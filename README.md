# unified-jboss-ocp
A demo project using multiple JBoss Middleware components inside OpenShift Container Platform. Kickstarted under the auspices of being a 'useful learning exercise'. Or something. Whatever.

Laughable HLD: https://www.lucidchart.com/invitations/accept/5284a69b-6231-43bf-ab02-bb3fba651e89

# Contents
* [Services](#services)
    * [Ingest](#ingest)
    * [ETL](#etl)
    * [RefDataLoader](#refdataloader)
    * [JDGStats](#jdgstats)
    * [Web](#web)   
    * [SSO](#sso)
    * [OpenShift](#openshift)
* [Usage](#usage)
    * [Maven](#maven)
    * [Template](#template)
    * [Points of Interest](#points-of-interest)
    * [Known Issues](#known-issues)

# Services

## Ingest

### Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss A-MQ

### Description
Ingest data from Network Rail's Darwin Push Port, documented here:

http://nrodwiki.rockshore.net/index.php/Darwin:Push_Port

This consumes data from a STOMP producer, and provides regular flow of XML-formatted data. The data is decompressed and added to JBoss A-MQ as an XML message body.

## ETL

### Components
* Red Hat JBoss A-MQ
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

### Description

Retrieves the messages containing XML body from A-MQ, transforms them into a protobuf-enabled common data format, and puts them into JDG. Used the Reference Data route to augment the Darwin Push Port Data


## RefDataLoader

### Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

### Description

Parses an XML file of reference data values from the [reference-data.xml](refdataloader/src/main/resources/ref/reference-data.xml file, and puts the data into JDG. Objects are transformed into a protobuf-enabled common data format.

## JDGStats

### Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

### Description

Periodically search the JDG instance using Infinispan Query DSL to search for location data embedded in the message. By deafult, this is 'Birmingham New Street', but can be any TIPLOC or location identifier identified in the ref data in [reference-data.xml](refdataloader/src/main/resources/ref/reference-data.xml). To change this, add an environment variable of *ISSUE_LOCATION* to the deployment config using one of the values in the aforementioned reference data file.

## Web

[TBD] Shiny-yet-ultimately-pointless web front end over JDG data

## SSO

[TBD] Can this play a part somehow?

## Rules

[TBD] Maybe we can do some CEP-type stuff over the incoming data flows

## OpenShift

### Components

* Kubernetes
* Some YAML

### Description

Template for creating the entire project in a single namespace. Used by running:
`oc create -f https://raw.githubusercontent.com/benemon/unified-jboss-ocp/master/openshift/unified-jboss-ocp.yaml`

This will create:
* BuildConfigs
* DeploymentConfigs
* ImageStreams
* Services

For further information see [Usage](#usage).

# Usage

## Maven

This project is heavily dependent on Maven, and assumes you have a Nexus repository sitting in a project named 'cicd'. If you do not happen to have that configured, either:

* Create a 'cicd' project, and follow the instructions at [my Docker Nexus repository](https://github.com/benemon/docker-nexus#red-hat-nexus-repositories) to get yourself a Red Hat-flavoured Nexus image, with preconfigured repositories.

* Alternatively, fork this project, comment out the configured nexus repositories, and uncomment the standard Red Hat repositories in the [settings.xml](configuration/settings.xml) file supplied.

## Template
To use this project, run through the following steps.

Create a new project for this template. Can be called anything, so I'm sticking with 'JBoss'. Because reasons.

`$ oc new-project jboss`

Make sure you're working in your new project:

`$ oc project jboss`

Assign the right roles to the default user. This enables clustering of AMQ and JDG within the project:
`$ oc policy add-role-to-user view system:serviceaccount:$(oc project -q):default -n $(oc project -q)`

Create the template:

`$ oc create -f https://raw.githubusercontent.com/benemon/unified-jboss-ocp/master/openshift/unified-jboss-ocp.yaml`

Instantiate the template:

`$ oc new-app --template=unified-jboss-ocp`

This will kick off deployments of:
* A-MQ
    - ingestdata queue
* JDG
    - darwindata cache
    - ref cache

It will kick off builds of:
* Ingest
* Ref
* ETL
* Stats

By default, all of the service deployments are created with 0 replicas. This is done to make sure that the supporting components (A-MQ and JDG) are up and running before we start deployment.

First, scale up the 'ref' deployment

`$ oc scale dc ref --replicas=1`

Wait for the pod to scale up. Check the logs and wait for the message:

`"INFO refDataRoute - Reference Data refresh completed from reference_data.xml"`

Your JDG instance has been pre-warmed with reference data. Hooray - nothing went bang.

At this point, you can just run the following command to scale up the rest of the services:

`$ oc scale dc ingest etl stats --replicas=1` 

Have a look at the logs for the 'stats' service to check the output. Given that there is usually something wrong at Birmingham New Street, you should see some alerts flagged for trains with stopping points there!

## Points of Interest:

This is a Maven multi-module project. Due to the way that multi-module projects are handled by (some of) OpenShift's builder images, S2I scripts in the individual modules are not respected. To get around this, I have added S2I scripts at the root level of the project which will inspect the module supplied in the build-time environment variable *MODULE_DIR* and see if it contains S2I scripts for [assemble](.s2i/bin/assemble) and [run](.s2i/bin/run). If they exist, they will be used. If they don't, or the environment variable doesn't exist, the defaults will be used.

## Known Issues:
* Build fails with message "error: build error: Failed to push image: unauthorized: authentication required"

This seems to occur on the CDK when the registry is under load. Simply repeat the build (staggering each component as necessary) and the build should complete successfully.

* Errors from Camel routes after restarting JDG instance

These tend to occur because the protobufs schema is no longer cached in the JDG instance. To resolve, restart the 'ref' deployment. This will force re-registration of protobufs schema and reload the reference data.

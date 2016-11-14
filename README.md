# unified-jboss-ocp
An demo project using multiple JBoss Middleware components inside OpenShift Container Platform. Kickstarted under the auspices of being a 'useful learning exercise'. Or something. Whatever.


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

This provides regular flow of xml formatted data. The data is decompressed and added to JBoss A-MQ as an XML message body.

## ETL

### Components
* Red Hat JBoss A-MQ
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

### Description

Retrieves the Objects from the Ingest component, transforms them into a common data format, and puts it into JDG. Used the Reference Data route for augmenting the Darwin Data


## RefDataLoader

### Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

## Description

Parse an XML file of reference data values from source repository and puts it into JDG. Objects are transformed into a protobus-enabled common data format.

## JDGStats

### Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

## Description
Poll the JDG service and search for data with a location matching the content of environment variable 'ISSUE_LOCATION'.

## Web

[TBD] Shiny-yet-ultimately-pointless web front end over JDG data

## SSO

[TBD] Can this play a part somehow?

## Rules

[TBD] Maybe we can do some CEP-type stuff over the incoming data flows

## OpenShift

Templates for creating the entire project in a single namespace. Used by running:
`oc create -f https://raw.githubusercontent.com/benemon/unified-jboss-ocp/master/openshift/unified-jboss-ocp.yaml`

For further information see the section on Useage.

# Usage

## Template
To use this project, run through the following steps.

`$ oc new-project jboss`
`$ oc project jboss`

Assign the right roles to the default user. This enables clustering of AMQ and JDG within the project:
`$ oc policy add-role-to-user view system:serviceaccount:$(oc project -q):default -n $(oc project -q)`


Create the template:

`$ oc create -f https://raw.githubusercontent.com/benemon/unified-jboss-ocp/master/openshift/unified-jboss-ocp.yaml`


This will kick off deployments of:
* A-MQ
    - ingestdata queue
* JDG
    - darwindata cache
    - ref cache

It will kick off builds of:
* Ingest - Consume data from National Rail STOMP producer

* Ref - Load the JDG instance with reference data

* ETL - Transform incoming messages from 'ingest' route into a protobuf-enabled common data format, and put into JDG. Augment incoming data with reference data.

* Stats - Periodically search the JDG instance using Infinispan Query DSL to search for location data embedded in the message. By deafult, this is 'Birmingham New Street', but can be any TIPLOC or location identifier identified in the ref data in *refdataloader/src/main/resources/ref/reference-data.xml*. To change this, add an environment variable of ISSUE_LOCATION to the deployment config using one of the values in the aforementioned reference data file.

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

This is a multi-module project. Due to the way that multi-module projects are handled by OpenShift's builder images, S2I scripts in the individual modules are not respected. To get around this, I have added S2I scripts at the root level of the project which will inspect the module supplied in the build-time environment variable 'MODULE_DIR' and see if it contains S2I scripts for 'assemble' and 'run'. If they exist, they will be used. If they don't, or the environment variable doesn't exist, the defaults will be used.


## Known Issues:
* Build fails with message "error: build error: Failed to push image: unauthorized: authentication required"

This seems to occur on the CDK when the registry is under load. Simply repeat the build (staggering each component as necessary) and the build should complete successfully.

* Errors from Camel routes after restarting JDG instance

These tend to occue because the protobufs schema is no longer cached in the JDG instance. To resolve, restart the 'ref' deployment. This will force re-registration of protobufs schema and reload the reference data.

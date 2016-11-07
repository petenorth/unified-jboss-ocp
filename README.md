# unified-jboss-ocp
An demo project using multiple JBoss Middleware components inside OpenShift Container Platform. Kickstarted under the auspices of being a 'useful learning exercise'. Or something. Whatever.


Laughable HLD: https://www.lucidchart.com/invitations/accept/5284a69b-6231-43bf-ab02-bb3fba651e89


# ingest

## Components
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss A-MQ

## Description
Ingest data from Network Rail's Darwin Push Port, documented here:

http://nrodwiki.rockshore.net/index.php/Darwin:Push_Port

This provides regular flow of xml formatted data. The data uncompressed and added to JBoss A-MQ

# etl

## Components
* Red Hat JBoss A-MQ
* Red Hat JBoss Fuse Integration Services
* Red Hat JBoss Data Grid

## Description

Gratuitous transformation of data from ingestion format into something KV-friendly, for insertion into JDG. Made up of two components:

### Reference Data ETL

Retrieve an XML file of reference data values from source repository and puts it into JDG

### Darwin Data ETL

Retrieves the Objects from the Ingest component, transforms them into a common data format, and puts it into JDG. Used the Reference Data route for augmenting the Darwin Data

# web

[TBD] Shiny-yet-ultimately-pointless web front end over JDG data

# sso

[TBD] Can this play a part somehow?

# rules

[TBD] Maybe we can do some CEP-type stuff over the incoming data flows

# openshift

[TBD] Templates for creating the entire project in a single namespace.

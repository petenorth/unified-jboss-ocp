# unified-jboss-ocp
An demo project using multiple JBoss Middleware components inside OpenShift Container Platform

# ingest

## Components
 Red Hat JBoss Fuse Integration Services
 Red Hat JBoss A-MQ

## Description
Ingest data from Network Rail's Darwin Push Port, documented here:

http://nrodwiki.rockshore.net/index.php/Darwin:Push_Port

This provides regular flow of xml formatted data. The data uncompressed and added to JBoss A-MQ

# etl

Gratuitous transformation of data from ingestion format into something KV-friendly, for insertion into JDG

# web

Shiny-yet-ultimately-pointless web front end over JDG data

# sso

Can this play a part somehow?

# rules

Maybe we can do some CEP-type stuff over the incoming data flows

# openshift

Templates for creating the entire project in a single namespace.

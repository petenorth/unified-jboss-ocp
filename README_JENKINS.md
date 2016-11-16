Create a new project

    oc new-project jboss

Create the template in the jboss namespace

    oc create -f https://raw.githubusercontent.com/petenorth/unified-jboss-ocp/master/openshift/unified-jboss-ocp.yaml -n jboss

Create the app

    oc new-app --template=unified-jboss-ocp --param=GIT_REPO=https://github.com/petenorth/unified-jboss-ocp.git --param=GIT_REF=master

Check that only two application pods have been create and are in a ready state (after the deployment pods have been deleted) namely, broker-amq-<build>-<pod id> and datagrid-app-<build>-<pod id>

If the previous commands have been run as 'system:admin' then you will probably want to add the admin role for  UI user (in this case admin) to the project 

    oc policy add-role-to-user admin admin -n jboss

Create the CI/CD project

    oc new-project cicd

Create the Jenkins pipline builds in the cicd project

    oc create -f https://raw.githubusercontent.com/petenorth/unified-jboss-ocp/master/etl/pipeline/pipeline.yml -n cicd
    oc create -f https://raw.githubusercontent.com/petenorth/unified-jboss-ocp/master/ingest/pipeline/pipeline.yml -n cicd
    oc create -f https://raw.githubusercontent.com/petenorth/unified-jboss-ocp/master/refdataloader/pipeline/pipeline.yml -n cicd
    oc create -f https://raw.githubusercontent.com/petenorth/unified-jboss-ocp/master/jdgstats/pipeline/pipeline.yml -n cicd

The jenkins service account in the cicd project must have edit role on the jboss project

    oc policy add-role-to-user edit system:serviceaccount:cicd:jenkins -n jboss

Make sure the Jenkins pod has been create and is ready in the cicd project.

Start the pipelines

    oc start-build etlpipeline
    oc start-build ingestpipeline
    oc start-build refpipeline
    oc start-build statspipeline




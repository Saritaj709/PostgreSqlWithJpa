Deploy postgres project to cf
------------------------------
->cf api
->cf login
->cf marketplace
->cf marketplace -s postgresql
->cf create-service postgresql v9.4-dev postgre-service 
->mvn package
->cf push


For SSL
-----------------
1.Create Self Signed SSL Certificate

2.Keep the certificate in resources of main application

3.configure certificate details in application.properties or application.yml

4.give a configuration to redirect requests to HTTPS in your configuration 

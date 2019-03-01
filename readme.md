Deploy postgres project to cf
------------------------------
->cf api
->cf login
->cf marketplace
->cf marketplace -s postgresql
->cf create-service postgresql v9.4-dev postgre-service 
->mvn package
->cf push
# NCSU_CSC440_S15_Proj1
NCSU CSC440 Sprint 201515 Database Project 1

#To run the project using the precompiled jar:
	* Change directories to the directory containing the auth.conf, main.jar, rebuild.jar, and sql directory
	* run `java -jar rebuild.jar` to rebuild the database with the standard sample database
	* run `java -jar main.jar 2>stderr.log` to run the application.
	
#To run the project in eclipse (luna):
	* Import the projectSrc.zip file as a project into eclipse.
	* Ensure that the build path points to a valid JDK for your system
	* Right click on the src -> (default package) -> RebuildDatabase.java and select run as java application to rebuild the database
	* Right click on the src -> (default package) -> main.java and select run as java application to start the program
	* The 2 run configurations for the project should now be in the Run drop down menu at the top of the screen for future use
	
#Configuring the MySQL server to connect to:
	*In the change the lines to reference your current installation and configurations
	*Note: the database and user must already have been created and the user should have full control of the database

#File layouts:
	* Java source files created as part of this project are stored in the /src directory
	* The MySQL JDBC4 connector Jar is stored in the /lib directory
	* The SQL commands executed by RebuildDatabase are stored in the /sql directory
	* Upon run of RebuildDatabase the files are executed in the order of dropTables.sql, createTables.sql, then initData.sql
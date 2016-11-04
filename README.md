# ITM14_Lotto
ITM14 Lotto P.SWEngi


## Requirements
- Wildfly v. 10.1.0
- Maven v. 3.3.9
- MariaDB v. 10.1.14
- JDK v. 1.8.0
- Eclipse

## Setup

#### Wildfly
- Download and unzip Wildfly [http://wildfly.org/downloads/](http://wildfly.org/downloads/)
- Make sure port 8080 and 9990 are free (e.g. Nvidia Service uses port 9990 too)
- Execute wildfly-x.y.z.Final/bin/standalone.bat
- Test if server is running by opening localhost:8080 in browser
- Add user by executing wildfly-x.y.z.Final/bin/add-user.bat

#### Maven
- Download and install Maven [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- Configure system environment variables
	- set JAVA_HOME to location of your jdk 
	- set M2_HOME to location of your maven installation
	- add bin folders of jdk and maven to PATH 
- Test installation by 
	- mvn --version

#### MariaDB
- Download and install MariaDB
- Connect to MariaDB
- Create database and tables using the script create-tables.db: 
	- \\. _path-to-script_

#### And finally ... the Lotto Project itself
- Download project from github
- Import project into Eclipse
- Configure database connection in src/db.properties 
- Right click on the project / Run As / Run on Server
- If you already have an existing server, use that one, otherwise select "Manually define a new server" and select the appropriate wildfly version and the path to your wildlfy installation in the wizard
- Test by entering http://localhost:8080/ITM_Lotto-0.0.1-SNAPSHOT or http://localhost:8080/ITM_Lotto-0.0.1-SNAPSHOT/test.html  in your browser
- Test DB-Connection by entering http://localhost:8080/ITM_Lotto-0.0.1-SNAPSHOT/api/draws/id/1 in your browser. 
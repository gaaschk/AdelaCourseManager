### Pre-requisites:
* You’ll need gradle installed.
* You’ll need jdk 1.8 by default.  You can change this in the gradle.properties.  1.7 will work also.

### Instructions:
1. Extract the tar
2. Rename the template-service project folder to your desired project name (e.g. awesome-service)
3. Edit gradle.properties:
4. Set the war.basename to your desired maven artifactId (awesome-service)
5. Set the war.group to your desired maven groupId (com.cigna.clinical.awesome)
6. Edit src/main/resources/boostrap.yml:
7. On line 9 set your default application name.  This is the name that it will use to identify itself to cloud services (eureka, config, admin, etc..) [awesome-service]

That’s the bare minimum to get the application up and running. At this point you can build it:
gradle clean build publish  <- you don’t have to publish. Right now publish just creates the tar that udeploy would use to deploy to the server.  The tar is what would actually get pushed to nexus
And run it:
```bash
java –jar build/libs/<what you set war.group to>-2015.99.0.0-SNAPSHOT.war
```

I have created some nifty scripts that you can run from your mac to do things like deploy the app to a server, configure that server (set the java_home, set the cloud settings, etc…).  If you want to use those scripts, you will want to change:
deploy
Line 31 – change the filename
run
Line 4 – Project name. This is just an echo. Not important.
Line 6 - filename again
You can import the project into eclipse now and change the sample rest endpoint java class and package.

If you need additional libraries, add them to applicationDependencies.gradle.  No need to mess with the actual build.gradle script.  I’ve abstracted all of that out so that nobody should have to mess with it.

To run the app “cloud enabled” there are three properties that need to be set.  These can either be set on environment, at runtime with –D… flags, or in an external bootstrap.yml file.  Since these three properties are identical regardless of the application I have them set as environment variables.  They are in the cloud-env.sh script.  If you put this script in /etc/profile.d/ on the server these properties will be set on the environment automatically.
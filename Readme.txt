1. Open the HSQLDB server

   Open the folder of hsqldb/lib
   
   In command line, run "java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb"

2. Gradle build and run the project

   In command line, go to {project} folder, use "gradle createJar". Because I create one task called createJar in build.gradle

   Copy test.json from {project} folder to {project}/build/lib

   Then open {project}/build/libs, run "java -jar JsonLog-all.jar test.json"

3. Gradle test

   In command line, run "gradle test" under {project} folder
   
   All of the junit tests in this project have passed.
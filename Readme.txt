In command line, go to {project} folder, use "gradle build"

Copy test.json from {project} folder to {project}/build/lib

Then open {project}/build/libs, run "java -jar HSQLDBTest-all test.json"


Open the folder of hsqldb/lib
run "java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb"

Above line will open a hsqldb server.

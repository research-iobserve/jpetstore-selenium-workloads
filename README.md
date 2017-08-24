# jpetstore-selenium-workloads
Workloads for our jpetstore variants based on selenium

To build the application run
`mvn compile package`

This will produce a jar file in `target` called `org.iobserve.workloadgeneration-0.0.1-SNAPSHOT.jar`.
You can execute this with:
```
java -jar target/org.iobserve.workloadgeneration-0.0.1-SNAPSHOT.jar \
	-u JPETSTORE_URL -i ITERATIONS -s SCREENSHOTS -p PHANTOM_JS
```

You have to replace the capitalized placeholder with appropriate values.



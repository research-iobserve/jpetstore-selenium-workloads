#!/bin/bash

BINDIR=$(cd "$(dirname "$0")"; pwd)/
CALL="target/org.iobserve.workloadgeneration-0.0.1-SNAPSHOT-jar-with-dependencies.jar"

java -jar "$BINDIR/$CALL" -u http://172.17.0.2:8080/jpetstore -i 20 -s /home/reiner/temp/ -p /home/reiner/node_modules/phantomjs/lib/phantom/bin/phantomjs

# end

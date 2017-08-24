#!/bin/bash

BINDIR=$(cd "$(dirname "$0")"; pwd)/
CALL="target/org.iobserve.workloadgeneration-0.0.1-SNAPSHOT-jar-with-dependencies.jar"

java -jar "$BINDIR/$CALL" $@

# end

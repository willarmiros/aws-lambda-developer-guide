#!/bin/bash
set -eo pipefail
gradle build
aws lambda update-function-code --function-name blank-java --zip-file fileb://build/distributions/function-java.zip

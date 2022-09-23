#!/bin/sh

awslocal sqs create-queue --queue-name sample-queue

echo "Initialized."
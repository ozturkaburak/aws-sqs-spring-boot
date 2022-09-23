# AWS SQS Producer & Consumer Application

### Run Steps
1. Run ``` docker compose up -d```
2. Run ```awslocal sqs create-queue --queue-name sample-queue``` command inside the docker localstack_main instance
3. Run ```mvn install```
4. Run ``` java -jar target/sqs-0.0.1-SNAPSHOT.jar```

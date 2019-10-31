docker run --name rabbitmq-quarkus --rm \
  -e RABBITMQ_DEFAULT_USER=quarkus -e RABBITMQ_DEFAULT_PASS=quarkus \
  -p 5672:5672 -p 15672:15672 \
  -d rabbitmq:3-management
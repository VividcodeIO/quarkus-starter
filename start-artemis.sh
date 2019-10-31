docker run --name artemis-quarkus --rm \
  -e ARTEMIS_USERNAME=quarkus -e ARTEMIS_PASSWORD=quarkus \
  -p 5672:5672 \
  -p 8161:8161 \
  -d vromero/activemq-artemis:2.10.1-alpine
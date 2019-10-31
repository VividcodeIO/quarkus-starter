docker run --name mysql-quarkus --rm \
  -e MYSQL_ROOT_PASSWORD=myrootpassword \
  -e MYSQL_USER=quarkus -e MYSQL_PASSWORD=quarkus \
  -e MYSQL_DATABASE=quarkus_starter \
  -p 3306:3306 \
  -d mysql:8
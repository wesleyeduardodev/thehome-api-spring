

- Gerar imagem da aplicação: docker build -t thehome-api .
- Subir container: docker run -p 8080:8080 --name thehome-api thehome-api

- Executar jar: java -jar target/thehome-api-spring-0.0.1-SNAPSHOT.jar
- Conectar máquina EC2: ssh ec2-user@"ip_aqui"
- Copiar jara para EC2: scp ./target/thehome-api-spring-0.0.1-SNAPSHOT.jar ec2-user@"ip_aqui":/home/ec2-user
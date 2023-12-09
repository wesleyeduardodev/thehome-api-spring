
- Rodar Docker compose ambiente dev: docker compose up -d
- Rodar Docker compose ambiente test: docker compose -f docker-compose-test.yml up -d
- Rodar Docker compose ambiente prod: docker compose -f docker-compose-prod.yml up -d

- Gerar build da aplicação antes de gerar a imagem: mvn clean install
- Gerar imagem da aplicação: docker build -t wesleyeduardodev/thehome-api .
- Subir container: docker run -p 8080:8080 --name thehome-api thehome-api

- Executar jar: java -jar target/thehome-api-spring-0.0.1-SNAPSHOT.jar
- Conectar máquina EC2: ssh ec2-user@"ip_aqui"
- Copiar jara para EC2: scp ./target/thehome-api-spring-0.0.1-SNAPSHOT.jar ec2-user@"ip_aqui":/home/ec2-user

## Comandos Docker úteis
- Login Docker: docker login
- Enviar imagem para o DockerHub: docker push wesleyeduardodev/thehome-api
- Remover todos os containers: docker rm $(docker ps -a -q) -f
- Remover todos as imagens: docker rmi $(docker images -q) -f
- Remover todos os volumes: docker volume rm $(docker volume ls -qf dangling=true) 
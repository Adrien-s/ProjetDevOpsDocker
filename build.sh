mvn clean install
sudo docker build -t devops
sudo docker run -d -p 88:8080 devops
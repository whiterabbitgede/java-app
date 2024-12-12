
-----------------------------------
-install mvn
-----------------------------------

tar -xvzf apache-maven-3.9.8-bin.tar.gz

cp -r apache-maven-3.9.8 /usr/local/apache-maven/

- maven path
/usr/local/apache-maven/


Open command terminal and set environment variables.

export M2_HOME=/usr/local/apache-maven/apache-maven-3.9.8 
export M2=$M2_HOME/bin
export MAVEN_OPTS=-Xms256m -Xmx512m
export PATH=$M2:$PATH




cd  /var/www/java/restapi/test-helloworld

test-helloworld/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│       ├── java/
│       └── resources/
│
├── pom.xml



mvn install 

mvn compile
mvn package



- on docker
docker compose up -d --build

docker compose up --build




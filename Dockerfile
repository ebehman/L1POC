FROM maven:3.5-jdk-8

# Set project directory
ENV PROJ /src

# Copy project to container
COPY . $PROJ
WORKDIR $PROJ

# Maven build
RUN mvn install -DskipTests

FROM openjdk:8u332-oraclelinux7

ENV POC_BIN="/opt/bin/poc" \
    POC_LOG="/var/log/poc"

RUN mkdir -p $POC_BIN
WORKDIR $POC_BIN

COPY --from=0 /src/target/poc-1.0-SNAPSHOT.jar $POC_BIN

RUN mkdir -p $POC_LOG
RUN chmod 777 $POC_LOG
RUN chmod -R 777 $POC_BIN

CMD ["java","-jar","/opt/bin/poc/poc-1.0-SNAPSHOT.jar"]
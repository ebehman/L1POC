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
    POC_LOG="/var/log/poc" \
    APP="L1POC" \
    VERSION="0.1" \
    JAR="$POC_BIN/$APP-$POC-SNAPSHOT.jar"


RUN mkdir -p $POC_BIN
WORKDIR $POC_BIN

# COPY --from=0 /target/poc-1.0-SNAPSHOT.jar $POC_BIN
#
# RUN mkdir -p /var/log/poc
# RUN chmod 777 /var/log/poc
#
# RUN groupadd --gid 303 poc \
#   && useradd --uid 303 --gid poc --shell /bin/bash --create-home poc -G sudo
#
# RUN chown -R poc:poc /var/log
# CMD ["/opt/bin/poc/L1POC-0.1-SNAPSHOT.jar"]
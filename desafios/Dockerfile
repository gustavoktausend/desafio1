FROM openjdk:11.0.3-jre-slim

ENTRYPOINT ["java", "-jar", "/usr/share/api/desafios.jar", "-Djava.net.preferIPv4Stack=true"]

# setting timezone
RUN apt-get update
RUN echo "America/Sao_Paulo" > '/etc/timezone'
RUN dpkg-reconfigure --frontend noninteractive tzdata

ADD target/desafios-*.jar /usr/share/api/desafios.jar

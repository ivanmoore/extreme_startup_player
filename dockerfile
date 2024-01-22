FROM openjdk:21-jdk-slim
RUN mkdir /code
COPY . /code/
WORKDIR /code
RUN ./gradlew clean build fatJar
EXPOSE 8123
CMD java -jar build/libs/extreme_startup_player-fat-jar-1.0.0.jar

FROM gradle:8.5-jdk17-jammy
RUN mkdir /code
COPY . /code/
WORKDIR /code
RUN gradle clean build fatJar
EXPOSE 8123
CMD java -jar build/libs/extreme_startup_player-fat-jar-1.0.0.jar

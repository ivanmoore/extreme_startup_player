FROM amazoncorretto:21
COPY build/libs/extreme_startup_player-fat-jar-1.0.0.jar extreme_startup_player-fat-jar-1.0.0.jar
EXPOSE 8123
CMD java -jar extreme_startup_player-fat-jar-1.0.0.jar

Running a service (close port 8080 and then run):
Gradle - lsof -n -i4TCP:8080 | awk '{print$2}' | tail -1 | xargs kill -9 && ./gradlew bootRun

./mvnw install
Maven - lsof -n -i4TCP:8080 | awk '{print$2}' | tail -1 | xargs kill -9 && ./mvnw spring-boot:run

Go to:
http://localhost:8080/hello

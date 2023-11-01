FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/Timesheet-devops.war Timesheet-devops.war
ENTRYPOINT ["java","-jar","/Timesheet-devops.war"]
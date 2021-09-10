FROM maven:3.6.3-jdk-11-slim

# Run commands through bash so source is found
SHELL ["/bin/bash", "-c"]

# Inform db
COPY Inform-DB/inform-checker.xml /app/Inform-DB/
COPY Inform-DB/pom.xml /app/Inform-DB/
COPY Inform-DB/inform-annotations /app/Inform-DB/inform-annotations
COPY Inform-DB/inform-db /app/Inform-DB/inform-db
WORKDIR /app/Inform-DB
RUN mvn install
# test
WORKDIR /app/github_actions_test
COPY github_actions_test/inform-checker.xml /app/github_actions_test/
COPY github_actions_test/pom.xml /app/github_actions_test/
# resolve dependencies before copying sourcecode
RUN mvn dependency:resolve
RUN mvn generate-resources -Dcheckstyle.skip
COPY github_actions_test/src /app/github_actions_test/src
# install test
WORKDIR /app/github_actions_test
RUN mvn install -Dcheckstyle.skip -Dmaven.test.skip=true -Dstart-class=test.App
CMD ["java", "-jar", "./target/test.jar"]


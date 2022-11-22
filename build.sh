#!bin/bash

# Set me! Local maven repository path
export REPO_DIR="/mnt/c/Users/Дмитрий Мамедов/Desktop/shcool21/microservices/libs"

# Build shared-library package and install into local maven repository
mvn -f shared-library/pom.xml clean package
mvn install:install-file \
    -Dfile="shared-library/target/shared-library-0.0.1-SNAPSHOT.jar" \
    -DgroupId="edu.school21" \
    -DartifactId="shared-library" \
    -Dversion="0.0.1-SNAPSHOT" \
    -Dpackaging="jar" \
    -DlocalRepositoryPath="${REPO_DIR}"

# Build countries-integration package and install into local maven repository
mvn -f countries-integration/pom.xml clean package
mvn install:install-file \
    -Dfile="countries-integration/target/countries-integration-0.0.1-SNAPSHOT.jar" \
    -DgroupId="edu.school21" \
    -DartifactId="countries-integration" \
    -Dversion="0.0.1-SNAPSHOT" \
    -Dpackaging="jar" \
    -DlocalRepositoryPath="${REPO_DIR}"

# Build covid-integration package and install into local maven repository
mvn -f covid-integration/pom.xml clean package
mvn install:install-file \
    -Dfile="covid-integration/target/covid-integration-0.0.1-SNAPSHOT.jar" \
    -DgroupId="edu.school21" \
    -DartifactId="covid-integration" \
    -Dversion="0.0.1-SNAPSHOT" \
    -Dpackaging="jar" \
    -DlocalRepositoryPath="${REPO_DIR}"

# Build other packages
mvn -f covid-service/pom.xml clean package
mvn -f countries-service/pom.xml clean package
mvn -f aggregator-service/pom.xml clean package
mvn -f gateway-service/pom.xml clean package
mvn -f discovery-server/pom.xml clean package

# Run docker container builder
docker compose up

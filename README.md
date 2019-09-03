# Pipeline Lab
<a href="https://snyk.io//test/github/connexta/pipeline-lab?targetFile=pom.xml"><img src="https://snyk.io//test/github/connexta/pipeline-lab/badge.svg?targetFile=pom.xml" alt="Known Vulnerabilities" data-canonical-src="https://snyk.io//test/github/connexta/pipeline-lab?targetFile=pom.xml" style="max-width:100%;"></a>
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=pipeline-lab&metric=alert_status)](https://sonarcloud.io/dashboard?id=pipeline-lab)

The master branch in pipeline labs is for active CICD development and overall stabalizing of standards and technologies.

The expectation is that there will be "feature*" branches tracking "released" increments of work.
- feature_basic_java_pipeline contains a basic java project with build, unit test and dependency test configured
- feature_code-compileandscan contains a basic java project with the same as feature_basic_java_pipeline and the addition of SonarCloud integration


The expectation is that there will be "topic*" branches tracking "development" increments that are unstable and under active work.
- topic_docker (j-fontaine)
-- Adding basic Sprint Boot application
-- Adding docker file for Docker Image creation
-- Adding image scanning via Snyk (Anchore to be tried)

# Pipeline Lab
<a href="https://snyk.io//test/github/connexta/pipeline-lab?targetFile=pom.xml"><img src="https://snyk.io//test/github/connexta/pipeline-lab/badge.svg?targetFile=pom.xml" alt="Known Vulnerabilities" data-canonical-src="https://snyk.io//test/github/connexta/pipeline-lab?targetFile=pom.xml" style="max-width:100%;"></a>
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=pipeline-lab&metric=alert_status)](https://sonarcloud.io/dashboard?id=pipeline-lab)


This branch will do fundamental build aspects for a code based pipeline (.jar etc.).
1) Maven Compile
2) Maven unit tests
3) Snyk Dependency Scanning
4) SonarCloud code quality analysis

It will not
- Execute OWASP dependency scanning (replaced by snyk)
- Execute Docker Image creation
- Execute Docker Image scanning
- Deployment of artifacts to a centralized repository
- Deployment of Docker Images to a registry
- Testing steps are all "stubs"

pipeline {
    agent any
    		   environment { 
         
        registry = "manelredissi/devopsproject" 
        registryCredential = 'dockerHub' 
	NEXUS_VERSION="nexus3"
	NEXUS_PROTOCOL="http"
	NEXUS_URL="192.168.2.0:8081"
	NEXUS_REPOSITORY="nexus-repo-devops"
	NEXUS_CREDENTIAL_ID="nexus-user-credentials"
	dockerImage = '' 
    }		
    		
    		

    stages {
        stage('Checkout GIT') {
            steps {

                echo 'Pulling...';
                git branch: 'Manel-Redissi',
                url : 'https://github.com/1906miral/ProjetDevOps';
            }
        }
	    
        stage('MVN CLEAN'){
            steps {
                sh 'mvn clean'
            }
        }

        stage('MVN COMPILE') {
            steps{
                sh 'mvn compile'
            }
        }
	    
	stage('MVN BUILD') {
            steps{
                sh 'mvn install -DskipTests=true'
            }
        }
        
        stage('MVN JUNIT') {
                steps{
                    sh 'mvn test -e '
                }
            }
             stage('MVN SONARQUBE') {
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
            
            stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }	
         
         stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":latest" 
                }
            } 
        }

        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 

        stage('Cleaning up') { 
            steps { 
                sh "docker rmi $registry:latest" 
            }
        }
            

        stage('show Date') {
            steps {
                echo 'Showing Date...';
                sh """ date """;
            }
        }

    }
 	post {
            always{
                
                emailext to: "manel.redissi@esprit.tn",
                subject: "[DevOps Spring]jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
		attachLog: true
                
            }
        }	


}

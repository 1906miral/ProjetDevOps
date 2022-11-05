pipeline {
    agent any
    		

    stages {
        stage('Checkout GIT') {
            steps {

                echo 'Pulling...';
                git branch: 'miral',
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

        stage('show Date') {
            steps {
                echo 'Showing Date...';
                sh """ date """;
            }
        }

    }
 	


}

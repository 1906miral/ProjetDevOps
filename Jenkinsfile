pipeline {
    agent any
    environment { 
       
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

        stage('show Date') {
            steps {
                echo 'Showing Date...';
                sh """ date """;
            }
        }

    }
    post {
            
        }	


}

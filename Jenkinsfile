pipeline {
    agent any


    stages {
       
        
        stage('MVN CLEAN') {
            steps {
               
              script {

                  sh 'mvn  clean'

 
                      }
                   }        
         }
          stage('MVN compile') {
            steps {
               
              script {

                  sh 'mvn  compile'

 
                      }
                   }        
         }
          stage('MVN test') {
            steps {
               
              script {

                  sh 'mvn  test'

 
                      }
                   }        
         }
      /*
         stage('Email Notification'){
            steps{
                script{
                    mail bcc: '', body: '''Hi,
Welcome to jenkins email alerts.
Thanks,
 cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'haifa.brineg@esprit.tn'
                }
            }
        }*/
          stage('SONAR') {
            steps {
               
              script {

                  sh 'mvn  sonar:sonar  -Dsonar.sources=src/main/java -Dsonar.css.node=. -Dsonar.java.binaries=. -Dsonar.host.url=http://192.168.118.91:9000/ -Dsonar.login=admin   -Dsonar.password=sonar'

 
                      }
                   }   
                   
         }
         
          stage('Artifact Construction') {
                      steps{
                          sh "mvn -B -DskipTests  package "
                      }
                  }
         stage('nexus') {
            steps {
               
              script {

sh 'mvn  deploy -e'                      }
                   }         
         }
      /*
          stage('Build Docker Image'){
                      steps {
                          script{
          				    sh 'docker image build . -t haifa123456/backcicd  '
                          }
                      }
          		}
          		stage('Docker login') {
                                steps {
                                    script {

                                        sh 'docker login -u obettaieb -p Mypwdocker13'}
                                }
                                }
                          stage('Pushing Docker Image') {
                                steps {
                                    script {

                                     sh 'docker push haifa123456/backcicd'
                                    }
                                }
                          }
                          stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh ' docker-compose -f backend-spring/docker-compose.yml up -d '
                                    }
                                }
                            }*/
     }
     
     }

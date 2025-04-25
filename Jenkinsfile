pipeline {
    agent {
        label 'ssh-1' // Replace with your agent's label
    }
    tools {
        jdk 'jdk-24'
    }
    
    environment {
        MAVEN_HOME = '/opt/maven'  // Set this to your Maven installation path
        PATH = "$MAVEN_HOME/bin:$PATH"  // Add Maven to the PATH
    }
    
    stages{
        stage('checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/testing']], extensions: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/Keerthansimha/thymleafDemo.git']]])
            }
        }

        stage('Build Project') {
            steps {
                echo 'Building the project using Maven...'
                sh 'mvn clean package ' // Includes clean to ensure a fresh build
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }


        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t keerthan66/thymleafdemo:0.0.1-snapshot.'

                    // Push the Docker image
                    withCredentials([string(credentialsId: 'Docker-pass', variable: 'Docker')]) {
                        sh 'docker login -u keerthan66 -p ${Docker}'                  
                    }
                    sh 'docker push keerthan66/thymleafDemo-0.0.1-SNAPSHOT'
                }
            }
        }

        stage('Docker Deploy to Container') {
            steps {
                script {
                    echo 'Logging in to Docker Hub...'
                    withCredentials([string(credentialsId: 'Docker-pass', variable: 'DOCKER_PASS')]) {
                        sh 'echo ${DOCKER_PASS} | docker login -u keerthan66 --password-stdin'
                    }
                    
                    echo 'Running Docker container...'
                    sh 'docker run -d --name loki -p 8080:8080 keerthan66/thymleafDemo-0.0.1-SNAPSHOT'
                }
            }
        } 
    }
    
    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}

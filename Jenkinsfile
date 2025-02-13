pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // getting token from cred's
        GIT_REPO = 'https://github.com/sanidhyamalhotra/CYB535.git'
        BRANCH = 'classwork'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH}", url: "${GIT_REPO}"
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
            post {
                success {
                    echo 'Build successful'
                }
                failure {
                    echo 'Build failed'
                }
            }
        }

        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
            post {
                success {
                    echo 'All test cases passed'
                }
                failure {
                    echo 'Some test cases failed'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    bat 'mvn sonar:sonar -Dsonar.token=%SONAR_TOKEN%'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn clean verify'
            }
            post {
                always {
                    jacoco execPattern: '**/target/jacoco.exec'
                }
            }
        }

        stage('Archive Artifact') {  // Added: Storing generated JAR files
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
        
        stage('Notification') {
            steps {
                mail to: 'tigertharu21@gmail.com',
                     subject: "Build ${currentBuild.result}: Job ${env.JOB_NAME}",
                     body: "Build ${env.BUILD_NUMBER} completed.\nCheck details: ${env.BUILD_URL}"
            }
        }
    }
    
    post {
        always {
            cleanWs()  // Clean up workspace after build
        }
        success {
            echo "SonarQube analysis completed successfully."
        }
        failure {
            echo "SonarQube analysis failed."
        }
    }
}

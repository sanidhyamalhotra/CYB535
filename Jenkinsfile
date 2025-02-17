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

        stage('Test & Code Coverage') {  // Added: Running tests and generating code coverage report
            steps {
                bat 'mvn clean test verify jacoco:report'  
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' // Capture JUnit reports
                    jacoco execPattern: 'target/jacoco.exec'
                }
                success {
                    echo 'All test cases passed with coverage report generated'
                }
                failure {
                    echo 'Some test cases failed'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    bat 'mvn sonar:sonar -Dsonar.token=%SONAR_TOKEN% -Dsonar.coverage.jacoco.xmlReportPaths=target/jacoco-report/jacoco.xml'
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
                mail to: 'csecec.1702842@gmail.com',
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
            mail to: 'csecec.1702842@gmail.com',
            subject: "FAILURE: Job ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
            body: "Build ${env.BUILD_NUMBER} has failed.\nCheck details: ${env.BUILD_URL}"
        }
    }
}

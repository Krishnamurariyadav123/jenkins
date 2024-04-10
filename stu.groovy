pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/chetansomkuwar254/studentapp.ui.git'
                echo 'pull completed'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                echo 'build'
            }
        }
        stage('Test') {
            steps {
                sh '''mvn sonar:sonar \\
                    -Dsonar.projectKey=studentapp-ui \\
                    -Dsonar.host.url=http://13.232.246.90:9000 \\
                    -Dsonar.login=423db6f4779159f42efebdb2b699bbe433f50831'''
                    echo 'test completed sucessfully'
            }
        }
        stage('quality check') {
            steps {
                echo 'quality check completed'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy completed'
            }
        }
    }
}

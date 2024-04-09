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
                echo 'build'
            }
        }
    }
}

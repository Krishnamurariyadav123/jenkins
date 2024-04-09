pipeline {
    agent any

    stages {
        stage('pull') {
            steps {
                echo 'Pull sucessfully '
            }
        }
        stage {
            steps ('build') {
                echo " Build sucessfully"
                }
        }
        stage {
            steps ('test') {
                echo " test completed"
            }
        }
        stage {
            step ('deploy') {
                echo "deploy completed"
            }
        }
    }
}

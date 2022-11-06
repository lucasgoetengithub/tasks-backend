pipeline {
    agent any
    stages {
        stage('Build backend') {
            steps {
                bat 'mvn clean package -DskipTest=true'
            }
        }
        stage('Unit Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t b2b-gateway .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8080:8080 b2b-gateway'
            }
        }
    }
}
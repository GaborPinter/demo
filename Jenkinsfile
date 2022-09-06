pipeline{
    agent any
    tools{
        maven 'maven_3_8_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/GaborPinter/demo']]])
                bat 'gradlew clean build'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t gaborpinter/demo .'
                }
            }
        }
    }
}
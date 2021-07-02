pipeline {
    agent any

    stages {
        stage('compile stage') {
            steps {
                withGradle(gradle : 'gradle_6_8') {
                    sh 'gradle clean build'
                }
            }
        }

        stage('testing stage') {
            steps {
                withGradle(gradle : 'gradle_6_8') {
                    sh 'gradle test'
                }
            }
        }

        stage('testing stage') {
            steps {
                withGradle(gradle : 'gradle_6_8') {
                    sh 'gradle test'
                }
            }
        }
    }

}
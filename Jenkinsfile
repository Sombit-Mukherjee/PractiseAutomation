pipeline{
    agent any

    tools{
        jdk 'JDK21'
        maven 'Maven_3'
    }

    stages{

        stage('Checkout code'){
            steps{
                git branch: 'main',
                url: 'https://github.com/Sombit-Mukherjee/PractiseAutomation.git'
            }
        }

        stage('Build and Test'){
            steps{
                bat 'mvn clean test'
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML(target: [
                    reportDir   : 'target',
                    reportFiles  : 'cucumber-reports.html',
                    reportName   : 'Cucumber Report',
                    keepAll      : true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {

        success {
            echo 'Build Successful! All tests passed.'
        }

        failure {
            echo 'Build Failed! Some tests have failed.'
        }

        always {
            echo 'Pipeline finished. Cleaning workspace.'
            cleanWs()
        }

    }


}
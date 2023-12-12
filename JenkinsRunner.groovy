pipeline {
    agent any

    stages {
        stage('Set up Env') {
            steps {
                git 'https://github.com/navanathjagtap/MultipleXMLTestRunner.git'
                echo 'Multiple XML Runner'
            }
        }
        stage('Build code')
        {
            steps {
            bat script: 'mvn compile'
            }
        }
        stage('Run test')
        {
            steps {
            bat script: 'mvn test'
            }
        }
    }
}

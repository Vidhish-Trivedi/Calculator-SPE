pipeline {
    agent any

    environment {
        // Define Docker Hub credentials ID (configured in Jenkins)
        DOCKER_CREDENTIALS_ID = 'dockerhub-credentials'
        DOCKERHUB_REPO = 'vidhishtrivedi/calculator'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Unit Test') {
            steps {
                // Run Maven unit tests
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image using the Dockerfile
                    bat "docker build -t ${DOCKERHUB_REPO}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Login to Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        // Push the Docker image to Docker Hub
                        docker.image("${DOCKERHUB_REPO}:${IMAGE_TAG}").push();
                    }
                }
            }
        }
    }

    post {
        success {
            // Notify on success
            echo 'Build and push completed successfully!'
        }
        failure {
            // Notify on failure
            echo 'Build or push failed.'
        }
    }
}

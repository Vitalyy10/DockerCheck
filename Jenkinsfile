pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'my-app:latest'
        DOCKER_REGISTRY = 'my-docker-registry.com'
        DOCKER_CREDENTIALS_ID = 'docker-credentials-id'
    }

    stages {
        stage('Checkout') {
            steps {
                // Проверяем исходный код из репозитория
                git 'https://github.com/Vitalyy10/DockerCheck.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Сборка Docker образа
                    docker.build("${env.DOCKER_IMAGE}")
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Запуск тестов внутри контейнера
                    docker.image("${env.DOCKER_IMAGE}").inside {
                        sh 'make test'
                    }
                }
            }
        }

        stage('Push') {
            steps {
                script {
                    // Логинимся в Docker Registry
                    docker.withRegistry("https://${env.DOCKER_REGISTRY}", "${env.DOCKER_CREDENTIALS_ID}") {
                        // Пушим образ в Registry
                        docker.image("${env.DOCKER_IMAGE}").push()
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Развертывание приложения (например, с использованием Docker Compose)
                    sh '''
                        docker-compose down
                        docker-compose up -d
                    '''
                }
            }
        }
    }

    post {
        always {
            // Удаление неиспользуемых образов для освобождения места
            sh 'docker system prune -f'
        }
    }
}

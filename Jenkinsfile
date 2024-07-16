pipeline {
    agent {label 'agent1'}

    environment {
        DOCKER_IMAGE = 'my-app:latest'
        DOCKER_REGISTRY = 'my-docker-registry.com'
        DOCKER_CREDENTIALS_ID = 'docker-credentials-id'
        DOCKER_BUILDKIT = '1'
    }


    stages {
        stage('Check and Install Docker') {
            steps {
                script {
                    def dockerInstalled = sh(script: 'which docker', returnStatus: true) == 0

                    if (!dockerInstalled) {
                        echo 'Docker is not installed. Installing Docker...'
                        sh '''
                             echo "some-sung"
                        '''
//                         sh '''
//                             sudo apt-get update
//                             sudo apt-get install -y \
//                                 ca-certificates \
//                                 curl \
//                                 gnupg \
//                                 lsb-release
//                             sudo mkdir -p /etc/apt/keyrings
//                             curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
//                             echo "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
//                             sudo apt-get update
//                             sudo apt-get install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin
//                         '''
//                     } else {
//                         echo 'Docker is already installed.'
                    }
                }
            }
        }


        stage('Checkout') {
            steps {
                // Проверяем исходный код из репозитория
                git 'https://github.com/Vitalyy10/DockerCheck.git'
            }
        }

        stage('Build') {
            steps {
                script {
//                 sh "rc-service docker restart"
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

//         stage('Push') {
//             steps {
//                 script {
//                     // Логинимся в Docker Registry
//                     docker.withRegistry("https://${env.DOCKER_REGISTRY}", "${env.DOCKER_CREDENTIALS_ID}") {
//                         // Пушим образ в Registry
//                         docker.image("${env.DOCKER_IMAGE}").push()
//                     }
//                 }
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 script {
//                     // Развертывание приложения (например, с использованием Docker Compose)
//                     sh '''
//                         docker-compose down
//                         docker-compose up -d
//                     '''
//                 }
//             }
//         }
    }

//     post {
//         always {
//             // Удаление неиспользуемых образов для освобождения места
//             sh 'docker system prune -f'
//         }
//     }
}


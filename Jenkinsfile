pipeline {
    agent any

    options {
        timestamps()
    }

    stages {

        stage('1. Verification') {
            steps {
                echo 'Verification de Java et des fichiers'

                sh '''
                    java --version
                    javac --version
                    git --version
                    ls -la
                '''
            }
        }

        stage('2. Build') {
            steps {
                echo 'Compilation du projet Java'

                sh '''
                    set -eu

                    mkdir -p build/classes

                    javac -d build/classes \
                        src/main/java/StudentManager.java \
                        src/main/java/Main.java

                    echo "Compilation reussie"
                '''
            }
        }

        stage('3. Test') {
            steps {
                echo 'Execution des tests'

                sh '''
                    set -eu

                    mkdir -p build/test-classes

                    javac -cp build/classes \
                        -d build/test-classes \
                        src/test/java/StudentManagerTest.java

                    java -cp build/classes:build/test-classes \
                        StudentManagerTest
                '''
            }
        }

        stage('4. Package') {
            steps {
                echo 'Creation du fichier JAR'

                sh '''
                    set -eu

                    jar --create \
                        --file build/StudentManager.jar \
                        --main-class Main \
                        -C build/classes .

                    ls -lh build/StudentManager.jar
                '''
            }
        }

        stage('5. Verification du JAR') {
            steps {
                echo 'Execution du JAR'

                sh '''
                    set -eu
                    java -jar build/StudentManager.jar
                '''
            }
        }
    }

    post {
        success {
            echo 'SUCCES : le pipeline est termine.'
        }

        failure {
            echo 'ECHEC : consultez Console Output.'
        }

        always {
            echo 'Fin du pipeline.'
        }
    }
}

pipeline {
    agent any

    environment {

    PATH = "C:\\WINDOWS\\SYSTEM32"

}

    stages {


        stage ('Retrieving') {


            steps {

                 git url:'https://github.com/ethanimperial/EcommerceClothesProject.git'

                }

        }
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven 3.8.2') {
                    bat 'mvn clean install test'
                }
            }
        }


    }
}

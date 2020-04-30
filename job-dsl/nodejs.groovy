job('NodeJS example') {
    scm {
        git('git://github.com/dasgourav/jenkins-course') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Gaurav Das')
            node / gitConfigEmail('ask.gaurav7@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}

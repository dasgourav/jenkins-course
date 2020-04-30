job('NodeJS Docker example') {
    scm {
        git('git://github.com/wardviaene/docker-demo') {  node -> // is hudson.plugins.git.GitSCM
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
        dockerBuildAndPublish {
            repositoryName('gunbo/docker-example')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

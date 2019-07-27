pipelineJob("my-first-pipeline") {
	logRotator {
    	numToKeep(10)
	}

    parameters {
      choiceParam('ACTION', ["plan", "apply"], "Choose current action")
      stringParam('DOCKER_LOGIN', 'denizzzzp')
      stringParam('DOCKER_PASS', 'password')
      stringParam('DOCKER_TAGS', 'latest')
      booleanParam('BUILD_IMAGE', true, 'Build image')
    }

    definition {
        cpsScm {
            scm {
                git {
                  remote {
                        github("denizzzzp/R1", 'https')
                        branch("master")
                  }
              }
        }
        scriptPath("Jenkinsfile")
      }

    }

 }

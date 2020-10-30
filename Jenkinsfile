@Library('pipelines') _
buildLibPipeline([
        buildSnapshotScript: './gradlew clean build publish',
        buildRCScript: './gradlew clean release -Prelease.useAutomaticVersion=true -Prelease.preCommitText=\"[skip ci]\"',
        projectName: 'logging-library',
        gitlabProjectNamespace:'tukan/logging-library',
        dockerBuildImageType: 'java11',
        artifactGroup: 'com.azimo.tukan',
        serviceName: 'logging-library',
        junitReports: 'build/test-results/**/*.xml',
        jacocoReports: false,
        projectEmoji: ':money_with_wings:',
        testTags: 'tukan'
])
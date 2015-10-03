grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "verbose" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'mysql:mysql-connector-java:5.1.24', {
            export = false
        }
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.42",
        // plugins or the compile step
        compile(
                ':cache:1.1.8',
                ':csv:0.3.1',
//                ':excel-import:1.0.0',
                ':export:1.5',
//                ':grails-template-engine:0.2.1',
//                ':grails-ui:1.2.3',
                ':hibernate:3.6.10.19',
                ':joda-time:1.5',
                ':jquery-ui:1.10.3',
//                ':navigation:1.3.2',
                ':platform-core:1.0.0',
                ':postgresql-extensions:0.6.1',
                ':quartz:1.0.2',
                ':rest:0.8',
                ':spring-security-core:2.0-RC5',
                ':spring-security-facebook:0.17',
//                ':spring-security-oauth-facebook:0.2',
//                ':spring-security-oauth-google:0.3.1',
//                ':spring-security-oauth:2.0.2',
                ':scaffolding:2.1.2'


        )

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:3.6.10.1" // or ":hibernate4:4.1.11.1"
//        runtime ":database-migration:1.3.5"
        runtime ":jquery:1.11.1"
        runtime ":asset-pipeline:1.8.3"
        build ":release:2.2.1"
//        build ':jbossas:1.0'
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"
    }
}

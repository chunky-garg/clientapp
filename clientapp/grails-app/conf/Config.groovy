// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

grails.plugin.springsecurity.facebook.domain.classname='com.wedding.app.security.FacebookUser'
grails.plugin.springsecurity.facebook.domain.appUserConnectionPropertyName ='com.wedding.app.security.User'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.wedding.app.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.wedding.app.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.wedding.app.security.Role'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.rejectIfNoRule = true

grails.plugin.springsecurity.interceptUrlMap = [
        '/*':   					['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/index/*':   				['IS_AUTHENTICATED_ANONYMOUSLY'],

        '/js/**':     	   			['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/css/**':     	  			['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/img/**':    	 			['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/assets/**':    	 		['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/login/**':     			['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/logout/**':    			['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/api/**':                  ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/admin/**':                ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/wedding/**':                ['IS_AUTHENTICATED_ANONYMOUSLY'],
        '/oauth/**':                ['IS_AUTHENTICATED_ANONYMOUSLY'],

        //Admin functionality pages
        '/pincode/**' :              ['IS_AUTHENTICATED_FULLY'],
        '/city/**' :                 ['IS_AUTHENTICATED_FULLY'],
        '/country/**' :              ['IS_AUTHENTICATED_FULLY'],
        '/vendor/**' :               ['IS_AUTHENTICATED_FULLY'],
        '/vendortype/**' :           ['IS_AUTHENTICATED_FULLY'],



]

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://local.wedmered.com:8080"
    }
    production {
        grails.logging.jul.usebridge = false
        TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
//    Example of changing the log pattern for the default console appender:

    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    }

    debug   'grails.app.controllers', 'grails.app.domain', 'grails.app.services' , 'com.the6hours.grails.springsecurity.facebook'

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

user.profile.pic.path="/profile/user/"


// Added by the Spring Security OAuth plugin:
grails.plugin.springsecurity.oauth.domainClass = 'com.wedding.app.security.OAuthID'

//oauth {
//    debug = true
//    providers {
//        facebook {
//            api = org.scribe.builder.api.FacebookApi
//            key = '155211021237321'
//            secret = '38cbad477de654c46c855b60038f7c21'
//            successUri = 'http://local.wedmered.com:8080/clientapp/oauth/facebook/success'
//            failureUri = 'http://local.wedmered.com:8080/clientapp/oauth/facebook/error'
//            callback = "http://local.wedmered.com:8080/clientapp/oauth/facebook/callback"
//        }
//

//        google {
//            api = org.scribe.builder.api.GoogleApi20
//            key = 'oauth_google_key'
//            secret = 'oauth_google_secret'
//            successUri = '/oauth/google/success'
//            failureUri = '/oauth/google/error'
//            callback = "${baseURL}/oauth/google/callback"
//            scope = 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email'
//        }
//    }
//}



grails.plugin.springsecurity.facebook.domain.classname='com.wedding.app.security.FacebookUser'
grails.plugin.springsecurity.facebook.domain.appUserConnectionPropertyName = 'user'
grails.plugin.springsecurity.facebook.appId='155211021237321'
grails.plugin.springsecurity.facebook.secret='38cbad477de654c46c855b60038f7c21'
grails.plugin.springsecurity.facebook.filter.type='redirect'
grails.plugin.springsecurity.facebook.filter.processUrl='/clientapp/wedding'

//or following:
//filter.types='transparent,cookieDirect,json'

//grails.plugin.springsecurity.facebook.autoCreate.enabled=true
//grails.plugin.springsecurity.facebook.autoCreate.roles=['ROLE_USER', 'ROLE_FACEBOOK',]


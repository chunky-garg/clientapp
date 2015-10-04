dataSource {
//    configClass = 'TablePerSubclassConfiguration'
    pooled = false
    driverClassName = "com.mysql.jdbc.Driver"
    username = "admin"
    password = "vegeta"

//    jndiName = "java:/bo/datasource"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

//// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/wedding?autoReconnect=true"
            username = "admin"
            password = "vegeta"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/wedding?autoReconnect=true"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            username = "admin"
            password = "vegeta"
            url = "jdbc:mysql://localhost:3306/wedding?autoReconnect=true"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            properties {
                //maxActive = 1000
                minEvictableIdleTimeMillis=1800000
                timeBetweenEvictionRunsMillis=1800000
                numTestsPerEvictionRun=3
                testOnBorrow=true
                testWhileIdle=true
                testOnReturn=false
                validationQuery="SELECT 1"
                jdbcInterceptors="ConnectionState"
            }
        }
    }
}

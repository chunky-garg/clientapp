dataSource {
//    configClass = 'TablePerSubclassConfiguration'
    pooled = false
    driverClassName = "org.postgresql.Driver"
    username = "db_user"
    password = "db_us3r"

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
            url = "jdbc:postgresql://localhost:5432/wedding"
            username = "blueoptima"
            password = "blu30pt1ma"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/wedding"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            username="blueoptima"
            password = "blu30pt1ma"
            url = "jdbc:postgresql://localhost:5432/wedding"
            dialect = org.hibernate.dialect.PostgreSQLDialect
            properties {
                maxActive = -1
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

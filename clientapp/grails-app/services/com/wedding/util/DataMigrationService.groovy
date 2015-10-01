package com.wedding.util

import grails.transaction.Transactional
import groovy.sql.Sql
import org.apache.commons.logging.LogFactory
import org.apache.commons.logging.Log

import java.util.logging.LogManager

@Transactional
class DataMigrationService {

    def dataSource
    def springSecurityService

    private static Log logr = LogFactory.getLog(this)

    def migrate() {
//        checkAndMigrateDB(1, this.&migrateDB1_0)

    }

    private void migrateDB1_0(def sql) {

    }

    private Boolean checkAndMigrateDB(long dbId, def migrateClosure) {
        if (DbVersion.get(dbId)) return true
        def sql = new Sql(dataSource)
        try{
            //Try inserting record to db version with same primary key(1) to block access to code below by single app node
            int numRowsUpdate = 0
            try{
                numRowsUpdate = sql.executeUpdate("insert into dbversion (id, version, db_version) VALUES(${dbId}, 0, 0)")
            }
            catch(Exception ex){
                def firstDbVersion = DbVersion.get(dbId)
                if (firstDbVersion == null){
                    logr.error("DBMigration-${dbId}:Some other error in starting the migration. Please contact Pricemaster Admin.")
                    ex.printStackTrace()
                }
                else{
                    logr.debug("DBMigration-${dbId}:Some other node has started migration")
                }
                return false
            }
            if (numRowsUpdate > 0){
                logr.debug("DBMigration-${dbId}:Entering...")
                //First ever entry to db migration
                //The one succeeds go inside and do the work
                try{
                    migrateClosure(sql)
                }
                catch(Exception e){
                    logr.error("DBMigration-${dbId}:Migration failed. Restore the database and try again or contact Admin.")
                    e.printStackTrace()
                    return false
                }
                //And update the db_version to 1 in the end
                logr.debug("DBMigration-${dbId}:Marking completed")
                sql.executeUpdate("update dbversion set version=1, db_version=${dbId} where id=${dbId}")
                //this marks completion of process
                logr.debug("DBMigration-${dbId}:Completed")
                return true
            }
        }
        catch(Exception e){
            logr.error("Some other error in migration. Contact Admin.")
            e.printStackTrace()
            return false
        }
        finally{
            sql.close()
        }
    }
}

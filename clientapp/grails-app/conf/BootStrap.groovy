import com.wedding.util.DataMigrationService

class BootStrap {

    DataMigrationService dataMigrationService


    def init = { servletContext ->

        dataMigrationService.migrate()

    }


    def destroy = {
    }
}

package com.wedding.admin

/**
 * Created by chunkygarg on 23/09/15.
 */
class Template {

    String name
    String contentPath
    String thumbnail
    String description

    Boolean isDefault

    static constraints = {
        name blank: false
        contentPath nullable: false
        thumbnail nullable: true
        description nullable: true
        isDefault default : false
    }

}

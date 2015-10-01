package com.wedding.app.client

import com.wedding.app.admin.Template
import com.wedding.app.security.User

/**
 * Created by chunkygarg on 23/09/15.
 */
class Wedding {

    User groom
    User bride
    Date weddingDate
    Template template
    boolean makePrivate //making wedding private will not be listed in our public dropdown

    static constraints = {
        groom nullable: false
        bride nullable: false
        weddingDate nullable: true
        template nullable: true
        makePrivate nullable : true

    }

    static mapping = {
        makePrivate defaultValue : true
    }

}

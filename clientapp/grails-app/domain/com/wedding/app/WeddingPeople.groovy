package com.wedding.app

import com.wedding.app.security.User

class WeddingPeople {

    String relationship
    String about
    String picture


    static belongsTo = [
            user:User,
            wedding:Wedding
    ]

    static constraints = {
        relationship nullable: false
        about nullable: true
        picture nullable: true
    }

}

package com.wedding.app.security

class Role {

    String authority
    String description

    static mapping = {
        table('role')
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
        description nullable: true
    }
}

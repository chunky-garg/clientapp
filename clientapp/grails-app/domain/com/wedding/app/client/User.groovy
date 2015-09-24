package com.wedding.app.client

/**
 * Created by chunkygarg on 23/09/15.
 */
class User {

    String firstName
    String middleName
    String lastName
    String username

    static constraints = {

        username blank:false
        firstName nullable: true
        middleName nullable: true
        lastName nullable: true

    }

    static mapping = { table ('public.user') }

    public String toString() {
        return firstName
    }
}

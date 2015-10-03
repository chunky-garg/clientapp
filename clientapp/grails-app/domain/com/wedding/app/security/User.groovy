package com.wedding.app.security


/**
 * Created by chunkygarg on 23/09/15.
 */
class User {

    transient springSecurityService

    String firstName
    String middleName
    String lastName
    String username

    String password

    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [oAuthIDs: OAuthID]


    static constraints = {

        username blank:false
        firstName nullable: true
        middleName nullable: true
        lastName nullable: true

        accountExpired default:false
        accountLocked default:false
        passwordExpired default:false

    }

    static transients =[
            'authorities'
    ]

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        //encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }


    //static mapping = { table ('public.user') }

    public String toString() {
        return firstName
    }
}

package com.wedding.app.security

class FacebookUser {

    Long uid
    String accessToken
    Date accessTokenExpires
    User user
    static belongsTo = [user: User] //connected to main Spring Security domain

    static constraints = {
        uid unique: true
    }
}

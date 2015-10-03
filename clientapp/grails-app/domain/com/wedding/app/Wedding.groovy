package com.wedding.app

import com.wedding.admin.Template
import com.wedding.app.security.User
import com.wedding.common.location.Address

/**
 * Created by chunkygarg on 23/09/15.
 */
class Wedding {

    User groom
    User bride
    Date weddingDate
    Template template
    boolean makePrivate //making wedding private will not be listed in our public dropdown

    String facebook
    String googlePlus
    String twitter
    String instagram
    String web

    Address venue;

    static hasMany = [people : WeddingPeople]

    static constraints = {
        groom nullable: false
        bride nullable: false
        weddingDate nullable: true
        template nullable: true
        makePrivate nullable : true
        facebook nullable : true
        googlePlus nullable : true
        twitter nullable : true
        instagram nullable :true

    }

    static mapping = {
        makePrivate defaultValue : true
    }

}

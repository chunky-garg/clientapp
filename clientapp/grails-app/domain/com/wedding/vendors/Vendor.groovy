package com.wedding.vendors

import com.wedding.app.security.User
import com.wedding.common.location.Address

class Vendor {

    String name
    String description

    Boolean active

    Date dateCreated
    Address address

    int views
    int contacted

    VendorProfile profile


    static belongsTo = [
            type: VendorType,
            user : User
    ]

    static hasMany= {
        ratings: VendorReview
    }

    static constraints = {
        name blank: false
        type nullable: false
        description nullable: true
        active nullable: true
        address nullable: true
    }

    static mapping = {
        active defaultValue:false
    }

    public String toString() {
        name
    }
}

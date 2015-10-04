package com.wedding.vendors

import com.wedding.app.security.User

class VendorServiceReview implements Serializable {

    Integer rating
    String comment

    VendorService vendorService
    User user

    static belongs = [
     vendorService : VendorService,
     user : User

    ]

    static constraints = {
        rating nullable:true
        comment nullable: true
        user nullable: false
        vendorService : false

    }
}

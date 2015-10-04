package com.wedding.vendors

import com.wedding.app.security.User

class VendorServiceReview implements Serializable {

    Integer rating
    String comment

    static belongs = [
     vendorService : VendorService,
     user: User
    ]

    static constraints = {
        rating nullable:true
        comment nullable: true
    }
}

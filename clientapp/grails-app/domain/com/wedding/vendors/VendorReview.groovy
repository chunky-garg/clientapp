package com.wedding.vendors

import com.wedding.app.security.User

class VendorReview implements Serializable {

    Integer rating
    String comment

    static belongs = [
     vendor : Vendor,
     user: User
    ]

    static constraints = {
        rating nullable:true
        comment nullable: true
    }
}

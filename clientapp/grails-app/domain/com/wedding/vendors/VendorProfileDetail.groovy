package com.wedding.vendors

class VendorProfileDetail {

    Category category
    SubCategory subCategory
    String value

    static belongsTo = [
            vendorProfile: VendorProfile
    ]


    static constraints = {
        subCategory nullable: true
        value nullable: true
    }
}

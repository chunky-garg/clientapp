package com.wedding.vendors

class VendorProfileDetail {

    VendorProfileHeader header
    Category category
    SubCategory subCategory
    String value

    static belongsTo = [
            vendorProfile:VendorProfile
    ]



    static constraints = {
        header nullable: false
    }
}

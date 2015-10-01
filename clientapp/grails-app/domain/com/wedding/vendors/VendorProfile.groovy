package com.wedding.vendors

class VendorProfile {

    static belongsTo =[
            vendor :Vendor
    ]

    static hasMany = [
            details :VendorProfileDetail
    ]

    static constraints = {
    }
}

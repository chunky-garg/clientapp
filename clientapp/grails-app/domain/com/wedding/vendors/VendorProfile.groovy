package com.wedding.vendors

class VendorProfile {

    static belongsTo =[
            vendor :VendorService
    ]

    static hasMany = [
            details :VendorProfileDetail
    ]

    static constraints = {
    }
}

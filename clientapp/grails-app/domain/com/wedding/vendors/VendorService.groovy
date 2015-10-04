package com.wedding.vendors

class VendorService {

    Vendor vendor
    ServiceCategory serviceCategory

    static hasMany = [
            reviews : VendorServiceReview
    ]

    public String toString() {
        serviceCategory +" by " + vendor
    }

}

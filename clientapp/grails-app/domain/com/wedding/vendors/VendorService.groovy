package com.wedding.vendors

class VendorService {

    Vendor vendor
    ServiceCategory service

    static hasMany = [
            reviews : VendorServiceReview
    ]

    public String toString() {
        service +" by " + vendor
    }

}

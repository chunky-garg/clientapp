package com.wedding.vendors

import com.wedding.app.security.User
import com.wedding.common.location.Address

class Vendor {

    String name
    String code

    String description

    Boolean active

    Date dateCreated
    Address address

    Integer views
    Integer inquiries

    VendorProfile profile
    String companyType


    static belongsTo = [
            user : User
    ]

    static hasMay =[
            services:VendorService
    ]


    static hasMany= {
        reviews: VendorServiceReview
    }

    static constraints = {
        name blank: false
        code blank:false, unique: true //required to form unique access url for each vendor
        description nullable: true
        active nullable: true
        address nullable: true
        profile nullable : true
        views nullable : true, default:0
        inquiries nullable: true, default :0
        companyType inList: ["Individual", "Company"]
    }

    static mapping = {
        active defaultValue:false
    }

    @Override
    public String toString() {
        name
    }
}

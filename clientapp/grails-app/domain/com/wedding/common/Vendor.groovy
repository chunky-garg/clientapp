package com.wedding.common

import com.wedding.common.location.Address

class Vendor {

    String name
    String description

    Boolean active

    Date dateCreated
    Address address

    static belongsTo = [
            type: VendorType
    ]

    static constraints = {
        name blank: false;
        description nullable: true
        active nullable: true
        address nullable: true
    }

    static mapping = {
        active defaultValue:false
    }

    public String toString() {
        name
    }
}
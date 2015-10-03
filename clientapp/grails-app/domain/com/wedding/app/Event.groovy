package com.wedding.app

import com.wedding.common.location.Address

class Event {


    String name
    String description
    Date eventDate
    Address venue

    String image

    Event previousEvent

    static belongsTo = [
            wedding : Wedding
    ]

    static constraints = {
        name blank: false
        description nullable: true
        eventDate nullable: true
        venue nullable: true
        previousEvent nullable : true
        image nullable: true

    }

    public String toString() {
        name + " @ " + eventDate
    }
}

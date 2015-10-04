package com.wedding.app

import com.wedding.AppConstants

class WeddingStory {

    String title
    String subTitle
    String description

    static belongsTo = [
            wedding:Wedding
    ]

    static hasMany = [
            stories : Storyline
    ]

    static constraints = {

        title blank: false, default:AppConstants.DEFAULT_STORY_TITLE
        subTitle nullable : true
        description nullable : true

    }

    public String toString() {
         wedding +" - " + title
    }
}

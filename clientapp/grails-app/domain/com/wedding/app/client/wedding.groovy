package com.wedding.app.client

import com.wedding.app.admin.Template

/**
 * Created by chunkygarg on 23/09/15.
 */
class wedding {

    User groom;
    User bride;
    Date weddingDate;
    Template template;

    static constraints = {
        groom nullable: false;
        bride nullable: false;
        weddingDate nullable: true;
        template nullable: true;
    }
}

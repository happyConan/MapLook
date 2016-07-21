package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/21.
 */
public class ContactsMember {
    String contacts_name;
    int contacts_image;

    public ContactsMember(int contacts_image, String contacts_name) {
        this.contacts_image = contacts_image;
        this.contacts_name = contacts_name;
    }

    public String getContacts_name() {
        return contacts_name;
    }

    public int getContacts_image() {
        return contacts_image;
    }
}

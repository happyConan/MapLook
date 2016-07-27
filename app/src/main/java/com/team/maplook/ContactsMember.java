package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/21.
 */
public class ContactsMember {
    String contacts_name;
    int contacts_hp;

    public ContactsMember(int contacts_hp, String contacts_name) {
        this.contacts_hp = contacts_hp;
        this.contacts_name = contacts_name;
    }

    public String getContacts_name() {
        return contacts_name;
    }

    public int getContacts_image() {
        return contacts_hp;
    }
}

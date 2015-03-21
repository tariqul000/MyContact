package com.example.pc21.mycontact;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PC21 on 21/3/2015.
 */
public class ContactList {


    private int IVContactImage;
    private String contactName;
    private String phoneNumber;

    public int getIVContactImage() {
        return IVContactImage;
    }

    public void setIVContactImage(int IVContactImage) {
        this.IVContactImage = IVContactImage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }


}

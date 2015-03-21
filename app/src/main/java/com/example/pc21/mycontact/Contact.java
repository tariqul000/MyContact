package com.example.pc21.mycontact;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Contact extends ActionBarActivity {

    ListView lv;
    List<ContactList> namelist;
    DBHandler db;
    List<ContactList> contactses;
    ContactList contacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getAllContactsFromPhone();

        init();




    }

    private void init() {
        db = new DBHandler(this);


    }


    public List<ContactList> getAllContactsFromPhone() {
        contactses = new ArrayList<ContactList>();

        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
                null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        + " COLLATE LOCALIZED ASC");

        // Looping through the contacts and adding them to arrayList
        while (cursor.moveToNext()) {
            String name = cursor
                    .getString(cursor
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = cursor
                    .getString(cursor
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts= new ContactList();

            contacts.setContactName(name);
            contacts.setPhoneNumber(phoneNumber);
            Toast.makeText(getApplicationContext(),name+ "  " + phoneNumber, Toast.LENGTH_LONG).show();
            contactses.add(contacts);
            contactses.get(0).getContactName();
            int i;
            for (i =1; i<contactses.size(); i++){

              //  db.addContact(contactses.get(i).getContactName(),contactses.get(i).getPhoneNumber(),contactses.get(i).getIVContactImage());
                db.addContact();
            }


          namelist.add((ContactList) db.getAllContact());

            ArrayAdapter<ContactList> adapter = new ArrayAdapter<ContactList>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, namelist);

            lv.setAdapter(adapter);
            Toast.makeText(this, "Show", Toast.LENGTH_LONG).show();

        }

        cursor.close();

        return contactses;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

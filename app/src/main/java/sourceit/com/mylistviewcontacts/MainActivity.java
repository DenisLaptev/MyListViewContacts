package sourceit.com.mylistviewcontacts;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sourceit.com.mylistviewcontacts.model.MyContact;

public class MainActivity extends AppCompatActivity implements MyAdapter.ContactClickListener {

    public static final String KEY = "myContact";

    ListView listView;
    MyAdapter adapter;
    MyContact[] contactsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsArray = generateContacts();

        listView = (ListView) findViewById(R.id.list_view);
        adapter = new MyAdapter(this, contactsArray);
        listView.setAdapter(adapter);
    }


    public MyContact[] generateContacts() {
        MyContact[] contactsArray = new MyContact[16];
        String name;
        String email;
        String address;
        String phone;
        @ColorInt
        int color;
        for (int i = 0; i < 15; i++) {
            name = "name" + i;
            email = "email" + i;
            address = "address" + i;
            phone = "phone" + i;
            color = Color.parseColor("#0000" + Integer.toHexString(i) + "" + Integer.toHexString(i));
            contactsArray[i] = new MyContact(name, email, address, phone, color);
        }
        return contactsArray;
    }

    @Override
    public void onClick(MyContact myContact) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra(KEY, myContact);
        startActivity(intent);
        Toast.makeText(this, myContact.getName(), Toast.LENGTH_SHORT).show();
    }
}

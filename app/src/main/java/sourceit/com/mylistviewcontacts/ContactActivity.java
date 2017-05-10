package sourceit.com.mylistviewcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sourceit.com.mylistviewcontacts.model.MyContact;

import static sourceit.com.mylistviewcontacts.MainActivity.KEY;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView tvName;

    @BindView(R.id.email)
    TextView tvEmail;

    @BindView(R.id.address)
    TextView tvAddress;

    @BindView(R.id.phone)
    TextView tvPhone;

    @BindView(R.id.rectangle)
    View rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);

        //textView = (TextView)findViewById(R.id.name);

        if (getIntent() != null) {
            MyContact myContact = (MyContact) getIntent().getSerializableExtra(KEY);
            tvName.setText(myContact.getName());
            tvEmail.setText(myContact.getEmail());
            tvAddress.setText(myContact.getAddress());
            tvPhone.setText(myContact.getPhone());
            rectangle.setBackgroundColor(myContact.getColor());
        }
    }
}

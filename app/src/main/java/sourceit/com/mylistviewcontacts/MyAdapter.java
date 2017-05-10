package sourceit.com.mylistviewcontacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import sourceit.com.mylistviewcontacts.model.MyContact;


import static sourceit.com.mylistviewcontacts.MainActivity.KEY;

/**
 * Created by Lenovo on 08.05.2017.
 */

public class MyAdapter extends ArrayAdapter<MyContact> {

    interface ContactClickListener {
        void onClick(MyContact myContact);
    }


    public MyAdapter(Context context, MyContact[] contacts) {
        super(context, R.layout.item, contacts);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.item, null, true);
            holder = new ViewHolder();
            holder.rectangle = (View) rowView.findViewById(R.id.rectangle);
            holder.name = (TextView) rowView.findViewById(R.id.name);
            holder.email = (TextView) rowView.findViewById(R.id.email);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        //settings code
        holder.name.setText("name");
        holder.email.setText("email");
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), String.valueOf(holder.email.getText()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ContactActivity.class);
                //intent.putExtra(KEY, myContact);
                startActivity(intent);
                //Toast.makeText(this,myContact.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }


    private static class ViewHolder {

        public ViewHolder() {
        }

        View rectangle;
        TextView name;
        TextView email;
    }
}
package sourceit.com.mylistviewcontacts;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sourceit.com.mylistviewcontacts.model.MyContact;


import static sourceit.com.mylistviewcontacts.MainActivity.KEY;

/**
 * Created by Lenovo on 08.05.2017.
 */

public class MyAdapter extends ArrayAdapter<MyAdapter.ViewHolder> {

    interface ContactClickListener {
        void onClick(MyContact myContact);
    }

    //Локальный слушатель для адаптера.
    interface ItemClickListener {
        void onClick(int position);
    }

    private Context context;
    private List<MyContact> list;
    private ContactClickListener contactClickListener;
    private ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onClick(int position) {
            //TODO
            contactClickListener.onClick(list.get(position));
        }
    };


    public MyAdapter(Context context,
                     List<MyContact> list,
                     ContactClickListener contactClickListener) {
        super(context, 0);
        this.context = context;
        this.list = list;
        this.contactClickListener = contactClickListener;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.item, null, true);
            View item = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ViewHolder(item, itemClickListener);
            holder.rectangle = (View) rowView.findViewById(R.id.rectangle);
            holder.name = (TextView) rowView.findViewById(R.id.name);
            holder.email = (TextView) rowView.findViewById(R.id.email);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        //settings code
        MyContact myContact = list.get(position);
        holder.name.setText("name");
        holder.email.setText("email");
        //holder.rectangle.setBackgroundColor(myContact.getColor());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), String.valueOf(holder.email.getText()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ContactActivity.class);
                MyContact myContact = list.get(position);
                intent.putExtra(KEY, myContact);
                v.getContext().startActivity(intent);
                //Toast.makeText(this,myContact.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    static class ViewHolder {
        View rectangle;
        TextView name;
        TextView email;

        ItemClickListener itemClickListener;

        public ViewHolder(View item, final ItemClickListener itemClickListener) {

            this.itemClickListener = itemClickListener;
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(getAdapterPosition());
                }
            });
        }


    }
}
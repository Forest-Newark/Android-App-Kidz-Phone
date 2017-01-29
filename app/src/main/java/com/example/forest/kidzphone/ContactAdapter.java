package com.example.forest.kidzphone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by Forest on 1/24/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {
public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contact contact = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        // Lookup view for data population
        TextView contactName = (TextView) convertView.findViewById(R.id.contactName);
        TextView contactNumber = (TextView) convertView.findViewById(R.id.contactNumber);
        // Populate the data into the template view using the data object
        contactName.setText(contact.getContactName());
        contactNumber.setText(contact.getContactNumber());
        // Return the completed view to render on screen
        return convertView;
        }

        public Contact getItemAtPosition(int position) {
                return getItem(position);
        }
}
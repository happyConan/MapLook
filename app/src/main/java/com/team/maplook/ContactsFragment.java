package com.team.maplook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class ContactsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container,false);
        ListView listView = (ListView) view.findViewById(R.id.id_contacts_listview);
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity());
        listView.setAdapter(contactsAdapter);
        return view;
    }


}

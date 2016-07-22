package com.team.maplook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class ContactsFragment extends Fragment {
    View view;
    ListView listView;
    ContactsAdapter contactsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contacts, container,false);
        listView = (ListView) view.findViewById(R.id.id_contacts_listview);
        contactsAdapter = new ContactsAdapter(getActivity());
        listView.setAdapter(contactsAdapter);
        return view;
    }
}

package br.com.criandojogosandroid.cap04ex01_paint;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String items[] = {"Paint.Style", "Paint.Cap", "Paint.Join", "AntiAlias"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(new Intent(this, StyleActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, CapActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, JoinActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, AliasActivity.class));
                break;
        }
    }
}
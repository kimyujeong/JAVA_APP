package org.androidtown.java_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class SubActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        final ArrayList<String> items2=new ArrayList<String>();
        final ArrayAdapter adapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items2);

        final ListView list2=(ListView) findViewById(R.id.listview2);
        list2.setAdapter(adapter2);
        Intent intent = getIntent();
        String[] aa=intent.getStringArrayExtra("value");
        for(int i=1;;i++) {
            if(aa[i]==null) break;
            items2.add(aa[i]);
        }
        adapter2.notifyDataSetChanged();
    }
}
package org.androidtown.java_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.list;
import static org.androidtown.java_app.R.id.btnDel;

public class MainActivity extends AppCompatActivity {

    EditText Edthw,Edtdate;
    View Add;
    View Success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제알리미");

        final ArrayList<String> items=new ArrayList<String>();
        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,items);//ListView 아이템에 TextView와 Radio Button을 가진 View 표시
        final ListView listview=(ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        /*final ArrayList<String> items2=new ArrayList<String>();
        final ArrayAdapter adapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,items2);//ListView 아이템에 TextView와 Radio Button을 가진 View 표시
        final ListView listview2=(ListView) findViewById(R.id.listview2);
        listview.setAdapter(adapter2);*/

        final ArrayList<String> items2=new ArrayList<String>();
        final ListView listview2=(ListView) findViewById(R.id.listview2);

        Button button2=(Button)findViewById(R.id.button2);
        Button btnDel=(Button)findViewById(R.id.btnDel);
        Button button3=(Button)findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Success=(View)View.inflate(MainActivity.this,R.layout.success,null);
                AlertDialog.Builder success=new AlertDialog.Builder(MainActivity.this);
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){ //미리 코딩해놓은 리스너와 연결

            @Override
            public void onClick(View v){
                Add =(View)View.inflate(MainActivity.this,R.layout.second_layout,null);
                AlertDialog.Builder add=new AlertDialog.Builder(MainActivity.this);
                add.setTitle("과제입력");

                add.setView(Add);
                add.setPositiveButton("확인",new DialogInterface.OnClickListener(){ //확인을 눌렀을때 사건
                    public void onClick(DialogInterface dialog, int which){
                        Edthw=(EditText) Add.findViewById(R.id.hw);
                        Edtdate=(EditText) Add.findViewById(R.id.date);
                        String str="[ "+Edtdate.getText().toString()+" ] "+Edthw.getText().toString();
                        items.add(str);
                        adapter.notifyDataSetChanged();
                        Edthw.setText(""); //입력된값지우기
                    }
                });

                add.setNegativeButton("취소",null); //취소를 눌렀을때의 사건(여기선 아무사건도 일어나지 않음

                add.show();
            }
        });
        /*listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v,int position,long id){
                String item=items.get(position); //ArrayList에서 position에 해당하는 데이터 얻어오기
            }
        });*/
       btnDel.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                SparseBooleanArray checkedItems=listview.getCheckedItemPositions();
                int count=adapter.getCount();
                for(int i=count-1;i>=0;i--){
                    if(checkedItems.get(i)){
                        String item=items.get(i);
                        items2.add(item);
                        items.remove(i);
                    }
                }
                listview.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });

    }
}


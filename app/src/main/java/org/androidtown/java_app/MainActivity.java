package org.androidtown.java_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Edthw,Edtdate;
    View Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제알리미");
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

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

                    }
                });

                add.setNegativeButton("취소",null); //취소를 눌렀을때의 사건(여기선 아무사건도 일어나지 않음

                add.show();
            }
        });


    }


}

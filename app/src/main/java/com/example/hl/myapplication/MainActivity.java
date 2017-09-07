package com.example.hl.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //提示按钮监听器
        Button bt1 = (Button)findViewById(R.id.button1);
                bt1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setMessage("并没有什么提示哟").setTitle("提示对话框");

                       builder1.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Toast.makeText(MainActivity.this,"用户按下了确定按钮",Toast.LENGTH_LONG).show();
                           }
                       });

                        builder1.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"用户按下了取消按钮",Toast.LENGTH_LONG).show();
                            }
                        });
                        builder1.show();
                    }
                });
        //登录按钮监听器
        Button bt2 = (Button)findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                View view = getLayoutInflater().inflate(R.layout.login_dialog,null);
                final EditText User_id = (EditText)view.findViewById(R.id.User_id);
                final EditText password = (EditText)view.findViewById(R.id.Password);
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setView(view)
                        .setTitle("Login")
                        .setPositiveButton("登录", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int id){
                                if(!User_id.getText().toString().equals("abc")||!password.getText().toString().equals("123")){
                                    Toast.makeText(MainActivity.this,"用户名或密码有误",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                }

                             }
                        });
                builder2.show();
            }
        });
    }
}

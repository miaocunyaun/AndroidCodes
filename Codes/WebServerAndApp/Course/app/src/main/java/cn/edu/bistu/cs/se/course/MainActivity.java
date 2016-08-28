package cn.edu.bistu.cs.se.course;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button=(Button)findViewById(R.id.butonLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                EditText textUserId=(EditText)findViewById(R.id.textUserId);
                EditText textUserPwd=(EditText)findViewById(R.id.textPwd);
                if(textUserId.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"User Id不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(textUserPwd.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Password不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }



                user.setUserName(textUserId.getText().toString());
                user.setUserPassword(textUserPwd.getText().toString());
                login(user);
            }
        });



    }

    private void login(final User user) {



        final Handler handler = new Handler() {
            @Override
//当有消息发送出来的时候就执行Handler的这个方法
            public void handleMessage(Message msg) {
                super.handleMessage(msg);


                User user = (User) msg.obj;

                if(user==null){
                    Toast.makeText(getApplicationContext(), "不存在该用户",
                            Toast.LENGTH_LONG).show();
                }   else if (user.getUserPassword()==null) {
                    Toast.makeText(getApplicationContext(), "密码错误",
                            Toast.LENGTH_LONG).show();
                } else if (user.getUserName()==null) {
                    Toast.makeText(getApplicationContext(), "不存在该用户",
                            Toast.LENGTH_LONG).show();
                } else {
                    //登录成功
                        Toast.makeText(getApplicationContext(), "成功",
                                Toast.LENGTH_LONG).show();
                }


            }
        };

        // The connection URL
        final String url = "http://192.168.1.3:8080/course/account/androidLogin.json";

        new Thread() {
            @Override
            public void run() {

                User result=new User();
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                try {
                    result = restTemplate.postForObject(url, user, User.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.obj=result;
                handler.sendMessage(msg);
            }
        }.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

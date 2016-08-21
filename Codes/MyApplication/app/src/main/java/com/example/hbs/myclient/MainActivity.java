package com.example.hbs.myclient;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler loginHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        User user = (User) msg.obj;
                        if (user == null) {
                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "success:" + user.getId(), Toast.LENGTH_LONG).show();
                        }
                }

            }
        };

        final EditText textUserId = (EditText) findViewById(R.id.editTextUserId);
        final EditText textUserPassword = (EditText) findViewById(R.id.editTextPassword);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final String userId = textUserId.getText().toString();
                final String userPassword = textUserPassword.getText().toString();

                // The connection URL
                String url = "http://192.168.56.1:8080/course/account/androidLogin.json";

                User user = new User();
                user.setUser_name(userId);
                user.setUser_password(userPassword);


                // Set the Content-Type header
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setContentType(new MediaType("application", "json"));
                HttpEntity<User> requestEntity = new HttpEntity<User>(user, requestHeaders);


                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


                ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, User.class);
                User result = responseEntity.getBody();
                if(result!=null)
                Log.v("tag","result: id:"+result.getId()+"-name:"+result.getUser_name()+"-pwd:"+result.getUser_password());


                Message msg = new Message();
                msg.obj = result;
                msg.what = 1;
                loginHandler.sendMessage(msg);
            }
        };


        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(runnable);
                t.start();
            }
        });


    }
}

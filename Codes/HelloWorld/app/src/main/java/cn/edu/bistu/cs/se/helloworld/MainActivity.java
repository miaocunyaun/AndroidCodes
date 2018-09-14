package cn.edu.bistu.cs.se.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("myTag","asdfsadf");





        Button button=findViewById(R.id.btnHelloWorld);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView=findViewById(R.id.txtView);
                textView.setText("Welcome to the Android World!");
            }
        });

        Log.v("mytag","asdfsadf");
    }
}

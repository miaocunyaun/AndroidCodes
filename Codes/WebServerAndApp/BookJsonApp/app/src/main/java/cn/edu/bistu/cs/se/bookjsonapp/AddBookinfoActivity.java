package cn.edu.bistu.cs.se.bookjsonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bookinfo);
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

        final EditText txtName=(EditText)findViewById(R.id.txtName);
        final EditText txtAuthor=(EditText)findViewById(R.id.txtAuthor);
        final EditText txtBinfo=(EditText)findViewById(R.id.txtBinfo);
        final EditText txtAinfo=(EditText)findViewById(R.id.txtAinfo);
        final EditText txtCollects=(EditText)findViewById(R.id.txtCollects);
        final EditText txtRewards=(EditText)findViewById(R.id.txtRewards);
        final EditText txtPublish=(EditText)findViewById(R.id.txtPublish);
        final EditText txtWords=(EditText)findViewById(R.id.txtWords);

        Button buttonOK=(Button)findViewById(R.id.btnOk);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                intent.putExtra("name",txtName.getText().toString());
                intent.putExtra("author",txtAuthor.getText().toString());
                intent.putExtra("binfo",txtBinfo.getText().toString());
                intent.putExtra("ainfo",txtAinfo.getText().toString());
                intent.putExtra("collects",Integer.parseInt(txtCollects.getText().toString()));
                intent.putExtra("rewards",Double.parseDouble(txtRewards.getText().toString()));
                intent.putExtra("publish",(byte) (Integer.parseInt(txtPublish.getText().toString())));
                intent.putExtra("words",Integer.parseInt(txtWords.getText().toString()));
                setResult(0,intent);
                finish();

            }
        });
    }

}

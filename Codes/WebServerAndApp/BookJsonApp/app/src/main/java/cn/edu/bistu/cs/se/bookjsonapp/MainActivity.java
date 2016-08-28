package cn.edu.bistu.cs.se.bookjsonapp;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String BOOK_ID = "id";
    private final static String BOOK_NAME = "name";
    private final static String BOOK_AUTHOR = "author";


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

        Button buttonAdd = (Button) findViewById(R.id.btnAddBook);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookinfoActivity.class);
                startActivityForResult(intent, 0);

            }
        });

        //获得书籍
        getAllBooks();
    }


    /**
     * 从服务器端获得所有的书籍，然后显示在列表中
     */
    private void getAllBooks() {
        final Handler handler = new Handler() {
            @Override
//当有消息发送出来的时候就执行Handler的这个方法
            public void handleMessage(Message msg) {
                super.handleMessage(msg);


                bookinfolist list = (bookinfolist) msg.obj;

                if (list == null) {
                    Toast.makeText(getApplicationContext(), "书籍为空",
                            Toast.LENGTH_LONG).show();
                } else {
                    //显示所有的书籍
                    List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();

                    if (list.getList() != null) {
                        for (int i = 0; i < list.getList().size(); i++) {
                            Map<String, Object> item = new HashMap<String, Object>();
                            item.put(BOOK_ID, list.getList().get(i).getId());
                            item.put(BOOK_NAME, list.getList().get(i).getName());
                            item.put(BOOK_AUTHOR, list.getList().get(i).getAuthor());
                            items.add(item);
                        }

                        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, items, R.layout.bookinfo_item, new String[]{BOOK_ID, BOOK_NAME, BOOK_AUTHOR}, new int[]{R.id.txtID, R.id.txtName, R.id.txtAuthor});

                        ListView listview = (ListView) findViewById(R.id.booklist);

                        listview.setAdapter(adapter);
                    }

                }


            }
        };

        // The connection URL
        final String url = "http://192.168.1.2:8080/webserver/androidlist.json";

        new Thread() {
            @Override
            public void run() {

                bookinfolist result = new bookinfolist();
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                try {
                    result = restTemplate.postForObject(url, null, bookinfolist.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.obj = result;
                handler.sendMessage(msg);
            }
        }.start();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {


           final bookinfo bi = new bookinfo();
            bi.setName(data.getStringExtra("name"));
            bi.setAuthor(data.getStringExtra("author"));
            bi.setBinfo(data.getStringExtra("binfo"));
            bi.setAuinfo(data.getStringExtra("ainfo"));
            bi.setCollects(data.getIntExtra("collects", 1));
            bi.setRewards(data.getDoubleExtra("rewards", 1));
            bi.setPublish(data.getByteExtra("publish", (byte) 0));
            bi.setWords(data.getIntExtra("words", 1));

            final Handler handler = new Handler() {
                @Override
                //当有消息发送出来的时候就执行Handler的这个方法
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);


                    Integer r = (Integer) msg.obj;

                    if (r == null || r==0) {
                        Toast.makeText(getApplicationContext(), "添加失败",
                                Toast.LENGTH_LONG).show();
                    } else {
                        //显示所有的书籍
                        getAllBooks();
                    }

                }


            };


            // The connection URL
            final String url = "http://192.168.1.2:8080/webserver/androidaddbook.json";

            new Thread() {
                @Override
                public void run() {

                    int result = 0;
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                    try {
                        result = restTemplate.postForObject(url, bi, Integer.class);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.obj = result;
                    handler.sendMessage(msg);
                }
            }.start();
        } ;


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

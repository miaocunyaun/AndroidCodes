package cn.edu.bistu.se.android.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import cn.edu.bistu.se.android.fragmentapp.word.WordContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClick(WordContent.WordItem wordItem) {
        DetailFragment detailFragment = (DetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.wordDetail);

        if (detailFragment != null) {
            detailFragment.updateView(wordItem);
        } else {

            DetailFragment newFragment = new DetailFragment();
            Bundle args = new Bundle();

            args.putSerializable(DetailFragment.ARG_PARAM,wordItem);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.wordDetail, newFragment);


            // Commit the transaction
            transaction.commit();
        }

    }
}
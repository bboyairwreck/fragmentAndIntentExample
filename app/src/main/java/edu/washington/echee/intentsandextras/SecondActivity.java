package edu.washington.echee.intentsandextras;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;


public class SecondActivity extends ActionBarActivity {
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createOverviewData();

        Intent whoCalledMe = getIntent();

        if (whoCalledMe != null) {
            String topic = whoCalledMe.getStringExtra("myString");   // math

            String myString2 = whoCalledMe.getStringExtra("myString2");
            int num = whoCalledMe.getIntExtra("myInt", 0);

            Log.i("SecondActivity" , topic + myString2 + num);



            // Loads QuestionFragment
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();


            Bundle topicBundle = new Bundle();
            topicBundle.putString("topicName", "Math");
            topicBundle.putInt("topicName", 32);
            topicBundle.putString("topicOverview", "I am done with this math");

            QuestionFragment questionFragment = new QuestionFragment();
            questionFragment.setArguments(topicBundle);



            ft.add(R.id.container, questionFragment);   // where , what
            ft.commit();


        }

    }

    public void loadAnswerFrag() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();






        Bundle topicBundle = new Bundle();
        topicBundle.putString("topicName", "Math");
        topicBundle.putInt("topicName", 32);
        topicBundle.putString("topicOverview", "I am done with this math");

        AnswerFragment questionFragment = new AnswerFragment();
        questionFragment.setArguments(topicBundle);



        ft.add(R.id.container, questionFragment);   // where , what
        ft.commit();

    }

    public void loadOverFrag() {


    }

    private void createOverviewData() {
        this.map = new HashMap<String, String>();

        this.map.put("Physics", "ballkajfdlakjflajwljart");
        this.map.put("Math", "ballkajfdlakjflajwljart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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

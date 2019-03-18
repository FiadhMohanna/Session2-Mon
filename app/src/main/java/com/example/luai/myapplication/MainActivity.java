package com.example.luai.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.luai.myapplication.models.User;
import com.example.luai.myapplication.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView mTextViewUserWithId1;
    private TextView mTextViewUserWithId5;
    private TextView mTextViewUserWithId7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (5): Find the 3 text views in the activity and inject them in the variables
        mTextViewUserWithId1 = findViewById(R.id.tv_user1);
        mTextViewUserWithId5 = findViewById(R.id.tv_user2);
        mTextViewUserWithId7 = findViewById(R.id.tv_user3);
        // TODO (7): Execute the AsyncTask and enjoy the show
        myAsyncTask goog = new myAsyncTask();
        goog.execute();
    }

    // TODO (6): Create an AsyncTask class that fetches list of users and then fill the text views with user data (for ids 1, 5 and 7). Use getStringFromUser method
    class myAsyncTask extends AsyncTask<Void, Void, List<User>>{
        @Override
        protected void onPostExecute(List<User> users) {
            mTextViewUserWithId1.setText(getStringFromUser(users.get(0)));
            mTextViewUserWithId5.setText(getStringFromUser(users.get(5)));
            mTextViewUserWithId7.setText(getStringFromUser(users.get(7)));
        }

        @Override
        protected List<User> doInBackground(Void... voids) {
            try {
                return JsonUtils.getUsers();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static String getStringFromUser(User user) {

        return  user.getId() + "\n"
                + user.getEmail() + "\n"
                + user.getName() + "\n"
                + user.getUsername();

    }

}

package com.example.luai.myapplication.utils;

import com.example.luai.myapplication.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static List<User> getUsers() throws IOException, JSONException {
        String strURL = "https://jsonplaceholder.typicode.com/users";
        // TODO (1): Get response data from API
        URL url = new URL(strURL);
        String data = NetworkUtils.getResponseFromHttpUrl(url);
        // TODO (2): Make a JSON array from the response data
        JSONArray users = new JSONArray(data);
        // TODO (3): Create an array of User (return value)
        List<User> list = new ArrayList<>();
        // TODO (4): Go through the JSON array and fill the users array with id, name, username and email.
        if (users.length()>0) {
            for (int i = 0; i < users.length(); i++) {
                list.add(new User(users.getJSONObject(i).getInt("id"),
                        users.getJSONObject(i).getString("name"),
                        users.getJSONObject(i).getString("username"),
                        users.getJSONObject(i).getString("email")));
            }
            return list;
        }
        return null;

    }

}

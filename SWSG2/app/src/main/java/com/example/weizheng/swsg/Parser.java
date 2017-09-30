package com.example.weizheng.swsg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser extends AppCompatActivity {

    private final String jsonTAG = "jsonTAG";
    private Bundle data;
    private String jsonStrings;
    private JSONObject rootJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser);

        data = getIntent().getExtras();
        jsonStrings = data.getString("jsonStrings");
        Log.i(jsonTAG, jsonStrings); //ensure that data has been correctly received
        try {
            rootJSON = new JSONObject(jsonStrings);
        } catch (JSONException e) {
            Log.i(jsonTAG, e.getMessage());
        }
    }

    public void parseClick(View view) {

        try{
            JSONArray resultsJSON = rootJSON.getJSONArray("result");
            JSONObject menuJSON = resultsJSON.getJSONObject(0);
            JSONArray menuElemJSON = menuJSON.getJSONArray("menu");
            Log.i(jsonTAG, "Beverages: ");
            for(int i=0;i<menuElemJSON.length();i++){
                if(menuElemJSON.getJSONObject(i).getBoolean("isBvg")){
                    Log.i(jsonTAG, menuElemJSON.getJSONObject(i).getString("name"));
                    //load this string into the textview under beverage
                }

            } // do the same for other categories

        } catch(JSONException e) {
            Log.i(jsonTAG, e.getMessage());
        }

    }
}

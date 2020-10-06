package com.example.harrypotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.harrypotter.adapter.AdapterCharacter;
import com.example.harrypotter.model.Character;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ContenidoActivity extends AppCompatActivity {

    private static final String URL="http://hp-api.herokuapp.com/api/characters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        processHttp();
    }

    public void processHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO",data);
                processCharacter(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void processCharacter(String data) {
        try {
            JSONArray root = new JSONArray(data);

            List<Character> list = new ArrayList<>();

            for(int i = 0; i<root.length();i++) {
                JSONObject character = root.getJSONObject(i);

                String name = character.getString("name");
                String species = character.getString("species");
                String gender = character.getString("gender");
                String house = character.getString("house");
                String dateOfBirth = character.getString("dateOfBirth");
                String patronus = character.getString("patronus");
                String hogwartsStudent = character.getString("hogwartsStudent");
                String actor = character.getString("actor");
                String alive = character.getString("alive");
                String image = character.getString("image");

                Character charac = new Character(name, species, gender, house, dateOfBirth, patronus, hogwartsStudent, actor, alive, image);
                list.add(charac);
            }


            RecyclerView rc = findViewById(R.id.rc_character);
            AdapterCharacter ac = new AdapterCharacter(this,list,R.layout.item_character);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ac);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
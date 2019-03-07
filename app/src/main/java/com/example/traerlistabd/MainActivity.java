package com.example.traerlistabd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.traerlistabd.adapters.AdaptadorPersonas;
import com.example.traerlistabd.models.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;




public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ListView listView;
    Button btn;
    TextView id, vnom;
    EditText edt;
    String URL = "http://nuevo.rnrsiilge-org.mx/ListaNombre";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start).setOnClickListener(this);
        listView = findViewById(R.id.list);
        id = findViewById(R.id.age);
        vnom = findViewById(R.id.nom);
    }

    @Override
    public void onClick(View v)
    {
        JsonArrayRequest jsonArray = new JsonArrayRequest
                (
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        Type PersonaList = new TypeToken<List<Persona>>(){}.getType();

                        List<Persona> personas = new Gson().fromJson(response.toString(), PersonaList);

                        listView.setAdapter
                                (
                                new AdaptadorPersonas(getApplicationContext(), personas)
                                );
                        Toast.makeText(getApplicationContext(),"DATOS EXTRAIDOS CORRECTAMENTE",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"NACHOS",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        VolleyS.getInstance(getApplicationContext()).getRequestQueue().add(jsonArray);

    }

}

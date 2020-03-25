package CA2.app.dogfostering;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String SERVICE_URI = "https://fosterdogapi.azurewebsites.net/api/dogs";
    private String TAG = "helloworldvolleyclient";
    private List<Dogs> dogsList;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // Button but = findViewById(R.id.callServiceButton);
        //   FloatingActionButton fab = findViewById(R.id.fab);


        dogsList = new ArrayList<>();
        list = (ListView) findViewById(R.id.list_view);

        //but.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //   public void onClick(View view) {
        //    callService(view);

    // });
        try

    {
        // make a string request (JSON request an alternative)
        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d(TAG, "Making request");
        try {
            StringRequest strObjRequest = new StringRequest(Request.Method.GET, SERVICE_URI,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // parse resulting string containing JSON to Greeting object
                            Dogs[] dogs = new Gson().fromJson(response, Dogs[].class);
                            for (int i = 0; i < dogs.length; i++) {
                                dogsList.add(dogs[i]);
                                DogsAdapter adapt = new DogsAdapter(MainActivity.this, dogsList);
                                list.setAdapter(adapt);
                            }


                            Log.d(TAG, "Displaying data" + dogs.toString());
                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.d(TAG, "Error" + error.toString());
                        }
                    });
            queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
        } catch (Exception e1) {
            Log.d(TAG, e1.toString());

        }
    }
        catch(
    Exception e2)

    {
        Log.d(TAG, e2.toString());

    }

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

    // call RESTful service using volley and display results
    public void callService(View v)
    {
        // get TextView for displaying result


        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
                StringRequest strObjRequest = new StringRequest(Request.Method.GET, SERVICE_URI,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                                Dogs[] dogs = new Gson().fromJson(response, Dogs[].class);
                                    for(int i=0;i<dogs.length;i++){
                                        dogsList.add(dogs[i]);
                                        DogsAdapter adapt = new DogsAdapter(MainActivity.this,dogsList);
                                        list.setAdapter(adapt);
                            }


                                Log.d(TAG, "Displaying data" + dogs.toString());
                            }

                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {

                                Log.d(TAG, "Error" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());

            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());

        }
    }

}

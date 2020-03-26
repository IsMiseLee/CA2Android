package CA2.app.dogfostering;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);


        String id  = getIntent().getExtras().getString("Dog ID");
        String name = getIntent().getExtras().getString("Dog Name");
        String breed = getIntent().getExtras().getString("Dog breed") ;
        double age = getIntent().getExtras().getDouble("Dog age");
        String information = getIntent().getExtras().getString("Dog information") ;
        String image_url = getIntent().getExtras().getString("Dog Url") ;
        Boolean isAdopted = getIntent().getExtras().getBoolean("Dog isAdopted") ;


        TextView tid = (TextView) findViewById(R.id.aId);
        TextView tname = (TextView) findViewById(R.id.aname);
        TextView tbreed = (TextView) findViewById(R.id.abreed);
        TextView tage = (TextView)findViewById(R.id.aage);
        TextView tinfo = (TextView) findViewById(R.id.ainfo);
        ImageView timage = (ImageView) findViewById(R.id.adogURL);
        TextView tadoption = (TextView)findViewById(R.id.aadoption);

        // setting values to each view

        tid.setText(id);
        tname.setText(name);
        tbreed.setText(breed);
        String numberStr = Double.toString(age);
        tage.setText("Dogs Age : "+numberStr);
        tinfo.setText(information);

        if(isAdopted){
            tadoption.setText("Dog Adopted");
        }else{
            tadoption.setText("Not Adopted");
        }


        Glide.with(DogActivity.this).load(image_url).into(timage);


    }
}

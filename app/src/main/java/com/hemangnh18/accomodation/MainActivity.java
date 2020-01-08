package com.hemangnh18.accomodation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hemangnh18.accomodation.POJO.EventsList;
import com.hemangnh18.accomodation.POJO.Methods;
import com.hemangnh18.accomodation.POJO.Participant;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button register_button;
    TextView name,email,phone,institute,id,city;
    String days="";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    Participant participant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.fullname_p);
        email = findViewById(R.id.email_p);
        phone = findViewById(R.id.phone_p);
        institute = findViewById(R.id.institute_p);
        id = findViewById(R.id.collegeid_p);
        city = findViewById(R.id.city_p);

        spinner= findViewById(R.id.spinner);
        register_button = findViewById(R.id.register_btn);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice, EventsList.EventsName));


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position==0){
            register_button.setClickable(false);
        }else {
            register_button.setClickable(true);
            days = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void Register(View view)
    {

            if(validate())
            {
                Methods.AddToDatabase(participant,this);
            }

    }

    boolean validate()
    {
            if(name.getText().toString().equals(""))
            {
                name.setError("Enter Name");
                name.requestFocus();
                return false;
            }

            if(email.getText().toString().equals(""))
            {
                email.setError("Enter Email");
                email.requestFocus();
                return false;
            }
            else
            {
                if(!email.getText().toString().matches(emailPattern))
                {
                    email.setError("Enter Email Properly");
                    email.requestFocus();
                    return false;
                }
            }


            if(phone.getText().toString().equals(""))
            {
                phone.setError("Enter Phone");
                phone.requestFocus();
                return false;
            }
            else
            {
                if(!android.util.Patterns.PHONE.matcher(phone.getText().toString()).matches() || phone.getText().toString().length()!=10)
                {
                    phone.setError("Enter Phone Properly");
                    phone.requestFocus();
                    return false;
                }
            }


        if(institute.getText().toString().equals(""))
            {
                institute.setError("Enter Institute Name");
                institute.requestFocus();
                return false;
            }

            if(id.getText().toString().equals(""))
            {
                id.setError("Enter Your College Id");
                id.requestFocus();
                return false;
            }

            if(city.getText().toString().equals(""))
            {
                city.setError("Enter City Name");
                city.requestFocus();
                return false;
            }

            participant = new Participant(name.getText().toString(),email.getText().toString(),institute.getText().toString(),id.getText().toString(),phone.getText().toString(),days,city.getText().toString());
            return  true;
    }
}

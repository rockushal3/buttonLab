package com.example.buttonlab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buttonlab.module.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class table extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    Spinner country;
    EditText name, dob, phone, email;
    RadioGroup gender;
    Button submit,click;
    RadioButton male, female, other;
    String[] countr = {"Nepal", "India", "Srilanka", "Bhutan", "Maldives", "Pakistan", "Afganistan"};
    String uname, udob, uphone, uemail, ugender, ucountry;
    CalendarView calendarView;
    List<User> userList = new ArrayList<>();
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener mydatepicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR,i);
            calendar.set(Calendar.MONTH,i1);
            calendar.set(Calendar.DAY_OF_MONTH,i2);
            String mydateFormat = "dd-MM-y";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mydateFormat, Locale.getDefault());
            dob.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        country = findViewById(R.id.Spinner);
        name = findViewById(R.id.Name);
        dob = findViewById(R.id.DoB);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.Email);
        gender = findViewById(R.id.RG);
        male = findViewById(R.id.RBMale);
        female = findViewById(R.id.RBFemale);
        other = findViewById(R.id.RBOther);
        submit = findViewById(R.id.btnSubmit);
        click = findViewById(R.id.click);
//        calendarView = findViewById(R.id.calenderView);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.countryname, countr);
        country.setAdapter(adapter);
        gender.setOnCheckedChangeListener(this);
        submit.setOnClickListener(this);
        dob.setOnClickListener(this);
        click.setOnClickListener(this);

//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//                Toast.makeText(table.this, String.valueOf(i) +
//                        "-"+ String.valueOf(i1)+
//                        "-"+String.valueOf(i2), Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.RBMale) {
            ugender = "Male";
            Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.RBFemale) {
            ugender = "Female";
            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.RBOther) {
            ugender = "Other";
            Toast.makeText(this, "Others", Toast.LENGTH_SHORT).show();
        }
    }

    private void setaValue() {
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ucountry = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        uname = name.getText().toString();
        uemail = email.getText().toString();
        udob = dob.getText().toString();
        uphone = phone.getText().toString();
        if (validate()) {
            if(view.getId() == R.id.btnSubmit){
                Toast.makeText(this, "ALL OK", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.getId() == R.id.DoB){
            new DatePickerDialog(this,mydatepicker,
                    calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

        }
        if (view.getId() == R.id.click){
            Intent intent = new Intent(table.this,listdata.class);
            intent.putExtra("allusers",(Serializable) userList);
            startActivity(intent);
        }
    }



    private boolean validate() {
        if (TextUtils.isEmpty(uname)) {
            name.setError("Enter Name");
            return false;

        }
        if (TextUtils.isEmpty(uemail)) {
            email.setError("Enter Email");
            return false;

        }

        if (TextUtils.isEmpty(udob)) {
            dob.setError("Enter DOB");
            return false;

        }
        if (TextUtils.isEmpty(uphone)) {
            phone.setError("Enter Phone");
            return false;

        }
        if(!TextUtils.isDigitsOnly(uphone)){
            phone.setError("Invalid Phone");
            return false;

        }
        if(TextUtils.isEmpty(ugender)){
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(uemail).matches()){
            email.setError("Invalid Email");
            return false;
        }

            return true;


    }
}


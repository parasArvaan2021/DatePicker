package com.mil.en2fr.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txt_current_date,txt_current_time,txt_show_value;
    int year,day,month,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_current_date=findViewById(R.id.txt_date_picker);
        txt_current_time=findViewById(R.id.txt_time_picker);
        txt_show_value=findViewById(R.id.show_value);

        txt_current_time.setOnClickListener(this);
        txt_current_date.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v==txt_current_date){
            Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH);
            day=c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                txt_show_value.setText(dayOfMonth+"/"+month+"/"+year);
                }
            },year,month,day);
            datePickerDialog.show();
        }
        if (v==txt_current_time){
            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            min = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    txt_show_value.setText(hourOfDay+":"+minute);
                }
            },hour,min,false);
            timePickerDialog.show();
        }

    }
}
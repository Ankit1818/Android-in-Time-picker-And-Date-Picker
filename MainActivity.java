package com.example.dateandtimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected static TextView displayCurrentTime;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCurrentTime = (TextView)findViewById(R.id.selected_time);
        Button displayTimeButton = (Button)findViewById(R.id.btn2);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Datepicker.class);
                startActivity(i);
            }
        });
        assert displayTimeButton != null;
        displayTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker mTimePicker = new TimePicker();
                mTimePicker.show(getSupportFragmentManager(), "Select time");
            }
        });
    }
    public static class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }
        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            displayCurrentTime.setText("Selected Time: " + String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
        }

    }
}
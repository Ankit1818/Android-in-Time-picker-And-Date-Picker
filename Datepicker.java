package com.example.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Datepicker extends AppCompatActivity {
    protected static TextView displayCurrentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCurrentTime = (TextView)findViewById(R.id.time2);
        Button displayTimeButton=(Button)findViewById(R.id.time);

        EditText editText;


        assert displayTimeButton != null;
        displayTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment mDatePicker = new DatePickerFragment();
                mDatePicker.show(getSupportFragmentManager(), "Select date");
            }
        });
    }
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            displayCurrentTime.setText("Selected date: " + String.valueOf(year) + " - " + String.valueOf(month) + " - " + String.valueOf(day));
        }


    }
}
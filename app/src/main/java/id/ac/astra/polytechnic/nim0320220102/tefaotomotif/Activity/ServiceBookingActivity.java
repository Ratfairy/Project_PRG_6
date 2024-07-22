package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import id.ac.astra.polytechnic.nim0320220102.tefaotomotif.R;

public class ServiceBookingActivity extends AppCompatActivity {
    private EditText txtScheduleDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_booking);

        txtScheduleDate = findViewById(R.id.txtScheduleDate);

        // Handle date picker for txtScheduleDate
        txtScheduleDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceBookingActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        txtScheduleDate.setText(selectedDate);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void startDashboardServiceActivity(View view) {
        Intent intent = new Intent(this, DashboardServiceActivity.class);
        startActivity(intent);
    }
}

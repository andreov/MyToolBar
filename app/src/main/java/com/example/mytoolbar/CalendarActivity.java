package com.example.mytoolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {
    private CalendarView mCalendarStart;
    private CalendarView mCalendarEnd;
    private Button mbtnStart;
    private Button mbtnEnd;
    private Button mbtnOk;
    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initViews();
        clickBtnStart();
        clickBtnEnd();
        cliclDateStart();
        clickDateEnd();
        outInfoToast();
    }
    private void initViews() {
        mCalendarStart = findViewById(R.id.calendarStart);
        mCalendarEnd = findViewById(R.id.calendarEnd);
        mbtnStart = findViewById(R.id.btnStart);
        mbtnEnd = findViewById(R.id.btnEnd);
        mbtnOk = findViewById(R.id.btnOk);
        mCalendarStart.setVisibility(View.GONE);
        mCalendarEnd.setVisibility(View.GONE);

    }
    private void clickBtnStart(){
        mbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarStart.setVisibility(View.VISIBLE);
                mCalendarEnd.setVisibility(View.GONE);
            }
        });

    }
    private void clickBtnEnd(){
        mbtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarEnd.setVisibility(View.VISIBLE);
                mCalendarStart.setVisibility(View.GONE);
            }
        });

    }
    private void cliclDateStart(){
        mCalendarStart.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i2+"-"+i1+"-"+i;
                mbtnStart.setText("Дата старта задачи: " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

    }
    private void clickDateEnd(){
        mCalendarEnd.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i2+"-"+i1+"-"+i;
                mbtnEnd.setText("Дата окончания задачи: " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

    }
    private void outInfoToast(){
        mbtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStartDate > mEndDate || mStartDateTxt == null || mEndDateTxt == null){
                    Toast.makeText(CalendarActivity.this, "Ошибка ввода дат старта и окончания задачи", Toast.LENGTH_LONG).show();
                    mbtnStart.setText("Дата старта задачи:");
                    mbtnEnd.setText("Дата окончания задачи:");
                } else {
                    Toast.makeText(CalendarActivity.this, "Старт задачи: " + mStartDateTxt +"\n" + "Окончаниe задачи: " + mEndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
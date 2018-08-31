package in.dileep.spteam.dlpam;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    TextView tv1,tv2,tv3,tv4,tv5;
    private static MainActivity inst;
    CheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8;
    Spinner sp1,sp2,sp3,sp4;
    Button b1;
    int a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsOnSpinner2();
       // addItemsOnSpinner3();
        b1=(Button) findViewById(R.id.b1);
        ch1=(CheckBox) findViewById(R.id.checkBox1);
        ch2=(CheckBox) findViewById(R.id.checkBox2);
        ch3=(CheckBox) findViewById(R.id.checkBox3);
        ch4=(CheckBox) findViewById(R.id.checkBox4);
        ch5=(CheckBox) findViewById(R.id.checkBox5);
        ch6=(CheckBox) findViewById(R.id.checkBox6);
        ch7=(CheckBox) findViewById(R.id.checkBox7);
        ch8=(CheckBox) findViewById(R.id.checkBox8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ch1.isChecked()){
                    a=8;
                    b=40;
                }
                if(ch2.isChecked()){
                    a=9;
                    b=40;
                }
                if(ch3.isChecked()){
                    a=10;
                    b=30;
                }
                if(ch4.isChecked()){
                    a=11;
                    b=20;
                }
                if(ch5.isChecked()){
                    a=14;
                    b=30;
                }
                if(ch6.isChecked()){
                    a=14;
                    b=40;
                }
                if(ch7.isChecked()){
                    a=15;
                    b=15;
                }
                if(ch8.isChecked()){
                    a=16;
                    b=50;
                }
                GettingValues();
            }
        });
    }
    public void addItemsOnSpinner2() {

        sp1 = (Spinner) findViewById(R.id.sp1);
        List<String> list = new ArrayList<String>();
        list.add("First Year");
        list.add("Second Year");
        list.add("Third Year");
        list.add("Fourth Year");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(dataAdapter);


       sp2 = (Spinner) findViewById(R.id.sp2);
        List<String> list1 = new ArrayList<String>();
        list1.add("CSE-A");
        list1.add("CSE-B");
        list1.add("ECE-A");
        list1.add("ECE-B");
        list1.add("EEE-A");
        list1.add("EEE-B");
        list1.add("CIVIL-A");
        list1.add("CIVIL-B");
        list1.add("MECH-A");
        list1.add("MECH-B");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(dataAdapter1);

        sp3 = (Spinner) findViewById(R.id.sp3);
        List<String> list2 = new ArrayList<String>();
        list2.add("Before 10 min");
        list2.add("Before 5 min");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(dataAdapter2);
    }
    public void GettingValues(){
        String str=sp3.getSelectedItem().toString();
        Integer firstNumber = Integer.parseInt(str.replaceFirst(".*?(\\d+).*", "$1"));
        Toast.makeText(MainActivity.this,firstNumber.toString()+a,Toast.LENGTH_LONG).show();
        int Number=(int)firstNumber;
        //int time = Integer.parseInt(etVal.getText().toString());
        //Toast.makeText(getApplicationContext(),"Alarm set in "+time+"seconds",Toast.LENGTH_LONG).show();



        alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, Alarmdil.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, a);
        calendar.set(Calendar.MINUTE, b-Number);

      alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),1000 * 60 * 20, alarmIntent);
        Toast.makeText(getApplicationContext(),"Alarm set in seconds",Toast.LENGTH_LONG).show();


        //alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),1000 * 60 * 20, alarmIntent);


    }

}

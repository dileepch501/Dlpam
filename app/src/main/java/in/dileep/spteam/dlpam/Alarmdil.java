package in.dileep.spteam.dlpam;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by spteam on 4/5/2018.
 */

public class Alarmdil extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context,"Alarm.working......",Toast.LENGTH_LONG).show();
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();
        try {
            Thread.sleep(20000);
            r.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

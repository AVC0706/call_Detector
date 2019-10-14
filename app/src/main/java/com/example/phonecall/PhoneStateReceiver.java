
package com.example.phonecall;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


/**
 * Created by theappguruz on 07/05/16.
 */
public class PhoneStateReceiver extends BroadcastReceiver {

    private static final String SMS_SENT_INTENT_FILTER = "com.phoneCall.sms_send";
    private static final String SMS_DELIVERED_INTENT_FILTER = "com.phoneCall.sms_delivered";
    @Override
    public void onReceive(Context context, Intent intent) {


        try {
            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context,"Incoming Call State",Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"Ringing State Number is -" + incomingNumber , Toast.LENGTH_SHORT).show();



                String message = " I'm driving at this moment , will call you later . ";

                String phnNo = incomingNumber ;//preferable use complete international number

                PendingIntent sentPI;
                sentPI = (PendingIntent) PendingIntent.getBroadcast(context, 0, new Intent(
                        SMS_SENT_INTENT_FILTER), 0);
                PendingIntent deliveredPI = (PendingIntent) PendingIntent.getBroadcast(context, 0, new Intent(
                        SMS_DELIVERED_INTENT_FILTER), 0);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phnNo, null, message, sentPI, deliveredPI);


            }
            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
                Toast.makeText(context,"Call Received State",Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context,"Call Idle State",Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }




}

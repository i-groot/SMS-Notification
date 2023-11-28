package com.zx.smsnotification.csdn;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import static android.telephony.TelephonyManager.PHONE_TYPE_CDMA;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.zx.smsnotification.R;

public class MessageReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVER_ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sBuilder = new StringBuilder();
        String format = intent.getStringExtra("format");
        if (SMS_RECEIVER_ACTION.equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            if (null != bundle) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                assert pdus != null;
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < messages.length; ++i) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                for (SmsMessage msg : messages) {
                    sBuilder.append("来自：").append(msg.getDisplayOriginatingAddress()).append("\n").append("短信内容：");
                    sBuilder.append(msg.getDisplayMessageBody()).append("\n");
                }
            }
        }
        Toast.makeText(context, "您收到了一条短信!!\n" + sBuilder.toString(), Toast.LENGTH_LONG).show();
    }

    private void sendNotification(int notificationId, String title, String content) {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
////                .setSmallIcon(R.drawable.ic_notification)
//                .setContentTitle(title)
//                .setContentText(content)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(notificationId, builder.build());
    }
}


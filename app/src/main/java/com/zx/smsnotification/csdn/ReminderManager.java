package com.zx.smsnotification.csdn;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.zx.smsnotification.R;

public class ReminderManager {
    private static final int NOTIFICATION_ID = 1;
    private static final int MUSIC_ID = 2;
    private static final int TIMER_ID = 3;

    public void showNotification(int notificationId, String title, String content) {
//        // 显示通知消息
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
//                .setSmallIcon(R.drawable.ic_notification)
//                .setContentTitle(title)
//                .setContentText(content)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(notificationId, builder.build());
    }

    public void playMusic() {
        // 播放指定的音乐
    }

    public void setTimer(int seconds) {
        // 设置定时器
    }
}


package com.sobot.chat.camera.util;

import android.content.Context;
import android.media.AudioManager;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/AudioUtil.class */
public class AudioUtil {
    public static String getReadableDurationString(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j2 % 60;
        if (j3 < 60) {
            return String.format(Locale.getDefault(), "%01d:%02d", Long.valueOf(j3), Long.valueOf(j4));
        }
        return String.format(Locale.getDefault(), "%d:%02d:%02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60), Long.valueOf(j4));
    }

    public static void setAudioManage(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.setStreamMute(1, true);
        audioManager.setStreamMute(3, true);
        audioManager.setStreamVolume(4, 0, 0);
        audioManager.setStreamVolume(8, 0, 0);
        audioManager.setStreamVolume(5, 0, 0);
        audioManager.setStreamVolume(2, 0, 0);
    }
}

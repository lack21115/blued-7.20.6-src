package com.sobot.chat.utils;

import android.media.MediaPlayer;
import android.media.MediaRecorder;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/AudioTools.class */
public class AudioTools {
    private static MediaPlayer instance;
    private static MediaRecorder mediaRecorder;

    public static void destory() {
        stop();
        instance = null;
    }

    public static MediaPlayer getInstance() {
        if (instance == null) {
            instance = new MediaPlayer();
        }
        return instance;
    }

    public static boolean getIsPlaying() {
        if (instance != null) {
            return getInstance().isPlaying();
        }
        return false;
    }

    public static MediaRecorder getMediaRecorder() {
        if (mediaRecorder == null) {
            mediaRecorder = new MediaRecorder();
        }
        return mediaRecorder;
    }

    public static void stop() {
        if (instance == null || !getInstance().isPlaying()) {
            return;
        }
        getInstance().stop();
    }
}

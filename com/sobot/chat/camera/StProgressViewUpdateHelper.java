package com.sobot.chat.camera;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StProgressViewUpdateHelper.class */
public class StProgressViewUpdateHelper extends Handler {
    private static final int CMD_REFRESH_PROGRESS_VIEWS = 1;
    private static final int MIN_INTERVAL = 20;
    private static final int UPDATE_INTERVAL_PAUSED = 500;
    private static final int UPDATE_INTERVAL_PLAYING = 1000;
    private Callback callback;
    private int intervalPaused;
    private int intervalPlaying;
    private Context mContext;
    private MediaPlayer mMediaPlayer;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/StProgressViewUpdateHelper$Callback.class */
    public interface Callback {
        void onUpdateProgressViews(int i, int i2);
    }

    public StProgressViewUpdateHelper(MediaPlayer mediaPlayer, Context context, Callback callback) {
        super(Looper.getMainLooper());
        this.mContext = context;
        this.mMediaPlayer = mediaPlayer;
        this.callback = callback;
        this.intervalPlaying = 1000;
        this.intervalPaused = 500;
    }

    public StProgressViewUpdateHelper(MediaPlayer mediaPlayer, Callback callback, int i, int i2) {
        super(Looper.getMainLooper());
        this.callback = callback;
        this.mMediaPlayer = mediaPlayer;
        this.intervalPlaying = i;
        this.intervalPaused = i2;
    }

    private void queueNextRefresh(long j) {
        Message obtainMessage = obtainMessage(1);
        removeMessages(1);
        sendMessageDelayed(obtainMessage, j);
    }

    private int refreshProgressViews() {
        try {
            int currentPosition = this.mMediaPlayer.getCurrentPosition();
            this.callback.onUpdateProgressViews(currentPosition, this.mMediaPlayer.getDuration());
            if (this.mMediaPlayer.isPlaying()) {
                int i = this.intervalPlaying;
                return Math.max(20, i - (currentPosition % i));
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int refreshProgressViews;
        super.handleMessage(message);
        if (message.what != 1 || (refreshProgressViews = refreshProgressViews()) == -1) {
            return;
        }
        queueNextRefresh(refreshProgressViews);
    }

    public void start() {
        queueNextRefresh(1L);
    }

    public void stop() {
        removeMessages(1);
    }
}

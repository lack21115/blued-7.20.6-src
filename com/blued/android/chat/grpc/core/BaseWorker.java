package com.blued.android.chat.grpc.core;

import com.blued.android.chat.grpc.utils.ChatLog;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/core/BaseWorker.class */
public class BaseWorker {
    private static final int PAUSE = 1;
    private static final int STOP = 0;
    private static final String TAG = "Chat_Worker";
    private static final int WORK = 2;
    private int state = 0;

    private int changeState(int i) {
        ChatLog.v(TAG, getWorkerName() + " state changed from " + this.state + " to " + i);
        int i2 = this.state;
        this.state = i;
        return i2;
    }

    public int getState() {
        return this.state;
    }

    protected String getWorkerName() {
        return "worker-" + getClass().getSimpleName();
    }

    public boolean isWorking() {
        return this.state == 2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void pause() {
        ChatLog.v(TAG, getWorkerName() + " pause()");
        if (this.state == 2) {
            changeState(1);
            onPause();
        }
    }

    public void resume() {
        ChatLog.v(TAG, getWorkerName() + " resume()");
        if (this.state == 1) {
            changeState(2);
            onResume();
        }
    }

    public void start() {
        ChatLog.v(TAG, getWorkerName() + " start()");
        int changeState = changeState(2);
        if (changeState == 0) {
            onStart();
            onResume();
        } else if (changeState == 1) {
            onResume();
        }
    }

    public void stop() {
        ChatLog.v(TAG, getWorkerName() + " stop()");
        int changeState = changeState(0);
        if (changeState == 2) {
            onPause();
            onStop();
        } else if (changeState == 1) {
            onStop();
        }
    }
}

package com.blued.android.chat.core.worker;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/BaseWorker.class */
public class BaseWorker {
    private static final int PAUSE = 1;
    private static final int STOP = 0;
    private static final String TAG = "Chat_Worker";
    private static final int WORK = 2;
    private int state = 0;

    private int changeState(int i) {
        if (ChatManager.debug) {
            Log.v(TAG, getWorkerName() + " state changed from " + this.state + " to " + i);
        }
        int i2 = this.state;
        this.state = i;
        return i2;
    }

    public int getState() {
        return this.state;
    }

    protected String getWorkerName() {
        return "worker";
    }

    public boolean isWorking() {
        return this.state == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    public void pause() {
        if (ChatManager.debug) {
            Log.v(TAG, getWorkerName() + " pause()");
        }
        if (this.state == 2) {
            changeState(1);
            onPause();
        }
    }

    public void resume() {
        if (ChatManager.debug) {
            Log.v(TAG, getWorkerName() + " resume()");
        }
        if (this.state == 1) {
            changeState(2);
            onResume();
        }
    }

    public void start() {
        if (ChatManager.debug) {
            Log.v(TAG, getWorkerName() + " start()");
        }
        int changeState = changeState(2);
        if (changeState == 0) {
            onStart();
            onResume();
        } else if (changeState == 1) {
            onResume();
        }
    }

    public void stop() {
        if (ChatManager.debug) {
            Log.v(TAG, getWorkerName() + " stop()");
        }
        int changeState = changeState(0);
        if (changeState == 2) {
            onPause();
            onStop();
        } else if (changeState == 1) {
            onStop();
        }
    }
}

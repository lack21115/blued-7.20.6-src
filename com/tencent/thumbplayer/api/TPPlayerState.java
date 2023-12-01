package com.tencent.thumbplayer.api;

import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.bw;
import com.tencent.thumbplayer.adapter.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerState.class */
public class TPPlayerState {
    public static final int COMPLETE = 7;
    public static final int ERROR = 10;
    public static final int IDLE = 1;
    public static final int INDEX = 0;
    public static final int INITIALIZED = 2;
    private static final SparseArray<String> NS_STATES;
    public static final int PAUSE = 6;
    public static final int PREPARED = 4;
    public static final int PREPARING = 3;
    public static final int RELEASED = 11;
    public static final int START = 5;
    public static final int STOPPED = 9;
    public static final int STOPPING = 8;
    private c.k mStateChangeListener;
    private int mCurState = 1;
    private int mPreState = 1;
    private int mLastState = 1;
    private int mInnerPlayState = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerState$STATE.class */
    public @interface STATE {
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        NS_STATES = sparseArray;
        sparseArray.put(1, "IDLE");
        NS_STATES.put(2, "INITIALIZED");
        NS_STATES.put(3, "PREPARING");
        NS_STATES.put(4, "PREPARED");
        NS_STATES.put(5, "START");
        NS_STATES.put(6, "PAUSE");
        NS_STATES.put(7, "COMPLETE");
        NS_STATES.put(8, "STOPPING");
        NS_STATES.put(9, "STOPPED");
        NS_STATES.put(10, bw.l);
        NS_STATES.put(11, "RELEASED");
    }

    public void changeState(int i) {
        synchronized (this) {
            if (this.mCurState != i) {
                int i2 = this.mCurState;
                this.mPreState = i2;
                this.mCurState = i;
                if (this.mStateChangeListener != null) {
                    this.mStateChangeListener.b(i2, i);
                }
            }
        }
    }

    public int innerPlayState() {
        int i;
        synchronized (this) {
            i = this.mInnerPlayState;
        }
        return i;
    }

    public boolean is(int i) {
        boolean z;
        synchronized (this) {
            z = this.mCurState == i;
        }
        return z;
    }

    public int lastState() {
        int i;
        synchronized (this) {
            i = this.mLastState;
        }
        return i;
    }

    public int preState() {
        int i;
        synchronized (this) {
            i = this.mPreState;
        }
        return i;
    }

    public void setInnerPlayStateState(int i) {
        synchronized (this) {
            if (this.mInnerPlayState != i) {
                this.mInnerPlayState = i;
            }
        }
    }

    public void setLastState(int i) {
        synchronized (this) {
            if (this.mLastState != i) {
                this.mLastState = i;
            }
        }
    }

    public void setOnPlayerStateChangeListener(c.k kVar) {
        this.mStateChangeListener = kVar;
    }

    public int state() {
        int i;
        synchronized (this) {
            i = this.mCurState;
        }
        return i;
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = "state[ cur : " + NS_STATES.get(this.mCurState) + " , pre : " + NS_STATES.get(this.mPreState) + " , last : " + NS_STATES.get(this.mLastState) + " , inner play : " + NS_STATES.get(this.mInnerPlayState) + " ]";
        }
        return str;
    }
}

package com.danlan.android.cognition.collector.base;

import android.content.Context;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/base/SubCollector.class */
public abstract class SubCollector {
    private SafeJSONObject collectJsonData;
    public Context mContext;
    private CountDownLatch mCountDownLatch;
    private boolean mIsCollectDone = false;

    public SubCollector(Context context, SafeJSONObject safeJSONObject) {
        this.mContext = context;
        this.collectJsonData = safeJSONObject;
    }

    private void startCollect() {
        doCollectAutomatically();
    }

    public void collectDone() {
        this.mIsCollectDone = true;
        CountDownLatch countDownLatch = this.mCountDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        postCollect();
    }

    public void doCollect() {
        reset();
        startCollect();
    }

    public abstract void doCollectAutomatically();

    public boolean isCollectDone() {
        return this.mIsCollectDone;
    }

    public void postCollect() {
    }

    public void put(String str, double d) {
        this.collectJsonData.put(str, d);
    }

    public void put(String str, int i) {
        this.collectJsonData.put(str, i);
    }

    public void put(String str, long j) {
        this.collectJsonData.put(str, j);
    }

    public void put(String str, Object obj) {
        this.collectJsonData.put(str, obj);
    }

    public void put(String str, boolean z) {
        this.collectJsonData.put(str, z);
    }

    public void release() {
    }

    public void reset() {
        this.mIsCollectDone = false;
    }

    public void resetCountDownLatch(CountDownLatch countDownLatch) {
        this.mCountDownLatch = countDownLatch;
    }
}

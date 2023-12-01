package com.blued.android.module.chat;

import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/StableSessionListListener.class */
public abstract class StableSessionListListener implements SessionListener {
    private static final long MIN_CALLBACK_SPAN_MS = 500;
    private UICallbackTask uiCallback = new UICallbackTask();
    private AtomicLong nextMinNotifyTime = new AtomicLong(-1);
    private AtomicLong lastNotifyTime = new AtomicLong(-1);
    private AtomicLong lastDataChangedTime = new AtomicLong(-1);
    private AtomicLong currentTime = new AtomicLong(-1);

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/StableSessionListListener$UICallbackTask.class */
    class UICallbackTask implements Runnable {
        private List<SessionModel> data;

        private UICallbackTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StableSessionListListener.this.onUISessionDataChanged(this.data);
        }

        public void setData(List<SessionModel> list) {
            this.data = list;
        }
    }

    @Override // com.blued.android.chat.listener.SessionListener
    public final void onSessionDataChanged(List<SessionModel> list, long j) {
        if (this.lastDataChangedTime.get() == j) {
            return;
        }
        this.lastDataChangedTime.set(j);
        AppInfo.n().removeCallbacks(this.uiCallback);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        this.uiCallback.setData(arrayList);
        this.currentTime.set(System.currentTimeMillis());
        if (this.currentTime.get() < this.nextMinNotifyTime.get()) {
            AppInfo.n().postDelayed(this.uiCallback, this.nextMinNotifyTime.get() - this.currentTime.get());
            this.lastNotifyTime.set(this.nextMinNotifyTime.get());
        } else if (this.currentTime.get() >= this.lastNotifyTime.get() + MIN_CALLBACK_SPAN_MS) {
            AppInfo.n().post(this.uiCallback);
            this.nextMinNotifyTime.set(this.currentTime.get() + MIN_CALLBACK_SPAN_MS);
            this.lastNotifyTime.set(this.currentTime.get());
        } else {
            AtomicLong atomicLong = this.nextMinNotifyTime;
            atomicLong.set(atomicLong.get() + MIN_CALLBACK_SPAN_MS);
            AppInfo.n().postDelayed(this.uiCallback, this.nextMinNotifyTime.get() - this.currentTime.get());
            this.lastNotifyTime.set(this.nextMinNotifyTime.get());
        }
    }

    public abstract void onUISessionDataChanged(List<SessionModel> list);

    public void reset() {
        this.nextMinNotifyTime.set(-1L);
        this.lastNotifyTime.set(-1L);
        this.lastDataChangedTime.set(-1L);
        this.currentTime.set(-1L);
    }
}

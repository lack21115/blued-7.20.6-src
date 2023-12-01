package com.ss.android.downloadlib.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/je.class */
public class je extends Handler {
    WeakReference<mb> mb;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/je$mb.class */
    public interface mb {
        void mb(Message message);
    }

    public je(Looper looper, mb mbVar) {
        super(looper);
        this.mb = new WeakReference<>(mbVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        mb mbVar = this.mb.get();
        if (mbVar == null || message == null) {
            return;
        }
        mbVar.mb(message);
    }
}

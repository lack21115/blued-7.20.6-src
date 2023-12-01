package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/e.class */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f9236a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/e$a.class */
    public interface a {
        void a(Message message);
    }

    public e(a aVar) {
        this.f9236a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f9236a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}

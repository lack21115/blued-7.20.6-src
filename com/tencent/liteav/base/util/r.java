package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/r.class */
public final class r extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private int f22654a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final a f22655c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/r$a.class */
    public interface a {
        void a_();
    }

    public r(Looper looper, a aVar) {
        super(looper);
        this.b = false;
        this.f22655c = aVar;
    }

    public final void a() {
        while (hasMessages(0)) {
            removeMessages(0);
        }
        this.b = false;
    }

    public final void a(int i, int i2) {
        a();
        this.f22654a = i2;
        this.b = true;
        sendEmptyMessageDelayed(0, i);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.b) {
            removeMessages(0);
            sendEmptyMessageDelayed(0, this.f22654a);
        }
        a aVar = this.f22655c;
        if (aVar != null) {
            aVar.a_();
        }
    }
}

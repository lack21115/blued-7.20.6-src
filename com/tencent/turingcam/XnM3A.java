package com.tencent.turingcam;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/XnM3A.class */
public class XnM3A {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, spXPg> f26127a = new ConcurrentHashMap();
    private HandlerThread b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/XnM3A$spXPg.class */
    class spXPg extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final CvowV f26128a;

        spXPg(XnM3A xnM3A, HandlerThread handlerThread, CvowV cvowV) {
            super(handlerThread.getLooper());
            this.f26128a = cvowV;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.f26128a.a(message);
            } catch (Throwable th) {
                this.f26128a.a(th);
            }
        }
    }

    public XnM3A() {
        HandlerThread handlerThread = new HandlerThread("MFA-ASYNC-WORKER");
        this.b = handlerThread;
        handlerThread.setPriority(10);
        this.b.start();
        new Handler(this.b.getLooper());
    }

    public String a(CvowV cvowV) {
        String uuid = UUID.randomUUID().toString();
        HandlerThread handlerThread = new HandlerThread("MFA-ASYNC-WORKER-" + uuid);
        handlerThread.start();
        this.f26127a.put(uuid, new spXPg(this, handlerThread, cvowV));
        return uuid;
    }

    public void a(String str, int i) {
        spXPg spxpg = this.f26127a.get(str);
        if (spxpg != null) {
            spxpg.removeMessages(i);
        }
    }

    public void a(String str, int i, long j) {
        spXPg spxpg = this.f26127a.get(str);
        if (spxpg != null) {
            spxpg.sendEmptyMessageDelayed(i, j);
        }
    }

    public void a(String str, Message message) {
        spXPg spxpg = this.f26127a.get(str);
        if (spxpg != null) {
            spxpg.sendMessageDelayed(message, 0L);
        }
    }
}

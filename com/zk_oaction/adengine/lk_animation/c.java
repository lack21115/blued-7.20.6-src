package com.zk_oaction.adengine.lk_animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f41886a;
    private ArrayList<b> b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Handler f41887c = new a(Looper.getMainLooper());

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/c$a.class */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.this.f41886a.f) {
                removeMessages(0);
                return;
            }
            Iterator it = c.this.b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).g();
            }
            sendEmptyMessageDelayed(0, c.this.f41886a.u - 3);
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f41886a = cVar;
    }

    public void a() {
        this.b.clear();
        this.f41887c.removeMessages(0);
    }

    public void a(b bVar) {
        this.b.add(bVar);
    }

    public void b() {
        if (this.b.size() > 0) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
            this.f41887c.sendEmptyMessageDelayed(0, this.f41886a.u);
        }
    }

    public void c() {
        this.f41887c.removeMessages(0);
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}

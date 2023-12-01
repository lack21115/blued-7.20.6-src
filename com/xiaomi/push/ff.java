package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bj;
import com.xiaomi.push.ji;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ff.class */
public class ff {

    /* renamed from: a  reason: collision with root package name */
    private int f27712a;

    /* renamed from: a  reason: collision with other field name */
    private long f394a;

    /* renamed from: a  reason: collision with other field name */
    private fe f396a;

    /* renamed from: a  reason: collision with other field name */
    private String f397a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f398a = false;

    /* renamed from: a  reason: collision with other field name */
    private bj f395a = bj.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ff$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final ff f27713a = new ff();
    }

    private ey a(bj.a aVar) {
        if (aVar.f173a == 0) {
            if (aVar.f174a instanceof ey) {
                return (ey) aVar.f174a;
            }
            return null;
        }
        ey m8699a = m8699a();
        m8699a.a(ex.CHANNEL_STATS_COUNTER.a());
        m8699a.c(aVar.f173a);
        m8699a.c(aVar.f175a);
        return m8699a;
    }

    private ez a(int i) {
        ArrayList arrayList = new ArrayList();
        ez ezVar = new ez(this.f397a, arrayList);
        if (!bh.e(this.f396a.f391a)) {
            ezVar.a(i.i(this.f396a.f391a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            ezVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<bj.a> m8493a = this.f395a.m8493a();
        while (m8493a.size() > 0) {
            try {
                ey a3 = a(m8493a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m8493a.removeLast();
            } catch (iw | NoSuchElementException e2) {
                return ezVar;
            }
        }
        return ezVar;
    }

    public static fe a() {
        fe feVar;
        synchronized (a.f27713a) {
            feVar = a.f27713a.f396a;
        }
        return feVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ff m8697a() {
        return a.f27713a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m8698a() {
        if (!this.f398a || System.currentTimeMillis() - this.f394a <= this.f27712a) {
            return;
        }
        this.f398a = false;
        this.f394a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ey m8699a() {
        ey eyVar;
        synchronized (this) {
            eyVar = new ey();
            eyVar.a(bh.m8485a((Context) this.f396a.f391a));
            eyVar.f368a = (byte) 0;
            eyVar.f372b = 1;
            eyVar.d((int) (System.currentTimeMillis() / 1000));
        }
        return eyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ez m8700a() {
        ez ezVar;
        synchronized (this) {
            ezVar = null;
            if (b()) {
                int i = 750;
                if (!bh.e(this.f396a.f391a)) {
                    i = 375;
                }
                ezVar = a(i);
            }
        }
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8701a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            int i3 = i2;
            if (i2 > 604800000) {
                i3 = 604800000;
            }
            if (this.f27712a == i3 && this.f398a) {
                return;
            }
            this.f398a = true;
            this.f394a = System.currentTimeMillis();
            this.f27712a = i3;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.f394a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ey eyVar) {
        synchronized (this) {
            this.f395a.a(eyVar);
        }
    }

    public void a(XMPushService xMPushService) {
        synchronized (this) {
            this.f396a = new fe(xMPushService);
            this.f397a = "";
            com.xiaomi.push.service.bv.a().a(new fg(this));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8702a() {
        return this.f398a;
    }

    boolean b() {
        m8698a();
        return this.f398a && this.f395a.m8492a() > 0;
    }
}

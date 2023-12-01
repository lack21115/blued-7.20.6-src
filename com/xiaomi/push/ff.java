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
    private int f41403a;

    /* renamed from: a  reason: collision with other field name */
    private long f441a;

    /* renamed from: a  reason: collision with other field name */
    private fe f443a;

    /* renamed from: a  reason: collision with other field name */
    private String f444a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f445a = false;

    /* renamed from: a  reason: collision with other field name */
    private bj f442a = bj.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ff$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final ff f41404a = new ff();
    }

    private ey a(bj.a aVar) {
        if (aVar.f220a == 0) {
            if (aVar.f221a instanceof ey) {
                return (ey) aVar.f221a;
            }
            return null;
        }
        ey m11749a = m11749a();
        m11749a.a(ex.CHANNEL_STATS_COUNTER.a());
        m11749a.c(aVar.f220a);
        m11749a.c(aVar.f222a);
        return m11749a;
    }

    private ez a(int i) {
        ArrayList arrayList = new ArrayList();
        ez ezVar = new ez(this.f444a, arrayList);
        if (!bh.e(this.f443a.f438a)) {
            ezVar.a(i.i(this.f443a.f438a));
        }
        jk jkVar = new jk(i);
        jc a2 = new ji.a().a(jkVar);
        try {
            ezVar.b(a2);
        } catch (iw e) {
        }
        LinkedList<bj.a> m11543a = this.f442a.m11543a();
        while (m11543a.size() > 0) {
            try {
                ey a3 = a(m11543a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (jkVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m11543a.removeLast();
            } catch (iw | NoSuchElementException e2) {
                return ezVar;
            }
        }
        return ezVar;
    }

    public static fe a() {
        fe feVar;
        synchronized (a.f41404a) {
            feVar = a.f41404a.f443a;
        }
        return feVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ff m11747a() {
        return a.f41404a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m11748a() {
        if (!this.f445a || System.currentTimeMillis() - this.f441a <= this.f41403a) {
            return;
        }
        this.f445a = false;
        this.f441a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ey m11749a() {
        ey eyVar;
        synchronized (this) {
            eyVar = new ey();
            eyVar.a(bh.m11535a((Context) this.f443a.f438a));
            eyVar.f415a = (byte) 0;
            eyVar.f419b = 1;
            eyVar.d((int) (System.currentTimeMillis() / 1000));
        }
        return eyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ez m11750a() {
        ez ezVar;
        synchronized (this) {
            ezVar = null;
            if (b()) {
                int i = 750;
                if (!bh.e(this.f443a.f438a)) {
                    i = 375;
                }
                ezVar = a(i);
            }
        }
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11751a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            int i3 = i2;
            if (i2 > 604800000) {
                i3 = 604800000;
            }
            if (this.f41403a == i3 && this.f445a) {
                return;
            }
            this.f445a = true;
            this.f441a = System.currentTimeMillis();
            this.f41403a = i3;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i3 + " start = " + this.f441a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ey eyVar) {
        synchronized (this) {
            this.f442a.a(eyVar);
        }
    }

    public void a(XMPushService xMPushService) {
        synchronized (this) {
            this.f443a = new fe(xMPushService);
            this.f444a = "";
            com.xiaomi.push.service.bv.a().a(new fg(this));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11752a() {
        return this.f445a;
    }

    boolean b() {
        m11748a();
        return this.f445a && this.f442a.m11542a() > 0;
    }
}

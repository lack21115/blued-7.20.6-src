package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.impl.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ah.class */
public class ah {
    private static ah b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26357a;

    /* renamed from: c  reason: collision with root package name */
    private Timer f26358c;
    private final List<b> d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ah$a.class */
    public final class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(ah ahVar, byte b) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (aj.a(TXCopyrightedMedia.instance().getApplicationContext())) {
                ArrayList<b> arrayList = null;
                synchronized (ah.class) {
                    try {
                        Iterator it = ah.this.d.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar.f26361a >= 5 || bVar.b) {
                                it.remove();
                            } else {
                                ArrayList arrayList2 = arrayList;
                                if (arrayList == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(bVar);
                                arrayList = arrayList2;
                            }
                        }
                    } finally {
                    }
                }
                if (arrayList != null) {
                    for (b bVar2 : arrayList) {
                        ah.a(bVar2);
                    }
                }
                synchronized (ah.class) {
                    try {
                        if (ah.this.f26357a && ah.this.d.size() == 0) {
                            ah.this.f26358c.cancel();
                            ah.d(ah.this);
                            ah.e(ah.this);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ah$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f26361a = 0;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        aw f26362c;

        public b(aw awVar) {
            this.f26362c = (aw) awVar.clone();
        }
    }

    private ah() {
    }

    public static ah a() {
        if (b == null) {
            synchronized (ah.class) {
                try {
                    if (b == null) {
                        b = new ah();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    static /* synthetic */ void a(b bVar) {
        try {
            if (bVar.b) {
                return;
            }
            bVar.f26361a++;
            String a2 = bVar.f26362c.a();
            if (a2 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder("report music->request url:");
            sb.append(bVar.f26362c.b());
            sb.append(" body:");
            sb.append(a2);
            w wVar = w.c.f26493a;
            w.d a3 = w.a(bVar.f26362c.b(), a2.getBytes(), "application/json");
            if (a3 == null || a3.b == null) {
                return;
            }
            new String(a3.b, "UTF-8");
            bVar.b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ Timer d(ah ahVar) {
        ahVar.f26358c = null;
        return null;
    }

    static /* synthetic */ boolean e(ah ahVar) {
        ahVar.f26357a = false;
        return false;
    }

    public final void a(aw awVar) {
        final b bVar = new b(awVar);
        synchronized (ah.class) {
            try {
                if (this.f26358c == null) {
                    this.f26357a = false;
                    Timer timer = new Timer();
                    this.f26358c = timer;
                    timer.schedule(new a(this, (byte) 0), 0L, 8000L);
                }
                if (this.d.size() > 200) {
                    this.d.remove(0);
                }
                this.d.add(bVar);
                this.f26358c.schedule(new TimerTask() { // from class: com.tencent.txcopyrightedmedia.impl.utils.ah.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        ah.a(bVar);
                    }
                }, 0L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

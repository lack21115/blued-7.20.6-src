package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.c.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/t.class */
public class t {
    public static final String a = t.class.getSimpleName();
    private static volatile t b;
    private Map<String, com.anythink.core.common.e.w> c;
    private List<com.anythink.core.common.e.w> d;
    private final int f = 5;
    private final int g = 500;
    private List<String> e = Collections.synchronizedList(new ArrayList(8));

    private t() {
    }

    public static t a() {
        if (b == null) {
            synchronized (t.class) {
                try {
                    if (b == null) {
                        b = new t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.core.common.e.w wVar) {
        synchronized (this) {
            new StringBuilder("delete: ").append(wVar.a());
            this.c.remove(wVar.a);
            this.d.remove(wVar);
            com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(wVar);
        }
    }

    private void a(final com.anythink.core.common.e.w wVar, final boolean z) {
        synchronized (this) {
            if (System.currentTimeMillis() > wVar.f) {
                new StringBuilder("resendNoticeUrl: do nothing because offer is out date: ").append(wVar.a());
                this.e.remove(wVar.a);
                if (z) {
                    a(wVar);
                }
            } else if (this.e.contains(wVar.a)) {
                new StringBuilder("resendNoticeUrl: do nothing because it is loading... ").append(wVar.a());
            } else {
                this.e.add(wVar.a);
                if (z) {
                    wVar.g++;
                    if (wVar.g >= 5) {
                        new StringBuilder("resendNoticeUrl: The number of retries is greater than or equal to the maximum number of retries, start deleting and continue: ").append(wVar.a());
                        a(wVar);
                    } else {
                        b(wVar);
                    }
                } else {
                    wVar.g++;
                    if (wVar.g >= 5) {
                        new StringBuilder("resendNoticeUrl: The number of retries is greater than or equal to the maximum number of retries, start deleting and continue: ").append(wVar.a());
                        this.e.remove(wVar.a);
                        return;
                    }
                }
                new StringBuilder("resendNoticeUrl: start to send notice: ").append(wVar.a());
                new com.anythink.core.common.g.k(wVar).a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.t.1
                    @Override // com.anythink.core.common.g.i
                    public final void onLoadCanceled(int i) {
                        synchronized (t.this) {
                            t.this.e.remove(wVar.a);
                        }
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadError(int i, String str, AdError adError) {
                        String str2 = t.a;
                        new StringBuilder("resendNoticeUrl:  send notice failed: ").append(wVar.a());
                        synchronized (t.this) {
                            t.this.e.remove(wVar.a);
                            if (!z) {
                                t.this.b(wVar);
                            }
                        }
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadFinish(int i, Object obj) {
                        String str = t.a;
                        new StringBuilder("resendNoticeUrl:  send notice success: ").append(wVar.a());
                        synchronized (t.this) {
                            t.this.e.remove(wVar.a);
                            if (z) {
                                t.this.a(wVar);
                            }
                        }
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadStart(int i) {
                    }
                });
            }
        }
    }

    public static boolean a(int i) {
        boolean z;
        boolean z2 = true;
        switch (i) {
            case com.anythink.core.common.g.g.d /* -1003 */:
            case com.anythink.core.common.g.g.c /* -1002 */:
            case com.anythink.core.common.g.g.b /* -1001 */:
            case -1000:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            if (i < -99 || i >= 200) {
                if (i >= 400) {
                    return true;
                }
            }
            return z2;
        }
        z2 = z;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.core.common.e.w wVar) {
        synchronized (this) {
            if (TextUtils.isEmpty(wVar.a)) {
                wVar.e = System.currentTimeMillis();
                wVar.a = com.anythink.core.common.k.f.a(wVar.d + wVar.e);
                this.c.put(wVar.a, wVar);
                this.d.add(wVar);
            }
            new StringBuilder("insertOrUpdate: ").append(wVar.a());
            com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).a(wVar);
            if (this.d.size() > 500) {
                com.anythink.core.common.e.w wVar2 = this.d.get(0);
                new StringBuilder("insertOrUpdate,  exceeded the maximum number of records, start to delete: ").append(wVar.a());
                this.e.remove(wVar.a);
                a(wVar2);
            }
        }
    }

    private void c() {
        synchronized (this) {
            try {
                if (this.c == null && this.d == null) {
                    i.a c = com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).c();
                    this.c = c.b;
                    this.d = c.a;
                }
                if (this.c == null) {
                    this.c = new ConcurrentHashMap();
                }
                if (this.d == null) {
                    this.d = Collections.synchronizedList(new ArrayList());
                }
            }
        }
    }

    public final void a(String str, String str2, long j) {
        synchronized (this) {
            com.anythink.core.common.e.w wVar = new com.anythink.core.common.e.w();
            wVar.b = 2;
            wVar.d = str;
            wVar.c = str2;
            wVar.f = j;
            new StringBuilder("reSendNow: ").append(wVar.a());
            a(wVar, false);
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                c();
                List<com.anythink.core.common.e.w> synchronizedList = Collections.synchronizedList(new ArrayList(this.d));
                if (synchronizedList != null && synchronizedList.size() > 0) {
                    for (com.anythink.core.common.e.w wVar : synchronizedList) {
                        new StringBuilder("tryToReSendNoticeUrl: ").append(wVar.a());
                        a(wVar, true);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}

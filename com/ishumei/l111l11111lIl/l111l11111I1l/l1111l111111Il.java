package com.ishumei.l111l11111lIl.l111l11111I1l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111Il.l111l1111lIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111l1Il.l111l11111I1l;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111I1l/l1111l111111Il.class */
public final class l1111l111111Il {
    private static final String l1111l111111Il = "sm";
    private static long l111l11111I1l = 2000;
    private static long l111l11111Il = 5000;
    private static long l111l11111lIl = 0;
    private static long l111l1111l1Il = 15000;
    private static final int l111l1111lI1l = 9;
    private static final int l111l1111lIl = 6;
    private static long l111l1111llIl = 30000;
    private static final int l11l1111I11l = 0;
    private static final int l11l1111I1l = 2;
    private static final int l11l1111I1ll = 1;
    private static final int l11l1111Il = 2;
    private static final int l11l1111Il1l = 3;
    private static final int l11l1111Ill = 4;
    private static final int l11l1111lIIl = 3;
    private static final int l11l11IlIIll = 1000000;
    private String l111l11IlIlIl;
    private AtomicInteger l11l111l11Il;
    private Runnable l11l111l1I1l;
    private String l11l111l1lll;

    /* renamed from: com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111I1l/l1111l111111Il$l1111l111111Il.class */
    static final class C0287l1111l111111Il {
        private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte) 0);

        private C0287l1111l111111Il() {
        }
    }

    private l1111l111111Il() {
        this.l11l111l1I1l = new Runnable() { // from class: com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il.1
            @Override // java.lang.Runnable
            public final void run() {
                l111l11111lIl l111l11111lIl2;
                try {
                    if (TextUtils.isEmpty(l1111l111111Il.this.l11l111l1lll) || TextUtils.isEmpty(l1111l111111Il.this.l111l11IlIlIl) || (l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl()) == null || !l111l11111lIl2.l11l1111lIIl()) {
                        return;
                    }
                    int i = l1111l111111Il.this.l11l111l11Il.get();
                    if (l111l11111lIl2.l111l1111llIl() < 0 || i < l111l11111lIl2.l111l1111llIl()) {
                        int l111l11111Il2 = l111l11111lIl2.l111l11111Il();
                        if (l111l11111Il2 > 0 && i <= l111l11111Il2 && !l111l1111lIl.l111l1111lI1l()) {
                            l1111l111111Il.l1111l111111Il(l1111l111111Il.this, 4);
                        } else if (!l1111l111111Il.l1111l111111Il(l1111l111111Il.this, l1111l111111Il.this.l11l111l1lll, l1111l111111Il.this.l111l11IlIlIl)) {
                            l1111l111111Il.l1111l111111Il(l1111l111111Il.this, 2);
                        } else {
                            l1111l111111Il.this.l11l111l1lll = l1111l111111Il.this.l111l11IlIlIl = null;
                            l1111l111111Il.l1111l111111Il(l1111l111111Il.this, 1);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        };
        this.l11l111l11Il = new AtomicInteger(0);
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    }

    /* synthetic */ l1111l111111Il(byte b) {
        this();
    }

    private static int l1111l111111Il(String str) {
        try {
            return new JSONObject(str).getInt("code");
        } catch (Exception e) {
            return -1;
        }
    }

    public static l1111l111111Il l1111l111111Il() {
        return C0287l1111l111111Il.l1111l111111Il;
    }

    private void l1111l111111Il(int i) {
        if (i == 1) {
            this.l11l111l11Il.set(0);
        } else if (i != 2) {
            if (i == 4) {
                l1111l111111Il(1000L);
            }
        } else {
            int incrementAndGet = this.l11l111l11Il.incrementAndGet();
            this.l11l111l11Il.get();
            if (incrementAndGet > 1000000) {
                this.l11l111l11Il.set(10);
            }
            l1111l111111Il(this.l11l111l11Il.get() > 9 ? 30000L : this.l11l111l11Il.get() > 6 ? 15000L : this.l11l111l11Il.get() > 3 ? 5000L : 2000L);
        }
    }

    private void l1111l111111Il(long j) {
        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l11l111l1I1l, 4, j, true);
    }

    static /* synthetic */ void l1111l111111Il(l1111l111111Il l1111l111111il, int i) {
        if (i == 1) {
            l1111l111111il.l11l111l11Il.set(0);
        } else if (i != 2) {
            if (i == 4) {
                l1111l111111il.l1111l111111Il(1000L);
            }
        } else {
            int incrementAndGet = l1111l111111il.l11l111l11Il.incrementAndGet();
            l1111l111111il.l11l111l11Il.get();
            if (incrementAndGet > 1000000) {
                l1111l111111il.l11l111l11Il.set(10);
            }
            l1111l111111il.l1111l111111Il(l1111l111111il.l11l111l11Il.get() > 9 ? 30000L : l1111l111111il.l11l111l11Il.get() > 6 ? 15000L : l1111l111111il.l11l111l11Il.get() > 3 ? 5000L : 2000L);
        }
    }

    static /* synthetic */ boolean l1111l111111Il(l1111l111111Il l1111l111111il, String str, String str2) {
        return l111l11111lIl(str, str2);
    }

    private long l111l11111I1l() {
        if (this.l11l111l11Il.get() > 9) {
            return 30000L;
        }
        if (this.l11l111l11Il.get() > 6) {
            return 15000L;
        }
        return this.l11l111l11Il.get() > 3 ? 5000L : 2000L;
    }

    private static boolean l111l11111lIl(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(new l111l11111I1l().l1111l111111Il(com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(str2)).l1111l111111Il(str.getBytes("utf-8"), null, str2));
            int i = jSONObject.getInt("code");
            if (i != 1100) {
                return i == 1902;
            }
            l111l1111llIl.l1111l111111Il().l1111l111111Il(jSONObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final void l1111l111111Il(final String str, final String str2) {
        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new Runnable() { // from class: com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il.2
            @Override // java.lang.Runnable
            public final void run() {
                l111l11111lIl l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
                if (l111l11111lIl2 == null || !l111l11111lIl2.l11l1111lIIl() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                String str3 = str;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("retry", 1);
                    str3 = jSONObject.toString();
                } catch (Exception e) {
                }
                Handler l1111l111111Il2 = com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(4);
                if (l1111l111111Il2 == null) {
                    return;
                }
                l1111l111111Il2.removeCallbacks(l1111l111111Il.this.l11l111l1I1l);
                l1111l111111Il.this.l11l111l1lll = str3;
                l1111l111111Il.this.l111l11IlIlIl = str2;
                l1111l111111Il.this.l111l11111lIl();
            }
        }, 4);
    }

    public final void l111l11111lIl() {
        this.l11l111l11Il.set(0);
        l1111l111111Il(0L);
    }
}

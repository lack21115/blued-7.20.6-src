package com.ishumei.l111l11111lIl.l111l11111lIl;

import android.content.SharedPreferences;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il.class */
public class l1111l111111Il {
    private static final String l1111l111111Il = "fc_times";
    private static final String l111l11111I1l = "n";
    private static final String l111l11111Il = "t";
    private static final String l111l11111lIl = "l";
    private static final int l111l1111l1Il = 20;
    private static final int l111l1111llIl = -1048576;
    private SharedPreferences l111l1111lI1l;
    private List<String> l111l1111lIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il$l1111l111111Il.class */
    public static final class C0458l1111l111111Il {
        private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte) 0);

        private C0458l1111l111111Il() {
        }
    }

    private l1111l111111Il() {
        this.l111l1111lIl = null;
        try {
            if (l111l1111llIl.l1111l111111Il.l111l11111Il != null) {
                this.l111l1111lI1l = l111l1111llIl.l1111l111111Il.l111l11111Il.getSharedPreferences(l1111l111111Il, 0);
            }
        } catch (Throwable th) {
        }
    }

    /* synthetic */ l1111l111111Il(byte b) {
        this();
    }

    private static int l1111l111111Il(int i) {
        int abs = Math.abs(i & 1048575);
        int i2 = abs;
        if (abs > 2880) {
            i2 = 2880;
        }
        return i2;
    }

    public static l1111l111111Il l1111l111111Il() {
        return C0458l1111l111111Il.l1111l111111Il;
    }

    private void l111l11111Il() {
        HashSet hashSet = new HashSet(this.l111l1111lI1l.getStringSet("t", new HashSet()));
        hashSet.add(String.valueOf(System.currentTimeMillis()));
        com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "t", hashSet);
    }

    private static int l111l11111lIl(int i) {
        int i2 = i >> 20;
        int i3 = i2;
        if (i2 > 100) {
            i3 = 100;
        }
        return i3;
    }

    private static int l111l11111lIl(int i, int i2) {
        return (i2 << 20) + i;
    }

    private void l111l1111l1Il() {
        try {
            this.l111l1111lIl = new ArrayList(this.l111l1111lI1l.getStringSet("t", new HashSet()));
            com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "l", System.currentTimeMillis());
            com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "t", new HashSet());
        } catch (Exception e) {
        }
    }

    public final void l1111l111111Il(int i, int i2) {
        synchronized (this) {
            if (this.l111l1111lI1l == null) {
                return;
            }
            if (i <= 0 || i2 <= 0) {
                com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "n", 0);
            } else {
                com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "n", (i2 << 20) + i);
            }
        }
    }

    public final List<String> l111l11111I1l() {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            if (this.l111l1111lIl == null) {
                return arrayList;
            }
            arrayList.addAll(this.l111l1111lIl);
            this.l111l1111lIl = null;
            return arrayList;
        }
    }

    public final boolean l111l11111lIl() {
        synchronized (this) {
            try {
                if (this.l111l1111lI1l == null) {
                    return true;
                }
                int i = this.l111l1111lI1l.getInt("n", 0);
                if (i == 0) {
                    l111l1111l1Il();
                    return true;
                }
                long j = this.l111l1111lI1l.getLong("l", 0L);
                int abs = Math.abs(1048575 & i);
                int i2 = abs;
                if (abs > 2880) {
                    i2 = 2880;
                }
                if (i2 * 60000 < Math.abs(System.currentTimeMillis() - j)) {
                    l111l1111l1Il();
                    return true;
                }
                int size = this.l111l1111lI1l.getStringSet("t", new HashSet()).size();
                int i3 = i >> 20;
                int i4 = i3;
                if (i3 > 100) {
                    i4 = 100;
                }
                if (size >= i4) {
                    l111l1111l1Il();
                    return true;
                }
                HashSet hashSet = new HashSet(this.l111l1111lI1l.getStringSet("t", new HashSet()));
                hashSet.add(String.valueOf(System.currentTimeMillis()));
                com.ishumei.l111l1111llIl.l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "t", hashSet);
                return false;
            } catch (Throwable th) {
                l111l1111l1Il();
                return true;
            }
        }
    }
}

package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111l1Il.class */
public class l111l1111l1Il {
    private static final String l1111l111111Il = "sm";
    private static final String l111l11111lIl = "seq";
    private static l111l1111l1Il l111l1111l1Il;
    private Context l111l11111Il;
    private int l111l11111I1l = 0;
    private com.ishumei.l111l11111I1l.l111l11111lIl l111l1111llIl = new com.ishumei.l111l11111I1l.l111l11111lIl(true, 7) { // from class: com.ishumei.l1111l111111Il.l111l1111l1Il.1
        {
            super(true, 7);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                l111l1111l1Il l111l1111l1il = l111l1111l1Il.this;
                StringBuilder sb = new StringBuilder();
                sb.append(l111l1111l1Il.this.l111l11111I1l);
                l111l1111l1Il.l1111l111111Il(l111l1111l1il, sb.toString());
            } catch (Throwable th) {
            }
        }
    };

    private l111l1111l1Il() {
        this.l111l11111Il = null;
        this.l111l11111Il = l111l1111llIl.l1111l111111Il.l111l11111Il;
    }

    public static l111l1111l1Il l1111l111111Il() {
        if (l111l1111l1Il == null) {
            synchronized (l111l1111l1Il.class) {
                try {
                    if (l111l1111l1Il == null) {
                        l111l1111l1Il = new l111l1111l1Il();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return l111l1111l1Il;
    }

    static /* synthetic */ void l1111l111111Il(l111l1111l1Il l111l1111l1il, String str) {
        try {
            if (l111l1111l1il.l111l11111Il == null) {
                throw new Exception("mContext == null");
            }
            SharedPreferences.Editor edit = l111l1111l1il.l111l11111Il.getSharedPreferences(l111l11111lIl, 0).edit();
            edit.putString(l111l11111lIl, str);
            if (!edit.commit()) {
                throw new IOException("editor commit failed");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void l1111l111111Il(String str) {
        try {
            if (this.l111l11111Il == null) {
                throw new Exception("mContext == null");
            }
            SharedPreferences.Editor edit = this.l111l11111Il.getSharedPreferences(l111l11111lIl, 0).edit();
            edit.putString(l111l11111lIl, str);
            if (!edit.commit()) {
                throw new IOException("editor commit failed");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String l111l11111I1l() {
        try {
            if (this.l111l11111Il != null) {
                String string = this.l111l11111Il.getSharedPreferences(l111l11111lIl, 0).getString(l111l11111lIl, null);
                if (com.ishumei.l111l1111llIl.l111l1111lI1l.l1111l111111Il(string)) {
                    throw new Exception("from shared preference empty id");
                }
                return string;
            }
            throw new Exception("mContext == null");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String l111l11111Il() {
        String str;
        String l111l11111I1l;
        try {
            l111l11111I1l = l111l11111I1l();
        } catch (Exception e) {
            str = null;
        }
        try {
            str = l111l11111I1l;
            if (com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111lIl(l111l11111I1l)) {
                return l111l11111I1l;
            }
            return str;
        } catch (Exception e2) {
            return l111l11111I1l;
        }
    }

    public final String l111l11111lIl() {
        String sb;
        synchronized (this) {
            if (this.l111l11111I1l == 0) {
                String str = null;
                try {
                    str = l111l11111Il();
                } catch (Exception e) {
                }
                if (com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111lIl(str)) {
                    try {
                        this.l111l11111I1l = Integer.parseInt(str);
                    } catch (Exception e2) {
                    }
                }
            }
            this.l111l11111I1l++;
            this.l111l1111llIl.l1111l111111Il();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.l111l11111I1l);
            sb = sb2.toString();
        }
        return sb;
    }
}

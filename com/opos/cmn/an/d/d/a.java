package com.opos.cmn.an.d.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.igexin.push.core.b;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/d/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f24491a;

    public a(Context context, String str, int i) {
        this.f24491a = null;
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.f24491a = context.getSharedPreferences(str, i);
        com.opos.cmn.an.f.a.b("SPEngine", "context.getSharedPreferences name=" + str + ",mode=" + i);
    }

    private boolean a(SharedPreferences.Editor editor, String str, Object obj) {
        boolean z = false;
        if (editor != null) {
            z = false;
            if (!com.opos.cmn.an.c.a.a(str)) {
                z = false;
                if (obj != null) {
                    z = false;
                    if (this.f24491a != null) {
                        try {
                            if (obj instanceof Boolean) {
                                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Float) {
                                editor.putFloat(str, ((Float) obj).floatValue());
                            } else if (obj instanceof Integer) {
                                editor.putInt(str, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                editor.putLong(str, ((Long) obj).longValue());
                            } else if (obj instanceof String) {
                                editor.putString(str, (String) obj);
                            } else {
                                z = false;
                                if (obj instanceof Set) {
                                    editor.putStringSet(str, (Set) obj);
                                }
                            }
                            z = true;
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.c("SPEngine", "put", e);
                            z = false;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("put key=");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(",value=");
        if (obj == null) {
            obj = b.l;
        }
        sb.append(obj);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return z;
    }

    public long a(String str, long j) {
        long j2 = j;
        if (!com.opos.cmn.an.c.a.a(str)) {
            SharedPreferences sharedPreferences = this.f24491a;
            j2 = j;
            if (sharedPreferences != null) {
                try {
                    j2 = sharedPreferences.getLong(str, j);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("SPEngine", "getLong", e);
                    j2 = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLong key=");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(",value=");
        sb.append(j2);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return j2;
    }

    public Map<String, ?> a() {
        SharedPreferences sharedPreferences = this.f24491a;
        Map<String, ?> all = sharedPreferences != null ? sharedPreferences.getAll() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getAll=");
        sb.append(all != null ? Integer.valueOf(all.size()) : b.l);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return all;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append("removeAndApply key=");
        sb.append(str != null ? str : b.l);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        if (com.opos.cmn.an.c.a.a(str) || (sharedPreferences = this.f24491a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "removeAndCommit", e);
        }
    }

    public void a(String str, Object obj) {
        SharedPreferences sharedPreferences;
        StringBuilder sb = new StringBuilder();
        sb.append("putAndApply key=");
        sb.append(str != null ? str : b.l);
        sb.append(",value=");
        Object obj2 = b.l;
        if (obj != null) {
            obj2 = obj;
        }
        sb.append(obj2);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        if (com.opos.cmn.an.c.a.a(str) || obj == null || (sharedPreferences = this.f24491a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (a(edit, str, obj)) {
                edit.apply();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "putAndApply", e);
        }
    }

    public boolean a(String str, boolean z) {
        boolean z2 = z;
        if (!com.opos.cmn.an.c.a.a(str)) {
            SharedPreferences sharedPreferences = this.f24491a;
            z2 = z;
            if (sharedPreferences != null) {
                try {
                    z2 = sharedPreferences.getBoolean(str, z);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("SPEngine", "getBoolean", e);
                    z2 = z;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getInt key=");
        if (str == null) {
            str = b.l;
        }
        sb.append(str);
        sb.append(",value=");
        sb.append(z2);
        com.opos.cmn.an.f.a.b("SPEngine", sb.toString());
        return z2;
    }
}

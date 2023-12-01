package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/b/a/c.class */
public class c {

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f63a;

    /* renamed from: a  reason: collision with other field name */
    private b f65a;

    /* renamed from: a  reason: collision with other field name */
    private d f66a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f34901c;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Context mContext;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences.Editor f34900a = null;

    /* renamed from: a  reason: collision with other field name */
    private b.a f64a = null;

    /* JADX WARN: Removed duplicated region for block: B:101:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x034f A[Catch: Exception -> 0x0378, TryCatch #3 {Exception -> 0x0378, blocks: (B:110:0x0348, B:112:0x034f), top: B:129:0x0348 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(android.content.Context r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 890
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private d a(String str) {
        File m9887a = m9887a(str);
        if (m9887a != null) {
            d dVar = new d(m9887a.getAbsolutePath());
            this.f66a = dVar;
            return dVar;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m9887a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences == null || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        a2.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                a2.a(key, (String) value);
            } else if (value instanceof Integer) {
                a2.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                a2.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                a2.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                a2.a(key, ((Boolean) value).booleanValue());
            }
        }
        try {
            a2.commit();
        } catch (Exception e) {
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f34900a == null && (sharedPreferences = this.f63a) != null) {
            this.f34900a = sharedPreferences.edit();
        }
        if (this.h && this.f64a == null && (bVar = this.f65a) != null) {
            this.f64a = bVar.a();
        }
        c();
    }

    private boolean c() {
        b bVar = this.f65a;
        if (bVar != null) {
            boolean b = bVar.b();
            if (!b) {
                commit();
            }
            return b;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(4:3|(1:7)|8|(11:10|11|(1:15)|16|17|18|19|20|(8:22|(2:24|(2:26|(3:28|(1:30)(1:32)|31))(4:33|34|35|(2:37|38)))|43|(2:45|(1:47))|49|50|51|(2:53|54))|60|61))|65|11|(2:13|15)|16|17|18|19|20|(0)|60|61|(2:(0)|(9:40|43|(0)|49|50|51|(0)|60|61))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
        r12.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ff, code lost:
        if (r5.f64a.commit() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0125, code lost:
        if (r5.f65a != null) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133 A[Catch: Exception -> 0x014f, TRY_LEAVE, TryCatch #0 {Exception -> 0x014f, blocks: (B:50:0x012c, B:52:0x0133), top: B:61:0x012c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean commit() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.commit():boolean");
    }

    public String getString(String str) {
        c();
        SharedPreferences sharedPreferences = this.f63a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!g.m9885a(string)) {
                return string;
            }
        }
        b bVar = this.f65a;
        return bVar != null ? bVar.getString(str, "") : "";
    }

    public void putString(String str, String str2) {
        if (g.m9885a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f34900a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f64a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) {
        if (g.m9885a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f34900a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f64a;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}

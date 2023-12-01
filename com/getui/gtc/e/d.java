package com.getui.gtc.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.db.AbstractTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/e/d.class */
public class d extends AbstractTable {

    /* renamed from: a  reason: collision with root package name */
    public String f21998a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f21999c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public long j;
    public long k;
    public final Set<String> l = new HashSet();

    private String b() {
        Cursor query;
        Cursor cursor = null;
        try {
            query = getReadableDatabase().query("r", new String[]{"a", "b"}, "a=?", new String[]{"17"}, null, null, null);
        } catch (Throwable th) {
            try {
                com.getui.gtc.i.c.a.a(th);
                if (cursor == null) {
                    return "";
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        if (query == null || !query.moveToNext()) {
            if (query != null) {
                cursor = query;
                cursor.close();
                return "";
            }
            return "";
        }
        cursor = query;
        String string = query.getString(1);
        if (query != null) {
            query.close();
        }
        return string;
    }

    public final JSONObject a() {
        try {
            String b = b();
            if (!TextUtils.isEmpty(b)) {
                return new JSONObject(new String(SecureCryptTools.getInstance().decrypt(Base64.decode(b, 0))));
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
        return new JSONObject();
    }

    public final void a(String str) {
        if (a(10, str)) {
            this.e = str;
        }
    }

    public final void a(Collection<String> collection) {
        if (collection.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.addAll(collection);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            sb.append((String) arrayList.get(i2));
            if (i2 < size - 1) {
                sb.append(",");
            }
            i = i2 + 1;
        }
        if (a(8, sb.toString())) {
            this.l.addAll(collection);
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(17, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(jSONObject.toString().getBytes()), 0));
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    public final boolean a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("a", Integer.valueOf(i));
        contentValues.put("b", Long.valueOf(j));
        return replace(null, contentValues) != -1;
    }

    public final boolean a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("a", Integer.valueOf(i));
        contentValues.put("b", str);
        return replace(null, contentValues) != -1;
    }

    public final void b(String str) {
        try {
            if (a(11, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.f = str;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    public final void c(String str) {
        try {
            if (a(12, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(str.getBytes()), 0))) {
                this.g = str;
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS r (a TEXT PRIMARY KEY, b TEXT)";
    }

    public final void d(String str) {
        if (a(7, str)) {
            this.f21998a = str;
        }
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str) || !this.l.contains(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.l);
        arrayList.remove(str);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            sb.append((String) arrayList.get(i2));
            if (i2 < size - 1) {
                sb.append(",");
            }
            i = i2 + 1;
        }
        if (a(8, sb.toString())) {
            this.l.remove(str);
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "r";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public void initCache() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = getReadableDatabase().query("r", new String[]{"a", "b"}, null, null, null, null, null);
                if (query != null) {
                    while (true) {
                        cursor2 = query;
                        cursor = query;
                        if (query.moveToNext()) {
                            switch (query.getInt(0)) {
                                case 4:
                                    this.f21999c = query.getString(1);
                                    continue;
                                case 6:
                                    this.b = query.getLong(1);
                                    continue;
                                case 7:
                                    this.f21998a = query.getString(1);
                                    continue;
                                case 8:
                                    String string = query.getString(1);
                                    if (TextUtils.isEmpty(string)) {
                                        continue;
                                    } else {
                                        this.l.addAll(Arrays.asList(string.split(",")));
                                    }
                                case 9:
                                    this.d = query.getString(1);
                                    continue;
                                case 10:
                                    this.e = query.getString(1);
                                    continue;
                                case 11:
                                    try {
                                        String string2 = query.getString(1);
                                        if (TextUtils.isEmpty(string2)) {
                                            continue;
                                        } else {
                                            this.f = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string2, 0)));
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        break;
                                    }
                                case 12:
                                    try {
                                        String string3 = query.getString(1);
                                        if (TextUtils.isEmpty(string3)) {
                                            continue;
                                        } else {
                                            this.g = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string3, 0)));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        break;
                                    }
                                case 13:
                                    try {
                                        String string4 = query.getString(1);
                                        if (TextUtils.isEmpty(string4)) {
                                            continue;
                                        } else {
                                            this.h = new String(SecureCryptTools.getInstance().decrypt(Base64.decode(string4, 0)));
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        break;
                                    }
                                case 14:
                                    this.i = query.getLong(1);
                                    continue;
                                case 15:
                                    this.j = query.getLong(1);
                                    continue;
                                case 16:
                                    this.k = query.getLong(1);
                                    continue;
                            }
                            com.getui.gtc.i.c.a.b(th);
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                com.getui.gtc.i.c.a.a(e);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th4) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th4;
        }
    }
}

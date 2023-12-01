package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.media.MediaFormat;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t1.class */
public abstract class t1 implements Cloneable {
    public static final SimpleDateFormat n = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final j2<HashMap<String, t1>> o = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7702a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f7703c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public String k;
    public String l;
    public JSONObject m;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t1$a.class */
    public static final class a extends j2<HashMap<String, t1>> {
        @Override // com.bytedance.bdtracker.j2
        public HashMap<String, t1> a(Object[] objArr) {
            return t1.j();
        }
    }

    public t1() {
        a(0L);
    }

    public static t1 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return o.b(new Object[0]).get(jSONObject.optString("k_cls", "")).m2745clone().a(jSONObject);
        } catch (Throwable th) {
            z2.c("U SHALL NOT PASS!", th);
            return null;
        }
    }

    public static HashMap<String, t1> j() {
        HashMap<String, t1> hashMap = new HashMap<>();
        hashMap.put(WBPageConstants.ParamKey.PAGE, new c2());
        hashMap.put("launch", new a2());
        hashMap.put("terminate", new f2());
        hashMap.put("pack", new b2());
        t1[] k = k();
        int length = k.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                hashMap.put(MediaFormat.KEY_PROFILE, new d2(null, null));
                return hashMap;
            }
            t1 t1Var = k[i2];
            hashMap.put(t1Var.f(), t1Var);
            i = i2 + 1;
        }
    }

    public static t1[] k() {
        return new t1[]{new x1(), new z1(null, null, false, null), new y1(null, "", new JSONObject())};
    }

    public int a(Cursor cursor) {
        this.f7702a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.f7703c = cursor.getLong(2);
        this.i = cursor.getInt(3);
        this.e = cursor.getLong(4);
        this.d = cursor.getString(5);
        this.f = cursor.getString(6);
        this.g = cursor.getString(7);
        this.h = cursor.getString(8);
        this.j = cursor.getInt(9);
        this.k = cursor.getString(10);
        String string = cursor.getString(11);
        this.m = new JSONObject();
        if (TextUtils.isEmpty(string)) {
            return 12;
        }
        try {
            this.m = new JSONObject(string);
            return 12;
        } catch (Exception e) {
            return 12;
        }
    }

    public final ContentValues a(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        b(contentValues);
        return contentValues;
    }

    public t1 a(JSONObject jSONObject) {
        this.b = jSONObject.optLong("local_time_ms", 0L);
        this.f7702a = 0L;
        this.f7703c = 0L;
        this.i = 0;
        this.e = 0L;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = jSONObject.optString("_app_id");
        this.m = jSONObject.optJSONObject("properties");
        return this;
    }

    public final String a() {
        List<String> b = b();
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(f());
        sb.append("(");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b.size()) {
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                return sb.toString();
            }
            sb.append(b.get(i2));
            sb.append(" ");
            sb.append(b.get(i2 + 1));
            sb.append(",");
            i = i2 + 2;
        }
    }

    public void a(long j) {
        long j2 = j;
        if (j == 0) {
            j2 = System.currentTimeMillis();
        }
        this.b = j2;
    }

    public void a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            j1.c(this.m, jSONObject2);
            jSONObject.put("params", jSONObject2);
        } catch (Throwable th) {
            z2.c("U SHALL NOT PASS!", th);
        }
    }

    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, SearchIndexablesContract.RawData.COLUMN_USER_ID, TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", TypedValues.Custom.S_INT, "_app_id", "varchar", "properties", "varchar");
    }

    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("tea_event_index", Long.valueOf(this.f7703c));
        contentValues.put("nt", Integer.valueOf(this.i));
        contentValues.put(SearchIndexablesContract.RawData.COLUMN_USER_ID, Long.valueOf(this.e));
        contentValues.put("session_id", this.d);
        contentValues.put("user_unique_id", this.f);
        contentValues.put("ssid", this.g);
        contentValues.put("ab_sdk_version", this.h);
        contentValues.put("event_type", Integer.valueOf(this.j));
        contentValues.put("_app_id", this.k);
        JSONObject jSONObject = this.m;
        contentValues.put("properties", jSONObject != null ? jSONObject.toString() : "");
    }

    public void b(JSONObject jSONObject) {
        this.m = jSONObject;
    }

    public String c() {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("sid:");
        a2.append(this.d);
        return a2.toString();
    }

    public void c(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("_app_id", this.k);
        jSONObject.put("properties", this.m);
    }

    /* renamed from: clone */
    public t1 m2745clone() {
        try {
            return (t1) super.clone();
        } catch (CloneNotSupportedException e) {
            z2.c("U SHALL NOT PASS!", e);
            return null;
        }
    }

    public String d() {
        return null;
    }

    public JSONObject e() {
        return this.m;
    }

    public abstract String f();

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", f());
            c(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            z2.c("U SHALL NOT PASS!", e);
            return jSONObject;
        }
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            this.l = n.format(new Date(this.b));
            return i();
        } catch (JSONException e) {
            z2.a("U SHALL NOT PASS!", e);
            return jSONObject;
        }
    }

    public abstract JSONObject i();

    public String toString() {
        String str;
        String f = f();
        String str2 = f;
        if (!getClass().getSimpleName().equalsIgnoreCase(f)) {
            str2 = f + ", " + getClass().getSimpleName();
        }
        String str3 = this.d;
        if (str3 != null) {
            int indexOf = str3.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            str = str3;
            if (indexOf >= 0) {
                str = str3.substring(0, indexOf);
            }
        } else {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        return "{" + str2 + ", " + c() + ", " + str + ", " + this.b + "}";
    }
}

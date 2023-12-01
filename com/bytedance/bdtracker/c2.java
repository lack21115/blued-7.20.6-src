package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c2.class */
public class c2 extends t1 {
    public long p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;
    public String x;
    public Class<?> y;

    @Override // com.bytedance.bdtracker.t1
    public int a(Cursor cursor) {
        super.a(cursor);
        this.r = cursor.getString(12);
        this.q = cursor.getString(13);
        this.p = cursor.getLong(14);
        this.w = cursor.getInt(15);
        this.x = cursor.getString(16);
        this.s = cursor.getString(17);
        this.t = cursor.getString(18);
        this.u = cursor.getString(19);
        this.v = cursor.getString(20);
        return 21;
    }

    @Override // com.bytedance.bdtracker.t1
    public t1 a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.r = jSONObject.optString("page_key", null);
        this.q = jSONObject.optString("refer_page_key", null);
        this.p = jSONObject.optLong("duration", 0L);
        this.w = jSONObject.optInt("is_back", 0);
        this.s = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.t = jSONObject.optString("refer_page_title", null);
        this.u = jSONObject.optString("page_path", null);
        this.v = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.bytedance.bdtracker.t1
    public List<String> b() {
        List<String> b = super.b();
        ArrayList arrayList = new ArrayList(b.size());
        arrayList.addAll(b);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.bdtracker.t1
    public void b(ContentValues contentValues) {
        super.b(contentValues);
        contentValues.put("page_key", this.r);
        contentValues.put("refer_page_key", this.q);
        contentValues.put("duration", Long.valueOf(this.p));
        contentValues.put("is_back", Integer.valueOf(this.w));
        contentValues.put("last_session", this.x);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.s);
        contentValues.put("refer_page_title", this.t);
        contentValues.put("page_path", this.u);
        contentValues.put("referrer_page_path", this.v);
    }

    @Override // com.bytedance.bdtracker.t1
    public String c() {
        return this.r + ", " + this.p;
    }

    @Override // com.bytedance.bdtracker.t1
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
        jSONObject.put("page_key", this.r);
        jSONObject.put("refer_page_key", this.q);
        jSONObject.put("duration", this.p);
        jSONObject.put("is_back", this.w);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.s);
        jSONObject.put("refer_page_title", this.t);
        jSONObject.put("page_path", this.u);
        jSONObject.put("referrer_page_path", this.v);
    }

    @Override // com.bytedance.bdtracker.t1
    public String f() {
        return WBPageConstants.ParamKey.PAGE;
    }

    @Override // com.bytedance.bdtracker.t1
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.f7703c);
        jSONObject.put("session_id", this.d);
        long j = this.e;
        if (j > 0) {
            jSONObject.put(SearchIndexablesContract.RawData.COLUMN_USER_ID, j);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f) ? JSONObject.NULL : this.f);
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", this.r);
        jSONObject2.put("refer_page_key", this.q);
        jSONObject2.put("is_back", this.w);
        jSONObject2.put("duration", this.p);
        jSONObject2.put(ArticleInfo.PAGE_TITLE, this.s);
        jSONObject2.put("refer_page_title", this.t);
        jSONObject2.put("page_path", this.u);
        jSONObject2.put("referrer_page_path", this.v);
        a(jSONObject, jSONObject2.toString());
        jSONObject.put("datetime", this.l);
        return jSONObject;
    }

    public boolean l() {
        return this.p == -1;
    }
}

package com.opos.mobad.provider.record;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/record/SdKRecord.class */
public class SdKRecord implements d {
    public static final d.a FACTORY = new d.a() { // from class: com.opos.mobad.provider.record.SdKRecord.1
        @Override // com.opos.process.bridge.provider.d.a
        public SdKRecord getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return SdKRecord.a(context.getApplicationContext());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static volatile SdKRecord f13439a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f13440c;

    private SdKRecord(Context context) {
        this.b = context;
        this.f13440c = context.getSharedPreferences("mobad_sdk_record", 0);
    }

    public static final SdKRecord a(Context context) {
        SdKRecord sdKRecord;
        if (f13439a != null) {
            return f13439a;
        }
        synchronized (SdKRecord.class) {
            try {
                if (f13439a == null) {
                    f13439a = new SdKRecord(context);
                }
                sdKRecord = f13439a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sdKRecord;
    }

    @BridgeMethod(a = 2)
    public CacheEntity a() {
        return new CacheEntity(this.f13440c.getInt("img_cache", 0), this.f13440c.getInt("img_amount", 0));
    }

    @BridgeMethod(a = 1)
    public void a(CacheEntity cacheEntity) {
        this.f13440c.edit().putInt("img_cache", this.f13440c.getInt("img_cache", 0) + cacheEntity.f13435a).putInt("img_amount", this.f13440c.getInt("img_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod(a = 7)
    public void a(ControlEntity controlEntity) {
        this.f13440c.edit().putBoolean("control_tt_enable", controlEntity.f13436a).putBoolean("control_gdt_enable", controlEntity.b).putBoolean("control_cache_enable", controlEntity.f13437c).putLong("control_refresh_time", controlEntity.d).putBoolean("control_gg_enable", controlEntity.e).putBoolean("control_fb_enable", controlEntity.f).putBoolean("control_quic_enable", controlEntity.g).putBoolean("control_jd_enable", controlEntity.h).commit();
    }

    @BridgeMethod(a = 15)
    public void a(CookieData cookieData) {
        if (cookieData == null) {
            return;
        }
        this.f13440c.edit().putString(OapsKey.KEY_CK, cookieData.f13438a).putLong("ck_time", cookieData.b).commit();
    }

    @BridgeMethod(a = 9)
    public void a(String str) {
        SharedPreferences.Editor putString;
        if (TextUtils.isEmpty(str)) {
            putString = this.f13440c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info");
        } else {
            putString = this.f13440c.edit().putInt("cr_amount", this.f13440c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str);
        }
        putString.commit();
    }

    @BridgeMethod(a = 13)
    public void a(String str, String str2) {
        SharedPreferences.Editor putString;
        if (TextUtils.isEmpty(str)) {
            putString = this.f13440c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info").remove("cr_env_info");
        } else {
            putString = this.f13440c.edit().putInt("cr_amount", this.f13440c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str).putString("cr_env_info", str2);
        }
        putString.commit();
    }

    @BridgeMethod(a = 4)
    public CacheEntity b() {
        return new CacheEntity(this.f13440c.getInt("video_cache", 0), this.f13440c.getInt("video_amount", 0));
    }

    @BridgeMethod(a = 3)
    public void b(CacheEntity cacheEntity) {
        this.f13440c.edit().putInt("video_cache", this.f13440c.getInt("video_cache", 0) + cacheEntity.f13435a).putInt("video_amount", this.f13440c.getInt("video_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod(a = 5)
    public void c() {
        this.f13440c.edit().remove("img_amount").remove("img_cache").remove("video_amount").remove("video_cache").commit();
    }

    @BridgeMethod(a = 6)
    public ControlEntity d() {
        return new ControlEntity(this.f13440c.getBoolean("control_tt_enable", false), this.f13440c.getBoolean("control_gdt_enable", false), this.f13440c.getBoolean("control_cache_enable", false), this.f13440c.getBoolean("control_gg_enable", false), this.f13440c.getBoolean("control_fb_enable", false), this.f13440c.getBoolean("control_quic_enable", false), this.f13440c.getLong("control_refresh_time", 0L), this.f13440c.getBoolean("control_jd_enable", false));
    }

    @BridgeMethod(a = 8)
    public long e() {
        return this.f13440c.getLong("align_time", 0L);
    }

    public void f() {
        this.f13440c.edit().putLong("align_time", System.currentTimeMillis()).commit();
    }

    @BridgeMethod(a = 10)
    public int g() {
        return this.f13440c.getInt("cr_amount", 0);
    }

    @BridgeMethod(a = 11)
    public long h() {
        return this.f13440c.getLong("cr_last_time", 0L);
    }

    @BridgeMethod(a = 12)
    public String i() {
        return this.f13440c.getString("cr_info", "");
    }

    @BridgeMethod(a = 14)
    public String j() {
        return this.f13440c.getString("cr_env_info", "");
    }

    @BridgeMethod(a = 16)
    public CookieData k() {
        return new CookieData(this.f13440c.getString(OapsKey.KEY_CK, ""), this.f13440c.getLong("ck_time", -1L));
    }
}

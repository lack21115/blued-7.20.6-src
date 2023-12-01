package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.util.Base64;
import com.tencent.txcopyrightedmedia.TXCMMusicInfo;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/be.class */
public final class be implements aw {
    private static final byte[] i = {66, 108, 105, 50, 78, 50, 79, 97, 118, 119, 98, 105, 53, 74, 68, 78, 107, 57, 57, 114, 117, 110, 113, 75, 53, 108, 111, 50, 77, 101, 66, 80};

    /* renamed from: a  reason: collision with root package name */
    public String f26401a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f26402c;
    public long d;
    public String e;
    public double f;
    public double g;
    public boolean h;
    private String j;
    private String k;
    private String l;

    public be() {
    }

    public be(TXCMMusicInfo tXCMMusicInfo) {
        String str;
        if (tXCMMusicInfo == null) {
            return;
        }
        if (com.tencent.txcopyrightedmedia.b.c(tXCMMusicInfo) == 0) {
            this.f26402c = "Original";
            str = "_0";
        } else if (com.tencent.txcopyrightedmedia.b.c(tXCMMusicInfo) == 1) {
            this.f26402c = "Accompaniment";
            str = "_1";
        } else {
            this.f26402c = "Unknown";
            str = "";
        }
        this.f26401a = aj.c(TXCopyrightedMedia.instance().getApplicationContext()) + "_" + System.currentTimeMillis() + str;
        this.b = com.tencent.txcopyrightedmedia.b.a(tXCMMusicInfo);
        j jVar = new j(com.tencent.txcopyrightedmedia.b.b(tXCMMusicInfo));
        this.j = jVar.b == 1 ? "Chorus" : "Complete";
        this.k = aj.d(TXCopyrightedMedia.instance().getApplicationContext());
        this.l = jVar.f26414c;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final String a() {
        Context applicationContext = TXCopyrightedMedia.instance().getApplicationContext();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("AppId", ap.a().b);
            jSONObject.put("LicenseExtAppName", ap.a().d.f26372c);
            jSONObject.put("ExpireTime", (System.currentTimeMillis() / 1000) + 300);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            byte[] bytes2 = ap.a().d.b.getBytes("UTF-8");
            String replace = new String(Base64.encode(ac.a(bytes, bytes2, Arrays.copyOf(bytes2, 16)), 0), "UTF-8").replace("\n", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Action", "CreateReport");
            jSONObject2.put("Sign", replace);
            jSONObject2.put("AppId", TXCopyrightedMedia.instance().getAppID());
            jSONObject2.put("LicenseExtAppName", ap.a().d.f26372c);
            jSONObject2.put("PlayToken", aj.d());
            jSONObject2.put("MusicId", this.b);
            jSONObject2.put("MusicType", this.f26402c);
            jSONObject2.put("AppName", aj.b(applicationContext));
            jSONObject2.put("ReportTime", this.d);
            jSONObject2.put("DeviceType", "Android");
            jSONObject2.put("DeviceId", aj.c(applicationContext));
            jSONObject2.put("DeviceSystem", aj.b());
            jSONObject2.put("ActivityId", this.f26401a);
            jSONObject2.put("ReportType", this.e);
            jSONObject2.put("PlayPosition", (long) this.f);
            jSONObject2.put("PackageName", applicationContext.getPackageName());
            jSONObject2.put("IP", "");
            jSONObject2.put("PlayFragmentType", this.j);
            jSONObject2.put("AppVersion", this.k);
            jSONObject2.put("SDKVersion", TXCopyrightedMedia.getSDKVersion());
            jSONObject2.put(TXCopyrightedMedia.EXT_INFO_ROOM_ID, m.a().a(TXCopyrightedMedia.EXT_INFO_ROOM_ID));
            jSONObject2.put(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE, m.a().a(TXCopyrightedMedia.EXT_INFO_PLAY_SCENE));
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final String b() {
        return "https://play.yinsuda.qcloud.com/v1/playapi";
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new be();
        }
    }

    public final String toString() {
        return "PCMReportInfo{activityId='" + this.f26401a + "', musicId='" + this.b + "', musicType='" + this.f26402c + "', reportTime=" + this.d + ", reportType='" + this.e + "', playDuration=" + this.f + ", lastReportDuration=" + this.g + ", clipType='" + this.j + "'}";
    }
}

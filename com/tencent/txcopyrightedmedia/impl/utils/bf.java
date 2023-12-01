package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.android.internal.telephony.RILConstants;
import com.android.internal.util.cm.QSConstants;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.net.URLDecoder;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/bf.class */
public final class bf implements aw, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f40094a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f40095c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;

    private bf() {
    }

    public bf(String str, String str2, long j) {
        this.f40094a = System.currentTimeMillis() / 1000;
        this.f40095c = str;
        this.b = j;
        if (str2 == null) {
            this.l = true;
            return;
        }
        Uri parse = Uri.parse(str2);
        this.d = parse.getQueryParameter("mid");
        this.e = parse.getQueryParameter("aid");
        this.f = parse.getQueryParameter(QSConstants.TILE_BLUETOOTH);
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f)) {
            this.l = true;
            return;
        }
        this.f = TextUtils.equals(this.f, "2") ? "Accompaniment" : TextUtils.equals(this.f, "1") ? "Original" : "Unknown";
        String queryParameter = parse.getQueryParameter("mep");
        this.d = URLDecoder.decode(this.d);
        j jVar = new j(URLDecoder.decode(queryParameter));
        this.g = jVar.b == 1 ? "Chorus" : "Complete";
        this.h = aj.d(TXCopyrightedMedia.instance().getApplicationContext());
        this.i = jVar.f40105c;
        this.j = parse.getQueryParameter("roomId");
        this.k = parse.getQueryParameter("roomUserId");
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.aw
    public final String a() {
        if (this.l) {
            return null;
        }
        Context applicationContext = TXCopyrightedMedia.instance().getApplicationContext();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.alipay.sdk.packet.e.f, ap.a().b);
            jSONObject.put("LicenseExtAppName", ap.a().d.f40063c);
            jSONObject.put("ExpireTime", (System.currentTimeMillis() / 1000) + 300);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            byte[] bytes2 = ap.a().d.b.getBytes("UTF-8");
            String replace = new String(Base64.encode(ac.a(bytes, bytes2, Arrays.copyOf(bytes2, 16)), 0), "UTF-8").replace("\n", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Action", "CreateReport");
            jSONObject2.put("Sign", replace);
            jSONObject2.put(com.alipay.sdk.packet.e.f, TXCopyrightedMedia.instance().getAppID());
            jSONObject2.put("LicenseExtAppName", ap.a().d.f40063c);
            jSONObject2.put("PlayToken", aj.d());
            jSONObject2.put("MusicId", this.d);
            jSONObject2.put("MusicType", this.f);
            jSONObject2.put("AppName", aj.b(applicationContext));
            jSONObject2.put("ReportTime", this.f40094a);
            jSONObject2.put("DeviceType", "Android");
            jSONObject2.put("DeviceId", aj.c(applicationContext));
            jSONObject2.put("DeviceSystem", aj.b());
            jSONObject2.put("ActivityId", this.e);
            jSONObject2.put("ReportType", this.f40095c);
            jSONObject2.put("PlayPosition", this.b);
            jSONObject2.put("PackageName", applicationContext.getPackageName());
            jSONObject2.put(RILConstants.SETUP_DATA_PROTOCOL_IP, "");
            jSONObject2.put("SdkType", "TRTC");
            jSONObject2.put("PlayFragmentType", this.g);
            jSONObject2.put("AppVersion", this.h);
            jSONObject2.put("SDKVersion", TXCopyrightedMedia.getSDKVersion());
            jSONObject2.put(TXCopyrightedMedia.EXT_INFO_ROOM_ID, m.a().a(TXCopyrightedMedia.EXT_INFO_ROOM_ID));
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject2.put("ChorusToken", this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject2.put("TRTCRoomId", this.j);
            }
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject2.put("TRTCRoomUserId", this.k);
            }
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
            return new bf();
        }
    }
}

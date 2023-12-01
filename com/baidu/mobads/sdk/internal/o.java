package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/o.class */
public class o implements NativeResponse.CustomizeMediaPlayer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6597a = "vstart";
    private static final String b = "vrepeatedplay";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6598c = "vclose";
    private static final String d = "vreadyplay";
    private static final String e = "vplayfail";
    private static final String f = "vmute";
    private static final String g = "vfrozen";
    private static final String h = "vshow";
    private static final String i = "curTimeSec";
    private static final String j = "startTimeSec";
    private static final String k = "autoPlay";
    private static final String l = "reasonValue";
    private final dd m;
    private final a n;
    private boolean o = false;
    private int p = 0;

    public o(dd ddVar, a aVar) {
        this.m = ddVar;
        this.n = aVar;
    }

    private JSONObject a(int i2, int i3, boolean z, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(j, i2 / 1000);
            jSONObject.put(i, i3 / 1000);
            jSONObject.put("autoPlay", z);
            jSONObject.put(l, i4);
            return jSONObject;
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
            return jSONObject;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject S;
        if (this.m == null || (aVar = this.n) == null || (S = aVar.S()) == null) {
            return;
        }
        try {
            S.put("msg", "sendVideoThirdLog");
            S.put("trackType", str);
            S.put("trackInfo", jSONObject);
            this.m.a(S);
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        a(e, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        a(g, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z) {
        a(f, a(this.p, i2, this.o, z ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, NativeResponse.VideoReason videoReason) {
        a(f6598c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.p = 0;
        a(b, a(0, 0, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        this.p = i2;
        a(f6597a, a(i2, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        this.p = 0;
        this.o = z;
        a(f6597a, a(0, 0, z, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, NativeResponse.VideoReason videoReason) {
        a(f6598c, a(this.p, i2, this.o, videoReason.getCode()));
    }
}

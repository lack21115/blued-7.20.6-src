package com.kwad.components.ad.reward.i.kwai;

import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/kwai/a.class */
public final class a extends com.kwad.components.ad.reward.i.a {
    private b xq = new b();
    private final C0493a xr = new C0493a(d.uA());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.i.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/kwai/a$a.class */
    public static final class C0493a extends com.kwad.components.ad.reward.i.b {
        public C0493a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.xo = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.xp = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/kwai/a$b.class */
    public static final class b extends com.kwad.components.ad.reward.i.b {
        public b() {
            this.xo = "基础奖励：观看视频";
            this.xp = "基础奖励：需再观看%ss视频";
        }
    }

    private void jw() {
        if (this.xr.isCompleted()) {
            jm();
        } else {
            jn();
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.xr.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<c> jk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xq);
        arrayList.add(this.xr);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int jl() {
        int i = 0;
        for (c cVar : jk()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void ju() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xq.jm();
        jw();
    }

    public final boolean jv() {
        return this.xq.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xr.jm();
        jw();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.xq.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xr.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable th) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xq);
        t.a(jSONObject, "mOpenNsTask", this.xr);
        return jSONObject;
    }
}

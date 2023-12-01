package com.kwad.components.ad.reward.i.a;

import android.content.Context;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/a/a.class */
public final class a extends com.kwad.components.ad.reward.i.a {
    private c xs = new c();
    private C0322a xt = new C0322a();
    private final b xu = new b(com.kwad.components.ad.reward.kwai.b.gy());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/a/a$a.class */
    public static final class C0322a extends com.kwad.components.ad.reward.i.b {
        public C0322a() {
            this.xo = "安装应用";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/a/a$b.class */
    public static final class b extends com.kwad.components.ad.reward.i.b {
        public b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.xo = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.xp = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i/a/a$c.class */
    public static final class c extends com.kwad.components.ad.reward.i.b {
        public c() {
            this.xo = "基础奖励：观看视频";
            this.xp = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ak.ah(context, com.kwad.sdk.core.response.a.a.aq(d.cb(adTemplate)))) {
            aVar.jx();
        } else {
            aVar.jy();
        }
    }

    private void jw() {
        if (this.xs.isCompleted() && this.xt.isCompleted() && this.xu.isCompleted()) {
            jm();
        } else {
            jn();
        }
    }

    private void jy() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markInstallUncompleted");
        this.xt.jn();
        jw();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.xt.isCompleted() && this.xu.isCompleted();
    }

    public final boolean jA() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "isInstallCompleted");
        return this.xt.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<com.kwad.components.ad.reward.i.c> jk() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xs);
        arrayList.add(this.xu);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int jl() {
        int i = 0;
        for (com.kwad.components.ad.reward.i.c cVar : jk()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void ju() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markWatchVideoCompleted");
        this.xs.jm();
        jw();
    }

    public final boolean jv() {
        return this.xs.isCompleted();
    }

    public final void jx() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markInstallCompleted");
        this.xt.jm();
        jw();
    }

    public final void jz() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markUseAppCompleted");
        this.xu.jm();
        jw();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.xs.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xu.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable th) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xs);
        t.a(jSONObject, "mInstallAppTask", this.xt);
        t.a(jSONObject, "mUseAppTask", this.xu);
        return jSONObject;
    }
}

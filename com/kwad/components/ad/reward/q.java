package com.kwad.components.ad.reward;

import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bb;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/q.class */
public final class q {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/q$a.class */
    static final class a {
        private String errorMsg;
        private boolean qy;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qy = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qy = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qy;
        }
    }

    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String bC = com.kwad.sdk.core.response.a.a.bC(adInfo);
        com.kwad.sdk.core.d.b.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bC);
        if (bb.isNullString(bC)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.q.1
            private void S(String str) {
                com.kwad.components.core.m.a.pb().c(adTemplate, 1, str);
            }

            private void gv() {
                com.kwad.components.core.m.a.pb().c(adTemplate, 0, bw.o);
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c doGet = com.kwad.sdk.b.rZ().doGet(String.this, null);
                    if (doGet == null) {
                        str = "Network Error: url invalid";
                    } else if (doGet.code != 200) {
                        S("Network Error: " + doGet.agf);
                        return;
                    } else {
                        a aVar = new a(doGet.agf);
                        if (aVar.isValid()) {
                            gv();
                            return;
                        }
                        str = aVar.errorMsg;
                    }
                    S(str);
                } catch (Throwable th) {
                    S("Request Error: " + th.getMessage());
                }
            }
        });
    }
}

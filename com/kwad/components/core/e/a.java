package com.kwad.components.core.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.y;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/e/a.class */
public final class a extends d implements f {
    private String Jo;
    private long Jp;
    private String Jq;
    private Context mContext;

    private void Z(Context context) {
        b.i("EncryptComponentsImpl", "initGId");
        try {
            if (at.DW()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("64", 0);
                KWEGIDDFP.handlePolicy(jSONObject);
            }
        } catch (Throwable th) {
            b.printStackTrace(th);
        }
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.components.core.e.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onFailed(int i, String str) {
                b.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public final void onSuccess(String str, String str2) {
                b.d("initGId onSuccess", "deviceInfo：" + str2);
                a.this.nu();
                a.this.as(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str) {
        if (this.mContext == null || bb.isNullString(str) || bb.isEquals(nz(), str)) {
            return;
        }
        this.Jq = str;
        y.Y(this.mContext, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        String bS = y.bS(this.mContext);
        String EF = bd.EF();
        if (TextUtils.isEmpty(bS)) {
            y.Q(this.mContext, EF);
        } else if (TextUtils.equals(bS, EF)) {
        } else {
            this.Jo = "";
            this.Jp = 0L;
            this.Jq = "";
            y.P(this.mContext, "");
            y.f(this.mContext, this.Jp);
            y.Y(this.mContext, this.Jq);
            y.Q(this.mContext, EF);
        }
    }

    private String nx() {
        if (TextUtils.isEmpty(this.Jo)) {
            this.Jo = y.bP(this.mContext);
        }
        return this.Jo;
    }

    private long ny() {
        if (this.Jp == 0) {
            this.Jp = y.bQ(this.mContext);
        }
        return this.Jp;
    }

    private String nz() {
        if (TextUtils.isEmpty(this.Jq)) {
            this.Jq = y.bV(this.mContext);
        }
        return this.Jq;
    }

    @Override // com.kwad.sdk.components.f
    public final void at(String str) {
        if (this.mContext == null || bb.isNullString(str) || bb.isEquals(nx(), str)) {
            return;
        }
        try {
            this.Jo = str;
            y.P(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return f.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
        try {
            this.mContext = context;
            Z(context);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.f
    public final String nv() {
        return (com.kwad.sdk.core.config.d.uq() || System.currentTimeMillis() >= ny() || TextUtils.isEmpty(nx())) ? nz() : "";
    }

    @Override // com.kwad.sdk.components.f
    public final com.kwad.sdk.core.kwai.f nw() {
        return new com.kwad.sdk.core.kwai.a();
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }

    @Override // com.kwad.sdk.components.f
    public final void r(long j) {
        if (this.mContext == null || j <= 0 || j == ny()) {
            return;
        }
        this.Jp = j;
        y.f(this.mContext, j);
    }
}

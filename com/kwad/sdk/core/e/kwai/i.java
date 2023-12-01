package com.kwad.sdk.core.e.kwai;

import android.content.Context;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/e/kwai/i.class */
public final class i {
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            String str = (String) s.a(s.c("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                new StringBuilder("getOAID oaid:").append(str);
                return str;
            } catch (Exception e) {
                return str;
            }
        } catch (Exception e2) {
            return "";
        }
    }
}

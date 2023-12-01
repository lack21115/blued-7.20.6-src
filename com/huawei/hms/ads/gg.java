package com.huawei.hms.ads;

import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gg.class */
public final class gg extends gc {
    private gg() {
    }

    public static gj Code() {
        return new gg();
    }

    private void Code(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
            return;
        }
        if (i != 4) {
            if (i == 5) {
                Log.w(str2, str);
                return;
            } else if (i == 6) {
                Log.e(str2, str);
                return;
            }
        }
        Log.i(str2, str);
    }

    @Override // com.huawei.hms.ads.gj
    public gj Code(String str, String str2) {
        if (this.Code != null) {
            this.Code.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.gj
    public void Code(gl glVar, int i, String str) {
        if (glVar == null) {
            return;
        }
        Code(glVar.V(), i, str);
        if (this.Code != null) {
            this.Code.Code(glVar, i, str);
        }
    }
}

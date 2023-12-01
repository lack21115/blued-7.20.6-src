package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ei.class */
public class ei {
    private static final String Code = "decouple";
    private static a V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ei$a.class */
    public static class a implements IDynamicLoaderAnalysis {
        private Context Code;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderException(String str, String str2, int i, String str3) {
            eh.Code(this.Code, str, str2, i, str3);
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderSuccess(String str, String str2, long j) {
            eh.Code(this.Code, str, str2, j);
        }
    }

    public static void Code(Context context) {
        if (V == null) {
            V = new a(context);
        }
        DynamicLoaderAnalysis.getInstance().registerDynamicLoaderAnalysis(Code, V);
    }
}

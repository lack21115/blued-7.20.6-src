package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AdEventRecord;
import com.huawei.openalliance.ad.inter.data.AdEventType;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/f.class */
public class f {
    private static f Code;
    private static final byte[] V = new byte[0];
    private Context I;

    private f(Context context) {
        this.I = context.getApplicationContext();
    }

    public static f Code(Context context) {
        return V(context);
    }

    private void Code(AdContentData adContentData, Long l, boolean z) {
        if (adContentData == null) {
            return;
        }
        adContentData.V(String.valueOf(v.Code()));
        ko.Code(this.I, adContentData, (String) null, l, Boolean.valueOf(z));
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, Long l, boolean z) {
        Code(dVar.l(), l, z);
        ko.Code(this.I, dVar.l(), Long.valueOf(Math.min(dVar.e() - dVar.d(), dVar.r())), Integer.valueOf(dVar.s()), (Integer) 7, l, Boolean.valueOf(z));
    }

    private static f V(Context context) {
        f fVar;
        synchronized (V) {
            if (Code == null) {
                Code = new f(context);
            }
            fVar = Code;
        }
        return fVar;
    }

    public void Code(List<AdEventRecord> list) {
        com.huawei.openalliance.ad.inter.data.d Code2;
        if (aa.Code(list)) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            AdEventRecord adEventRecord = list.get(i2);
            if (adEventRecord != null && (Code2 = adEventRecord.Code()) != null && Code2.x()) {
                String Z = adEventRecord.Z();
                Long valueOf = Long.valueOf(adEventRecord.B() == null ? v.Code() : adEventRecord.B().longValue());
                boolean z = i2 >= size - 1;
                if ("imp".equalsIgnoreCase(Z)) {
                    Code(Code2, valueOf, z);
                } else if (AdEventType.SHOW_START.equalsIgnoreCase(Z)) {
                    Code(Code2.l(), valueOf, z);
                } else if ("click".equalsIgnoreCase(Z)) {
                    ko.Code(this.I, Code2.l(), null, 0, 0, s.D, 12, null, valueOf, Boolean.valueOf(z), null);
                } else if ("intentSuccess".equalsIgnoreCase(Z)) {
                    ko.Code(this.I, Code2.l(), "intentSuccess", (Integer) 1, (Integer) null, valueOf, Boolean.valueOf(z));
                }
            }
            i = i2 + 1;
        }
    }
}

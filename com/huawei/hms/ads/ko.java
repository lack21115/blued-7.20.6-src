package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ko.class */
public class ko {
    public static AdEventReport Code(AdContentData adContentData) {
        AdEventReport adEventReport = new AdEventReport();
        if (adContentData != null) {
            adEventReport.Code(adContentData.Code());
            adEventReport.Code(adContentData.S());
            adEventReport.Z(adContentData.B());
            adEventReport.B(adContentData.E());
            adEventReport.D(adContentData.ah());
            adEventReport.I(adContentData.ak());
            adEventReport.Code(adContentData.aw());
            adEventReport.Z(adContentData.aA());
            adEventReport.a(adContentData.az());
            adEventReport.b(adContentData.C());
        }
        return adEventReport;
    }

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.p.I, Code(adContentData));
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str) {
        Code(context, adContentData, i, i2, (List<String>) null, str);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, com.huawei.openalliance.ad.inter.data.m mVar, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.I(str);
        Code.V(Integer.valueOf(i3));
        Code.F(str2);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.p.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.I(str);
        Code.V(Integer.valueOf(i3));
        Code.F(str2);
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.p.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, int i3, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.I(str);
        Code.V(Integer.valueOf(i3));
        Code.F(str2);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.p.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, com.huawei.openalliance.ad.inter.data.m mVar, String str2, int[] iArr) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        if (!aa.Code(iArr) && iArr.length > 1) {
            Code.D(Integer.valueOf(iArr[0]));
            Code.L(Integer.valueOf(iArr[1]));
            Code.a(Integer.valueOf(com.huawei.openalliance.ad.utils.ay.L(context)));
        }
        Code.I(str);
        Code.F(str2);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code.Z(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        Code(context, com.huawei.openalliance.ad.constant.p.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2) {
        Code(context, adContentData, i, i2, str, (com.huawei.openalliance.ad.inter.data.m) null, str2, new int[0]);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, String str, String str2, int[] iArr) {
        Code(context, adContentData, i, i2, str, (com.huawei.openalliance.ad.inter.data.m) null, str2, iArr);
    }

    public static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list) {
        Code(context, adContentData, i, i2, list, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, int i, int i2, List<String> list, String str) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.Code(list);
        if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
            Code.V(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.p.C, Code);
    }

    public static void Code(Context context, AdContentData adContentData, long j, int i) {
        kn.a aVar = new kn.a();
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i));
        Code(context, adContentData, true, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, kn knVar) {
        Code(context, adContentData, false, knVar);
    }

    public static void Code(Context context, AdContentData adContentData, kn knVar, String str) {
        Code(context, adContentData, false, knVar, str);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num) {
        AdEventReport Code = Code(adContentData);
        Code.V(num);
        Code(context, com.huawei.openalliance.ad.constant.p.D, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Integer num, String str) {
        AdEventReport Code = Code(adContentData);
        Code.V(num);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.p.F, Code);
    }

    public static void Code(Context context, AdContentData adContentData, Long l, Integer num, Integer num2, Long l2, Boolean bool) {
        kn.a aVar = new kn.a();
        aVar.Code(l).Code(num).V(num2).V(l2).Code(bool);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, Long l, Integer num, Integer num2, String str) {
        kn.a aVar = new kn.a();
        aVar.Code(l);
        aVar.Code(num);
        aVar.V(num2);
        aVar.Code(str);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        Code(context, adContentData, str, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, com.huawei.openalliance.ad.inter.data.m mVar) {
        Code(context, adContentData, str, i, i2, str2, i3, str3, null, null, mVar);
    }

    public static void Code(Context context, AdContentData adContentData, String str, int i, int i2, String str2, int i3, String str3, Long l, Boolean bool, com.huawei.openalliance.ad.inter.data.m mVar) {
        AdEventReport Code = Code(adContentData);
        Code.V(i);
        Code.I(i2);
        Code.I(str2);
        Code.V(Integer.valueOf(i3));
        Code.C(str);
        Code.F(str3);
        Code.Z(l);
        Code.Code(bool);
        if (mVar != null) {
            Code.S(mVar.Code());
            Code.F(mVar.V());
            Code.L(mVar.I());
        }
        Code(context, com.huawei.openalliance.ad.constant.p.B, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2) {
        Code(context, adContentData, str, num, num2, (Long) null, (Boolean) null);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Integer num, Integer num2, Long l, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.B(num);
        Code.C(num2);
        Code.Z(l);
        Code.Code(bool);
        Code(context, com.huawei.openalliance.ad.constant.p.S, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Boolean bool) {
        AdEventReport Code = Code(adContentData);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.p.I, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Integer num, Integer num2, String str2) {
        kn.a aVar = new kn.a();
        aVar.V(str).Code(l).Code(num).V(num2).Code(str2);
        Code(context, adContentData, false, aVar.Code());
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.V(l);
        Code.I(l2);
        Code.I(num);
        Code.Z(num2);
        Code(context, com.huawei.openalliance.ad.constant.p.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, Long l, Long l2, Integer num, Integer num2, String str2) {
        AdEventReport Code = Code(adContentData);
        Code.V(str);
        Code.V(l);
        Code.I(l2);
        Code.I(num);
        Code.Z(num2);
        Code.C(str2);
        Code(context, com.huawei.openalliance.ad.constant.p.Z, Code);
    }

    public static void Code(Context context, AdContentData adContentData, String str, String str2, String str3) {
        AdEventReport Code = Code(adContentData);
        if (str != null) {
            Code.C(str);
        } else {
            ge.I("event", "on ad rewarded, customData is null");
        }
        if (str2 != null) {
            Code.S(str2);
        } else {
            ge.I("event", "on ad rewarded, userId is null");
        }
        Code.F(str3);
        Code(context, com.huawei.openalliance.ad.constant.p.b, Code);
    }

    public static void Code(Context context, AdContentData adContentData, List<FeedbackInfo> list, int i) {
        AdEventReport Code = Code(adContentData);
        Code.C(String.valueOf(i));
        Code.V(list);
        Code(context, com.huawei.openalliance.ad.constant.p.w, Code);
    }

    public static void Code(Context context, AdContentData adContentData, boolean z) {
        AdEventReport Code = Code(adContentData);
        Code.V(z);
        Code(context, com.huawei.openalliance.ad.constant.p.i, Code);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, kn knVar) {
        Code(context, adContentData, z, knVar, (String) null);
    }

    private static void Code(Context context, AdContentData adContentData, boolean z, kn knVar, String str) {
        if (adContentData == null) {
            ge.I("EvtProcessor", "on ad show, ad data is null");
            return;
        }
        AdEventReport Code = Code(adContentData);
        Code.Code(z);
        if (knVar != null) {
            if (knVar.S() != null) {
                Code.C(knVar.S());
            }
            if (knVar.Code() != null) {
                Code.Code(knVar.Code());
            }
            if (knVar.V() != null) {
                Code.Code(knVar.V());
            }
            if (knVar.I() != null) {
                Code.V(knVar.I());
            }
            if (knVar.Z() != null) {
                Code.F(knVar.Z());
            }
            if (knVar.B() != null) {
                Code.Z(knVar.B());
            }
            if (knVar.C() != null) {
                Code.Code(knVar.C());
            }
        }
        if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
            Code.V(str);
        }
        Code(context, com.huawei.openalliance.ad.constant.p.V, Code);
    }

    private static void Code(Context context, String str, AdEventReport adEventReport) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.h.Code(context, adEventReport.r()).Code(str, com.huawei.openalliance.ad.utils.z.V(adEventReport), null, null);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, com.huawei.openalliance.ad.constant.p.d, Code(adContentData));
    }

    public static void V(Context context, AdContentData adContentData, String str) {
        AdEventReport Code = Code(adContentData);
        Code.C(str);
        Code(context, com.huawei.openalliance.ad.constant.p.e, Code);
    }
}

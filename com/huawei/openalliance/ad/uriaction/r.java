package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/r.class */
public class r {
    private static final String Code = r.class.getSimpleName();

    public static q Code(Context context, AdContentData adContentData, Map<String, String> map) {
        if (context == null || adContentData == null || map == null) {
            return new k();
        }
        List<q> Code2 = Code(context, adContentData, map, adContentData.m());
        if (Code2 == null || Code2.size() <= 0) {
            return new k();
        }
        q qVar = null;
        for (q qVar2 : Code2) {
            if (qVar != null) {
                qVar.Code(qVar2);
            }
            qVar = qVar2;
        }
        return Code2.get(0);
    }

    private static List<q> Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        f lVar;
        ArrayList arrayList = null;
        if (list != null) {
            arrayList = null;
            if (list.size() > 0) {
                ArrayList arrayList2 = new ArrayList(list.size());
                q qVar = null;
                for (Integer num : list) {
                    int intValue = num.intValue();
                    if (intValue != 300) {
                        switch (intValue) {
                            case 0:
                                lVar = new k();
                                break;
                            case 1:
                                lVar = new j(context, adContentData, false, map);
                                break;
                            case 2:
                                lVar = new i(context, adContentData, map);
                                break;
                            case 3:
                                lVar = new a(context, adContentData);
                                break;
                            case 4:
                                lVar = new j(context, adContentData, true, map);
                                break;
                            case 5:
                                lVar = new n(context, adContentData);
                                break;
                            case 6:
                                lVar = new c(context, adContentData);
                                break;
                            case 7:
                                lVar = new b(context, adContentData);
                                break;
                            case 8:
                                lVar = new m(context, adContentData);
                                break;
                            case 9:
                                lVar = new p(context, adContentData);
                                break;
                            default:
                                switch (intValue) {
                                    case 11:
                                        lVar = new g(context, adContentData);
                                        break;
                                    case 12:
                                        lVar = new e(context, adContentData);
                                        break;
                                    case 13:
                                        lVar = qVar;
                                        if (kv.Code(context)) {
                                            lVar = new o(context, adContentData);
                                            break;
                                        }
                                        break;
                                    case 14:
                                        lVar = new f(context, adContentData, true, map);
                                        break;
                                    default:
                                        ge.I(Code, "unsupport action:" + num);
                                        lVar = null;
                                        break;
                                }
                        }
                    } else {
                        lVar = new l(context, adContentData, map);
                    }
                    qVar = lVar;
                    if (lVar != null) {
                        arrayList2.add(lVar);
                        qVar = lVar;
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }
}

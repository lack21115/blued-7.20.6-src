package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.ApiStatisticsReq;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eh.class */
public class eh {
    public static void Code(Context context) {
        V(context, eg.F, null, null, null);
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final long j2, final long j3) {
        if (j <= 0 || j > j2) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                DelayInfo delayInfo;
                ArrayList arrayList2;
                if (!com.huawei.openalliance.ad.utils.af.Code(Map.this)) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it = Map.this.entrySet().iterator();
                    DelayInfo delayInfo2 = null;
                    while (true) {
                        arrayList = arrayList3;
                        arrayList2 = arrayList4;
                        delayInfo = delayInfo2;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        arrayList3.add(entry.getKey());
                        List list = (List) entry.getValue();
                        if (!aa.Code(list)) {
                            Iterator it2 = list.iterator();
                            DelayInfo delayInfo3 = delayInfo2;
                            while (true) {
                                delayInfo2 = delayInfo3;
                                if (it2.hasNext()) {
                                    com.huawei.openalliance.ad.inter.data.d dVar = (com.huawei.openalliance.ad.inter.data.d) it2.next();
                                    if (dVar != null) {
                                        DelayInfo delayInfo4 = delayInfo3;
                                        if (dVar instanceof c) {
                                            c cVar = (c) dVar;
                                            delayInfo4 = delayInfo3;
                                            if (cVar.j_() != null) {
                                                delayInfo4 = cVar.j_();
                                            }
                                        }
                                        arrayList4.add(dVar.D());
                                        delayInfo3 = delayInfo4;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    arrayList = null;
                    delayInfo = null;
                    arrayList2 = null;
                }
                DelayInfo delayInfo5 = delayInfo;
                if (delayInfo == null) {
                    delayInfo5 = new DelayInfo();
                }
                delayInfo5.Code(arrayList);
                delayInfo5.V(arrayList2);
                delayInfo5.j().Code(j);
                delayInfo5.j().V(j2);
                delayInfo5.j().c(j3);
                eh.V(context, com.huawei.openalliance.ad.constant.p.f22953c, com.huawei.openalliance.ad.utils.z.V(eh.V(j2 - j, com.huawei.openalliance.ad.constant.f.Code, str, i2, i, delayInfo5)), null, null);
            }
        });
    }

    public static <T extends com.huawei.openalliance.ad.inter.data.d> void Code(final Context context, final int i, final String str, final int i2, final Map<String, List<T>> map, final long j, final DelayInfo delayInfo) {
        if (ge.Code()) {
            boolean z = false;
            if (delayInfo != null) {
                z = true;
            }
            ge.Code("AnalysisReport", "reportE2ECostTime,  duration = %s delayInfo: %s", Long.valueOf(j), Boolean.valueOf(z));
        }
        if (context == null || delayInfo == null || j <= 0) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                ArrayList arrayList2;
                if (!com.huawei.openalliance.ad.utils.af.Code(Map.this)) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it = Map.this.entrySet().iterator();
                    while (true) {
                        arrayList = arrayList3;
                        arrayList2 = arrayList4;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        arrayList3.add(entry.getKey());
                        List<com.huawei.openalliance.ad.inter.data.d> list = (List) entry.getValue();
                        if (!aa.Code(list)) {
                            for (com.huawei.openalliance.ad.inter.data.d dVar : list) {
                                if (dVar != null) {
                                    arrayList4.add(dVar.D());
                                }
                            }
                        }
                    }
                } else {
                    arrayList = null;
                    arrayList2 = null;
                }
                delayInfo.Code(arrayList);
                delayInfo.V(arrayList2);
                eh.V(context, com.huawei.openalliance.ad.constant.p.f22953c, com.huawei.openalliance.ad.utils.z.V(eh.V(j, com.huawei.openalliance.ad.constant.f.Code, str, i2, i, delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, int i, String str, AdContentData adContentData) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.C(adContentData.S());
        analysisEventReport.S(adContentData.az());
        analysisEventReport.F(adContentData.C());
        analysisEventReport.I(adContentData.aA());
        V(context, com.huawei.openalliance.ad.constant.p.q, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, int i, String str, String str2, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(i);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        analysisEventReport.B(str3);
        V(context, com.huawei.openalliance.ad.download.app.a.Code.equals(str3) ? eg.I : eg.Z, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, long j, long j2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(j);
        analysisEventReport.I(j2);
        if (adContentData != null) {
            analysisEventReport.C(adContentData.S());
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        } else {
            analysisEventReport.C("");
        }
        V(context, eg.V, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(Context context, AdContentData adContentData, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.I(str);
        if (adContentData != null) {
            analysisEventReport.C(adContentData.S());
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        V(context, com.huawei.openalliance.ad.constant.p.v, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final int i, final AdContentData adContentData, final DelayInfo delayInfo) {
        if (delayInfo == null || delayInfo.Code() == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.2
            @Override // java.lang.Runnable
            public void run() {
                AdContentData adContentData2 = AdContentData.this;
                if (adContentData2 != null) {
                    delayInfo.V(adContentData2.af());
                    delayInfo.V(Collections.singletonList(AdContentData.this.S()));
                    delayInfo.Code(AdContentData.this.al());
                    delayInfo.Code(Integer.valueOf(AdContentData.this.h()));
                    DelayInfo ai = AdContentData.this.ai();
                    if (ai != null) {
                        delayInfo.C(ai.c());
                        delayInfo.Code(ai.V());
                        delayInfo.I(ai.Z());
                        delayInfo.B(ai.C());
                        delayInfo.V(ai.I());
                        delayInfo.F(ai.g().longValue());
                        delayInfo.I(ai.m());
                        AdTimeStatistics j = ai.j();
                        if (j != null) {
                            AdTimeStatistics j2 = delayInfo.j();
                            j.Code(j2.Code());
                            j.V(j2.V());
                            j.c(j2.c());
                            j.d(j2.d());
                            j.e(j2.e());
                            delayInfo.Code(j);
                        }
                    }
                }
                eh.V(context, com.huawei.openalliance.ad.constant.p.f22953c, com.huawei.openalliance.ad.utils.z.V(eh.V(delayInfo.Code().longValue(), com.huawei.openalliance.ad.constant.f.Code, str, i, eh.V(delayInfo), delayInfo)), null, null);
            }
        });
    }

    public static void Code(Context context, String str, AdContentData adContentData, String str2) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.C(str);
        analysisEventReport.I(str2);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        V(context, eg.C, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final int i2, final String str3) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.1
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.Code(i2);
                analysisEventReport.V(i);
                analysisEventReport.I(str);
                analysisEventReport.Z(str2);
                analysisEventReport.B(str3);
                eh.V(context, eg.Code, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final int i, final String str3) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.6
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(String.this);
                analysisEventReport.Z(str2);
                analysisEventReport.Code(i);
                analysisEventReport.B(str3);
                eh.V(context, eg.D, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(final Context context, final String str, final String str2, final long j) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.eh.5
            @Override // java.lang.Runnable
            public void run() {
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.I(String.this);
                analysisEventReport.Z(str2);
                analysisEventReport.V(j);
                analysisEventReport.Code(0);
                eh.V(context, eg.D, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
            }
        });
    }

    public static void Code(Context context, String str, String str2, long j, AdContentData adContentData, String str3) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.C(str2);
        analysisEventReport.I(str);
        analysisEventReport.I(j);
        analysisEventReport.V(str3);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.I(adContentData.aA());
        }
        I(context, eg.B, com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    private static <T> void I(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.d.Code(context).Code(str, str2, remoteCallResultCallback, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int V(DelayInfo delayInfo) {
        int i;
        int f = delayInfo.f();
        if (f == -2) {
            int i2 = 10000;
            Integer F = com.huawei.openalliance.ad.utils.au.F(delayInfo.b());
            if (F != null) {
                i2 = 10000 + F.intValue();
            }
            i = i2 + delayInfo.i();
        } else {
            i = f;
            if (f == 494) {
                Integer l = delayInfo.l();
                i = f;
                if (l != null) {
                    i = l.intValue();
                }
            }
        }
        delayInfo.I(i);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiStatisticsReq V(long j, String str, String str2, int i, int i2, DelayInfo delayInfo) {
        ApiStatisticsReq apiStatisticsReq = new ApiStatisticsReq();
        apiStatisticsReq.V(j);
        apiStatisticsReq.V(str);
        apiStatisticsReq.S(str2);
        apiStatisticsReq.I(i);
        apiStatisticsReq.V(i2);
        apiStatisticsReq.Code(delayInfo);
        return apiStatisticsReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void V(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        com.huawei.openalliance.ad.ipc.g.V(context).Code(str, str2, remoteCallResultCallback, cls);
    }
}

package com.opos.acs.st.utils;

import android.content.Context;
import android.media.TtmlUtils;
import android.provider.Downloads;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.common.net.HttpHeaders;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.entity.StrategyEntity;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24473a = new byte[0];
    private static final ReadWriteLock b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static Timer f24474c = null;
    private static final byte[] d = new byte[0];
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static final ReentrantReadWriteLock h = new ReentrantReadWriteLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/h$a.class */
    public interface a {
        void a();

        void a(String str, String str2);
    }

    private static com.opos.acs.st.b.c a(Context context, String str, Map<String, String> map, boolean z) {
        int i;
        com.opos.acs.st.b.c cVar = new com.opos.acs.st.b.c();
        cVar.b = str;
        cVar.f24456c = map.get("adId");
        cVar.d = a(context, str, map);
        if (map.get("parEvtId") != null) {
            cVar.h = map.get("parEvtId");
        }
        cVar.i = System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        StrategyEntity i2 = i(context);
        MetaEntity c2 = c(context, str);
        List<String> list = null;
        List<String> list2 = null;
        List<String> list3 = c2 != null ? c2.eventKeys : null;
        if (z) {
            if (i2 != null) {
                list2 = i2.commonKeys;
            }
            cVar.k = a(context, list2, map);
            cVar.l = a(context, list3, map);
            i = 1;
        } else {
            String a2 = a(context, str);
            List<String> list4 = i2 != null ? i2.headKeys : null;
            if (i2 != null) {
                list = i2.bodyKeys;
            }
            cVar.e = a(context, list4, map, a2);
            cVar.f = a(context, list, map, a2);
            cVar.g = a(context, list3, map, ",");
            i = 0;
        }
        cVar.j = i;
        long currentTimeMillis2 = System.currentTimeMillis();
        com.opos.cmn.an.f.a.a("Utils", "map2AcsStDbCache,dataType=" + str + ",cost time=" + (currentTimeMillis2 - currentTimeMillis));
        return cVar;
    }

    public static String a(Context context) {
        return com.opos.cmn.an.h.c.a.f(context);
    }

    private static String a(Context context, com.opos.acs.st.b.c cVar) {
        if (cVar == null) {
            return "";
        }
        boolean z = cVar.j == 0;
        try {
            d.a("Utils", "dataType=" + cVar.b + ",acsId=" + cVar.f24456c);
            if (z && cVar.f != null) {
                cVar.f = cVar.f.replace("sessionIdRpl", "1");
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(b(context, cVar));
            return jSONArray.toString();
        } catch (Exception e2) {
            d.b("Utils", "acsStDbCache2JsonString:" + e2.toString());
            return "";
        }
    }

    private static String a(Context context, String str) {
        MetaEntity metaEntity;
        STConfigEntity b2 = g.b(context);
        return (b2 == null || b2.dataEntity == null || b2.dataEntity.metaEntityMap == null || str == null || (metaEntity = b2.dataEntity.metaEntityMap.get(str)) == null || metaEntity.split == null) ? "\t" : metaEntity.split;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        String str2;
        if (context == null || map == null || b(context, str)) {
            return null;
        }
        StrategyEntity i = i(context);
        MetaEntity c2 = c(context, str);
        if (c2 != null) {
            String str3 = c2.url;
            if (a(str3) || i == null) {
                return null;
            }
            int i2 = i.prtflg;
            StringBuilder sb = new StringBuilder();
            if (str3.startsWith("http://")) {
                String replace = str3.replace("http://", "");
                sb.append("http://");
                str2 = str3;
                str3 = replace;
            } else if (str3.startsWith("https://")) {
                String replace2 = str3.replace("https://", "");
                sb.append("https://");
                str2 = str3;
                str3 = replace2;
            } else if (i2 == 1) {
                str2 = "https://" + str3;
                sb.append("https://");
            } else {
                str2 = "http://" + str3;
                sb.append("http://");
            }
            d.a("Utils", "prtflg = ".concat(String.valueOf(i2)));
            d.a("Utils", "nonDmDefaultUrlUrl:".concat(String.valueOf(str3)));
            d.a("Utils", "dmDefaultUrlUrl:".concat(String.valueOf(str2)));
            d.a("Utils", "urlBuffer:".concat(String.valueOf(sb)));
            List<String> list = i.dmKeys;
            String str4 = map.get("dm");
            int i3 = -1;
            if (str4 != null) {
                try {
                    i3 = Integer.parseInt(str4);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("Utils", "createUrl error", e2);
                    i3 = -1;
                }
            }
            String substring = str3.substring(0, str3.indexOf(BridgeUtil.SPLIT_MARK));
            String str5 = map.get("area");
            String substring2 = str3.substring(str3.indexOf(BridgeUtil.SPLIT_MARK));
            if (i3 < 0 || list == null || i3 >= list.size()) {
                sb.append(substring);
            } else {
                sb.append(list.get(i3));
            }
            if (str5 != null && !"".equals(str5.trim())) {
                sb.append(BridgeUtil.SPLIT_MARK);
                sb.append(str5);
            }
            if (!"".equals(substring2.trim())) {
                sb.append(substring2);
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0295, code lost:
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02c1, code lost:
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03ab, code lost:
        if (r9 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        if ("0".equalsIgnoreCase(r0) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c9, code lost:
        if (r5 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e8, code lost:
        if (a(r0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0183, code lost:
        if (r6 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 996
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, boolean):java.lang.String");
    }

    private static String a(Context context, List<com.opos.acs.st.b.c> list) {
        String replace;
        if (list == null || list.size() <= 0) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.acs.st.b.c cVar : list) {
                if (cVar.j == 0) {
                    if (a(context, cVar.b, cVar.h)) {
                        d.a("Utils", "dataType=" + cVar.b + ",acsId=" + cVar.f24456c + ",effective");
                        replace = cVar.f.replace("sessionIdRpl", "1");
                    } else {
                        d.a("Utils", "dataType=" + cVar.b + ",acsId=" + cVar.f24456c + "， not effective");
                        replace = cVar.f.replace("sessionIdRpl", "0");
                    }
                    cVar.f = replace;
                }
                jSONArray.put(b(context, cVar));
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            d.b("Utils", "acsStDbCache2JsonString:" + e2.toString());
            return "";
        }
    }

    private static String a(Context context, List<String> list, Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null && context != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                String str2 = list.get(i2);
                if (str2 != null && !"eventKeys".equals(str2)) {
                    sb.append(a(context, str2, map, str, false));
                    if (i2 < list.size() - 1) {
                        sb.append(str);
                    }
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    private static String a(Context context, List<String> list, Map<String, String> map, boolean z) {
        String str = "";
        if (list != null) {
            str = "";
            if (context != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            break;
                        }
                        String str2 = list.get(i2);
                        if (str2 != null && !"eventKeys".equals(str2)) {
                            if ("ext".equals(str2)) {
                                jSONObject.put(str2, "");
                            } else {
                                jSONObject.put(str2, a(context, str2, map, "", z));
                            }
                        }
                        i = i2 + 1;
                    }
                    str = jSONObject.toString();
                } catch (JSONException e2) {
                    d.b("Utils", "", e2);
                    str = "";
                }
            }
        }
        d.a("Utils", "getExtJsonValues = ".concat(String.valueOf(str)));
        return str;
    }

    private static String a(Context context, Map<String, String> map, boolean z) {
        String str;
        synchronized (h.class) {
            try {
                StrategyEntity i = i(context);
                String a2 = com.opos.cmn.an.a.d.a(a(context, i != null ? i.extKeys : null, map, z));
                str = a2;
                if (a2 == null) {
                    str = "";
                }
            } finally {
            }
        }
        return str;
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(BridgeUtil.UNDERLINE_STR);
        if (split.length > 0) {
            try {
                int parseInt = Integer.parseInt(split[0]);
                return (parseInt + 1) + BridgeUtil.UNDERLINE_STR + str2;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("Utils", "getRetStr error", e2);
                return null;
            }
        }
        return null;
    }

    private static JSONObject a(Context context, List<String> list, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (list != null && context != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                String str = list.get(i2);
                if (str != null && !"eventKeys".equals(str)) {
                    try {
                        String a2 = a(context, str, map, "", true);
                        if (a2 != null) {
                            jSONObject.put(str, a2);
                        }
                    } catch (JSONException e2) {
                        com.opos.cmn.an.f.a.b("Utils", "getValueJsonObject", e2);
                    }
                }
                i = i2 + 1;
            }
        }
        return jSONObject;
    }

    public static void a() {
        synchronized (h.class) {
            try {
                synchronized (d) {
                    d.b("lshxjtu", "cancelReportTimer isCancelTimering=" + f);
                    if (f24474c != null && !f) {
                        f = true;
                        d.b("lshxjtu", "cancelReportTimer really start!!!");
                        f24474c.cancel();
                        f24474c = null;
                    }
                    f = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.b.c cVar, int i, int i2) {
        synchronized (f24473a) {
            if (i != 0) {
                String a2 = a(context, cVar.b);
                com.opos.acs.st.b.c a3 = com.opos.acs.st.a.b.a(context, cVar.b, cVar.f24456c, cVar.d);
                if (a3 == null) {
                    com.opos.acs.st.a.b.a(context, cVar);
                } else {
                    if (cVar.j == 0) {
                        int lastIndexOf = a3.f.lastIndexOf(a2);
                        if (lastIndexOf > 0) {
                            try {
                                String substring = a3.f.substring(lastIndexOf + 1);
                                d.a("Utils", "count=".concat(String.valueOf(substring)));
                                int parseInt = Integer.parseInt(substring);
                                a3.f = a3.f.substring(0, lastIndexOf);
                                a3.f += a2 + (parseInt + 1);
                            } catch (Exception e2) {
                                e = e2;
                                com.opos.cmn.an.f.a.d("Utils", "insertOrMergeAcsStDbCache", e);
                                com.opos.acs.st.a.b.b(context, a3);
                            }
                        }
                    } else {
                        try {
                            JSONObject jSONObject = a3.k;
                            if (jSONObject != null && jSONObject.has("count")) {
                                jSONObject.put("count", jSONObject.optInt("count") + 1);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.opos.cmn.an.f.a.d("Utils", "insertOrMergeAcsStDbCache", e);
                            com.opos.acs.st.a.b.b(context, a3);
                        }
                    }
                    com.opos.acs.st.a.b.b(context, a3);
                }
            } else {
                com.opos.acs.st.a.b.a(context, cVar);
                if (i2 > 0) {
                    int intValue = com.opos.acs.st.a.b.a(context, cVar.b).intValue();
                    d.a("Utils", cVar.b + "已经有事件 count=" + intValue);
                    if (intValue != 0 && intValue >= i2) {
                        b(context, cVar.b, cVar.d);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, com.opos.acs.st.b.c r6, java.lang.String r7) {
        /*
            r0 = r6
            if (r0 == 0) goto L74
            r0 = r7
            if (r0 == 0) goto L74
            r0 = r6
            int r0 = r0.j
            if (r0 != 0) goto L74
            r0 = r6
            java.lang.String r0 = r0.g
            r8 = r0
            r0 = r8
            boolean r0 = a(r0)
            if (r0 != 0) goto L35
            java.lang.String r0 = "(?<=\\#)(\\S+)(?=\\#)"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r8
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r8 = r0
            r0 = r8
            boolean r0 = r0.find()
            if (r0 == 0) goto L35
            r0 = r8
            java.lang.String r0 = r0.group()
            r8 = r0
            goto L37
        L35:
            r0 = 0
            r8 = r0
        L37:
            r0 = r8
            r1 = r7
            java.lang.String r0 = a(r0, r1)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L74
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "#"
            r1.<init>(r2)
            r8 = r0
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = "#"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r0 = r0.toString()
            r7 = r0
            r0 = r6
            r1 = r6
            java.lang.String r1 = r1.g
            java.lang.String r2 = "#.*?#"
            r3 = r7
            java.lang.String r1 = r1.replaceAll(r2, r3)
            r0.g = r1
            r0 = r5
            r1 = r6
            boolean r0 = com.opos.acs.st.a.b.b(r0, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, com.opos.acs.st.b.c, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, com.opos.acs.st.utils.h.a r10) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.opos.acs.st.utils.h$a):void");
    }

    public static void a(final Context context, final Map<String, String> map, final STManager.EventListener eventListener) {
        boolean z;
        int i;
        MetaEntity metaEntity;
        JSONObject b2;
        if (context == null || map == null) {
            return;
        }
        d.a("Utils", "report recordEvent start:".concat(String.valueOf(map)));
        String str = map.get(STManager.KEY_DATA_TYPE);
        if (str != null) {
            if (!"".equals(str.trim())) {
                if (b(context, str)) {
                    d.a("Utils", "report no strategy,save data!dataType=".concat(String.valueOf(str)));
                    long currentTimeMillis = System.currentTimeMillis();
                    com.opos.acs.st.b.a aVar = new com.opos.acs.st.b.a();
                    aVar.b = (map == null || (b2 = com.opos.acs.st.b.a.b(map)) == null) ? null : b2.toString();
                    aVar.f24452c = currentTimeMillis;
                    aVar.d = currentTimeMillis;
                    com.opos.acs.st.a.c.a(context, aVar);
                    g.b(context, str);
                    b(true, 6, eventListener);
                    return;
                }
                final MetaEntity c2 = c(context, str);
                boolean equals = "wbs".equals(c2.version);
                map.put("count", "1");
                map.put("clickId", d());
                map.put("category", String.valueOf(c2.category));
                map.put("eventValue", String.valueOf(c2.eventValue));
                map.put("oriDatatype", equals ? "" : str);
                String str2 = map.get("statUploadStrategy");
                boolean z2 = (equals || "3".equals(str2) || "2".equals(str2)) ? false : true;
                if (!equals && !"3".equals(str2)) {
                    final boolean z3 = z2;
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.acs.st.utils.h.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.a(Context.this, false, z3, map, c2, eventListener);
                        }
                    });
                }
                if (equals || "3".equals(str2) || "2".equals(str2)) {
                    if (equals) {
                        metaEntity = c2;
                    } else {
                        String str3 = c2.newDatatype;
                        if (TextUtils.isEmpty(str3)) {
                            com.opos.cmn.an.f.a.d("Utils", "No associate new dataType!");
                            e.a(context);
                            e.a(ErrorContants.errorContantseMap(context, "5", ErrorContants.NO_NEW_OLD_ASSOCIATE, "", "", 0L, 0L, "old dataType:" + str + ",new dataType:" + str3));
                            metaEntity = null;
                        } else {
                            MetaEntity c3 = c(context, str3);
                            metaEntity = c3;
                            if (c3 == null) {
                                com.opos.cmn.an.f.a.d("Utils", "No associate dataType strategy!");
                                e.a(context);
                                e.a(ErrorContants.errorContantseMap(context, "5", ErrorContants.NO_NEW_STRATEGY_ERROR, "", "", 0L, 0L, "old dataType:" + str + ",new dataType:" + str3));
                                g.b(context, str3);
                                metaEntity = c3;
                            }
                        }
                    }
                    if (metaEntity != null) {
                        a(context, true, false, map, metaEntity, eventListener);
                    }
                }
                z = !z2;
                i = 7;
                b(z, i, eventListener);
            }
        }
        z = true;
        d.b("Utils", "report dataType is empty!");
        i = 4;
        b(z, i, eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Context context, final boolean z, final boolean z2, Map<String, String> map, final MetaEntity metaEntity, final STManager.EventListener eventListener) {
        String str;
        String str2;
        int i;
        if (metaEntity.uploadFlag != 0) {
            StrategyEntity i2 = i(context);
            final com.opos.acs.st.b.c a2 = a(context, metaEntity.dataType, map, z);
            if (!com.opos.cmn.an.h.c.a.d(context)) {
                d.a("Utils", "report data fail:no net!");
                a(context, a2, metaEntity.aggrFlag, i2.triggerNums);
                b(z2, 5, eventListener);
                return;
            }
            if (metaEntity.immFlag != 0) {
                d.a("Utils", "report data immediately.dataType= " + metaEntity.dataType + ",new dataType= " + z);
                final String str3 = a2.d;
                if (TextUtils.isEmpty(str3)) {
                    i = 4;
                } else {
                    String a3 = a(context, a2);
                    final long currentTimeMillis = System.currentTimeMillis();
                    a(context, str3, a3, metaEntity.dataType, new a() { // from class: com.opos.acs.st.utils.h.2
                        @Override // com.opos.acs.st.utils.h.a
                        public final void a() {
                            h.b(z2, 1, eventListener);
                        }

                        @Override // com.opos.acs.st.utils.h.a
                        public final void a(String str4, String str5) {
                            if (!"400".equals(str4)) {
                                h.a(context, a2, metaEntity.aggrFlag, 0);
                                if (!z) {
                                    h.a(context, a2, str4);
                                }
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            String str6 = metaEntity.dataType;
                            String str7 = z ? ErrorContants.NEW_REALTIME_REPORT_ERROR : ErrorContants.REALTIME_REPORT_ERROR;
                            e.a(context);
                            Context context2 = context;
                            String str8 = str3;
                            e.a(ErrorContants.errorContantseMap(context2, "5", str7, str8, str4, currentTimeMillis2, currentTimeMillis2, "dataType:" + str6 + "response:" + str5));
                            h.b(z2, 2, eventListener);
                        }
                    });
                }
            } else {
                d.a("Utils", "report data delay!insert db.dataType=" + metaEntity.dataType + ",is new dataType=" + z);
                a(context, a2, metaEntity.aggrFlag, i2.triggerNums);
                b(z2, 5, eventListener);
            }
            if (!z && (str = map.get("parEvtId")) != null && !"".equals(str.trim())) {
                try {
                    b.writeLock().lock();
                    d.a("Utils", "evtParentId=".concat(String.valueOf(str)));
                    com.opos.acs.st.b.b b2 = com.opos.acs.st.a.b.b(context, str);
                    if (b2 == null) {
                        com.opos.acs.st.b.b bVar = new com.opos.acs.st.b.b();
                        bVar.b = str;
                        bVar.f24454c = map.get(STManager.KEY_AD_POS_ID);
                        if (metaEntity.immFlag != 0) {
                            bVar.d = 1;
                        } else if (metaEntity.judgePosids != null) {
                            bVar.d = 0;
                        }
                        d.a("Utils", "insertStatBatchEntity:".concat(String.valueOf(bVar)));
                        com.opos.acs.st.a.b.a(context, bVar);
                    } else if (b2.d == 0) {
                        if (metaEntity.immFlag != 0) {
                            b2.d = 1;
                        } else if (b2.f24454c != null && (str2 = map.get(STManager.KEY_AD_POS_ID)) != null && !b2.f24454c.contains(str2)) {
                            b2.f24454c += "|" + map.get(STManager.KEY_AD_POS_ID);
                        }
                        com.opos.acs.st.a.b.b(context, b2);
                        d.a("Utils", "updateStatBatchEntity:".concat(String.valueOf(b2)));
                    }
                    b.writeLock().unlock();
                } catch (Throwable th) {
                    b.writeLock().unlock();
                    throw th;
                }
            }
            d.a("Utils", "report recordEvent end!!!!!!!dataType=" + metaEntity.dataType);
            return;
        }
        d.a("Utils", "report no need upload!");
        i = 3;
        b(z2, i, eventListener);
    }

    static /* synthetic */ void a(Context context, Integer[] numArr, List list) {
        com.opos.acs.st.a.b.a(context, numArr);
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            b.writeLock().lock();
            d.a("Utils", "delete batchIds:".concat(String.valueOf(list)));
            com.opos.acs.st.a.b.a(context, list);
            b.writeLock().unlock();
        } catch (Throwable th) {
            b.writeLock().unlock();
            throw th;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        MetaEntity c2;
        List<String> list;
        d.a("Utils", "start ifDataEffective");
        if (str2 == null || "".equals(str2)) {
            return true;
        }
        try {
            b.readLock().lock();
            com.opos.acs.st.b.b b2 = com.opos.acs.st.a.b.b(context, str2);
            b.readLock().unlock();
            d.a("Utils", "statBatchEntity=".concat(String.valueOf(b2)));
            if (b2 != null) {
                if (b2.d == 1 || b2.f24454c == null || b(context, str) || (c2 = c(context, str)) == null || (list = c2.judgePosids) == null || list.size() == 0) {
                    return true;
                }
                d.a("Utils", "statBatchEntity.acsPosIds=" + b2.f24454c);
                String[] split = b2.f24454c.split("\\|");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    String str3 = list.get(i2);
                    int length = split.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < length) {
                            String str4 = split[i4];
                            if (!Pattern.compile(str3).matcher(str4).find()) {
                                d.a("Utils", "judgePosid=" + str3 + ",acsPosId=" + str4 + " not match!");
                                return true;
                            }
                            i3 = i4 + 1;
                        }
                    }
                    i = i2 + 1;
                }
            }
            d.a("Utils", "end ifDataEffective");
            return false;
        } catch (Throwable th) {
            b.readLock().unlock();
            throw th;
        }
    }

    private static boolean a(STConfigEntity sTConfigEntity) {
        boolean z = false;
        if (sTConfigEntity != null) {
            z = false;
            if (sTConfigEntity.dataEntity != null) {
                z = false;
                if (sTConfigEntity.dataEntity.metaEntityMap != null) {
                    z = false;
                    if (sTConfigEntity.dataEntity.metaEntityMap.size() > 0) {
                        try {
                            Iterator<Map.Entry<String, MetaEntity>> it = sTConfigEntity.dataEntity.metaEntityMap.entrySet().iterator();
                            while (true) {
                                z = false;
                                if (!it.hasNext()) {
                                    break;
                                } else if (it.next().getValue().immFlag == 0) {
                                    z = true;
                                    break;
                                }
                            }
                        } catch (Exception e2) {
                            d.a("Utils", "", e2);
                            z = false;
                        }
                    }
                }
            }
        }
        d.a("Utils", "getReportTimer=".concat(String.valueOf(z)));
        return z;
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1000];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            d.b("Utils", "", e2);
            return null;
        }
    }

    private static JSONObject b(Context context, com.opos.acs.st.b.c cVar) throws JSONException {
        boolean z = cVar.j == 0;
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            JSONObject jSONObject2 = cVar.k;
            JSONObject jSONObject3 = cVar.l;
            JSONObject jSONObject4 = jSONObject2;
            if (jSONObject2 == null) {
                jSONObject4 = new JSONObject();
            }
            JSONObject jSONObject5 = jSONObject3;
            if (jSONObject3 == null) {
                jSONObject5 = new JSONObject();
            }
            jSONObject4.put("evtTime", cVar.i);
            jSONObject4.put(STManager.KEY_DATA_TYPE, cVar.b);
            jSONObject.put("header", jSONObject4);
            jSONObject.put(TtmlUtils.TAG_BODY, jSONObject5);
            return jSONObject;
        }
        String str = cVar.g;
        String str2 = str;
        if (str != null) {
            str2 = str.replace("#", "");
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("evtTime", cVar.i);
        jSONObject6.put(STManager.KEY_DATA_TYPE, cVar.b);
        jSONObject.put(Downloads.Impl.RequestHeaders.URI_SEGMENT, jSONObject6);
        String a2 = a(context, cVar.b);
        jSONObject.put(TtmlUtils.TAG_BODY, cVar.e + a2 + cVar.f + a2 + str2);
        return jSONObject;
    }

    public static void b(Context context) {
        STConfigEntity b2;
        if (context == null || (b2 = g.b(context)) == null || b2.dataEntity == null || b2.dataEntity.strategyEntity == null || b2.dataEntity.metaEntityMap == null) {
            return;
        }
        List<String> a2 = com.opos.acs.st.a.b.a(context);
        synchronized (f24473a) {
            for (String str : b2.dataEntity.metaEntityMap.keySet()) {
                if (a2 != null && a2.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < a2.size()) {
                            b(context, str, a2.get(i2));
                            i = i2 + 1;
                        }
                    }
                }
            }
            int i3 = b2.dataEntity.strategyEntity.reportLimit;
            int i4 = i3;
            if (i3 <= 0) {
                i4 = 30;
            }
            d.a("Utils", "reportLimit =" + i4 + "days, delete count =" + com.opos.acs.st.a.b.a(context, "'cpd-app-expose', 'cpd-srh-expose', 'bd-expose', 'feeds-expose', 'sms-expose'", System.currentTimeMillis() - ((((i4 * 24) * 60) * 60) * 1000)));
        }
    }

    private static void b(final Context context, final String str, final String str2) {
        if (context == null || str2 == null || "".equals(str2.trim()) || b(context, str)) {
            return;
        }
        d.a("Utils", "start:" + str + ",dmUrl:" + str2);
        STConfigEntity b2 = g.b(context);
        int i = b2.dataEntity.metaEntityMap.get(str).batchNums;
        int i2 = i;
        if (i <= 0) {
            i2 = b2.dataEntity.strategyEntity.batchNums;
        }
        int i3 = i2;
        List<com.opos.acs.st.b.c> a2 = com.opos.acs.st.a.b.a(context, str, str2);
        if (i3 == 0 || a2 == null || a2.size() <= 0) {
            return;
        }
        int size = a2.size() % i3 == 0 ? a2.size() / i3 : (a2.size() / i3) + 1;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                d.a("Utils", "end:".concat(String.valueOf(str)));
                return;
            }
            int i6 = i5 * i3;
            int i7 = i5 + 1;
            int i8 = i7 * i3;
            int i9 = i8;
            if (i8 > a2.size()) {
                i9 = a2.size();
            }
            if (i9 < i6) {
                return;
            }
            final List<com.opos.acs.st.b.c> subList = a2.subList(i6, i9);
            final Integer[] numArr = new Integer[subList.size()];
            final ArrayList arrayList = new ArrayList();
            Iterator<com.opos.acs.st.b.c> it = subList.iterator();
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (it.hasNext()) {
                    com.opos.acs.st.b.c next = it.next();
                    numArr[i11] = Integer.valueOf(next.f24455a);
                    if (next.h != null && !arrayList.contains(next.h)) {
                        arrayList.add(next.h);
                    }
                    i10 = i11 + 1;
                }
            }
            String a3 = a(context, subList);
            final long currentTimeMillis = System.currentTimeMillis();
            a(context, str2, a3, str, new a() { // from class: com.opos.acs.st.utils.h.3
                @Override // com.opos.acs.st.utils.h.a
                public final void a() {
                    h.a(Context.this, numArr, arrayList);
                }

                @Override // com.opos.acs.st.utils.h.a
                public final void a(String str3, String str4) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    boolean z = subList.size() > 0 && ((com.opos.acs.st.b.c) subList.get(0)).j == 1;
                    String str5 = z ? ErrorContants.NEW_PERIODIC_REPORT_ERROR : ErrorContants.PERIODIC_REPORT_ERROR;
                    e.a(Context.this);
                    e.a(ErrorContants.errorContantseMap(Context.this, "5", str5, str2, str3, currentTimeMillis2, currentTimeMillis2, "dataType:" + str + ",response:" + str4));
                    if ("400".equals(str3)) {
                        h.a(Context.this, numArr, arrayList);
                    } else if (z) {
                    } else {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12;
                            if (i13 >= subList.size()) {
                                return;
                            }
                            h.a(Context.this, (com.opos.acs.st.b.c) subList.get(i13), str3);
                            i12 = i13 + 1;
                        }
                    }
                }
            });
            i4 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, int i, STManager.EventListener eventListener) {
        if (eventListener != null && z) {
            eventListener.onEventReturn(i);
        }
    }

    private static boolean b() {
        try {
            h.readLock().lock();
            d.a("Utils", "startReportTimer=" + g);
            boolean z = g;
            h.readLock().unlock();
            return z;
        } catch (Throwable th) {
            h.readLock().unlock();
            throw th;
        }
    }

    private static boolean b(Context context, String str) {
        STConfigEntity b2;
        return TextUtils.isEmpty(str) || (b2 = g.b(context)) == null || b2.dataEntity == null || b2.dataEntity.strategyEntity == null || b2.dataEntity.metaEntityMap == null || b2.dataEntity.metaEntityMap.get(str) == null;
    }

    private static byte[] b(String str) {
        byte[] bytes = "".getBytes();
        if (str == null) {
            return bytes;
        }
        byte[] a2 = com.opos.cmn.b.c.a.a(str.getBytes());
        byte[] bArr = bytes;
        if (a2 != null) {
            bArr = a2;
        }
        return bArr;
    }

    private static MetaEntity c(Context context, String str) {
        STConfigEntity b2;
        if (TextUtils.isEmpty(str) || (b2 = g.b(context)) == null || b2.dataEntity == null || b2.dataEntity.metaEntityMap == null) {
            return null;
        }
        return b2.dataEntity.metaEntityMap.get(str);
    }

    private static String c() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            d.b("Utils", "", e2);
        }
        StringBuilder sb = new StringBuilder("getUserAgent=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        d.a("Utils", sb.toString());
        return str;
    }

    public static void c(Context context) {
        long j;
        long j2;
        synchronized (h.class) {
            try {
                synchronized (d) {
                    StringBuilder sb = new StringBuilder("startReportTimer receive,reportTimer=");
                    sb.append(f24474c == null ? com.igexin.push.core.b.l : f24474c);
                    sb.append(",startReportTimer=");
                    sb.append(b());
                    sb.append(",isStartTimering=");
                    sb.append(e);
                    d.b("lshxjtu", sb.toString());
                    if (context != null && f24474c == null && b() && !e) {
                        e = true;
                        d.b("lshxjtu", "startReportTimer really start!");
                        StrategyEntity i = i(context);
                        if (i != null) {
                            j = i.frequencyTime * 1000;
                            j2 = i.wfTime * 1000;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        long j3 = (!d(context) || j2 <= 0) ? j : j2;
                        long j4 = j3;
                        if (j3 <= 0) {
                            j4 = 60000;
                        }
                        d.a("Utils", "period=".concat(String.valueOf(j4)));
                        f fVar = new f(context, j, j2, j4);
                        Timer timer = new Timer();
                        f24474c = timer;
                        timer.schedule(fVar, 0L, j4);
                    }
                    e = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String d() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

    public static boolean d(Context context) {
        return "WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(context));
    }

    public static boolean e(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            d.c("Utils", "", e2);
            return false;
        }
    }

    public static boolean f(Context context) {
        if (context == null || !e(context) || c.b()) {
            return false;
        }
        d.b("Utils", "isDebuggable, not inited");
        return true;
    }

    public static void g(Context context) {
        STConfigEntity b2 = g.b(context);
        if (b2 == null || context == null || b2 == null) {
            return;
        }
        boolean a2 = a(b2);
        try {
            h.writeLock().lock();
            g = a2;
            d.a("Utils", "setReportTimer=" + g);
            h.writeLock().unlock();
            if (a2) {
                d.a("Utils", "startReportTimer=true,start report timer!!!");
                c(context);
                return;
            }
            d.a("Utils", "startReportTimer=false,cancel report timer!!!");
            a();
        } catch (Throwable th) {
            h.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01fe, code lost:
        if (r21 != null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.h(android.content.Context):void");
    }

    private static StrategyEntity i(Context context) {
        STConfigEntity b2 = g.b(context);
        if (b2 == null || b2.dataEntity == null) {
            return null;
        }
        return b2.dataEntity.strategyEntity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (r9.isClosed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.j(android.content.Context):java.lang.String");
    }

    private static HashMap<String, String> k(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-type", "application/json");
        hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        hashMap.put("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
        return hashMap;
    }

    private static String l(Context context) {
        return context != null ? context.getPackageName() : "";
    }
}

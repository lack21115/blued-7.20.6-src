package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/z.class */
public class z implements ag {

    /* renamed from: a  reason: collision with root package name */
    private String f27098a;
    private ArrayList<aa> b;

    /* renamed from: c  reason: collision with root package name */
    private String f27099c = "";
    private String d = "";
    private String e = "";
    private String f = "";

    public z(String str, ArrayList<aa> arrayList) {
        this.f27098a = null;
        this.b = new ArrayList<>();
        this.f27098a = str;
        this.b = arrayList;
    }

    private String c(String str) {
        String str2;
        String[] split = str.split(",");
        String str3 = "";
        String str4 = str3;
        if (split.length > 0) {
            ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.f27098a);
            int i = 0;
            if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
                this.f = forbidSdkArray.toString();
                int length = split.length;
                while (true) {
                    str4 = str3;
                    if (i >= length) {
                        break;
                    }
                    String str5 = split[i];
                    if (CcgAgent.getActionInfo(str5) != null && !forbidSdkArray.contains(str5)) {
                        return str5;
                    }
                    i++;
                }
            } else {
                int length2 = split.length;
                int i2 = 0;
                while (true) {
                    str4 = str3;
                    if (i2 >= length2) {
                        break;
                    }
                    String str6 = split[i2];
                    ActionInfo actionInfo = CcgAgent.getActionInfo(str6);
                    String str7 = str3;
                    if (actionInfo != null) {
                        String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                        str7 = str3;
                        if (supportAction.length > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                str2 = str3;
                                if (i4 >= supportAction.length) {
                                    break;
                                } else if (this.f27098a.equals(supportAction[i4])) {
                                    str2 = str6;
                                    break;
                                } else {
                                    i3 = i4 + 1;
                                }
                            }
                            str7 = str2;
                            if (!TextUtils.isEmpty(str2)) {
                                return str2;
                            }
                        } else {
                            continue;
                        }
                    }
                    i2++;
                    str3 = str7;
                }
            }
        }
        return str4;
    }

    public String a() {
        return this.f27098a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (com.umeng.ccg.CcgAgent.hasRegistedActionInfo() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (android.text.TextUtils.isEmpty(r5.d) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        r0 = c(r5.d);
        r5.e = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "采集项：" + r5.f27098a + "; 选中Module: " + r5.e + "; sdk: " + r5.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "采集项：" + r5.f27098a + "; 未选中可用Module ; sdk: " + r5.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cc, code lost:
        r0 = r5.b.get(r0 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00dc, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00df, code lost:
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e2, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e9, code lost:
        if ((r0 instanceof com.umeng.analytics.pro.ac) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ec, code lost:
        r0 = r0.c();
        r6 = new org.json.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fe, code lost:
        r6.put("actionName", r5.f27098a);
        r6.put("sdk", r5.d);
        r6.put(com.umeng.ccg.a.o, r5.f27099c);
        r6.put("delay", r0);
        r6.put(com.umeng.ccg.a.p, r5.e);
        r6.put(com.umeng.ccg.a.q, r5.f);
     */
    @Override // com.umeng.analytics.pro.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(java.lang.String r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.z.a(java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }

    public void a(String str) {
        this.f27099c = str;
    }

    public String b() {
        return this.f27099c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.d;
    }
}

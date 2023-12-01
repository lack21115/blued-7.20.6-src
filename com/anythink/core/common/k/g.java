package com.anythink.core.common.k;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/g.class */
public final class g {

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/g$a.class */
    public static final class a {
        public static final String a = "com.android.vending";
    }

    public static double a(ai aiVar) {
        if (aiVar != null) {
            return aiVar.aa() ? com.anythink.core.b.f.a().b(aiVar) : aiVar.ag();
        }
        return 0.0d;
    }

    private static int a(int i, int[] iArr, int i2) {
        if (iArr == null) {
            return i2;
        }
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return i2;
            }
            if (i == iArr[i4]) {
                return i;
            }
            i3 = i4 + 1;
        }
    }

    public static String a() {
        String str = com.anythink.core.common.b.g.a;
        if (TextUtils.isEmpty(com.anythink.core.common.b.g.a)) {
            str = "UA_0.0.0";
        }
        return str;
    }

    public static String a(Context context) {
        String x = com.anythink.core.common.b.n.a().x();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d.d(context));
        stringBuffer.append(com.alipay.sdk.sys.a.b);
        stringBuffer.append(d.f());
        stringBuffer.append(com.alipay.sdk.sys.a.b);
        stringBuffer.append(x);
        stringBuffer.append(com.alipay.sdk.sys.a.b);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(com.alipay.sdk.sys.a.b);
        stringBuffer.append(new Random().nextInt(10000));
        return f.a(stringBuffer.toString());
    }

    public static String a(com.anythink.core.common.e.i iVar) {
        return f.a(iVar.p() + iVar.A());
    }

    public static String a(String str, String str2, long j) {
        return str + BridgeUtil.UNDERLINE_STR + str2 + BridgeUtil.UNDERLINE_STR + j;
    }

    public static JSONObject a(Context context, String str, String str2, int i, int i2) {
        ae aeVar;
        int i3;
        int i4;
        Map<String, ae> a2 = com.anythink.core.a.a.a(context).a(i);
        if (a2 != null) {
            Iterator<ae> it = a2.values().iterator();
            i3 = 0;
            int i5 = 0;
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                ae next = it.next();
                i3 += next.c;
                i5 = i4 + next.d;
            }
            aeVar = a2.get(str2);
        } else {
            aeVar = null;
            i3 = 0;
            i4 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sr", "tp");
            jSONObject.put("rid", str);
            jSONObject.put("ads", i3);
            jSONObject.put("ahs", i4);
            jSONObject.put("pds", aeVar != null ? aeVar.c : 0);
            int i6 = 0;
            if (aeVar != null) {
                i6 = aeVar.d;
            }
            jSONObject.put("phs", i6);
            jSONObject.put("ap", i2);
            jSONObject.put("tpl", str2);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        webView.getSettings().setSavePassword(false);
    }

    public static void a(com.anythink.core.common.e.e eVar, String str, String str2, String str3) {
        if (!ATSDK.isNetworkLogDebug() || eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (eVar.y() != 0) {
                jSONObject.put("defaultAdSourceType", eVar.y());
            }
            jSONObject.put("placementId", eVar.W());
            jSONObject.put("adType", eVar.Z());
            jSONObject.put("mixedFormatAdType", eVar.L());
            jSONObject.put("action", str);
            jSONObject.put(com.alipay.sdk.widget.j.l, eVar.F());
            jSONObject.put(com.alipay.sdk.util.l.c, str2);
            jSONObject.put("segmentId", eVar.I());
            jSONObject.put("adSourceId", eVar.x());
            jSONObject.put("position", eVar.z());
            jSONObject.put(PhoneConstants.DATA_NETWORK_TYPE_KEY, eVar.H());
            jSONObject.put("networkName", eVar.T());
            jSONObject.put("networkVersion", eVar.u);
            jSONObject.put("networkUnit", eVar.G());
            jSONObject.put("isHB", eVar.v());
            jSONObject.put(com.alipay.sdk.cons.c.b, str3);
            jSONObject.put("hourly_frequency", eVar.B());
            jSONObject.put("daily_frequency", eVar.C());
            jSONObject.put("network_list", eVar.D());
            jSONObject.put("request_network_num", eVar.E());
            jSONObject.put("handle_class", eVar.i());
        } catch (Throwable th) {
        }
        n.a("network", jSONObject.toString());
    }

    private static void a(String str, List<ai> list) {
        if (list == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    Log.e(str, sb.toString());
                    return;
                }
                ai aiVar = list.get(i2);
                sb.append("\n");
                sb.append(i2);
                sb.append(" --> adSourceId: ");
                sb.append(aiVar.t());
                sb.append(", ");
                sb.append(aiVar.d());
                sb.append(", real: ");
                sb.append(aiVar.x());
                sb.append(", sort: ");
                sb.append(a(aiVar));
                String z = aiVar.z();
                if (!TextUtils.isEmpty(z)) {
                    sb.append(", errorMsg: ");
                    sb.append(z);
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(List<ai> list, ai aiVar, boolean z) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (z) {
            if (aiVar.a() == -1 || size == 0) {
                list.add(aiVar);
                return;
            }
        } else if (size == 0) {
            list.add(aiVar);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ai aiVar2 = list.get(i2);
            boolean z2 = true;
            if (z && aiVar2.a() == -1) {
                list.add(i2, aiVar);
            } else if (a(aiVar) >= a(aiVar2)) {
                list.add(i2, aiVar);
            } else if (i2 == size - 1) {
                list.add(aiVar);
            } else {
                z2 = false;
            }
            if (z2) {
                return;
            }
            i = i2 + 1;
        }
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.e.e eVar) {
        if (eVar == null || eVar.H() >= 100000) {
            return;
        }
        map.put(g.k.h, eVar);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            Log.e(com.anythink.core.common.b.g.n, "Invalid Channel(" + str + "):Channel'length over 128");
            return false;
        } else if (Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        } else {
            Log.e(com.anythink.core.common.b.g.n, "Invalid Channel(" + str + "): contains some characters that are not in the ^([.A-Za-z0-9_-]){1,128}$");
            return false;
        }
    }

    private static boolean a(List<ai> list, ai aiVar, ai aiVar2, int i, int i2, boolean z) {
        if (z && aiVar.a() == -1) {
            list.add(i, aiVar2);
            return true;
        } else if (a(aiVar2) >= a(aiVar)) {
            list.add(i, aiVar2);
            return true;
        } else if (i == i2) {
            list.add(aiVar2);
            return true;
        } else {
            return false;
        }
    }

    private static String b(Context context) {
        String x = com.anythink.core.common.b.n.a().x();
        String str = x;
        if (TextUtils.isEmpty(x)) {
            str = d.d(context) + d.f();
        }
        return f.a(str + UUID.randomUUID().toString());
    }

    public static String b(String str, String str2, long j) {
        return a(str, str2, j) + "_refresh";
    }

    public static boolean b() {
        try {
            Map<String, Object> m = com.anythink.core.common.b.n.a().m();
            boolean z = false;
            if (m != null) {
                z = false;
                if (m.containsKey(ATCustomRuleKeys.AGE)) {
                    z = false;
                    if (Integer.parseInt(m.get(ATCustomRuleKeys.AGE).toString()) <= 13) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            Log.e(com.anythink.core.common.b.g.n, "Invalid SubChannel(" + str + "):SubChannel'length over 128");
            return false;
        } else if (Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        } else {
            Log.e(com.anythink.core.common.b.g.n, "Invalid SubChannel(" + str + "):SubChannel contains some characters that are not in the ^([.A-Za-z0-9_-]){1,128}$");
            return false;
        }
    }

    private static boolean c() {
        return q.a().b();
    }

    private static boolean c(Context context) {
        return q.a().a(context);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 14) {
            Log.e(com.anythink.core.common.b.g.n, "Invalid Scenario(" + str + "):Scenario'length isn't 14");
            return false;
        } else if (Pattern.matches("^[A-Za-z0-9]+$", str)) {
            return true;
        } else {
            Log.e(com.anythink.core.common.b.g.n, "Invalid Scenario(" + str + "):Scenario contains some characters that are not in the [A-Za-z0-9]");
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String d(String str) {
        boolean z;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 49:
                if (str.equals("1")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 50:
                if (str.equals("2")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 51:
                if (str.equals("3")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 52:
                if (str.equals("4")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        return z ? !z ? !z ? !z ? !z ? "" : g.C0060g.e : g.C0060g.d : g.C0060g.c : g.C0060g.b : g.C0060g.a;
    }

    private static boolean d(Context context) {
        return q.a().b(context);
    }
}

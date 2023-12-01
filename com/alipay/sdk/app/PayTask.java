package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/PayTask.class */
public class PayTask {
    private static final long i = 3000;
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private com.alipay.sdk.widget.a f4585c;
    private String d = "wappaygw.alipay.com/service/rest.htm";
    private String e = "mclient.alipay.com/service/rest.htm";
    private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
    private Map<String, a> g = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    static final Object f4584a = com.alipay.sdk.util.e.class;
    private static long h = 0;
    private static long j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/PayTask$a.class */
    public class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f4587c;
        private String d;
        private String e;

        private a() {
            this.b = "";
            this.f4587c = "";
            this.d = "";
            this.e = "";
        }

        /* synthetic */ a(PayTask payTask, g gVar) {
            this();
        }

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.d;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.f4587c;
        }

        public void c(String str) {
            this.f4587c = str;
        }

        public String d() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }
    }

    public PayTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.sys.b.a().a(this.b);
        this.f4585c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.b);
    }

    private e.a a() {
        return new h(this);
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.b, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString("cookie", c2[1]);
        }
        intent.putExtras(bundle);
        a.C0050a.a(aVar, intent);
        this.b.startActivity(intent);
        synchronized (f4584a) {
            try {
                f4584a.wait();
            } catch (InterruptedException e) {
                com.alipay.sdk.util.c.a(e);
                return j.c();
            }
        }
        String a2 = j.a();
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = j.c();
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d7, code lost:
        r0 = r0.c();
        r8 = com.alipay.sdk.app.j.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.n.b(r7, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(com.alipay.sdk.sys.a r7, com.alipay.sdk.protocol.b r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.sys.a, com.alipay.sdk.protocol.b, java.lang.String):java.lang.String");
    }

    private String a(com.alipay.sdk.sys.a aVar, String str) {
        k kVar;
        String a2;
        showLoading();
        try {
            try {
                JSONObject c2 = new com.alipay.sdk.packet.impl.f().a(aVar, this.b.getApplicationContext(), str).c();
                String optString = c2.optString("end_code", null);
                List<com.alipay.sdk.protocol.b> a3 = com.alipay.sdk.protocol.b.a(c2.optJSONObject(com.alipay.sdk.cons.c.f4616c).optJSONObject(com.alipay.sdk.cons.c.d));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= a3.size()) {
                        break;
                    }
                    if (a3.get(i3).b() == com.alipay.sdk.protocol.a.Update) {
                        com.alipay.sdk.protocol.b.a(a3.get(i3));
                    }
                    i2 = i3 + 1;
                }
                a(aVar, c2);
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.p);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= a3.size()) {
                        dismissLoading();
                        com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.p);
                        kVar = null;
                        break;
                    }
                    com.alipay.sdk.protocol.b bVar = a3.get(i5);
                    if (bVar.b() == com.alipay.sdk.protocol.a.WapPay) {
                        a2 = a(aVar, bVar);
                        break;
                    } else if (bVar.b() == com.alipay.sdk.protocol.a.OpenWeb) {
                        a2 = a(aVar, bVar, optString);
                        break;
                    } else {
                        i4 = i5 + 1;
                    }
                }
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.p);
                return a2;
            } catch (IOException e) {
                k b = k.b(k.NETWORK_ERROR.a());
                com.alipay.sdk.app.statistic.a.a(aVar, "net", e);
                dismissLoading();
                com.alipay.sdk.app.statistic.a.a(this.b, aVar, str, aVar.p);
                kVar = b;
            }
            k kVar2 = kVar;
            if (kVar == null) {
                kVar2 = k.b(k.FAILED.a());
            }
            return j.a(kVar2.a(), kVar2.b(), "");
        }
    }

    private static String a(com.alipay.sdk.sys.a aVar, String str, List<a.C0048a> list, String str2, Activity activity) {
        n.a a2 = n.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a()) {
            return str2;
        }
        if (TextUtils.equals(a2.f4676a.packageName, PayResultActivity.f4582c)) {
            com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask not_login");
            String valueOf = String.valueOf(str.hashCode());
            PayResultActivity.b.put(valueOf, new Object());
            Intent intent = new Intent(activity, PayResultActivity.class);
            intent.putExtra(PayResultActivity.e, str);
            intent.putExtra(PayResultActivity.f, activity.getPackageName());
            intent.putExtra(PayResultActivity.d, valueOf);
            a.C0050a.a(aVar, intent);
            activity.startActivity(intent);
            synchronized (PayResultActivity.b.get(valueOf)) {
                try {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask wait");
                    PayResultActivity.b.get(valueOf).wait();
                } catch (InterruptedException e) {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask interrupted");
                    return j.c();
                }
            }
            String str3 = PayResultActivity.a.b;
            com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "PayTask ret: " + str3);
            return str3;
        }
        return str2;
    }

    private String a(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        synchronized (this) {
            if (b()) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, "RepPay", "");
                return j.d();
            }
            if (z) {
                showLoading();
            }
            if (str.contains("payment_inst=")) {
                String substring = str.substring(str.indexOf("payment_inst=") + 13);
                int indexOf = substring.indexOf(38);
                String str2 = substring;
                if (indexOf > 0) {
                    str2 = substring.substring(0, indexOf);
                }
                i.a(str2.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
            } else {
                i.a("");
            }
            if (str.contains(com.alipay.sdk.cons.a.t)) {
                com.alipay.sdk.cons.a.u = true;
            }
            String str3 = str;
            if (com.alipay.sdk.cons.a.u) {
                if (str.startsWith(com.alipay.sdk.cons.a.v)) {
                    str3 = str.substring(str.indexOf(com.alipay.sdk.cons.a.v) + 53);
                } else {
                    str3 = str;
                    if (str.startsWith(com.alipay.sdk.cons.a.w)) {
                        str3 = str.substring(str.indexOf(com.alipay.sdk.cons.a.w) + 52);
                    }
                }
            }
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay prepared: " + str3);
            String a2 = a(str3, aVar);
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay raw result: " + a2);
            com.alipay.sdk.util.i.a(aVar, this.b.getApplicationContext(), a2);
            com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.O, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.data.a.j().a(aVar, this.b.getApplicationContext());
            dismissLoading();
            com.alipay.sdk.app.statistic.a.b(this.b.getApplicationContext(), aVar, str3, aVar.p);
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "pay returning: " + a2);
            return a2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r0 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r7, com.alipay.sdk.sys.a r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(java.lang.String, com.alipay.sdk.sys.a):java.lang.String");
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.util.i.d));
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(l.f4671a));
        String str2 = map.get("result");
        a remove = this.g.remove(str);
        a(remove != null ? remove.b() : "", remove != null ? remove.d() : "");
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a2 = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.cons.a.r, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.cons.a.s, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String a3 = equals ? remove.a() : remove.c();
            if (!TextUtils.isEmpty(a3)) {
                return a3;
            }
        }
        return remove != null ? com.alipay.sdk.data.a.j().e() : "";
    }

    private static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return "";
            }
            String str = strArr[i3];
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            i2 = i3 + 1;
        }
    }

    private void a(com.alipay.sdk.sys.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.tid.b.e);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a(optString, optString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.I, th);
        }
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i3];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2 = i3 + 1;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        } else if (!z) {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        } else {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
    }

    private static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - j >= 3000) {
            j = elapsedRealtime;
            return false;
        }
        return true;
    }

    public static boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.sys.b.a().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - h < com.alipay.sdk.data.a.j().f()) {
                    return false;
                }
                h = elapsedRealtime;
                com.alipay.sdk.data.a.j().a(com.alipay.sdk.sys.a.a(), context.getApplicationContext());
                return true;
            } catch (Exception e) {
                com.alipay.sdk.util.c.a(e);
                return false;
            } finally {
            }
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.f4585c;
        if (aVar != null) {
            aVar.c();
            this.f4585c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0138, code lost:
        if (r0.startsWith("http://" + r11.e) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x021d, code lost:
        if (r0.startsWith("http://" + r11.f) != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0053, code lost:
        if (r0.startsWith("http://" + r11.d) != false) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 1775
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    public String fetchTradeToken() {
        String a2;
        synchronized (this) {
            a2 = com.alipay.sdk.util.i.a(new com.alipay.sdk.sys.a(this.b, "", "fetchTradeToken"), this.b.getApplicationContext());
        }
        return a2;
    }

    public String getVersion() {
        return "15.7.4";
    }

    public H5PayResultModel h5Pay(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        synchronized (this) {
            h5PayResultModel = new H5PayResultModel();
            String[] split = a(aVar, str, z).split(";");
            HashMap hashMap = new HashMap();
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                String str2 = split[i3];
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, a(str2, substring));
                }
                i2 = i3 + 1;
            }
            if (hashMap.containsKey(l.f4671a)) {
                h5PayResultModel.setResultCode(hashMap.get(l.f4671a));
            }
            h5PayResultModel.setReturnUrl(a(str, hashMap));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.af, "");
            }
        }
        return h5PayResultModel;
    }

    public String pay(String str, boolean z) {
        String a2;
        synchronized (this) {
            a2 = a(new com.alipay.sdk.sys.a(this.b, str, WBConstants.ACTION_LOG_TYPE_PAY), str, z);
        }
        return a2;
    }

    public boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        boolean isEmpty;
        synchronized (this) {
            String fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
            if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "intercepted: " + fetchOrderInfoFromH5PayUrl);
                new Thread(new g(this, fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
            }
            isEmpty = TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
        }
        return !isEmpty;
    }

    public Map<String, String> payV2(String str, boolean z) {
        Map<String, String> a2;
        synchronized (this) {
            com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.b, str, "payV2");
            a2 = l.a(aVar, a(aVar, str, z));
        }
        return a2;
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.f4585c;
        if (aVar != null) {
            aVar.b();
        }
    }
}

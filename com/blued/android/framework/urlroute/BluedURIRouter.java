package com.blued.android.framework.urlroute;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.sys.a;
import com.blued.android.core.AppInfo;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedURIRouter.class */
public class BluedURIRouter {
    private static final String a = BluedURIRouter.class.getName();
    private static volatile BluedURIRouter b;
    private ConcurrentHashMap<String, Action> c = new ConcurrentHashMap<>();
    private String d = null;
    private String[] e = null;
    private String[] f = null;
    private String[] g = null;
    private String h = "";
    private String i = "blued_uri_router.json";
    private String j = "blued_uri_prefix.json";
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedURIRouter$Action.class */
    public class Action {
        String a;
        String b;
        String c;
        boolean d;
        FunctionArguments[] e;

        private Action() {
            this.d = false;
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/urlroute/BluedURIRouter$FunctionArguments.class */
    public class FunctionArguments {
        public String a;
        public String b;
        public String c;
        public boolean d;

        private FunctionArguments() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = false;
        }
    }

    private BluedURIRouter() {
    }

    public static BluedURIRouter a() {
        if (b == null) {
            synchronized (BluedURIRouter.class) {
                try {
                    if (b == null) {
                        b = new BluedURIRouter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private String a(String str, String str2, String str3) {
        String str4 = str;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return str3;
            }
            str4 = str2;
        }
        return str4;
    }

    private boolean f() {
        try {
            if (this.f == null) {
                String h = h(this.j);
                if (TextUtils.isEmpty(h)) {
                    if (AppInfo.m()) {
                        throw new RuntimeException(this.j + " is empty !!");
                    }
                    return false;
                }
                JSONObject jSONObject = new JSONObject(h);
                String optString = jSONObject.optString("protocol");
                this.d = optString;
                if (TextUtils.isEmpty(optString)) {
                    if (AppInfo.m()) {
                        throw new RuntimeException("protocal is empty in " + this.j + " !!");
                    }
                    return false;
                }
                this.e = this.d.split(",");
                JSONArray optJSONArray = jSONObject.optJSONArray("hostname");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.f = new String[length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        this.f[i2] = optJSONArray.optString(i2);
                        i = i2 + 1;
                    }
                }
                if (this.f != null && this.f.length != 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("cookie-domain");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        this.g = new String[length2];
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= length2) {
                                break;
                            }
                            this.g[i4] = optJSONArray2.optString(i4);
                            i3 = i4 + 1;
                        }
                    }
                    if (this.g == null || this.g.length == 0) {
                        if (AppInfo.m()) {
                            throw new RuntimeException("cookie-domain is empty in " + this.j + " !!");
                        }
                        return false;
                    }
                    return true;
                }
                if (AppInfo.m()) {
                    throw new RuntimeException("hostname is empty in " + this.j + " !!");
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.trim();
        return trim.length() > 0 ? trim : "";
    }

    private boolean g() {
        JSONArray optJSONArray;
        int length;
        ConcurrentHashMap<String, Action> concurrentHashMap = this.c;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            try {
                String h = h(this.i);
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject(h);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("method", "");
                        if (!TextUtils.isEmpty(optString)) {
                            String optString2 = optJSONObject.optString("class", "");
                            String str = optString2;
                            if (TextUtils.isEmpty(optString2)) {
                                if (!TextUtils.isEmpty(this.h)) {
                                    str = this.h;
                                } else if (AppInfo.m()) {
                                    throw new RuntimeException("please invoke setDefaultAdapterClass() firstly !!");
                                }
                            }
                            String optString3 = optJSONObject.optString("return", "");
                            Action action = new Action();
                            action.a = next;
                            action.b = str;
                            action.c = optString;
                            action.d = optString3.equalsIgnoreCase("void");
                            if (optJSONObject.has("args") && !optJSONObject.isNull("args") && (optJSONArray = optJSONObject.optJSONArray("args")) != null && (length = optJSONArray.length()) > 0) {
                                FunctionArguments[] functionArgumentsArr = new FunctionArguments[length];
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= length) {
                                        break;
                                    }
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                    FunctionArguments functionArguments = new FunctionArguments();
                                    functionArguments.a = jSONObject2.keys().next();
                                    if (!jSONObject2.isNull(functionArguments.a)) {
                                        JSONObject optJSONObject2 = jSONObject2.optJSONObject(functionArguments.a);
                                        functionArguments.b = optJSONObject2.optString("type", "");
                                        functionArguments.c = optJSONObject2.optString("default", "");
                                        functionArguments.d = optJSONObject2.optBoolean("require", false);
                                    }
                                    functionArgumentsArr[i2] = functionArguments;
                                    i = i2 + 1;
                                }
                                action.e = functionArgumentsArr;
                            }
                            this.c.put(next, action);
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    private String h(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (AppInfo.d() == null) {
            if (AppInfo.m()) {
                throw new RuntimeException("AppInfo getAppContext() is null !");
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (AppInfo.m()) {
                throw new RuntimeException("config name is null !");
            }
            return null;
        } else {
            try {
                inputStream = AppInfo.d().getAssets().open(str);
            } catch (Exception e) {
                inputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                String str2 = new String(bArr, "UTF-8");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        return str2;
                    }
                }
                return str2;
            } catch (Exception e3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return null;
                    } catch (Exception e4) {
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        }
    }

    private boolean h() {
        return f() && g();
    }

    public Uri a(String str, int i) {
        if (TextUtils.isEmpty(str) || str.trim().length() <= 0) {
            return null;
        }
        return a("http://common.blued.com", "webbrowse", new String[]{"weburl", "webFromPage"}, new String[]{str, "" + i});
    }

    public Uri a(String str, String str2, String[] strArr, String[] strArr2) {
        if (TextUtils.isEmpty(str2) || str2.trim().length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("?action=");
        sb.append(str2);
        if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    break;
                }
                if (!TextUtils.isEmpty(strArr[i2]) && strArr[i2].trim().length() != 0) {
                    try {
                        sb.append(a.b);
                        sb.append(strArr[i2]);
                        sb.append("=");
                        sb.append(URLEncoder.encode(strArr2[i2], "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                }
                i = i2 + 1;
            }
        }
        return Uri.parse(sb.toString());
    }

    public void a(boolean z) {
        this.k = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: Exception -> 0x0362, TryCatch #0 {Exception -> 0x0362, blocks: (B:6:0x0006, B:10:0x0020, B:12:0x0028, B:15:0x0034, B:17:0x0043, B:19:0x005c, B:21:0x0062, B:26:0x0096, B:28:0x00b2, B:31:0x00df, B:33:0x00f3, B:35:0x00f9, B:39:0x0103, B:41:0x0112, B:44:0x0123, B:48:0x0137, B:50:0x0149, B:52:0x0151, B:54:0x015b, B:58:0x0166, B:62:0x0170, B:64:0x0182, B:65:0x01a4, B:67:0x01b2, B:68:0x01d4, B:70:0x01e6, B:71:0x0208, B:73:0x0216, B:74:0x0238, B:76:0x0246, B:78:0x026e, B:79:0x0282, B:81:0x0288, B:88:0x02b8, B:92:0x02f2, B:83:0x0295, B:86:0x02aa, B:94:0x032d, B:96:0x0346, B:98:0x0350), top: B:114:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[Catch: Exception -> 0x0362, TRY_ENTER, TryCatch #0 {Exception -> 0x0362, blocks: (B:6:0x0006, B:10:0x0020, B:12:0x0028, B:15:0x0034, B:17:0x0043, B:19:0x005c, B:21:0x0062, B:26:0x0096, B:28:0x00b2, B:31:0x00df, B:33:0x00f3, B:35:0x00f9, B:39:0x0103, B:41:0x0112, B:44:0x0123, B:48:0x0137, B:50:0x0149, B:52:0x0151, B:54:0x015b, B:58:0x0166, B:62:0x0170, B:64:0x0182, B:65:0x01a4, B:67:0x01b2, B:68:0x01d4, B:70:0x01e6, B:71:0x0208, B:73:0x0216, B:74:0x0238, B:76:0x0246, B:78:0x026e, B:79:0x0282, B:81:0x0288, B:88:0x02b8, B:92:0x02f2, B:83:0x0295, B:86:0x02aa, B:94:0x032d, B:96:0x0346, B:98:0x0350), top: B:114:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r8, android.net.Uri r9) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.urlroute.BluedURIRouter.a(android.content.Context, android.net.Uri):boolean");
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] c = c();
        int length = c.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (c[i2].trim().equalsIgnoreCase(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean b() {
        return this.k;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] d = d();
        int length = d.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (d[i2].trim().equalsIgnoreCase(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void c(String str) {
        this.h = g(str);
    }

    public String[] c() {
        f();
        if (this.e == null) {
            this.e = new String[0];
        }
        return this.e;
    }

    public void d(String str) {
        this.i = g(str);
    }

    public String[] d() {
        f();
        if (this.f == null) {
            this.f = new String[0];
        }
        return this.f;
    }

    public void e(String str) {
        this.j = g(str);
    }

    public String[] e() {
        f();
        if (this.g == null) {
            this.g = new String[0];
        }
        return this.g;
    }

    public Uri f(String str) {
        if (AppInfo.m()) {
            String str2 = a;
            Log.d(str2, "url:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && !TextUtils.isEmpty(parse.getScheme())) {
                if (h()) {
                    if (!a(parse.getScheme()) && !b(parse.getHost())) {
                        return null;
                    }
                    String queryParameter = parse.getQueryParameter("action");
                    if (TextUtils.isEmpty(queryParameter) || this.c.get(queryParameter) == null) {
                        return null;
                    }
                    return parse;
                }
                return null;
            }
            if (AppInfo.m()) {
                String str3 = a;
                Log.d(str3, "uri.getScheme():" + parse.getScheme());
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}

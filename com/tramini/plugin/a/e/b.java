package com.tramini.plugin.a.e;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tramini.plugin.a.e.f;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/b.class */
public final class b extends f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tramini.plugin.a.e.b$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/b$1.class */
    public final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f26823a;
        final /* synthetic */ ExecutorService b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String[] f26824c;

        AnonymousClass1(WebView webView, ExecutorService executorService, String[] strArr) {
            this.f26823a = webView;
            this.b = executorService;
            this.f26824c = strArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f26823a == null) {
                    synchronized (this.b) {
                        this.b.notifyAll();
                    }
                }
                this.f26823a.post(new Runnable() { // from class: com.tramini.plugin.a.e.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (Build.VERSION.SDK_INT >= 19) {
                            AnonymousClass1.this.f26823a.evaluateJavascript("(function() { return (document.getElementsByTagName('html')[0].innerHTML); })();", new ValueCallback<String>() { // from class: com.tramini.plugin.a.e.b.1.1.1
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(String str) {
                                    Properties properties = new Properties();
                                    try {
                                        properties.load(new StringReader("unicodedString=".concat(String.valueOf(str))));
                                    } catch (IOException e) {
                                    }
                                    String property = properties.getProperty("unicodedString");
                                    if (property.length() > 2) {
                                        AnonymousClass1.this.f26824c[0] = property.substring(1, property.length() - 1);
                                    }
                                    synchronized (AnonymousClass1.this.b) {
                                        AnonymousClass1.this.b.notifyAll();
                                    }
                                }
                            });
                        }
                    }
                });
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03c2 A[Catch: all -> 0x04b4, TryCatch #1 {all -> 0x04b4, blocks: (B:3:0x0038, B:6:0x0058, B:8:0x0060, B:10:0x006b, B:12:0x007c, B:17:0x00a4, B:19:0x00ae, B:23:0x00d7, B:101:0x03b2, B:103:0x03c2, B:105:0x03c9, B:107:0x03d1, B:109:0x03dd, B:110:0x03e8, B:112:0x03f2, B:114:0x03f9, B:116:0x0401, B:123:0x0433, B:119:0x0417, B:121:0x041f, B:125:0x043a, B:127:0x0448, B:129:0x044f, B:131:0x0462, B:135:0x0479, B:137:0x048c, B:139:0x0494, B:141:0x04a0, B:41:0x0170, B:47:0x01c5, B:89:0x0348, B:93:0x035f, B:97:0x03a7), top: B:163:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x043a A[Catch: all -> 0x04b4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x04b4, blocks: (B:3:0x0038, B:6:0x0058, B:8:0x0060, B:10:0x006b, B:12:0x007c, B:17:0x00a4, B:19:0x00ae, B:23:0x00d7, B:101:0x03b2, B:103:0x03c2, B:105:0x03c9, B:107:0x03d1, B:109:0x03dd, B:110:0x03e8, B:112:0x03f2, B:114:0x03f9, B:116:0x0401, B:123:0x0433, B:119:0x0417, B:121:0x041f, B:125:0x043a, B:127:0x0448, B:129:0x044f, B:131:0x0462, B:135:0x0479, B:137:0x048c, B:139:0x0494, B:141:0x04a0, B:41:0x0170, B:47:0x01c5, B:89:0x0348, B:93:0x035f, B:97:0x03a7), top: B:163:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tramini.plugin.a.c.a a(java.lang.Object r12, java.lang.String r13, java.lang.String r14, long r15, long r17, org.json.JSONObject r19, java.lang.String r20, org.json.JSONArray r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.e.b.a(java.lang.Object, java.lang.String, java.lang.String, long, long, org.json.JSONObject, java.lang.String, org.json.JSONArray, java.lang.String):com.tramini.plugin.a.c.a");
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str, String str2) {
        return a(a(jSONObject.optString("in_na"), str), "", jSONObject.optString("tobj_k"), jSONObject.optLong("bwt", 10000L), jSONObject.optLong("bswt", 2000L), jSONObject, jSONObject.optString("bu_k"), cVar.e, str2);
    }

    private static String a(WebView webView, long j, long j2) {
        if (Build.VERSION.SDK_INT < 19) {
            return "";
        }
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        String[] strArr = new String[1];
        try {
            newFixedThreadPool.submit(new AnonymousClass1(webView, newFixedThreadPool, strArr));
        } catch (Throwable th) {
        }
        try {
            synchronized (newFixedThreadPool) {
                newFixedThreadPool.wait(j + j2);
            }
            newFixedThreadPool.shutdown();
            return strArr[0] != null ? strArr[0] : "";
        } catch (Exception e2) {
            return "";
        }
    }

    private static String a(Object obj) {
        if (obj != null) {
            try {
                ArrayList<Field> arrayList = new ArrayList();
                a(obj.getClass(), arrayList);
                for (Field field : arrayList) {
                    if (field != null) {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null && (obj2 instanceof String) && ((String) obj2).endsWith(".mp4")) {
                            return (String) obj2;
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5 A[Catch: all -> 0x027d, TRY_LEAVE, TryCatch #0 {all -> 0x027d, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x001a, B:9:0x002b, B:43:0x015e, B:45:0x0165, B:85:0x025f, B:47:0x0172, B:49:0x0179, B:51:0x01a0, B:53:0x01b0, B:55:0x01b7, B:27:0x008f, B:29:0x0097, B:31:0x00bf, B:33:0x00c5, B:35:0x00ff, B:37:0x0107, B:39:0x012f, B:41:0x0137, B:57:0x01c4, B:59:0x01cc, B:61:0x01da, B:63:0x01e2, B:65:0x01f0, B:67:0x01f8, B:69:0x0206, B:71:0x020e, B:73:0x0222, B:75:0x022e, B:77:0x0235, B:80:0x0246, B:83:0x0255), top: B:100:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r4, java.lang.Object r5, org.json.JSONObject r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.e.b.a(java.lang.String, java.lang.Object, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String b(Object obj) {
        if (obj != null) {
            try {
                ArrayList<Field> arrayList = new ArrayList();
                a(obj.getClass(), arrayList);
                for (Field field : arrayList) {
                    if (field != null) {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null && (obj2 instanceof String) && ((String) obj2).contains("<!DOCTYPE html>")) {
                            return (String) obj2;
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    private static JSONObject c(Object obj, String str) {
        try {
            ArrayList<Field> arrayList = new ArrayList();
            a(obj.getClass(), arrayList);
            for (Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof JSONObject) && !TextUtils.isEmpty(((JSONObject) obj2).optString(str, ""))) {
                        return (JSONObject) obj2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String d(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            String str3 = "";
            while (true) {
                String str4 = str3;
                if (i >= jSONArray.length()) {
                    return "";
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String str5 = str4;
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("action", -1);
                    String optString = optJSONObject.optString(RemoteMessageConst.MessageBody.PARAM, "");
                    if (optInt == 101) {
                        str5 = str4;
                        if (TextUtils.isEmpty(str2)) {
                            continue;
                        } else {
                            str4 = f.b.a(str2, optString);
                        }
                    }
                    str5 = str4;
                    if (!TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                }
                i++;
                str3 = str5;
            }
        } catch (Throwable th) {
            return "";
        }
    }
}

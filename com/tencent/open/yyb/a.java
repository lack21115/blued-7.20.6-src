package com.tencent.open.yyb;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/a.class */
public class a {

    /* renamed from: com.tencent.open.yyb.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/a$a.class */
    public static class C0805a {

        /* renamed from: a  reason: collision with root package name */
        public String f24617a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f24618c;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/yyb/a$b.class */
    static class b extends AsyncTask<Bundle, Void, Void> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (android.text.TextUtils.isEmpty(r9) == false) goto L9;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(android.os.Bundle... r7) {
            /*
                r6 = this;
                r0 = r7
                if (r0 != 0) goto L6
                r0 = 0
                return r0
            L6:
                r0 = r7
                int r0 = r0.length
                r1 = 2
                if (r0 != r1) goto L1f
                r0 = r7
                r1 = 1
                r0 = r0[r1]
                java.lang.String r1 = "uri"
                java.lang.String r0 = r0.getString(r1)
                r9 = r0
                r0 = r9
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L1f
                goto L22
            L1f:
                java.lang.String r0 = "http://analy.qq.com/cgi-bin/mapp_apptrace"
                r9 = r0
            L22:
                r0 = 0
                r1 = r9
                java.lang.String r2 = "GET"
                r3 = r7
                r4 = 0
                r3 = r3[r4]     // Catch: java.lang.Exception -> L58
                com.tencent.open.utils.Util$Statistic r0 = com.tencent.open.utils.HttpUtils.openUrl2(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L58
                java.lang.String r0 = r0.response     // Catch: java.lang.Exception -> L58
                org.json.JSONObject r0 = com.tencent.open.utils.Util.parseJson(r0)     // Catch: java.lang.Exception -> L58
                java.lang.String r1 = "ret"
                int r0 = r0.getInt(r1)     // Catch: java.lang.Exception -> L58
                r8 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L58
                r1 = r0
                r1.<init>()     // Catch: java.lang.Exception -> L58
                r7 = r0
                r0 = r7
                java.lang.String r1 = "-->(ViaAsyncTask)doInBackground : ret = "
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L58
                r0 = r7
                r1 = r8
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L58
                java.lang.String r0 = "openSDK_LOG.AppbarUtil"
                r1 = r7
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L58
                com.tencent.open.a.f.b(r0, r1)     // Catch: java.lang.Exception -> L58
                r0 = 0
                return r0
            L58:
                r7 = move-exception
                java.lang.String r0 = "openSDK_LOG.AppbarUtil"
                java.lang.String r1 = "-->(ViaAsyncTask)doInBackground : Exception = "
                r2 = r7
                com.tencent.open.a.f.b(r0, r1, r2)
                r0 = r7
                r0.printStackTrace()
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.yyb.a.b.doInBackground(android.os.Bundle[]):java.lang.Void");
        }
    }

    public static Drawable a(String str, Context context) {
        return a(str, context, new Rect(0, 0, 0, 0));
    }

    public static Drawable a(String str, Context context, Rect rect) {
        InputStream inputStream;
        Drawable drawable;
        NinePatchDrawable createFromStream;
        Context applicationContext = context.getApplicationContext();
        AssetManager assets = applicationContext.getAssets();
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    inputStream = assets.open(str);
                } catch (IOException e) {
                    e = e;
                    inputStream = null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : IOException", e3);
                        }
                    }
                    throw th;
                }
                if (inputStream == null) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : IOException", e4);
                            return null;
                        }
                    }
                    return null;
                }
                try {
                    if (str.endsWith(".9.png")) {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                        if (decodeStream == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return null;
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : IOException", e5);
                                    return null;
                                }
                            }
                            return null;
                        }
                        createFromStream = new NinePatchDrawable(applicationContext.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
                    } else {
                        createFromStream = Drawable.createFromStream(inputStream, str);
                    }
                    drawable = createFromStream;
                    if (inputStream != null) {
                        inputStream.close();
                        return createFromStream;
                    }
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    InputStream inputStream3 = inputStream;
                    f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : IOException", e);
                    drawable = null;
                    if (inputStream != null) {
                        inputStream.close();
                        return null;
                    }
                    return drawable;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    e.printStackTrace();
                    InputStream inputStream4 = inputStream;
                    f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : OutOfMemoryError", e);
                    drawable = null;
                    if (inputStream != null) {
                        inputStream.close();
                        drawable = null;
                    }
                    return drawable;
                }
                return drawable;
            } catch (IOException e8) {
                e8.printStackTrace();
                f.b("openSDK_LOG.AppbarUtil", "-->(AppbarUtil)getDrawable : IOException", e8);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        String str5 = null;
        if (Uri.parse(str).getHost().toLowerCase().endsWith(".qq.com")) {
            str5 = ".qq.com";
        }
        cookieManager.setCookie(str, b("logintype", "MOBILEQ", str5));
        cookieManager.setCookie(str, b("qopenid", str2, str5));
        cookieManager.setCookie(str, b("qaccesstoken", str3, str5));
        cookieManager.setCookie(str, b("openappid", str4, str5));
        CookieSyncManager.getInstance().sync();
    }

    public static void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", Constants.DEFAULT_UIN);
        bundle.putString("action", str2);
        bundle.putString("appid", str);
        bundle.putString("via", str3);
        new b().execute(bundle);
    }

    private static String b(String str, String str2, String str3) {
        String str4 = str + "=" + str2;
        String str5 = str4;
        if (str3 != null) {
            str5 = (str4 + "; path=/") + "; domain=" + str3;
        }
        return str5;
    }
}

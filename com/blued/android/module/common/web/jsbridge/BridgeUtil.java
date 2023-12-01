package com.blued.android.module.common.web.jsbridge;

import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/BridgeUtil.class */
public class BridgeUtil {
    public static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    public static final String EMPTY_STR = "";
    public static final String JAVASCRIPT_STR = "javascript:";
    public static final String JS_FETCH_QUEUE_FROM_JAVA = "javascript:WebViewJavascriptBridge._fetchQueue();";
    public static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";
    public static final String SPLIT_MARK = "/";
    public static final String UNDERLINE_STR = "_";
    public static final String YY_FETCH_QUEUE = "yy://return/_fetchQueue/";
    public static final String YY_OVERRIDE_SCHEMA = "yy://";
    public static final String YY_RETURN_DATA = "yy://return/";

    /* JADX WARN: Removed duplicated region for block: B:64:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String assetFile2Str(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            r8 = r0
            r0 = r6
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L75
            r1 = r7
            java.io.InputStream r0 = r0.open(r1)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L75
            r7 = r0
            r0 = r7
            r6 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r1 = r0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r3 = r2
            r4 = r7
            r3.<init>(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r1.<init>(r2)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r8 = r0
            r0 = r7
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r9 = r0
        L27:
            r0 = r7
            r6 = r0
            r0 = r8
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L49
            r0 = r7
            r6 = r0
            r0 = r10
            java.lang.String r1 = "^\\s*\\/\\/.*"
            boolean r0 = r0.matches(r1)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            if (r0 != 0) goto L49
            r0 = r7
            r6 = r0
            r0 = r9
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
        L49:
            r0 = r10
            if (r0 != 0) goto L27
            r0 = r7
            r6 = r0
            r0 = r8
            r0.close()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r0 = r7
            r6 = r0
            r0 = r7
            r0.close()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r0 = r7
            r6 = r0
            r0 = r9
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L88
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L69
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L97
        L69:
            r0 = r8
            return r0
        L6b:
            r8 = move-exception
            goto L78
        L6f:
            r6 = move-exception
            r0 = r8
            r7 = r0
            goto L8d
        L75:
            r8 = move-exception
            r0 = 0
            r7 = r0
        L78:
            r0 = r7
            r6 = r0
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L88
            r0 = r7
            if (r0 == 0) goto L86
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L9a
        L86:
            r0 = 0
            return r0
        L88:
            r8 = move-exception
            r0 = r6
            r7 = r0
            r0 = r8
            r6 = r0
        L8d:
            r0 = r7
            if (r0 == 0) goto L95
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L9d
        L95:
            r0 = r6
            throw r0
        L97:
            r6 = move-exception
            r0 = r8
            return r0
        L9a:
            r6 = move-exception
            r0 = 0
            return r0
        L9d:
            r7 = move-exception
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.web.jsbridge.BridgeUtil.assetFile2Str(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String getDataFromReturnUrl(String str) {
        if (str.startsWith(YY_FETCH_QUEUE)) {
            return str.replace(YY_FETCH_QUEUE, "");
        }
        String[] split = str.replace(YY_RETURN_DATA, "").split(SPLIT_MARK);
        if (split.length < 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return sb.toString();
            }
            sb.append(split[i2]);
            i = i2 + 1;
        }
    }

    public static String getFunctionFromReturnUrl(String str) {
        String[] split = str.replace(YY_RETURN_DATA, "").split(SPLIT_MARK);
        if (split.length >= 1) {
            return split[0];
        }
        return null;
    }

    public static String parseFunctionName(String str) {
        return str.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static void webViewLoadJs(WebView webView, String str) {
        Tracker.loadUrl(webView, "javascript:" + (("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void webViewLoadLocalJs(WebView webView, String str) {
        String assetFile2Str = assetFile2Str(webView.getContext(), str);
        Tracker.loadUrl(webView, "javascript:" + assetFile2Str);
    }
}

package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.bm;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/au.class */
public abstract class au {
    private static final String Code = "StrUtil";
    private static final int I = 100;
    private static final String V = "^[0-9\\*\\+\\-\\.]*$";

    public static boolean B(String str) {
        if (str != null) {
            return str.startsWith(bm.HTTP.toString()) || str.startsWith(bm.HTTPS.toString());
        }
        return false;
    }

    public static String C(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? L(str) : a(str);
    }

    public static int Code(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ge.I(Code, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return i;
        }
    }

    public static long Code(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            ge.I(Code, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return j;
        }
    }

    private static String Code(long j) {
        float f = (((float) j) * 1.0f) / 1048576.0f;
        float f2 = f;
        if (f < 0.1f) {
            f2 = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            r0 = r5
            android.content.res.Resources r0 = r0.getResources()
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r5
            com.huawei.hms.ads.ee r0 = com.huawei.hms.ads.dt.Code(r0)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            boolean r0 = r0.Code()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            if (r0 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r10 = r0
            r0 = r10
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r0 = r10
            java.lang.String r1 = "_zh"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r0 = r12
            r1 = r10
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            java.lang.String r2 = "string"
            r3 = r5
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            int r0 = r0.getIdentifier(r1, r2, r3)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L53
            r0 = r12
            r1 = r9
            r2 = r8
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r5 = r0
            goto L5b
        L53:
            r0 = r12
            r1 = r9
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Exception -> L61 java.lang.RuntimeException -> L6d
            r5 = r0
        L5b:
            r0 = r5
            r10 = r0
            goto L96
        L61:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            goto L76
        L6d:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
        L76:
            r0 = r7
            java.lang.String r1 = "getChinaString "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "StrUtil"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.huawei.hms.ads.ge.Z(r0, r1)
            r0 = r11
            r10 = r0
        L96:
            r0 = r10
            r5 = r0
            r0 = r10
            if (r0 != 0) goto Lb6
            r0 = r8
            if (r0 == 0) goto Laf
            r0 = r8
            int r0 = r0.length
            if (r0 <= 0) goto Laf
            r0 = r12
            r1 = r6
            r2 = r8
            java.lang.String r0 = r0.getString(r1, r2)
            return r0
        Laf:
            r0 = r12
            r1 = r6
            java.lang.String r0 = r0.getString(r1)
            r5 = r0
        Lb6:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.au.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }

    public static String Code(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return V(bundle).toString();
    }

    public static String Code(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static String Code(String str, Context context) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedReader bufferedReader2;
        AssetManager assets = context.getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = assets.open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        inputStream2 = inputStream;
                        bufferedReader2 = bufferedReader;
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (Throwable th) {
                        th = th;
                        try {
                            ge.I(Code, "getStringFromAsset " + th.getClass().getSimpleName());
                            inputStream2 = inputStream;
                            bufferedReader2 = bufferedReader;
                            at.Code(bufferedReader2);
                            at.Code((Closeable) inputStream2);
                            return sb.toString();
                        } catch (Throwable th2) {
                            at.Code(bufferedReader);
                            at.Code((Closeable) inputStream);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStream = null;
        }
        at.Code(bufferedReader2);
        at.Code((Closeable) inputStream2);
        return sb.toString();
    }

    public static String Code(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            boolean z = true;
            for (String str2 : list) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public static boolean Code(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean Code(Set<String> set, String str) {
        if (aa.Code(set) || TextUtils.isEmpty(str)) {
            ge.Code(Code, "ModelList or ModelName is empty");
            return true;
        }
        return set.contains(str);
    }

    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(V, str) && str.length() < 100;
    }

    public static Integer F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            ge.Z(Code, "toInteger NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    public static Long I(String str) {
        if (Code(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e) {
            ge.Z(Code, "toLong NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    private static Object I(Object obj) {
        if (obj instanceof Bundle) {
            return V((Bundle) obj);
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                return JSONObject.wrap(obj);
            }
        } catch (Throwable th) {
            ge.I(Code, "wrap Exception:" + th.getClass().getSimpleName());
        }
        return JSONObject.NULL;
    }

    private static String L(String str) {
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null) {
            sb.append(scheme);
            sb.append("://");
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = parse.getHost();
        } else {
            sb.append("******");
            sb.append('/');
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                sb.append((CharSequence) lastPathSegment, 0, 3);
            } else if (length > 1) {
                sb.append((CharSequence) lastPathSegment, 0, length - 1);
            }
        }
        sb.append("******");
        return sb.toString();
    }

    public static String S(String str) {
        if (Code(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ge.Z(Code, "unsupport encoding");
            return null;
        }
    }

    public static String V(Object obj) {
        return obj == null ? com.igexin.push.core.b.l : "not null";
    }

    public static String V(String str) {
        String str2;
        if (Code(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str2 = "unsupport encoding";
            ge.Z(Code, str2);
            return null;
        } catch (Exception e2) {
            str2 = "decode error";
            ge.Z(Code, str2);
            return null;
        }
    }

    public static JSONObject V(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        Set<String> keySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            try {
                jSONObject.put(str, I(bundle.get(str)));
            } catch (Throwable th) {
                ge.I(Code, "converBundleToJson Exception:" + th.getClass().getSimpleName());
            }
        }
        return jSONObject;
    }

    public static String Z(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "\\\"");
    }

    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        String str2 = str;
        if (lastIndexOf >= 0) {
            int i = lastIndexOf + 1;
            str2 = str;
            if (i < str.length()) {
                str2 = str.substring(i);
            }
        }
        int length = str2.length();
        String str3 = "******";
        if (length > 3) {
            str3 = str2.substring(0, 3) + "******";
        } else if (length > 1) {
            return str2.substring(0, length - 1) + "******";
        }
        return str3;
    }
}

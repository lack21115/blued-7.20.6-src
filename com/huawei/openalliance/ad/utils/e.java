package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.huawei.hms.ads.ge;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/e.class */
public class e {
    private static final String Code = "ApkUtil";
    private static final Map<String, List<String>> V;

    static {
        HashMap hashMap = new HashMap();
        V = hashMap;
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        V.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        V.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static String B(Context context, String str) {
        byte[] F = F(context, str);
        if (F == null || F.length == 0) {
            return null;
        }
        return u.Code(aq.Code(F));
    }

    public static boolean C(Context context, String str) {
        return Code(V.get(str), B(context, str));
    }

    public static boolean Code() {
        return Build.VERSION.SDK_INT <= 29 || !V();
    }

    public static boolean Code(Context context) {
        return !TextUtils.isEmpty(V(context));
    }

    public static boolean Code(Context context, String str) {
        return V(context, str) != null;
    }

    public static boolean Code(Context context, String str, String str2) {
        String str3;
        Intent V2;
        ge.V(Code, "openApp intent");
        try {
            if (context.getPackageManager() == null || (V2 = V(context, str2, str)) == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                V2.addFlags(268435456);
            }
            V2.setClipData(com.huawei.openalliance.ad.constant.t.cF);
            context.startActivity(V2);
            return true;
        } catch (ActivityNotFoundException e) {
            str3 = "activity not exist";
            ge.I(Code, str3);
            return false;
        } catch (Exception e2) {
            str3 = "handle intent url fail";
            ge.I(Code, str3);
            return false;
        }
    }

    private static boolean Code(Intent intent, String str) {
        boolean z = true;
        if (intent != null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            ComponentName component = intent.getComponent();
            z = true;
            if (component != null) {
                String packageName = component.getPackageName();
                z = true;
                if (!TextUtils.isEmpty(packageName)) {
                    if (str.equalsIgnoreCase(packageName)) {
                        return true;
                    }
                    z = false;
                }
            }
        }
        return z;
    }

    public static boolean Code(String str) {
        return "com.huawei.hwid".equals(str) || "com.huawei.hms".equals(str) || "com.huawei.hwid.tv".equals(str);
    }

    private static boolean Code(List<ResolveInfo> list) {
        if (aa.Code(list)) {
            return false;
        }
        boolean z = true;
        for (ResolveInfo resolveInfo : list) {
            if (!resolveInfo.activityInfo.exported) {
                z = false;
            }
        }
        return z;
    }

    private static boolean Code(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] F(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String sb;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                byteArrayInputStream = null;
                if (packageManager != null) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                    byteArrayInputStream = null;
                    if (packageInfo != null) {
                        byteArrayInputStream = null;
                        if (packageInfo.signatures.length > 0) {
                            byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                            try {
                                byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getEncoded();
                                at.Code((Closeable) byteArrayInputStream);
                                return encoded;
                            } catch (RuntimeException e) {
                                e = e;
                                StringBuilder sb2 = new StringBuilder();
                                ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
                                sb2.append("getPackageSignatureBytes RuntimeException:");
                                ByteArrayInputStream byteArrayInputStream4 = byteArrayInputStream;
                                sb2.append(e.getClass().getSimpleName());
                                ByteArrayInputStream byteArrayInputStream5 = byteArrayInputStream;
                                sb = sb2.toString();
                                InputStream inputStream = byteArrayInputStream;
                                ge.Z(Code, sb);
                                at.Code((Closeable) byteArrayInputStream);
                                ge.V(Code, "Failed to get application signature certificate fingerprint.");
                                return new byte[0];
                            } catch (Exception e2) {
                                e = e2;
                                StringBuilder sb3 = new StringBuilder();
                                ByteArrayInputStream byteArrayInputStream6 = byteArrayInputStream;
                                sb3.append("getPackageSignatureBytes Exception:");
                                ByteArrayInputStream byteArrayInputStream7 = byteArrayInputStream;
                                sb3.append(e.getClass().getSimpleName());
                                ByteArrayInputStream byteArrayInputStream8 = byteArrayInputStream;
                                sb = sb3.toString();
                                InputStream inputStream2 = byteArrayInputStream;
                                ge.Z(Code, sb);
                                at.Code((Closeable) byteArrayInputStream);
                                ge.V(Code, "Failed to get application signature certificate fingerprint.");
                                return new byte[0];
                            } catch (Throwable th) {
                                byteArrayInputStream2 = byteArrayInputStream;
                                th = th;
                                at.Code((Closeable) byteArrayInputStream2);
                                throw th;
                            }
                        }
                    }
                }
            } catch (RuntimeException e3) {
                e = e3;
                byteArrayInputStream = null;
            } catch (Exception e4) {
                e = e4;
                byteArrayInputStream = null;
            }
            at.Code((Closeable) byteArrayInputStream);
            ge.V(Code, "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String I(Context context) {
        return Code(context, "com.huawei.hwid") ? "com.huawei.hwid" : Code(context, "com.huawei.hms") ? "com.huawei.hms" : Code(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static boolean I(Context context, String str) {
        Intent launchIntentForPackage;
        ge.V(Code, "open app main page");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            launchIntentForPackage.addFlags(268435456);
        }
        launchIntentForPackage.setPackage(str);
        launchIntentForPackage.setClipData(com.huawei.openalliance.ad.constant.t.cF);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    public static ApplicationInfo S(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                ge.V(Code, "pm is null");
                return null;
            }
            return packageManager.getApplicationInfo(str, 128);
        } catch (Throwable th) {
            ge.I(Code, "getApplicationInfo " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static Intent V(Context context, String str, String str2) {
        String str3;
        PackageManager packageManager;
        try {
            if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            if (Code(parseUri, str2)) {
                if (!TextUtils.isEmpty(str2)) {
                    parseUri.setPackage(str2);
                }
                Intent intent = parseUri;
                if (parseUri.getData() != null) {
                    intent = parseUri;
                    if (Build.VERSION.SDK_INT >= 16) {
                        intent = parseUri.setDataAndTypeAndNormalize(parseUri.getData(), parseUri.getType());
                    }
                }
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (!Code(queryIntentActivities)) {
                    ge.I(Code, "parseAndCheckIntent, activity not exists or not exported.");
                    return null;
                } else if (queryIntentActivities.isEmpty() && Code()) {
                    return null;
                } else {
                    return intent;
                }
            }
            return null;
        } catch (URISyntaxException e) {
            str3 = "parseAndCheckIntent, parse uri fail";
            ge.I(Code, str3);
            return null;
        } catch (Exception e2) {
            str3 = "handle intent url fail";
            ge.I(Code, str3);
            return null;
        }
    }

    public static PackageInfo V(Context context, String str) {
        String str2;
        if (ge.Code()) {
            ge.Code(Code, "getPackageInfo, packageName:%s", str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            str2 = "getPackageInfo NameNotFoundException";
            ge.I(Code, str2);
            return null;
        } catch (Exception e2) {
            str2 = "getPackageInfo Exception";
            ge.I(Code, str2);
            return null;
        }
    }

    public static String V(Context context) {
        String I = I(context);
        if (TextUtils.isEmpty(I)) {
            return null;
        }
        if (Code(V.get(I), B(context, I))) {
            return I;
        }
        return null;
    }

    public static boolean V() {
        try {
            return ((Boolean) Class.forName("com.huawei.openalliance.ad.ppskit.utils.AdsCoreScopeUtil").getMethod("isScopePrime", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable th) {
            ge.V(Code, "AdsCoreScopeUtil wrapper not found");
            ge.Code(Code, "is prime sdk: %s.", false);
            return false;
        }
    }

    public static int Z(Context context, String str) {
        try {
            PackageInfo V2 = V(context, str);
            if (V2 == null) {
                return 0;
            }
            return V2.versionCode;
        } catch (AndroidRuntimeException | Exception e) {
            ge.I(Code, "getAppVersionCode fail");
            return 0;
        }
    }
}

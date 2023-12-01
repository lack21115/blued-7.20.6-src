package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.youzan.androidsdk.tool.AppSigning;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/a.class */
public class a {
    public static RequestHeader a() throws ApiException {
        String str;
        String str2;
        Context a2 = d.e.a();
        try {
            Object obj = a2.getPackageManager().getApplicationInfo(a2.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            str = null;
            if (obj != null) {
                str = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e) {
            b.a("ConfigUtils", "getPushAppId", e);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            b.a("checkPushConfig Parameter is missing");
            throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
        }
        String a3 = a(a2, a2.getPackageName());
        if (TextUtils.isEmpty(a3)) {
            b.a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setPackageName(a2.getPackageName());
        requestHeader.setAppId(str);
        requestHeader.setCertificateFingerprint(a3);
        c cVar = c.b;
        requestHeader.setPushToken(cVar.b(a2));
        synchronized (cVar) {
            cVar.a(a2);
            SharedPreferences sharedPreferences = c.f22282a.f22323a;
            String string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
            str2 = string;
            if (TextUtils.isEmpty(string)) {
                str2 = UUID.randomUUID().toString().replace("-", "");
                c.f22282a.a("key_aaid", str2);
            }
        }
        requestHeader.setAAID(str2);
        requestHeader.setSdkVersion(BuildConfig.PUSH_SDK_VERSION_CODE);
        return requestHeader;
    }

    public static ApiException a(Exception exc) {
        return exc.getCause() instanceof ApiException ? (ApiException) exc.getCause() : exc instanceof ApiException ? (ApiException) exc : new ApiException(-1, exc.getMessage());
    }

    public static <TResult> j0<TResult> a(Callable<TResult> callable) {
        ExecutorService executorService = y.f22325c.b;
        x xVar = new x();
        try {
            executorService.execute(new i0(xVar, callable));
        } catch (Exception e) {
            xVar.a(e);
        }
        return xVar.f22324a;
    }

    public static <TResult> TResult a(j0<TResult> j0Var) throws ExecutionException, InterruptedException {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (j0Var.f22307a) {
                z = j0Var.b;
            }
            if (z) {
                if (j0Var.e()) {
                    return j0Var.c();
                }
                throw new ExecutionException(j0Var.b());
            }
            l0 l0Var = new l0();
            y yVar = y.f22325c;
            j0Var.a(new h0(yVar.f22326a, l0Var)).a(new f0(yVar.f22326a, l0Var)).a(new b0(yVar.f22326a, l0Var));
            l0Var.f22311a.await();
            if (j0Var.e()) {
                return j0Var.c();
            }
            throw new ExecutionException(j0Var.b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0073 -> B:17:0x0075). Please submit an issue!!! */
    public static String a(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        StringBuilder sb = new StringBuilder("getCertFingerprint pkgName=");
        sb.append(str);
        sb.append("onlyOne=true");
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 30) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                signatureArr = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            }
            signatureArr = null;
        } else {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 != null) {
                signatureArr = packageInfo2.signatures;
            }
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            int length = signatureArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                try {
                    byte[] digest = MessageDigest.getInstance(AppSigning.SHA256).digest(signatureArr[i2].toByteArray());
                    StringBuilder sb2 = new StringBuilder();
                    int length2 = digest.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            break;
                        }
                        String upperCase = Integer.toHexString(digest[i4] & 255).toUpperCase(Locale.US);
                        if (upperCase.length() == 1) {
                            sb2.append("0");
                        }
                        sb2.append(upperCase);
                        i3 = i4 + 1;
                    }
                    str2 = sb2.toString();
                } catch (NoSuchAlgorithmException e) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                    break;
                }
                i = i2 + 1;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }

    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                StringBuilder sb = new StringBuilder("0x");
                int i3 = i2 * 2;
                sb.append(new String(new byte[]{bytes[i3]}, StandardCharsets.UTF_8));
                byte byteValue = (byte) (Byte.decode(sb.toString()).byteValue() << 4);
                StringBuilder sb2 = new StringBuilder("0x");
                sb2.append(new String(new byte[]{bytes[i3 + 1]}, StandardCharsets.UTF_8));
                bArr[i2] = (byte) (byteValue ^ Byte.decode(sb2.toString()).byteValue());
                i = i2 + 1;
            }
        } catch (NumberFormatException e) {
            new StringBuilder("hex string 2 byte array exception : ").append(e.getMessage());
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null) {
            return bArr;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                return bArr;
            }
            if (i < 0) {
                bArr[i3] = (byte) (bArr[i3] << (-i));
            } else {
                bArr[i3] = (byte) (bArr[i3] >> i);
            }
            i2 = i3 + 1;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null) {
            int length = bArr.length;
            if (length == bArr2.length) {
                byte[] bArr4 = new byte[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    bArr3 = bArr4;
                    if (i2 >= length) {
                        break;
                    }
                    bArr4[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        }
        return bArr3;
    }
}

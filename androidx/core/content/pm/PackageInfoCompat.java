package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/PackageInfoCompat.class */
public final class PackageInfoCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/PackageInfoCompat$Api28Impl.class */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static boolean a(PackageManager packageManager, String str, byte[] bArr, int i) {
            return packageManager.hasSigningCertificate(str, bArr, i);
        }

        static boolean a(SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        static Signature[] b(SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        static Signature[] c(SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean a(byte[][] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Arrays.equals(bArr2, bArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(AppSigning.SHA256).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
        }
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public static List<Signature> getSignatures(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
            signatureArr = Api28Impl.a(signingInfo) ? Api28Impl.b(signingInfo) : Api28Impl.c(signingInfo);
        } else {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        }
        return signatureArr == null ? Collections.emptyList() : Arrays.asList(signatureArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasSignatures(PackageManager packageManager, String str, Map<byte[], Integer> map, boolean z) throws PackageManager.NameNotFoundException {
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> keySet = map.keySet();
        for (byte[] bArr : keySet) {
            if (bArr == null) {
                throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
            Integer num = map.get(bArr);
            if (num == null) {
                throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
            }
            int intValue = num.intValue();
            if (intValue != 0 && intValue != 1) {
                throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
            }
        }
        List<Signature> signatures = getSignatures(packageManager, str);
        if (!z && Build.VERSION.SDK_INT >= 28) {
            for (byte[] bArr2 : keySet) {
                if (!Api28Impl.a(packageManager, str, bArr2, map.get(bArr2).intValue())) {
                    return false;
                }
            }
            return true;
        } else if (signatures.size() == 0 || map.size() > signatures.size()) {
            return false;
        } else {
            if (!z || map.size() == signatures.size()) {
                byte[][] bArr3 = null;
                if (map.containsValue(1)) {
                    byte[] bArr4 = new byte[signatures.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        bArr3 = bArr4;
                        if (i2 >= signatures.size()) {
                            break;
                        }
                        bArr4[i2] = a(signatures.get(i2).toByteArray());
                        i = i2 + 1;
                    }
                }
                Iterator<byte[]> it = keySet.iterator();
                if (it.hasNext()) {
                    byte[] next = it.next();
                    Integer num2 = map.get(next);
                    int intValue2 = num2.intValue();
                    if (intValue2 == 0) {
                        return signatures.contains(new Signature(next));
                    } else if (intValue2 == 1) {
                        return a(bArr3, next);
                    } else {
                        throw new IllegalArgumentException("Unsupported certificate type " + num2);
                    }
                }
                return false;
            }
            return false;
        }
    }
}

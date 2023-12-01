package s_a.s_a.s_a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.anythink.core.common.b.g;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a/a.class */
public class a {
    public static Pair<String, String> a(String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKey c = c(str);
            if (c == null) {
                return null;
            }
            cipher.init(1, c);
            return new Pair<>(Base64.encodeToString(cipher.doFinal(bArr), 2), Base64.encodeToString(cipher.getIV(), 2));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1018");
            sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
            Log.e("IDHelper", sb.toString());
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1011 ");
            sb.append(e.getMessage());
            Log.e("IDHelper", sb.toString() != null ? e.getMessage() : e.getLocalizedMessage());
            signatureArr = null;
        }
        if (signatureArr == null) {
            return null;
        }
        int length = signatureArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Signature signature = signatureArr[i2];
            if ("SHA1".equals(str2)) {
                byte[] byteArray = signature.toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest == null) {
                        return null;
                    }
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb2 = new StringBuilder();
                    int length2 = digest.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            return sb2.toString();
                        }
                        sb2.append(Integer.toHexString((digest[i4] & 255) | 256).substring(1, 3));
                        i3 = i4 + 1;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("1012 ");
                    sb3.append(e2.getMessage());
                    Log.e("IDHelper", sb3.toString() != null ? e2.getMessage() : e2.getLocalizedMessage());
                    return null;
                }
            } else {
                i = i2 + 1;
            }
        }
    }

    public static String a(Context context, String str, HashMap<String, e> hashMap) {
        if (hashMap.isEmpty() || !hashMap.containsKey(str)) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("cache", 0);
                if (!hashMap.containsKey("GUID")) {
                    String string = sharedPreferences.getString("GUID", null);
                    long j = sharedPreferences.getLong("GUID_TIME", 0L);
                    String string2 = sharedPreferences.getString("GUID_IV", null);
                    if (string != null && j != 0 && string2 != null) {
                        try {
                            byte[] a = a("StdIdAppKey", string, string2);
                            if (a != null) {
                                hashMap.put("GUID", new e(new String(a, "ISO-8859-1"), j));
                            }
                        } catch (UnsupportedEncodingException e) {
                            Log.e("IDHelper", e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
                        }
                    }
                }
                if (!hashMap.containsKey("APID")) {
                    String string3 = sharedPreferences.getString("APID", null);
                    long j2 = sharedPreferences.getLong("APID_TIME", 0L);
                    String string4 = sharedPreferences.getString("APID_IV", null);
                    if (string3 != null && j2 != 0 && string4 != null) {
                        try {
                            byte[] a2 = a("StdIdAppKey", string3, string4);
                            if (a2 != null) {
                                hashMap.put("APID", new e(new String(a2, "ISO-8859-1"), j2));
                            }
                        } catch (UnsupportedEncodingException e2) {
                            Log.e("IDHelper", e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                        }
                    }
                }
                if (!hashMap.containsKey("DUID")) {
                    String string5 = sharedPreferences.getString("DUID", null);
                    long j3 = sharedPreferences.getLong("DUID_TIME", 0L);
                    if (string5 != null && j3 != 0) {
                        hashMap.put("DUID", new e(string5, j3));
                    }
                }
                if (!hashMap.containsKey("AUID")) {
                    String string6 = sharedPreferences.getString("AUID", null);
                    long j4 = sharedPreferences.getLong("AUID_TIME", 0L);
                    if (string6 != null && j4 != 0) {
                        hashMap.put("AUID", new e(string6, j4));
                    }
                }
            } catch (IllegalStateException e3) {
                StringBuilder sb = new StringBuilder();
                sb.append("1020:");
                sb.append(e3.getMessage());
                Log.e("IDHelper", sb.toString() != null ? e3.getMessage() : e3.getLocalizedMessage());
            }
        }
        String str2 = "";
        if (hashMap.containsKey(str)) {
            e eVar = hashMap.get(str);
            str2 = "";
            if (eVar.a(str)) {
                str2 = eVar.a;
            }
        }
        return str2;
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            f.a("4025: " + e.toString());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
        if (r7.equals("APID") != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0135 A[Catch: IllegalStateException -> 0x017b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x017b, blocks: (B:14:0x0025, B:24:0x005c, B:49:0x00ae, B:51:0x00bf, B:53:0x00c7, B:69:0x0173, B:54:0x00d3, B:56:0x00e4, B:57:0x00ed, B:59:0x00fe, B:61:0x0120, B:63:0x012a, B:64:0x0135, B:66:0x0146, B:68:0x0168, B:28:0x006a, B:32:0x0078, B:36:0x0086), top: B:78:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, s_a.s_a.s_a.a.e r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s_a.s_a.s_a.a.a.a(android.content.Context, s_a.s_a.s_a.a.e, java.lang.String):void");
    }

    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT > 29 || b(context, MsgBackupManager.PLATFORM_ANDROID).equals(b(context, str));
    }

    public static byte[] a(String str, String str2, String str3) {
        try {
            byte[] decode = Base64.decode(str2, 2);
            byte[] decode2 = Base64.decode(str3, 2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, decode2);
            SecretKey c = c(str);
            if (c == null) {
                return null;
            }
            cipher.init(2, c, gCMParameterSpec);
            return cipher.doFinal(decode);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1015:");
            sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
            Log.e("IDHelper", sb.toString());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long b(String str) {
        boolean z;
        switch (str.hashCode()) {
            case 2015626:
                if (str.equals("APID")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 2020431:
                if (str.equals("AUID")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2109804:
                if (str.equals("DUID")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2199177:
                if (str.equals("GUID")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2437505:
                if (str.equals("OUID")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 572132464:
                if (str.equals("OUID_STATUS")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z) {
            return 259200000L;
        }
        if (!z) {
            if (!z) {
                if (z || z) {
                    return g.e.a;
                }
                return 0L;
            }
            return 86400000L;
        }
        return 604800000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s_a.s_a.s_a.a.a.b(android.content.Context, java.lang.String):java.lang.String");
    }

    public static SecretKey c(String str) {
        SecretKey secretKey;
        SecretKey secretKey2 = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(str, null);
            secretKey2 = null;
            if (entry != null) {
                secretKey2 = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
            }
            secretKey = secretKey2;
            if (secretKey2 == null) {
                return d(str);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1016:");
            sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
            Log.e("IDHelper", sb.toString());
            secretKey = secretKey2;
        }
        return secretKey;
    }

    public static SecretKey d(String str) {
        try {
            Log.e("IDHelper", "generateSecretKey, alias:" + str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            return keyGenerator.generateKey();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("1017:");
            sb.append(e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage());
            Log.e("IDHelper", sb.toString());
            return null;
        }
    }
}

package com.mokee.security;

import android.app.ActivityThread;
import android.content.Context;
import com.mokee.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/security/License.class */
public class License {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24225a = null;

    static {
        String[] strArr = new String[3];
        throw new VerifyError("bad dex opcode");
    }

    public static void genLicense(Context context, String str, String str2, String str3, String str4) throws Exception {
        try {
            if (ActivityThread.currentPackageName().equals(f24225a[0])) {
                if (getPayAppSignature(context).equals(f24225a[1])) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str, false));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(Build.getUniqueID(context)).append(" ").append(str2).append(" ").append(str3).append(" ").append(str4);
                    bufferedWriter.write(Encryption.toHex(Encryption.encryptByPrivateKey(stringBuffer.toString().getBytes())));
                    bufferedWriter.close();
                }
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (r0 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
        r0.append(r0[r6].toCharsString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0039, code lost:
        r5 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r5 < r0) goto L6;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0040 -> B:6:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getPayAppSignature(android.content.Context r4) {
        /*
            int r0 = com.mokee.security.Encryption.b
            r8 = r0
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            java.lang.String[] r1 = com.mokee.security.License.f24225a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r2 = 2
            r1 = r1[r2]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r2 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r1 = r0
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r9 = r0
            r0 = r4
            int r0 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r7 = r0
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = r8
            if (r0 == 0) goto L3c
        L2c:
            r0 = r9
            r1 = r4
            r2 = r6
            r1 = r1[r2]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            java.lang.String r1 = r1.toCharsString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L3c:
            r0 = r5
            r6 = r0
            r0 = r5
            r1 = r7
            if (r0 < r1) goto L2c
            r0 = r9
            java.lang.String r0 = r0.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L4b
            r4 = r0
            r0 = r4
            return r0
        L4b:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.security.License.getPayAppSignature(android.content.Context):java.lang.String");
    }

    public static String readLincense(String str, String str2) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                    return new String(Encryption.decryptByPublicKey(Encryption.toByte(sb.toString()), str2));
                } catch (Exception e) {
                    throw e;
                }
            }
            sb.append(readLine);
        }
    }
}

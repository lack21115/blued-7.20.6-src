package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/o.class */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9217a = "o";
    private static Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f9218c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static String a(String str) {
        String str2 = b.get(str);
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        }
        return str3;
    }

    private static void a(String str, Context context) {
        String c2 = d.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            a("s", str, c2 + "/files/s");
        } catch (IOException e) {
            HMSLog.e(f9217a, "save keyS IOException.");
        }
    }

    private static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        HMSLog.i(f9217a, "save local secret key.");
        try {
            File file = new File(str3);
            p.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                bufferedWriter2 = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
            try {
                bufferedWriter2.write(str2);
                bufferedWriter2.flush();
                b.put(str, str2);
                IOUtils.closeQuietly((Writer) outputStreamWriter);
                IOUtils.closeQuietly((Writer) bufferedWriter2);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                IOUtils.closeQuietly((Writer) outputStreamWriter);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
            bufferedWriter = null;
        }
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c2 = d.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            a("m", str, c2 + "/files/math/m");
            a("p", str2, c2 + "/files/panda/p");
            a("d", str3, c2 + "/files/panda/d");
            a("t", str4, c2 + "/files/math/t");
            a("s", str5, c2 + "/files/s");
        } catch (IOException e) {
            HMSLog.e(f9217a, "save key IOException.");
        }
    }

    public static byte[] a(Context context) {
        byte[] a2 = c.a(context.getString(R.string.push_cat_head));
        byte[] a3 = c.a(context.getString(R.string.push_cat_body));
        return a(a(a(a2, a3), c.a(a())));
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        return Build.VERSION.SDK_INT >= 26 ? BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true) : BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f9217a, "work key is empty, execute init.");
            c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
        return q.a(decryptWorkKey) ? decryptWorkKey : e(context);
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    private static String c() {
        return a("d");
    }

    public static void c(Context context) {
        synchronized (f9218c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f9217a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(d.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.i(f9217a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String a2 = c.a(generateSecureRandom);
            String a3 = c.a(generateSecureRandom2);
            String a4 = c.a(generateSecureRandom3);
            String a5 = c.a(generateSecureRandom4);
            a(a2, a3, a4, a5, WorkKeyCryptUtil.encryptWorkKey(c.a(EncryptUtil.generateSecureRandom(32)), a(a2, a3, a4, a5)), context);
            HMSLog.i(f9217a, "generate D.");
        }
    }

    private static String d() {
        return a("m");
    }

    private static void d(Context context) {
        if (i()) {
            HMSLog.i(f9217a, "secretKeyCache not empty.");
            return;
        }
        b.clear();
        String c2 = d.c(context);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String a2 = p.a(c2 + "/files/math/m");
        String a3 = p.a(c2 + "/files/panda/p");
        String a4 = p.a(c2 + "/files/panda/d");
        String a5 = p.a(c2 + "/files/math/t");
        String a6 = p.a(c2 + "/files/s");
        if (q.a(a2, a3, a4, a5, a6)) {
            b.put("m", a2);
            b.put("p", a3);
            b.put("d", a4);
            b.put("t", a5);
            b.put("s", a6);
        }
    }

    private static String e() {
        return a("p");
    }

    private static String e(Context context) {
        synchronized (o.class) {
            try {
                String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(f(), b());
                if (q.a(decryptWorkKey)) {
                    HMSLog.i(f9217a, "keyS has been upgraded, no require operate again.");
                    return decryptWorkKey;
                }
                String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(f(), h());
                if (q.a(decryptWorkKey2)) {
                    HMSLog.i(f9217a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                    a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, b()), context);
                    return decryptWorkKey2;
                }
                String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(f(), BaseKeyUtil.exportRootKey(d(), e(), c(), g(), 32, false));
                if (!q.a(decryptWorkKey3)) {
                    HMSLog.e(f9217a, "all mode unable to decrypt root key.");
                    return "";
                }
                HMSLog.i(f9217a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, b()), context);
                return decryptWorkKey3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String f() {
        return a("s");
    }

    private static String g() {
        return a("t");
    }

    private static RootKeyUtil h() {
        return RootKeyUtil.newInstance(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }
}

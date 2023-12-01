package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bw;
import java.io.File;
import java.io.FilenameFilter;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bp.class */
public class bp extends File {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9351a = "LocalApkFile";
    private static final long b = 6916965592955692235L;
    private static ClassLoader h;

    /* renamed from: c  reason: collision with root package name */
    private bu f9352c;
    private Class<?> d;
    private Context e;
    private PublicKey f;
    private bq g;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bp$a.class */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public bp(String str, Context context) {
        this(str, context, null);
    }

    public bp(String str, Context context, bu buVar) {
        super(str);
        this.d = null;
        this.e = null;
        this.g = bq.a();
        this.e = context;
        this.f9352c = buVar;
        if (buVar != null) {
            try {
                this.f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception e) {
                this.f = null;
            }
        }
    }

    public static ClassLoader a(Context context) {
        ClassLoader classLoader = h;
        return classLoader != null ? classLoader : ar.a(context.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x010f A[Catch: Exception -> 0x012b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x012b, blocks: (B:51:0x0103, B:54:0x010f), top: B:62:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.File r6) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.bp.a(java.io.File):java.lang.String");
    }

    private Class<?> b(File file) {
        Class<?> cls;
        bq bqVar = this.g;
        bqVar.a(f9351a, "Android version:" + bj.a(this.e).c());
        Class<?> cls2 = null;
        try {
            synchronized (bw.class) {
                try {
                    String absolutePath = file.getAbsolutePath();
                    ClassLoader classLoader = getClass().getClassLoader();
                    String absolutePath2 = this.e.getFilesDir().getAbsolutePath();
                    String str = w.aC;
                    h = an.a(absolutePath, absolutePath2, (String) null, classLoader);
                    bq bqVar2 = this.g;
                    bqVar2.a(f9351a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                    cls = Class.forName(str, true, h);
                } finally {
                }
            }
            cls2 = cls;
        } catch (Exception e) {
            this.g.a(f9351a, e.getMessage());
        }
        bq bqVar3 = this.g;
        bqVar3.a(f9351a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    private String b(String str) {
        if (this.f != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Exception e) {
                this.g.c("ErrorWhileVerifySigNature", e);
                return null;
            }
        }
        return null;
    }

    private static PublicKey c(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    private void d() {
        File[] listFiles = this.e.getFilesDir().listFiles(new a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (listFiles == null || i2 >= listFiles.length) {
                return;
            }
            if (listFiles[i2].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                bq bqVar = this.g;
                bqVar.a(f9351a, "clearDexCacheFiles-->" + i2 + "--" + listFiles[i2].getAbsolutePath());
                listFiles[i2].delete();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f9352c == null) {
            this.g.a(f9351a, "built-in apk, no need to check");
            return;
        }
        String a2 = a(new File(getAbsolutePath()));
        String b2 = b(this.f9352c.d());
        if (a2.equalsIgnoreCase(b2)) {
            return;
        }
        throw new bw.a("doCheckApkIntegrity failed, md5sum: " + a2 + ", checksum in json info: " + b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        renameTo(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> b() {
        if (this.d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.d = b(file);
            } catch (Exception e) {
                file.delete();
            }
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double c() {
        bu buVar = this.f9352c;
        if (buVar == null) {
            return 0.0d;
        }
        return buVar.b();
    }
}

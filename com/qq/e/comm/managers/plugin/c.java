package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f27920a = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};
    private PublicKey b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27921c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f27922a = new c();
    }

    private c() {
        boolean z;
        try {
            this.b = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        this.f27921c = z;
    }

    private PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("公钥非法");
        }
    }

    public boolean a(String str, File file) {
        String str2;
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.exists()) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String a2 = d.a(messageDigest.digest());
                try {
                    fileInputStream.close();
                    str2 = a2;
                } catch (Exception e2) {
                    str2 = a2;
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                str2 = "";
                return a(str, str2);
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
            return a(str, str2);
        }
        str2 = "";
        return a(str, str2);
    }

    public boolean a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.f27921c) {
            if (this.b != null) {
                byte[] decode = Base64.decode(str, 0);
                try {
                    Cipher cipher = Cipher.getInstance(new String(f27920a, "UTF-8"));
                    cipher.init(2, this.b);
                    str3 = new String(cipher.doFinal(decode), "UTF-8").trim();
                } catch (Throwable th) {
                    GDTLogger.d("ErrorWhileVerifySigNature");
                }
                boolean equals = str2.equals(str3);
                GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + str3);
                return equals;
            }
            str3 = null;
            boolean equals2 = str2.equals(str3);
            GDTLogger.d("Verify Result" + equals2 + "src=" + str2 + " & target=" + str3);
            return equals2;
        }
        return true;
    }
}

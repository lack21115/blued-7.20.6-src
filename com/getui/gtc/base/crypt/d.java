package com.getui.gtc.base.crypt;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    a f21904a;
    c b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, SecretKey> f21905c = new HashMap();
    Map<String, SecretKey> d = new HashMap();
    Map<String, KeyPair> e = new HashMap();
    Map<String, IvParameterSpec> f = new HashMap();
    String g;

    private KeyPair d(String str) {
        try {
            String digestToHexString = CryptTools.digestToHexString("MD5", (str + "-rsa1024alias").getBytes());
            if (this.e.containsKey(digestToHexString)) {
                return this.e.get(digestToHexString);
            }
            KeyPair a2 = this.f21904a.a(null, digestToHexString, false);
            if (a2 == null) {
                return null;
            }
            this.e.put(digestToHexString, a2);
            return a2;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x014c A[Catch: all -> 0x0166, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0166, blocks: (B:21:0x0137, B:23:0x014c, B:25:0x015c, B:26:0x0165), top: B:34:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015c A[Catch: all -> 0x0166, TRY_ENTER, TryCatch #0 {all -> 0x0166, blocks: (B:21:0x0137, B:23:0x014c, B:25:0x015c, B:26:0x0165), top: B:34:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.getui.gtc.base.crypt.CryptException> a(android.content.Context r7) throws com.getui.gtc.base.crypt.CryptException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.base.crypt.d.a(android.content.Context):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecretKey a() {
        return b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecretKey a(String str) {
        try {
            String digestToHexString = CryptTools.digestToHexString("MD5", (str + "-aes128alias").getBytes());
            if (this.f21905c.containsKey(digestToHexString)) {
                return this.f21905c.get(digestToHexString);
            }
            SecretKey a2 = this.f21904a.a(digestToHexString);
            if (a2 == null) {
                return null;
            }
            this.f21905c.put(digestToHexString, a2);
            return a2;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecretKey b(String str) {
        try {
            String digestToHexString = CryptTools.digestToHexString("MD5", (str + "-aes128alias").getBytes());
            if (this.d.containsKey(digestToHexString)) {
                return this.d.get(digestToHexString);
            }
            SecretKey a2 = this.b.a(digestToHexString, false, d(str));
            if (a2 == null) {
                return null;
            }
            this.d.put(digestToHexString, a2);
            return a2;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IvParameterSpec b() {
        return c(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IvParameterSpec c(String str) {
        try {
            String digestToHexString = CryptTools.digestToHexString("MD5", (str + "-ivalias").getBytes());
            if (this.f.containsKey(digestToHexString)) {
                return this.f.get(digestToHexString);
            }
            IvParameterSpec b = this.b.b(digestToHexString, false, d(str));
            if (b == null) {
                return null;
            }
            this.f.put(digestToHexString, b);
            return b;
        } catch (Throwable th) {
            return null;
        }
    }
}

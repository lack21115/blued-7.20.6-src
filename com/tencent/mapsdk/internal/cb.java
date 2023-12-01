package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.za;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cb.class */
public class cb {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f37363c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private final va<String, String> f37364a = new va<>(1000);
    private final za.k<za.m<MessageDigest>> b = za.b(10, new a());

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cb$a.class */
    public class a implements za.i<za.m<MessageDigest>> {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.za.i
        /* renamed from: b */
        public za.m<MessageDigest> a() {
            try {
                return new za.m<>(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr);
            }
            byte b = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f37363c;
            cArr[i3 + 1] = cArr2[b & 15];
            cArr[i3 + 0] = cArr2[((byte) (b >>> 4)) & 15];
            i = i2 + 1;
        }
    }

    public String a(String str) {
        String b;
        synchronized (this.f37364a) {
            b = this.f37364a.b((va<String, String>) str);
        }
        String str2 = b;
        if (b == null) {
            za.m<MessageDigest> a2 = this.b.a();
            try {
                a2.b().update(str.getBytes());
                str2 = a(a2.b().digest());
            } finally {
                this.b.a(a2);
            }
        }
        synchronized (this.f37364a) {
            this.f37364a.a(str, str2);
        }
        return str2;
    }
}

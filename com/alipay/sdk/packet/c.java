package com.alipay.sdk.packet;

import com.alipay.sdk.encrypt.f;
import com.alipay.sdk.util.n;
import java.util.Locale;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/packet/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4639a;
    private String b = n.a(24);

    public c(boolean z) {
        this.f4639a = z;
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }

    private static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    private static byte[] a(String str, String str2) {
        return com.alipay.sdk.encrypt.e.a(str, str2);
    }

    private static byte[] a(String str, byte[] bArr, String str2) {
        return f.a(str, bArr, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[]... r4) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.c.a(byte[][]):byte[]");
    }

    private static byte[] b(String str, byte[] bArr, String str2) {
        return f.b(str, bArr, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.sdk.packet.b a(com.alipay.sdk.packet.d r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.c.a(com.alipay.sdk.packet.d, java.lang.String):com.alipay.sdk.packet.b");
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v22, types: [byte[], byte[][]] */
    public d a(b bVar, boolean z, String str) {
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        byte[] bArr = bytes2;
        boolean z2 = z;
        if (z) {
            try {
                bArr = com.alipay.sdk.encrypt.c.a(bytes2);
                z2 = z;
            } catch (Exception e) {
                z2 = false;
                bArr = bytes2;
            }
        }
        return new d(z2, this.f4639a ? a((byte[][]) new byte[]{bytes, a(this.b, com.alipay.sdk.cons.a.e), a(this.b, bArr, str)}) : a((byte[][]) new byte[]{bytes, bArr}));
    }
}

package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/b.class */
public final class b {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate[][] f21409a;
        public final byte[] b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f21409a = x509CertificateArr;
            this.b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a2 = f.a(mVar.f21422a);
                int i = 0;
                while (a2.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(f.a(a2), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i > 0) {
                    if (arrayMap.isEmpty()) {
                        throw new SecurityException("No content digests found");
                    }
                    f.a(arrayMap, randomAccessFile, mVar);
                    byte[] bArr = null;
                    if (arrayMap.containsKey(3)) {
                        bArr = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                    }
                    return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), bArr);
                }
                throw new SecurityException("No signers found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a2 = f.a(byteBuffer);
            if (a2.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
            } else if (a2.getInt() == -1091571699) {
                if (a2.remaining() < 4) {
                    throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a2.remaining());
                } else if (a2.getInt() == 3) {
                    throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int a2;
        ByteBuffer a3 = f.a(byteBuffer);
        ByteBuffer a4 = f.a(byteBuffer);
        byte[] b = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        int i = -1;
        int i2 = 0;
        while (a4.hasRemaining()) {
            int i3 = i2 + 1;
            try {
                ByteBuffer a5 = f.a(a4);
                if (a5.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i4 = a5.getInt();
                arrayList.add(Integer.valueOf(i4));
                boolean z = true;
                if (i4 != 513) {
                    z = true;
                    if (i4 != 514) {
                        z = true;
                        if (i4 != 769) {
                            z = true;
                            if (i4 != 1057) {
                                z = true;
                                if (i4 != 1059) {
                                    z = true;
                                    if (i4 != 1061) {
                                        z = true;
                                        switch (i4) {
                                            case 257:
                                            case 258:
                                            case 259:
                                            case 260:
                                                break;
                                            default:
                                                z = false;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (i != -1) {
                        i2 = i3;
                        if (f.a(i4, i) > 0) {
                        }
                    }
                    bArr = f.b(a5);
                    i = i4;
                    i2 = i3;
                } else {
                    i2 = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String c2 = f.c(i);
        Pair<String, ? extends AlgorithmParameterSpec> d = f.d(i);
        String str = d.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(c2).generatePublic(new X509EncodedKeySpec(b));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(a3);
            if (!signature.verify(bArr)) {
                throw new SecurityException(str + " signature did not verify");
            }
            a3.clear();
            ByteBuffer a6 = f.a(a3);
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            byte[] bArr2 = null;
            while (a6.hasRemaining()) {
                int i6 = i5 + 1;
                try {
                    ByteBuffer a7 = f.a(a6);
                    if (a7.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = a7.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    i5 = i6;
                    if (i7 == i) {
                        bArr2 = f.b(a7);
                        i5 = i6;
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (arrayList.equals(arrayList2)) {
                byte[] put = map.put(Integer.valueOf(f.a(i)), bArr2);
                if (put != null && !MessageDigest.isEqual(put, bArr2)) {
                    throw new SecurityException(f.b(a2) + " contents digest does not match the digest specified by a preceding signer");
                }
                ByteBuffer a8 = f.a(a3);
                ArrayList arrayList3 = new ArrayList();
                int i8 = 0;
                while (a8.hasRemaining()) {
                    i8++;
                    byte[] b2 = f.b(a8);
                    try {
                        arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b2)), b2));
                    } catch (CertificateException e3) {
                        throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                    }
                }
                if (arrayList3.isEmpty()) {
                    throw new SecurityException("No certificates listed");
                }
                if (Arrays.equals(b, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                    a(f.a(a3));
                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                }
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }
}

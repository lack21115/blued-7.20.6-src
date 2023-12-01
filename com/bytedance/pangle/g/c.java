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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/c.class */
public final class c {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/c$a.class */
    static final class a extends Exception {
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<X509Certificate> f21410a;
        public final List<Integer> b;

        public b(List<X509Certificate> list, List<Integer> list2) {
            this.f21410a = list;
            this.b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/c$c.class */
    public static final class C0318c {

        /* renamed from: a  reason: collision with root package name */
        public final X509Certificate[] f21411a;
        public final b b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f21412c;

        public C0318c(X509Certificate[] x509CertificateArr, b bVar) {
            this.f21411a = x509CertificateArr;
            this.b = bVar;
        }
    }

    private static b a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i3 = -1;
            p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer a2 = f.a(byteBuffer);
                ByteBuffer a3 = f.a(a2);
                int i4 = a2.getInt();
                int i5 = a2.getInt();
                byte[] b2 = f.b(a2);
                if (pVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> d = f.d(i3);
                    PublicKey publicKey = pVar.getPublicKey();
                    Signature signature = Signature.getInstance(d.first);
                    signature.initVerify(publicKey);
                    if (d.second != 0) {
                        signature.setParameter((AlgorithmParameterSpec) d.second);
                    }
                    signature.update(a3);
                    if (!signature.verify(b2)) {
                        StringBuilder sb = new StringBuilder("Unable to verify signature of certificate #");
                        sb.append(i);
                        sb.append(" using ");
                        sb.append(d.first);
                        sb.append(" when verifying Proof-of-rotation record");
                        throw new SecurityException(sb.toString());
                    }
                }
                a3.rewind();
                byte[] b3 = f.b(a3);
                int i6 = a3.getInt();
                if (pVar != null && i3 != i6) {
                    StringBuilder sb2 = new StringBuilder("Signing algorithm ID mismatch for certificate #");
                    sb2.append(i);
                    sb2.append(" when verifying Proof-of-rotation record");
                    throw new SecurityException(sb2.toString());
                }
                pVar = new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b3)), b3);
                if (hashSet.contains(pVar)) {
                    StringBuilder sb3 = new StringBuilder("Encountered duplicate entries in Proof-of-rotation record at certificate #");
                    sb3.append(i);
                    sb3.append(".  All signing certificates should be unique");
                    throw new SecurityException(sb3.toString());
                }
                hashSet.add(pVar);
                arrayList.add(pVar);
                arrayList2.add(Integer.valueOf(i4));
                i3 = i5;
            }
            return new b(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            i2 = 0;
            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i2 + " when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            i2 = 0;
            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i2 + " when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            i2 = 0;
            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i2 + " when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i2 + " when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0318c a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a2 = f.a(mVar.f21422a);
                int i = 0;
                C0318c c0318c = null;
                while (a2.hasRemaining()) {
                    try {
                        i++;
                        c0318c = a(f.a(a2), arrayMap, certificateFactory);
                    } catch (a e) {
                    } catch (IOException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0318c == null) {
                    throw new SecurityException("No signers found");
                }
                if (i == 1) {
                    if (arrayMap.isEmpty()) {
                        throw new SecurityException("No content digests found");
                    }
                    f.a(arrayMap, randomAccessFile, mVar);
                    if (arrayMap.containsKey(3)) {
                        c0318c.f21412c = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                    }
                    return c0318c;
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }

    private static C0318c a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b bVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a2 = f.a(byteBuffer);
            if (a2.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
            } else if (a2.getInt() == 1000370060) {
                if (bVar != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                b a3 = a(a2, certificateFactory);
                bVar = a3;
                try {
                    if (a3.f21410a.size() <= 0) {
                        continue;
                    } else if (!Arrays.equals(a3.f21410a.get(a3.f21410a.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                    } else {
                        bVar = a3;
                    }
                } catch (CertificateEncodingException e) {
                    throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new C0318c(x509CertificateArr, bVar);
    }

    private static C0318c a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        int a2;
        ByteBuffer a3 = f.a(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer a4 = f.a(byteBuffer);
        byte[] b2 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i3 = -1;
        int i4 = 0;
        byte[] bArr = null;
        while (a4.hasRemaining()) {
            int i5 = i4 + 1;
            try {
                ByteBuffer a5 = f.a(a4);
                if (a5.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i6 = a5.getInt();
                arrayList.add(Integer.valueOf(i6));
                boolean z = true;
                if (i6 != 513) {
                    z = true;
                    if (i6 != 514) {
                        z = true;
                        if (i6 != 769) {
                            z = true;
                            if (i6 != 1057) {
                                z = true;
                                if (i6 != 1059) {
                                    z = true;
                                    if (i6 != 1061) {
                                        z = true;
                                        switch (i6) {
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
                    if (i3 != -1) {
                        i4 = i5;
                        if (f.a(i6, i3) > 0) {
                        }
                    }
                    bArr = f.b(a5);
                    i3 = i6;
                    i4 = i5;
                } else {
                    i4 = i5;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i5)), e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String c2 = f.c(i3);
        Pair<String, ? extends AlgorithmParameterSpec> d = f.d(i3);
        String str = d.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(c2).generatePublic(new X509EncodedKeySpec(b2));
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
            byte[] bArr2 = null;
            int i7 = 0;
            while (a6.hasRemaining()) {
                i7++;
                try {
                    ByteBuffer a7 = f.a(a6);
                    if (a7.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i8 = a7.getInt();
                    arrayList2.add(Integer.valueOf(i8));
                    if (i8 == i3) {
                        bArr2 = f.b(a7);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i7)), e2);
                }
            }
            if (arrayList.equals(arrayList2)) {
                byte[] put = map.put(Integer.valueOf(f.a(i3)), bArr2);
                if (put != null && !MessageDigest.isEqual(put, bArr2)) {
                    throw new SecurityException(f.b(a2) + " contents digest does not match the digest specified by a preceding signer");
                }
                ByteBuffer a8 = f.a(a3);
                ArrayList arrayList3 = new ArrayList();
                int i9 = 0;
                while (a8.hasRemaining()) {
                    i9++;
                    byte[] b3 = f.b(a8);
                    try {
                        arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b3)), b3));
                    } catch (CertificateException e3) {
                        throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i9)), e3);
                    }
                }
                if (arrayList3.isEmpty()) {
                    throw new SecurityException("No certificates listed");
                }
                if (Arrays.equals(b2, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                    if (a3.getInt() == i) {
                        if (a3.getInt() == i2) {
                            return a(f.a(a3), arrayList3, certificateFactory);
                        }
                        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                    }
                    throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                }
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }
}

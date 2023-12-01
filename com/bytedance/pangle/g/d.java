package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.os.Build;
import com.bytedance.pangle.g.c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/d.class */
public final class d {
    /* JADX WARN: Type inference failed for: r0v55, types: [java.security.cert.Certificate[], java.security.cert.Certificate[][]] */
    public static o a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        int i;
        int[] iArr;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(str, "r");
            } catch (Exception e) {
                throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
            }
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            try {
                f.a(str, randomAccessFile2, -262969152, 1896449818);
                try {
                    try {
                        m mVar = f.f7807a.get(str).get(-262969152);
                        if (mVar != null) {
                            c.C0148c a2 = c.a(randomAccessFile2, mVar);
                            Signature[] a3 = a((Certificate[][]) new Certificate[]{a2.f7805a});
                            if (a2.b != null) {
                                int size = a2.b.f7804a.size();
                                signatureArr = new Signature[size];
                                iArr = new int[a2.b.b.size()];
                                for (i = 0; i < size; i++) {
                                    signatureArr[i] = new Signature(a2.b.f7804a.get(i).getEncoded());
                                    iArr[i] = a2.b.b.get(i).intValue();
                                }
                            } else {
                                iArr = null;
                            }
                            o oVar = new o(a3, 3, signatureArr, iArr);
                            try {
                                randomAccessFile2.close();
                                return oVar;
                            } catch (Exception e2) {
                                return oVar;
                            }
                        }
                        throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                    } catch (n e3) {
                        try {
                            try {
                                m mVar2 = f.f7807a.get(str).get(1896449818);
                                if (mVar2 != null) {
                                    o oVar2 = new o(a(b.a(randomAccessFile2, mVar2).f7803a));
                                    try {
                                        randomAccessFile2.close();
                                        return oVar2;
                                    } catch (Exception e4) {
                                        return oVar2;
                                    }
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            } catch (n e5) {
                                o a4 = a.a(str);
                                try {
                                    randomAccessFile2.close();
                                    return a4;
                                } catch (Exception e6) {
                                    return a4;
                                }
                            }
                        } catch (Exception e7) {
                            throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e7);
                        }
                    }
                } catch (Exception e8) {
                    throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e8);
                }
            } catch (Exception e9) {
                throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e9);
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = randomAccessFile2;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e10) {
                }
            }
            throw th;
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= certificateArr.length) {
                return signatureArr;
            }
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 28) {
                Constructor a2 = com.bytedance.pangle.b.b.a.a(Signature.class, Certificate[].class);
                if (a2 != null) {
                    a2.setAccessible(true);
                }
                if (a2 != null && a2.isAccessible()) {
                    try {
                        signatureArr[i2] = (Signature) a2.newInstance(certificateArr[i2]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                signatureArr[i2] = new Signature(certificateArr[i2][0].getEncoded());
            }
            i = i2 + 1;
        }
    }
}

package com.bytedance.pangle.g;

import android.content.pm.Signature;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/g/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f21408a = new AtomicReference<>();

    public static o a(String str) {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry(ShareConstants.RES_MANIFEST);
                    if (jarEntry == null) {
                        throw new q(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] a2 = a(jarFile2, jarEntry);
                    if (com.bytedance.pangle.util.d.a(a2)) {
                        throw new q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] a3 = d.a(a2);
                    Enumeration<JarEntry> entries = jarFile2.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            if (!name.startsWith("META-INF/") && !name.equals(ShareConstants.RES_MANIFEST)) {
                                arrayList.add(nextElement);
                            }
                        }
                    }
                    for (JarEntry jarEntry2 : arrayList) {
                        Certificate[][] a4 = a(jarFile2, jarEntry2);
                        if (com.bytedance.pangle.util.d.a(a4)) {
                            throw new q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                        } else if (!o.a(a3, d.a(a4))) {
                            throw new q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                        }
                    }
                    o oVar = new o(a3, 1, null, null, null);
                    try {
                        jarFile2.close();
                        return oVar;
                    } catch (Exception e) {
                        return oVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                    e = e;
                    throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e3) {
                    e = e3;
                    e = e;
                    throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e4) {
                    e = e4;
                    throw new q(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (RuntimeException e7) {
                e = e7;
            } catch (GeneralSecurityException e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.security.cert.Certificate[], java.security.cert.Certificate[][]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.Certificate[][] a(java.util.jar.JarFile r6, java.util.jar.JarEntry r7) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.a.a(java.util.jar.JarFile, java.util.jar.JarEntry):java.security.cert.Certificate[][]");
    }
}

package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.jr;
import com.anythink.core.common.b.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.kf  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kf.class */
public final class kf {
    public static int a(ke keVar) {
        jr jrVar;
        jr jrVar2 = null;
        try {
            try {
                if (keVar.f.d()) {
                    keVar.f.c_(true);
                    jrVar2 = jr.a(new File(keVar.a), keVar.b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] a = a(jrVar2, keVar, arrayList);
                        if (a != null && a.length != 0) {
                            iv ivVar = new iv(a, keVar.c);
                            ju.a();
                            JSONObject jSONObject = new JSONObject(new String(ju.a(ivVar).a));
                            if (jSONObject.has(g.c.b) && jSONObject.getInt(g.c.b) == 1) {
                                if (keVar.f != null && a != null) {
                                    keVar.f.b_(a.length);
                                }
                                if (keVar.f.a() < Integer.MAX_VALUE) {
                                    a(jrVar2, arrayList);
                                } else {
                                    jrVar2.d();
                                }
                                return a.length;
                            }
                        }
                        if (jrVar2 != null) {
                            try {
                                jrVar2.close();
                                return -1;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return -1;
                            }
                        }
                        return -1;
                    } catch (Throwable th2) {
                        jrVar = jrVar2;
                        th = th2;
                        try {
                            iw.c(th, "leg", "uts");
                            if (jrVar != null) {
                                jrVar.close();
                                return -1;
                            }
                            return -1;
                        } catch (Throwable th3) {
                            if (jrVar != null) {
                                try {
                                    jrVar.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                }
                if (jrVar2 != null) {
                    jrVar2.close();
                    return -1;
                }
                return -1;
            } catch (Throwable th5) {
                th = th5;
                jrVar = null;
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
            return -1;
        }
    }

    private static void a(jr jrVar, List<String> list) {
        if (jrVar != null) {
            try {
                for (String str : list) {
                    jrVar.c(str);
                }
                jrVar.close();
            } catch (Throwable th) {
                iw.c(th, "ofm", "dlo");
            }
        }
    }

    public static void a(String str, byte[] bArr, ke keVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        jr jrVar;
        OutputStream outputStream = null;
        try {
            if (a(keVar.a, str)) {
                return;
            }
            File file = new File(keVar.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            jr a = jr.a(file, keVar.b);
            outputStream = null;
            try {
                a.a(keVar.d);
                byte[] b = keVar.e.b(bArr);
                jr.a b2 = a.b(str);
                OutputStream a2 = b2.a();
                a2.write(b);
                b2.b();
                outputStream = a2;
                a.c();
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                jrVar = a;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (jrVar != null) {
                    try {
                        jrVar.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            jrVar = null;
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            iw.c(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] a(jr jrVar, ke keVar, List<String> list) {
        int i;
        try {
            File b = jrVar.b();
            if (b != null && b.exists()) {
                String[] list2 = b.list();
                int length = list2.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    i = i4;
                    if (i2 >= length) {
                        break;
                    }
                    String str = list2[i2];
                    int i5 = i4;
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = kl.a(jrVar, str2);
                        int length2 = i4 + a.length;
                        list.add(str2);
                        i = length2;
                        if (length2 > keVar.f.a()) {
                            break;
                        }
                        keVar.g.b(a);
                        i5 = length2;
                    }
                    i2++;
                    i3 = i5;
                }
                if (i <= 0) {
                    return null;
                }
                return keVar.g.a();
            }
        } catch (Throwable th) {
            iw.c(th, "leg", "gCo");
        }
        return new byte[0];
    }
}

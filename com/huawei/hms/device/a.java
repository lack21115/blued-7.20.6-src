package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.util.j;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/device/a.class */
public class a {
    public static String a(String str, String str2) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        int indexOf = upperCase.indexOf(str2 + "=");
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        return indexOf2 != -1 ? str.substring(indexOf + str2.length() + 1, indexOf2) : str.substring(indexOf + str2.length() + 1);
    }

    public static X509Certificate a(Context context) {
        return a(context, j.f);
    }

    public static X509Certificate a(Context context, String str) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream open;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        keyStore = KeyStore.getInstance(j.e);
                        open = context.getAssets().open("hmsrootcas.bks");
                    } catch (IOException e) {
                        e = e;
                        inputStream = null;
                        StringBuilder sb = new StringBuilder();
                        InputStream inputStream2 = inputStream;
                        sb.append("exception:");
                        InputStream inputStream3 = inputStream;
                        sb.append(e.getMessage());
                        InputStream inputStream4 = inputStream;
                        HMSLog.e("X509CertUtil", sb.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (KeyStoreException e2) {
                        e = e2;
                        inputStream = null;
                        StringBuilder sb2 = new StringBuilder();
                        InputStream inputStream22 = inputStream;
                        sb2.append("exception:");
                        InputStream inputStream32 = inputStream;
                        sb2.append(e.getMessage());
                        InputStream inputStream42 = inputStream;
                        HMSLog.e("X509CertUtil", sb2.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        inputStream = null;
                        StringBuilder sb22 = new StringBuilder();
                        InputStream inputStream222 = inputStream;
                        sb22.append("exception:");
                        InputStream inputStream322 = inputStream;
                        sb22.append(e.getMessage());
                        InputStream inputStream422 = inputStream;
                        HMSLog.e("X509CertUtil", sb22.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (CertificateException e4) {
                        e = e4;
                        inputStream = null;
                        StringBuilder sb222 = new StringBuilder();
                        InputStream inputStream2222 = inputStream;
                        sb222.append("exception:");
                        InputStream inputStream3222 = inputStream;
                        sb222.append(e.getMessage());
                        InputStream inputStream4222 = inputStream;
                        HMSLog.e("X509CertUtil", sb222.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly((InputStream) null);
                        throw th;
                    }
                    try {
                        keyStore.load(open, "".toCharArray());
                        if (!keyStore.containsAlias(str)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Not include alias ");
                            sb3.append(str);
                            HMSLog.e("X509CertUtil", sb3.toString());
                            HMSPackageManager.getInstance(context).setUseOldCertificate(true);
                            IOUtils.closeQuietly(open);
                            return null;
                        }
                        Certificate certificate = keyStore.getCertificate(str);
                        if (!(certificate instanceof X509Certificate)) {
                            IOUtils.closeQuietly(open);
                            return null;
                        }
                        X509Certificate x509Certificate = (X509Certificate) certificate;
                        x509Certificate.checkValidity();
                        IOUtils.closeQuietly(open);
                        return x509Certificate;
                    } catch (IOException e5) {
                        e = e5;
                        inputStream = open;
                        StringBuilder sb2222 = new StringBuilder();
                        InputStream inputStream22222 = inputStream;
                        sb2222.append("exception:");
                        InputStream inputStream32222 = inputStream;
                        sb2222.append(e.getMessage());
                        InputStream inputStream42222 = inputStream;
                        HMSLog.e("X509CertUtil", sb2222.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (KeyStoreException e6) {
                        e = e6;
                        inputStream = open;
                        StringBuilder sb22222 = new StringBuilder();
                        InputStream inputStream222222 = inputStream;
                        sb22222.append("exception:");
                        InputStream inputStream322222 = inputStream;
                        sb22222.append(e.getMessage());
                        InputStream inputStream422222 = inputStream;
                        HMSLog.e("X509CertUtil", sb22222.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (NoSuchAlgorithmException e7) {
                        e = e7;
                        inputStream = open;
                        StringBuilder sb222222 = new StringBuilder();
                        InputStream inputStream2222222 = inputStream;
                        sb222222.append("exception:");
                        InputStream inputStream3222222 = inputStream;
                        sb222222.append(e.getMessage());
                        InputStream inputStream4222222 = inputStream;
                        HMSLog.e("X509CertUtil", sb222222.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    } catch (CertificateException e8) {
                        e = e8;
                        inputStream = open;
                        StringBuilder sb2222222 = new StringBuilder();
                        InputStream inputStream22222222 = inputStream;
                        sb2222222.append("exception:");
                        InputStream inputStream32222222 = inputStream;
                        sb2222222.append(e.getMessage());
                        InputStream inputStream42222222 = inputStream;
                        HMSLog.e("X509CertUtil", sb2222222.toString());
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        HMSLog.e("X509CertUtil", "args are error");
        return null;
    }

    public static X509Certificate a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(Base64.decode(str));
        } catch (IllegalArgumentException e) {
            HMSLog.e("X509CertUtil", "getCert failed : " + e.getMessage());
            return null;
        }
    }

    public static X509Certificate a(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            HMSLog.e("X509CertUtil", "Failed to get cert: " + e.getMessage());
            return null;
        }
    }

    public static boolean a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        return b(x509Certificate, "CN", str);
    }

    public static boolean a(X509Certificate x509Certificate, String str, String str2) {
        try {
            return a(x509Certificate, str.getBytes("UTF-8"), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            HMSLog.e("X509CertUtil", " plainText exception: " + e.getMessage());
            return false;
        }
    }

    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (x509Certificate == null) {
            HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
            return false;
        }
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (X509Certificate x509Certificate2 : list) {
            if (x509Certificate2 == null) {
                return false;
            }
            try {
                x509Certificate2.checkValidity();
                x509Certificate2.verify(publicKey);
                publicKey = x509Certificate2.getPublicKey();
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                HMSLog.e("X509CertUtil", "verify failed " + e.getMessage());
                return false;
            }
        }
        return a(list);
    }

    public static boolean a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            HMSLog.e("X509CertUtil", "failed checkSignature : " + e.getMessage());
            return false;
        }
    }

    public static boolean a(List<X509Certificate> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() - 1) {
                return true;
            }
            if (!a(list.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static List<X509Certificate> b(String str) {
        return b(c(str));
    }

    public static List<X509Certificate> b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(a(str));
        }
        return arrayList;
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        return b(x509Certificate, "OU", str);
    }

    public static boolean b(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
    }

    public static List<String> c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                arrayList.add(jSONArray.getString(i2));
                i = i2 + 1;
            }
        } catch (JSONException e) {
            HMSLog.e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}

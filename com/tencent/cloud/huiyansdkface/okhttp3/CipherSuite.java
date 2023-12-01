package com.tencent.cloud.huiyansdkface.okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CipherSuite.class */
public final class CipherSuite {
    final String bq;

    /* renamed from: a  reason: collision with root package name */
    static final Comparator<String> f22140a = new Comparator<String>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.CipherSuite.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i2 = 4;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    int length = str.length();
                    int length2 = str2.length();
                    if (length != length2) {
                        return length < length2 ? -1 : 1;
                    }
                    return 0;
                }
                char charAt = str.charAt(i3);
                char charAt2 = str2.charAt(i3);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
                i2 = i3 + 1;
            }
        }
    };
    private static final Map<String, CipherSuite> br = new LinkedHashMap();
    public static final CipherSuite b = a("SSL_RSA_WITH_NULL_MD5", 1);

    /* renamed from: c  reason: collision with root package name */
    public static final CipherSuite f22142c = a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final CipherSuite d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final CipherSuite e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final CipherSuite f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final CipherSuite g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final CipherSuite h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final CipherSuite i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final CipherSuite k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final CipherSuite l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final CipherSuite m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final CipherSuite n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final CipherSuite o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final CipherSuite p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final CipherSuite q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final CipherSuite r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final CipherSuite s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final CipherSuite t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final CipherSuite u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final CipherSuite v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final CipherSuite w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final CipherSuite x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final CipherSuite y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final CipherSuite z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final CipherSuite G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final CipherSuite H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final CipherSuite I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final CipherSuite K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final CipherSuite L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final CipherSuite M = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final CipherSuite O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final CipherSuite P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final CipherSuite Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final CipherSuite U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final CipherSuite V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final CipherSuite W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final CipherSuite X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final CipherSuite Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final CipherSuite Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final CipherSuite aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final CipherSuite ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final CipherSuite ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final CipherSuite ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final CipherSuite ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final CipherSuite af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final CipherSuite ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final CipherSuite aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final CipherSuite ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final CipherSuite al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final CipherSuite am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final CipherSuite an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final CipherSuite ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final CipherSuite ap = a("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* renamed from: ar  reason: collision with root package name */
    public static final CipherSuite f22141ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final CipherSuite as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final CipherSuite ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final CipherSuite aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final CipherSuite aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final CipherSuite aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final CipherSuite aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final CipherSuite aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final CipherSuite aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final CipherSuite aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final CipherSuite aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final CipherSuite aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final CipherSuite ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final CipherSuite bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final CipherSuite bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final CipherSuite bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final CipherSuite be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final CipherSuite bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final CipherSuite bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final CipherSuite bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite bj = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final CipherSuite bk = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final CipherSuite bl = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite bm = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite bn = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite bo = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite bp = a("TLS_AES_256_CCM_8_SHA256", 4869);

    private CipherSuite(String str) {
        if (str == null) {
            throw null;
        }
        this.bq = str;
    }

    private static CipherSuite a(String str, int i2) {
        CipherSuite cipherSuite = new CipherSuite(str);
        br.put(str, cipherSuite);
        return cipherSuite;
    }

    private static String a(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        String str2 = str;
        if (str.startsWith("SSL_")) {
            str2 = "TLS_" + str.substring(4);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<CipherSuite> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(forJavaName(strArr[i3]));
            i2 = i3 + 1;
        }
    }

    public static CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            try {
                CipherSuite cipherSuite2 = br.get(str);
                cipherSuite = cipherSuite2;
                if (cipherSuite2 == null) {
                    CipherSuite cipherSuite3 = br.get(a(str));
                    cipherSuite = cipherSuite3;
                    if (cipherSuite3 == null) {
                        cipherSuite = new CipherSuite(str);
                    }
                    br.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipherSuite;
    }

    public String javaName() {
        return this.bq;
    }

    public String toString() {
        return this.bq;
    }
}

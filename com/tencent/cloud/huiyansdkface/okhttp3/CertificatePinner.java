package com.tencent.cloud.huiyansdkface.okhttp3;

import com.blued.das.live.LiveProtos;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CertificatePinner.class */
public final class CertificatePinner {

    /* renamed from: a  reason: collision with root package name */
    public static final CertificatePinner f22134a = new Builder().build();
    private final CertificatePinProvider b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Pin> f22135c;
    private final CertificateChainCleaner d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CertificatePinner$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<Pin> f22136a = new ArrayList();
        private CertificatePinProvider b;

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return this;
                }
                this.f22136a.add(new Pin(str, strArr[i2]));
                i = i2 + 1;
            }
        }

        public CertificatePinner build() {
            CertificatePinProvider certificatePinProvider = this.b;
            return certificatePinProvider != null ? new CertificatePinner(certificatePinProvider, (CertificateChainCleaner) null) : new CertificatePinner(new LinkedHashSet(this.f22136a), (CertificateChainCleaner) null);
        }

        public Builder pinProvider(CertificatePinProvider certificatePinProvider) {
            if (certificatePinProvider != null) {
                this.b = certificatePinProvider;
                return this;
            }
            throw new NullPointerException("pin provider == null");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CertificatePinner$CertificatePinProvider.class */
    public interface CertificatePinProvider {
        Set<String> getPins(String str);

        void onPinVerifyFailed(String str, List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CertificatePinner$Pin.class */
    public static final class Pin {

        /* renamed from: a  reason: collision with root package name */
        final String f22137a;
        final String b;

        /* renamed from: c  reason: collision with root package name */
        final String f22138c;
        final ByteString d;

        /* JADX WARN: Removed duplicated region for block: B:13:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        Pin(java.lang.String r5, java.lang.String r6) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.Pin.<init>(java.lang.String, java.lang.String):void");
        }

        boolean a(String str) {
            if (this.f22137a.startsWith("**.")) {
                return str.endsWith("." + this.b);
            } else if (this.f22137a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.b.length()) {
                    String str2 = this.b;
                    return str.regionMatches(false, indexOf + 1, str2, 0, str2.length());
                }
                return false;
            } else {
                return str.equals(this.b);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return this.f22137a.equals(pin.f22137a) && this.f22138c.equals(pin.f22138c) && this.d.equals(pin.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE + this.f22137a.hashCode()) * 31) + this.f22138c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.f22138c + this.d.base64();
        }
    }

    CertificatePinner(CertificatePinProvider certificatePinProvider, CertificateChainCleaner certificateChainCleaner) {
        this.b = certificatePinProvider;
        this.f22135c = new LinkedHashSet();
        this.d = certificateChainCleaner;
    }

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        this.f22135c = set;
        this.b = null;
        this.d = certificateChainCleaner;
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CertificatePinner a(CertificateChainCleaner certificateChainCleaner) {
        return Util.equal(this.d, certificateChainCleaner) ? this : this.b != null ? new CertificatePinner(this.b, certificateChainCleaner) : new CertificatePinner(this.f22135c, certificateChainCleaner);
    }

    List<Pin> a(String str) {
        HashSet<Pin> hashSet = new HashSet();
        CertificatePinProvider certificatePinProvider = this.b;
        if (certificatePinProvider != null) {
            Set<String> pins = certificatePinProvider.getPins(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str2 : pins) {
                linkedHashSet.add(new Pin(str, str2));
            }
            hashSet.addAll(linkedHashSet);
        }
        hashSet.addAll(this.f22135c);
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : hashSet) {
            if (pin.a(str)) {
                ArrayList arrayList = emptyList;
                if (emptyList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                arrayList.add(pin);
                emptyList = arrayList;
            }
        }
        return emptyList;
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        check(str, list, true);
    }

    public void check(String str, List<Certificate> list, boolean z) throws SSLPeerUnverifiedException {
        List<Pin> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.d;
        List<Certificate> list2 = list;
        if (certificateChainCleaner != null) {
            list2 = list;
            if (z) {
                list2 = certificateChainCleaner.clean(list, str);
            }
        }
        int size = list2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                StringBuilder sb = new StringBuilder();
                sb.append("Certificate pinning failure!");
                sb.append("\n  Peer certificate chain:");
                int size2 = list2.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    X509Certificate x509Certificate = (X509Certificate) list2.get(i4);
                    sb.append("\n    ");
                    sb.append(pin(x509Certificate));
                    sb.append(": ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    i3 = i4 + 1;
                }
                sb.append("\n  Pinned certificates for ");
                sb.append(str);
                sb.append(":");
                ArrayList arrayList = new ArrayList();
                int size3 = a2.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size3) {
                        break;
                    }
                    Pin pin = a2.get(i6);
                    sb.append("\n    ");
                    sb.append(pin);
                    arrayList.add(pin.toString());
                    i5 = i6 + 1;
                }
                CertificatePinProvider certificatePinProvider = this.b;
                if (certificatePinProvider != null) {
                    certificatePinProvider.onPinVerifyFailed(str, arrayList);
                }
                throw new SSLPeerUnverifiedException(sb.toString());
            }
            X509Certificate x509Certificate2 = (X509Certificate) list2.get(i2);
            int size4 = a2.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < size4) {
                    Pin pin2 = a2.get(i8);
                    if (pin2.f22138c.equals("sha256/")) {
                        ByteString byteString3 = byteString;
                        if (byteString == null) {
                            byteString3 = b(x509Certificate2);
                        }
                        byteString = byteString3;
                        if (pin2.d.equals(byteString3)) {
                            return;
                        }
                    } else if (!pin2.f22138c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin2.f22138c);
                    } else {
                        ByteString byteString4 = byteString2;
                        if (byteString2 == null) {
                            byteString4 = a(x509Certificate2);
                        }
                        byteString2 = byteString4;
                        if (pin2.d.equals(byteString4)) {
                            return;
                        }
                    }
                    i7 = i8 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    public void checkPin(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr), false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            return Util.equal(this.d, certificatePinner.d) && this.f22135c.equals(certificatePinner.f22135c);
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.d;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f22135c.hashCode();
    }
}

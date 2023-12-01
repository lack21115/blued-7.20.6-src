package javax.net.ssl;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.net.InetAddress;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/DefaultHostnameVerifier.class */
public final class DefaultHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    private List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) {
        ArrayList emptyList;
        Collection<List<?>> subjectAlternativeNames;
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            emptyList = Collections.emptyList();
        }
        if (subjectAlternativeNames == null) {
            return Collections.emptyList();
        }
        Iterator<List<?>> it = subjectAlternativeNames.iterator();
        while (true) {
            emptyList = arrayList;
            if (!it.hasNext()) {
                break;
            }
            List<?> next = it.next();
            if (next != null && next.size() >= 2 && (num = (Integer) next.get(0)) != null && num.intValue() == i && (str = (String) next.get(1)) != null) {
                arrayList.add(str);
            }
        }
        return emptyList;
    }

    private boolean verifyHostName(String str, X509Certificate x509Certificate) {
        String findMostSpecific;
        String lowerCase = str.toLowerCase(Locale.US);
        boolean z = false;
        for (String str2 : getSubjectAltNames(x509Certificate, 2)) {
            z = true;
            if (verifyHostName(lowerCase, str2)) {
                return true;
            }
        }
        if (z || (findMostSpecific = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific(AdvanceSetting.CLEAR_NOTIFICATION)) == null) {
            return false;
        }
        return verifyHostName(lowerCase, findMostSpecific);
    }

    private boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        for (String str2 : getSubjectAltNames(x509Certificate, 7)) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean verify(String str, X509Certificate x509Certificate) {
        return InetAddress.isNumeric(str) ? verifyIpAddress(str, x509Certificate) : verifyHostName(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r7.equals(r0.substring(2)) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean verifyHostName(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 1
            r13 = r0
            r0 = r7
            if (r0 == 0) goto L19
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L19
            r0 = r8
            if (r0 == 0) goto L19
            r0 = r8
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1f
        L19:
            r0 = 0
            r12 = r0
        L1c:
            r0 = r12
            return r0
        L1f:
            r0 = r8
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r1)
            r8 = r0
            r0 = r8
            java.lang.String r1 = "*"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L36
            r0 = r7
            r1 = r8
            boolean r0 = r0.equals(r1)
            return r0
        L36:
            r0 = r8
            java.lang.String r1 = "*."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L4f
            r0 = r13
            r12 = r0
            r0 = r7
            r1 = r8
            r2 = 2
            java.lang.String r1 = r1.substring(r2)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1c
        L4f:
            r0 = r8
            r1 = 42
            int r0 = r0.indexOf(r1)
            r9 = r0
            r0 = r9
            r1 = r8
            r2 = 46
            int r1 = r1.indexOf(r2)
            if (r0 <= r1) goto L62
            r0 = 0
            return r0
        L62:
            r0 = r7
            r1 = 0
            r2 = r8
            r3 = 0
            r4 = r9
            boolean r0 = r0.regionMatches(r1, r2, r3, r4)
            if (r0 != 0) goto L6f
            r0 = 0
            return r0
        L6f:
            r0 = r8
            int r0 = r0.length()
            r1 = r9
            r2 = 1
            int r1 = r1 + r2
            int r0 = r0 - r1
            r10 = r0
            r0 = r7
            int r0 = r0.length()
            r1 = r10
            int r0 = r0 - r1
            r11 = r0
            r0 = r7
            r1 = 46
            r2 = r9
            int r0 = r0.indexOf(r1, r2)
            r1 = r11
            if (r0 >= r1) goto L99
            r0 = r7
            java.lang.String r1 = ".clients.google.com"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L99
            r0 = 0
            return r0
        L99:
            r0 = r13
            r12 = r0
            r0 = r7
            r1 = r11
            r2 = r8
            r3 = r9
            r4 = 1
            int r3 = r3 + r4
            r4 = r10
            boolean r0 = r0.regionMatches(r1, r2, r3, r4)
            if (r0 != 0) goto L1c
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.net.ssl.DefaultHostnameVerifier.verifyHostName(java.lang.String, java.lang.String):boolean");
    }
}

package com.bytedance.sdk.openadsdk.api.plugin.mb;

import com.android.internal.telephony.PhoneConstants;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/mb/mb.class */
public final class mb implements HostnameVerifier {
    public static final mb mb = new mb();
    private static final Pattern ox = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private mb() {
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        String mb2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> mb3 = mb(x509Certificate, 2);
        int size = mb3.size();
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= size) {
                if (z2 || (mb2 = new ox(x509Certificate.getSubjectX500Principal()).mb(AdvanceSetting.CLEAR_NOTIFICATION)) == null) {
                    return false;
                }
                return mb(lowerCase, mb2);
            } else if (mb(lowerCase, mb3.get(i))) {
                return true;
            } else {
                i++;
                z = true;
            }
        }
    }

    private static List<String> mb(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    private static boolean mb(String str) {
        return ox.matcher(str).matches();
    }

    private boolean mb(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        String str3 = str;
        if (!str.endsWith(".")) {
            str3 = str + '.';
        }
        String str4 = str2;
        if (!str2.endsWith(".")) {
            str4 = str2 + '.';
        }
        String lowerCase = str4.toLowerCase(Locale.US);
        if (lowerCase.contains(PhoneConstants.APN_TYPE_ALL)) {
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str3.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (str3.endsWith(substring)) {
                int length = str3.length() - substring.length();
                return length <= 0 || str3.lastIndexOf(46, length - 1) == -1;
            }
            return false;
        }
        return str3.equals(lowerCase);
    }

    private boolean mb(String str, X509Certificate x509Certificate) {
        return mb(str) ? ox(str, x509Certificate) : b(str, x509Certificate);
    }

    private boolean ox(String str, X509Certificate x509Certificate) {
        List<String> mb2 = mb(x509Certificate, 7);
        int size = mb2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (str.equalsIgnoreCase(mb2.get(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mb(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }
}

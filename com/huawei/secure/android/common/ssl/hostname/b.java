package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/hostname/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f23123a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final String[] b;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] a2 = a(x509Certificate);
        String[] b2 = b(x509Certificate);
        g.a("", "cn is : " + Arrays.toString(a2));
        g.a("", "san is : " + Arrays.toString(b2));
        a(str, a2, b2, z);
    }

    public static final void a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        boolean z2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && strArr[0] != null) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = strArr2[i2];
                if (str2 != null) {
                    linkedList.add(str2);
                }
                i = i2 + 1;
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuffer stringBuffer = new StringBuffer();
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        Iterator<E> it = linkedList.iterator();
        boolean z3 = false;
        do {
            z2 = z3;
            if (!it.hasNext()) {
                break;
            }
            String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
            stringBuffer.append(" <");
            stringBuffer.append(lowerCase2);
            stringBuffer.append('>');
            if (it.hasNext()) {
                stringBuffer.append(" OR");
            }
            if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                z2 = lowerCase.endsWith(lowerCase2.substring(1));
                if (z2 && z) {
                    z2 = b(lowerCase) == b(lowerCase2);
                }
            } else {
                z2 = lowerCase.equals(lowerCase2);
            }
            z3 = z2;
        } while (!z2);
        if (z2) {
            return;
        }
        throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
    }

    public static boolean a(String str) {
        int length = str.length();
        boolean z = true;
        if (length >= 7) {
            z = true;
            if (length <= 9) {
                int i = length - 3;
                z = true;
                if (str.charAt(i) == '.') {
                    if (Arrays.binarySearch(b, str.substring(2, i)) < 0) {
                        return true;
                    }
                    z = false;
                }
            }
        }
        return z;
    }

    public static String[] a(X509Certificate x509Certificate) {
        List<String> b2 = new a(x509Certificate.getSubjectX500Principal()).b(AdvanceSetting.CLEAR_NOTIFICATION);
        if (b2.isEmpty()) {
            return null;
        }
        String[] strArr = new String[b2.size()];
        b2.toArray(strArr);
        return strArr;
    }

    public static int b(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= str.length()) {
                return i3;
            }
            int i4 = i3;
            if (str.charAt(i) == '.') {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    public static String[] b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            g.a("", "Error parsing certificate.", e);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean c(String str) {
        return f23123a.matcher(str).matches();
    }
}

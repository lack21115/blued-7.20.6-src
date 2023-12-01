package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/CertificatePinner.class */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final Map<String, Set<ByteString>> hostnameToPins;

    /* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/CertificatePinner$Builder.class */
    public static final class Builder {
        private final Map<String, Set<ByteString>> hostnameToPins = new LinkedHashMap();

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new IllegalArgumentException("hostname == null");
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Set<ByteString> put = this.hostnameToPins.put(str, Collections.unmodifiableSet(linkedHashSet));
            if (put != null) {
                linkedHashSet.addAll(put);
            }
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return this;
                }
                String str2 = strArr[i2];
                if (!str2.startsWith("sha1/")) {
                    throw new IllegalArgumentException("pins must start with 'sha1/': " + str2);
                }
                ByteString decodeBase64 = ByteString.decodeBase64(str2.substring(5));
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException("pins must be base64: " + str2);
                }
                linkedHashSet.add(decodeBase64);
                i = i2 + 1;
            }
        }

        public CertificatePinner build() {
            return new CertificatePinner(this);
        }
    }

    private CertificatePinner(Builder builder) {
        this.hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + sha1((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Set<ByteString> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                StringBuilder sb = new StringBuilder();
                sb.append("Certificate pinning failure!");
                sb.append("\n  Peer certificate chain:");
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size2) {
                        break;
                    }
                    X509Certificate x509Certificate = (X509Certificate) list.get(i4);
                    sb.append("\n    ");
                    sb.append(pin(x509Certificate));
                    sb.append(": ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    i3 = i4 + 1;
                }
                sb.append("\n  Pinned certificates for ");
                sb.append(str);
                sb.append(":");
                for (ByteString byteString : findMatchingPins) {
                    sb.append("\n    sha1/");
                    sb.append(byteString.base64());
                }
                throw new SSLPeerUnverifiedException(sb.toString());
            } else if (findMatchingPins.contains(sha1((X509Certificate) list.get(i2)))) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    Set<ByteString> findMatchingPins(String str) {
        int indexOf;
        Set<ByteString> set;
        Set<ByteString> set2 = this.hostnameToPins.get(str);
        if (str.indexOf(46) != str.lastIndexOf(46)) {
            set = this.hostnameToPins.get("*." + str.substring(indexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 == null || set == null) {
            return set2 != null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set2);
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }
}

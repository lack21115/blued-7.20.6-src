package com.android.org.conscrypt;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import libcore.io.IoUtils;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/TrustedCertificateStore.class */
public final class TrustedCertificateStore {
    private static final CertificateFactory CERT_FACTORY;
    private static final String PREFIX_SYSTEM = "system:";
    private static final String PREFIX_USER = "user:";
    private static File defaultCaCertsAddedDir;
    private static File defaultCaCertsDeletedDir;
    private static File defaultCaCertsSystemDir;
    private final File addedDir;
    private final File deletedDir;
    private final File systemDir;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/TrustedCertificateStore$CertSelector.class */
    public interface CertSelector {
        boolean match(X509Certificate x509Certificate);
    }

    static {
        String str = System.getenv("ANDROID_ROOT");
        String str2 = System.getenv("ANDROID_DATA");
        defaultCaCertsSystemDir = new File(str + "/etc/security/cacerts");
        setDefaultUserDirectory(new File(str2 + "/misc/keychain"));
        try {
            CERT_FACTORY = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            throw new AssertionError(e);
        }
    }

    public TrustedCertificateStore() {
        this(defaultCaCertsSystemDir, defaultCaCertsAddedDir, defaultCaCertsDeletedDir);
    }

    public TrustedCertificateStore(File file, File file2, File file3) {
        this.systemDir = file;
        this.addedDir = file2;
        this.deletedDir = file3;
    }

    private void addAliases(Set<String> set, String str, File file) {
        String[] list = file.list();
        if (list == null) {
            return;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = str + list[i2];
            if (containsAlias(str2)) {
                set.add(str2);
            }
            i = i2 + 1;
        }
    }

    private boolean containsAlias(String str, boolean z) {
        return getCertificate(str, z) != null;
    }

    private static OpenSSLX509Certificate convertToOpenSSLIfNeeded(X509Certificate x509Certificate) throws CertificateException {
        if (x509Certificate == null) {
            return null;
        }
        if (x509Certificate instanceof OpenSSLX509Certificate) {
            return (OpenSSLX509Certificate) x509Certificate;
        }
        try {
            return OpenSSLX509Certificate.fromX509Der(x509Certificate.getEncoded());
        } catch (Exception e) {
            throw new CertificateException(e);
        }
    }

    private File file(File file, String str, int i) {
        return new File(file, str + '.' + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (isTombstone(r7) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File fileForAlias(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            if (r0 != 0) goto Le
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            java.lang.String r2 = "alias == null"
            r1.<init>(r2)
            throw r0
        Le:
            r0 = r7
            boolean r0 = isSystem(r0)
            if (r0 == 0) goto L3f
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            java.io.File r2 = r2.systemDir
            r3 = r7
            java.lang.String r4 = "system:"
            int r4 = r4.length()
            java.lang.String r3 = r3.substring(r4)
            r1.<init>(r2, r3)
            r7 = r0
        L2a:
            r0 = r7
            boolean r0 = r0.exists()
            if (r0 == 0) goto L3b
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = r7
            boolean r0 = r0.isTombstone(r1)
            if (r0 == 0) goto L3d
        L3b:
            r0 = 0
            r8 = r0
        L3d:
            r0 = r8
            return r0
        L3f:
            r0 = r7
            boolean r0 = isUser(r0)
            if (r0 == 0) goto L5e
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            java.io.File r2 = r2.addedDir
            r3 = r7
            java.lang.String r4 = "user:"
            int r4 = r4.length()
            java.lang.String r3 = r3.substring(r4)
            r1.<init>(r2, r3)
            r7 = r0
            goto L2a
        L5e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.TrustedCertificateStore.fileForAlias(java.lang.String):java.io.File");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.security.cert.X509Certificate, T] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.android.org.conscrypt.TrustedCertificateStore$CertSelector] */
    private <T> T findCert(File file, X500Principal x500Principal, CertSelector certSelector, Class<T> cls) {
        File file2;
        ?? r0;
        String hash = hash(x500Principal);
        int i = 0;
        while (true) {
            int i2 = i;
            File file3 = file(file, hash, i2);
            if (file3.isFile()) {
                if (isTombstone(file3) || (r0 = (T) readCertificate(file3)) == 0 || !certSelector.match(r0)) {
                    i = i2 + 1;
                } else if (cls == X509Certificate.class) {
                    return r0;
                } else {
                    if (cls == Boolean.class) {
                        return (T) Boolean.TRUE;
                    }
                    file2 = file3;
                    if (cls != File.class) {
                        throw new AssertionError();
                    }
                }
            } else if (cls == Boolean.class) {
                file2 = Boolean.FALSE;
            } else {
                file2 = file3;
                if (cls != File.class) {
                    return null;
                }
            }
        }
        return (T) file2;
    }

    private File getCertificateFile(File file, final X509Certificate x509Certificate) {
        return (File) findCert(file, x509Certificate.getSubjectX500Principal(), new CertSelector() { // from class: com.android.org.conscrypt.TrustedCertificateStore.1
            @Override // com.android.org.conscrypt.TrustedCertificateStore.CertSelector
            public boolean match(X509Certificate x509Certificate2) {
                return x509Certificate2.equals(x509Certificate);
            }
        }, File.class);
    }

    private String hash(X500Principal x500Principal) {
        return IntegralToString.intToHexString(NativeCrypto.X509_NAME_hash_old(x500Principal), false, 8);
    }

    private boolean isDeletedSystemCertificate(X509Certificate x509Certificate) {
        return getCertificateFile(this.deletedDir, x509Certificate).exists();
    }

    private static boolean isSelfIssuedCertificate(OpenSSLX509Certificate openSSLX509Certificate) {
        long context = openSSLX509Certificate.getContext();
        return NativeCrypto.X509_check_issued(context, context) == 0;
    }

    public static final boolean isSystem(String str) {
        return str.startsWith(PREFIX_SYSTEM);
    }

    private boolean isTombstone(File file) {
        return file.length() == 0;
    }

    public static final boolean isUser(String str) {
        return str.startsWith(PREFIX_USER);
    }

    private X509Certificate readCertificate(File file) {
        BufferedInputStream bufferedInputStream;
        if (!file.isFile()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                X509Certificate x509Certificate = (X509Certificate) CERT_FACTORY.generateCertificate(bufferedInputStream);
                IoUtils.closeQuietly(bufferedInputStream);
                return x509Certificate;
            } catch (IOException e) {
                IoUtils.closeQuietly(bufferedInputStream);
                return null;
            } catch (CertificateException e2) {
                IoUtils.closeQuietly(bufferedInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (IOException e3) {
            bufferedInputStream = null;
        } catch (CertificateException e4) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    private void removeUnnecessaryTombstones(String str) throws IOException {
        if (!isUser(str)) {
            throw new AssertionError(str);
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            throw new AssertionError(str);
        }
        String substring = str.substring(PREFIX_USER.length(), lastIndexOf);
        int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
        if (file(this.addedDir, substring, parseInt + 1).exists()) {
            return;
        }
        for (int i = parseInt; i >= 0; i--) {
            File file = file(this.addedDir, substring, i);
            if (!isTombstone(file)) {
                return;
            }
            if (!file.delete()) {
                throw new IOException("Could not remove " + file);
            }
        }
    }

    public static void setDefaultUserDirectory(File file) {
        defaultCaCertsAddedDir = new File(file, "cacerts-added");
        defaultCaCertsDeletedDir = new File(file, "cacerts-removed");
    }

    private void writeCertificate(File file, X509Certificate x509Certificate) throws IOException, CertificateException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File parentFile = file.getParentFile();
        parentFile.mkdirs();
        parentFile.setReadable(true, false);
        parentFile.setExecutable(true, false);
        try {
            fileOutputStream2 = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream2.write(x509Certificate.getEncoded());
            IoUtils.closeQuietly(fileOutputStream2);
            file.setReadable(true, false);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            IoUtils.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public Set<String> aliases() {
        HashSet hashSet = new HashSet();
        addAliases(hashSet, PREFIX_USER, this.addedDir);
        addAliases(hashSet, PREFIX_SYSTEM, this.systemDir);
        return hashSet;
    }

    public Set<String> allSystemAliases() {
        HashSet hashSet = new HashSet();
        String[] list = this.systemDir.list();
        if (list != null) {
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = PREFIX_SYSTEM + list[i2];
                if (containsAlias(str, true)) {
                    hashSet.add(str);
                }
                i = i2 + 1;
            }
        }
        return hashSet;
    }

    public boolean containsAlias(String str) {
        return containsAlias(str, false);
    }

    public void deleteCertificateEntry(String str) throws IOException, CertificateException {
        File fileForAlias;
        if (str == null || (fileForAlias = fileForAlias(str)) == null) {
            return;
        }
        if (!isSystem(str)) {
            if (isUser(str)) {
                new FileOutputStream(fileForAlias).close();
                removeUnnecessaryTombstones(str);
                return;
            }
            return;
        }
        X509Certificate readCertificate = readCertificate(fileForAlias);
        if (readCertificate != null) {
            File certificateFile = getCertificateFile(this.deletedDir, readCertificate);
            if (certificateFile.exists()) {
                return;
            }
            writeCertificate(certificateFile, readCertificate);
        }
    }

    public X509Certificate findIssuer(final X509Certificate x509Certificate) {
        CertSelector certSelector = new CertSelector() { // from class: com.android.org.conscrypt.TrustedCertificateStore.3
            @Override // com.android.org.conscrypt.TrustedCertificateStore.CertSelector
            public boolean match(X509Certificate x509Certificate2) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        };
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        X509Certificate x509Certificate2 = (X509Certificate) findCert(this.addedDir, issuerX500Principal, certSelector, X509Certificate.class);
        if (x509Certificate2 != null) {
            return x509Certificate2;
        }
        X509Certificate x509Certificate3 = (X509Certificate) findCert(this.systemDir, issuerX500Principal, certSelector, X509Certificate.class);
        if (x509Certificate3 == null || isDeletedSystemCertificate(x509Certificate3)) {
            return null;
        }
        return x509Certificate3;
    }

    public Certificate getCertificate(String str) {
        return getCertificate(str, false);
    }

    public Certificate getCertificate(String str, boolean z) {
        X509Certificate x509Certificate;
        File fileForAlias = fileForAlias(str);
        if (fileForAlias == null || (isUser(str) && isTombstone(fileForAlias))) {
            x509Certificate = null;
        } else {
            X509Certificate readCertificate = readCertificate(fileForAlias);
            if (readCertificate == null) {
                return null;
            }
            x509Certificate = readCertificate;
            if (isSystem(str)) {
                x509Certificate = readCertificate;
                if (!z) {
                    x509Certificate = readCertificate;
                    if (isDeletedSystemCertificate(readCertificate)) {
                        return null;
                    }
                }
            }
        }
        return x509Certificate;
    }

    public String getCertificateAlias(Certificate certificate) {
        return getCertificateAlias(certificate, false);
    }

    public String getCertificateAlias(Certificate certificate, boolean z) {
        if (certificate == null || !(certificate instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        File certificateFile = getCertificateFile(this.addedDir, x509Certificate);
        if (certificateFile.exists()) {
            return PREFIX_USER + certificateFile.getName();
        }
        if (z || !isDeletedSystemCertificate(x509Certificate)) {
            File certificateFile2 = getCertificateFile(this.systemDir, x509Certificate);
            if (certificateFile2.exists()) {
                return PREFIX_SYSTEM + certificateFile2.getName();
            }
            return null;
        }
        return null;
    }

    public List<X509Certificate> getCertificateChain(X509Certificate x509Certificate) throws CertificateException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        OpenSSLX509Certificate convertToOpenSSLIfNeeded = convertToOpenSSLIfNeeded(x509Certificate);
        linkedHashSet.add(convertToOpenSSLIfNeeded);
        while (!isSelfIssuedCertificate(convertToOpenSSLIfNeeded)) {
            convertToOpenSSLIfNeeded = convertToOpenSSLIfNeeded(findIssuer(convertToOpenSSLIfNeeded));
            if (convertToOpenSSLIfNeeded == null || linkedHashSet.contains(convertToOpenSSLIfNeeded)) {
                break;
            }
            linkedHashSet.add(convertToOpenSSLIfNeeded);
        }
        return new ArrayList(linkedHashSet);
    }

    public Date getCreationDate(String str) {
        File fileForAlias;
        if (containsAlias(str) && (fileForAlias = fileForAlias(str)) != null) {
            long lastModified = fileForAlias.lastModified();
            if (lastModified != 0) {
                return new Date(lastModified);
            }
            return null;
        }
        return null;
    }

    public X509Certificate getTrustAnchor(final X509Certificate x509Certificate) {
        CertSelector certSelector = new CertSelector() { // from class: com.android.org.conscrypt.TrustedCertificateStore.2
            @Override // com.android.org.conscrypt.TrustedCertificateStore.CertSelector
            public boolean match(X509Certificate x509Certificate2) {
                return x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
            }
        };
        X509Certificate x509Certificate2 = (X509Certificate) findCert(this.addedDir, x509Certificate.getSubjectX500Principal(), certSelector, X509Certificate.class);
        if (x509Certificate2 != null) {
            return x509Certificate2;
        }
        X509Certificate x509Certificate3 = (X509Certificate) findCert(this.systemDir, x509Certificate.getSubjectX500Principal(), certSelector, X509Certificate.class);
        if (x509Certificate3 == null || isDeletedSystemCertificate(x509Certificate3)) {
            return null;
        }
        return x509Certificate3;
    }

    public void installCertificate(X509Certificate x509Certificate) throws IOException, CertificateException {
        if (x509Certificate == null) {
            throw new NullPointerException("cert == null");
        }
        if (getCertificateFile(this.systemDir, x509Certificate).exists()) {
            File certificateFile = getCertificateFile(this.deletedDir, x509Certificate);
            if (certificateFile.exists() && !certificateFile.delete()) {
                throw new IOException("Could not remove " + certificateFile);
            }
            return;
        }
        File certificateFile2 = getCertificateFile(this.addedDir, x509Certificate);
        if (certificateFile2.exists()) {
            return;
        }
        writeCertificate(certificateFile2, x509Certificate);
    }

    public boolean isUserAddedCertificate(X509Certificate x509Certificate) {
        return getCertificateFile(this.addedDir, x509Certificate).exists();
    }

    public Set<String> userAliases() {
        HashSet hashSet = new HashSet();
        addAliases(hashSet, PREFIX_USER, this.addedDir);
        return hashSet;
    }
}

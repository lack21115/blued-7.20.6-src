package com.android.org.conscrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;
import libcore.util.BasicLruCache;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/CertPinManager.class */
public class CertPinManager {
    private static final boolean DEBUG = false;
    private final TrustedCertificateStore certStore;
    private final Map<String, PinListEntry> entries;
    private final BasicLruCache<String, String> hostnameCache;
    private boolean initialized;
    private long lastModified;
    private final File pinFile;

    public CertPinManager(TrustedCertificateStore trustedCertificateStore) throws PinManagerException {
        this.entries = new HashMap();
        this.hostnameCache = new BasicLruCache<>(10);
        this.initialized = false;
        this.pinFile = new File("/data/misc/keychain/pins");
        this.certStore = trustedCertificateStore;
    }

    public CertPinManager(String str, TrustedCertificateStore trustedCertificateStore) throws PinManagerException {
        this.entries = new HashMap();
        this.hostnameCache = new BasicLruCache<>(10);
        this.initialized = false;
        if (str == null) {
            throw new NullPointerException("path == null");
        }
        this.pinFile = new File(str);
        this.certStore = trustedCertificateStore;
    }

    private boolean ensureInitialized() throws PinManagerException {
        boolean z = true;
        synchronized (this) {
            if (!this.initialized || !isCacheValid()) {
                String readPinFile = readPinFile();
                if (readPinFile != null) {
                    String[] pinFileEntries = getPinFileEntries(readPinFile);
                    int length = pinFileEntries.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String str = pinFileEntries[i2];
                        try {
                            PinListEntry pinListEntry = new PinListEntry(str, this.certStore);
                            this.entries.put(pinListEntry.getCommonName(), pinListEntry);
                        } catch (PinEntryException e) {
                            log("Pinlist contains a malformed pin: " + str, e);
                        }
                        i = i2 + 1;
                    }
                    this.hostnameCache.evictAll();
                    this.lastModified = this.pinFile.lastModified();
                    this.initialized = true;
                }
                z = this.initialized;
            }
        }
        return z;
    }

    private String getMatchingCN(String str) {
        String str2 = "";
        for (String str3 : this.entries.keySet()) {
            if (str3.length() >= str2.length() && isHostnameMatchedBy(str, str3)) {
                str2 = str3;
            }
        }
        return str2;
    }

    private static String[] getPinFileEntries(String str) {
        return str.split("\n");
    }

    private boolean isCacheValid() {
        return this.pinFile.lastModified() == this.lastModified;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        if (r7.regionMatches(0, r0, 2, r0.length() - 2) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isHostnameMatchedBy(java.lang.String r7, java.lang.String r8) {
        /*
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
            if (r0 == 0) goto L53
            r0 = r13
            r12 = r0
            r0 = r7
            r1 = 0
            r2 = r8
            r3 = 2
            r4 = r8
            int r4 = r4.length()
            r5 = 2
            int r4 = r4 - r5
            boolean r0 = r0.regionMatches(r1, r2, r3, r4)
            if (r0 != 0) goto L1c
        L53:
            r0 = r8
            r1 = 42
            int r0 = r0.indexOf(r1)
            r9 = r0
            r0 = r9
            r1 = r8
            r2 = 46
            int r1 = r1.indexOf(r2)
            if (r0 <= r1) goto L66
            r0 = 0
            return r0
        L66:
            r0 = r7
            r1 = 0
            r2 = r8
            r3 = 0
            r4 = r9
            boolean r0 = r0.regionMatches(r1, r2, r3, r4)
            if (r0 != 0) goto L73
            r0 = 0
            return r0
        L73:
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
            if (r0 >= r1) goto L92
            r0 = 0
            return r0
        L92:
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
        throw new UnsupportedOperationException("Method not decompiled: com.android.org.conscrypt.CertPinManager.isHostnameMatchedBy(java.lang.String, java.lang.String):boolean");
    }

    private static void log(String str, Exception exc) {
    }

    private PinListEntry lookup(String str) throws PinManagerException {
        PinListEntry pinListEntry = null;
        synchronized (this) {
            if (ensureInitialized()) {
                String str2 = this.hostnameCache.get(str);
                if (str2 != null) {
                    pinListEntry = this.entries.get(str2);
                } else {
                    String matchingCN = getMatchingCN(str);
                    if (matchingCN != null) {
                        this.hostnameCache.put(str, matchingCN);
                        pinListEntry = this.entries.get(matchingCN);
                    }
                }
            }
        }
        return pinListEntry;
    }

    private String readPinFile() throws PinManagerException {
        try {
            return IoUtils.readFileAsString(this.pinFile.getPath());
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            throw new PinManagerException("Unexpected error reading pin list; failing.", e2);
        }
    }

    public boolean isChainValid(String str, List<X509Certificate> list) throws PinManagerException {
        PinListEntry lookup = lookup(str);
        if (lookup == null) {
            return true;
        }
        return lookup.isChainValid(list);
    }
}

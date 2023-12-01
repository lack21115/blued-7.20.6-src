package java.util.jar;

import com.youzan.androidsdk.tool.AppSigning;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import libcore.io.Base64;
import org.apache.harmony.security.utils.JarUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarVerifier.class */
public class JarVerifier {
    private static final String[] DIGEST_ALGORITHMS = {"SHA-512", "SHA-384", "SHA-256", AppSigning.SHA1};
    private final String jarName;
    private final int mainAttributesEnd;
    private final Manifest manifest;
    private final HashMap<String, byte[]> metaEntries;
    private final Hashtable<String, HashMap<String, Attributes>> signatures = new Hashtable<>(5);
    private final Hashtable<String, Certificate[]> certificates = new Hashtable<>(5);
    private final Hashtable<String, Certificate[][]> verifiedEntries = new Hashtable<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarVerifier$VerifierEntry.class */
    public static class VerifierEntry extends OutputStream {
        private final Certificate[][] certChains;
        private final MessageDigest digest;
        private final byte[] hash;
        private final String name;
        private final Hashtable<String, Certificate[][]> verifiedEntries;

        VerifierEntry(String str, MessageDigest messageDigest, byte[] bArr, Certificate[][] certificateArr, Hashtable<String, Certificate[][]> hashtable) {
            this.name = str;
            this.digest = messageDigest;
            this.hash = bArr;
            this.certChains = certificateArr;
            this.verifiedEntries = hashtable;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void verify() {
            if (!MessageDigest.isEqual(this.digest.digest(), Base64.decode(this.hash))) {
                throw JarVerifier.invalidDigest(JarFile.MANIFEST_NAME, this.name, this.name);
            }
            this.verifiedEntries.put(this.name, this.certChains);
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.digest.update((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.digest.update(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JarVerifier(String str, Manifest manifest, HashMap<String, byte[]> hashMap) {
        this.jarName = str;
        this.manifest = manifest;
        this.metaEntries = hashMap;
        this.mainAttributesEnd = manifest.getMainAttributesEnd();
    }

    private static SecurityException failedVerification(String str, String str2) {
        throw new SecurityException(str + " failed verification of " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecurityException invalidDigest(String str, String str2, String str3) {
        throw new SecurityException(str + " has invalid digest for " + str2 + " in " + str3);
    }

    private boolean verify(Attributes attributes, String str, byte[] bArr, int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            z3 = z2;
            if (i4 >= DIGEST_ALGORITHMS.length) {
                break;
            }
            String str2 = DIGEST_ALGORITHMS[i4];
            String value = attributes.getValue(str2 + str);
            if (value != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str2);
                    if (z && bArr[i2 - 1] == 10 && bArr[i2 - 2] == 10) {
                        messageDigest.update(bArr, i, (i2 - 1) - i);
                    } else {
                        messageDigest.update(bArr, i, i2 - i);
                    }
                    z3 = MessageDigest.isEqual(messageDigest.digest(), Base64.decode(value.getBytes(StandardCharsets.ISO_8859_1)));
                } catch (NoSuchAlgorithmException e) {
                }
            }
            i3 = i4 + 1;
        }
        return z3;
    }

    private void verifyCertificate(String str) {
        byte[] bArr;
        String str2 = str.substring(0, str.lastIndexOf(46)) + ".SF";
        byte[] bArr2 = this.metaEntries.get(str2);
        if (bArr2 == null || (bArr = this.metaEntries.get(JarFile.MANIFEST_NAME)) == null) {
            return;
        }
        try {
            Certificate[] verifySignature = JarUtils.verifySignature(new ByteArrayInputStream(bArr2), new ByteArrayInputStream(this.metaEntries.get(str)));
            if (verifySignature != null) {
                this.certificates.put(str2, verifySignature);
            }
            Attributes attributes = new Attributes();
            HashMap<String, Attributes> hashMap = new HashMap<>();
            try {
                new ManifestReader(bArr2, attributes).readEntries(hashMap, null);
                if (attributes.get(Attributes.Name.SIGNATURE_VERSION) != null) {
                    String value = attributes.getValue("Created-By");
                    boolean z = value != null ? value.indexOf("signtool") != -1 : false;
                    if (this.mainAttributesEnd > 0 && !z && !verify(attributes, "-Digest-Manifest-Main-Attributes", bArr, 0, this.mainAttributesEnd, false, true)) {
                        throw failedVerification(this.jarName, str2);
                    }
                    if (!verify(attributes, z ? "-Digest" : "-Digest-Manifest", bArr, 0, bArr.length, false, false)) {
                        for (Map.Entry<String, Attributes> entry : hashMap.entrySet()) {
                            Manifest.Chunk chunk = this.manifest.getChunk(entry.getKey());
                            if (chunk == null) {
                                return;
                            }
                            if (!verify(entry.getValue(), "-Digest", bArr, chunk.start, chunk.end, z, false)) {
                                throw invalidDigest(str2, entry.getKey(), this.jarName);
                            }
                        }
                    }
                    this.metaEntries.put(str2, null);
                    this.signatures.put(str2, hashMap);
                }
            } catch (IOException e) {
            }
        } catch (IOException e2) {
        } catch (GeneralSecurityException e3) {
            throw failedVerification(this.jarName, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMetaEntry(String str, byte[] bArr) {
        this.metaEntries.put(str.toUpperCase(Locale.US), bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Certificate[][] getCertificateChains(String str) {
        return this.verifiedEntries.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifierEntry initEntry(String str) {
        Attributes attributes;
        if (this.manifest == null || this.signatures.isEmpty() || (attributes = this.manifest.getAttributes(str)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, HashMap<String, Attributes>> entry : this.signatures.entrySet()) {
            if (entry.getValue().get(str) != null) {
                Certificate[] certificateArr = this.certificates.get(entry.getKey());
                if (certificateArr != null) {
                    arrayList.add(certificateArr);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Certificate[][] certificateArr2 = (Certificate[][]) arrayList.toArray(new Certificate[arrayList.size()]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= DIGEST_ALGORITHMS.length) {
                return null;
            }
            String str2 = DIGEST_ALGORITHMS[i2];
            String value = attributes.getValue(str2 + "-Digest");
            if (value != null) {
                try {
                    return new VerifierEntry(str, MessageDigest.getInstance(str2), value.getBytes(StandardCharsets.ISO_8859_1), certificateArr2, this.verifiedEntries);
                } catch (NoSuchAlgorithmException e) {
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSignedJar() {
        return this.certificates.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean readCertificates() {
        boolean z;
        synchronized (this) {
            if (this.metaEntries.isEmpty()) {
                z = false;
            } else {
                Iterator<String> it = this.metaEntries.keySet().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.endsWith(".DSA") || next.endsWith(".RSA") || next.endsWith(".EC")) {
                        verifyCertificate(next);
                        it.remove();
                    }
                }
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMetaEntries() {
        this.metaEntries.clear();
    }
}

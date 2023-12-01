package java.security.cert;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;
import org.apache.harmony.security.x509.GeneralName;
import org.apache.harmony.security.x509.NameConstraints;
import org.apache.harmony.security.x509.SubjectPublicKeyInfo;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/X509CertSelector.class */
public class X509CertSelector implements CertSelector {
    private byte[] authorityKeyIdentifier;
    private X509Certificate certificateEquals;
    private Date certificateValid;
    private Set<String> extendedKeyUsage;
    private X500Principal issuer;
    private byte[] issuerBytes;
    private String issuerName;
    private boolean[] keyUsage;
    private NameConstraints nameConstraints;
    private ArrayList<GeneralName> pathToNames;
    private Set<String> policies;
    private Date privateKeyValid;
    private BigInteger serialNumber;
    private X500Principal subject;
    private List<GeneralName>[] subjectAltNames;
    private byte[] subjectKeyIdentifier;
    private byte[] subjectPublicKey;
    private String subjectPublicKeyAlgID;
    private PublicKey subjectPublicKeyImpl;
    private boolean matchAllNames = true;
    private int pathLen = -1;

    private void checkOID(String str) throws IOException {
        int indexOf = str.indexOf(46, 0);
        try {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            int i = indexOf + 1;
            if (parseInt < 0 || parseInt > 2) {
                throw new IOException("Bad OID: " + str);
            }
            int parseInt2 = Integer.parseInt(str.substring(i, str.indexOf(46, i)));
            if (parseInt2 < 0 || parseInt2 > 39) {
                throw new IOException("Bad OID: " + str);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Bad OID: " + str);
        } catch (NumberFormatException e2) {
            throw new IOException("Bad OID: " + str);
        }
    }

    private byte[] getExtensionValue(X509Certificate x509Certificate, String str) {
        try {
            byte[] extensionValue = x509Certificate.getExtensionValue(str);
            if (extensionValue == null) {
                return null;
            }
            return (byte[]) ASN1OctetString.getInstance().decode(extensionValue);
        } catch (IOException e) {
            return null;
        }
    }

    public void addPathToName(int i, String str) throws IOException {
        GeneralName generalName = new GeneralName(i, str);
        if (this.pathToNames == null) {
            this.pathToNames = new ArrayList<>();
        }
        this.pathToNames.add(generalName);
    }

    public void addPathToName(int i, byte[] bArr) throws IOException {
        GeneralName generalName = new GeneralName(i, bArr);
        if (this.pathToNames == null) {
            this.pathToNames = new ArrayList<>();
        }
        this.pathToNames.add(generalName);
    }

    public void addSubjectAlternativeName(int i, String str) throws IOException {
        GeneralName generalName = new GeneralName(i, str);
        if (this.subjectAltNames == null) {
            this.subjectAltNames = new ArrayList[9];
        }
        if (this.subjectAltNames[i] == null) {
            this.subjectAltNames[i] = new ArrayList();
        }
        this.subjectAltNames[i].add(generalName);
    }

    public void addSubjectAlternativeName(int i, byte[] bArr) throws IOException {
        GeneralName generalName = new GeneralName(i, bArr);
        if (this.subjectAltNames == null) {
            this.subjectAltNames = new ArrayList[9];
        }
        if (this.subjectAltNames[i] == null) {
            this.subjectAltNames[i] = new ArrayList();
        }
        this.subjectAltNames[i].add(generalName);
    }

    @Override // java.security.cert.CertSelector
    public Object clone() {
        try {
            X509CertSelector x509CertSelector = (X509CertSelector) super.clone();
            if (this.subjectKeyIdentifier != null) {
                x509CertSelector.subjectKeyIdentifier = new byte[this.subjectKeyIdentifier.length];
                System.arraycopy(this.subjectKeyIdentifier, 0, x509CertSelector.subjectKeyIdentifier, 0, this.subjectKeyIdentifier.length);
            }
            if (this.authorityKeyIdentifier != null) {
                x509CertSelector.authorityKeyIdentifier = new byte[this.authorityKeyIdentifier.length];
                System.arraycopy(this.authorityKeyIdentifier, 0, x509CertSelector.authorityKeyIdentifier, 0, this.authorityKeyIdentifier.length);
            }
            if (this.subjectPublicKey != null) {
                x509CertSelector.subjectPublicKey = new byte[this.subjectPublicKey.length];
                System.arraycopy(this.subjectPublicKey, 0, x509CertSelector.subjectPublicKey, 0, this.subjectPublicKey.length);
            }
            if (this.keyUsage != null) {
                x509CertSelector.keyUsage = new boolean[this.keyUsage.length];
                System.arraycopy(this.keyUsage, 0, x509CertSelector.keyUsage, 0, this.keyUsage.length);
            }
            x509CertSelector.extendedKeyUsage = this.extendedKeyUsage == null ? null : new HashSet(this.extendedKeyUsage);
            if (this.subjectAltNames != null) {
                x509CertSelector.subjectAltNames = new ArrayList[9];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 9) {
                        break;
                    }
                    if (this.subjectAltNames[i2] != null) {
                        x509CertSelector.subjectAltNames[i2] = new ArrayList(this.subjectAltNames[i2]);
                    }
                    i = i2 + 1;
                }
            }
            x509CertSelector.policies = this.policies == null ? null : new HashSet(this.policies);
            x509CertSelector.pathToNames = this.pathToNames == null ? null : new ArrayList<>(this.pathToNames);
            return x509CertSelector;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public byte[] getAuthorityKeyIdentifier() {
        if (this.authorityKeyIdentifier == null) {
            return null;
        }
        byte[] bArr = new byte[this.authorityKeyIdentifier.length];
        System.arraycopy(this.authorityKeyIdentifier, 0, bArr, 0, bArr.length);
        return bArr;
    }

    public int getBasicConstraints() {
        return this.pathLen;
    }

    public X509Certificate getCertificate() {
        return this.certificateEquals;
    }

    public Date getCertificateValid() {
        if (this.certificateValid == null) {
            return null;
        }
        return (Date) this.certificateValid.clone();
    }

    public Set<String> getExtendedKeyUsage() {
        return this.extendedKeyUsage;
    }

    public X500Principal getIssuer() {
        return this.issuer;
    }

    public byte[] getIssuerAsBytes() throws IOException {
        if (this.issuer == null) {
            return null;
        }
        if (this.issuerBytes == null) {
            this.issuerBytes = this.issuer.getEncoded();
        }
        byte[] bArr = new byte[this.issuerBytes.length];
        System.arraycopy(this.issuerBytes, 0, bArr, 0, this.issuerBytes.length);
        return bArr;
    }

    public String getIssuerAsString() {
        if (this.issuer == null) {
            return null;
        }
        if (this.issuerName == null) {
            this.issuerName = this.issuer.getName();
        }
        return this.issuerName;
    }

    public boolean[] getKeyUsage() {
        if (this.keyUsage == null) {
            return null;
        }
        boolean[] zArr = new boolean[this.keyUsage.length];
        System.arraycopy(this.keyUsage, 0, zArr, 0, this.keyUsage.length);
        return zArr;
    }

    public boolean getMatchAllSubjectAltNames() {
        return this.matchAllNames;
    }

    public byte[] getNameConstraints() {
        if (this.nameConstraints == null) {
            return null;
        }
        return this.nameConstraints.getEncoded();
    }

    public Collection<List<?>> getPathToNames() {
        ArrayList arrayList;
        if (this.pathToNames != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<GeneralName> it = this.pathToNames.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                arrayList2.add(it.next().getAsList());
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public Set<String> getPolicy() {
        return this.policies;
    }

    public Date getPrivateKeyValid() {
        if (this.privateKeyValid != null) {
            return (Date) this.privateKeyValid.clone();
        }
        return null;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public X500Principal getSubject() {
        return this.subject;
    }

    public Collection<List<?>> getSubjectAlternativeNames() {
        ArrayList arrayList;
        if (this.subjectAltNames != null) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= 9) {
                    break;
                }
                if (this.subjectAltNames[i2] != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < this.subjectAltNames[i2].size()) {
                            ArrayList arrayList3 = new ArrayList(2);
                            arrayList3.add(Integer.valueOf(i2));
                            arrayList3.add(this.subjectAltNames[i2].get(i4));
                            arrayList2.add(arrayList3);
                            i3 = i4 + 1;
                        }
                    }
                }
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public byte[] getSubjectAsBytes() throws IOException {
        if (this.subject == null) {
            return null;
        }
        return this.subject.getEncoded();
    }

    public String getSubjectAsString() {
        if (this.subject == null) {
            return null;
        }
        return this.subject.getName();
    }

    public byte[] getSubjectKeyIdentifier() {
        if (this.subjectKeyIdentifier == null) {
            return null;
        }
        byte[] bArr = new byte[this.subjectKeyIdentifier.length];
        System.arraycopy(this.subjectKeyIdentifier, 0, bArr, 0, bArr.length);
        return bArr;
    }

    public PublicKey getSubjectPublicKey() {
        return this.subjectPublicKeyImpl;
    }

    public String getSubjectPublicKeyAlgID() {
        return this.subjectPublicKeyAlgID;
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x0302, code lost:
        if (r5.matchAllNames != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0305, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0307, code lost:
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x030d, code lost:
        if (r8 >= r0[r7].length) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x031a, code lost:
        if (r0[r7][r8] != 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x031d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x031f, code lost:
        r0 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0326, code lost:
        r0 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x03e7, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x03e9, code lost:
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x03ec, code lost:
        if (r7 >= 9) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x03ef, code lost:
        r0 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.cert.CertSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean match(java.security.cert.Certificate r6) {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.security.cert.X509CertSelector.match(java.security.cert.Certificate):boolean");
    }

    public void setAuthorityKeyIdentifier(byte[] bArr) {
        if (bArr == null) {
            this.authorityKeyIdentifier = null;
            return;
        }
        this.authorityKeyIdentifier = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.authorityKeyIdentifier, 0, bArr.length);
    }

    public void setBasicConstraints(int i) {
        if (i < -2) {
            throw new IllegalArgumentException("pathLen < -2");
        }
        this.pathLen = i;
    }

    public void setCertificate(X509Certificate x509Certificate) {
        this.certificateEquals = x509Certificate;
    }

    public void setCertificateValid(Date date) {
        this.certificateValid = date == null ? null : (Date) date.clone();
    }

    public void setExtendedKeyUsage(Set<String> set) throws IOException {
        this.extendedKeyUsage = null;
        if (set == null || set.size() == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            checkOID(str);
            hashSet.add(str);
        }
        this.extendedKeyUsage = Collections.unmodifiableSet(hashSet);
    }

    public void setIssuer(String str) throws IOException {
        if (str == null) {
            this.issuer = null;
            this.issuerName = null;
            this.issuerBytes = null;
            return;
        }
        try {
            this.issuer = new X500Principal(str);
            this.issuerName = str;
            this.issuerBytes = null;
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void setIssuer(X500Principal x500Principal) {
        this.issuer = x500Principal;
        this.issuerName = null;
        this.issuerBytes = null;
    }

    public void setIssuer(byte[] bArr) throws IOException {
        if (bArr == null) {
            this.issuer = null;
            return;
        }
        try {
            this.issuer = new X500Principal(bArr);
            this.issuerName = null;
            this.issuerBytes = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.issuerBytes, 0, bArr.length);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void setKeyUsage(boolean[] zArr) {
        if (zArr == null) {
            this.keyUsage = null;
            return;
        }
        this.keyUsage = new boolean[zArr.length];
        System.arraycopy(zArr, 0, this.keyUsage, 0, zArr.length);
    }

    public void setMatchAllSubjectAltNames(boolean z) {
        this.matchAllNames = z;
    }

    public void setNameConstraints(byte[] bArr) throws IOException {
        this.nameConstraints = bArr == null ? null : (NameConstraints) NameConstraints.ASN1.decode(bArr);
    }

    public void setPathToNames(Collection<List<?>> collection) throws IOException {
        this.pathToNames = null;
        if (collection == null || collection.size() == 0) {
            return;
        }
        for (List<?> list : collection) {
            int intValue = ((Integer) list.get(0)).intValue();
            Object obj = list.get(1);
            if (obj instanceof String) {
                addPathToName(intValue, (String) obj);
            } else if (!(obj instanceof byte[])) {
                throw new IOException("name neither a String nor a byte[]");
            } else {
                addPathToName(intValue, (byte[]) obj);
            }
        }
    }

    public void setPolicy(Set<String> set) throws IOException {
        if (set == null) {
            this.policies = null;
            return;
        }
        HashSet hashSet = new HashSet(set.size());
        for (String str : set) {
            checkOID(str);
            hashSet.add(str);
        }
        this.policies = Collections.unmodifiableSet(hashSet);
    }

    public void setPrivateKeyValid(Date date) {
        if (date == null) {
            this.privateKeyValid = null;
        } else {
            this.privateKeyValid = (Date) date.clone();
        }
    }

    public void setSerialNumber(BigInteger bigInteger) {
        this.serialNumber = bigInteger;
    }

    public void setSubject(String str) throws IOException {
        if (str == null) {
            this.subject = null;
            return;
        }
        try {
            this.subject = new X500Principal(str);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void setSubject(X500Principal x500Principal) {
        this.subject = x500Principal;
    }

    public void setSubject(byte[] bArr) throws IOException {
        if (bArr == null) {
            this.subject = null;
            return;
        }
        try {
            this.subject = new X500Principal(bArr);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void setSubjectAlternativeNames(Collection<List<?>> collection) throws IOException {
        this.subjectAltNames = null;
        if (collection == null || collection.size() == 0) {
            return;
        }
        for (List<?> list : collection) {
            int intValue = ((Integer) list.get(0)).intValue();
            Object obj = list.get(1);
            if (obj instanceof String) {
                addSubjectAlternativeName(intValue, (String) obj);
            } else if (!(obj instanceof byte[])) {
                throw new IOException("name neither a String nor a byte[]");
            } else {
                addSubjectAlternativeName(intValue, (byte[]) obj);
            }
        }
    }

    public void setSubjectKeyIdentifier(byte[] bArr) {
        if (bArr == null) {
            this.subjectKeyIdentifier = null;
            return;
        }
        this.subjectKeyIdentifier = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.subjectKeyIdentifier, 0, bArr.length);
    }

    public void setSubjectPublicKey(PublicKey publicKey) {
        this.subjectPublicKey = publicKey == null ? null : publicKey.getEncoded();
        this.subjectPublicKeyImpl = publicKey;
    }

    public void setSubjectPublicKey(byte[] bArr) throws IOException {
        if (bArr == null) {
            this.subjectPublicKey = null;
            this.subjectPublicKeyImpl = null;
            return;
        }
        this.subjectPublicKey = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.subjectPublicKey, 0, bArr.length);
        this.subjectPublicKeyImpl = ((SubjectPublicKeyInfo) SubjectPublicKeyInfo.ASN1.decode(bArr)).getPublicKey();
    }

    public void setSubjectPublicKeyAlgID(String str) throws IOException {
        if (str == null) {
            this.subjectPublicKeyAlgID = null;
            return;
        }
        checkOID(str);
        this.subjectPublicKeyAlgID = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X509CertSelector: \n[");
        if (this.certificateEquals != null) {
            sb.append("\n  certificateEquals: ").append(this.certificateEquals);
        }
        if (this.serialNumber != null) {
            sb.append("\n  serialNumber: ").append(this.serialNumber);
        }
        if (this.issuer != null) {
            sb.append("\n  issuer: ").append(this.issuer);
        }
        if (this.subject != null) {
            sb.append("\n  subject: ").append(this.subject);
        }
        if (this.subjectKeyIdentifier != null) {
            sb.append("\n  subjectKeyIdentifier: ").append(Array.getBytesAsString(this.subjectKeyIdentifier));
        }
        if (this.authorityKeyIdentifier != null) {
            sb.append("\n  authorityKeyIdentifier: ").append(Array.getBytesAsString(this.authorityKeyIdentifier));
        }
        if (this.certificateValid != null) {
            sb.append("\n  certificateValid: ").append(this.certificateValid);
        }
        if (this.subjectPublicKeyAlgID != null) {
            sb.append("\n  subjectPublicKeyAlgID: ").append(this.subjectPublicKeyAlgID);
        }
        if (this.privateKeyValid != null) {
            sb.append("\n  privateKeyValid: ").append(this.privateKeyValid);
        }
        if (this.subjectPublicKey != null) {
            sb.append("\n  subjectPublicKey: ").append(Array.getBytesAsString(this.subjectPublicKey));
        }
        if (this.keyUsage != null) {
            sb.append("\n  keyUsage: \n  [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 9) {
                    break;
                }
                if (this.keyUsage[i2]) {
                    sb.append("\n    ").append(new String[]{"digitalSignature", "nonRepudiation", "keyEncipherment", "dataEncipherment", "keyAgreement", "keyCertSign", "cRLSign", "encipherOnly", "decipherOnly"}[i2]);
                }
                i = i2 + 1;
            }
            sb.append("\n  ]");
        }
        if (this.extendedKeyUsage != null) {
            sb.append("\n  extendedKeyUsage: ").append(this.extendedKeyUsage.toString());
        }
        sb.append("\n  matchAllNames: ").append(this.matchAllNames);
        sb.append("\n  pathLen: ").append(this.pathLen);
        if (this.subjectAltNames != null) {
            sb.append("\n  subjectAltNames:  \n  [");
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 9) {
                    break;
                }
                List<GeneralName> list = this.subjectAltNames[i4];
                if (list != null) {
                    list.size();
                    for (GeneralName generalName : list) {
                        sb.append("\n    ").append(generalName.toString());
                    }
                }
                i3 = i4 + 1;
            }
            sb.append("\n  ]");
        }
        if (this.nameConstraints != null) {
        }
        if (this.policies != null) {
            sb.append("\n  policies: ").append(this.policies.toString());
        }
        if (this.pathToNames != null) {
            sb.append("\n  pathToNames:  \n  [");
            Iterator<GeneralName> it = this.pathToNames.iterator();
            while (it.hasNext()) {
                sb.append("\n    ").append(it.next().toString());
            }
        }
        sb.append("\n]");
        return sb.toString();
    }
}

package org.apache.harmony.security.x509;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/Extensions.class */
public final class Extensions {
    private volatile Set<String> critical;
    private byte[] encoding;
    private final List<Extension> extensions;
    private volatile Boolean hasUnsupported;
    private volatile Set<String> noncritical;
    private volatile HashMap<String, Extension> oidMap;
    private static List SUPPORTED_CRITICAL = Arrays.asList("2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17", "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    public static final ASN1Type ASN1 = new ASN1SequenceOf(Extension.ASN1) { // from class: org.apache.harmony.security.x509.Extensions.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new Extensions((List) berInputStream.content);
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            Extensions extensions = (Extensions) obj;
            return extensions.extensions == null ? new ArrayList() : extensions.extensions;
        }
    };

    public Extensions() {
        this.extensions = null;
    }

    public Extensions(List<Extension> list) {
        this.extensions = list;
    }

    private static Collection<List<?>> decodeGeneralNames(Extension extension) throws IOException {
        if (extension == null) {
            return null;
        }
        Collection<List<?>> pairsList = ((GeneralNames) GeneralNames.ASN1.decode(extension.getValue())).getPairsList();
        if (pairsList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableCollection(pairsList);
    }

    private void makeOidsLists() {
        if (this.extensions == null) {
            return;
        }
        int size = this.extensions.size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        Boolean bool = Boolean.FALSE;
        for (Extension extension : this.extensions) {
            String id = extension.getId();
            if (extension.isCritical()) {
                if (!SUPPORTED_CRITICAL.contains(id)) {
                    bool = Boolean.TRUE;
                }
                hashSet.add(id);
            } else {
                hashSet2.add(id);
            }
        }
        this.critical = hashSet;
        this.noncritical = hashSet2;
        this.hasUnsupported = bool;
    }

    public void dumpValue(StringBuilder sb, String str) {
        if (this.extensions == null) {
            return;
        }
        int i = 1;
        for (Extension extension : this.extensions) {
            sb.append('\n').append(str).append('[').append(i).append("]: ");
            extension.dumpValue(sb, str);
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Extensions) {
            Extensions extensions = (Extensions) obj;
            return (this.extensions == null || this.extensions.isEmpty()) ? extensions.extensions == null || extensions.extensions.isEmpty() : this.extensions.equals(extensions.extensions);
        }
        return false;
    }

    public Set<String> getCriticalExtensions() {
        Set<String> set = this.critical;
        Set<String> set2 = set;
        if (set == null) {
            makeOidsLists();
            set2 = this.critical;
        }
        return set2;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Extension getExtensionByOID(String str) {
        if (this.extensions == null) {
            return null;
        }
        HashMap<String, Extension> hashMap = this.oidMap;
        HashMap<String, Extension> hashMap2 = hashMap;
        if (hashMap == null) {
            hashMap2 = new HashMap<>();
            for (Extension extension : this.extensions) {
                hashMap2.put(extension.getId(), extension);
            }
            this.oidMap = hashMap2;
        }
        return hashMap2.get(str);
    }

    public Set<String> getNonCriticalExtensions() {
        Set<String> set = this.noncritical;
        Set<String> set2 = set;
        if (set == null) {
            makeOidsLists();
            set2 = this.noncritical;
        }
        return set2;
    }

    public boolean hasUnsupportedCritical() {
        Boolean bool = this.hasUnsupported;
        Boolean bool2 = bool;
        if (bool == null) {
            makeOidsLists();
            bool2 = this.hasUnsupported;
        }
        return bool2.booleanValue();
    }

    public int hashCode() {
        int i = 0;
        if (this.extensions != null) {
            i = this.extensions.hashCode();
        }
        return i;
    }

    public int size() {
        if (this.extensions == null) {
            return 0;
        }
        return this.extensions.size();
    }

    public int valueOfBasicConstraints() {
        BasicConstraints basicConstraintsValue;
        Extension extensionByOID = getExtensionByOID("2.5.29.19");
        if (extensionByOID == null || (basicConstraintsValue = extensionByOID.getBasicConstraintsValue()) == null || !basicConstraintsValue.getCa()) {
            return -1;
        }
        return basicConstraintsValue.getPathLenConstraint();
    }

    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        Extension extensionByOID = getExtensionByOID("2.5.29.29");
        if (extensionByOID == null) {
            return null;
        }
        return ((CertificateIssuer) extensionByOID.getDecodedExtensionValue()).getIssuer();
    }

    public List<String> valueOfExtendedKeyUsage() throws IOException {
        Extension extensionByOID = getExtensionByOID("2.5.29.37");
        if (extensionByOID == null) {
            return null;
        }
        return ((ExtendedKeyUsage) extensionByOID.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        return decodeGeneralNames(getExtensionByOID("2.5.29.18"));
    }

    public boolean[] valueOfKeyUsage() {
        KeyUsage keyUsageValue;
        Extension extensionByOID = getExtensionByOID("2.5.29.15");
        if (extensionByOID == null || (keyUsageValue = extensionByOID.getKeyUsageValue()) == null) {
            return null;
        }
        return keyUsageValue.getKeyUsage();
    }

    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        return decodeGeneralNames(getExtensionByOID("2.5.29.17"));
    }
}

package org.apache.harmony.security.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/GeneralNames.class */
public final class GeneralNames {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralName.ASN1) { // from class: org.apache.harmony.security.x509.GeneralNames.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new GeneralNames((List) berInputStream.content, berInputStream.getEncoded());
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            return ((GeneralNames) obj).generalNames;
        }
    };
    private byte[] encoding;
    private List<GeneralName> generalNames;

    public GeneralNames() {
        this.generalNames = new ArrayList();
    }

    public GeneralNames(List<GeneralName> list) {
        this.generalNames = list;
    }

    private GeneralNames(List<GeneralName> list, byte[] bArr) {
        this.generalNames = list;
        this.encoding = bArr;
    }

    public void addName(GeneralName generalName) {
        this.encoding = null;
        if (this.generalNames == null) {
            this.generalNames = new ArrayList();
        }
        this.generalNames.add(generalName);
    }

    public void dumpValue(StringBuilder sb, String str) {
        if (this.generalNames == null) {
            return;
        }
        for (GeneralName generalName : this.generalNames) {
            sb.append(str);
            sb.append(generalName);
            sb.append('\n');
        }
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public List<GeneralName> getNames() {
        if (this.generalNames == null || this.generalNames.size() == 0) {
            return null;
        }
        return new ArrayList(this.generalNames);
    }

    public Collection<List<?>> getPairsList() {
        ArrayList arrayList = new ArrayList();
        if (this.generalNames != null) {
            for (GeneralName generalName : this.generalNames) {
                try {
                    arrayList.add(generalName.getAsList());
                } catch (IllegalArgumentException e) {
                }
            }
        }
        return arrayList;
    }
}

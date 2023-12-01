package org.apache.harmony.security.x509;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/NameConstraints.class */
public final class NameConstraints extends ExtensionValue {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Implicit(0, GeneralSubtrees.ASN1), new ASN1Implicit(1, GeneralSubtrees.ASN1)}) { // from class: org.apache.harmony.security.x509.NameConstraints.1
        {
            setOptional(0);
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new NameConstraints((GeneralSubtrees) objArr[0], (GeneralSubtrees) objArr[1], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            NameConstraints nameConstraints = (NameConstraints) obj;
            objArr[0] = nameConstraints.permittedSubtrees;
            objArr[1] = nameConstraints.excludedSubtrees;
        }
    };
    private byte[] encoding;
    private final GeneralSubtrees excludedSubtrees;
    private ArrayList<GeneralName>[] excluded_names;
    private final GeneralSubtrees permittedSubtrees;
    private ArrayList<GeneralName>[] permitted_names;

    public NameConstraints(GeneralSubtrees generalSubtrees, GeneralSubtrees generalSubtrees2) {
        List<GeneralSubtree> subtrees;
        List<GeneralSubtree> subtrees2;
        if (generalSubtrees != null && ((subtrees2 = generalSubtrees.getSubtrees()) == null || subtrees2.isEmpty())) {
            throw new IllegalArgumentException("permittedSubtrees are empty");
        }
        if (generalSubtrees2 != null && ((subtrees = generalSubtrees2.getSubtrees()) == null || subtrees.isEmpty())) {
            throw new IllegalArgumentException("excludedSubtrees are empty");
        }
        this.permittedSubtrees = generalSubtrees;
        this.excludedSubtrees = generalSubtrees2;
    }

    private NameConstraints(GeneralSubtrees generalSubtrees, GeneralSubtrees generalSubtrees2, byte[] bArr) {
        this(generalSubtrees, generalSubtrees2);
        this.encoding = bArr;
    }

    public static NameConstraints decode(byte[] bArr) throws IOException {
        return (NameConstraints) ASN1.decode(bArr);
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

    private void prepareNames() {
        this.permitted_names = new ArrayList[9];
        if (this.permittedSubtrees != null) {
            for (GeneralSubtree generalSubtree : this.permittedSubtrees.getSubtrees()) {
                GeneralName base = generalSubtree.getBase();
                int tag = base.getTag();
                if (this.permitted_names[tag] == null) {
                    this.permitted_names[tag] = new ArrayList<>();
                }
                this.permitted_names[tag].add(base);
            }
        }
        this.excluded_names = new ArrayList[9];
        if (this.excludedSubtrees != null) {
            for (GeneralSubtree generalSubtree2 : this.excludedSubtrees.getSubtrees()) {
                GeneralName base2 = generalSubtree2.getBase();
                int tag2 = base2.getTag();
                if (this.excluded_names[tag2] == null) {
                    this.excluded_names[tag2] = new ArrayList<>();
                }
                this.excluded_names[tag2].add(base2);
            }
        }
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("Name Constraints: [\n");
        if (this.permittedSubtrees != null) {
            sb.append(str).append("  Permitted: [\n");
            for (GeneralSubtree generalSubtree : this.permittedSubtrees.getSubtrees()) {
                generalSubtree.dumpValue(sb, str + "    ");
            }
            sb.append(str).append("  ]\n");
        }
        if (this.excludedSubtrees != null) {
            sb.append(str).append("  Excluded: [\n");
            for (GeneralSubtree generalSubtree2 : this.excludedSubtrees.getSubtrees()) {
                generalSubtree2.dumpValue(sb, str + "    ");
            }
            sb.append(str).append("  ]\n");
        }
        sb.append('\n').append(str).append("]\n");
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public boolean isAcceptable(X509Certificate x509Certificate) {
        if (this.permitted_names == null) {
            prepareNames();
        }
        byte[] extensionValue = getExtensionValue(x509Certificate, "2.5.29.17");
        try {
            ArrayList arrayList = extensionValue == null ? new ArrayList(1) : ((GeneralNames) GeneralNames.ASN1.decode(extensionValue)).getNames();
            if (this.excluded_names[4] != null || this.permitted_names[4] != null) {
                try {
                    arrayList.add(new GeneralName(4, x509Certificate.getSubjectX500Principal().getName()));
                } catch (IOException e) {
                }
            }
            return isAcceptable(arrayList);
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isAcceptable(List<GeneralName> list) {
        if (this.permitted_names == null) {
            prepareNames();
        }
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[9];
        for (GeneralName generalName : list) {
            int tag = generalName.getTag();
            if (this.excluded_names[tag] != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.excluded_names[tag].size()) {
                        break;
                    } else if (this.excluded_names[tag].get(i2).isAcceptable(generalName)) {
                        return false;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
            if (this.permitted_names[tag] != null && !zArr2[tag]) {
                zArr[tag] = true;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.permitted_names[tag].size()) {
                        if (this.permitted_names[tag].get(i4).isAcceptable(generalName)) {
                            zArr2[tag] = true;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 9) {
                return true;
            }
            if (zArr[i6] && !zArr2[i6]) {
                return false;
            }
            i5 = i6 + 1;
        }
    }
}

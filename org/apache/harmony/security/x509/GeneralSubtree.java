package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/GeneralSubtree.class */
public final class GeneralSubtree {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{GeneralName.ASN1, new ASN1Implicit(0, ASN1Integer.getInstance()), new ASN1Implicit(1, ASN1Integer.getInstance())}) { // from class: org.apache.harmony.security.x509.GeneralSubtree.1
        {
            setDefault(new byte[]{0}, 1);
            setOptional(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            int i = -1;
            if (objArr[2] != null) {
                i = ASN1Integer.toIntValue(objArr[2]);
            }
            return new GeneralSubtree((GeneralName) objArr[0], ASN1Integer.toIntValue(objArr[1]), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            GeneralSubtree generalSubtree = (GeneralSubtree) obj;
            objArr[0] = generalSubtree.base;
            objArr[1] = ASN1Integer.fromIntValue(generalSubtree.minimum);
            if (generalSubtree.maximum > -1) {
                objArr[2] = ASN1Integer.fromIntValue(generalSubtree.maximum);
            }
        }
    };
    private final GeneralName base;
    private byte[] encoding;
    private final int maximum;
    private final int minimum;

    public GeneralSubtree(GeneralName generalName, int i, int i2) {
        this.base = generalName;
        this.minimum = i;
        this.maximum = i2;
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("General Subtree: [\n");
        sb.append(str).append("  base: ").append(this.base).append('\n');
        sb.append(str).append("  minimum: ").append(this.minimum).append('\n');
        if (this.maximum >= 0) {
            sb.append(str).append("  maximum: ").append(this.maximum).append('\n');
        }
        sb.append(str).append("]\n");
    }

    public GeneralName getBase() {
        return this.base;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }
}

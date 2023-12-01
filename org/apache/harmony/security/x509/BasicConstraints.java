package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/BasicConstraints.class */
public final class BasicConstraints extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Boolean.getInstance(), ASN1Integer.getInstance()}) { // from class: org.apache.harmony.security.x509.BasicConstraints.1
        {
            setDefault(Boolean.FALSE, 0);
            setOptional(1);
        }

        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return berInputStream.content;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            Object[] objArr2 = (Object[]) obj;
            objArr[0] = objArr2[0];
            objArr[1] = ((BigInteger) objArr2[1]).toByteArray();
        }
    };
    private boolean ca;
    private int pathLenConstraint;

    public BasicConstraints(byte[] bArr) throws IOException {
        super(bArr);
        this.ca = false;
        this.pathLenConstraint = Integer.MAX_VALUE;
        Object[] objArr = (Object[]) ASN1.decode(bArr);
        this.ca = ((Boolean) objArr[0]).booleanValue();
        if (objArr[1] != null) {
            this.pathLenConstraint = new BigInteger((byte[]) objArr[1]).intValue();
        }
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("BasicConstraints [\n").append(str).append("  CA: ").append(this.ca).append("\n  ").append(str).append("pathLenConstraint: ").append(this.pathLenConstraint).append('\n').append(str).append("]\n");
    }

    public boolean getCa() {
        return this.ca;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(new Object[]{Boolean.valueOf(this.ca), BigInteger.valueOf(this.pathLenConstraint)});
        }
        return this.encoding;
    }

    public int getPathLenConstraint() {
        return this.pathLenConstraint;
    }
}

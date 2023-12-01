package java.security.cert;

import java.io.IOException;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PolicyQualifierInfo.class */
public class PolicyQualifierInfo {
    private final byte[] encoded;
    private final byte[] policyQualifier;
    private final String policyQualifierId;

    public PolicyQualifierInfo(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("encoded == null");
        }
        if (bArr.length == 0) {
            throw new IOException("encoded.length == 0");
        }
        this.encoded = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encoded, 0, this.encoded.length);
        Object[] objArr = (Object[]) org.apache.harmony.security.x509.PolicyQualifierInfo.ASN1.decode(this.encoded);
        this.policyQualifierId = ObjectIdentifier.toString((int[]) objArr[0]);
        this.policyQualifier = (byte[]) objArr[1];
    }

    public final byte[] getEncoded() {
        byte[] bArr = new byte[this.encoded.length];
        System.arraycopy(this.encoded, 0, bArr, 0, this.encoded.length);
        return bArr;
    }

    public final byte[] getPolicyQualifier() {
        if (this.policyQualifier == null) {
            return null;
        }
        byte[] bArr = new byte[this.policyQualifier.length];
        System.arraycopy(this.policyQualifier, 0, bArr, 0, this.policyQualifier.length);
        return bArr;
    }

    public final String getPolicyQualifierId() {
        return this.policyQualifierId;
    }

    public String toString() {
        return "PolicyQualifierInfo: [\npolicyQualifierId: " + this.policyQualifierId + "\npolicyQualifier: \n" + Array.toString(this.policyQualifier, " ") + "]";
    }
}

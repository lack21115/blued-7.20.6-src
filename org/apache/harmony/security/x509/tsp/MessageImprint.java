package org.apache.harmony.security.x509.tsp;

import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/tsp/MessageImprint.class */
public class MessageImprint {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance()}) { // from class: org.apache.harmony.security.x509.tsp.MessageImprint.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new MessageImprint((AlgorithmIdentifier) objArr[0], (byte[]) objArr[1]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            MessageImprint messageImprint = (MessageImprint) obj;
            objArr[0] = messageImprint.algId;
            objArr[1] = messageImprint.hashedMessage;
        }
    };
    private final AlgorithmIdentifier algId;
    private final byte[] hashedMessage;

    public MessageImprint(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.algId = algorithmIdentifier;
        this.hashedMessage = bArr;
    }
}

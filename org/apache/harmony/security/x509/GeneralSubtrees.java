package org.apache.harmony.security.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/GeneralSubtrees.class */
public final class GeneralSubtrees {
    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralSubtree.ASN1) { // from class: org.apache.harmony.security.x509.GeneralSubtrees.1
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            return new GeneralSubtrees((List) berInputStream.content);
        }

        @Override // org.apache.harmony.security.asn1.ASN1ValueCollection
        public Collection getValues(Object obj) {
            GeneralSubtrees generalSubtrees = (GeneralSubtrees) obj;
            return generalSubtrees.generalSubtrees == null ? new ArrayList() : generalSubtrees.generalSubtrees;
        }
    };
    private byte[] encoding;
    private List<GeneralSubtree> generalSubtrees;

    public GeneralSubtrees(List<GeneralSubtree> list) {
        this.generalSubtrees = list;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public List<GeneralSubtree> getSubtrees() {
        return this.generalSubtrees;
    }
}

package org.apache.harmony.security.asn1;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1TypeCollection.class */
public abstract class ASN1TypeCollection extends ASN1Constructed {
    public final Object[] DEFAULT;
    public final boolean[] OPTIONAL;
    public final ASN1Type[] type;

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1TypeCollection(int i, ASN1Type[] aSN1TypeArr) {
        super(i);
        this.type = aSN1TypeArr;
        this.OPTIONAL = new boolean[aSN1TypeArr.length];
        this.DEFAULT = new Object[aSN1TypeArr.length];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getValues(Object obj, Object[] objArr) {
        throw new RuntimeException("ASN.1 type is not designed to be encoded: " + getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setDefault(Object obj, int i) {
        this.OPTIONAL[i] = true;
        this.DEFAULT[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setOptional(int i) {
        this.OPTIONAL[i] = true;
    }
}

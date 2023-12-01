package org.apache.harmony.security.asn1;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/DerOutputStream.class */
public final class DerOutputStream extends BerOutputStream {
    private static final int initSize = 32;
    private int index;
    private int[][] len = new int[32];
    private Object[][] val = new Object[32];

    /* JADX WARN: Type inference failed for: r1v1, types: [int[], int[][]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[], java.lang.Object[][]] */
    public DerOutputStream(ASN1Type aSN1Type, Object obj) {
        this.content = obj;
        this.index = -1;
        aSN1Type.setEncodingContent(this);
        this.encoded = new byte[aSN1Type.getEncodedLength(this)];
        this.index = 0;
        aSN1Type.encodeASN(this);
    }

    private void encodeValueCollection(ASN1ValueCollection aSN1ValueCollection) {
        Object[] objArr = this.val[this.index];
        int[] iArr = this.len[this.index];
        this.index++;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            this.content = objArr[i2];
            this.length = iArr[i2];
            aSN1ValueCollection.type.encodeASN(this);
            i = i2 + 1;
        }
    }

    private void getValueOfLength(ASN1ValueCollection aSN1ValueCollection) {
        Object[] array = aSN1ValueCollection.getValues(this.content).toArray();
        Object[] objArr = new Object[array.length];
        int[] iArr = new int[objArr.length];
        push(iArr, objArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= objArr.length) {
                this.length = i;
                return;
            }
            this.content = array[i3];
            aSN1ValueCollection.type.setEncodingContent(this);
            iArr[i3] = this.length;
            objArr[i3] = this.content;
            i += aSN1ValueCollection.type.getEncodedLength(this);
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [int[], int[][], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.lang.Object[], java.lang.Object, java.lang.Object[][]] */
    private void push(int[] iArr, Object[] objArr) {
        this.index++;
        if (this.index == this.val.length) {
            ?? r0 = new int[this.val.length * 2];
            System.arraycopy(this.len, 0, (Object) r0, 0, this.val.length);
            this.len = r0;
            ?? r02 = new Object[this.val.length * 2];
            System.arraycopy(this.val, 0, (Object) r02, 0, this.val.length);
            this.val = r02;
        }
        this.len[this.index] = iArr;
        this.val[this.index] = objArr;
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void encodeChoice(ASN1Choice aSN1Choice) {
        this.content = this.val[this.index][1];
        this.index++;
        ((ASN1Type) this.val[this.index][0]).encodeASN(this);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void encodeExplicit(ASN1Explicit aSN1Explicit) {
        this.content = this.val[this.index][0];
        this.length = this.len[this.index][0];
        this.index++;
        aSN1Explicit.type.encodeASN(this);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void encodeSequence(ASN1Sequence aSN1Sequence) {
        ASN1Type[] aSN1TypeArr = aSN1Sequence.type;
        Object[] objArr = this.val[this.index];
        int[] iArr = this.len[this.index];
        this.index++;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aSN1TypeArr.length) {
                return;
            }
            if (objArr[i2] != null) {
                this.content = objArr[i2];
                this.length = iArr[i2];
                aSN1TypeArr[i2].encodeASN(this);
            }
            i = i2 + 1;
        }
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void encodeSequenceOf(ASN1SequenceOf aSN1SequenceOf) {
        encodeValueCollection(aSN1SequenceOf);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void encodeSetOf(ASN1SetOf aSN1SetOf) {
        encodeValueCollection(aSN1SetOf);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void getChoiceLength(ASN1Choice aSN1Choice) {
        int index = aSN1Choice.getIndex(this.content);
        this.content = aSN1Choice.getObjectToEncode(this.content);
        Object[] objArr = {aSN1Choice.type[index], this.content};
        push(null, objArr);
        aSN1Choice.type[index].setEncodingContent(this);
        objArr[1] = this.content;
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void getExplicitLength(ASN1Explicit aSN1Explicit) {
        Object[] objArr = {this.content};
        push(r0, objArr);
        aSN1Explicit.type.setEncodingContent(this);
        objArr[0] = this.content;
        int[] iArr = {this.length};
        this.length = aSN1Explicit.type.getEncodedLength(this);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void getSequenceLength(ASN1Sequence aSN1Sequence) {
        ASN1Type[] aSN1TypeArr = aSN1Sequence.type;
        Object[] objArr = new Object[aSN1TypeArr.length];
        int[] iArr = new int[aSN1TypeArr.length];
        aSN1Sequence.getValues(this.content, objArr);
        push(iArr, objArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= aSN1TypeArr.length) {
                this.length = i;
                return;
            }
            if (objArr[i3] == null) {
                if (!aSN1Sequence.OPTIONAL[i3]) {
                    throw new RuntimeException();
                }
            } else if (Objects.equal(aSN1Sequence.DEFAULT[i3], objArr[i3])) {
                objArr[i3] = null;
            } else {
                this.content = objArr[i3];
                aSN1TypeArr[i3].setEncodingContent(this);
                iArr[i3] = this.length;
                objArr[i3] = this.content;
                i += aSN1TypeArr[i3].getEncodedLength(this);
            }
            i2 = i3 + 1;
        }
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void getSequenceOfLength(ASN1SequenceOf aSN1SequenceOf) {
        getValueOfLength(aSN1SequenceOf);
    }

    @Override // org.apache.harmony.security.asn1.BerOutputStream
    public void getSetOfLength(ASN1SetOf aSN1SetOf) {
        getValueOfLength(aSN1SetOf);
    }
}

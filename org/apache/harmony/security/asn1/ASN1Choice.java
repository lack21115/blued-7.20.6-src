package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Choice.class */
public abstract class ASN1Choice extends ASN1Type {
    private final int[][] identifiers;
    public final ASN1Type[] type;

    public ASN1Choice(ASN1Type[] aSN1TypeArr) {
        super(0);
        if (aSN1TypeArr.length == 0) {
            throw new IllegalArgumentException("ASN.1 choice type MUST have at least one alternative: " + getClass().getName());
        }
        TreeMap<BigInteger, BigInteger> treeMap = new TreeMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aSN1TypeArr.length) {
                ASN1Type aSN1Type = aSN1TypeArr[i2];
                if (aSN1Type instanceof ASN1Any) {
                    throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName());
                }
                if (aSN1Type instanceof ASN1Choice) {
                    int[][] iArr = ((ASN1Choice) aSN1Type).identifiers;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < iArr[0].length) {
                            addIdentifier(treeMap, iArr[0][i4], i2);
                            i3 = i4 + 1;
                        }
                    }
                } else {
                    if (aSN1Type.checkTag(aSN1Type.id)) {
                        addIdentifier(treeMap, aSN1Type.id, i2);
                    }
                    if (aSN1Type.checkTag(aSN1Type.constrId)) {
                        addIdentifier(treeMap, aSN1Type.constrId, i2);
                    }
                }
                i = i2 + 1;
            } else {
                int size = treeMap.size();
                this.identifiers = (int[][]) Array.newInstance(Integer.TYPE, 2, size);
                Iterator<Map.Entry<BigInteger, BigInteger>> it = treeMap.entrySet().iterator();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size) {
                        this.type = aSN1TypeArr;
                        return;
                    }
                    Map.Entry<BigInteger, BigInteger> next = it.next();
                    this.identifiers[0][i6] = next.getKey().intValue();
                    this.identifiers[1][i6] = next.getValue().intValue();
                    i5 = i6 + 1;
                }
            }
        }
    }

    private void addIdentifier(TreeMap<BigInteger, BigInteger> treeMap, int i, int i2) {
        if (treeMap.put(BigInteger.valueOf(i), BigInteger.valueOf(i2)) != null) {
            throw new IllegalArgumentException("ASN.1 choice type MUST have alternatives with distinct tags: " + getClass().getName());
        }
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final boolean checkTag(int i) {
        boolean z = false;
        if (Arrays.binarySearch(this.identifiers[0], i) >= 0) {
            z = true;
        }
        return z;
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        int binarySearch = Arrays.binarySearch(this.identifiers[0], berInputStream.tag);
        if (binarySearch < 0) {
            throw new ASN1Exception("Failed to decode ASN.1 choice type.  No alternatives were found for " + getClass().getName());
        }
        int i = this.identifiers[1][binarySearch];
        berInputStream.content = this.type[i].decode(berInputStream);
        berInputStream.choiceIndex = i;
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public void encodeASN(BerOutputStream berOutputStream) {
        encodeContent(berOutputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeChoice(this);
    }

    public abstract int getIndex(Object obj);

    public abstract Object getObjectToEncode(Object obj);

    @Override // org.apache.harmony.security.asn1.ASN1Type
    public final void setEncodingContent(BerOutputStream berOutputStream) {
        berOutputStream.getChoiceLength(this);
    }
}

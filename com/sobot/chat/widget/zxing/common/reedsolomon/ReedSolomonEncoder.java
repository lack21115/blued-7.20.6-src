package com.sobot.chat.widget.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/reedsolomon/ReedSolomonEncoder.class */
public final class ReedSolomonEncoder {
    private final List<GenericGFPoly> cachedGenerators;
    private final GenericGF field;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.field = genericGF;
        ArrayList arrayList = new ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly buildGenerator(int i) {
        if (i >= this.cachedGenerators.size()) {
            List<GenericGFPoly> list = this.cachedGenerators;
            GenericGFPoly genericGFPoly = list.get(list.size() - 1);
            int size = this.cachedGenerators.size();
            while (true) {
                int i2 = size;
                if (i2 > i) {
                    break;
                }
                GenericGF genericGF = this.field;
                genericGFPoly = genericGFPoly.multiply(new GenericGFPoly(genericGF, new int[]{1, genericGF.exp((i2 - 1) + genericGF.getGeneratorBase())}));
                this.cachedGenerators.add(genericGFPoly);
                size = i2 + 1;
            }
        }
        return this.cachedGenerators.get(i);
    }

    public void encode(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly buildGenerator = buildGenerator(i);
        int[] iArr2 = new int[length];
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, length);
        int[] coefficients = new GenericGFPoly(this.field, iArr2).multiplyByMonomial(i, 1).divide(buildGenerator)[1].getCoefficients();
        int length2 = i - coefficients.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                System.arraycopy((Object) coefficients, 0, (Object) iArr, length + length2, coefficients.length);
                return;
            } else {
                iArr[length + i3] = 0;
                i2 = i3 + 1;
            }
        }
    }
}

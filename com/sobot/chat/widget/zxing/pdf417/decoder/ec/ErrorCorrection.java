package com.sobot.chat.widget.zxing.pdf417.decoder.ec;

import com.sobot.chat.widget.zxing.ChecksumException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/pdf417/decoder/ec/ErrorCorrection.class */
public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int i;
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= this.field.getSize() || i >= degree) {
                break;
            }
            int i4 = i;
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        if (i == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 > degree) {
                break;
            }
            iArr2[degree - i2] = this.field.multiply(i2, modulusPoly2.getCoefficient(i2));
            i = i2 + 1;
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return iArr3;
            }
            int inverse = this.field.inverse(iArr[i4]);
            iArr3[i4] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
            i3 = i4 + 1;
        }
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i) throws ChecksumException {
        ModulusPoly modulusPoly3 = modulusPoly;
        ModulusPoly modulusPoly4 = modulusPoly2;
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly4 = modulusPoly;
            modulusPoly3 = modulusPoly2;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        ModulusPoly modulusPoly5 = modulusPoly4;
        ModulusPoly modulusPoly6 = zero;
        while (true) {
            ModulusPoly modulusPoly7 = modulusPoly6;
            ModulusPoly modulusPoly8 = modulusPoly3;
            modulusPoly3 = modulusPoly5;
            if (modulusPoly3.getDegree() < i / 2) {
                int coefficient = one.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse = this.field.inverse(coefficient);
                    return new ModulusPoly[]{one.multiply(inverse), modulusPoly3.multiply(inverse)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (modulusPoly3.isZero()) {
                throw ChecksumException.getChecksumInstance();
            } else {
                ModulusPoly zero2 = this.field.getZero();
                int inverse2 = this.field.inverse(modulusPoly3.getCoefficient(modulusPoly3.getDegree()));
                modulusPoly5 = modulusPoly8;
                ModulusPoly modulusPoly9 = zero2;
                while (modulusPoly5.getDegree() >= modulusPoly3.getDegree() && !modulusPoly5.isZero()) {
                    int degree = modulusPoly5.getDegree() - modulusPoly3.getDegree();
                    int multiply = this.field.multiply(modulusPoly5.getCoefficient(modulusPoly5.getDegree()), inverse2);
                    modulusPoly9 = modulusPoly9.add(this.field.buildMonomial(degree, multiply));
                    modulusPoly5 = modulusPoly5.subtract(modulusPoly3.multiplyByMonomial(degree, multiply));
                }
                ModulusPoly negative = modulusPoly9.multiply(one).subtract(modulusPoly7).negative();
                modulusPoly6 = one;
                one = negative;
            }
        }
    }

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i - i2] = evaluateAt;
            if (evaluateAt != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            int length = iArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                int exp = this.field.exp((iArr.length - 1) - iArr2[i4]);
                ModulusGF modulusGF = this.field;
                one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
                i3 = i4 + 1;
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
        ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(modulusPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= findErrorLocations.length) {
                return findErrorLocations.length;
            }
            int length2 = (iArr.length - 1) - this.field.log(findErrorLocations[i6]);
            if (length2 < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length2] = this.field.subtract(iArr[length2], findErrorMagnitudes[i6]);
            i5 = i6 + 1;
        }
    }
}

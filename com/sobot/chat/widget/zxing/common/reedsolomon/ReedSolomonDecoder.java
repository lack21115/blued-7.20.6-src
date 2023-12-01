package com.sobot.chat.widget.zxing.common.reedsolomon;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/common/reedsolomon/ReedSolomonDecoder.class */
public final class ReedSolomonDecoder {
    private final GenericGF field;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.field = genericGF;
    }

    private int[] findErrorLocations(GenericGFPoly genericGFPoly) throws ReedSolomonException {
        int degree = genericGFPoly.getDegree();
        int i = 0;
        int i2 = 1;
        if (degree == 1) {
            return new int[]{genericGFPoly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        while (i2 < this.field.getSize() && i < degree) {
            int i3 = i;
            if (genericGFPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        if (i == degree) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr2;
            }
            int inverse = this.field.inverse(iArr[i2]);
            int i3 = 1;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i3;
                if (i2 != i4) {
                    int multiply = this.field.multiply(iArr[i4], inverse);
                    i5 = this.field.multiply(i3, (multiply & 1) == 0 ? multiply | 1 : multiply & (-2));
                }
                i4++;
                i3 = i5;
            }
            iArr2[i2] = this.field.multiply(genericGFPoly.evaluateAt(inverse), this.field.inverse(i3));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i2] = this.field.multiply(iArr2[i2], inverse);
            }
            i = i2 + 1;
        }
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly genericGFPoly, GenericGFPoly genericGFPoly2, int i) throws ReedSolomonException {
        GenericGFPoly genericGFPoly3 = genericGFPoly;
        GenericGFPoly genericGFPoly4 = genericGFPoly2;
        if (genericGFPoly.getDegree() < genericGFPoly2.getDegree()) {
            genericGFPoly4 = genericGFPoly;
            genericGFPoly3 = genericGFPoly2;
        }
        GenericGFPoly zero = this.field.getZero();
        GenericGFPoly one = this.field.getOne();
        GenericGFPoly genericGFPoly5 = genericGFPoly4;
        GenericGFPoly genericGFPoly6 = zero;
        while (true) {
            GenericGFPoly genericGFPoly7 = genericGFPoly6;
            GenericGFPoly genericGFPoly8 = genericGFPoly3;
            genericGFPoly3 = genericGFPoly5;
            if (genericGFPoly3.getDegree() < i / 2) {
                int coefficient = one.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse = this.field.inverse(coefficient);
                    return new GenericGFPoly[]{one.multiply(inverse), genericGFPoly3.multiply(inverse)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            } else if (genericGFPoly3.isZero()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            } else {
                GenericGFPoly zero2 = this.field.getZero();
                int inverse2 = this.field.inverse(genericGFPoly3.getCoefficient(genericGFPoly3.getDegree()));
                genericGFPoly5 = genericGFPoly8;
                GenericGFPoly genericGFPoly9 = zero2;
                while (genericGFPoly5.getDegree() >= genericGFPoly3.getDegree() && !genericGFPoly5.isZero()) {
                    int degree = genericGFPoly5.getDegree() - genericGFPoly3.getDegree();
                    int multiply = this.field.multiply(genericGFPoly5.getCoefficient(genericGFPoly5.getDegree()), inverse2);
                    genericGFPoly9 = genericGFPoly9.addOrSubtract(this.field.buildMonomial(degree, multiply));
                    genericGFPoly5 = genericGFPoly5.addOrSubtract(genericGFPoly3.multiplyByMonomial(degree, multiply));
                }
                GenericGFPoly addOrSubtract = genericGFPoly9.multiply(one).addOrSubtract(genericGFPoly7);
                if (genericGFPoly5.getDegree() >= genericGFPoly3.getDegree()) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
                genericGFPoly6 = one;
                one = addOrSubtract;
            }
        }
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            GenericGF genericGF = this.field;
            int evaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i2));
            iArr2[(i - 1) - i2] = evaluateAt;
            if (evaluateAt != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        GenericGFPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new GenericGFPoly(this.field, iArr2), i);
        GenericGFPoly genericGFPoly2 = runEuclideanAlgorithm[0];
        GenericGFPoly genericGFPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(genericGFPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, findErrorLocations);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= findErrorLocations.length) {
                return;
            }
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i4]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = GenericGF.addOrSubtract(iArr[length], findErrorMagnitudes[i4]);
            i3 = i4 + 1;
        }
    }
}

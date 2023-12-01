package com.google.zxing.pdf417.decoder.ec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/pdf417/decoder/ec/ModulusPoly.class */
public final class ModulusPoly {
    private final int[] coefficients;
    private final ModulusGF field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly(ModulusGF modulusGF, int[] iArr) {
        int i;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = modulusGF;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        int i2 = 1;
        while (true) {
            i = i2;
            if (i >= length || iArr[i] != 0) {
                break;
            }
            i2 = i + 1;
        }
        if (i == length) {
            this.coefficients = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.coefficients = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly add(ModulusPoly modulusPoly) {
        int[] iArr;
        if (!this.field.equals(modulusPoly.field)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero()) {
            return modulusPoly;
        }
        if (modulusPoly.isZero()) {
            return this;
        }
        int[] iArr2 = this.coefficients;
        int[] iArr3 = modulusPoly.coefficients;
        if (iArr2.length > iArr3.length) {
            iArr = iArr2;
            iArr2 = iArr3;
        } else {
            iArr = iArr3;
        }
        int[] iArr4 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr4, 0, length);
        int i = length;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return new ModulusPoly(this.field, iArr4);
            }
            iArr4[i2] = this.field.add(iArr2[i2 - length], iArr[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int evaluateAt(int i) {
        if (i == 0) {
            return getCoefficient(0);
        }
        if (i != 1) {
            int[] iArr = this.coefficients;
            int i2 = iArr[0];
            int length = iArr.length;
            for (int i3 = 1; i3 < length; i3++) {
                ModulusGF modulusGF = this.field;
                i2 = modulusGF.add(modulusGF.multiply(i, i2), this.coefficients[i3]);
            }
            return i2;
        }
        int[] iArr2 = this.coefficients;
        int length2 = iArr2.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length2) {
                return i4;
            }
            i4 = this.field.add(i4, iArr2[i6]);
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCoefficient(int i) {
        int[] iArr = this.coefficients;
        return iArr[(iArr.length - 1) - i];
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDegree() {
        return this.coefficients.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isZero() {
        return this.coefficients[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return new ModulusPoly(this.field, iArr);
            }
            iArr[i3] = this.field.multiply(this.coefficients[i3], i);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiply(ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero() || modulusPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = modulusPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new ModulusPoly(this.field, iArr3);
            }
            int i3 = iArr[i2];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < length2) {
                    int i6 = i2 + i5;
                    ModulusGF modulusGF = this.field;
                    iArr3[i6] = modulusGF.add(iArr3[i6], modulusGF.multiply(i3, iArr2[i5]));
                    i4 = i5 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly multiplyByMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[i + length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return new ModulusPoly(this.field, iArr);
            }
            iArr[i4] = this.field.multiply(this.coefficients[i4], i2);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly negative() {
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new ModulusPoly(this.field, iArr);
            }
            iArr[i2] = this.field.subtract(0, this.coefficients[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModulusPoly subtract(ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            return modulusPoly.isZero() ? this : add(modulusPoly.negative());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        int degree = getDegree();
        while (true) {
            int i2 = degree;
            if (i2 < 0) {
                return sb.toString();
            }
            int coefficient = getCoefficient(i2);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    i = -coefficient;
                } else {
                    i = coefficient;
                    if (sb.length() > 0) {
                        sb.append(" + ");
                        i = coefficient;
                    }
                }
                if (i2 == 0 || i != 1) {
                    sb.append(i);
                }
                if (i2 != 0) {
                    if (i2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(i2);
                    }
                }
            }
            degree = i2 - 1;
        }
    }
}

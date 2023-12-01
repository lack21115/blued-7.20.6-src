package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/math/Quantiles.class */
public final class Quantiles {

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/math/Quantiles$Scale.class */
    public static final class Scale {
        private final int scale;

        private Scale(int i) {
            Preconditions.checkArgument(i > 0, "Quantile scale must be positive");
            this.scale = i;
        }

        public ScaleAndIndex index(int i) {
            return new ScaleAndIndex(this.scale, i);
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/math/Quantiles$ScaleAndIndex.class */
    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        private ScaleAndIndex(int i, int i2) {
            Quantiles.checkIndex(i2, i);
            this.scale = i;
            this.index = i2;
        }

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = this.index * (dArr.length - 1);
            int divide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
            int i = (int) (length - (divide * this.scale));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[divide];
            }
            int i2 = divide + 1;
            Quantiles.selectInPlace(i2, dArr, i2, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i2], i, this.scale);
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/math/Quantiles$ScaleAndIndexes.class */
    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        private ScaleAndIndexes(int i, int[] iArr) {
            int length = iArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                Quantiles.checkIndex(iArr[i3], i);
                i2 = i3 + 1;
            }
            Preconditions.checkArgument(iArr.length > 0 ? true : z, "Indexes must be a non empty array");
            this.scale = i;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            int[] iArr;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i : this.indexes) {
                    linkedHashMap.put(Integer.valueOf(i), Double.valueOf(Double.NaN));
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= this.indexes.length) {
                    break;
                }
                long length = iArr[i2] * (dArr.length - 1);
                int divide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
                int i4 = (int) (length - (divide * this.scale));
                iArr3[i2] = divide;
                iArr4[i2] = i4;
                iArr5[i3] = divide;
                int i5 = i3 + 1;
                i3 = i5;
                if (i4 != 0) {
                    iArr5[i5] = divide + 1;
                    i3 = i5 + 1;
                }
                i2++;
            }
            Arrays.sort(iArr5, 0, i3);
            Quantiles.selectAllInPlace(iArr5, 0, i3 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                int[] iArr6 = this.indexes;
                if (i7 >= iArr6.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i8 = iArr3[i7];
                int i9 = iArr4[i7];
                if (i9 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i7]), Double.valueOf(dArr[i8]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i7]), Double.valueOf(Quantiles.interpolate(dArr[i8], dArr[i8 + 1], i9, this.scale)));
                }
                i6 = i7 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIndex(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i2);
        }
    }

    private static int chooseNextSelection(int[] iArr, int i, int i2, int i3, int i4) {
        if (i == i2) {
            return i;
        }
        int i5 = i3 + i4;
        int i6 = i5 >>> 1;
        while (i2 > i + 1) {
            int i7 = (i + i2) >>> 1;
            if (iArr[i7] > i6) {
                i2 = i7;
            } else if (iArr[i7] >= i6) {
                return i7;
            } else {
                i = i7;
            }
        }
        return (i5 - iArr[i]) - iArr[i2] > 0 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (Double.isNaN(dArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double interpolate(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        } else if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else {
            return d + (((d2 - d) * d3) / d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return dArr;
            }
            dArr[i2] = iArr[i2];
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return dArr;
            }
            dArr[i2] = jArr[i2];
            i = i2 + 1;
        }
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i, int i2) {
        boolean z = true;
        int i3 = (i + i2) >>> 1;
        boolean z2 = dArr[i2] < dArr[i3];
        boolean z3 = dArr[i3] < dArr[i];
        if (dArr[i2] >= dArr[i]) {
            z = false;
        }
        if (z2 == z3) {
            swap(dArr, i3, i);
        } else if (z2 != z) {
            swap(dArr, i, i2);
        }
    }

    private static int partition(double[] dArr, int i, int i2) {
        movePivotToStartOfSlice(dArr, i, i2);
        double d = dArr[i];
        int i3 = i2;
        while (true) {
            int i4 = i3;
            if (i2 <= i) {
                swap(dArr, i, i4);
                return i4;
            }
            int i5 = i4;
            if (dArr[i2] > d) {
                swap(dArr, i4, i2);
                i5 = i4 - 1;
            }
            i2--;
            i3 = i5;
        }
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i) {
        return new Scale(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5;
        int i6;
        int chooseNextSelection = chooseNextSelection(iArr, i, i2, i3, i4);
        int i7 = iArr[chooseNextSelection];
        selectInPlace(i7, dArr, i3, i4);
        int i8 = chooseNextSelection;
        while (true) {
            i5 = i8 - 1;
            if (i5 < i || iArr[i5] != i7) {
                break;
            }
            i8 = i5;
        }
        if (i5 >= i) {
            selectAllInPlace(iArr, i, i5, dArr, i3, i7 - 1);
        }
        int i9 = chooseNextSelection;
        while (true) {
            i6 = i9 + 1;
            if (i6 > i2 || iArr[i6] != i7) {
                break;
            }
            i9 = i6;
        }
        if (i6 <= i2) {
            selectAllInPlace(iArr, i6, i2, dArr, i7 + 1, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectInPlace(int i, double[] dArr, int i2, int i3) {
        int i4;
        int i5 = i2;
        int i6 = i3;
        if (i != i2) {
            while (i6 > i5) {
                int partition = partition(dArr, i5, i6);
                int i7 = i6;
                if (partition >= i) {
                    i7 = partition - 1;
                }
                i6 = i7;
                if (partition <= i) {
                    i5 = partition + 1;
                    i6 = i7;
                }
            }
            return;
        }
        int i8 = i2 + 1;
        int i9 = i2;
        while (true) {
            i4 = i9;
            if (i8 > i3) {
                break;
            }
            int i10 = i4;
            if (dArr[i4] > dArr[i8]) {
                i10 = i8;
            }
            i8++;
            i9 = i10;
        }
        if (i4 != i2) {
            swap(dArr, i4, i2);
        }
    }

    private static void swap(double[] dArr, int i, int i2) {
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
    }
}
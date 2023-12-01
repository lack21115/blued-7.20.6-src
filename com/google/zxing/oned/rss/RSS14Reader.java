package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/rss/RSS14Reader.class */
public final class RSS14Reader extends AbstractRSSReader {
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        boolean z;
        if (pair == null) {
            return;
        }
        Iterator<Pair> it = collection.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Pair next = it.next();
            if (next.getValue() == pair.getValue()) {
                next.incrementCount();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(pair);
    }

    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        if (z) {
            if (sum > 12) {
                z13 = false;
                z14 = true;
            } else {
                z13 = sum < 4;
                z14 = false;
            }
            if (sum2 > 12) {
                z8 = z13;
                z5 = z14;
                z9 = false;
                z11 = true;
                z10 = z8;
            } else {
                z4 = z13;
                z5 = z14;
                if (sum2 < 4) {
                    z7 = z13;
                    z6 = z14;
                    z9 = true;
                    z10 = z7;
                    z5 = z6;
                    z11 = false;
                }
                z9 = false;
                z10 = z4;
                z11 = false;
            }
        } else {
            if (sum > 11) {
                z2 = false;
                z3 = true;
            } else {
                z2 = sum < 5;
                z3 = false;
            }
            if (sum2 > 10) {
                z5 = z3;
                z8 = z2;
                z9 = false;
                z11 = true;
                z10 = z8;
            } else {
                z4 = z2;
                z5 = z3;
                if (sum2 < 4) {
                    z6 = z3;
                    z7 = z2;
                    z9 = true;
                    z10 = z7;
                    z5 = z6;
                    z11 = false;
                }
                z9 = false;
                z10 = z4;
                z11 = false;
            }
        }
        int i2 = (sum + sum2) - i;
        boolean z15 = (sum & 1) == z;
        boolean z16 = false;
        if ((sum2 & 1) == 1) {
            z16 = true;
        }
        if (i2 == 1) {
            if (z15) {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z12 = z10;
                z5 = true;
            } else if (!z16) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z12 = z10;
                z11 = true;
            }
        } else if (i2 == -1) {
            if (z15) {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z12 = true;
            } else if (!z16) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z12 = z10;
                z9 = true;
            }
        } else if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            if (z15) {
                if (!z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    z12 = true;
                    z11 = true;
                } else {
                    z9 = true;
                    z12 = z10;
                    z5 = true;
                }
            } else if (z16) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z12 = z10;
            }
        }
        if (z12) {
            if (z5) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z5) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z9) {
            if (z11) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z11) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = pair.getChecksumPortion();
        int checksumPortion2 = pair2.getChecksumPortion();
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        int i = value;
        if (value > 72) {
            i = value - 1;
        }
        int i2 = i;
        if (i > 8) {
            i2 = i - 1;
        }
        return (checksumPortion + (checksumPortion2 * 16)) % 79 == i2;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((pair.getValue() * 4537077) + pair2.getValue());
        StringBuilder sb = new StringBuilder(14);
        int i = 13;
        int length = valueOf.length();
        while (true) {
            int i2 = i - length;
            if (i2 <= 0) {
                break;
            }
            sb.append('0');
            i = i2;
            length = 1;
        }
        sb.append(valueOf);
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4) - '0';
            int i5 = charAt;
            if ((i4 & 1) == 0) {
                i5 = charAt * 3;
            }
            i3 += i5;
        }
        int i6 = 10 - (i3 % 10);
        int i7 = i6;
        if (i6 == 10) {
            i7 = 0;
        }
        sb.append(i7);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(sb.toString(), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        int i;
        int[] dataCharacterCounters = getDataCharacterCounters();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= dataCharacterCounters.length) {
                break;
            }
            dataCharacterCounters[i3] = 0;
            i2 = i3 + 1;
        }
        if (z) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i4 = 0;
            for (int length = dataCharacterCounters.length - 1; i4 < length; length--) {
                int i5 = dataCharacterCounters[i4];
                dataCharacterCounters[i4] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i5;
                i4++;
            }
        }
        int i6 = z ? 16 : 15;
        float sum = MathUtils.sum(dataCharacterCounters) / i6;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= dataCharacterCounters.length) {
                break;
            }
            float f = dataCharacterCounters[i8] / sum;
            int i9 = (int) (0.5f + f);
            if (i9 <= 0) {
                i = 1;
            } else {
                i = i9;
                if (i9 > 8) {
                    i = 8;
                }
            }
            int i10 = i8 / 2;
            if ((i8 & 1) == 0) {
                oddCounts[i10] = i;
                oddRoundingErrors[i10] = f - i;
            } else {
                evenCounts[i10] = i;
                evenRoundingErrors[i10] = f - i;
            }
            i7 = i8 + 1;
        }
        adjustOddEvenCounts(z, i6);
        int i11 = 0;
        int i12 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            i11 = (i11 * 9) + oddCounts[length2];
            i12 += oddCounts[length2];
        }
        int i13 = 0;
        int i14 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i13 = (i13 * 9) + evenCounts[length3];
            i14 += evenCounts[length3];
        }
        int i15 = i11 + (i13 * 3);
        if (!z) {
            if ((i14 & 1) != 0 || i14 > 10 || i14 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i16 = (10 - i14) / 2;
            int i17 = INSIDE_ODD_WIDEST[i16];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i17, false) * INSIDE_ODD_TOTAL_SUBSET[i16]) + RSSUtils.getRSSvalue(oddCounts, i17, true) + INSIDE_GSUM[i16], i15);
        } else if ((i12 & 1) != 0 || i12 > 12 || i12 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i18 = (12 - i12) / 2;
            int i19 = OUTSIDE_ODD_WIDEST[i18];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i19, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i18]) + RSSUtils.getRSSvalue(evenCounts, 9 - i19, true) + OUTSIDE_GSUM[i18], i15);
        }
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = (findFinderPattern[0] + findFinderPattern[1]) / 2.0f;
                float f2 = f;
                if (z) {
                    f2 = (bitArray.getSize() - 1) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f2, i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, boolean z) throws NotFoundException {
        boolean z2;
        int i;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            z2 = z3;
            if (i2 >= size) {
                break;
            }
            boolean z4 = !bitArray.get(i2);
            z2 = z4;
            if (z == z4) {
                break;
            }
            i2++;
            z3 = z4;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = i2;
        while (i5 < size) {
            if (bitArray.get(i5) != z2) {
                decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
                i = i4;
            } else {
                if (i4 != 3) {
                    i = i4 + 1;
                } else if (isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i3, i5};
                } else {
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i = i4 - 1;
                }
                decodeFinderCounters[i] = 1;
                z2 = !z2;
            }
            i5++;
            i4 = i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int i2;
        int i3;
        boolean z2 = bitArray.get(iArr[0]);
        int i4 = iArr[0];
        while (true) {
            i2 = i4 - 1;
            if (i2 < 0 || z2 == bitArray.get(i2)) {
                break;
            }
            i4 = i2;
        }
        int i5 = i2 + 1;
        int i6 = iArr[0];
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy((Object) decodeFinderCounters, 0, (Object) decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i6 - i5;
        int parseFinderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i7 = iArr[1];
        if (z) {
            int size = bitArray.getSize();
            i7 = (bitArray.getSize() - 1) - i7;
            i3 = (size - 1) - i5;
        } else {
            i3 = i5;
        }
        return new FinderPattern(parseFinderValue, new int[]{i5, iArr[1]}, i3, i7, i);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        for (Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}

package com.sobot.chat.widget.zxing.oned.rss.expanded;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.ResultPoint;
import com.sobot.chat.widget.zxing.common.BitArray;
import com.sobot.chat.widget.zxing.common.detector.MathUtils;
import com.sobot.chat.widget.zxing.oned.rss.AbstractRSSReader;
import com.sobot.chat.widget.zxing.oned.rss.DataCharacter;
import com.sobot.chat.widget.zxing.oned.rss.FinderPattern;
import com.sobot.chat.widget.zxing.oned.rss.RSSUtils;
import com.sobot.chat.widget.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/expanded/RSSExpandedReader.class */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        boolean z6 = false;
        if (sum > 13) {
            z = false;
            z2 = true;
        } else {
            z = sum < 4;
            z2 = false;
        }
        if (sum2 > 13) {
            z3 = false;
            z4 = true;
        } else {
            z3 = sum2 < 4;
            z4 = false;
        }
        int i2 = (sum + sum2) - i;
        boolean z7 = (sum & 1) == 1;
        if ((sum2 & 1) == 0) {
            z6 = true;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z7) {
                    if (z6) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z5 = z;
                    z2 = true;
                } else if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z5 = z;
                    z4 = true;
                }
            } else if (z7) {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum < sum2) {
                    z5 = true;
                    z4 = true;
                } else {
                    z3 = true;
                    z5 = z;
                    z2 = true;
                }
            } else if (z6) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z5 = z;
            }
        } else if (z7) {
            if (z6) {
                throw NotFoundException.getNotFoundInstance();
            }
            z5 = true;
        } else if (!z6) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            z5 = z;
            z3 = true;
        }
        if (z5) {
            if (z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z2) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        boolean z = false;
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i = 2;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= this.pairs.size()) {
                break;
            }
            ExpandedPair expandedPair2 = this.pairs.get(i3);
            int checksumPortion2 = checksumPortion + expandedPair2.getLeftChar().getChecksumPortion();
            int i4 = i + 1;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            checksumPortion = checksumPortion2;
            i = i4;
            if (rightChar2 != null) {
                checksumPortion = checksumPortion2 + rightChar2.getChecksumPortion();
                i = i4 + 1;
            }
            i2 = i3 + 1;
        }
        if (((i - 4) * 211) + (checksumPortion % 211) == leftChar.getValue()) {
            z = true;
        }
        return z;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            for (ExpandedRow expandedRow2 : list) {
                this.pairs.addAll(expandedRow2.getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException e) {
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException e) {
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean z = list.size() % 2 != 0;
        boolean z2 = z;
        if (this.startFromEven) {
            z2 = !z;
        }
        boolean z3 = false;
        while (i < size) {
            z3 = !bitArray.get(i);
            if (!z3) {
                break;
            }
            i++;
        }
        int i2 = 0;
        int i3 = i;
        for (int i4 = i; i4 < size; i4++) {
            if (bitArray.get(i4) != z3) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z2) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i3;
                        iArr[1] = i4;
                        return;
                    }
                    if (z2) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z3 = !z3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        return bitArray.get(i) ? bitArray.getNextSet(bitArray.getNextUnset(i)) : bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z;
        boolean z2;
        for (ExpandedRow expandedRow : iterable2) {
            Iterator<ExpandedPair> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                ExpandedPair next = it.next();
                Iterator<ExpandedPair> it2 = expandedRow.getPairs().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (next.equals(it2.next())) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        boolean z;
        int[][] iArr = FINDER_PATTERN_SEQUENCES;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            int[] iArr2 = iArr[i2];
            if (list.size() <= iArr2.length) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i4).getFinderPattern().getValue() != iArr2[i4]) {
                        z = false;
                        break;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                if (z) {
                    return true;
                }
            }
            i = i2 + 1;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.startEnd[0];
            while (true) {
                i5 = i6 - 1;
                if (i5 < 0 || bitArray.get(i5)) {
                    break;
                }
                i6 = i5;
            }
            i2 = i5 + 1;
            int[] iArr = this.startEnd;
            i4 = iArr[0] - i2;
            i3 = iArr[1];
        } else {
            int[] iArr2 = this.startEnd;
            i2 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i3 = nextUnset;
            i4 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy((Object) decodeFinderCounters, 0, (Object) decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i2, i3}, i2, i3, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private static void removePartialRows(Collection<ExpandedPair> collection, Collection<ExpandedRow> collection2) {
        boolean z;
        Iterator<ExpandedRow> it = collection2.iterator();
        while (it.hasNext()) {
            ExpandedRow next = it.next();
            if (next.getPairs().size() != collection.size()) {
                Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    z = true;
                    if (!it2.hasNext()) {
                        break;
                    } else if (!collection.contains(it2.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length / 2) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
            i = i2 + 1;
        }
    }

    private void storeRow(int i, boolean z) {
        boolean z2;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            z2 = false;
            if (i2 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z3 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (z2 || z3 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
        removePartialRows(this.pairs, this.rows);
    }

    DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int i;
        int i2;
        int[] dataCharacterCounters = getDataCharacterCounters();
        Arrays.fill(dataCharacterCounters, 0);
        if (z2) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i3 = 0;
            for (int length = dataCharacterCounters.length - 1; i3 < length; length--) {
                int i4 = dataCharacterCounters[i3];
                dataCharacterCounters[i3] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i4;
                i3++;
            }
        }
        float sum = MathUtils.sum(dataCharacterCounters) / 17;
        float f = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(sum - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= dataCharacterCounters.length) {
                adjustOddEvenCounts(17);
                int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
                int length2 = oddCounts.length - 1;
                int i7 = 0;
                int i8 = 0;
                while (length2 >= 0) {
                    int i9 = i7;
                    if (isNotA1left(finderPattern, z, z2)) {
                        i9 = i7 + (oddCounts[length2] * WEIGHTS[value][length2 * 2]);
                    }
                    i8 += oddCounts[length2];
                    length2--;
                    i7 = i9;
                }
                int length3 = evenCounts.length - 1;
                int i10 = 0;
                while (true) {
                    i = i10;
                    if (length3 < 0) {
                        break;
                    }
                    int i11 = i;
                    if (isNotA1left(finderPattern, z, z2)) {
                        i11 = i + (evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1]);
                    }
                    length3--;
                    i10 = i11;
                }
                if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i12 = (13 - i8) / 2;
                int i13 = SYMBOL_WIDEST[i12];
                return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i13, true) * EVEN_TOTAL_SUBSET[i12]) + RSSUtils.getRSSvalue(evenCounts, 9 - i13, false) + GSUM[i12], i7 + i);
            }
            float f2 = (dataCharacterCounters[i6] * 1.0f) / sum;
            int i14 = (int) (0.5f + f2);
            if (i14 >= 1) {
                i2 = i14;
                if (i14 > 8) {
                    if (f2 > 8.7f) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    i2 = 8;
                }
            } else if (f2 < 0.3f) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                i2 = 1;
            }
            int i15 = i6 / 2;
            if ((i6 & 1) == 0) {
                oddCounts[i15] = i2;
                oddRoundingErrors[i15] = f2 - i2;
            } else {
                evenCounts[i15] = i2;
                evenRoundingErrors[i15] = f2 - i2;
            }
            i5 = i6 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException e) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        boolean z = false;
        while (!z) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (checkChecksum()) {
            return this.pairs;
        }
        boolean isEmpty = this.rows.isEmpty();
        storeRow(i, false);
        if (!isEmpty) {
            List<ExpandedPair> checkRows = checkRows(false);
            if (checkRows != null) {
                return checkRows;
            }
            List<ExpandedPair> checkRows2 = checkRows(true);
            if (checkRows2 != null) {
                return checkRows2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    List<ExpandedRow> getRows() {
        return this.rows;
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDReader, com.sobot.chat.widget.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        boolean z;
        DataCharacter dataCharacter;
        boolean z2 = list.size() % 2 == 0;
        boolean z3 = z2;
        if (this.startFromEven) {
            z3 = !z2;
        }
        int i2 = -1;
        boolean z4 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z3);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                z = z4;
            } else {
                z = false;
            }
            z4 = z;
        } while (z);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z3, true);
        if (list.isEmpty() || !list.get(list.size() - 1).mustBeLast()) {
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z3, false);
            } catch (NotFoundException e) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

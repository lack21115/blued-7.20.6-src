package com.sobot.chat.widget.zxing.aztec.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/aztec/encoder/HighLevelEncoder.class */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;
    static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX WARN: Type inference failed for: r0v3, types: [int[], int[][]] */
    static {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, 5, 256);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        int i = 65;
        while (true) {
            int i2 = i;
            if (i2 > 90) {
                break;
            }
            CHAR_MAP[0][i2] = (i2 - 65) + 2;
            i = i2 + 1;
        }
        CHAR_MAP[1][32] = 1;
        int i3 = 97;
        while (true) {
            int i4 = i3;
            if (i4 > 122) {
                break;
            }
            CHAR_MAP[1][i4] = (i4 - 97) + 2;
            i3 = i4 + 1;
        }
        CHAR_MAP[2][32] = 1;
        int i5 = 48;
        while (true) {
            int i6 = i5;
            if (i6 > 57) {
                break;
            }
            CHAR_MAP[2][i6] = (i6 - 48) + 2;
            i5 = i6 + 1;
        }
        int[][] iArr2 = CHAR_MAP;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 28) {
                break;
            }
            CHAR_MAP[3][new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127}[i8]] = i8;
            i7 = i8 + 1;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 31) {
                break;
            }
            if (iArr3[i10] > 0) {
                CHAR_MAP[4][iArr3[i10]] = i10;
            }
            i9 = i10 + 1;
        }
        int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, 6, 6);
        SHIFT_TABLE = iArr4;
        int length = iArr4.length;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= length) {
                int[][] iArr5 = SHIFT_TABLE;
                iArr5[0][4] = 0;
                iArr5[1][4] = 0;
                iArr5[1][0] = 28;
                iArr5[3][4] = 0;
                iArr5[2][4] = 0;
                iArr5[2][0] = 15;
                return;
            }
            Arrays.fill(iArr4[i12], -1);
            i11 = i12 + 1;
        }
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    private static Collection<State> simplifyStates(Iterable<State> iterable) {
        boolean z;
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    z = false;
                    break;
                } else if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i, Collection<State> collection) {
        char c2 = (char) (this.text[i] & 255);
        int i2 = 0;
        boolean z = CHAR_MAP[state.getMode()][c2] > 0;
        State state2 = null;
        while (true) {
            State state3 = state2;
            if (i2 > 4) {
                break;
            }
            int i3 = CHAR_MAP[i2][c2];
            State state4 = state3;
            if (i3 > 0) {
                State state5 = state3;
                if (state3 == null) {
                    state5 = state.endBinaryShift(i);
                }
                if (!z || i2 == state.getMode() || i2 == 2) {
                    collection.add(state5.latchAndAppend(i2, i3));
                }
                state4 = state5;
                if (!z) {
                    state4 = state5;
                    if (SHIFT_TABLE[state.getMode()][i2] >= 0) {
                        collection.add(state5.shiftAndAppend(i2, i3));
                        state4 = state5;
                    }
                }
            }
            i2++;
            state2 = state4;
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c2] == 0) {
            collection.add(state.addBinaryShiftChar(i));
        }
    }

    private static void updateStateForPair(State state, int i, int i2, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i);
        collection.add(endBinaryShift.latchAndAppend(4, i2));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i2).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i).addBinaryShiftChar(i + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForChar(state, i, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static Collection<State> updateStateListForPair(Iterable<State> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            updateStateForPair(state, i, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.chat.widget.zxing.common.BitArray encode() {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.aztec.encoder.HighLevelEncoder.encode():com.sobot.chat.widget.zxing.common.BitArray");
    }
}

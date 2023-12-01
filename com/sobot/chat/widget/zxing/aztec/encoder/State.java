package com.sobot.chat.widget.zxing.aztec.encoder;

import com.sobot.chat.widget.zxing.common.BitArray;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/aztec/encoder/State.class */
public final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    private static int calculateBinaryShiftCost(State state) {
        int i = state.binaryShiftByteCount;
        if (i > 62) {
            return 21;
        }
        if (i > 31) {
            return 20;
        }
        return i > 0 ? 10 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
        if (r0 == 2) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.chat.widget.zxing.aztec.encoder.State addBinaryShiftChar(int r9) {
        /*
            r8 = this;
            r0 = r8
            com.sobot.chat.widget.zxing.aztec.encoder.Token r0 = r0.token
            r15 = r0
            r0 = r8
            int r0 = r0.mode
            r13 = r0
            r0 = r8
            int r0 = r0.bitCount
            r10 = r0
            r0 = r13
            r1 = 4
            if (r0 == r1) goto L27
            r0 = r15
            r14 = r0
            r0 = r13
            r12 = r0
            r0 = r10
            r11 = r0
            r0 = r13
            r1 = 2
            if (r0 != r1) goto L4b
        L27:
            int[][] r0 = com.sobot.chat.widget.zxing.aztec.encoder.HighLevelEncoder.LATCH_TABLE
            r1 = r13
            r0 = r0[r1]
            r1 = 0
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            r1 = 16
            int r0 = r0 >> r1
            r12 = r0
            r0 = r15
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = r11
            r1 = r1 & r2
            r2 = r12
            com.sobot.chat.widget.zxing.aztec.encoder.Token r0 = r0.add(r1, r2)
            r14 = r0
            r0 = r10
            r1 = r12
            int r0 = r0 + r1
            r11 = r0
            r0 = 0
            r12 = r0
        L4b:
            r0 = r8
            int r0 = r0.binaryShiftByteCount
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L6f
            r0 = r10
            r1 = 31
            if (r0 != r1) goto L5d
            goto L6f
        L5d:
            r0 = r10
            r1 = 62
            if (r0 != r1) goto L69
            r0 = 9
            r10 = r0
            goto L72
        L69:
            r0 = 8
            r10 = r0
            goto L72
        L6f:
            r0 = 18
            r10 = r0
        L72:
            com.sobot.chat.widget.zxing.aztec.encoder.State r0 = new com.sobot.chat.widget.zxing.aztec.encoder.State
            r1 = r0
            r2 = r14
            r3 = r12
            r4 = r8
            int r4 = r4.binaryShiftByteCount
            r5 = 1
            int r4 = r4 + r5
            r5 = r11
            r6 = r10
            int r5 = r5 + r6
            r1.<init>(r2, r3, r4, r5)
            r15 = r0
            r0 = r15
            r14 = r0
            r0 = r15
            int r0 = r0.binaryShiftByteCount
            r1 = 2078(0x81e, float:2.912E-42)
            if (r0 != r1) goto La1
            r0 = r15
            r1 = r9
            r2 = 1
            int r1 = r1 + r2
            com.sobot.chat.widget.zxing.aztec.encoder.State r0 = r0.endBinaryShift(r1)
            r14 = r0
        La1:
            r0 = r14
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.aztec.encoder.State.addBinaryShiftChar(int):com.sobot.chat.widget.zxing.aztec.encoder.State");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State endBinaryShift(int i) {
        int i2 = this.binaryShiftByteCount;
        return i2 == 0 ? this : new State(this.token.addBinaryShift(i - i2, i2), this.mode, 0, this.bitCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitCount() {
        return this.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    Token getToken() {
        return this.token;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterThanOrEqualTo(State state) {
        int i;
        int i2 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i3 = this.binaryShiftByteCount;
        int i4 = state.binaryShiftByteCount;
        if (i3 < i4) {
            i = i2 + (calculateBinaryShiftCost(state) - calculateBinaryShiftCost(this));
        } else {
            i = i2;
            if (i3 > i4) {
                i = i2;
                if (i4 > 0) {
                    i = i2 + 10;
                }
            }
        }
        return i <= state.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State latchAndAppend(int i, int i2) {
        int i3 = this.bitCount;
        Token token = this.token;
        int i4 = i3;
        Token token2 = token;
        if (i != this.mode) {
            int i5 = HighLevelEncoder.LATCH_TABLE[this.mode][i];
            int i6 = i5 >> 16;
            token2 = token.add(65535 & i5, i6);
            i4 = i3 + i6;
        }
        int i7 = i == 2 ? 4 : 5;
        return new State(token2.add(i2, i7), i, 0, i4 + i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State shiftAndAppend(int i, int i2) {
        Token token = this.token;
        int i3 = this.mode == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i], i3).add(i2, 5), this.mode, 0, this.bitCount + i3 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList();
        Token token = endBinaryShift(bArr.length).token;
        while (true) {
            Token token2 = token;
            if (token2 == null) {
                break;
            }
            linkedList.addFirst(token2);
            token = token2.getPrevious();
        }
        BitArray bitArray = new BitArray();
        for (Token token3 : linkedList) {
            token3.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}

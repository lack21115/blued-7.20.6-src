package com.sobot.chat.widget.zxing.qrcode.decoder;

import com.blued.das.live.LiveProtos;
import com.tencent.rtmp.TXLiveConstants;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/decoder/FormatInformation.class */
final class FormatInformation {
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{FORMAT_INFO_MASK_QR, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{LiveProtos.Event.LIVE_PK_MORE_EXIT_BTN_SHOW_VALUE, 21}, new int[]{3340, 22}, new int[]{TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    private FormatInformation(int i) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.dataMask = (byte) (i & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormatInformation decodeFormatInformation(int i, int i2) {
        FormatInformation doDecodeFormatInformation = doDecodeFormatInformation(i, i2);
        return doDecodeFormatInformation != null ? doDecodeFormatInformation : doDecodeFormatInformation(i ^ FORMAT_INFO_MASK_QR, i2 ^ FORMAT_INFO_MASK_QR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0090, code lost:
        return new com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation(r0[1]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation doDecodeFormatInformation(int r5, int r6) {
        /*
            int[][] r0 = com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation.FORMAT_INFO_DECODE_LOOKUP
            r14 = r0
            r0 = r14
            int r0 = r0.length
            r13 = r0
            r0 = 2147483647(0x7fffffff, float:NaN)
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = 0
            r8 = r0
        L13:
            r0 = r11
            r1 = r13
            if (r0 >= r1) goto L91
            r0 = r14
            r1 = r11
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            r1 = 0
            r0 = r0[r1]
            r12 = r0
            r0 = r12
            r1 = r5
            if (r0 == r1) goto L85
            r0 = r12
            r1 = r6
            if (r0 != r1) goto L36
            goto L85
        L36:
            r0 = r5
            r1 = r12
            int r0 = numBitsDiffering(r0, r1)
            r9 = r0
            r0 = r10
            r7 = r0
            r0 = r9
            r1 = r10
            if (r0 >= r1) goto L50
            r0 = r15
            r1 = 1
            r0 = r0[r1]
            r8 = r0
            r0 = r9
            r7 = r0
        L50:
            r0 = r7
            r10 = r0
            r0 = r8
            r9 = r0
            r0 = r5
            r1 = r6
            if (r0 == r1) goto L79
            r0 = r6
            r1 = r12
            int r0 = numBitsDiffering(r0, r1)
            r12 = r0
            r0 = r7
            r10 = r0
            r0 = r8
            r9 = r0
            r0 = r12
            r1 = r7
            if (r0 >= r1) goto L79
            r0 = r15
            r1 = 1
            r0 = r0[r1]
            r9 = r0
            r0 = r12
            r10 = r0
        L79:
            r0 = r11
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
            r0 = r9
            r8 = r0
            goto L13
        L85:
            com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation r0 = new com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation
            r1 = r0
            r2 = r15
            r3 = 1
            r2 = r2[r3]
            r1.<init>(r2)
            return r0
        L91:
            r0 = r10
            r1 = 3
            if (r0 > r1) goto La0
            com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation r0 = new com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            return r0
        La0:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation.doDecodeFormatInformation(int, int):com.sobot.chat.widget.zxing.qrcode.decoder.FormatInformation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int numBitsDiffering(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FormatInformation) {
            FormatInformation formatInformation = (FormatInformation) obj;
            boolean z = false;
            if (this.errorCorrectionLevel == formatInformation.errorCorrectionLevel) {
                z = false;
                if (this.dataMask == formatInformation.dataMask) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte getDataMask() {
        return this.dataMask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }
}

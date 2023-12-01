package com.sobot.chat.widget.zxing.qrcode.detector;

import com.sobot.chat.widget.zxing.ResultPoint;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/detector/AlignmentPattern.class */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPattern(float f, float f2, float f3) {
        super(f, f2);
        this.estimatedModuleSize = f3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0043, code lost:
        if (r0 <= r3.estimatedModuleSize) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean aboutEquals(float r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = r5
            r1 = r3
            float r1 = r1.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r5 = r0
            r0 = 0
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r5
            r1 = r4
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L49
            r0 = r8
            r7 = r0
            r0 = r6
            r1 = r3
            float r1 = r1.getX()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r1 = r4
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L49
            r0 = r4
            r1 = r3
            float r1 = r1.estimatedModuleSize
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            r4 = r0
            r0 = r4
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L46
            r0 = r8
            r7 = r0
            r0 = r4
            r1 = r3
            float r1 = r1.estimatedModuleSize
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L49
        L46:
            r0 = 1
            r7 = r0
        L49:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.qrcode.detector.AlignmentPattern.aboutEquals(float, float, float):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlignmentPattern combineEstimate(float f, float f2, float f3) {
        return new AlignmentPattern((getX() + f2) / 2.0f, (getY() + f) / 2.0f, (this.estimatedModuleSize + f3) / 2.0f);
    }
}

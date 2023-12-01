package com.sobot.chat.widget.zxing.oned.rss;

import com.sobot.chat.widget.zxing.ResultPoint;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/FinderPattern.class */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.value = i;
        this.startEnd = iArr;
        float f = i4;
        this.resultPoints = new ResultPoint[]{new ResultPoint(i2, f), new ResultPoint(i3, f)};
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof FinderPattern) {
            if (this.value == ((FinderPattern) obj).value) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}

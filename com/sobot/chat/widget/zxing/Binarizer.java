package com.sobot.chat.widget.zxing;

import com.sobot.chat.widget.zxing.common.BitArray;
import com.sobot.chat.widget.zxing.common.BitMatrix;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/Binarizer.class */
public abstract class Binarizer {
    private final LuminanceSource source;

    public Binarizer(LuminanceSource luminanceSource) {
        this.source = luminanceSource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    public abstract BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException;

    public final int getHeight() {
        return this.source.getHeight();
    }

    public final LuminanceSource getLuminanceSource() {
        return this.source;
    }

    public final int getWidth() {
        return this.source.getWidth();
    }
}

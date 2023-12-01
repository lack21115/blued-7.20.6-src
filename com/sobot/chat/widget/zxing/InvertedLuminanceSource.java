package com.sobot.chat.widget.zxing;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/InvertedLuminanceSource.class */
public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new InvertedLuminanceSource(this.delegate.crop(i, i2, i3, i4));
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= width) {
                return bArr;
            }
            bArr[i2] = (byte) (255 - (matrix[i2] & 255));
            i = i2 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        byte[] row = this.delegate.getRow(i, bArr);
        int width = getWidth();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= width) {
                return row;
            }
            row[i3] = (byte) (255 - (row[i3] & 255));
            i2 = i3 + 1;
        }
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public LuminanceSource invert() {
        return this.delegate;
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    @Override // com.sobot.chat.widget.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}

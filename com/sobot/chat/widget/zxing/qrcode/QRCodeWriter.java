package com.sobot.chat.widget.zxing.qrcode;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.EncodeHintType;
import com.sobot.chat.widget.zxing.Writer;
import com.sobot.chat.widget.zxing.WriterException;
import com.sobot.chat.widget.zxing.common.BitMatrix;
import com.sobot.chat.widget.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sobot.chat.widget.zxing.qrcode.encoder.ByteMatrix;
import com.sobot.chat.widget.zxing.qrcode.encoder.Encoder;
import com.sobot.chat.widget.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/qrcode/QRCodeWriter.class */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i, int i2, int i3) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int i4 = i3 * 2;
            int i5 = width + i4;
            int i6 = i4 + height;
            int max = Math.max(i, i5);
            int max2 = Math.max(i2, i6);
            int min = Math.min(max / i5, max2 / i6);
            int i7 = (max - (width * min)) / 2;
            int i8 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i9 = 0;
            while (i9 < height) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < width) {
                    if (matrix.get(i11, i9) == 1) {
                        bitMatrix.setRegion(i10, i8, min, min);
                    }
                    i11++;
                    i10 += min;
                }
                i9++;
                i8 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    @Override // com.sobot.chat.widget.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.sobot.chat.widget.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i3 = 4;
            ErrorCorrectionLevel errorCorrectionLevel2 = errorCorrectionLevel;
            if (map != null) {
                if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                i3 = 4;
                errorCorrectionLevel2 = errorCorrectionLevel;
                if (map.containsKey(EncodeHintType.MARGIN)) {
                    i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                    errorCorrectionLevel2 = errorCorrectionLevel;
                }
            }
            return renderResult(Encoder.encode(str, errorCorrectionLevel2, map), i, i2, i3);
        }
    }
}

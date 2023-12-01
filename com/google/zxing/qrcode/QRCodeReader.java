package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/qrcode/QRCodeReader.class */
public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        int i6 = i4;
        if (i5 != i4 - i3) {
            i6 = i3 + i5;
            if (i6 >= bitMatrix.getWidth()) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        int round = Math.round(((i6 - i3) + 1) / moduleSize);
        int round2 = Math.round((i5 + 1) / moduleSize);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = (int) (moduleSize / 2.0f);
        int i8 = i + i7;
        int i9 = i3 + i7;
        int i10 = (((int) ((round - 1) * moduleSize)) + i9) - i6;
        int i11 = i9;
        if (i10 > 0) {
            if (i10 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i11 = i9 - i10;
        }
        int i12 = (((int) ((round2 - 1) * moduleSize)) + i8) - i2;
        int i13 = i8;
        if (i12 > 0) {
            if (i12 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i13 = i8 - i12;
        }
        BitMatrix bitMatrix2 = new BitMatrix(round, round2);
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= round2) {
                return bitMatrix2;
            }
            int i16 = (int) (i15 * moduleSize);
            int i17 = 0;
            while (true) {
                int i18 = i17;
                if (i18 < round) {
                    if (bitMatrix.get(((int) (i18 * moduleSize)) + i11, i16 + i13)) {
                        bitMatrix2.set(i18, i15);
                    }
                    i17 = i18 + 1;
                }
            }
            i14 = i15 + 1;
        }
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i >= width || i2 >= height) {
                break;
            }
            boolean z2 = z;
            int i5 = i4;
            if (z != bitMatrix.get(i, i2)) {
                i5 = i4 + 1;
                if (i5 == 5) {
                    break;
                }
                z2 = !z;
            }
            i++;
            i2++;
            z = z2;
            i3 = i5;
        }
        if (i == width || i2 == height) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        DecoderResult decode;
        ResultPoint[] points;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            decode = this.decoder.decode(detect.getBits(), map);
            points = detect.getPoints();
        } else {
            decode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        }
        if (decode.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decode.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}

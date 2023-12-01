package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/datamatrix/DataMatrixWriter.class */
public final class DataMatrixWriter implements Writer {
    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix, int i, int i2) {
        BitMatrix bitMatrix;
        int i3;
        int i4;
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int max = Math.max(i, width);
        int max2 = Math.max(i2, height);
        int min = Math.min(max / width, max2 / height);
        int i5 = (max - (width * min)) / 2;
        int i6 = (max2 - (height * min)) / 2;
        if (i2 < height || i < width) {
            bitMatrix = new BitMatrix(width, height);
            i3 = 0;
            i4 = 0;
        } else {
            bitMatrix = new BitMatrix(i, i2);
            i3 = i5;
            i4 = i6;
        }
        bitMatrix.clear();
        int i7 = 0;
        while (i7 < height) {
            int i8 = i3;
            int i9 = 0;
            while (i9 < width) {
                if (byteMatrix.get(i9, i7) == 1) {
                    bitMatrix.setRegion(i8, i4, min, min);
                }
                i9++;
                i8 += min;
            }
            i7++;
            i4 += min;
        }
        return bitMatrix;
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo, int i, int i2) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i3 = 0;
        for (int i4 = 0; i4 < symbolDataHeight; i4++) {
            int i5 = i3;
            if (i4 % symbolInfo.matrixHeight == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < symbolInfo.getSymbolWidth(); i7++) {
                    byteMatrix.set(i6, i3, i7 % 2 == 0);
                    i6++;
                }
                i5 = i3 + 1;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < symbolDataWidth; i9++) {
                int i10 = i8;
                if (i9 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i8, i5, true);
                    i10 = i8 + 1;
                }
                byteMatrix.set(i10, i5, defaultPlacement.getBit(i9, i4));
                int i11 = i10 + 1;
                i8 = i11;
                if (i9 % symbolInfo.matrixWidth == symbolInfo.matrixWidth - 1) {
                    byteMatrix.set(i11, i5, i4 % 2 == 0);
                    i8 = i11 + 1;
                }
            }
            int i12 = i5 + 1;
            i3 = i12;
            if (i4 % symbolInfo.matrixHeight == symbolInfo.matrixHeight - 1) {
                int i13 = 0;
                for (int i14 = 0; i14 < symbolInfo.getSymbolWidth(); i14++) {
                    byteMatrix.set(i13, i12, true);
                    i13++;
                }
                i3 = i12 + 1;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix, i, i2);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat == BarcodeFormat.DATA_MATRIX) {
            if (i < 0 || i2 < 0) {
                throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
            }
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                dimension2 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension2 == null) {
                    dimension2 = null;
                }
                dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension == null) {
                    dimension = null;
                }
            } else {
                dimension = null;
            }
            String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
            SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            return encodeLowLevel(defaultPlacement, lookup, i, i2);
        }
        throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
    }
}

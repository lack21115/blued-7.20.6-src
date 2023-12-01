package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/multi/GenericMultipleBarcodeReader.class */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        boolean z;
        if (i3 > 4) {
            return;
        }
        try {
            Result decode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getText().equals(decode.getText())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                list.add(translateResultPoints(decode, i, i2));
            }
            ResultPoint[] resultPoints = decode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f = width;
            float f2 = height;
            int length = resultPoints.length;
            float f3 = 0.0f;
            float f4 = 0.0f;
            int i4 = 0;
            while (i4 < length) {
                ResultPoint resultPoint = resultPoints[i4];
                float f5 = f;
                float f6 = f3;
                float f7 = f2;
                float f8 = f4;
                if (resultPoint != null) {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    float f9 = f;
                    if (x < f) {
                        f9 = x;
                    }
                    float f10 = f2;
                    if (y < f2) {
                        f10 = y;
                    }
                    float f11 = f3;
                    if (x > f3) {
                        f11 = x;
                    }
                    f5 = f9;
                    f6 = f11;
                    f7 = f10;
                    f8 = f4;
                    if (y > f4) {
                        f8 = y;
                        f7 = f10;
                        f6 = f11;
                        f5 = f9;
                    }
                }
                i4++;
                f = f5;
                f3 = f6;
                f2 = f7;
                f4 = f8;
            }
            if (f > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f, height), map, list, i, i2, i3 + 1);
            }
            if (f2 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int) f2), map, list, i, i2, i3 + 1);
            }
            if (f3 < width - 100) {
                int i5 = (int) f3;
                doDecodeMultiple(binaryBitmap.crop(i5, 0, width - i5, height), map, list, i + i5, i2, i3 + 1);
            }
            if (f4 < height - 100) {
                int i6 = (int) f4;
                doDecodeMultiple(binaryBitmap.crop(0, i6, width, height - i6), map, list, i, i2 + i6, i3 + 1);
            }
        } catch (ReaderException e) {
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= resultPoints.length) {
                Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
                result2.putAllMetadata(result.getResultMetadata());
                return result2;
            }
            ResultPoint resultPoint = resultPoints[i4];
            if (resultPoint != null) {
                resultPointArr[i4] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }
}

package com.sobot.chat.widget.zxing.multi;

import com.sobot.chat.widget.zxing.BinaryBitmap;
import com.sobot.chat.widget.zxing.DecodeHintType;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.Reader;
import com.sobot.chat.widget.zxing.ReaderException;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/multi/GenericMultipleBarcodeReader.class */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        boolean z;
        float f;
        float f2;
        float f3;
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
            float f4 = width;
            float f5 = height;
            int length = resultPoints.length;
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i4 = 0;
            while (i4 < length) {
                ResultPoint resultPoint = resultPoints[i4];
                if (resultPoint == null) {
                    f = f4;
                    f2 = f5;
                    f3 = f7;
                } else {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    float f8 = f4;
                    if (x < f4) {
                        f8 = x;
                    }
                    float f9 = f5;
                    if (y < f5) {
                        f9 = y;
                    }
                    float f10 = f6;
                    if (x > f6) {
                        f10 = x;
                    }
                    f = f8;
                    f6 = f10;
                    f2 = f9;
                    f3 = f7;
                    if (y > f7) {
                        f3 = y;
                        f2 = f9;
                        f6 = f10;
                        f = f8;
                    }
                }
                i4++;
                f4 = f;
                f5 = f2;
                f7 = f3;
            }
            if (f4 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f4, height), map, list, i, i2, i3 + 1);
            }
            if (f5 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int) f5), map, list, i, i2, i3 + 1);
            }
            if (f6 < width - 100) {
                int i5 = (int) f6;
                doDecodeMultiple(binaryBitmap.crop(i5, 0, width - i5, height), map, list, i + i5, i2, i3 + 1);
            }
            if (f7 < height - 100) {
                int i6 = (int) f7;
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

    @Override // com.sobot.chat.widget.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.sobot.chat.widget.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }
}

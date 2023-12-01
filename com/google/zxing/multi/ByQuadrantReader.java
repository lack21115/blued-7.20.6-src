package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/multi/ByQuadrantReader.class */
public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    private static void makeAbsolute(ResultPoint[] resultPointArr, int i, int i2) {
        if (resultPointArr == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= resultPointArr.length) {
                return;
            }
            ResultPoint resultPoint = resultPointArr[i4];
            resultPointArr[i4] = new ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            i3 = i4 + 1;
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
        } catch (NotFoundException e) {
            try {
                Result decode = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
                makeAbsolute(decode.getResultPoints(), width, 0);
                return decode;
            } catch (NotFoundException e2) {
                try {
                    Result decode2 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                    makeAbsolute(decode2.getResultPoints(), 0, height);
                    return decode2;
                } catch (NotFoundException e3) {
                    try {
                        Result decode3 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                        makeAbsolute(decode3.getResultPoints(), width, height);
                        return decode3;
                    } catch (NotFoundException e4) {
                        int i = width / 2;
                        int i2 = height / 2;
                        Result decode4 = this.delegate.decode(binaryBitmap.crop(i, i2, width, height), map);
                        makeAbsolute(decode4.getResultPoints(), i, i2);
                        return decode4;
                    }
                }
            }
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }
}

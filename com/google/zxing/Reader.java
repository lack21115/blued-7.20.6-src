package com.google.zxing;

import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/Reader.class */
public interface Reader {
    Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException;

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}

package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/multi/qrcode/QRCodeMultiReader.class */
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/google/zxing/multi/qrcode/QRCodeMultiReader$SAComparator.class */
    public static final class SAComparator implements Serializable, Comparator<Result> {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Result result, Result result2) {
            return Integer.compare(((Integer) result.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue(), ((Integer) result2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue());
        }
    }

    private static List<Result> processStructuredAppend(List<Result> list) {
        boolean z;
        Iterator<Result> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList<Result> arrayList2 = new ArrayList();
            for (Result result : list) {
                arrayList.add(result);
                if (result.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    arrayList2.add(result);
                }
            }
            Collections.sort(arrayList2, new SAComparator());
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int i2 = 0;
            for (Result result2 : arrayList2) {
                sb.append(result2.getText());
                int length = i + result2.getRawBytes().length;
                i = length;
                if (result2.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                    Iterator it2 = ((Iterable) result2.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
                    int i3 = i2;
                    while (true) {
                        int i4 = i3;
                        i = length;
                        i2 = i4;
                        if (it2.hasNext()) {
                            i3 = i4 + ((byte[]) it2.next()).length;
                        }
                    }
                }
            }
            byte[] bArr = new byte[i];
            byte[] bArr2 = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            for (Result result3 : arrayList2) {
                System.arraycopy((Object) result3.getRawBytes(), 0, (Object) bArr, i5, result3.getRawBytes().length);
                int length2 = i5 + result3.getRawBytes().length;
                i5 = length2;
                if (result3.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                    Iterator it3 = ((Iterable) result3.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
                    int i7 = i6;
                    while (true) {
                        int i8 = i7;
                        i5 = length2;
                        i6 = i8;
                        if (it3.hasNext()) {
                            byte[] bArr3 = (byte[]) it3.next();
                            System.arraycopy((Object) bArr3, 0, (Object) bArr2, i8, bArr3.length);
                            i7 = i8 + bArr3.length;
                        }
                    }
                }
            }
            Result result4 = new Result(sb.toString(), bArr, NO_POINTS, BarcodeFormat.QR_CODE);
            if (i2 > 0) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(bArr2);
                result4.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
            }
            arrayList.add(result4);
            return arrayList;
        }
        return list;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        DetectorResult[] detectMulti = new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map);
        int length = detectMulti.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            DetectorResult detectorResult = detectMulti[i2];
            try {
                DecoderResult decode = getDecoder().decode(detectorResult.getBits(), map);
                ResultPoint[] points = detectorResult.getPoints();
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
                arrayList.add(result);
            } catch (ReaderException e) {
            }
            i = i2 + 1;
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        List<Result> processStructuredAppend = processStructuredAppend(arrayList);
        return (Result[]) processStructuredAppend.toArray(new Result[processStructuredAppend.size()]);
    }
}

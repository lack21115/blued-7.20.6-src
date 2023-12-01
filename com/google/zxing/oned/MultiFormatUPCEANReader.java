package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/oned/MultiFormatUPCEANReader.class */
public final class MultiFormatUPCEANReader extends OneDReader {
    private final UPCEANReader[] readers;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new EAN13Reader());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new UPCAReader());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new EAN8Reader());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new EAN13Reader());
            arrayList.add(new EAN8Reader());
            arrayList.add(new UPCEReader());
        }
        this.readers = (UPCEANReader[]) arrayList.toArray(new UPCEANReader[arrayList.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        return r0;
     */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.Result decodeRow(int r8, com.google.zxing.common.BitArray r9, java.util.Map<com.google.zxing.DecodeHintType, ?> r10) throws com.google.zxing.NotFoundException {
        /*
            r7 = this;
            r0 = r9
            int[] r0 = com.google.zxing.oned.UPCEANReader.findStartGuardPattern(r0)
            r16 = r0
            r0 = r7
            com.google.zxing.oned.UPCEANReader[] r0 = r0.readers
            r17 = r0
            r0 = r17
            int r0 = r0.length
            r14 = r0
            r0 = 0
            r11 = r0
        L14:
            r0 = r11
            r1 = r14
            if (r0 >= r1) goto Lb2
            r0 = r17
            r1 = r11
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            r1 = r8
            r2 = r9
            r3 = r16
            r4 = r10
            com.google.zxing.Result r0 = r0.decodeRow(r1, r2, r3, r4)     // Catch: com.google.zxing.ReaderException -> Lb6
            r18 = r0
            r0 = r18
            com.google.zxing.BarcodeFormat r0 = r0.getBarcodeFormat()     // Catch: com.google.zxing.ReaderException -> Lb6
            com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.EAN_13     // Catch: com.google.zxing.ReaderException -> Lb6
            if (r0 != r1) goto Lbb
            r0 = r18
            java.lang.String r0 = r0.getText()     // Catch: com.google.zxing.ReaderException -> Lb6
            r1 = 0
            char r0 = r0.charAt(r1)     // Catch: com.google.zxing.ReaderException -> Lb6
            r1 = 48
            if (r0 != r1) goto Lbb
            r0 = 1
            r12 = r0
            goto Lbe
        L4d:
            r0 = r10
            com.google.zxing.DecodeHintType r1 = com.google.zxing.DecodeHintType.POSSIBLE_FORMATS     // Catch: com.google.zxing.ReaderException -> Lb6
            java.lang.Object r0 = r0.get(r1)     // Catch: com.google.zxing.ReaderException -> Lb6
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: com.google.zxing.ReaderException -> Lb6
            r15 = r0
        L5b:
            r0 = r15
            if (r0 == 0) goto Lce
            r0 = r15
            com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.UPC_A     // Catch: com.google.zxing.ReaderException -> Lb6
            boolean r0 = r0.contains(r1)     // Catch: com.google.zxing.ReaderException -> Lb6
            if (r0 == 0) goto Lc8
            goto Lce
        L70:
            r0 = r12
            if (r0 == 0) goto La6
            r0 = r13
            if (r0 == 0) goto La6
            com.google.zxing.Result r0 = new com.google.zxing.Result     // Catch: com.google.zxing.ReaderException -> Lb6
            r1 = r0
            r2 = r18
            java.lang.String r2 = r2.getText()     // Catch: com.google.zxing.ReaderException -> Lb6
            r3 = 1
            java.lang.String r2 = r2.substring(r3)     // Catch: com.google.zxing.ReaderException -> Lb6
            r3 = r18
            byte[] r3 = r3.getRawBytes()     // Catch: com.google.zxing.ReaderException -> Lb6
            r4 = r18
            com.google.zxing.ResultPoint[] r4 = r4.getResultPoints()     // Catch: com.google.zxing.ReaderException -> Lb6
            com.google.zxing.BarcodeFormat r5 = com.google.zxing.BarcodeFormat.UPC_A     // Catch: com.google.zxing.ReaderException -> Lb6
            r1.<init>(r2, r3, r4, r5)     // Catch: com.google.zxing.ReaderException -> Lb6
            r15 = r0
            r0 = r15
            r1 = r18
            java.util.Map r1 = r1.getResultMetadata()     // Catch: com.google.zxing.ReaderException -> Lb6
            r0.putAllMetadata(r1)     // Catch: com.google.zxing.ReaderException -> Lb6
            r0 = r15
            return r0
        La6:
            r0 = r18
            return r0
        La9:
            r0 = r11
            r1 = 1
            int r0 = r0 + r1
            r11 = r0
            goto L14
        Lb2:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        Lb6:
            r15 = move-exception
            goto La9
        Lbb:
            r0 = 0
            r12 = r0
        Lbe:
            r0 = r10
            if (r0 != 0) goto L4d
            r0 = 0
            r15 = r0
            goto L5b
        Lc8:
            r0 = 0
            r13 = r0
            goto L70
        Lce:
            r0 = 1
            r13 = r0
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.MultiFormatUPCEANReader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        UPCEANReader[] uPCEANReaderArr = this.readers;
        int length = uPCEANReaderArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            uPCEANReaderArr[i2].reset();
            i = i2 + 1;
        }
    }
}

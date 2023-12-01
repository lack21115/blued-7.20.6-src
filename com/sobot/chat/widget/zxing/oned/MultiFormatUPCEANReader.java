package com.sobot.chat.widget.zxing.oned;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/MultiFormatUPCEANReader.class */
public final class MultiFormatUPCEANReader extends OneDReader {
    private static final UPCEANReader[] EMPTY_READER_ARRAY = new UPCEANReader[0];
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
        this.readers = (UPCEANReader[]) arrayList.toArray(EMPTY_READER_ARRAY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        return r0;
     */
    @Override // com.sobot.chat.widget.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.chat.widget.zxing.Result decodeRow(int r8, com.sobot.chat.widget.zxing.common.BitArray r9, java.util.Map<com.sobot.chat.widget.zxing.DecodeHintType, ?> r10) throws com.sobot.chat.widget.zxing.NotFoundException {
        /*
            r7 = this;
            r0 = r9
            int[] r0 = com.sobot.chat.widget.zxing.oned.UPCEANReader.findStartGuardPattern(r0)
            r16 = r0
            r0 = r7
            com.sobot.chat.widget.zxing.oned.UPCEANReader[] r0 = r0.readers
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
            com.sobot.chat.widget.zxing.Result r0 = r0.decodeRow(r1, r2, r3, r4)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r18 = r0
            r0 = r18
            com.sobot.chat.widget.zxing.BarcodeFormat r0 = r0.getBarcodeFormat()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            com.sobot.chat.widget.zxing.BarcodeFormat r1 = com.sobot.chat.widget.zxing.BarcodeFormat.EAN_13     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            if (r0 != r1) goto Lbb
            r0 = r18
            java.lang.String r0 = r0.getText()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r1 = 0
            char r0 = r0.charAt(r1)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r1 = 48
            if (r0 != r1) goto Lbb
            r0 = 1
            r12 = r0
            goto Lbe
        L4d:
            r0 = r10
            com.sobot.chat.widget.zxing.DecodeHintType r1 = com.sobot.chat.widget.zxing.DecodeHintType.POSSIBLE_FORMATS     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            java.lang.Object r0 = r0.get(r1)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r15 = r0
        L5b:
            r0 = r15
            if (r0 == 0) goto Lce
            r0 = r15
            com.sobot.chat.widget.zxing.BarcodeFormat r1 = com.sobot.chat.widget.zxing.BarcodeFormat.UPC_A     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            boolean r0 = r0.contains(r1)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            if (r0 == 0) goto Lc8
            goto Lce
        L70:
            r0 = r12
            if (r0 == 0) goto La6
            r0 = r13
            if (r0 == 0) goto La6
            com.sobot.chat.widget.zxing.Result r0 = new com.sobot.chat.widget.zxing.Result     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r1 = r0
            r2 = r18
            java.lang.String r2 = r2.getText()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r3 = 1
            java.lang.String r2 = r2.substring(r3)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r3 = r18
            byte[] r3 = r3.getRawBytes()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r4 = r18
            com.sobot.chat.widget.zxing.ResultPoint[] r4 = r4.getResultPoints()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            com.sobot.chat.widget.zxing.BarcodeFormat r5 = com.sobot.chat.widget.zxing.BarcodeFormat.UPC_A     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r1.<init>(r2, r3, r4, r5)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r15 = r0
            r0 = r15
            r1 = r18
            java.util.Map r1 = r1.getResultMetadata()     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
            r0.putAllMetadata(r1)     // Catch: com.sobot.chat.widget.zxing.ReaderException -> Lb6
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
            com.sobot.chat.widget.zxing.NotFoundException r0 = com.sobot.chat.widget.zxing.NotFoundException.getNotFoundInstance()
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
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.oned.MultiFormatUPCEANReader.decodeRow(int, com.sobot.chat.widget.zxing.common.BitArray, java.util.Map):com.sobot.chat.widget.zxing.Result");
    }

    @Override // com.sobot.chat.widget.zxing.oned.OneDReader, com.sobot.chat.widget.zxing.Reader
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

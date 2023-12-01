package com.sobot.chat.widget.zxing;

import com.sobot.chat.widget.zxing.aztec.AztecReader;
import com.sobot.chat.widget.zxing.datamatrix.DataMatrixReader;
import com.sobot.chat.widget.zxing.maxicode.MaxiCodeReader;
import com.sobot.chat.widget.zxing.oned.MultiFormatOneDReader;
import com.sobot.chat.widget.zxing.pdf417.PDF417Reader;
import com.sobot.chat.widget.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/MultiFormatReader.class */
public final class MultiFormatReader implements Reader {
    private static final Reader[] EMPTY_READER_ARRAY = new Reader[0];
    private Map<DecodeHintType, ?> hints;
    private Reader[] readers;

    private Result decodeInternal(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.readers;
        if (readerArr != null) {
            int length = readerArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                try {
                    return readerArr[i2].decode(binaryBitmap, this.hints);
                } catch (ReaderException e) {
                    i = i2 + 1;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException {
        setHints(null);
        return decodeInternal(binaryBitmap);
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        setHints(map);
        return decodeInternal(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) throws NotFoundException {
        if (this.readers == null) {
            setHints(null);
        }
        return decodeInternal(binaryBitmap);
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public void reset() {
        Reader[] readerArr = this.readers;
        if (readerArr == null) {
            return;
        }
        int length = readerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            readerArr[i2].reset();
            i = i2 + 1;
        }
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        this.hints = map;
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = true;
            if (!collection.contains(BarcodeFormat.UPC_A)) {
                z2 = true;
                if (!collection.contains(BarcodeFormat.UPC_E)) {
                    z2 = true;
                    if (!collection.contains(BarcodeFormat.EAN_13)) {
                        z2 = true;
                        if (!collection.contains(BarcodeFormat.EAN_8)) {
                            z2 = true;
                            if (!collection.contains(BarcodeFormat.CODABAR)) {
                                z2 = true;
                                if (!collection.contains(BarcodeFormat.CODE_39)) {
                                    z2 = true;
                                    if (!collection.contains(BarcodeFormat.CODE_93)) {
                                        z2 = true;
                                        if (!collection.contains(BarcodeFormat.CODE_128)) {
                                            z2 = true;
                                            if (!collection.contains(BarcodeFormat.ITF)) {
                                                z2 = true;
                                                if (!collection.contains(BarcodeFormat.RSS_14)) {
                                                    z2 = collection.contains(BarcodeFormat.RSS_EXPANDED);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z2 && !z) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new AztecReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new PDF417Reader());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new MaxiCodeReader());
            }
            if (z2 && z) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            arrayList.add(new QRCodeReader());
            arrayList.add(new DataMatrixReader());
            arrayList.add(new AztecReader());
            arrayList.add(new PDF417Reader());
            arrayList.add(new MaxiCodeReader());
            if (z) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        this.readers = (Reader[]) arrayList.toArray(EMPTY_READER_ARRAY);
    }
}

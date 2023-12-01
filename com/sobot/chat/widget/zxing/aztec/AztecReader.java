package com.sobot.chat.widget.zxing.aztec;

import com.sobot.chat.widget.zxing.BinaryBitmap;
import com.sobot.chat.widget.zxing.FormatException;
import com.sobot.chat.widget.zxing.NotFoundException;
import com.sobot.chat.widget.zxing.Reader;
import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/aztec/AztecReader.class */
public final class AztecReader implements Reader {
    @Override // com.sobot.chat.widget.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9 A[LOOP:0: B:38:0x00b3->B:40:0x00b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.sobot.chat.widget.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.chat.widget.zxing.Result decode(com.sobot.chat.widget.zxing.BinaryBitmap r11, java.util.Map<com.sobot.chat.widget.zxing.DecodeHintType, ?> r12) throws com.sobot.chat.widget.zxing.NotFoundException, com.sobot.chat.widget.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.aztec.AztecReader.decode(com.sobot.chat.widget.zxing.BinaryBitmap, java.util.Map):com.sobot.chat.widget.zxing.Result");
    }

    @Override // com.sobot.chat.widget.zxing.Reader
    public void reset() {
    }
}

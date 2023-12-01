package com.sobot.chat.widget.zxing.datamatrix.encoder;

import com.blued.das.live.LiveProtos;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/datamatrix/encoder/DataMatrixSymbolInfo144.class */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMatrixSymbolInfo144() {
        super(false, 1558, LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_SHOW_VALUE, 22, 22, 36, -1, 62);
    }

    @Override // com.sobot.chat.widget.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.sobot.chat.widget.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }
}

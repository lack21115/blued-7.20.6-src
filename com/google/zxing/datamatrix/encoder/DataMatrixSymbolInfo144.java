package com.google.zxing.datamatrix.encoder;

import com.blued.das.live.LiveProtos;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/datamatrix/encoder/DataMatrixSymbolInfo144.class */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMatrixSymbolInfo144() {
        super(false, 1558, LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_SHOW_VALUE, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }
}

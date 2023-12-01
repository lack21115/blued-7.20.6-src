package com.sobot.chat.widget.zxing.oned.rss.expanded.decoders;

import com.sobot.chat.widget.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/oned/rss/expanded/decoders/AI013103decoder.class */
public final class AI013103decoder extends AI013x0xDecoder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.sobot.chat.widget.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i) {
        sb.append("(3103)");
    }

    @Override // com.sobot.chat.widget.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i;
    }
}

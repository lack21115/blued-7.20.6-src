package com.tencent.cos.xml.model.tag.eventstreaming;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/CheckSums.class */
final class CheckSums {
    private CheckSums() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void update(Checksum checksum, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            checksum.update(bArr, 0, remaining);
            return;
        }
        int position = byteBuffer.position();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        checksum.update(byteBuffer.array(), position + arrayOffset, limit - position);
        byteBuffer.position(limit);
    }
}

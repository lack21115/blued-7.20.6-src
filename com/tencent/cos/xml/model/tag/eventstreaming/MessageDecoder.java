package com.tencent.cos.xml.model.tag.eventstreaming;

import com.tencent.cos.xml.exception.CosXmlServiceException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/MessageDecoder.class */
public final class MessageDecoder {
    private static int defaultDecoderCapacity = 1053696;
    private static int incrementDecoderCapacity = 524288;
    private ByteBuffer buf = ByteBuffer.allocate(defaultDecoderCapacity);

    private void byteBufferCopy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        System.arraycopy(byteBuffer2.array(), 0, byteBuffer.array(), 0, byteBuffer2.position());
        byteBuffer.position(byteBuffer2.position());
    }

    private ByteBuffer safePut(ByteBuffer byteBuffer, byte[] bArr, int i, int i2) {
        if (byteBuffer.remaining() >= i2) {
            byteBuffer.put(bArr, i, i2);
            return byteBuffer;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() + incrementDecoderCapacity);
        byteBufferCopy(allocate, byteBuffer);
        allocate.put(bArr, i, i2);
        return allocate;
    }

    public List<Message> feed(byte[] bArr) throws CosXmlServiceException {
        return feed(bArr, 0, bArr.length);
    }

    public List<Message> feed(byte[] bArr, int i, int i2) throws CosXmlServiceException {
        int i3;
        int intExact;
        ByteBuffer safePut = safePut(this.buf, bArr, i, i2);
        this.buf = safePut;
        ByteBuffer byteBuffer = (ByteBuffer) safePut.duplicate().flip();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            i3 = i4;
            if (byteBuffer.remaining() < 15 || byteBuffer.remaining() < (intExact = Utils.toIntExact(Prelude.decode(byteBuffer.duplicate()).getTotalLength()))) {
                break;
            }
            arrayList.add(Message.decode(byteBuffer));
            i4 = i3 + intExact;
        }
        if (i3 > 0) {
            this.buf.flip();
            ByteBuffer byteBuffer2 = this.buf;
            byteBuffer2.position(byteBuffer2.position() + i3);
            this.buf.compact();
        }
        return arrayList;
    }

    public boolean hasPendingContent() {
        return this.buf.position() != 0;
    }
}

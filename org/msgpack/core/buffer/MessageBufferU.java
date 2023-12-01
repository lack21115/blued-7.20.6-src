package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/core/buffer/MessageBufferU.class */
public class MessageBufferU extends MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBuffer wrap;

    private MessageBufferU(Object obj, long j, int i, ByteBuffer byteBuffer) {
        super(obj, j, i);
        this.wrap = byteBuffer;
    }

    MessageBufferU(ByteBuffer byteBuffer) {
        super(byteBuffer);
        this.wrap = byteBuffer.slice();
    }

    MessageBufferU(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
        this.wrap = ByteBuffer.wrap(bArr, i, i2).slice();
    }

    private void resetBufferPosition() {
        this.wrap.position(0);
        this.wrap.limit(this.size);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void copyTo(int i, MessageBuffer messageBuffer, int i2, int i3) {
        try {
            this.wrap.position(i);
            messageBuffer.putByteBuffer(i2, this.wrap, i3);
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public boolean getBoolean(int i) {
        return this.wrap.get(i) != 0;
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte getByte(int i) {
        return this.wrap.get(i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int i, int i2, ByteBuffer byteBuffer) {
        try {
            this.wrap.position(i);
            this.wrap.limit(i + i2);
            byteBuffer.put(this.wrap);
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        try {
            this.wrap.position(i);
            this.wrap.get(bArr, i2, i3);
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public double getDouble(int i) {
        return this.wrap.getDouble(i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public float getFloat(int i) {
        return this.wrap.getFloat(i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public int getInt(int i) {
        return this.wrap.getInt(i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public long getLong(int i) {
        return this.wrap.getLong(i);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public short getShort(int i) {
        return this.wrap.getShort(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBoolean(int i, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByte(int i, byte b) {
        this.wrap.put(i, b);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putByteBuffer(int i, ByteBuffer byteBuffer, int i2) {
        if (byteBuffer.hasArray()) {
            putBytes(i, byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), i2);
            byteBuffer.position(byteBuffer.position() + i2);
            return;
        }
        int limit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i2);
            this.wrap.position(i);
            this.wrap.put(byteBuffer);
        } finally {
            byteBuffer.limit(limit);
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putBytes(int i, byte[] bArr, int i2, int i3) {
        try {
            this.wrap.position(i);
            this.wrap.put(bArr, i2, i3);
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putDouble(int i, double d) {
        this.wrap.putDouble(i, d);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putFloat(int i, float f) {
        this.wrap.putFloat(i, f);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putInt(int i, int i2) {
        this.wrap.putInt(i, i2);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putLong(int i, long j) {
        this.wrap.putLong(i, j);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putMessageBuffer(int i, MessageBuffer messageBuffer, int i2, int i3) {
        putBytes(i, messageBuffer.toByteArray(), i2, i3);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public void putShort(int i, short s) {
        this.wrap.putShort(i, s);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public MessageBufferU slice(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        int i3 = i + i2;
        Preconditions.checkArgument(i3 <= size());
        try {
            this.wrap.position(i);
            this.wrap.limit(i3);
            return new MessageBufferU(this.base, i + this.address, i2, this.wrap.slice());
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, this.size);
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public ByteBuffer sliceAsByteBuffer(int i, int i2) {
        try {
            this.wrap.position(i);
            this.wrap.limit(i + i2);
            return this.wrap.slice();
        } finally {
            resetBufferPosition();
        }
    }

    @Override // org.msgpack.core.buffer.MessageBuffer
    public byte[] toByteArray() {
        int size = size();
        byte[] bArr = new byte[size];
        getBytes(0, bArr, 0, size);
        return bArr;
    }
}

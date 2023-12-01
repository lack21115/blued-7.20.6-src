package com.tencent.tinker.ziputils.ziputil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/BufferIterator.class */
public abstract class BufferIterator {
    public abstract int readInt();

    public abstract short readShort();

    public abstract void seek(int i);

    public abstract void skip(int i);
}

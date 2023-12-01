package org.apache.commons.codec.binary;

import java.io.OutputStream;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/binary/Base64OutputStream.class */
public class Base64OutputStream extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base64(false), z);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new Base64(i, bArr), z);
    }
}

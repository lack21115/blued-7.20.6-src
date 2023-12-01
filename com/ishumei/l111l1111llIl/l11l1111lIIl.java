package com.ishumei.l111l1111llIl;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l11l1111lIIl.class */
public final class l11l1111lIIl {
    public static byte[] l1111l111111Il(byte[] bArr) {
        int inflate;
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        while (!inflater.finished() && (inflate = inflater.inflate(bArr2)) > 0) {
            byteArrayOutputStream.write(bArr2, 0, inflate);
        }
        inflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}

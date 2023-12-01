package com.getui.gtc.base.util.io;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/io/Base64OutputStream.class */
public class Base64OutputStream extends OutputStream {
    private int buffer;
    private int bytecounter;
    private int linecounter;
    private int linelength;
    private OutputStream outputStream;

    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public Base64OutputStream(OutputStream outputStream, int i) {
        this.outputStream = null;
        this.buffer = 0;
        this.bytecounter = 0;
        this.linecounter = 0;
        this.linelength = 0;
        this.outputStream = outputStream;
        this.linelength = i;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        commit();
        this.outputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void commit() throws IOException {
        if (this.bytecounter > 0) {
            int i = this.linelength;
            if (i > 0 && this.linecounter == i) {
                this.outputStream.write(com.tencent.qcloud.core.util.IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                this.linecounter = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 14) >>> 26);
            char c2 = '=';
            char charAt3 = this.bytecounter < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 20) >>> 26);
            if (this.bytecounter >= 3) {
                c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.buffer << 26) >>> 26);
            }
            this.outputStream.write(charAt);
            this.outputStream.write(charAt2);
            this.outputStream.write(charAt3);
            this.outputStream.write(c2);
            this.linecounter += 4;
            this.bytecounter = 0;
            this.buffer = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2 = this.bytecounter;
        this.buffer = ((i & 255) << (16 - (i2 * 8))) | this.buffer;
        int i3 = i2 + 1;
        this.bytecounter = i3;
        if (i3 == 3) {
            commit();
        }
    }
}

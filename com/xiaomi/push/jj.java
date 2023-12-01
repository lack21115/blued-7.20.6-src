package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jj.class */
public class jj extends jm {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f27862a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f845a;

    protected jj() {
        this.f27862a = null;
        this.f845a = null;
    }

    public jj(OutputStream outputStream) {
        this.f27862a = null;
        this.f845a = null;
        this.f845a = outputStream;
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f27862a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new jn(4);
            } catch (IOException e) {
                throw new jn(0, e);
            }
        }
        throw new jn(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.jm
    /* renamed from: a  reason: collision with other method in class */
    public void mo9007a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f845a;
        if (outputStream == null) {
            throw new jn(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new jn(0, e);
        }
    }
}

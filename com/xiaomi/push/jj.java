package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/jj.class */
public class jj extends jm {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f41553a;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f892a;

    protected jj() {
        this.f41553a = null;
        this.f892a = null;
    }

    public jj(OutputStream outputStream) {
        this.f41553a = null;
        this.f892a = null;
        this.f892a = outputStream;
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f41553a;
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
    public void mo12057a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f892a;
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

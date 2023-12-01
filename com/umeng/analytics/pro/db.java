package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/db.class */
public class db extends dd {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f40718a;
    protected OutputStream b;

    protected db() {
        this.f40718a = null;
        this.b = null;
    }

    public db(InputStream inputStream) {
        this.f40718a = null;
        this.b = null;
        this.f40718a = inputStream;
    }

    public db(InputStream inputStream, OutputStream outputStream) {
        this.f40718a = null;
        this.b = null;
        this.f40718a = inputStream;
        this.b = outputStream;
    }

    public db(OutputStream outputStream) {
        this.f40718a = null;
        this.b = null;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.dd
    public int a(byte[] bArr, int i, int i2) throws de {
        InputStream inputStream = this.f40718a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new de(4);
            } catch (IOException e) {
                throw new de(0, e);
            }
        }
        throw new de(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.dd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dd
    public void b() throws de {
    }

    @Override // com.umeng.analytics.pro.dd
    public void b(byte[] bArr, int i, int i2) throws de {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new de(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new de(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.dd
    public void c() {
        InputStream inputStream = this.f40718a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f40718a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.dd
    public void d() throws de {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new de(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e) {
            throw new de(0, e);
        }
    }
}

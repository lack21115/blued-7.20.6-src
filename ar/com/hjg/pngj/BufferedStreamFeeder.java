package ar.com.hjg.pngj;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/BufferedStreamFeeder.class */
public class BufferedStreamFeeder {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f3610a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f3611c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;

    public BufferedStreamFeeder(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public BufferedStreamFeeder(InputStream inputStream, int i) {
        this.e = false;
        this.f = true;
        this.g = false;
        this.f3610a = inputStream;
        this.b = new byte[i < 1 ? 8192 : i];
    }

    public int a(IBytesConsumer iBytesConsumer) {
        return a(iBytesConsumer, Integer.MAX_VALUE);
    }

    public int a(IBytesConsumer iBytesConsumer, int i) {
        if (this.f3611c == 0) {
            a();
        }
        if (i < 0 || i >= this.f3611c) {
            i = this.f3611c;
        }
        int i2 = 0;
        if (i > 0) {
            int a2 = iBytesConsumer.a(this.b, this.d, i);
            i2 = a2;
            if (a2 > 0) {
                this.d += a2;
                this.f3611c -= a2;
                i2 = a2;
            }
        }
        if (i2 < 1 && this.g) {
            throw new PngjInputException("Failed to feed bytes (premature ending?)");
        }
        return i2;
    }

    protected void a() {
        if (this.f3611c > 0 || this.e) {
            return;
        }
        try {
            this.d = 0;
            int read = this.f3610a.read(this.b);
            this.f3611c = read;
            if (read < 0) {
                b();
            }
        } catch (IOException e) {
            throw new PngjInputException(e);
        }
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b() {
        this.e = true;
        this.b = null;
        this.f3611c = 0;
        this.d = 0;
        InputStream inputStream = this.f3610a;
        if (inputStream != null && this.f) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        this.f3610a = null;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public boolean b(IBytesConsumer iBytesConsumer, int i) {
        while (i > 0) {
            int a2 = a(iBytesConsumer, i);
            if (a2 < 1) {
                return false;
            }
            i -= a2;
        }
        return true;
    }
}

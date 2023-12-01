package com.youzan.spiderman.d;

import android.content.Context;
import com.youzan.spiderman.b.f;
import com.youzan.spiderman.cache.CacheUrl;
import com.youzan.spiderman.cache.g;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.OkHttpUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/d/a.class */
public final class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f28117a;
    private CacheUrl b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28118c;
    private File d = null;
    private BufferedOutputStream e = null;
    private boolean f = false;

    public a(Context context, CacheUrl cacheUrl) {
        this.f28118c = context;
        this.b = cacheUrl;
    }

    private InputStream a() {
        File b = b();
        this.d = b;
        if (b != null) {
            try {
                this.e = new BufferedOutputStream(new FileOutputStream(this.d));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                this.e = null;
            }
        }
        d downloadFile = OkHttpUtil.downloadFile(this.f28118c, this.b.getUri().toString());
        if (downloadFile == null) {
            return null;
        }
        if (downloadFile.c() || !this.b.isScript()) {
            return downloadFile.a();
        }
        c cVar = new c(downloadFile);
        b.a().a(cVar);
        return cVar.a();
    }

    static /* synthetic */ void a(a aVar) {
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = aVar.f28117a.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    aVar.e.write(bArr, 0, read);
                }
                aVar.e.flush();
                aVar.e.close();
                aVar.e = null;
                File file = aVar.b.isScript() ? new File(g.f(), aVar.b.getMd5()) : new File(g.g(), aVar.b.getMd5());
                if (aVar.d.renameTo(file)) {
                    f.a().a(aVar.b, file);
                }
                BufferedOutputStream bufferedOutputStream = aVar.e;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        Logger.e("InputStreamWrapper", e);
                    }
                }
                InputStream inputStream = aVar.f28117a;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Logger.e("InputStreamWrapper", e2);
                    }
                }
            } catch (Exception e3) {
                Logger.e("InputStreamWrapper", e3);
                BufferedOutputStream bufferedOutputStream2 = aVar.e;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e4) {
                        Logger.e("InputStreamWrapper", e4);
                    }
                }
                InputStream inputStream2 = aVar.f28117a;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                        Logger.e("InputStreamWrapper", e5);
                    }
                }
            }
        } catch (Throwable th) {
            BufferedOutputStream bufferedOutputStream3 = aVar.e;
            if (bufferedOutputStream3 != null) {
                try {
                    bufferedOutputStream3.close();
                } catch (IOException e6) {
                    Logger.e("InputStreamWrapper", e6);
                }
            }
            InputStream inputStream3 = aVar.f28117a;
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException e7) {
                    Logger.e("InputStreamWrapper", e7);
                }
            }
            throw th;
        }
    }

    private File b() {
        File file = new File(g.d());
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, this.b.getMd5());
            if (file2.exists()) {
                return file2;
            }
            try {
                if (file2.createNewFile()) {
                    return file2;
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        if (!this.f) {
            if (this.d == null || this.e == null || this.f28117a == null) {
                return;
            }
            com.youzan.spiderman.a.c.a().a(new com.youzan.spiderman.a.a() { // from class: com.youzan.spiderman.d.a.1
                @Override // com.youzan.spiderman.a.a
                public final void a() throws Throwable {
                    a.a(a.this);
                }

                @Override // com.youzan.spiderman.a.a
                public final void a(Throwable th) {
                    Logger.e("InputStreamWrapper", th);
                }
            });
            return;
        }
        BufferedOutputStream bufferedOutputStream = this.e;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        File file = this.d;
        if (file != null) {
            file.delete();
        }
        InputStream inputStream = this.f28117a;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f28117a == null) {
            this.f28117a = a();
        }
        InputStream inputStream = this.f28117a;
        if (inputStream == null) {
            this.f = true;
            Logger.e("InputStreamWrapper", "get input stream null, url:" + this.b.getUri(), new Object[0]);
            throw new IOException("get download input stream failed");
        }
        try {
            int read = inputStream.read();
            if (read != -1 && this.e != null) {
                this.e.write(read);
            }
            return read;
        } catch (IOException e) {
            this.f = true;
            Logger.e("InputStreamWrapper", "exception when read, url:" + this.b.getUri(), e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f28117a == null) {
            this.f28117a = a();
        }
        InputStream inputStream = this.f28117a;
        if (inputStream == null) {
            this.f = true;
            Logger.e("InputStreamWrapper", "get input stream null, url:" + this.b.getUri(), new Object[0]);
            throw new IOException("get download input stream failed");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read != -1 && this.e != null) {
                this.e.write(bArr, i, read);
            }
            return read;
        } catch (IOException e) {
            this.f = true;
            Logger.e("InputStreamWrapper", "exception when read buf, url:" + this.b.getUri(), e);
            throw e;
        }
    }
}

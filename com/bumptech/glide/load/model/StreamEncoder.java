package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/model/StreamEncoder.class */
public class StreamEncoder implements Encoder<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f7301a;

    public StreamEncoder(ArrayPool arrayPool) {
        this.f7301a = arrayPool;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean a(InputStream inputStream, File file, Options options) {
        boolean z;
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.f7301a.a(65536, byte[].class);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream3.write(bArr, 0, read);
                        } catch (IOException e) {
                            fileOutputStream = fileOutputStream3;
                            e = e;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                fileOutputStream2 = fileOutputStream;
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            z = false;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                z = false;
                            }
                            this.f7301a.a((ArrayPool) bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream3;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e2) {
                                }
                            }
                            this.f7301a.a((ArrayPool) bArr);
                            throw th;
                        }
                    }
                    fileOutputStream3.close();
                    fileOutputStream3.close();
                    z = true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            }
        } catch (IOException e4) {
        }
        this.f7301a.a((ArrayPool) bArr);
        return z;
    }
}

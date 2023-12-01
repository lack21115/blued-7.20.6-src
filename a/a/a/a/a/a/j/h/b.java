package a.a.a.a.a.a.j.h;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.j.d;
import a.a.a.a.a.e.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/b.class */
public class b extends a.a.a.a.a.a.j.h.a {
    public int o;
    public d p;
    public Object q;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/b$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f1232a;

        public a(Bitmap bitmap) {
            this.f1232a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f, this.f1232a.getWidth() / 2.0f, this.f1232a.getHeight() / 2.0f);
            Bitmap bitmap = this.f1232a;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f1232a.getHeight(), matrix, true);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(createBitmap.getWidth() * createBitmap.getHeight() * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            if (createBitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                createBitmap.copyPixelsToBuffer(allocateDirect);
                allocateDirect.position(0);
            }
            synchronized (b.this.q) {
                b.this.o = f.a(allocateDirect, createBitmap.getWidth(), createBitmap.getHeight(), 6408);
                b.this.q.notify();
            }
        }
    }

    public b(Context context, a.a.a.a.a.b.c cVar, a.a.a.a.a.a.b bVar, d dVar) {
        super(context, cVar, bVar);
        this.q = new Object();
        this.p = dVar;
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void a() {
        d dVar = this.p;
        if (dVar == null) {
            e.f1313c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
        } else {
            dVar.a(this.o, System.nanoTime(), false);
        }
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void a(Bitmap bitmap) {
        d dVar = this.p;
        if (dVar == null) {
            e.f1313c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
            return;
        }
        dVar.a(false);
        b(bitmap);
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void b() {
        this.o = 0;
        d dVar = this.p;
        if (dVar == null) {
            e.f1313c.e("TexturePictureStreamingManager", "mTextureMovieTransfer is null !!!");
        } else {
            dVar.b(false);
        }
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void b(Bitmap bitmap) {
        if (this.p.b().post(new a(bitmap))) {
            synchronized (this.q) {
                if (this.o == 0) {
                    try {
                        this.q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

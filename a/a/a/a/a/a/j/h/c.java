package a.a.a.a.a.a.j.h;

import a.a.a.a.a.a.j.f;
import a.a.a.a.a.a.j.g;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/c.class */
public class c extends a {
    public g o;
    public f.a p;
    public ByteBuffer q;
    public StreamingPreviewCallback r;

    public c(Context context, a.a.a.a.a.b.c cVar, a.a.a.a.a.a.b bVar, g gVar, f.a aVar, StreamingPreviewCallback streamingPreviewCallback) {
        super(context, cVar, bVar);
        this.o = gVar;
        this.p = aVar;
        this.r = streamingPreviewCallback;
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void a() {
        if (d()) {
            g gVar = this.o;
            if (gVar == null) {
                e.f1361c.e("YUVPictureStreamingManager", "mYuvDataTransfer is null !!!");
                return;
            } else {
                ByteBuffer byteBuffer = this.q;
                gVar.a(byteBuffer, byteBuffer.capacity(), System.nanoTime());
            }
        }
        StreamingPreviewCallback streamingPreviewCallback = this.r;
        if (streamingPreviewCallback != null) {
            byte[] array = this.q.array();
            f.a aVar = this.p;
            streamingPreviewCallback.onPreviewFrame(array, aVar.b, aVar.f1272c, aVar.e, aVar.f, System.nanoTime());
        }
    }

    public void a(f.a aVar) {
        boolean z = this.p.m;
        this.p = aVar;
        aVar.m = z;
        String str = this.b;
        if (str != null) {
            a(str);
        } else {
            a(this.f1276c);
        }
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void a(Bitmap bitmap) {
        if (this.p == null) {
            e.f1361c.e("YUVPictureStreamingManager", "mCurrentTransferSessionCfg is null !!!");
            return;
        }
        if (d()) {
            this.o.b(false);
            this.o.a(this.p);
            this.o.a(false);
        }
        b(bitmap);
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void b() {
        this.q = null;
        if (d()) {
            g gVar = this.o;
            if (gVar == null) {
                e.f1361c.e("YUVPictureStreamingManager", "mYuvDataTransfer is null !!!");
            } else {
                gVar.b(false);
            }
        }
    }

    @Override // a.a.a.a.a.a.j.h.a
    public void b(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(-this.p.e);
        if (this.p.m) {
            matrix.postScale(1.0f, -1.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        f.a aVar = this.p;
        boolean z = true;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, aVar.b, aVar.f1272c, true);
        int width = createScaledBitmap.getWidth();
        int height = createScaledBitmap.getHeight();
        if (this.p.f != PLFourCC.FOURCC_NV21) {
            z = false;
        }
        this.q = ByteBuffer.wrap(h.a(width, height, createScaledBitmap, z));
    }
}

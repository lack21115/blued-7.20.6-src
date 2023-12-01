package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/APNGFrame.class */
public class APNGFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean f = !APNGFrame.class.desiredAssertionStatus();
    private static final byte[] m = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] n = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static ThreadLocal<CRC32> o = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final byte f9522a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f9523c;
    List<Chunk> d;
    List<Chunk> e;

    public APNGFrame(APNGReader aPNGReader, FCTLChunk fCTLChunk) {
        super(aPNGReader);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f9522a = fCTLChunk.n;
        this.b = fCTLChunk.m;
        this.l = (fCTLChunk.k * 1000) / (fCTLChunk.l == 0 ? (short) 100 : fCTLChunk.l);
        this.h = fCTLChunk.f9525c;
        this.i = fCTLChunk.h;
        this.j = fCTLChunk.i;
        this.k = fCTLChunk.j;
    }

    private int a(APNGWriter aPNGWriter) throws IOException {
        int i;
        int i2;
        int i3;
        Iterator<Chunk> it = this.e.iterator();
        int i4 = 33;
        while (true) {
            i = i4;
            if (!it.hasNext()) {
                break;
            }
            i4 = i + it.next().d + 12;
        }
        for (Chunk chunk : this.d) {
            if (chunk instanceof IDATChunk) {
                i2 = chunk.d;
                i3 = 12;
            } else if (chunk instanceof FDATChunk) {
                i2 = chunk.d;
                i3 = 8;
            }
            i += i2 + i3;
        }
        int length = i + n.length;
        aPNGWriter.c(length);
        aPNGWriter.a(m);
        aPNGWriter.b(13);
        int a2 = aPNGWriter.a();
        aPNGWriter.a(IHDRChunk.f9538a);
        aPNGWriter.b(this.h);
        aPNGWriter.b(this.i);
        aPNGWriter.a(this.f9523c);
        CRC32 a3 = a();
        a3.reset();
        a3.update(aPNGWriter.b(), a2, 17);
        aPNGWriter.b((int) a3.getValue());
        for (Chunk chunk2 : this.e) {
            if (!(chunk2 instanceof IENDChunk)) {
                ((APNGReader) this.g).reset();
                ((APNGReader) this.g).skip(chunk2.g);
                ((APNGReader) this.g).read(aPNGWriter.b(), aPNGWriter.a(), chunk2.d + 12);
                aPNGWriter.d(chunk2.d + 12);
            }
        }
        for (Chunk chunk3 : this.d) {
            if (chunk3 instanceof IDATChunk) {
                ((APNGReader) this.g).reset();
                ((APNGReader) this.g).skip(chunk3.g);
                ((APNGReader) this.g).read(aPNGWriter.b(), aPNGWriter.a(), chunk3.d + 12);
                aPNGWriter.d(chunk3.d + 12);
            } else if (chunk3 instanceof FDATChunk) {
                aPNGWriter.b(chunk3.d - 4);
                int a4 = aPNGWriter.a();
                aPNGWriter.a(IDATChunk.f9536a);
                ((APNGReader) this.g).reset();
                ((APNGReader) this.g).skip(chunk3.g + 4 + 4 + 4);
                ((APNGReader) this.g).read(aPNGWriter.b(), aPNGWriter.a(), chunk3.d - 4);
                aPNGWriter.d(chunk3.d - 4);
                a3.reset();
                a3.update(aPNGWriter.b(), a4, chunk3.d);
                aPNGWriter.b((int) a3.getValue());
            }
        }
        aPNGWriter.a(n);
        return length;
    }

    private CRC32 a() {
        CRC32 crc32 = o.get();
        CRC32 crc322 = crc32;
        if (crc32 == null) {
            crc322 = new CRC32();
            o.set(crc322);
        }
        return crc322;
    }

    @Override // com.blued.android.core.image.apng.decode.Frame
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, APNGWriter aPNGWriter) {
        try {
            int a2 = a(aPNGWriter);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(aPNGWriter.b(), 0, a2, options);
            if (f || decodeByteArray != null) {
                float f2 = i;
                canvas.drawBitmap(decodeByteArray, this.j / f2, this.k / f2, paint);
                return decodeByteArray;
            }
            throw new AssertionError();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

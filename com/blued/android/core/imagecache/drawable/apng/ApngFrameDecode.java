package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.Pair;
import ar.com.hjg.pngj.PngReaderApng;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkACTL;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import com.blued.android.core.imagecache.RecyclingUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngFrameDecode.class */
public class ApngFrameDecode {
    protected int b;
    protected int c;
    ApngDrawable d;
    ApngRenderTask e;
    private File f;
    protected boolean a = false;
    private ArrayList<PngChunkFCTL> g = new ArrayList<>();
    private Map<Integer, Pair<Integer, Integer>> h = new HashMap();

    public ApngFrameDecode(ApngDrawable apngDrawable) {
        this.d = apngDrawable;
        this.e = new ApngRenderTask(apngDrawable, this);
    }

    private Bitmap a(int i, int i2, byte b, Bitmap bitmap, Bitmap bitmap2) {
        Bitmap a = (bitmap2 == null || bitmap2.getWidth() != this.d.c || bitmap2.getHeight() != this.d.d || this.d.h.a(bitmap2)) ? this.d.h.a(this.d.c, this.d.d) : bitmap2;
        if (a == null) {
            return bitmap2;
        }
        Canvas canvas = new Canvas(a);
        if (bitmap2 != null) {
            if (a != bitmap2) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
            if (b == 0) {
                canvas.clipRect(i, i2, bitmap.getWidth() + i, bitmap.getHeight() + i2);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.clipRect(0, 0, this.d.c, this.d.d);
            }
        }
        canvas.drawBitmap(bitmap, i, i2, (Paint) null);
        return a;
    }

    private void a(File file) {
        int i;
        PngReaderApng pngReaderApng = new PngReaderApng(file);
        pngReaderApng.c();
        List a = pngReaderApng.b().a();
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i2 >= a.size()) {
                this.d.h.a(i4);
                return;
            }
            PngChunkACTL pngChunkACTL = (PngChunk) a.get(i2);
            if (pngChunkACTL instanceof PngChunkACTL) {
                PngChunkACTL pngChunkACTL2 = pngChunkACTL;
                this.b = pngChunkACTL2.e();
                if (this.c > 0) {
                    i = i4;
                } else {
                    this.c = pngChunkACTL2.f();
                    i = i4;
                }
            } else {
                i = i4;
                if (pngChunkACTL instanceof PngChunkFCTL) {
                    PngChunkFCTL pngChunkFCTL = (PngChunkFCTL) pngChunkACTL;
                    this.g.add(pngChunkFCTL);
                    int size = this.g.size() - 1;
                    int i5 = 1;
                    while (pngChunkFCTL.j() == 2 && size > 0) {
                        size--;
                        i5++;
                        pngChunkFCTL = this.g.get(size);
                    }
                    i = Math.max(i4, i5);
                }
            }
            i2++;
            i3 = i;
        }
    }

    private Bitmap c(int i) {
        Bitmap bitmap;
        Bitmap a;
        Bitmap a2;
        PngChunkFCTL pngChunkFCTL = i > 0 ? this.g.get(i - 1) : null;
        if (pngChunkFCTL == null) {
            return null;
        }
        byte j = pngChunkFCTL.j();
        int f = pngChunkFCTL.f();
        int g = pngChunkFCTL.g();
        ApngDrawable apngDrawable = this.d;
        if (j == 0) {
            bitmap = null;
            if (i > 0) {
                bitmap = apngDrawable.h.b(i - 1);
            }
        } else if (j == 1) {
            Bitmap b = i > 0 ? apngDrawable.h.b(i - 1) : null;
            if (b != null) {
                int i2 = i - 1;
                if (this.h.containsKey(Integer.valueOf(i2)) && (a = this.d.h.a(this.d.c, this.d.d)) != null) {
                    Canvas canvas = new Canvas(a);
                    canvas.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
                    canvas.clipRect(f, g, ((Integer) this.h.get(Integer.valueOf(i2)).first).intValue() + f, ((Integer) this.h.get(Integer.valueOf(i2)).second).intValue() + g);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    canvas.clipRect(0, 0, this.d.c, this.d.d);
                    return a;
                }
            }
            return b;
        } else if (j != 2) {
            return null;
        } else {
            bitmap = null;
            if (i > 1) {
                int i3 = i;
                int i4 = 2;
                while (true) {
                    int i5 = i3 - i4;
                    bitmap = null;
                    if (i5 < 0) {
                        break;
                    }
                    PngChunkFCTL pngChunkFCTL2 = this.g.get(i5);
                    byte j2 = pngChunkFCTL2.j();
                    int f2 = pngChunkFCTL2.f();
                    int g2 = pngChunkFCTL2.g();
                    if (j2 == 2) {
                        i3 = i5;
                        i4 = 1;
                    } else if (j2 == 0) {
                        return this.d.h.b(i5);
                    } else {
                        bitmap = null;
                        if (j2 == 1) {
                            Bitmap b2 = this.d.h.b(i5);
                            if (b2 == null || !this.h.containsKey(Integer.valueOf(i5)) || (a2 = this.d.h.a(this.d.c, this.d.d)) == null) {
                                return b2;
                            }
                            Canvas canvas2 = new Canvas(a2);
                            canvas2.drawBitmap(b2, 0.0f, 0.0f, (Paint) null);
                            canvas2.clipRect(f2, g2, ((Integer) this.h.get(Integer.valueOf(i5)).first).intValue() + f2, ((Integer) this.h.get(Integer.valueOf(i5)).second).intValue() + g2);
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                            canvas2.clipRect(0, 0, this.d.c, this.d.d);
                            return a2;
                        }
                    }
                }
            }
        }
        return bitmap;
    }

    public int a(int i) {
        PngChunkFCTL pngChunkFCTL = this.g.get(i);
        return Math.round((pngChunkFCTL.h() * 1000.0f) / pngChunkFCTL.i());
    }

    public void a() {
        String i = this.d.i();
        if (i == null) {
            return;
        }
        File file = new File(i);
        this.f = file;
        if (file.exists()) {
            ApngExtractFrames.a(this.f);
            a(this.f);
            this.a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b(int i) {
        if (i == 0) {
            String i2 = this.d.i();
            Bitmap b = this.d.h.b(0);
            Bitmap bitmap = b;
            if (b == null) {
                bitmap = ApngImageUtils.a(RecyclingUtils.Scheme.FILE.b(i2), this.d.h.a(this.d.c, this.d.d));
                this.d.h.a(0, bitmap);
            }
            return bitmap;
        }
        String path = new File(this.d.b, ApngExtractFrames.a(this.f, i)).getPath();
        Bitmap bitmap2 = null;
        try {
            Bitmap a = this.d.h.a(this.d.c, this.d.d);
            Bitmap a2 = ApngImageUtils.a(RecyclingUtils.Scheme.FILE.b(path), a);
            bitmap2 = a2;
            if (a != a2) {
                bitmap2 = a2;
                this.d.h.b(a);
                bitmap2 = a2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (bitmap2 != null) {
            this.h.put(Integer.valueOf(i), new Pair<>(Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight())));
        }
        Bitmap c = c(i);
        PngChunkFCTL pngChunkFCTL = this.g.get(i);
        Bitmap a3 = a(pngChunkFCTL.f(), pngChunkFCTL.g(), pngChunkFCTL.k(), bitmap2, c);
        this.d.h.a(i, a3);
        this.d.h.b(bitmap2);
        this.d.h.b(c);
        return a3;
    }

    public void b() {
        if (this.d.e < 0) {
            this.d.e = 0;
        } else if (this.d.e >= this.g.size() - 1) {
            this.d.e = 0;
        }
        b(0);
        this.d.f.schedule(this.e, a(0), TimeUnit.MILLISECONDS);
    }
}

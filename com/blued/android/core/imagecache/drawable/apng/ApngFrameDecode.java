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

    /* renamed from: c  reason: collision with root package name */
    protected int f9635c;
    ApngDrawable d;
    ApngRenderTask e;
    private File f;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f9634a = false;
    private ArrayList<PngChunkFCTL> g = new ArrayList<>();
    private Map<Integer, Pair<Integer, Integer>> h = new HashMap();

    public ApngFrameDecode(ApngDrawable apngDrawable) {
        this.d = apngDrawable;
        this.e = new ApngRenderTask(apngDrawable, this);
    }

    private Bitmap a(int i, int i2, byte b, Bitmap bitmap, Bitmap bitmap2) {
        Bitmap a2 = (bitmap2 == null || bitmap2.getWidth() != this.d.f9627c || bitmap2.getHeight() != this.d.d || this.d.h.a(bitmap2)) ? this.d.h.a(this.d.f9627c, this.d.d) : bitmap2;
        if (a2 == null) {
            return bitmap2;
        }
        Canvas canvas = new Canvas(a2);
        if (bitmap2 != null) {
            if (a2 != bitmap2) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
            if (b == 0) {
                canvas.clipRect(i, i2, bitmap.getWidth() + i, bitmap.getHeight() + i2);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.clipRect(0, 0, this.d.f9627c, this.d.d);
            }
        }
        canvas.drawBitmap(bitmap, i, i2, (Paint) null);
        return a2;
    }

    private void a(File file) {
        int i;
        PngReaderApng pngReaderApng = new PngReaderApng(file);
        pngReaderApng.c();
        List<PngChunk> a2 = pngReaderApng.b().a();
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i2 >= a2.size()) {
                this.d.h.a(i4);
                return;
            }
            PngChunk pngChunk = a2.get(i2);
            if (pngChunk instanceof PngChunkACTL) {
                PngChunkACTL pngChunkACTL = (PngChunkACTL) pngChunk;
                this.b = pngChunkACTL.e();
                if (this.f9635c > 0) {
                    i = i4;
                } else {
                    this.f9635c = pngChunkACTL.f();
                    i = i4;
                }
            } else {
                i = i4;
                if (pngChunk instanceof PngChunkFCTL) {
                    PngChunkFCTL pngChunkFCTL = (PngChunkFCTL) pngChunk;
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
        Bitmap a2;
        Bitmap a3;
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
                if (this.h.containsKey(Integer.valueOf(i2)) && (a2 = this.d.h.a(this.d.f9627c, this.d.d)) != null) {
                    Canvas canvas = new Canvas(a2);
                    canvas.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
                    canvas.clipRect(f, g, this.h.get(Integer.valueOf(i2)).first.intValue() + f, this.h.get(Integer.valueOf(i2)).second.intValue() + g);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    canvas.clipRect(0, 0, this.d.f9627c, this.d.d);
                    return a2;
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
                            if (b2 == null || !this.h.containsKey(Integer.valueOf(i5)) || (a3 = this.d.h.a(this.d.f9627c, this.d.d)) == null) {
                                return b2;
                            }
                            Canvas canvas2 = new Canvas(a3);
                            canvas2.drawBitmap(b2, 0.0f, 0.0f, (Paint) null);
                            canvas2.clipRect(f2, g2, this.h.get(Integer.valueOf(i5)).first.intValue() + f2, this.h.get(Integer.valueOf(i5)).second.intValue() + g2);
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                            canvas2.clipRect(0, 0, this.d.f9627c, this.d.d);
                            return a3;
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
            this.f9634a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b(int i) {
        if (i == 0) {
            String i2 = this.d.i();
            Bitmap b = this.d.h.b(0);
            Bitmap bitmap = b;
            if (b == null) {
                bitmap = ApngImageUtils.a(RecyclingUtils.Scheme.FILE.b(i2), this.d.h.a(this.d.f9627c, this.d.d));
                this.d.h.a(0, bitmap);
            }
            return bitmap;
        }
        String path = new File(this.d.b, ApngExtractFrames.a(this.f, i)).getPath();
        Bitmap bitmap2 = null;
        try {
            Bitmap a2 = this.d.h.a(this.d.f9627c, this.d.d);
            Bitmap a3 = ApngImageUtils.a(RecyclingUtils.Scheme.FILE.b(path), a2);
            bitmap2 = a3;
            if (a2 != a3) {
                bitmap2 = a3;
                this.d.h.b(a2);
                bitmap2 = a3;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (bitmap2 != null) {
            this.h.put(Integer.valueOf(i), new Pair<>(Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight())));
        }
        Bitmap c2 = c(i);
        PngChunkFCTL pngChunkFCTL = this.g.get(i);
        Bitmap a4 = a(pngChunkFCTL.f(), pngChunkFCTL.g(), pngChunkFCTL.k(), bitmap2, c2);
        this.d.h.a(i, a4);
        this.d.h.b(bitmap2);
        this.d.h.b(c2);
        return a4;
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

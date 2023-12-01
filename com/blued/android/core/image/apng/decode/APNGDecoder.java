package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.blued.android.core.image.apng.decode.FrameSeqDecoder;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/APNGDecoder.class */
public class APNGDecoder extends FrameSeqDecoder<APNGReader, APNGWriter> {
    private APNGWriter g;
    private int h;
    private final Paint i;
    private SnapShot j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/APNGDecoder$SnapShot.class */
    public class SnapShot {
        byte a;
        Rect b;
        ByteBuffer c;

        private SnapShot() {
            this.b = new Rect();
        }
    }

    public APNGDecoder(ByteBufferLoader byteBufferLoader, FrameSeqDecoder.RenderListener renderListener) {
        super(byteBufferLoader, renderListener);
        this.i = new Paint();
        this.j = new SnapShot();
        this.i.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    /* renamed from: a */
    public Rect b(APNGReader aPNGReader) throws IOException {
        List<Chunk> a = APNGParser.a(aPNGReader);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<Chunk> it = a.iterator();
        APNGFrame aPNGFrame = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Chunk next = it.next();
            if (next instanceof ACTLChunk) {
                this.h = ((ACTLChunk) next).c;
                z = true;
            } else if (next instanceof FCTLChunk) {
                APNGFrame aPNGFrame2 = new APNGFrame(aPNGReader, (FCTLChunk) next);
                aPNGFrame2.e = arrayList;
                aPNGFrame2.c = bArr;
                aPNGFrame = aPNGFrame2;
                if (this.a != null) {
                    this.a.add(aPNGFrame2);
                    aPNGFrame = aPNGFrame2;
                }
            } else if (next instanceof FDATChunk) {
                if (aPNGFrame != null) {
                    aPNGFrame.d.add(next);
                }
            } else if (next instanceof IDATChunk) {
                if (!z) {
                    StillFrame stillFrame = new StillFrame(aPNGReader);
                    stillFrame.h = i;
                    stillFrame.i = i2;
                    if (this.a != null) {
                        this.a.add(stillFrame);
                    }
                    this.h = 1;
                } else if (aPNGFrame != null) {
                    aPNGFrame.d.add(next);
                }
            } else if (next instanceof IHDRChunk) {
                IHDRChunk iHDRChunk = (IHDRChunk) next;
                i = iHDRChunk.b;
                i2 = iHDRChunk.c;
                bArr = iHDRChunk.h;
            } else if (!(next instanceof IENDChunk)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        this.e = ByteBuffer.allocate(((i3 / (this.c * this.c)) + 1) * 4);
        this.j.c = ByteBuffer.allocate(((i3 / (this.c * this.c)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    /* renamed from: a */
    public APNGReader c(Reader reader) {
        return new APNGReader(reader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    /* renamed from: a */
    public APNGWriter d() {
        if (this.g == null) {
            this.g = new APNGWriter();
        }
        return this.g;
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    protected void a(Frame frame) {
        if (frame == null || this.f == null) {
            return;
        }
        try {
            Bitmap a = a(this.f.width() / this.c, this.f.height() / this.c);
            Canvas canvas = null;
            if (this.d != null) {
                canvas = this.d.get(a);
            }
            Canvas canvas2 = canvas;
            if (canvas == null) {
                canvas2 = new Canvas(a);
                this.d.put(a, canvas2);
            }
            if (frame instanceof APNGFrame) {
                this.e.rewind();
                a.copyPixelsFromBuffer(this.e);
                if (this.b == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.j.b);
                    byte b = this.j.a;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.j.c.rewind();
                        a.copyPixelsFromBuffer(this.j.c);
                    }
                    canvas2.restore();
                }
                if (((APNGFrame) frame).b == 2 && this.j.a != 2) {
                    this.j.c.rewind();
                    a.copyPixelsToBuffer(this.j.c);
                }
                this.j.a = ((APNGFrame) frame).b;
                canvas2.save();
                if (((APNGFrame) frame).a == 0) {
                    canvas2.clipRect(frame.j / this.c, frame.k / this.c, (frame.j + frame.h) / this.c, (frame.k + frame.i) / this.c);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.j.b.set(frame.j / this.c, frame.k / this.c, (frame.j + frame.h) / this.c, (frame.k + frame.i) / this.c);
                canvas2.restore();
            }
            a(frame.a(canvas2, this.i, this.c, a(frame.h, frame.i), d()));
            this.e.rewind();
            a.copyPixelsToBuffer(this.e);
            a(a);
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    protected int b() {
        return this.h;
    }

    @Override // com.blued.android.core.image.apng.decode.FrameSeqDecoder
    protected void c() {
        if (this.j.c != null) {
            this.j.c.clear();
            this.j.c = null;
        }
        APNGWriter aPNGWriter = this.g;
        if (aPNGWriter != null) {
            aPNGWriter.c();
            this.g = null;
        }
    }
}

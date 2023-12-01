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

        /* renamed from: a  reason: collision with root package name */
        byte f9520a;
        Rect b;

        /* renamed from: c  reason: collision with root package name */
        ByteBuffer f9521c;

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
        List<Chunk> a2 = APNGParser.a(aPNGReader);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<Chunk> it = a2.iterator();
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
                this.h = ((ACTLChunk) next).f9519c;
                z = true;
            } else if (next instanceof FCTLChunk) {
                APNGFrame aPNGFrame2 = new APNGFrame(aPNGReader, (FCTLChunk) next);
                aPNGFrame2.e = arrayList;
                aPNGFrame2.f9523c = bArr;
                aPNGFrame = aPNGFrame2;
                if (this.f9527a != null) {
                    this.f9527a.add(aPNGFrame2);
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
                    if (this.f9527a != null) {
                        this.f9527a.add(stillFrame);
                    }
                    this.h = 1;
                } else if (aPNGFrame != null) {
                    aPNGFrame.d.add(next);
                }
            } else if (next instanceof IHDRChunk) {
                IHDRChunk iHDRChunk = (IHDRChunk) next;
                i = iHDRChunk.b;
                i2 = iHDRChunk.f9539c;
                bArr = iHDRChunk.h;
            } else if (!(next instanceof IENDChunk)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        this.e = ByteBuffer.allocate(((i3 / (this.f9528c * this.f9528c)) + 1) * 4);
        this.j.f9521c = ByteBuffer.allocate(((i3 / (this.f9528c * this.f9528c)) + 1) * 4);
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
            Bitmap a2 = a(this.f.width() / this.f9528c, this.f.height() / this.f9528c);
            Canvas canvas = null;
            if (this.d != null) {
                canvas = this.d.get(a2);
            }
            Canvas canvas2 = canvas;
            if (canvas == null) {
                canvas2 = new Canvas(a2);
                this.d.put(a2, canvas2);
            }
            if (frame instanceof APNGFrame) {
                this.e.rewind();
                a2.copyPixelsFromBuffer(this.e);
                if (this.b == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.j.b);
                    byte b = this.j.f9520a;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.j.f9521c.rewind();
                        a2.copyPixelsFromBuffer(this.j.f9521c);
                    }
                    canvas2.restore();
                }
                if (((APNGFrame) frame).b == 2 && this.j.f9520a != 2) {
                    this.j.f9521c.rewind();
                    a2.copyPixelsToBuffer(this.j.f9521c);
                }
                this.j.f9520a = ((APNGFrame) frame).b;
                canvas2.save();
                if (((APNGFrame) frame).f9522a == 0) {
                    canvas2.clipRect(frame.j / this.f9528c, frame.k / this.f9528c, (frame.j + frame.h) / this.f9528c, (frame.k + frame.i) / this.f9528c);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.j.b.set(frame.j / this.f9528c, frame.k / this.f9528c, (frame.j + frame.h) / this.f9528c, (frame.k + frame.i) / this.f9528c);
                canvas2.restore();
            }
            a(frame.a(canvas2, this.i, this.f9528c, a(frame.h, frame.i), d()));
            this.e.rewind();
            a2.copyPixelsToBuffer(this.e);
            a(a2);
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
        if (this.j.f9521c != null) {
            this.j.f9521c.clear();
            this.j.f9521c = null;
        }
        APNGWriter aPNGWriter = this.g;
        if (aPNGWriter != null) {
            aPNGWriter.c();
            this.g = null;
        }
    }
}

package com.sobot.chat.widget.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.io.InputStream;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView.class */
public class GifView extends View implements GifAction {
    private GifImageType animationType;
    private Bitmap currentImage;
    private DrawThread drawThread;
    private GifDecoder gifDecoder;
    private boolean isRun;
    private boolean pause;
    private Rect rect;
    private Handler redrawHandler;
    private int showHeight;
    private int showWidth;

    /* renamed from: com.sobot.chat.widget.gif.GifView$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$sobot$chat$widget$gif$GifView$GifImageType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[GifImageType.values().length];
            $SwitchMap$com$sobot$chat$widget$gif$GifView$GifImageType = iArr;
            try {
                iArr[GifImageType.WAIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$gif$GifView$GifImageType[GifImageType.COVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$sobot$chat$widget$gif$GifView$GifImageType[GifImageType.SYNC_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView$DrawThread.class */
    class DrawThread extends Thread {
        private DrawThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (GifView.this.gifDecoder == null) {
                return;
            }
            while (GifView.this.isRun) {
                if (GifView.this.pause) {
                    SystemClock.sleep(10L);
                } else {
                    GifFrame next = GifView.this.gifDecoder.next();
                    GifView.this.currentImage = next.image;
                    long j = next.delay;
                    if (GifView.this.redrawHandler == null) {
                        return;
                    }
                    GifView.this.redrawHandler.sendMessage(GifView.this.redrawHandler.obtainMessage());
                    SystemClock.sleep(j);
                }
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/gif/GifView$GifImageType.class */
    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        GifImageType(int i) {
            this.nativeInt = i;
        }
    }

    public GifView(Context context) {
        super(context);
        this.gifDecoder = null;
        this.currentImage = null;
        this.isRun = true;
        this.pause = false;
        this.showWidth = -1;
        this.showHeight = -1;
        this.rect = null;
        this.drawThread = null;
        this.animationType = GifImageType.SYNC_DECODER;
        this.redrawHandler = new Handler() { // from class: com.sobot.chat.widget.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                GifView.this.invalidate();
            }
        };
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gifDecoder = null;
        this.currentImage = null;
        this.isRun = true;
        this.pause = false;
        this.showWidth = -1;
        this.showHeight = -1;
        this.rect = null;
        this.drawThread = null;
        this.animationType = GifImageType.SYNC_DECODER;
        this.redrawHandler = new Handler() { // from class: com.sobot.chat.widget.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                GifView.this.invalidate();
            }
        };
    }

    private void reDraw() {
        Handler handler = this.redrawHandler;
        if (handler != null) {
            this.redrawHandler.sendMessage(handler.obtainMessage());
        }
    }

    private void setGifDecoderImage(InputStream inputStream) {
        GifDecoder gifDecoder = this.gifDecoder;
        if (gifDecoder != null) {
            gifDecoder.free();
            this.gifDecoder = null;
        }
        GifDecoder gifDecoder2 = new GifDecoder(inputStream, this);
        this.gifDecoder = gifDecoder2;
        gifDecoder2.start();
    }

    private void setGifDecoderImage(byte[] bArr) {
        GifDecoder gifDecoder = this.gifDecoder;
        if (gifDecoder != null) {
            gifDecoder.free();
            this.gifDecoder = null;
        }
        GifDecoder gifDecoder2 = new GifDecoder(bArr, this);
        this.gifDecoder = gifDecoder2;
        gifDecoder2.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        GifDecoder gifDecoder = this.gifDecoder;
        if (gifDecoder == null) {
            return;
        }
        if (this.currentImage == null) {
            this.currentImage = gifDecoder.getImage();
        }
        if (this.currentImage == null) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        if (this.showWidth == -1) {
            canvas.drawBitmap(this.currentImage, 0.0f, 0.0f, (Paint) null);
        } else {
            canvas.drawBitmap(this.currentImage, (Rect) null, this.rect, (Paint) null);
        }
        canvas.restoreToCount(saveCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        GifDecoder gifDecoder = this.gifDecoder;
        int i4 = 1;
        if (gifDecoder == null) {
            i3 = 1;
        } else {
            i4 = gifDecoder.width;
            i3 = this.gifDecoder.height;
        }
        setMeasuredDimension(resolveSize(Math.max(i4 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i3 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i2));
    }

    @Override // com.sobot.chat.widget.gif.GifAction
    public void parseOk(boolean z, int i) {
        if (z) {
            if (this.gifDecoder == null) {
                Log.e("gif", "parse error");
                return;
            }
            int i2 = AnonymousClass2.$SwitchMap$com$sobot$chat$widget$gif$GifView$GifImageType[this.animationType.ordinal()];
            if (i2 == 1) {
                if (i == -1) {
                    if (this.gifDecoder.getFrameCount() > 1) {
                        new DrawThread().start();
                    } else {
                        reDraw();
                    }
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                if (i == 1) {
                    this.currentImage = this.gifDecoder.getImage();
                    reDraw();
                } else if (i == -1) {
                    reDraw();
                } else if (this.drawThread == null) {
                    DrawThread drawThread = new DrawThread();
                    this.drawThread = drawThread;
                    drawThread.start();
                }
            } else if (i == 1) {
                this.currentImage = this.gifDecoder.getImage();
                reDraw();
            } else if (i == -1) {
                if (this.gifDecoder.getFrameCount() <= 1) {
                    reDraw();
                } else if (this.drawThread == null) {
                    DrawThread drawThread2 = new DrawThread();
                    this.drawThread = drawThread2;
                    drawThread2.start();
                }
            }
        }
    }

    public void setGifImage(int i) {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImageType(GifImageType gifImageType) {
        if (this.gifDecoder == null) {
            this.animationType = gifImageType;
        }
    }

    public void setShowDimension(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.showWidth = i;
        this.showHeight = i2;
        Rect rect = new Rect();
        this.rect = rect;
        rect.left = 0;
        this.rect.top = 0;
        this.rect.right = i;
        this.rect.bottom = i2;
    }

    public void showAnimation() {
        if (this.pause) {
            this.pause = false;
        }
    }

    public void showCover() {
        GifDecoder gifDecoder = this.gifDecoder;
        if (gifDecoder == null) {
            return;
        }
        this.pause = true;
        this.currentImage = gifDecoder.getImage();
        invalidate();
    }

    public void startGifView() {
        this.isRun = true;
    }

    public void stopGifView() {
        this.isRun = false;
    }
}

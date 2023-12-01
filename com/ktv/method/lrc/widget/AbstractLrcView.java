package com.ktv.method.lrc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.ktv.method.lrc.LyricsReader;
import com.ktv.method.lrc.model.LyricsLineInfo;
import com.ktv.method.lrc.utils.LyricsUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/AbstractLrcView.class */
public abstract class AbstractLrcView extends View {
    private int A;
    private int B;
    private float C;
    private int D;
    private ExtraLyricsListener E;
    private float F;
    private float G;
    private int H;
    private int I;
    private int J;
    private int K;
    private float L;
    private LyricsReader M;
    private TreeMap<Integer, LyricsLineInfo> N;
    private List<LyricsLineInfo> O;
    private List<LyricsLineInfo> P;
    private byte[] Q;
    private int R;
    private long S;
    private long T;
    private long U;
    private long V;
    private Handler W;

    /* renamed from: a  reason: collision with root package name */
    private Paint f23701a;
    private HandlerThread aa;
    private Handler ab;
    private WeakReference<Context> ac;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f23702c;
    private Paint d;
    private int[] e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private String k;
    private String l;
    private String m;
    private String n;
    private RectF o;
    private boolean p;
    private Paint q;
    private Paint r;
    private int s;
    private SearchLyricsListener t;
    private float u;
    private float v;
    private float w;
    private float x;
    private int y;
    private int z;

    /* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/AbstractLrcView$ExtraLyricsListener.class */
    public interface ExtraLyricsListener {
        void a();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/AbstractLrcView$SearchLyricsListener.class */
    public interface SearchLyricsListener {
    }

    public AbstractLrcView(Context context) {
        super(context);
        this.f23702c = new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")};
        this.e = new int[]{Color.parseColor("#00E0AB"), Color.parseColor("#00E0AB")};
        this.p = false;
        this.s = 0;
        this.u = 20.0f;
        this.v = 40.0f;
        this.w = 15.0f;
        this.x = 0.0f;
        this.y = 0;
        this.z = 0;
        this.A = -1;
        this.B = -1;
        this.C = 0.0f;
        this.D = 0;
        this.F = 30.0f;
        this.G = 30.0f;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0.0f;
        this.Q = new byte[0];
        this.R = 0;
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 30L;
        this.ab = new Handler(Looper.getMainLooper()) { // from class: com.ktv.method.lrc.widget.AbstractLrcView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (((Context) AbstractLrcView.this.ac.get()) != null) {
                    synchronized (AbstractLrcView.this.Q) {
                        if (AbstractLrcView.this.R == 1 && AbstractLrcView.this.M != null) {
                            AbstractLrcView.this.a();
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = AbstractLrcView.this.S;
                            long j2 = AbstractLrcView.this.T;
                            AbstractLrcView.this.T = currentTimeMillis - AbstractLrcView.this.S;
                            AbstractLrcView.this.W.sendEmptyMessageDelayed(0, Math.max(0L, AbstractLrcView.this.V - ((currentTimeMillis - j) - j2)));
                        }
                    }
                }
            }
        };
        a(context);
    }

    public AbstractLrcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23702c = new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")};
        this.e = new int[]{Color.parseColor("#00E0AB"), Color.parseColor("#00E0AB")};
        this.p = false;
        this.s = 0;
        this.u = 20.0f;
        this.v = 40.0f;
        this.w = 15.0f;
        this.x = 0.0f;
        this.y = 0;
        this.z = 0;
        this.A = -1;
        this.B = -1;
        this.C = 0.0f;
        this.D = 0;
        this.F = 30.0f;
        this.G = 30.0f;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0.0f;
        this.Q = new byte[0];
        this.R = 0;
        this.S = 0L;
        this.T = 0L;
        this.U = 0L;
        this.V = 30L;
        this.ab = new Handler(Looper.getMainLooper()) { // from class: com.ktv.method.lrc.widget.AbstractLrcView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (((Context) AbstractLrcView.this.ac.get()) != null) {
                    synchronized (AbstractLrcView.this.Q) {
                        if (AbstractLrcView.this.R == 1 && AbstractLrcView.this.M != null) {
                            AbstractLrcView.this.a();
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = AbstractLrcView.this.S;
                            long j2 = AbstractLrcView.this.T;
                            AbstractLrcView.this.T = currentTimeMillis - AbstractLrcView.this.S;
                            AbstractLrcView.this.W.sendEmptyMessageDelayed(0, Math.max(0L, AbstractLrcView.this.V - ((currentTimeMillis - j) - j2)));
                        }
                    }
                }
            }
        };
        a(context);
    }

    private void a(Context context) {
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        Paint paint = new Paint();
        this.f23701a = paint;
        paint.setDither(true);
        this.f23701a.setAntiAlias(true);
        this.f23701a.setTextSize(this.v);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setDither(true);
        this.b.setAntiAlias(true);
        this.b.setTextSize(this.v);
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.setDither(true);
        this.d.setAntiAlias(true);
        this.d.setTextSize(this.v);
        Paint paint4 = new Paint();
        this.f = paint4;
        paint4.setDither(true);
        this.f.setAntiAlias(true);
        this.f.setColor(-16777216);
        this.f.setTextSize(this.v);
        Paint paint5 = new Paint();
        this.g = paint5;
        paint5.setDither(true);
        this.g.setAntiAlias(true);
        this.g.setColor(-16777216);
        this.g.setTextSize(this.v);
        Paint paint6 = new Paint();
        this.h = paint6;
        paint6.setDither(true);
        this.h.setAntiAlias(true);
        this.h.setTextSize(this.G);
        Paint paint7 = new Paint();
        this.i = paint7;
        paint7.setDither(true);
        this.i.setAntiAlias(true);
        this.i.setTextSize(this.G);
        Paint paint8 = new Paint();
        this.j = paint8;
        paint8.setDither(true);
        this.j.setAntiAlias(true);
        this.j.setColor(-16777216);
        this.j.setTextSize(this.G);
        Paint paint9 = new Paint();
        this.r = paint9;
        paint9.setDither(true);
        this.r.setAntiAlias(true);
        this.r.setTextSize(this.v);
        Paint paint10 = new Paint();
        this.q = paint10;
        paint10.setDither(true);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(2.0f);
        this.q.setTextSize(this.v);
        this.ac = new WeakReference<>(context);
        HandlerThread handlerThread = new HandlerThread("updateLrcData", 10);
        this.aa = handlerThread;
        handlerThread.start();
        this.W = new Handler(this.aa.getLooper(), new Handler.Callback() { // from class: com.ktv.method.lrc.widget.AbstractLrcView.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (((Context) AbstractLrcView.this.ac.get()) != null) {
                    synchronized (AbstractLrcView.this.Q) {
                        if (AbstractLrcView.this.M != null) {
                            AbstractLrcView.this.a(AbstractLrcView.this.U + AbstractLrcView.this.T);
                            if (AbstractLrcView.this.R == 1) {
                                AbstractLrcView.this.ab.sendEmptyMessage(0);
                            } else if (AbstractLrcView.this.R == 2) {
                                AbstractLrcView.this.a();
                            }
                        }
                    }
                    return false;
                }
                return false;
            }
        });
    }

    private void b(Canvas canvas) {
        synchronized (this.Q) {
            this.f23701a.setAlpha(255);
            this.d.setAlpha(255);
            this.h.setAlpha(255);
            this.i.setAlpha(255);
            if (this.s != 1 && this.s != 5 && this.s != 6 && this.s == 4) {
                a(canvas);
            }
        }
    }

    private void e() {
        this.R = 0;
        f();
        this.U = 0L;
        this.S = 0L;
        this.T = 0L;
        this.y = 0;
        this.z = 0;
        this.A = -1;
        this.B = -1;
        this.C = 0.0f;
        this.N = null;
        this.O = null;
        this.P = null;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.L = 0.0f;
        ExtraLyricsListener extraLyricsListener = this.E;
        if (extraLyricsListener != null) {
            extraLyricsListener.a();
        }
    }

    private void f() {
        Handler handler = this.ab;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.W;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public void a() {
        synchronized (this) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                invalidate();
            } else {
                postInvalidate();
            }
        }
    }

    public void a(float f, boolean z) {
        this.u = f;
        if (z) {
            a();
        }
    }

    protected abstract void a(long j);

    protected abstract void a(Canvas canvas);

    public void a(Typeface typeface, boolean z) {
        if (typeface != null) {
            this.f23701a.setTypeface(typeface);
            this.d.setTypeface(typeface);
            this.f.setTypeface(typeface);
            this.h.setTypeface(typeface);
            this.i.setTypeface(typeface);
            this.j.setTypeface(typeface);
        }
        if (z) {
            a();
        }
    }

    public void a(int[] iArr, boolean z) {
        this.f23702c = iArr;
        if (z) {
            a();
        }
    }

    public void b() {
        synchronized (this.Q) {
            this.M = null;
            this.s = 0;
            e();
            a();
        }
    }

    public void b(long j) {
        synchronized (this.Q) {
            if (j - 400 > this.U) {
                c(j);
                return;
            }
            if (this.R == 1) {
                f();
            }
            this.R = 1;
            this.U = j;
            this.S = System.currentTimeMillis();
            this.T = 0L;
            this.W.sendEmptyMessageDelayed(0, 0L);
        }
    }

    public void b(int[] iArr, boolean z) {
        this.e = iArr;
        if (z) {
            a();
        }
    }

    public void c(long j) {
        synchronized (this.Q) {
            this.R = 2;
            this.U = j;
            this.S = System.currentTimeMillis();
            this.T = 0L;
            this.W.sendEmptyMessageDelayed(0, 0L);
        }
    }

    public boolean c() {
        LyricsReader lyricsReader = this.M;
        if (lyricsReader == null || lyricsReader.b() == null || this.M.b().size() <= 0) {
            return false;
        }
        if (this.M.a() == 1) {
            this.N = LyricsUtils.a(this.M.b(), this.x, this.f23701a);
            return true;
        }
        return true;
    }

    public void d() {
        f();
        HandlerThread handlerThread = this.aa;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void d(long j) {
        if (this.N == null) {
            return;
        }
        if (this.M.a() != 1) {
            this.z = LyricsUtils.b(this.N, this.y, j, this.M.c());
            return;
        }
        this.z = LyricsUtils.a(this.N, this.y, j, this.M.c());
        this.A = LyricsUtils.d(this.N, this.y, j, this.M.c());
        this.B = LyricsUtils.c(this.N, this.y, j, this.M.c());
        this.C = (float) LyricsUtils.e(this.N, this.y, j, this.M.c());
    }

    public Paint getExtraLrcPaint() {
        return this.h;
    }

    public Paint getExtraLrcPaintHL() {
        return this.i;
    }

    public Paint getExtraLrcPaintOutline() {
        return this.j;
    }

    public int getExtraLyricsWordIndex() {
        return this.I;
    }

    public int getExtraSplitLyricsLineNum() {
        return this.H;
    }

    public int getExtraSplitLyricsWordIndex() {
        return this.J;
    }

    public String getGotoSearchText() {
        return this.n;
    }

    public String getLoadErrorText() {
        return this.l;
    }

    public String getLoadingText() {
        return this.k;
    }

    public TreeMap<Integer, LyricsLineInfo> getLrcLineInfos() {
        return this.N;
    }

    public int getLrcPlayerStatus() {
        return this.R;
    }

    public int getLrcStatus() {
        return this.s;
    }

    public int getLyricsLineNum() {
        return this.y;
    }

    public LyricsReader getLyricsReader() {
        return this.M;
    }

    public float getLyricsWordHLTime() {
        return this.C;
    }

    public int getLyricsWordIndex() {
        return this.A;
    }

    public String getNonsupportText() {
        return this.m;
    }

    public float getPaddingLeftOrRight() {
        return this.w;
    }

    public Paint getPaint() {
        return this.f23701a;
    }

    public int[] getPaintColors() {
        return this.f23702c;
    }

    public Paint getPaintHL() {
        return this.d;
    }

    public int[] getPaintHLColors() {
        return this.e;
    }

    public Paint getPaintOutline() {
        return this.f;
    }

    public float getSpaceLineHeight() {
        return this.u;
    }

    public int getSplitLyricsLineNum() {
        return this.z;
    }

    public int getSplitLyricsWordIndex() {
        return this.B;
    }

    public int getTranslateDrawType() {
        return this.K;
    }

    public List<LyricsLineInfo> getTranslateLrcLineInfos() {
        return this.O;
    }

    public float getTranslateLyricsWordHLTime() {
        return this.L;
    }

    public List<LyricsLineInfo> getTransliterationLrcLineInfos() {
        return this.P;
    }

    public Paint getmPaintNo() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        b(canvas);
    }

    public void setFontSize(float f) {
        synchronized (this.Q) {
            this.v = f;
            this.f23701a.setTextSize(f);
            this.d.setTextSize(this.v);
            this.f.setTextSize(this.v);
            if (this.t != null) {
                this.q.setTextSize(this.v);
                this.r.setTextSize(this.v);
                this.o = null;
            }
        }
    }

    public void setGotoSearchText(String str) {
        this.n = str;
    }

    public void setLoadErrorText(String str) {
        this.l = str;
    }

    public void setLoadingText(String str) {
        this.k = str;
    }

    public void setLrcStatus(int i) {
        this.s = i;
        a();
    }

    public void setLyricsLineNum(int i) {
        this.y = i;
    }

    public void setLyricsReader(LyricsReader lyricsReader) {
        synchronized (this.Q) {
            this.M = lyricsReader;
            e();
            if (c()) {
                this.s = 4;
                a(this.U);
            }
            a();
        }
    }

    public void setNonsupportText(String str) {
        this.m = str;
    }

    public void setRefreshTime(long j) {
        this.V = j;
    }

    public void setTextMaxWidth(float f) {
        this.x = f;
    }
}

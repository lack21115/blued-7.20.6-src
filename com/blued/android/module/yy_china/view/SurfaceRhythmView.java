package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/SurfaceRhythmView.class */
public final class SurfaceRhythmView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private final float a;
    private final float b;
    private final float c;
    private final int d;
    private Bitmap e;
    private CopyOnWriteArrayList<YYTXSongScoreNoteItem> f;
    private CopyOnWriteArrayList<YYTXSongScoreNoteItem> g;
    private CopyOnWriteArrayList<YYTXSongScoreNoteItem> h;
    private final ArrayList<Bitmap> i;
    private float j;
    private YYUserSongScoreNoteItem k;
    private final Paint l;
    private final Paint m;
    private final Paint n;
    private final float o;
    private final float p;
    private int q;
    private RhythmViewHanlder r;
    private SurfaceHolder s;
    private float t;
    private DrawInfo u;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/SurfaceRhythmView$DrawInfo.class */
    public final class DrawInfo {
        final /* synthetic */ SurfaceRhythmView a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private Path i;
        private Path j;
        private float k;
        private float l;
        private float m;

        public DrawInfo(SurfaceRhythmView this$0) {
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.i = new Path();
            this.j = new Path();
        }

        public final float a() {
            return this.b;
        }

        public final void a(float f) {
            this.f = f;
        }

        public final float b() {
            return this.c;
        }

        public final void b(float f) {
            this.g = f;
        }

        public final float c() {
            return this.d;
        }

        public final void c(float f) {
            this.h = f;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.f;
        }

        public final float f() {
            return this.g;
        }

        public final float g() {
            return this.h;
        }

        public final Path h() {
            return this.i;
        }

        public final Path i() {
            return this.j;
        }

        public final float j() {
            return this.k;
        }

        public final float k() {
            return this.l;
        }

        public final float l() {
            return this.m;
        }

        public final void m() {
            Bitmap selBitmap;
            Bitmap selBitmap2;
            Bitmap selBitmap3;
            this.b = this.a.getHeight() - ((this.a.getSelBitmap() == null ? 0 : selBitmap.getHeight()) / 2.0f);
            float f = 5;
            this.c = (this.a.getWidth() * 2.0f) / f;
            float width = (this.a.getWidth() * 2.0f) / f;
            float f2 = 2;
            this.d = width + f2;
            this.e = this.b - 3;
            this.i = new Path();
            this.j = new Path();
            this.a.a(this.i, (int) this.b);
            this.a.b(this.j, (int) this.b);
            YYUserSongScoreNoteItem yYUserSongScoreNoteItem = this.a.k;
            if (yYUserSongScoreNoteItem != null) {
                SurfaceRhythmView surfaceRhythmView = this.a;
                a(((((a() - (surfaceRhythmView.p * f2)) - surfaceRhythmView.o) * yYUserSongScoreNoteItem.c()) / 100.0f) + surfaceRhythmView.o + surfaceRhythmView.p);
                if (yYUserSongScoreNoteItem.c() == 0) {
                    a(a());
                }
                b(((surfaceRhythmView.getWidth() * 2.0f) / f) - ((surfaceRhythmView.getSelBitmap() == null ? 0 : selBitmap2.getWidth()) / 2.0f));
                c(e() - ((surfaceRhythmView.getSelBitmap() == null ? 0 : selBitmap3.getHeight()) / 2.0f));
            }
            this.k = this.b / 2.0f;
            this.l = (this.a.getWidth() * 2.0f) / f;
            this.m = (this.a.getWidth() * 2.0f) / f;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/SurfaceRhythmView$RhythmViewHanlder.class */
    public static final class RhythmViewHanlder extends Handler {
        private boolean a;
        private boolean b;
        private final WeakReference<SurfaceRhythmView> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RhythmViewHanlder(SurfaceRhythmView view, Looper looper) {
            super(looper);
            Intrinsics.e(view, "view");
            Intrinsics.e(looper, "looper");
            view.d();
            this.b = true;
            this.c = new WeakReference<>(view);
        }

        public final WeakReference<SurfaceRhythmView> a() {
            return this.c;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void b(boolean z) {
            this.b = z;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Canvas lockCanvas;
            SurfaceHolder surfaceHolder;
            DrawInfo info;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 3 || msg.obj == null) {
                return;
            }
            SurfaceRhythmView surfaceRhythmView = this.c.get();
            if ((surfaceRhythmView == null ? null : surfaceRhythmView.getSelBitmap()) == null) {
                return;
            }
            SurfaceRhythmView surfaceRhythmView2 = this.c.get();
            if (surfaceRhythmView2 != null) {
                surfaceRhythmView2.a(msg);
            }
            SurfaceRhythmView surfaceRhythmView3 = this.c.get();
            if (surfaceRhythmView3 != null && (info = surfaceRhythmView3.getInfo()) != null) {
                info.m();
            }
            if (!this.a && this.b) {
                SurfaceRhythmView surfaceRhythmView4 = this.c.get();
                if (surfaceRhythmView4 == null) {
                    lockCanvas = null;
                } else {
                    SurfaceHolder surfaceHolder2 = surfaceRhythmView4.s;
                    lockCanvas = surfaceHolder2 == null ? null : surfaceHolder2.lockCanvas();
                }
                if (lockCanvas == null) {
                    return;
                }
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                SurfaceRhythmView surfaceRhythmView5 = a().get();
                if (surfaceRhythmView5 != null) {
                    surfaceRhythmView5.a(lockCanvas);
                }
                try {
                    SurfaceRhythmView surfaceRhythmView6 = a().get();
                    if (surfaceRhythmView6 == null || (surfaceHolder = surfaceRhythmView6.s) == null) {
                        return;
                    }
                    surfaceHolder.unlockCanvasAndPost(lockCanvas);
                    Unit unit = Unit.a;
                } catch (Exception e) {
                    Unit unit2 = Unit.a;
                }
            }
        }
    }

    public SurfaceRhythmView(Context context) {
        this(context, null);
    }

    public SurfaceRhythmView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SurfaceRhythmView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 2000.0f;
        this.b = 3000.0f;
        this.c = 5000.0f;
        this.d = 3;
        this.e = BitmapFactory.decodeResource(getResources(), R.drawable.icon_yy_ktv_select);
        this.f = new CopyOnWriteArrayList<>();
        this.g = new CopyOnWriteArrayList<>();
        this.h = new CopyOnWriteArrayList<>();
        this.i = new ArrayList<>();
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(60.0f);
        this.l = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(60.0f);
        this.m = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        this.n = paint3;
        this.o = getResources().getDimensionPixelOffset(R.dimen.dp_13);
        this.p = getResources().getDimensionPixelOffset(R.dimen.dp_3);
        SurfaceHolder holder = getHolder();
        this.s = holder;
        if (holder != null) {
            holder.addCallback(this);
        }
        if (!isInEditMode()) {
            setZOrderOnTop(true);
        }
        SurfaceHolder surfaceHolder = this.s;
        if (surfaceHolder != null) {
            surfaceHolder.setFormat(-3);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$SurfaceRhythmView$S3UXLrkeK_1LuK1zLe_mDtAdqmw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurfaceRhythmView.a(SurfaceRhythmView.this, view);
            }
        });
        d();
        this.t = -1.0f;
        this.u = new DrawInfo(this);
    }

    private final void a(Path path, float f, float f2, float f3) {
        float f4 = this.p;
        path.addRoundRect(new RectF(f, f3 - f4, f2, f3 + f4), 10.0f, 10.0f, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Path path, int i) {
        for (YYTXSongScoreNoteItem yYTXSongScoreNoteItem : this.f) {
            a(path, (getWidth() * (yYTXSongScoreNoteItem.a - this.j)) / this.c, (getWidth() * (yYTXSongScoreNoteItem.c - this.j)) / this.c, ((((i - (this.p * 2)) - this.o) * yYTXSongScoreNoteItem.d) / 100.0f) + this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SurfaceRhythmView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        RhythmViewHanlder rhythmViewHanlder = this$0.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Path path, int i) {
        for (YYTXSongScoreNoteItem yYTXSongScoreNoteItem : this.h) {
            a(path, (getWidth() * (yYTXSongScoreNoteItem.a - this.j)) / this.c, (getWidth() * (yYTXSongScoreNoteItem.c - this.j)) / this.c, ((((i - (this.p * 2)) - this.o) * yYTXSongScoreNoteItem.d) / 100.0f) + this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.e = BitmapFactory.decodeResource(getResources(), R.drawable.icon_yy_ktv_select);
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_01));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_02));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_03));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_04));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_05));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_06));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_07));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_08));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_09));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_10));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_11));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_12));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_13));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_14));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_15));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_16));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_17));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_18));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_19));
        this.i.add(BitmapFactory.decodeResource(getResources(), R.drawable.ktv_stay_20));
    }

    public final void a() {
        Message obtain = Message.obtain();
        obtain.obj = new ArrayList();
        obtain.what = 1;
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.sendMessage(obtain);
    }

    public final void a(Canvas ca) {
        Intrinsics.e(ca, "ca");
        this.n.setColor(getResources().getColor(R.color.white));
        this.n.setStrokeWidth(1.0f);
        this.n.setAlpha(67);
        ca.drawLine(this.u.b(), this.o, this.u.c(), this.u.d(), this.n);
        ca.drawLine(0.0f, this.u.a(), getWidth(), this.u.a(), this.n);
        this.n.setAlpha(255);
        int saveLayer = ca.saveLayer(0.0f, 0.0f, getWidth() * 1.0f, this.u.a(), null);
        this.l.setColor(getResources().getColor(R.color.white_alpha70));
        ca.drawPath(this.u.h(), this.l);
        this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.l.setColor(getResources().getColor(R.color.syc_00E9C1));
        ca.drawPath(this.u.i(), this.l);
        this.l.setXfermode(null);
        ca.restoreToCount(saveLayer);
        YYUserSongScoreNoteItem yYUserSongScoreNoteItem = this.k;
        if (yYUserSongScoreNoteItem != null) {
            if (getSelBitmap() != null && !getSelBitmap().isRecycled()) {
                ca.drawBitmap(getSelBitmap(), getInfo().f(), getInfo().g(), this.m);
            }
            if (yYUserSongScoreNoteItem.a()) {
                this.m.setShader(new LinearGradient(0.0f, getInfo().j(), getInfo().k(), getInfo().j(), getResources().getColor(R.color.white_alpha04), getResources().getColor(R.color.white_alpha30), Shader.TileMode.CLAMP));
                ca.drawRect(0.0f, this.o, (getWidth() * 2.0f) / 5, getInfo().a(), this.m);
                if (this.q / this.d < this.i.size()) {
                    Bitmap bitmap = this.i.get(this.q / this.d);
                    Intrinsics.c(bitmap, "bims[stayNum / BIT_ALL]");
                    Bitmap bitmap2 = bitmap;
                    if (!bitmap2.isRecycled()) {
                        ca.drawBitmap(bitmap2, getInfo().l(), getInfo().e() - bitmap2.getHeight(), this.m);
                    }
                }
            }
        }
        int i = this.q + 1;
        this.q = i;
        if (i >= this.i.size() * this.d) {
            this.q = 0;
        }
    }

    public final void a(Message msg) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YYMsgKtvMusic yYMsgKtvMusic2;
        Intrinsics.e(msg, "msg");
        int i = msg.what;
        if (i == 1) {
            Object obj = msg.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem> }");
            }
            ArrayList arrayList = (ArrayList) obj;
            this.f.clear();
            this.g.clear();
            this.h.clear();
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null || (yYMsgKtvMusic = b.music) == null) {
                return;
            }
            yYMsgKtvMusic.getRealData().clear();
            yYMsgKtvMusic.getUserData().clear();
            CopyOnWriteArrayList<YYTXSongScoreNoteItem> realData = yYMsgKtvMusic.getRealData();
            Intrinsics.c(realData, "it.realData");
            this.g = realData;
            CopyOnWriteArrayList<YYTXSongScoreNoteItem> userData = yYMsgKtvMusic.getUserData();
            Intrinsics.c(userData, "it.userData");
            this.h = userData;
            this.g.addAll(arrayList);
            this.j = 0 - this.a;
        } else if (i == 2) {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null && (yYMsgKtvMusic2 = b2.music) != null) {
                CopyOnWriteArrayList<YYTXSongScoreNoteItem> realData2 = yYMsgKtvMusic2.getRealData();
                Intrinsics.c(realData2, "it.realData");
                this.g = realData2;
                CopyOnWriteArrayList<YYTXSongScoreNoteItem> userData2 = yYMsgKtvMusic2.getUserData();
                Intrinsics.c(userData2, "it.userData");
                this.h = userData2;
            }
            YYUserSongScoreNoteItem yYUserSongScoreNoteItem = this.k;
            Object obj2 = msg.obj;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem");
            }
            YYUserSongScoreNoteItem yYUserSongScoreNoteItem2 = (YYUserSongScoreNoteItem) obj2;
            float b3 = yYUserSongScoreNoteItem2.b() - this.a;
            float b4 = yYUserSongScoreNoteItem2.b();
            float f = this.b;
            this.j = b3;
            this.k = yYUserSongScoreNoteItem2;
            this.f.clear();
            if (this.g.size() > 0) {
                Iterator<YYTXSongScoreNoteItem> it = this.g.iterator();
                while (it.hasNext()) {
                    YYTXSongScoreNoteItem next = it.next();
                    if (next.c < b3) {
                        this.g.remove(next);
                    }
                }
                for (YYTXSongScoreNoteItem yYTXSongScoreNoteItem : this.g) {
                    if (b4 + f > yYTXSongScoreNoteItem.a) {
                        this.f.add(yYTXSongScoreNoteItem);
                    }
                }
            }
            if (this.h.size() <= 0) {
                if (!yYUserSongScoreNoteItem2.a()) {
                    this.t = yYUserSongScoreNoteItem2.b();
                    return;
                }
                YYTXSongScoreNoteItem yYTXSongScoreNoteItem2 = new YYTXSongScoreNoteItem();
                yYTXSongScoreNoteItem2.a = (int) yYUserSongScoreNoteItem2.b();
                yYTXSongScoreNoteItem2.c = (int) yYUserSongScoreNoteItem2.b();
                yYTXSongScoreNoteItem2.d = yYUserSongScoreNoteItem2.c();
                this.h.add(yYTXSongScoreNoteItem2);
                this.t = -1.0f;
                return;
            }
            CopyOnWriteArrayList<YYTXSongScoreNoteItem> copyOnWriteArrayList = this.h;
            YYTXSongScoreNoteItem yYTXSongScoreNoteItem3 = copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1);
            if (yYUserSongScoreNoteItem2.a()) {
                if (yYTXSongScoreNoteItem3.d == yYUserSongScoreNoteItem2.c()) {
                    if (this.t == -1.0f) {
                        yYTXSongScoreNoteItem3.c = (int) yYUserSongScoreNoteItem2.b();
                    } else {
                        YYTXSongScoreNoteItem yYTXSongScoreNoteItem4 = new YYTXSongScoreNoteItem();
                        yYTXSongScoreNoteItem4.a = (int) yYUserSongScoreNoteItem2.b();
                        yYTXSongScoreNoteItem4.c = (int) yYUserSongScoreNoteItem2.b();
                        yYTXSongScoreNoteItem4.d = yYUserSongScoreNoteItem2.c();
                        this.h.add(yYTXSongScoreNoteItem4);
                    }
                } else {
                    YYTXSongScoreNoteItem yYTXSongScoreNoteItem5 = new YYTXSongScoreNoteItem();
                    if (!(this.t == -1.0f)) {
                        yYTXSongScoreNoteItem5.a = (int) this.t;
                    } else if (yYUserSongScoreNoteItem != null) {
                        yYTXSongScoreNoteItem5.a = (int) yYUserSongScoreNoteItem.b();
                    }
                    yYTXSongScoreNoteItem5.c = (int) yYUserSongScoreNoteItem2.b();
                    yYTXSongScoreNoteItem5.d = yYUserSongScoreNoteItem2.c();
                    this.h.add(yYTXSongScoreNoteItem5);
                }
                this.t = -1.0f;
            } else {
                this.t = yYUserSongScoreNoteItem2.b();
            }
            if (this.h.get(0).c < b3) {
                this.h.remove(0);
            }
        }
    }

    public final void a(YYUserSongScoreNoteItem itemGrove) {
        Intrinsics.e(itemGrove, "itemGrove");
        Message obtain = Message.obtain();
        obtain.obj = itemGrove;
        obtain.what = 2;
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.sendMessage(obtain);
    }

    public final void a(ArrayList<YYTXSongScoreNoteItem> allGrove) {
        Intrinsics.e(allGrove, "allGrove");
        Message obtain = Message.obtain();
        obtain.obj = allGrove;
        obtain.what = 1;
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.sendMessage(obtain);
    }

    public final void b() {
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.a(true);
    }

    public final void c() {
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.a(false);
    }

    public final DrawInfo getInfo() {
        return this.u;
    }

    public final Bitmap getSelBitmap() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int i) {
        Intrinsics.e(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.b(i == 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        Looper myLooper = Looper.myLooper();
        Intrinsics.a(myLooper);
        Intrinsics.c(myLooper, "myLooper()!!");
        this.r = new RhythmViewHanlder(this, myLooper);
        Looper.loop();
    }

    public final void setCon(float f) {
        this.t = f;
    }

    public final void setInfo(DrawInfo drawInfo) {
        Intrinsics.e(drawInfo, "<set-?>");
        this.u = drawInfo;
    }

    public final void setSelBitmap(Bitmap bitmap) {
        this.e = bitmap;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder p0, int i, int i2, int i3) {
        Intrinsics.e(p0, "p0");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.e(holder, "holder");
        new Thread(this).start();
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder == null) {
            return;
        }
        rhythmViewHanlder.b(true);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder p0) {
        Looper looper;
        Intrinsics.e(p0, "p0");
        RhythmViewHanlder rhythmViewHanlder = this.r;
        if (rhythmViewHanlder != null) {
            rhythmViewHanlder.b(false);
        }
        this.e.recycle();
        this.e = null;
        Iterator<Bitmap> it = this.i.iterator();
        Intrinsics.c(it, "bims.iterator()");
        while (it.hasNext()) {
            it.next().recycle();
            it.remove();
        }
        this.i.clear();
        RhythmViewHanlder rhythmViewHanlder2 = this.r;
        if (rhythmViewHanlder2 != null) {
            rhythmViewHanlder2.removeCallbacksAndMessages(null);
        }
        RhythmViewHanlder rhythmViewHanlder3 = this.r;
        if (rhythmViewHanlder3 == null || (looper = rhythmViewHanlder3.getLooper()) == null) {
            return;
        }
        looper.quit();
    }
}

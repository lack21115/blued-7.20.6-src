package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlPaintView.class */
public class LiveGiftScrawlPaintView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f13863a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f13864c;
    private int d;
    private Bitmap e;
    private int f;
    private float g;
    private final List<LiveGiftScrawlModel> h;
    private final Map<String, Bitmap> i;
    private final int j;
    private final int k;
    private int l;
    private ScrawlPaintListener m;
    private float n;
    private float o;
    private Map<String, Integer> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftScrawlPaintView$ScrawlPaintListener.class */
    public interface ScrawlPaintListener {
        void a(int i, SpannableStringBuilder spannableStringBuilder, int i2);

        void a(List<LiveGiftScrawlModel> list);
    }

    public LiveGiftScrawlPaintView(Context context) {
        super(context);
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = 150;
        this.k = 10;
        this.l = 0;
        this.p = new HashMap();
        c();
    }

    public LiveGiftScrawlPaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = 150;
        this.k = 10;
        this.l = 0;
        this.p = new HashMap();
        c();
    }

    public LiveGiftScrawlPaintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = 150;
        this.k = 10;
        this.l = 0;
        this.p = new HashMap();
        c();
    }

    public LiveGiftScrawlPaintView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = 150;
        this.k = 10;
        this.l = 0;
        this.p = new HashMap();
        c();
    }

    private void a(float f, float f2) {
        if (this.l < 150) {
            if (this.h.size() > 0) {
                List<LiveGiftScrawlModel> list = this.h;
                list.get(list.size() - 1).addPath(new Point((int) f, (int) f2));
            }
            d();
        }
    }

    private void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.i.containsKey(str) || this.i.get(str) == null) {
            ImageFileLoader.a((IRequestHost) null).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftScrawlPaintView$6eEbzBpfrJTdOR_g02RKbC5u6jw
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    LiveGiftScrawlPaintView.this.a(str, file, exc);
                }
            }).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, File file, Exception exc) {
        Bitmap bitmap;
        if (file == null || !file.exists()) {
            bitmap = this.e;
        } else {
            int i = this.f;
            Bitmap a2 = ImageUtils.a(file, i, i);
            if (a2 != null) {
                int i2 = this.f;
                bitmap = Bitmap.createScaledBitmap(a2, i2, i2, false);
            } else {
                bitmap = null;
            }
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = this.e;
        }
        synchronized (this.i) {
            if (bitmap2 != null) {
                this.i.put(str, bitmap2);
                postInvalidate();
            }
        }
    }

    private void c() {
        this.b = DisplayUtil.a(getContext(), 1.0f);
        int a2 = DisplayUtil.a(getContext(), 40.0f);
        this.f = a2;
        this.g = (a2 * 2) / 3.0f;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.gift_default_icon);
        int i = this.f;
        this.e = Bitmap.createScaledBitmap(decodeResource, i, i, false);
        Paint paint = new Paint();
        this.f13863a = paint;
        paint.setAntiAlias(true);
        this.f13863a.setDither(true);
        this.f13863a.setStrokeWidth(this.b);
        this.f13863a.setStyle(Paint.Style.STROKE);
    }

    private int d() {
        int i;
        SpannableStringBuilder spannableStringBuilder;
        this.p.clear();
        Iterator<LiveGiftScrawlModel> it = this.h.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (!it.hasNext()) {
                break;
            }
            LiveGiftScrawlModel next = it.next();
            if (this.p.containsKey(next.goods_id)) {
                this.p.put(next.goods_id, Integer.valueOf(this.p.get(next.goods_id).intValue() + next.getPath().size()));
            } else {
                this.p.put(next.goods_id, Integer.valueOf(next.getPath().size()));
            }
            i3 = i + next.getPath().size();
        }
        int i4 = 0;
        for (String str : this.p.keySet()) {
            Iterator<LiveGiftScrawlModel> it2 = this.h.iterator();
            while (true) {
                if (it2.hasNext()) {
                    LiveGiftScrawlModel next2 = it2.next();
                    if (StringUtils.a(str, next2.goods_id)) {
                        int intValue = this.p.get(str).intValue();
                        if (intValue < next2.user_store_count) {
                            i4 += intValue;
                        } else {
                            i4 += next2.user_store_count;
                            i2 = (int) (i2 + ((intValue - next2.user_store_count) * next2.beans));
                        }
                    }
                }
            }
        }
        if (i < 10) {
            spannableStringBuilder = new SpannableStringBuilder("礼物数量不少于10个");
        } else if (i2 <= 0) {
            spannableStringBuilder = new SpannableStringBuilder("需要 " + i4 + " 库存");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB119")), 2, String.valueOf(i4).length() + 2, 33);
        } else {
            String valueOf = String.valueOf(i2);
            if (i4 > 0) {
                String valueOf2 = String.valueOf(i4);
                String str2 = "需要 " + valueOf2 + " 库存+ " + i2 + " 弯豆";
                spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB119")), 2, valueOf2.length() + 2, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB119")), str2.lastIndexOf(valueOf), str2.lastIndexOf(valueOf) + valueOf.length(), 33);
            } else {
                String str3 = "需要 " + valueOf + " 弯豆";
                spannableStringBuilder = new SpannableStringBuilder(str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB119")), str3.indexOf(valueOf), str3.indexOf(valueOf) + valueOf.length(), 33);
            }
        }
        ScrawlPaintListener scrawlPaintListener = this.m;
        if (scrawlPaintListener != null) {
            scrawlPaintListener.a(i, spannableStringBuilder, i2);
        }
        if (i >= 150) {
            ScrawlPaintListener scrawlPaintListener2 = this.m;
            if (scrawlPaintListener2 != null) {
                scrawlPaintListener2.a(this.h);
            }
            ToastUtils.b("最多绘制150个礼物");
        }
        this.l = i;
        invalidate();
        return i;
    }

    public void a() {
        int size = this.h.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            } else if (this.h.get(i).getPath().size() > 0) {
                this.h.get(i).clearPath();
                break;
            } else {
                size = i;
            }
        }
        d();
    }

    public void a(LiveGiftModel liveGiftModel) {
        a(new LiveGiftScrawlModel(liveGiftModel));
    }

    public void a(LiveGiftScrawlModel liveGiftScrawlModel) {
        Iterator<LiveGiftScrawlModel> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().getPath().size() == 0) {
                it.remove();
            }
        }
        if (liveGiftScrawlModel != null) {
            this.h.add(liveGiftScrawlModel);
            a(liveGiftScrawlModel.images_static);
        }
    }

    public void b() {
        LiveGiftScrawlModel liveGiftScrawlModel;
        if (this.h.size() > 0) {
            List<LiveGiftScrawlModel> list = this.h;
            list.get(list.size() - 1).clearPath();
            List<LiveGiftScrawlModel> list2 = this.h;
            liveGiftScrawlModel = list2.get(list2.size() - 1);
        } else {
            liveGiftScrawlModel = null;
        }
        this.h.clear();
        if (liveGiftScrawlModel != null) {
            this.h.add(liveGiftScrawlModel);
        }
        d();
    }

    public List<LiveGiftScrawlModel> getScrawlModelList() {
        ArrayList arrayList = new ArrayList();
        for (LiveGiftScrawlModel liveGiftScrawlModel : this.h) {
            if (liveGiftScrawlModel.getPath().size() > 0) {
                LiveGiftScrawlModel liveGiftScrawlModel2 = new LiveGiftScrawlModel(liveGiftScrawlModel);
                liveGiftScrawlModel2.clearPath();
                for (Point point : liveGiftScrawlModel.getPath()) {
                    liveGiftScrawlModel2.addPath(new Point(DisplayUtil.b(getContext(), point.x), DisplayUtil.b(getContext(), point.y)));
                }
                arrayList.add(liveGiftScrawlModel2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (Bitmap bitmap : this.i.values()) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.i.clear();
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        this.h.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h.size() <= 0) {
            canvas.drawColor(0);
            return;
        }
        for (LiveGiftScrawlModel liveGiftScrawlModel : this.h) {
            Bitmap bitmap = this.i.get(liveGiftScrawlModel.images_static);
            Bitmap bitmap2 = bitmap;
            if (bitmap == null) {
                bitmap2 = this.e;
            }
            if (bitmap2 != null) {
                for (Point point : liveGiftScrawlModel.getPath()) {
                    canvas.drawBitmap(bitmap2, point.x - (this.f / 2), point.y - (this.f / 2), this.f13863a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() <= 0 || getMeasuredWidth() == this.f13864c) {
            return;
        }
        this.f13864c = getMeasuredWidth();
        this.d = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = 0.0f;
            this.o = 0.0f;
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (y <= this.d) {
                    float f = x - this.n;
                    float f2 = y - this.o;
                    float f3 = this.g;
                    if ((f * f) + (f2 * f2) > f3 * f3) {
                        a(x, y);
                        this.n = x;
                        this.o = y;
                        return true;
                    }
                    return true;
                }
                return true;
            } else if (action != 3) {
                return super.onTouchEvent(motionEvent);
            }
        }
        if (this.h.size() > 0) {
            List<LiveGiftScrawlModel> list = this.h;
            LiveGiftScrawlModel liveGiftScrawlModel = new LiveGiftScrawlModel(list.get(list.size() - 1));
            liveGiftScrawlModel.clearPath();
            this.h.add(liveGiftScrawlModel);
        }
        postInvalidate();
        return true;
    }

    public void setScrawlPaintListener(ScrawlPaintListener scrawlPaintListener) {
        this.m = scrawlPaintListener;
    }
}

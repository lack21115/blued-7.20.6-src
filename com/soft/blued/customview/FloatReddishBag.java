package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardStatusExtra;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.lang.ref.SoftReference;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/FloatReddishBag.class */
public abstract class FloatReddishBag extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f28418a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28419c;
    private TextView d;
    private Handler e;
    private List<LiveRewardListModel> f;
    private int g;
    private BaseFragment h;
    private String i;
    private boolean j;
    private Long k;
    private int l;
    private float m;
    private RecyclerView.OnScrollListener n;

    /* renamed from: com.soft.blued.customview.FloatReddishBag$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/FloatReddishBag$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardStatusExtra>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FloatReddishBag f28421a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardStatusExtra> bluedEntity) {
            if (bluedEntity == null || !bluedEntity.hasData()) {
                this.f28421a.a(bluedEntity.data, "");
            } else if (bluedEntity.extra != null) {
                String str = bluedEntity.extra.redirect;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f28421a.a(bluedEntity.data, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/FloatReddishBag$MyHandler.class */
    public static class MyHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        SoftReference<FloatReddishBag> f28425a;

        public MyHandler(FloatReddishBag floatReddishBag) {
            this.f28425a = new SoftReference<>(floatReddishBag);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FloatReddishBag floatReddishBag;
            super.handleMessage(message);
            if (message.what == 0 && (floatReddishBag = this.f28425a.get()) != null) {
                floatReddishBag.c();
                floatReddishBag.a((long) m.ag);
            }
        }
    }

    public FloatReddishBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.n = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.customview.FloatReddishBag.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (recyclerView.getChildAt(0) != null) {
                    if (FloatReddishBag.this.k == null) {
                        FloatReddishBag.this.k = Long.valueOf(System.currentTimeMillis());
                    }
                    int top = recyclerView.getChildAt(0).getTop();
                    long currentTimeMillis = System.currentTimeMillis() - FloatReddishBag.this.k.longValue();
                    if (findFirstVisibleItemPosition == 0 && top == 0) {
                        if (!FloatReddishBag.this.j) {
                            FloatReddishBag.this.e();
                        }
                    } else if (FloatReddishBag.this.l < findFirstVisibleItemPosition) {
                        if (FloatReddishBag.this.j) {
                            FloatReddishBag.this.f();
                        }
                    } else if (FloatReddishBag.this.l == findFirstVisibleItemPosition) {
                        float f = top;
                        int abs = (int) Math.abs(FloatReddishBag.this.m - f);
                        if (FloatReddishBag.this.m >= f || currentTimeMillis == 0 || (abs * 1000) / currentTimeMillis <= 2000) {
                            if (FloatReddishBag.this.m > f && abs > 10 && FloatReddishBag.this.j) {
                                FloatReddishBag.this.f();
                            }
                        } else if (!FloatReddishBag.this.j) {
                            FloatReddishBag.this.e();
                        }
                    }
                    FloatReddishBag.this.l = findFirstVisibleItemPosition;
                    FloatReddishBag.this.m = top;
                    FloatReddishBag.this.k = Long.valueOf(System.currentTimeMillis());
                }
            }
        };
        this.f28418a = context;
        d();
    }

    public FloatReddishBag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        this.n = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.customview.FloatReddishBag.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (recyclerView.getChildAt(0) != null) {
                    if (FloatReddishBag.this.k == null) {
                        FloatReddishBag.this.k = Long.valueOf(System.currentTimeMillis());
                    }
                    int top = recyclerView.getChildAt(0).getTop();
                    long currentTimeMillis = System.currentTimeMillis() - FloatReddishBag.this.k.longValue();
                    if (findFirstVisibleItemPosition == 0 && top == 0) {
                        if (!FloatReddishBag.this.j) {
                            FloatReddishBag.this.e();
                        }
                    } else if (FloatReddishBag.this.l < findFirstVisibleItemPosition) {
                        if (FloatReddishBag.this.j) {
                            FloatReddishBag.this.f();
                        }
                    } else if (FloatReddishBag.this.l == findFirstVisibleItemPosition) {
                        float f = top;
                        int abs = (int) Math.abs(FloatReddishBag.this.m - f);
                        if (FloatReddishBag.this.m >= f || currentTimeMillis == 0 || (abs * 1000) / currentTimeMillis <= 2000) {
                            if (FloatReddishBag.this.m > f && abs > 10 && FloatReddishBag.this.j) {
                                FloatReddishBag.this.f();
                            }
                        } else if (!FloatReddishBag.this.j) {
                            FloatReddishBag.this.e();
                        }
                    }
                    FloatReddishBag.this.l = findFirstVisibleItemPosition;
                    FloatReddishBag.this.m = top;
                    FloatReddishBag.this.k = Long.valueOf(System.currentTimeMillis());
                }
            }
        };
        this.f28418a = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.e.removeMessages(0);
        this.e.sendEmptyMessageDelayed(0, j);
    }

    private void a(final View view) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f28418a, -50.0f), DensityUtils.a(this.f28418a, 30.0f));
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.FloatReddishBag.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, intValue);
                view.setLayoutParams(marginLayoutParams);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveRewardListModel> list, String str) {
        if (this.h.isAdded()) {
            if (list == null || list.size() <= 0) {
                setVisibility(8);
                return;
            }
            b();
            this.f = list;
            this.i = str;
            setVisibility(0);
            TextView textView = this.d;
            String string = this.f28418a.getResources().getString(2131890213);
            textView.setText(String.format(string, list.size() + ""));
            a(0L);
        }
    }

    private void b(final View view) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f28418a, 30.0f), DensityUtils.a(this.f28418a, -50.0f));
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.FloatReddishBag.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, intValue);
                view.setLayoutParams(marginLayoutParams);
            }
        });
        ofInt.start();
    }

    private void d() {
        View inflate = LayoutInflater.from(this.f28418a).inflate(R.layout.live_reddish_bag, this);
        this.b = inflate;
        this.f28419c = (ImageView) inflate.findViewById(R.id.reddish_bag_header);
        this.d = (TextView) this.b.findViewById(R.id.reddish_bag_num);
        this.e = new MyHandler(this);
        setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.FloatReddishBag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FloatReddishBag.this.a();
                WebViewShowInfoFragment.show(FloatReddishBag.this.f28418a, FloatReddishBag.this.i, 7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a((View) this);
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        b((View) this);
        this.j = false;
    }

    public abstract void a();

    public void a(int i) {
        LiveRewardListModel liveRewardListModel;
        List<LiveRewardListModel> list = this.f;
        if (list == null || list.size() <= i || (liveRewardListModel = this.f.get(i)) == null) {
            return;
        }
        BaseFragment baseFragment = this.h;
        ImageLoader.a(baseFragment != null ? baseFragment.getFragmentActive() : null, liveRewardListModel.avatar).b(2131237310).c().a(this.f28419c);
    }

    public abstract void b();

    public void c() {
        List<LiveRewardListModel> list = this.f;
        if (list != null) {
            int i = this.g;
            int size = list.size();
            int i2 = i + 1;
            if (i2 == size) {
                this.g = 0;
            } else {
                this.g = i2;
            }
            a(this.g);
        }
    }

    public RecyclerView.OnScrollListener getCustomScrollListener() {
        return this.n;
    }

    public void setFragment(BaseFragment baseFragment) {
        this.h = baseFragment;
    }
}

package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.ScrollTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeView.class */
public class MarqueeView extends ViewFlipper {
    private int a;
    private boolean b;
    private int c;
    private int d;
    private String e;
    private boolean f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private List<? extends CharSequence> m;
    private OnItemClickListener n;
    private LiveMsgManager o;
    private ScrollTextView.OnScrollListener p;
    private int q;

    /* renamed from: com.blued.android.module.live_china.view.MarqueeView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeView$1.class */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ MarqueeView d;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.d.a(this.a, this.b, this.c);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/MarqueeView$OnItemClickListener.class */
    public interface OnItemClickListener {
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 4000;
        this.b = false;
        this.c = 1000;
        this.d = 12;
        this.f = false;
        this.g = 19;
        this.h = false;
        this.i = 0;
        this.j = R.anim.anim_bottom_in;
        this.k = R.anim.anim_top_out;
        this.m = new ArrayList();
        a(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView a(CharSequence charSequence) {
        TextView textView = new TextView(getContext());
        textView.setGravity(this.g);
        try {
            textView.setTextColor(Color.parseColor(this.e));
        } catch (Exception e) {
            textView.setTextColor(-1);
        }
        textView.setTextSize(this.d);
        textView.setSingleLine(true);
        textView.setText(charSequence);
        textView.setTag(Integer.valueOf(this.l));
        textView.setMovementMethod(LinkMovementClickMethod.a());
        return textView;
    }

    private void a(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeView.3
            @Override // java.lang.Runnable
            public void run() {
                MarqueeView.this.b(i, i2);
            }
        });
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        setFlipInterval(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        int i3;
        CharSequence a = LiveRoomInfo.a().a(str, "#ffd452", new LiveRoomConstants.ClickAtLinkListener() { // from class: com.blued.android.module.live_china.view.MarqueeView.2
            @Override // com.blued.android.module.live_china.constant.LiveRoomConstants.ClickAtLinkListener
            public void a(String str2, String str3) {
                if (MarqueeView.this.o != null) {
                    if (TextUtils.isEmpty(str3)) {
                        MarqueeView.this.o.b(str2);
                    } else {
                        MarqueeView.this.o.a(str3);
                    }
                } else if (TextUtils.isEmpty(str3)) {
                    LiveSetDataObserver.a().d(str2);
                } else {
                    LiveSetDataObserver.a().e(str3);
                }
            }
        });
        int length = a.length();
        Context context = getContext();
        int i4 = this.q;
        int b = DensityUtils.b(context, i4 > 580 ? 720.0f : i4);
        if (b == 0) {
            throw new RuntimeException("Please set the width of MarqueeView !");
        }
        int i5 = b / this.d;
        ArrayList arrayList = new ArrayList();
        if (length > i5) {
            int i6 = length / i5;
            int i7 = length % i5 != 0 ? 1 : 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i8 >= i6 + i7) {
                    break;
                }
                int i10 = (i8 * i5) + i9;
                int i11 = i8 + 1;
                int i12 = (i11 * i5) + i9;
                int i13 = i12;
                if (i12 >= length) {
                    i13 = length;
                }
                Matcher matcher = Pattern.compile("[a-z0-9]").matcher(a.subSequence(i10 == 0 ? 0 : i10, i13));
                int i14 = 0;
                while (true) {
                    i3 = i14;
                    if (!matcher.find()) {
                        break;
                    }
                    i9++;
                    i14 = i3 + 1;
                }
                int i15 = i13 + i3;
                if (i15 >= length) {
                    arrayList.add(a.subSequence(i10, length));
                    break;
                } else {
                    arrayList.add(a.subSequence(i10, i15));
                    i8 = i11;
                }
            }
        } else {
            arrayList.add(a);
        }
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.clear();
        this.m.addAll(arrayList);
        a(i, i2);
    }

    static /* synthetic */ int b(MarqueeView marqueeView) {
        int i = marqueeView.l;
        marqueeView.l = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        removeAllViews();
        clearAnimation();
        this.l = 0;
        addView(a(this.m.get(0)));
        if (this.m.size() > 1) {
            c(i, i2);
            startFlipping();
        }
        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.MarqueeView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MarqueeView.b(MarqueeView.this);
                    if (MarqueeView.this.l >= MarqueeView.this.m.size()) {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (MarqueeView.this.p != null) {
                                    MarqueeView.this.p.a();
                                }
                            }
                        }, 1000L);
                        return;
                    }
                    MarqueeView marqueeView = MarqueeView.this;
                    TextView a = marqueeView.a((CharSequence) marqueeView.m.get(MarqueeView.this.l));
                    if (a.getParent() == null) {
                        MarqueeView.this.addView(a);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        } else {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.MarqueeView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MarqueeView.this.p != null) {
                        MarqueeView.this.p.a();
                    }
                }
            }, 4000L);
        }
    }

    private void c(int i, int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        if (this.b) {
            loadAnimation.setDuration(this.c);
        }
        setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        if (this.b) {
            loadAnimation2.setDuration(this.c);
        }
        setOutAnimation(loadAnimation2);
    }

    public List<? extends CharSequence> getNotices() {
        return this.m;
    }

    public int getPosition() {
        return ((Integer) getCurrentView().getTag()).intValue();
    }

    public void setLiveMsgManager(LiveMsgManager liveMsgManager) {
        this.o = liveMsgManager;
    }

    public void setNotices(List<? extends CharSequence> list) {
        this.m = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.n = onItemClickListener;
    }

    public void setOnScrollListener(ScrollTextView.OnScrollListener onScrollListener) {
        this.p = onScrollListener;
    }

    public void setTextColor(String str) {
        this.e = str;
    }

    public void setWidth(int i) {
        this.q = i;
    }
}

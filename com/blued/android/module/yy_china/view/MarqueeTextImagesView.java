package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGlobalMsgMarqueeModel;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/MarqueeTextImagesView.class */
public class MarqueeTextImagesView extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f17954a;
    private SimpleDateFormat b;

    /* renamed from: c  reason: collision with root package name */
    private CopyOnWriteArrayList<NotiData> f17955c;
    private Paint d;
    private int e;
    private LinearLayout f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ActivityFragmentActive j;
    private ImageView k;
    private HorizontalScrollView l;
    private String m;

    public MarqueeTextImagesView(Context context) {
        this(context, null);
    }

    public MarqueeTextImagesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeTextImagesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17954a = -1;
        this.f17955c = new CopyOnWriteArrayList<>();
        LayoutInflater.from(context).inflate(R.layout.view_marquee_text_imge, (ViewGroup) this, true);
        this.f = (LinearLayout) findViewById(R.id.ll_mar);
        this.g = (TextView) findViewById(R.id.tv_mess);
        this.k = (ImageView) findViewById(R.id.iv_back);
        this.h = (ImageView) findViewById(R.id.iv_mar);
        this.i = (ImageView) findViewById(R.id.iv_mar_forward);
        this.l = (HorizontalScrollView) findViewById(R.id.h_scroll);
        Paint paint = new Paint();
        this.d = paint;
        paint.setTextSize(14.0f);
        this.e = getResources().getDimensionPixelOffset(R.dimen.dp_44);
        post(new Runnable() { // from class: com.blued.android.module.yy_china.view.MarqueeTextImagesView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeTextImagesView marqueeTextImagesView = MarqueeTextImagesView.this;
                marqueeTextImagesView.f17954a = marqueeTextImagesView.getMeasuredWidth() - MarqueeTextImagesView.this.getResources().getDimensionPixelOffset(R.dimen.dp_20);
            }
        });
        this.l.setOnTouchListener(this);
        this.f.setOnClickListener(this);
        this.f.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        CopyOnWriteArrayList<NotiData> copyOnWriteArrayList = this.f17955c;
        if (copyOnWriteArrayList == null) {
            return;
        }
        if (copyOnWriteArrayList.size() > 0) {
            this.f17955c.remove(0);
        }
        if (this.f17955c.size() > 0) {
            setText(this.f17955c.get(0));
        } else {
            setVisibility(8);
        }
    }

    private void setText(final NotiData notiData) {
        if (this.h == null) {
            return;
        }
        if (StringUtils.b(notiData.b)) {
            this.k.setImageResource(R.drawable.shape_fc3883fd_fc00e0ab);
        } else {
            ImageLoader.a((IRequestHost) null, notiData.b).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.MarqueeTextImagesView.2
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    MarqueeTextImagesView.this.k.setBackground(drawable);
                }
            });
        }
        setVisibility(0);
        this.h.setImageResource(R.color.transparent);
        this.g.setText("");
        float measureText = this.g.getPaint().measureText(notiData.f17962a.toString()) + (this.e * 2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "translationX", this.f17954a);
        ofFloat.setDuration(1000L);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f, "translationX", this.f17954a, -measureText);
        ofFloat2.setDuration((measureText + this.f17954a) * 8.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.yy_china.view.MarqueeTextImagesView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MarqueeTextImagesView.this.f.setClickable(false);
                MarqueeTextImagesView.this.b();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.yy_china.view.MarqueeTextImagesView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MarqueeTextImagesView.this.g == null) {
                    return;
                }
                MarqueeTextImagesView.this.g.setText(notiData.f17962a);
                if (StringUtils.b(notiData.d)) {
                    MarqueeTextImagesView.this.h.setVisibility(4);
                } else {
                    ImageLoader.a(MarqueeTextImagesView.this.j, notiData.d).a(MarqueeTextImagesView.this.h);
                    MarqueeTextImagesView.this.h.setVisibility(0);
                }
                if (StringUtils.b(notiData.f17963c)) {
                    MarqueeTextImagesView.this.i.setVisibility(4);
                } else {
                    ImageLoader.a(MarqueeTextImagesView.this.j, notiData.f17963c).a(MarqueeTextImagesView.this.i);
                    MarqueeTextImagesView.this.i.setVisibility(0);
                }
                if (!StringUtils.b(notiData.e)) {
                    MarqueeTextImagesView.this.m = notiData.e;
                    MarqueeTextImagesView.this.f.setClickable(true);
                }
                ofFloat2.start();
            }
        });
        ofFloat.start();
    }

    public SpannableStringBuilder a(String str, String str2) {
        return new SpannableStringBuilder(String.format("%s 与 %s 在心动房间交友成功，恭喜他们！", str, str2));
    }

    public SpannableStringBuilder a(String str, String str2, String str3, String str4, String str5) {
        if (this.b == null) {
            this.b = new SimpleDateFormat("HH:mm");
        }
        return new SpannableStringBuilder(String.format("%s %s 送给 %s %s个%s", this.b.format(new Date(new Long(str).longValue() * 1000)), str2, str3, str4, str5));
    }

    public void a() {
    }

    public void a(SpannableStringBuilder spannableStringBuilder, String str) {
        if (this.f17955c != null) {
            NotiData notiData = new NotiData(spannableStringBuilder, str);
            this.f17955c.add(notiData);
            if (this.f17955c.size() == 1) {
                setText(notiData);
            }
        }
    }

    public void a(ActivityFragmentActive activityFragmentActive) {
        this.j = activityFragmentActive;
    }

    public void a(YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel) {
        if (this.f17955c != null) {
            NotiData notiData = new NotiData(yYGlobalMsgMarqueeModel);
            this.f17955c.add(notiData);
            if (this.f17955c.size() == 1) {
                setText(notiData);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (StringUtils.b(this.m)) {
            return;
        }
        YYRoomInfoManager.e().c().a(getContext(), this.m, 9);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}

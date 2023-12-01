package com.soft.blued.ui.community.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.DoubleClickProxy;
import com.blued.android.module.common.utils.click.IClickAgain;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedPostSignStateFragment;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/view/FeedBubbleProfileView.class */
public final class FeedBubbleProfileView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f16104a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f16105c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private ImageView h;
    private ShapeFrameLayout i;
    private View j;
    private View k;
    private FeedPostSignStateItem l;
    private String m;
    private boolean n;
    private boolean o;
    private UserInfoFragmentNew p;
    private int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleProfileView(Context context) {
        super(context);
        Intrinsics.a(context);
        this.n = true;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleProfileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.a(context);
        this.n = true;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleProfileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        this.n = true;
        a();
    }

    private final void a() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.feed_bubble_profile_view_layout, (ViewGroup) null);
        this.f16104a = frameLayout;
        if (frameLayout == null) {
            return;
        }
        this.f16105c = (FrameLayout) frameLayout.findViewById(R.id.feed_bubble_state_content);
        this.b = (ImageView) frameLayout.findViewById(R.id.feed_bubble_host_shine_iv);
        this.d = (ImageView) frameLayout.findViewById(R.id.feed_bubble_state_iv);
        this.e = (TextView) frameLayout.findViewById(R.id.feed_bubble_state_tv);
        this.f = (ImageView) frameLayout.findViewById(R.id.feed_bubble_arrow_iv);
        this.g = (TextView) frameLayout.findViewById(R.id.feed_bubble_content_tv);
        this.h = (ImageView) frameLayout.findViewById(R.id.feed_bubble_add_iv);
        this.i = frameLayout.findViewById(R.id.feed_bubble_guest_him_lo);
        this.j = frameLayout.findViewById(R.id.feed_bubble_space);
        this.k = frameLayout.findViewById(R.id.feed_bubble_double_click_lo);
        b();
        FrameLayout frameLayout2 = this.f16105c;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$qt9IpFgm7kdk4PkS0PicZEFLk4c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubbleProfileView.a(FeedBubbleProfileView.this, view);
                }
            });
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$YZhOESrvJHLCa0Haf3YRQ7dtc9g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubbleProfileView.b(FeedBubbleProfileView.this, view);
                }
            });
        }
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$T_4BOHxAwrZHnUv3VZom8QkGlxo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubbleProfileView.c(FeedBubbleProfileView.this, view);
                }
            });
        }
        View view = this.k;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) new DoubleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$_kZXqBENKxkmGO5VZfca1UtDExI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedBubbleProfileView.d(FeedBubbleProfileView.this, view2);
                }
            }, new IClickAgain() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$MbKvLXQ435FJyLbWzM0Y5bHfzB8
                public final void onAgain() {
                    FeedBubbleProfileView.j(FeedBubbleProfileView.this);
                }
            }));
        }
        addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView textView, ValueAnimator valueAnimator) {
        Intrinsics.e(textView, "$it");
        Intrinsics.e(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = intValue;
        textView.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleProfileView feedBubbleProfileView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBubbleProfileView, "this$0");
        feedBubbleProfileView.g();
    }

    private final void a(String str) {
        final TextView textView;
        if (str != null && (textView = this.g) != null) {
            textView.setText(str);
            textView.setVisibility(0);
            int measureText = ((int) textView.getPaint().measureText(str)) + 2;
            this.q = measureText;
            if (measureText > FeedMethods.c(100)) {
                this.q = FeedMethods.c(100);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.q);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$3ZNr9l9qleaDPwmVfuryj23mPGI
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FeedBubbleProfileView.a(textView, valueAnimator);
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.community.view.FeedBubbleProfileView$startContentShowAnim$1$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    boolean z;
                    ImageView imageView;
                    ShapeFrameLayout shapeFrameLayout;
                    View view;
                    FeedPostSignStateItem feedPostSignStateItem;
                    View view2;
                    View view3;
                    int i;
                    String name;
                    ImageView imageView2;
                    ShapeFrameLayout shapeFrameLayout2;
                    View view4;
                    String str2;
                    Intrinsics.e(animator, "animator");
                    z = FeedBubbleProfileView.this.n;
                    if (z) {
                        imageView2 = FeedBubbleProfileView.this.h;
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                        shapeFrameLayout2 = FeedBubbleProfileView.this.i;
                        if (shapeFrameLayout2 != null) {
                            shapeFrameLayout2.setVisibility(8);
                        }
                        view4 = FeedBubbleProfileView.this.k;
                        if (view4 != null) {
                            view4.setVisibility(8);
                        }
                        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.PERSONAL_BUBBLE_PUBLISH_BTN_SHOW;
                        str2 = FeedBubbleProfileView.this.m;
                        EventTrackPersonalProfile.a(event, str2, true);
                        return;
                    }
                    imageView = FeedBubbleProfileView.this.h;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    shapeFrameLayout = FeedBubbleProfileView.this.i;
                    if (shapeFrameLayout != null) {
                        shapeFrameLayout.setVisibility(0);
                    }
                    view = FeedBubbleProfileView.this.k;
                    Integer num = null;
                    ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
                    feedPostSignStateItem = FeedBubbleProfileView.this.l;
                    if (feedPostSignStateItem != null && (name = feedPostSignStateItem.getName()) != null) {
                        num = Integer.valueOf(name.length());
                    }
                    Integer num2 = num;
                    if (num == null) {
                        num2 = 0;
                    }
                    Integer num3 = num2;
                    if (num2.intValue() > 4) {
                        num3 = 4;
                    }
                    if (layoutParams != null) {
                        int c2 = FeedMethods.c((num3.intValue() * 12) + 28 + 3 + 8 + 41);
                        i = FeedBubbleProfileView.this.q;
                        layoutParams.width = c2 + i;
                    }
                    view2 = FeedBubbleProfileView.this.k;
                    if (view2 != null) {
                        view2.setLayoutParams(layoutParams);
                    }
                    view3 = FeedBubbleProfileView.this.k;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    if (CommunityPreferences.W()) {
                        FeedBubbleProfileView.this.j();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ImageView imageView;
                    Intrinsics.e(animator, "animator");
                    imageView = FeedBubbleProfileView.this.f;
                    if (imageView == null) {
                        return;
                    }
                    imageView.setVisibility(8);
                }
            });
            ofInt.start();
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$i-P07vTTtigoMaA8PWRYsCwDOGw
            @Override // java.lang.Runnable
            public final void run() {
                FeedBubbleProfileView.l(FeedBubbleProfileView.this);
            }
        }, 4000L);
    }

    private final void b() {
        ShapeFrameLayout shapeFrameLayout = this.i;
        ShapeModel shapeModel = shapeFrameLayout == null ? null : shapeFrameLayout.getShapeModel();
        ShapeModel shapeModel2 = shapeModel;
        if (shapeModel == null) {
            shapeModel2 = new ShapeModel();
        }
        shapeModel2.t = Color.parseColor("#CC7056FF");
        shapeModel2.v = Color.parseColor("#CC3071FE");
        ShapeFrameLayout shapeFrameLayout2 = this.i;
        if (shapeFrameLayout2 == null) {
            return;
        }
        shapeFrameLayout2.setShapeModel(shapeModel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TextView textView, ValueAnimator valueAnimator) {
        Intrinsics.e(textView, "$it");
        Intrinsics.e(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = intValue;
        textView.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBubbleProfileView feedBubbleProfileView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBubbleProfileView, "this$0");
        feedBubbleProfileView.g();
    }

    private final void c() {
        b();
        FeedPostSignStateItem feedPostSignStateItem = this.l;
        if (feedPostSignStateItem == null) {
            if (!this.n) {
                setVisibility(8);
                return;
            }
            long a2 = TimeAndDateUtils.a();
            if (a2 <= CommunityPreferences.U()) {
                setVisibility(8);
                return;
            }
            CommunityPreferences.e(a2);
            d();
            EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_BUBBLE_ICON_SHOW, this.m, "");
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BUBBLE_PUBLISH_BTN_SHOW, this.m, false);
            return;
        }
        if (!this.n) {
            boolean z = true;
            if (feedPostSignStateItem == null || feedPostSignStateItem.is_bubble_tt_click() != 1) {
                z = false;
            }
            if (z) {
                setVisibility(8);
                return;
            }
        }
        setVisibility(0);
        FrameLayout frameLayout = this.f16105c;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            FeedPostSignStateItem feedPostSignStateItem2 = this.l;
            Intrinsics.a(feedPostSignStateItem2);
            ImageLoader.a((IRequestHost) null, feedPostSignStateItem2.getIcon()).a(imageView2);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            FeedPostSignStateItem feedPostSignStateItem3 = this.l;
            Intrinsics.a(feedPostSignStateItem3);
            textView2.setText(feedPostSignStateItem3.getName());
        }
        if (this.o) {
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = this.g;
            if (textView4 != null) {
                FeedPostSignStateItem feedPostSignStateItem4 = this.l;
                Intrinsics.a(feedPostSignStateItem4);
                textView4.setText(feedPostSignStateItem4.getLeading_words());
            }
            ImageView imageView3 = this.f;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        } else {
            TextView textView5 = this.g;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            ImageView imageView4 = this.f;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            ImageView imageView5 = this.h;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            ShapeFrameLayout shapeFrameLayout = this.i;
            if (shapeFrameLayout != null) {
                shapeFrameLayout.setVisibility(8);
            }
            View view = this.k;
            if (view != null) {
                view.setVisibility(8);
            }
            e();
        }
        if (!this.n && CommunityPreferences.V()) {
            CommunityPreferences.p(false);
            UserInfoFragmentNew userInfoFragmentNew = this.p;
            if (userInfoFragmentNew != null) {
                userInfoFragmentNew.j();
            }
        }
        EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_BUBBLE_ICON_SHOW, this.m, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedBubbleProfileView feedBubbleProfileView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBubbleProfileView, "this$0");
        feedBubbleProfileView.h();
    }

    private final void d() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$38G4ixZRjD-RNLWwJIXOFt2kNUc
            @Override // java.lang.Runnable
            public final void run() {
                FeedBubbleProfileView.k(FeedBubbleProfileView.this);
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedBubbleProfileView feedBubbleProfileView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBubbleProfileView, "this$0");
        feedBubbleProfileView.i();
    }

    private final void e() {
        ImageView imageView = this.f;
        if (imageView == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        animationDrawable.stop();
        animationDrawable.start();
    }

    private final void f() {
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
        final TextView textView = this.g;
        if (textView == null) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(textView.getMeasuredWidth(), 0);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$FeedBubbleProfileView$x5-SaJ0Ut1ulvgoF8APGT73-GTQ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedBubbleProfileView.b(textView, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.community.view.FeedBubbleProfileView$startContentHideAnim$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageView imageView;
                ImageView imageView2;
                ShapeFrameLayout shapeFrameLayout;
                Intrinsics.e(animator, "animator");
                imageView = FeedBubbleProfileView.this.f;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                imageView2 = FeedBubbleProfileView.this.h;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                shapeFrameLayout = FeedBubbleProfileView.this.i;
                if (shapeFrameLayout != null) {
                    shapeFrameLayout.setVisibility(8);
                }
                FeedBubbleProfileView.this.o = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.e(animator, "animator");
            }
        });
        ofInt.start();
    }

    private final void g() {
        FeedPostSignStateItem feedPostSignStateItem = this.l;
        if (feedPostSignStateItem != null) {
            if (this.o) {
                return;
            }
            this.o = true;
            a(feedPostSignStateItem == null ? null : feedPostSignStateItem.getLeading_words());
            EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_BUBBLE_ICON_CLICK, this.m, "");
        } else if (this.n) {
            FeedPostSignStateFragment.Companion companion = FeedPostSignStateFragment.a;
            Context context = getContext();
            Intrinsics.c(context, "context");
            companion.a(context, 3);
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BUBBLE_PUBLISH_BTN_CLICK, this.m, false);
        }
    }

    private final void h() {
        if (this.n) {
            FeedPostSignStateFragment.Companion companion = FeedPostSignStateFragment.a;
            Context context = getContext();
            Intrinsics.c(context, "context");
            companion.a(context, 3);
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BUBBLE_PUBLISH_BTN_CLICK, this.m, true);
        }
    }

    private final void i() {
        FeedPostSignStateItem feedPostSignStateItem = this.l;
        boolean z = false;
        if (feedPostSignStateItem != null && feedPostSignStateItem.is_bubble_tt_click() == 1) {
            z = true;
        }
        if (z) {
            return;
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        String name;
        CommunityPreferences.q(false);
        FeedPostSignStateItem feedPostSignStateItem = this.l;
        Integer num = null;
        if (feedPostSignStateItem != null && (name = feedPostSignStateItem.getName()) != null) {
            num = Integer.valueOf(name.length());
        }
        Integer num2 = num;
        if (num == null) {
            num2 = 0;
        }
        Integer num3 = num2;
        if (num2.intValue() > 4) {
            num3 = 4;
        }
        UserInfoFragmentNew userInfoFragmentNew = this.p;
        if (userInfoFragmentNew == null) {
            return;
        }
        userInfoFragmentNew.a(FeedMethods.c((num3.intValue() * 12) + 66) + this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(FeedBubbleProfileView feedBubbleProfileView) {
        Intrinsics.e(feedBubbleProfileView, "this$0");
        feedBubbleProfileView.k();
    }

    private final void k() {
        String feed_id;
        FeedPostSignStateItem feedPostSignStateItem = this.l;
        boolean z = false;
        if (feedPostSignStateItem != null && feedPostSignStateItem.is_bubble_tt_click() == 1) {
            z = true;
        }
        if (z) {
            return;
        }
        FeedPostSignStateItem feedPostSignStateItem2 = this.l;
        if (feedPostSignStateItem2 != null && (feed_id = feedPostSignStateItem2.getFeed_id()) != null) {
            ToastUtils.a("已戳破泡泡，对方会收到通知");
            UserInfoFragmentNew userInfoFragmentNew = this.p;
            final ActivityFragmentActive fragmentActive = userInfoFragmentNew == null ? null : userInfoFragmentNew.getFragmentActive();
            BluedUIHttpResponse<BluedEntityA<String>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<String>>(fragmentActive) { // from class: com.soft.blued.ui.community.view.FeedBubbleProfileView$onDoubleClickPoke$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super((IRequestHost) fragmentActive);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<String> bluedEntityA) {
                }

                public void onUIFinish(boolean z2) {
                    super.onUIFinish(z2);
                    FeedBubbleProfileView.this.setVisibility(8);
                }
            };
            UserInfoFragmentNew userInfoFragmentNew2 = this.p;
            FeedHttpUtils.i(bluedUIHttpResponse, feed_id, userInfoFragmentNew2 == null ? null : userInfoFragmentNew2.getFragmentActive());
        }
        EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_BUBBLE_ICON_DOUBLE_CLICK, this.m, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FeedBubbleProfileView feedBubbleProfileView) {
        Intrinsics.e(feedBubbleProfileView, "this$0");
        ImageView imageView = feedBubbleProfileView.b;
        if (imageView == null) {
            return;
        }
        feedBubbleProfileView.setVisibility(0);
        FrameLayout frameLayout = feedBubbleProfileView.f16105c;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        imageView.setVisibility(0);
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        animationDrawable.stop();
        animationDrawable.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FeedBubbleProfileView feedBubbleProfileView) {
        ActivityFragmentActive fragmentActive;
        Intrinsics.e(feedBubbleProfileView, "this$0");
        UserInfoFragmentNew userInfoFragmentNew = feedBubbleProfileView.p;
        boolean z = true;
        if (userInfoFragmentNew == null || (fragmentActive = userInfoFragmentNew.getFragmentActive()) == null || !fragmentActive.isActive()) {
            z = false;
        }
        if (z && feedBubbleProfileView.getVisibility() == 0) {
            feedBubbleProfileView.f();
        }
    }

    public final void a(FeedPostSignStateItem feedPostSignStateItem, String str) {
        this.m = str;
        this.n = CommunityManager.a.a().c(str);
        this.l = feedPostSignStateItem;
        c();
    }

    public final void setFragment(UserInfoFragmentNew userInfoFragmentNew) {
        this.p = userInfoFragmentNew;
    }
}

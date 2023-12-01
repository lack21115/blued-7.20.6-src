package com.blued.community.ui.subject.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.c.g;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.community.utils.ViewUtils;
import com.blued.community.view.CommonFloatBottomView;
import com.blued.das.client.feed.FeedProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectDetailFragment.class */
public final class FeedSubjectDetailFragment extends FeedTopicDetailBaseFragment {
    private TextView A;
    private ShapeLinearLayout B;
    private TextView C;
    private TextView D;
    private CommonFloatBottomView E;
    private View F;
    private View G;
    private TextView H;
    private View I;
    private View J;
    private ShapeLinearLayout K;
    private int M;
    private int N;
    private int S;
    private int V;
    private int W;
    private int X;
    private int Y;
    private boolean Z;
    private final ValueAnimator aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private View i;
    private ShapeLinearLayout j;
    private TextView k;
    private CardView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private ImageView r;
    private ImageView s;
    private View t;
    private TextView u;
    private ImageView v;
    private CardView w;
    private TextView x;
    private View y;
    private TextView z;
    private boolean L = true;
    private int O = 1;
    private int P = 1;
    private final ArrayList<BluedIngSelfFeed> Q = new ArrayList<>();
    private final ArrayList<BluedIngSelfFeed> R = new ArrayList<>();
    private final SparseArray<Integer> T = new SparseArray<>();
    private final SparseArray<Integer> U = new SparseArray<>();

    public FeedSubjectDetailFragment() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 24);
        Intrinsics.c(ofInt, "ofInt(0, 24)");
        this.aa = ofInt;
        this.ad = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View bgView, int i, int i2, ValueAnimator valueAnimator) {
        Intrinsics.e(bgView, "$bgView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = bgView.getLayoutParams();
        layoutParams.width = i + FeedMethods.a(intValue * 1.5f);
        layoutParams.height = i2 + FeedMethods.c(intValue);
        bgView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectDetailFragment this$0, Ref.BooleanRef followFlag, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(followFlag, "$followFlag");
        this$0.c(followFlag.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef skeletonTopBg, int i, int i2, ValueAnimator animation) {
        View view;
        View view2;
        Intrinsics.e(skeletonTopBg, "$skeletonTopBg");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        if (intValue <= 1 && (view2 = (View) skeletonTopBg.a) != null) {
            view2.setBackgroundColor(i);
        }
        if (intValue < 9 || (view = (View) skeletonTopBg.a) == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(FeedSubjectDetailFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.e(this$0, "this$0");
        return (this$0.ae && ViewUtils.a(this$0.l, motionEvent)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedSubjectDetailFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().scrollToPositionWithOffset(this$0.V, this$0.W);
        int i = this$0.V;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Integer num = this$0.T.get(i3);
            Intrinsics.c(num, "recommendFeedHeightArray[i]");
            i2 += num.intValue();
        }
        int abs = i2 + Math.abs(this$0.W);
        this$0.d(abs);
        LogUtils.c(Intrinsics.a("scrollY: ", (Object) Integer.valueOf(abs)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedSubjectDetailFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().scrollToPositionWithOffset(this$0.X, this$0.Y);
        int i = this$0.X;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Integer num = this$0.U.get(i3);
            Intrinsics.c(num, "latestFeedHeightArray[i]");
            i2 += num.intValue();
        }
        int abs = i2 + Math.abs(this$0.Y);
        this$0.d(abs);
        LogUtils.c(Intrinsics.a("scrollY: ", (Object) Integer.valueOf(abs)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    private final void c(final boolean z) {
        String str = this.d;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        FeedHttpUtils.a(str, z, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.community.ui.subject.fragment.FeedSubjectDetailFragment$requestFollow$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        }, getFragmentActive());
    }

    private final void d(int i) {
        if (this.M == 0) {
            this.M = FeedMethods.c(105);
        }
        if (this.N == 0) {
            this.N = FeedMethods.c(45);
        }
        if (i <= FeedMethods.c(20)) {
            View view = this.q;
            if (view != null) {
                view.setBackgroundResource(R.color.transparent);
            }
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_title_back_white);
            }
            ImageView imageView2 = this.s;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.icon_title_share_white);
            }
            View view2 = this.t;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.y;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.r;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_title_back);
        }
        ImageView imageView4 = this.s;
        if (imageView4 != null) {
            imageView4.setImageResource(R.drawable.icon_title_share);
        }
        if (i <= this.M) {
            if (CommunityManager.a.a().s()) {
                View view4 = this.q;
                if (view4 != null) {
                    view4.setBackgroundColor(Color.parseColor("#80151515"));
                }
            } else {
                View view5 = this.q;
                if (view5 != null) {
                    view5.setBackgroundResource(R.color.syc_dark_80ffffff);
                }
            }
            View view6 = this.t;
            if (view6 != null) {
                view6.setVisibility(8);
            }
            View view7 = this.y;
            if (view7 == null) {
                return;
            }
            view7.setVisibility(8);
            return;
        }
        if (CommunityManager.a.a().s()) {
            View view8 = this.q;
            if (view8 != null) {
                view8.setBackgroundResource(R.color.syc_151515);
            }
        } else {
            View view9 = this.q;
            if (view9 != null) {
                view9.setBackgroundResource(R.color.syc_b);
            }
        }
        View view10 = this.t;
        if (view10 != null) {
            view10.setVisibility(0);
        }
        ShapeLinearLayout shapeLinearLayout = this.j;
        Intrinsics.a(shapeLinearLayout);
        if (i > (shapeLinearLayout.getMeasuredHeight() + this.M) - this.N) {
            View view11 = this.y;
            if (view11 == null) {
                return;
            }
            view11.setVisibility(0);
            return;
        }
        View view12 = this.y;
        if (view12 == null) {
            return;
        }
        view12.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FeedSubjectDetailFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.r();
    }

    private final void p() {
        final View view = this.G;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        final int a = DisplayUtil.a(AppInfo.d(), 128.0f);
        final int a2 = DisplayUtil.a(AppInfo.d(), 42.0f);
        this.aa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$d-0Qc_BgL_apddzPB7mnvsevbVI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedSubjectDetailFragment.a(View.this, a, a2, valueAnimator);
            }
        });
        this.aa.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectDetailFragment$showGuidePostAnim$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.aa.setRepeatCount(1);
        this.aa.setDuration(1500L);
        this.aa.setStartDelay(300L);
        this.aa.start();
    }

    private final void q() {
        if (this.L || this.S != 0) {
            return;
        }
        this.R.clear();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        if (feedListAdapterForRecyclerView != null) {
            this.R.addAll(feedListAdapterForRecyclerView.getData());
        }
        this.P = i();
        this.X = f().findFirstVisibleItemPosition();
        View childAt = f().getChildAt(0);
        if (childAt != null) {
            this.Y = childAt.getTop();
        }
        LogUtils.c("latestTypePosition: " + this.X + ", latestTypeScrollY: " + this.Y);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = this.a;
        if (feedListAdapterForRecyclerView2 != null) {
            feedListAdapterForRecyclerView2.b(29);
        }
        this.L = true;
        a(this.O);
        a("");
        TextView textView = this.z;
        if (textView != null) {
            textView.setTextSize(17.0f);
        }
        TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setTextSize(17.0f);
        }
        TextView textView3 = this.z;
        if (textView3 != null) {
            textView3.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        }
        TextView textView4 = this.C;
        if (textView4 != null) {
            textView4.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        }
        TextView textView5 = this.A;
        if (textView5 != null) {
            textView5.setTextSize(15.0f);
        }
        TextView textView6 = this.D;
        if (textView6 != null) {
            textView6.setTextSize(15.0f);
        }
        TextView textView7 = this.A;
        if (textView7 != null) {
            textView7.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
        }
        TextView textView8 = this.D;
        if (textView8 != null) {
            textView8.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
        }
        RecyclerView e = e();
        if (e != null) {
            e.stopScroll();
        }
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView3 = this.a;
        if (feedListAdapterForRecyclerView3 != null) {
            feedListAdapterForRecyclerView3.setNewData(this.Q);
        }
        if (this.Q.size() == 0) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.b;
            if (noDataAndLoadFailView != null) {
                noDataAndLoadFailView.a();
            }
            View h = h();
            if (h != null) {
                h.setVisibility(8);
            }
        } else {
            NoDataAndLoadFailView noDataAndLoadFailView2 = this.b;
            if (noDataAndLoadFailView2 != null) {
                noDataAndLoadFailView2.d();
            }
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$JlRS1ioUTIo_D2j2x5qrjiqX3mE
            @Override // java.lang.Runnable
            public final void run() {
                FeedSubjectDetailFragment.b(FeedSubjectDetailFragment.this);
            }
        }, 100L);
    }

    private final void r() {
        if (this.L && this.S == 0) {
            this.Q.clear();
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
            if (feedListAdapterForRecyclerView != null) {
                this.Q.addAll(feedListAdapterForRecyclerView.getData());
            }
            this.O = i();
            this.V = f().findFirstVisibleItemPosition();
            View childAt = f().getChildAt(0);
            if (childAt != null) {
                this.W = childAt.getTop();
            }
            LogUtils.c("recommendTypePosition: " + this.V + ", recommendTypeScrollY: " + this.W);
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = this.a;
            if (feedListAdapterForRecyclerView2 != null) {
                feedListAdapterForRecyclerView2.b(30);
            }
            this.L = false;
            a(this.P);
            a(g.a.g);
            TextView textView = this.z;
            if (textView != null) {
                textView.setTextSize(15.0f);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                textView2.setTextSize(15.0f);
            }
            TextView textView3 = this.z;
            if (textView3 != null) {
                textView3.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
            }
            TextView textView4 = this.C;
            if (textView4 != null) {
                textView4.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
            }
            TextView textView5 = this.A;
            if (textView5 != null) {
                textView5.setTextSize(17.0f);
            }
            TextView textView6 = this.D;
            if (textView6 != null) {
                textView6.setTextSize(17.0f);
            }
            TextView textView7 = this.A;
            if (textView7 != null) {
                textView7.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            }
            TextView textView8 = this.D;
            if (textView8 != null) {
                textView8.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            }
            RecyclerView e = e();
            if (e != null) {
                e.stopScroll();
            }
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView3 = this.a;
            if (feedListAdapterForRecyclerView3 != null) {
                feedListAdapterForRecyclerView3.setNewData(this.R);
            }
            if (!this.ad) {
                NoDataAndLoadFailView noDataAndLoadFailView = this.b;
                if (noDataAndLoadFailView != null) {
                    noDataAndLoadFailView.d();
                }
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$thik_CHWj0vahoTnDobLl6kkvAc
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedSubjectDetailFragment.c(FeedSubjectDetailFragment.this);
                    }
                }, 100L);
                return;
            }
            a(true);
            NoDataAndLoadFailView noDataAndLoadFailView2 = this.b;
            if (noDataAndLoadFailView2 != null) {
                noDataAndLoadFailView2.a();
            }
            View h = h();
            if (h != null) {
                h.setVisibility(8);
            }
            f().scrollToPositionWithOffset(this.X, this.Y);
            d(0);
            u();
            this.ad = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        String str;
        String str2;
        CardView findViewById;
        CardView findViewById2;
        CardView findViewById3;
        CardView findViewById4;
        CardView findViewById5;
        CardView findViewById6;
        CardView findViewById7;
        CardView findViewById8;
        CardView findViewById9;
        CardView findViewById10;
        CardView findViewById11;
        CardView findViewById12;
        CardView findViewById13;
        CardView findViewById14;
        CardView findViewById15;
        CardView findViewById16;
        CardView findViewById17;
        if (CommunityManager.a.a().s()) {
            str = "#414141";
            str2 = "#3C3C3C";
        } else {
            str = "#DCDCDC";
            str2 = "#E9E9E9";
        }
        final int parseColor = Color.parseColor(str);
        final int parseColor2 = Color.parseColor(str2);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View view = this.J;
        objectRef.a = view == null ? null : view.findViewById(R.id.feed_subject_detail_skeleton_top_bg);
        View view2 = (View) objectRef.a;
        if (view2 != null) {
            view2.setBackgroundColor(parseColor);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$bsPJl2HvMZPlhatS7Rut8zSUtEE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedSubjectDetailFragment.a(Ref.ObjectRef.this, parseColor, parseColor2, valueAnimator);
            }
        });
        ofInt.setRepeatCount(10);
        ofInt.setDuration(1250L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
        int parseColor3 = Color.parseColor(CommunityManager.a.a().s() ? "#505050" : "#E7E7E7");
        ShapeLinearLayout shapeLinearLayout = this.K;
        ShapeModel shapeModel = shapeLinearLayout == null ? null : shapeLinearLayout.getShapeModel();
        ShapeModel shapeModel2 = shapeModel;
        if (shapeModel == null) {
            shapeModel2 = new ShapeModel();
        }
        shapeModel2.k = Color.parseColor(CommunityManager.a.a().s() ? "#373737" : "#FFFFFF");
        ShapeLinearLayout shapeLinearLayout2 = this.K;
        if (shapeLinearLayout2 != null) {
            shapeLinearLayout2.setShapeModel(shapeModel2);
        }
        View view3 = this.J;
        if (view3 != null && (findViewById17 = view3.findViewById(R.id.feed_subject_detail_skeleton_name_icon)) != null) {
            findViewById17.setCardBackgroundColor(parseColor3);
        }
        View view4 = this.J;
        if (view4 != null && (findViewById16 = view4.findViewById(R.id.feed_subject_detail_skeleton_name)) != null) {
            findViewById16.setCardBackgroundColor(parseColor3);
        }
        View view5 = this.J;
        if (view5 != null && (findViewById15 = view5.findViewById(R.id.feed_subject_detail_skeleton_feed)) != null) {
            findViewById15.setCardBackgroundColor(parseColor3);
        }
        View view6 = this.J;
        if (view6 != null && (findViewById14 = view6.findViewById(R.id.feed_subject_detail_skeleton_viewer)) != null) {
            findViewById14.setCardBackgroundColor(parseColor3);
        }
        View view7 = this.J;
        if (view7 != null && (findViewById13 = view7.findViewById(R.id.feed_subject_detail_skeleton_feed_header)) != null) {
            findViewById13.setCardBackgroundColor(parseColor3);
        }
        View view8 = this.J;
        if (view8 != null && (findViewById12 = view8.findViewById(R.id.feed_subject_detail_skeleton_feed_name)) != null) {
            findViewById12.setCardBackgroundColor(parseColor3);
        }
        View view9 = this.J;
        if (view9 != null && (findViewById11 = view9.findViewById(R.id.feed_subject_detail_skeleton_feed_content_line_1)) != null) {
            findViewById11.setCardBackgroundColor(parseColor3);
        }
        View view10 = this.J;
        if (view10 != null && (findViewById10 = view10.findViewById(R.id.feed_subject_detail_skeleton_feed_content_line_2)) != null) {
            findViewById10.setCardBackgroundColor(parseColor3);
        }
        View view11 = this.J;
        if (view11 != null && (findViewById9 = view11.findViewById(R.id.feed_subject_detail_skeleton_feed_content_iv)) != null) {
            findViewById9.setCardBackgroundColor(parseColor3);
        }
        View view12 = this.J;
        if (view12 != null && (findViewById8 = view12.findViewById(R.id.feed_subject_detail_skeleton_feed_tag_1)) != null) {
            findViewById8.setCardBackgroundColor(parseColor3);
        }
        View view13 = this.J;
        if (view13 != null && (findViewById7 = view13.findViewById(R.id.feed_subject_detail_skeleton_feed_tag_2)) != null) {
            findViewById7.setCardBackgroundColor(parseColor3);
        }
        View view14 = this.J;
        if (view14 != null && (findViewById6 = view14.findViewById(R.id.feed_subject_detail_skeleton_feed_tag_3)) != null) {
            findViewById6.setCardBackgroundColor(parseColor3);
        }
        View view15 = this.J;
        if (view15 != null && (findViewById5 = view15.findViewById(R.id.feed_subject_detail_skeleton_feed_two_header)) != null) {
            findViewById5.setCardBackgroundColor(parseColor3);
        }
        View view16 = this.J;
        if (view16 != null && (findViewById4 = view16.findViewById(R.id.feed_subject_detail_skeleton_feed_two_name)) != null) {
            findViewById4.setCardBackgroundColor(parseColor3);
        }
        View view17 = this.J;
        if (view17 != null && (findViewById3 = view17.findViewById(R.id.feed_subject_detail_skeleton_feed_two_content_line_1)) != null) {
            findViewById3.setCardBackgroundColor(parseColor3);
        }
        View view18 = this.J;
        if (view18 != null && (findViewById2 = view18.findViewById(R.id.feed_subject_detail_skeleton_feed_two_content_line_2)) != null) {
            findViewById2.setCardBackgroundColor(parseColor3);
        }
        View view19 = this.J;
        if (view19 != null && (findViewById = view19.findViewById(R.id.feed_subject_detail_skeleton_feed_two_content_iv)) != null) {
            findViewById.setCardBackgroundColor(parseColor3);
        }
        View view20 = this.J;
        View findViewById18 = view20 == null ? null : view20.findViewById(R.id.feed_subject_detail_skeleton_info_margin_view);
        if (findViewById18 != null) {
            findViewById18.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$tPkKmJD_hja17pDFZPDnJQ-FOoY
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view21, MotionEvent motionEvent) {
                    boolean a;
                    a = FeedSubjectDetailFragment.a(FeedSubjectDetailFragment.this, view21, motionEvent);
                    return a;
                }
            });
        }
        View view21 = this.J;
        View findViewById19 = view21 == null ? null : view21.findViewById(R.id.feed_subject_detail_skeleton_feed_content_root);
        if (findViewById19 != null) {
            findViewById19.setBackgroundColor(Color.parseColor(CommunityManager.a.a().s() ? "#373737" : "#FFFFFF"));
        }
        if (findViewById19 != null) {
            findViewById19.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$qFlr1Gz8dxY8VCQIJV6tOEBO8pg
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view22, MotionEvent motionEvent) {
                    boolean a;
                    a = FeedSubjectDetailFragment.a(view22, motionEvent);
                    return a;
                }
            });
        }
        ShapeLinearLayout shapeLinearLayout3 = this.K;
        if (shapeLinearLayout3 == null) {
            return;
        }
        shapeLinearLayout3.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$1XctKywDAPcFiWj0LRgeeTCndt8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view22, MotionEvent motionEvent) {
                boolean b;
                b = FeedSubjectDetailFragment.b(view22, motionEvent);
                return b;
            }
        });
    }

    private final void t() {
        View view = this.J;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final void u() {
        this.ae = true;
        if (this.M == 0) {
            this.M = FeedMethods.c(105);
        }
        if (this.N == 0) {
            this.N = FeedMethods.c(45);
        }
        View view = this.J;
        if (view != null) {
            view.setVisibility(0);
        }
        ShapeLinearLayout shapeLinearLayout = this.K;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setVisibility(8);
        }
        View view2 = this.J;
        View findViewById = view2 == null ? null : view2.findViewById(R.id.feed_subject_detail_skeleton_top_bg);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View view3 = this.J;
        View findViewById2 = view3 == null ? null : view3.findViewById(R.id.feed_subject_detail_skeleton_info_margin_view);
        if (findViewById2 != null && this.i != null) {
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            View view4 = this.i;
            Intrinsics.a(view4);
            marginLayoutParams.height = view4.getMeasuredHeight();
        }
        View view5 = this.J;
        View findViewById3 = view5 == null ? null : view5.findViewById(R.id.feed_subject_detail_skeleton_feed_content_root);
        if (findViewById3 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = findViewById3.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = FeedMethods.c(12);
        ViewGroup.LayoutParams layoutParams3 = findViewById3.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = FeedMethods.c(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        BluedTopic bluedTopic = this.f;
        if (bluedTopic == null) {
            return;
        }
        if (CommunityManager.a.a().s()) {
            CardView cardView = this.w;
            if (cardView != null) {
                cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            TextView textView = this.x;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.syc_dark_h));
            }
        } else {
            CardView cardView2 = this.w;
            if (cardView2 != null) {
                cardView2.setCardBackgroundColor(Color.parseColor("#151515"));
            }
            TextView textView2 = this.x;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.white));
            }
        }
        if (bluedTopic.is_follow == 1) {
            CardView cardView3 = this.w;
            if (cardView3 != null) {
                cardView3.setAlpha(0.5f);
            }
            TextView textView3 = this.x;
            if (textView3 != null) {
                textView3.setText(getString(R.string.followed));
            }
            CardView cardView4 = this.w;
            if (cardView4 != null) {
                cardView4.setVisibility(4);
            }
            CardView cardView5 = this.l;
            if (cardView5 != null) {
                cardView5.setCardBackgroundColor(Color.parseColor("#80FFFFFF"));
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                textView4.setText(getString(R.string.followed));
            }
            TextView textView5 = this.m;
            if (textView5 == null) {
                return;
            }
            textView5.setTextColor(Color.parseColor("#80222222"));
            return;
        }
        CardView cardView6 = this.w;
        if (cardView6 != null) {
            cardView6.setAlpha(1.0f);
        }
        TextView textView6 = this.x;
        if (textView6 != null) {
            textView6.setText(getString(R.string.follow));
        }
        CardView cardView7 = this.w;
        if (cardView7 != null) {
            cardView7.setVisibility(0);
        }
        CardView cardView8 = this.l;
        if (cardView8 != null) {
            cardView8.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        TextView textView7 = this.m;
        if (textView7 != null) {
            textView7.setText(getString(R.string.follow));
        }
        TextView textView8 = this.m;
        if (textView8 == null) {
            return;
        }
        textView8.setTextColor(getResources().getColor(R.color.syc_dark_h));
    }

    private final void w() {
        BluedTopic bluedTopic = this.f;
        if (bluedTopic == null) {
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.a = bluedTopic.is_follow != 1;
        if (bluedTopic.is_follow == 1) {
            CommonAlertDialog.a(getContext(), (String) null, getString(R.string.feed_subject_cancel_followed_tips), getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$89vdJvQh2Se-BmDt12t-VZ7NqOE
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    FeedSubjectDetailFragment.a(FeedSubjectDetailFragment.this, booleanRef, dialogInterface, i);
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            c(booleanRef.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void a() {
        super.a();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        if (feedListAdapterForRecyclerView == null) {
            return;
        }
        feedListAdapterForRecyclerView.a(FeedMethods.c(12));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void a(RecyclerView recyclerView, int i) {
        CommonFloatBottomView commonFloatBottomView;
        Intrinsics.e(recyclerView, "recyclerView");
        super.a(recyclerView, i);
        this.S = i;
        if (i == 0) {
            if (!recyclerView.canScrollVertically(-1)) {
                CommonFloatBottomView commonFloatBottomView2 = this.E;
                if (commonFloatBottomView2 != null) {
                    commonFloatBottomView2.startBtmBtnShow();
                }
            } else if (!recyclerView.canScrollVertically(1) && (commonFloatBottomView = this.E) != null) {
                commonFloatBottomView.startBtmBtnHide();
            }
        }
        if (this.S != 0 || this.Z || f().findFirstVisibleItemPosition() <= l()) {
            return;
        }
        this.Z = true;
        CommonFloatBottomView commonFloatBottomView3 = this.E;
        if (commonFloatBottomView3 != null) {
            commonFloatBottomView3.startBtmBtnShow();
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void a(RecyclerView recyclerView, int i, int i2) {
        int i3;
        int i4;
        int intValue;
        int height;
        CommonFloatBottomView commonFloatBottomView;
        Intrinsics.e(recyclerView, "recyclerView");
        super.a(recyclerView, i, i2);
        if (i2 < 0 && (commonFloatBottomView = this.E) != null) {
            commonFloatBottomView.startBtmBtnShow();
        }
        int findFirstVisibleItemPosition = f().findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = f().findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0 && findLastVisibleItemPosition >= findFirstVisibleItemPosition) {
            int i5 = findFirstVisibleItemPosition;
            while (true) {
                int i6 = i5;
                if (i6 >= findLastVisibleItemPosition + 1) {
                    break;
                }
                View childAt = f().getChildAt(i6 - findFirstVisibleItemPosition);
                if (childAt != null && (height = childAt.getHeight()) > 0) {
                    if (this.L) {
                        this.T.put(i6, Integer.valueOf(height));
                    } else {
                        this.U.put(i6, Integer.valueOf(height));
                    }
                }
                i5 = i6 + 1;
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = i8;
            if (i7 >= findFirstVisibleItemPosition) {
                break;
            } else if (this.L) {
                i4 = i3;
                if (this.T.indexOfKey(i7) >= 0) {
                    Integer num = this.T.get(i7);
                    Intrinsics.c(num, "recommendFeedHeightArray.get(i)");
                    intValue = num.intValue();
                    i4 = i3 + intValue;
                    i7++;
                    i8 = i4;
                } else {
                    i7++;
                    i8 = i4;
                }
            } else {
                i4 = i3;
                if (this.U.indexOfKey(i7) >= 0) {
                    Integer num2 = this.U.get(i7);
                    Intrinsics.c(num2, "latestFeedHeightArray.get(i)");
                    intValue = num2.intValue();
                    i4 = i3 + intValue;
                    i7++;
                    i8 = i4;
                } else {
                    i7++;
                    i8 = i4;
                }
            }
        }
        View childAt2 = f().getChildAt(0);
        int i9 = i3;
        if (childAt2 != null) {
            i9 = i3 + Math.abs(childAt2.getTop());
        }
        if (i9 < 0) {
            i9 = 0;
        }
        d(i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void a(boolean z) {
        super.a(z);
        if (this.L) {
            this.O = i();
        } else {
            this.P = i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void b() {
        super.b();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_subject_detail_header_view, (ViewGroup) null);
        this.i = inflate;
        this.c = inflate == null ? null : (ImageView) inflate.findViewById(R.id.feed_subject_detail_img);
        View view = this.i;
        this.j = view == null ? null : (ShapeLinearLayout) view.findViewById(R.id.feed_subject_detail_info_ll);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.I = FeedMethods.c(20);
        shapeModel.J = FeedMethods.c(20);
        ShapeLinearLayout shapeLinearLayout = this.j;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setShapeModel(shapeModel);
        }
        View view2 = this.i;
        this.k = view2 == null ? null : (TextView) view2.findViewById(R.id.feed_subject_detail_name_tv);
        View view3 = this.i;
        this.l = view3 == null ? null : view3.findViewById(R.id.feed_subject_detail_follow_btn);
        View view4 = this.i;
        this.m = view4 == null ? null : (TextView) view4.findViewById(R.id.feed_subject_detail_follow_tv);
        CardView cardView = this.l;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$5K9_vM6g-4_lWJi9KFVl64Sc_90
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    FeedSubjectDetailFragment.f(FeedSubjectDetailFragment.this, view5);
                }
            });
        }
        View view5 = this.i;
        this.n = view5 == null ? null : (TextView) view5.findViewById(R.id.feed_subject_detail_feed_count);
        View view6 = this.i;
        this.o = view6 == null ? null : (TextView) view6.findViewById(R.id.feed_subject_detail_viewer_count);
        View view7 = this.i;
        this.p = view7 == null ? null : (TextView) view7.findViewById(R.id.feed_subject_detail_des);
        View view8 = this.i;
        this.B = view8 == null ? null : (ShapeLinearLayout) view8.findViewById(R.id.feed_subject_detail_type_layout);
        ShapeModel shapeModel2 = new ShapeModel();
        shapeModel2.I = FeedMethods.c(6);
        shapeModel2.J = FeedMethods.c(6);
        shapeModel2.k = BluedSkinUtils.a(getContext(), R.color.syc_b);
        ShapeLinearLayout shapeLinearLayout2 = this.B;
        if (shapeLinearLayout2 != null) {
            shapeLinearLayout2.setShapeModel(shapeModel2);
        }
        View view9 = this.i;
        this.C = view9 == null ? null : (TextView) view9.findViewById(R.id.feed_subject_detail_type_recommend);
        View view10 = this.i;
        this.D = view10 == null ? null : (TextView) view10.findViewById(R.id.feed_subject_detail_type_latest);
        TextView textView = this.C;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$XjDM_9ALPcmnT3Wobe6TFg-shxk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view11) {
                    FeedSubjectDetailFragment.g(FeedSubjectDetailFragment.this, view11);
                }
            });
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$bymVAZzmpcyeFZhXqv5UN547oaE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view11) {
                    FeedSubjectDetailFragment.h(FeedSubjectDetailFragment.this, view11);
                }
            });
        }
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.addHeaderView(this.i);
        }
        View view11 = this.i;
        this.b = view11 == null ? null : (NoDataAndLoadFailView) view11.findViewById(R.id.no_data_view);
        NoDataAndLoadFailView noDataAndLoadFailView = this.b;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.setNoDataStr(R.string.no_content_for_now);
            noDataAndLoadFailView.setTopSpace(DensityUtils.a(getContext(), 60.0f));
            noDataAndLoadFailView.setBottomSpace(FeedMethods.c(120));
        }
        View view12 = this.i;
        View findViewById = view12 == null ? null : view12.findViewById(R.id.feed_subject_detail_top_divider);
        this.I = findViewById;
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void c() {
        int i;
        String str;
        super.c();
        if (CommunityManager.a.a().s()) {
            View view = this.rootView;
            if (view != null) {
                view.setBackgroundResource(R.color.syc_151515);
            }
        } else {
            View view2 = this.rootView;
            if (view2 != null) {
                view2.setBackgroundResource(R.color.syc_b);
            }
        }
        BluedTopic bluedTopic = this.f;
        if (bluedTopic != null) {
            TextView textView = this.u;
            if (textView != null) {
                textView.setText(bluedTopic.name);
            }
            if (bluedTopic.is_anonym == 1) {
                TextView textView2 = this.H;
                if (textView2 != null) {
                    textView2.setText(R.string.super_topic_post);
                }
                if (CommunityManager.a.a().s()) {
                    ImageView imageView = this.v;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.feed_post_subject_annony);
                    }
                } else {
                    ImageView imageView2 = this.v;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.feed_post_subject_annony_dark);
                    }
                }
                i = R.drawable.feed_post_subject_annony;
                ImageView imageView3 = this.s;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
            } else {
                TextView textView3 = this.H;
                if (textView3 != null) {
                    textView3.setText(R.string.post);
                }
                if (CommunityManager.a.a().s()) {
                    ImageView imageView4 = this.v;
                    if (imageView4 != null) {
                        imageView4.setImageResource(R.drawable.feed_post_subject_icon);
                    }
                } else {
                    ImageView imageView5 = this.v;
                    if (imageView5 != null) {
                        imageView5.setImageResource(R.drawable.feed_post_subject_icon_dark);
                    }
                }
                i = R.drawable.feed_post_subject_icon;
                ImageView imageView6 = this.s;
                if (imageView6 != null) {
                    imageView6.setVisibility(0);
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bluedTopic.name);
            spannableStringBuilder.insert(0, (CharSequence) "s ");
            Drawable drawable = getResources().getDrawable(i);
            drawable.setBounds(0, 0, FeedMethods.c(20), FeedMethods.c(20));
            spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 33);
            TextView textView4 = this.k;
            if (textView4 != null) {
                textView4.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            }
            TextView textView5 = this.n;
            if (textView5 != null) {
                textView5.setText(Intrinsics.a(CommonStringUtils.b(bluedTopic.ticktocks_total), (Object) "动态"));
            }
            TextView textView6 = this.o;
            if (textView6 != null) {
                textView6.setText(Intrinsics.a(CommonStringUtils.b(bluedTopic.visited_total), (Object) "浏览"));
            }
            if (TextUtils.isEmpty(bluedTopic.description)) {
                TextView textView7 = this.p;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
            } else {
                TextView textView8 = this.p;
                if (textView8 != null) {
                    textView8.setMovementMethod(LinkMovementMethod.getInstance());
                    int i2 = AppInfo.l;
                    int c = FeedMethods.c(24);
                    TextPaint paint = textView8.getPaint();
                    String str2 = bluedTopic.description;
                    Intrinsics.c(str2, "it.description");
                    int a = StringsKt.a((CharSequence) str2, "[Lottery1](", 0, false, 6, (Object) null);
                    if (a >= 0) {
                        String str3 = (String) bluedTopic.description.subSequence(0, a);
                        float measureText = paint.measureText(Intrinsics.a(str3, (Object) "..."));
                        int i3 = (i2 - c) * 2;
                        if (measureText > i3 - FeedMethods.c(78)) {
                            while (measureText > i3 - FeedMethods.c(78)) {
                                str3 = str3.substring(0, str3.length() - 1);
                                Intrinsics.c(str3, "this as java.lang.String…ing(startIndex, endIndex)");
                                measureText = paint.measureText(Intrinsics.a(str3, (Object) "..."));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append("...");
                            String str4 = bluedTopic.description;
                            Intrinsics.c(str4, "it.description");
                            String substring = str4.substring(a);
                            Intrinsics.c(substring, "this as java.lang.String).substring(startIndex)");
                            sb.append(substring);
                            str = sb.toString();
                        } else {
                            str = bluedTopic.description;
                            Intrinsics.c(str, "it.description");
                        }
                        textView8.setText(MarkDownLinkHelper.a(getContext(), str, true, R.color.syc_m, true, (MarkDownLinkHelper.MDLinkOnClickListener) null));
                    } else {
                        textView8.setText(MarkDownLinkHelper.a(getContext(), bluedTopic.description, true, R.color.syc_m, true, (MarkDownLinkHelper.MDLinkOnClickListener) null));
                    }
                    textView8.setVisibility(0);
                }
            }
            int parseColor = Color.parseColor("#5E4434");
            int i4 = parseColor;
            if (!TextUtils.isEmpty(bluedTopic.bg_color)) {
                try {
                    i4 = Color.parseColor(bluedTopic.bg_color);
                } catch (Exception e) {
                    i4 = parseColor;
                }
            }
            RecyclerView e2 = e();
            if (e2 != null) {
                e2.setBackgroundColor(i4);
            }
            ShapeLinearLayout shapeLinearLayout = this.j;
            ShapeModel shapeModel = shapeLinearLayout == null ? null : shapeLinearLayout.getShapeModel();
            ShapeModel shapeModel2 = shapeModel;
            if (shapeModel == null) {
                shapeModel2 = new ShapeModel();
                shapeModel2.I = DensityUtils.a(getContext(), 20.0f);
                shapeModel2.J = DensityUtils.a(getContext(), 20.0f);
            }
            shapeModel2.k = i4;
            ShapeLinearLayout shapeLinearLayout2 = this.j;
            if (shapeLinearLayout2 != null) {
                shapeLinearLayout2.setShapeModel(shapeModel2);
            }
            if (!this.ab && this.L) {
                EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, FeedConstants.b, bluedTopic.super_did, bluedTopic.is_anonym == 1, MarkDownLinkHelper.a(bluedTopic.description), FeedProtos.FeedPage.TOPIC_RECOMMEND, bluedTopic.is_follow == 1);
                this.ab = true;
            }
            if (!this.ac && !this.L) {
                EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, FeedConstants.b, bluedTopic.super_did, bluedTopic.is_anonym == 1, MarkDownLinkHelper.a(bluedTopic.description), FeedProtos.FeedPage.TOPIC_NEW, bluedTopic.is_follow == 1);
                this.ac = true;
            }
            List<BluedIngSelfFeed> list = bluedTopic.tt;
            Intrinsics.c(list, "it.tt");
            if ((!list.isEmpty()) && bluedTopic.tt.get(0).is_top_feed == 1) {
                View view3 = this.I;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            } else {
                View view4 = this.I;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            v();
        }
        t();
    }

    public void onDestroy() {
        super.onDestroy();
        FeedConstants.b = FeedProtos.DetailFrom.UNKNOWN_DETAIL_FROM;
    }

    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void onInitView() {
        b(29);
        super.onInitView();
        this.M = FeedMethods.c(105);
        this.N = FeedMethods.c(45);
        View view = this.rootView;
        this.q = view == null ? null : view.findViewById(R.id.feed_subject_detail_title_fl);
        View view2 = this.rootView;
        this.r = view2 == null ? null : (ImageView) view2.findViewById(R.id.feed_subject_detail_title_close);
        View view3 = this.rootView;
        this.s = view3 == null ? null : (ImageView) view3.findViewById(R.id.feed_subject_detail_title_share);
        View view4 = this.rootView;
        this.u = view4 == null ? null : (TextView) view4.findViewById(R.id.feed_subject_detail_title_tv);
        View view5 = this.rootView;
        this.t = view5 == null ? null : view5.findViewById(R.id.feed_subject_detail_title_center_lo);
        View view6 = this.rootView;
        this.v = view6 == null ? null : (ImageView) view6.findViewById(R.id.feed_subject_detail_title_iv);
        View view7 = this.rootView;
        this.w = view7 == null ? null : view7.findViewById(R.id.feed_subject_detail_title_follow_btn);
        View view8 = this.rootView;
        this.x = view8 == null ? null : (TextView) view8.findViewById(R.id.feed_subject_detail_title_follow_tv);
        CardView cardView = this.w;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$v_pHI9hXOc2QQAIQ0S4FJNgDYyg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    FeedSubjectDetailFragment.a(FeedSubjectDetailFragment.this, view9);
                }
            });
        }
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$yAprQIp40k3DAWFKymhgzS20bPE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    FeedSubjectDetailFragment.b(FeedSubjectDetailFragment.this, view9);
                }
            });
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$or55skK6JjJrJ_LE3na0Vpr6BhA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    FeedSubjectDetailFragment.c(FeedSubjectDetailFragment.this, view9);
                }
            });
        }
        View view9 = this.rootView;
        this.y = view9 == null ? null : view9.findViewById(R.id.feed_subject_detail_title_type_layout);
        View view10 = this.rootView;
        this.z = view10 == null ? null : (TextView) view10.findViewById(R.id.feed_subject_detail_title_type_recommend);
        View view11 = this.rootView;
        this.A = view11 == null ? null : (TextView) view11.findViewById(R.id.feed_subject_detail_title_type_latest);
        TextView textView = this.z;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$VnqDlC_MgdzLSfVSFAKJdVIr8m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view12) {
                    FeedSubjectDetailFragment.d(FeedSubjectDetailFragment.this, view12);
                }
            });
        }
        TextView textView2 = this.A;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectDetailFragment$GKMO_3cN_2-gvGCid9F1XAJgzs4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view12) {
                    FeedSubjectDetailFragment.e(FeedSubjectDetailFragment.this, view12);
                }
            });
        }
        if (CommunityManager.a.a().s()) {
            View view12 = this.rootView;
            if (view12 != null) {
                view12.setBackgroundResource(R.color.syc_151515);
            }
        } else {
            View view13 = this.rootView;
            if (view13 != null) {
                view13.setBackgroundResource(R.color.syc_b);
            }
        }
        View view14 = this.rootView;
        CommonFloatBottomView findViewById = view14 == null ? null : view14.findViewById(R.id.feed_subject_send_float_view);
        this.E = findViewById;
        if (findViewById != null) {
            findViewById.setOnBtnClickListener(new CommonFloatBottomView.OnBtnClickListener() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectDetailFragment$onInitView$6
                public void onClick() {
                    FeedSubjectDetailFragment.this.o();
                }
            });
        }
        CommonFloatBottomView commonFloatBottomView = this.E;
        if (commonFloatBottomView != null) {
            commonFloatBottomView.setVisibility(0);
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_subject_send_btn_layout, (ViewGroup) null);
        this.F = inflate;
        this.G = inflate == null ? null : inflate.findViewById(R.id.feed_subject_send_bg);
        View view15 = this.F;
        this.H = view15 == null ? null : (TextView) view15.findViewById(R.id.feed_subject_send_tv);
        View view16 = this.G;
        if (view16 != null) {
            view16.setVisibility(8);
        }
        CommonFloatBottomView commonFloatBottomView2 = this.E;
        if (commonFloatBottomView2 != null) {
            commonFloatBottomView2.addChildView(this.F);
        }
        View view17 = this.rootView;
        this.J = view17 == null ? null : view17.findViewById(R.id.feed_subject_detail_skeleton_id);
        View view18 = this.rootView;
        this.K = view18 == null ? null : (ShapeLinearLayout) view18.findViewById(R.id.feed_subject_detail_skeleton_info_ll);
        s();
    }

    public int onSetRootViewId() {
        return R.layout.fragment_feed_subject_detail;
    }
}

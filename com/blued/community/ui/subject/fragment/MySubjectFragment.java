package com.blued.community.ui.subject.fragment;

import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.fragment.BaseViewPagerParentFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoScrollViewPager;
import com.blued.community.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/MySubjectFragment.class */
public final class MySubjectFragment extends BaseViewPagerParentFragment {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f20235a;
    private CardView b;

    /* renamed from: c  reason: collision with root package name */
    private CardView f20236c;
    private int d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MySubjectFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (this.d == 0) {
            CardView cardView = this.b;
            if (cardView != null) {
                cardView.setCardBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_y));
            }
            CardView cardView2 = this.f20236c;
            if (cardView2 == null) {
                return;
            }
            cardView2.setCardBackgroundColor(0);
            return;
        }
        CardView cardView3 = this.b;
        if (cardView3 != null) {
            cardView3.setCardBackgroundColor(0);
        }
        CardView cardView4 = this.f20236c;
        if (cardView4 == null) {
            return;
        }
        cardView4.setCardBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MySubjectFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ViewPager viewPager = this$0.h;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MySubjectFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ViewPager viewPager = this$0.h;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(1, true);
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void a() {
        this.j.add(new FeedSubjectAttentionFragment());
        this.j.add(new FeedSubjectJoinedFragment());
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public BaseFragment b(int i) {
        return i == 1 ? new FeedSubjectJoinedFragment() : new FeedSubjectAttentionFragment();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.my_subject_title);
        this.f20235a = commonTopTitleNoTrans;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$MySubjectFragment$NUOiKJr4D2BtOyeQ-j7RFfWKnSA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MySubjectFragment.a(MySubjectFragment.this, view);
                }
            });
        }
        this.b = (CardView) this.rootView.findViewById(R.id.my_subject_tab_attention);
        this.f20236c = (CardView) this.rootView.findViewById(R.id.emotion_mall_tab_mine);
        CardView cardView = this.b;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$MySubjectFragment$9Jx7rzwAvYv77Pq_0mIuqyn6y7s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MySubjectFragment.b(MySubjectFragment.this, view);
                }
            });
        }
        CardView cardView2 = this.f20236c;
        if (cardView2 != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$MySubjectFragment$7Ed4pfiAp9FzeJwLFWR5_83iBEk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MySubjectFragment.c(MySubjectFragment.this, view);
                }
            });
        }
        ViewPager viewPager = this.h;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.subject.fragment.MySubjectFragment$onInitView$4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    MySubjectFragment.this.d = i;
                    MySubjectFragment.this.b();
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                }
            });
        }
        if (this.h instanceof NoScrollViewPager) {
            ViewPager viewPager2 = this.h;
            if (viewPager2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.view.NoScrollViewPager");
            }
            ((NoScrollViewPager) viewPager2).a(false);
        }
        b();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        ViewPager viewPager = this.h;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(this.d, false);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        this.d = this.args.getInt("index");
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_my_subject;
    }
}

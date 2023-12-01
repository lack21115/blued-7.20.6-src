package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYHotTopicPageAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyHotTopicBinding;
import com.blued.android.module.yy_china.model.HotTopicModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.view.YYHotTopicTabView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicListFragment.class */
public final class YYHotTopicListFragment extends MvpFragment<MvpPresenter> {
    public static final Companion a = new Companion(null);
    private FragmentYyHotTopicBinding b;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHotTopicListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            TerminalActivity.a(bundle);
            TerminalActivity.b(bundle);
            TerminalActivity.d(context, YYHotTopicListFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHotTopicListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    private final void b() {
        ViewPager viewPager;
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        LinearLayout titleBackground;
        CommonTopTitleNoTrans commonTopTitleNoTrans3;
        FragmentYyHotTopicBinding a2 = FragmentYyHotTopicBinding.a(this.i);
        this.b = a2;
        if (a2 != null && (commonTopTitleNoTrans3 = a2.e) != null) {
            commonTopTitleNoTrans3.setCenterText("热议话题");
        }
        FragmentYyHotTopicBinding fragmentYyHotTopicBinding = this.b;
        if (fragmentYyHotTopicBinding != null && (commonTopTitleNoTrans2 = fragmentYyHotTopicBinding.e) != null && (titleBackground = commonTopTitleNoTrans2.getTitleBackground()) != null) {
            titleBackground.setBackgroundResource(R.color.transparent);
        }
        FragmentYyHotTopicBinding fragmentYyHotTopicBinding2 = this.b;
        if (fragmentYyHotTopicBinding2 != null && (commonTopTitleNoTrans = fragmentYyHotTopicBinding2.e) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHotTopicListFragment$qLxZz1XKyTy55CFkyotjwu562yk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHotTopicListFragment.a(YYHotTopicListFragment.this, view);
                }
            });
        }
        FragmentYyHotTopicBinding fragmentYyHotTopicBinding3 = this.b;
        if (fragmentYyHotTopicBinding3 != null && (noDataAndLoadFailView2 = fragmentYyHotTopicBinding3.b) != null) {
            noDataAndLoadFailView2.setBackgroundColorRes(R.color.transparent);
        }
        FragmentYyHotTopicBinding fragmentYyHotTopicBinding4 = this.b;
        if (fragmentYyHotTopicBinding4 != null && (noDataAndLoadFailView = fragmentYyHotTopicBinding4.b) != null) {
            noDataAndLoadFailView.setNoDataStr(R.string.yy_hot_topic_no_data);
        }
        FragmentYyHotTopicBinding fragmentYyHotTopicBinding5 = this.b;
        if (fragmentYyHotTopicBinding5 != null && (viewPager = fragmentYyHotTopicBinding5.c) != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicListFragment$initView$2
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    FragmentYyHotTopicBinding fragmentYyHotTopicBinding6;
                    YYHotTopicTabView yYHotTopicTabView;
                    fragmentYyHotTopicBinding6 = YYHotTopicListFragment.this.b;
                    if (fragmentYyHotTopicBinding6 == null || (yYHotTopicTabView = fragmentYyHotTopicBinding6.d) == null) {
                        return;
                    }
                    yYHotTopicTabView.setToolBtnSelect(i);
                }
            });
        }
        c();
    }

    private final void c() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.l(new BluedUIHttpResponse<BluedEntityA<HotTopicModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYHotTopicListFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<HotTopicModel> p0) {
                FragmentYyHotTopicBinding fragmentYyHotTopicBinding;
                FragmentYyHotTopicBinding fragmentYyHotTopicBinding2;
                FragmentYyHotTopicBinding fragmentYyHotTopicBinding3;
                FragmentYyHotTopicBinding fragmentYyHotTopicBinding4;
                YYHotTopicTabView yYHotTopicTabView;
                YYHotTopicTabView yYHotTopicTabView2;
                FragmentYyHotTopicBinding fragmentYyHotTopicBinding5;
                Intrinsics.e(p0, "p0");
                if (!p0.hasData()) {
                    fragmentYyHotTopicBinding = YYHotTopicListFragment.this.b;
                    NoDataAndLoadFailView noDataAndLoadFailView = fragmentYyHotTopicBinding == null ? null : fragmentYyHotTopicBinding.b;
                    if (noDataAndLoadFailView == null) {
                        return;
                    }
                    noDataAndLoadFailView.setVisibility(0);
                    return;
                }
                p0.data.add(0, new HotTopicModel("0", "全部"));
                fragmentYyHotTopicBinding2 = YYHotTopicListFragment.this.b;
                if (fragmentYyHotTopicBinding2 != null && (yYHotTopicTabView2 = fragmentYyHotTopicBinding2.d) != null) {
                    fragmentYyHotTopicBinding5 = YYHotTopicListFragment.this.b;
                    ViewPager viewPager = fragmentYyHotTopicBinding5 == null ? null : fragmentYyHotTopicBinding5.c;
                    Intrinsics.a(viewPager);
                    Intrinsics.c(viewPager, "vb?.roomViewPager!!");
                    yYHotTopicTabView2.a(viewPager);
                }
                fragmentYyHotTopicBinding3 = YYHotTopicListFragment.this.b;
                if (fragmentYyHotTopicBinding3 != null && (yYHotTopicTabView = fragmentYyHotTopicBinding3.d) != null) {
                    yYHotTopicTabView.setData(p0.data);
                }
                PagerAdapter yYHotTopicPageAdapter = new YYHotTopicPageAdapter(YYHotTopicListFragment.this.getChildFragmentManager());
                fragmentYyHotTopicBinding4 = YYHotTopicListFragment.this.b;
                ViewPager viewPager2 = fragmentYyHotTopicBinding4 == null ? null : fragmentYyHotTopicBinding4.c;
                if (viewPager2 != null) {
                    viewPager2.setAdapter(yYHotTopicPageAdapter);
                }
                yYHotTopicPageAdapter.b(p0.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_hot_topic;
    }
}

package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.provider.BrowserContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRankItemLayoutBinding;
import com.blued.android.module.yy_china.fragment.YYRankItemFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.TabItemTextModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankItemFragment.class */
public final class YYRankItemFragment extends BaseLazyFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17401a = new Companion(null);
    private FragmentYyRankItemLayoutBinding b;

    /* renamed from: c  reason: collision with root package name */
    private int f17402c;
    private TabAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankItemFragment$ChildFragmentAdapter.class */
    public final class ChildFragmentAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRankItemFragment f17403a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildFragmentAdapter(YYRankItemFragment this$0) {
            super(this$0.getChildFragmentManager(), 1);
            Intrinsics.e(this$0, "this$0");
            this.f17403a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            Integer valueOf;
            if (this.f17403a.d != null) {
                TabAdapter tabAdapter = this.f17403a.d;
                if ((tabAdapter == null ? null : tabAdapter.getData()) == null) {
                    return 0;
                }
                TabAdapter tabAdapter2 = this.f17403a.d;
                if (tabAdapter2 == null) {
                    valueOf = null;
                } else {
                    List<TabItemTextModel> data = tabAdapter2.getData();
                    valueOf = data == null ? null : Integer.valueOf(data.size());
                }
                Intrinsics.a(valueOf);
                return valueOf.intValue();
            }
            return 0;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            YYRankChildFragment yYRankChildFragment = new YYRankChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("rank_type", this.f17403a.f17402c);
            bundle.putInt(BrowserContract.Bookmarks.POSITION, i);
            yYRankChildFragment.setArguments(bundle);
            return yYRankChildFragment;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankItemFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankItemFragment$TabAdapter.class */
    public final class TabAdapter extends BaseQuickAdapter<TabItemTextModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRankItemFragment f17404a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabAdapter(YYRankItemFragment this$0) {
            super(R.layout.tab_item_text_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17404a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(BaseViewHolder baseViewHolder, TabAdapter this$0, YYRankItemFragment this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            int adapterPosition = baseViewHolder.getAdapterPosition();
            this$0.a(adapterPosition);
            FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding = this$1.b;
            FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding2 = fragmentYyRankItemLayoutBinding;
            if (fragmentYyRankItemLayoutBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankItemLayoutBinding2 = null;
            }
            fragmentYyRankItemLayoutBinding2.b.setCurrentItem(adapterPosition);
        }

        public final void a(int i) {
            List<TabItemTextModel> data = getData();
            Intrinsics.c(data, "data");
            for (TabItemTextModel tabItemTextModel : data) {
                tabItemTextModel.setChecked(false);
            }
            getData().get(i).setChecked(true);
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, TabItemTextModel tabItemTextModel) {
            View view;
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_item_text);
            if (textView != null) {
                textView.setText(tabItemTextModel == null ? null : tabItemTextModel.getTabName());
            }
            ShapeFrameLayout shapeFrameLayout = baseViewHolder == null ? null : (ShapeFrameLayout) baseViewHolder.getView(R.id.ll_item_background);
            if (shapeFrameLayout != null) {
                boolean z = true;
                if (tabItemTextModel == null || !tabItemTextModel.getChecked()) {
                    z = false;
                }
                shapeFrameLayout.setVisibility(z ? 0 : 4);
            }
            if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
                return;
            }
            final YYRankItemFragment yYRankItemFragment = this.f17404a;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRankItemFragment$TabAdapter$LSsZf3SBwNKqRusKur-ZT-nra7k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRankItemFragment.TabAdapter.a(BaseViewHolder.this, this, yYRankItemFragment, view2);
                }
            });
        }
    }

    private final void b() {
        if (StatusBarHelper.a()) {
            FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding = this.b;
            FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding2 = fragmentYyRankItemLayoutBinding;
            if (fragmentYyRankItemLayoutBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankItemLayoutBinding2 = null;
            }
            ViewGroup.LayoutParams layoutParams = fragmentYyRankItemLayoutBinding2.f16533a.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = DensityUtils.a(getContext(), 35.0f) + StatusBarHelper.a(getContext());
        }
    }

    private final void c() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.d = new TabAdapter(this);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding = this.b;
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding2 = fragmentYyRankItemLayoutBinding;
        if (fragmentYyRankItemLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding2 = null;
        }
        fragmentYyRankItemLayoutBinding2.f16534c.setLayoutManager(gridLayoutManager);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding3 = this.b;
        if (fragmentYyRankItemLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding3 = null;
        }
        fragmentYyRankItemLayoutBinding3.f16534c.setAdapter(this.d);
        ArrayList arrayList = new ArrayList();
        TabItemTextModel tabItemTextModel = new TabItemTextModel(0, "current", "本场", true);
        TabItemTextModel tabItemTextModel2 = new TabItemTextModel(1, "day", "日榜", false);
        TabItemTextModel tabItemTextModel3 = new TabItemTextModel(2, "week", "周榜", false);
        arrayList.add(tabItemTextModel);
        arrayList.add(tabItemTextModel2);
        arrayList.add(tabItemTextModel3);
        TabAdapter tabAdapter = this.d;
        if (tabAdapter == null) {
            return;
        }
        tabAdapter.setNewData(arrayList);
    }

    private final void d() {
        ChildFragmentAdapter childFragmentAdapter = new ChildFragmentAdapter(this);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding = this.b;
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding2 = fragmentYyRankItemLayoutBinding;
        if (fragmentYyRankItemLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding2 = null;
        }
        fragmentYyRankItemLayoutBinding2.b.setAdapter(childFragmentAdapter);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding3 = this.b;
        if (fragmentYyRankItemLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding3 = null;
        }
        fragmentYyRankItemLayoutBinding3.b.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYRankItemFragment$initViewPager$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                YYRankItemFragment.TabAdapter tabAdapter = YYRankItemFragment.this.d;
                if (tabAdapter == null) {
                    return;
                }
                tabAdapter.a(i);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment
    public void a() {
        ChatRoomProtos.Event event;
        super.a();
        if (this.f17402c == 0) {
            LogUtils.d("YYRankItemFragment", "setUserVisibleHint 获赠榜 。。。 ");
            event = ChatRoomProtos.Event.CHAT_ROOM_LIST_PAGE_GET_SHOW;
        } else {
            LogUtils.d("YYRankItemFragment", "setUserVisibleHint 赠送榜 。。。 ");
            event = ChatRoomProtos.Event.CHAT_ROOM_LIST_PAGE_SEND_SHOW;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(event, b.room_id, b.uid);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.f17402c = arguments.getInt(BrowserContract.Bookmarks.POSITION);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_yy_rank_item_layout, (ViewGroup) null);
        FragmentYyRankItemLayoutBinding a2 = FragmentYyRankItemLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.b = a2;
        b();
        c();
        d();
        return inflate;
    }
}

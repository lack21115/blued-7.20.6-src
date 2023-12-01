package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
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
    public static final Companion a = new Companion(null);
    private FragmentYyRankItemLayoutBinding b;
    private int c;
    private TabAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankItemFragment$ChildFragmentAdapter.class */
    public final class ChildFragmentAdapter extends FragmentPagerAdapter {
        final /* synthetic */ YYRankItemFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildFragmentAdapter(YYRankItemFragment this$0) {
            super(this$0.getChildFragmentManager(), 1);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        public int getCount() {
            Integer valueOf;
            if (this.a.d != null) {
                TabAdapter tabAdapter = this.a.d;
                if ((tabAdapter == null ? null : tabAdapter.getData()) == null) {
                    return 0;
                }
                TabAdapter tabAdapter2 = this.a.d;
                if (tabAdapter2 == null) {
                    valueOf = null;
                } else {
                    List data = tabAdapter2.getData();
                    valueOf = data == null ? null : Integer.valueOf(data.size());
                }
                Intrinsics.a(valueOf);
                return valueOf.intValue();
            }
            return 0;
        }

        public Fragment getItem(int i) {
            YYRankChildFragment yYRankChildFragment = new YYRankChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("rank_type", this.a.c);
            bundle.putInt("position", i);
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
        final /* synthetic */ YYRankItemFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabAdapter(YYRankItemFragment this$0) {
            super(R.layout.tab_item_text_layout);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
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
            ((TabItemTextModel) getData().get(i)).setChecked(true);
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
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
            final YYRankItemFragment yYRankItemFragment = this.a;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRankItemFragment$TabAdapter$LSsZf3SBwNKqRusKur-ZT-nra7k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRankItemFragment.TabAdapter.a(baseViewHolder, this, yYRankItemFragment, view2);
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
            ConstraintLayout.LayoutParams layoutParams = fragmentYyRankItemLayoutBinding2.a.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            layoutParams.topMargin = DensityUtils.a(getContext(), 35.0f) + StatusBarHelper.a(getContext());
        }
    }

    private final void c() {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.d = new TabAdapter(this);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding = this.b;
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding2 = fragmentYyRankItemLayoutBinding;
        if (fragmentYyRankItemLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding2 = null;
        }
        fragmentYyRankItemLayoutBinding2.c.setLayoutManager(gridLayoutManager);
        FragmentYyRankItemLayoutBinding fragmentYyRankItemLayoutBinding3 = this.b;
        if (fragmentYyRankItemLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankItemLayoutBinding3 = null;
        }
        fragmentYyRankItemLayoutBinding3.c.setAdapter(this.d);
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
        PagerAdapter childFragmentAdapter = new ChildFragmentAdapter(this);
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
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

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
        if (this.c == 0) {
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

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.c = arguments.getInt("position");
    }

    @Override // com.blued.android.core.ui.BaseFragment
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

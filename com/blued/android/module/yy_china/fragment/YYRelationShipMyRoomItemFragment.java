package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyMyRelationshipBinding;
import com.blued.android.module.yy_china.fragment.YYRelationShipMyRoomItemFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMyRoom;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.YYRelationShipMyRoomItemPresenter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRelationShipMyRoomItemFragment.class */
public final class YYRelationShipMyRoomItemFragment extends MvpFragment<YYRelationShipMyRoomItemPresenter> {
    private FragmentYyMyRelationshipBinding a;
    private final RelationShipMyRoomAdapter b = new RelationShipMyRoomAdapter(this);
    private YYRelationShipRoomMode c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRelationShipMyRoomItemFragment$RelationShipMyRoomAdapter.class */
    public final class RelationShipMyRoomAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomMyRoom, BaseViewHolder> {
        final /* synthetic */ YYRelationShipMyRoomItemFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RelationShipMyRoomAdapter(YYRelationShipMyRoomItemFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_yy_my_relation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipMyRoomItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getTarge_uid_profile().getRoom_id());
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0265, code lost:
            if (r0 == null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x02d0, code lost:
            if (r0 == null) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void b(com.chad.library.adapter.base.BaseViewHolder r7, com.blued.android.module.yy_china.model.YYRelationShipRoomMyRoom r8) {
            /*
                Method dump skipped, instructions count: 849
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYRelationShipMyRoomItemFragment.RelationShipMyRoomAdapter.b(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.YYRelationShipRoomMyRoom):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomMyRoom item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    private final void b(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding = this.a;
        if (fragmentYyMyRelationshipBinding != null && (smartRefreshLayout2 = fragmentYyMyRelationshipBinding.d) != null) {
            smartRefreshLayout2.g();
        }
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding2 = this.a;
        if (fragmentYyMyRelationshipBinding2 != null && (smartRefreshLayout = fragmentYyMyRelationshipBinding2.d) != null) {
            smartRefreshLayout.h();
        }
        LinearLayout linearLayout = null;
        if (this.b.getData().size() > 0) {
            FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding3 = this.a;
            LinearLayout linearLayout2 = fragmentYyMyRelationshipBinding3 == null ? null : fragmentYyMyRelationshipBinding3.b;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } else if (!z) {
            FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding4 = this.a;
            LinearLayout linearLayout3 = fragmentYyMyRelationshipBinding4 == null ? null : fragmentYyMyRelationshipBinding4.b;
            if (linearLayout3 == null) {
                return;
            }
            linearLayout3.setVisibility(0);
        } else {
            FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding5 = this.a;
            if (fragmentYyMyRelationshipBinding5 != null) {
                linearLayout = fragmentYyMyRelationshipBinding5.b;
            }
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    private final void c() {
        YYRelationShipRoomUiInfo resource_options;
        String icon_empty_data;
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyMyRelationshipBinding a = FragmentYyMyRelationshipBinding.a(this.i);
        this.a = a;
        RecyclerView recyclerView = a == null ? null : a.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding = this.a;
        RecyclerView recyclerView2 = fragmentYyMyRelationshipBinding == null ? null : fragmentYyMyRelationshipBinding.c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding2 = this.a;
        if (fragmentYyMyRelationshipBinding2 != null && (smartRefreshLayout = fragmentYyMyRelationshipBinding2.d) != null) {
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYRelationShipMyRoomItemFragment$initView$1
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYRelationShipMyRoomItemFragment.this.j().f();
                }

                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYRelationShipMyRoomItemFragment.this.j().e();
                }
            });
        }
        ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRelationShipRoomMode yYRelationShipRoomMode = this.c;
        String str = "";
        if (yYRelationShipRoomMode != null && (resource_options = yYRelationShipRoomMode.getResource_options()) != null && (icon_empty_data = resource_options.getIcon_empty_data()) != null) {
            str = icon_empty_data;
        }
        ImageWrapper a2 = ImageLoader.a(fragmentActive, str);
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding3 = this.a;
        a2.a(fragmentYyMyRelationshipBinding3 == null ? null : fragmentYyMyRelationshipBinding3.a);
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding4 = this.a;
        TextView textView = fragmentYyMyRelationshipBinding4 == null ? null : fragmentYyMyRelationshipBinding4.e;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("暂无「");
            YYRelationShipRoomMode yYRelationShipRoomMode2 = this.c;
            sb.append((Object) (yYRelationShipRoomMode2 == null ? null : yYRelationShipRoomMode2.getRelation_name()));
            sb.append((char) 12301);
            textView.setText(sb.toString());
        }
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding5 = this.a;
        TextView textView2 = fragmentYyMyRelationshipBinding5 == null ? null : fragmentYyMyRelationshipBinding5.f;
        if (textView2 == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("快去配对自己的「");
        YYRelationShipRoomMode yYRelationShipRoomMode3 = this.c;
        sb2.append((Object) (yYRelationShipRoomMode3 == null ? null : yYRelationShipRoomMode3.getRelation_name()));
        sb2.append("」吧～");
        textView2.setText(sb2.toString());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.c = yYRelationShipRoomMode;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List<?> list) {
        super.a(str, list);
        if (Intrinsics.a((Object) str, (Object) j().m())) {
            MvpUtils.a(list, YYRelationShipRoomMyRoom.class, new MvpUtils.DataListHandler<YYRelationShipRoomMyRoom>() { // from class: com.blued.android.module.yy_china.fragment.YYRelationShipMyRoomItemFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<YYRelationShipRoomMyRoom> list2) {
                    YYRelationShipMyRoomItemFragment.RelationShipMyRoomAdapter relationShipMyRoomAdapter;
                    Intrinsics.e(list2, "list");
                    relationShipMyRoomAdapter = YYRelationShipMyRoomItemFragment.this.b;
                    relationShipMyRoomAdapter.setNewData(list2);
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        if (Intrinsics.a((Object) str, (Object) "_load_type_refresh_") ? true : Intrinsics.a((Object) str, (Object) "_load_type_loadmore_")) {
            b(z);
        }
    }

    public final YYRelationShipRoomMode b() {
        return this.c;
    }

    public final void c(String roomId) {
        Intrinsics.e(roomId, "roomId");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (StringUtils.a(b == null ? null : b.room_id, roomId)) {
            return;
        }
        YYRoomInfoManager e = YYRoomInfoManager.e();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
        }
        e.a((BaseFragmentActivity) activity, roomId, "");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_my_relationship;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding = this.a;
        if (fragmentYyMyRelationshipBinding == null || (smartRefreshLayout = fragmentYyMyRelationshipBinding.d) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding = this.a;
        if (fragmentYyMyRelationshipBinding == null || (smartRefreshLayout = fragmentYyMyRelationshipBinding.d) == null) {
            return;
        }
        smartRefreshLayout.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentYyMyRelationshipBinding fragmentYyMyRelationshipBinding = this.a;
        if (fragmentYyMyRelationshipBinding == null || (smartRefreshLayout = fragmentYyMyRelationshipBinding.d) == null) {
            return;
        }
        smartRefreshLayout.b(false);
    }
}

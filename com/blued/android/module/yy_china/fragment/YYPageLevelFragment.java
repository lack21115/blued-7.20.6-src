package com.blued.android.module.yy_china.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentPageLevelLayoutBinding;
import com.blued.android.module.yy_china.databinding.ItemPageLevelBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YyPkLevelListModel;
import com.blued.android.module.yy_china.model.YyPkRecordListModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPageLevelFragment.class */
public class YYPageLevelFragment extends BaseFragment {
    private FragmentPageLevelLayoutBinding a;
    private Ada b;
    private int c = 1;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPageLevelFragment$Ada.class */
    public static final class Ada extends BaseQuickAdapter<YyPkRecordListModel, BaseViewHolder> {
        private SimpleDateFormat a;

        public Ada() {
            super(R.layout.item_page_level, new ArrayList());
            this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YyPkRecordListModel yyPkRecordListModel) {
            View view = baseViewHolder == null ? null : baseViewHolder.itemView;
            Intrinsics.a(view);
            ItemPageLevelBinding a = ItemPageLevelBinding.a(view);
            Intrinsics.c(a, "bind(helper?.itemView!!)");
            a.a.setText(yyPkRecordListModel == null ? null : yyPkRecordListModel.getName());
            TextView textView = a.c;
            SimpleDateFormat simpleDateFormat = this.a;
            Long valueOf = yyPkRecordListModel == null ? null : Long.valueOf(yyPkRecordListModel.getTime());
            Intrinsics.a(valueOf);
            textView.setText(simpleDateFormat.format(new Date(valueOf.longValue())));
            a.b.setText(yyPkRecordListModel.getScore());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YyPkLevelListModel yyPkLevelListModel) {
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding = this.a;
        TextView textView = fragmentPageLevelLayoutBinding == null ? null : fragmentPageLevelLayoutBinding.k;
        if (textView != null) {
            textView.setText(yyPkLevelListModel.getPk_count());
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding2 = this.a;
        TextView textView2 = fragmentPageLevelLayoutBinding2 == null ? null : fragmentPageLevelLayoutBinding2.l;
        if (textView2 != null) {
            textView2.setText(yyPkLevelListModel.getWin_count());
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding3 = this.a;
        TextView textView3 = fragmentPageLevelLayoutBinding3 == null ? null : fragmentPageLevelLayoutBinding3.j;
        if (textView3 != null) {
            textView3.setText(yyPkLevelListModel.getScore());
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding4 = this.a;
        TextView textView4 = fragmentPageLevelLayoutBinding4 == null ? null : fragmentPageLevelLayoutBinding4.i;
        if (textView4 != null) {
            textView4.setText(yyPkLevelListModel.getWin_rate());
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding5 = this.a;
        TextView textView5 = fragmentPageLevelLayoutBinding5 == null ? null : fragmentPageLevelLayoutBinding5.h;
        if (textView5 != null) {
            textView5.setText(yyPkLevelListModel.getLevel());
        }
        ImageLoader.a(getFragmentActive(), yyPkLevelListModel.getLevel_img()).a((Target) new CustomTarget<Drawable>() { // from class: com.blued.android.module.yy_china.fragment.YYPageLevelFragment$refreshPKLevelUI$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding6;
                ConstraintLayout constraintLayout;
                Intrinsics.e(resource, "resource");
                fragmentPageLevelLayoutBinding6 = YYPageLevelFragment.this.a;
                if (fragmentPageLevelLayoutBinding6 == null || (constraintLayout = fragmentPageLevelLayoutBinding6.a) == null) {
                    return;
                }
                constraintLayout.setBackgroundDrawable(resource);
            }

            public void onLoadCleared(Drawable drawable) {
            }
        });
    }

    private final void f() {
        SmartRefreshLayout smartRefreshLayout;
        RefreshFooter refreshFooter;
        View view;
        FrameLayout frameLayout;
        SmartRefreshLayout smartRefreshLayout2;
        b();
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding = this.a;
        if (fragmentPageLevelLayoutBinding != null && (smartRefreshLayout2 = fragmentPageLevelLayoutBinding.g) != null) {
            smartRefreshLayout2.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYPageLevelFragment$initView$1
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYPageLevelFragment.this.d();
                }

                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYPageLevelFragment.this.c = 1;
                    YYPageLevelFragment.this.d();
                }
            });
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding2 = this.a;
        if (fragmentPageLevelLayoutBinding2 != null && (smartRefreshLayout = fragmentPageLevelLayoutBinding2.g) != null && (refreshFooter = smartRefreshLayout.getRefreshFooter()) != null && (view = refreshFooter.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.layout_load_more_view)) != null) {
            frameLayout.setBackgroundResource(R.color.transparent);
        }
        Ada ada = new Ada();
        this.b = ada;
        if (ada != null) {
            ada.setEnableLoadMore(false);
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding3 = this.a;
        RecyclerView recyclerView = fragmentPageLevelLayoutBinding3 == null ? null : fragmentPageLevelLayoutBinding3.f;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding4 = this.a;
        RecyclerView recyclerView2 = fragmentPageLevelLayoutBinding4 == null ? null : fragmentPageLevelLayoutBinding4.f;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding = this.a;
        if (fragmentPageLevelLayoutBinding != null && (smartRefreshLayout2 = fragmentPageLevelLayoutBinding.g) != null) {
            smartRefreshLayout2.h();
        }
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding2 = this.a;
        if (fragmentPageLevelLayoutBinding2 == null || (smartRefreshLayout = fragmentPageLevelLayoutBinding2.g) == null) {
            return;
        }
        smartRefreshLayout.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.c;
    }

    public void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.g(b.room_id, (BluedUIHttpResponse) c(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BluedUIHttpResponse<BluedEntityA<YyPkLevelListModel>> c() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        return new BluedUIHttpResponse<BluedEntityA<YyPkLevelListModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPageLevelFragment$getLevelHttpResponse$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YyPkLevelListModel> bluedEntityA) {
                YyPkLevelListModel singleData;
                Boolean valueOf = bluedEntityA == null ? null : Boolean.valueOf(bluedEntityA.hasData());
                Intrinsics.a(valueOf);
                if (!valueOf.booleanValue() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYPageLevelFragment.this.a(singleData);
            }
        };
    }

    public void d() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.c(b.room_id, String.valueOf(this.c), (BluedUIHttpResponse) e(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BluedUIHttpResponse<BluedEntity<YyPkRecordListModel, BluedEntityBaseExtra>> e() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        return new BluedUIHttpResponse<BluedEntity<YyPkRecordListModel, BluedEntityBaseExtra>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPageLevelFragment$getRecordHttpResponse$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                YYPageLevelFragment.this.g();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                YYPageLevelFragment.this.g();
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
                r0 = r4.a.b;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.yy_china.model.YyPkRecordListModel, com.blued.android.framework.http.parser.BluedEntityBaseExtra> r5) {
                /*
                    Method dump skipped, instructions count: 217
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYPageLevelFragment$getRecordHttpResponse$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
            }
        };
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PK_CREATE_LEVEL_PAGE_SHOW;
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = null;
        String str2 = b == null ? null : b.room_id;
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 != null) {
            str = b2.uid;
        }
        EventTrackYY.d(event, str2, str);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = FragmentPageLevelLayoutBinding.a(getLayoutInflater(), viewGroup, true);
        f();
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding = this.a;
        return fragmentPageLevelLayoutBinding == null ? null : fragmentPageLevelLayoutBinding.getRoot();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        FragmentPageLevelLayoutBinding fragmentPageLevelLayoutBinding = this.a;
        if (fragmentPageLevelLayoutBinding == null || (smartRefreshLayout = fragmentPageLevelLayoutBinding.g) == null) {
            return;
        }
        smartRefreshLayout.i();
    }
}

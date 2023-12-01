package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvMusicListBinding;
import com.blued.android.module.yy_china.fragment.YYKtvMusicListFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYKtvMusicExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvMusicListFragment.class */
public final class YYKtvMusicListFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private String f17307a;
    private FragmentYyKtvMusicListBinding b;

    /* renamed from: c  reason: collision with root package name */
    private YYRoomModel f17308c;
    private KtvMusicAdapter d;
    private String e;
    private OnCLickSingNumListener f;
    private NoDataAndLoadFailView g;
    private View h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvMusicListFragment$KtvMusicAdapter.class */
    public final class KtvMusicAdapter extends BaseMultiItemQuickAdapter<YYKtvMusicModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYKtvMusicListFragment f17309a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KtvMusicAdapter(YYKtvMusicListFragment this$0) {
            super(null);
            Intrinsics.e(this$0, "this$0");
            this.f17309a = this$0;
            addItemType(0, R.layout.item_yy_ktv_music_info);
            addItemType(1, R.layout.live_music_item_no_more_view);
        }

        private final void a(YYKtvMusicModel yYKtvMusicModel) {
            Boolean normalKtv;
            final YYKtvMusicListFragment yYKtvMusicListFragment = this.f17309a;
            YYRoomModel yYRoomModel = yYKtvMusicListFragment.f17308c;
            if (yYRoomModel != null && (normalKtv = yYRoomModel.getNormalKtv()) != null) {
                boolean booleanValue = normalKtv.booleanValue();
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_QUEUE_CLICK;
                YYRoomModel yYRoomModel2 = yYKtvMusicListFragment.f17308c;
                String str = yYRoomModel2 == null ? null : yYRoomModel2.room_id;
                YYRoomModel yYRoomModel3 = yYKtvMusicListFragment.f17308c;
                EventTrackYY.b(event, str, yYRoomModel3 == null ? null : yYRoomModel3.uid, yYKtvMusicModel.musicId, !booleanValue);
            }
            String str2 = yYKtvMusicModel.bigCoverUrl == null ? yYKtvMusicModel.coverUrl : yYKtvMusicModel.bigCoverUrl;
            YYRoomModel yYRoomModel4 = yYKtvMusicListFragment.f17308c;
            String str3 = yYRoomModel4 == null ? null : yYRoomModel4.room_id;
            long j = yYKtvMusicModel.duration;
            final ActivityFragmentActive fragmentActive = yYKtvMusicListFragment.getFragmentActive();
            YYRoomHttpUtils.a(str3, yYKtvMusicModel.musicId, yYKtvMusicModel.musicName, yYKtvMusicModel.artist, str2, j, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYKtvMusicListFragment$KtvMusicAdapter$getMusicDetails$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fragmentActive);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    ToastUtils.a("点歌成功");
                    YYRoomInfoManager.e().H();
                    YYKtvMusicListFragment.this.getParentFragmentManager().setFragmentResult("key_cancel", BundleKt.bundleOf(new Pair[0]));
                }
            }, yYKtvMusicListFragment.getFragmentActive());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYKtvMusicListFragment this$0, KtvMusicAdapter this$1, YYKtvMusicModel yYKtvMusicModel, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            OnCLickSingNumListener a2 = this$0.a();
            if (a2 != null && a2.Z_()) {
                this$1.a(yYKtvMusicModel);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(final YYKtvMusicListFragment this$0, final KtvMusicAdapter this$1, final YYKtvMusicModel yYKtvMusicModel, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            if (YYRoomInfoManager.e().i()) {
                new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicListFragment$KtvMusicAdapter$KWNMPzChn1bDrPbDjDS-xViPSEU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        YYKtvMusicListFragment.KtvMusicAdapter.a(YYKtvMusicListFragment.this, this$1, yYKtvMusicModel, view2);
                    }
                }, 2000L, null).onClick(view);
                return;
            }
            LiveEventBus.get("EVENT_KTV_GUIDE_APPL_UP_MIC").post("");
            YYRoomModel yYRoomModel = this$0.f17308c;
            if (yYRoomModel == null) {
                return;
            }
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_KTV_NO_MIKE_SONG_CLICK, yYRoomModel.room_id, yYRoomModel.uid);
        }

        private final void b(BaseViewHolder baseViewHolder, final YYKtvMusicModel yYKtvMusicModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.music_cover);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_music_writer);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_book_in);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_logo);
            if (yYKtvMusicModel == null) {
                return;
            }
            final YYKtvMusicListFragment yYKtvMusicListFragment = this.f17309a;
            ImageLoader.a(yYKtvMusicListFragment.getFragmentActive(), yYKtvMusicModel.coverUrl).a(imageView);
            if (textView != null) {
                textView.setText(yYKtvMusicModel.musicName);
            }
            if (textView2 != null) {
                textView2.setText(yYKtvMusicModel.artist);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(TextUtils.equals("Featured", yYKtvMusicModel.recommendType) ? 0 : 8);
            }
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicListFragment$KtvMusicAdapter$Rx3y8zT9ZsCuyfjsOqCBUTQC-tg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYKtvMusicListFragment.KtvMusicAdapter.b(YYKtvMusicListFragment.this, this, yYKtvMusicModel, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYKtvMusicModel yYKtvMusicModel) {
            if (baseViewHolder != null && baseViewHolder.getItemViewType() == 0) {
                b(baseViewHolder, yYKtvMusicModel);
            }
        }
    }

    public YYKtvMusicListFragment(String PlaylistId) {
        Intrinsics.e(PlaylistId, "PlaylistId");
        this.f17307a = PlaylistId;
        this.e = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<YYKtvMusicModel> list) {
        KtvMusicAdapter ktvMusicAdapter;
        if (TextUtils.isEmpty(this.e)) {
            KtvMusicAdapter ktvMusicAdapter2 = this.d;
            if (ktvMusicAdapter2 == null) {
                return;
            }
            ktvMusicAdapter2.setNewData(list);
        } else if (list == null || (ktvMusicAdapter = this.d) == null) {
        } else {
            ktvMusicAdapter.addData((Collection) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        Collection data;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        boolean z2 = true;
        if (z) {
            FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding = this.b;
            if (fragmentYyKtvMusicListBinding != null && (smartRefreshLayout4 = fragmentYyKtvMusicListBinding.f16519a) != null) {
                smartRefreshLayout4.l(true);
            }
            View view = this.h;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding2 = this.b;
            if (fragmentYyKtvMusicListBinding2 != null && (smartRefreshLayout = fragmentYyKtvMusicListBinding2.f16519a) != null) {
                smartRefreshLayout.l(false);
            }
            View view2 = this.h;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding3 = this.b;
        if (fragmentYyKtvMusicListBinding3 != null && (smartRefreshLayout3 = fragmentYyKtvMusicListBinding3.f16519a) != null) {
            smartRefreshLayout3.h();
        }
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding4 = this.b;
        if (fragmentYyKtvMusicListBinding4 != null && (smartRefreshLayout2 = fragmentYyKtvMusicListBinding4.f16519a) != null) {
            smartRefreshLayout2.j();
        }
        KtvMusicAdapter ktvMusicAdapter = this.d;
        if (ktvMusicAdapter == null || (data = ktvMusicAdapter.getData()) == null || data.size() != 0) {
            z2 = false;
        }
        if (z2) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.g;
            if (noDataAndLoadFailView == null) {
                return;
            }
            noDataAndLoadFailView.a();
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.g;
        if (noDataAndLoadFailView2 == null) {
            return;
        }
        noDataAndLoadFailView2.d();
    }

    private final void b() {
        SmartRefreshLayout smartRefreshLayout;
        RefreshFooter refreshFooter;
        View view;
        FrameLayout frameLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.d = new KtvMusicAdapter(this);
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding = this.b;
        RecyclerView recyclerView = fragmentYyKtvMusicListBinding == null ? null : fragmentYyKtvMusicListBinding.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding2 = this.b;
        RecyclerView recyclerView2 = fragmentYyKtvMusicListBinding2 == null ? null : fragmentYyKtvMusicListBinding2.b;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.d);
        }
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.g = noDataAndLoadFailView;
        if (noDataAndLoadFailView != null) {
            noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_common);
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.g;
        if (noDataAndLoadFailView2 != null) {
            noDataAndLoadFailView2.setBackgroundColorRes(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView3 = this.g;
        if (noDataAndLoadFailView3 != null) {
            noDataAndLoadFailView3.setFailTextColor(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView4 = this.g;
        if (noDataAndLoadFailView4 != null) {
            noDataAndLoadFailView4.setTopSpace(DensityUtils.a(getContext(), 40.0f));
        }
        NoDataAndLoadFailView noDataAndLoadFailView5 = this.g;
        if (noDataAndLoadFailView5 != null) {
            noDataAndLoadFailView5.setNoDataTextColor(R.color.transparent);
        }
        NoDataAndLoadFailView noDataAndLoadFailView6 = this.g;
        if (noDataAndLoadFailView6 != null) {
            noDataAndLoadFailView6.d();
        }
        KtvMusicAdapter ktvMusicAdapter = this.d;
        if (ktvMusicAdapter != null) {
            ktvMusicAdapter.setEmptyView(this.g);
        }
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding3 = this.b;
        if (fragmentYyKtvMusicListBinding3 != null && (smartRefreshLayout3 = fragmentYyKtvMusicListBinding3.f16519a) != null) {
            smartRefreshLayout3.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYKtvMusicListFragment$initView$1
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYKtvMusicListFragment.this.c();
                }

                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYKtvMusicListFragment.this.e = "";
                    YYKtvMusicListFragment.this.c();
                }
            });
        }
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding4 = this.b;
        if (fragmentYyKtvMusicListBinding4 != null && (smartRefreshLayout2 = fragmentYyKtvMusicListBinding4.f16519a) != null) {
            smartRefreshLayout2.a(bluedLoadMoreView);
        }
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding5 = this.b;
        if (fragmentYyKtvMusicListBinding5 != null && (smartRefreshLayout = fragmentYyKtvMusicListBinding5.f16519a) != null && (refreshFooter = smartRefreshLayout.getRefreshFooter()) != null && (view = refreshFooter.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.layout_load_more_view)) != null) {
            frameLayout.setBackgroundResource(R.color.transparent);
        }
        View inflate = View.inflate(getContext(), R.layout.layout_load_end_footer, null);
        this.h = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        KtvMusicAdapter ktvMusicAdapter2 = this.d;
        if (ktvMusicAdapter2 != null) {
            ktvMusicAdapter2.addFooterView(this.h);
        }
        KtvMusicAdapter ktvMusicAdapter3 = this.d;
        if (ktvMusicAdapter3 == null) {
            return;
        }
        ktvMusicAdapter3.setEnableLoadMore(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        String str = this.f17307a;
        String str2 = this.e;
        YYRoomModel yYRoomModel = this.f17308c;
        String str3 = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.b(str, str2, str3, "1", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYKtvMusicListFragment$loadData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                String str4;
                super.onUIFinish(z);
                YYKtvMusicListFragment yYKtvMusicListFragment = YYKtvMusicListFragment.this;
                str4 = yYKtvMusicListFragment.e;
                yYKtvMusicListFragment.a(!TextUtils.isEmpty(str4));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYKtvMusicModel, YYKtvMusicExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    YYKtvMusicListFragment.this.e = "";
                    YYKtvMusicListFragment.this.a(false);
                    return;
                }
                YYKtvMusicListFragment.this.a(bluedEntity.data);
                YYKtvMusicExtra yYKtvMusicExtra = bluedEntity.extra;
                if (yYKtvMusicExtra == null) {
                    return;
                }
                YYKtvMusicListFragment.this.e = yYKtvMusicExtra.ScrollToken;
            }
        }, getFragmentActive());
    }

    public final OnCLickSingNumListener a() {
        return this.f;
    }

    public final void a(OnCLickSingNumListener onCLickSingNumListener) {
        this.f = onCLickSingNumListener;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17308c = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_yy_ktv_music_list, (ViewGroup) null);
        this.b = FragmentYyKtvMusicListBinding.a(inflate);
        b();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        FragmentYyKtvMusicListBinding fragmentYyKtvMusicListBinding = this.b;
        if (fragmentYyKtvMusicListBinding == null || (smartRefreshLayout = fragmentYyKtvMusicListBinding.f16519a) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_TAB_SHOW;
        YYRoomModel yYRoomModel = this.f17308c;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.f17308c;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.b(event, str2, str, this.f17307a);
    }
}

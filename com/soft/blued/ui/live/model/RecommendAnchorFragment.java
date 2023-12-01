package com.soft.blued.ui.live.model;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.openalliance.ad.constant.s;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.fragment.LiveListTabFragment;
import com.soft.blued.ui.live.model.RecommendAnchorFragment;
import com.soft.blued.user.BluedConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/RecommendAnchorFragment.class */
public class RecommendAnchorFragment extends SimpleFragment {
    private CommonRecycleAdapter<RecommendAnchorModel> adapter;
    private GridLayoutManager layoutManager;
    private NoDataAndLoadFailView noDataView;
    private RecyclerView recyclerView;
    private SmartRefreshLayout refreshLayout;
    private CommonTopTitleNoTrans titleBar;
    private int imgHeight = 500;
    private List<String> lids = new ArrayList();
    private final int VIEW_TYPE_GAME = -10087;
    private final int VIEW_TYPE_ANCHOR = -10086;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.live.model.RecommendAnchorFragment$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/RecommendAnchorFragment$1.class */
    public class AnonymousClass1 extends CommonRecycleAdapter<RecommendAnchorModel> {
        AnonymousClass1(Context context) {
            super(context);
        }

        private int getPlayTypeRes(RecommendAnchorModel recommendAnchorModel) {
            if (recommendAnchorModel.link_type == 1) {
                return R.drawable.recommend_live_pk;
            }
            if (recommendAnchorModel.link_type == 2) {
                return R.drawable.recommend_live_friend;
            }
            return 2131237272;
        }

        private void openLiveRoom(RecommendAnchorModel recommendAnchorModel) {
            LiveRoomInfoChannel.a(AppInfo.d(), new LiveRoomData(recommendAnchorModel.lid, 0, s.B, String.valueOf(recommendAnchorModel.uid), "", "", 0));
            EventTrackLive.a(LiveProtos.Event.RECOMMEND_PAGE_ENTER_BTN_CLICK, String.valueOf(recommendAnchorModel.lid), String.valueOf(recommendAnchorModel.type), String.valueOf(recommendAnchorModel.uid));
        }

        private void setGameAnchor(final RecommendAnchorModel recommendAnchorModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (!RecommendAnchorFragment.this.lids.contains(String.valueOf(recommendAnchorModel.lid))) {
                RecommendAnchorFragment.this.lids.add(String.valueOf(recommendAnchorModel.lid));
                EventTrackLive.a(LiveProtos.Event.RECOMMEND_PAGE_ROOM_SHOW, String.valueOf(recommendAnchorModel.lid), String.valueOf(recommendAnchorModel.type), String.valueOf(recommendAnchorModel.uid));
            }
            commonAdapterHolder.b(R.id.item_recommend_anchor_avatar, recommendAnchorModel.cover).a(R.id.item_recommend_anchor_name, recommendAnchorModel.name).a(R.id.item_recommend_game_name, recommendAnchorModel.game_name).a(R.id.item_recommend_anchor_count, String.valueOf(recommendAnchorModel.watch_count)).a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.model.-$$Lambda$RecommendAnchorFragment$1$tJsf7qXjwUDb0Qukli2lepT8R6E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendAnchorFragment.AnonymousClass1.this.lambda$setGameAnchor$0$RecommendAnchorFragment$1(recommendAnchorModel, view);
                }
            });
        }

        private void setModelTitle(final RecommendAnchorModel recommendAnchorModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            commonAdapterHolder.a(R.id.item_recommoned_anchor_title_name, recommendAnchorModel.name).a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.model.-$$Lambda$RecommendAnchorFragment$1$wWwuos1mBenVGw2jqwo73cyStYs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendAnchorFragment.AnonymousClass1.this.lambda$setModelTitle$2$RecommendAnchorFragment$1(recommendAnchorModel, view);
                }
            });
        }

        private void setNormalAnchor(final RecommendAnchorModel recommendAnchorModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (!RecommendAnchorFragment.this.lids.contains(String.valueOf(recommendAnchorModel.lid))) {
                RecommendAnchorFragment.this.lids.add(String.valueOf(recommendAnchorModel.lid));
                EventTrackLive.a(LiveProtos.Event.RECOMMEND_PAGE_ROOM_SHOW, String.valueOf(recommendAnchorModel.lid), String.valueOf(recommendAnchorModel.type), String.valueOf(recommendAnchorModel.uid));
            }
            commonAdapterHolder.b(R.id.item_recommend_anchor_avatar, recommendAnchorModel.cover).a(R.id.item_recommend_anchor_name, recommendAnchorModel.name).a(R.id.item_recommend_anchor_count, String.valueOf(recommendAnchorModel.watch_count)).d(R.id.item_recommend_anchor_type_iv, getPlayTypeRes(recommendAnchorModel)).a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.model.-$$Lambda$RecommendAnchorFragment$1$ZXDp3vmZoNfugIvY5VpdopNTKvc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendAnchorFragment.AnonymousClass1.this.lambda$setNormalAnchor$1$RecommendAnchorFragment$1(recommendAnchorModel, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return ((RecommendAnchorModel) this.dataList.get(i)).viewType;
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return i == -10087 ? R.layout.item_recommend_anchor_game : i == -10086 ? R.layout.item_recommend_anchor_list : R.layout.item_recommend_anchor_list_title;
        }

        public /* synthetic */ void lambda$setGameAnchor$0$RecommendAnchorFragment$1(RecommendAnchorModel recommendAnchorModel, View view) {
            Tracker.onClick(view);
            openLiveRoom(recommendAnchorModel);
        }

        public /* synthetic */ void lambda$setModelTitle$2$RecommendAnchorFragment$1(final RecommendAnchorModel recommendAnchorModel, View view) {
            Tracker.onClick(view);
            HomeArgumentHelper.a(AppInfo.d(), "live", (Bundle) null);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.live.model.RecommendAnchorFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!BluedConfig.a().P()) {
                        if (recommendAnchorModel.type == 12) {
                            LiveListSetSelectedTab.a().a(0);
                            return;
                        } else {
                            LiveListTabFragment.a(AppInfo.d(), String.valueOf(recommendAnchorModel.type), recommendAnchorModel.name, 0);
                            return;
                        }
                    }
                    LiveTagsSetSelectedTab a2 = LiveTagsSetSelectedTab.a();
                    a2.a(recommendAnchorModel.type + "");
                }
            }, 300L);
            EventTrackLive.a(LiveProtos.Event.RECOMMEND_PAGE_MORE_BTN_CLICK, "0", String.valueOf(recommendAnchorModel.type), "0");
        }

        public /* synthetic */ void lambda$setNormalAnchor$1$RecommendAnchorFragment$1(RecommendAnchorModel recommendAnchorModel, View view) {
            Tracker.onClick(view);
            openLiveRoom(recommendAnchorModel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public void onBindViewHolderData(RecommendAnchorModel recommendAnchorModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (getItemViewType(i) == -10087) {
                setGameAnchor(recommendAnchorModel, i, commonAdapterHolder);
            } else if (getItemViewType(i) == -10086) {
                setNormalAnchor(recommendAnchorModel, i, commonAdapterHolder);
            } else {
                setModelTitle(recommendAnchorModel, i, commonAdapterHolder);
            }
        }
    }

    private void getData() {
        LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<RecommendAnchorListModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.model.RecommendAnchorFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntityA<RecommendAnchorListModel> bluedEntityA) {
                ArrayList arrayList = new ArrayList();
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    RecommendAnchorFragment.this.noDataView.setVisibility(0);
                } else {
                    for (RecommendAnchorListModel recommendAnchorListModel : bluedEntityA.data) {
                        RecommendAnchorModel recommendAnchorModel = new RecommendAnchorModel();
                        recommendAnchorModel.name = recommendAnchorListModel.name;
                        recommendAnchorModel.type = recommendAnchorListModel.type;
                        arrayList.add(recommendAnchorModel);
                        if (!TypeUtils.a((List<?>) recommendAnchorListModel.list)) {
                            for (RecommendAnchorModel recommendAnchorModel2 : recommendAnchorListModel.list) {
                                recommendAnchorModel2.type = recommendAnchorListModel.type;
                                if (recommendAnchorListModel.type == 9) {
                                    recommendAnchorModel2.viewType = -10087;
                                } else {
                                    recommendAnchorModel2.viewType = -10086;
                                }
                                arrayList.add(recommendAnchorModel2);
                            }
                        }
                    }
                    RecommendAnchorFragment.this.noDataView.setVisibility(8);
                    RecommendAnchorFragment.this.adapter.setDataAndNotify(arrayList);
                }
                RecommendAnchorFragment.this.refreshLayout.j();
            }
        });
    }

    private void initRecycleView() {
        this.refreshLayout = (SmartRefreshLayout) this.rootView.findViewById(2131369116);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(2131369096);
        this.recyclerView = recyclerView;
        recyclerView.setPadding(DisplayUtil.a(AppInfo.d(), 1.5f), 0, DisplayUtil.a(AppInfo.d(), 1.5f), 0);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(AppInfo.d());
        this.adapter = anonymousClass1;
        this.recyclerView.setAdapter(anonymousClass1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AppInfo.d(), 6);
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.live.model.RecommendAnchorFragment.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (i < RecommendAnchorFragment.this.adapter.getDataList().size()) {
                    if (((RecommendAnchorModel) RecommendAnchorFragment.this.adapter.getDataList().get(i)).viewType == -10086) {
                        return 2;
                    }
                    return ((RecommendAnchorModel) RecommendAnchorFragment.this.adapter.getDataList().get(i)).viewType == -10087 ? 3 : 6;
                }
                return 6;
            }
        });
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.refreshLayout.a(new OnRefreshListener() { // from class: com.soft.blued.ui.live.model.-$$Lambda$RecommendAnchorFragment$fq3OkqsmEB96vsKvWPdwkJiW5sY
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                RecommendAnchorFragment.this.lambda$initRecycleView$1$RecommendAnchorFragment(refreshLayout);
            }
        });
        this.refreshLayout.l(false);
        this.refreshLayout.i();
    }

    private void initTitleBar() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(2131370694);
        this.titleBar = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setVisibility(0);
        this.titleBar.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.model.-$$Lambda$RecommendAnchorFragment$Mkew2w8HlXl4H22-4nuARfLkn9Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendAnchorFragment.this.lambda$initTitleBar$0$RecommendAnchorFragment(view);
            }
        });
        this.titleBar.setCenterText(getString(R.string.recommend_anchor_title));
    }

    public static void show(Context context) {
        TerminalActivity.d(context, RecommendAnchorFragment.class, null);
    }

    public /* synthetic */ void lambda$initRecycleView$1$RecommendAnchorFragment(RefreshLayout refreshLayout) {
        getData();
    }

    public /* synthetic */ void lambda$initTitleBar$0$RecommendAnchorFragment(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        initTitleBar();
        initRecycleView();
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.rootView.findViewById(2131368721);
        this.noDataView = noDataAndLoadFailView;
        noDataAndLoadFailView.setVisibility(8);
        this.noDataView.setNoDataStr(2131891066);
        this.imgHeight = (AppInfo.l - DisplayUtil.a(AppInfo.d(), 24.0f)) / 3;
        EventTrackLive.a(LiveProtos.Event.LIVE_FOOTPRINT_PAGE_SHOW);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return 2131558935;
    }
}

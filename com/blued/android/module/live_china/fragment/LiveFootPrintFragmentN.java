package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveFootPrintModel;
import com.blued.android.module.live_china.model.LiveListCommonModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveTwoLevelRefreshView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFootPrintFragmentN.class */
public class LiveFootPrintFragmentN extends SimpleFragment {
    private CommonTopTitleNoTrans a;
    private SmartRefreshLayout b;
    private RecyclerView c;
    private GridLayoutManager d;
    private CommonRecycleAdapter<BluedLiveListData> e;
    private NoDataAndLoadFailView f;
    private CustomTwoLevelHeader g;
    private LiveTwoLevelRefreshView h;
    private int o;
    private boolean i = false;
    private LiveTwoFloorModel j = null;
    private boolean k = false;
    private LiveListCommonModel l = new LiveListCommonModel();
    private int m = 500;
    private List<String> n = new ArrayList();
    private long p = 0;
    private String q = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFootPrintFragmentN$4.class */
    public class AnonymousClass4 extends CommonRecycleAdapter<BluedLiveListData> {
        AnonymousClass4(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedLiveListData bluedLiveListData, View view) {
            LiveFootPrintFragmentN.this.a(bluedLiveListData);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final BluedLiveListData bluedLiveListData, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (getItemViewType(i) == 1 || bluedLiveListData.anchor == null) {
                return;
            }
            ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_foot_print_header);
            GridLayoutManager.LayoutParams layoutParams = commonAdapterHolder.a().getLayoutParams();
            if (layoutParams.height != LiveFootPrintFragmentN.this.m) {
                layoutParams.height = LiveFootPrintFragmentN.this.m;
                commonAdapterHolder.a().setLayoutParams(layoutParams);
            }
            ImageLoader.a(LiveFootPrintFragmentN.this.getFragmentActive(), bluedLiveListData.anchor.avatar).b(R.drawable.live_bg).a(6.0f).a(imageView);
            commonAdapterHolder.a(R.id.item_live_foot_print_time, LiveFootPrintFragmentN.this.a(AppInfo.d(), bluedLiveListData.last_start_time * 1000)).a(R.id.item_live_foot_print_name, TextUtils.isEmpty(bluedLiveListData.anchor.name) ? "" : bluedLiveListData.anchor.name).a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFootPrintFragmentN$4$nq-EyEA4nJe-m-W3pPydMkdYSGY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveFootPrintFragmentN.AnonymousClass4.this.a(bluedLiveListData, view);
                }
            });
            ImageView imageView2 = (ImageView) commonAdapterHolder.a(R.id.item_live_foot_print_state);
            if (bluedLiveListData.isLivingForFollow()) {
                imageView2.setVisibility(0);
                ImageLoader.c(LiveFootPrintFragmentN.this.getFragmentActive(), "live_living_anim.png").e(imageView2.hashCode()).g(-1).a(imageView2);
            } else {
                imageView2.setVisibility(8);
            }
            if (LiveFootPrintFragmentN.this.n.contains(bluedLiveListData.lid)) {
                return;
            }
            EventTrackLive.t(LiveProtos.Event.LIVE_ROOM_SHOW, "footprint", bluedLiveListData.lid, bluedLiveListData.anchor.uid);
            LiveFootPrintFragmentN.this.n.add(bluedLiveListData.lid);
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getItemViewType(int i) {
            return ((BluedLiveListData) this.dataList.get(i)).getItemType();
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return i == 1 ? R.layout.item_live_foot_print_footer : R.layout.item_live_foot_print;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedLiveListData bluedLiveListData) {
        if (bluedLiveListData == null || bluedLiveListData.anchor == null) {
            return;
        }
        if (!bluedLiveListData.isLivingForFollow()) {
            LiveRoomInfo.a().a(AppInfo.d(), bluedLiveListData.anchor.uid, bluedLiveListData.anchor.name, bluedLiveListData.anchor.avatar, 0, 1);
            return;
        }
        EventTrackLive.t(LiveProtos.Event.LIVE_ROOM_CLICK, "footprint", bluedLiveListData.lid, bluedLiveListData.anchor.uid);
        LiveRoomData liveRoomData = new LiveRoomData(CommonStringUtils.c(bluedLiveListData.lid), bluedLiveListData.screen_pattern, "footprint", bluedLiveListData.anchor.uid, bluedLiveListData.anchor.name, bluedLiveListData.anchor.avatar, 0);
        liveRoomData.live_url = bluedLiveListData.live_play;
        liveRoomData.details = this.q;
        LiveRoomInfo.a().a(AppInfo.d(), liveRoomData, -1, (List<LiveRoomData>) null, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RefreshLayout refreshLayout) {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        if (z) {
            this.l.setPage(1);
        } else {
            LiveListCommonModel liveListCommonModel = this.l;
            liveListCommonModel.setPage(liveListCommonModel.getPage() + 1);
        }
        LiveRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LiveFootPrintModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFootPrintModel> bluedEntityA) {
                ArrayList arrayList = new ArrayList();
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    LiveFootPrintFragmentN.this.b.b(false);
                } else {
                    for (LiveFootPrintModel liveFootPrintModel : bluedEntityA.data) {
                        UserBasicModel userBasicModel = new UserBasicModel(liveFootPrintModel.getAnchor());
                        userBasicModel.name = liveFootPrintModel.getName();
                        userBasicModel.avatar = liveFootPrintModel.getAvatar();
                        BluedLiveListData bluedLiveListData = new BluedLiveListData(liveFootPrintModel.getLid(), userBasicModel);
                        bluedLiveListData.setItemType(0);
                        bluedLiveListData.last_start_time = liveFootPrintModel.getLeave_time();
                        arrayList.add(bluedLiveListData);
                    }
                    LiveFootPrintFragmentN.this.l.setHasData(bluedEntityA.hasMore());
                    if (LiveFootPrintFragmentN.this.l.getHasData()) {
                        LiveFootPrintFragmentN.this.b.b(true);
                    } else {
                        LiveFootPrintFragmentN.this.b.b(false);
                        if (LiveFootPrintFragmentN.this.e.getDataList().size() + arrayList.size() > 0) {
                            BluedLiveListData bluedLiveListData2 = new BluedLiveListData();
                            bluedLiveListData2.setItemType(1);
                            arrayList.add(bluedLiveListData2);
                        } else {
                            LiveFootPrintFragmentN.this.f.setVisibility(0);
                        }
                    }
                    if (z) {
                        LiveFootPrintFragmentN.this.e.setDataAndNotify(arrayList);
                    } else {
                        LiveFootPrintFragmentN.this.e.addDataAndNotify(arrayList);
                    }
                    LiveRoomUtils.c(LiveFootPrintFragmentN.this.l.tabId, LiveFootPrintFragmentN.this.e.getDataList());
                }
                LiveFootPrintFragmentN.this.b.g();
                LiveFootPrintFragmentN.this.b.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveFootPrintFragmentN.this.l.hasRequestData = true;
            }
        }, String.valueOf(this.l.getPage()), (IRequestHost) getFragmentActive());
    }

    private void f() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.title);
        this.a = commonTopTitleNoTrans;
        if (this.o == 1) {
            commonTopTitleNoTrans.setVisibility(8);
            return;
        }
        commonTopTitleNoTrans.setVisibility(0);
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFootPrintFragmentN$4ZlPme7eBL1WuxHXkI2bn1kdV14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFootPrintFragmentN.this.a(view);
            }
        });
        this.a.setCenterText("观看记录");
    }

    private void g() {
        this.b = this.rootView.findViewById(R.id.refreshLayout);
        RecyclerView findViewById = this.rootView.findViewById(R.id.recyclerView);
        this.c = findViewById;
        findViewById.setPadding(DisplayUtil.a(AppInfo.d(), 9.0f), 0, DisplayUtil.a(AppInfo.d(), 9.0f), 0);
        CustomTwoLevelHeader customTwoLevelHeader = (CustomTwoLevelHeader) this.rootView.findViewById(R.id.header);
        this.g = customTwoLevelHeader;
        customTwoLevelHeader.a(new OnTwoLevelListener() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.3
            public boolean onTwoLevel(RefreshLayout refreshLayout) {
                return false;
            }
        });
        this.h = (LiveTwoLevelRefreshView) this.rootView.findViewById(R.id.refresh_view);
        if (this.e == null) {
            this.e = new AnonymousClass4(AppInfo.d());
        }
        this.c.setAdapter(this.e);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AppInfo.d(), 3);
        this.d = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.5
            public int getSpanSize(int i) {
                return (i >= LiveFootPrintFragmentN.this.e.getDataList().size() || ((BluedLiveListData) LiveFootPrintFragmentN.this.e.getDataList().get(i)).getItemType() != 0) ? 3 : 1;
            }
        });
        this.c.setLayoutManager(this.d);
        this.c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.6
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition < LiveFootPrintFragmentN.this.e.getDataList().size() && ((BluedLiveListData) LiveFootPrintFragmentN.this.e.getDataList().get(childAdapterPosition)).getItemType() == 0) {
                    float f = 0.0f;
                    rect.top = DisplayUtil.a(view.getContext(), 0.0f);
                    rect.bottom = DisplayUtil.a(view.getContext(), 1.0f);
                    if (childAdapterPosition != 0 && childAdapterPosition != 1 && childAdapterPosition != 2) {
                        if (childAdapterPosition / 3 == ((LiveFootPrintFragmentN.this.e.getDataList().size() + 2) / 3) - 1) {
                            rect.bottom = DisplayUtil.a(view.getContext(), 10.0f);
                            return;
                        }
                        return;
                    }
                    Context context = view.getContext();
                    if (LiveFootPrintFragmentN.this.o != 1) {
                        f = 10.0f;
                    }
                    rect.top = DisplayUtil.a(context, f);
                }
            }
        });
        this.b.a(new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.7
            public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                super.a(refreshHeader, z, f, i, i2, i3);
                if (LiveFootPrintFragmentN.this.getParentFragment() instanceof LiveMainFragment) {
                    LiveMainFragment liveMainFragment = (LiveMainFragment) LiveFootPrintFragmentN.this.getParentFragment();
                    if (LiveFootPrintFragmentN.this.j == null || TextUtils.isEmpty(LiveFootPrintFragmentN.this.j.two_floor_picture) || !LiveFootPrintFragmentN.this.c()) {
                        liveMainFragment.a(0.0f, 0);
                        LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), 0.0f, 0);
                        return;
                    }
                    liveMainFragment.a(f, i);
                    LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), f, i);
                }
            }

            public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
                if (refreshState2 == RefreshState.a) {
                    LiveFootPrintFragmentN.this.d();
                    if (LiveFootPrintFragmentN.this.j != null && !TextUtils.isEmpty(LiveFootPrintFragmentN.this.j.two_floor_picture)) {
                        com.blued.android.module.live_china.utils.log.EventTrackLive.a(LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW, LiveFootPrintFragmentN.this.j.lid, LiveFootPrintFragmentN.this.j.uid, LiveFootPrintFragmentN.this.j.id);
                    }
                    if (LiveFootPrintFragmentN.this.j == null || StringUtils.a(LiveFootPrintFragmentN.this.j.lid, 0L) <= 0) {
                        return;
                    }
                    com.blued.android.module.live_china.utils.log.EventTrackLive.a(LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW, LiveFootPrintFragmentN.this.j.lid, LiveFootPrintFragmentN.this.j.uid, LiveFootPrintFragmentN.this.j.id);
                } else if (refreshState2 != RefreshState.h && refreshState2 == RefreshState.i) {
                    LiveFootPrintFragmentN.this.e();
                    if (LiveFootPrintFragmentN.this.j == null) {
                        return;
                    }
                    if (TextUtils.equals("3", LiveFootPrintFragmentN.this.j.type) && !TextUtils.isEmpty(LiveFootPrintFragmentN.this.j.activity_addr)) {
                        LiveRoomInfo.a().b(LiveFootPrintFragmentN.this.getContext(), LiveFootPrintFragmentN.this.j.activity_addr);
                    } else if (!TextUtils.equals("1", LiveFootPrintFragmentN.this.j.type) || StringUtils.a(LiveFootPrintFragmentN.this.j.lid, 0L) <= 0) {
                    } else {
                        LiveRoomInfo.a().a(LiveFootPrintFragmentN.this.getContext(), LiveFootPrintFragmentN.this.j);
                    }
                }
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                LiveFootPrintFragmentN.this.a(true);
                LiveFootPrintFragmentN.this.d.scrollToPosition(0);
                if (LiveFootPrintFragmentN.this.getParentFragment() instanceof LiveMainFragment) {
                    LiveMainFragment liveMainFragment = (LiveMainFragment) LiveFootPrintFragmentN.this.getParentFragment();
                    liveMainFragment.w();
                    LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), true);
                }
            }
        });
        this.b.a(new OnLoadMoreListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFootPrintFragmentN$nJ7BNkhAWk5yI_RleuwfLryUElk
            public final void onLoadMore(RefreshLayout refreshLayout) {
                LiveFootPrintFragmentN.this.a(refreshLayout);
            }
        });
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.8
            @Override // java.lang.Runnable
            public void run() {
                LiveFootPrintFragmentN.this.b.a(LiveFootPrintFragmentN.this.g);
            }
        });
        d();
    }

    public String a(Context context, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - j;
        long j3 = j2 / 86400000;
        if (j2 < 86400000 || j3 >= 365) {
            return TimeAndDateUtils.a(context, j);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if (j > calendar.getTimeInMillis() - 86400000) {
            stringBuffer.append(String.format(context.getResources().getString(R.string.befor_day), "1"));
        } else {
            String string = context.getResources().getString(R.string.befor_day);
            stringBuffer.append(String.format(string, j3 + ""));
        }
        return stringBuffer.toString();
    }

    public void a() {
        if (!c()) {
            this.p = System.currentTimeMillis();
            return;
        }
        EventTrackLive.g(LiveProtos.Event.LIVE_SECOND_TAB_SHOW, this.l.tabPoint);
        b();
    }

    public void a(List<LiveTwoFloorModel> list) {
        if (getParentFragment() instanceof LiveMainFragment) {
            if (list == null || list.size() <= 0) {
                this.j = null;
                this.i = false;
            } else {
                LiveTwoFloorModel liveTwoFloorModel = list.get(0);
                this.j = liveTwoFloorModel;
                if (liveTwoFloorModel == null) {
                    this.i = false;
                } else if (TextUtils.equals("1", liveTwoFloorModel.type) && StringUtils.a(this.j.lid, 0L) > 0) {
                    this.i = true;
                } else if (!TextUtils.equals("3", this.j.type) || TextUtils.isEmpty(this.j.activity_addr)) {
                    this.i = false;
                } else {
                    this.i = true;
                }
            }
            LiveMainFragment liveMainFragment = (LiveMainFragment) getParentFragment();
            if (liveMainFragment != null) {
                liveMainFragment.a(this.j);
                liveMainFragment.b(this.i);
            }
            d();
        }
    }

    public void b() {
        SmartRefreshLayout smartRefreshLayout;
        if (this.p != 0) {
            if (System.currentTimeMillis() - this.p > 900000 && (smartRefreshLayout = this.b) != null) {
                smartRefreshLayout.i();
            }
            this.p = 0L;
        }
    }

    public boolean c() {
        if (getParentFragment() instanceof LiveMainFragment) {
            LiveMainFragment liveMainFragment = (LiveMainFragment) getParentFragment();
            return liveMainFragment != null && liveMainFragment.isVisible() && this.k;
        }
        return this.k;
    }

    public void d() {
        if (!(getParentFragment() instanceof LiveMainFragment)) {
            this.g.a(false);
            return;
        }
        LiveMainFragment liveMainFragment = (LiveMainFragment) getParentFragment();
        if (liveMainFragment != null) {
            this.j = liveMainFragment.t();
            this.i = liveMainFragment.s();
        }
        if (this.b.getState() == RefreshState.a) {
            this.g.a(this.i);
            LiveTwoFloorModel liveTwoFloorModel = this.j;
            String str = liveTwoFloorModel != null ? liveTwoFloorModel.two_floor_picture : "";
            if (TextUtils.isEmpty(str)) {
                this.h.a(this.i, false);
            } else {
                this.h.a(this.i, true);
            }
            LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), this.i, str, liveMainFragment.x());
            LiveTwoFloorModel liveTwoFloorModel2 = this.j;
            if (liveTwoFloorModel2 == null || liveTwoFloorModel2.anchor == null || TextUtils.isEmpty(this.j.anchor.avatar)) {
                return;
            }
            ImageFileLoader.a((IRequestHost) null).a(this.j.anchor.avatar).a();
        }
    }

    public void e() {
        if (getParentFragment() instanceof LiveMainFragment) {
            LiveRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.10
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveTwoFloorModel> bluedEntityA) {
                    if (bluedEntityA != null && bluedEntityA.data != null) {
                        LiveFootPrintFragmentN.this.a(bluedEntityA.data);
                        return;
                    }
                    LiveFootPrintFragmentN.this.a(new ArrayList());
                }
            }, getFragmentActive());
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        String str3 = "";
        if (getArguments() != null) {
            this.o = getArguments().getInt("from", 0);
            str3 = getArguments().getString("tabId", "");
            str = getArguments().getString("tabName", "");
            str2 = getArguments().getString("tabPoint", "");
            this.q = getArguments().getString("live_pay_beans_details", "");
        } else {
            str = "";
            str2 = str;
        }
        LiveListCommonModel d = LiveRoomUtils.d(str3);
        LiveListCommonModel liveListCommonModel = d;
        if (d == null) {
            liveListCommonModel = new LiveListCommonModel();
            liveListCommonModel.setPage(1);
            liveListCommonModel.tabId = str3;
            liveListCommonModel.tabName = str;
            liveListCommonModel.tabPoint = str2;
            liveListCommonModel.setHasData(true);
            LiveRoomUtils.a(str3, liveListCommonModel);
        }
        this.l = liveListCommonModel;
        com.blued.android.module.live_china.utils.log.EventTrackLive.a(LiveProtos.Event.LIVE_FOOTPRINT_CLICK);
    }

    public void onInitView() {
        super.onInitView();
        f();
        g();
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.rootView.findViewById(R.id.noDataView);
        this.f = noDataAndLoadFailView;
        noDataAndLoadFailView.setVisibility(8);
        this.f.setNoDataStr(R.string.no_data_foot_print);
        this.m = (AppInfo.l - DisplayUtil.a(AppInfo.d(), 24.0f)) / 3;
        com.blued.android.module.live_china.utils.log.EventTrackLive.a(LiveProtos.Event.LIVE_FOOTPRINT_PAGE_SHOW);
        if (this.l.hasRequestData) {
            List<BluedLiveListData> c = LiveRoomUtils.c(this.l.tabId);
            this.b.b(this.l.getHasData());
            this.e.setDataAndNotify(c);
        } else {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.1
                @Override // java.lang.Runnable
                public void run() {
                    LiveFootPrintFragmentN.this.b.i();
                }
            }, 300L);
        }
        LiveEventBus.get("live_back_to_two_level", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.2
            /* renamed from: a */
            public void onChanged(String str) {
                LiveFootPrintFragmentN.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiveFootPrintFragmentN.this.g == null || LiveFootPrintFragmentN.this.o != 1) {
                            return;
                        }
                        LiveFootPrintFragmentN.this.g.a();
                    }
                }, 300L);
            }
        });
    }

    public void onPause() {
        super.onPause();
        this.k = false;
        a();
    }

    public void onResume() {
        super.onResume();
        this.k = true;
        a();
    }

    public int onSetRootViewId() {
        return R.layout.fragment_live_foot_point;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        a();
    }
}

package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.share.ShareUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.das.client.feed.FeedProtos;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.msg.model.FriendsModel;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToFriendsFragment.class */
public class ShareToFriendsFragment extends PreloadFragment {
    private SearchView A;
    private PullToRefreshRecyclerView B;
    private FriendsModel C;
    private ShareToMsgEntity E;
    private String F;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Context s;
    private FriendListAdapter t;
    private NoDataAndLoadFailView u;
    private View v;
    private SearchEditText w;
    private FrameLayout x;
    private ProgressBar y;
    private RecyclerView z;
    private final int j = 20;
    private int k = 1;
    private int l = 1;
    private boolean m = true;
    private boolean n = false;
    private int D = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter.class */
    public class FriendListAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f18241c;
        private ImageView d;

        private FriendListAdapter() {
            super(R.layout.item_share_to, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, BluedBlackList bluedBlackList) {
            if (baseViewHolder == null || bluedBlackList == null) {
                return;
            }
            this.b = (TextView) baseViewHolder.getView(2131372046);
            this.f18241c = (ImageView) baseViewHolder.getView(R.id.riv_avatar);
            this.d = (ImageView) baseViewHolder.getView(2131364726);
            this.b.setText(ShareToFriendsFragment.this.a(bluedBlackList));
            UserRelationshipUtils.a(this.mContext, this.b, bluedBlackList);
            UserRelationshipUtils.a(this.d, bluedBlackList);
            ImageLoader.a(ShareToFriendsFragment.this.getFragmentActive(), bluedBlackList.avatar).b(2131237310).c().a(this.f18241c);
        }
    }

    public static ShareToFriendsFragment a(Bundle bundle) {
        ShareToFriendsFragment shareToFriendsFragment = new ShareToFriendsFragment();
        if (bundle != null) {
            shareToFriendsFragment.setArguments(bundle);
        }
        return shareToFriendsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(BluedBlackList bluedBlackList) {
        return bluedBlackList == null ? "" : !TextUtils.isEmpty(bluedBlackList.note) ? bluedBlackList.note : !TextUtils.isEmpty(bluedBlackList.name) ? bluedBlackList.name : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<BluedBlackList> bluedEntityA, boolean z) {
        if (bluedEntityA != null) {
            try {
                if (bluedEntityA.hasData()) {
                    this.o = false;
                    this.p = false;
                    if (this.k == 1) {
                        if (!z && (z || this.m)) {
                            this.t.setNewData(bluedEntityA.data);
                        }
                        int size = this.t.getData().size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size - 1) {
                                break;
                            }
                            this.t.remove(1);
                            i = i2 + 1;
                        }
                        this.t.addData((Collection) bluedEntityA.data);
                        if (this.t.getData().size() > 0) {
                            this.t.remove(0);
                        }
                    } else {
                        this.t.addData((Collection) bluedEntityA.data);
                    }
                    this.q = bluedEntityA.hasMore();
                    this.r = bluedEntityA.hasMore();
                    this.t.setEnableLoadMore(this.q);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.o = true;
        this.p = true;
        if (z) {
            if (this.l == 1) {
                return;
            }
        } else if (this.k == 1) {
            return;
        }
        if (this.t.getData().size() > 0) {
            AppMethods.a(this.s.getResources().getString(2131887275));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!this.m) {
            k();
        }
        if (this.C.data.size() > 0 && !TextUtils.isEmpty(str)) {
            if (!i()) {
                this.u.a();
                this.t.setEmptyView((View) this.u);
            }
            ChatHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.6

                /* renamed from: a  reason: collision with root package name */
                boolean f18238a = false;

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
                    this.f18238a = false;
                    ShareToFriendsFragment.this.a(bluedEntityA, true);
                }

                public boolean onUIFailure(int i, String str2) {
                    if (ShareToFriendsFragment.this.l != 1) {
                        ShareToFriendsFragment.this.t.loadMoreFail();
                        ShareToFriendsFragment.m(ShareToFriendsFragment.this);
                    }
                    return super.onUIFailure(i, str2);
                }

                public void onUIFinish() {
                    super.onUIFinish();
                    if (!ShareToFriendsFragment.this.p && !this.f18238a) {
                        if (ShareToFriendsFragment.this.r) {
                            ShareToFriendsFragment.this.t.loadMoreComplete();
                        } else {
                            ShareToFriendsFragment.this.t.loadMoreEnd();
                        }
                    }
                    if (!ShareToFriendsFragment.this.p || this.f18238a) {
                        return;
                    }
                    if (ShareToFriendsFragment.this.l != 1) {
                        ShareToFriendsFragment.m(ShareToFriendsFragment.this);
                    } else {
                        ShareToFriendsFragment.this.t.setNewData(null);
                    }
                    ShareToFriendsFragment.this.t.loadMoreEnd();
                }

                public void onUIStart() {
                    super.onUIStart();
                    ShareToFriendsFragment.this.p = false;
                    ShareToFriendsFragment.this.r = false;
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), str, this.l, (IRequestHost) getFragmentActive());
        }
        try {
            if (this.C.data.size() <= 0 || !TextUtils.isEmpty(str)) {
                return;
            }
            this.k = 1;
            h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<BluedBlackList> list) {
        if (list == null) {
            return false;
        }
        try {
            if (list.size() <= 0) {
                return false;
            }
            this.C.data.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return true;
                }
                this.C.data.add((BluedBlackList) list.get(i2).clone());
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ int f(ShareToFriendsFragment shareToFriendsFragment) {
        int i = shareToFriendsFragment.l;
        shareToFriendsFragment.l = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Context context = this.s;
        BluedUIHttpResponse<BluedEntityA<BluedBlackList>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.7

            /* renamed from: a  reason: collision with root package name */
            boolean f18239a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedBlackList> bluedEntityA) {
                this.f18239a = false;
                ShareToFriendsFragment.this.a(bluedEntityA, false);
            }

            public boolean onUIFailure(int i, String str) {
                if (ShareToFriendsFragment.this.k == 1 && ShareToFriendsFragment.this.t.getData().size() == 0) {
                    ShareToFriendsFragment.this.u.b();
                    ShareToFriendsFragment.this.t.setEmptyView((View) ShareToFriendsFragment.this.u);
                    ShareToFriendsFragment.this.t.setNewData(null);
                } else if (ShareToFriendsFragment.this.k != 1) {
                    ShareToFriendsFragment.this.t.loadMoreFail();
                }
                if (ShareToFriendsFragment.this.k != 1) {
                    ShareToFriendsFragment.r(ShareToFriendsFragment.this);
                }
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                ShareToFriendsFragment.this.y.setVisibility(8);
                ShareToFriendsFragment.this.B.j();
                if (!ShareToFriendsFragment.this.o && !this.f18239a) {
                    if (ShareToFriendsFragment.this.q) {
                        ShareToFriendsFragment.this.t.loadMoreComplete();
                    } else {
                        ShareToFriendsFragment.this.t.loadMoreEnd();
                    }
                }
                if (ShareToFriendsFragment.this.o && !this.f18239a) {
                    if (ShareToFriendsFragment.this.k != 1) {
                        ShareToFriendsFragment.r(ShareToFriendsFragment.this);
                    } else {
                        ShareToFriendsFragment.this.u.a();
                        ShareToFriendsFragment.this.t.setEmptyView((View) ShareToFriendsFragment.this.u);
                        ShareToFriendsFragment.this.t.setNewData(null);
                    }
                    ShareToFriendsFragment.this.t.loadMoreEnd();
                }
                ShareToFriendsFragment shareToFriendsFragment = ShareToFriendsFragment.this;
                shareToFriendsFragment.a(shareToFriendsFragment.t.getData());
            }

            public void onUIStart() {
                super.onUIStart();
                ShareToFriendsFragment.this.o = false;
                ShareToFriendsFragment.this.q = false;
            }
        };
        MineHttpUtils.b(context, bluedUIHttpResponse, this.k + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, getFragmentActive());
    }

    static /* synthetic */ int i(ShareToFriendsFragment shareToFriendsFragment) {
        int i = shareToFriendsFragment.k;
        shareToFriendsFragment.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (TextUtils.isEmpty(this.w.getText().toString())) {
            this.B.setRefreshEnabled(true);
            return true;
        }
        this.B.setRefreshEnabled(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return this.m ? !i() : !i();
    }

    private void k() {
        if (i()) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
    }

    static /* synthetic */ int m(ShareToFriendsFragment shareToFriendsFragment) {
        int i = shareToFriendsFragment.l;
        shareToFriendsFragment.l = i - 1;
        return i;
    }

    static /* synthetic */ int r(ShareToFriendsFragment shareToFriendsFragment) {
        int i = shareToFriendsFragment.k;
        shareToFriendsFragment.k = i - 1;
        return i;
    }

    public void a(View view) {
        this.C = new FriendsModel();
        View inflate = LayoutInflater.from(this.s).inflate(R.layout.fragment_share_to_single, (ViewGroup) view, true);
        SearchView inflate2 = LayoutInflater.from(this.s).inflate(R.layout.layout_msg_search_view, (ViewGroup) null);
        this.A = inflate2;
        this.w = inflate2.getEditView();
        this.x = (FrameLayout) inflate.findViewById(2131363911);
        this.y = (ProgressBar) inflate.findViewById(2131368973);
        this.v = inflate.findViewById(R.id.keyboard_view);
        PullToRefreshRecyclerView findViewById = inflate.findViewById(R.id.ptrrv_list);
        this.B = findViewById;
        findViewById.setRefreshEnabled(true);
        this.z = (RecyclerView) this.B.getRefreshableView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.s);
        this.t = new FriendListAdapter();
        this.z.setLayoutManager(linearLayoutManager);
        this.t.addHeaderView(this.A);
        this.t.setHeaderAndEmpty(true);
        this.t.setLoadMoreView(new RecyclerViewLoadMoreView());
        this.z.setAdapter(this.t);
        this.t.bindToRecyclerView(this.z);
        this.t.disableLoadMoreIfNotFullPage();
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.s);
        this.u = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataStr(2131892287);
        this.u.setNoDataImg(2131233641);
        this.u.d();
        this.d = inflate.findViewById(R.id.keyboard_layout);
        super.a(this.d);
        this.A.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.1
            public void a() {
                KeyboardUtils.a((Activity) ShareToFriendsFragment.this.s);
            }

            public void a(String str) {
                ShareToFriendsFragment.this.l = 1;
                ShareToFriendsFragment.this.a(str);
            }

            public void b() {
            }
        });
        this.v.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    KeyboardUtils.a((Activity) ShareToFriendsFragment.this.s);
                    return true;
                }
                return true;
            }
        });
        this.t.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                BluedBlackList bluedBlackList;
                if (i < 0 || baseQuickAdapter.getData().size() <= i || (bluedBlackList = (BluedBlackList) baseQuickAdapter.getData().get(i)) == null) {
                    return;
                }
                int i2 = ShareToFriendsFragment.this.D;
                if (i2 == 0) {
                    ShareUtils.a().a(ShareToFriendsFragment.this.s, Long.parseLong(bluedBlackList.uid), (short) 2, bluedBlackList.name, bluedBlackList.avatar, bluedBlackList.vbadge, bluedBlackList.vip_grade, bluedBlackList.is_vip_annual, bluedBlackList.vip_exp_lvl, bluedBlackList.is_hide_vip_look, ShareToFriendsFragment.this.E, ShareToFriendsFragment.this.a(bluedBlackList), ShareToFriendsFragment.this.E.gid);
                } else if (i2 != 1) {
                } else {
                    EventTrackFeed.e(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_USER, ShareToFriendsFragment.this.F, bluedBlackList.uid);
                    CircleMethods.a(ShareToFriendsFragment.this.getFragmentActive(), ShareToFriendsFragment.this.F, bluedBlackList.uid, true);
                }
            }
        });
        this.t.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                if (ShareToFriendsFragment.this.j()) {
                    ShareToFriendsFragment.f(ShareToFriendsFragment.this);
                    ShareToFriendsFragment shareToFriendsFragment = ShareToFriendsFragment.this;
                    shareToFriendsFragment.a(shareToFriendsFragment.w.getText().toString());
                } else if (ShareToFriendsFragment.this.i()) {
                    ShareToFriendsFragment.i(ShareToFriendsFragment.this);
                    ShareToFriendsFragment.this.h();
                }
            }
        }, this.z);
        this.B.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.msg.ShareToFriendsFragment.5
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                ShareToFriendsFragment.this.k = 1;
                ShareToFriendsFragment.this.h();
            }
        });
        h();
    }

    public void j_(int i) {
        if (i == -3) {
            this.m = false;
            k();
            this.x.setFocusable(false);
            this.x.setFocusableInTouchMode(false);
            SearchView searchView = this.A;
            if (searchView != null) {
                searchView.a(true);
            }
        } else if (i != -2) {
        } else {
            this.m = true;
            if (i()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.C.data);
                this.t.setNewData(arrayList);
                this.t.loadMoreEnd();
            }
            this.v.setVisibility(8);
            this.A.a(false);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.s = context;
        if (getArguments() != null) {
            this.D = getArguments().getInt("share_type");
            this.E = (ShareToMsgEntity) getArguments().get("share_entity");
            this.F = getArguments().getString("circle_id");
        }
    }
}

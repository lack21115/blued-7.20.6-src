package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.user.adapter.AlbumAdapterNew;
import com.soft.blued.ui.user.model.AlbumDataForJsonParse;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserinfoFragmentAlbumTab.class */
public class UserinfoFragmentAlbumTab extends BaseFragment implements AlbumViewObserver.IAblumViewObserver, AlbumDataObserver.IAlbumObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f20380a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f20381c;
    public RecyclerView d;
    public UserBasicModel e;
    private NoDataAndLoadFailView f;
    private AlbumAdapterNew j;
    private AlbumForDataTrans k;
    private View m;
    private int g = 1;
    private int h = 20;
    private boolean i = true;
    private int l = 3;
    private boolean n = true;

    public static UserinfoFragmentAlbumTab a(UserBasicModel userBasicModel) {
        UserinfoFragmentAlbumTab userinfoFragmentAlbumTab = new UserinfoFragmentAlbumTab();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        userinfoFragmentAlbumTab.setArguments(bundle);
        return userinfoFragmentAlbumTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<AlbumDataForJsonParse> bluedEntityA) {
        String[] strArr;
        this.i = bluedEntityA.hasMore();
        if (!bluedEntityA.hasData()) {
            AlbumAdapterNew albumAdapterNew = this.j;
            if (albumAdapterNew == null || albumAdapterNew.getData().size() != 0) {
                return;
            }
            this.j.setNewData(new ArrayList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AlbumDataForJsonParse albumDataForJsonParse : bluedEntityA.data) {
            if (albumDataForJsonParse.feed != null) {
                if (getParentFragment() != null && ((UserInfoFragmentNew) getParentFragment()).N != null) {
                    albumDataForJsonParse.feed.is_new_face = ((UserInfoFragmentNew) getParentFragment()).N.is_new_face;
                }
                if ("1".equals(albumDataForJsonParse.feed.is_videos) && albumDataForJsonParse.feed.feed_videos != null && albumDataForJsonParse.feed.feed_videos.length > 0) {
                    AlbumFlow albumFlow = albumDataForJsonParse.feed;
                    albumFlow.album_pic = albumDataForJsonParse.feed.feed_videos[0];
                    if (TextUtils.isEmpty(albumFlow.distance)) {
                        albumFlow.distance = this.e.distance;
                    }
                    albumFlow.location = this.e.location;
                    albumFlow.is_hide_distance = this.e.is_hide_distance;
                    albumFlow.age = StringUtils.c(this.e.age);
                    albumFlow.height = StringUtils.c(this.e.height);
                    albumFlow.weight = StringUtils.c(this.e.weight);
                    Log.v("drb", "setListData location:" + this.e.location + "  distance:" + this.e.distance + " -- " + this.e.is_hide_distance);
                    arrayList.add(albumFlow);
                } else if (albumDataForJsonParse.feed.feed_pics != null) {
                    for (String str : albumDataForJsonParse.feed.feed_pics) {
                        AlbumFlow albumFlow2 = (AlbumFlow) albumDataForJsonParse.feed.clone();
                        albumFlow2.album_pic = str;
                        if (TextUtils.isEmpty(albumFlow2.distance)) {
                            albumFlow2.distance = this.e.distance;
                        }
                        albumFlow2.age = StringUtils.c(this.e.age);
                        albumFlow2.height = StringUtils.c(this.e.height);
                        albumFlow2.weight = StringUtils.c(this.e.weight);
                        albumFlow2.location = this.e.location;
                        albumFlow2.is_hide_distance = this.e.is_hide_distance;
                        Log.v("drb", "setListData location:" + this.e.location + "  distance:" + this.e.distance + " -- " + this.e.is_hide_distance);
                        arrayList.add(albumFlow2);
                    }
                }
            }
        }
        Log.v("drb", "setListData mPage:" + this.g + " -- " + arrayList.size());
        if (this.g != 1) {
            AlbumAdapterNew albumAdapterNew2 = this.j;
            if (albumAdapterNew2 != null) {
                albumAdapterNew2.addData((Collection) arrayList);
                a(this.j.getData());
                AlbumViewDataManager.a().a(bluedEntityA.hasMore(), this.k.data);
                return;
            }
            return;
        }
        AlbumAdapterNew albumAdapterNew3 = this.j;
        if (albumAdapterNew3 != null) {
            albumAdapterNew3.setNewData(arrayList);
            this.k.data.clear();
            a(this.j.getData());
            AlbumViewDataManager.a().a(bluedEntityA.hasMore());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        boolean z;
        if (this.j.getData() == null || this.j.getData().size() <= i) {
            return;
        }
        if ("1".equals(this.j.getData().get(i).is_videos) && AudioChannelManager.j().n()) {
            AppMethods.a(this.f20380a.getResources().getText(R.string.yy_in_use));
            return;
        }
        Iterator<AlbumFlow> it = this.j.getData().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else if (it.next().showApply) {
                z = true;
                break;
            }
        }
        String str = TextUtils.equals(this.e.uid, UserInfo.getInstance().getLoginUserInfo().uid) ? null : this.e.name;
        Context context = this.f20380a;
        AlbumForDataTrans albumForDataTrans = this.k;
        int i2 = i;
        if (z) {
            i2 = i - 1;
        }
        BasePhotoFragment.a(context, albumForDataTrans, i2, 6, str, this.e.uid, 27);
    }

    private void a(List<AlbumFlow> list) {
        this.k.data.clear();
        for (AlbumFlow albumFlow : list) {
            if (!albumFlow.showApply) {
                this.k.data.add((AlbumFlow) albumFlow.clone());
            }
        }
    }

    private void d() {
        this.d.setLayoutManager(new GridLayoutManager(this.f20380a, this.l));
        this.j.notifyDataSetChanged();
    }

    @Override // com.soft.blued.ui.feed.observer.AlbumViewObserver.IAblumViewObserver
    public void a() {
        a(false);
    }

    public void a(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        this.e = userInfoEntity;
        Log.v("drb", "setView location:" + userInfoEntity.location + "  distance:" + userInfoEntity.distance + " -- " + userInfoEntity.is_hide_distance);
    }

    public void a(String str) {
        AlbumForDataTrans albumForDataTrans;
        if (StringUtils.d(str) || (albumForDataTrans = this.k) == null) {
            return;
        }
        Iterator<AlbumFlow> it = albumForDataTrans.data.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().feed_id)) {
                it.remove();
            }
        }
    }

    public void a(boolean z) {
        int i;
        UserBasicModel userBasicModel = this.e;
        if (userBasicModel == null || StringUtils.d(userBasicModel.uid)) {
            return;
        }
        if (z) {
            this.g = 1;
        } else {
            this.g++;
        }
        if (!this.i && (i = this.g) != 1) {
            this.g = i - 1;
            return;
        }
        Log.v("drb", "getAlbumFlowList mPage:" + this.g);
        BluedUIHttpResponse<BluedEntityA<AlbumDataForJsonParse>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<AlbumDataForJsonParse>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentAlbumTab.3

            /* renamed from: a  reason: collision with root package name */
            boolean f20384a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AlbumDataForJsonParse> bluedEntityA) {
                UserinfoFragmentAlbumTab.this.a(bluedEntityA);
            }

            public boolean onUIFailure(int i2, String str) {
                this.f20384a = true;
                AlbumViewDataManager.a().c();
                return super.onUIFailure(i2, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                try {
                    if (UserinfoFragmentAlbumTab.this.m != null) {
                        UserinfoFragmentAlbumTab.this.m.setVisibility(8);
                    }
                    if (UserinfoFragmentAlbumTab.this.j == null || UserinfoFragmentAlbumTab.this.j.getItemCount() != 0) {
                        UserinfoFragmentAlbumTab.this.f.d();
                    } else if (this.f20384a) {
                        Log.v("drb", "showFail");
                        UserinfoFragmentAlbumTab.this.f.b();
                    } else {
                        Log.v("drb", "showNodata");
                        UserinfoFragmentAlbumTab.this.f.a();
                    }
                    this.f20384a = false;
                    if (UserinfoFragmentAlbumTab.this.i) {
                        UserinfoFragmentAlbumTab.this.f20381c.l(true);
                    } else {
                        UserinfoFragmentAlbumTab.this.f20381c.l(false);
                    }
                    UserinfoFragmentAlbumTab.this.f20381c.j();
                    UserinfoFragmentAlbumTab.this.f20381c.h();
                    boolean z2 = false;
                    if (UserinfoFragmentAlbumTab.this.j != null) {
                        z2 = false;
                        if (UserinfoFragmentAlbumTab.this.j.getData().size() > 0) {
                            z2 = true;
                        }
                    }
                    ((UserInfoFragmentNew) UserinfoFragmentAlbumTab.this.getParentFragment()).d(z2);
                } catch (Exception e) {
                }
            }

            public void onUIStart() {
                super.onUIStart();
                if (UserinfoFragmentAlbumTab.this.j == null || UserinfoFragmentAlbumTab.this.j.getItemCount() != 0) {
                    return;
                }
                UserinfoFragmentAlbumTab.this.m.setVisibility(0);
            }
        };
        UserHttpUtils.a((BluedUIHttpResponse) bluedUIHttpResponse, this.e.uid, "", this.g + "", this.h + "", (IRequestHost) getFragmentActive());
    }

    @Override // com.soft.blued.ui.user.observer.AlbumDataObserver.IAlbumObserver
    public void a(boolean z, String str) {
        if (this.j == null || StringUtils.d(str)) {
            return;
        }
        if (z) {
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = str;
            this.j.a(bluedIngSelfFeed);
            a(str);
            return;
        }
        Iterator<AlbumFlow> it = this.j.getData().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().pid)) {
                it.remove();
            }
        }
        this.j.notifyDataSetChanged();
    }

    public void b() {
        this.m = this.b.findViewById(R.id.loading_view);
        NoDataAndLoadFailView findViewById = this.b.findViewById(R.id.nodataview);
        this.f = findViewById;
        findViewById.d();
        this.f.setImageScale(0.8f);
        this.f.setTopSpace(DensityUtils.a(this.f20380a, 58.0f));
        this.f.setOnTouchEvent(false);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b.findViewById(R.id.refresh_layout);
        this.f20381c = smartRefreshLayout;
        smartRefreshLayout.c(false);
        this.d = (RecyclerView) this.b.findViewById(2131369105);
        this.j = new AlbumAdapterNew(this.f20380a, getFragmentActive());
        FeedMethods.a(getActivity(), this.j);
        this.d.setAdapter(this.j);
        this.j.setHeaderAndEmpty(true);
        this.d.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentAlbumTab.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (UserinfoFragmentAlbumTab.this.n) {
                    UserinfoFeedScrollObserver.a().a(recyclerView, i, i2);
                    UserinfoFragmentAlbumTab.this.n = false;
                }
            }
        });
        this.j.setEnableLoadMore(false);
        this.f20381c.a(new OnLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.UserinfoFragmentAlbumTab.2
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                UserinfoFragmentAlbumTab.this.a(false);
            }
        });
        this.j.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserinfoFragmentAlbumTab$KHoU96jFLfrV4knndB1hXO8yPT4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UserinfoFragmentAlbumTab.this.a(baseQuickAdapter, view, i);
            }
        });
        a(true);
    }

    public void c() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20380a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_userinfo_album_tab, viewGroup, false);
            UserBasicModel serializable = getArguments().getSerializable("user");
            this.e = serializable;
            if (serializable == null) {
                UserBasicModel userBasicModel = new UserBasicModel();
                this.e = userBasicModel;
                userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
            }
            this.k = new AlbumForDataTrans();
            b();
            d();
            AlbumViewObserver.a().a(this);
            AlbumDataObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        AlbumViewObserver.a().b(this);
        AlbumDataObserver.a().b(this);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}

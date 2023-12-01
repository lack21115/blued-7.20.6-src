package com.blued.community.ui.video.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.player.audio.TXVodAudioPlayer;
import com.blued.android.module.shortvideo.view.CustomProgressDialog;
import com.blued.community.R;
import com.blued.community.ui.video.adapter.MyMusicCollectionAdapter;
import com.blued.community.ui.video.manager.MusicManager;
import com.blued.community.ui.video.model.VideoScanMusic;
import com.blued.community.ui.video.presenter.MyMusicCollectionPresent;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/fragment/MyMusicCollectionFragment.class */
public class MyMusicCollectionFragment extends MvpFragment<MyMusicCollectionPresent> {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f20371a;
    private SearchView b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f20372c;
    private SmartRefreshLayout d;
    private IAudioPlayer e;
    private MyMusicCollectionAdapter f;
    private NoDataAndLoadFailView g;
    private ProgressDialog k;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        CommonAlertDialog.a(getContext(), getContext().getResources().getString(R.string.community_notice), getContext().getResources().getString(R.string.music_cancel_collection), getContext().getResources().getString(R.string.common_ok), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                MyMusicCollectionFragment.this.j().d(MyMusicCollectionFragment.this.f.getData().get(i).music_id);
                MyMusicCollectionFragment.this.f.remove(i);
            }
        }, getContext().getResources().getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public static void a(Fragment fragment, int i) {
        TerminalActivity.a(fragment, MyMusicCollectionFragment.class, (Bundle) null, i);
    }

    private void b() {
        this.f20371a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.top_title);
        this.b = (SearchView) this.i.findViewById(R.id.search_view);
        this.f20372c = (RecyclerView) this.i.findViewById(R.id.recycler_view);
        this.d = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
    }

    private void b(boolean z) {
        this.d.j();
        if (z) {
            this.f.loadMoreComplete();
        } else {
            this.f.loadMoreFail();
        }
        if (this.f.getData().size() <= 0) {
            if (z) {
                this.g.a();
            } else {
                this.g.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent intent = new Intent();
        intent.putExtra("music_file_path", str);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        this.e = new TXVodAudioPlayer();
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(getContext());
        this.k = customProgressDialog;
        customProgressDialog.setCanceledOnTouchOutside(true);
        this.f20371a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MyMusicCollectionFragment.this.t();
            }
        });
        this.f20372c.setLayoutManager(new LinearLayoutManager(getContext()));
        MyMusicCollectionAdapter myMusicCollectionAdapter = new MyMusicCollectionAdapter(getContext(), getFragmentActive());
        this.f = myMusicCollectionAdapter;
        this.f20372c.setAdapter(myMusicCollectionAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_posted);
        this.g.setNoDataStr(R.string.no_content_for_now);
        this.f.setEmptyView(this.g);
        this.f.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VideoScanMusic videoScanMusic = MyMusicCollectionFragment.this.f.getData().get(i);
                int id = view.getId();
                if (id == R.id.stv_use) {
                    ProgressDialog progressDialog = MyMusicCollectionFragment.this.k;
                    MyMusicCollectionFragment myMusicCollectionFragment = MyMusicCollectionFragment.this;
                    MusicManager.a(progressDialog, myMusicCollectionFragment, myMusicCollectionFragment.f.getData().get(i).music_url, MyMusicCollectionFragment.this.f.getData().get(i).music_id, new MusicManager.ICallBack() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.2.1
                        @Override // com.blued.community.ui.video.manager.MusicManager.ICallBack
                        public void a(String str) {
                            MyMusicCollectionFragment.this.c(str);
                        }
                    });
                } else if (id == R.id.iv_collection) {
                    MyMusicCollectionFragment.this.a(i);
                } else if (id == R.id.layout_cover) {
                    if (videoScanMusic.isPlaying) {
                        MyMusicCollectionFragment.this.f.a();
                        MusicManager.a(MyMusicCollectionFragment.this.e);
                        return;
                    }
                    MyMusicCollectionFragment.this.f.a(videoScanMusic);
                    MusicManager.a(MyMusicCollectionFragment.this.e, videoScanMusic.music_url, videoScanMusic.music_id);
                }
            }
        });
        this.d.l(false);
        this.d.a(new OnRefreshListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                MusicManager.a(MyMusicCollectionFragment.this.e);
                MyMusicCollectionFragment.this.j().e();
            }
        });
        this.f.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.f.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                MyMusicCollectionFragment.this.j().f();
            }
        }, this.f20372c);
        this.b.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.blued.community.ui.video.fragment.MyMusicCollectionFragment.5
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                KeyboardUtils.a(MyMusicCollectionFragment.this.getActivity());
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
                MyMusicCollectionFragment.this.j().e(str);
                MyMusicCollectionFragment.this.j().e();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<VideoScanMusic> list) {
        this.f.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.g = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_my_music_collection;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.d.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IAudioPlayer iAudioPlayer = this.e;
        if (iAudioPlayer != null) {
            iAudioPlayer.b();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        MyMusicCollectionAdapter myMusicCollectionAdapter;
        super.onPause();
        if (this.e == null || (myMusicCollectionAdapter = this.f) == null) {
            return;
        }
        myMusicCollectionAdapter.a();
        MusicManager.a(this.e);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.f.setEnableLoadMore(false);
    }
}

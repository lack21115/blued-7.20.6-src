package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.soft.blued.R;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.AlbumDownLoadObserver;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/OccupyDetailFragment.class */
public class OccupyDetailFragment extends BaseFragment implements AlbumDownLoadObserver.IAlbumDownLoadObserver {

    /* renamed from: a  reason: collision with root package name */
    private View f19373a;
    private ProgressBar b;

    /* renamed from: c  reason: collision with root package name */
    private int f19374c;
    private int d;
    private FrameLayout e;
    private boolean f;

    public static OccupyDetailFragment a(int i, int i2) {
        OccupyDetailFragment occupyDetailFragment = new OccupyDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("come_code", i);
        bundle.putInt("current_position", i2);
        occupyDetailFragment.setArguments(bundle);
        return occupyDetailFragment;
    }

    private void b() {
        this.f19374c = getArguments() != null ? getArguments().getInt("come_code") : 0;
        int i = 0;
        if (getArguments() != null) {
            i = getArguments().getInt("current_position");
        }
        this.d = i;
    }

    private void c() {
        this.b = (ProgressBar) this.f19373a.findViewById(R.id.loading_view);
        this.e = (FrameLayout) this.f19373a.findViewById(R.id.load_failed_view);
    }

    @Override // com.soft.blued.ui.photo.observer.AlbumDownLoadObserver.IAlbumDownLoadObserver
    public void a() {
        this.e.setVisibility(0);
        this.b.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f19373a;
        if (view == null) {
            this.f19373a = layoutInflater.inflate(R.layout.fragment_occupy_detail, viewGroup, false);
            b();
            c();
            AlbumDownLoadObserver.a().a(this);
            AlbumViewDataManager.a().e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f19373a.getParent()).removeView(this.f19373a);
        }
        this.f = true;
        return this.f19373a;
    }

    public void onDestroy() {
        super.onDestroy();
        AlbumDownLoadObserver.a().b(this);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.f && z) {
            this.b.setVisibility(0);
            EventCallbackObserver.a().e();
        }
    }
}

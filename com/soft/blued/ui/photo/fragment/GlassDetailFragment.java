package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.view.ViewDragHelperLayout;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/GlassDetailFragment.class */
public class GlassDetailFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    ViewDragHelperLayout.OnLayoutStateListener f33060a = new ViewDragHelperLayout.OnLayoutStateListener() { // from class: com.soft.blued.ui.photo.fragment.GlassDetailFragment.1
        @Override // com.blued.android.module.live_china.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a() {
            if (GlassDetailFragment.this.getActivity() != null) {
                GlassDetailFragment.this.getActivity().finish();
                GlassDetailFragment.this.getActivity().overridePendingTransition(0, 0);
            }
            EventCallbackObserver.a().b();
        }

        @Override // com.blued.android.module.live_china.view.ViewDragHelperLayout.OnLayoutStateListener
        public void a(int i) {
            EventCallbackObserver.a().a(i);
        }

        @Override // com.blued.android.module.live_china.view.ViewDragHelperLayout.OnLayoutStateListener
        public void b() {
            EventCallbackObserver.a().c();
        }

        @Override // com.blued.android.module.live_china.view.ViewDragHelperLayout.OnLayoutStateListener
        public void c() {
        }

        @Override // com.blued.android.module.live_china.view.ViewDragHelperLayout.OnLayoutStateListener
        public void d() {
        }
    };
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ViewDragHelperLayout f33061c;
    private ProgressBar d;
    private TextView e;
    private ImageView f;
    private int g;
    private int h;
    private String i;
    private int j;

    public static GlassDetailFragment a(String str, boolean z, int i, int i2, int i3) {
        GlassDetailFragment glassDetailFragment = new GlassDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putBoolean("islocal", z);
        bundle.putInt("come_code", i);
        bundle.putInt("current_position", i2);
        bundle.putInt("album_count", i3);
        glassDetailFragment.setArguments(bundle);
        return glassDetailFragment;
    }

    private void a() {
        this.g = getArguments() != null ? getArguments().getInt("come_code") : 0;
        this.j = getArguments() != null ? getArguments().getInt("album_count") : 0;
        this.i = getArguments() != null ? getArguments().getString("url") : null;
        int i = 0;
        if (getArguments() != null) {
            i = getArguments().getInt("current_position");
        }
        this.h = i;
    }

    private void b() {
        this.f33061c = (ViewDragHelperLayout) this.b.findViewById(2131373158);
        this.d = (ProgressBar) this.b.findViewById(2131368385);
        this.f33061c.setOnLayoutStateListener(this.f33060a);
        this.f = (ImageView) this.b.findViewById(2131362351);
        this.e = (TextView) this.b.findViewById(R.id.lock_text);
        c();
    }

    private void c() {
        TextView textView = this.e;
        textView.setText(getString(2131888865) + "(" + this.j + getString(R.string.album_unit) + ")");
        ImageLoader.a(getFragmentActive(), this.i).d().a(this.f);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.GlassDetailFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        EventCallbackObserver.a().d();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_glass_detail, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f33061c.setScrollDisable(true);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}

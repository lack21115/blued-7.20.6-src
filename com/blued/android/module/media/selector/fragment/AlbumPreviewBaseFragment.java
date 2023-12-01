package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.observer.PLVideoObserver;
import com.blued.android.module.media.selector.present.AlbumPreviewBasePresenter;
import com.blued.android.module.media.selector.utils.ViewUtils;
import com.blued.android.module.media.selector.view.HackyViewPager;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.observer.EventCallBackAdapter;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/AlbumPreviewBaseFragment.class */
public abstract class AlbumPreviewBaseFragment extends MediaBaseFragment<IAlbumPreviewBaseView, AlbumPreviewBasePresenter> implements IAlbumPreviewBaseView, PLVideoObserver.IPLVideoObserver {

    /* renamed from: a  reason: collision with root package name */
    EventCallBackAdapter f15547a = new EventCallBackAdapter() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.2
        @Override // com.blued.android.module.player.media.observer.EventCallBackAdapter, com.blued.android.module.player.media.observer.EventCallBackListener
        public void a(View view) {
            super.a(view);
            AlbumPreviewBaseFragment.this.f();
        }

        @Override // com.blued.android.module.player.media.observer.EventCallBackAdapter, com.blued.android.module.player.media.observer.EventCallBackListener
        public void am_() {
            super.am_();
            AlbumPreviewBaseFragment.this.getActivity().finish();
        }

        @Override // com.blued.android.module.player.media.observer.EventCallBackAdapter, com.blued.android.module.player.media.observer.EventCallBackListener
        public void b(View view) {
            super.b(view);
            AlbumPreviewBaseFragment.this.f();
        }
    };
    private View d;
    private HackyViewPager e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private View j;
    private ImageView k;
    private ImageView l;
    private FragmentStatePagerAdapter m;

    public static void a(BaseFragment baseFragment, Bundle bundle, int i, int i2) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = b(i);
        }
        TerminalActivity.a(baseFragment, AlbumPreviewBaseFragment.class, bundle2, i2);
    }

    public static Bundle b(int i) {
        Bundle bundle = new Bundle();
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        AlbumDataManager.setCurrentPosition(i);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.b != 0) {
            ((AlbumPreviewBasePresenter) this.b).d();
            ((AlbumPreviewBasePresenter) this.b).a((Intent) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b == 0) {
            return;
        }
        AlbumPreviewBasePresenter albumPreviewBasePresenter = (AlbumPreviewBasePresenter) this.b;
        MediaInfo f = AlbumPreviewBasePresenter.f();
        if (f == null) {
            onBackPressed();
        } else if (f.media_type == AlbumPreviewBasePresenter.g()) {
            this.g.setVisibility(8);
        } else {
            AlbumPreviewBasePresenter albumPreviewBasePresenter2 = (AlbumPreviewBasePresenter) this.b;
            if (AlbumPreviewBasePresenter.j() == 0) {
                this.g.setVisibility(8);
                return;
            }
            this.g.setVisibility(0);
            TextView textView = this.g;
            StringBuilder sb = new StringBuilder();
            AlbumPreviewBasePresenter albumPreviewBasePresenter3 = (AlbumPreviewBasePresenter) this.b;
            sb.append(AlbumPreviewBasePresenter.j());
            sb.append("");
            textView.setText(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view = this.h;
        if (view != null) {
            if (view.getVisibility() == 0) {
                ViewUtils.d(getContext(), this.h);
            } else {
                this.h.setVisibility(0);
                ViewUtils.c(getContext(), this.h);
            }
        }
        View view2 = this.i;
        if (view2 != null) {
            if (view2.getVisibility() == 0) {
                ViewUtils.b(getContext(), this.i);
                return;
            }
            this.i.setVisibility(0);
            ViewUtils.a(getContext(), this.i);
        }
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    protected void A() {
        AlbumPreviewBasePresenter albumPreviewBasePresenter = (AlbumPreviewBasePresenter) this.b;
        a(AlbumPreviewBasePresenter.e());
        FragmentStatePagerAdapter b = b();
        this.m = b;
        if (b == null) {
            getActivity().finish();
            return;
        }
        this.e.setAdapter(b);
        HackyViewPager hackyViewPager = this.e;
        AlbumPreviewBasePresenter albumPreviewBasePresenter2 = (AlbumPreviewBasePresenter) this.b;
        hackyViewPager.setCurrentItem(AlbumPreviewBasePresenter.e());
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public BaseFragment a() {
        return this;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public BaseFragment a(VideoPlayConfig videoPlayConfig) {
        return VideoDetailFragment.a(videoPlayConfig);
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public void a(int i) {
        MediaInfo a2 = ((AlbumPreviewBasePresenter) this.b).a(i);
        if (a2 != null) {
            if (a2.media_type != AlbumPreviewBasePresenter.g()) {
                this.j.setVisibility(4);
                this.l.setVisibility(0);
                this.l.setSelected(a2.isSelected);
                return;
            }
            AlbumPreviewBasePresenter albumPreviewBasePresenter = (AlbumPreviewBasePresenter) this.b;
            if (AlbumPreviewBasePresenter.j() > 0) {
                this.j.setVisibility(0);
            }
            this.l.setVisibility(4);
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IBaseView
    public void a(boolean z) {
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public boolean a(Activity activity, int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public boolean a(Bundle bundle) {
        return false;
    }

    public FragmentStatePagerAdapter b() {
        if (this.b != 0) {
            return ((AlbumPreviewBasePresenter) this.b).b();
        }
        return null;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    protected void b(Bundle bundle) {
        HackyViewPager hackyViewPager = (HackyViewPager) this.d.findViewById(R.id.vr_viewpager);
        this.e = hackyViewPager;
        hackyViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlbumPreviewBaseFragment albumPreviewBaseFragment = AlbumPreviewBaseFragment.this;
                AlbumPreviewBasePresenter albumPreviewBasePresenter = (AlbumPreviewBasePresenter) albumPreviewBaseFragment.b;
                albumPreviewBaseFragment.a(AlbumPreviewBasePresenter.b(i));
            }
        });
        this.h = this.d.findViewById(R.id.vr_vpg_title_v);
        StatusBarHelper.a(getActivity(), this.h);
        this.k = (ImageView) this.d.findViewById(R.id.vr_vpg_ctt_left);
        this.l = (ImageView) this.d.findViewById(R.id.vr_vpg_ctt_right);
        this.i = this.d.findViewById(R.id.vr_vpg_bottom_v);
        this.j = this.d.findViewById(R.id.vr_warn_ll);
        this.g = (TextView) this.d.findViewById(R.id.vr_vpg_num_view);
        this.f = (TextView) this.d.findViewById(R.id.vr_vpg_done_text_view);
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AlbumPreviewBasePresenter albumPreviewBasePresenter = (AlbumPreviewBasePresenter) AlbumPreviewBaseFragment.this.b;
                MediaInfo f = AlbumPreviewBasePresenter.f();
                if (f == null) {
                    AlbumPreviewBaseFragment.this.onBackPressed();
                } else if (f.isSelected) {
                    f.isSelected = false;
                    AlbumPreviewBaseFragment.this.l.setSelected(f.isSelected);
                    ((AlbumPreviewBasePresenter) AlbumPreviewBaseFragment.this.b).a(f);
                    AlbumPreviewBaseFragment.this.e();
                } else if (((AlbumPreviewBasePresenter) AlbumPreviewBaseFragment.this.b).c()) {
                    ViewUtils.b(AlbumPreviewBaseFragment.this.l);
                    AlbumPreviewBaseFragment.this.l.setSelected(f.isSelected);
                    AlbumPreviewBaseFragment.this.e();
                }
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AlbumPreviewBaseFragment.this.getActivity().finish();
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AlbumPreviewBaseFragment.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    /* renamed from: c */
    public AlbumPreviewBasePresenter B() {
        return new AlbumPreviewBasePresenter();
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.photo_preview_v, viewGroup, false);
            super.onCreateView(layoutInflater, viewGroup, bundle);
            e();
            EventCallbackObserver.a().a(this.f15547a);
            PLVideoObserver.a().a(this);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        AlbumDataManager.getCurrentListChangeLiveData().observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (AlbumPreviewBaseFragment.this.m != null) {
                    AlbumPreviewBaseFragment.this.m.notifyDataSetChanged();
                }
            }
        });
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventCallbackObserver.a().b(this.f15547a);
        PLVideoObserver.a().b(this);
        super.onDestroyView();
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void x() {
        a(true);
    }
}

package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.PhotoView;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoRemoveFragment.class */
public class ShowPhotoRemoveFragment extends BasePhotoFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private Context f19414c;
    private View d;
    private LayoutInflater e;
    private ImagePagerAdapter f;
    private LoadOptions g;
    private int h;
    private int i;
    private Dialog j;
    private HackyViewPager k;
    private ImageView l;
    private int m;
    private List<ChildImageInfo> n = new ArrayList();
    private View o;
    private TextView p;

    /* renamed from: com.soft.blued.ui.photo.fragment.ShowPhotoRemoveFragment$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoRemoveFragment$2.class */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoView f19416a;
        final /* synthetic */ ShowPhotoRemoveFragment b;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            if (((int) this.f19416a.getScale()) != ((int) this.f19416a.getMinimumScale())) {
                if (this.b.f19362a) {
                    ShowPhotoRemoveFragment showPhotoRemoveFragment = this.b;
                    ImageView imageView = showPhotoRemoveFragment.l;
                    TextView textView = this.b.p;
                    if (this.b.n.size() > 1) {
                        z = true;
                    }
                    showPhotoRemoveFragment.a(imageView, textView, z);
                }
            } else if (this.b.f19362a) {
            } else {
                ShowPhotoRemoveFragment showPhotoRemoveFragment2 = this.b;
                ImageView imageView2 = showPhotoRemoveFragment2.l;
                TextView textView2 = this.b.p;
                boolean z2 = false;
                if (this.b.n.size() > 1) {
                    z2 = true;
                }
                showPhotoRemoveFragment2.b(imageView2, textView2, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoRemoveFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ShowPhotoRemoveFragment.this.n.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            String str = ((ChildImageInfo) ShowPhotoRemoveFragment.this.n.get(i)).mImagePath;
            if (!TextUtils.isEmpty(str)) {
                str.contains("http");
            }
            return BizPhotoDetailFragment.a(str, ShowPhotoRemoveFragment.this.m, ShowPhotoRemoveFragment.this.g);
        }
    }

    private void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = getArguments().getInt("show_photo");
            this.h = arguments.getInt("photo_index", 0);
            this.g = arguments.getSerializable("photo_options");
            this.i = this.h;
            this.n.clear();
            for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
                if (!TextUtils.isEmpty(childImageInfo.mImagePath) && !childImageInfo.isVideo) {
                    this.n.add(childImageInfo);
                }
            }
        }
    }

    private void i() {
        this.j = DialogUtils.a(getActivity());
        this.e = LayoutInflater.from(this.f19414c);
        this.k = (HackyViewPager) this.d.findViewById(2131368810);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.close_album_btn);
        this.l = imageView;
        imageView.setOnClickListener(this);
        View findViewById = this.d.findViewById(R.id.tv_delete);
        this.o = findViewById;
        findViewById.setOnClickListener(this);
        this.p = (TextView) this.d.findViewById(R.id.tv_position);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.f = imagePagerAdapter;
        this.k.setAdapter(imagePagerAdapter);
        this.k.setCurrentItem(this.h);
        this.k.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoRemoveFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ShowPhotoRemoveFragment.this.h = i;
                ShowPhotoRemoveFragment.this.k();
            }
        });
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        k();
    }

    private void j() {
        if (this.m == 1) {
            if (BluedPreferences.bk() == 0) {
                BluedPreferences.i(1);
            }
        } else if (BluedPreferences.bj() == 0) {
            BluedPreferences.h(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.n.size() <= 1) {
            this.p.setVisibility(8);
            return;
        }
        TextView textView = this.p;
        textView.setText((this.h + 1) + "/" + this.n.size());
        if (this.f19362a) {
            this.p.setVisibility(0);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void a(int i) {
        super.a(i);
        this.k.getBackground().setAlpha(i);
        if (this.f19362a) {
            ImageView imageView = this.l;
            TextView textView = this.p;
            boolean z = true;
            if (this.n.size() <= 1) {
                z = false;
            }
            a(imageView, textView, z);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void a(View view) {
        super.a(view);
        f();
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void al_() {
        super.al_();
        if (this.f19362a) {
            return;
        }
        ImageView imageView = this.l;
        TextView textView = this.p;
        boolean z = true;
        if (this.n.size() <= 1) {
            z = false;
        }
        b(imageView, textView, z);
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void b(View view) {
        super.b(view);
        f();
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131362969) {
            e();
        } else if (id != 2131371256) {
        } else {
            CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.feed_photo_delete_confirm), getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoRemoveFragment.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    int currentItem = ShowPhotoRemoveFragment.this.k.getCurrentItem();
                    try {
                        SelectPhotoManager.a().b((ChildImageInfo) ShowPhotoRemoveFragment.this.n.get(currentItem));
                        ShowPhotoRemoveFragment.this.n.remove(currentItem);
                    } catch (Throwable th) {
                    }
                    ShowPhotoRemoveFragment.this.k.setAdapter(ShowPhotoRemoveFragment.this.f);
                    ShowPhotoRemoveFragment.this.k.setCurrentItem(currentItem);
                    if (currentItem != ShowPhotoRemoveFragment.this.n.size()) {
                        TextView textView = ShowPhotoRemoveFragment.this.p;
                        textView.setText((currentItem + 1) + "/" + ShowPhotoRemoveFragment.this.n.size());
                    } else if (ShowPhotoRemoveFragment.this.n.size() == 0) {
                        ShowPhotoRemoveFragment.this.p.setText("1/1");
                    } else {
                        TextView textView2 = ShowPhotoRemoveFragment.this.p;
                        textView2.setText(ShowPhotoRemoveFragment.this.n.size() + "/" + ShowPhotoRemoveFragment.this.n.size());
                    }
                    if (currentItem == ShowPhotoRemoveFragment.this.n.size() && ShowPhotoRemoveFragment.this.n.size() == 0) {
                        ShowPhotoRemoveFragment.this.getActivity().finish();
                    }
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().postponeEnterTransition();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19414c = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_show_album, viewGroup, false);
            h();
            i();
            j();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        if (bundle != null) {
            this.h = bundle.getInt("state_position");
        }
        return this.d;
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("state_position", this.k.getCurrentItem());
    }
}

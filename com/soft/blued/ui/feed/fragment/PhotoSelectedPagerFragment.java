package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.module.common.constants.PhotoConstants;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectedPagerFragment.class */
public class PhotoSelectedPagerFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f30003a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private HackyViewPager f30004c;
    private LayoutInflater d;
    private ImagePagerAdapter e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private int l;
    private int m;
    private List<ChildImageInfo> n = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectedPagerFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return PhotoSelectedPagerFragment.this.n.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageDetailFragment.a(!TextUtils.isEmpty(((ChildImageInfo) PhotoSelectedPagerFragment.this.n.get(i)).imgUri) ? ((ChildImageInfo) PhotoSelectedPagerFragment.this.n.get(i)).imgUri : ((ChildImageInfo) PhotoSelectedPagerFragment.this.n.get(i)).mImagePath, true, 4, null, i, PhotoSelectedPagerFragment.this.n.size());
        }
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.l = arguments.getInt("photo_index", 0);
            this.m = arguments.getInt("select_photo", 0);
        }
        this.n.addAll(SelectPhotoManager.a().c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.n.get(i).mSelect) {
            this.k.setImageResource(R.drawable.photo_selected);
        } else {
            this.k.setImageResource(R.drawable.photo_unselected);
        }
    }

    public static void a(BaseFragment baseFragment, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i2);
        bundle.putInt("photo_index", i);
        TerminalActivity.a(baseFragment, PhotoSelectedPagerFragment.class, bundle, 1);
    }

    private void b() {
        this.d = LayoutInflater.from(this.f30003a);
        this.f30004c = (HackyViewPager) this.b.findViewById(2131368810);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.e = imagePagerAdapter;
        this.f30004c.setAdapter(imagePagerAdapter);
        View findViewById = this.b.findViewById(2131370694);
        this.h = findViewById;
        this.j = (ImageView) findViewById.findViewById(2131363120);
        this.i = (TextView) this.h.findViewById(2131363108);
        this.k = (ImageView) this.h.findViewById(2131363126);
        this.f = (TextView) this.b.findViewById(R.id.done_text_view);
        this.g = (TextView) this.b.findViewById(2131368751);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectedPagerFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChildImageInfo childImageInfo = (ChildImageInfo) PhotoSelectedPagerFragment.this.n.get(PhotoSelectedPagerFragment.this.l);
                if (childImageInfo.mSelect) {
                    childImageInfo.mSelect = false;
                    PhotoSelectedPagerFragment.this.k.setImageResource(R.drawable.photo_unselected);
                    SelectPhotoManager.a().b(childImageInfo);
                    PhotoSelectedPagerFragment.this.c();
                    PhotoSelectedPagerFragment.this.e.notifyDataSetChanged();
                } else if (SelectPhotoManager.a().b() + PhotoSelectFragment.f29974a.size() >= PhotoConstants.CONFIG.f10707a) {
                    AppMethods.a((CharSequence) String.format(PhotoSelectedPagerFragment.this.getResources().getString(2131890590), Integer.valueOf(PhotoConstants.CONFIG.f10707a)));
                } else {
                    childImageInfo.mSelect = true;
                    PhotoSelectedPagerFragment.this.k.setImageResource(R.drawable.photo_selected);
                    SelectPhotoManager.a().a(childImageInfo);
                    PhotoSelectedPagerFragment.this.c();
                    PhotoSelectedPagerFragment.this.e.notifyDataSetChanged();
                }
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectedPagerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Intent intent = new Intent();
                intent.putExtra("page_state", 0);
                PhotoSelectedPagerFragment.this.getActivity().setResult(-1, intent);
                PhotoSelectedPagerFragment.this.getActivity().finish();
            }
        });
        this.f30004c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectedPagerFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PhotoSelectedPagerFragment.this.l = i;
                PhotoSelectedPagerFragment.this.a(i);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectedPagerFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SelectPhotoManager.a().b() == 0) {
                    ChildImageInfo childImageInfo = new ChildImageInfo();
                    childImageInfo.mImagePath = ((ChildImageInfo) PhotoSelectedPagerFragment.this.n.get(PhotoSelectedPagerFragment.this.l)).mImagePath;
                    childImageInfo.mSelect = true;
                    SelectPhotoManager.a().a(childImageInfo);
                    PhotoSelectedPagerFragment.this.k.setImageResource(R.drawable.photo_selected);
                }
                if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= SelectPhotoManager.a().c().size()) {
                            break;
                        }
                        ChildImageInfo childImageInfo2 = SelectPhotoManager.a().c().get(i2);
                        if (childImageInfo2 != null && !TextUtils.isEmpty(childImageInfo2.imgUri) && !AppUtils.b(childImageInfo2.mImagePath)) {
                            String e = RecyclingUtils.e("photo");
                            FileUtils.a(childImageInfo2.imgUri, e);
                            childImageInfo2.mImagePath = e;
                        }
                        i = i2 + 1;
                    }
                }
                int i3 = PhotoSelectedPagerFragment.this.m;
                if (i3 == 5) {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f29974a);
                } else if (i3 != 7) {
                    FeedAddPostFragment.a(PhotoSelectedPagerFragment.this.f30003a);
                } else {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f29974a);
                }
                Intent intent = new Intent();
                intent.putExtra("page_state", 1);
                PhotoSelectedPagerFragment.this.getActivity().setResult(-1, intent);
                PhotoSelectedPagerFragment.this.getActivity().finish();
            }
        });
        this.f30004c.setCurrentItem(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int b = SelectPhotoManager.a().b();
        if (b == 0) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        TextView textView = this.g;
        textView.setText(b + "");
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().setResult(-1);
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30003a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_photo_pager, viewGroup, false);
            a();
            b();
            c();
            a(this.l);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}

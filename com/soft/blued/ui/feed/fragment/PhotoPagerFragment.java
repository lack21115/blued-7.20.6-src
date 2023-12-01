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
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoPagerFragment.class */
public class PhotoPagerFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f16272a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private HackyViewPager f16273c;
    private LayoutInflater d;
    private ImagePagerAdapter e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private int l;
    private List<ChildImageInfo> m = new ArrayList();
    private boolean n = true;
    private int o;
    private String p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoPagerFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return PhotoPagerFragment.this.m.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return ImageDetailFragment.a(!TextUtils.isEmpty(((ChildImageInfo) PhotoPagerFragment.this.m.get(i)).imgUri) ? ((ChildImageInfo) PhotoPagerFragment.this.m.get(i)).imgUri : ((ChildImageInfo) PhotoPagerFragment.this.m.get(i)).mImagePath, true, 4, null, i, PhotoPagerFragment.this.m.size());
        }
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.o = arguments.getInt("select_photo", 0);
            this.l = arguments.getInt("photo_index", 0);
            this.p = arguments.getString("super_topic_id");
            this.l--;
        }
        this.m.addAll(ChildPhotoManager.a().c());
        if (this.m.size() > 0) {
            this.m.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (ChildPhotoManager.a().a(i).mSelect) {
            this.k.setImageResource(R.drawable.photo_selected);
        } else {
            this.k.setImageResource(R.drawable.photo_unselected);
        }
    }

    public static void a(BaseFragment baseFragment, int i, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i2);
        bundle.putInt("photo_index", i);
        bundle.putString("super_topic_id", str);
        TerminalActivity.a(baseFragment, PhotoPagerFragment.class, bundle, 1);
    }

    private void b() {
        this.d = LayoutInflater.from(this.f16272a);
        this.f16273c = (HackyViewPager) this.b.findViewById(2131368810);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.e = imagePagerAdapter;
        this.f16273c.setAdapter(imagePagerAdapter);
        View findViewById = this.b.findViewById(2131370694);
        this.h = findViewById;
        this.j = (ImageView) findViewById.findViewById(2131363120);
        this.i = (TextView) this.h.findViewById(2131363108);
        this.k = (ImageView) this.h.findViewById(2131363126);
        this.g = (TextView) this.b.findViewById(R.id.num_view);
        this.f = (TextView) this.b.findViewById(R.id.done_text_view);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoPagerFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChildImageInfo a2 = ChildPhotoManager.a().a(PhotoPagerFragment.this.l + 1);
                if (a2.mSelect) {
                    a2.mSelect = false;
                    PhotoPagerFragment.this.k.setImageResource(R.drawable.photo_unselected);
                    SelectPhotoManager.a().b(a2);
                    PhotoPagerFragment.this.c();
                } else if (SelectPhotoManager.a().b() + PhotoSelectFragment.f16284a.size() >= PhotoConstants.CONFIG.a) {
                    AppMethods.a(String.format(PhotoPagerFragment.this.getResources().getString(R.string.max_select_num), Integer.valueOf(PhotoConstants.CONFIG.a)));
                } else {
                    a2.mSelect = true;
                    PhotoPagerFragment.this.k.setImageResource(R.drawable.photo_selected);
                    SelectPhotoManager.a().a(a2);
                    PhotoPagerFragment.this.c();
                }
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoPagerFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                Intent intent = new Intent();
                intent.putExtra("page_state", 0);
                PhotoPagerFragment.this.getActivity().setResult(-1, intent);
                PhotoPagerFragment.this.getActivity().finish();
            }
        });
        this.f16273c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoPagerFragment.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PhotoPagerFragment.this.l = i;
                PhotoPagerFragment.this.a(i + 1);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoPagerFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SelectPhotoManager.a().b() == 0) {
                    ChildImageInfo childImageInfo = new ChildImageInfo();
                    childImageInfo.mImagePath = ((ChildImageInfo) PhotoPagerFragment.this.m.get(PhotoPagerFragment.this.l)).mImagePath;
                    childImageInfo.mSelect = true;
                    SelectPhotoManager.a().a(childImageInfo);
                    PhotoPagerFragment.this.k.setImageResource(R.drawable.photo_selected);
                }
                if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= SelectPhotoManager.a().c().size()) {
                            break;
                        }
                        ChildImageInfo childImageInfo2 = (ChildImageInfo) SelectPhotoManager.a().c().get(i2);
                        if (childImageInfo2 != null && !TextUtils.isEmpty(childImageInfo2.imgUri) && !AppUtils.b(childImageInfo2.mImagePath)) {
                            String e = RecyclingUtils.e("photo");
                            FileUtils.a(childImageInfo2.imgUri, e);
                            childImageInfo2.mImagePath = e;
                        }
                        i = i2 + 1;
                    }
                }
                int i3 = PhotoPagerFragment.this.o;
                if (i3 == 5) {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f16284a);
                } else if (i3 != 7) {
                    FeedAddPostFragment.a(PhotoPagerFragment.this.f16272a);
                } else {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f16284a);
                }
                Intent intent = new Intent();
                intent.putExtra("page_state", 1);
                PhotoPagerFragment.this.getActivity().setResult(-1, intent);
                PhotoPagerFragment.this.getActivity().finish();
            }
        });
        a(this.l + 1);
        this.f16273c.setCurrentItem(this.l);
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

    public boolean onBackPressed() {
        getActivity().setResult(-1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16272a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_photo_pager, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}

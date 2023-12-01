package com.soft.blued.ui.feed.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoRemoveFragment.class */
public class PhotoRemoveFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f29969a;
    private HackyViewPager b;

    /* renamed from: c  reason: collision with root package name */
    private ImagePagerAdapter f29970c;
    private View d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private int h;
    private List<ChildImageInfo> i = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoRemoveFragment$ImagePagerAdapter.class */
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
            return PhotoRemoveFragment.this.i.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            String str = ((ChildImageInfo) PhotoRemoveFragment.this.i.get(i)).mImagePath;
            return ImageDetailFragment.a(str, !str.contains("http://"), 4, null, i, PhotoRemoveFragment.this.i.size());
        }
    }

    private void a() {
        View findViewById = this.f29969a.findViewById(2131370694);
        this.d = findViewById;
        this.e = (ImageView) findViewById.findViewById(2131363120);
        this.g = (TextView) this.d.findViewById(2131363108);
        this.f = (ImageView) this.d.findViewById(2131363126);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        TextView textView = this.g;
        textView.setText((this.h + 1) + BridgeUtil.SPLIT_MARK + this.i.size());
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.h = arguments.getInt("photo_index");
        }
        this.i.clear();
        this.i.addAll(SelectPhotoManager.a().c());
    }

    private void c() {
        this.b = (HackyViewPager) this.f29969a.findViewById(2131368810);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.f29970c = imagePagerAdapter;
        this.b.setAdapter(imagePagerAdapter);
        this.b.setCurrentItem(this.h);
        this.b.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoRemoveFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PhotoRemoveFragment.this.h = i;
                TextView textView = PhotoRemoveFragment.this.g;
                textView.setText((PhotoRemoveFragment.this.h + 1) + BridgeUtil.SPLIT_MARK + PhotoRemoveFragment.this.i.size());
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.feed_photo_delete_confirm), getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoRemoveFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    int currentItem = PhotoRemoveFragment.this.b.getCurrentItem();
                    SelectPhotoManager.a().a(((ChildImageInfo) PhotoRemoveFragment.this.i.get(currentItem)).mImagePath);
                    PhotoRemoveFragment.this.i.remove(currentItem);
                    PhotoRemoveFragment.this.b.setAdapter(PhotoRemoveFragment.this.f29970c);
                    PhotoRemoveFragment.this.b.setCurrentItem(currentItem);
                    if (currentItem != PhotoRemoveFragment.this.i.size()) {
                        TextView textView = PhotoRemoveFragment.this.g;
                        textView.setText((currentItem + 1) + BridgeUtil.SPLIT_MARK + PhotoRemoveFragment.this.i.size());
                    } else if (PhotoRemoveFragment.this.i.size() == 0) {
                        PhotoRemoveFragment.this.g.setText("1/1");
                    } else {
                        TextView textView2 = PhotoRemoveFragment.this.g;
                        textView2.setText(PhotoRemoveFragment.this.i.size() + BridgeUtil.SPLIT_MARK + PhotoRemoveFragment.this.i.size());
                    }
                    if (currentItem == PhotoRemoveFragment.this.i.size() && PhotoRemoveFragment.this.i.size() == 0) {
                        PhotoRemoveFragment.this.getActivity().finish();
                    }
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.f29969a;
        if (view == null) {
            this.f29969a = layoutInflater.inflate(R.layout.fragment_feed_photo_remove, viewGroup, false);
            b();
            c();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f29969a.getParent()).removeView(this.f29969a);
        }
        return this.f29969a;
    }
}

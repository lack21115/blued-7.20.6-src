package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.presenter.LivePhotoDetailPresenter;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePhotoDetailFragment.class */
public class LivePhotoDetailFragment extends MvpFragment<LivePhotoDetailPresenter> {
    ImageView a;
    ViewPager b;
    private PicturePagerAdapter c;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePhotoDetailFragment$PicturePagerAdapter.class */
    class PicturePagerAdapter extends FragmentStatePagerAdapter {
        public PicturePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            if (LivePhotoDetailFragment.this.j().h == null) {
                return 0;
            }
            return LivePhotoDetailFragment.this.j().h.size();
        }

        public Fragment getItem(int i) {
            return PhotoDetailFragment.a(LivePhotoDetailFragment.this.j().h.get(i), LivePhotoDetailFragment.this.j().m(), false);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = (ImageView) this.i.findViewById(R.id.close_album_btn);
        this.b = this.i.findViewById(R.id.pic_view_pager);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LivePhotoDetailFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("live_dialog_cancel").post("cancel");
            }
        });
        PicturePagerAdapter picturePagerAdapter = new PicturePagerAdapter(getChildFragmentManager());
        this.c = picturePagerAdapter;
        this.b.setAdapter(picturePagerAdapter);
        this.b.setCurrentItem(0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_photo_detail;
    }
}

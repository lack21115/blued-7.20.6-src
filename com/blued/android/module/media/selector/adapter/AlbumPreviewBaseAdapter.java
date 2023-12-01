package com.blued.android.module.media.selector.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.blued.android.module.media.selector.present.AlbumPreviewBasePresenter;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/adapter/AlbumPreviewBaseAdapter.class */
public class AlbumPreviewBaseAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private IAlbumPreviewBaseCallback f15535a;

    public AlbumPreviewBaseAdapter(FragmentManager fragmentManager, IAlbumPreviewBaseCallback iAlbumPreviewBaseCallback) {
        super(fragmentManager);
        this.f15535a = iAlbumPreviewBaseCallback;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f15535a.a();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        MediaInfo a2 = this.f15535a.a(i);
        if (a2 != null) {
            String str = !TextUtils.isEmpty(a2.imgUri) ? a2.imgUri : a2.imagePath;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = a2.path;
            }
            if (a2.media_type == AlbumPreviewBasePresenter.g()) {
                VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
                videoPlayConfig.f15652a = str2;
                videoPlayConfig.b = a2.path;
                videoPlayConfig.y = a2;
                videoPlayConfig.o = false;
                videoPlayConfig.p = false;
                videoPlayConfig.q = true;
                videoPlayConfig.r = false;
                videoPlayConfig.m = true;
                videoPlayConfig.j = true;
                videoPlayConfig.v = true;
                return this.f15535a.a(videoPlayConfig);
            }
            return PhotoDetailFragment.a(str2, null, false);
        }
        return PhotoDetailFragment.a(null, null, false);
    }
}

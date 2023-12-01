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
    private IAlbumPreviewBaseCallback a;

    public AlbumPreviewBaseAdapter(FragmentManager fragmentManager, IAlbumPreviewBaseCallback iAlbumPreviewBaseCallback) {
        super(fragmentManager);
        this.a = iAlbumPreviewBaseCallback;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public int getCount() {
        return this.a.a();
    }

    public Fragment getItem(int i) {
        MediaInfo a = this.a.a(i);
        if (a != null) {
            String str = !TextUtils.isEmpty(a.imgUri) ? a.imgUri : a.imagePath;
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = a.path;
            }
            if (a.media_type == AlbumPreviewBasePresenter.g()) {
                VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
                videoPlayConfig.a = str2;
                videoPlayConfig.b = a.path;
                videoPlayConfig.y = a;
                videoPlayConfig.o = false;
                videoPlayConfig.p = false;
                videoPlayConfig.q = true;
                videoPlayConfig.r = false;
                videoPlayConfig.m = true;
                videoPlayConfig.j = true;
                videoPlayConfig.v = true;
                return this.a.a(videoPlayConfig);
            }
            return PhotoDetailFragment.a(str2, null, false);
        }
        return PhotoDetailFragment.a(null, null, false);
    }
}

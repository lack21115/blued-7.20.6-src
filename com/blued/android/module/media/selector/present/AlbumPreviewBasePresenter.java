package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.adapter.AlbumPreviewBaseAdapter;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback;
import com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/present/AlbumPreviewBasePresenter.class */
public class AlbumPreviewBasePresenter extends MediaBasePresent<IAlbumPreviewBaseView> implements IAlbumPreviewBaseCallback {
    public static void a(MediaInfo mediaInfo, int i) {
        AlbumDataManager.addSelectImage(mediaInfo, i);
    }

    public static int b(int i) {
        return AlbumDataManager.setCurrentPosition(i);
    }

    public static void b(MediaInfo mediaInfo) {
        AlbumDataManager.removeSelectImage(mediaInfo);
    }

    public static int e() {
        return AlbumDataManager.getCurrentPosition();
    }

    public static MediaInfo f() {
        return AlbumDataManager.getCurrentChildImageInfo();
    }

    public static int g() {
        return AlbumDataManager.getMediaTypeVideo();
    }

    public static int i() {
        return AlbumDataManager.getMediaTypeImage();
    }

    public static int j() {
        return AlbumDataManager.getSelectImageSize();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback
    public int a() {
        return AlbumDataManager.getCurrentListSize();
    }

    public int a(MediaInfo mediaInfo) {
        b(mediaInfo);
        return j();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback
    public BaseFragment a(VideoPlayConfig videoPlayConfig) {
        return n() != null ? n().a(videoPlayConfig) : VideoDetailFragment.a(videoPlayConfig);
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback
    public MediaInfo a(int i) {
        return AlbumDataManager.getVRChildImageInfo(i);
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (n() == null || n().a(activity, i, i2, intent) || i != 1 || i2 != 0) {
            return;
        }
        n().getActivity().finish();
    }

    public void a(Intent intent) {
        AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
        albumSelectInfo.a(AlbumDataManager.getAlbumSelectInfo());
        AlbumDataManager.clearAlbumSelectData();
        if (n().a(albumSelectInfo)) {
            return;
        }
        Intent intent2 = intent;
        if (intent == null) {
            intent2 = new Intent();
        }
        intent2.putExtra("album_result_model", albumSelectInfo);
        n().getActivity().setResult(-1, intent2);
        n().getActivity().finish();
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Bundle bundle) {
        AlbumSelectInfo albumSelectInfo;
        if (bundle == null || (albumSelectInfo = (AlbumSelectInfo) bundle.getSerializable("serializeble_data")) == null) {
            return;
        }
        AlbumDataManager.setAlbumSelectInfo(albumSelectInfo);
    }

    public FragmentStatePagerAdapter b() {
        return new AlbumPreviewBaseAdapter(n().a().getChildFragmentManager(), this);
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void b(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putSerializable("serializeble_data", AlbumDataManager.getAlbumSelectInfo());
    }

    public boolean c() {
        if (j() >= AlbumDataManager.getMaxSelectNum()) {
            AppMethods.a((CharSequence) String.format(n().getActivity().getResources().getString(R.string.foudation_media_max_select_num), Integer.valueOf(AlbumDataManager.getMaxSelectNum())));
            return false;
        }
        MediaInfo f = f();
        f.isSelected = true;
        a(f, e());
        return true;
    }

    public void d() {
        MediaInfo f = f();
        if (f != null) {
            if (f.media_type == g()) {
                if (j() == 0) {
                    a(f, e());
                    AlbumDataManager.setSelectMediaType(g());
                }
            } else if (j() == 0) {
                a(f(), e());
                n().a(e());
                AlbumDataManager.setSelectMediaType(i());
            }
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseCallback
    public Context getContext() {
        if (n() != null) {
            return n().getContext();
        }
        return null;
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void h() {
        ThumbLoader.a().b();
    }
}

package com.blued.community.ui.video.model;

import android.content.Intent;
import android.text.TextUtils;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.utils.StorageUtils;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/model/AlbumOperateModel.class */
public class AlbumOperateModel {
    public void nextOperate(BaseFragment baseFragment, AlbumSelectInfo albumSelectInfo, int i, int i2) {
        MediaInfo mediaInfo;
        if (albumSelectInfo == null) {
            return;
        }
        if (albumSelectInfo.e() == AlbumDataManager.getMediaTypeVideo()) {
            if (albumSelectInfo.c() == null || albumSelectInfo.c().size() <= 0 || (mediaInfo = albumSelectInfo.c().get(0)) == null) {
                return;
            }
            ShortVideoProxy.e().a(baseFragment, mediaInfo.path, i, i2);
        } else if (i != 1) {
            for (MediaInfo mediaInfo2 : albumSelectInfo.c()) {
                ChildImageInfo childImageInfo = new ChildImageInfo();
                if (!StorageUtils.b() || TextUtils.isEmpty(mediaInfo2.imgUri) || StorageUtils.a(mediaInfo2.imagePath)) {
                    childImageInfo.mImagePath = mediaInfo2.imagePath;
                } else {
                    String e = RecyclingUtils.e("photo");
                    boolean a2 = FileUtils.a(mediaInfo2.imgUri, e);
                    childImageInfo.mImagePath = e;
                    LogUtils.c("SaveSelectPhoto: " + e + " " + a2);
                }
                childImageInfo.width = mediaInfo2.width;
                childImageInfo.height = mediaInfo2.height;
                SelectPhotoManager.a().c().add(childImageInfo);
            }
            Intent intent = new Intent();
            intent.putExtra("close_page", true);
            baseFragment.getActivity().setResult(-1, intent);
            baseFragment.getActivity().finish();
        }
    }
}

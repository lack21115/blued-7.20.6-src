package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.k;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoComposer.class */
public class PLShortVideoComposer {
    private k mShortVideoComposerCore;

    public PLShortVideoComposer(Context context) {
        this.mShortVideoComposerCore = new k(context);
    }

    public void cancelComposeImages() {
        this.mShortVideoComposerCore.d();
    }

    public void cancelComposeItems() {
        this.mShortVideoComposerCore.c();
    }

    public void cancelComposeToGIF() {
        this.mShortVideoComposerCore.a();
    }

    public void cancelComposeVideos() {
        this.mShortVideoComposerCore.b();
    }

    public boolean composeImages(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", list.size());
        return this.mShortVideoComposerCore.a(list, (String) null, false, str, PLDisplayMode.FIT, pLVideoEncodeSetting, pLVideoSaveListener);
    }

    public boolean composeImages(List<PLComposeItem> list, String str, boolean z, String str2, PLDisplayMode pLDisplayMode, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", list.size());
        return this.mShortVideoComposerCore.a(list, str, z, str2, pLDisplayMode, pLVideoEncodeSetting, pLVideoSaveListener);
    }

    public boolean composeImages(List<PLComposeItem> list, String str, boolean z, String str2, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_image, "operation_compose_image", list.size());
        return this.mShortVideoComposerCore.a(list, str, z, str2, PLDisplayMode.FIT, pLVideoEncodeSetting, pLVideoSaveListener);
    }

    public boolean composeItems(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_item, "operation_compose_item", list.size());
        return this.mShortVideoComposerCore.a(list, str, pLVideoEncodeSetting, (String) null, 1.0f, 1.0f, pLVideoSaveListener);
    }

    public boolean composeItems(List<PLComposeItem> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, String str2, float f, float f2, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_item, "operation_compose_item", list.size());
        return this.mShortVideoComposerCore.a(list, str, pLVideoEncodeSetting, str2, f, f2, pLVideoSaveListener);
    }

    public void composeToGIF(List<Bitmap> list, int i, boolean z, String str, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_gif, "operation_compose_gif", list.size());
        this.mShortVideoComposerCore.a(list, i, z, str, pLVideoSaveListener);
    }

    public boolean composeVideoRanges(List<PLVideoRange> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_trim_video, "operation_compose_video", list.size());
        return this.mShortVideoComposerCore.b(list, str, pLVideoEncodeSetting, pLVideoSaveListener);
    }

    public boolean composeVideos(List<String> list, String str, PLVideoEncodeSetting pLVideoEncodeSetting, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_video, "operation_compose_video", list.size());
        return this.mShortVideoComposerCore.a(list, str, pLVideoEncodeSetting, pLVideoSaveListener);
    }

    public void extractVideoToGIF(String str, long j, long j2, int i, int i2, int i3, int i4, boolean z, String str2, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoComposerCore.a(QosManager.KeyPoint.compose_gif, "operation_compose_gif", 1);
        this.mShortVideoComposerCore.a(str, j, j2, i, i2, i3, i4, z, str2, pLVideoSaveListener);
    }
}

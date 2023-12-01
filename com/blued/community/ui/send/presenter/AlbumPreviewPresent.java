package com.blued.community.ui.send.presenter;

import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.community.ui.video.model.AlbumOperateModel;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/presenter/AlbumPreviewPresent.class */
public class AlbumPreviewPresent {

    /* renamed from: a  reason: collision with root package name */
    private AlbumOperateModel f20079a = new AlbumOperateModel();

    public void a(BaseFragment baseFragment, AlbumSelectInfo albumSelectInfo, int i, int i2) {
        AlbumOperateModel albumOperateModel = this.f20079a;
        if (albumOperateModel != null) {
            albumOperateModel.nextOperate(baseFragment, albumSelectInfo, i, i2);
        }
    }
}

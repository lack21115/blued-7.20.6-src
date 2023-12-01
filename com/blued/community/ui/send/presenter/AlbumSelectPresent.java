package com.blued.community.ui.send.presenter;

import android.app.Activity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.community.ui.video.model.AlbumOperateModel;
import com.blued.community.utils.UserInfoUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/presenter/AlbumSelectPresent.class */
public class AlbumSelectPresent {

    /* renamed from: a  reason: collision with root package name */
    private AlbumOperateModel f20080a;

    public AlbumSelectPresent(Activity activity) {
        a(activity);
    }

    private void a(Activity activity) {
        if (UserInfoUtils.a() == null) {
            activity.finish();
        } else {
            this.f20080a = new AlbumOperateModel();
        }
    }

    public long a() {
        return 300000L;
    }

    public void a(BaseFragment baseFragment, AlbumSelectInfo albumSelectInfo, int i, int i2) {
        AlbumOperateModel albumOperateModel = this.f20080a;
        if (albumOperateModel != null) {
            albumOperateModel.nextOperate(baseFragment, albumSelectInfo, i, i2);
        }
    }
}

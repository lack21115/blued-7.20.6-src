package com.blued.community.ui.send.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppMethods;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.R;
import com.blued.community.ui.send.adapter.AlbumSelectHalfAdapter;
import com.igexin.push.config.c;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/presenter/AlbumSelectHalfPresenter.class */
public class AlbumSelectHalfPresenter extends AlbumBasePresenter {
    @Override // com.blued.android.module.media.selector.present.AlbumBasePresenter, com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public void a(int i, MediaInfo mediaInfo) {
        if (mediaInfo.media_type != AlbumBasePresenter.k() || (mediaInfo.videoTime >= m.ag && mediaInfo.videoTime <= c.g)) {
            super.a(i, mediaInfo);
        } else {
            AppMethods.a(R.string.post_default_maxtime_prompt, true);
        }
    }

    @Override // com.blued.android.module.media.selector.present.AlbumBasePresenter, com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public long f() {
        return 1L;
    }

    @Override // com.blued.android.module.media.selector.present.AlbumBasePresenter, com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public long g() {
        return Long.MAX_VALUE;
    }

    @Override // com.blued.android.module.media.selector.present.AlbumBasePresenter
    public RecyclerView.Adapter i() {
        return new AlbumSelectHalfAdapter(this);
    }
}

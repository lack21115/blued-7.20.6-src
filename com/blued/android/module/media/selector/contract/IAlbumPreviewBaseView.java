package com.blued.android.module.media.selector.contract;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.VideoPlayConfig;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/contract/IAlbumPreviewBaseView.class */
public interface IAlbumPreviewBaseView extends IBaseView {
    BaseFragment a();

    BaseFragment a(VideoPlayConfig videoPlayConfig);

    void a(int i);

    boolean a(Activity activity, int i, int i2, Intent intent);

    boolean a(AlbumSelectInfo albumSelectInfo);

    FragmentActivity getActivity();
}

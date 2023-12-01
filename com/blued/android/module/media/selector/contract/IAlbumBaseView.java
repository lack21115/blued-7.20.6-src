package com.blued.android.module.media.selector.contract;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/contract/IAlbumBaseView.class */
public interface IAlbumBaseView extends IBaseView {
    @Override // com.blued.android.module.media.selector.contract.IBaseView
    void a(boolean z);

    void a(boolean z, String str);

    boolean a(int i, MediaInfo mediaInfo);

    boolean a(Activity activity, int i, int i2, Intent intent);

    boolean a(AlbumSelectInfo albumSelectInfo);

    BaseFragment b();

    void c();

    void d();

    void e();

    int f();

    long g();

    FragmentActivity getActivity();

    long h();

    int i();
}

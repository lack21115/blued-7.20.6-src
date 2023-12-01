package com.blued.community.ui.send.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.community.ui.send.presenter.AlbumPreviewPresent;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumPreviewFragment.class */
public class AlbumPreviewFragment extends AlbumPreviewBaseFragment {
    private AlbumPreviewPresent d;
    private int e;

    public static void a(BaseFragment baseFragment, int i, int i2, int i3) {
        Bundle b = b(i2);
        b.putInt("from", i);
        TerminalActivity.a(baseFragment, AlbumPreviewFragment.class, b, i3);
    }

    private void d() {
        if (getArguments() == null) {
            return;
        }
        this.e = getArguments().getInt("from");
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment, com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public boolean a(Activity activity, int i, int i2, Intent intent) {
        boolean z = false;
        if (i2 == -1) {
            z = false;
            if (i == 1000) {
                z = false;
                if (intent != null) {
                    z = false;
                    if (intent.getBooleanExtra("close_page", false)) {
                        getActivity().setResult(-1, intent);
                        getActivity().finish();
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public boolean a(AlbumSelectInfo albumSelectInfo) {
        AlbumPreviewPresent albumPreviewPresent;
        if (albumSelectInfo == null || (albumPreviewPresent = this.d) == null) {
            return false;
        }
        albumPreviewPresent.a(a(), albumSelectInfo, this.e, 1000);
        return true;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = new AlbumPreviewPresent();
        d();
        ShortVideoProxy.e().a(getClass().getSimpleName());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ShortVideoProxy.e().b(getClass().getSimpleName());
        super.onDestroyView();
    }
}

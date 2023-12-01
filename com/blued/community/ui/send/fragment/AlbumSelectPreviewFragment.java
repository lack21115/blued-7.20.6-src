package com.blued.community.ui.send.fragment;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumSelectPreviewFragment.class */
public class AlbumSelectPreviewFragment extends AlbumPreviewFragment {
    public static void b(BaseFragment baseFragment, int i, int i2, int i3) {
        Bundle b = b(i2);
        b.putInt("from", i);
        try {
            TerminalActivity.a(baseFragment, AlbumSelectPreviewFragment.class, b, i3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.community.ui.send.fragment.AlbumPreviewFragment, com.blued.android.module.media.selector.contract.IAlbumPreviewBaseView
    public boolean a(AlbumSelectInfo albumSelectInfo) {
        return false;
    }
}

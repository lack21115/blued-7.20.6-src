package com.blued.android.modules;

import com.blued.android.module.base.album.AlbumProxy;
import com.blued.android.module.base.album.IAlbum;
import com.blued.community.ui.send.fragment.AlbumSelectFragment;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/AlbumModule.class */
public class AlbumModule {
    protected static IAlbum a = new IAlbum() { // from class: com.blued.android.modules.AlbumModule.1
        @Override // com.blued.android.module.base.album.IAlbum
        public void a(Object obj, int i, int i2, int i3) {
            a(obj, i, 9, i2, i3);
        }

        public void a(Object obj, int i, int i2, int i3, int i4) {
            AlbumSelectFragment.a(obj, i, 3, i2, i3, i4);
        }
    };

    public static void a() {
        AlbumProxy.a().a(a);
    }
}

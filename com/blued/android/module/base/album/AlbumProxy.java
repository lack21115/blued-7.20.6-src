package com.blued.android.module.base.album;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/album/AlbumProxy.class */
public class AlbumProxy extends BaseProxy<IAlbum> implements IAlbum {
    private static AlbumProxy b;

    private AlbumProxy() {
    }

    public static AlbumProxy a() {
        if (b == null) {
            synchronized (AlbumProxy.class) {
                try {
                    if (b == null) {
                        b = new AlbumProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.album.IAlbum
    public void a(Object obj, int i, int i2, int i3) {
        if (this.a != 0) {
            ((IAlbum) this.a).a(obj, i, i2, i3);
        }
    }
}

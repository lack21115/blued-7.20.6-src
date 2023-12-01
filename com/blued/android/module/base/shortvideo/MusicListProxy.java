package com.blued.android.module.base.shortvideo;

import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/shortvideo/MusicListProxy.class */
public class MusicListProxy extends BaseProxy<IMusicList> implements IMusicList {
    private static MusicListProxy b;

    private MusicListProxy() {
    }

    public static MusicListProxy a() {
        if (b == null) {
            synchronized (MusicListProxy.class) {
                try {
                    if (b == null) {
                        b = new MusicListProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.shortvideo.IMusicList
    public void a(BaseFragment baseFragment, int i) {
        if (this.a != 0) {
            ((IMusicList) this.a).a(baseFragment, i);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IMusicList
    public void b(BaseFragment baseFragment, int i) {
        if (this.a != 0) {
            ((IMusicList) this.a).b(baseFragment, i);
        }
    }
}

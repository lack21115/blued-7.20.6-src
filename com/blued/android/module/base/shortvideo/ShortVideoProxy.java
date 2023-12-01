package com.blued.android.module.base.shortvideo;

import android.os.Bundle;
import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/shortvideo/ShortVideoProxy.class */
public class ShortVideoProxy extends BaseProxy<IShortVideo> implements IShortVideo {
    private static ShortVideoProxy b;

    private ShortVideoProxy() {
    }

    public static ShortVideoProxy e() {
        if (b == null) {
            synchronized (ShortVideoProxy.class) {
                try {
                    if (b == null) {
                        b = new ShortVideoProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Bundle bundle, int i, ISaveInterface iSaveInterface) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(bundle, i, iSaveInterface);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, int i, int i2) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, i, i2);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, int i, int i2, int i3) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, i, i2, i3);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, int i, int i2, String str, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, i, i2, str, i3, deleteAutoCheckedListener);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, int i, String str, String str2, int i2) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, i, str, str2, i2);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, Bundle bundle, int i) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, bundle, i);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, Bundle bundle, int i, int i2) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, bundle, i, i2);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, String str, int i, int i2) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, str, i, i2);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, String str, int i, int i2, String str2, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, str, i, i2, str2, i3, deleteAutoCheckedListener);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(Object obj, String str, String str2, int i) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(obj, str, str2, i);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(String str) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(str);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void a(String str, ITranscodingVideoListener iTranscodingVideoListener) {
        if (this.a != 0) {
            ((IShortVideo) this.a).a(str, iTranscodingVideoListener);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public boolean a() {
        if (this.a != 0) {
            return ((IShortVideo) this.a).a();
        }
        return false;
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void b(Object obj, int i, int i2) {
        if (this.a != 0) {
            ((IShortVideo) this.a).b(obj, i, i2);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void b(String str) {
        if (this.a != 0) {
            ((IShortVideo) this.a).b(str);
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public boolean b() {
        if (this.a != 0) {
            return ((IShortVideo) this.a).b();
        }
        return false;
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void c() {
        if (this.a != 0) {
            ((IShortVideo) this.a).c();
        }
    }

    @Override // com.blued.android.module.base.shortvideo.IShortVideo
    public void d() {
        if (this.a != 0) {
            ((IShortVideo) this.a).d();
        }
    }
}

package com.blued.android.module.base.album;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/album/TakePhotoProxy.class */
public class TakePhotoProxy extends BaseProxy<ITakePhoto> implements ITakePhoto {
    private static TakePhotoProxy b;

    private TakePhotoProxy() {
    }

    public static TakePhotoProxy a() {
        if (b == null) {
            synchronized (TakePhotoProxy.class) {
                try {
                    if (b == null) {
                        b = new TakePhotoProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.album.ITakePhoto
    public void a(String str) {
        if (this.f10426a != 0) {
            ((ITakePhoto) this.f10426a).a(str);
        }
    }
}

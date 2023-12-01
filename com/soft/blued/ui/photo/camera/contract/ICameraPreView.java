package com.soft.blued.ui.photo.camera.contract;

import android.graphics.Bitmap;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/camera/contract/ICameraPreView.class */
public interface ICameraPreView extends ICameraBaseView {
    IRequestHost a();

    void a(int i);

    void a(Bitmap bitmap);

    void b();

    void b(Bitmap bitmap);

    void b(String str);

    void c();

    void c(String str);

    void d();
}

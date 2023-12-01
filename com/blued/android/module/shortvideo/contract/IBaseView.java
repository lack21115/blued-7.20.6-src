package com.blued.android.module.shortvideo.contract;

import android.opengl.GLSurfaceView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.shortvideo.model.CommonModel;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/contract/IBaseView.class */
public interface IBaseView extends IView {
    GLSurfaceView a();

    void a(int i, int i2, int i3);

    void a(CommonModel commonModel);

    BaseFragment b();

    void c();

    FragmentActivity getActivity();
}

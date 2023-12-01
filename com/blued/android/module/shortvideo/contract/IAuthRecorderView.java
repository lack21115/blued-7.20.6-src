package com.blued.android.module.shortvideo.contract;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/contract/IAuthRecorderView.class */
public interface IAuthRecorderView {
    GLSurfaceView a();

    void a(Runnable runnable);

    void a(boolean z);

    BaseFragment b();

    void b(boolean z);

    void c();

    void d();

    void e();

    void f();

    void g();

    FragmentActivity getActivity();

    Bundle getArguments();

    Context getContext();
}

package com.blued.android.module.shortvideo.contract;

import android.content.Context;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.fragment.app.FragmentActivity;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/contract/IAuthPreviewView.class */
public interface IAuthPreviewView {
    void T_();

    VideoView a();

    void a(float f);

    void a(Runnable runnable, long j);

    void a(String str);

    void b();

    void c();

    void d();

    void f();

    FragmentActivity getActivity();

    Bundle getArguments();

    Context getContext();
}

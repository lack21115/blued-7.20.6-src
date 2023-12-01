package com.soft.blued.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/base/mvp/MVPIView.class */
public interface MVPIView {
    void a(boolean z);

    void b();

    void c();

    void d();

    IRequestHost g();

    Activity getActivity();

    Bundle getArguments();

    Context getContext();
}

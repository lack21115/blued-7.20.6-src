package com.blued.android.module.ui.mvp.base;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/base/IntMvpView.class */
public interface IntMvpView {
    void a(String str);

    void a(String str, List<?> list);

    void a(String str, boolean z);

    boolean c();

    void d();

    void e();

    void f();

    FragmentActivity g();
}

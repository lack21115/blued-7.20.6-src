package com.blued.android.module.ui.mvp.dispatcher;

import com.blued.android.module.ui.mvp.fragment.MvpFragment;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/dispatcher/MvpDispatcher.class */
public interface MvpDispatcher {
    void a(MvpFragment<?, ?> mvpFragment, String str, List<?> list);
}

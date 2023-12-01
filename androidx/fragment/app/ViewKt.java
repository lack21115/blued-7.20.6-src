package androidx.fragment.app;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/ViewKt.class */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        Intrinsics.e(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        Intrinsics.c(f, "FragmentManager.findFragment(this)");
        return f;
    }
}

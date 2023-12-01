package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTransactionKt.class */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, int i, String str, Bundle bundle) {
        Intrinsics.e(add, "$this$add");
        Intrinsics.a(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        Intrinsics.c(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, String tag, Bundle bundle) {
        Intrinsics.e(add, "$this$add");
        Intrinsics.e(tag, "tag");
        Intrinsics.a(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.c(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.e(add, "$this$add");
        Intrinsics.a(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        Intrinsics.c(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        Intrinsics.e(add, "$this$add");
        Intrinsics.e(tag, "tag");
        Intrinsics.a(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.c(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction replace, int i, String str, Bundle bundle) {
        Intrinsics.e(replace, "$this$replace");
        Intrinsics.a(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        Intrinsics.c(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i, String str, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.e(replace, "$this$replace");
        Intrinsics.a(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        Intrinsics.c(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }
}

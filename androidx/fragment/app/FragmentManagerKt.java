package androidx.fragment.app;

import android.media.TtmlUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManagerKt.class */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.e(fragmentManager, "$this$commit");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.e(fragmentManager, "$this$commit");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.e(fragmentManager, "$this$commitNow");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.e(fragmentManager, "$this$commitNow");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated
    public static final void transaction(FragmentManager fragmentManager, boolean z, boolean z2, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.e(fragmentManager, "$this$transaction");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        Intrinsics.e(fragmentManager, "$this$transaction");
        Intrinsics.e(function1, TtmlUtils.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        if (z) {
            if (z2) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}

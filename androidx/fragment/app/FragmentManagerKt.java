package androidx.fragment.app;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManagerKt.class */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager commit, boolean z, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.e(commit, "$this$commit");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.e(commit, "$this$commit");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager commitNow, boolean z, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.e(commitNow, "$this$commitNow");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.e(commitNow, "$this$commitNow");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated
    public static final void transaction(FragmentManager transaction, boolean z, boolean z2, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.e(transaction, "$this$transaction");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
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

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z, boolean z2, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        Intrinsics.e(transaction, "$this$transaction");
        Intrinsics.e(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.c(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
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

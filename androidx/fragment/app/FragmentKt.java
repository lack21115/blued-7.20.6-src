package androidx.fragment.app;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentKt.class */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment clearFragmentResult, String requestKey) {
        Intrinsics.e(clearFragmentResult, "$this$clearFragmentResult");
        Intrinsics.e(requestKey, "requestKey");
        clearFragmentResult.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(Fragment clearFragmentResultListener, String requestKey) {
        Intrinsics.e(clearFragmentResultListener, "$this$clearFragmentResultListener");
        Intrinsics.e(requestKey, "requestKey");
        clearFragmentResultListener.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(Fragment setFragmentResult, String requestKey, Bundle result) {
        Intrinsics.e(setFragmentResult, "$this$setFragmentResult");
        Intrinsics.e(requestKey, "requestKey");
        Intrinsics.e(result, "result");
        setFragmentResult.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment setFragmentResultListener, String requestKey, final Function2<? super String, ? super Bundle, Unit> listener) {
        Intrinsics.e(setFragmentResultListener, "$this$setFragmentResultListener");
        Intrinsics.e(requestKey, "requestKey");
        Intrinsics.e(listener, "listener");
        setFragmentResultListener.getParentFragmentManager().setFragmentResultListener(requestKey, setFragmentResultListener, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(String p0, Bundle p1) {
                Intrinsics.e(p0, "p0");
                Intrinsics.e(p1, "p1");
                Intrinsics.c(Function2.this.invoke(p0, p1), "invoke(...)");
            }
        });
    }
}

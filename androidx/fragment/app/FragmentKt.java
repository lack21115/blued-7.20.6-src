package androidx.fragment.app;

import android.os.Bundle;
import com.kuaishou.weapon.p0.bp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentKt.class */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        Intrinsics.e(fragment, "$this$clearFragmentResult");
        Intrinsics.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        Intrinsics.e(fragment, "$this$clearFragmentResultListener");
        Intrinsics.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        Intrinsics.e(fragment, "$this$setFragmentResult");
        Intrinsics.e(str, "requestKey");
        Intrinsics.e(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics.e(fragment, "$this$setFragmentResultListener");
        Intrinsics.e(str, "requestKey");
        Intrinsics.e(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(String str2, Bundle bundle) {
                Intrinsics.e(str2, bp.g);
                Intrinsics.e(bundle, "p1");
                Intrinsics.c(function2.invoke(str2, bundle), "invoke(...)");
            }
        });
    }
}

package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelProviderKt.class */
public final class ViewModelProviderKt {
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        Intrinsics.e(viewModelProvider, "<this>");
        Intrinsics.a(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}

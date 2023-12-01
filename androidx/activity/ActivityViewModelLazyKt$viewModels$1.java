package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/activity/ActivityViewModelLazyKt$viewModels$1.class */
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ComponentActivity f1430a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
        super(0);
        this.f1430a = componentActivity;
    }

    /* renamed from: invoke */
    public final ViewModelStore m1065invoke() {
        ViewModelStore viewModelStore = this.f1430a.getViewModelStore();
        Intrinsics.c(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}

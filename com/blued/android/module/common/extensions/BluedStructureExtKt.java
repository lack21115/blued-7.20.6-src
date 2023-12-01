package com.blued.android.module.common.extensions;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.blued.android.framework.utils.ThreadUtils;
import com.blued.android.module.common.base.mvi.BluedLiveData;
import com.blued.android.module.common.base.mvi.BluedMutableLiveData;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.base.mvi.UiAction;
import com.blued.android.module.common.base.mvi.UiEvent;
import com.blued.android.module.common.base.mvi.UiState;
import com.blued.android.module.common.base.mvvm.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedStructureExtKt.class */
public final class BluedStructureExtKt {
    private static final <T, A> void a(BluedLiveData<T> bluedLiveData, LifecycleOwner lifecycleOwner, final KProperty1<T, ? extends A> kProperty1, final Function1<? super A, Unit> function1) {
        LiveData map = Transformations.map(bluedLiveData, new Function() { // from class: com.blued.android.module.common.extensions.BluedStructureExtKt$observeState$$inlined$map$1
            public final StateTuple1<A> apply(T t) {
                return new StateTuple1<>(KProperty1.this.a(t));
            }
        });
        Intrinsics.c(map, "crossinline transform: (…p(this) { transform(it) }");
        LiveData distinctUntilChanged = Transformations.distinctUntilChanged(map);
        Intrinsics.c(distinctUntilChanged, "distinctUntilChanged(this)");
        distinctUntilChanged.observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedStructureExtKt$E3HjaTLJhANzYGOkj7bzuby0STQ
            public final void onChanged(Object obj) {
                BluedStructureExtKt.a(Function1.this, (StateTuple1) obj);
            }
        });
    }

    public static final <State extends UiState, Action extends UiAction, VM extends MVIBaseViewModel<State, Action>, A> void a(MVIBaseFragment<VM> mVIBaseFragment, LifecycleOwner lifecycleOwner, KProperty1<State, ? extends A> prop1, final Function1<? super A, Unit> action) {
        Intrinsics.e(mVIBaseFragment, "<this>");
        Intrinsics.e(lifecycleOwner, "lifecycleOwner");
        Intrinsics.e(prop1, "prop1");
        Intrinsics.e(action, "action");
        a(mVIBaseFragment.y().getUiState(), lifecycleOwner, prop1, new Function1<A, Unit>() { // from class: com.blued.android.module.common.extensions.BluedStructureExtKt$observeState$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void a(A a) {
                if (a == null) {
                    return;
                }
                action.invoke(a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Object obj) {
                a(obj);
                return Unit.a;
            }
        });
    }

    public static final <State extends UiState, Action extends UiAction, VM extends MVIBaseViewModel<State, Action>> void a(MVIBaseFragment<VM> mVIBaseFragment, Action action) {
        Intrinsics.e(mVIBaseFragment, "<this>");
        Intrinsics.e(action, "action");
        mVIBaseFragment.y().dispatchAction(action);
    }

    public static final <State extends UiState, Action extends UiAction, Event extends UiEvent> void a(MVIBaseViewModel<State, Action> mVIBaseViewModel, final Event event) {
        Intrinsics.e(mVIBaseViewModel, "<this>");
        Intrinsics.e(event, "event");
        final SingleLiveEvent uiEvent = mVIBaseViewModel.getUiEvent();
        if (ThreadUtils.a()) {
            uiEvent.setValue(event);
        } else {
            ThreadUtils.b(new Runnable() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedStructureExtKt$NQ2Lv_T0hPnBuKsIwMS1AlxHt5E
                @Override // java.lang.Runnable
                public final void run() {
                    BluedStructureExtKt.a(SingleLiveEvent.this, event);
                }
            });
        }
    }

    public static final <State extends UiState, Action extends UiAction> void a(MVIBaseViewModel<State, Action> mVIBaseViewModel, final Function1<? super State, ? extends State> reducer) {
        Intrinsics.e(mVIBaseViewModel, "<this>");
        Intrinsics.e(reducer, "reducer");
        final BluedMutableLiveData bluedMutableLiveData = (BluedMutableLiveData) mVIBaseViewModel.getUiState();
        if (!ThreadUtils.a()) {
            ThreadUtils.b(new Runnable() { // from class: com.blued.android.module.common.extensions.BluedStructureExtKt$setState$1
                @Override // java.lang.Runnable
                public final void run() {
                    BluedMutableLiveData<T> bluedMutableLiveData2 = bluedMutableLiveData;
                    Object value = bluedMutableLiveData2.getValue();
                    bluedMutableLiveData2.setValue(value == null ? null : reducer.invoke(value));
                }
            });
            return;
        }
        Object value = bluedMutableLiveData.getValue();
        bluedMutableLiveData.setValue(value == null ? null : reducer.invoke(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SingleLiveEvent _uiEvent, UiEvent event) {
        Intrinsics.e(_uiEvent, "$_uiEvent");
        Intrinsics.e(event, "$event");
        _uiEvent.setValue(event);
    }

    public static final <T> void a(final SingleLiveEvent<T> singleLiveEvent, final T t) {
        Intrinsics.e(singleLiveEvent, "<this>");
        if (ThreadUtils.a()) {
            singleLiveEvent.setValue(t);
        } else {
            ThreadUtils.b(new Runnable() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedStructureExtKt$XdnjFMRmGMniGpFbkm3yHBgpyXs
                @Override // java.lang.Runnable
                public final void run() {
                    BluedStructureExtKt.b(SingleLiveEvent.this, t);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 action, StateTuple1 stateTuple1) {
        Intrinsics.e(action, "$action");
        action.invoke(stateTuple1.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SingleLiveEvent this_setEvent, Object obj) {
        Intrinsics.e(this_setEvent, "$this_setEvent");
        this_setEvent.setValue(obj);
    }
}

package com.blued.android.module.common.base.mvi;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.base.mvi.UiAction;
import com.blued.android.module.common.base.mvi.UiState;
import com.blued.android.module.common.base.mvvm.SingleLiveEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.google.gson.internal.C$Gson$Types;
import com.soft.blued.http.api.ApiUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MVIBaseViewModel.class */
public abstract class MVIBaseViewModel<State extends UiState, Action extends UiAction> extends ViewModel {
    private final String TAG = getClass().getSimpleName();
    private final SingleLiveEvent<UiEvent> _uiEvent;
    protected BluedMutableLiveData<State> _uiState;
    private final LiveData<UiEvent> uiEvent;
    public BluedLiveData<State> uiState;

    public MVIBaseViewModel() {
        SingleLiveEvent<UiEvent> singleLiveEvent = new SingleLiveEvent<>();
        this._uiEvent = singleLiveEvent;
        this.uiEvent = singleLiveEvent;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || !(genericSuperclass instanceof ParameterizedType)) {
            return;
        }
        ParameterizedType tClass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        if (this instanceof BaseListViewModel) {
            ParameterizedType newParameterizedTypeWithOwner = C$Gson$Types.newParameterizedTypeWithOwner(null, BaseListState.class, tClass);
            Intrinsics.c(newParameterizedTypeWithOwner, "newParameterizedTypeWith… tClass\n                )");
            tClass = newParameterizedTypeWithOwner;
        } else {
            Intrinsics.c(tClass, "tClass");
        }
        Class<?> b = ApiUtils.f29672a.b(tClass);
        Object newInstance = b == null ? null : b.newInstance();
        if (newInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type State of com.blued.android.module.common.base.mvi.MVIBaseViewModel");
        }
        set_uiState(new BluedMutableLiveData<>((UiState) newInstance));
        setUiState(get_uiState());
    }

    public abstract void dispatchAction(Action action);

    public final String getTAG() {
        return this.TAG;
    }

    public final LiveData<UiEvent> getUiEvent() {
        return this.uiEvent;
    }

    public final BluedLiveData<State> getUiState() {
        BluedLiveData<State> bluedLiveData = this.uiState;
        if (bluedLiveData != null) {
            return bluedLiveData;
        }
        Intrinsics.c("uiState");
        return null;
    }

    protected final SingleLiveEvent<UiEvent> get_uiEvent() {
        return this._uiEvent;
    }

    protected final BluedMutableLiveData<State> get_uiState() {
        BluedMutableLiveData<State> bluedMutableLiveData = this._uiState;
        if (bluedMutableLiveData != null) {
            return bluedMutableLiveData;
        }
        Intrinsics.c("_uiState");
        return null;
    }

    public void init(Bundle bundle) {
    }

    public final void setUiState(BluedLiveData<State> bluedLiveData) {
        Intrinsics.e(bluedLiveData, "<set-?>");
        this.uiState = bluedLiveData;
    }

    protected final void set_uiState(BluedMutableLiveData<State> bluedMutableLiveData) {
        Intrinsics.e(bluedMutableLiveData, "<set-?>");
        this._uiState = bluedMutableLiveData;
    }

    public final void showToast(String message) {
        Intrinsics.e(message, "message");
        BluedStructureExtKt.a((SingleLiveEvent<MviEvent.ToastEvent>) this._uiEvent, new MviEvent.ToastEvent(message));
    }
}

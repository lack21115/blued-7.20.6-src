package com.blued.android.module.common.adx.base;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/IBaseAd.class */
public interface IBaseAd {
    Object a(Continuation<? super ADEvent> continuation);

    int c();

    Map<String, Object> d();
}

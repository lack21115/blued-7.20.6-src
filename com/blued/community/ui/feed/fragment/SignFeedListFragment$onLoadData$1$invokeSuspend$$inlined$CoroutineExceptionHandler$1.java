package com.blued.community.ui.feed.fragment;

import com.blued.android.framework.utils.LogUtils;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$onLoadData$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1.class */
public final class SignFeedListFragment$onLoadData$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public SignFeedListFragment$onLoadData$1$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key) {
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        LogUtils.c(Intrinsics.a("CoroutineExceptionHandler: ", (Object) th));
    }
}

package com.soft.blued.ui.search.vm;

import com.soft.blued.utils.Logger;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalVM$doSearch$$inlined$CoroutineExceptionHandler$1.class */
public final class SearchGlobalVM$doSearch$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchGlobalVM f33187a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalVM$doSearch$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, SearchGlobalVM searchGlobalVM) {
        super(key);
        this.f33187a = searchGlobalVM;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        String tag;
        tag = this.f33187a.getTAG();
        Logger.e(tag, Intrinsics.a("CoroutineExceptionHandler: ", (Object) th));
    }
}

package com.soft.blued.ui.search.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SearchGlobalMoreVM.kt", c = {104}, d = "searchGroup", e = "com.soft.blued.ui.search.vm.SearchGlobalMoreVM")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalMoreVM$searchGroup$1.class */
public final class SearchGlobalMoreVM$searchGroup$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f19490a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SearchGlobalMoreVM f19491c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalMoreVM$searchGroup$1(SearchGlobalMoreVM searchGlobalMoreVM, Continuation<? super SearchGlobalMoreVM$searchGroup$1> continuation) {
        super(continuation);
        this.f19491c = searchGlobalMoreVM;
    }

    public final Object invokeSuspend(Object obj) {
        Object b;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        b = this.f19491c.b((Continuation) this);
        return b;
    }
}

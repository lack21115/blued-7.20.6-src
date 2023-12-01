package com.soft.blued.ui.search.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SearchGlobalMoreVM.kt", c = {65}, d = "searchUser", e = "com.soft.blued.ui.search.vm.SearchGlobalMoreVM")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/vm/SearchGlobalMoreVM$searchUser$1.class */
public final class SearchGlobalMoreVM$searchUser$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f33183a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SearchGlobalMoreVM f33184c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalMoreVM$searchUser$1(SearchGlobalMoreVM searchGlobalMoreVM, Continuation<? super SearchGlobalMoreVM$searchUser$1> continuation) {
        super(continuation);
        this.f33184c = searchGlobalMoreVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        a2 = this.f33184c.a(this);
        return a2;
    }
}

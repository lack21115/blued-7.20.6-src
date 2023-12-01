package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveChannel$onReceiveOrNull$1.class */
public final class ReceiveChannel$onReceiveOrNull$1<E> implements SelectClause1<E> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReceiveChannel<E> f43000a;

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        this.f43000a.k().a(selectInstance, new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(function2, null));
    }
}

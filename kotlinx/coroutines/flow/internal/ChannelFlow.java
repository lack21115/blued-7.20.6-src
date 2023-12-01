package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlow.class */
public abstract class ChannelFlow<T> implements FusibleFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f43446a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f43447c;

    public ChannelFlow(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.f43446a = coroutineContext;
        this.b = i;
        this.f43447c = bufferOverflow;
        if (DebugKt.a()) {
            if (!(this.b != -1)) {
                throw new AssertionError();
            }
        }
    }

    static /* synthetic */ Object a(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object a2 = CoroutineScopeKt.a(new ChannelFlow$collect$2(flowCollector, channelFlow, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return a(this, flowCollector, continuation);
    }

    protected String a() {
        return null;
    }

    public ReceiveChannel<T> a(CoroutineScope coroutineScope) {
        return ProduceKt.a(coroutineScope, this.f43446a, c(), this.f43447c, CoroutineStart.ATOMIC, null, b(), 16, null);
    }

    protected abstract ChannelFlow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow);

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> a_(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if (DebugKt.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.f43446a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.b;
            if (i2 != -3) {
                if (i == -3) {
                    i = i2;
                } else if (i2 != -2) {
                    if (i == -2) {
                        i = i2;
                    } else {
                        if (DebugKt.a()) {
                            if (!(this.b >= 0)) {
                                throw new AssertionError();
                            }
                        }
                        if (DebugKt.a()) {
                            if (!(i >= 0)) {
                                throw new AssertionError();
                            }
                        }
                        i = this.b + i;
                        if (i < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            bufferOverflow = this.f43447c;
        }
        return (Intrinsics.a(plus, this.f43446a) && i == this.b && bufferOverflow == this.f43447c) ? this : a(plus, i, bufferOverflow);
    }

    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> b() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int c() {
        int i = this.b;
        int i2 = i;
        if (i == -3) {
            i2 = -2;
        }
        return i2;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String a2 = a();
        if (a2 != null) {
            arrayList.add(a2);
        }
        if (this.f43446a != EmptyCoroutineContext.f42457a) {
            arrayList.add(Intrinsics.a("context=", (Object) this.f43446a));
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add(Intrinsics.a("capacity=", (Object) Integer.valueOf(i)));
        }
        if (this.f43447c != BufferOverflow.SUSPEND) {
            arrayList.add(Intrinsics.a("onBufferOverflow=", (Object) this.f43447c));
        }
        return DebugStringsKt.b(this) + '[' + CollectionsKt.a(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}

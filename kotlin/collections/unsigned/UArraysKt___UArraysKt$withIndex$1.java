package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysKt$withIndex$1.class */
final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends UInt>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int[] f42421a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<UInt> invoke() {
        return UIntArray.b(this.f42421a);
    }
}

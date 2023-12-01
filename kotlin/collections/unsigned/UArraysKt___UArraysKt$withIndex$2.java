package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysKt$withIndex$2.class */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends ULong>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long[] f42422a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<ULong> invoke() {
        return ULongArray.b(this.f42422a);
    }
}

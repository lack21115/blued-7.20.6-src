package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/unsigned/UArraysKt___UArraysKt$withIndex$3.class */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends UByte>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f42423a;

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a */
    public final Iterator<UByte> invoke() {
        return UByteArray.b(this.f42423a);
    }
}

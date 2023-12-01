package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/YieldContext.class */
public final class YieldContext extends AbstractCoroutineContextElement {
    public static final Key a = new Key(null);
    public boolean b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/YieldContext$Key.class */
    public static final class Key implements CoroutineContext.Key<YieldContext> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YieldContext() {
        super(a);
    }
}

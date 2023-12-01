package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/MainCoroutineDispatcher.class */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        Dispatchers dispatchers = Dispatchers.a;
        MainCoroutineDispatcher b = Dispatchers.b();
        if (this == b) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = b.a();
        } catch (UnsupportedOperationException e) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String b = b();
        String str = b;
        if (b == null) {
            str = DebugStringsKt.b(this) + '@' + DebugStringsKt.a(this);
        }
        return str;
    }
}

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/Jobs.class */
final class Jobs {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key, EngineJob<?>> f7181a = new HashMap();
    private final Map<Key, EngineJob<?>> b = new HashMap();

    private Map<Key, EngineJob<?>> a(boolean z) {
        return z ? this.b : this.f7181a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob<?> a(Key key, boolean z) {
        return a(z).get(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key, EngineJob<?> engineJob) {
        a(engineJob.a()).put(key, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> a2 = a(engineJob.a());
        if (engineJob.equals(a2.get(key))) {
            a2.remove(key);
        }
    }
}

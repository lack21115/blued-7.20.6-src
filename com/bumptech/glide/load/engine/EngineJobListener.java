package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/EngineJobListener.class */
interface EngineJobListener {
    void a(EngineJob<?> engineJob, Key key);

    void a(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource);
}

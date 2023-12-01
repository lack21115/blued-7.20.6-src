package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/SafeKeyGenerator.class */
public class SafeKeyGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Key, String> f7233a = new LruCache<>(1000);
    private final Pools.Pool<PoolableDigestContainer> b = FactoryPools.a(10, new FactoryPools.Factory<PoolableDigestContainer>() { // from class: com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* renamed from: a */
        public PoolableDigestContainer b() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/SafeKeyGenerator$PoolableDigestContainer.class */
    public static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f7235a;
        private final StateVerifier b = StateVerifier.a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f7235a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public StateVerifier d() {
            return this.b;
        }
    }

    private String b(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.a(this.b.acquire());
        try {
            key.a(poolableDigestContainer.f7235a);
            return Util.a(poolableDigestContainer.f7235a.digest());
        } finally {
            this.b.release(poolableDigestContainer);
        }
    }

    public String a(Key key) {
        String b;
        synchronized (this.f7233a) {
            b = this.f7233a.b(key);
        }
        String str = b;
        if (b == null) {
            str = b(key);
        }
        synchronized (this.f7233a) {
            this.f7233a.b(key, str);
        }
        return str;
    }
}

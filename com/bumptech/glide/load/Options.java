package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/Options.class */
public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> b = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Option<T> option, Object obj, MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }

    public <T> Options a(Option<T> option, T t) {
        this.b.put(option, t);
        return this;
    }

    public <T> T a(Option<T> option) {
        return this.b.containsKey(option) ? (T) this.b.get(option) : option.a();
    }

    public void a(Options options) {
        this.b.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.b);
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            a(this.b.keyAt(i2), this.b.valueAt(i2), messageDigest);
            i = i2 + 1;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.b.equals(((Options) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}

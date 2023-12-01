package java.net;

import libcore.util.BasicLruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/net/AddressCache.class */
public class AddressCache {
    private static final int MAX_ENTRIES = 16;
    private static final long TTL_NANOS = 2000000000;
    private final BasicLruCache<AddressCacheKey, AddressCacheEntry> cache = new BasicLruCache<>(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/AddressCache$AddressCacheEntry.class */
    public static class AddressCacheEntry {
        final long expiryNanos = System.nanoTime() + AddressCache.TTL_NANOS;
        final Object value;

        AddressCacheEntry(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/net/AddressCache$AddressCacheKey.class */
    public static class AddressCacheKey {
        private final String mHostname;
        private final int mNetId;

        AddressCacheKey(String str, int i) {
            this.mHostname = str;
            this.mNetId = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddressCacheKey) {
                AddressCacheKey addressCacheKey = (AddressCacheKey) obj;
                return this.mHostname.equals(addressCacheKey.mHostname) && this.mNetId == addressCacheKey.mNetId;
            }
            return false;
        }

        public int hashCode() {
            return ((this.mNetId + 527) * 31) + this.mHostname.hashCode();
        }
    }

    public void clear() {
        this.cache.evictAll();
    }

    public Object get(String str, int i) {
        AddressCacheEntry addressCacheEntry = this.cache.get(new AddressCacheKey(str, i));
        if (addressCacheEntry == null || addressCacheEntry.expiryNanos < System.nanoTime()) {
            return null;
        }
        return addressCacheEntry.value;
    }

    public void put(String str, int i, InetAddress[] inetAddressArr) {
        this.cache.put(new AddressCacheKey(str, i), new AddressCacheEntry(inetAddressArr));
    }

    public void putUnknownHost(String str, int i, String str2) {
        this.cache.put(new AddressCacheKey(str, i), new AddressCacheEntry(str2));
    }
}

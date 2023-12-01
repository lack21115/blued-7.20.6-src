package kotlin.collections;

import com.alipay.sdk.util.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap.class */
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/AbstractMap$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected AbstractMap() {
    }

    private final String a(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(Map.Entry<? extends K, ? extends V> entry) {
        return a(entry.getKey()) + '=' + a(entry.getValue());
    }

    private final Map.Entry<K, V> b(K k) {
        Map.Entry<K, V> entry;
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            Map.Entry<K, V> next = it.next();
            if (Intrinsics.a(next.getKey(), k)) {
                entry = next;
                break;
            }
        }
        return entry;
    }

    public int a() {
        return entrySet().size();
    }

    public final boolean a(Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        AbstractMap<K, V> abstractMap = this;
        V v = abstractMap.get(key);
        if (Intrinsics.a(value, v)) {
            return v != null || abstractMap.containsKey(key);
        }
        return false;
    }

    public abstract Set b();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return b((AbstractMap<K, V>) obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        boolean z;
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = entrySet.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else if (Intrinsics.a(it.next().getValue(), obj)) {
                z = true;
                break;
            }
        }
        return z;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            Set<Map.Entry<K, V>> entrySet = map.entrySet();
            if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
                return true;
            }
            Iterator<Map.Entry<K, V>> it = entrySet.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                } else if (!a((Map.Entry<?, ?>) it.next())) {
                    z = false;
                    break;
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    public String toString() {
        return CollectionsKt.a(entrySet(), ", ", "{", i.d, 0, null, new Function1<Map.Entry<? extends K, ? extends V>, CharSequence>(this) { // from class: kotlin.collections.AbstractMap$toString$1
            final /* synthetic */ AbstractMap<K, V> a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.a = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final CharSequence invoke(Map.Entry<? extends K, ? extends V> it) {
                String b;
                Intrinsics.e(it, "it");
                b = this.a.b((Map.Entry) it);
                return b;
            }
        }, 24, null);
    }
}

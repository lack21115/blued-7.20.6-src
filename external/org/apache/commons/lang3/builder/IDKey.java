package external.org.apache.commons.lang3.builder;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/builder/IDKey.class */
final class IDKey {
    private final int id;
    private final Object value;

    public IDKey(Object obj) {
        this.id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IDKey) {
            IDKey iDKey = (IDKey) obj;
            return this.id == iDKey.id && this.value == iDKey.value;
        }
        return false;
    }

    public int hashCode() {
        return this.id;
    }
}

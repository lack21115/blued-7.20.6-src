package external.org.apache.commons.lang3.tuple;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/tuple/ImmutablePair.class */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public static <L, R> ImmutablePair<L, R> of(L l, R r) {
        return new ImmutablePair<>(l, r);
    }

    @Override // external.org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // external.org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}

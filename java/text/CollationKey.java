package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/CollationKey.class */
public abstract class CollationKey implements Comparable<CollationKey> {
    private final String source;

    /* JADX INFO: Access modifiers changed from: protected */
    public CollationKey(String str) {
        this.source = str;
    }

    @Override // java.lang.Comparable
    public abstract int compareTo(CollationKey collationKey);

    public String getSourceString() {
        return this.source;
    }

    public abstract byte[] toByteArray();
}

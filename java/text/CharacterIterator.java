package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/CharacterIterator.class */
public interface CharacterIterator extends Cloneable {
    public static final char DONE = 65535;

    Object clone();

    char current();

    char first();

    int getBeginIndex();

    int getEndIndex();

    int getIndex();

    char last();

    char next();

    char previous();

    char setIndex(int i);
}

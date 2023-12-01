package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/ParsePosition.class */
public class ParsePosition {
    private int currentPosition;
    private int errorIndex = -1;

    public ParsePosition(int i) {
        this.currentPosition = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParsePosition) {
            ParsePosition parsePosition = (ParsePosition) obj;
            return this.currentPosition == parsePosition.currentPosition && this.errorIndex == parsePosition.errorIndex;
        }
        return false;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public int getIndex() {
        return this.currentPosition;
    }

    public int hashCode() {
        return this.currentPosition + this.errorIndex;
    }

    public void setErrorIndex(int i) {
        this.errorIndex = i;
    }

    public void setIndex(int i) {
        this.currentPosition = i;
    }

    public String toString() {
        return getClass().getName() + "[index=" + this.currentPosition + ", errorIndex=" + this.errorIndex + "]";
    }
}

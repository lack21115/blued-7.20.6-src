package java.text;

import java.text.Format;

/* loaded from: source-2895416-dex2jar.jar:java/text/FieldPosition.class */
public class FieldPosition {
    private Format.Field attribute;
    private int beginIndex;
    private int endIndex;
    private int field;

    public FieldPosition(int i) {
        this.field = i;
    }

    public FieldPosition(Format.Field field) {
        this.attribute = field;
        this.field = -1;
    }

    public FieldPosition(Format.Field field, int i) {
        this.attribute = field;
        this.field = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FieldPosition) {
            FieldPosition fieldPosition = (FieldPosition) obj;
            return this.field == fieldPosition.field && this.attribute == fieldPosition.attribute && this.beginIndex == fieldPosition.beginIndex && this.endIndex == fieldPosition.endIndex;
        }
        return false;
    }

    public int getBeginIndex() {
        return this.beginIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getField() {
        return this.field;
    }

    public Format.Field getFieldAttribute() {
        return this.attribute;
    }

    public int hashCode() {
        return (this.field * 10) + (this.attribute == null ? 0 : this.attribute.hashCode()) + (this.beginIndex * 100) + this.endIndex;
    }

    public void setBeginIndex(int i) {
        this.beginIndex = i;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public String toString() {
        return getClass().getName() + "[attribute=" + this.attribute + ",field=" + this.field + ",beginIndex=" + this.beginIndex + ",endIndex=" + this.endIndex + "]";
    }
}

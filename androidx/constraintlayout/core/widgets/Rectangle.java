package androidx.constraintlayout.core.widgets;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Rectangle.class */
public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }
}

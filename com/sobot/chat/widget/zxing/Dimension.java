package com.sobot.chat.widget.zxing;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/Dimension.class */
public final class Dimension {
    private final int height;
    private final int width;

    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.width = i;
        this.height = i2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            z = false;
            if (this.width == dimension.width) {
                z = false;
                if (this.height == dimension.height) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}

package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STEffectInImage.class */
public class STEffectInImage {
    STImage image;
    boolean mirror;
    int rotate;

    public STEffectInImage(STImage sTImage, int i, boolean z) {
        this.image = sTImage;
        this.rotate = i;
        this.mirror = z;
    }

    public STImage getImage() {
        return this.image;
    }

    public int getRotate() {
        return this.rotate;
    }

    public boolean isMirror() {
        return this.mirror;
    }

    public void setImage(STImage sTImage) {
        this.image = sTImage;
    }

    public void setMirror(boolean z) {
        this.mirror = z;
    }

    public void setRotate(int i) {
        this.rotate = i;
    }
}

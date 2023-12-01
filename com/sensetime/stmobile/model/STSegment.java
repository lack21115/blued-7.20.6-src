package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STSegment.class */
public class STSegment {
    STImage image;
    float maxThrehold;
    float minThrehold;
    STPoint offset;
    STPoint scale;
    float score;

    public STImage getImage() {
        return this.image;
    }

    public float getMaxThrehold() {
        return this.maxThrehold;
    }

    public float getMinThrehold() {
        return this.minThrehold;
    }

    public STPoint getOffset() {
        return this.offset;
    }

    public STPoint getScale() {
        return this.scale;
    }

    public float getScore() {
        return this.score;
    }

    public void setImage(STImage sTImage) {
        this.image = sTImage;
    }

    public void setMaxThrehold(float f) {
        this.maxThrehold = f;
    }

    public void setMinThrehold(float f) {
        this.minThrehold = f;
    }

    public void setOffset(STPoint sTPoint) {
        this.offset = sTPoint;
    }

    public void setScale(STPoint sTPoint) {
        this.scale = sTPoint;
    }

    public void setScore(float f) {
        this.score = f;
    }
}

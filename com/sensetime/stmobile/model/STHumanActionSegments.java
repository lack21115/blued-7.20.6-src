package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STHumanActionSegments.class */
public class STHumanActionSegments {
    private STSegment depth;
    private int faceOcclusionCount;
    private STSegment[] faceOcclusions;
    private STSegment hair;
    private STSegment head;
    private int headCount;
    private STSegment image;
    private int mouthParseCount;
    private STSegment[] mouthParses;
    private STSegment multiSegment;
    private STSegment skin;
    private STSegment sky;

    public STSegment getDepth() {
        return this.depth;
    }

    public int getFaceOcclusionCount() {
        return this.faceOcclusionCount;
    }

    public STSegment[] getFaceOcclusions() {
        return this.faceOcclusions;
    }

    public STSegment getFigureSegment() {
        return this.image;
    }

    public STSegment getHair() {
        return this.hair;
    }

    public STSegment getHead() {
        return this.head;
    }

    public int getHeadCount() {
        return this.headCount;
    }

    public STSegment getImage() {
        return this.image;
    }

    public int getMouthParseCount() {
        return this.mouthParseCount;
    }

    public STSegment[] getMouthParses() {
        return this.mouthParses;
    }

    public STSegment getMultiSegment() {
        return this.multiSegment;
    }

    public STSegment getSkin() {
        return this.skin;
    }

    public STSegment getSky() {
        return this.sky;
    }
}

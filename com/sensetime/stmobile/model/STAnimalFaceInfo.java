package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STAnimalFaceInfo.class */
public class STAnimalFaceInfo {
    private STAnimalFace[] animalFaces;
    private int faceCount;

    public STAnimalFaceInfo(STAnimalFace[] sTAnimalFaceArr, int i) {
        this.animalFaces = sTAnimalFaceArr;
        this.faceCount = i;
    }

    public STAnimalFace[] getAnimalFaces() {
        return this.animalFaces;
    }

    public int getFaceCount() {
        return this.faceCount;
    }
}

package com.sensetime.stmobile.model;

import com.sensetime.stmobile.STEffectInImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectRenderInParam.class */
public class STEffectRenderInParam {
    private int animalFaceCount;
    private STAnimalFace[] animalFaces;
    STEffectCustomParam customParam;
    int frontRotate;
    STHumanAction humanAction;
    STEffectInImage image;
    long nativeHumanActionResult;
    boolean needMirror;
    int rotate;
    STEffectTexture texture;
    double timeStamp;

    public STEffectRenderInParam(long j, STAnimalFaceInfo sTAnimalFaceInfo, int i, int i2, boolean z, STEffectCustomParam sTEffectCustomParam, STEffectTexture sTEffectTexture, STEffectInImage sTEffectInImage) {
        this.nativeHumanActionResult = j;
        this.animalFaces = sTAnimalFaceInfo != null ? sTAnimalFaceInfo.getAnimalFaces() : null;
        this.animalFaceCount = sTAnimalFaceInfo != null ? sTAnimalFaceInfo.getFaceCount() : 0;
        this.rotate = i;
        this.frontRotate = i2;
        this.needMirror = z;
        this.customParam = sTEffectCustomParam;
        this.texture = sTEffectTexture;
        this.image = sTEffectInImage;
        this.timeStamp = System.currentTimeMillis();
    }

    public STEffectRenderInParam(STHumanAction sTHumanAction, STAnimalFaceInfo sTAnimalFaceInfo, int i, int i2, boolean z, STEffectCustomParam sTEffectCustomParam, STEffectTexture sTEffectTexture, STEffectInImage sTEffectInImage) {
        this.humanAction = sTHumanAction;
        this.animalFaces = sTAnimalFaceInfo != null ? sTAnimalFaceInfo.getAnimalFaces() : null;
        this.animalFaceCount = sTAnimalFaceInfo != null ? sTAnimalFaceInfo.getFaceCount() : 0;
        this.rotate = i;
        this.frontRotate = i2;
        this.needMirror = z;
        this.customParam = sTEffectCustomParam;
        this.texture = sTEffectTexture;
        this.image = sTEffectInImage;
        this.timeStamp = System.currentTimeMillis();
    }

    public int getAnimalFaceCount() {
        return this.animalFaceCount;
    }

    public STAnimalFaceInfo getAnimalFaceInfo() {
        return new STAnimalFaceInfo(this.animalFaces, this.animalFaceCount);
    }

    public STAnimalFace[] getAnimalFaces() {
        return this.animalFaces;
    }

    public STEffectCustomParam getCustomParam() {
        return this.customParam;
    }

    public int getFrontRotate() {
        return this.frontRotate;
    }

    public STHumanAction getHumanAction() {
        return this.humanAction;
    }

    public STEffectInImage getImage() {
        return this.image;
    }

    public long getNativeHumanActionResult() {
        return this.nativeHumanActionResult;
    }

    public int getRotate() {
        return this.rotate;
    }

    public STEffectTexture getTexture() {
        return this.texture;
    }

    public boolean isNeedMirror() {
        return this.needMirror;
    }

    public void setAnimalFaceCount(int i) {
        this.animalFaceCount = i;
    }

    public void setAnimalFaces(STAnimalFace[] sTAnimalFaceArr) {
        this.animalFaces = sTAnimalFaceArr;
    }

    public void setCustomParam(STEffectCustomParam sTEffectCustomParam) {
        this.customParam = sTEffectCustomParam;
    }

    public void setFrontRotate(int i) {
        this.frontRotate = i;
    }

    public void setHumanAction(STHumanAction sTHumanAction) {
        this.humanAction = sTHumanAction;
    }

    public void setImage(STEffectInImage sTEffectInImage) {
        this.image = sTEffectInImage;
    }

    public void setNativeHumanActionResult(long j) {
        this.nativeHumanActionResult = j;
    }

    public void setNeedMirror(boolean z) {
        this.needMirror = z;
    }

    public void setRotate(int i) {
        this.rotate = i;
    }

    public void setTexture(STEffectTexture sTEffectTexture) {
        this.texture = sTEffectTexture;
    }
}

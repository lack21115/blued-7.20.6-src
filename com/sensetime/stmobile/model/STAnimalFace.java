package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STAnimalFace.class */
public class STAnimalFace {
    int animalType;
    float[] earScore;
    int id;
    int key_points_count;
    STPoint[] p_key_points;
    float pitch;
    STRect rect;
    float roll;
    float score;
    float yaw;

    public int getAnimalType() {
        return this.animalType;
    }

    public float[] getEarScore() {
        return this.earScore;
    }

    public int getId() {
        return this.id;
    }

    public int getKey_points_count() {
        return this.key_points_count;
    }

    public STPoint[] getP_key_points() {
        return this.p_key_points;
    }

    public float getPitch() {
        return this.pitch;
    }

    public STRect getRect() {
        return this.rect;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getScore() {
        return this.score;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setAnimalType(int i) {
        this.animalType = i;
    }

    public void setEarScore(float[] fArr) {
        this.earScore = fArr;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKey_points_count(int i) {
        this.key_points_count = i;
    }

    public void setP_key_points(STPoint[] sTPointArr) {
        this.p_key_points = sTPointArr;
    }

    public void setPitch(float f) {
        this.pitch = f;
    }

    public void setRect(STRect sTRect) {
        this.rect = sTRect;
    }

    public void setRoll(float f) {
        this.roll = f;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public void setYaw(float f) {
        this.yaw = f;
    }
}

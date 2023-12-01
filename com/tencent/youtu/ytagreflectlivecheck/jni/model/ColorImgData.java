package com.tencent.youtu.ytagreflectlivecheck.jni.model;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/ytagreflectlivecheck/jni/model/ColorImgData.class */
public class ColorImgData {
    private long capture_time;
    public String checksum;
    private String image;
    private int x;
    private int y;

    public long getCapture_time() {
        return this.capture_time;
    }

    public String getImage() {
        return this.image;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setCapture_time(long j) {
        this.capture_time = j;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    public String toString() {
        return "ColorImgData{image='" + this.image + "', capture_time=" + this.capture_time + ", checksum='" + this.checksum + "', x=" + this.x + ", y=" + this.y + '}';
    }
}

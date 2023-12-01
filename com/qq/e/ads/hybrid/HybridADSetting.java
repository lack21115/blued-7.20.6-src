package com.qq.e.ads.hybrid;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/hybrid/HybridADSetting.class */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;
    private String f;
    private String g;
    private String h;

    /* renamed from: a  reason: collision with root package name */
    private int f27874a = 1;
    private int b = 44;

    /* renamed from: c  reason: collision with root package name */
    private int f27875c = -1;
    private int d = -14013133;
    private int e = 16;
    private int i = -1776153;
    private int j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f;
    }

    public int getTitleBarColor() {
        return this.f27875c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.d;
    }

    public int getTitleSize() {
        return this.e;
    }

    public int getType() {
        return this.f27874a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f27875c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.f27874a = i;
        return this;
    }
}

package com.anythink.expressad.video.signal;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/j.class */
public interface j {
    public static final int m_ = 1;
    public static final int n = 2;
    public static final int n_ = 2;
    public static final int o = 1;
    public static final int o_ = 3;
    public static final int p = 2;
    public static final int p_ = 4;
    public static final int q = 0;
    public static final int q_ = 5;
    public static final int r = 1;
    public static final int r_ = 0;
    public static final int s_ = 1;
    public static final int t_ = 1;
    public static final int u_ = 2;
    public static final int v_ = 1;
    public static final int w_ = 2;
    public static final int x_ = -1;
    public static final int y_ = 1;

    void alertWebViewShowed();

    void closeVideoOperate(int i, int i2);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    String getCurrentProgress();

    void hideAlertView(int i);

    boolean isH5Canvas();

    void notifyCloseBtn(int i);

    void progressBarOperate(int i);

    void progressOperate(int i, int i2);

    void setCover(boolean z);

    void setInstallDialogState(boolean z);

    void setMiniEndCardState(boolean z);

    void setScaleFitXY(int i);

    void setVisible(int i);

    void showAlertView();

    void showIVRewardAlertView(String str);

    void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    void soundOperate(int i, int i2);

    void soundOperate(int i, int i2, String str);

    void videoOperate(int i);
}

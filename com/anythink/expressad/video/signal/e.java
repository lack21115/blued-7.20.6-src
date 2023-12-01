package com.anythink.expressad.video.signal;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/e.class */
public interface e extends f {
    public static final int d_ = -1;
    public static final int e_ = 1;
    public static final int f_ = 2;
    public static final int g_ = 1;
    public static final int h_ = 2;
    public static final int i_ = 3;
    public static final int j_ = 4;
    public static final int k_ = 5;
    public static final int l_ = 100;

    void configurationChanged(int i, int i2, int i3);

    boolean endCardShowing();

    void handlerPlayableException(String str);

    void hideAlertWebview();

    void ivRewardAdsWithoutVideo(String str);

    boolean miniCardLoaded();

    boolean miniCardShowing();

    void readyStatus(int i);

    void resizeMiniCard(int i, int i2, int i3);

    boolean showAlertWebView();

    void showEndcard(int i);

    void showMiniCard(int i, int i2, int i3, int i4, int i5);

    void showPlayableView();

    void showVideoClickView(int i);

    void showVideoEndCover();
}

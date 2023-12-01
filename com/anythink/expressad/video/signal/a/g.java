package com.anythink.expressad.video.signal.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/a/g.class */
public class g implements com.anythink.expressad.video.signal.j {
    protected static final String s = "DefaultJSVideoModule";

    @Override // com.anythink.expressad.video.signal.j
    public void alertWebViewShowed() {
        com.anythink.expressad.foundation.h.o.a(s, "alertWebViewShowed:");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void closeVideoOperate(int i, int i2) {
        com.anythink.expressad.foundation.h.o.a(s, "closeOperte:close=" + i + "closeViewVisible=" + i2);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void dismissAllAlert() {
        com.anythink.expressad.foundation.h.o.a(s, "dismissAllAlert");
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewHeight() {
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewLeft() {
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewRadius() {
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewTop() {
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.j
    public int getBorderViewWidth() {
        return 0;
    }

    @Override // com.anythink.expressad.video.signal.j
    public String getCurrentProgress() {
        com.anythink.expressad.foundation.h.o.a(s, "getCurrentProgress");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.j
    public void hideAlertView(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "hideAlertView:");
    }

    @Override // com.anythink.expressad.video.signal.j
    public boolean isH5Canvas() {
        return false;
    }

    @Override // com.anythink.expressad.video.signal.j
    public void notifyCloseBtn(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "notifyCloseBtn:".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressBarOperate(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "progressBarOperate:progressViewVisible=".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void progressOperate(int i, int i2) {
        com.anythink.expressad.foundation.h.o.a(s, "progressOperate:progress=" + i + "progressViewVisible=" + i2);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setCover(boolean z) {
        com.anythink.expressad.foundation.h.o.a(s, "setCover:".concat(String.valueOf(z)));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setInstallDialogState(boolean z) {
        com.anythink.expressad.foundation.h.o.a(s, "setInstallDialogState");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setMiniEndCardState(boolean z) {
        com.anythink.expressad.foundation.h.o.a(s, "setMiniEndCardState");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setScaleFitXY(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "setScaleFitXY:".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void setVisible(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "setVisible:".concat(String.valueOf(i)));
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showAlertView() {
        com.anythink.expressad.foundation.h.o.a(s, "showAlertView:");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showIVRewardAlertView(String str) {
        com.anythink.expressad.foundation.h.o.a(s, "showAlertView:");
    }

    @Override // com.anythink.expressad.video.signal.j
    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        com.anythink.expressad.foundation.h.o.a(s, "showVideoLocation:marginTop=" + i + ",marginLeft=" + i2 + ",width=" + i3 + ",height=" + i4 + ",radius=" + i5 + ",borderTop=" + i6 + ",borderTop=" + i6 + ",borderLeft=" + i7 + ",borderWidth=" + i8 + ",borderHeight=" + i9);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2) {
        com.anythink.expressad.foundation.h.o.a(s, "soundOperate:mute=" + i + ",soundViewVisible=" + i2);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void soundOperate(int i, int i2, String str) {
        com.anythink.expressad.foundation.h.o.a(s, "soundOperate:mute=" + i + ",soundViewVisible=" + i2 + ",pt=" + str);
    }

    @Override // com.anythink.expressad.video.signal.j
    public void videoOperate(int i) {
        com.anythink.expressad.foundation.h.o.a(s, "videoOperate:".concat(String.valueOf(i)));
    }
}

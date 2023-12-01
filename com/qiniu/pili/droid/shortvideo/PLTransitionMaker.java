package com.qiniu.pili.droid.shortvideo;

import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.s;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLTransitionMaker.class */
public class PLTransitionMaker {
    private s mTransitionMakerCore;

    public PLTransitionMaker(ViewGroup viewGroup, PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.mTransitionMakerCore = new s(viewGroup, pLVideoEncodeSetting);
    }

    public void addImage(PLImageView pLImageView) {
        this.mTransitionMakerCore.a(pLImageView);
    }

    public void addText(PLTextView pLTextView) {
        this.mTransitionMakerCore.a(pLTextView);
    }

    public void addTransition(PLImageView pLImageView, PLTransition pLTransition) {
        this.mTransitionMakerCore.a(pLImageView, pLTransition);
    }

    public void addTransition(PLTextView pLTextView, PLTransition pLTransition) {
        this.mTransitionMakerCore.a(pLTextView, pLTransition);
    }

    public void cancelSave() {
        this.mTransitionMakerCore.d();
    }

    public void destroy() {
        this.mTransitionMakerCore.e();
    }

    public void play() {
        this.mTransitionMakerCore.c();
    }

    public void removeAllResource() {
        this.mTransitionMakerCore.a();
    }

    public void save(String str, PLVideoSaveListener pLVideoSaveListener) {
        this.mTransitionMakerCore.a(str, pLVideoSaveListener);
        QosManager.a().a(QosManager.KeyPoint.transition_make);
        QosManager.a().a(this.mTransitionMakerCore.f());
    }

    public void setBackgroundColor(int i) {
        this.mTransitionMakerCore.b(i);
    }

    public void setDuration(int i) {
        this.mTransitionMakerCore.a(i);
    }

    public void stop() {
        this.mTransitionMakerCore.b();
    }
}

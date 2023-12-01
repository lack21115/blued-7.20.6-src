package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/jobs/ViewPortJob.class */
public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    protected float[] l = new float[2];
    protected ViewPortHandler m;
    protected float n;
    protected float o;
    protected Transformer p;
    protected View q;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        this.n = 0.0f;
        this.o = 0.0f;
        this.m = viewPortHandler;
        this.n = f;
        this.o = f2;
        this.p = transformer;
        this.q = view;
    }
}

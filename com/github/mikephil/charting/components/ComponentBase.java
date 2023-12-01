package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/ComponentBase.class */
public abstract class ComponentBase {
    protected boolean w = true;
    protected float x = 5.0f;
    protected float y = 5.0f;
    protected Typeface z = null;
    protected float A = Utils.a(10.0f);
    protected int B = -16777216;

    public void d(boolean z) {
        this.w = z;
    }

    public float u() {
        return this.x;
    }

    public float v() {
        return this.y;
    }

    public Typeface w() {
        return this.z;
    }

    public float x() {
        return this.A;
    }

    public int y() {
        return this.B;
    }

    public boolean z() {
        return this.w;
    }
}

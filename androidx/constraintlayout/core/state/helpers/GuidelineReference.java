package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/GuidelineReference.class */
public class GuidelineReference implements Reference, Facade {

    /* renamed from: a  reason: collision with root package name */
    final State f2108a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Guideline f2109c;
    private int d = -1;
    private int e = -1;
    private float f = 0.0f;
    private Object g;

    public GuidelineReference(State state) {
        this.f2108a = state;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        this.f2109c.setOrientation(this.b);
        int i = this.d;
        if (i != -1) {
            this.f2109c.setGuideBegin(i);
            return;
        }
        int i2 = this.e;
        if (i2 != -1) {
            this.f2109c.setGuideEnd(i2);
        } else {
            this.f2109c.setGuidePercent(this.f);
        }
    }

    public GuidelineReference end(Object obj) {
        this.d = -1;
        this.e = this.f2108a.convertDimension(obj);
        this.f = 0.0f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.f2109c == null) {
            this.f2109c = new Guideline();
        }
        return this.f2109c;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return null;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.g;
    }

    public int getOrientation() {
        return this.b;
    }

    public GuidelineReference percent(float f) {
        this.d = -1;
        this.e = -1;
        this.f = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.f2109c = (Guideline) constraintWidget;
        } else {
            this.f2109c = null;
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object obj) {
        this.g = obj;
    }

    public void setOrientation(int i) {
        this.b = i;
    }

    public GuidelineReference start(Object obj) {
        this.d = this.f2108a.convertDimension(obj);
        this.e = -1;
        this.f = 0.0f;
        return this;
    }
}

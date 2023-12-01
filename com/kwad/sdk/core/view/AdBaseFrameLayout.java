package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.e;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/view/AdBaseFrameLayout.class */
public class AdBaseFrameLayout extends FrameLayout implements e {
    private static final ac.a mTouchCoords = new ac.a();
    private List<View.OnTouchListener> aoo;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aoo = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoo = new ArrayList();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoo = new ArrayList();
    }

    public final void a(View.OnTouchListener onTouchListener) {
        if (this.aoo.contains(onTouchListener)) {
            return;
        }
        this.aoo.add(onTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            b.printStackTrace(th);
            com.kwad.sdk.service.b.gatherException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aoo.isEmpty()) {
            for (View.OnTouchListener onTouchListener : this.aoo) {
                onTouchListener.onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            mTouchCoords.u(getWidth(), getHeight());
            mTouchCoords.f(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            mTouchCoords.g(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.e
    public ac.a getTouchCoords() {
        return mTouchCoords;
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }
}

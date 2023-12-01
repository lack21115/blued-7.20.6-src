package com.kwad.sdk.widget.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.kwad.sdk.core.d.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/swipe/VerticalSwipeLayout.class */
public class VerticalSwipeLayout extends FrameLayout {
    private int aDw;
    private int aDx;
    private com.kwad.sdk.widget.swipe.a aDy;
    private List<a> aDz;
    private float fM;
    private float fN;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/swipe/VerticalSwipeLayout$a.class */
    public interface a {
        void ee();

        void ef();
    }

    public VerticalSwipeLayout(Context context) {
        super(context);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    public VerticalSwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    public VerticalSwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDx = 0;
        this.aDz = new ArrayList();
        init(context);
    }

    private void FI() {
        synchronized (this) {
            for (a aVar : this.aDz) {
                aVar.ef();
            }
        }
    }

    private void FJ() {
        synchronized (this) {
            for (a aVar : this.aDz) {
                aVar.ee();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.VerticalSwipeLayout.c(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != 3) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.VerticalSwipeLayout.d(android.view.MotionEvent):boolean");
    }

    private void init(Context context) {
        this.aDw = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public final void a(a aVar) {
        synchronized (this) {
            this.aDz.add(aVar);
        }
    }

    public final void b(a aVar) {
        synchronized (this) {
            this.aDz.remove(aVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        List<a> list = this.aDz;
        if (list != null && !list.isEmpty()) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action == 0) {
                parent = getParent();
            } else if (action == 1 || action == 3) {
                parent = getParent();
                z = false;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public List<a> getOnSwipedListeners() {
        List<a> list;
        synchronized (this) {
            list = this.aDz;
        }
        return list;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.aDy;
        if (aVar == null || !aVar.b(this, motionEvent)) {
            List<a> list = this.aDz;
            return (list == null || list.isEmpty()) ? super.onInterceptTouchEvent(motionEvent) : c(motionEvent);
        }
        b.d("VerticalSwipeLayout", "onInterceptTouchEvent true");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.kwad.sdk.widget.swipe.a aVar = this.aDy;
        if (aVar == null || !aVar.c(this, motionEvent)) {
            List<a> list = this.aDz;
            return (list == null || list.isEmpty()) ? super.onTouchEvent(motionEvent) : d(motionEvent);
        }
        b.d("VerticalSwipeLayout", "handlerTouchEvent true");
        return true;
    }

    public void setTouchDetector(com.kwad.sdk.widget.swipe.a aVar) {
        this.aDy = aVar;
    }
}

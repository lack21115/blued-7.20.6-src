package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/GhostViewPort.class */
public class GhostViewPort extends ViewGroup implements GhostView {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f3451a;
    View b;

    /* renamed from: c  reason: collision with root package name */
    final View f3452c;
    int d;
    private Matrix e;
    private final ViewTreeObserver.OnPreDrawListener f;

    GhostViewPort(View view) {
        super(view.getContext());
        this.f = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewCompat.postInvalidateOnAnimation(GhostViewPort.this);
                if (GhostViewPort.this.f3451a == null || GhostViewPort.this.b == null) {
                    return true;
                }
                GhostViewPort.this.f3451a.endViewTransition(GhostViewPort.this.b);
                ViewCompat.postInvalidateOnAnimation(GhostViewPort.this.f3451a);
                GhostViewPort.this.f3451a = null;
                GhostViewPort.this.b = null;
                return true;
            }
        };
        this.f3452c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static GhostViewPort a(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    static void a(View view, View view2) {
        ViewUtils.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static void a(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ViewUtils.a(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        ViewUtils.b(viewGroup, matrix);
    }

    static void a(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewPort b(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostViewPort ghostViewPort;
        GhostViewHolder ghostViewHolder;
        if (view.getParent() instanceof ViewGroup) {
            GhostViewHolder a2 = GhostViewHolder.a(viewGroup);
            GhostViewPort a3 = a(view);
            GhostViewPort ghostViewPort2 = a3;
            int i = 0;
            if (a3 != null) {
                GhostViewHolder ghostViewHolder2 = (GhostViewHolder) a3.getParent();
                ghostViewPort2 = a3;
                i = 0;
                if (ghostViewHolder2 != a2) {
                    i = a3.d;
                    ghostViewHolder2.removeView(a3);
                    ghostViewPort2 = null;
                }
            }
            if (ghostViewPort2 == null) {
                Matrix matrix2 = matrix;
                if (matrix == null) {
                    matrix2 = new Matrix();
                    a(view, viewGroup, matrix2);
                }
                GhostViewPort ghostViewPort3 = new GhostViewPort(view);
                ghostViewPort3.a(matrix2);
                if (a2 == null) {
                    ghostViewHolder = new GhostViewHolder(viewGroup);
                } else {
                    a2.a();
                    ghostViewHolder = a2;
                }
                a(viewGroup, ghostViewHolder);
                a((View) viewGroup, (View) ghostViewPort3);
                ghostViewHolder.a(ghostViewPort3);
                ghostViewPort3.d = i;
                ghostViewPort = ghostViewPort3;
            } else {
                ghostViewPort = ghostViewPort2;
                if (matrix != null) {
                    ghostViewPort2.a(matrix);
                    ghostViewPort = ghostViewPort2;
                }
            }
            ghostViewPort.d++;
            return ghostViewPort;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view) {
        GhostViewPort a2 = a(view);
        if (a2 != null) {
            int i = a2.d - 1;
            a2.d = i;
            if (i <= 0) {
                ((GhostViewHolder) a2.getParent()).removeView(a2);
            }
        }
    }

    void a(Matrix matrix) {
        this.e = matrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f3452c, this);
        this.f3452c.getViewTreeObserver().addOnPreDrawListener(this.f);
        ViewUtils.a(this.f3452c, 4);
        if (this.f3452c.getParent() != null) {
            ((View) this.f3452c.getParent()).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f3452c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        ViewUtils.a(this.f3452c, 0);
        a(this.f3452c, (GhostViewPort) null);
        if (this.f3452c.getParent() != null) {
            ((View) this.f3452c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        CanvasUtils.a(canvas, true);
        canvas.setMatrix(this.e);
        ViewUtils.a(this.f3452c, 0);
        this.f3452c.invalidate();
        ViewUtils.a(this.f3452c, 4);
        drawChild(canvas, this.f3452c, getDrawingTime());
        CanvasUtils.a(canvas, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.f3451a = viewGroup;
        this.b = view;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (a(this.f3452c) == this) {
            ViewUtils.a(this.f3452c, i == 0 ? 4 : 0);
        }
    }
}

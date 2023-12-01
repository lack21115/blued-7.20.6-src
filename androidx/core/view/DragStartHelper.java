package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DragStartHelper.class */
public class DragStartHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f2630a;
    private final OnDragStartListener b;

    /* renamed from: c  reason: collision with root package name */
    private int f2631c;
    private int d;
    private boolean e;
    private final View.OnLongClickListener f = new View.OnLongClickListener() { // from class: androidx.core.view.DragStartHelper.1
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    };
    private final View.OnTouchListener g = new View.OnTouchListener() { // from class: androidx.core.view.DragStartHelper.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    };

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DragStartHelper$OnDragStartListener.class */
    public interface OnDragStartListener {
        boolean onDragStart(View view, DragStartHelper dragStartHelper);
    }

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.f2630a = view;
        this.b = onDragStartListener;
    }

    public void attach() {
        this.f2630a.setOnLongClickListener(this.f);
        this.f2630a.setOnTouchListener(this.g);
    }

    public void detach() {
        this.f2630a.setOnLongClickListener(null);
        this.f2630a.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.f2631c, this.d);
    }

    public boolean onLongClick(View view) {
        return this.b.onDragStart(view, this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2631c = x;
            this.d = y;
            return false;
        }
        if (action != 1) {
            if (action == 2) {
                if (!MotionEventCompat.isFromSource(motionEvent, 8194) || (motionEvent.getButtonState() & 1) == 0 || this.e) {
                    return false;
                }
                if (this.f2631c == x && this.d == y) {
                    return false;
                }
                this.f2631c = x;
                this.d = y;
                boolean onDragStart = this.b.onDragStart(view, this);
                this.e = onDragStart;
                return onDragStart;
            } else if (action != 3) {
                return false;
            }
        }
        this.e = false;
        return false;
    }
}

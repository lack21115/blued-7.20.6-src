package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/WrapperViewList.class */
public class WrapperViewList extends ListView {
    private LifeCycleListener a;
    private List<View> b;
    private int c;
    private Rect d;
    private Field e;
    private boolean f;
    private boolean g;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/WrapperViewList$LifeCycleListener.class */
    interface LifeCycleListener {
        void a(Canvas canvas);
    }

    public WrapperViewList(Context context) {
        super(context);
        this.d = new Rect();
        this.f = true;
        this.g = false;
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mSelectorRect");
            declaredField.setAccessible(true);
            this.d = (Rect) declaredField.get(this);
            if (Build.VERSION.SDK_INT >= 14) {
                Field declaredField2 = AbsListView.class.getDeclaredField("mSelectorPosition");
                this.e = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private void b() {
        int c;
        if (this.d.isEmpty() || (c = c()) < 0) {
            return;
        }
        View childAt = getChildAt(c - a());
        if (childAt instanceof WrapperView) {
            WrapperView wrapperView = (WrapperView) childAt;
            this.d.top = wrapperView.getTop() + wrapperView.e;
        }
    }

    private void b(View view) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(view);
    }

    private int c() {
        Field field = this.e;
        if (field != null) {
            try {
                return field.getInt(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return -1;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return -1;
            }
            if (getChildAt(i2).getBottom() == this.d.bottom) {
                return i2 + a();
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (Build.VERSION.SDK_INT >= 11) {
            return firstVisiblePosition;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = firstVisiblePosition;
            if (i3 >= getChildCount()) {
                break;
            } else if (getChildAt(i3).getBottom() >= 0) {
                i = firstVisiblePosition + i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        int i4 = i;
        if (!this.f) {
            i4 = i;
            if (getPaddingTop() > 0) {
                i4 = i;
                if (i > 0) {
                    i4 = i;
                    if (getChildAt(0).getTop() > 0) {
                        i4 = i - 1;
                    }
                }
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LifeCycleListener lifeCycleListener) {
        this.a = lifeCycleListener;
    }

    public void a(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view) {
        List<View> list = this.b;
        if (list == null) {
            return false;
        }
        return list.contains(view);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        super.addFooterView(view);
        b(view);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        super.addFooterView(view, obj, z);
        b(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        b();
        if (this.c != 0) {
            canvas.save();
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.top = this.c;
            canvas.clipRect(clipBounds);
            super.dispatchDraw(canvas);
            canvas.restore();
        } else {
            super.dispatchDraw(canvas);
        }
        this.a.a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (this.g) {
            return;
        }
        super.layoutChildren();
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        View view2 = view;
        if (view instanceof WrapperView) {
            view2 = ((WrapperView) view).a;
        }
        return super.performItemClick(view2, i, j);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        if (super.removeFooterView(view)) {
            this.b.remove(view);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        this.f = z;
        super.setClipToPadding(z);
    }
}

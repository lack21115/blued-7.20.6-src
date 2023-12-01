package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewBoundsCheck.class */
public class ViewBoundsCheck {

    /* renamed from: a  reason: collision with root package name */
    final Callback f3361a;
    BoundFlags b = new BoundFlags();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewBoundsCheck$BoundFlags.class */
    public static class BoundFlags {

        /* renamed from: a  reason: collision with root package name */
        int f3362a = 0;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f3363c;
        int d;
        int e;

        BoundFlags() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a() {
            this.f3362a = 0;
        }

        void a(int i) {
            this.f3362a = i | this.f3362a;
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.f3363c = i2;
            this.d = i3;
            this.e = i4;
        }

        boolean b() {
            int i = this.f3362a;
            if ((i & 7) == 0 || (i & (a(this.d, this.b) << 0)) != 0) {
                int i2 = this.f3362a;
                if ((i2 & 112) == 0 || (i2 & (a(this.d, this.f3363c) << 4)) != 0) {
                    int i3 = this.f3362a;
                    if ((i3 & 1792) == 0 || (i3 & (a(this.e, this.b) << 8)) != 0) {
                        int i4 = this.f3362a;
                        return (i4 & 28672) == 0 || (i4 & (a(this.e, this.f3363c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewBoundsCheck$Callback.class */
    public interface Callback {
        View getChildAt(int i);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ViewBoundsCheck$ViewBounds.class */
    public @interface ViewBounds {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBoundsCheck(Callback callback) {
        this.f3361a = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int parentStart = this.f3361a.getParentStart();
        int parentEnd = this.f3361a.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (true) {
            View view2 = view;
            if (i == i2) {
                return view2;
            }
            View childAt = this.f3361a.getChildAt(i);
            this.b.a(parentStart, parentEnd, this.f3361a.getChildStart(childAt), this.f3361a.getChildEnd(childAt));
            if (i3 != 0) {
                this.b.a();
                this.b.a(i3);
                if (this.b.b()) {
                    return childAt;
                }
            }
            View view3 = view2;
            if (i4 != 0) {
                this.b.a();
                this.b.a(i4);
                view3 = view2;
                if (this.b.b()) {
                    view3 = childAt;
                }
            }
            i += i5;
            view = view3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.b.a(this.f3361a.getParentStart(), this.f3361a.getParentEnd(), this.f3361a.getChildStart(view), this.f3361a.getChildEnd(view));
        if (i != 0) {
            this.b.a();
            this.b.a(i);
            return this.b.b();
        }
        return false;
    }
}

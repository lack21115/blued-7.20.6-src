package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/GhostViewHolder.class */
class GhostViewHolder extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f3448a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f3448a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.a(this.f3448a).add(this);
        this.b = true;
    }

    private int a(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            a(((GhostViewPort) getChildAt(i2)).f3452c, arrayList2);
            if (a(arrayList, arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewHolder a(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private static void a(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean a(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            if (view.getZ() > view2.getZ()) {
                z = true;
            }
            return z;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return true;
            }
            View childAt = viewGroup.getChildAt(ViewGroupUtils.a(viewGroup, i2));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        boolean z = true;
        if (!arrayList.isEmpty()) {
            z = true;
            if (!arrayList2.isEmpty()) {
                if (arrayList.get(0) != arrayList2.get(0)) {
                    return true;
                }
                int min = Math.min(arrayList.size(), arrayList2.size());
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 < min) {
                        View view = arrayList.get(i2);
                        View view2 = arrayList2.get(i2);
                        if (view != view2) {
                            return a(view, view2);
                        }
                        i = i2 + 1;
                    } else if (arrayList2.size() == min) {
                        return true;
                    } else {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        ViewGroupUtils.a(this.f3448a).remove(this);
        ViewGroupUtils.a(this.f3448a).add(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<>();
        a(ghostViewPort.f3452c, arrayList);
        int a2 = a(arrayList);
        if (a2 < 0 || a2 >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, a2);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f3448a.setTag(R.id.ghost_view_holder, null);
            ViewGroupUtils.a(this.f3448a).remove(this);
            this.b = false;
        }
    }
}

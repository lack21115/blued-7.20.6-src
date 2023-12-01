package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintHelper.class */
public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    private View[] f2253a;
    protected int[] j;
    protected int k;
    protected Context l;
    protected Helper m;
    protected boolean n;
    protected String o;
    protected String p;
    protected HashMap<Integer, String> q;

    public ConstraintHelper(Context context) {
        super(context);
        this.j = new int[32];
        this.n = false;
        this.f2253a = null;
        this.q = new HashMap<>();
        this.l = context;
        a((AttributeSet) null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new int[32];
        this.n = false;
        this.f2253a = null;
        this.q = new HashMap<>();
        this.l = context;
        a(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new int[32];
        this.n = false;
        this.f2253a = null;
        this.q = new HashMap<>();
        this.l = context;
        a(attributeSet);
    }

    private int a(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.l.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return 0;
            }
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException e) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
            i = i2 + 1;
        }
    }

    private void a(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.k;
        int[] iArr = this.j;
        if (i2 + 1 > iArr.length) {
            this.j = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.j;
        int i3 = this.k;
        iArr2[i3] = i;
        this.k = i3 + 1;
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.l == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int c2 = c(trim);
        if (c2 != 0) {
            this.q.put(Integer.valueOf(c2), trim);
            a(c2);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private int[] a(View view, String str) {
        int i;
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= split.length) {
                break;
            }
            int c2 = c(split[i2].trim());
            int i4 = i;
            if (c2 != 0) {
                iArr[i] = c2;
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        int[] iArr2 = iArr;
        if (i != split.length) {
            iArr2 = Arrays.copyOf(iArr, i);
        }
        return iArr2;
    }

    private void b(String str) {
        if (str == null || str.length() == 0 || this.l == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = null;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = constraintLayout.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    a(childAt.getId());
                }
            }
            i = i2 + 1;
        }
    }

    private int c(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode()) {
            i = 0;
            if (constraintLayout != null) {
                Object designInformation = constraintLayout.getDesignInformation(0, str);
                i = 0;
                if (designInformation instanceof Integer) {
                    i = ((Integer) designInformation).intValue();
                }
            }
        }
        int i2 = i;
        if (i == 0) {
            i2 = i;
            if (constraintLayout != null) {
                i2 = a(constraintLayout, str);
            }
        }
        int i3 = i2;
        if (i2 == 0) {
            try {
                i3 = R.id.class.getField(str).getInt(null);
            } catch (Exception e) {
                i3 = i2;
            }
        }
        int i4 = i3;
        if (i3 == 0) {
            i4 = this.l.getResources().getIdentifier(str, "id", this.l.getPackageName());
        }
        return i4;
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                String string = obtainStyledAttributes.getString(index);
                this.o = string;
                setIds(string);
            } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                String string2 = obtainStyledAttributes.getString(index);
                this.p = string2;
                setReferenceTags(string2);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ConstraintLayout constraintLayout) {
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else if (view.getParent() == null) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        } else {
            this.o = null;
            a(view.getId());
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        b((ConstraintLayout) parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            View viewById = constraintLayout.getViewById(this.j[i2]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] c(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2253a;
        if (viewArr == null || viewArr.length != this.k) {
            this.f2253a = new View[this.k];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return this.f2253a;
            }
            this.f2253a[i2] = constraintLayout.getViewById(this.j[i2]);
            i = i2 + 1;
        }
    }

    public boolean containsId(int i) {
        int[] iArr = this.j;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (iArr[i3] == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.j, this.k);
    }

    public int indexFromId(int i) {
        int[] iArr = this.j;
        int length = iArr.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return i2;
            }
            i2++;
            if (iArr[i4] == i) {
                return i2;
            }
            i3 = i4 + 1;
        }
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (constraint.layout.mReferenceIds != null) {
            setReferencedIds(constraint.layout.mReferenceIds);
        } else if (constraint.layout.mReferenceIdString != null) {
            if (constraint.layout.mReferenceIdString.length() > 0) {
                constraint.layout.mReferenceIds = a(this, constraint.layout.mReferenceIdString);
            } else {
                constraint.layout.mReferenceIds = null;
            }
        }
        if (helperWidget == null) {
            return;
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= constraint.layout.mReferenceIds.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(constraint.layout.mReferenceIds[i2]);
            if (constraintWidget != null) {
                helperWidget.add(constraintWidget);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.o;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.p;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.n) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i;
        int i2;
        int id = view.getId();
        if (id == -1) {
            return -1;
        }
        this.o = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            i = -1;
            if (i4 >= this.k) {
                break;
            } else if (this.j[i4] == id) {
                int i5 = i4;
                while (true) {
                    int i6 = i5;
                    i2 = this.k;
                    if (i6 >= i2 - 1) {
                        break;
                    }
                    int[] iArr = this.j;
                    int i7 = i6 + 1;
                    iArr[i6] = iArr[i7];
                    i5 = i7;
                }
                this.j[i2 - 1] = 0;
                this.k = i2 - 1;
                i = i4;
            } else {
                i3 = i4 + 1;
            }
        }
        requestLayout();
        return i;
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
    }

    protected void setIds(String str) {
        this.o = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.k = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.p = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.k = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                b(str.substring(i));
                return;
            } else {
                b(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.o = null;
        this.k = 0;
        for (int i : iArr) {
            a(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.o == null) {
            a(i);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            helper.add(sparseArray.get(this.j[i2]));
            i = i2 + 1;
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.o);
        }
        Helper helper = this.m;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                this.m.updateConstraints(constraintLayout.mLayoutWidget);
                return;
            }
            int i3 = this.j[i2];
            View viewById = constraintLayout.getViewById(i3);
            View view = viewById;
            if (viewById == null) {
                String str = this.q.get(Integer.valueOf(i3));
                int a2 = a(constraintLayout, str);
                view = viewById;
                if (a2 != 0) {
                    this.j[i2] = a2;
                    this.q.put(Integer.valueOf(a2), str);
                    view = constraintLayout.getViewById(a2);
                }
            }
            if (view != null) {
                this.m.add(constraintLayout.getViewWidget(view));
            }
            i = i2 + 1;
        }
    }

    public void validateParams() {
        if (this.m == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).v = (ConstraintWidget) this.m;
        }
    }
}

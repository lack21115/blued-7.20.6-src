package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/helper/widget/CircularFlow.class */
public class CircularFlow extends VirtualLayout {

    /* renamed from: c  reason: collision with root package name */
    private static int f2108c;
    private static float d;

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout f2109a;
    int b;
    private float[] e;
    private int[] f;
    private int g;
    private int h;
    private String i;
    private String r;
    private Float s;
    private Integer t;

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        this.f2109a = (ConstraintLayout) getParent();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                b();
                return;
            }
            View viewById = this.f2109a.getViewById(this.j[i2]);
            if (viewById != null) {
                int i3 = f2108c;
                float f = d;
                int[] iArr = this.f;
                if (iArr == null || i2 >= iArr.length) {
                    Integer num = this.t;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.q.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.g++;
                        if (this.f == null) {
                            this.f = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f = radius;
                        radius[this.g - 1] = i3;
                    }
                } else {
                    i3 = iArr[i2];
                }
                float[] fArr = this.e;
                if (fArr == null || i2 >= fArr.length) {
                    Float f2 = this.s;
                    if (f2 == null || f2.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.q.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.h++;
                        if (this.e == null) {
                            this.e = new float[1];
                        }
                        float[] angles = getAngles();
                        this.e = angles;
                        angles[this.h - 1] = f;
                    }
                } else {
                    f = fArr[i2];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f;
                layoutParams.circleConstraint = this.b;
                layoutParams.circleRadius = i3;
                viewById.setLayoutParams(layoutParams);
            }
            i = i2 + 1;
        }
    }

    private void a(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.l == null || (fArr = this.e) == null) {
            return;
        }
        if (this.h + 1 > fArr.length) {
            this.e = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.e[this.h] = Integer.parseInt(str);
        this.h++;
    }

    private float[] a(float[] fArr, int i) {
        float[] fArr2 = fArr;
        if (fArr != null) {
            fArr2 = fArr;
            if (i >= 0) {
                if (i >= this.h) {
                    return fArr;
                }
                fArr2 = removeElementFromArray(fArr, i);
            }
        }
        return fArr2;
    }

    private int[] a(int[] iArr, int i) {
        int[] iArr2 = iArr;
        if (iArr != null) {
            iArr2 = iArr;
            if (i >= 0) {
                if (i >= this.g) {
                    return iArr;
                }
                iArr2 = removeElementFromArray(iArr, i);
            }
        }
        return iArr2;
    }

    private void b(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.l == null || (iArr = this.f) == null) {
            return;
        }
        if (this.g + 1 > iArr.length) {
            this.f = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f[this.g] = (int) (Integer.parseInt(str) * this.l.getResources().getDisplayMetrics().density);
        this.g++;
    }

    public static float[] removeElementFromArray(float[] fArr, int i) {
        float[] fArr2 = new float[fArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            if (i3 != i) {
                fArr2[i2] = fArr[i3];
                i2++;
            }
        }
        return fArr2;
    }

    public static int[] removeElementFromArray(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 != i) {
                iArr2[i2] = iArr[i3];
                i2++;
            }
        }
        return iArr2;
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.h = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i).trim());
                return;
            } else {
                a(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                b(str.substring(i).trim());
                return;
            } else {
                b(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
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
            if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                this.b = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                String string = obtainStyledAttributes.getString(index);
                this.i = string;
                setAngles(string);
            } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                String string2 = obtainStyledAttributes.getString(index);
                this.r = string2;
                setRadius(string2);
            } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, d));
                this.s = valueOf;
                setDefaultAngle(valueOf.floatValue());
            } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f2108c));
                this.t = valueOf2;
                setDefaultRadius(valueOf2.intValue());
            }
            i = i2 + 1;
        }
    }

    public void addViewToCircularFlow(View view, int i, float f) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.h++;
        float[] angles = getAngles();
        this.e = angles;
        angles[this.h - 1] = f;
        this.g++;
        int[] radius = getRadius();
        this.f = radius;
        radius[this.g - 1] = (int) (i * this.l.getResources().getDisplayMetrics().density);
        a();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.e, this.h);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f, this.g);
    }

    public boolean isUpdatable(View view) {
        boolean z = false;
        if (containsId(view.getId())) {
            if (indexFromId(view.getId()) != -1) {
                z = true;
            }
            return z;
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.i;
        if (str != null) {
            this.e = new float[1];
            setAngles(str);
        }
        String str2 = this.r;
        if (str2 != null) {
            this.f = new int[1];
            setRadius(str2);
        }
        Float f = this.s;
        if (f != null) {
            setDefaultAngle(f.floatValue());
        }
        Integer num = this.t;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        a();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.f2109a);
        constraintSet.clear(view.getId(), 8);
        constraintSet.applyTo(this.f2109a);
        float[] fArr = this.e;
        if (removeView < fArr.length) {
            this.e = a(fArr, removeView);
            this.h--;
        }
        int[] iArr = this.f;
        if (removeView < iArr.length) {
            this.f = a(iArr, removeView);
            this.g--;
        }
        a();
        return removeView;
    }

    public void setDefaultAngle(float f) {
        d = f;
    }

    public void setDefaultRadius(int i) {
        f2108c = i;
    }

    public void updateAngle(View view, float f) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.e.length) {
            return;
        }
        float[] angles = getAngles();
        this.e = angles;
        angles[indexFromId] = f;
        a();
    }

    public void updateRadius(View view, int i) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.f.length) {
            return;
        }
        int[] radius = getRadius();
        this.f = radius;
        radius[indexFromId] = (int) (i * this.l.getResources().getDisplayMetrics().density);
        a();
    }

    public void updateReference(View view, int i, float f) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.e = angles;
            angles[indexFromId] = f;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.f = radius;
            radius[indexFromId] = (int) (i * this.l.getResources().getDisplayMetrics().density);
        }
        a();
    }
}

package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/StateListDrawable.class */
public class StateListDrawable extends DrawableContainer {

    /* renamed from: a  reason: collision with root package name */
    private StateListState f1633a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/StateListDrawable$StateListState.class */
    public static class StateListState extends DrawableContainer.DrawableContainerState {
        int[][] L;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v3, types: [int[], int[][]] */
        public StateListState(StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
            super(stateListState, stateListDrawable, resources);
            if (stateListState != null) {
                this.L = stateListState.L;
            } else {
                this.L = new int[c()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int addChild = addChild(drawable);
            this.L[addChild] = iArr;
            return addChild;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [int[], int[][]] */
        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        void a() {
            int[][] iArr = this.L;
            ?? r0 = new int[iArr.length];
            int length = iArr.length;
            while (true) {
                int i = length - 1;
                if (i < 0) {
                    this.L = r0;
                    return;
                }
                int[][] iArr2 = this.L;
                r0[i] = iArr2[i] != null ? (int[]) iArr2[i].clone() : null;
                length = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    return -1;
                }
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [int[], int[][], java.lang.Object] */
        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int i, int i2) {
            super.growArray(i, i2);
            ?? r0 = new int[i2];
            System.arraycopy(this.L, 0, (Object) r0, 0, i);
            this.L = r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }
    }

    StateListDrawable() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateListDrawable(StateListState stateListState) {
        if (stateListState != null) {
            a(stateListState);
        }
    }

    StateListDrawable(StateListState stateListState, Resources resources) {
        a(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        StateListState stateListState = this.f1633a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                Drawable drawable = null;
                int resourceId = obtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                if (resourceId > 0) {
                    drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                }
                obtainAttributes.recycle();
                int[] a2 = a(attributeSet);
                Drawable drawable2 = drawable;
                if (drawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    drawable2 = Build.VERSION.SDK_INT >= 21 ? Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
                stateListState.a(a2, drawable2);
            }
        }
    }

    private void a(TypedArray typedArray) {
        StateListState stateListState = this.f1633a;
        if (Build.VERSION.SDK_INT >= 21) {
            stateListState.f |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        }
        stateListState.k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.k);
        stateListState.n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.n);
        stateListState.C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.C);
        stateListState.D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.D);
        stateListState.z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void a(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.a(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.f1633a = (StateListState) drawableContainerState;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= attributeCount) {
                return StateSet.trimStateSet(iArr, i3);
            }
            int attributeNameResource = attributeSet.getAttributeNameResource(i);
            int i4 = i3;
            if (attributeNameResource != 0) {
                i4 = i3;
                if (attributeNameResource != 16842960) {
                    i4 = i3;
                    if (attributeNameResource != 16843161) {
                        iArr[i3] = attributeSet.getAttributeBooleanValue(i, false) ? attributeNameResource : -attributeNameResource;
                        i4 = i3 + 1;
                    }
                }
            }
            i++;
            i2 = i4;
        }
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.f1633a.a(iArr, drawable);
            onStateChange(getState());
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    /* renamed from: b */
    public StateListState c() {
        return new StateListState(this.f1633a, this, null);
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        a(obtainAttributes);
        a(resources);
        obtainAttributes.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.f1633a.a();
            this.b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.f1633a.b(iArr);
        int i = b;
        if (b < 0) {
            i = this.f1633a.b(StateSet.WILD_CARD);
        }
        return a(i) || onStateChange;
    }
}

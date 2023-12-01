package android.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.DrawableContainer;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/LevelListDrawable.class */
public class LevelListDrawable extends DrawableContainer {
    private LevelListState mLevelListState;
    private boolean mMutated;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/LevelListDrawable$LevelListState.class */
    public static final class LevelListState extends DrawableContainer.DrawableContainerState {
        private int[] mHighs;
        private int[] mLows;

        LevelListState(LevelListState levelListState, LevelListDrawable levelListDrawable, Resources resources) {
            super(levelListState, levelListDrawable, resources);
            if (levelListState != null) {
                this.mLows = levelListState.mLows;
                this.mHighs = levelListState.mHighs;
                return;
            }
            this.mLows = new int[getCapacity()];
            this.mHighs = new int[getCapacity()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mutate() {
            this.mLows = (int[]) this.mLows.clone();
            this.mHighs = (int[]) this.mHighs.clone();
        }

        public void addLevel(int i, int i2, Drawable drawable) {
            int addChild = addChild(drawable);
            this.mLows[addChild] = i;
            this.mHighs[addChild] = i2;
        }

        @Override // android.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int i, int i2) {
            super.growArray(i, i2);
            int[] iArr = new int[i2];
            System.arraycopy(this.mLows, 0, iArr, 0, i);
            this.mLows = iArr;
            int[] iArr2 = new int[i2];
            System.arraycopy(this.mHighs, 0, iArr2, 0, i);
            this.mHighs = iArr2;
        }

        public int indexOfLevel(int i) {
            int[] iArr = this.mLows;
            int[] iArr2 = this.mHighs;
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childCount) {
                    return -1;
                }
                if (i >= iArr[i3] && i <= iArr2[i3]) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new LevelListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new LevelListDrawable(this, resources);
        }
    }

    public LevelListDrawable() {
        this(null, null);
    }

    private LevelListDrawable(LevelListState levelListState, Resources resources) {
        setConstantState(new LevelListState(levelListState, this, resources));
        onLevelChange(getLevel());
    }

    public void addLevel(int i, int i2, Drawable drawable) {
        if (drawable != null) {
            this.mLevelListState.addLevel(i, i2, drawable);
            onLevelChange(getLevel());
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.graphics.drawable.DrawableContainer
    public LevelListState cloneConstantState() {
        return new LevelListState(this.mLevelListState, this, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0107, code lost:
        onLevelChange(getLevel());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0110, code lost:
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void inflate(android.content.res.Resources r7, org.xmlpull.v1.XmlPullParser r8, android.util.AttributeSet r9, android.content.res.Resources.Theme r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.graphics.drawable.LevelListDrawable.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mLevelListState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (selectDrawable(this.mLevelListState.indexOfLevel(i))) {
            return true;
        }
        return super.onLevelChange(i);
    }

    @Override // android.graphics.drawable.DrawableContainer
    protected void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof LevelListState) {
            this.mLevelListState = (LevelListState) drawableContainerState;
        }
    }
}

package android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.PathParser;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable.class */
public class VectorDrawable extends Drawable {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String LOGTAG = VectorDrawable.class.getSimpleName();
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private VectorDrawableState mVectorState;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VClipPath.class */
    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= typedArray.getChangingConfigurations();
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = Drawable.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableClipPath);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        @Override // android.graphics.drawable.VectorDrawable.VPath
        public boolean isClipPath() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VFullPath.class */
    public static class VFullPath extends VPath {
        float mFillAlpha;
        int mFillColor;
        int mFillRule;
        float mStrokeAlpha;
        int mStrokeColor;
        Paint.Cap mStrokeLineCap;
        Paint.Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        public VFullPath() {
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.mFillColor = 0;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mStrokeColor = 0;
            this.mStrokeWidth = 0.0f;
            this.mFillColor = 0;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private Paint.Cap getStrokeLineCap(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Paint.Join getStrokeLineJoin(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= typedArray.getChangingConfigurations();
            this.mThemeAttrs = typedArray.extractThemeAttrs();
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.mNodes = PathParser.createNodesFromPathData(string2);
            }
            this.mFillColor = typedArray.getColor(1, this.mFillColor);
            this.mFillAlpha = typedArray.getFloat(12, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(typedArray.getInt(8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(typedArray.getInt(9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = typedArray.getFloat(10, this.mStrokeMiterlimit);
            this.mStrokeColor = typedArray.getColor(3, this.mStrokeColor);
            this.mStrokeAlpha = typedArray.getFloat(11, this.mStrokeAlpha);
            this.mStrokeWidth = typedArray.getFloat(4, this.mStrokeWidth);
            this.mTrimPathEnd = typedArray.getFloat(6, this.mTrimPathEnd);
            this.mTrimPathOffset = typedArray.getFloat(7, this.mTrimPathOffset);
            this.mTrimPathStart = typedArray.getFloat(5, this.mTrimPathStart);
        }

        @Override // android.graphics.drawable.VectorDrawable.VPath
        public void applyTheme(Resources.Theme theme) {
            if (this.mThemeAttrs == null) {
                return;
            }
            TypedArray resolveAttributes = theme.resolveAttributes(this.mThemeAttrs, R.styleable.VectorDrawablePath);
            updateStateFromTypedArray(resolveAttributes);
            resolveAttributes.recycle();
        }

        @Override // android.graphics.drawable.VectorDrawable.VPath
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        int getFillColor() {
            return this.mFillColor;
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        int getStrokeColor() {
            return this.mStrokeColor;
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = Drawable.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawablePath);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        void setFillColor(int i) {
            this.mFillColor = i;
        }

        void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        void setStrokeColor(int i) {
            this.mStrokeColor = i;
        }

        void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VGroup.class */
    public static class VGroup {
        private int mChangingConfigurations;
        final ArrayList<Object> mChildren;
        private String mGroupName;
        private final Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        private float mRotate;
        private float mScaleX;
        private float mScaleY;
        private final Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup() {
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v44, types: [android.graphics.drawable.VectorDrawable$VPath] */
        /* JADX WARN: Type inference failed for: r1v39, types: [android.graphics.drawable.VectorDrawable$VPath] */
        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VFullPath vClipPath;
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            this.mGroupName = vGroup.mGroupName;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (this.mGroupName != null) {
                arrayMap.put(this.mGroupName, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<Object> arrayList = vGroup.mChildren;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                Object obj = arrayList.get(i2);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) obj);
                    } else if (!(obj instanceof VClipPath)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        vClipPath = new VClipPath((VClipPath) obj);
                    }
                    this.mChildren.add(vClipPath);
                    if (vClipPath.mPathName != null) {
                        arrayMap.put(vClipPath.mPathName, vClipPath);
                    }
                }
                i = i2 + 1;
            }
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            this.mChangingConfigurations |= typedArray.getChangingConfigurations();
            this.mThemeAttrs = typedArray.extractThemeAttrs();
            this.mRotate = typedArray.getFloat(5, this.mRotate);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = typedArray.getFloat(3, this.mScaleX);
            this.mScaleY = typedArray.getFloat(4, this.mScaleY);
            this.mTranslateX = typedArray.getFloat(6, this.mTranslateX);
            this.mTranslateY = typedArray.getFloat(7, this.mTranslateY);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        public void applyTheme(Resources.Theme theme) {
            if (this.mThemeAttrs == null) {
                return;
            }
            TypedArray resolveAttributes = theme.resolveAttributes(this.mThemeAttrs, R.styleable.VectorDrawableGroup);
            updateStateFromTypedArray(resolveAttributes);
            resolveAttributes.recycle();
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme) {
            TypedArray obtainAttributes = Drawable.obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawableGroup);
            updateStateFromTypedArray(obtainAttributes);
            obtainAttributes.recycle();
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VPath.class */
    public static class VPath {
        int mChangingConfigurations;
        protected PathParser.PathDataNode[] mNodes;
        String mPathName;

        public VPath() {
            this.mNodes = null;
        }

        public VPath(VPath vPath) {
            this.mNodes = null;
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            } else {
                this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            if (this.mNodes != null) {
                PathParser.PathDataNode.nodesToPath(this.mNodes, path);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VPathRenderer.class */
    public static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = new Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        private Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        private final VGroup mRootGroup;
        String mRootName;
        private Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, this.mVGTargetsMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            if (vPathRenderer.mRootName != null) {
                this.mVGTargetsMap.put(vPathRenderer.mRootName, this);
            }
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= vGroup.mChildren.size()) {
                    return;
                }
                Object obj = vGroup.mChildren.get(i4);
                if (obj instanceof VGroup) {
                    drawGroupTree((VGroup) obj, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (obj instanceof VPath) {
                    drawPath(vGroup, (VPath) obj, canvas, i, i2, colorFilter);
                }
                i3 = i4 + 1;
            }
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.mViewportWidth;
            float f2 = i2 / this.mViewportHeight;
            float min = Math.min(f, f2);
            this.mFinalPathMatrix.set(vGroup.mStackedMatrix);
            this.mFinalPathMatrix.postScale(f, f2);
            vPath.toPath(this.mPath);
            Path path = this.mPath;
            this.mRenderPath.reset();
            if (vPath.isClipPath()) {
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                canvas.clipPath(this.mRenderPath, Region.Op.REPLACE);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            if (vFullPath.mTrimPathStart != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                float f3 = vFullPath.mTrimPathStart;
                float f4 = vFullPath.mTrimPathOffset;
                float f5 = vFullPath.mTrimPathEnd;
                float f6 = vFullPath.mTrimPathOffset;
                if (this.mPathMeasure == null) {
                    this.mPathMeasure = new PathMeasure();
                }
                this.mPathMeasure.setPath(this.mPath, false);
                float length = this.mPathMeasure.getLength();
                float f7 = ((f3 + f4) % 1.0f) * length;
                float f8 = ((f5 + f6) % 1.0f) * length;
                path.reset();
                if (f7 > f8) {
                    this.mPathMeasure.getSegment(f7, length, path, true);
                    this.mPathMeasure.getSegment(0.0f, f8, path, true);
                } else {
                    this.mPathMeasure.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.mRenderPath.addPath(path, this.mFinalPathMatrix);
            if (vFullPath.mFillColor != 0) {
                if (this.mFillPaint == null) {
                    this.mFillPaint = new Paint();
                    this.mFillPaint.setStyle(Paint.Style.FILL);
                    this.mFillPaint.setAntiAlias(true);
                }
                Paint paint = this.mFillPaint;
                paint.setColor(VectorDrawable.applyAlpha(vFullPath.mFillColor, vFullPath.mFillAlpha));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.mRenderPath, paint);
            }
            if (vFullPath.mStrokeColor != 0) {
                if (this.mStrokePaint == null) {
                    this.mStrokePaint = new Paint();
                    this.mStrokePaint.setStyle(Paint.Style.STROKE);
                    this.mStrokePaint.setAntiAlias(true);
                }
                Paint paint2 = this.mStrokePaint;
                if (vFullPath.mStrokeLineJoin != null) {
                    paint2.setStrokeJoin(vFullPath.mStrokeLineJoin);
                }
                if (vFullPath.mStrokeLineCap != null) {
                    paint2.setStrokeCap(vFullPath.mStrokeLineCap);
                }
                paint2.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                paint2.setColor(VectorDrawable.applyAlpha(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(vFullPath.mStrokeWidth * min);
                canvas.drawPath(this.mRenderPath, paint2);
            }
        }

        private void recursiveApplyTheme(VGroup vGroup, Resources.Theme theme) {
            ArrayList<Object> arrayList = vGroup.mChildren;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return;
                }
                Object obj = arrayList.get(i2);
                if (obj instanceof VGroup) {
                    VGroup vGroup2 = (VGroup) obj;
                    if (vGroup2.canApplyTheme()) {
                        vGroup2.applyTheme(theme);
                    }
                    recursiveApplyTheme(vGroup2, theme);
                } else if (obj instanceof VPath) {
                    VPath vPath = (VPath) obj;
                    if (vPath.canApplyTheme()) {
                        vPath.applyTheme(theme);
                    }
                }
                i = i2 + 1;
            }
        }

        private boolean recursiveCanApplyTheme(VGroup vGroup) {
            ArrayList<Object> arrayList = vGroup.mChildren;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    return false;
                }
                Object obj = arrayList.get(i2);
                if (obj instanceof VGroup) {
                    VGroup vGroup2 = (VGroup) obj;
                    if (vGroup2.canApplyTheme() || recursiveCanApplyTheme(vGroup2)) {
                        return true;
                    }
                } else if ((obj instanceof VPath) && ((VPath) obj).canApplyTheme()) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        public void applyTheme(Resources.Theme theme) {
            recursiveApplyTheme(this.mRootGroup, theme);
        }

        public boolean canApplyTheme() {
            return recursiveCanApplyTheme(this.mRootGroup);
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/drawable/VectorDrawable$VectorDrawableState.class */
    public static class VectorDrawableState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        int[] mThemeAttrs;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableState() {
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        public VectorDrawableState(VectorDrawableState vectorDrawableState) {
            this.mTint = null;
            this.mTintMode = Drawable.DEFAULT_TINT_MODE;
            if (vectorDrawableState != null) {
                this.mThemeAttrs = vectorDrawableState.mThemeAttrs;
                this.mChangingConfigurations = vectorDrawableState.mChangingConfigurations;
                this.mVPathRenderer = new VPathRenderer(vectorDrawableState.mVPathRenderer);
                if (vectorDrawableState.mVPathRenderer.mFillPaint != null) {
                    this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableState.mTint;
                this.mTintMode = vectorDrawableState.mTintMode;
                this.mAutoMirrored = vectorDrawableState.mAutoMirrored;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) {
                return (this.mVPathRenderer != null && this.mVPathRenderer.canApplyTheme()) || super.canApplyTheme();
            }
            return true;
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedThemeAttrs == this.mThemeAttrs && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(Rect rect) {
            if (this.mCachedBitmap == null || !canReuseBitmap(rect.width(), rect.height())) {
                this.mCachedBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter) {
            canvas.drawBitmap(this.mCachedBitmap, 0.0f, 0.0f, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (hasTranslucentRoot() || colorFilter != null) {
                if (this.mTempPaint == null) {
                    this.mTempPaint = new Paint();
                    this.mTempPaint.setFilterBitmap(true);
                }
                this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
                this.mTempPaint.setColorFilter(colorFilter);
                return this.mTempPaint;
            }
            return null;
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawable(this);
        }

        public void updateCacheStates() {
            this.mCachedThemeAttrs = this.mThemeAttrs;
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(Rect rect) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), rect.width(), rect.height(), null);
        }
    }

    public VectorDrawable() {
        this.mAllowCaching = true;
        this.mVectorState = new VectorDrawableState();
    }

    private VectorDrawable(VectorDrawableState vectorDrawableState) {
        this.mAllowCaching = true;
        this.mVectorState = vectorDrawableState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int applyAlpha(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    public static VectorDrawable create(Resources resources, int i) {
        int next;
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            VectorDrawable vectorDrawable = new VectorDrawable();
            vectorDrawable.inflate(resources, xml, asAttributeSet);
            return vectorDrawable;
        } catch (IOException e) {
            Log.e(LOGTAG, "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e(LOGTAG, "parser error", e2);
            return null;
        }
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        VectorDrawableState vectorDrawableState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        boolean z2 = true;
        Stack stack = new Stack();
        stack.push(vPathRenderer.mRootGroup);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) stack.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme);
                    vGroup.mChildren.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                    }
                    z = false;
                    vectorDrawableState.mChangingConfigurations |= vFullPath.mChangingConfigurations;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme);
                    vGroup.mChildren.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableState.mChangingConfigurations |= vClipPath.mChangingConfigurations;
                    z = z2;
                } else {
                    z = z2;
                    if ("group".equals(name)) {
                        VGroup vGroup2 = new VGroup();
                        vGroup2.inflate(resources, attributeSet, theme);
                        vGroup.mChildren.add(vGroup2);
                        stack.push(vGroup2);
                        if (vGroup2.getGroupName() != null) {
                            vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                        }
                        vectorDrawableState.mChangingConfigurations |= vGroup2.mChangingConfigurations;
                        z = z2;
                    }
                }
            } else {
                z = z2;
                if (eventType == 3) {
                    z = z2;
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                        z = z2;
                    }
                }
            }
            eventType = xmlPullParser.next();
            z2 = z;
        }
        if (z2) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + ((Object) stringBuffer) + " defined");
        }
    }

    private boolean needMirroring() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    private void printGroupTree(VGroup vGroup, int i) {
        String str = "";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            str = str + "    ";
            i2 = i3 + 1;
        }
        Log.v(LOGTAG, str + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.mRotate);
        Log.v(LOGTAG, str + "matrix is :" + vGroup.getLocalMatrix().toString());
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= vGroup.mChildren.size()) {
                return;
            }
            Object obj = vGroup.mChildren.get(i5);
            if (obj instanceof VGroup) {
                printGroupTree((VGroup) obj, i + 1);
            }
            i4 = i5 + 1;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) throws XmlPullParserException {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        vectorDrawableState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        vectorDrawableState.mThemeAttrs = typedArray.extractThemeAttrs();
        int i = typedArray.getInt(6, -1);
        if (i != -1) {
            vectorDrawableState.mTintMode = Drawable.parseTintMode(i, PorterDuff.Mode.SRC_IN);
        }
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            vectorDrawableState.mTint = colorStateList;
        }
        vectorDrawableState.mAutoMirrored = typedArray.getBoolean(5, vectorDrawableState.mAutoMirrored);
        vPathRenderer.mViewportWidth = typedArray.getFloat(7, vPathRenderer.mViewportWidth);
        vPathRenderer.mViewportHeight = typedArray.getFloat(8, vPathRenderer.mViewportHeight);
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (vPathRenderer.mViewportHeight <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
        vPathRenderer.mBaseHeight = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
        if (vPathRenderer.mBaseWidth <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (vPathRenderer.mBaseHeight <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        vPathRenderer.setAlpha(typedArray.getFloat(4, vPathRenderer.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            vPathRenderer.mRootName = string;
            vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState != null && vectorDrawableState.mThemeAttrs != null) {
            TypedArray resolveAttributes = theme.resolveAttributes(vectorDrawableState.mThemeAttrs, R.styleable.VectorDrawable);
            try {
                try {
                    vectorDrawableState.mCacheDirty = true;
                    updateStateFromTypedArray(resolveAttributes);
                    resolveAttributes.recycle();
                    this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                resolveAttributes.recycle();
                throw th;
            }
        }
        VPathRenderer vPathRenderer = vectorDrawableState.mVPathRenderer;
        if (vPathRenderer == null || !vPathRenderer.canApplyTheme()) {
            return;
        }
        vPathRenderer.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return (this.mVectorState != null && this.mVectorState.canApplyTheme()) || super.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        int save = canvas.save();
        boolean needMirroring = needMirroring();
        canvas.translate(bounds.left, bounds.top);
        if (needMirroring) {
            canvas.translate(bounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        PorterDuffColorFilter porterDuffColorFilter = this.mColorFilter == null ? this.mTintFilter : this.mColorFilter;
        if (this.mAllowCaching) {
            this.mVectorState.createCachedBitmapIfNeeded(bounds);
            if (!this.mVectorState.canReuseCache()) {
                this.mVectorState.updateCachedBitmap(bounds);
                this.mVectorState.updateCacheStates();
            }
            this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, porterDuffColorFilter);
        } else if (this.mVectorState.hasTranslucentRoot()) {
            this.mVectorState.createCachedBitmapIfNeeded(bounds);
            this.mVectorState.updateCachedBitmap(bounds);
            this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, porterDuffColorFilter);
        } else {
            this.mVectorState.mVPathRenderer.draw(canvas, bounds.width(), bounds.height(), porterDuffColorFilter);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mVectorState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getPixelSize() {
        if ((this.mVectorState == null && this.mVectorState.mVPathRenderer == null) || this.mVectorState.mVPathRenderer.mBaseWidth == 0.0f || this.mVectorState.mVPathRenderer.mBaseHeight == 0.0f || this.mVectorState.mVPathRenderer.mViewportHeight == 0.0f || this.mVectorState.mVPathRenderer.mViewportWidth == 0.0f) {
            return 1.0f;
        }
        float f = this.mVectorState.mVPathRenderer.mBaseWidth;
        float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
        return Math.min(this.mVectorState.mVPathRenderer.mViewportWidth / f, this.mVectorState.mVPathRenderer.mViewportHeight / f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getTargetByName(String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        vectorDrawableState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, R.styleable.VectorDrawable);
        updateStateFromTypedArray(obtainAttributes);
        obtainAttributes.recycle();
        vectorDrawableState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        return (this.mVectorState == null || this.mVectorState.mTint == null || !this.mVectorState.mTint.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTint == null || vectorDrawableState.mTintMode == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, vectorDrawableState.mTintMode);
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.mVectorState.mAutoMirrored != z) {
            this.mVectorState.mAutoMirrored = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTint != colorStateList) {
            vectorDrawableState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableState.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        VectorDrawableState vectorDrawableState = this.mVectorState;
        if (vectorDrawableState.mTintMode != mode) {
            vectorDrawableState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableState.mTint, mode);
            invalidateSelf();
        }
    }
}

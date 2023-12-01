package android.animation;

import android.animation.Keyframes;
import android.content.Context;
import android.content.res.ConfigurationBoundResourceCache;
import android.content.res.ConstantState;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.PathParser;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorInflater.class */
public class AnimatorInflater {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int SEQUENTIALLY = 1;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 4;
    private static final int VALUE_TYPE_CUSTOM = 5;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final TypedValue sTmpTypedValue = new TypedValue();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorInflater$PathDataEvaluator.class */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        private PathDataEvaluator() {
        }

        public PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        @Override // android.animation.TypeEvaluator
        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.mNodeArray == null || !PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pathDataNodeArr.length) {
                    return this.mNodeArray;
                }
                this.mNodeArray[i2].interpolatePathDataNode(pathDataNodeArr[i2], pathDataNodeArr2[i2], f);
                i = i2 + 1;
            }
        }
    }

    private static Animator createAnimatorFromXml(Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [android.animation.ValueAnimator] */
    /* JADX WARN: Type inference failed for: r0v43, types: [android.animation.ObjectAnimator] */
    private static Animator createAnimatorFromXml(Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        AnimatorSet animatorSet2;
        AnimatorSet animatorSet3 = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animatorSet2 = loadObjectAnimator(resources, theme, attributeSet, f);
                    } else if (name.equals("animator")) {
                        animatorSet2 = loadAnimator(resources, theme, attributeSet, null, f);
                    } else if (!name.equals("set")) {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    } else {
                        AnimatorSet animatorSet4 = new AnimatorSet();
                        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.AnimatorSet, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.AnimatorSet);
                        animatorSet4.appendChangingConfigurations(obtainStyledAttributes.getChangingConfigurations());
                        createAnimatorFromXml(resources, theme, xmlPullParser, attributeSet, animatorSet4, obtainStyledAttributes.getInt(0, 0), f);
                        obtainStyledAttributes.recycle();
                        animatorSet2 = animatorSet4;
                    }
                    animatorSet3 = animatorSet2;
                    if (animatorSet != null) {
                        ArrayList arrayList2 = arrayList;
                        if (arrayList == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(animatorSet2);
                        animatorSet3 = animatorSet2;
                        arrayList = arrayList2;
                    }
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            int i2 = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i2] = (Animator) it.next();
                i2++;
            }
            if (i != 0) {
                animatorSet.playSequentially(animatorArr);
                return animatorSet3;
            }
            animatorSet.playTogether(animatorArr);
        }
        return animatorSet3;
    }

    private static StateListAnimator createStateListAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws IOException, XmlPullParserException {
        StateListAnimator stateListAnimator = new StateListAnimator();
        while (true) {
            switch (xmlPullParser.next()) {
                case 1:
                case 3:
                    return stateListAnimator;
                case 2:
                    Animator animator = null;
                    if ("item".equals(xmlPullParser.getName())) {
                        int attributeCount = xmlPullParser.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i = 0;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                            if (attributeNameResource == 16843213) {
                                animator = loadAnimator(context, attributeSet.getAttributeResourceValue(i2, 0));
                            } else {
                                int i3 = i + 1;
                                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i] = attributeNameResource;
                                i = i3;
                            }
                        }
                        Animator animator2 = animator;
                        if (animator == null) {
                            animator2 = createAnimatorFromXml(context.getResources(), context.getTheme(), xmlPullParser, 1.0f);
                        }
                        if (animator2 != null) {
                            stateListAnimator.addState(StateSet.trimStateSet(iArr, i), animator2);
                            break;
                        } else {
                            throw new Resources.NotFoundException("animation state item must have a valid animation");
                        }
                    } else {
                        continue;
                    }
            }
        }
    }

    private static int getChangingConfigs(Resources resources, int i) {
        int i2;
        synchronized (sTmpTypedValue) {
            resources.getValue(i, sTmpTypedValue, true);
            i2 = sTmpTypedValue.changingConfigurations;
        }
        return i2;
    }

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        return loadAnimator(context.getResources(), context.getTheme(), i);
    }

    public static Animator loadAnimator(Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return loadAnimator(resources, theme, i, 1.0f);
    }

    public static Animator loadAnimator(Resources resources, Resources.Theme theme, int i, float f) throws Resources.NotFoundException {
        ConfigurationBoundResourceCache<Animator> animatorCache = resources.getAnimatorCache();
        Animator animator = animatorCache.get(i, theme);
        if (animator != null) {
            return animator;
        }
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                XmlResourceParser animation = resources.getAnimation(i);
                Animator createAnimatorFromXml = createAnimatorFromXml(resources, theme, animation, f);
                Animator animator2 = createAnimatorFromXml;
                if (createAnimatorFromXml != null) {
                    createAnimatorFromXml.appendChangingConfigurations(getChangingConfigs(resources, i));
                    ConstantState<Animator> createConstantState = createAnimatorFromXml.createConstantState();
                    animator2 = createAnimatorFromXml;
                    if (createConstantState != null) {
                        animatorCache.put(i, theme, createConstantState);
                        xmlResourceParser3 = animation;
                        xmlResourceParser = animation;
                        xmlResourceParser2 = animation;
                        animator2 = createConstantState.newInstance(resources, theme);
                    }
                }
                if (animation != null) {
                    animation.close();
                }
                return animator2;
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                notFoundException.initCause(e);
                XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private static ValueAnimator loadAnimator(Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f) throws Resources.NotFoundException {
        TypedArray typedArray = null;
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.Animator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.Animator);
        if (valueAnimator != null) {
            TypedArray obtainStyledAttributes2 = theme != null ? theme.obtainStyledAttributes(attributeSet, R.styleable.PropertyAnimator, 0, 0) : resources.obtainAttributes(attributeSet, R.styleable.PropertyAnimator);
            valueAnimator.appendChangingConfigurations(obtainStyledAttributes2.getChangingConfigurations());
            typedArray = obtainStyledAttributes2;
        }
        ValueAnimator valueAnimator2 = valueAnimator;
        if (valueAnimator == null) {
            valueAnimator2 = new ValueAnimator();
        }
        valueAnimator2.appendChangingConfigurations(obtainStyledAttributes.getChangingConfigurations());
        parseAnimatorFromTypeArray(valueAnimator2, obtainStyledAttributes, typedArray, f);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            Interpolator loadInterpolator = AnimationUtils.loadInterpolator(resources, theme, resourceId);
            if (loadInterpolator instanceof BaseInterpolator) {
                valueAnimator2.appendChangingConfigurations(((BaseInterpolator) loadInterpolator).getChangingConfiguration());
            }
            valueAnimator2.setInterpolator(loadInterpolator);
        }
        obtainStyledAttributes.recycle();
        if (typedArray != null) {
            typedArray.recycle();
        }
        return valueAnimator2;
    }

    private static ObjectAnimator loadObjectAnimator(Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(resources, theme, attributeSet, objectAnimator, f);
        return objectAnimator;
    }

    public static StateListAnimator loadStateListAnimator(Context context, int i) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        ConfigurationBoundResourceCache<StateListAnimator> stateListAnimatorCache = resources.getStateListAnimatorCache();
        Resources.Theme theme = context.getTheme();
        StateListAnimator stateListAnimator = stateListAnimatorCache.get(i, theme);
        if (stateListAnimator != null) {
            return stateListAnimator;
        }
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser xmlResourceParser3 = null;
        try {
            try {
                XmlResourceParser animation = resources.getAnimation(i);
                StateListAnimator createStateListAnimatorFromXml = createStateListAnimatorFromXml(context, animation, Xml.asAttributeSet(animation));
                StateListAnimator stateListAnimator2 = createStateListAnimatorFromXml;
                if (createStateListAnimatorFromXml != null) {
                    createStateListAnimatorFromXml.appendChangingConfigurations(getChangingConfigs(resources, i));
                    ConstantState<StateListAnimator> createConstantState = createStateListAnimatorFromXml.createConstantState();
                    stateListAnimator2 = createStateListAnimatorFromXml;
                    if (createConstantState != null) {
                        stateListAnimatorCache.put(i, theme, createConstantState);
                        xmlResourceParser3 = animation;
                        xmlResourceParser = animation;
                        xmlResourceParser2 = animation;
                        stateListAnimator2 = createConstantState.newInstance(resources, theme);
                    }
                }
                if (animation != null) {
                    animation.close();
                }
                return stateListAnimator2;
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load state list animator resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser4 = xmlResourceParser2;
                notFoundException.initCause(e);
                XmlResourceParser xmlResourceParser5 = xmlResourceParser2;
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load state list animator resource ID #0x" + Integer.toHexString(i));
                XmlResourceParser xmlResourceParser6 = xmlResourceParser3;
                notFoundException2.initCause(e2);
                XmlResourceParser xmlResourceParser7 = xmlResourceParser3;
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (r13 <= 31) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseAnimatorFromTypeArray(android.animation.ValueAnimator r8, android.content.res.TypedArray r9, android.content.res.TypedArray r10, float r11) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.animation.AnimatorInflater.parseAnimatorFromTypeArray(android.animation.ValueAnimator, android.content.res.TypedArray, android.content.res.TypedArray, float):void");
    }

    private static TypeEvaluator setupAnimatorForPath(ValueAnimator valueAnimator, TypedArray typedArray) {
        PathDataEvaluator pathDataEvaluator;
        String string = typedArray.getString(5);
        String string2 = typedArray.getString(6);
        PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
        PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
        if (createNodesFromPathData != null) {
            if (createNodesFromPathData2 != null) {
                valueAnimator.setObjectValues(createNodesFromPathData, createNodesFromPathData2);
                if (!PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                    throw new InflateException(typedArray.getPositionDescription() + " Can't morph from " + string + " to " + string2);
                }
            } else {
                valueAnimator.setObjectValues(createNodesFromPathData);
            }
            pathDataEvaluator = new PathDataEvaluator(PathParser.deepCopyNodes(createNodesFromPathData));
        } else {
            pathDataEvaluator = null;
            if (createNodesFromPathData2 != null) {
                valueAnimator.setObjectValues(createNodesFromPathData2);
                return new PathDataEvaluator(PathParser.deepCopyNodes(createNodesFromPathData2));
            }
        }
        return pathDataEvaluator;
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, boolean z, float f) {
        Keyframes.FloatKeyframes createXIntKeyframes;
        Keyframes.FloatKeyframes createYIntKeyframes;
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String string = typedArray.getString(1);
        if (string == null) {
            objectAnimator.setPropertyName(typedArray.getString(0));
            return;
        }
        String string2 = typedArray.getString(2);
        String string3 = typedArray.getString(3);
        if (string2 == null && string3 == null) {
            throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
        }
        PathKeyframes ofPath = KeyframeSet.ofPath(PathParser.createPathFromPathData(string), 0.5f * f);
        if (z) {
            createXIntKeyframes = ofPath.createXFloatKeyframes();
            createYIntKeyframes = ofPath.createYFloatKeyframes();
        } else {
            createXIntKeyframes = ofPath.createXIntKeyframes();
            createYIntKeyframes = ofPath.createYIntKeyframes();
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (string2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofKeyframes(string2, createXIntKeyframes);
        }
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (string3 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofKeyframes(string3, createYIntKeyframes);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else {
            objectAnimator.setValues(propertyValuesHolder, propertyValuesHolder2);
        }
    }

    private static void setupValues(ValueAnimator valueAnimator, TypedArray typedArray, boolean z, boolean z2, int i, boolean z3, int i2) {
        if (z) {
            if (!z2) {
                valueAnimator.setFloatValues(i2 == 5 ? typedArray.getDimension(6, 0.0f) : typedArray.getFloat(6, 0.0f));
                return;
            }
            float dimension = i == 5 ? typedArray.getDimension(5, 0.0f) : typedArray.getFloat(5, 0.0f);
            if (z3) {
                valueAnimator.setFloatValues(dimension, i2 == 5 ? typedArray.getDimension(6, 0.0f) : typedArray.getFloat(6, 0.0f));
            } else {
                valueAnimator.setFloatValues(dimension);
            }
        } else if (!z2) {
            if (z3) {
                valueAnimator.setIntValues(i2 == 5 ? (int) typedArray.getDimension(6, 0.0f) : (i2 < 28 || i2 > 31) ? typedArray.getInt(6, 0) : typedArray.getColor(6, 0));
            }
        } else {
            int dimension2 = i == 5 ? (int) typedArray.getDimension(5, 0.0f) : (i < 28 || i > 31) ? typedArray.getInt(5, 0) : typedArray.getColor(5, 0);
            if (z3) {
                valueAnimator.setIntValues(dimension2, i2 == 5 ? (int) typedArray.getDimension(6, 0.0f) : (i2 < 28 || i2 > 31) ? typedArray.getInt(6, 0) : typedArray.getColor(6, 0));
            } else {
                valueAnimator.setIntValues(dimension2);
            }
        }
    }
}

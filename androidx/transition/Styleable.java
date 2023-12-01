package androidx.transition;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable.class */
class Styleable {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f3419a = {android.R.attr.targetClass, android.R.attr.targetId, android.R.attr.excludeId, android.R.attr.excludeClass, android.R.attr.targetName, android.R.attr.excludeName};
    static final int[] b = {android.R.attr.fromScene, android.R.attr.toScene, android.R.attr.transition};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f3420c = {android.R.attr.interpolator, android.R.attr.duration, android.R.attr.startDelay, android.R.attr.matchOrder};
    static final int[] d = {android.R.attr.resizeClip};
    static final int[] e = {android.R.attr.transitionVisibilityMode};
    static final int[] f = {android.R.attr.fadingMode};
    static final int[] g = {android.R.attr.reparent, android.R.attr.reparentWithOverlay};
    static final int[] h = {android.R.attr.slideEdge};
    static final int[] i = {android.R.attr.transitionOrdering};
    static final int[] j = {android.R.attr.minimumHorizontalAngle, android.R.attr.minimumVerticalAngle, android.R.attr.maximumAngle};
    static final int[] k = {android.R.attr.patternPathData};

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$ArcMotion.class */
    interface ArcMotion {
        public static final int MAXIMUM_ANGLE = 2;
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$ChangeBounds.class */
    interface ChangeBounds {
        public static final int RESIZE_CLIP = 0;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$ChangeTransform.class */
    interface ChangeTransform {
        public static final int REPARENT = 0;
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$Fade.class */
    interface Fade {
        public static final int FADING_MODE = 0;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$PatternPathMotion.class */
    interface PatternPathMotion {
        public static final int PATTERN_PATH_DATA = 0;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$Slide.class */
    interface Slide {
        public static final int SLIDE_EDGE = 0;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$Transition.class */
    interface Transition {
        public static final int DURATION = 1;
        public static final int INTERPOLATOR = 0;
        public static final int MATCH_ORDER = 3;
        public static final int START_DELAY = 2;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$TransitionManager.class */
    interface TransitionManager {
        public static final int FROM_SCENE = 0;
        public static final int TO_SCENE = 1;
        public static final int TRANSITION = 2;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$TransitionSet.class */
    interface TransitionSet {
        public static final int TRANSITION_ORDERING = 0;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$TransitionTarget.class */
    interface TransitionTarget {
        public static final int EXCLUDE_CLASS = 3;
        public static final int EXCLUDE_ID = 2;
        public static final int EXCLUDE_NAME = 5;
        public static final int TARGET_CLASS = 0;
        public static final int TARGET_ID = 1;
        public static final int TARGET_NAME = 4;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Styleable$VisibilityTransition.class */
    interface VisibilityTransition {
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    private Styleable() {
    }
}

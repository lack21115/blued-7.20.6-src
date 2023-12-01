package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues.class */
public interface TypedValues {
    public static final int BOOLEAN_MASK = 1;
    public static final int FLOAT_MASK = 4;
    public static final int INT_MASK = 2;
    public static final int STRING_MASK = 8;
    public static final String S_CUSTOM = "CUSTOM";
    public static final int TYPE_FRAME_POSITION = 100;
    public static final int TYPE_TARGET = 101;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$AttributesType.class */
    public interface AttributesType {
        public static final String NAME = "KeyAttributes";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_CUSTOM = "CUSTOM";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final int TYPE_ALPHA = 303;
        public static final int TYPE_CURVE_FIT = 301;
        public static final int TYPE_EASING = 317;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 316;
        public static final int TYPE_PIVOT_TARGET = 318;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 302;
        public static final String S_FRAME = "frame";
        public static final String S_TARGET = "target";
        public static final String S_PIVOT_TARGET = "pivotTarget";
        public static final String[] KEY_WORDS = {"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "CUSTOM", S_FRAME, S_TARGET, S_PIVOT_TARGET};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$AttributesType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$AttributesType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1310311125:
                        if (str.equals("easing")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320804:
                        if (str.equals("rotationZ")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -987906986:
                        if (str.equals("pivotX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -987906985:
                        if (str.equals("pivotY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -880905839:
                        if (str.equals(AttributesType.S_TARGET)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 97692013:
                        if (str.equals(AttributesType.S_FRAME)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 579057826:
                        if (str.equals("curveFit")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 803192288:
                        if (str.equals("pathRotate")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1167159411:
                        if (str.equals(AttributesType.S_PIVOT_TARGET)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1941332754:
                        if (str.equals("visibility")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 301;
                    case true:
                        return 302;
                    case true:
                        return 303;
                    case true:
                        return 304;
                    case true:
                        return 305;
                    case true:
                        return 306;
                    case true:
                        return 307;
                    case true:
                        return 308;
                    case true:
                        return 309;
                    case true:
                        return 310;
                    case true:
                        return 311;
                    case true:
                        return 312;
                    case true:
                        return 313;
                    case true:
                        return 314;
                    case true:
                        return 315;
                    case true:
                        return 316;
                    case true:
                        return 317;
                    case true:
                        return 100;
                    case true:
                        return 101;
                    case true:
                        return 318;
                    default:
                        return -1;
                }
            }

            public static int getType(int i) {
                if (i != 100) {
                    if (i != 101) {
                        switch (i) {
                            case 301:
                            case 302:
                                return 2;
                            case 303:
                            case 304:
                            case 305:
                            case 306:
                            case 307:
                            case 308:
                            case 309:
                            case 310:
                            case 311:
                            case 312:
                            case 313:
                            case 314:
                            case 315:
                            case 316:
                                return 4;
                            case 317:
                            case 318:
                                return 8;
                            default:
                                return -1;
                        }
                    }
                    return 8;
                }
                return 2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$Custom.class */
    public interface Custom {
        public static final String NAME = "Custom";
        public static final String S_COLOR = "color";
        public static final String S_INT = "integer";
        public static final String S_STRING = "string";
        public static final int TYPE_BOOLEAN = 904;
        public static final int TYPE_COLOR = 902;
        public static final int TYPE_DIMENSION = 905;
        public static final int TYPE_FLOAT = 901;
        public static final int TYPE_INT = 900;
        public static final int TYPE_REFERENCE = 906;
        public static final int TYPE_STRING = 903;
        public static final String S_FLOAT = "float";
        public static final String S_BOOLEAN = "boolean";
        public static final String S_DIMENSION = "dimension";
        public static final String S_REFERENCE = "refrence";
        public static final String[] KEY_WORDS = {S_FLOAT, "color", "string", S_BOOLEAN, S_DIMENSION, S_REFERENCE};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$Custom$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$Custom$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1095013018:
                        if (str.equals(Custom.S_DIMENSION)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -891985903:
                        if (str.equals("string")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -710953590:
                        if (str.equals(Custom.S_REFERENCE)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 64711720:
                        if (str.equals(Custom.S_BOOLEAN)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 94842723:
                        if (str.equals("color")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 97526364:
                        if (str.equals(Custom.S_FLOAT)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1958052158:
                        if (str.equals(Custom.S_INT)) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 900;
                    case true:
                        return 901;
                    case true:
                        return 902;
                    case true:
                        return 903;
                    case true:
                        return 904;
                    case true:
                        return 905;
                    case true:
                        return Custom.TYPE_REFERENCE;
                    default:
                        return -1;
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$CycleType.class */
    public interface CycleType {
        public static final String NAME = "KeyCycle";
        public static final String S_ALPHA = "alpha";
        public static final String S_CURVE_FIT = "curveFit";
        public static final String S_EASING = "easing";
        public static final String S_ELEVATION = "elevation";
        public static final String S_PATH_ROTATE = "pathRotate";
        public static final String S_PIVOT_X = "pivotX";
        public static final String S_PIVOT_Y = "pivotY";
        public static final String S_PROGRESS = "progress";
        public static final String S_ROTATION_X = "rotationX";
        public static final String S_ROTATION_Y = "rotationY";
        public static final String S_ROTATION_Z = "rotationZ";
        public static final String S_SCALE_X = "scaleX";
        public static final String S_SCALE_Y = "scaleY";
        public static final String S_TRANSLATION_X = "translationX";
        public static final String S_TRANSLATION_Y = "translationY";
        public static final String S_TRANSLATION_Z = "translationZ";
        public static final String S_VISIBILITY = "visibility";
        public static final String S_WAVE_OFFSET = "offset";
        public static final String S_WAVE_PERIOD = "period";
        public static final String S_WAVE_SHAPE = "waveShape";
        public static final int TYPE_ALPHA = 403;
        public static final int TYPE_CURVE_FIT = 401;
        public static final int TYPE_CUSTOM_WAVE_SHAPE = 422;
        public static final int TYPE_EASING = 420;
        public static final int TYPE_ELEVATION = 307;
        public static final int TYPE_PATH_ROTATE = 416;
        public static final int TYPE_PIVOT_X = 313;
        public static final int TYPE_PIVOT_Y = 314;
        public static final int TYPE_PROGRESS = 315;
        public static final int TYPE_ROTATION_X = 308;
        public static final int TYPE_ROTATION_Y = 309;
        public static final int TYPE_ROTATION_Z = 310;
        public static final int TYPE_SCALE_X = 311;
        public static final int TYPE_SCALE_Y = 312;
        public static final int TYPE_TRANSLATION_X = 304;
        public static final int TYPE_TRANSLATION_Y = 305;
        public static final int TYPE_TRANSLATION_Z = 306;
        public static final int TYPE_VISIBILITY = 402;
        public static final int TYPE_WAVE_OFFSET = 424;
        public static final int TYPE_WAVE_PERIOD = 423;
        public static final int TYPE_WAVE_PHASE = 425;
        public static final int TYPE_WAVE_SHAPE = 421;
        public static final String S_CUSTOM_WAVE_SHAPE = "customWave";
        public static final String S_WAVE_PHASE = "phase";
        public static final String[] KEY_WORDS = {"curveFit", "visibility", "alpha", "translationX", "translationY", "translationZ", "elevation", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "pivotX", "pivotY", "progress", "pathRotate", "easing", "waveShape", S_CUSTOM_WAVE_SHAPE, "period", "offset", S_WAVE_PHASE};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$CycleType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$CycleType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1310311125:
                        if (str.equals("easing")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1249320804:
                        if (str.equals("rotationZ")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -987906986:
                        if (str.equals("pivotX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -987906985:
                        if (str.equals("pivotY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 579057826:
                        if (str.equals("curveFit")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 803192288:
                        if (str.equals("pathRotate")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1941332754:
                        if (str.equals("visibility")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 401;
                    case true:
                        return 402;
                    case true:
                        return 403;
                    case true:
                        return 304;
                    case true:
                        return 305;
                    case true:
                        return 306;
                    case true:
                        return 308;
                    case true:
                        return 309;
                    case true:
                        return 310;
                    case true:
                        return 311;
                    case true:
                        return 312;
                    case true:
                        return 313;
                    case true:
                        return 314;
                    case true:
                        return 315;
                    case true:
                        return 416;
                    case true:
                        return 420;
                    default:
                        return -1;
                }
            }

            public static int getType(int i) {
                if (i != 100) {
                    if (i != 101) {
                        if (i != 416) {
                            if (i == 420 || i == 421) {
                                return 8;
                            }
                            switch (i) {
                                case 304:
                                case 305:
                                case 306:
                                case 307:
                                case 308:
                                case 309:
                                case 310:
                                case 311:
                                case 312:
                                case 313:
                                case 314:
                                case 315:
                                    return 4;
                                default:
                                    switch (i) {
                                        case 401:
                                        case 402:
                                            return 2;
                                        case 403:
                                            return 4;
                                        default:
                                            switch (i) {
                                                case 423:
                                                case 424:
                                                case 425:
                                                    return 4;
                                                default:
                                                    return -1;
                                            }
                                    }
                            }
                        }
                        return 4;
                    }
                    return 8;
                }
                return 2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$MotionScene.class */
    public interface MotionScene {
        public static final String NAME = "MotionScene";
        public static final int TYPE_DEFAULT_DURATION = 600;
        public static final int TYPE_LAYOUT_DURING_TRANSITION = 601;
        public static final String S_DEFAULT_DURATION = "defaultDuration";
        public static final String S_LAYOUT_DURING_TRANSITION = "layoutDuringTransition";
        public static final String[] KEY_WORDS = {S_DEFAULT_DURATION, S_LAYOUT_DURING_TRANSITION};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$MotionScene$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$MotionScene$-CC.class */
        public final /* synthetic */ class CC {
            public static int getId(String str) {
                boolean z;
                int hashCode = str.hashCode();
                if (hashCode != 6076149) {
                    if (hashCode == 1028758976 && str.equals(MotionScene.S_LAYOUT_DURING_TRANSITION)) {
                        z = true;
                    }
                    z = true;
                } else {
                    if (str.equals(MotionScene.S_DEFAULT_DURATION)) {
                        z = false;
                    }
                    z = true;
                }
                if (z) {
                    return !z ? -1 : 601;
                }
                return 600;
            }

            public static int getType(int i) {
                if (i != 600) {
                    return i != 601 ? -1 : 1;
                }
                return 2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$MotionType.class */
    public interface MotionType {
        public static final String NAME = "Motion";
        public static final int TYPE_ANIMATE_CIRCLEANGLE_TO = 606;
        public static final int TYPE_ANIMATE_RELATIVE_TO = 605;
        public static final int TYPE_DRAW_PATH = 608;
        public static final int TYPE_EASING = 603;
        public static final int TYPE_PATHMOTION_ARC = 607;
        public static final int TYPE_PATH_ROTATE = 601;
        public static final int TYPE_POLAR_RELATIVETO = 609;
        public static final int TYPE_QUANTIZE_INTERPOLATOR = 604;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_ID = 612;
        public static final int TYPE_QUANTIZE_INTERPOLATOR_TYPE = 611;
        public static final int TYPE_QUANTIZE_MOTIONSTEPS = 610;
        public static final int TYPE_QUANTIZE_MOTION_PHASE = 602;
        public static final int TYPE_STAGGER = 600;
        public static final String S_STAGGER = "Stagger";
        public static final String S_PATH_ROTATE = "PathRotate";
        public static final String S_QUANTIZE_MOTION_PHASE = "QuantizeMotionPhase";
        public static final String S_EASING = "TransitionEasing";
        public static final String S_QUANTIZE_INTERPOLATOR = "QuantizeInterpolator";
        public static final String S_ANIMATE_RELATIVE_TO = "AnimateRelativeTo";
        public static final String S_ANIMATE_CIRCLEANGLE_TO = "AnimateCircleAngleTo";
        public static final String S_PATHMOTION_ARC = "PathMotionArc";
        public static final String S_DRAW_PATH = "DrawPath";
        public static final String S_POLAR_RELATIVETO = "PolarRelativeTo";
        public static final String S_QUANTIZE_MOTIONSTEPS = "QuantizeMotionSteps";
        public static final String S_QUANTIZE_INTERPOLATOR_TYPE = "QuantizeInterpolatorType";
        public static final String S_QUANTIZE_INTERPOLATOR_ID = "QuantizeInterpolatorID";
        public static final String[] KEY_WORDS = {S_STAGGER, S_PATH_ROTATE, S_QUANTIZE_MOTION_PHASE, S_EASING, S_QUANTIZE_INTERPOLATOR, S_ANIMATE_RELATIVE_TO, S_ANIMATE_CIRCLEANGLE_TO, S_PATHMOTION_ARC, S_DRAW_PATH, S_POLAR_RELATIVETO, S_QUANTIZE_MOTIONSTEPS, S_QUANTIZE_INTERPOLATOR_TYPE, S_QUANTIZE_INTERPOLATOR_ID};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$MotionType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$MotionType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -2033446275:
                        if (str.equals(MotionType.S_ANIMATE_CIRCLEANGLE_TO)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1532277420:
                        if (str.equals(MotionType.S_QUANTIZE_MOTION_PHASE)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1529145600:
                        if (str.equals(MotionType.S_QUANTIZE_MOTIONSTEPS)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1498310144:
                        if (str.equals(MotionType.S_PATH_ROTATE)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1030753096:
                        if (str.equals(MotionType.S_QUANTIZE_INTERPOLATOR)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -762370135:
                        if (str.equals(MotionType.S_DRAW_PATH)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -232872051:
                        if (str.equals(MotionType.S_STAGGER)) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 1138491429:
                        if (str.equals(MotionType.S_POLAR_RELATIVETO)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1539234834:
                        if (str.equals(MotionType.S_QUANTIZE_INTERPOLATOR_TYPE)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1583722451:
                        if (str.equals(MotionType.S_QUANTIZE_INTERPOLATOR_ID)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1639368448:
                        if (str.equals(MotionType.S_EASING)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1900899336:
                        if (str.equals(MotionType.S_ANIMATE_RELATIVE_TO)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 2109694967:
                        if (str.equals(MotionType.S_PATHMOTION_ARC)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 600;
                    case true:
                        return 601;
                    case true:
                        return 602;
                    case true:
                        return 603;
                    case true:
                        return 604;
                    case true:
                        return 605;
                    case true:
                        return 606;
                    case true:
                        return 607;
                    case true:
                        return 608;
                    case true:
                        return 609;
                    case true:
                        return 610;
                    case true:
                        return 611;
                    case true:
                        return 612;
                    default:
                        return -1;
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$OnSwipe.class */
    public interface OnSwipe {
        public static final String AUTOCOMPLETE_MODE = "autocompletemode";
        public static final String DRAG_DIRECTION = "dragdirection";
        public static final String DRAG_SCALE = "dragscale";
        public static final String DRAG_THRESHOLD = "dragthreshold";
        public static final String LIMIT_BOUNDS_TO = "limitboundsto";
        public static final String MAX_ACCELERATION = "maxacceleration";
        public static final String MAX_VELOCITY = "maxvelocity";
        public static final String MOVE_WHEN_SCROLLAT_TOP = "movewhenscrollattop";
        public static final String NESTED_SCROLL_FLAGS = "nestedscrollflags";
        public static final String ON_TOUCH_UP = "ontouchup";
        public static final String ROTATION_CENTER_ID = "rotationcenterid";
        public static final String SPRINGS_TOP_THRESHOLD = "springstopthreshold";
        public static final String SPRING_BOUNDARY = "springboundary";
        public static final String SPRING_DAMPING = "springdamping";
        public static final String SPRING_MASS = "springmass";
        public static final String SPRING_STIFFNESS = "springstiffness";
        public static final String TOUCH_ANCHOR_ID = "touchanchorid";
        public static final String TOUCH_ANCHOR_SIDE = "touchanchorside";
        public static final String TOUCH_REGION_ID = "touchregionid";
        public static final String[] ON_TOUCH_UP_ENUM = {"autoComplete", "autoCompleteToStart", "autoCompleteToEnd", "stop", "decelerate", "decelerateAndComplete", "neverCompleteToStart", "neverCompleteToEnd"};
        public static final String[] SPRING_BOUNDARY_ENUM = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        public static final String[] AUTOCOMPLETE_MODE_ENUM = {"continuousVelocity", "spring"};
        public static final String[] NESTED_SCROLL_FLAGS_ENUM = {"none", "disablePostScroll", "disableScroll", "supportScrollUp"};
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$PositionType.class */
    public interface PositionType {
        public static final String[] KEY_WORDS = {"transitionEasing", "drawPath", "percentWidth", "percentHeight", "sizePercent", "percentX", "percentY"};
        public static final String NAME = "KeyPosition";
        public static final String S_DRAWPATH = "drawPath";
        public static final String S_PERCENT_HEIGHT = "percentHeight";
        public static final String S_PERCENT_WIDTH = "percentWidth";
        public static final String S_PERCENT_X = "percentX";
        public static final String S_PERCENT_Y = "percentY";
        public static final String S_SIZE_PERCENT = "sizePercent";
        public static final String S_TRANSITION_EASING = "transitionEasing";
        public static final int TYPE_CURVE_FIT = 508;
        public static final int TYPE_DRAWPATH = 502;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_PERCENT_HEIGHT = 504;
        public static final int TYPE_PERCENT_WIDTH = 503;
        public static final int TYPE_PERCENT_X = 506;
        public static final int TYPE_PERCENT_Y = 507;
        public static final int TYPE_POSITION_TYPE = 510;
        public static final int TYPE_SIZE_PERCENT = 505;
        public static final int TYPE_TRANSITION_EASING = 501;

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$PositionType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$PositionType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1812823328:
                        if (str.equals("transitionEasing")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case -1127236479:
                        if (str.equals("percentWidth")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1017587252:
                        if (str.equals("percentHeight")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -827014263:
                        if (str.equals("drawPath")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -200259324:
                        if (str.equals("sizePercent")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 428090547:
                        if (str.equals("percentX")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 428090548:
                        if (str.equals("percentY")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 501;
                    case true:
                        return 502;
                    case true:
                        return 503;
                    case true:
                        return 504;
                    case true:
                        return 505;
                    case true:
                        return 506;
                    case true:
                        return 507;
                    default:
                        return -1;
                }
            }

            public static int getType(int i) {
                if (i != 100) {
                    if (i != 101) {
                        switch (i) {
                            case 501:
                            case 502:
                                return 8;
                            case 503:
                            case 504:
                            case 505:
                            case 506:
                            case 507:
                                return 4;
                            case 508:
                                return 2;
                            default:
                                return -1;
                        }
                    }
                    return 8;
                }
                return 2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$TransitionType.class */
    public interface TransitionType {
        public static final String NAME = "Transitions";
        public static final String S_DURATION = "duration";
        public static final String S_FROM = "from";
        public static final String S_TO = "to";
        public static final int TYPE_AUTO_TRANSITION = 704;
        public static final int TYPE_DURATION = 700;
        public static final int TYPE_FROM = 701;
        public static final int TYPE_INTERPOLATOR = 705;
        public static final int TYPE_PATH_MOTION_ARC = 509;
        public static final int TYPE_STAGGERED = 706;
        public static final int TYPE_TO = 702;
        public static final int TYPE_TRANSITION_FLAGS = 707;
        public static final String S_PATH_MOTION_ARC = "pathMotionArc";
        public static final String S_AUTO_TRANSITION = "autoTransition";
        public static final String S_INTERPOLATOR = "motionInterpolator";
        public static final String S_STAGGERED = "staggered";
        public static final String S_TRANSITION_FLAGS = "transitionFlags";
        public static final String[] KEY_WORDS = {"duration", "from", "to", S_PATH_MOTION_ARC, S_AUTO_TRANSITION, S_INTERPOLATOR, S_STAGGERED, "from", S_TRANSITION_FLAGS};

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$TransitionType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$TransitionType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1996906958:
                        if (str.equals(TransitionType.S_TRANSITION_FLAGS)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1992012396:
                        if (str.equals("duration")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case -1357874275:
                        if (str.equals(TransitionType.S_INTERPOLATOR)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1298065308:
                        if (str.equals(TransitionType.S_AUTO_TRANSITION)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 3707:
                        if (str.equals("to")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 3151786:
                        if (str.equals("from")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1310733335:
                        if (str.equals(TransitionType.S_PATH_MOTION_ARC)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1839260940:
                        if (str.equals(TransitionType.S_STAGGERED)) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 700;
                    case true:
                        return 701;
                    case true:
                        return 702;
                    case true:
                        return 509;
                    case true:
                        return 704;
                    case true:
                        return 705;
                    case true:
                        return 706;
                    case true:
                        return 707;
                    default:
                        return -1;
                }
            }

            public static int getType(int i) {
                if (i != 509) {
                    switch (i) {
                        case 700:
                            return 2;
                        case 701:
                        case 702:
                            return 8;
                        default:
                            switch (i) {
                                case 705:
                                case 707:
                                    return 8;
                                case 706:
                                    return 4;
                                default:
                                    return -1;
                            }
                    }
                }
                return 2;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$TriggerType.class */
    public interface TriggerType {
        public static final String CROSS = "CROSS";
        public static final String[] KEY_WORDS = {"viewTransitionOnCross", "viewTransitionOnPositiveCross", "viewTransitionOnNegativeCross", "postLayout", "triggerSlack", "triggerCollisionView", "triggerCollisionId", "triggerID", "positiveCross", "negativeCross", "triggerReceiver", "CROSS"};
        public static final String NAME = "KeyTrigger";
        public static final String NEGATIVE_CROSS = "negativeCross";
        public static final String POSITIVE_CROSS = "positiveCross";
        public static final String POST_LAYOUT = "postLayout";
        public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
        public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
        public static final String TRIGGER_ID = "triggerID";
        public static final String TRIGGER_RECEIVER = "triggerReceiver";
        public static final String TRIGGER_SLACK = "triggerSlack";
        public static final int TYPE_CROSS = 312;
        public static final int TYPE_NEGATIVE_CROSS = 310;
        public static final int TYPE_POSITIVE_CROSS = 309;
        public static final int TYPE_POST_LAYOUT = 304;
        public static final int TYPE_TRIGGER_COLLISION_ID = 307;
        public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
        public static final int TYPE_TRIGGER_ID = 308;
        public static final int TYPE_TRIGGER_RECEIVER = 311;
        public static final int TYPE_TRIGGER_SLACK = 305;
        public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
        public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
        public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
        public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
        public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
        public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";

        /* renamed from: androidx.constraintlayout.core.motion.utils.TypedValues$TriggerType$-CC  reason: invalid class name */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedValues$TriggerType$-CC.class */
        public final /* synthetic */ class CC {
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public static int getId(String str) {
                boolean z;
                switch (str.hashCode()) {
                    case -1594793529:
                        if (str.equals("positiveCross")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -966421266:
                        if (str.equals("viewTransitionOnPositiveCross")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -786670827:
                        if (str.equals("triggerCollisionId")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -648752941:
                        if (str.equals("triggerID")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -638126837:
                        if (str.equals("negativeCross")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -76025313:
                        if (str.equals("triggerCollisionView")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -9754574:
                        if (str.equals("viewTransitionOnNegativeCross")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 64397344:
                        if (str.equals("CROSS")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 364489912:
                        if (str.equals("triggerSlack")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1301930599:
                        if (str.equals("viewTransitionOnCross")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 1401391082:
                        if (str.equals("postLayout")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1535404999:
                        if (str.equals("triggerReceiver")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        return 301;
                    case true:
                        return 302;
                    case true:
                        return 303;
                    case true:
                        return 304;
                    case true:
                        return 305;
                    case true:
                        return 306;
                    case true:
                        return 307;
                    case true:
                        return 308;
                    case true:
                        return 309;
                    case true:
                        return 310;
                    case true:
                        return 311;
                    case true:
                        return 312;
                    default:
                        return -1;
                }
            }
        }
    }

    int getId(String str);

    boolean setValue(int i, float f);

    boolean setValue(int i, int i2);

    boolean setValue(int i, String str);

    boolean setValue(int i, boolean z);
}

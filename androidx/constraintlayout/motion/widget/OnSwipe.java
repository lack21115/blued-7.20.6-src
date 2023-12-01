package androidx.constraintlayout.motion.widget;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/OnSwipe.class */
public class OnSwipe {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    public static final int DRAG_ANTICLOCKWISE = 7;
    public static final int DRAG_CLOCKWISE = 6;
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_END = 5;
    public static final int DRAG_LEFT = 2;
    public static final int DRAG_RIGHT = 3;
    public static final int DRAG_START = 4;
    public static final int DRAG_UP = 0;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int ON_UP_AUTOCOMPLETE = 0;
    public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
    public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
    public static final int ON_UP_DECELERATE = 4;
    public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int ON_UP_NEVER_TO_END = 7;
    public static final int ON_UP_NEVER_TO_START = 6;
    public static final int ON_UP_STOP = 3;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final int SPRING_BOUNDARY_BOUNCEBOTH = 3;
    public static final int SPRING_BOUNDARY_BOUNCEEND = 2;
    public static final int SPRING_BOUNDARY_BOUNCESTART = 1;
    public static final int SPRING_BOUNDARY_OVERSHOOT = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f2211a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2212c = -1;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private int g = -1;
    private float h = 4.0f;
    private float i = 1.2f;
    private boolean j = true;
    private float k = 1.0f;
    private int l = 0;
    private float m = 10.0f;
    private float n = Float.NaN;
    private float o = 1.0f;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private int r = 0;
    private int s = 0;

    public int getAutoCompleteMode() {
        return this.s;
    }

    public int getDragDirection() {
        return this.f2211a;
    }

    public float getDragScale() {
        return this.k;
    }

    public float getDragThreshold() {
        return this.m;
    }

    public int getLimitBoundsTo() {
        return this.e;
    }

    public float getMaxAcceleration() {
        return this.i;
    }

    public float getMaxVelocity() {
        return this.h;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.j;
    }

    public int getNestedScrollFlags() {
        return this.l;
    }

    public int getOnTouchUp() {
        return this.f;
    }

    public int getRotationCenterId() {
        return this.g;
    }

    public int getSpringBoundary() {
        return this.r;
    }

    public float getSpringDamping() {
        return this.n;
    }

    public float getSpringMass() {
        return this.o;
    }

    public float getSpringStiffness() {
        return this.p;
    }

    public float getSpringStopThreshold() {
        return this.q;
    }

    public int getTouchAnchorId() {
        return this.f2212c;
    }

    public int getTouchAnchorSide() {
        return this.b;
    }

    public int getTouchRegionId() {
        return this.d;
    }

    public void setAutoCompleteMode(int i) {
        this.s = i;
    }

    public OnSwipe setDragDirection(int i) {
        this.f2211a = i;
        return this;
    }

    public OnSwipe setDragScale(int i) {
        this.k = i;
        return this;
    }

    public OnSwipe setDragThreshold(int i) {
        this.m = i;
        return this;
    }

    public OnSwipe setLimitBoundsTo(int i) {
        this.e = i;
        return this;
    }

    public OnSwipe setMaxAcceleration(int i) {
        this.i = i;
        return this;
    }

    public OnSwipe setMaxVelocity(int i) {
        this.h = i;
        return this;
    }

    public OnSwipe setMoveWhenScrollAtTop(boolean z) {
        this.j = z;
        return this;
    }

    public OnSwipe setNestedScrollFlags(int i) {
        this.l = i;
        return this;
    }

    public OnSwipe setOnTouchUp(int i) {
        this.f = i;
        return this;
    }

    public OnSwipe setRotateCenter(int i) {
        this.g = i;
        return this;
    }

    public OnSwipe setSpringBoundary(int i) {
        this.r = i;
        return this;
    }

    public OnSwipe setSpringDamping(float f) {
        this.n = f;
        return this;
    }

    public OnSwipe setSpringMass(float f) {
        this.o = f;
        return this;
    }

    public OnSwipe setSpringStiffness(float f) {
        this.p = f;
        return this;
    }

    public OnSwipe setSpringStopThreshold(float f) {
        this.q = f;
        return this;
    }

    public OnSwipe setTouchAnchorId(int i) {
        this.f2212c = i;
        return this;
    }

    public OnSwipe setTouchAnchorSide(int i) {
        this.b = i;
        return this;
    }

    public OnSwipe setTouchRegionId(int i) {
        this.d = i;
        return this;
    }
}

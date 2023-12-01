package android.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.ArrayMap;
import android.view.GhostView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionCoordinator.class */
public abstract class ActivityTransitionCoordinator extends ResultReceiver {
    protected static final String KEY_ELEVATION = "shared_element:elevation";
    protected static final String KEY_IMAGE_MATRIX = "shared_element:imageMatrix";
    static final String KEY_REMOTE_RECEIVER = "android:remoteReceiver";
    protected static final String KEY_SCALE_TYPE = "shared_element:scaleType";
    protected static final String KEY_SCREEN_BOTTOM = "shared_element:screenBottom";
    protected static final String KEY_SCREEN_LEFT = "shared_element:screenLeft";
    protected static final String KEY_SCREEN_RIGHT = "shared_element:screenRight";
    protected static final String KEY_SCREEN_TOP = "shared_element:screenTop";
    protected static final String KEY_SNAPSHOT = "shared_element:bitmap";
    protected static final String KEY_TRANSLATION_Z = "shared_element:translationZ";
    public static final int MSG_CANCEL = 106;
    public static final int MSG_EXIT_TRANSITION_COMPLETE = 104;
    public static final int MSG_HIDE_SHARED_ELEMENTS = 101;
    public static final int MSG_SEND_SHARED_ELEMENT_DESTINATION = 108;
    public static final int MSG_SET_REMOTE_RECEIVER = 100;
    public static final int MSG_SHARED_ELEMENT_DESTINATION = 107;
    public static final int MSG_START_EXIT_TRANSITION = 105;
    public static final int MSG_TAKE_SHARED_ELEMENTS = 103;
    protected static final ImageView.ScaleType[] SCALE_TYPE_VALUES = ImageView.ScaleType.values();
    private static final String TAG = "ActivityTransitionCoordinator";
    protected final ArrayList<String> mAllSharedElementNames;
    private final FixedEpicenterCallback mEpicenterCallback;
    private ArrayList<GhostViewListeners> mGhostViewListeners;
    protected final boolean mIsReturning;
    private boolean mIsStartingTransition;
    protected SharedElementCallback mListener;
    private ArrayMap<View, Float> mOriginalAlphas;
    private Runnable mPendingTransition;
    protected ResultReceiver mResultReceiver;
    private final ArrayList<View> mRootSharedElements;
    protected final ArrayList<String> mSharedElementNames;
    private ArrayList<Matrix> mSharedElementParentMatrices;
    protected final ArrayList<View> mSharedElements;
    protected ArrayList<View> mTransitioningViews;
    private Window mWindow;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionCoordinator$ContinueTransitionListener.class */
    protected class ContinueTransitionListener extends Transition.TransitionListenerAdapter {
        /* JADX INFO: Access modifiers changed from: protected */
        public ContinueTransitionListener() {
        }

        @Override // android.transition.Transition.TransitionListenerAdapter, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            ActivityTransitionCoordinator.this.mIsStartingTransition = false;
            Runnable runnable = ActivityTransitionCoordinator.this.mPendingTransition;
            ActivityTransitionCoordinator.this.mPendingTransition = null;
            if (runnable != null) {
                ActivityTransitionCoordinator.this.startTransition(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionCoordinator$FixedEpicenterCallback.class */
    public static class FixedEpicenterCallback extends Transition.EpicenterCallback {
        private Rect mEpicenter;

        private FixedEpicenterCallback() {
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.mEpicenter;
        }

        public void setEpicenter(Rect rect) {
            this.mEpicenter = rect;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionCoordinator$GhostViewListeners.class */
    private static class GhostViewListeners implements ViewTreeObserver.OnPreDrawListener {
        private ViewGroup mDecor;
        private Matrix mMatrix = new Matrix();
        private View mParent;
        private View mView;

        public GhostViewListeners(View view, View view2, ViewGroup viewGroup) {
            this.mView = view;
            this.mParent = view2;
            this.mDecor = viewGroup;
        }

        public View getView() {
            return this.mView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            GhostView ghost = GhostView.getGhost(this.mView);
            if (ghost == null) {
                this.mParent.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            GhostView.calculateMatrix(this.mView, this.mDecor, this.mMatrix);
            ghost.setMatrix(this.mMatrix);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityTransitionCoordinator$SharedElementOriginalState.class */
    public static class SharedElementOriginalState {
        int mBottom;
        float mElevation;
        int mLeft;
        Matrix mMatrix;
        int mMeasuredHeight;
        int mMeasuredWidth;
        int mRight;
        ImageView.ScaleType mScaleType;
        int mTop;
        float mTranslationZ;

        SharedElementOriginalState() {
        }
    }

    public ActivityTransitionCoordinator(Window window, ArrayList<String> arrayList, SharedElementCallback sharedElementCallback, boolean z) {
        super(new Handler());
        this.mSharedElements = new ArrayList<>();
        this.mSharedElementNames = new ArrayList<>();
        this.mTransitioningViews = new ArrayList<>();
        this.mEpicenterCallback = new FixedEpicenterCallback();
        this.mGhostViewListeners = new ArrayList<>();
        this.mOriginalAlphas = new ArrayMap<>();
        this.mRootSharedElements = new ArrayList<>();
        this.mWindow = window;
        this.mListener = sharedElementCallback;
        this.mAllSharedElementNames = arrayList;
        this.mIsReturning = z;
    }

    private static SharedElementOriginalState getOldSharedElementState(View view, String str, Bundle bundle) {
        Bundle bundle2;
        SharedElementOriginalState sharedElementOriginalState = new SharedElementOriginalState();
        sharedElementOriginalState.mLeft = view.getLeft();
        sharedElementOriginalState.mTop = view.getTop();
        sharedElementOriginalState.mRight = view.getRight();
        sharedElementOriginalState.mBottom = view.getBottom();
        sharedElementOriginalState.mMeasuredWidth = view.getMeasuredWidth();
        sharedElementOriginalState.mMeasuredHeight = view.getMeasuredHeight();
        sharedElementOriginalState.mTranslationZ = view.getTranslationZ();
        sharedElementOriginalState.mElevation = view.getElevation();
        if ((view instanceof ImageView) && (bundle2 = bundle.getBundle(str)) != null && bundle2.getInt(KEY_SCALE_TYPE, -1) >= 0) {
            ImageView imageView = (ImageView) view;
            sharedElementOriginalState.mScaleType = imageView.getScaleType();
            if (sharedElementOriginalState.mScaleType == ImageView.ScaleType.MATRIX) {
                sharedElementOriginalState.mMatrix = new Matrix(imageView.getImageMatrix());
                return sharedElementOriginalState;
            }
        }
        return sharedElementOriginalState;
    }

    private void getSharedElementParentMatrix(View view, Matrix matrix) {
        boolean z;
        if (!this.mRootSharedElements.contains(view)) {
            z = true;
        } else {
            int indexOf = this.mSharedElementParentMatrices == null ? -1 : this.mSharedElements.indexOf(view);
            if (indexOf < 0) {
                z = true;
            } else {
                matrix.set(this.mSharedElementParentMatrices.get(indexOf));
                z = false;
            }
        }
        if (z) {
            matrix.reset();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).transformMatrixToLocal(matrix);
            }
        }
    }

    public static boolean isInTransitionGroup(ViewParent viewParent, ViewGroup viewGroup) {
        if (viewParent == viewGroup || !(viewParent instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewParent;
        if (viewGroup2.isTransitionGroup()) {
            return true;
        }
        return isInTransitionGroup(viewGroup2.getParent(), viewGroup);
    }

    private static boolean isNested(View view, ArrayMap<String, View> arrayMap) {
        boolean z;
        ViewParent parent = view.getParent();
        while (true) {
            z = false;
            if (!(parent instanceof View)) {
                break;
            }
            View view2 = (View) parent;
            if (arrayMap.containsValue(view2)) {
                z = true;
                break;
            }
            parent = view2.getParent();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Transition mergeTransitions(Transition transition, Transition transition2) {
        if (transition == null) {
            return transition2;
        }
        if (transition2 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    private static int scaleTypeToInt(ImageView.ScaleType scaleType) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= SCALE_TYPE_VALUES.length) {
                return -1;
            }
            if (scaleType == SCALE_TYPE_VALUES[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void setEpicenter(View view) {
        if (view == null) {
            this.mEpicenterCallback.setEpicenter(null);
            return;
        }
        Rect rect = new Rect();
        view.getBoundsOnScreen(rect);
        this.mEpicenterCallback.setEpicenter(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void setOriginalSharedElementState(ArrayList<View> arrayList, ArrayList<SharedElementOriginalState> arrayList2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList2.size()) {
                return;
            }
            View view = arrayList.get(i2);
            SharedElementOriginalState sharedElementOriginalState = arrayList2.get(i2);
            if ((view instanceof ImageView) && sharedElementOriginalState.mScaleType != null) {
                ImageView imageView = (ImageView) view;
                imageView.setScaleType(sharedElementOriginalState.mScaleType);
                if (sharedElementOriginalState.mScaleType == ImageView.ScaleType.MATRIX) {
                    imageView.setImageMatrix(sharedElementOriginalState.mMatrix);
                }
            }
            view.setElevation(sharedElementOriginalState.mElevation);
            view.setTranslationZ(sharedElementOriginalState.mTranslationZ);
            view.measure(View.MeasureSpec.makeMeasureSpec(sharedElementOriginalState.mMeasuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(sharedElementOriginalState.mMeasuredHeight, 1073741824));
            view.layout(sharedElementOriginalState.mLeft, sharedElementOriginalState.mTop, sharedElementOriginalState.mRight, sharedElementOriginalState.mBottom);
            i = i2 + 1;
        }
    }

    private void setSharedElementMatrices() {
        int size = this.mSharedElements.size();
        if (size > 0) {
            this.mSharedElementParentMatrices = new ArrayList<>(size);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.mSharedElements.get(i2).getParent();
            Matrix matrix = new Matrix();
            viewGroup.transformMatrixToLocal(matrix);
            this.mSharedElementParentMatrices.add(matrix);
            i = i2 + 1;
        }
    }

    private void setSharedElementState(View view, String str, Bundle bundle, Matrix matrix, RectF rectF, int[] iArr) {
        float scrollX;
        float scrollY;
        float f;
        float f2;
        int i;
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return;
        }
        if ((view instanceof ImageView) && (i = bundle2.getInt(KEY_SCALE_TYPE, -1)) >= 0) {
            ImageView imageView = (ImageView) view;
            ImageView.ScaleType scaleType = SCALE_TYPE_VALUES[i];
            imageView.setScaleType(scaleType);
            if (scaleType == ImageView.ScaleType.MATRIX) {
                matrix.setValues(bundle2.getFloatArray(KEY_IMAGE_MATRIX));
                imageView.setImageMatrix(matrix);
            }
        }
        view.setTranslationZ(bundle2.getFloat(KEY_TRANSLATION_Z));
        view.setElevation(bundle2.getFloat(KEY_ELEVATION));
        float f3 = bundle2.getFloat(KEY_SCREEN_LEFT);
        float f4 = bundle2.getFloat(KEY_SCREEN_TOP);
        float f5 = bundle2.getFloat(KEY_SCREEN_RIGHT);
        float f6 = bundle2.getFloat(KEY_SCREEN_BOTTOM);
        if (iArr != null) {
            scrollX = f3 - iArr[0];
            scrollY = f4 - iArr[1];
            f = f5 - iArr[0];
            f2 = f6 - iArr[1];
        } else {
            getSharedElementParentMatrix(view, matrix);
            rectF.set(f3, f4, f5, f6);
            matrix.mapRect(rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            view.getInverseMatrix().mapRect(rectF);
            float width = rectF.width();
            float height = rectF.height();
            view.setLeft(0);
            view.setTop(0);
            view.setRight(Math.round(width));
            view.setBottom(Math.round(height));
            rectF.set(0.0f, 0.0f, width, height);
            view.getMatrix().mapRect(rectF);
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            scrollX = (f7 - rectF.left) + viewGroup.getScrollX();
            scrollY = (f8 - rectF.top) + viewGroup.getScrollY();
            f = scrollX + width;
            f2 = scrollY + height;
        }
        int round = Math.round(scrollX);
        int round2 = Math.round(scrollY);
        int round3 = Math.round(f) - round;
        int round4 = Math.round(f2) - round2;
        view.measure(View.MeasureSpec.makeMeasureSpec(round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round4, 1073741824));
        view.layout(round, round2, round + round3, round2 + round4);
    }

    private void setSharedElements(ArrayMap<String, View> arrayMap) {
        boolean z = true;
        while (true) {
            boolean z2 = z;
            if (arrayMap.isEmpty()) {
                return;
            }
            int size = arrayMap.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    View valueAt = arrayMap.valueAt(i);
                    String keyAt = arrayMap.keyAt(i);
                    if (z2 && (valueAt == null || !valueAt.isAttachedToWindow() || keyAt == null)) {
                        arrayMap.removeAt(i);
                    } else if (!isNested(valueAt, arrayMap)) {
                        this.mSharedElementNames.add(keyAt);
                        this.mSharedElements.add(valueAt);
                        arrayMap.removeAt(i);
                        if (z2) {
                            this.mRootSharedElements.add(valueAt);
                        }
                    }
                    size = i;
                }
            }
            z = false;
        }
    }

    private void showView(View view, boolean z) {
        Float remove = this.mOriginalAlphas.remove(view);
        if (remove != null) {
            view.setAlpha(remove.floatValue());
        }
        if (z) {
            view.setTransitionAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cancelPendingTransitions() {
        this.mPendingTransition = null;
        return this.mIsStartingTransition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle captureSharedElementState() {
        Bundle bundle = new Bundle();
        RectF rectF = new RectF();
        Matrix matrix = new Matrix();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSharedElements.size()) {
                return bundle;
            }
            captureSharedElementState(this.mSharedElements.get(i2), this.mSharedElementNames.get(i2), bundle, matrix, rectF);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void captureSharedElementState(View view, String str, Bundle bundle, Matrix matrix, RectF rectF) {
        Bundle bundle2 = new Bundle();
        matrix.reset();
        view.transformMatrixToGlobal(matrix);
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        bundle2.putFloat(KEY_SCREEN_LEFT, rectF.left);
        bundle2.putFloat(KEY_SCREEN_RIGHT, rectF.right);
        bundle2.putFloat(KEY_SCREEN_TOP, rectF.top);
        bundle2.putFloat(KEY_SCREEN_BOTTOM, rectF.bottom);
        bundle2.putFloat(KEY_TRANSLATION_Z, view.getTranslationZ());
        bundle2.putFloat(KEY_ELEVATION, view.getElevation());
        Parcelable parcelable = null;
        if (this.mListener != null) {
            parcelable = this.mListener.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }
        if (parcelable != null) {
            bundle2.putParcelable(KEY_SNAPSHOT, parcelable);
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            bundle2.putInt(KEY_SCALE_TYPE, scaleTypeToInt(imageView.getScaleType()));
            if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                float[] fArr = new float[9];
                imageView.getImageMatrix().getValues(fArr);
                bundle2.putFloatArray(KEY_IMAGE_MATRIX, fArr);
            }
        }
        bundle.putBundle(str, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearState() {
        this.mWindow = null;
        this.mSharedElements.clear();
        this.mTransitioningViews = null;
        this.mOriginalAlphas.clear();
        this.mResultReceiver = null;
        this.mPendingTransition = null;
        this.mListener = null;
        this.mRootSharedElements.clear();
        this.mSharedElementParentMatrices = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Transition configureTransition(Transition transition, boolean z) {
        Transition transition2 = transition;
        if (transition != null) {
            Transition mo996clone = transition.mo996clone();
            mo996clone.setEpicenterCallback(this.mEpicenterCallback);
            transition2 = setTargets(mo996clone, z);
        }
        return transition2;
    }

    public ArrayList<View> copyMappedViews() {
        return new ArrayList<>(this.mSharedElements);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<View> createSnapshots(Bundle bundle, Collection<String> collection) {
        int size = collection.size();
        ArrayList<View> arrayList = new ArrayList<>(size);
        if (size != 0) {
            Context context = getWindow().getContext();
            int[] iArr = new int[2];
            ViewGroup decor = getDecor();
            if (decor != null) {
                decor.getLocationOnScreen(iArr);
            }
            Matrix matrix = new Matrix();
            for (String str : collection) {
                Bundle bundle2 = bundle.getBundle(str);
                View view = null;
                if (bundle2 != null) {
                    Parcelable parcelable = bundle2.getParcelable(KEY_SNAPSHOT);
                    View view2 = null;
                    if (parcelable != null) {
                        view2 = null;
                        if (this.mListener != null) {
                            view2 = this.mListener.onCreateSnapshotView(context, parcelable);
                        }
                    }
                    view = view2;
                    if (view2 != null) {
                        setSharedElementState(view2, str, bundle, matrix, null, iArr);
                        view = view2;
                    }
                }
                arrayList.add(view);
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAcceptedNames() {
        return this.mSharedElementNames;
    }

    public ArrayList<String> getAllSharedElementNames() {
        return this.mAllSharedElementNames;
    }

    public ViewGroup getDecor() {
        if (this.mWindow == null) {
            return null;
        }
        return (ViewGroup) this.mWindow.getDecorView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getFadeDuration() {
        return getWindow().getTransitionBackgroundFadeDuration();
    }

    public ArrayList<String> getMappedNames() {
        ArrayList<String> arrayList = new ArrayList<>(this.mSharedElements.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSharedElements.size()) {
                return arrayList;
            }
            arrayList.add(this.mSharedElements.get(i2).getTransitionName());
            i = i2 + 1;
        }
    }

    protected abstract Transition getViewsTransition();

    /* JADX INFO: Access modifiers changed from: protected */
    public Window getWindow() {
        return this.mWindow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideViews(ArrayList<View> arrayList) {
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View view = arrayList.get(i2);
            if (!this.mOriginalAlphas.containsKey(view)) {
                this.mOriginalAlphas.put(view, Float.valueOf(view.getAlpha()));
            }
            view.setAlpha(0.0f);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayMap<String, View> mapSharedElements(ArrayList<String> arrayList, ArrayList<View> arrayList2) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                arrayMap.put(arrayList.get(i2), arrayList2.get(i2));
                i = i2 + 1;
            }
        } else {
            ViewGroup decor = getDecor();
            if (decor != null) {
                decor.findNamedViews(arrayMap);
            }
        }
        return arrayMap;
    }

    protected boolean moveSharedElementWithParent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void moveSharedElementsFromOverlay() {
        ViewGroup decor;
        int size = this.mGhostViewListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            GhostViewListeners ghostViewListeners = this.mGhostViewListeners.get(i2);
            ((ViewGroup) ghostViewListeners.getView().getParent()).getViewTreeObserver().removeOnPreDrawListener(ghostViewListeners);
            i = i2 + 1;
        }
        this.mGhostViewListeners.clear();
        if (this.mWindow == null || !this.mWindow.getSharedElementsUseOverlay() || (decor = getDecor()) == null) {
            return;
        }
        decor.getOverlay();
        int size2 = this.mSharedElements.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                return;
            }
            GhostView.removeGhost(this.mSharedElements.get(i4));
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void moveSharedElementsToOverlay() {
        if (this.mWindow == null || !this.mWindow.getSharedElementsUseOverlay()) {
            return;
        }
        setSharedElementMatrices();
        int size = this.mSharedElements.size();
        ViewGroup decor = getDecor();
        if (decor == null) {
            return;
        }
        boolean moveSharedElementWithParent = moveSharedElementWithParent();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View view = this.mSharedElements.get(i2);
            GhostView.addGhost(view, decor);
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (moveSharedElementWithParent && !isInTransitionGroup(viewGroup, decor)) {
                GhostViewListeners ghostViewListeners = new GhostViewListeners(view, viewGroup, decor);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(ghostViewListeners);
                this.mGhostViewListeners.add(ghostViewListeners);
            }
            i = i2 + 1;
        }
    }

    protected void notifySharedElementEnd(ArrayList<View> arrayList) {
        if (this.mListener != null) {
            this.mListener.onSharedElementEnd(this.mSharedElementNames, this.mSharedElements, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scheduleGhostVisibilityChange(final int i) {
        final ViewGroup decor = getDecor();
        if (decor != null) {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.ActivityTransitionCoordinator.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    ActivityTransitionCoordinator.this.setGhostVisibility(i);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scheduleSetSharedElementEnd(final ArrayList<View> arrayList) {
        final ViewGroup decor = getDecor();
        if (decor != null) {
            decor.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.app.ActivityTransitionCoordinator.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    decor.getViewTreeObserver().removeOnPreDrawListener(this);
                    ActivityTransitionCoordinator.this.notifySharedElementEnd(arrayList);
                    return true;
                }
            });
        }
    }

    protected void setEpicenter() {
        View view = null;
        if (!this.mAllSharedElementNames.isEmpty()) {
            view = null;
            if (!this.mSharedElementNames.isEmpty()) {
                int indexOf = this.mSharedElementNames.indexOf(this.mAllSharedElementNames.get(0));
                view = null;
                if (indexOf >= 0) {
                    view = this.mSharedElements.get(indexOf);
                }
            }
        }
        setEpicenter(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGhostVisibility(int i) {
        int size = this.mSharedElements.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            GhostView ghost = GhostView.getGhost(this.mSharedElements.get(i3));
            if (ghost != null) {
                ghost.setVisibility(i);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setResultReceiver(ResultReceiver resultReceiver) {
        this.mResultReceiver = resultReceiver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<SharedElementOriginalState> setSharedElementState(Bundle bundle, ArrayList<View> arrayList) {
        ArrayList<SharedElementOriginalState> arrayList2 = new ArrayList<>();
        if (bundle != null) {
            Matrix matrix = new Matrix();
            RectF rectF = new RectF();
            int size = this.mSharedElements.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                View view = this.mSharedElements.get(i2);
                String str = this.mSharedElementNames.get(i2);
                arrayList2.add(getOldSharedElementState(view, str, bundle));
                setSharedElementState(view, str, bundle, matrix, rectF, null);
                i = i2 + 1;
            }
        }
        if (this.mListener != null) {
            this.mListener.onSharedElementStart(this.mSharedElementNames, this.mSharedElements, arrayList);
        }
        return arrayList2;
    }

    protected Transition setTargets(Transition transition, boolean z) {
        TransitionSet transitionSet;
        if (transition == null || (z && (this.mTransitioningViews == null || this.mTransitioningViews.isEmpty()))) {
            transitionSet = null;
        } else {
            TransitionSet transitionSet2 = new TransitionSet();
            if (this.mTransitioningViews != null) {
                int size = this.mTransitioningViews.size();
                while (true) {
                    int i = size - 1;
                    if (i < 0) {
                        break;
                    }
                    View view = this.mTransitioningViews.get(i);
                    if (z) {
                        transitionSet2.addTarget(view);
                    } else {
                        transitionSet2.excludeTarget(view, true);
                    }
                    size = i;
                }
            }
            transitionSet2.addTransition(transition);
            transitionSet = transitionSet2;
            if (!z) {
                transitionSet = transitionSet2;
                if (this.mTransitioningViews != null) {
                    transitionSet = transitionSet2;
                    if (!this.mTransitioningViews.isEmpty()) {
                        return new TransitionSet().addTransition(transitionSet2);
                    }
                }
            }
        }
        return transitionSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showViews(ArrayList<View> arrayList, boolean z) {
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            showView(arrayList.get(i2), z);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startTransition(Runnable runnable) {
        if (this.mIsStartingTransition) {
            this.mPendingTransition = runnable;
            return;
        }
        this.mIsStartingTransition = true;
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stripOffscreenViews() {
        if (this.mTransitioningViews == null) {
            return;
        }
        Rect rect = new Rect();
        int size = this.mTransitioningViews.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            View view = this.mTransitioningViews.get(i);
            if (!view.getGlobalVisibleRect(rect)) {
                this.mTransitioningViews.remove(i);
                showView(view, true);
            }
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transitionStarted() {
        this.mIsStartingTransition = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void viewsReady(ArrayMap<String, View> arrayMap) {
        arrayMap.retainAll(this.mAllSharedElementNames);
        if (this.mListener != null) {
            this.mListener.onMapSharedElements(this.mAllSharedElementNames, arrayMap);
        }
        setSharedElements(arrayMap);
        if (getViewsTransition() != null && this.mTransitioningViews != null) {
            ViewGroup decor = getDecor();
            if (decor != null) {
                decor.captureTransitioningViews(this.mTransitioningViews);
            }
            this.mTransitioningViews.removeAll(this.mSharedElements);
        }
        setEpicenter();
    }
}

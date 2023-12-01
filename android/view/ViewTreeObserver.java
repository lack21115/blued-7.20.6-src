package android.view;

import android.graphics.Rect;
import android.graphics.Region;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver.class */
public final class ViewTreeObserver {
    private boolean mAlive = true;
    private CopyOnWriteArray<OnComputeInternalInsetsListener> mOnComputeInternalInsetsListeners;
    private ArrayList<OnDrawListener> mOnDrawListeners;
    private CopyOnWriteArrayList<OnEnterAnimationCompleteListener> mOnEnterAnimationCompleteListeners;
    private CopyOnWriteArrayList<OnGlobalFocusChangeListener> mOnGlobalFocusListeners;
    private CopyOnWriteArray<OnGlobalLayoutListener> mOnGlobalLayoutListeners;
    private CopyOnWriteArray<OnPreDrawListener> mOnPreDrawListeners;
    private CopyOnWriteArray<OnScrollChangedListener> mOnScrollChangedListeners;
    private CopyOnWriteArrayList<OnTouchModeChangeListener> mOnTouchModeChangeListeners;
    private CopyOnWriteArrayList<OnWindowAttachListener> mOnWindowAttachListeners;
    private CopyOnWriteArrayList<OnWindowFocusChangeListener> mOnWindowFocusListeners;
    private CopyOnWriteArray<OnWindowShownListener> mOnWindowShownListeners;
    private boolean mWindowShown;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$CopyOnWriteArray.class */
    public static class CopyOnWriteArray<T> {
        private ArrayList<T> mDataCopy;
        private boolean mStart;
        private ArrayList<T> mData = new ArrayList<>();
        private final Access<T> mAccess = new Access<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$CopyOnWriteArray$Access.class */
        public static class Access<T> {
            private ArrayList<T> mData;
            private int mSize;

            Access() {
            }

            T get(int i) {
                return this.mData.get(i);
            }

            int size() {
                return this.mSize;
            }
        }

        CopyOnWriteArray() {
        }

        private ArrayList<T> getArray() {
            if (this.mStart) {
                if (this.mDataCopy == null) {
                    this.mDataCopy = new ArrayList<>(this.mData);
                }
                return this.mDataCopy;
            }
            return this.mData;
        }

        void add(T t) {
            getArray().add(t);
        }

        void addAll(CopyOnWriteArray<T> copyOnWriteArray) {
            getArray().addAll(copyOnWriteArray.mData);
        }

        void clear() {
            getArray().clear();
        }

        void end() {
            if (!this.mStart) {
                throw new IllegalStateException("Iteration not started");
            }
            this.mStart = false;
            if (this.mDataCopy != null) {
                this.mData = this.mDataCopy;
                ((Access) this.mAccess).mData.clear();
                ((Access) this.mAccess).mSize = 0;
            }
            this.mDataCopy = null;
        }

        void remove(T t) {
            getArray().remove(t);
        }

        int size() {
            return getArray().size();
        }

        Access<T> start() {
            if (this.mStart) {
                throw new IllegalStateException("Iteration already started");
            }
            this.mStart = true;
            this.mDataCopy = null;
            ((Access) this.mAccess).mData = this.mData;
            ((Access) this.mAccess).mSize = this.mData.size();
            return this.mAccess;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$InternalInsetsInfo.class */
    public static final class InternalInsetsInfo {
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        int mTouchableInsets;
        public final Rect contentInsets = new Rect();
        public final Rect visibleInsets = new Rect();
        public final Region touchableRegion = new Region();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            InternalInsetsInfo internalInsetsInfo = (InternalInsetsInfo) obj;
            return this.mTouchableInsets == internalInsetsInfo.mTouchableInsets && this.contentInsets.equals(internalInsetsInfo.contentInsets) && this.visibleInsets.equals(internalInsetsInfo.visibleInsets) && this.touchableRegion.equals(internalInsetsInfo.touchableRegion);
        }

        public int hashCode() {
            return (((((this.contentInsets.hashCode() * 31) + this.visibleInsets.hashCode()) * 31) + this.touchableRegion.hashCode()) * 31) + this.mTouchableInsets;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.contentInsets.isEmpty() && this.visibleInsets.isEmpty() && this.touchableRegion.isEmpty() && this.mTouchableInsets == 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            this.contentInsets.setEmpty();
            this.visibleInsets.setEmpty();
            this.touchableRegion.setEmpty();
            this.mTouchableInsets = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void set(InternalInsetsInfo internalInsetsInfo) {
            this.contentInsets.set(internalInsetsInfo.contentInsets);
            this.visibleInsets.set(internalInsetsInfo.visibleInsets);
            this.touchableRegion.set(internalInsetsInfo.touchableRegion);
            this.mTouchableInsets = internalInsetsInfo.mTouchableInsets;
        }

        public void setTouchableInsets(int i) {
            this.mTouchableInsets = i;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnComputeInternalInsetsListener.class */
    public interface OnComputeInternalInsetsListener {
        void onComputeInternalInsets(InternalInsetsInfo internalInsetsInfo);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnDrawListener.class */
    public interface OnDrawListener {
        void onDraw();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnEnterAnimationCompleteListener.class */
    public interface OnEnterAnimationCompleteListener {
        void onEnterAnimationComplete();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnGlobalFocusChangeListener.class */
    public interface OnGlobalFocusChangeListener {
        void onGlobalFocusChanged(View view, View view2);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnGlobalLayoutListener.class */
    public interface OnGlobalLayoutListener {
        void onGlobalLayout();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnPreDrawListener.class */
    public interface OnPreDrawListener {
        boolean onPreDraw();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnScrollChangedListener.class */
    public interface OnScrollChangedListener {
        void onScrollChanged();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnTouchModeChangeListener.class */
    public interface OnTouchModeChangeListener {
        void onTouchModeChanged(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnWindowAttachListener.class */
    public interface OnWindowAttachListener {
        void onWindowAttached();

        void onWindowDetached();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnWindowFocusChangeListener.class */
    public interface OnWindowFocusChangeListener {
        void onWindowFocusChanged(boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewTreeObserver$OnWindowShownListener.class */
    public interface OnWindowShownListener {
        void onWindowShown();
    }

    private void checkIsAlive() {
        if (!this.mAlive) {
            throw new IllegalStateException("This ViewTreeObserver is not alive, call getViewTreeObserver() again");
        }
    }

    private void kill() {
        this.mAlive = false;
    }

    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener onComputeInternalInsetsListener) {
        checkIsAlive();
        if (this.mOnComputeInternalInsetsListeners == null) {
            this.mOnComputeInternalInsetsListeners = new CopyOnWriteArray<>();
        }
        this.mOnComputeInternalInsetsListeners.add(onComputeInternalInsetsListener);
    }

    public void addOnDrawListener(OnDrawListener onDrawListener) {
        checkIsAlive();
        if (this.mOnDrawListeners == null) {
            this.mOnDrawListeners = new ArrayList<>();
        }
        this.mOnDrawListeners.add(onDrawListener);
    }

    public void addOnEnterAnimationCompleteListener(OnEnterAnimationCompleteListener onEnterAnimationCompleteListener) {
        checkIsAlive();
        if (this.mOnEnterAnimationCompleteListeners == null) {
            this.mOnEnterAnimationCompleteListeners = new CopyOnWriteArrayList<>();
        }
        this.mOnEnterAnimationCompleteListeners.add(onEnterAnimationCompleteListener);
    }

    public void addOnGlobalFocusChangeListener(OnGlobalFocusChangeListener onGlobalFocusChangeListener) {
        checkIsAlive();
        if (this.mOnGlobalFocusListeners == null) {
            this.mOnGlobalFocusListeners = new CopyOnWriteArrayList<>();
        }
        this.mOnGlobalFocusListeners.add(onGlobalFocusChangeListener);
    }

    public void addOnGlobalLayoutListener(OnGlobalLayoutListener onGlobalLayoutListener) {
        checkIsAlive();
        if (this.mOnGlobalLayoutListeners == null) {
            this.mOnGlobalLayoutListeners = new CopyOnWriteArray<>();
        }
        this.mOnGlobalLayoutListeners.add(onGlobalLayoutListener);
    }

    public void addOnPreDrawListener(OnPreDrawListener onPreDrawListener) {
        checkIsAlive();
        if (this.mOnPreDrawListeners == null) {
            this.mOnPreDrawListeners = new CopyOnWriteArray<>();
        }
        this.mOnPreDrawListeners.add(onPreDrawListener);
    }

    public void addOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        checkIsAlive();
        if (this.mOnScrollChangedListeners == null) {
            this.mOnScrollChangedListeners = new CopyOnWriteArray<>();
        }
        this.mOnScrollChangedListeners.add(onScrollChangedListener);
    }

    public void addOnTouchModeChangeListener(OnTouchModeChangeListener onTouchModeChangeListener) {
        checkIsAlive();
        if (this.mOnTouchModeChangeListeners == null) {
            this.mOnTouchModeChangeListeners = new CopyOnWriteArrayList<>();
        }
        this.mOnTouchModeChangeListeners.add(onTouchModeChangeListener);
    }

    public void addOnWindowAttachListener(OnWindowAttachListener onWindowAttachListener) {
        checkIsAlive();
        if (this.mOnWindowAttachListeners == null) {
            this.mOnWindowAttachListeners = new CopyOnWriteArrayList<>();
        }
        this.mOnWindowAttachListeners.add(onWindowAttachListener);
    }

    public void addOnWindowFocusChangeListener(OnWindowFocusChangeListener onWindowFocusChangeListener) {
        checkIsAlive();
        if (this.mOnWindowFocusListeners == null) {
            this.mOnWindowFocusListeners = new CopyOnWriteArrayList<>();
        }
        this.mOnWindowFocusListeners.add(onWindowFocusChangeListener);
    }

    public void addOnWindowShownListener(OnWindowShownListener onWindowShownListener) {
        checkIsAlive();
        if (this.mOnWindowShownListeners == null) {
            this.mOnWindowShownListeners = new CopyOnWriteArray<>();
        }
        this.mOnWindowShownListeners.add(onWindowShownListener);
        if (this.mWindowShown) {
            onWindowShownListener.onWindowShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnComputeInternalInsets(InternalInsetsInfo internalInsetsInfo) {
        CopyOnWriteArray<OnComputeInternalInsetsListener> copyOnWriteArray = this.mOnComputeInternalInsetsListeners;
        if (copyOnWriteArray == null || copyOnWriteArray.size() <= 0) {
            return;
        }
        CopyOnWriteArray.Access<OnComputeInternalInsetsListener> start = copyOnWriteArray.start();
        try {
            int size = start.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                start.get(i2).onComputeInternalInsets(internalInsetsInfo);
                i = i2 + 1;
            }
        } finally {
            copyOnWriteArray.end();
        }
    }

    public final void dispatchOnDraw() {
        if (this.mOnDrawListeners == null) {
            return;
        }
        ArrayList<OnDrawListener> arrayList = this.mOnDrawListeners;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).onDraw();
            i = i2 + 1;
        }
    }

    public final void dispatchOnEnterAnimationComplete() {
        CopyOnWriteArrayList<OnEnterAnimationCompleteListener> copyOnWriteArrayList = this.mOnEnterAnimationCompleteListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<OnEnterAnimationCompleteListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onEnterAnimationComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnGlobalFocusChange(View view, View view2) {
        CopyOnWriteArrayList<OnGlobalFocusChangeListener> copyOnWriteArrayList = this.mOnGlobalFocusListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<OnGlobalFocusChangeListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onGlobalFocusChanged(view, view2);
        }
    }

    public final void dispatchOnGlobalLayout() {
        CopyOnWriteArray<OnGlobalLayoutListener> copyOnWriteArray = this.mOnGlobalLayoutListeners;
        if (copyOnWriteArray == null || copyOnWriteArray.size() <= 0) {
            return;
        }
        CopyOnWriteArray.Access<OnGlobalLayoutListener> start = copyOnWriteArray.start();
        try {
            int size = start.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                start.get(i2).onGlobalLayout();
                i = i2 + 1;
            }
        } finally {
            copyOnWriteArray.end();
        }
    }

    public final boolean dispatchOnPreDraw() {
        CopyOnWriteArray<OnPreDrawListener> copyOnWriteArray = this.mOnPreDrawListeners;
        boolean z = false;
        if (copyOnWriteArray != null) {
            z = false;
            if (copyOnWriteArray.size() > 0) {
                CopyOnWriteArray.Access<OnPreDrawListener> start = copyOnWriteArray.start();
                try {
                    int size = start.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        z |= !start.get(i).onPreDraw();
                    }
                } finally {
                    copyOnWriteArray.end();
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnScrollChanged() {
        CopyOnWriteArray<OnScrollChangedListener> copyOnWriteArray = this.mOnScrollChangedListeners;
        if (copyOnWriteArray == null || copyOnWriteArray.size() <= 0) {
            return;
        }
        CopyOnWriteArray.Access<OnScrollChangedListener> start = copyOnWriteArray.start();
        try {
            int size = start.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                start.get(i2).onScrollChanged();
                i = i2 + 1;
            }
        } finally {
            copyOnWriteArray.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnTouchModeChanged(boolean z) {
        CopyOnWriteArrayList<OnTouchModeChangeListener> copyOnWriteArrayList = this.mOnTouchModeChangeListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<OnTouchModeChangeListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onTouchModeChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnWindowAttachedChange(boolean z) {
        CopyOnWriteArrayList<OnWindowAttachListener> copyOnWriteArrayList = this.mOnWindowAttachListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<OnWindowAttachListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            OnWindowAttachListener next = it.next();
            if (z) {
                next.onWindowAttached();
            } else {
                next.onWindowDetached();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dispatchOnWindowFocusChange(boolean z) {
        CopyOnWriteArrayList<OnWindowFocusChangeListener> copyOnWriteArrayList = this.mOnWindowFocusListeners;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<OnWindowFocusChangeListener> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().onWindowFocusChanged(z);
        }
    }

    public final void dispatchOnWindowShown() {
        this.mWindowShown = true;
        CopyOnWriteArray<OnWindowShownListener> copyOnWriteArray = this.mOnWindowShownListeners;
        if (copyOnWriteArray == null || copyOnWriteArray.size() <= 0) {
            return;
        }
        CopyOnWriteArray.Access<OnWindowShownListener> start = copyOnWriteArray.start();
        try {
            int size = start.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                start.get(i2).onWindowShown();
                i = i2 + 1;
            }
        } finally {
            copyOnWriteArray.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasComputeInternalInsetsListeners() {
        CopyOnWriteArray<OnComputeInternalInsetsListener> copyOnWriteArray = this.mOnComputeInternalInsetsListeners;
        return copyOnWriteArray != null && copyOnWriteArray.size() > 0;
    }

    final boolean hasOnPreDrawListeners() {
        return this.mOnPreDrawListeners != null && this.mOnPreDrawListeners.size() > 0;
    }

    public boolean isAlive() {
        return this.mAlive;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void merge(ViewTreeObserver viewTreeObserver) {
        if (viewTreeObserver.mOnWindowAttachListeners != null) {
            if (this.mOnWindowAttachListeners != null) {
                this.mOnWindowAttachListeners.addAll(viewTreeObserver.mOnWindowAttachListeners);
            } else {
                this.mOnWindowAttachListeners = viewTreeObserver.mOnWindowAttachListeners;
            }
        }
        if (viewTreeObserver.mOnWindowFocusListeners != null) {
            if (this.mOnWindowFocusListeners != null) {
                this.mOnWindowFocusListeners.addAll(viewTreeObserver.mOnWindowFocusListeners);
            } else {
                this.mOnWindowFocusListeners = viewTreeObserver.mOnWindowFocusListeners;
            }
        }
        if (viewTreeObserver.mOnGlobalFocusListeners != null) {
            if (this.mOnGlobalFocusListeners != null) {
                this.mOnGlobalFocusListeners.addAll(viewTreeObserver.mOnGlobalFocusListeners);
            } else {
                this.mOnGlobalFocusListeners = viewTreeObserver.mOnGlobalFocusListeners;
            }
        }
        if (viewTreeObserver.mOnGlobalLayoutListeners != null) {
            if (this.mOnGlobalLayoutListeners != null) {
                this.mOnGlobalLayoutListeners.addAll(viewTreeObserver.mOnGlobalLayoutListeners);
            } else {
                this.mOnGlobalLayoutListeners = viewTreeObserver.mOnGlobalLayoutListeners;
            }
        }
        if (viewTreeObserver.mOnPreDrawListeners != null) {
            if (this.mOnPreDrawListeners != null) {
                this.mOnPreDrawListeners.addAll(viewTreeObserver.mOnPreDrawListeners);
            } else {
                this.mOnPreDrawListeners = viewTreeObserver.mOnPreDrawListeners;
            }
        }
        if (viewTreeObserver.mOnTouchModeChangeListeners != null) {
            if (this.mOnTouchModeChangeListeners != null) {
                this.mOnTouchModeChangeListeners.addAll(viewTreeObserver.mOnTouchModeChangeListeners);
            } else {
                this.mOnTouchModeChangeListeners = viewTreeObserver.mOnTouchModeChangeListeners;
            }
        }
        if (viewTreeObserver.mOnComputeInternalInsetsListeners != null) {
            if (this.mOnComputeInternalInsetsListeners != null) {
                this.mOnComputeInternalInsetsListeners.addAll(viewTreeObserver.mOnComputeInternalInsetsListeners);
            } else {
                this.mOnComputeInternalInsetsListeners = viewTreeObserver.mOnComputeInternalInsetsListeners;
            }
        }
        if (viewTreeObserver.mOnScrollChangedListeners != null) {
            if (this.mOnScrollChangedListeners != null) {
                this.mOnScrollChangedListeners.addAll(viewTreeObserver.mOnScrollChangedListeners);
            } else {
                this.mOnScrollChangedListeners = viewTreeObserver.mOnScrollChangedListeners;
            }
        }
        if (viewTreeObserver.mOnWindowShownListeners != null) {
            if (this.mOnWindowShownListeners != null) {
                this.mOnWindowShownListeners.addAll(viewTreeObserver.mOnWindowShownListeners);
            } else {
                this.mOnWindowShownListeners = viewTreeObserver.mOnWindowShownListeners;
            }
        }
        viewTreeObserver.kill();
    }

    @Deprecated
    public void removeGlobalOnLayoutListener(OnGlobalLayoutListener onGlobalLayoutListener) {
        removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener onComputeInternalInsetsListener) {
        checkIsAlive();
        if (this.mOnComputeInternalInsetsListeners == null) {
            return;
        }
        this.mOnComputeInternalInsetsListeners.remove(onComputeInternalInsetsListener);
    }

    public void removeOnDrawListener(OnDrawListener onDrawListener) {
        checkIsAlive();
        if (this.mOnDrawListeners == null) {
            return;
        }
        this.mOnDrawListeners.remove(onDrawListener);
    }

    public void removeOnEnterAnimationCompleteListener(OnEnterAnimationCompleteListener onEnterAnimationCompleteListener) {
        checkIsAlive();
        if (this.mOnEnterAnimationCompleteListeners == null) {
            return;
        }
        this.mOnEnterAnimationCompleteListeners.remove(onEnterAnimationCompleteListener);
    }

    public void removeOnGlobalFocusChangeListener(OnGlobalFocusChangeListener onGlobalFocusChangeListener) {
        checkIsAlive();
        if (this.mOnGlobalFocusListeners == null) {
            return;
        }
        this.mOnGlobalFocusListeners.remove(onGlobalFocusChangeListener);
    }

    public void removeOnGlobalLayoutListener(OnGlobalLayoutListener onGlobalLayoutListener) {
        checkIsAlive();
        if (this.mOnGlobalLayoutListeners == null) {
            return;
        }
        this.mOnGlobalLayoutListeners.remove(onGlobalLayoutListener);
    }

    public void removeOnPreDrawListener(OnPreDrawListener onPreDrawListener) {
        checkIsAlive();
        if (this.mOnPreDrawListeners == null) {
            return;
        }
        this.mOnPreDrawListeners.remove(onPreDrawListener);
    }

    public void removeOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        checkIsAlive();
        if (this.mOnScrollChangedListeners == null) {
            return;
        }
        this.mOnScrollChangedListeners.remove(onScrollChangedListener);
    }

    public void removeOnTouchModeChangeListener(OnTouchModeChangeListener onTouchModeChangeListener) {
        checkIsAlive();
        if (this.mOnTouchModeChangeListeners == null) {
            return;
        }
        this.mOnTouchModeChangeListeners.remove(onTouchModeChangeListener);
    }

    public void removeOnWindowAttachListener(OnWindowAttachListener onWindowAttachListener) {
        checkIsAlive();
        if (this.mOnWindowAttachListeners == null) {
            return;
        }
        this.mOnWindowAttachListeners.remove(onWindowAttachListener);
    }

    public void removeOnWindowFocusChangeListener(OnWindowFocusChangeListener onWindowFocusChangeListener) {
        checkIsAlive();
        if (this.mOnWindowFocusListeners == null) {
            return;
        }
        this.mOnWindowFocusListeners.remove(onWindowFocusChangeListener);
    }

    public void removeOnWindowShownListener(OnWindowShownListener onWindowShownListener) {
        checkIsAlive();
        if (this.mOnWindowShownListeners == null) {
            return;
        }
        this.mOnWindowShownListeners.remove(onWindowShownListener);
    }
}

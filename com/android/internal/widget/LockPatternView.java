package com.android.internal.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.internal.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView.class */
public class LockPatternView extends View {
    private static final int ASPECT_LOCK_HEIGHT = 2;
    private static final int ASPECT_LOCK_WIDTH = 1;
    private static final int ASPECT_SQUARE = 0;
    private static final float DRAG_THRESHHOLD = 0.0f;
    private static final int MILLIS_PER_CIRCLE_ANIMATING = 700;
    private static final boolean PROFILE_DRAWING = false;
    private long mAnimatingPeriodStart;
    private int mAspect;
    private CellState[][] mCellStates;
    private final Path mCurrentPath;
    private final int mDotSize;
    private final int mDotSizeActivated;
    private boolean mDrawingProfilingStarted;
    private boolean mEnableHapticFeedback;
    private int mErrorColor;
    private Interpolator mFastOutSlowInInterpolator;
    private float mHitFactor;
    private float mInProgressX;
    private float mInProgressY;
    private boolean mInStealthMode;
    private boolean mInputEnabled;
    private final Rect mInvalidate;
    private Interpolator mLinearOutSlowInInterpolator;
    private LockPatternUtils mLockPatternUtils;
    private OnPatternListener mOnPatternListener;
    private Paint mPaint;
    private Paint mPathPaint;
    private final int mPathWidth;
    private ArrayList<Cell> mPattern;
    private DisplayMode mPatternDisplayMode;
    private boolean[][] mPatternDrawLookup;
    private boolean mPatternInProgress;
    private byte mPatternSize;
    private int mRegularColor;
    private boolean mShowErrorPath;
    private float mSquareHeight;
    private float mSquareWidth;
    private int mSuccessColor;
    private final Rect mTmpInvalidateRect;
    private boolean mVisibleDots;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView$Cell.class */
    public static class Cell {
        static Cell[][] sCells;
        int column;
        int row;

        static {
            updateSize((byte) 3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Cell(int i, int i2, byte b) {
            checkRange(i, i2, b);
            this.row = i;
            this.column = i2;
        }

        private static void checkRange(int i, int i2, byte b) {
            if (i < 0 || i > b - 1) {
                throw new IllegalArgumentException("row must be in range 0-" + (b - 1));
            }
            if (i2 < 0 || i2 > b - 1) {
                throw new IllegalArgumentException("column must be in range 0-" + (b - 1));
            }
        }

        public static Cell of(int i, int i2, byte b) {
            Cell of;
            synchronized (Cell.class) {
                try {
                    of = of(sCells, i, i2, b);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return of;
        }

        public static Cell of(Cell[][] cellArr, int i, int i2, byte b) {
            checkRange(i, i2, b);
            return cellArr[i][i2];
        }

        public static void updateSize(byte b) {
            sCells = (Cell[][]) Array.newInstance(Cell.class, b, b);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < b) {
                        sCells[i2][i4] = new Cell(i2, i4, b);
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Cell) {
                Cell cell = (Cell) obj;
                z = false;
                if (cell.getColumn() == getColumn()) {
                    z = false;
                    if (cell.getRow() == getRow()) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }

        public String toString() {
            return "(row=" + this.row + ",clmn=" + this.column + ")";
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView$CellState.class */
    public static class CellState {
        public ValueAnimator lineAnimator;
        public float size;
        public float scale = 1.0f;
        public float translateY = 0.0f;
        public float alpha = 1.0f;
        public float lineEndX = Float.MIN_VALUE;
        public float lineEndY = Float.MIN_VALUE;
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView$DisplayMode.class */
    public enum DisplayMode {
        Correct,
        Animate,
        Wrong
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView$OnPatternListener.class */
    public interface OnPatternListener {
        void onPatternCellAdded(List<Cell> list);

        void onPatternCleared();

        void onPatternDetected(List<Cell> list);

        void onPatternStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/LockPatternView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.android.internal.widget.LockPatternView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final byte mPatternSize;
        private final String mSerializedPattern;
        private final boolean mShowErrorPath;
        private final boolean mTactileFeedbackEnabled;
        private final boolean mVisibleDots;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSerializedPattern = parcel.readString();
            this.mDisplayMode = parcel.readInt();
            this.mPatternSize = parcel.readByte();
            this.mInputEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mInStealthMode = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mTactileFeedbackEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mVisibleDots = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mShowErrorPath = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        private SavedState(Parcelable parcelable, String str, int i, byte b, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            super(parcelable);
            this.mSerializedPattern = str;
            this.mDisplayMode = i;
            this.mPatternSize = b;
            this.mInputEnabled = z;
            this.mInStealthMode = z2;
            this.mTactileFeedbackEnabled = z3;
            this.mVisibleDots = z4;
            this.mShowErrorPath = z5;
        }

        public int getDisplayMode() {
            return this.mDisplayMode;
        }

        public byte getPatternSize() {
            return this.mPatternSize;
        }

        public String getSerializedPattern() {
            return this.mSerializedPattern;
        }

        public boolean isInStealthMode() {
            return this.mInStealthMode;
        }

        public boolean isInputEnabled() {
            return this.mInputEnabled;
        }

        public boolean isShowErrorPath() {
            return this.mShowErrorPath;
        }

        public boolean isTactileFeedbackEnabled() {
            return this.mTactileFeedbackEnabled;
        }

        public boolean isVisibleDots() {
            return this.mVisibleDots;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mSerializedPattern);
            parcel.writeInt(this.mDisplayMode);
            parcel.writeByte(this.mPatternSize);
            parcel.writeValue(Boolean.valueOf(this.mInputEnabled));
            parcel.writeValue(Boolean.valueOf(this.mInStealthMode));
            parcel.writeValue(Boolean.valueOf(this.mTactileFeedbackEnabled));
            parcel.writeValue(Boolean.valueOf(this.mVisibleDots));
            parcel.writeValue(Boolean.valueOf(this.mShowErrorPath));
        }
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawingProfilingStarted = false;
        this.mPaint = new Paint();
        this.mPathPaint = new Paint();
        this.mPatternSize = (byte) 3;
        this.mPattern = new ArrayList<>(this.mPatternSize * this.mPatternSize);
        this.mPatternDrawLookup = (boolean[][]) Array.newInstance(Boolean.TYPE, this.mPatternSize, this.mPatternSize);
        this.mInProgressX = -1.0f;
        this.mInProgressY = -1.0f;
        this.mPatternDisplayMode = DisplayMode.Correct;
        this.mInputEnabled = true;
        this.mInStealthMode = false;
        this.mEnableHapticFeedback = true;
        this.mPatternInProgress = false;
        this.mVisibleDots = true;
        this.mShowErrorPath = true;
        this.mHitFactor = 0.6f;
        this.mCurrentPath = new Path();
        this.mInvalidate = new Rect();
        this.mTmpInvalidateRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LockPatternView);
        String string = obtainStyledAttributes.getString(0);
        if ("square".equals(string)) {
            this.mAspect = 0;
        } else if ("lock_width".equals(string)) {
            this.mAspect = 1;
        } else if ("lock_height".equals(string)) {
            this.mAspect = 2;
        } else {
            this.mAspect = 0;
        }
        setClickable(true);
        this.mPathPaint.setAntiAlias(true);
        this.mPathPaint.setDither(true);
        this.mRegularColor = getResources().getColor(R.color.lock_pattern_view_regular_color);
        this.mErrorColor = getResources().getColor(R.color.lock_pattern_view_error_color);
        this.mSuccessColor = getResources().getColor(R.color.lock_pattern_view_success_color);
        this.mRegularColor = obtainStyledAttributes.getColor(2, this.mRegularColor);
        this.mErrorColor = obtainStyledAttributes.getColor(3, this.mErrorColor);
        this.mSuccessColor = obtainStyledAttributes.getColor(4, this.mSuccessColor);
        this.mPathPaint.setColor(obtainStyledAttributes.getColor(1, this.mRegularColor));
        this.mPathPaint.setStyle(Paint.Style.STROKE);
        this.mPathPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPathPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPathWidth = getResources().getDimensionPixelSize(R.dimen.lock_pattern_dot_line_width);
        this.mPathPaint.setStrokeWidth(this.mPathWidth);
        this.mDotSize = getResources().getDimensionPixelSize(R.dimen.lock_pattern_dot_size);
        this.mDotSizeActivated = getResources().getDimensionPixelSize(R.dimen.lock_pattern_dot_size_activated);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mCellStates = (CellState[][]) Array.newInstance(CellState.class, this.mPatternSize, this.mPatternSize);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in);
                this.mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.linear_out_slow_in);
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mPatternSize) {
                    this.mCellStates[i2][i4] = new CellState();
                    this.mCellStates[i2][i4].size = this.mDotSize;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private void addCellToPattern(Cell cell) {
        this.mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        this.mPattern.add(cell);
        if (!this.mInStealthMode) {
            startCellActivatedAnimation(cell);
        }
        notifyCellAdded();
    }

    private float calculateLastSegmentAlpha(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return Math.min(1.0f, Math.max(0.0f, ((((float) Math.sqrt((f5 * f5) + (f6 * f6))) / this.mSquareWidth) - 0.3f) * 4.0f));
    }

    private void cancelLineAnimations() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mPatternSize) {
                    CellState cellState = this.mCellStates[i2][i4];
                    if (cellState.lineAnimator != null) {
                        cellState.lineAnimator.cancel();
                        cellState.lineEndX = Float.MIN_VALUE;
                        cellState.lineEndY = Float.MIN_VALUE;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private Cell checkForNewHit(float f, float f2) {
        int columnHit;
        int rowHit = getRowHit(f2);
        if (rowHit >= 0 && (columnHit = getColumnHit(f)) >= 0 && !this.mPatternDrawLookup[rowHit][columnHit]) {
            return Cell.of(rowHit, columnHit, this.mPatternSize);
        }
        return null;
    }

    private void clearPatternDrawLookup() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mPatternSize) {
                    this.mPatternDrawLookup[i2][i4] = false;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    private Cell detectAndAddHit(float f, float f2) {
        Cell checkForNewHit = checkForNewHit(f, f2);
        if (checkForNewHit != null) {
            ArrayList<Cell> arrayList = this.mPattern;
            if (!arrayList.isEmpty()) {
                Cell cell = arrayList.get(arrayList.size() - 1);
                int i = checkForNewHit.row - cell.row;
                int i2 = checkForNewHit.column - cell.column;
                int i3 = cell.row;
                int i4 = cell.column;
                int i5 = i4;
                int i6 = i3;
                if (i != 0) {
                    i5 = i4;
                    i6 = i3;
                    if (i2 != 0) {
                        if (Math.abs(i) == Math.abs(i2)) {
                            i6 = i3;
                            i5 = i4;
                        }
                    }
                }
                while (true) {
                    int signum = i6 + Integer.signum(i);
                    int signum2 = i5 + Integer.signum(i2);
                    if (signum == checkForNewHit.row && signum2 == checkForNewHit.column) {
                        break;
                    }
                    Cell of = Cell.of(signum, signum2, this.mPatternSize);
                    i5 = signum2;
                    i6 = signum;
                    if (!this.mPatternDrawLookup[of.row][of.column]) {
                        addCellToPattern(of);
                        i5 = signum2;
                        i6 = signum;
                    }
                }
            }
            addCellToPattern(checkForNewHit);
            if (this.mEnableHapticFeedback) {
                performHapticFeedback(1, 3);
            }
            return checkForNewHit;
        }
        return null;
    }

    private void drawCircle(Canvas canvas, float f, float f2, float f3, boolean z, float f4) {
        if (this.mVisibleDots) {
            this.mPaint.setColor(getCurrentColor(z));
            this.mPaint.setAlpha((int) (255.0f * f4));
            canvas.drawCircle(f, f2, f3 / 2.0f, this.mPaint);
        }
    }

    private float getCenterXForColumn(int i) {
        return this.mPaddingLeft + (i * this.mSquareWidth) + (this.mSquareWidth / 2.0f);
    }

    private float getCenterYForRow(int i) {
        return this.mPaddingTop + (i * this.mSquareHeight) + (this.mSquareHeight / 2.0f);
    }

    private int getColumnHit(float f) {
        float f2 = this.mSquareWidth;
        float f3 = f2 * this.mHitFactor;
        float f4 = this.mPaddingLeft;
        float f5 = (f2 - f3) / 2.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                return -1;
            }
            float f6 = f4 + f5 + (i2 * f2);
            if (f >= f6 && f <= f6 + f3) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private int getCurrentColor(boolean z) {
        if (!z || ((this.mInStealthMode && this.mPatternDisplayMode != DisplayMode.Wrong) || ((this.mPatternDisplayMode == DisplayMode.Wrong && !this.mShowErrorPath) || this.mPatternInProgress))) {
            return this.mRegularColor;
        }
        if (this.mPatternDisplayMode == DisplayMode.Wrong) {
            return this.mErrorColor;
        }
        if (this.mPatternDisplayMode == DisplayMode.Correct || this.mPatternDisplayMode == DisplayMode.Animate) {
            return this.mSuccessColor;
        }
        throw new IllegalStateException("unknown display mode " + this.mPatternDisplayMode);
    }

    private int getRowHit(float f) {
        float f2 = this.mSquareHeight;
        float f3 = f2 * this.mHitFactor;
        float f4 = this.mPaddingTop;
        float f5 = (f2 - f3) / 2.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                return -1;
            }
            float f6 = f4 + f5 + (i2 * f2);
            if (f >= f6 && f <= f6 + f3) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void handleActionDown(MotionEvent motionEvent) {
        resetPattern();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Cell detectAndAddHit = detectAndAddHit(x, y);
        if (detectAndAddHit != null) {
            this.mPatternInProgress = true;
            this.mPatternDisplayMode = DisplayMode.Correct;
            notifyPatternStarted();
        } else if (this.mPatternInProgress) {
            this.mPatternInProgress = false;
            notifyPatternCleared();
        }
        if (detectAndAddHit != null) {
            float centerXForColumn = getCenterXForColumn(detectAndAddHit.column);
            float centerYForRow = getCenterYForRow(detectAndAddHit.row);
            float f = this.mSquareWidth / 2.0f;
            float f2 = this.mSquareHeight / 2.0f;
            invalidate((int) (centerXForColumn - f), (int) (centerYForRow - f2), (int) (centerXForColumn + f), (int) (centerYForRow + f2));
        }
        this.mInProgressX = x;
        this.mInProgressY = y;
    }

    private void handleActionMove(MotionEvent motionEvent) {
        float f = this.mPathWidth;
        int historySize = motionEvent.getHistorySize();
        this.mTmpInvalidateRect.setEmpty();
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= historySize + 1) {
                break;
            }
            float historicalX = i2 < historySize ? motionEvent.getHistoricalX(i2) : motionEvent.getX();
            float historicalY = i2 < historySize ? motionEvent.getHistoricalY(i2) : motionEvent.getY();
            Cell detectAndAddHit = detectAndAddHit(historicalX, historicalY);
            int size = this.mPattern.size();
            if (detectAndAddHit != null && size == 1) {
                this.mPatternInProgress = true;
                notifyPatternStarted();
            }
            float abs = Math.abs(historicalX - this.mInProgressX);
            float abs2 = Math.abs(historicalY - this.mInProgressY);
            if (abs > 0.0f || abs2 > 0.0f) {
                z = true;
            }
            if (this.mPatternInProgress && size > 0) {
                Cell cell = this.mPattern.get(size - 1);
                float centerXForColumn = getCenterXForColumn(cell.column);
                float centerYForRow = getCenterYForRow(cell.row);
                float min = Math.min(centerXForColumn, historicalX) - f;
                float max = Math.max(centerXForColumn, historicalX) + f;
                float min2 = Math.min(centerYForRow, historicalY) - f;
                float max2 = Math.max(centerYForRow, historicalY) + f;
                float f2 = max2;
                float f3 = min;
                float f4 = max;
                float f5 = min2;
                if (detectAndAddHit != null) {
                    float f6 = this.mSquareWidth * 0.5f;
                    float f7 = this.mSquareHeight * 0.5f;
                    float centerXForColumn2 = getCenterXForColumn(detectAndAddHit.column);
                    float centerYForRow2 = getCenterYForRow(detectAndAddHit.row);
                    f3 = Math.min(centerXForColumn2 - f6, min);
                    f4 = Math.max(centerXForColumn2 + f6, max);
                    f5 = Math.min(centerYForRow2 - f7, min2);
                    f2 = Math.max(centerYForRow2 + f7, max2);
                }
                this.mTmpInvalidateRect.union(Math.round(f3), Math.round(f5), Math.round(f4), Math.round(f2));
            }
            i = i2 + 1;
        }
        this.mInProgressX = motionEvent.getX();
        this.mInProgressY = motionEvent.getY();
        if (z) {
            this.mInvalidate.union(this.mTmpInvalidateRect);
            invalidate(this.mInvalidate);
            this.mInvalidate.set(this.mTmpInvalidateRect);
        }
    }

    private void handleActionUp(MotionEvent motionEvent) {
        if (this.mPattern.isEmpty()) {
            return;
        }
        this.mPatternInProgress = false;
        cancelLineAnimations();
        notifyPatternDetected();
        invalidate();
    }

    private void notifyCellAdded() {
        sendAccessEvent(R.string.lockscreen_access_pattern_cell_added);
        if (this.mOnPatternListener != null) {
            this.mOnPatternListener.onPatternCellAdded(this.mPattern);
        }
    }

    private void notifyPatternCleared() {
        sendAccessEvent(R.string.lockscreen_access_pattern_cleared);
        if (this.mOnPatternListener != null) {
            this.mOnPatternListener.onPatternCleared();
        }
    }

    private void notifyPatternDetected() {
        sendAccessEvent(R.string.lockscreen_access_pattern_detected);
        if (this.mOnPatternListener != null) {
            this.mOnPatternListener.onPatternDetected(this.mPattern);
        }
    }

    private void notifyPatternStarted() {
        sendAccessEvent(R.string.lockscreen_access_pattern_start);
        if (this.mOnPatternListener != null) {
            this.mOnPatternListener.onPatternStart();
        }
    }

    private void resetPattern() {
        this.mPattern.clear();
        clearPatternDrawLookup();
        this.mPatternDisplayMode = DisplayMode.Correct;
        invalidate();
    }

    private int resolveMeasured(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    private void sendAccessEvent(int i) {
        announceForAccessibility(this.mContext.getString(i));
    }

    private void startCellActivatedAnimation(Cell cell) {
        final CellState cellState = this.mCellStates[cell.row][cell.column];
        startSizeAnimation(this.mDotSize, this.mDotSizeActivated, 96L, this.mLinearOutSlowInInterpolator, cellState, new Runnable() { // from class: com.android.internal.widget.LockPatternView.1
            @Override // java.lang.Runnable
            public void run() {
                LockPatternView.this.startSizeAnimation(LockPatternView.this.mDotSizeActivated, LockPatternView.this.mDotSize, 192L, LockPatternView.this.mFastOutSlowInInterpolator, cellState, null);
            }
        });
        startLineEndAnimation(cellState, this.mInProgressX, this.mInProgressY, getCenterXForColumn(cell.column), getCenterYForRow(cell.row));
    }

    private void startLineEndAnimation(final CellState cellState, final float f, final float f2, final float f3, final float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.widget.LockPatternView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cellState.lineEndX = ((1.0f - floatValue) * f) + (f3 * floatValue);
                cellState.lineEndY = ((1.0f - floatValue) * f2) + (f4 * floatValue);
                LockPatternView.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.widget.LockPatternView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cellState.lineAnimator = null;
            }
        });
        ofFloat.setInterpolator(this.mFastOutSlowInInterpolator);
        ofFloat.setDuration(100L);
        ofFloat.start();
        cellState.lineAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSizeAnimation(float f, float f2, long j, Interpolator interpolator, final CellState cellState, final Runnable runnable) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.internal.widget.LockPatternView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.size = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LockPatternView.this.invalidate();
            }
        });
        if (runnable != null) {
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.widget.LockPatternView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }
            });
        }
        ofFloat.setInterpolator(interpolator);
        ofFloat.setDuration(j);
        ofFloat.start();
    }

    public void clearPattern() {
        resetPattern();
    }

    public void disableInput() {
        this.mInputEnabled = false;
    }

    public void enableInput() {
        this.mInputEnabled = true;
    }

    public CellState[][] getCellStates() {
        return this.mCellStates;
    }

    public int getLockPatternSize() {
        return this.mPatternSize;
    }

    public boolean isInStealthMode() {
        return this.mInStealthMode;
    }

    public boolean isShowErrorPath() {
        return this.mShowErrorPath;
    }

    public boolean isTactileFeedbackEnabled() {
        return this.mEnableHapticFeedback;
    }

    public boolean isVisibleDots() {
        return this.mVisibleDots;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int elapsedRealtime;
        ArrayList<Cell> arrayList = this.mPattern;
        int size = arrayList.size();
        boolean[][] zArr = this.mPatternDrawLookup;
        if (this.mPatternDisplayMode == DisplayMode.Animate) {
            int elapsedRealtime2 = (((int) (SystemClock.elapsedRealtime() - this.mAnimatingPeriodStart)) % ((size + 1) * MILLIS_PER_CIRCLE_ANIMATING)) / MILLIS_PER_CIRCLE_ANIMATING;
            clearPatternDrawLookup();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elapsedRealtime2) {
                    break;
                }
                Cell cell = arrayList.get(i2);
                zArr[cell.getRow()][cell.getColumn()] = true;
                i = i2 + 1;
            }
            if (elapsedRealtime2 > 0 && elapsedRealtime2 < size) {
                float f = (elapsedRealtime % MILLIS_PER_CIRCLE_ANIMATING) / 700.0f;
                Cell cell2 = arrayList.get(elapsedRealtime2 - 1);
                float centerXForColumn = getCenterXForColumn(cell2.column);
                float centerYForRow = getCenterYForRow(cell2.row);
                Cell cell3 = arrayList.get(elapsedRealtime2);
                float centerXForColumn2 = getCenterXForColumn(cell3.column);
                float centerYForRow2 = getCenterYForRow(cell3.row);
                this.mInProgressX = centerXForColumn + (f * (centerXForColumn2 - centerXForColumn));
                this.mInProgressY = centerYForRow + (f * (centerYForRow2 - centerYForRow));
            }
            invalidate();
        }
        Path path = this.mCurrentPath;
        path.rewind();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mPatternSize) {
                break;
            }
            float centerYForRow3 = getCenterYForRow(i4);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < this.mPatternSize) {
                    CellState cellState = this.mCellStates[i4][i6];
                    drawCircle(canvas, (int) getCenterXForColumn(i6), ((int) centerYForRow3) + cellState.translateY, cellState.size * cellState.scale, zArr[i4][i6], cellState.alpha);
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
        if (!(this.mInStealthMode || this.mPatternDisplayMode == DisplayMode.Wrong) || (this.mPatternDisplayMode == DisplayMode.Wrong && this.mShowErrorPath)) {
            this.mPathPaint.setColor(getCurrentColor(true));
            boolean z = false;
            float f2 = 0.0f;
            float f3 = 0.0f;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size) {
                    break;
                }
                Cell cell4 = arrayList.get(i8);
                if (!zArr[cell4.row][cell4.column]) {
                    break;
                }
                z = true;
                float centerXForColumn3 = getCenterXForColumn(cell4.column);
                float centerYForRow4 = getCenterYForRow(cell4.row);
                if (i8 != 0) {
                    CellState cellState2 = this.mCellStates[cell4.row][cell4.column];
                    path.rewind();
                    path.moveTo(f2, f3);
                    if (cellState2.lineEndX == Float.MIN_VALUE || cellState2.lineEndY == Float.MIN_VALUE) {
                        path.lineTo(centerXForColumn3, centerYForRow4);
                    } else {
                        path.lineTo(cellState2.lineEndX, cellState2.lineEndY);
                    }
                    canvas.drawPath(path, this.mPathPaint);
                }
                f2 = centerXForColumn3;
                f3 = centerYForRow4;
                i7 = i8 + 1;
            }
            if ((this.mPatternInProgress || this.mPatternDisplayMode == DisplayMode.Animate) && z) {
                path.rewind();
                path.moveTo(f2, f3);
                path.lineTo(this.mInProgressX, this.mInProgressY);
                this.mPathPaint.setAlpha((int) (calculateLastSegmentAlpha(this.mInProgressX, this.mInProgressY, f2, f3) * 255.0f));
                canvas.drawPath(path, this.mPathPaint);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (AccessibilityManager.getInstance(this.mContext).isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            switch (action) {
                case 7:
                    motionEvent.setAction(2);
                    break;
                case 9:
                    motionEvent.setAction(0);
                    break;
                case 10:
                    motionEvent.setAction(1);
                    break;
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int min;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int resolveMeasured = resolveMeasured(i, suggestedMinimumWidth);
        int resolveMeasured2 = resolveMeasured(i2, suggestedMinimumHeight);
        switch (this.mAspect) {
            case 0:
                resolveMeasured2 = Math.min(resolveMeasured, resolveMeasured2);
                min = resolveMeasured2;
                break;
            case 1:
                resolveMeasured2 = Math.min(resolveMeasured, resolveMeasured2);
                min = resolveMeasured;
                break;
            case 2:
                min = Math.min(resolveMeasured, resolveMeasured2);
                break;
            default:
                min = resolveMeasured;
                break;
        }
        setMeasuredDimension(min, resolveMeasured2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPatternDisplayMode = DisplayMode.values()[savedState.getDisplayMode()];
        this.mPatternSize = savedState.getPatternSize();
        this.mInputEnabled = savedState.isInputEnabled();
        this.mInStealthMode = savedState.isInStealthMode();
        this.mEnableHapticFeedback = savedState.isTactileFeedbackEnabled();
        this.mVisibleDots = savedState.isVisibleDots();
        this.mShowErrorPath = savedState.isShowErrorPath();
        setPattern(DisplayMode.Correct, LockPatternUtils.stringToPattern(savedState.getSerializedPattern(), this.mPatternSize));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), LockPatternUtils.patternToString(this.mPattern, this.mPatternSize), this.mPatternDisplayMode.ordinal(), this.mPatternSize, this.mInputEnabled, this.mInStealthMode, this.mEnableHapticFeedback, this.mVisibleDots, this.mShowErrorPath);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSquareWidth = ((i - this.mPaddingLeft) - this.mPaddingRight) / this.mPatternSize;
        this.mSquareHeight = ((i2 - this.mPaddingTop) - this.mPaddingBottom) / this.mPatternSize;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (this.mInputEnabled && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    handleActionDown(motionEvent);
                    return true;
                case 1:
                    handleActionUp(motionEvent);
                    return true;
                case 2:
                    handleActionMove(motionEvent);
                    return true;
                case 3:
                    if (this.mPatternInProgress) {
                        this.mPatternInProgress = false;
                        resetPattern();
                        notifyPatternCleared();
                        return true;
                    }
                    break;
                default:
                    return false;
            }
        } else {
            z = false;
        }
        return z;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.mPatternDisplayMode = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.mPattern.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.mAnimatingPeriodStart = SystemClock.elapsedRealtime();
            Cell cell = this.mPattern.get(0);
            this.mInProgressX = getCenterXForColumn(cell.getColumn());
            this.mInProgressY = getCenterYForRow(cell.getRow());
            clearPatternDrawLookup();
        }
        invalidate();
    }

    public void setInStealthMode(boolean z) {
        this.mInStealthMode = z;
    }

    public void setLockPatternSize(byte b) {
        this.mPatternSize = b;
        Cell.updateSize(b);
        this.mCellStates = (CellState[][]) Array.newInstance(CellState.class, this.mPatternSize, this.mPatternSize);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mPatternSize) {
                this.mPattern = new ArrayList<>(b * b);
                this.mPatternDrawLookup = (boolean[][]) Array.newInstance(Boolean.TYPE, b, b);
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mPatternSize) {
                    this.mCellStates[i2][i4] = new CellState();
                    this.mCellStates[i2][i4].size = this.mDotSize;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void setLockPatternUtils(LockPatternUtils lockPatternUtils) {
        this.mLockPatternUtils = lockPatternUtils;
    }

    public void setOnPatternListener(OnPatternListener onPatternListener) {
        this.mOnPatternListener = onPatternListener;
    }

    public void setPattern(DisplayMode displayMode, List<Cell> list) {
        this.mPattern.clear();
        this.mPattern.addAll(list);
        clearPatternDrawLookup();
        for (Cell cell : list) {
            this.mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void setShowErrorPath(boolean z) {
        this.mShowErrorPath = z;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.mEnableHapticFeedback = z;
    }

    public void setVisibleDots(boolean z) {
        this.mVisibleDots = z;
    }
}

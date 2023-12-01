package android.inputmethodservice;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/KeyboardView.class */
public class KeyboardView extends View implements View.OnClickListener {
    private static final int DEBOUNCE_TIME = 70;
    private static final boolean DEBUG = false;
    private static final int DELAY_AFTER_PREVIEW = 70;
    private static final int DELAY_BEFORE_PREVIEW = 0;
    private static final int MSG_LONGPRESS = 4;
    private static final int MSG_REMOVE_PREVIEW = 2;
    private static final int MSG_REPEAT = 3;
    private static final int MSG_SHOW_PREVIEW = 1;
    private static final int MULTITAP_INTERVAL = 800;
    private static final int NOT_A_KEY = -1;
    private static final int REPEAT_INTERVAL = 50;
    private static final int REPEAT_START_DELAY = 400;
    private boolean mAbortKey;
    private AccessibilityManager mAccessibilityManager;
    private AudioManager mAudioManager;
    private float mBackgroundDimAmount;
    private Bitmap mBuffer;
    private Canvas mCanvas;
    private Rect mClipRegion;
    private final int[] mCoordinates;
    private int mCurrentKey;
    private int mCurrentKeyIndex;
    private long mCurrentKeyTime;
    private Rect mDirtyRect;
    private boolean mDisambiguateSwipe;
    private int[] mDistances;
    private int mDownKey;
    private long mDownTime;
    private boolean mDrawPending;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private boolean mHeadsetRequiredToHearPasswordsAnnounced;
    private boolean mInMultiTap;
    private Keyboard.Key mInvalidatedKey;
    private Drawable mKeyBackground;
    private int[] mKeyIndices;
    private int mKeyTextColor;
    private int mKeyTextSize;
    private Keyboard mKeyboard;
    private OnKeyboardActionListener mKeyboardActionListener;
    private boolean mKeyboardChanged;
    private Keyboard.Key[] mKeys;
    private int mLabelTextSize;
    private int mLastCodeX;
    private int mLastCodeY;
    private int mLastKey;
    private long mLastKeyTime;
    private long mLastMoveTime;
    private int mLastSentIndex;
    private long mLastTapTime;
    private int mLastX;
    private int mLastY;
    private KeyboardView mMiniKeyboard;
    private Map<Keyboard.Key, View> mMiniKeyboardCache;
    private View mMiniKeyboardContainer;
    private int mMiniKeyboardOffsetX;
    private int mMiniKeyboardOffsetY;
    private boolean mMiniKeyboardOnScreen;
    private int mOldPointerCount;
    private float mOldPointerX;
    private float mOldPointerY;
    private Rect mPadding;
    private Paint mPaint;
    private PopupWindow mPopupKeyboard;
    private int mPopupLayout;
    private View mPopupParent;
    private int mPopupPreviewX;
    private int mPopupPreviewY;
    private int mPopupX;
    private int mPopupY;
    private boolean mPossiblePoly;
    private boolean mPreviewCentered;
    private int mPreviewHeight;
    private StringBuilder mPreviewLabel;
    private int mPreviewOffset;
    private PopupWindow mPreviewPopup;
    private TextView mPreviewText;
    private int mPreviewTextSizeLarge;
    private boolean mProximityCorrectOn;
    private int mProximityThreshold;
    private int mRepeatKeyIndex;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowPreview;
    private boolean mShowTouchPoints;
    private int mStartX;
    private int mStartY;
    private int mSwipeThreshold;
    private SwipeTracker mSwipeTracker;
    private int mTapCount;
    private int mVerticalCorrection;
    private static final int[] KEY_DELETE = {-5};
    private static final int[] LONG_PRESSABLE_STATE_SET = {R.attr.state_long_pressable};
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static int MAX_NEARBY_KEYS = 12;

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/KeyboardView$OnKeyboardActionListener.class */
    public interface OnKeyboardActionListener {
        void onKey(int i, int[] iArr);

        void onPress(int i);

        void onRelease(int i);

        void onText(CharSequence charSequence);

        void swipeDown();

        void swipeLeft();

        void swipeRight();

        void swipeUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/KeyboardView$SwipeTracker.class */
    public static class SwipeTracker {
        static final int LONGEST_PAST_TIME = 200;
        static final int NUM_PAST = 4;
        final long[] mPastTime;
        final float[] mPastX;
        final float[] mPastY;
        float mXVelocity;
        float mYVelocity;

        private SwipeTracker() {
            this.mPastX = new float[4];
            this.mPastY = new float[4];
            this.mPastTime = new long[4];
        }

        private void addPoint(float f, float f2, long j) {
            int i;
            int i2 = -1;
            long[] jArr = this.mPastTime;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i >= 4 || jArr[i] == 0) {
                    break;
                }
                if (jArr[i] < j - 200) {
                    i2 = i;
                }
                i3 = i + 1;
            }
            int i4 = i2;
            if (i == 4) {
                i4 = i2;
                if (i2 < 0) {
                    i4 = 0;
                }
            }
            int i5 = i4;
            if (i4 == i) {
                i5 = i4 - 1;
            }
            float[] fArr = this.mPastX;
            float[] fArr2 = this.mPastY;
            int i6 = i;
            if (i5 >= 0) {
                int i7 = i5 + 1;
                int i8 = (4 - i5) - 1;
                System.arraycopy(fArr, i7, fArr, 0, i8);
                System.arraycopy(fArr2, i7, fArr2, 0, i8);
                System.arraycopy(jArr, i7, jArr, 0, i8);
                i6 = i - (i5 + 1);
            }
            fArr[i6] = f;
            fArr2[i6] = f2;
            jArr[i6] = j;
            int i9 = i6 + 1;
            if (i9 < 4) {
                jArr[i9] = 0;
            }
        }

        public void addMovement(MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int historySize = motionEvent.getHistorySize();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= historySize) {
                    addPoint(motionEvent.getX(), motionEvent.getY(), eventTime);
                    return;
                } else {
                    addPoint(motionEvent.getHistoricalX(i2), motionEvent.getHistoricalY(i2), motionEvent.getHistoricalEventTime(i2));
                    i = i2 + 1;
                }
            }
        }

        public void clear() {
            this.mPastTime[0] = 0;
        }

        public void computeCurrentVelocity(int i) {
            computeCurrentVelocity(i, Float.MAX_VALUE);
        }

        public void computeCurrentVelocity(int i, float f) {
            int i2;
            float[] fArr = this.mPastX;
            float[] fArr2 = this.mPastY;
            long[] jArr = this.mPastTime;
            float f2 = fArr[0];
            float f3 = fArr2[0];
            long j = jArr[0];
            float f4 = 0.0f;
            float f5 = 0.0f;
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= 4 || jArr[i2] == 0) {
                    break;
                }
                i3 = i2 + 1;
            }
            int i4 = 1;
            while (i4 < i2) {
                int i5 = (int) (jArr[i4] - j);
                if (i5 != 0) {
                    float f6 = ((fArr[i4] - f2) / i5) * i;
                    if (f4 != 0.0f) {
                        f6 = (f4 + f6) * 0.5f;
                    }
                    float f7 = ((fArr2[i4] - f3) / i5) * i;
                    if (f5 == 0.0f) {
                        f5 = f7;
                        f4 = f6;
                    } else {
                        f5 = (f5 + f7) * 0.5f;
                        f4 = f6;
                    }
                }
                i4++;
                f5 = f5;
            }
            this.mXVelocity = f4 < 0.0f ? Math.max(f4, -f) : Math.min(f4, f);
            this.mYVelocity = f5 < 0.0f ? Math.max(f5, -f) : Math.min(f5, f);
        }

        public float getXVelocity() {
            return this.mXVelocity;
        }

        public float getYVelocity() {
            return this.mYVelocity;
        }
    }

    public KeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 18219117);
    }

    public KeyboardView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public KeyboardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCurrentKeyIndex = -1;
        this.mCoordinates = new int[2];
        this.mPreviewCentered = false;
        this.mShowPreview = true;
        this.mShowTouchPoints = true;
        this.mCurrentKey = -1;
        this.mDownKey = -1;
        this.mKeyIndices = new int[12];
        this.mRepeatKeyIndex = -1;
        this.mClipRegion = new Rect(0, 0, 0, 0);
        this.mSwipeTracker = new SwipeTracker();
        this.mOldPointerCount = 1;
        this.mDistances = new int[MAX_NEARBY_KEYS];
        this.mPreviewLabel = new StringBuilder(1);
        this.mDirtyRect = new Rect();
        this.mHandler = new Handler() { // from class: android.inputmethodservice.KeyboardView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        KeyboardView.this.showKey(message.arg1);
                        return;
                    case 2:
                        KeyboardView.this.mPreviewText.setVisibility(4);
                        return;
                    case 3:
                        if (KeyboardView.this.repeatKey()) {
                            sendMessageDelayed(Message.obtain(this, 3), 50L);
                            return;
                        }
                        return;
                    case 4:
                        KeyboardView.this.openPopupIfRequired((MotionEvent) message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyboardView, i, i2);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int i3 = 0;
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= indexCount) {
                this.mBackgroundDimAmount = this.mContext.obtainStyledAttributes(com.android.internal.R.styleable.Theme).getFloat(2, 0.5f);
                this.mPreviewPopup = new PopupWindow(context);
                if (i3 != 0) {
                    this.mPreviewText = (TextView) layoutInflater.inflate(i3, (ViewGroup) null);
                    this.mPreviewTextSizeLarge = (int) this.mPreviewText.getTextSize();
                    this.mPreviewPopup.setContentView(this.mPreviewText);
                    this.mPreviewPopup.setBackgroundDrawable(null);
                } else {
                    this.mShowPreview = false;
                }
                this.mPreviewPopup.setTouchable(false);
                this.mPopupKeyboard = new PopupWindow(context);
                this.mPopupKeyboard.setBackgroundDrawable(null);
                this.mPopupParent = this;
                this.mPaint = new Paint();
                this.mPaint.setAntiAlias(true);
                this.mPaint.setTextSize(0);
                this.mPaint.setTextAlign(Paint.Align.CENTER);
                this.mPaint.setAlpha(255);
                this.mPadding = new Rect(0, 0, 0, 0);
                this.mMiniKeyboardCache = new HashMap();
                this.mKeyBackground.getPadding(this.mPadding);
                this.mSwipeThreshold = (int) (500.0f * getResources().getDisplayMetrics().density);
                this.mDisambiguateSwipe = getResources().getBoolean(17956946);
                this.mAccessibilityManager = AccessibilityManager.getInstance(context);
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                resetMultiTap();
                initGestureDetector();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i5);
            switch (index) {
                case 0:
                    this.mShadowColor = obtainStyledAttributes.getColor(index, 0);
                    break;
                case 1:
                    this.mShadowRadius = obtainStyledAttributes.getFloat(index, 0.0f);
                    break;
                case 2:
                    this.mKeyBackground = obtainStyledAttributes.getDrawable(index);
                    break;
                case 3:
                    this.mKeyTextSize = obtainStyledAttributes.getDimensionPixelSize(index, 18);
                    break;
                case 4:
                    this.mLabelTextSize = obtainStyledAttributes.getDimensionPixelSize(index, 14);
                    break;
                case 5:
                    this.mKeyTextColor = obtainStyledAttributes.getColor(index, -16777216);
                    break;
                case 6:
                    i3 = obtainStyledAttributes.getResourceId(index, 0);
                    break;
                case 7:
                    this.mPreviewOffset = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    break;
                case 8:
                    this.mPreviewHeight = obtainStyledAttributes.getDimensionPixelSize(index, 80);
                    break;
                case 9:
                    this.mVerticalCorrection = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    break;
                case 10:
                    this.mPopupLayout = obtainStyledAttributes.getResourceId(index, 0);
                    break;
            }
            i4 = i5 + 1;
        }
    }

    private CharSequence adjustCase(CharSequence charSequence) {
        String str = charSequence;
        if (this.mKeyboard.isShifted()) {
            str = charSequence;
            if (charSequence != null) {
                str = charSequence;
                if (charSequence.length() < 3) {
                    str = charSequence;
                    if (Character.isLowerCase(charSequence.charAt(0))) {
                        str = charSequence.toString().toUpperCase();
                    }
                }
            }
        }
        return str;
    }

    private void checkMultiTap(long j, int i) {
        if (i == -1) {
            return;
        }
        Keyboard.Key key = this.mKeys[i];
        if (key.codes.length <= 1) {
            if (j > this.mLastTapTime + 800 || i != this.mLastSentIndex) {
                resetMultiTap();
                return;
            }
            return;
        }
        this.mInMultiTap = true;
        if (j >= this.mLastTapTime + 800 || i != this.mLastSentIndex) {
            this.mTapCount = -1;
        } else {
            this.mTapCount = (this.mTapCount + 1) % key.codes.length;
        }
    }

    private void computeProximityThreshold(Keyboard keyboard) {
        Keyboard.Key[] keyArr;
        if (keyboard == null || (keyArr = this.mKeys) == null) {
            return;
        }
        int length = keyArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            Keyboard.Key key = keyArr[i3];
            i += Math.min(key.width, key.height) + key.gap;
            i2 = i3 + 1;
        }
        if (i < 0 || length == 0) {
            return;
        }
        this.mProximityThreshold = (int) ((i * 1.4f) / length);
        this.mProximityThreshold *= this.mProximityThreshold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectAndSendKey(int i, int i2, int i3, long j) {
        if (i == -1 || i >= this.mKeys.length) {
            return;
        }
        Keyboard.Key key = this.mKeys[i];
        if (key.text != null) {
            this.mKeyboardActionListener.onText(key.text);
            this.mKeyboardActionListener.onRelease(-1);
        } else {
            int i4 = key.codes[0];
            int[] iArr = new int[MAX_NEARBY_KEYS];
            Arrays.fill(iArr, -1);
            getKeyIndices(i2, i3, iArr);
            int i5 = i4;
            if (this.mInMultiTap) {
                if (this.mTapCount != -1) {
                    this.mKeyboardActionListener.onKey(-5, KEY_DELETE);
                } else {
                    this.mTapCount = 0;
                }
                i5 = key.codes[this.mTapCount];
            }
            this.mKeyboardActionListener.onKey(i5, iArr);
            this.mKeyboardActionListener.onRelease(i5);
        }
        this.mLastSentIndex = i;
        this.mLastTapTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPopupKeyboard() {
        if (this.mPopupKeyboard.isShowing()) {
            this.mPopupKeyboard.dismiss();
            this.mMiniKeyboardOnScreen = false;
            invalidateAllKeys();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getKeyIndices(int r8, int r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.inputmethodservice.KeyboardView.getKeyIndices(int, int, int[]):int");
    }

    private CharSequence getPreviewText(Keyboard.Key key) {
        int i = 0;
        if (this.mInMultiTap) {
            this.mPreviewLabel.setLength(0);
            StringBuilder sb = this.mPreviewLabel;
            int[] iArr = key.codes;
            if (this.mTapCount >= 0) {
                i = this.mTapCount;
            }
            sb.append((char) iArr[i]);
            return adjustCase(this.mPreviewLabel);
        }
        return adjustCase(key.label);
    }

    private void initGestureDetector() {
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: android.inputmethodservice.KeyboardView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z;
                if (KeyboardView.this.mPossiblePoly) {
                    return false;
                }
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                int width = KeyboardView.this.getWidth() / 2;
                int height = KeyboardView.this.getHeight() / 2;
                KeyboardView.this.mSwipeTracker.computeCurrentVelocity(1000);
                float xVelocity = KeyboardView.this.mSwipeTracker.getXVelocity();
                float yVelocity = KeyboardView.this.mSwipeTracker.getYVelocity();
                if (f <= KeyboardView.this.mSwipeThreshold || abs2 >= abs || x <= width) {
                    if (f >= (-KeyboardView.this.mSwipeThreshold) || abs2 >= abs || x >= (-width)) {
                        if (f2 >= (-KeyboardView.this.mSwipeThreshold) || abs >= abs2 || y >= (-height)) {
                            z = false;
                            if (f2 > KeyboardView.this.mSwipeThreshold) {
                                z = false;
                                if (abs < abs2 / 2.0f) {
                                    z = false;
                                    if (y > height) {
                                        if (!KeyboardView.this.mDisambiguateSwipe || yVelocity >= f2 / 4.0f) {
                                            KeyboardView.this.swipeDown();
                                            return true;
                                        }
                                        z = true;
                                    }
                                }
                            }
                        } else if (!KeyboardView.this.mDisambiguateSwipe || yVelocity <= f2 / 4.0f) {
                            KeyboardView.this.swipeUp();
                            return true;
                        } else {
                            z = true;
                        }
                    } else if (!KeyboardView.this.mDisambiguateSwipe || xVelocity <= f / 4.0f) {
                        KeyboardView.this.swipeLeft();
                        return true;
                    } else {
                        z = true;
                    }
                } else if (!KeyboardView.this.mDisambiguateSwipe || xVelocity >= f / 4.0f) {
                    KeyboardView.this.swipeRight();
                    return true;
                } else {
                    z = true;
                }
                if (z) {
                    KeyboardView.this.detectAndSendKey(KeyboardView.this.mDownKey, KeyboardView.this.mStartX, KeyboardView.this.mStartY, motionEvent.getEventTime());
                    return false;
                }
                return false;
            }
        });
        this.mGestureDetector.setIsLongpressEnabled(false);
    }

    private void onBufferDraw() {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.mBuffer == null || this.mKeyboardChanged) {
            if (this.mBuffer == null || (this.mKeyboardChanged && (this.mBuffer.getWidth() != getWidth() || this.mBuffer.getHeight() != getHeight()))) {
                this.mBuffer = Bitmap.createBitmap(Math.max(1, getWidth()), Math.max(1, getHeight()), Bitmap.Config.ARGB_8888);
                this.mCanvas = new Canvas(this.mBuffer);
            }
            invalidateAllKeys();
            this.mKeyboardChanged = false;
        }
        Canvas canvas = this.mCanvas;
        canvas.clipRect(this.mDirtyRect, Region.Op.REPLACE);
        if (this.mKeyboard == null) {
            return;
        }
        Paint paint = this.mPaint;
        Drawable drawable = this.mKeyBackground;
        Rect rect = this.mClipRegion;
        Rect rect2 = this.mPadding;
        int i = this.mPaddingLeft;
        int i2 = this.mPaddingTop;
        Keyboard.Key[] keyArr = this.mKeys;
        Keyboard.Key key = this.mInvalidatedKey;
        paint.setColor(this.mKeyTextColor);
        boolean z = false;
        if (key != null) {
            z = false;
            if (canvas.getClipBounds(rect)) {
                z = false;
                if ((key.x + i) - 1 <= rect.left) {
                    z = false;
                    if ((key.y + i2) - 1 <= rect.top) {
                        z = false;
                        if (key.x + key.width + i + 1 >= rect.right) {
                            z = false;
                            if (key.y + key.height + i2 + 1 >= rect.bottom) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        int length = keyArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            Keyboard.Key key2 = keyArr[i4];
            if (!z || key == key2) {
                drawable.setState(key2.getCurrentDrawableState());
                String charSequence = key2.label == null ? null : adjustCase(key2.label).toString();
                Rect bounds = drawable.getBounds();
                if (key2.width != bounds.right || key2.height != bounds.bottom) {
                    drawable.setBounds(0, 0, key2.width, key2.height);
                }
                canvas.translate(key2.x + i, key2.y + i2);
                drawable.draw(canvas);
                if (charSequence != null) {
                    if (charSequence.length() <= 1 || key2.codes.length >= 2) {
                        paint.setTextSize(this.mKeyTextSize);
                        paint.setTypeface(Typeface.DEFAULT);
                    } else {
                        paint.setTextSize(this.mLabelTextSize);
                        paint.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                    paint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, this.mShadowColor);
                    canvas.drawText(charSequence, (((key2.width - rect2.left) - rect2.right) / 2) + rect2.left, (((key2.height - rect2.top) - rect2.bottom) / 2) + ((paint.getTextSize() - paint.descent()) / 2.0f) + rect2.top, paint);
                    paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                } else if (key2.icon != null) {
                    canvas.translate(((((key2.width - rect2.left) - rect2.right) - key2.icon.getIntrinsicWidth()) / 2) + rect2.left, ((((key2.height - rect2.top) - rect2.bottom) - key2.icon.getIntrinsicHeight()) / 2) + rect2.top);
                    key2.icon.setBounds(0, 0, key2.icon.getIntrinsicWidth(), key2.icon.getIntrinsicHeight());
                    key2.icon.draw(canvas);
                    canvas.translate(-intrinsicWidth, -intrinsicHeight);
                }
                canvas.translate((-key2.x) - i, (-key2.y) - i2);
            }
            i3 = i4 + 1;
        }
        this.mInvalidatedKey = null;
        if (this.mMiniKeyboardOnScreen) {
            paint.setColor(((int) (this.mBackgroundDimAmount * 255.0f)) << 24);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
        }
        this.mDrawPending = false;
        this.mDirtyRect.setEmpty();
    }

    private boolean onModifiedTouchEvent(MotionEvent motionEvent, boolean z) {
        int i;
        int x = ((int) motionEvent.getX()) - this.mPaddingLeft;
        int y = ((int) motionEvent.getY()) - this.mPaddingTop;
        int i2 = y;
        if (y >= (-this.mVerticalCorrection)) {
            i2 = y + this.mVerticalCorrection;
        }
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        int keyIndices = getKeyIndices(x, i2, null);
        this.mPossiblePoly = z;
        if (action == 0) {
            this.mSwipeTracker.clear();
        }
        this.mSwipeTracker.addMovement(motionEvent);
        if (!this.mAbortKey || action == 0 || action == 3) {
            if (this.mGestureDetector.onTouchEvent(motionEvent)) {
                showPreview(-1);
                this.mHandler.removeMessages(3);
                this.mHandler.removeMessages(4);
                return true;
            } else if (!this.mMiniKeyboardOnScreen || action == 3) {
                switch (action) {
                    case 0:
                        this.mAbortKey = false;
                        this.mStartX = x;
                        this.mStartY = i2;
                        this.mLastCodeX = x;
                        this.mLastCodeY = i2;
                        this.mLastKeyTime = 0L;
                        this.mCurrentKeyTime = 0L;
                        this.mLastKey = -1;
                        this.mCurrentKey = keyIndices;
                        this.mDownKey = keyIndices;
                        this.mDownTime = motionEvent.getEventTime();
                        this.mLastMoveTime = this.mDownTime;
                        checkMultiTap(eventTime, keyIndices);
                        this.mKeyboardActionListener.onPress(keyIndices != -1 ? this.mKeys[keyIndices].codes[0] : 0);
                        if (this.mCurrentKey >= 0 && this.mKeys[this.mCurrentKey].repeatable) {
                            this.mRepeatKeyIndex = this.mCurrentKey;
                            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), 400L);
                            repeatKey();
                            if (this.mAbortKey) {
                                this.mRepeatKeyIndex = -1;
                                i = x;
                                break;
                            }
                        }
                        if (this.mCurrentKey != -1) {
                            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4, motionEvent), LONGPRESS_TIMEOUT);
                        }
                        showPreview(keyIndices);
                        i = x;
                        break;
                    case 1:
                        removeMessages();
                        if (keyIndices == this.mCurrentKey) {
                            this.mCurrentKeyTime += eventTime - this.mLastMoveTime;
                        } else {
                            resetMultiTap();
                            this.mLastKey = this.mCurrentKey;
                            this.mLastKeyTime = (this.mCurrentKeyTime + eventTime) - this.mLastMoveTime;
                            this.mCurrentKey = keyIndices;
                            this.mCurrentKeyTime = 0L;
                        }
                        i = x;
                        int i3 = i2;
                        if (this.mCurrentKeyTime < this.mLastKeyTime) {
                            i = x;
                            i3 = i2;
                            if (this.mCurrentKeyTime < 70) {
                                i = x;
                                i3 = i2;
                                if (this.mLastKey != -1) {
                                    this.mCurrentKey = this.mLastKey;
                                    i = this.mLastCodeX;
                                    i3 = this.mLastCodeY;
                                }
                            }
                        }
                        showPreview(-1);
                        Arrays.fill(this.mKeyIndices, -1);
                        if (this.mRepeatKeyIndex == -1 && !this.mMiniKeyboardOnScreen && !this.mAbortKey) {
                            detectAndSendKey(this.mCurrentKey, i, i3, eventTime);
                        }
                        invalidateKey(keyIndices);
                        this.mRepeatKeyIndex = -1;
                        i2 = i3;
                        break;
                    case 2:
                        boolean z2 = false;
                        if (keyIndices != -1) {
                            if (this.mCurrentKey == -1) {
                                this.mCurrentKey = keyIndices;
                                this.mCurrentKeyTime = eventTime - this.mDownTime;
                                z2 = false;
                            } else if (keyIndices == this.mCurrentKey) {
                                this.mCurrentKeyTime += eventTime - this.mLastMoveTime;
                                z2 = true;
                            } else {
                                z2 = false;
                                if (this.mRepeatKeyIndex == -1) {
                                    resetMultiTap();
                                    this.mLastKey = this.mCurrentKey;
                                    this.mLastCodeX = this.mLastX;
                                    this.mLastCodeY = this.mLastY;
                                    this.mLastKeyTime = (this.mCurrentKeyTime + eventTime) - this.mLastMoveTime;
                                    this.mCurrentKey = keyIndices;
                                    this.mCurrentKeyTime = 0L;
                                    z2 = false;
                                }
                            }
                        }
                        if (!z2) {
                            this.mHandler.removeMessages(4);
                            if (keyIndices != -1) {
                                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(4, motionEvent), LONGPRESS_TIMEOUT);
                            }
                        }
                        showPreview(this.mCurrentKey);
                        this.mLastMoveTime = eventTime;
                        i = x;
                        break;
                    case 3:
                        removeMessages();
                        dismissPopupKeyboard();
                        this.mAbortKey = true;
                        showPreview(-1);
                        invalidateKey(this.mCurrentKey);
                        i = x;
                        break;
                    default:
                        i = x;
                        break;
                }
                this.mLastX = i;
                this.mLastY = i2;
                return true;
            } else {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openPopupIfRequired(MotionEvent motionEvent) {
        boolean z;
        if (this.mPopupLayout == 0) {
            z = false;
        } else {
            z = false;
            if (this.mCurrentKey >= 0) {
                z = false;
                if (this.mCurrentKey < this.mKeys.length) {
                    boolean onLongPress = onLongPress(this.mKeys[this.mCurrentKey]);
                    z = onLongPress;
                    if (onLongPress) {
                        this.mAbortKey = true;
                        showPreview(-1);
                        return onLongPress;
                    }
                }
            }
        }
        return z;
    }

    private void removeMessages() {
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean repeatKey() {
        Keyboard.Key key = this.mKeys[this.mRepeatKeyIndex];
        detectAndSendKey(this.mCurrentKey, key.x, key.y, this.mLastTapTime);
        return true;
    }

    private void resetMultiTap() {
        this.mLastSentIndex = -1;
        this.mTapCount = 0;
        this.mLastTapTime = -1L;
        this.mInMultiTap = false;
    }

    private void sendAccessibilityEventForUnicodeCharacter(int i, int i2) {
        String string;
        boolean z = false;
        if (this.mAccessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
            onInitializeAccessibilityEvent(obtain);
            if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), Settings.Secure.ACCESSIBILITY_SPEAK_PASSWORD, 0, -3) != 0) {
                z = true;
            }
            if (z || this.mAudioManager.isBluetoothA2dpOn() || this.mAudioManager.isWiredHeadsetOn()) {
                switch (i2) {
                    case -6:
                        string = this.mContext.getString(17040998);
                        break;
                    case -5:
                        string = this.mContext.getString(17041000);
                        break;
                    case -4:
                        string = this.mContext.getString(17041001);
                        break;
                    case -3:
                        string = this.mContext.getString(17040999);
                        break;
                    case -2:
                        string = this.mContext.getString(17041002);
                        break;
                    case -1:
                        string = this.mContext.getString(17041003);
                        break;
                    case 10:
                        string = this.mContext.getString(17041004);
                        break;
                    default:
                        string = String.valueOf((char) i2);
                        break;
                }
            } else if (this.mHeadsetRequiredToHearPasswordsAnnounced) {
                string = this.mContext.getString(17041012);
            } else {
                if (i == 256) {
                    this.mHeadsetRequiredToHearPasswordsAnnounced = true;
                }
                string = this.mContext.getString(17041011);
            }
            obtain.getText().add(string);
            this.mAccessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKey(int i) {
        PopupWindow popupWindow = this.mPreviewPopup;
        Keyboard.Key[] keyArr = this.mKeys;
        if (i < 0 || i >= this.mKeys.length) {
            return;
        }
        Keyboard.Key key = keyArr[i];
        if (key.icon != null) {
            this.mPreviewText.setCompoundDrawables(null, null, null, key.iconPreview != null ? key.iconPreview : key.icon);
            this.mPreviewText.setText((CharSequence) null);
        } else {
            this.mPreviewText.setCompoundDrawables(null, null, null, null);
            this.mPreviewText.setText(getPreviewText(key));
            if (key.label.length() <= 1 || key.codes.length >= 2) {
                this.mPreviewText.setTextSize(0, this.mPreviewTextSizeLarge);
                this.mPreviewText.setTypeface(Typeface.DEFAULT);
            } else {
                this.mPreviewText.setTextSize(0, this.mKeyTextSize);
                this.mPreviewText.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
        this.mPreviewText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int max = Math.max(this.mPreviewText.getMeasuredWidth(), key.width + this.mPreviewText.getPaddingLeft() + this.mPreviewText.getPaddingRight());
        int i2 = this.mPreviewHeight;
        ViewGroup.LayoutParams layoutParams = this.mPreviewText.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = max;
            layoutParams.height = i2;
        }
        if (this.mPreviewCentered) {
            this.mPopupPreviewX = 160 - (this.mPreviewText.getMeasuredWidth() / 2);
            this.mPopupPreviewY = -this.mPreviewText.getMeasuredHeight();
        } else {
            this.mPopupPreviewX = (key.x - this.mPreviewText.getPaddingLeft()) + this.mPaddingLeft;
            this.mPopupPreviewY = (key.y - i2) + this.mPreviewOffset;
        }
        this.mHandler.removeMessages(2);
        getLocationInWindow(this.mCoordinates);
        int[] iArr = this.mCoordinates;
        iArr[0] = iArr[0] + this.mMiniKeyboardOffsetX;
        int[] iArr2 = this.mCoordinates;
        iArr2[1] = iArr2[1] + this.mMiniKeyboardOffsetY;
        this.mPreviewText.getBackground().setState(key.popupResId != 0 ? LONG_PRESSABLE_STATE_SET : EMPTY_STATE_SET);
        this.mPopupPreviewX += this.mCoordinates[0];
        this.mPopupPreviewY += this.mCoordinates[1];
        getLocationOnScreen(this.mCoordinates);
        if (this.mPopupPreviewY + this.mCoordinates[1] < 0) {
            if (key.x + key.width <= getWidth() / 2) {
                this.mPopupPreviewX += (int) (key.width * 2.5d);
            } else {
                this.mPopupPreviewX -= (int) (key.width * 2.5d);
            }
            this.mPopupPreviewY += i2;
        }
        if (popupWindow.isShowing()) {
            popupWindow.update(this.mPopupPreviewX, this.mPopupPreviewY, max, i2);
        } else {
            popupWindow.setWidth(max);
            popupWindow.setHeight(i2);
            popupWindow.showAtLocation(this.mPopupParent, 0, this.mPopupPreviewX, this.mPopupPreviewY);
        }
        this.mPreviewText.setVisibility(0);
    }

    private void showPreview(int i) {
        int i2 = this.mCurrentKeyIndex;
        PopupWindow popupWindow = this.mPreviewPopup;
        this.mCurrentKeyIndex = i;
        Keyboard.Key[] keyArr = this.mKeys;
        if (i2 != this.mCurrentKeyIndex) {
            if (i2 != -1 && keyArr.length > i2) {
                Keyboard.Key key = keyArr[i2];
                key.onReleased(this.mCurrentKeyIndex == -1);
                invalidateKey(i2);
                int i3 = key.codes[0];
                sendAccessibilityEventForUnicodeCharacter(256, i3);
                sendAccessibilityEventForUnicodeCharacter(65536, i3);
            }
            if (this.mCurrentKeyIndex != -1 && keyArr.length > this.mCurrentKeyIndex) {
                Keyboard.Key key2 = keyArr[this.mCurrentKeyIndex];
                key2.onPressed();
                invalidateKey(this.mCurrentKeyIndex);
                int i4 = key2.codes[0];
                sendAccessibilityEventForUnicodeCharacter(128, i4);
                sendAccessibilityEventForUnicodeCharacter(32768, i4);
            }
        }
        if (i2 == this.mCurrentKeyIndex || !this.mShowPreview) {
            return;
        }
        this.mHandler.removeMessages(1);
        if (popupWindow.isShowing() && i == -1) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 70L);
        }
        if (i != -1) {
            if (popupWindow.isShowing() && this.mPreviewText.getVisibility() == 0) {
                showKey(i);
            } else {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, i, 0), 0L);
            }
        }
    }

    public void closing() {
        if (this.mPreviewPopup.isShowing()) {
            this.mPreviewPopup.dismiss();
        }
        removeMessages();
        dismissPopupKeyboard();
        this.mBuffer = null;
        this.mCanvas = null;
        this.mMiniKeyboardCache.clear();
    }

    public Keyboard getKeyboard() {
        return this.mKeyboard;
    }

    protected OnKeyboardActionListener getOnKeyboardActionListener() {
        return this.mKeyboardActionListener;
    }

    public boolean handleBack() {
        if (this.mPopupKeyboard.isShowing()) {
            dismissPopupKeyboard();
            return true;
        }
        return false;
    }

    public void invalidateAllKeys() {
        this.mDirtyRect.union(0, 0, getWidth(), getHeight());
        this.mDrawPending = true;
        invalidate();
    }

    public void invalidateKey(int i) {
        if (this.mKeys != null && i >= 0 && i < this.mKeys.length) {
            Keyboard.Key key = this.mKeys[i];
            this.mInvalidatedKey = key;
            this.mDirtyRect.union(key.x + this.mPaddingLeft, key.y + this.mPaddingTop, key.x + key.width + this.mPaddingLeft, key.y + key.height + this.mPaddingTop);
            onBufferDraw();
            invalidate(key.x + this.mPaddingLeft, key.y + this.mPaddingTop, key.x + key.width + this.mPaddingLeft, key.y + key.height + this.mPaddingTop);
        }
    }

    public boolean isPreviewEnabled() {
        return this.mShowPreview;
    }

    public boolean isProximityCorrectionEnabled() {
        return this.mProximityCorrectOn;
    }

    public boolean isShifted() {
        if (this.mKeyboard != null) {
            return this.mKeyboard.isShifted();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismissPopupKeyboard();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closing();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawPending || this.mBuffer == null || this.mKeyboardChanged) {
            onBufferDraw();
        }
        canvas.drawBitmap(this.mBuffer, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (this.mAccessibilityManager.isTouchExplorationEnabled()) {
            z = true;
            if (motionEvent.getPointerCount() == 1) {
                switch (motionEvent.getAction()) {
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
                z = onTouchEvent(motionEvent);
            }
        }
        return z;
    }

    protected boolean onLongPress(Keyboard.Key key) {
        boolean z = false;
        int i = key.popupResId;
        if (i != 0) {
            this.mMiniKeyboardContainer = this.mMiniKeyboardCache.get(key);
            if (this.mMiniKeyboardContainer == null) {
                this.mMiniKeyboardContainer = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(this.mPopupLayout, (ViewGroup) null);
                this.mMiniKeyboard = (KeyboardView) this.mMiniKeyboardContainer.findViewById(R.id.keyboardView);
                View findViewById = this.mMiniKeyboardContainer.findViewById(R.id.closeButton);
                if (findViewById != null) {
                    findViewById.setOnClickListener(this);
                }
                this.mMiniKeyboard.setOnKeyboardActionListener(new OnKeyboardActionListener() { // from class: android.inputmethodservice.KeyboardView.3
                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void onKey(int i2, int[] iArr) {
                        KeyboardView.this.mKeyboardActionListener.onKey(i2, iArr);
                        KeyboardView.this.dismissPopupKeyboard();
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void onPress(int i2) {
                        KeyboardView.this.mKeyboardActionListener.onPress(i2);
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void onRelease(int i2) {
                        KeyboardView.this.mKeyboardActionListener.onRelease(i2);
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void onText(CharSequence charSequence) {
                        KeyboardView.this.mKeyboardActionListener.onText(charSequence);
                        KeyboardView.this.dismissPopupKeyboard();
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void swipeDown() {
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void swipeLeft() {
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void swipeRight() {
                    }

                    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
                    public void swipeUp() {
                    }
                });
                this.mMiniKeyboard.setKeyboard(key.popupCharacters != null ? new Keyboard(getContext(), i, key.popupCharacters, -1, getPaddingLeft() + getPaddingRight()) : new Keyboard(getContext(), i));
                this.mMiniKeyboard.setPopupParent(this);
                this.mMiniKeyboardContainer.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                this.mMiniKeyboardCache.put(key, this.mMiniKeyboardContainer);
            } else {
                this.mMiniKeyboard = (KeyboardView) this.mMiniKeyboardContainer.findViewById(R.id.keyboardView);
            }
            getLocationInWindow(this.mCoordinates);
            this.mPopupX = key.x + this.mPaddingLeft;
            this.mPopupY = key.y + this.mPaddingTop;
            this.mPopupX = (this.mPopupX + key.width) - this.mMiniKeyboardContainer.getMeasuredWidth();
            this.mPopupY -= this.mMiniKeyboardContainer.getMeasuredHeight();
            int paddingRight = this.mPopupX + this.mMiniKeyboardContainer.getPaddingRight() + this.mCoordinates[0];
            int paddingBottom = this.mPopupY + this.mMiniKeyboardContainer.getPaddingBottom() + this.mCoordinates[1];
            this.mMiniKeyboard.setPopupOffset(paddingRight < 0 ? 0 : paddingRight, paddingBottom);
            this.mMiniKeyboard.setShifted(isShifted());
            this.mPopupKeyboard.setContentView(this.mMiniKeyboardContainer);
            this.mPopupKeyboard.setWidth(this.mMiniKeyboardContainer.getMeasuredWidth());
            this.mPopupKeyboard.setHeight(this.mMiniKeyboardContainer.getMeasuredHeight());
            this.mPopupKeyboard.showAtLocation(this, 0, paddingRight, paddingBottom);
            this.mMiniKeyboardOnScreen = true;
            invalidateAllKeys();
            z = true;
        }
        return z;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mKeyboard == null) {
            setMeasuredDimension(this.mPaddingLeft + this.mPaddingRight, this.mPaddingTop + this.mPaddingBottom);
            return;
        }
        int minWidth = this.mKeyboard.getMinWidth() + this.mPaddingLeft + this.mPaddingRight;
        int i3 = minWidth;
        if (View.MeasureSpec.getSize(i) < minWidth + 10) {
            i3 = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(i3, this.mKeyboard.getHeight() + this.mPaddingTop + this.mPaddingBottom);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mKeyboard != null) {
            this.mKeyboard.resize(i, i2);
        }
        this.mBuffer = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        if (pointerCount != this.mOldPointerCount) {
            if (pointerCount == 1) {
                MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                z = onModifiedTouchEvent(obtain, false);
                obtain.recycle();
                if (action == 1) {
                    z = onModifiedTouchEvent(motionEvent, true);
                }
            } else {
                MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 1, this.mOldPointerX, this.mOldPointerY, motionEvent.getMetaState());
                z = onModifiedTouchEvent(obtain2, true);
                obtain2.recycle();
            }
        } else if (pointerCount == 1) {
            z = onModifiedTouchEvent(motionEvent, false);
            this.mOldPointerX = motionEvent.getX();
            this.mOldPointerY = motionEvent.getY();
        } else {
            z = true;
        }
        this.mOldPointerCount = pointerCount;
        return z;
    }

    public void setKeyboard(Keyboard keyboard) {
        if (this.mKeyboard != null) {
            showPreview(-1);
        }
        removeMessages();
        this.mKeyboard = keyboard;
        List<Keyboard.Key> keys = this.mKeyboard.getKeys();
        this.mKeys = (Keyboard.Key[]) keys.toArray(new Keyboard.Key[keys.size()]);
        requestLayout();
        this.mKeyboardChanged = true;
        invalidateAllKeys();
        computeProximityThreshold(keyboard);
        this.mMiniKeyboardCache.clear();
        this.mAbortKey = true;
    }

    public void setOnKeyboardActionListener(OnKeyboardActionListener onKeyboardActionListener) {
        this.mKeyboardActionListener = onKeyboardActionListener;
    }

    public void setPopupOffset(int i, int i2) {
        this.mMiniKeyboardOffsetX = i;
        this.mMiniKeyboardOffsetY = i2;
        if (this.mPreviewPopup.isShowing()) {
            this.mPreviewPopup.dismiss();
        }
    }

    public void setPopupParent(View view) {
        this.mPopupParent = view;
    }

    public void setPreviewEnabled(boolean z) {
        this.mShowPreview = z;
    }

    public void setProximityCorrectionEnabled(boolean z) {
        this.mProximityCorrectOn = z;
    }

    public boolean setShifted(boolean z) {
        if (this.mKeyboard == null || !this.mKeyboard.setShifted(z)) {
            return false;
        }
        invalidateAllKeys();
        return true;
    }

    public void setVerticalCorrection(int i) {
    }

    protected void swipeDown() {
        this.mKeyboardActionListener.swipeDown();
    }

    protected void swipeLeft() {
        this.mKeyboardActionListener.swipeLeft();
    }

    protected void swipeRight() {
        this.mKeyboardActionListener.swipeRight();
    }

    protected void swipeUp() {
        this.mKeyboardActionListener.swipeUp();
    }
}

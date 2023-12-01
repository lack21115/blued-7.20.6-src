package android.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.UndoManager;
import android.content.res.ColorStateList;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.GetChars;
import android.text.GraphicsOperations;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.AllCapsTransformationMethod;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.LinkMovementMethod;
import android.text.method.MetaKeyKeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.method.TransformationMethod2;
import android.text.method.WordIterator;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.AccessibilityIterators;
import android.view.ActionMode;
import android.view.Choreographer;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import android.widget.AccessibilityIterators;
import android.widget.Editor;
import android.widget.RemoteViews;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.util.FastMath;
import com.android.internal.widget.EditableInputConnection;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/TextView.class */
public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
    private static final int ANIMATED_SCROLL_GAP = 250;
    private static final int CHANGE_WATCHER_PRIORITY = 100;
    static final boolean DEBUG_EXTRACT = false;
    private static final int DECIMAL = 4;
    private static final int EMS = 1;
    static final int ID_COPY = 16908321;
    static final int ID_CUT = 16908320;
    static final int ID_PASTE = 16908322;
    static final int ID_SELECT_ALL = 16908319;
    static long LAST_CUT_OR_COPY_TIME = 0;
    private static final int LINES = 1;
    static final String LOG_TAG = "TextView";
    private static final int MARQUEE_FADE_NORMAL = 0;
    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    private static final int MONOSPACE = 3;
    private static final int PIXELS = 2;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int SIGNED = 2;
    private static final BoringLayout.Metrics UNKNOWN_BORING;
    private static final int VERY_WIDE = 1048576;
    private boolean mAllowTransformationLengthChange;
    private int mAutoLinkMask;
    private BoringLayout.Metrics mBoring;
    private BufferType mBufferType;
    private ChangeWatcher mChangeWatcher;
    private CharWrapper mCharWrapper;
    private int mCurHintTextColor;
    @ViewDebug.ExportedProperty(category = "text")
    private int mCurTextColor;
    private volatile Locale mCurrentSpellCheckerLocaleCache;
    int mCursorDrawableRes;
    private int mDeferScroll;
    private int mDesiredHeightAtMeasure;
    private boolean mDispatchTemporaryDetach;
    Drawables mDrawables;
    private Editable.Factory mEditableFactory;
    private Editor mEditor;
    private TextUtils.TruncateAt mEllipsize;
    private InputFilter[] mFilters;
    private boolean mFreezesText;
    private int mGravity;
    int mHighlightColor;
    private final Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mHighlightPathBogus;
    private CharSequence mHint;
    private BoringLayout.Metrics mHintBoring;
    private Layout mHintLayout;
    private ColorStateList mHintTextColor;
    private boolean mHorizontallyScrolling;
    private boolean mIncludePad;
    private int mLastLayoutDirection;
    private long mLastScroll;
    private Layout mLayout;
    private ColorStateList mLinkTextColor;
    private boolean mLinksClickable;
    private ArrayList<TextWatcher> mListeners;
    private Marquee mMarquee;
    private int mMarqueeFadeMode;
    private int mMarqueeRepeatLimit;
    private int mMaxMode;
    private int mMaxWidth;
    private int mMaxWidthMode;
    private int mMaximum;
    private int mMinMode;
    private int mMinWidth;
    private int mMinWidthMode;
    private int mMinimum;
    private MovementMethod mMovement;
    private int mOldMaxMode;
    private int mOldMaximum;
    private boolean mPreDrawListenerDetached;
    private boolean mPreDrawRegistered;
    private boolean mPreventDefaultMovement;
    private boolean mRestartMarquee;
    private BoringLayout mSavedHintLayout;
    private BoringLayout mSavedLayout;
    private Layout mSavedMarqueeModeLayout;
    private Scroller mScroller;
    private int mShadowColor;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;
    private boolean mSingleLine;
    private float mSpacingAdd;
    private float mSpacingMult;
    private Spannable.Factory mSpannableFactory;
    private Rect mTempRect;
    boolean mTemporaryDetach;
    @ViewDebug.ExportedProperty(category = "text")
    private CharSequence mText;
    private ColorStateList mTextColor;
    private TextDirectionHeuristic mTextDir;
    int mTextEditSuggestionItemLayout;
    private final TextPaint mTextPaint;
    int mTextSelectHandleLeftRes;
    int mTextSelectHandleRes;
    int mTextSelectHandleRightRes;
    private TransformationMethod mTransformation;
    private CharSequence mTransformed;
    private boolean mUserSetTextScaleX;
    private static final RectF TEMP_RECTF = new RectF();
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static final Spanned EMPTY_SPANNED = new SpannedString("");
    private static final int[] MULTILINE_STATE_SET = {16843597};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.widget.TextView$4  reason: invalid class name */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment = new int[Layout.Alignment.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0043 -> B:29:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0047 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004b -> B:27:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004f -> B:25:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$BufferType.class */
    public enum BufferType {
        NORMAL,
        SPANNABLE,
        EDITABLE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$ChangeWatcher.class */
    public class ChangeWatcher implements TextWatcher, SpanWatcher {
        private CharSequence mBeforeText;

        private ChangeWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView.this.sendAfterTextChanged(editable);
            if (MetaKeyKeyListener.getMetaState(editable, 2048) != 0) {
                MetaKeyKeyListener.stopSelecting(TextView.this, editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (AccessibilityManager.getInstance(TextView.this.mContext).isEnabled() && ((!TextView.isPasswordInputType(TextView.this.getInputType()) && !TextView.this.hasPasswordTransformationMethod()) || TextView.this.shouldSpeakPasswordsForAccessibility())) {
                this.mBeforeText = charSequence.toString();
            }
            TextView.this.sendBeforeTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            TextView.this.spanChange(spannable, obj, -1, i, -1, i2);
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            TextView.this.spanChange(spannable, obj, i, i3, i2, i4);
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            TextView.this.spanChange(spannable, obj, i, -1, i2, -1);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TextView.this.handleTextChanged(charSequence, i, i2, i3);
            if (AccessibilityManager.getInstance(TextView.this.mContext).isEnabled()) {
                if (TextView.this.isFocused() || (TextView.this.isSelected() && TextView.this.isShown())) {
                    TextView.this.sendAccessibilityEventTypeViewTextChanged(this.mBeforeText, i, i2, i3);
                    this.mBeforeText = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$CharWrapper.class */
    public static class CharWrapper implements CharSequence, GetChars, GraphicsOperations {
        private char[] mChars;
        private int mLength;
        private int mStart;

        public CharWrapper(char[] cArr, int i, int i2) {
            this.mChars = cArr;
            this.mStart = i;
            this.mLength = i2;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.mChars[this.mStart + i];
        }

        @Override // android.text.GraphicsOperations
        public void drawText(Canvas canvas, int i, int i2, float f, float f2, Paint paint) {
            canvas.drawText(this.mChars, i + this.mStart, i2 - i, f, f2, paint);
        }

        @Override // android.text.GraphicsOperations
        public void drawTextRun(Canvas canvas, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
            canvas.drawTextRun(this.mChars, i + this.mStart, i2 - i, i3 + this.mStart, i4 - i3, f, f2, z, paint);
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            if (i < 0 || i2 < 0 || i > this.mLength || i2 > this.mLength) {
                throw new IndexOutOfBoundsException(i + ", " + i2);
            }
            System.arraycopy(this.mChars, this.mStart + i, cArr, i3, i2 - i);
        }

        @Override // android.text.GraphicsOperations
        public float getTextRunAdvances(int i, int i2, int i3, int i4, boolean z, float[] fArr, int i5, Paint paint) {
            return paint.getTextRunAdvances(this.mChars, i + this.mStart, i2 - i, i3 + this.mStart, i4 - i3, z, fArr, i5);
        }

        @Override // android.text.GraphicsOperations
        public int getTextRunCursor(int i, int i2, int i3, int i4, int i5, Paint paint) {
            return paint.getTextRunCursor(this.mChars, i + this.mStart, i2 - i, i3, i4 + this.mStart, i5);
        }

        @Override // android.text.GraphicsOperations
        public int getTextWidths(int i, int i2, float[] fArr, Paint paint) {
            return paint.getTextWidths(this.mChars, this.mStart + i, i2 - i, fArr);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mLength;
        }

        @Override // android.text.GraphicsOperations
        public float measureText(int i, int i2, Paint paint) {
            return paint.measureText(this.mChars, this.mStart + i, i2 - i);
        }

        void set(char[] cArr, int i, int i2) {
            this.mChars = cArr;
            this.mStart = i;
            this.mLength = i2;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            if (i < 0 || i2 < 0 || i > this.mLength || i2 > this.mLength) {
                throw new IndexOutOfBoundsException(i + ", " + i2);
            }
            return new String(this.mChars, this.mStart + i, i2 - i);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return new String(this.mChars, this.mStart, this.mLength);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$Drawables.class */
    public static class Drawables {
        static final int DRAWABLE_LEFT = 1;
        static final int DRAWABLE_NONE = -1;
        static final int DRAWABLE_RIGHT = 0;
        Drawable mDrawableBottom;
        Drawable mDrawableEnd;
        Drawable mDrawableError;
        int mDrawableHeightEnd;
        int mDrawableHeightError;
        int mDrawableHeightLeft;
        int mDrawableHeightRight;
        int mDrawableHeightStart;
        int mDrawableHeightTemp;
        Drawable mDrawableLeft;
        Drawable mDrawableLeftInitial;
        int mDrawablePadding;
        Drawable mDrawableRight;
        Drawable mDrawableRightInitial;
        int mDrawableSizeBottom;
        int mDrawableSizeEnd;
        int mDrawableSizeError;
        int mDrawableSizeLeft;
        int mDrawableSizeRight;
        int mDrawableSizeStart;
        int mDrawableSizeTemp;
        int mDrawableSizeTop;
        Drawable mDrawableStart;
        Drawable mDrawableTemp;
        Drawable mDrawableTop;
        int mDrawableWidthBottom;
        int mDrawableWidthTop;
        boolean mIsRtlCompatibilityMode;
        boolean mOverride;
        final Rect mCompoundRect = new Rect();
        int mDrawableSaved = -1;

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
            if (r6 != false) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Drawables(android.content.Context r5) {
            /*
                r4 = this;
                r0 = 1
                r9 = r0
                r0 = r4
                r0.<init>()
                r0 = r4
                android.graphics.Rect r1 = new android.graphics.Rect
                r2 = r1
                r2.<init>()
                r0.mCompoundRect = r1
                r0 = r4
                r1 = -1
                r0.mDrawableSaved = r1
                r0 = r5
                android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
                int r0 = r0.targetSdkVersion
                r7 = r0
                r0 = r5
                android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
                int r0 = r0.flags
                r1 = 1
                r0 = r0 & r1
                if (r0 == 0) goto L55
                r0 = 1
                r6 = r0
            L2d:
                r0 = r7
                r1 = 17
                if (r0 >= r1) goto L3b
                r0 = r9
                r8 = r0
                r0 = r6
                if (r0 == 0) goto L49
            L3b:
                r0 = r5
                android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
                boolean r0 = r0.hasRtlSupport()
                if (r0 != 0) goto L5a
                r0 = r9
                r8 = r0
            L49:
                r0 = r4
                r1 = r8
                r0.mIsRtlCompatibilityMode = r1
                r0 = r4
                r1 = 0
                r0.mOverride = r1
                return
            L55:
                r0 = 0
                r6 = r0
                goto L2d
            L5a:
                r0 = 0
                r8 = r0
                goto L49
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.Drawables.<init>(android.content.Context):void");
        }

        private void applyErrorDrawableIfNeeded(int i) {
            switch (this.mDrawableSaved) {
                case 0:
                    this.mDrawableRight = this.mDrawableTemp;
                    this.mDrawableSizeRight = this.mDrawableSizeTemp;
                    this.mDrawableHeightRight = this.mDrawableHeightTemp;
                    break;
                case 1:
                    this.mDrawableLeft = this.mDrawableTemp;
                    this.mDrawableSizeLeft = this.mDrawableSizeTemp;
                    this.mDrawableHeightLeft = this.mDrawableHeightTemp;
                    break;
            }
            if (this.mDrawableError != null) {
                switch (i) {
                    case 1:
                        this.mDrawableSaved = 1;
                        this.mDrawableTemp = this.mDrawableLeft;
                        this.mDrawableSizeTemp = this.mDrawableSizeLeft;
                        this.mDrawableHeightTemp = this.mDrawableHeightLeft;
                        this.mDrawableLeft = this.mDrawableError;
                        this.mDrawableSizeLeft = this.mDrawableSizeError;
                        this.mDrawableHeightLeft = this.mDrawableHeightError;
                        return;
                    default:
                        this.mDrawableSaved = 0;
                        this.mDrawableTemp = this.mDrawableRight;
                        this.mDrawableSizeTemp = this.mDrawableSizeRight;
                        this.mDrawableHeightTemp = this.mDrawableHeightRight;
                        this.mDrawableRight = this.mDrawableError;
                        this.mDrawableSizeRight = this.mDrawableSizeError;
                        this.mDrawableHeightRight = this.mDrawableHeightError;
                        return;
                }
            }
        }

        private void updateDrawablesLayoutDirection(int i) {
            if (this.mDrawableLeft != null) {
                this.mDrawableLeft.setLayoutDirection(i);
            }
            if (this.mDrawableRight != null) {
                this.mDrawableRight.setLayoutDirection(i);
            }
            if (this.mDrawableTop != null) {
                this.mDrawableTop.setLayoutDirection(i);
            }
            if (this.mDrawableBottom != null) {
                this.mDrawableBottom.setLayoutDirection(i);
            }
        }

        public void resolveWithLayoutDirection(int i) {
            this.mDrawableLeft = this.mDrawableLeftInitial;
            this.mDrawableRight = this.mDrawableRightInitial;
            if (!this.mIsRtlCompatibilityMode) {
                switch (i) {
                    case 1:
                        if (this.mOverride) {
                            this.mDrawableRight = this.mDrawableStart;
                            this.mDrawableSizeRight = this.mDrawableSizeStart;
                            this.mDrawableHeightRight = this.mDrawableHeightStart;
                            this.mDrawableLeft = this.mDrawableEnd;
                            this.mDrawableSizeLeft = this.mDrawableSizeEnd;
                            this.mDrawableHeightLeft = this.mDrawableHeightEnd;
                            break;
                        }
                        break;
                    default:
                        if (this.mOverride) {
                            this.mDrawableLeft = this.mDrawableStart;
                            this.mDrawableSizeLeft = this.mDrawableSizeStart;
                            this.mDrawableHeightLeft = this.mDrawableHeightStart;
                            this.mDrawableRight = this.mDrawableEnd;
                            this.mDrawableSizeRight = this.mDrawableSizeEnd;
                            this.mDrawableHeightRight = this.mDrawableHeightEnd;
                            break;
                        }
                        break;
                }
            } else {
                if (this.mDrawableStart != null && this.mDrawableLeft == null) {
                    this.mDrawableLeft = this.mDrawableStart;
                    this.mDrawableSizeLeft = this.mDrawableSizeStart;
                    this.mDrawableHeightLeft = this.mDrawableHeightStart;
                }
                if (this.mDrawableEnd != null && this.mDrawableRight == null) {
                    this.mDrawableRight = this.mDrawableEnd;
                    this.mDrawableSizeRight = this.mDrawableSizeEnd;
                    this.mDrawableHeightRight = this.mDrawableHeightEnd;
                }
            }
            applyErrorDrawableIfNeeded(i);
            updateDrawablesLayoutDirection(i);
        }

        public void setErrorDrawable(Drawable drawable, TextView textView) {
            if (this.mDrawableError != drawable && this.mDrawableError != null) {
                this.mDrawableError.setCallback(null);
            }
            this.mDrawableError = drawable;
            Rect rect = this.mCompoundRect;
            int[] drawableState = textView.getDrawableState();
            if (this.mDrawableError == null) {
                this.mDrawableHeightError = 0;
                this.mDrawableSizeError = 0;
                return;
            }
            this.mDrawableError.setState(drawableState);
            this.mDrawableError.copyBounds(rect);
            this.mDrawableError.setCallback(textView);
            this.mDrawableSizeError = rect.width();
            this.mDrawableHeightError = rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$Marquee.class */
    public static final class Marquee {
        private static final int MARQUEE_DELAY = 1200;
        private static final float MARQUEE_DELTA_MAX = 0.07f;
        private static final int MARQUEE_DP_PER_SECOND = 30;
        private static final int MARQUEE_RESTART_DELAY = 1200;
        private static final byte MARQUEE_RUNNING = 2;
        private static final byte MARQUEE_STARTING = 1;
        private static final byte MARQUEE_STOPPED = 0;
        private float mFadeStop;
        private float mGhostOffset;
        private float mGhostStart;
        private long mLastAnimationMs;
        private float mMaxFadeScroll;
        private float mMaxScroll;
        private final float mPixelsPerSecond;
        private int mRepeatLimit;
        private float mScroll;
        private final WeakReference<TextView> mView;
        private byte mStatus = 0;
        private Choreographer.FrameCallback mTickCallback = new Choreographer.FrameCallback() { // from class: android.widget.TextView.Marquee.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Marquee.this.tick();
            }
        };
        private Choreographer.FrameCallback mStartCallback = new Choreographer.FrameCallback() { // from class: android.widget.TextView.Marquee.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Marquee.this.mStatus = (byte) 2;
                Marquee.this.mLastAnimationMs = Marquee.this.mChoreographer.getFrameTime();
                Marquee.this.tick();
            }
        };
        private Choreographer.FrameCallback mRestartCallback = new Choreographer.FrameCallback() { // from class: android.widget.TextView.Marquee.3
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (Marquee.this.mStatus == 2) {
                    if (Marquee.this.mRepeatLimit >= 0) {
                        Marquee.access$710(Marquee.this);
                    }
                    Marquee.this.start(Marquee.this.mRepeatLimit);
                }
            }
        };
        private final Choreographer mChoreographer = Choreographer.getInstance();

        Marquee(TextView textView) {
            this.mPixelsPerSecond = 30.0f * textView.getContext().getResources().getDisplayMetrics().density;
            this.mView = new WeakReference<>(textView);
        }

        static /* synthetic */ int access$710(Marquee marquee) {
            int i = marquee.mRepeatLimit;
            marquee.mRepeatLimit = i - 1;
            return i;
        }

        private void resetScroll() {
            this.mScroll = 0.0f;
            TextView textView = this.mView.get();
            if (textView != null) {
                textView.invalidate();
            }
        }

        float getGhostOffset() {
            return this.mGhostOffset;
        }

        float getMaxFadeScroll() {
            return this.mMaxFadeScroll;
        }

        float getScroll() {
            return this.mScroll;
        }

        boolean isRunning() {
            return this.mStatus == 2;
        }

        boolean isStopped() {
            return this.mStatus == 0;
        }

        boolean shouldDrawGhost() {
            return this.mStatus == 2 && this.mScroll > this.mGhostStart;
        }

        boolean shouldDrawLeftFade() {
            return this.mScroll <= this.mFadeStop;
        }

        void start(int i) {
            if (i == 0) {
                stop();
                return;
            }
            this.mRepeatLimit = i;
            TextView textView = this.mView.get();
            if (textView == null || textView.mLayout == null) {
                return;
            }
            this.mStatus = (byte) 1;
            this.mScroll = 0.0f;
            int width = (textView.getWidth() - textView.getCompoundPaddingLeft()) - textView.getCompoundPaddingRight();
            float lineWidth = textView.mLayout.getLineWidth(0);
            float f = width / 3.0f;
            this.mGhostStart = (lineWidth - width) + f;
            this.mMaxScroll = this.mGhostStart + width;
            this.mGhostOffset = lineWidth + f;
            this.mFadeStop = (width / 6.0f) + lineWidth;
            this.mMaxFadeScroll = this.mGhostStart + lineWidth + lineWidth;
            textView.invalidate();
            this.mChoreographer.postFrameCallback(this.mStartCallback);
        }

        void stop() {
            this.mStatus = (byte) 0;
            this.mChoreographer.removeFrameCallback(this.mStartCallback);
            this.mChoreographer.removeFrameCallback(this.mRestartCallback);
            this.mChoreographer.removeFrameCallback(this.mTickCallback);
            resetScroll();
        }

        void tick() {
            if (this.mStatus != 2) {
                return;
            }
            this.mChoreographer.removeFrameCallback(this.mTickCallback);
            TextView textView = this.mView.get();
            if (textView != null) {
                if (textView.isFocused() || textView.isSelected()) {
                    long frameTime = this.mChoreographer.getFrameTime();
                    long j = this.mLastAnimationMs;
                    this.mLastAnimationMs = frameTime;
                    this.mScroll += (((float) (frameTime - j)) / 1000.0f) * this.mPixelsPerSecond;
                    if (this.mScroll > this.mMaxScroll) {
                        this.mScroll = this.mMaxScroll;
                        this.mChoreographer.postFrameCallbackDelayed(this.mRestartCallback, 1200L);
                    } else {
                        this.mChoreographer.postFrameCallback(this.mTickCallback);
                    }
                    textView.invalidate();
                }
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$OnEditorActionListener.class */
    public interface OnEditorActionListener {
        boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TextView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.TextView.SavedState.1
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
        CharSequence error;
        boolean frozenWithFocus;
        int selEnd;
        int selStart;
        CharSequence text;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selStart = parcel.readInt();
            this.selEnd = parcel.readInt();
            this.frozenWithFocus = parcel.readInt() != 0;
            this.text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                this.error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            String str = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.selStart + " end=" + this.selEnd;
            String str2 = str;
            if (this.text != null) {
                str2 = str + " text=" + ((Object) this.text);
            }
            return str2 + i.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.selStart);
            parcel.writeInt(this.selEnd);
            parcel.writeInt(this.frozenWithFocus ? 1 : 0);
            TextUtils.writeToParcel(this.text, parcel, i);
            if (this.error == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            TextUtils.writeToParcel(this.error, parcel, i);
        }
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
        UNKNOWN_BORING = new BoringLayout.Metrics();
    }

    public TextView(Context context) {
        this(context, null);
    }

    public TextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public TextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        BufferType bufferType;
        int i3;
        TextKeyListener.Capitalize capitalize;
        this.mEditableFactory = Editable.Factory.getInstance();
        this.mSpannableFactory = Spannable.Factory.getInstance();
        this.mMarqueeRepeatLimit = 3;
        this.mLastLayoutDirection = -1;
        this.mMarqueeFadeMode = 0;
        this.mBufferType = BufferType.NORMAL;
        this.mGravity = BadgeDrawable.TOP_START;
        this.mLinksClickable = true;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mMaximum = Integer.MAX_VALUE;
        this.mMaxMode = 1;
        this.mMinimum = 0;
        this.mMinMode = 1;
        this.mOldMaximum = this.mMaximum;
        this.mOldMaxMode = this.mMaxMode;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxWidthMode = 2;
        this.mMinWidth = 0;
        this.mMinWidthMode = 2;
        this.mDesiredHeightAtMeasure = -1;
        this.mIncludePad = true;
        this.mDeferScroll = -1;
        this.mFilters = NO_FILTERS;
        this.mHighlightColor = 1714664933;
        this.mHighlightPathBogus = true;
        this.mText = "";
        Resources resources = getResources();
        CompatibilityInfo compatibilityInfo = resources.getCompatibilityInfo();
        this.mTextPaint = new TextPaint(1);
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        this.mTextPaint.setCompatibilityScaling(compatibilityInfo.applicationScale);
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setCompatibilityScaling(compatibilityInfo.applicationScale);
        this.mMovement = getDefaultMovementMethod();
        this.mTransformation = null;
        int i4 = 0;
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        ColorStateList colorStateList3 = null;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        int i5 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z3 = false;
        float f4 = 0.0f;
        String str2 = null;
        Resources.Theme theme = context.getTheme();
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.TextViewAppearance, i, i2);
        TypedArray typedArray = null;
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        typedArray = resourceId != -1 ? theme.obtainStyledAttributes(resourceId, R.styleable.TextAppearance) : typedArray;
        int i6 = -1;
        int i7 = 15;
        int i8 = -1;
        if (typedArray != null) {
            int indexCount = typedArray.getIndexCount();
            i8 = -1;
            i7 = 15;
            colorStateList3 = null;
            colorStateList2 = null;
            i4 = 0;
            colorStateList = null;
            i6 = -1;
            i5 = 0;
            f3 = 0.0f;
            f4 = 0.0f;
            str2 = null;
            str = null;
            z3 = false;
            f2 = 0.0f;
            f = 0.0f;
            z2 = false;
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArray.getIndex(i9);
                switch (index) {
                    case 0:
                        i7 = typedArray.getDimensionPixelSize(index, i7);
                        break;
                    case 1:
                        i8 = typedArray.getInt(index, -1);
                        break;
                    case 2:
                        i6 = typedArray.getInt(index, -1);
                        break;
                    case 3:
                        colorStateList = typedArray.getColorStateList(index);
                        break;
                    case 4:
                        i4 = typedArray.getColor(index, i4);
                        break;
                    case 5:
                        colorStateList2 = typedArray.getColorStateList(index);
                        break;
                    case 6:
                        colorStateList3 = typedArray.getColorStateList(index);
                        break;
                    case 7:
                        i5 = typedArray.getInt(index, 0);
                        break;
                    case 8:
                        f = typedArray.getFloat(index, 0.0f);
                        break;
                    case 9:
                        f2 = typedArray.getFloat(index, 0.0f);
                        break;
                    case 10:
                        f3 = typedArray.getFloat(index, 0.0f);
                        break;
                    case 11:
                        z2 = typedArray.getBoolean(index, false);
                        break;
                    case 12:
                        str = typedArray.getString(index);
                        break;
                    case 13:
                        z3 = typedArray.getBoolean(index, false);
                        break;
                    case 14:
                        f4 = typedArray.getFloat(index, 0.0f);
                        break;
                    case 15:
                        str2 = typedArray.getString(index);
                        break;
                }
            }
            typedArray.recycle();
        }
        boolean defaultEditable = getDefaultEditable();
        CharSequence charSequence = null;
        int i10 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i11 = -1;
        int i12 = 0;
        boolean z6 = false;
        Drawable drawable = null;
        Drawable drawable2 = null;
        Drawable drawable3 = null;
        Drawable drawable4 = null;
        Drawable drawable5 = null;
        Drawable drawable6 = null;
        int i13 = 0;
        boolean z7 = false;
        int i14 = -1;
        CharSequence charSequence2 = null;
        boolean z8 = false;
        TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, R.styleable.TextView, i, i2);
        int indexCount2 = obtainStyledAttributes2.getIndexCount();
        int i15 = 0;
        int i16 = i7;
        ColorStateList colorStateList4 = colorStateList2;
        int i17 = i4;
        CharSequence charSequence3 = "";
        int i18 = i6;
        int i19 = i5;
        int i20 = 0;
        String str3 = str2;
        int i21 = -1;
        CharSequence charSequence4 = null;
        while (i15 < indexCount2) {
            int index2 = obtainStyledAttributes2.getIndex(i15);
            boolean z9 = z2;
            int i22 = i11;
            boolean z10 = z5;
            int i23 = i12;
            CharSequence charSequence5 = charSequence4;
            Drawable drawable7 = drawable4;
            Drawable drawable8 = drawable6;
            Drawable drawable9 = drawable;
            int i24 = i13;
            Drawable drawable10 = drawable3;
            Drawable drawable11 = drawable5;
            Drawable drawable12 = drawable2;
            float f5 = f;
            float f6 = f2;
            boolean z11 = defaultEditable;
            boolean z12 = z3;
            int i25 = i21;
            String str4 = str;
            boolean z13 = z;
            String str5 = str3;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence;
            int i26 = i20;
            float f7 = f4;
            int i27 = i14;
            int i28 = i10;
            boolean z14 = z8;
            boolean z15 = z4;
            float f8 = f3;
            boolean z16 = z6;
            int i29 = i19;
            boolean z17 = z7;
            int i30 = i18;
            CharSequence charSequence8 = charSequence3;
            ColorStateList colorStateList5 = colorStateList;
            int i31 = i17;
            ColorStateList colorStateList6 = colorStateList4;
            ColorStateList colorStateList7 = colorStateList3;
            int i32 = i16;
            int i33 = i8;
            switch (index2) {
                case 0:
                    setEnabled(obtainStyledAttributes2.getBoolean(index2, isEnabled()));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 1:
                case 65:
                case 66:
                case 68:
                case 69:
                    break;
                case 2:
                    i32 = obtainStyledAttributes2.getDimensionPixelSize(index2, i16);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i33 = i8;
                    break;
                case 3:
                    i33 = obtainStyledAttributes2.getInt(index2, i8);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    break;
                case 4:
                    i30 = obtainStyledAttributes2.getInt(index2, i18);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 5:
                    colorStateList5 = obtainStyledAttributes2.getColorStateList(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 6:
                    i31 = obtainStyledAttributes2.getColor(index2, i17);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 7:
                    colorStateList6 = obtainStyledAttributes2.getColorStateList(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 8:
                    colorStateList7 = obtainStyledAttributes2.getColorStateList(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 9:
                    i25 = obtainStyledAttributes2.getInt(index2, i21);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 10:
                    setGravity(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 11:
                    this.mAutoLinkMask = obtainStyledAttributes2.getInt(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 12:
                    this.mLinksClickable = obtainStyledAttributes2.getBoolean(index2, true);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 13:
                    setMaxWidth(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 14:
                    setMaxHeight(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 15:
                    setMinWidth(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 16:
                    setMinHeight(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 17:
                    i23 = obtainStyledAttributes2.getInt(index2, i12);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 18:
                    charSequence8 = obtainStyledAttributes2.getText(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 19:
                    charSequence6 = obtainStyledAttributes2.getText(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 20:
                    setTextScaleX(obtainStyledAttributes2.getFloat(index2, 1.0f));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 21:
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    if (obtainStyledAttributes2.getBoolean(index2, true)) {
                        break;
                    } else {
                        setCursorVisible(false);
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    }
                case 22:
                    setMaxLines(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 23:
                    setLines(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 24:
                    setHeight(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 25:
                    setMinLines(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 26:
                    setMaxEms(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 27:
                    setEms(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 28:
                    setWidth(obtainStyledAttributes2.getDimensionPixelSize(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 29:
                    setMinEms(obtainStyledAttributes2.getInt(index2, -1));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 30:
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    if (obtainStyledAttributes2.getBoolean(index2, false)) {
                        setHorizontallyScrolling(true);
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    } else {
                        break;
                    }
                case 31:
                    z14 = obtainStyledAttributes2.getBoolean(index2, z8);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 32:
                    z17 = obtainStyledAttributes2.getBoolean(index2, z7);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 33:
                    z16 = obtainStyledAttributes2.getBoolean(index2, z6);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 34:
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    if (obtainStyledAttributes2.getBoolean(index2, true)) {
                        break;
                    } else {
                        setIncludeFontPadding(false);
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    }
                case 35:
                    i27 = obtainStyledAttributes2.getInt(index2, -1);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 36:
                    i29 = obtainStyledAttributes2.getInt(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 37:
                    f5 = obtainStyledAttributes2.getFloat(index2, 0.0f);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 38:
                    f6 = obtainStyledAttributes2.getFloat(index2, 0.0f);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 39:
                    f8 = obtainStyledAttributes2.getFloat(index2, 0.0f);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 40:
                    i28 = obtainStyledAttributes2.getInt(index2, i10);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 41:
                    charSequence5 = obtainStyledAttributes2.getText(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 42:
                    z15 = obtainStyledAttributes2.getBoolean(index2, z4);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 43:
                    charSequence7 = obtainStyledAttributes2.getText(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 44:
                    i22 = obtainStyledAttributes2.getInt(index2, i11);
                    z9 = z2;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 45:
                    z10 = obtainStyledAttributes2.getBoolean(index2, z5);
                    z9 = z2;
                    i22 = i11;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 46:
                    z11 = obtainStyledAttributes2.getBoolean(index2, defaultEditable);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 47:
                    this.mFreezesText = obtainStyledAttributes2.getBoolean(index2, false);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 48:
                    drawable12 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 49:
                    drawable7 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 50:
                    drawable9 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 51:
                    drawable10 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 52:
                    i24 = obtainStyledAttributes2.getDimensionPixelSize(index2, i13);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 53:
                    this.mSpacingAdd = obtainStyledAttributes2.getDimensionPixelSize(index2, (int) this.mSpacingAdd);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 54:
                    this.mSpacingMult = obtainStyledAttributes2.getFloat(index2, this.mSpacingMult);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 55:
                    setMarqueeRepeatLimit(obtainStyledAttributes2.getInt(index2, this.mMarqueeRepeatLimit));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 56:
                    i26 = obtainStyledAttributes2.getInt(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 57:
                    setPrivateImeOptions(obtainStyledAttributes2.getString(index2));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 58:
                    try {
                        setInputExtras(obtainStyledAttributes2.getResourceId(index2, 0));
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    } catch (IOException e) {
                        Log.w(LOG_TAG, "Failure reading input extras", e);
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    } catch (XmlPullParserException e2) {
                        Log.w(LOG_TAG, "Failure reading input extras", e2);
                        z9 = z2;
                        i22 = i11;
                        z10 = z5;
                        i23 = i12;
                        charSequence5 = charSequence4;
                        drawable7 = drawable4;
                        drawable8 = drawable6;
                        drawable9 = drawable;
                        i24 = i13;
                        drawable10 = drawable3;
                        drawable11 = drawable5;
                        drawable12 = drawable2;
                        f5 = f;
                        f6 = f2;
                        z11 = defaultEditable;
                        z12 = z3;
                        i25 = i21;
                        str4 = str;
                        z13 = z;
                        str5 = str3;
                        charSequence6 = charSequence2;
                        charSequence7 = charSequence;
                        i26 = i20;
                        f7 = f4;
                        i27 = i14;
                        i28 = i10;
                        z14 = z8;
                        z15 = z4;
                        f8 = f3;
                        z16 = z6;
                        i29 = i19;
                        z17 = z7;
                        i30 = i18;
                        charSequence8 = charSequence3;
                        colorStateList5 = colorStateList;
                        i31 = i17;
                        colorStateList6 = colorStateList4;
                        colorStateList7 = colorStateList3;
                        i32 = i16;
                        i33 = i8;
                        break;
                    }
                case 59:
                    createEditorIfNeeded();
                    this.mEditor.createInputContentTypeIfNeeded();
                    this.mEditor.mInputContentType.imeOptions = obtainStyledAttributes2.getInt(index2, this.mEditor.mInputContentType.imeOptions);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 60:
                    createEditorIfNeeded();
                    this.mEditor.createInputContentTypeIfNeeded();
                    this.mEditor.mInputContentType.imeActionLabel = obtainStyledAttributes2.getText(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 61:
                    createEditorIfNeeded();
                    this.mEditor.createInputContentTypeIfNeeded();
                    this.mEditor.mInputContentType.imeActionId = obtainStyledAttributes2.getInt(index2, this.mEditor.mInputContentType.imeActionId);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 62:
                    this.mTextSelectHandleLeftRes = obtainStyledAttributes2.getResourceId(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 63:
                    this.mTextSelectHandleRightRes = obtainStyledAttributes2.getResourceId(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 64:
                    this.mTextSelectHandleRes = obtainStyledAttributes2.getResourceId(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 67:
                    setTextIsSelectable(obtainStyledAttributes2.getBoolean(index2, false));
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 70:
                    this.mCursorDrawableRes = obtainStyledAttributes2.getResourceId(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 71:
                    this.mTextEditSuggestionItemLayout = obtainStyledAttributes2.getResourceId(index2, 0);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 72:
                    z9 = obtainStyledAttributes2.getBoolean(index2, false);
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 73:
                    drawable11 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 74:
                    drawable8 = obtainStyledAttributes2.getDrawable(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 75:
                    str4 = obtainStyledAttributes2.getString(index2);
                    z13 = true;
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 76:
                    z12 = obtainStyledAttributes2.getBoolean(index2, false);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 77:
                    f7 = obtainStyledAttributes2.getFloat(index2, 0.0f);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    str5 = str3;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                case 78:
                    str5 = obtainStyledAttributes2.getString(index2);
                    z9 = z2;
                    i22 = i11;
                    z10 = z5;
                    i23 = i12;
                    charSequence5 = charSequence4;
                    drawable7 = drawable4;
                    drawable8 = drawable6;
                    drawable9 = drawable;
                    i24 = i13;
                    drawable10 = drawable3;
                    drawable11 = drawable5;
                    drawable12 = drawable2;
                    f5 = f;
                    f6 = f2;
                    z11 = defaultEditable;
                    z12 = z3;
                    i25 = i21;
                    str4 = str;
                    z13 = z;
                    charSequence6 = charSequence2;
                    charSequence7 = charSequence;
                    i26 = i20;
                    f7 = f4;
                    i27 = i14;
                    i28 = i10;
                    z14 = z8;
                    z15 = z4;
                    f8 = f3;
                    z16 = z6;
                    i29 = i19;
                    z17 = z7;
                    i30 = i18;
                    charSequence8 = charSequence3;
                    colorStateList5 = colorStateList;
                    i31 = i17;
                    colorStateList6 = colorStateList4;
                    colorStateList7 = colorStateList3;
                    i32 = i16;
                    i33 = i8;
                    break;
                default:
                    i33 = i8;
                    i32 = i16;
                    colorStateList7 = colorStateList3;
                    colorStateList6 = colorStateList4;
                    i31 = i17;
                    colorStateList5 = colorStateList;
                    charSequence8 = charSequence3;
                    i30 = i18;
                    z17 = z7;
                    i29 = i19;
                    z16 = z6;
                    f8 = f3;
                    z15 = z4;
                    z14 = z8;
                    i28 = i10;
                    i27 = i14;
                    f7 = f4;
                    i26 = i20;
                    charSequence7 = charSequence;
                    charSequence6 = charSequence2;
                    str5 = str3;
                    z13 = z;
                    str4 = str;
                    i25 = i21;
                    z12 = z3;
                    z11 = defaultEditable;
                    f6 = f2;
                    f5 = f;
                    drawable12 = drawable2;
                    drawable11 = drawable5;
                    drawable10 = drawable3;
                    i24 = i13;
                    drawable9 = drawable;
                    drawable8 = drawable6;
                    drawable7 = drawable4;
                    charSequence5 = charSequence4;
                    i23 = i12;
                    z10 = z5;
                    i22 = i11;
                    z9 = z2;
                    break;
            }
            i15++;
            z2 = z9;
            i11 = i22;
            z5 = z10;
            i12 = i23;
            charSequence4 = charSequence5;
            drawable4 = drawable7;
            drawable6 = drawable8;
            drawable = drawable9;
            i13 = i24;
            drawable3 = drawable10;
            drawable5 = drawable11;
            drawable2 = drawable12;
            f = f5;
            f2 = f6;
            defaultEditable = z11;
            z3 = z12;
            i21 = i25;
            str = str4;
            z = z13;
            str3 = str5;
            charSequence2 = charSequence6;
            charSequence = charSequence7;
            i20 = i26;
            f4 = f7;
            i14 = i27;
            i10 = i28;
            z8 = z14;
            z4 = z15;
            f3 = f8;
            z6 = z16;
            i19 = i29;
            z7 = z17;
            i18 = i30;
            charSequence3 = charSequence8;
            colorStateList = colorStateList5;
            i17 = i31;
            colorStateList4 = colorStateList6;
            colorStateList3 = colorStateList7;
            i16 = i32;
            i8 = i33;
        }
        obtainStyledAttributes2.recycle();
        BufferType bufferType2 = BufferType.EDITABLE;
        int i34 = i20 & 4095;
        boolean z18 = i34 == 129;
        boolean z19 = i34 == 225;
        boolean z20 = i34 == 18;
        if (charSequence != null) {
            try {
                Class<?> cls = Class.forName(charSequence.toString());
                try {
                    createEditorIfNeeded();
                    this.mEditor.mKeyListener = (KeyListener) cls.newInstance();
                    try {
                        this.mEditor.mInputType = i20 == 0 ? this.mEditor.mKeyListener.getInputType() : i20;
                        bufferType = bufferType2;
                    } catch (IncompatibleClassChangeError e3) {
                        this.mEditor.mInputType = 1;
                        bufferType = bufferType2;
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InstantiationException e5) {
                    throw new RuntimeException(e5);
                }
            } catch (ClassNotFoundException e6) {
                throw new RuntimeException(e6);
            }
        } else if (charSequence4 != null) {
            createEditorIfNeeded();
            this.mEditor.mKeyListener = DigitsKeyListener.getInstance(charSequence4.toString());
            this.mEditor.mInputType = i20 == 0 ? 1 : i20;
            bufferType = bufferType2;
        } else if (i20 != 0) {
            setInputType(i20, true);
            z7 = !isMultilineInputType(i20);
            bufferType = bufferType2;
        } else if (z4) {
            createEditorIfNeeded();
            this.mEditor.mKeyListener = DialerKeyListener.getInstance();
            this.mEditor.mInputType = 3;
            bufferType = bufferType2;
        } else if (i10 != 0) {
            createEditorIfNeeded();
            this.mEditor.mKeyListener = DigitsKeyListener.getInstance((i10 & 2) != 0, (i10 & 4) != 0);
            int i35 = (i10 & 2) != 0 ? 2 | 4096 : 2;
            this.mEditor.mInputType = (i10 & 4) != 0 ? i35 | 8192 : i35;
            bufferType = bufferType2;
        } else if (z5 || i11 != -1) {
            int i36 = 1;
            switch (i11) {
                case 1:
                    capitalize = TextKeyListener.Capitalize.SENTENCES;
                    i36 = 1 | 16384;
                    break;
                case 2:
                    capitalize = TextKeyListener.Capitalize.WORDS;
                    i36 = 1 | 8192;
                    break;
                case 3:
                    capitalize = TextKeyListener.Capitalize.CHARACTERS;
                    i36 = 1 | 4096;
                    break;
                default:
                    capitalize = TextKeyListener.Capitalize.NONE;
                    break;
            }
            createEditorIfNeeded();
            this.mEditor.mKeyListener = TextKeyListener.getInstance(z5, capitalize);
            this.mEditor.mInputType = i36;
            bufferType = bufferType2;
        } else if (isTextSelectable()) {
            if (this.mEditor != null) {
                this.mEditor.mKeyListener = null;
                this.mEditor.mInputType = 0;
            }
            bufferType = BufferType.SPANNABLE;
            setMovementMethod(ArrowKeyMovementMethod.getInstance());
        } else if (!defaultEditable) {
            if (this.mEditor != null) {
                this.mEditor.mKeyListener = null;
            }
            switch (i12) {
                case 0:
                    bufferType = BufferType.NORMAL;
                    break;
                case 1:
                    bufferType = BufferType.SPANNABLE;
                    break;
                case 2:
                    bufferType = BufferType.EDITABLE;
                    break;
                default:
                    bufferType = bufferType2;
                    break;
            }
        } else {
            createEditorIfNeeded();
            this.mEditor.mKeyListener = TextKeyListener.getInstance();
            this.mEditor.mInputType = 1;
            bufferType = bufferType2;
        }
        if (this.mEditor != null) {
            this.mEditor.adjustInputType(z8, z18, z19, z20);
        }
        BufferType bufferType3 = bufferType;
        if (z6) {
            createEditorIfNeeded();
            this.mEditor.mSelectAllOnFocus = true;
            bufferType3 = bufferType;
            if (bufferType == BufferType.NORMAL) {
                bufferType3 = BufferType.SPANNABLE;
            }
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        setRelativeDrawablesIfNeeded(drawable5, drawable6);
        setCompoundDrawablePadding(i13);
        setInputTypeSingleLine(z7);
        applySingleLine(z7, z7, z7);
        int i37 = i21;
        if (z7) {
            i37 = i21;
            if (getKeyListener() == null) {
                i37 = i21;
                if (i21 < 0) {
                    i37 = 3;
                }
            }
        }
        switch (i37) {
            case 1:
                setEllipsize(TextUtils.TruncateAt.START);
                break;
            case 2:
                setEllipsize(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                setEllipsize(TextUtils.TruncateAt.END);
                break;
            case 4:
                if (ViewConfiguration.get(context).isFadingMarqueeEnabled()) {
                    setHorizontalFadingEdgeEnabled(true);
                    this.mMarqueeFadeMode = 0;
                } else {
                    setHorizontalFadingEdgeEnabled(false);
                    this.mMarqueeFadeMode = 1;
                }
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
                break;
        }
        setTextColor(colorStateList == null ? ColorStateList.valueOf(-16777216) : colorStateList);
        setHintTextColor(colorStateList4);
        setLinkTextColor(colorStateList3);
        if (i17 != 0) {
            setHighlightColor(i17);
        }
        setRawTextSize(i16);
        setElegantTextHeight(z3);
        setLetterSpacing(f4);
        setFontFeatureSettings(str3);
        if (z2) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        }
        if (z8 || z18 || z19 || z20) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            i3 = 3;
        } else {
            i3 = i8;
            if (this.mEditor != null) {
                i3 = i8;
                if ((this.mEditor.mInputType & 4095) == 129) {
                    i3 = 3;
                }
            }
        }
        String str6 = str;
        if (i3 != -1) {
            str6 = str;
            if (!z) {
                str6 = null;
            }
        }
        setTypefaceFromAttrs(str6, i3, i18);
        if (i19 != 0) {
            setShadowLayer(f3, f, f2, i19);
        }
        if (i14 >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i14)});
        } else {
            setFilters(NO_FILTERS);
        }
        setText(charSequence3, bufferType3);
        if (charSequence2 != null) {
            setHint(charSequence2);
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, R.styleable.View, i, i2);
        boolean z21 = (this.mMovement == null && getKeyListener() == null) ? false : true;
        boolean z22 = z21 || isClickable();
        boolean z23 = z21 || isLongClickable();
        int indexCount3 = obtainStyledAttributes3.getIndexCount();
        int i38 = 0;
        while (true) {
            int i39 = i38;
            if (i39 >= indexCount3) {
                obtainStyledAttributes3.recycle();
                setFocusable(z21);
                setClickable(z22);
                setLongClickable(z23);
                if (this.mEditor != null) {
                    this.mEditor.prepareCursorControllers();
                }
                if (getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            int index3 = obtainStyledAttributes3.getIndex(i39);
            switch (index3) {
                case 19:
                    z21 = obtainStyledAttributes3.getBoolean(index3, z21);
                    break;
                case 30:
                    z22 = obtainStyledAttributes3.getBoolean(index3, z22);
                    break;
                case 31:
                    z23 = obtainStyledAttributes3.getBoolean(index3, z23);
                    break;
            }
            i38 = i39 + 1;
        }
    }

    private void applySingleLine(boolean z, boolean z2, boolean z3) {
        this.mSingleLine = z;
        if (z) {
            setLines(1);
            setHorizontallyScrolling(true);
            if (z2) {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
                return;
            }
            return;
        }
        if (z3) {
            setMaxLines(Integer.MAX_VALUE);
        }
        setHorizontallyScrolling(false);
        if (z2) {
            setTransformationMethod(null);
        }
    }

    private void assumeLayout() {
        int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int i = compoundPaddingLeft;
        if (compoundPaddingLeft < 1) {
            i = 0;
        }
        int i2 = i;
        if (this.mHorizontallyScrolling) {
            i2 = 1048576;
        }
        makeNewLayout(i2, i, UNKNOWN_BORING, UNKNOWN_BORING, i, false);
    }

    private boolean bringTextIntoView() {
        Layout.Alignment alignment;
        int ceil;
        Layout layout = isShowingHint() ? this.mHintLayout : this.mLayout;
        int i = 0;
        if ((this.mGravity & 112) == 80) {
            i = layout.getLineCount() - 1;
        }
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        int paragraphDirection = layout.getParagraphDirection(i);
        int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (paragraphAlignment == Layout.Alignment.ALIGN_NORMAL) {
            alignment = paragraphDirection == 1 ? Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
        } else {
            alignment = paragraphAlignment;
            if (paragraphAlignment == Layout.Alignment.ALIGN_OPPOSITE) {
                alignment = paragraphDirection == 1 ? Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
            }
        }
        if (alignment == Layout.Alignment.ALIGN_CENTER) {
            int floor = (int) FloatMath.floor(layout.getLineLeft(i));
            int ceil2 = (int) FloatMath.ceil(layout.getLineRight(i));
            ceil = ceil2 - floor < compoundPaddingLeft ? ((ceil2 + floor) / 2) - (compoundPaddingLeft / 2) : paragraphDirection < 0 ? ceil2 - compoundPaddingLeft : floor;
        } else {
            ceil = alignment == Layout.Alignment.ALIGN_RIGHT ? ((int) FloatMath.ceil(layout.getLineRight(i))) - compoundPaddingLeft : (int) FloatMath.floor(layout.getLineLeft(i));
        }
        int i2 = height < extendedPaddingTop ? 0 : (this.mGravity & 112) == 80 ? height - extendedPaddingTop : 0;
        if (ceil == this.mScrollX && i2 == this.mScrollY) {
            return false;
        }
        scrollTo(ceil, i2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
        if (r3.mSavedMarqueeModeLayout.getLineWidth(0) > r0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean canMarquee() {
        /*
            r3 = this;
            r0 = 0
            r6 = r0
            r0 = r3
            int r0 = r0.mRight
            r1 = r3
            int r1 = r1.mLeft
            int r0 = r0 - r1
            r1 = r3
            int r1 = r1.getCompoundPaddingLeft()
            int r0 = r0 - r1
            r1 = r3
            int r1 = r1.getCompoundPaddingRight()
            int r0 = r0 - r1
            r4 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 <= 0) goto L4e
            r0 = r3
            android.text.Layout r0 = r0.mLayout
            r1 = 0
            float r0 = r0.getLineWidth(r1)
            r1 = r4
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L4c
            r0 = r6
            r5 = r0
            r0 = r3
            int r0 = r0.mMarqueeFadeMode
            if (r0 == 0) goto L4e
            r0 = r6
            r5 = r0
            r0 = r3
            android.text.Layout r0 = r0.mSavedMarqueeModeLayout
            if (r0 == 0) goto L4e
            r0 = r6
            r5 = r0
            r0 = r3
            android.text.Layout r0 = r0.mSavedMarqueeModeLayout
            r1 = 0
            float r0 = r0.getLineWidth(r1)
            r1 = r4
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4e
        L4c:
            r0 = 1
            r5 = r0
        L4e:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.canMarquee():boolean");
    }

    private boolean canSelectText() {
        return (this.mText.length() == 0 || this.mEditor == null || !this.mEditor.hasSelectionController()) ? false : true;
    }

    private void checkForRelayout() {
        if ((this.mLayoutParams.width == -2 && (this.mMaxWidthMode != this.mMinWidthMode || this.mMaxWidth != this.mMinWidth)) || ((this.mHint != null && this.mHintLayout == null) || ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight() <= 0)) {
            nullLayouts();
            requestLayout();
            invalidate();
            return;
        }
        int height = this.mLayout.getHeight();
        makeNewLayout(this.mLayout.getWidth(), this.mHintLayout == null ? 0 : this.mHintLayout.getWidth(), UNKNOWN_BORING, UNKNOWN_BORING, ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
        if (this.mEllipsize != TextUtils.TruncateAt.MARQUEE) {
            if (this.mLayoutParams.height != -2 && this.mLayoutParams.height != -1) {
                invalidate();
                return;
            } else if (this.mLayout.getHeight() == height && (this.mHintLayout == null || this.mHintLayout.getHeight() == height)) {
                invalidate();
                return;
            }
        }
        requestLayout();
        invalidate();
    }

    private void checkForResize() {
        boolean z = false;
        boolean z2 = false;
        if (this.mLayout != null) {
            if (this.mLayoutParams.width == -2) {
                z2 = true;
                invalidate();
            }
            if (this.mLayoutParams.height == -2) {
                z = z2;
                if (getDesiredHeight() != getHeight()) {
                    z = true;
                }
            } else {
                z = z2;
                if (this.mLayoutParams.height == -1) {
                    z = z2;
                    if (this.mDesiredHeightAtMeasure >= 0) {
                        z = z2;
                        if (getDesiredHeight() != this.mDesiredHeightAtMeasure) {
                            z = true;
                        }
                    }
                }
            }
        }
        if (z) {
            requestLayout();
        }
    }

    private boolean compressText(float f) {
        if (!isHardwareAccelerated() && f > 0.0f && this.mLayout != null && getLineCount() == 1 && !this.mUserSetTextScaleX && this.mTextPaint.getTextScaleX() == 1.0f) {
            float lineWidth = ((this.mLayout.getLineWidth(0) + 1.0f) - f) / f;
            if (lineWidth <= 0.0f || lineWidth > 0.07f) {
                return false;
            }
            this.mTextPaint.setTextScaleX((1.0f - lineWidth) - 0.005f);
            post(new Runnable() { // from class: android.widget.TextView.2
                @Override // java.lang.Runnable
                public void run() {
                    TextView.this.requestLayout();
                }
            });
            return true;
        }
        return false;
    }

    private void convertFromViewportToContentCoordinates(Rect rect) {
        int viewportToContentHorizontalOffset = viewportToContentHorizontalOffset();
        rect.left += viewportToContentHorizontalOffset;
        rect.right += viewportToContentHorizontalOffset;
        int viewportToContentVerticalOffset = viewportToContentVerticalOffset();
        rect.top += viewportToContentVerticalOffset;
        rect.bottom += viewportToContentVerticalOffset;
    }

    private void createEditorIfNeeded() {
        if (this.mEditor == null) {
            this.mEditor = new Editor(this);
        }
    }

    private static int desired(Layout layout) {
        int lineCount = layout.getLineCount();
        CharSequence text = layout.getText();
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= lineCount - 1) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= lineCount) {
                        return (int) FloatMath.ceil(f);
                    }
                    f = Math.max(f, layout.getLineWidth(i4));
                    i3 = i4 + 1;
                }
            } else if (text.charAt(layout.getLineEnd(i2) - 1) != '\n') {
                return -1;
            } else {
                i = i2 + 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int doKeyDown(int r7, android.view.KeyEvent r8, android.view.KeyEvent r9) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.doKeyDown(int, android.view.KeyEvent, android.view.KeyEvent):int");
    }

    private void ensureIterableTextForAccessibilitySelectable() {
        if (this.mText instanceof Spannable) {
            return;
        }
        setText(this.mText, BufferType.SPANNABLE);
    }

    private void fixFocusableAndClickableSettings() {
        if (this.mMovement == null && (this.mEditor == null || this.mEditor.mKeyListener == null)) {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
            return;
        }
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
    }

    private int getBottomVerticalOffset(boolean z) {
        int i = this.mGravity & 112;
        Layout layout = this.mLayout;
        Layout layout2 = layout;
        if (!z) {
            layout2 = layout;
            if (this.mText.length() == 0) {
                layout2 = layout;
                if (this.mHintLayout != null) {
                    layout2 = this.mHintLayout;
                }
            }
        }
        int i2 = 0;
        if (i != 80) {
            int boxHeight = getBoxHeight(layout2);
            int height = layout2.getHeight();
            i2 = 0;
            if (height < boxHeight) {
                if (i != 48) {
                    return (boxHeight - height) >> 1;
                }
                i2 = boxHeight - height;
            }
        }
        return i2;
    }

    private int getBoxHeight(Layout layout) {
        Insets opticalInsets = isLayoutModeOptical(this.mParent) ? getOpticalInsets() : Insets.NONE;
        return (getMeasuredHeight() - (layout == this.mHintLayout ? getCompoundPaddingTop() + getCompoundPaddingBottom() : getExtendedPaddingTop() + getExtendedPaddingBottom())) + opticalInsets.top + opticalInsets.bottom;
    }

    private int getDesiredHeight() {
        boolean z = true;
        int desiredHeight = getDesiredHeight(this.mLayout, true);
        Layout layout = this.mHintLayout;
        if (this.mEllipsize == null) {
            z = false;
        }
        return Math.max(desiredHeight, getDesiredHeight(layout, z));
    }

    private int getDesiredHeight(Layout layout, boolean z) {
        int min;
        int i;
        int max;
        if (layout == null) {
            return 0;
        }
        int lineCount = layout.getLineCount();
        int compoundPaddingTop = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int lineTop = layout.getLineTop(lineCount);
        Drawables drawables = this.mDrawables;
        int i2 = lineTop;
        if (drawables != null) {
            i2 = Math.max(Math.max(lineTop, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
        }
        int i3 = i2 + compoundPaddingTop;
        if (this.mMaxMode == 1) {
            min = i3;
            i = lineCount;
            if (z) {
                min = i3;
                i = lineCount;
                if (lineCount > this.mMaximum) {
                    int lineTop2 = layout.getLineTop(this.mMaximum);
                    int i4 = lineTop2;
                    if (drawables != null) {
                        i4 = Math.max(Math.max(lineTop2, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
                    }
                    min = i4 + compoundPaddingTop;
                    i = this.mMaximum;
                }
            }
        } else {
            min = Math.min(i3, this.mMaximum);
            i = lineCount;
        }
        if (this.mMinMode == 1) {
            max = min;
            if (i < this.mMinimum) {
                max = min + (getLineHeight() * (this.mMinimum - i));
            }
        } else {
            max = Math.max(min, this.mMinimum);
        }
        return Math.max(max, getSuggestedMinimumHeight());
    }

    private int getFudgedPaddingRight() {
        return Math.max(0, getCompoundPaddingRight() - ((((int) this.mTextPaint.density) + 2) - 1));
    }

    private void getInterestingRect(Rect rect, int i) {
        convertFromViewportToContentCoordinates(rect);
        if (i == 0) {
            rect.top -= getExtendedPaddingTop();
        }
        if (i == this.mLayout.getLineCount() - 1) {
            rect.bottom += getExtendedPaddingBottom();
        }
    }

    private Layout.Alignment getLayoutAlignment() {
        switch (getTextAlignment()) {
            case 1:
                switch (this.mGravity & 8388615) {
                    case 1:
                        return Layout.Alignment.ALIGN_CENTER;
                    case 3:
                        return Layout.Alignment.ALIGN_LEFT;
                    case 5:
                        return Layout.Alignment.ALIGN_RIGHT;
                    case 8388611:
                        return !isLayoutRtl() ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_RIGHT;
                    case 8388613:
                        return !isLayoutRtl() ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_LEFT;
                    default:
                        return Layout.Alignment.ALIGN_NORMAL;
                }
            case 2:
                return Layout.Alignment.ALIGN_NORMAL;
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
                return getLayoutDirection() == 1 ? Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
            case 6:
                return getLayoutDirection() == 1 ? Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private int getOffsetAtCoordinate(int i, float f) {
        return getLayout().getOffsetForHorizontal(i, convertToLocalHorizontalCoordinate(f));
    }

    public static int getTextColor(Context context, TypedArray typedArray, int i) {
        ColorStateList textColors = getTextColors(context, typedArray);
        return textColors == null ? i : textColors.getDefaultColor();
    }

    public static ColorStateList getTextColors(Context context, TypedArray typedArray) {
        if (typedArray == null) {
            throw new NullPointerException();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(android.R.styleable.TextView);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(5);
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList == null) {
            int resourceId = obtainStyledAttributes.getResourceId(1, 0);
            colorStateList2 = colorStateList;
            if (resourceId != 0) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, android.R.styleable.TextAppearance);
                colorStateList2 = obtainStyledAttributes2.getColorStateList(3);
                obtainStyledAttributes2.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        return colorStateList2;
    }

    private Locale getTextServicesLocale(boolean z) {
        updateTextServicesLocaleAsync();
        return (this.mCurrentSpellCheckerLocaleCache != null || z) ? this.mCurrentSpellCheckerLocaleCache : Locale.getDefault();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (isPressed() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Path getUpdatedHighlightPath() {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.getUpdatedHighlightPath():android.graphics.Path");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasPasswordTransformationMethod() {
        return this.mTransformation instanceof PasswordTransformationMethod;
    }

    private void invalidateCursor(int i, int i2, int i3) {
        if (i >= 0 || i2 >= 0 || i3 >= 0) {
            invalidateRegion(Math.min(Math.min(i, i2), i3), Math.max(Math.max(i, i2), i3), true);
        }
    }

    private static boolean isMultilineInputType(int i) {
        return (131087 & i) == 131073;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPasswordInputType(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    private boolean isShowingHint() {
        return TextUtils.isEmpty(this.mText) && !TextUtils.isEmpty(this.mHint);
    }

    private static boolean isVisiblePasswordInputType(int i) {
        return (i & 4095) == 145;
    }

    private Layout makeSingleLayout(int i, BoringLayout.Metrics metrics, int i2, Layout.Alignment alignment, boolean z, TextUtils.TruncateAt truncateAt, boolean z2) {
        Layout layout;
        if (this.mText instanceof Spannable) {
            CharSequence charSequence = this.mText;
            CharSequence charSequence2 = this.mTransformed;
            TextPaint textPaint = this.mTextPaint;
            TextDirectionHeuristic textDirectionHeuristic = this.mTextDir;
            float f = this.mSpacingMult;
            float f2 = this.mSpacingAdd;
            boolean z3 = this.mIncludePad;
            if (getKeyListener() != null) {
                truncateAt = null;
            }
            layout = new DynamicLayout(charSequence, charSequence2, textPaint, i, alignment, textDirectionHeuristic, f, f2, z3, truncateAt, i2);
        } else {
            BoringLayout.Metrics metrics2 = metrics;
            if (metrics == UNKNOWN_BORING) {
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mTextDir, this.mBoring);
                metrics2 = isBoring;
                if (isBoring != null) {
                    this.mBoring = isBoring;
                    metrics2 = isBoring;
                }
            }
            if (metrics2 == null) {
                if (z) {
                    return new StaticLayout(this.mTransformed, 0, this.mTransformed.length(), this.mTextPaint, i, alignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, truncateAt, i2, this.mMaxMode == 1 ? this.mMaximum : Integer.MAX_VALUE);
                }
                return new StaticLayout(this.mTransformed, this.mTextPaint, i, alignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad);
            } else if (metrics2.width > i || (truncateAt != null && metrics2.width > i2)) {
                if (z && metrics2.width <= i) {
                    return (!z2 || this.mSavedLayout == null) ? BoringLayout.make(this.mTransformed, this.mTextPaint, i, alignment, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad, truncateAt, i2) : this.mSavedLayout.replaceOrMake(this.mTransformed, this.mTextPaint, i, alignment, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad, truncateAt, i2);
                } else if (z) {
                    return new StaticLayout(this.mTransformed, 0, this.mTransformed.length(), this.mTextPaint, i, alignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, truncateAt, i2, this.mMaxMode == 1 ? this.mMaximum : Integer.MAX_VALUE);
                } else {
                    return new StaticLayout(this.mTransformed, this.mTextPaint, i, alignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad);
                }
            } else {
                Layout make = (!z2 || this.mSavedLayout == null) ? BoringLayout.make(this.mTransformed, this.mTextPaint, i, alignment, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad) : this.mSavedLayout.replaceOrMake(this.mTransformed, this.mTextPaint, i, alignment, this.mSpacingMult, this.mSpacingAdd, metrics2, this.mIncludePad);
                layout = make;
                if (z2) {
                    this.mSavedLayout = (BoringLayout) make;
                    return make;
                }
            }
        }
        return layout;
    }

    private void nullLayouts() {
        if ((this.mLayout instanceof BoringLayout) && this.mSavedLayout == null) {
            this.mSavedLayout = (BoringLayout) this.mLayout;
        }
        if ((this.mHintLayout instanceof BoringLayout) && this.mSavedHintLayout == null) {
            this.mSavedHintLayout = (BoringLayout) this.mHintLayout;
        }
        this.mHintLayout = null;
        this.mLayout = null;
        this.mSavedMarqueeModeLayout = null;
        this.mHintBoring = null;
        this.mBoring = null;
        if (this.mEditor != null) {
            this.mEditor.prepareCursorControllers();
        }
    }

    private void paste(int i, int i2) {
        ClipData primaryClip = ((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).getPrimaryClip();
        if (primaryClip != null) {
            boolean z = false;
            int i3 = 0;
            while (i3 < primaryClip.getItemCount()) {
                CharSequence coerceToStyledText = primaryClip.getItemAt(i3).coerceToStyledText(getContext());
                boolean z2 = z;
                if (coerceToStyledText != null) {
                    if (z) {
                        ((Editable) this.mText).insert(getSelectionEnd(), "\n");
                        ((Editable) this.mText).insert(getSelectionEnd(), coerceToStyledText);
                        z2 = z;
                    } else {
                        Selection.setSelection((Spannable) this.mText, i2);
                        ((Editable) this.mText).replace(i, i2, coerceToStyledText);
                        z2 = true;
                    }
                }
                i3++;
                z = z2;
            }
            stopSelectionActionMode();
            LAST_CUT_OR_COPY_TIME = 0L;
        }
    }

    private void registerForPreDraw() {
        if (this.mPreDrawRegistered) {
            return;
        }
        getViewTreeObserver().addOnPreDrawListener(this);
        this.mPreDrawRegistered = true;
    }

    private <T> void removeIntersectingNonAdjacentSpans(int i, int i2, Class<T> cls) {
        if (!(this.mText instanceof Editable)) {
            return;
        }
        Editable editable = (Editable) this.mText;
        Object[] spans = editable.getSpans(i, i2, cls);
        int length = spans.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            int spanStart = editable.getSpanStart(spans[i4]);
            if (editable.getSpanEnd(spans[i4]) == i || spanStart == i2) {
                return;
            }
            editable.removeSpan(spans[i4]);
            i3 = i4 + 1;
        }
    }

    static void removeParcelableSpans(Spannable spannable, int i, int i2) {
        Object[] spans = spannable.getSpans(i, i2, ParcelableSpan.class);
        int length = spans.length;
        while (length > 0) {
            length--;
            spannable.removeSpan(spans[length]);
        }
    }

    private void restartMarqueeIfNeeded() {
        if (this.mRestartMarquee && this.mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            this.mRestartMarquee = false;
            startMarquee();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBeforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    break;
                }
                arrayList.get(i5).beforeTextChanged(charSequence, i, i2, i3);
                i4 = i5 + 1;
            }
        }
        removeIntersectingNonAdjacentSpans(i, i + i2, SpellCheckSpan.class);
        removeIntersectingNonAdjacentSpans(i, i + i2, SuggestionSpan.class);
    }

    private void setFilters(Editable editable, InputFilter[] inputFilterArr) {
        if (this.mEditor != null) {
            boolean z = this.mEditor.mUndoInputFilter != null;
            boolean z2 = this.mEditor.mKeyListener instanceof InputFilter;
            int i = 0;
            if (z) {
                i = 0 + 1;
            }
            int i2 = i;
            if (z2) {
                i2 = i + 1;
            }
            if (i2 > 0) {
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + i2];
                System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, inputFilterArr.length);
                int i3 = 0;
                if (z) {
                    inputFilterArr2[inputFilterArr.length] = this.mEditor.mUndoInputFilter;
                    i3 = 0 + 1;
                }
                if (z2) {
                    inputFilterArr2[inputFilterArr.length + i3] = (InputFilter) this.mEditor.mKeyListener;
                }
                editable.setFilters(inputFilterArr2);
                return;
            }
        }
        editable.setFilters(inputFilterArr);
    }

    private void setInputType(int i, boolean z) {
        TextKeyListener dialerKeyListener;
        boolean z2 = true;
        int i2 = i & 15;
        if (i2 == 1) {
            dialerKeyListener = TextKeyListener.getInstance((32768 & i) != 0, (i & 4096) != 0 ? TextKeyListener.Capitalize.CHARACTERS : (i & 8192) != 0 ? TextKeyListener.Capitalize.WORDS : (i & 16384) != 0 ? TextKeyListener.Capitalize.SENTENCES : TextKeyListener.Capitalize.NONE);
        } else if (i2 == 2) {
            boolean z3 = (i & 4096) != 0;
            if ((i & 8192) == 0) {
                z2 = false;
            }
            dialerKeyListener = DigitsKeyListener.getInstance(z3, z2);
        } else if (i2 == 4) {
            switch (i & InputType.TYPE_MASK_VARIATION) {
                case 16:
                    dialerKeyListener = DateKeyListener.getInstance();
                    break;
                case 32:
                    dialerKeyListener = TimeKeyListener.getInstance();
                    break;
                default:
                    dialerKeyListener = DateTimeKeyListener.getInstance();
                    break;
            }
        } else {
            dialerKeyListener = i2 == 3 ? DialerKeyListener.getInstance() : TextKeyListener.getInstance();
        }
        setRawInputType(i);
        if (!z) {
            setKeyListenerOnly(dialerKeyListener);
            return;
        }
        createEditorIfNeeded();
        this.mEditor.mKeyListener = dialerKeyListener;
    }

    private void setInputTypeSingleLine(boolean z) {
        if (this.mEditor == null || (this.mEditor.mInputType & 15) != 1) {
            return;
        }
        if (z) {
            this.mEditor.mInputType &= -131073;
            return;
        }
        this.mEditor.mInputType |= 131072;
    }

    private void setKeyListenerOnly(KeyListener keyListener) {
        if (this.mEditor == null && keyListener == null) {
            return;
        }
        createEditorIfNeeded();
        if (this.mEditor.mKeyListener != keyListener) {
            this.mEditor.mKeyListener = keyListener;
            if (keyListener != null && !(this.mText instanceof Editable)) {
                setText(this.mText);
            }
            setFilters((Editable) this.mText, this.mFilters);
        }
    }

    private void setPrimaryClip(ClipData clipData) {
        ((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(clipData);
        LAST_CUT_OR_COPY_TIME = SystemClock.uptimeMillis();
    }

    private void setRawTextSize(float f) {
        if (f != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(f);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    private void setRelativeDrawablesIfNeeded(Drawable drawable, Drawable drawable2) {
        if ((drawable == null && drawable2 == null) ? false : true) {
            Drawables drawables = this.mDrawables;
            Drawables drawables2 = drawables;
            if (drawables == null) {
                drawables2 = new Drawables(getContext());
                this.mDrawables = drawables2;
            }
            this.mDrawables.mOverride = true;
            Rect rect = drawables2.mCompoundRect;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables2.mDrawableStart = drawable;
                drawables2.mDrawableSizeStart = rect.width();
                drawables2.mDrawableHeightStart = rect.height();
            } else {
                drawables2.mDrawableHeightStart = 0;
                drawables2.mDrawableSizeStart = 0;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                drawables2.mDrawableEnd = drawable2;
                drawables2.mDrawableSizeEnd = rect.width();
                drawables2.mDrawableHeightEnd = rect.height();
            } else {
                drawables2.mDrawableHeightEnd = 0;
                drawables2.mDrawableSizeEnd = 0;
            }
            resetResolvedDrawables();
            resolveDrawables();
        }
    }

    private void setText(CharSequence charSequence, BufferType bufferType, boolean z, int i) {
        Spannable spannable;
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "";
        }
        CharSequence charSequence3 = charSequence2;
        if (!isSuggestionsEnabled()) {
            charSequence3 = removeSuggestionSpans(charSequence2);
        }
        if (!this.mUserSetTextScaleX) {
            this.mTextPaint.setTextScaleX(1.0f);
        }
        if ((charSequence3 instanceof Spanned) && ((Spanned) charSequence3).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0) {
            if (ViewConfiguration.get(this.mContext).isFadingMarqueeEnabled()) {
                setHorizontalFadingEdgeEnabled(true);
                this.mMarqueeFadeMode = 0;
            } else {
                setHorizontalFadingEdgeEnabled(false);
                this.mMarqueeFadeMode = 1;
            }
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
        int length = this.mFilters.length;
        CharSequence charSequence4 = charSequence3;
        for (int i2 = 0; i2 < length; i2++) {
            CharSequence filter = this.mFilters[i2].filter(charSequence4, 0, charSequence4.length(), EMPTY_SPANNED, 0, 0);
            if (filter != null) {
                charSequence4 = filter;
            }
        }
        int i3 = i;
        if (z) {
            if (this.mText != null) {
                i3 = this.mText.length();
                sendBeforeTextChanged(this.mText, 0, i3, charSequence4.length());
            } else {
                sendBeforeTextChanged("", 0, 0, charSequence4.length());
                i3 = i;
            }
        }
        boolean z2 = false;
        if (this.mListeners != null) {
            z2 = false;
            if (this.mListeners.size() != 0) {
                z2 = true;
            }
        }
        if (bufferType == BufferType.EDITABLE || getKeyListener() != null || z2) {
            createEditorIfNeeded();
            Editable newEditable = this.mEditableFactory.newEditable(charSequence4);
            setFilters(newEditable, this.mFilters);
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            spannable = newEditable;
            if (peekInstance != null) {
                peekInstance.restartInput(this);
                spannable = newEditable;
            }
        } else if (bufferType == BufferType.SPANNABLE || this.mMovement != null) {
            spannable = this.mSpannableFactory.newSpannable(charSequence4);
        } else {
            spannable = charSequence4;
            if (!(charSequence4 instanceof CharWrapper)) {
                spannable = TextUtils.stringOrSpannedString(charSequence4);
            }
        }
        Spannable spannable2 = spannable;
        BufferType bufferType2 = bufferType;
        if (this.mAutoLinkMask != 0) {
            Spannable newSpannable = (bufferType == BufferType.EDITABLE || (spannable instanceof Spannable)) ? spannable : this.mSpannableFactory.newSpannable(spannable);
            spannable2 = spannable;
            bufferType2 = bufferType;
            if (Linkify.addLinks(newSpannable, this.mAutoLinkMask)) {
                BufferType bufferType3 = bufferType == BufferType.EDITABLE ? BufferType.EDITABLE : BufferType.SPANNABLE;
                this.mText = newSpannable;
                spannable2 = newSpannable;
                bufferType2 = bufferType3;
                if (this.mLinksClickable) {
                    spannable2 = newSpannable;
                    bufferType2 = bufferType3;
                    if (!textCanBeSelected()) {
                        setMovementMethod(LinkMovementMethod.getInstance());
                        bufferType2 = bufferType3;
                        spannable2 = newSpannable;
                    }
                }
            }
        }
        this.mBufferType = bufferType2;
        this.mText = spannable2;
        if (this.mTransformation == null) {
            this.mTransformed = spannable2;
        } else {
            this.mTransformed = this.mTransformation.getTransformation(spannable2, this);
        }
        int length2 = spannable2.length();
        if ((spannable2 instanceof Spannable) && !this.mAllowTransformationLengthChange) {
            Spannable spannable3 = spannable2;
            ChangeWatcher[] changeWatcherArr = (ChangeWatcher[]) spannable3.getSpans(0, spannable3.length(), ChangeWatcher.class);
            int length3 = changeWatcherArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length3) {
                    break;
                }
                spannable3.removeSpan(changeWatcherArr[i5]);
                i4 = i5 + 1;
            }
            if (this.mChangeWatcher == null) {
                this.mChangeWatcher = new ChangeWatcher();
            }
            spannable3.setSpan(this.mChangeWatcher, 0, length2, 6553618);
            if (this.mEditor != null) {
                this.mEditor.addSpanWatchers(spannable3);
            }
            if (this.mTransformation != null) {
                spannable3.setSpan(this.mTransformation, 0, length2, 18);
            }
            if (this.mMovement != null) {
                this.mMovement.initialize(this, spannable2);
                if (this.mEditor != null) {
                    this.mEditor.mSelectionMoved = false;
                }
            }
        }
        if (this.mLayout != null) {
            checkForRelayout();
        }
        sendOnTextChanged(spannable2, 0, i3, length2);
        onTextChanged(spannable2, 0, i3, length2);
        notifyViewAccessibilityStateChangedIfNeeded(2);
        if (z2) {
            sendAfterTextChanged((Editable) spannable2);
        }
        if (this.mEditor != null) {
            this.mEditor.prepareCursorControllers();
        }
    }

    private void setTypefaceFromAttrs(String str, int i, int i2) {
        Typeface typeface;
        Typeface typeface2 = null;
        if (str != null) {
            Typeface create = Typeface.create(str, i2);
            typeface2 = create;
            if (create != null) {
                setTypeface(create);
                return;
            }
        }
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = typeface2;
                break;
        }
        setTypeface(typeface, i2);
    }

    private boolean shouldAdvanceFocusOnEnter() {
        if (getKeyListener() == null) {
            return false;
        }
        if (this.mSingleLine) {
            return true;
        }
        if (this.mEditor == null || (this.mEditor.mInputType & 15) != 1) {
            return false;
        }
        int i = this.mEditor.mInputType & InputType.TYPE_MASK_VARIATION;
        return i == 32 || i == 48;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r0 == 131072) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean shouldAdvanceFocusOnTab() {
        /*
            r3 = this;
            r0 = 1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r3
            android.text.method.KeyListener r0 = r0.getKeyListener()
            if (r0 == 0) goto L4b
            r0 = r6
            r5 = r0
            r0 = r3
            boolean r0 = r0.mSingleLine
            if (r0 != 0) goto L4b
            r0 = r6
            r5 = r0
            r0 = r3
            android.widget.Editor r0 = r0.mEditor
            if (r0 == 0) goto L4b
            r0 = r6
            r5 = r0
            r0 = r3
            android.widget.Editor r0 = r0.mEditor
            int r0 = r0.mInputType
            r1 = 15
            r0 = r0 & r1
            r1 = 1
            if (r0 != r1) goto L4b
            r0 = r3
            android.widget.Editor r0 = r0.mEditor
            int r0 = r0.mInputType
            r1 = 4080(0xff0, float:5.717E-42)
            r0 = r0 & r1
            r4 = r0
            r0 = r4
            r1 = 262144(0x40000, float:3.67342E-40)
            if (r0 == r1) goto L49
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != r1) goto L4b
        L49:
            r0 = 0
            r5 = r0
        L4b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.shouldAdvanceFocusOnTab():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldSpeakPasswordsForAccessibility() {
        return Settings.Secure.getIntForUser(this.mContext.getContentResolver(), Settings.Secure.ACCESSIBILITY_SPEAK_PASSWORD, 0, -3) == 1;
    }

    private void startMarquee() {
        if (getKeyListener() == null && !compressText((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight())) {
            if (this.mMarquee == null || this.mMarquee.isStopped()) {
                if ((isFocused() || isSelected()) && getLineCount() == 1 && canMarquee()) {
                    if (this.mMarqueeFadeMode == 1) {
                        this.mMarqueeFadeMode = 2;
                        Layout layout = this.mLayout;
                        this.mLayout = this.mSavedMarqueeModeLayout;
                        this.mSavedMarqueeModeLayout = layout;
                        setHorizontalFadingEdgeEnabled(true);
                        requestLayout();
                        invalidate();
                    }
                    if (this.mMarquee == null) {
                        this.mMarquee = new Marquee(this);
                    }
                    this.mMarquee.start(this.mMarqueeRepeatLimit);
                }
            }
        }
    }

    private void startStopMarquee(boolean z) {
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            if (z) {
                startMarquee();
            } else {
                stopMarquee();
            }
        }
    }

    private void stopMarquee() {
        if (this.mMarquee != null && !this.mMarquee.isStopped()) {
            this.mMarquee.stop();
        }
        if (this.mMarqueeFadeMode == 2) {
            this.mMarqueeFadeMode = 1;
            Layout layout = this.mSavedMarqueeModeLayout;
            this.mSavedMarqueeModeLayout = this.mLayout;
            this.mLayout = layout;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        }
    }

    private void unregisterForPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.mPreDrawRegistered = false;
        this.mPreDrawListenerDetached = false;
    }

    private void updateTextColors() {
        boolean z = false;
        int colorForState = this.mTextColor.getColorForState(getDrawableState(), 0);
        if (colorForState != this.mCurTextColor) {
            this.mCurTextColor = colorForState;
            z = true;
        }
        boolean z2 = z;
        if (this.mLinkTextColor != null) {
            int colorForState2 = this.mLinkTextColor.getColorForState(getDrawableState(), 0);
            z2 = z;
            if (colorForState2 != this.mTextPaint.linkColor) {
                this.mTextPaint.linkColor = colorForState2;
                z2 = true;
            }
        }
        boolean z3 = z2;
        if (this.mHintTextColor != null) {
            int colorForState3 = this.mHintTextColor.getColorForState(getDrawableState(), 0);
            z3 = z2;
            if (colorForState3 != this.mCurHintTextColor) {
                this.mCurHintTextColor = colorForState3;
                z3 = z2;
                if (this.mText.length() == 0) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            if (this.mEditor != null) {
                this.mEditor.invalidateTextDisplayList();
            }
            invalidate();
        }
    }

    private void updateTextServicesLocaleAsync() {
        AsyncTask.execute(new Runnable() { // from class: android.widget.TextView.3
            @Override // java.lang.Runnable
            public void run() {
                TextView.this.updateTextServicesLocaleLocked();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextServicesLocaleLocked() {
        SpellCheckerSubtype currentSpellCheckerSubtype = ((TextServicesManager) this.mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE)).getCurrentSpellCheckerSubtype(true);
        this.mCurrentSpellCheckerLocaleCache = currentSpellCheckerSubtype != null ? SpellCheckerSubtype.constructLocaleFromString(currentSpellCheckerSubtype.getLocale()) : null;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(textWatcher);
    }

    public final void append(CharSequence charSequence) {
        append(charSequence, 0, charSequence.length());
    }

    public void append(CharSequence charSequence, int i, int i2) {
        if (!(this.mText instanceof Editable)) {
            setText(this.mText, BufferType.EDITABLE);
        }
        ((Editable) this.mText).append(charSequence, i, i2);
    }

    public void beginBatchEdit() {
        if (this.mEditor != null) {
            this.mEditor.beginBatchEdit();
        }
    }

    public boolean bringPointIntoView(int i) {
        boolean z;
        int i2;
        int i3;
        if (isLayoutRequested()) {
            this.mDeferScroll = i;
            z = false;
        } else {
            boolean z2 = false;
            z = false;
            Layout layout = isShowingHint() ? this.mHintLayout : this.mLayout;
            if (layout != null) {
                int lineForOffset = layout.getLineForOffset(i);
                switch (AnonymousClass4.$SwitchMap$android$text$Layout$Alignment[layout.getParagraphAlignment(lineForOffset).ordinal()]) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = -1;
                        break;
                    case 3:
                        i2 = layout.getParagraphDirection(lineForOffset);
                        break;
                    case 4:
                        i2 = -layout.getParagraphDirection(lineForOffset);
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                int primaryHorizontal = (int) layout.getPrimaryHorizontal(i, i2 > 0);
                int lineTop = layout.getLineTop(lineForOffset);
                int lineTop2 = layout.getLineTop(lineForOffset + 1);
                int floor = (int) FloatMath.floor(layout.getLineLeft(lineForOffset));
                int ceil = (int) FloatMath.ceil(layout.getLineRight(lineForOffset));
                int height = layout.getHeight();
                int compoundPaddingLeft = ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
                int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
                int i4 = ceil;
                if (!this.mHorizontallyScrolling) {
                    i4 = ceil;
                    if (ceil - floor > compoundPaddingLeft) {
                        i4 = ceil;
                        if (ceil > primaryHorizontal) {
                            i4 = Math.max(primaryHorizontal, floor + compoundPaddingLeft);
                        }
                    }
                }
                int i5 = (lineTop2 - lineTop) / 2;
                int i6 = i5;
                if (i5 > extendedPaddingTop / 4) {
                    i6 = extendedPaddingTop / 4;
                }
                int i7 = i5;
                if (i5 > compoundPaddingLeft / 4) {
                    i7 = compoundPaddingLeft / 4;
                }
                int i8 = this.mScrollX;
                int i9 = this.mScrollY;
                int i10 = i9;
                if (lineTop - i9 < i6) {
                    i10 = lineTop - i6;
                }
                int i11 = i10;
                if (lineTop2 - i10 > extendedPaddingTop - i6) {
                    i11 = lineTop2 - (extendedPaddingTop - i6);
                }
                int i12 = i11;
                if (height - i11 < extendedPaddingTop) {
                    i12 = height - extendedPaddingTop;
                }
                int i13 = i12;
                if (0 - i12 > 0) {
                    i13 = 0;
                }
                int i14 = i8;
                if (i2 != 0) {
                    int i15 = i8;
                    if (primaryHorizontal - i8 < i7) {
                        i15 = primaryHorizontal - i7;
                    }
                    i14 = i15;
                    if (primaryHorizontal - i15 > compoundPaddingLeft - i7) {
                        i14 = primaryHorizontal - (compoundPaddingLeft - i7);
                    }
                }
                if (i2 < 0) {
                    int i16 = i14;
                    if (floor - i14 > 0) {
                        i16 = floor;
                    }
                    i3 = i16;
                    if (i4 - i16 < compoundPaddingLeft) {
                        i3 = i4 - compoundPaddingLeft;
                    }
                } else if (i2 > 0) {
                    int i17 = i14;
                    if (i4 - i14 < compoundPaddingLeft) {
                        i17 = i4 - compoundPaddingLeft;
                    }
                    i3 = i17;
                    if (floor - i17 > 0) {
                        i3 = floor;
                    }
                } else if (i4 - floor <= compoundPaddingLeft) {
                    i3 = floor - ((compoundPaddingLeft - (i4 - floor)) / 2);
                } else if (primaryHorizontal > i4 - i7) {
                    i3 = i4 - compoundPaddingLeft;
                } else if (primaryHorizontal < floor + i7) {
                    i3 = floor;
                } else if (floor > i14) {
                    i3 = floor;
                } else if (i4 < i14 + compoundPaddingLeft) {
                    i3 = i4 - compoundPaddingLeft;
                } else {
                    int i18 = i14;
                    if (primaryHorizontal - i14 < i7) {
                        i18 = primaryHorizontal - i7;
                    }
                    i3 = i18;
                    if (primaryHorizontal - i18 > compoundPaddingLeft - i7) {
                        i3 = primaryHorizontal - (compoundPaddingLeft - i7);
                    }
                }
                if (i3 != this.mScrollX || i13 != this.mScrollY) {
                    if (this.mScroller == null) {
                        scrollTo(i3, i13);
                    } else {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        long j = this.mLastScroll;
                        int i19 = i3 - this.mScrollX;
                        int i20 = i13 - this.mScrollY;
                        if (currentAnimationTimeMillis - j > 250) {
                            this.mScroller.startScroll(this.mScrollX, this.mScrollY, i19, i20);
                            awakenScrollBars(this.mScroller.getDuration());
                            invalidate();
                        } else {
                            if (!this.mScroller.isFinished()) {
                                this.mScroller.abortAnimation();
                            }
                            scrollBy(i19, i20);
                        }
                        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
                    }
                    z2 = true;
                }
                z = z2;
                if (isFocused()) {
                    if (this.mTempRect == null) {
                        this.mTempRect = new Rect();
                    }
                    this.mTempRect.set(primaryHorizontal - 2, lineTop, primaryHorizontal + 2, lineTop2);
                    getInterestingRect(this.mTempRect, lineForOffset);
                    this.mTempRect.offset(this.mScrollX, this.mScrollY);
                    z = z2;
                    if (requestRectangleOnScreen(this.mTempRect)) {
                        return true;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canCopy() {
        return !hasPasswordTransformationMethod() && this.mText.length() > 0 && hasSelection() && this.mEditor != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canCut() {
        return !hasPasswordTransformationMethod() && this.mText.length() > 0 && hasSelection() && (this.mText instanceof Editable) && this.mEditor != null && this.mEditor.mKeyListener != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canPaste() {
        return (this.mText instanceof Editable) && this.mEditor != null && this.mEditor.mKeyListener != null && getSelectionStart() >= 0 && getSelectionEnd() >= 0 && ((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).hasPrimaryClip();
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        if (this.mEditor != null) {
            this.mEditor.mIgnoreActionUpEvent = true;
        }
    }

    public void clearComposingText() {
        if (this.mText instanceof Spannable) {
            BaseInputConnection.removeComposingSpans((Spannable) this.mText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return this.mLayout != null ? (this.mSingleLine && (this.mGravity & 7) == 3) ? (int) this.mLayout.getLineWidth(0) : this.mLayout.getWidth() : super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller == null || !this.mScroller.computeScrollOffset()) {
            return;
        }
        this.mScrollX = this.mScroller.getCurrX();
        this.mScrollY = this.mScroller.getCurrY();
        invalidateParentCaches();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return this.mLayout != null ? this.mLayout.getHeight() : super.computeVerticalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float convertToLocalHorizontalCoordinate(float f) {
        return Math.min((getWidth() - getTotalPaddingRight()) - 1, Math.max(0.0f, f - getTotalPaddingLeft())) + getScrollX();
    }

    @Override // android.view.View
    public void debug(int i) {
        String str;
        super.debug(i);
        String str2 = debugIndent(i) + "frame={" + this.mLeft + ", " + this.mTop + ", " + this.mRight + ", " + this.mBottom + "} scroll={" + this.mScrollX + ", " + this.mScrollY + "} ";
        if (this.mText != null) {
            String str3 = str2 + "mText=\"" + ((Object) this.mText) + "\" ";
            str = str3;
            if (this.mLayout != null) {
                str = str3 + "mLayout width=" + this.mLayout.getWidth() + " height=" + this.mLayout.getHeight();
            }
        } else {
            str = str2 + "mText=NULL";
        }
        Log.d("View", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteText_internal(int i, int i2) {
        ((Editable) this.mText).delete(i, i2);
    }

    public boolean didTouchFocusSelect() {
        return this.mEditor != null && this.mEditor.mTouchFocusSelected;
    }

    @Override // android.view.View
    public void dispatchFinishTemporaryDetach() {
        this.mDispatchTemporaryDetach = true;
        super.dispatchFinishTemporaryDetach();
        this.mDispatchTemporaryDetach = false;
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            if (drawables.mDrawableTop != null) {
                drawables.mDrawableTop.setHotspot(f, f2);
            }
            if (drawables.mDrawableBottom != null) {
                drawables.mDrawableBottom.setHotspot(f, f2);
            }
            if (drawables.mDrawableLeft != null) {
                drawables.mDrawableLeft.setHotspot(f, f2);
            }
            if (drawables.mDrawableRight != null) {
                drawables.mDrawableRight.setHotspot(f, f2);
            }
            if (drawables.mDrawableStart != null) {
                drawables.mDrawableStart.setHotspot(f, f2);
            }
            if (drawables.mDrawableEnd != null) {
                drawables.mDrawableEnd.setHotspot(f, f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.mTextColor != null && this.mTextColor.isStateful()) || ((this.mHintTextColor != null && this.mHintTextColor.isStateful()) || (this.mLinkTextColor != null && this.mLinkTextColor.isStateful()))) {
            updateTextColors();
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            int[] drawableState = getDrawableState();
            if (drawables.mDrawableTop != null && drawables.mDrawableTop.isStateful()) {
                drawables.mDrawableTop.setState(drawableState);
            }
            if (drawables.mDrawableBottom != null && drawables.mDrawableBottom.isStateful()) {
                drawables.mDrawableBottom.setState(drawableState);
            }
            if (drawables.mDrawableLeft != null && drawables.mDrawableLeft.isStateful()) {
                drawables.mDrawableLeft.setState(drawableState);
            }
            if (drawables.mDrawableRight != null && drawables.mDrawableRight.isStateful()) {
                drawables.mDrawableRight.setState(drawableState);
            }
            if (drawables.mDrawableStart != null && drawables.mDrawableStart.isStateful()) {
                drawables.mDrawableStart.setState(drawableState);
            }
            if (drawables.mDrawableEnd == null || !drawables.mDrawableEnd.isStateful()) {
                return;
            }
            drawables.mDrawableEnd.setState(drawableState);
        }
    }

    public void endBatchEdit() {
        if (this.mEditor != null) {
            this.mEditor.endBatchEdit();
        }
    }

    public boolean extractText(ExtractedTextRequest extractedTextRequest, ExtractedText extractedText) {
        createEditorIfNeeded();
        return this.mEditor.extractText(extractedTextRequest, extractedText);
    }

    @Override // android.view.View
    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i) {
        super.findViewsWithText(arrayList, charSequence, i);
        if (arrayList.contains(this) || (i & 1) == 0 || TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(this.mText)) {
            return;
        }
        if (this.mText.toString().toLowerCase().contains(charSequence.toString().toLowerCase())) {
            arrayList.add(this);
        }
    }

    @Override // android.view.View
    public int getAccessibilitySelectionEnd() {
        return getSelectionEnd();
    }

    @Override // android.view.View
    public int getAccessibilitySelectionStart() {
        return getSelectionStart();
    }

    public final int getAutoLinkMask() {
        return this.mAutoLinkMask;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.mLayout == null) {
            return super.getBaseline();
        }
        int i = 0;
        if ((this.mGravity & 112) != 48) {
            i = getVerticalOffset(true);
        }
        int i2 = i;
        if (isLayoutModeOptical(this.mParent)) {
            i2 = i - getOpticalInsets().top;
        }
        return getExtendedPaddingTop() + i2 + this.mLayout.getLineBaseline(0);
    }

    @Override // android.view.View
    protected int getBottomPaddingOffset() {
        return (int) Math.max(0.0f, this.mShadowDy + this.mShadowRadius);
    }

    public int getCompoundDrawablePadding() {
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            return drawables.mDrawablePadding;
        }
        return 0;
    }

    public Drawable[] getCompoundDrawables() {
        Drawables drawables = this.mDrawables;
        return drawables != null ? new Drawable[]{drawables.mDrawableLeft, drawables.mDrawableTop, drawables.mDrawableRight, drawables.mDrawableBottom} : new Drawable[]{null, null, null, null};
    }

    public Drawable[] getCompoundDrawablesRelative() {
        Drawables drawables = this.mDrawables;
        return drawables != null ? new Drawable[]{drawables.mDrawableStart, drawables.mDrawableTop, drawables.mDrawableEnd, drawables.mDrawableBottom} : new Drawable[]{null, null, null, null};
    }

    public int getCompoundPaddingBottom() {
        Drawables drawables = this.mDrawables;
        return (drawables == null || drawables.mDrawableBottom == null) ? this.mPaddingBottom : this.mPaddingBottom + drawables.mDrawablePadding + drawables.mDrawableSizeBottom;
    }

    public int getCompoundPaddingEnd() {
        resolveDrawables();
        switch (getLayoutDirection()) {
            case 1:
                return getCompoundPaddingLeft();
            default:
                return getCompoundPaddingRight();
        }
    }

    public int getCompoundPaddingLeft() {
        Drawables drawables = this.mDrawables;
        return (drawables == null || drawables.mDrawableLeft == null) ? this.mPaddingLeft : this.mPaddingLeft + drawables.mDrawablePadding + drawables.mDrawableSizeLeft;
    }

    public int getCompoundPaddingRight() {
        Drawables drawables = this.mDrawables;
        return (drawables == null || drawables.mDrawableRight == null) ? this.mPaddingRight : this.mPaddingRight + drawables.mDrawablePadding + drawables.mDrawableSizeRight;
    }

    public int getCompoundPaddingStart() {
        resolveDrawables();
        switch (getLayoutDirection()) {
            case 1:
                return getCompoundPaddingRight();
            default:
                return getCompoundPaddingLeft();
        }
    }

    public int getCompoundPaddingTop() {
        Drawables drawables = this.mDrawables;
        return (drawables == null || drawables.mDrawableTop == null) ? this.mPaddingTop : this.mPaddingTop + drawables.mDrawablePadding + drawables.mDrawableSizeTop;
    }

    public final int getCurrentHintTextColor() {
        return this.mHintTextColor != null ? this.mCurHintTextColor : this.mCurTextColor;
    }

    public final int getCurrentTextColor() {
        return this.mCurTextColor;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        if (this.mEditor == null) {
            return null;
        }
        return this.mEditor.mCustomSelectionActionModeCallback;
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    protected MovementMethod getDefaultMovementMethod() {
        return null;
    }

    public Editable getEditableText() {
        if (this.mText instanceof Editable) {
            return (Editable) this.mText;
        }
        return null;
    }

    @ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        return this.mEllipsize;
    }

    public CharSequence getError() {
        if (this.mEditor == null) {
            return null;
        }
        return this.mEditor.mError;
    }

    public int getExtendedPaddingBottom() {
        int i;
        if (this.mMaxMode != 1) {
            i = getCompoundPaddingBottom();
        } else {
            if (this.mLayout == null) {
                assumeLayout();
            }
            if (this.mLayout.getLineCount() <= this.mMaximum) {
                return getCompoundPaddingBottom();
            }
            int compoundPaddingTop = getCompoundPaddingTop();
            int compoundPaddingBottom = getCompoundPaddingBottom();
            int height = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
            int lineTop = this.mLayout.getLineTop(this.mMaximum);
            i = compoundPaddingBottom;
            if (lineTop < height) {
                int i2 = this.mGravity & 112;
                if (i2 == 48) {
                    return (compoundPaddingBottom + height) - lineTop;
                }
                i = compoundPaddingBottom;
                if (i2 != 80) {
                    return compoundPaddingBottom + ((height - lineTop) / 2);
                }
            }
        }
        return i;
    }

    public int getExtendedPaddingTop() {
        int i;
        if (this.mMaxMode != 1) {
            i = getCompoundPaddingTop();
        } else {
            if (this.mLayout == null) {
                assumeLayout();
            }
            if (this.mLayout.getLineCount() <= this.mMaximum) {
                return getCompoundPaddingTop();
            }
            int compoundPaddingTop = getCompoundPaddingTop();
            int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
            int lineTop = this.mLayout.getLineTop(this.mMaximum);
            i = compoundPaddingTop;
            if (lineTop < height) {
                int i2 = this.mGravity & 112;
                i = compoundPaddingTop;
                if (i2 != 48) {
                    return i2 == 80 ? (compoundPaddingTop + height) - lineTop : compoundPaddingTop + ((height - lineTop) / 2);
                }
            }
        }
        return i;
    }

    @Override // android.view.View
    protected int getFadeHeight(boolean z) {
        if (this.mLayout != null) {
            return this.mLayout.getHeight();
        }
        return 0;
    }

    @Override // android.view.View
    protected int getFadeTop(boolean z) {
        if (this.mLayout == null) {
            return 0;
        }
        int i = 0;
        if ((this.mGravity & 112) != 48) {
            i = getVerticalOffset(true);
        }
        int i2 = i;
        if (z) {
            i2 = i + getTopPaddingOffset();
        }
        return getExtendedPaddingTop() + i2;
    }

    public InputFilter[] getFilters() {
        return this.mFilters;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.mLayout == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = getSelectionEnd();
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionStart = getSelectionStart();
        if (selectionStart < 0 || selectionStart >= selectionEnd) {
            int lineForOffset = this.mLayout.getLineForOffset(selectionEnd);
            rect.top = this.mLayout.getLineTop(lineForOffset);
            rect.bottom = this.mLayout.getLineBottom(lineForOffset);
            rect.left = ((int) this.mLayout.getPrimaryHorizontal(selectionEnd)) - 2;
            rect.right = rect.left + 4;
        } else {
            int lineForOffset2 = this.mLayout.getLineForOffset(selectionStart);
            int lineForOffset3 = this.mLayout.getLineForOffset(selectionEnd);
            rect.top = this.mLayout.getLineTop(lineForOffset2);
            rect.bottom = this.mLayout.getLineBottom(lineForOffset3);
            if (lineForOffset2 == lineForOffset3) {
                rect.left = (int) this.mLayout.getPrimaryHorizontal(selectionStart);
                rect.right = (int) this.mLayout.getPrimaryHorizontal(selectionEnd);
            } else {
                if (this.mHighlightPathBogus) {
                    if (this.mHighlightPath == null) {
                        this.mHighlightPath = new Path();
                    }
                    this.mHighlightPath.reset();
                    this.mLayout.getSelectionPath(selectionStart, selectionEnd, this.mHighlightPath);
                    this.mHighlightPathBogus = false;
                }
                synchronized (TEMP_RECTF) {
                    this.mHighlightPath.computeBounds(TEMP_RECTF, true);
                    rect.left = ((int) TEMP_RECTF.left) - 1;
                    rect.right = ((int) TEMP_RECTF.right) + 1;
                }
            }
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop();
        int i = extendedPaddingTop;
        if ((this.mGravity & 112) != 48) {
            i = extendedPaddingTop + getVerticalOffset(false);
        }
        rect.offset(compoundPaddingLeft, i);
        rect.bottom += getExtendedPaddingBottom();
    }

    public String getFontFeatureSettings() {
        return this.mTextPaint.getFontFeatureSettings();
    }

    public boolean getFreezesText() {
        return this.mFreezesText;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        return this.mHint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Layout getHintLayout() {
        return this.mHintLayout;
    }

    public final ColorStateList getHintTextColors() {
        return this.mHintTextColor;
    }

    public int getHorizontalOffsetForDrawables() {
        return 0;
    }

    public boolean getHorizontallyScrolling() {
        return this.mHorizontallyScrolling;
    }

    public int getImeActionId() {
        if (this.mEditor == null || this.mEditor.mInputContentType == null) {
            return 0;
        }
        return this.mEditor.mInputContentType.imeActionId;
    }

    public CharSequence getImeActionLabel() {
        if (this.mEditor == null || this.mEditor.mInputContentType == null) {
            return null;
        }
        return this.mEditor.mInputContentType.imeActionLabel;
    }

    public int getImeOptions() {
        if (this.mEditor == null || this.mEditor.mInputContentType == null) {
            return 0;
        }
        return this.mEditor.mInputContentType.imeOptions;
    }

    public boolean getIncludeFontPadding() {
        return this.mIncludePad;
    }

    public Bundle getInputExtras(boolean z) {
        if (this.mEditor != null || z) {
            createEditorIfNeeded();
            if (this.mEditor.mInputContentType == null) {
                if (!z) {
                    return null;
                }
                this.mEditor.createInputContentTypeIfNeeded();
            }
            if (this.mEditor.mInputContentType.extras == null) {
                if (!z) {
                    return null;
                }
                this.mEditor.mInputContentType.extras = new Bundle();
            }
            return this.mEditor.mInputContentType.extras;
        }
        return null;
    }

    public int getInputType() {
        if (this.mEditor == null) {
            return 0;
        }
        return this.mEditor.mInputType;
    }

    @Override // android.view.View
    public CharSequence getIterableTextForAccessibility() {
        return this.mText;
    }

    @Override // android.view.View
    public AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(int i) {
        switch (i) {
            case 4:
                Spannable spannable = (Spannable) getIterableTextForAccessibility();
                if (!TextUtils.isEmpty(spannable) && getLayout() != null) {
                    AccessibilityIterators.LineTextSegmentIterator lineTextSegmentIterator = AccessibilityIterators.LineTextSegmentIterator.getInstance();
                    lineTextSegmentIterator.initialize(spannable, getLayout());
                    return lineTextSegmentIterator;
                }
                break;
            case 16:
                if (!TextUtils.isEmpty((Spannable) getIterableTextForAccessibility()) && getLayout() != null) {
                    AccessibilityIterators.PageTextSegmentIterator pageTextSegmentIterator = AccessibilityIterators.PageTextSegmentIterator.getInstance();
                    pageTextSegmentIterator.initialize(this);
                    return pageTextSegmentIterator;
                }
                break;
        }
        return super.getIteratorForGranularity(i);
    }

    public final KeyListener getKeyListener() {
        if (this.mEditor == null) {
            return null;
        }
        return this.mEditor.mKeyListener;
    }

    public final Layout getLayout() {
        return this.mLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        float f;
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE && this.mMarqueeFadeMode != 1) {
            if (this.mMarquee != null && !this.mMarquee.isStopped()) {
                Marquee marquee = this.mMarquee;
                f = 0.0f;
                if (marquee.shouldDrawLeftFade()) {
                    f = marquee.getScroll() / getHorizontalFadingEdgeLength();
                }
            } else if (getLineCount() == 1) {
                f = 0.0f;
                switch (Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection()) & 7) {
                    case 1:
                    case 7:
                        f = 0.0f;
                        if (this.mLayout.getParagraphDirection(0) != 1) {
                            return ((((this.mLayout.getLineRight(0) - (this.mRight - this.mLeft)) - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - this.mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength();
                        }
                        break;
                    case 5:
                        return ((((this.mLayout.getLineRight(0) - (this.mRight - this.mLeft)) - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - this.mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength();
                }
            }
            return f;
        }
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.view.View
    protected int getLeftPaddingOffset() {
        return (getCompoundPaddingLeft() - this.mPaddingLeft) + ((int) Math.min(0.0f, this.mShadowDx - this.mShadowRadius));
    }

    public float getLetterSpacing() {
        return this.mTextPaint.getLetterSpacing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLineAtCoordinate(float f) {
        return getLayout().getLineForVertical((int) (Math.min((getHeight() - getTotalPaddingBottom()) - 1, Math.max(0.0f, f - getTotalPaddingTop())) + getScrollY()));
    }

    public int getLineBounds(int i, Rect rect) {
        if (this.mLayout == null) {
            if (rect != null) {
                rect.set(0, 0, 0, 0);
                return 0;
            }
            return 0;
        }
        int lineBounds = this.mLayout.getLineBounds(i, rect);
        int extendedPaddingTop = getExtendedPaddingTop();
        int i2 = extendedPaddingTop;
        if ((this.mGravity & 112) != 48) {
            i2 = extendedPaddingTop + getVerticalOffset(true);
        }
        if (rect != null) {
            rect.offset(getCompoundPaddingLeft(), i2);
        }
        return lineBounds + i2;
    }

    public int getLineCount() {
        if (this.mLayout != null) {
            return this.mLayout.getLineCount();
        }
        return 0;
    }

    public int getLineHeight() {
        return FastMath.round((this.mTextPaint.getFontMetricsInt(null) * this.mSpacingMult) + this.mSpacingAdd);
    }

    public float getLineSpacingExtra() {
        return this.mSpacingAdd;
    }

    public float getLineSpacingMultiplier() {
        return this.mSpacingMult;
    }

    public final ColorStateList getLinkTextColors() {
        return this.mLinkTextColor;
    }

    public final boolean getLinksClickable() {
        return this.mLinksClickable;
    }

    public int getMarqueeRepeatLimit() {
        return this.mMarqueeRepeatLimit;
    }

    public int getMaxEms() {
        if (this.mMaxWidthMode == 1) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public int getMaxHeight() {
        if (this.mMaxMode == 2) {
            return this.mMaximum;
        }
        return -1;
    }

    public int getMaxLines() {
        if (this.mMaxMode == 1) {
            return this.mMaximum;
        }
        return -1;
    }

    public int getMaxWidth() {
        if (this.mMaxWidthMode == 2) {
            return this.mMaxWidth;
        }
        return -1;
    }

    public int getMinEms() {
        if (this.mMinWidthMode == 1) {
            return this.mMinWidth;
        }
        return -1;
    }

    public int getMinHeight() {
        if (this.mMinMode == 2) {
            return this.mMinimum;
        }
        return -1;
    }

    public int getMinLines() {
        if (this.mMinMode == 1) {
            return this.mMinimum;
        }
        return -1;
    }

    public int getMinWidth() {
        if (this.mMinWidthMode == 2) {
            return this.mMinWidth;
        }
        return -1;
    }

    public final MovementMethod getMovementMethod() {
        return this.mMovement;
    }

    public int getOffsetForPosition(float f, float f2) {
        if (getLayout() == null) {
            return -1;
        }
        return getOffsetAtCoordinate(getLineAtCoordinate(f2), f);
    }

    public TextPaint getPaint() {
        return this.mTextPaint;
    }

    public int getPaintFlags() {
        return this.mTextPaint.getFlags();
    }

    public String getPrivateImeOptions() {
        if (this.mEditor == null || this.mEditor.mInputContentType == null) {
            return null;
        }
        return this.mEditor.mInputContentType.privateImeOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        float f;
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE && this.mMarqueeFadeMode != 1) {
            if (this.mMarquee != null && !this.mMarquee.isStopped()) {
                Marquee marquee = this.mMarquee;
                f = (marquee.getMaxFadeScroll() - marquee.getScroll()) / getHorizontalFadingEdgeLength();
            } else if (getLineCount() == 1) {
                f = 0.0f;
                switch (Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection()) & 7) {
                    case 1:
                    case 7:
                        f = 0.0f;
                        if (this.mLayout.getParagraphDirection(0) != -1) {
                            return (this.mLayout.getLineWidth(0) - (((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight())) / getHorizontalFadingEdgeLength();
                        }
                        break;
                    case 3:
                        int i = this.mRight;
                        int i2 = this.mLeft;
                        int compoundPaddingLeft = getCompoundPaddingLeft();
                        return (this.mLayout.getLineWidth(0) - (((i - i2) - compoundPaddingLeft) - getCompoundPaddingRight())) / getHorizontalFadingEdgeLength();
                }
            }
            return f;
        }
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    protected int getRightPaddingOffset() {
        return (-(getFudgedPaddingRight() - this.mPaddingRight)) + ((int) Math.max(0.0f, this.mShadowDx + this.mShadowRadius));
    }

    @ViewDebug.ExportedProperty(category = "text")
    public float getScaledTextSize() {
        return this.mTextPaint.getTextSize() / this.mTextPaint.density;
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        return Selection.getSelectionEnd(getText());
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        return Selection.getSelectionStart(getText());
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public float getShadowDx() {
        return this.mShadowDx;
    }

    public float getShadowDy() {
        return this.mShadowDy;
    }

    public float getShadowRadius() {
        return this.mShadowRadius;
    }

    public final boolean getShowSoftInputOnFocus() {
        return this.mEditor == null || this.mEditor.mShowSoftInputOnFocus;
    }

    public Locale getSpellCheckerLocale() {
        return getTextServicesLocale(true);
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        return this.mText;
    }

    public final ColorStateList getTextColors() {
        return this.mTextColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextDirectionHeuristic getTextDirectionHeuristic() {
        boolean z = true;
        if (hasPasswordTransformationMethod()) {
            return TextDirectionHeuristics.ANYRTL_LTR;
        }
        if (getLayoutDirection() != 1) {
            z = false;
        }
        switch (getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            default:
                return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public CharSequence getTextForAccessibility() {
        CharSequence text = getText();
        CharSequence charSequence = text;
        if (TextUtils.isEmpty(text)) {
            charSequence = getHint();
        }
        return charSequence;
    }

    public Locale getTextLocale() {
        return this.mTextPaint.getTextLocale();
    }

    public float getTextScaleX() {
        return this.mTextPaint.getTextScaleX();
    }

    public Locale getTextServicesLocale() {
        return getTextServicesLocale(false);
    }

    @ViewDebug.ExportedProperty(category = "text")
    public float getTextSize() {
        return this.mTextPaint.getTextSize();
    }

    @Override // android.view.View
    protected int getTopPaddingOffset() {
        return (int) Math.min(0.0f, this.mShadowDy - this.mShadowRadius);
    }

    public int getTotalPaddingBottom() {
        return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    public int getTotalPaddingEnd() {
        return getCompoundPaddingEnd();
    }

    public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    public int getTotalPaddingStart() {
        return getCompoundPaddingStart();
    }

    public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    public final TransformationMethod getTransformationMethod() {
        return this.mTransformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getTransformedText(int i, int i2) {
        return removeSuggestionSpans(this.mTransformed.subSequence(i, i2));
    }

    public Typeface getTypeface() {
        return this.mTextPaint.getTypeface();
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "NORMAL"), @ViewDebug.IntToString(from = 1, to = "BOLD"), @ViewDebug.IntToString(from = 2, to = "ITALIC"), @ViewDebug.IntToString(from = 3, to = "BOLD_ITALIC")})
    public int getTypefaceStyle() {
        return this.mTextPaint.getTypeface().getStyle();
    }

    public final UndoManager getUndoManager() {
        if (this.mEditor == null) {
            return null;
        }
        return this.mEditor.mUndoManager;
    }

    public URLSpan[] getUrls() {
        return this.mText instanceof Spanned ? (URLSpan[]) ((Spanned) this.mText).getSpans(0, this.mText.length(), URLSpan.class) : new URLSpan[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVerticalOffset(boolean z) {
        int i = this.mGravity & 112;
        Layout layout = this.mLayout;
        Layout layout2 = layout;
        if (!z) {
            layout2 = layout;
            if (this.mText.length() == 0) {
                layout2 = layout;
                if (this.mHintLayout != null) {
                    layout2 = this.mHintLayout;
                }
            }
        }
        int i2 = 0;
        if (i != 48) {
            int boxHeight = getBoxHeight(layout2);
            int height = layout2.getHeight();
            i2 = 0;
            if (height < boxHeight) {
                if (i != 80) {
                    return (boxHeight - height) >> 1;
                }
                i2 = boxHeight - height;
            }
        }
        return i2;
    }

    public WordIterator getWordIterator() {
        if (this.mEditor != null) {
            return this.mEditor.getWordIterator();
        }
        return null;
    }

    void handleTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Editor.InputMethodState inputMethodState = this.mEditor == null ? null : this.mEditor.mInputMethodState;
        if (inputMethodState == null || inputMethodState.mBatchEditNesting == 0) {
            updateAfterEdit();
        }
        if (inputMethodState != null) {
            inputMethodState.mContentChanged = true;
            if (inputMethodState.mChangedStart < 0) {
                inputMethodState.mChangedStart = i;
                inputMethodState.mChangedEnd = i + i2;
            } else {
                inputMethodState.mChangedStart = Math.min(inputMethodState.mChangedStart, i);
                inputMethodState.mChangedEnd = Math.max(inputMethodState.mChangedEnd, (i + i2) - inputMethodState.mChangedDelta);
            }
            inputMethodState.mChangedDelta += i3 - i2;
        }
        resetErrorChangedFlag();
        sendOnTextChanged(charSequence, i, i2, i3);
        onTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return !(getBackground() == null || getBackground().getCurrent() == null) || (this.mText instanceof Spannable) || hasSelection() || isHorizontalFadingEdgeEnabled();
    }

    public boolean hasSelection() {
        int selectionStart = getSelectionStart();
        return selectionStart >= 0 && selectionStart != getSelectionEnd();
    }

    public void hideErrorIfUnchanged() {
        if (this.mEditor == null || this.mEditor.mError == null || this.mEditor.mErrorWasChanged) {
            return;
        }
        setError(null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateCursor() {
        int selectionEnd = getSelectionEnd();
        invalidateCursor(selectionEnd, selectionEnd, selectionEnd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateCursorPath() {
        if (this.mHighlightPathBogus) {
            invalidateCursor();
            return;
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop() + getVerticalOffset(true);
        if (this.mEditor.mCursorCount == 0) {
            synchronized (TEMP_RECTF) {
                float ceil = FloatMath.ceil(this.mTextPaint.getStrokeWidth());
                float f = ceil;
                if (ceil < 1.0f) {
                    f = 1.0f;
                }
                float f2 = f / 2.0f;
                this.mHighlightPath.computeBounds(TEMP_RECTF, false);
                invalidate((int) FloatMath.floor((compoundPaddingLeft + TEMP_RECTF.left) - f2), (int) FloatMath.floor((extendedPaddingTop + TEMP_RECTF.top) - f2), (int) FloatMath.ceil(compoundPaddingLeft + TEMP_RECTF.right + f2), (int) FloatMath.ceil(extendedPaddingTop + TEMP_RECTF.bottom + f2));
            }
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mEditor.mCursorCount) {
                return;
            }
            Rect bounds = this.mEditor.mCursorDrawable[i2].getBounds();
            invalidate(bounds.left + compoundPaddingLeft, bounds.top + extendedPaddingTop, bounds.right + compoundPaddingLeft, bounds.bottom + extendedPaddingTop);
            i = i2 + 1;
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        boolean z = false;
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            Drawables drawables = this.mDrawables;
            boolean z2 = false;
            int i3 = i;
            int i4 = i2;
            if (drawables != null) {
                if (drawable == drawables.mDrawableLeft) {
                    int compoundPaddingTop = getCompoundPaddingTop();
                    int compoundPaddingBottom = getCompoundPaddingBottom();
                    int i5 = this.mBottom;
                    int i6 = this.mTop;
                    i3 = i + this.mPaddingLeft;
                    i4 = i2 + (((((i5 - i6) - compoundPaddingBottom) - compoundPaddingTop) - drawables.mDrawableHeightLeft) / 2) + compoundPaddingTop;
                    z2 = true;
                } else if (drawable == drawables.mDrawableRight) {
                    int compoundPaddingTop2 = getCompoundPaddingTop();
                    int compoundPaddingBottom2 = getCompoundPaddingBottom();
                    int i7 = this.mBottom;
                    int i8 = this.mTop;
                    i3 = i + (((this.mRight - this.mLeft) - this.mPaddingRight) - drawables.mDrawableSizeRight);
                    i4 = i2 + (((((i7 - i8) - compoundPaddingBottom2) - compoundPaddingTop2) - drawables.mDrawableHeightRight) / 2) + compoundPaddingTop2;
                    z2 = true;
                } else if (drawable == drawables.mDrawableTop) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    i3 = i + (((((this.mRight - this.mLeft) - getCompoundPaddingRight()) - compoundPaddingLeft) - drawables.mDrawableWidthTop) / 2) + compoundPaddingLeft;
                    i4 = i2 + this.mPaddingTop;
                    z2 = true;
                } else {
                    z2 = false;
                    i3 = i;
                    i4 = i2;
                    if (drawable == drawables.mDrawableBottom) {
                        int compoundPaddingLeft2 = getCompoundPaddingLeft();
                        i3 = i + (((((this.mRight - this.mLeft) - getCompoundPaddingRight()) - compoundPaddingLeft2) - drawables.mDrawableWidthBottom) / 2) + compoundPaddingLeft2;
                        i4 = i2 + (((this.mBottom - this.mTop) - this.mPaddingBottom) - drawables.mDrawableSizeBottom);
                        z2 = true;
                    }
                }
            }
            z = z2;
            if (z2) {
                invalidate(bounds.left + i3, bounds.top + i4, bounds.right + i3, bounds.bottom + i4);
                z = z2;
            }
        }
        if (z) {
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateRegion(int i, int i2, boolean z) {
        int i3;
        int width;
        if (this.mLayout == null) {
            invalidate();
            return;
        }
        int lineForOffset = this.mLayout.getLineForOffset(i);
        int lineTop = this.mLayout.getLineTop(lineForOffset);
        int i4 = lineTop;
        if (lineForOffset > 0) {
            i4 = lineTop - this.mLayout.getLineDescent(lineForOffset - 1);
        }
        int lineForOffset2 = i == i2 ? lineForOffset : this.mLayout.getLineForOffset(i2);
        int lineBottom = this.mLayout.getLineBottom(lineForOffset2);
        int i5 = lineBottom;
        int i6 = i4;
        if (z) {
            i5 = lineBottom;
            i6 = i4;
            if (this.mEditor != null) {
                int i7 = 0;
                int i8 = i4;
                int i9 = lineBottom;
                while (true) {
                    i5 = i9;
                    i6 = i8;
                    if (i7 >= this.mEditor.mCursorCount) {
                        break;
                    }
                    Rect bounds = this.mEditor.mCursorDrawable[i7].getBounds();
                    i8 = Math.min(i8, bounds.top);
                    i9 = Math.max(i9, bounds.bottom);
                    i7++;
                }
            }
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int extendedPaddingTop = getExtendedPaddingTop() + getVerticalOffset(true);
        if (lineForOffset != lineForOffset2 || z) {
            i3 = compoundPaddingLeft;
            width = getWidth() - getCompoundPaddingRight();
        } else {
            i3 = ((int) this.mLayout.getPrimaryHorizontal(i)) + compoundPaddingLeft;
            width = ((int) (this.mLayout.getPrimaryHorizontal(i2) + 1.0d)) + compoundPaddingLeft;
        }
        invalidate(this.mScrollX + i3, extendedPaddingTop + i6, this.mScrollX + width, extendedPaddingTop + i5);
    }

    @Override // android.view.View
    public boolean isAccessibilitySelectionExtendable() {
        return true;
    }

    public boolean isCursorVisible() {
        if (this.mEditor == null) {
            return true;
        }
        return this.mEditor.mCursorVisible;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInBatchEditMode() {
        if (this.mEditor == null) {
            return false;
        }
        Editor.InputMethodState inputMethodState = this.mEditor.mInputMethodState;
        return inputMethodState != null ? inputMethodState.mBatchEditNesting > 0 : this.mEditor.mInBatchEditControllers;
    }

    public boolean isInputMethodTarget() {
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        return peekInstance != null && peekInstance.isActive(this);
    }

    @Override // android.view.View
    protected boolean isPaddingOffsetRequired() {
        return (this.mShadowRadius == 0.0f && this.mDrawables == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSingleLine() {
        return this.mSingleLine;
    }

    public boolean isSuggestionsEnabled() {
        if (this.mEditor != null && (this.mEditor.mInputType & 15) == 1 && (this.mEditor.mInputType & 524288) <= 0) {
            int i = this.mEditor.mInputType & InputType.TYPE_MASK_VARIATION;
            return i == 0 || i == 48 || i == 80 || i == 64 || i == 160;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTextEditable() {
        return (this.mText instanceof Editable) && onCheckIsTextEditor() && isEnabled();
    }

    public boolean isTextSelectable() {
        if (this.mEditor == null) {
            return false;
        }
        return this.mEditor.mTextIsSelectable;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mDrawables != null) {
            if (this.mDrawables.mDrawableLeft != null) {
                this.mDrawables.mDrawableLeft.jumpToCurrentState();
            }
            if (this.mDrawables.mDrawableTop != null) {
                this.mDrawables.mDrawableTop.jumpToCurrentState();
            }
            if (this.mDrawables.mDrawableRight != null) {
                this.mDrawables.mDrawableRight.jumpToCurrentState();
            }
            if (this.mDrawables.mDrawableBottom != null) {
                this.mDrawables.mDrawableBottom.jumpToCurrentState();
            }
            if (this.mDrawables.mDrawableStart != null) {
                this.mDrawables.mDrawableStart.jumpToCurrentState();
            }
            if (this.mDrawables.mDrawableEnd != null) {
                this.mDrawables.mDrawableEnd.jumpToCurrentState();
            }
        }
    }

    public int length() {
        return this.mText.length();
    }

    protected void makeNewLayout(int i, int i2, BoringLayout.Metrics metrics, BoringLayout.Metrics metrics2, int i3, boolean z) {
        stopMarquee();
        this.mOldMaximum = this.mMaximum;
        this.mOldMaxMode = this.mMaxMode;
        this.mHighlightPathBogus = true;
        int i4 = i;
        if (i < 0) {
            i4 = 0;
        }
        int i5 = i2;
        if (i2 < 0) {
            i5 = 0;
        }
        Layout.Alignment layoutAlignment = getLayoutAlignment();
        boolean z2 = this.mSingleLine && this.mLayout != null && (layoutAlignment == Layout.Alignment.ALIGN_NORMAL || layoutAlignment == Layout.Alignment.ALIGN_OPPOSITE);
        int i6 = 0;
        if (z2) {
            i6 = this.mLayout.getParagraphDirection(0);
        }
        boolean z3 = this.mEllipsize != null && getKeyListener() == null;
        boolean z4 = this.mEllipsize == TextUtils.TruncateAt.MARQUEE && this.mMarqueeFadeMode != 0;
        TextUtils.TruncateAt truncateAt = this.mEllipsize;
        TextUtils.TruncateAt truncateAt2 = truncateAt;
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            truncateAt2 = truncateAt;
            if (this.mMarqueeFadeMode == 1) {
                truncateAt2 = TextUtils.TruncateAt.END_SMALL;
            }
        }
        if (this.mTextDir == null) {
            this.mTextDir = getTextDirectionHeuristic();
        }
        this.mLayout = makeSingleLayout(i4, metrics, i3, layoutAlignment, z3, truncateAt2, truncateAt2 == this.mEllipsize);
        if (z4) {
            this.mSavedMarqueeModeLayout = makeSingleLayout(i4, metrics, i3, layoutAlignment, z3, truncateAt2 == TextUtils.TruncateAt.MARQUEE ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE, truncateAt2 != this.mEllipsize);
        }
        boolean z5 = this.mEllipsize != null;
        this.mHintLayout = null;
        if (this.mHint != null) {
            if (z5) {
                i5 = i4;
            }
            BoringLayout.Metrics metrics3 = metrics2;
            if (metrics2 == UNKNOWN_BORING) {
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(this.mHint, this.mTextPaint, this.mTextDir, this.mHintBoring);
                metrics3 = isBoring;
                if (isBoring != null) {
                    this.mHintBoring = isBoring;
                    metrics3 = isBoring;
                }
            }
            if (metrics3 != null) {
                if (metrics3.width <= i5 && (!z5 || metrics3.width <= i3)) {
                    if (this.mSavedHintLayout != null) {
                        this.mHintLayout = this.mSavedHintLayout.replaceOrMake(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mSpacingMult, this.mSpacingAdd, metrics3, this.mIncludePad);
                    } else {
                        this.mHintLayout = BoringLayout.make(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mSpacingMult, this.mSpacingAdd, metrics3, this.mIncludePad);
                    }
                    this.mSavedHintLayout = (BoringLayout) this.mHintLayout;
                } else if (!z5 || metrics3.width > i5) {
                    if (z5) {
                        this.mHintLayout = new StaticLayout(this.mHint, 0, this.mHint.length(), this.mTextPaint, i5, layoutAlignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, i3, this.mMaxMode == 1 ? this.mMaximum : Integer.MAX_VALUE);
                    } else {
                        this.mHintLayout = new StaticLayout(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad);
                    }
                } else if (this.mSavedHintLayout != null) {
                    this.mHintLayout = this.mSavedHintLayout.replaceOrMake(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mSpacingMult, this.mSpacingAdd, metrics3, this.mIncludePad, this.mEllipsize, i3);
                } else {
                    this.mHintLayout = BoringLayout.make(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mSpacingMult, this.mSpacingAdd, metrics3, this.mIncludePad, this.mEllipsize, i3);
                }
            } else if (z5) {
                this.mHintLayout = new StaticLayout(this.mHint, 0, this.mHint.length(), this.mTextPaint, i5, layoutAlignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, i3, this.mMaxMode == 1 ? this.mMaximum : Integer.MAX_VALUE);
            } else {
                this.mHintLayout = new StaticLayout(this.mHint, this.mTextPaint, i5, layoutAlignment, this.mTextDir, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad);
            }
        }
        if (z || (z2 && i6 != this.mLayout.getParagraphDirection(0))) {
            registerForPreDraw();
        }
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE && !compressText(i3)) {
            int i7 = this.mLayoutParams.height;
            if (i7 == -2 || i7 == -1) {
                this.mRestartMarquee = true;
            } else {
                startMarquee();
            }
        }
        if (this.mEditor != null) {
            this.mEditor.prepareCursorControllers();
        }
    }

    public boolean moveCursorToVisibleOffset() {
        int selectionStart;
        if ((this.mText instanceof Spannable) && (selectionStart = getSelectionStart()) == getSelectionEnd()) {
            int lineForOffset = this.mLayout.getLineForOffset(selectionStart);
            int lineTop = this.mLayout.getLineTop(lineForOffset);
            int lineTop2 = this.mLayout.getLineTop(lineForOffset + 1);
            int extendedPaddingTop = ((this.mBottom - this.mTop) - getExtendedPaddingTop()) - getExtendedPaddingBottom();
            int i = (lineTop2 - lineTop) / 2;
            int i2 = i;
            if (i > extendedPaddingTop / 4) {
                i2 = extendedPaddingTop / 4;
            }
            int i3 = this.mScrollY;
            if (lineTop < i3 + i2) {
                lineForOffset = this.mLayout.getLineForVertical(i3 + i2 + (lineTop2 - lineTop));
            } else if (lineTop2 > (extendedPaddingTop + i3) - i2) {
                lineForOffset = this.mLayout.getLineForVertical(((extendedPaddingTop + i3) - i2) - (lineTop2 - lineTop));
            }
            int i4 = this.mRight;
            int i5 = this.mLeft;
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int compoundPaddingRight = getCompoundPaddingRight();
            int i6 = this.mScrollX;
            int offsetForHorizontal = this.mLayout.getOffsetForHorizontal(lineForOffset, i6);
            int offsetForHorizontal2 = this.mLayout.getOffsetForHorizontal(lineForOffset, (((i4 - i5) - compoundPaddingLeft) - compoundPaddingRight) + i6);
            int i7 = offsetForHorizontal < offsetForHorizontal2 ? offsetForHorizontal : offsetForHorizontal2;
            if (offsetForHorizontal <= offsetForHorizontal2) {
                offsetForHorizontal = offsetForHorizontal2;
            }
            if (selectionStart >= i7) {
                i7 = selectionStart;
                if (selectionStart > offsetForHorizontal) {
                    i7 = offsetForHorizontal;
                }
            }
            if (i7 != selectionStart) {
                Selection.setSelection((Spannable) this.mText, i7);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mTemporaryDetach = false;
        if (this.mEditor != null) {
            this.mEditor.onAttachedToWindow();
        }
        if (this.mPreDrawListenerDetached) {
            getViewTreeObserver().addOnPreDrawListener(this);
            this.mPreDrawListenerDetached = false;
        }
    }

    public void onBeginBatchEdit() {
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return (this.mEditor == null || this.mEditor.mInputType == 0) ? false : true;
    }

    public void onCommitCompletion(CompletionInfo completionInfo) {
    }

    public void onCommitCorrection(CorrectionInfo correctionInfo) {
        if (this.mEditor != null) {
            this.mEditor.onCommitCorrection(correctionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState;
        if (this.mSingleLine) {
            onCreateDrawableState = super.onCreateDrawableState(i);
        } else {
            onCreateDrawableState = super.onCreateDrawableState(i + 1);
            mergeDrawableStates(onCreateDrawableState, MULTILINE_STATE_SET);
        }
        if (isTextSelectable()) {
            int length = onCreateDrawableState.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                } else if (onCreateDrawableState[i3] == 16842919) {
                    int[] iArr = new int[length - 1];
                    System.arraycopy(onCreateDrawableState, 0, iArr, 0, i3);
                    System.arraycopy(onCreateDrawableState, i3 + 1, iArr, i3, (length - i3) - 1);
                    return iArr;
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (onCheckIsTextEditor() && isEnabled()) {
            this.mEditor.createInputMethodStateIfNeeded();
            editorInfo.inputType = getInputType();
            if (this.mEditor.mInputContentType != null) {
                editorInfo.imeOptions = this.mEditor.mInputContentType.imeOptions;
                editorInfo.privateImeOptions = this.mEditor.mInputContentType.privateImeOptions;
                editorInfo.actionLabel = this.mEditor.mInputContentType.imeActionLabel;
                editorInfo.actionId = this.mEditor.mInputContentType.imeActionId;
                editorInfo.extras = this.mEditor.mInputContentType.extras;
            } else {
                editorInfo.imeOptions = 0;
            }
            if (focusSearch(130) != null) {
                editorInfo.imeOptions |= 134217728;
            }
            if (focusSearch(33) != null) {
                editorInfo.imeOptions |= 67108864;
            }
            if ((editorInfo.imeOptions & 255) == 0) {
                if ((editorInfo.imeOptions & 134217728) != 0) {
                    editorInfo.imeOptions |= 5;
                } else {
                    editorInfo.imeOptions |= 6;
                }
                if (!shouldAdvanceFocusOnEnter()) {
                    editorInfo.imeOptions |= 1073741824;
                }
            }
            if (isMultilineInputType(editorInfo.inputType)) {
                editorInfo.imeOptions |= 1073741824;
            }
            editorInfo.hintText = this.mHint;
            if (this.mText instanceof Editable) {
                EditableInputConnection editableInputConnection = new EditableInputConnection(this);
                editorInfo.initialSelStart = getSelectionStart();
                editorInfo.initialSelEnd = getSelectionEnd();
                editorInfo.initialCapsMode = editableInputConnection.getCursorCapsMode(getInputType());
                return editableInputConnection;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindowInternal() {
        if (this.mPreDrawRegistered) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.mPreDrawListenerDetached = true;
        }
        resetResolvedDrawables();
        if (this.mEditor != null) {
            this.mEditor.onDetachedFromWindow();
        }
        super.onDetachedFromWindowInternal();
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                return this.mEditor != null && this.mEditor.hasInsertionController();
            case 2:
                Selection.setSelection((Spannable) this.mText, getOffsetForPosition(dragEvent.getX(), dragEvent.getY()));
                return true;
            case 3:
                if (this.mEditor != null) {
                    this.mEditor.onDrop(dragEvent);
                    return true;
                }
                return true;
            case 4:
            default:
                return true;
            case 5:
                requestFocus();
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        restartMarqueeIfNeeded();
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int i = this.mScrollX;
        int i2 = this.mScrollY;
        int i3 = this.mRight;
        int i4 = this.mLeft;
        int i5 = this.mBottom;
        int i6 = this.mTop;
        boolean isLayoutRtl = isLayoutRtl();
        int horizontalOffsetForDrawables = getHorizontalOffsetForDrawables();
        int i7 = isLayoutRtl ? 0 : horizontalOffsetForDrawables;
        if (!isLayoutRtl) {
            horizontalOffsetForDrawables = 0;
        }
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            int i8 = ((i5 - i6) - compoundPaddingBottom) - compoundPaddingTop;
            int i9 = ((i3 - i4) - compoundPaddingRight) - compoundPaddingLeft;
            if (drawables.mDrawableLeft != null) {
                canvas.save();
                canvas.translate(this.mPaddingLeft + i + i7, i2 + compoundPaddingTop + ((i8 - drawables.mDrawableHeightLeft) / 2));
                drawables.mDrawableLeft.draw(canvas);
                canvas.restore();
            }
            if (drawables.mDrawableRight != null) {
                canvas.save();
                canvas.translate(((((i + i3) - i4) - this.mPaddingRight) - drawables.mDrawableSizeRight) - horizontalOffsetForDrawables, i2 + compoundPaddingTop + ((i8 - drawables.mDrawableHeightRight) / 2));
                drawables.mDrawableRight.draw(canvas);
                canvas.restore();
            }
            if (drawables.mDrawableTop != null) {
                canvas.save();
                canvas.translate(i + compoundPaddingLeft + ((i9 - drawables.mDrawableWidthTop) / 2), this.mPaddingTop + i2);
                drawables.mDrawableTop.draw(canvas);
                canvas.restore();
            }
            if (drawables.mDrawableBottom != null) {
                canvas.save();
                canvas.translate(i + compoundPaddingLeft + ((i9 - drawables.mDrawableWidthBottom) / 2), (((i2 + i5) - i6) - this.mPaddingBottom) - drawables.mDrawableSizeBottom);
                drawables.mDrawableBottom.draw(canvas);
                canvas.restore();
            }
        }
        int i10 = this.mCurTextColor;
        if (this.mLayout == null) {
            assumeLayout();
        }
        Layout layout = this.mLayout;
        Layout layout2 = layout;
        int i11 = i10;
        if (this.mHint != null) {
            layout2 = layout;
            i11 = i10;
            if (this.mText.length() == 0) {
                if (this.mHintTextColor != null) {
                    i10 = this.mCurHintTextColor;
                }
                layout2 = this.mHintLayout;
                i11 = i10;
            }
        }
        this.mTextPaint.setColor(i11);
        this.mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        int extendedPaddingBottom = getExtendedPaddingBottom();
        int i12 = this.mBottom;
        int i13 = this.mTop;
        int height = this.mLayout.getHeight();
        float f = compoundPaddingLeft + i;
        float f2 = i2 == 0 ? 0.0f : extendedPaddingTop + i2;
        float fudgedPaddingRight = ((i3 - i4) - getFudgedPaddingRight()) + i;
        if (i2 == height - (((i12 - i13) - compoundPaddingBottom) - compoundPaddingTop)) {
            extendedPaddingBottom = 0;
        }
        float f3 = ((i5 - i6) + i2) - extendedPaddingBottom;
        float f4 = f3;
        float f5 = f;
        float f6 = fudgedPaddingRight;
        float f7 = f2;
        if (this.mShadowRadius != 0.0f) {
            f5 = f + Math.min(0.0f, this.mShadowDx - this.mShadowRadius);
            f6 = fudgedPaddingRight + Math.max(0.0f, this.mShadowDx + this.mShadowRadius);
            f7 = f2 + Math.min(0.0f, this.mShadowDy - this.mShadowRadius);
            f4 = f3 + Math.max(0.0f, this.mShadowDy + this.mShadowRadius);
        }
        canvas.clipRect(f5, f7, f6, f4);
        int i14 = 0;
        int i15 = 0;
        if ((this.mGravity & 112) != 48) {
            i14 = getVerticalOffset(false);
            i15 = getVerticalOffset(true);
        }
        canvas.translate(compoundPaddingLeft, extendedPaddingTop + i14);
        int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        if (this.mEllipsize == TextUtils.TruncateAt.MARQUEE && this.mMarqueeFadeMode != 1) {
            if (!this.mSingleLine && getLineCount() == 1 && canMarquee() && (absoluteGravity & 7) != 3) {
                canvas.translate(layout2.getParagraphDirection(0) * (this.mLayout.getLineRight(0) - ((this.mRight - this.mLeft) - (getCompoundPaddingLeft() + getCompoundPaddingRight()))), 0.0f);
            }
            if (this.mMarquee != null && this.mMarquee.isRunning()) {
                canvas.translate(layout2.getParagraphDirection(0) * (-this.mMarquee.getScroll()), 0.0f);
            }
        }
        int i16 = i15 - i14;
        Path updatedHighlightPath = getUpdatedHighlightPath();
        if (this.mEditor != null) {
            this.mEditor.onDraw(canvas, layout2, updatedHighlightPath, this.mHighlightPaint, i16);
        } else {
            layout2.draw(canvas, updatedHighlightPath, this.mHighlightPaint, i16);
        }
        if (this.mMarquee != null && this.mMarquee.shouldDrawGhost()) {
            canvas.translate(layout2.getParagraphDirection(0) * this.mMarquee.getGhostOffset(), 0.0f);
            layout2.draw(canvas, updatedHighlightPath, this.mHighlightPaint, i16);
        }
        canvas.restore();
    }

    public void onEditorAction(int i) {
        Editor.InputContentType inputContentType = this.mEditor == null ? null : this.mEditor.mInputContentType;
        if (inputContentType != null) {
            if (inputContentType.onEditorActionListener != null && inputContentType.onEditorActionListener.onEditorAction(this, i, null)) {
                return;
            }
            if (i == 5) {
                View focusSearch = focusSearch(2);
                if (focusSearch != null && !focusSearch.requestFocus(2)) {
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                }
                return;
            } else if (i == 7) {
                View focusSearch2 = focusSearch(1);
                if (focusSearch2 != null && !focusSearch2.requestFocus(1)) {
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                }
                return;
            } else if (i == 6) {
                InputMethodManager peekInstance = InputMethodManager.peekInstance();
                if (peekInstance == null || !peekInstance.isActive(this)) {
                    return;
                }
                peekInstance.hideSoftInputFromWindow(getWindowToken(), 0);
                return;
            }
        }
        ViewRootImpl viewRootImpl = getViewRootImpl();
        if (viewRootImpl != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            viewRootImpl.dispatchKeyFromIme(new KeyEvent(uptimeMillis, uptimeMillis, 0, 66, 0, 0, -1, 0, 22));
            viewRootImpl.dispatchKeyFromIme(new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, 66, 0, 0, -1, 0, 22));
        }
    }

    public void onEndBatchEdit() {
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (!this.mDispatchTemporaryDetach) {
            this.mTemporaryDetach = false;
        }
        if (this.mEditor != null) {
            this.mEditor.mTemporaryDetach = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mTemporaryDetach) {
            super.onFocusChanged(z, i, rect);
            return;
        }
        if (this.mEditor != null) {
            this.mEditor.onFocusChanged(z, i);
        }
        if (z && (this.mText instanceof Spannable)) {
            MetaKeyKeyListener.resetMetaState((Spannable) this.mText);
        }
        startStopMarquee(z);
        if (this.mTransformation != null) {
            this.mTransformation.onFocusChanged(this, this.mText, z, i, rect);
        }
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mMovement != null && (this.mText instanceof Spannable) && this.mLayout != null) {
            try {
                if (this.mMovement.onGenericMotionEvent(this, (Spannable) this.mText, motionEvent)) {
                    return true;
                }
            } catch (AbstractMethodError e) {
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextView.class.getName());
        accessibilityEvent.setPassword(hasPasswordTransformationMethod());
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(this.mText));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(this.mText));
            accessibilityEvent.setItemCount(this.mText.length());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextView.class.getName());
        boolean hasPasswordTransformationMethod = hasPasswordTransformationMethod();
        accessibilityNodeInfo.setPassword(hasPasswordTransformationMethod);
        if (!hasPasswordTransformationMethod || shouldSpeakPasswordsForAccessibility()) {
            accessibilityNodeInfo.setText(getTextForAccessibility());
        }
        if (this.mBufferType == BufferType.EDITABLE) {
            accessibilityNodeInfo.setEditable(true);
        }
        if (this.mEditor != null) {
            accessibilityNodeInfo.setInputType(this.mEditor.mInputType);
            if (this.mEditor.mError != null) {
                accessibilityNodeInfo.setContentInvalid(true);
                accessibilityNodeInfo.setError(this.mEditor.mError);
            }
        }
        if (!TextUtils.isEmpty(this.mText)) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
        }
        if (isFocused()) {
            if (canSelectText()) {
                accessibilityNodeInfo.addAction(131072);
            }
            if (canCopy()) {
                accessibilityNodeInfo.addAction(16384);
            }
            if (canPaste()) {
                accessibilityNodeInfo.addAction(32768);
            }
            if (canCut()) {
                accessibilityNodeInfo.addAction(65536);
            }
        }
        int length = this.mFilters.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            InputFilter inputFilter = this.mFilters[i2];
            if (inputFilter instanceof InputFilter.LengthFilter) {
                accessibilityNodeInfo.setMaxTextLength(((InputFilter.LengthFilter) inputFilter).getMax());
            }
            i = i2 + 1;
        }
        if (isSingleLine()) {
            return;
        }
        accessibilityNodeInfo.setMultiLine(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (doKeyDown(i, keyEvent, null) == 0) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        KeyEvent changeAction = KeyEvent.changeAction(keyEvent, 0);
        int doKeyDown = doKeyDown(i, changeAction, keyEvent);
        if (doKeyDown == 0) {
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        if (doKeyDown == -1) {
            return true;
        }
        int i3 = i2 - 1;
        KeyEvent changeAction2 = KeyEvent.changeAction(keyEvent, 1);
        if (doKeyDown == 1) {
            this.mEditor.mKeyListener.onKeyUp(this, (Editable) this.mText, i, changeAction2);
            while (true) {
                i3--;
                if (i3 <= 0) {
                    hideErrorIfUnchanged();
                    return true;
                }
                this.mEditor.mKeyListener.onKeyDown(this, (Editable) this.mText, i, changeAction);
                this.mEditor.mKeyListener.onKeyUp(this, (Editable) this.mText, i, changeAction2);
            }
        } else if (doKeyDown != 2) {
            return true;
        } else {
            this.mMovement.onKeyUp(this, (Spannable) this.mText, i, changeAction2);
            while (true) {
                i3--;
                if (i3 <= 0) {
                    return true;
                }
                this.mMovement.onKeyDown(this, (Spannable) this.mText, i, changeAction);
                this.mMovement.onKeyUp(this, (Spannable) this.mText, i, changeAction2);
            }
        }
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if ((this.mEditor == null || this.mEditor.mSelectionActionMode == null) ? false : true) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                        return true;
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        stopSelectionActionMode();
                        return true;
                    }
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState() & (-28673))) {
            switch (i) {
                case 29:
                    if (canSelectText()) {
                        return onTextContextMenuItem(16908319);
                    }
                    break;
                case 31:
                    if (canCopy()) {
                        return onTextContextMenuItem(16908321);
                    }
                    break;
                case 50:
                    if (canPaste()) {
                        return onTextContextMenuItem(16908322);
                    }
                    break;
                case 52:
                    if (canCut()) {
                        return onTextContextMenuItem(16908320);
                    }
                    break;
            }
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InputMethodManager peekInstance;
        if (isEnabled()) {
            if (!KeyEvent.isModifierKey(i)) {
                this.mPreventDefaultMovement = false;
            }
            switch (i) {
                case 23:
                    if (keyEvent.hasNoModifiers() && !hasOnClickListeners() && this.mMovement != null && (this.mText instanceof Editable) && this.mLayout != null && onCheckIsTextEditor()) {
                        InputMethodManager peekInstance2 = InputMethodManager.peekInstance();
                        viewClicked(peekInstance2);
                        if (peekInstance2 != null && getShowSoftInputOnFocus()) {
                            peekInstance2.showSoftInput(this, 0);
                        }
                    }
                    return super.onKeyUp(i, keyEvent);
                case 66:
                    if (keyEvent.hasNoModifiers()) {
                        if (this.mEditor != null && this.mEditor.mInputContentType != null && this.mEditor.mInputContentType.onEditorActionListener != null && this.mEditor.mInputContentType.enterDown) {
                            this.mEditor.mInputContentType.enterDown = false;
                            if (this.mEditor.mInputContentType.onEditorActionListener.onEditorAction(this, 0, keyEvent)) {
                                return true;
                            }
                        }
                        if (((keyEvent.getFlags() & 16) != 0 || shouldAdvanceFocusOnEnter()) && !hasOnClickListeners()) {
                            View focusSearch = focusSearch(130);
                            if (focusSearch != null) {
                                if (focusSearch.requestFocus(130)) {
                                    super.onKeyUp(i, keyEvent);
                                    return true;
                                }
                                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                            } else if ((keyEvent.getFlags() & 16) != 0 && (peekInstance = InputMethodManager.peekInstance()) != null && peekInstance.isActive(this)) {
                                peekInstance.hideSoftInputFromWindow(getWindowToken(), 0);
                            }
                        }
                        return super.onKeyUp(i, keyEvent);
                    }
                    break;
            }
            if (this.mEditor == null || this.mEditor.mKeyListener == null || !this.mEditor.mKeyListener.onKeyUp(this, (Editable) this.mText, i, keyEvent)) {
                if (this.mMovement == null || this.mLayout == null || !this.mMovement.onKeyUp(this, (Spannable) this.mText, i, keyEvent)) {
                    return super.onKeyUp(i, keyEvent);
                }
                return true;
            }
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mDeferScroll >= 0) {
            int i5 = this.mDeferScroll;
            this.mDeferScroll = -1;
            bringPointIntoView(Math.min(i5, this.mText.length()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLocaleChanged() {
        this.mEditor.mWordIterator = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        BoringLayout.Metrics metrics;
        int i5;
        int i6;
        int i7;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        BoringLayout.Metrics metrics2 = UNKNOWN_BORING;
        BoringLayout.Metrics metrics3 = UNKNOWN_BORING;
        if (this.mTextDir == null) {
            this.mTextDir = getTextDirectionHeuristic();
        }
        int i8 = -1;
        boolean z2 = false;
        if (mode == 1073741824) {
            i5 = size;
            metrics = metrics2;
        } else {
            int i9 = -1;
            if (this.mLayout != null) {
                i9 = -1;
                if (this.mEllipsize == null) {
                    i9 = desired(this.mLayout);
                }
            }
            if (i9 < 0) {
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mTextDir, this.mBoring);
                metrics2 = isBoring;
                z = false;
                if (isBoring != null) {
                    this.mBoring = isBoring;
                    z = false;
                    metrics2 = isBoring;
                }
            } else {
                z = true;
            }
            if (metrics2 == null || metrics2 == UNKNOWN_BORING) {
                i3 = i9;
                if (i9 < 0) {
                    i3 = (int) FloatMath.ceil(Layout.getDesiredWidth(this.mTransformed, this.mTextPaint));
                }
                i4 = i3;
            } else {
                i4 = metrics2.width;
                i3 = i9;
            }
            Drawables drawables = this.mDrawables;
            int i10 = i4;
            if (drawables != null) {
                i10 = Math.max(Math.max(i4, drawables.mDrawableWidthTop), drawables.mDrawableWidthBottom);
            }
            BoringLayout.Metrics metrics4 = metrics3;
            int i11 = i10;
            if (this.mHint != null) {
                int i12 = -1;
                if (this.mHintLayout != null) {
                    i12 = -1;
                    if (this.mEllipsize == null) {
                        i12 = desired(this.mHintLayout);
                    }
                }
                if (i12 < 0) {
                    BoringLayout.Metrics isBoring2 = BoringLayout.isBoring(this.mHint, this.mTextPaint, this.mTextDir, this.mHintBoring);
                    metrics3 = isBoring2;
                    if (isBoring2 != null) {
                        this.mHintBoring = isBoring2;
                        metrics3 = isBoring2;
                    }
                }
                if (metrics3 == null || metrics3 == UNKNOWN_BORING) {
                    int i13 = i12;
                    if (i12 < 0) {
                        i13 = (int) FloatMath.ceil(Layout.getDesiredWidth(this.mHint, this.mTextPaint));
                    }
                    i6 = i13;
                } else {
                    i6 = metrics3.width;
                }
                metrics4 = metrics3;
                i11 = i10;
                if (i6 > i10) {
                    i11 = i6;
                    metrics4 = metrics3;
                }
            }
            int compoundPaddingLeft = i11 + getCompoundPaddingLeft() + getCompoundPaddingRight();
            int min = this.mMaxWidthMode == 1 ? Math.min(compoundPaddingLeft, this.mMaxWidth * getLineHeight()) : Math.min(compoundPaddingLeft, this.mMaxWidth);
            int max = Math.max(this.mMinWidthMode == 1 ? Math.max(min, this.mMinWidth * getLineHeight()) : Math.max(min, this.mMinWidth), getSuggestedMinimumWidth());
            metrics = metrics2;
            metrics3 = metrics4;
            i8 = i3;
            z2 = z;
            i5 = max;
            if (mode == Integer.MIN_VALUE) {
                i5 = Math.min(size, max);
                metrics = metrics2;
                metrics3 = metrics4;
                i8 = i3;
                z2 = z;
            }
        }
        int compoundPaddingLeft2 = (i5 - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        int i14 = compoundPaddingLeft2;
        if (this.mHorizontallyScrolling) {
            i14 = 1048576;
        }
        int width = this.mHintLayout == null ? i14 : this.mHintLayout.getWidth();
        if (this.mLayout == null) {
            makeNewLayout(i14, i14, metrics, metrics3, (i5 - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
        } else {
            boolean z3 = (this.mLayout.getWidth() == i14 && width == i14 && this.mLayout.getEllipsizedWidth() == (i5 - getCompoundPaddingLeft()) - getCompoundPaddingRight()) ? false : true;
            boolean z4 = this.mHint == null && this.mEllipsize == null && i14 > this.mLayout.getWidth() && ((this.mLayout instanceof BoringLayout) || (z2 && i8 >= 0 && i8 <= i14));
            boolean z5 = (this.mMaxMode == this.mOldMaxMode && this.mMaximum == this.mOldMaximum) ? false : true;
            if (z3 || z5) {
                if (z5 || !z4) {
                    makeNewLayout(i14, i14, metrics, metrics3, (i5 - getCompoundPaddingLeft()) - getCompoundPaddingRight(), false);
                } else {
                    this.mLayout.increaseWidthTo(i14);
                }
            }
        }
        if (mode2 == 1073741824) {
            i7 = size2;
            this.mDesiredHeightAtMeasure = -1;
        } else {
            int desiredHeight = getDesiredHeight();
            i7 = desiredHeight;
            this.mDesiredHeightAtMeasure = desiredHeight;
            if (mode2 == Integer.MIN_VALUE) {
                i7 = Math.min(desiredHeight, size2);
            }
        }
        int compoundPaddingTop = (i7 - getCompoundPaddingTop()) - getCompoundPaddingBottom();
        int i15 = compoundPaddingTop;
        if (this.mMaxMode == 1) {
            i15 = compoundPaddingTop;
            if (this.mLayout.getLineCount() > this.mMaximum) {
                i15 = Math.min(compoundPaddingTop, this.mLayout.getLineTop(this.mMaximum));
            }
        }
        if (this.mMovement != null || this.mLayout.getWidth() > compoundPaddingLeft2 || this.mLayout.getHeight() > i15) {
            registerForPreDraw();
        } else {
            scrollTo(0, 0);
        }
        setMeasuredDimension(i5, i7);
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!hasPasswordTransformationMethod() || shouldSpeakPasswordsForAccessibility()) {
            CharSequence textForAccessibility = getTextForAccessibility();
            if (TextUtils.isEmpty(textForAccessibility)) {
                return;
            }
            accessibilityEvent.getText().add(textForAccessibility);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.mLayout == null) {
            assumeLayout();
        }
        if (this.mMovement != null) {
            int selectionEnd = getSelectionEnd();
            int i = selectionEnd;
            if (this.mEditor != null) {
                i = selectionEnd;
                if (this.mEditor.mSelectionModifierCursorController != null) {
                    i = selectionEnd;
                    if (this.mEditor.mSelectionModifierCursorController.isSelectionStartDragged()) {
                        i = getSelectionStart();
                    }
                }
            }
            int i2 = i;
            if (i < 0) {
                i2 = i;
                if ((this.mGravity & 112) == 80) {
                    i2 = this.mText.length();
                }
            }
            if (i2 >= 0) {
                bringPointIntoView(i2);
            }
        } else {
            bringTextIntoView();
        }
        if (this.mEditor != null && this.mEditor.mCreatedWithASelection) {
            this.mEditor.startSelectionActionMode();
            this.mEditor.mCreatedWithASelection = false;
        }
        if ((this instanceof ExtractEditText) && hasSelection() && this.mEditor != null) {
            this.mEditor.startSelectionActionMode();
        }
        unregisterForPreDraw();
        return true;
    }

    public boolean onPrivateIMECommand(String str, Bundle bundle) {
        return false;
    }

    @Override // android.view.View
    public void onResolveDrawables(int i) {
        if (this.mLastLayoutDirection == i) {
            return;
        }
        this.mLastLayoutDirection = i;
        if (this.mDrawables != null) {
            this.mDrawables.resolveWithLayoutDirection(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.text != null) {
            setText(savedState.text);
        }
        if (savedState.selStart >= 0 && savedState.selEnd >= 0 && (this.mText instanceof Spannable)) {
            int length = this.mText.length();
            if (savedState.selStart > length || savedState.selEnd > length) {
                Log.e(LOG_TAG, "Saved cursor position " + savedState.selStart + BridgeUtil.SPLIT_MARK + savedState.selEnd + " out of range for " + (savedState.text != null ? "(restored) " : "") + "text " + ((Object) this.mText));
            } else {
                Selection.setSelection((Spannable) this.mText, savedState.selStart, savedState.selEnd);
                if (savedState.frozenWithFocus) {
                    createEditorIfNeeded();
                    this.mEditor.mFrozenWithFocus = true;
                }
            }
        }
        if (savedState.error != null) {
            final CharSequence charSequence = savedState.error;
            post(new Runnable() { // from class: android.widget.TextView.1
                @Override // java.lang.Runnable
                public void run() {
                    TextView.this.setError(charSequence);
                }
            });
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        this.mTextDir = getTextDirectionHeuristic();
        if (this.mLayout != null) {
            checkForRelayout();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r0 >= 0) goto L7;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Parcelable onSaveInstanceState() {
        /*
            r4 = this;
            r0 = r4
            android.os.Parcelable r0 = super.onSaveInstanceState()
            r11 = r0
            r0 = r4
            boolean r0 = r0.mFreezesText
            r10 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r10
            r9 = r0
            r0 = r4
            java.lang.CharSequence r0 = r0.mText
            if (r0 == 0) goto L40
            r0 = r4
            int r0 = r0.getSelectionStart()
            r7 = r0
            r0 = r4
            int r0 = r0.getSelectionEnd()
            r8 = r0
            r0 = r7
            if (r0 >= 0) goto L38
            r0 = r8
            r5 = r0
            r0 = r10
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 < 0) goto L40
        L38:
            r0 = 1
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            r5 = r0
        L40:
            r0 = r9
            if (r0 == 0) goto Lc7
            android.widget.TextView$SavedState r0 = new android.widget.TextView$SavedState
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            r11 = r0
            r0 = r11
            r1 = r6
            r0.selStart = r1
            r0 = r11
            r1 = r5
            r0.selEnd = r1
            r0 = r4
            java.lang.CharSequence r0 = r0.mText
            boolean r0 = r0 instanceof android.text.Spanned
            if (r0 == 0) goto Lb6
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r1 = r0
            r2 = r4
            java.lang.CharSequence r2 = r2.mText
            r1.<init>(r2)
            r12 = r0
            r0 = r4
            android.widget.Editor r0 = r0.mEditor
            if (r0 == 0) goto L8e
            r0 = r4
            r1 = r12
            r0.removeMisspelledSpans(r1)
            r0 = r12
            r1 = r4
            android.widget.Editor r1 = r1.mEditor
            android.text.style.SuggestionRangeSpan r1 = r1.mSuggestionRangeSpan
            r0.removeSpan(r1)
        L8e:
            r0 = r11
            r1 = r12
            r0.text = r1
        L95:
            r0 = r4
            boolean r0 = r0.isFocused()
            if (r0 == 0) goto Laa
            r0 = r6
            if (r0 < 0) goto Laa
            r0 = r5
            if (r0 < 0) goto Laa
            r0 = r11
            r1 = 1
            r0.frozenWithFocus = r1
        Laa:
            r0 = r11
            r1 = r4
            java.lang.CharSequence r1 = r1.getError()
            r0.error = r1
            r0 = r11
            return r0
        Lb6:
            r0 = r11
            r1 = r4
            java.lang.CharSequence r1 = r1.mText
            java.lang.String r1 = r1.toString()
            r0.text = r1
            goto L95
        Lc7:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.onSaveInstanceState():android.os.Parcelable");
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.mEditor != null) {
            this.mEditor.onScreenStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mEditor != null) {
            this.mEditor.onScrollChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        sendAccessibilityEvent(8192);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (!this.mDispatchTemporaryDetach) {
            this.mTemporaryDetach = true;
        }
        if (this.mEditor != null) {
            this.mEditor.mTemporaryDetach = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean onTextContextMenuItem(int i) {
        int i2 = 0;
        int length = this.mText.length();
        if (isFocused()) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            i2 = Math.max(0, Math.min(selectionStart, selectionEnd));
            length = Math.max(0, Math.max(selectionStart, selectionEnd));
        }
        switch (i) {
            case 16908319:
                selectAllText();
                return true;
            case 16908320:
                setPrimaryClip(ClipData.newPlainText(null, getTransformedText(i2, length)));
                deleteText_internal(i2, length);
                stopSelectionActionMode();
                return true;
            case 16908321:
                setPrimaryClip(ClipData.newPlainText(null, getTransformedText(i2, length)));
                stopSelectionActionMode();
                return true;
            case 16908322:
                paste(i2, length);
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0109, code lost:
        if (r0 != false) goto L53;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.mMovement == null || !(this.mText instanceof Spannable) || this.mLayout == null || !this.mMovement.onTrackballEvent(this, (Spannable) this.mText, motionEvent)) {
            return super.onTrackballEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mEditor == null || i == 0) {
            return;
        }
        this.mEditor.hideControllers();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mEditor != null) {
            this.mEditor.onWindowFocusChanged(z);
        }
        startStopMarquee(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008e, code lost:
        if (onCheckIsTextEditor() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c4, code lost:
        if (isTextSelectable() != false) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityActionInternal(int r6, android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.performAccessibilityActionInternal(int, android.os.Bundle):boolean");
    }

    @Override // android.view.View
    public boolean performLongClick() {
        boolean z = false;
        if (super.performLongClick()) {
            z = true;
        }
        boolean z2 = z;
        if (this.mEditor != null) {
            z2 = z | this.mEditor.performLongClick(z);
        }
        if (z2) {
            performHapticFeedback(0);
            if (this.mEditor != null) {
                this.mEditor.mDiscardNextActionUp = true;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAdjacentSuggestionSpans(int i) {
        if (!(this.mText instanceof Editable)) {
            return;
        }
        Editable editable = (Editable) this.mText;
        SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) editable.getSpans(i, i, SuggestionSpan.class);
        int length = suggestionSpanArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            int spanStart = editable.getSpanStart(suggestionSpanArr[i3]);
            int spanEnd = editable.getSpanEnd(suggestionSpanArr[i3]);
            if ((spanEnd == i || spanStart == i) && SpellChecker.haveWordBoundariesChanged(editable, i, i, spanStart, spanEnd)) {
                editable.removeSpan(suggestionSpanArr[i3]);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMisspelledSpans(Spannable spannable) {
        Object[] objArr = (SuggestionSpan[]) spannable.getSpans(0, spannable.length(), SuggestionSpan.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            int flags = objArr[i2].getFlags();
            if ((flags & 1) != 0 && (flags & 2) != 0) {
                spannable.removeSpan(objArr[i2]);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.text.Spannable] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.text.Spannable] */
    CharSequence removeSuggestionSpans(CharSequence charSequence) {
        Spannable spannable;
        CharSequence charSequence2 = charSequence;
        if (charSequence instanceof Spanned) {
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                SpannableString spannableString = new SpannableString(charSequence);
                charSequence = spannableString;
                spannable = spannableString;
            }
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, charSequence.length(), SuggestionSpan.class);
            int i = 0;
            while (true) {
                int i2 = i;
                charSequence2 = charSequence;
                if (i2 >= suggestionSpanArr.length) {
                    break;
                }
                spannable.removeSpan(suggestionSpanArr[i2]);
                i = i2 + 1;
            }
        }
        return charSequence2;
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        int indexOf;
        if (this.mListeners == null || (indexOf = this.mListeners.indexOf(textWatcher)) < 0) {
            return;
        }
        this.mListeners.remove(indexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void replaceText_internal(int i, int i2, CharSequence charSequence) {
        ((Editable) this.mText).replace(i, i2, charSequence);
    }

    public void resetErrorChangedFlag() {
        if (this.mEditor != null) {
            this.mEditor.mErrorWasChanged = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void resetResolvedDrawables() {
        super.resetResolvedDrawables();
        this.mLastLayoutDirection = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean selectAllText() {
        int length = this.mText.length();
        Selection.setSelection((Spannable) this.mText, 0, length);
        return length > 0;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            return;
        }
        super.sendAccessibilityEvent(i);
    }

    void sendAccessibilityEventTypeViewTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16);
        obtain.setFromIndex(i);
        obtain.setRemovedCount(i2);
        obtain.setAddedCount(i3);
        obtain.setBeforeText(charSequence);
        sendAccessibilityEventUnchecked(obtain);
    }

    void sendAfterTextChanged(Editable editable) {
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                arrayList.get(i2).afterTextChanged(editable);
                i = i2 + 1;
            }
        }
        hideErrorIfUnchanged();
    }

    void sendOnTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mListeners != null) {
            ArrayList<TextWatcher> arrayList = this.mListeners;
            int size = arrayList.size();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= size) {
                    break;
                }
                arrayList.get(i5).onTextChanged(charSequence, i, i2, i3);
                i4 = i5 + 1;
            }
        }
        if (this.mEditor != null) {
            this.mEditor.sendOnTextChanged(i, i3);
        }
    }

    @Override // android.view.View
    public void setAccessibilitySelection(int i, int i2) {
        if (getAccessibilitySelectionStart() == i && getAccessibilitySelectionEnd() == i2) {
            return;
        }
        if (this.mEditor != null) {
            this.mEditor.hideControllers();
        }
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
        if (Math.min(i, i2) < 0 || Math.max(i, i2) > iterableTextForAccessibility.length()) {
            Selection.removeSelection((Spannable) iterableTextForAccessibility);
        } else {
            Selection.setSelection((Spannable) iterableTextForAccessibility, i, i2);
        }
    }

    public void setAllCaps(boolean z) {
        if (z) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } else {
            setTransformationMethod(null);
        }
    }

    @RemotableViewMethod
    public final void setAutoLinkMask(int i) {
        this.mAutoLinkMask = i;
    }

    @RemotableViewMethod
    public void setCompoundDrawablePadding(int i) {
        Drawables drawables = this.mDrawables;
        if (i != 0) {
            Drawables drawables2 = drawables;
            if (drawables == null) {
                drawables2 = new Drawables(getContext());
                this.mDrawables = drawables2;
            }
            drawables2.mDrawablePadding = i;
        } else if (drawables != null) {
            drawables.mDrawablePadding = i;
        }
        invalidate();
        requestLayout();
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawables drawables;
        Drawables drawables2 = this.mDrawables;
        if (drawables2 != null) {
            if (drawables2.mDrawableStart != null) {
                drawables2.mDrawableStart.setCallback(null);
            }
            drawables2.mDrawableStart = null;
            if (drawables2.mDrawableEnd != null) {
                drawables2.mDrawableEnd.setCallback(null);
            }
            drawables2.mDrawableEnd = null;
            drawables2.mDrawableHeightStart = 0;
            drawables2.mDrawableSizeStart = 0;
            drawables2.mDrawableHeightEnd = 0;
            drawables2.mDrawableSizeEnd = 0;
        }
        if ((drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) ? false : true) {
            drawables = drawables2;
            if (drawables2 == null) {
                drawables = new Drawables(getContext());
                this.mDrawables = drawables;
            }
            this.mDrawables.mOverride = false;
            if (drawables.mDrawableLeft != drawable && drawables.mDrawableLeft != null) {
                drawables.mDrawableLeft.setCallback(null);
            }
            drawables.mDrawableLeft = drawable;
            if (drawables.mDrawableTop != drawable2 && drawables.mDrawableTop != null) {
                drawables.mDrawableTop.setCallback(null);
            }
            drawables.mDrawableTop = drawable2;
            if (drawables.mDrawableRight != drawable3 && drawables.mDrawableRight != null) {
                drawables.mDrawableRight.setCallback(null);
            }
            drawables.mDrawableRight = drawable3;
            if (drawables.mDrawableBottom != drawable4 && drawables.mDrawableBottom != null) {
                drawables.mDrawableBottom.setCallback(null);
            }
            drawables.mDrawableBottom = drawable4;
            Rect rect = drawables.mCompoundRect;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables.mDrawableSizeLeft = rect.width();
                drawables.mDrawableHeightLeft = rect.height();
            } else {
                drawables.mDrawableHeightLeft = 0;
                drawables.mDrawableSizeLeft = 0;
            }
            if (drawable3 != null) {
                drawable3.setState(drawableState);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                drawables.mDrawableSizeRight = rect.width();
                drawables.mDrawableHeightRight = rect.height();
            } else {
                drawables.mDrawableHeightRight = 0;
                drawables.mDrawableSizeRight = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                drawables.mDrawableSizeTop = rect.height();
                drawables.mDrawableWidthTop = rect.width();
            } else {
                drawables.mDrawableWidthTop = 0;
                drawables.mDrawableSizeTop = 0;
            }
            if (drawable4 != null) {
                drawable4.setState(drawableState);
                drawable4.copyBounds(rect);
                drawable4.setCallback(this);
                drawables.mDrawableSizeBottom = rect.height();
                drawables.mDrawableWidthBottom = rect.width();
            } else {
                drawables.mDrawableWidthBottom = 0;
                drawables.mDrawableSizeBottom = 0;
            }
        } else {
            drawables = drawables2;
            if (drawables2 != null) {
                if (drawables2.mDrawablePadding == 0) {
                    this.mDrawables = null;
                    drawables = drawables2;
                } else {
                    if (drawables2.mDrawableLeft != null) {
                        drawables2.mDrawableLeft.setCallback(null);
                    }
                    drawables2.mDrawableLeft = null;
                    if (drawables2.mDrawableTop != null) {
                        drawables2.mDrawableTop.setCallback(null);
                    }
                    drawables2.mDrawableTop = null;
                    if (drawables2.mDrawableRight != null) {
                        drawables2.mDrawableRight.setCallback(null);
                    }
                    drawables2.mDrawableRight = null;
                    if (drawables2.mDrawableBottom != null) {
                        drawables2.mDrawableBottom.setCallback(null);
                    }
                    drawables2.mDrawableBottom = null;
                    drawables2.mDrawableHeightLeft = 0;
                    drawables2.mDrawableSizeLeft = 0;
                    drawables2.mDrawableHeightRight = 0;
                    drawables2.mDrawableSizeRight = 0;
                    drawables2.mDrawableWidthTop = 0;
                    drawables2.mDrawableSizeTop = 0;
                    drawables2.mDrawableWidthBottom = 0;
                    drawables2.mDrawableSizeBottom = 0;
                    drawables = drawables2;
                }
            }
        }
        if (drawables != null) {
            drawables.mDrawableLeftInitial = drawable;
            drawables.mDrawableRightInitial = drawable3;
        }
        resetResolvedDrawables();
        resolveDrawables();
        invalidate();
        requestLayout();
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Drawables drawables = this.mDrawables;
        if (drawables != null) {
            if (drawables.mDrawableLeft != null) {
                drawables.mDrawableLeft.setCallback(null);
            }
            drawables.mDrawableLeftInitial = null;
            drawables.mDrawableLeft = null;
            if (drawables.mDrawableRight != null) {
                drawables.mDrawableRight.setCallback(null);
            }
            drawables.mDrawableRightInitial = null;
            drawables.mDrawableRight = null;
            drawables.mDrawableHeightLeft = 0;
            drawables.mDrawableSizeLeft = 0;
            drawables.mDrawableHeightRight = 0;
            drawables.mDrawableSizeRight = 0;
        }
        if ((drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) ? false : true) {
            Drawables drawables2 = drawables;
            if (drawables == null) {
                drawables2 = new Drawables(getContext());
                this.mDrawables = drawables2;
            }
            this.mDrawables.mOverride = true;
            if (drawables2.mDrawableStart != drawable && drawables2.mDrawableStart != null) {
                drawables2.mDrawableStart.setCallback(null);
            }
            drawables2.mDrawableStart = drawable;
            if (drawables2.mDrawableTop != drawable2 && drawables2.mDrawableTop != null) {
                drawables2.mDrawableTop.setCallback(null);
            }
            drawables2.mDrawableTop = drawable2;
            if (drawables2.mDrawableEnd != drawable3 && drawables2.mDrawableEnd != null) {
                drawables2.mDrawableEnd.setCallback(null);
            }
            drawables2.mDrawableEnd = drawable3;
            if (drawables2.mDrawableBottom != drawable4 && drawables2.mDrawableBottom != null) {
                drawables2.mDrawableBottom.setCallback(null);
            }
            drawables2.mDrawableBottom = drawable4;
            Rect rect = drawables2.mCompoundRect;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables2.mDrawableSizeStart = rect.width();
                drawables2.mDrawableHeightStart = rect.height();
            } else {
                drawables2.mDrawableHeightStart = 0;
                drawables2.mDrawableSizeStart = 0;
            }
            if (drawable3 != null) {
                drawable3.setState(drawableState);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                drawables2.mDrawableSizeEnd = rect.width();
                drawables2.mDrawableHeightEnd = rect.height();
            } else {
                drawables2.mDrawableHeightEnd = 0;
                drawables2.mDrawableSizeEnd = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                drawables2.mDrawableSizeTop = rect.height();
                drawables2.mDrawableWidthTop = rect.width();
            } else {
                drawables2.mDrawableWidthTop = 0;
                drawables2.mDrawableSizeTop = 0;
            }
            if (drawable4 != null) {
                drawable4.setState(drawableState);
                drawable4.copyBounds(rect);
                drawable4.setCallback(this);
                drawables2.mDrawableSizeBottom = rect.height();
                drawables2.mDrawableWidthBottom = rect.width();
            } else {
                drawables2.mDrawableWidthBottom = 0;
                drawables2.mDrawableSizeBottom = 0;
            }
        } else if (drawables != null) {
            if (drawables.mDrawablePadding == 0) {
                this.mDrawables = null;
            } else {
                if (drawables.mDrawableStart != null) {
                    drawables.mDrawableStart.setCallback(null);
                }
                drawables.mDrawableStart = null;
                if (drawables.mDrawableTop != null) {
                    drawables.mDrawableTop.setCallback(null);
                }
                drawables.mDrawableTop = null;
                if (drawables.mDrawableEnd != null) {
                    drawables.mDrawableEnd.setCallback(null);
                }
                drawables.mDrawableEnd = null;
                if (drawables.mDrawableBottom != null) {
                    drawables.mDrawableBottom.setCallback(null);
                }
                drawables.mDrawableBottom = null;
                drawables.mDrawableHeightStart = 0;
                drawables.mDrawableSizeStart = 0;
                drawables.mDrawableHeightEnd = 0;
                drawables.mDrawableSizeEnd = 0;
                drawables.mDrawableWidthTop = 0;
                drawables.mDrawableSizeTop = 0;
                drawables.mDrawableWidthBottom = 0;
                drawables.mDrawableSizeBottom = 0;
            }
        }
        resetResolvedDrawables();
        resolveDrawables();
        invalidate();
        requestLayout();
    }

    @RemotableViewMethod
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = null;
        Context context = getContext();
        Drawable drawable2 = i != 0 ? context.getDrawable(i) : null;
        Drawable drawable3 = i2 != 0 ? context.getDrawable(i2) : null;
        Drawable drawable4 = i3 != 0 ? context.getDrawable(i3) : null;
        if (i4 != 0) {
            drawable = context.getDrawable(i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        }
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @RemotableViewMethod
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Drawable drawable = null;
        Context context = getContext();
        Drawable drawable2 = i != 0 ? context.getDrawable(i) : null;
        Drawable drawable3 = i2 != 0 ? context.getDrawable(i2) : null;
        Drawable drawable4 = i3 != 0 ? context.getDrawable(i3) : null;
        if (i4 != 0) {
            drawable = context.getDrawable(i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCursorPosition_internal(int i, int i2) {
        Selection.setSelection((Editable) this.mText, i, i2);
    }

    @RemotableViewMethod
    public void setCursorVisible(boolean z) {
        if (z && this.mEditor == null) {
            return;
        }
        createEditorIfNeeded();
        if (this.mEditor.mCursorVisible != z) {
            this.mEditor.mCursorVisible = z;
            invalidate();
            this.mEditor.makeBlink();
            this.mEditor.prepareCursorControllers();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        createEditorIfNeeded();
        this.mEditor.mCustomSelectionActionModeCallback = callback;
    }

    public final void setEditableFactory(Editable.Factory factory) {
        this.mEditableFactory = factory;
        setText(this.mText);
    }

    public void setElegantTextHeight(boolean z) {
        this.mTextPaint.setElegantTextHeight(z);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.mEllipsize != truncateAt) {
            this.mEllipsize = truncateAt;
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    @RemotableViewMethod
    public void setEms(int i) {
        this.mMinWidth = i;
        this.mMaxWidth = i;
        this.mMinWidthMode = 1;
        this.mMaxWidthMode = 1;
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        InputMethodManager peekInstance;
        InputMethodManager peekInstance2;
        if (z == isEnabled()) {
            return;
        }
        if (!z && (peekInstance2 = InputMethodManager.peekInstance()) != null && peekInstance2.isActive(this)) {
            peekInstance2.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.setEnabled(z);
        if (z && (peekInstance = InputMethodManager.peekInstance()) != null) {
            peekInstance.restartInput(this);
        }
        if (this.mEditor != null) {
            this.mEditor.invalidateTextDisplayList();
            this.mEditor.prepareCursorControllers();
            this.mEditor.makeBlink();
        }
    }

    @RemotableViewMethod
    public void setError(CharSequence charSequence) {
        if (charSequence == null) {
            setError(null, null);
            return;
        }
        Drawable drawable = getContext().getDrawable(R.drawable.indicator_input_error);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        setError(charSequence, drawable);
    }

    public void setError(CharSequence charSequence, Drawable drawable) {
        createEditorIfNeeded();
        this.mEditor.setError(charSequence, drawable);
        notifyViewAccessibilityStateChangedIfNeeded(0);
    }

    public void setExtractedText(ExtractedText extractedText) {
        int i;
        int i2;
        Editable editableText = getEditableText();
        if (extractedText.text != null) {
            if (editableText == null) {
                setText(extractedText.text, BufferType.EDITABLE);
            } else if (extractedText.partialStartOffset < 0) {
                removeParcelableSpans(editableText, 0, editableText.length());
                editableText.replace(0, editableText.length(), extractedText.text);
            } else {
                int length = editableText.length();
                int i3 = extractedText.partialStartOffset;
                int i4 = i3;
                if (i3 > length) {
                    i4 = length;
                }
                int i5 = extractedText.partialEndOffset;
                int i6 = i5;
                if (i5 > length) {
                    i6 = length;
                }
                removeParcelableSpans(editableText, i4, i6);
                editableText.replace(i4, i6, extractedText.text);
            }
        }
        Spannable spannable = (Spannable) getText();
        int length2 = spannable.length();
        int i7 = extractedText.selectionStart;
        if (i7 < 0) {
            i = 0;
        } else {
            i = i7;
            if (i7 > length2) {
                i = length2;
            }
        }
        int i8 = extractedText.selectionEnd;
        if (i8 < 0) {
            i2 = 0;
        } else {
            i2 = i8;
            if (i8 > length2) {
                i2 = length2;
            }
        }
        Selection.setSelection(spannable, i, i2);
        if ((extractedText.flags & 2) != 0) {
            MetaKeyKeyListener.startSelecting(this, spannable);
        } else {
            MetaKeyKeyListener.stopSelecting(this, spannable);
        }
    }

    public void setExtracting(ExtractedTextRequest extractedTextRequest) {
        if (this.mEditor.mInputMethodState != null) {
            this.mEditor.mInputMethodState.mExtractedTextRequest = extractedTextRequest;
        }
        this.mEditor.hideControllers();
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        if (inputFilterArr == null) {
            throw new IllegalArgumentException();
        }
        this.mFilters = inputFilterArr;
        if (this.mText instanceof Editable) {
            setFilters((Editable) this.mText, inputFilterArr);
        }
    }

    @RemotableViewMethod
    public void setFontFeatureSettings(String str) {
        if (str != this.mTextPaint.getFontFeatureSettings()) {
            this.mTextPaint.setFontFeatureSettings(str);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (this.mEditor != null) {
            this.mEditor.setFrame();
        }
        restartMarqueeIfNeeded();
        return frame;
    }

    @RemotableViewMethod
    public void setFreezesText(boolean z) {
        this.mFreezesText = z;
    }

    public void setGravity(int i) {
        int i2 = i;
        if ((i & 8388615) == 0) {
            i2 = i | 8388611;
        }
        int i3 = i2;
        if ((i2 & 112) == 0) {
            i3 = i2 | 48;
        }
        boolean z = false;
        if ((i3 & 8388615) != (this.mGravity & 8388615)) {
            z = true;
        }
        if (i3 != this.mGravity) {
            invalidate();
        }
        this.mGravity = i3;
        if (this.mLayout == null || !z) {
            return;
        }
        makeNewLayout(this.mLayout.getWidth(), this.mHintLayout == null ? 0 : this.mHintLayout.getWidth(), UNKNOWN_BORING, UNKNOWN_BORING, ((this.mRight - this.mLeft) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), true);
    }

    @RemotableViewMethod
    public void setHeight(int i) {
        this.mMinimum = i;
        this.mMaximum = i;
        this.mMinMode = 2;
        this.mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setHighlightColor(int i) {
        if (this.mHighlightColor != i) {
            this.mHighlightColor = i;
            invalidate();
        }
    }

    @RemotableViewMethod
    public final void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    @RemotableViewMethod
    public final void setHint(CharSequence charSequence) {
        this.mHint = TextUtils.stringOrSpannedString(charSequence);
        if (this.mLayout != null) {
            checkForRelayout();
        }
        if (this.mText.length() == 0) {
            invalidate();
        }
        if (this.mEditor == null || this.mText.length() != 0 || this.mHint == null) {
            return;
        }
        this.mEditor.invalidateTextDisplayList();
    }

    @RemotableViewMethod
    public final void setHintTextColor(int i) {
        this.mHintTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setHintTextColor(ColorStateList colorStateList) {
        this.mHintTextColor = colorStateList;
        updateTextColors();
    }

    public void setHorizontallyScrolling(boolean z) {
        if (this.mHorizontallyScrolling != z) {
            this.mHorizontallyScrolling = z;
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setImeActionLabel(CharSequence charSequence, int i) {
        createEditorIfNeeded();
        this.mEditor.createInputContentTypeIfNeeded();
        this.mEditor.mInputContentType.imeActionLabel = charSequence;
        this.mEditor.mInputContentType.imeActionId = i;
    }

    public void setImeOptions(int i) {
        createEditorIfNeeded();
        this.mEditor.createInputContentTypeIfNeeded();
        this.mEditor.mInputContentType.imeOptions = i;
    }

    public void setIncludeFontPadding(boolean z) {
        if (this.mIncludePad != z) {
            this.mIncludePad = z;
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setInputExtras(int i) throws XmlPullParserException, IOException {
        createEditorIfNeeded();
        XmlResourceParser xml = getResources().getXml(i);
        this.mEditor.createInputContentTypeIfNeeded();
        this.mEditor.mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(xml, this.mEditor.mInputContentType.extras);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r0 != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setInputType(int r6) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.setInputType(int):void");
    }

    public void setKeyListener(KeyListener keyListener) {
        setKeyListenerOnly(keyListener);
        fixFocusableAndClickableSettings();
        if (keyListener != null) {
            createEditorIfNeeded();
            try {
                this.mEditor.mInputType = this.mEditor.mKeyListener.getInputType();
            } catch (IncompatibleClassChangeError e) {
                this.mEditor.mInputType = 1;
            }
            setInputTypeSingleLine(this.mSingleLine);
        } else if (this.mEditor != null) {
            this.mEditor.mInputType = 0;
        }
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (peekInstance != null) {
            peekInstance.restartInput(this);
        }
    }

    @RemotableViewMethod
    public void setLetterSpacing(float f) {
        if (f != this.mTextPaint.getLetterSpacing()) {
            this.mTextPaint.setLetterSpacing(f);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setLineSpacing(float f, float f2) {
        if (this.mSpacingAdd == f && this.mSpacingMult == f2) {
            return;
        }
        this.mSpacingAdd = f;
        this.mSpacingMult = f2;
        if (this.mLayout != null) {
            nullLayouts();
            requestLayout();
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setLines(int i) {
        this.mMinimum = i;
        this.mMaximum = i;
        this.mMinMode = 1;
        this.mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public final void setLinkTextColor(int i) {
        this.mLinkTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setLinkTextColor(ColorStateList colorStateList) {
        this.mLinkTextColor = colorStateList;
        updateTextColors();
    }

    @RemotableViewMethod
    public final void setLinksClickable(boolean z) {
        this.mLinksClickable = z;
    }

    public void setMarqueeRepeatLimit(int i) {
        this.mMarqueeRepeatLimit = i;
    }

    @RemotableViewMethod
    public void setMaxEms(int i) {
        this.mMaxWidth = i;
        this.mMaxWidthMode = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxHeight(int i) {
        this.mMaximum = i;
        this.mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxLines(int i) {
        this.mMaximum = i;
        this.mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        this.mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinEms(int i) {
        this.mMinWidth = i;
        this.mMinWidthMode = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinHeight(int i) {
        this.mMinimum = i;
        this.mMinMode = 2;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinLines(int i) {
        this.mMinimum = i;
        this.mMinMode = 1;
        requestLayout();
        invalidate();
    }

    @RemotableViewMethod
    public void setMinWidth(int i) {
        this.mMinWidth = i;
        this.mMinWidthMode = 2;
        requestLayout();
        invalidate();
    }

    public final void setMovementMethod(MovementMethod movementMethod) {
        if (this.mMovement != movementMethod) {
            this.mMovement = movementMethod;
            if (movementMethod != null && !(this.mText instanceof Spannable)) {
                setText(this.mText);
            }
            fixFocusableAndClickableSettings();
            if (this.mEditor != null) {
                this.mEditor.prepareCursorControllers();
            }
        }
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        createEditorIfNeeded();
        this.mEditor.createInputContentTypeIfNeeded();
        this.mEditor.mInputContentType.onEditorActionListener = onEditorActionListener;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (i != this.mPaddingLeft || i3 != this.mPaddingRight || i2 != this.mPaddingTop || i4 != this.mPaddingBottom) {
            nullLayouts();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        if (i != getPaddingStart() || i3 != getPaddingEnd() || i2 != this.mPaddingTop || i4 != this.mPaddingBottom) {
            nullLayouts();
        }
        super.setPaddingRelative(i, i2, i3, i4);
        invalidate();
    }

    @RemotableViewMethod
    public void setPaintFlags(int i) {
        if (this.mTextPaint.getFlags() != i) {
            this.mTextPaint.setFlags(i);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setPrivateImeOptions(String str) {
        createEditorIfNeeded();
        this.mEditor.createInputContentTypeIfNeeded();
        this.mEditor.mInputContentType.privateImeOptions = str;
    }

    public void setRawInputType(int i) {
        if (i == 0 && this.mEditor == null) {
            return;
        }
        createEditorIfNeeded();
        this.mEditor.mInputType = i;
    }

    public void setScroller(Scroller scroller) {
        this.mScroller = scroller;
    }

    @RemotableViewMethod
    public void setSelectAllOnFocus(boolean z) {
        createEditorIfNeeded();
        this.mEditor.mSelectAllOnFocus = z;
        if (!z || (this.mText instanceof Spannable)) {
            return;
        }
        setText(this.mText, BufferType.SPANNABLE);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        boolean isSelected = isSelected();
        super.setSelected(z);
        if (z == isSelected || this.mEllipsize != TextUtils.TruncateAt.MARQUEE) {
            return;
        }
        if (z) {
            startMarquee();
        } else {
            stopMarquee();
        }
    }

    public void setShadowLayer(float f, float f2, float f3, int i) {
        this.mTextPaint.setShadowLayer(f, f2, f3, i);
        this.mShadowRadius = f;
        this.mShadowDx = f2;
        this.mShadowDy = f3;
        this.mShadowColor = i;
        if (this.mEditor != null) {
            this.mEditor.invalidateTextDisplayList();
        }
        invalidate();
    }

    @RemotableViewMethod
    public final void setShowSoftInputOnFocus(boolean z) {
        createEditorIfNeeded();
        this.mEditor.mShowSoftInputOnFocus = z;
    }

    public void setSingleLine() {
        setSingleLine(true);
    }

    @RemotableViewMethod
    public void setSingleLine(boolean z) {
        setInputTypeSingleLine(z);
        applySingleLine(z, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSpan_internal(Object obj, int i, int i2, int i3) {
        ((Editable) this.mText).setSpan(obj, i, i2, i3);
    }

    public final void setSpannableFactory(Spannable.Factory factory) {
        this.mSpannableFactory = factory;
        setText(this.mText);
    }

    @RemotableViewMethod
    public final void setText(int i) {
        setText(getContext().getResources().getText(i));
    }

    public final void setText(int i, BufferType bufferType) {
        setText(getContext().getResources().getText(i), bufferType);
    }

    @RemotableViewMethod
    public final void setText(CharSequence charSequence) {
        setText(charSequence, this.mBufferType);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        setText(charSequence, bufferType, true, 0);
        if (this.mCharWrapper != null) {
            this.mCharWrapper.mChars = null;
        }
    }

    public final void setText(char[] cArr, int i, int i2) {
        int i3 = 0;
        if (i < 0 || i2 < 0 || i + i2 > cArr.length) {
            throw new IndexOutOfBoundsException(i + ", " + i2);
        }
        if (this.mText != null) {
            i3 = this.mText.length();
            sendBeforeTextChanged(this.mText, 0, i3, i2);
        } else {
            sendBeforeTextChanged("", 0, 0, i2);
        }
        if (this.mCharWrapper == null) {
            this.mCharWrapper = new CharWrapper(cArr, i, i2);
        } else {
            this.mCharWrapper.set(cArr, i, i2);
        }
        setText(this.mCharWrapper, this.mBufferType, false, i3);
    }

    public void setTextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        int color = obtainStyledAttributes.getColor(4, 0);
        if (color != 0) {
            setHighlightColor(color);
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        if (colorStateList != null) {
            setTextColor(colorStateList);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        if (dimensionPixelSize != 0) {
            setRawTextSize(dimensionPixelSize);
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(5);
        if (colorStateList2 != null) {
            setHintTextColor(colorStateList2);
        }
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(6);
        if (colorStateList3 != null) {
            setLinkTextColor(colorStateList3);
        }
        setTypefaceFromAttrs(obtainStyledAttributes.getString(12), obtainStyledAttributes.getInt(1, -1), obtainStyledAttributes.getInt(2, -1));
        int i2 = obtainStyledAttributes.getInt(7, 0);
        if (i2 != 0) {
            setShadowLayer(obtainStyledAttributes.getFloat(10, 0.0f), obtainStyledAttributes.getFloat(8, 0.0f), obtainStyledAttributes.getFloat(9, 0.0f), i2);
        }
        if (obtainStyledAttributes.getBoolean(11, false)) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        }
        if (obtainStyledAttributes.hasValue(13)) {
            setElegantTextHeight(obtainStyledAttributes.getBoolean(13, false));
        }
        if (obtainStyledAttributes.hasValue(14)) {
            setLetterSpacing(obtainStyledAttributes.getFloat(14, 0.0f));
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setFontFeatureSettings(obtainStyledAttributes.getString(15));
        }
        obtainStyledAttributes.recycle();
    }

    @RemotableViewMethod
    public void setTextColor(int i) {
        this.mTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        }
        this.mTextColor = colorStateList;
        updateTextColors();
    }

    public void setTextIsSelectable(boolean z) {
        if (z || this.mEditor != null) {
            createEditorIfNeeded();
            if (this.mEditor.mTextIsSelectable != z) {
                this.mEditor.mTextIsSelectable = z;
                setFocusableInTouchMode(z);
                setFocusable(z);
                setClickable(z);
                setLongClickable(z);
                setMovementMethod(z ? ArrowKeyMovementMethod.getInstance() : null);
                setText(this.mText, z ? BufferType.SPANNABLE : BufferType.NORMAL);
                this.mEditor.prepareCursorControllers();
            }
        }
    }

    @RemotableViewMethod
    public final void setTextKeepState(CharSequence charSequence) {
        setTextKeepState(charSequence, this.mBufferType);
    }

    public final void setTextKeepState(CharSequence charSequence, BufferType bufferType) {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = charSequence.length();
        setText(charSequence, bufferType);
        if ((selectionStart >= 0 || selectionEnd >= 0) && (this.mText instanceof Spannable)) {
            Selection.setSelection((Spannable) this.mText, Math.max(0, Math.min(selectionStart, length)), Math.max(0, Math.min(selectionEnd, length)));
        }
    }

    public void setTextLocale(Locale locale) {
        this.mTextPaint.setTextLocale(locale);
    }

    @RemotableViewMethod
    public void setTextScaleX(float f) {
        if (f != this.mTextPaint.getTextScaleX()) {
            this.mUserSetTextScaleX = true;
            this.mTextPaint.setTextScaleX(f);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    @RemotableViewMethod
    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        Context context = getContext();
        setRawTextSize(TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final void setTransformationMethod(TransformationMethod transformationMethod) {
        if (transformationMethod == this.mTransformation) {
            return;
        }
        if (this.mTransformation != null && (this.mText instanceof Spannable)) {
            ((Spannable) this.mText).removeSpan(this.mTransformation);
        }
        this.mTransformation = transformationMethod;
        if (transformationMethod instanceof TransformationMethod2) {
            TransformationMethod2 transformationMethod2 = (TransformationMethod2) transformationMethod;
            this.mAllowTransformationLengthChange = (isTextSelectable() || (this.mText instanceof Editable)) ? false : true;
            transformationMethod2.setLengthChangesAllowed(this.mAllowTransformationLengthChange);
        } else {
            this.mAllowTransformationLengthChange = false;
        }
        setText(this.mText);
        if (hasPasswordTransformationMethod()) {
            notifyViewAccessibilityStateChangedIfNeeded(0);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        boolean z = false;
        if (i <= 0) {
            this.mTextPaint.setFakeBoldText(false);
            this.mTextPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
            return;
        }
        Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
        setTypeface(defaultFromStyle);
        int style = i & ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ (-1));
        TextPaint textPaint = this.mTextPaint;
        if ((style & 1) != 0) {
            z = true;
        }
        textPaint.setFakeBoldText(z);
        this.mTextPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
    }

    public final void setUndoManager(UndoManager undoManager, String str) {
        if (undoManager == null) {
            if (this.mEditor != null) {
                this.mEditor.mUndoManager = null;
                this.mEditor.mUndoOwner = null;
                this.mEditor.mUndoInputFilter = null;
                return;
            }
            return;
        }
        createEditorIfNeeded();
        this.mEditor.mUndoManager = undoManager;
        this.mEditor.mUndoOwner = undoManager.getOwner(str, this);
        this.mEditor.mUndoInputFilter = new Editor.UndoInputFilter(this.mEditor);
        if (!(this.mText instanceof Editable)) {
            setText(this.mText, BufferType.EDITABLE);
        }
        setFilters((Editable) this.mText, this.mFilters);
    }

    @RemotableViewMethod
    public void setWidth(int i) {
        this.mMinWidth = i;
        this.mMaxWidth = i;
        this.mMinWidthMode = 2;
        this.mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r9 >= 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
        if (r9 >= 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void spanChange(android.text.Spanned r6, java.lang.Object r7, int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.TextView.spanChange(android.text.Spanned, java.lang.Object, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopSelectionActionMode() {
        this.mEditor.stopSelectionActionMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean textCanBeSelected() {
        if (this.mMovement == null || !this.mMovement.canSelectArbitrarily()) {
            return false;
        }
        if (isTextEditable()) {
            return true;
        }
        return isTextSelectable() && (this.mText instanceof Spannable) && isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAfterEdit() {
        invalidate();
        int selectionStart = getSelectionStart();
        if (selectionStart >= 0 || (this.mGravity & 112) == 80) {
            registerForPreDraw();
        }
        checkForResize();
        if (selectionStart >= 0) {
            this.mHighlightPathBogus = true;
            if (this.mEditor != null) {
                this.mEditor.makeBlink();
            }
            bringPointIntoView(selectionStart);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        return (verifyDrawable || this.mDrawables == null) ? verifyDrawable : drawable == this.mDrawables.mDrawableLeft || drawable == this.mDrawables.mDrawableTop || drawable == this.mDrawables.mDrawableRight || drawable == this.mDrawables.mDrawableBottom || drawable == this.mDrawables.mDrawableStart || drawable == this.mDrawables.mDrawableEnd;
    }

    protected void viewClicked(InputMethodManager inputMethodManager) {
        if (inputMethodManager != null) {
            inputMethodManager.viewClicked(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int viewportToContentHorizontalOffset() {
        return getCompoundPaddingLeft() - this.mScrollX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int viewportToContentVerticalOffset() {
        int extendedPaddingTop = getExtendedPaddingTop() - this.mScrollY;
        int i = extendedPaddingTop;
        if ((this.mGravity & 112) != 48) {
            i = extendedPaddingTop + getVerticalOffset(false);
        }
        return i;
    }
}

package android.widget;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.UndoManager;
import android.content.UndoOperation;
import android.content.UndoOwner;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.WordIterator;
import android.text.style.EasyEditSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.HardwareCanvas;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.RenderNode;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.widget.EditableInputConnection;
import com.anythink.expressad.video.module.a.a.m;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: source-4181928-dex2jar.jar:android/widget/Editor.class */
public class Editor {
    static final int BLINK = 500;
    static final boolean DEBUG_UNDO = false;
    static final int EXTRACT_NOTHING = -2;
    static final int EXTRACT_UNKNOWN = -1;
    private static final String TAG = "Editor";
    Blink mBlink;
    CorrectionHighlighter mCorrectionHighlighter;
    boolean mCreatedWithASelection;
    int mCursorCount;
    ActionMode.Callback mCustomSelectionActionModeCallback;
    boolean mDiscardNextActionUp;
    CharSequence mError;
    ErrorPopup mErrorPopup;
    boolean mErrorWasChanged;
    boolean mFrozenWithFocus;
    boolean mIgnoreActionUpEvent;
    boolean mInBatchEditControllers;
    InputContentType mInputContentType;
    InputMethodState mInputMethodState;
    boolean mInsertionControllerEnabled;
    InsertionPointCursorController mInsertionPointCursorController;
    KeyListener mKeyListener;
    float mLastDownPositionX;
    float mLastDownPositionY;
    private PositionListener mPositionListener;
    boolean mPreserveDetachedSelection;
    boolean mSelectAllOnFocus;
    private Drawable mSelectHandleCenter;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    ActionMode mSelectionActionMode;
    boolean mSelectionControllerEnabled;
    SelectionModifierCursorController mSelectionModifierCursorController;
    boolean mSelectionMoved;
    long mShowCursor;
    boolean mShowErrorAfterAttach;
    Runnable mShowSuggestionRunnable;
    private SpanController mSpanController;
    SpellChecker mSpellChecker;
    SuggestionRangeSpan mSuggestionRangeSpan;
    SuggestionsPopupWindow mSuggestionsPopupWindow;
    private Rect mTempRect;
    boolean mTemporaryDetach;
    TextDisplayList[] mTextDisplayLists;
    boolean mTextIsSelectable;
    private TextView mTextView;
    boolean mTouchFocusSelected;
    InputFilter mUndoInputFilter;
    UndoManager mUndoManager;
    UndoOwner mUndoOwner;
    WordIterator mWordIterator;
    private static final float[] TEMP_POSITION = new float[2];
    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    int mInputType = 0;
    boolean mCursorVisible = true;
    boolean mShowSoftInputOnFocus = true;
    final Drawable[] mCursorDrawable = new Drawable[2];
    final CursorAnchorInfoNotifier mCursorAnchorInfoNotifier = new CursorAnchorInfoNotifier();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$ActionPopupWindow.class */
    public class ActionPopupWindow extends PinnedPopupWindow implements View.OnClickListener {
        private static final int POPUP_TEXT_LAYOUT = 17367256;
        private TextView mPasteTextView;
        private TextView mReplaceTextView;

        private ActionPopupWindow() {
            super();
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int clipVertically(int i) {
            int i2 = i;
            if (i < 0) {
                int textOffset = getTextOffset();
                Layout layout = Editor.this.mTextView.getLayout();
                int lineForOffset = layout.getLineForOffset(textOffset);
                i2 = i + (layout.getLineBottom(lineForOffset) - layout.getLineTop(lineForOffset)) + this.mContentView.getMeasuredHeight() + Editor.this.mTextView.getContext().getDrawable(Editor.this.mTextView.mTextSelectHandleRes).getIntrinsicHeight();
            }
            return i2;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void createPopupWindow() {
            this.mPopupWindow = new PopupWindow(Editor.this.mTextView.getContext(), (AttributeSet) null, 16843464);
            this.mPopupWindow.setClippingEnabled(true);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getTextOffset() {
            return (Editor.this.mTextView.getSelectionStart() + Editor.this.mTextView.getSelectionEnd()) / 2;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getVerticalLocalPosition(int i) {
            return Editor.this.mTextView.getLayout().getLineTop(i) - this.mContentView.getMeasuredHeight();
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(Editor.this.mTextView.getContext());
            linearLayout.setOrientation(0);
            this.mContentView = linearLayout;
            this.mContentView.setBackgroundResource(R.drawable.text_edit_paste_window);
            LayoutInflater layoutInflater = (LayoutInflater) Editor.this.mTextView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            this.mPasteTextView = (TextView) layoutInflater.inflate(17367256, (ViewGroup) null);
            this.mPasteTextView.setLayoutParams(layoutParams);
            this.mContentView.addView(this.mPasteTextView);
            this.mPasteTextView.setText(17039371);
            this.mPasteTextView.setOnClickListener(this);
            this.mReplaceTextView = (TextView) layoutInflater.inflate(17367256, (ViewGroup) null);
            this.mReplaceTextView.setLayoutParams(layoutParams);
            this.mContentView.addView(this.mReplaceTextView);
            this.mReplaceTextView.setText(R.string.replace);
            this.mReplaceTextView.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.mPasteTextView && Editor.this.mTextView.canPaste()) {
                Editor.this.mTextView.onTextContextMenuItem(16908322);
                hide();
            } else if (view == this.mReplaceTextView) {
                int selectionStart = (Editor.this.mTextView.getSelectionStart() + Editor.this.mTextView.getSelectionEnd()) / 2;
                Editor.this.stopSelectionActionMode();
                Selection.setSelection((Spannable) Editor.this.mTextView.getText(), selectionStart);
                Editor.this.showSuggestions();
            }
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        public void show() {
            boolean canPaste = Editor.this.mTextView.canPaste();
            boolean z = Editor.this.mTextView.isSuggestionsEnabled() && Editor.this.isCursorInsideSuggestionSpan();
            this.mPasteTextView.setVisibility(canPaste ? 0 : 8);
            this.mReplaceTextView.setVisibility(z ? 0 : 8);
            if (canPaste || z) {
                super.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$Blink.class */
    public class Blink extends Handler implements Runnable {
        private boolean mCancelled;

        private Blink() {
        }

        void cancel() {
            if (this.mCancelled) {
                return;
            }
            removeCallbacks(this);
            this.mCancelled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCancelled) {
                return;
            }
            removeCallbacks(this);
            if (Editor.this.shouldBlink()) {
                if (Editor.this.mTextView.getLayout() != null) {
                    Editor.this.mTextView.invalidateCursorPath();
                }
                postAtTime(this, SystemClock.uptimeMillis() + 500);
            }
        }

        void uncancel() {
            this.mCancelled = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$CorrectionHighlighter.class */
    public class CorrectionHighlighter {
        private static final int FADE_OUT_DURATION = 400;
        private int mEnd;
        private long mFadingStartTime;
        private int mStart;
        private RectF mTempRectF;
        private final Path mPath = new Path();
        private final Paint mPaint = new Paint(1);

        public CorrectionHighlighter() {
            this.mPaint.setCompatibilityScaling(Editor.this.mTextView.getResources().getCompatibilityInfo().applicationScale);
            this.mPaint.setStyle(Paint.Style.FILL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidate(boolean z) {
            if (Editor.this.mTextView.getLayout() == null) {
                return;
            }
            if (this.mTempRectF == null) {
                this.mTempRectF = new RectF();
            }
            this.mPath.computeBounds(this.mTempRectF, false);
            int compoundPaddingLeft = Editor.this.mTextView.getCompoundPaddingLeft();
            int extendedPaddingTop = Editor.this.mTextView.getExtendedPaddingTop() + Editor.this.mTextView.getVerticalOffset(true);
            if (z) {
                Editor.this.mTextView.postInvalidateOnAnimation(((int) this.mTempRectF.left) + compoundPaddingLeft, ((int) this.mTempRectF.top) + extendedPaddingTop, ((int) this.mTempRectF.right) + compoundPaddingLeft, ((int) this.mTempRectF.bottom) + extendedPaddingTop);
            } else {
                Editor.this.mTextView.postInvalidate((int) this.mTempRectF.left, (int) this.mTempRectF.top, (int) this.mTempRectF.right, (int) this.mTempRectF.bottom);
            }
        }

        private void stopAnimation() {
            Editor.this.mCorrectionHighlighter = null;
        }

        private boolean updatePaint() {
            long uptimeMillis = SystemClock.uptimeMillis() - this.mFadingStartTime;
            if (uptimeMillis > 400) {
                return false;
            }
            float f = ((float) uptimeMillis) / 400.0f;
            int alpha = Color.alpha(Editor.this.mTextView.mHighlightColor);
            this.mPaint.setColor((Editor.this.mTextView.mHighlightColor & 16777215) + (((int) (alpha * (1.0f - f))) << 24));
            return true;
        }

        private boolean updatePath() {
            Layout layout = Editor.this.mTextView.getLayout();
            if (layout == null) {
                return false;
            }
            int length = Editor.this.mTextView.getText().length();
            int min = Math.min(length, this.mStart);
            int min2 = Math.min(length, this.mEnd);
            this.mPath.reset();
            layout.getSelectionPath(min, min2, this.mPath);
            return true;
        }

        public void draw(Canvas canvas, int i) {
            if (!updatePath() || !updatePaint()) {
                stopAnimation();
                invalidate(false);
                return;
            }
            if (i != 0) {
                canvas.translate(0.0f, i);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            if (i != 0) {
                canvas.translate(0.0f, -i);
            }
            invalidate(true);
        }

        public void highlight(CorrectionInfo correctionInfo) {
            this.mStart = correctionInfo.getOffset();
            this.mEnd = this.mStart + correctionInfo.getNewText().length();
            this.mFadingStartTime = SystemClock.uptimeMillis();
            if (this.mStart < 0 || this.mEnd < 0) {
                stopAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$CursorAnchorInfoNotifier.class */
    public final class CursorAnchorInfoNotifier implements TextViewPositionListener {
        final CursorAnchorInfo.Builder mSelectionInfoBuilder;
        final int[] mTmpIntOffset;
        final Matrix mViewToScreenMatrix;

        private CursorAnchorInfoNotifier() {
            this.mSelectionInfoBuilder = new CursorAnchorInfo.Builder();
            this.mTmpIntOffset = new int[2];
            this.mViewToScreenMatrix = new Matrix();
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x022d, code lost:
            if (r0 == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0310, code lost:
            if (r0 == false) goto L79;
         */
        @Override // android.widget.Editor.TextViewPositionListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void updatePosition(int r9, int r10, boolean r11, boolean r12) {
            /*
                Method dump skipped, instructions count: 843
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.Editor.CursorAnchorInfoNotifier.updatePosition(int, int, boolean, boolean):void");
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$CursorController.class */
    private interface CursorController extends ViewTreeObserver.OnTouchModeChangeListener {
        void hide();

        void onDetached();

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$DragLocalState.class */
    public static class DragLocalState {
        public int end;
        public TextView sourceTextView;
        public int start;

        public DragLocalState(TextView textView, int i, int i2) {
            this.sourceTextView = textView;
            this.start = i;
            this.end = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$EasyEditDeleteListener.class */
    public interface EasyEditDeleteListener {
        void onDeleteClick(EasyEditSpan easyEditSpan);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$EasyEditPopupWindow.class */
    public class EasyEditPopupWindow extends PinnedPopupWindow implements View.OnClickListener {
        private static final int POPUP_TEXT_LAYOUT = 17367256;
        private TextView mDeleteTextView;
        private EasyEditSpan mEasyEditSpan;
        private EasyEditDeleteListener mOnDeleteListener;

        private EasyEditPopupWindow() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOnDeleteListener(EasyEditDeleteListener easyEditDeleteListener) {
            this.mOnDeleteListener = easyEditDeleteListener;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int clipVertically(int i) {
            return i;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void createPopupWindow() {
            this.mPopupWindow = new PopupWindow(Editor.this.mTextView.getContext(), (AttributeSet) null, 16843464);
            this.mPopupWindow.setInputMethodMode(2);
            this.mPopupWindow.setClippingEnabled(true);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getTextOffset() {
            return ((Editable) Editor.this.mTextView.getText()).getSpanEnd(this.mEasyEditSpan);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getVerticalLocalPosition(int i) {
            return Editor.this.mTextView.getLayout().getLineBottom(i);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        public void hide() {
            if (this.mEasyEditSpan != null) {
                this.mEasyEditSpan.setDeleteEnabled(false);
            }
            this.mOnDeleteListener = null;
            super.hide();
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(Editor.this.mTextView.getContext());
            linearLayout.setOrientation(0);
            this.mContentView = linearLayout;
            this.mContentView.setBackgroundResource(R.drawable.text_edit_side_paste_window);
            LayoutInflater layoutInflater = (LayoutInflater) Editor.this.mTextView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            this.mDeleteTextView = (TextView) layoutInflater.inflate(17367256, (ViewGroup) null);
            this.mDeleteTextView.setLayoutParams(layoutParams);
            this.mDeleteTextView.setText(R.string.delete);
            this.mDeleteTextView.setOnClickListener(this);
            this.mContentView.addView(this.mDeleteTextView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != this.mDeleteTextView || this.mEasyEditSpan == null || !this.mEasyEditSpan.isDeleteEnabled() || this.mOnDeleteListener == null) {
                return;
            }
            this.mOnDeleteListener.onDeleteClick(this.mEasyEditSpan);
        }

        public void setEasyEditSpan(EasyEditSpan easyEditSpan) {
            this.mEasyEditSpan = easyEditSpan;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$ErrorPopup.class */
    public static class ErrorPopup extends PopupWindow {
        private boolean mAbove;
        private int mPopupInlineErrorAboveBackgroundId;
        private int mPopupInlineErrorBackgroundId;
        private final TextView mView;

        ErrorPopup(TextView textView, int i, int i2) {
            super(textView, i, i2);
            this.mAbove = false;
            this.mPopupInlineErrorBackgroundId = 0;
            this.mPopupInlineErrorAboveBackgroundId = 0;
            this.mView = textView;
            this.mPopupInlineErrorBackgroundId = getResourceId(this.mPopupInlineErrorBackgroundId, 272);
            this.mView.setBackgroundResource(this.mPopupInlineErrorBackgroundId);
        }

        private int getResourceId(int i, int i2) {
            int i3 = i;
            if (i == 0) {
                TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(android.R.styleable.Theme);
                i3 = obtainStyledAttributes.getResourceId(i2, 0);
                obtainStyledAttributes.recycle();
            }
            return i3;
        }

        void fixDirection(boolean z) {
            this.mAbove = z;
            if (z) {
                this.mPopupInlineErrorAboveBackgroundId = getResourceId(this.mPopupInlineErrorAboveBackgroundId, 273);
            } else {
                this.mPopupInlineErrorBackgroundId = getResourceId(this.mPopupInlineErrorBackgroundId, 272);
            }
            this.mView.setBackgroundResource(z ? this.mPopupInlineErrorAboveBackgroundId : this.mPopupInlineErrorBackgroundId);
        }

        @Override // android.widget.PopupWindow
        public void update(int i, int i2, int i3, int i4, boolean z) {
            super.update(i, i2, i3, i4, z);
            boolean isAboveAnchor = isAboveAnchor();
            if (isAboveAnchor != this.mAbove) {
                fixDirection(isAboveAnchor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$HandleView.class */
    public abstract class HandleView extends View implements TextViewPositionListener {
        private static final int HISTORY_SIZE = 5;
        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
        private Runnable mActionPopupShower;
        protected ActionPopupWindow mActionPopupWindow;
        private final PopupWindow mContainer;
        protected Drawable mDrawable;
        protected Drawable mDrawableLtr;
        protected Drawable mDrawableRtl;
        protected int mHorizontalGravity;
        protected int mHotspotX;
        private float mIdealVerticalOffset;
        private boolean mIsDragging;
        private int mLastParentX;
        private int mLastParentY;
        private int mMinSize;
        private int mNumberPreviousOffsets;
        private boolean mPositionHasChanged;
        private int mPositionX;
        private int mPositionY;
        private int mPreviousOffset;
        private int mPreviousOffsetIndex;
        private final int[] mPreviousOffsets;
        private final long[] mPreviousOffsetsTimes;
        private float mTouchOffsetY;
        private float mTouchToWindowOffsetX;
        private float mTouchToWindowOffsetY;

        public HandleView(Drawable drawable, Drawable drawable2) {
            super(Editor.this.mTextView.getContext());
            this.mPreviousOffset = -1;
            this.mPositionHasChanged = true;
            this.mPreviousOffsetsTimes = new long[5];
            this.mPreviousOffsets = new int[5];
            this.mPreviousOffsetIndex = 0;
            this.mNumberPreviousOffsets = 0;
            this.mContainer = new PopupWindow(Editor.this.mTextView.getContext(), (AttributeSet) null, 16843464);
            this.mContainer.setSplitTouchEnabled(true);
            this.mContainer.setClippingEnabled(false);
            this.mContainer.setWindowLayoutType(1002);
            this.mContainer.setContentView(this);
            this.mDrawableLtr = drawable;
            this.mDrawableRtl = drawable2;
            this.mMinSize = Editor.this.mTextView.getContext().getResources().getDimensionPixelSize(R.dimen.text_handle_min_size);
            updateDrawable();
            int preferredHeight = getPreferredHeight();
            this.mTouchOffsetY = (-0.3f) * preferredHeight;
            this.mIdealVerticalOffset = 0.7f * preferredHeight;
        }

        private void addPositionToTouchUpFilter(int i) {
            this.mPreviousOffsetIndex = (this.mPreviousOffsetIndex + 1) % 5;
            this.mPreviousOffsets[this.mPreviousOffsetIndex] = i;
            this.mPreviousOffsetsTimes[this.mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            this.mNumberPreviousOffsets++;
        }

        private void filterOnTouchUp() {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = 0;
            int i2 = this.mPreviousOffsetIndex;
            int min = Math.min(this.mNumberPreviousOffsets, 5);
            while (i < min && uptimeMillis - this.mPreviousOffsetsTimes[i2] < 150) {
                i++;
                i2 = ((this.mPreviousOffsetIndex - i) + 5) % 5;
            }
            if (i <= 0 || i >= min || uptimeMillis - this.mPreviousOffsetsTimes[i2] <= 350) {
                return;
            }
            positionAtCursorOffset(this.mPreviousOffsets[i2], false);
        }

        private int getHorizontalOffset() {
            int preferredWidth = getPreferredWidth();
            int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
            switch (this.mHorizontalGravity) {
                case 3:
                    return 0;
                case 4:
                default:
                    return (preferredWidth - intrinsicWidth) / 2;
                case 5:
                    return preferredWidth - intrinsicWidth;
            }
        }

        private int getPreferredHeight() {
            return Math.max(this.mDrawable.getIntrinsicHeight(), this.mMinSize);
        }

        private int getPreferredWidth() {
            return Math.max(this.mDrawable.getIntrinsicWidth(), this.mMinSize);
        }

        private boolean isVisible() {
            if (this.mIsDragging) {
                return true;
            }
            if (Editor.this.mTextView.isInBatchEditMode()) {
                return false;
            }
            return Editor.this.isPositionVisible(this.mPositionX + this.mHotspotX, this.mPositionY);
        }

        private void startTouchUpFilter(int i) {
            this.mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(i);
        }

        protected void dismiss() {
            this.mIsDragging = false;
            if (this.mContainer.isShowing()) {
                this.mContainer.dismiss();
            }
            onDetached();
        }

        public abstract int getCurrentCursorOffset();

        protected int getCursorOffset() {
            return 0;
        }

        protected abstract int getHorizontalGravity(boolean z);

        protected abstract int getHotspotX(Drawable drawable, boolean z);

        public void hide() {
            dismiss();
            Editor.this.getPositionListener().removeSubscriber(this);
        }

        protected void hideActionPopupWindow() {
            if (this.mActionPopupShower != null) {
                Editor.this.mTextView.removeCallbacks(this.mActionPopupShower);
            }
            if (this.mActionPopupWindow != null) {
                this.mActionPopupWindow.hide();
            }
        }

        public boolean isDragging() {
            return this.mIsDragging;
        }

        public boolean isShowing() {
            return this.mContainer.isShowing();
        }

        public boolean offsetHasBeenChanged() {
            return this.mNumberPreviousOffsets > 1;
        }

        public void onDetached() {
            hideActionPopupWindow();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
            int horizontalOffset = getHorizontalOffset();
            this.mDrawable.setBounds(horizontalOffset, 0, horizontalOffset + intrinsicWidth, this.mDrawable.getIntrinsicHeight());
            this.mDrawable.draw(canvas);
        }

        void onHandleMoved() {
            hideActionPopupWindow();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            setMeasuredDimension(getPreferredWidth(), getPreferredHeight());
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    startTouchUpFilter(getCurrentCursorOffset());
                    this.mTouchToWindowOffsetX = motionEvent.getRawX() - this.mPositionX;
                    this.mTouchToWindowOffsetY = motionEvent.getRawY() - this.mPositionY;
                    PositionListener positionListener = Editor.this.getPositionListener();
                    this.mLastParentX = positionListener.getPositionX();
                    this.mLastParentY = positionListener.getPositionY();
                    this.mIsDragging = true;
                    return true;
                case 1:
                    filterOnTouchUp();
                    this.mIsDragging = false;
                    return true;
                case 2:
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f = this.mTouchToWindowOffsetY - this.mLastParentY;
                    float f2 = (rawY - this.mPositionY) - this.mLastParentY;
                    this.mTouchToWindowOffsetY = this.mLastParentY + (f < this.mIdealVerticalOffset ? Math.max(Math.min(f2, this.mIdealVerticalOffset), f) : Math.min(Math.max(f2, this.mIdealVerticalOffset), f));
                    updatePosition((rawX - this.mTouchToWindowOffsetX) + this.mHotspotX, (rawY - this.mTouchToWindowOffsetY) + this.mTouchOffsetY);
                    return true;
                case 3:
                    this.mIsDragging = false;
                    return true;
                default:
                    return true;
            }
        }

        protected void positionAtCursorOffset(int i, boolean z) {
            Layout layout = Editor.this.mTextView.getLayout();
            if (layout == null) {
                Editor.this.prepareCursorControllers();
                return;
            }
            boolean z2 = i != this.mPreviousOffset;
            if (z2 || z) {
                if (z2) {
                    updateSelection(i);
                    addPositionToTouchUpFilter(i);
                }
                int lineForOffset = layout.getLineForOffset(i);
                this.mPositionX = (int) ((((layout.getPrimaryHorizontal(i) - 0.5f) - this.mHotspotX) - getHorizontalOffset()) + getCursorOffset());
                this.mPositionY = layout.getLineBottom(lineForOffset);
                this.mPositionX += Editor.this.mTextView.viewportToContentHorizontalOffset();
                this.mPositionY += Editor.this.mTextView.viewportToContentVerticalOffset();
                this.mPreviousOffset = i;
                this.mPositionHasChanged = true;
            }
        }

        public void show() {
            if (isShowing()) {
                return;
            }
            Editor.this.getPositionListener().addSubscriber(this, true);
            this.mPreviousOffset = -1;
            positionAtCursorOffset(getCurrentCursorOffset(), false);
            hideActionPopupWindow();
        }

        void showActionPopupWindow(int i) {
            if (this.mActionPopupWindow == null) {
                this.mActionPopupWindow = new ActionPopupWindow();
            }
            if (this.mActionPopupShower == null) {
                this.mActionPopupShower = new Runnable() { // from class: android.widget.Editor.HandleView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HandleView.this.mActionPopupWindow.show();
                    }
                };
            } else {
                Editor.this.mTextView.removeCallbacks(this.mActionPopupShower);
            }
            Editor.this.mTextView.postDelayed(this.mActionPopupShower, i);
        }

        protected void updateDrawable() {
            boolean isRtlCharAt = Editor.this.mTextView.getLayout().isRtlCharAt(getCurrentCursorOffset());
            this.mDrawable = isRtlCharAt ? this.mDrawableRtl : this.mDrawableLtr;
            this.mHotspotX = getHotspotX(this.mDrawable, isRtlCharAt);
            this.mHorizontalGravity = getHorizontalGravity(isRtlCharAt);
        }

        public abstract void updatePosition(float f, float f2);

        @Override // android.widget.Editor.TextViewPositionListener
        public void updatePosition(int i, int i2, boolean z, boolean z2) {
            positionAtCursorOffset(getCurrentCursorOffset(), z2);
            if (z || this.mPositionHasChanged) {
                if (this.mIsDragging) {
                    if (i != this.mLastParentX || i2 != this.mLastParentY) {
                        this.mTouchToWindowOffsetX += i - this.mLastParentX;
                        this.mTouchToWindowOffsetY += i2 - this.mLastParentY;
                        this.mLastParentX = i;
                        this.mLastParentY = i2;
                    }
                    onHandleMoved();
                }
                if (isVisible()) {
                    int i3 = i + this.mPositionX;
                    int i4 = i2 + this.mPositionY;
                    if (isShowing()) {
                        this.mContainer.update(i3, i4, -1, -1);
                    } else {
                        this.mContainer.showAtLocation(Editor.this.mTextView, 0, i3, i4);
                    }
                } else if (isShowing()) {
                    dismiss();
                }
                this.mPositionHasChanged = false;
            }
        }

        protected abstract void updateSelection(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$InputContentType.class */
    public static class InputContentType {
        boolean enterDown;
        Bundle extras;
        int imeActionId;
        CharSequence imeActionLabel;
        int imeOptions = 0;
        TextView.OnEditorActionListener onEditorActionListener;
        String privateImeOptions;

        InputContentType() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$InputMethodState.class */
    public static class InputMethodState {
        int mBatchEditNesting;
        int mChangedDelta;
        int mChangedEnd;
        int mChangedStart;
        boolean mContentChanged;
        boolean mCursorChanged;
        ExtractedTextRequest mExtractedTextRequest;
        boolean mSelectionModeChanged;
        Rect mCursorRectInWindow = new Rect();
        float[] mTmpOffset = new float[2];
        final ExtractedText mExtractedText = new ExtractedText();

        InputMethodState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$InsertionHandleView.class */
    public class InsertionHandleView extends HandleView {
        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        private static final int RECENT_CUT_COPY_DURATION = 15000;
        private float mDownPositionX;
        private float mDownPositionY;
        private Runnable mHider;

        public InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
        }

        private void hideAfterDelay() {
            if (this.mHider == null) {
                this.mHider = new Runnable() { // from class: android.widget.Editor.InsertionHandleView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InsertionHandleView.this.hide();
                    }
                };
            } else {
                removeHiderCallback();
            }
            Editor.this.mTextView.postDelayed(this.mHider, 4000L);
        }

        private void removeHiderCallback() {
            if (this.mHider != null) {
                Editor.this.mTextView.removeCallbacks(this.mHider);
            }
        }

        @Override // android.widget.Editor.HandleView
        public int getCurrentCursorOffset() {
            return Editor.this.mTextView.getSelectionStart();
        }

        @Override // android.widget.Editor.HandleView
        protected int getCursorOffset() {
            int cursorOffset = super.getCursorOffset();
            Drawable drawable = Editor.this.mCursorCount > 0 ? Editor.this.mCursorDrawable[0] : null;
            int i = cursorOffset;
            if (drawable != null) {
                drawable.getPadding(Editor.this.mTempRect);
                i = cursorOffset + (((drawable.getIntrinsicWidth() - Editor.this.mTempRect.left) - Editor.this.mTempRect.right) / 2);
            }
            return i;
        }

        @Override // android.widget.Editor.HandleView
        protected int getHorizontalGravity(boolean z) {
            return 1;
        }

        @Override // android.widget.Editor.HandleView
        protected int getHotspotX(Drawable drawable, boolean z) {
            return drawable.getIntrinsicWidth() / 2;
        }

        @Override // android.widget.Editor.HandleView
        public void onDetached() {
            super.onDetached();
            removeHiderCallback();
        }

        @Override // android.widget.Editor.HandleView
        void onHandleMoved() {
            super.onHandleMoved();
            removeHiderCallback();
        }

        @Override // android.widget.Editor.HandleView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.mDownPositionX = motionEvent.getRawX();
                    this.mDownPositionY = motionEvent.getRawY();
                    return onTouchEvent;
                case 1:
                    if (!offsetHasBeenChanged()) {
                        float rawX = this.mDownPositionX - motionEvent.getRawX();
                        float rawY = this.mDownPositionY - motionEvent.getRawY();
                        int scaledTouchSlop = ViewConfiguration.get(Editor.this.mTextView.getContext()).getScaledTouchSlop();
                        if ((rawX * rawX) + (rawY * rawY) < scaledTouchSlop * scaledTouchSlop) {
                            if (this.mActionPopupWindow == null || !this.mActionPopupWindow.isShowing()) {
                                showWithActionPopup();
                            } else {
                                this.mActionPopupWindow.hide();
                            }
                        }
                    }
                    hideAfterDelay();
                    return onTouchEvent;
                case 2:
                default:
                    return onTouchEvent;
                case 3:
                    hideAfterDelay();
                    return onTouchEvent;
            }
        }

        @Override // android.widget.Editor.HandleView
        public void show() {
            super.show();
            if (SystemClock.uptimeMillis() - TextView.LAST_CUT_OR_COPY_TIME < 15000) {
                showActionPopupWindow(0);
            }
            hideAfterDelay();
        }

        public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
        }

        @Override // android.widget.Editor.HandleView
        public void updatePosition(float f, float f2) {
            positionAtCursorOffset(Editor.this.mTextView.getOffsetForPosition(f, f2), false);
        }

        @Override // android.widget.Editor.HandleView
        public void updateSelection(int i) {
            Selection.setSelection((Spannable) Editor.this.mTextView.getText(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$InsertionPointCursorController.class */
    public class InsertionPointCursorController implements CursorController {
        private InsertionHandleView mHandle;

        private InsertionPointCursorController() {
        }

        private InsertionHandleView getHandle() {
            if (Editor.this.mSelectHandleCenter == null) {
                Editor.this.mSelectHandleCenter = Editor.this.mTextView.getContext().getDrawable(Editor.this.mTextView.mTextSelectHandleRes);
            }
            if (this.mHandle == null) {
                this.mHandle = new InsertionHandleView(Editor.this.mSelectHandleCenter);
            }
            return this.mHandle;
        }

        @Override // android.widget.Editor.CursorController
        public void hide() {
            if (this.mHandle != null) {
                this.mHandle.hide();
            }
        }

        @Override // android.widget.Editor.CursorController
        public void onDetached() {
            Editor.this.mTextView.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if (this.mHandle != null) {
                this.mHandle.onDetached();
            }
        }

        @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
        public void onTouchModeChanged(boolean z) {
            if (z) {
                return;
            }
            hide();
        }

        @Override // android.widget.Editor.CursorController
        public void show() {
            getHandle().show();
        }

        public void showWithActionPopup() {
            getHandle().showWithActionPopup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$PinnedPopupWindow.class */
    public abstract class PinnedPopupWindow implements TextViewPositionListener {
        protected ViewGroup mContentView;
        protected PopupWindow mPopupWindow;
        int mPositionX;
        int mPositionY;

        public PinnedPopupWindow() {
            createPopupWindow();
            this.mPopupWindow.setWindowLayoutType(1002);
            this.mPopupWindow.setWidth(-2);
            this.mPopupWindow.setHeight(-2);
            initContentView();
            this.mContentView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.mPopupWindow.setContentView(this.mContentView);
        }

        private void computeLocalPosition() {
            measureContent();
            int measuredWidth = this.mContentView.getMeasuredWidth();
            int textOffset = getTextOffset();
            this.mPositionX = (int) (Editor.this.mTextView.getLayout().getPrimaryHorizontal(textOffset) - (measuredWidth / 2.0f));
            this.mPositionX += Editor.this.mTextView.viewportToContentHorizontalOffset();
            this.mPositionY = getVerticalLocalPosition(Editor.this.mTextView.getLayout().getLineForOffset(textOffset));
            this.mPositionY += Editor.this.mTextView.viewportToContentVerticalOffset();
        }

        private void updatePosition(int i, int i2) {
            int i3 = this.mPositionX;
            int clipVertically = clipVertically(i2 + this.mPositionY);
            DisplayMetrics displayMetrics = Editor.this.mTextView.getResources().getDisplayMetrics();
            int max = Math.max(0, Math.min(displayMetrics.widthPixels - this.mContentView.getMeasuredWidth(), i + i3));
            if (isShowing()) {
                this.mPopupWindow.update(max, clipVertically, -1, -1);
            } else {
                this.mPopupWindow.showAtLocation(Editor.this.mTextView, 0, max, clipVertically);
            }
        }

        protected abstract int clipVertically(int i);

        protected abstract void createPopupWindow();

        protected abstract int getTextOffset();

        protected abstract int getVerticalLocalPosition(int i);

        public void hide() {
            this.mPopupWindow.dismiss();
            Editor.this.getPositionListener().removeSubscriber(this);
        }

        protected abstract void initContentView();

        public boolean isShowing() {
            return this.mPopupWindow.isShowing();
        }

        protected void measureContent() {
            DisplayMetrics displayMetrics = Editor.this.mTextView.getResources().getDisplayMetrics();
            this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        }

        public void show() {
            Editor.this.getPositionListener().addSubscriber(this, false);
            computeLocalPosition();
            PositionListener positionListener = Editor.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
        }

        @Override // android.widget.Editor.TextViewPositionListener
        public void updatePosition(int i, int i2, boolean z, boolean z2) {
            if (!isShowing() || !Editor.this.isOffsetVisible(getTextOffset())) {
                hide();
                return;
            }
            if (z2) {
                computeLocalPosition();
            }
            updatePosition(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$PositionListener.class */
    public class PositionListener implements ViewTreeObserver.OnPreDrawListener {
        private final int MAXIMUM_NUMBER_OF_LISTENERS;
        private boolean[] mCanMove;
        private int mNumberOfListeners;
        private boolean mPositionHasChanged;
        private TextViewPositionListener[] mPositionListeners;
        private int mPositionX;
        private int mPositionY;
        private boolean mScrollHasChanged;
        final int[] mTempCoords;

        private PositionListener() {
            this.MAXIMUM_NUMBER_OF_LISTENERS = 7;
            this.mPositionListeners = new TextViewPositionListener[7];
            this.mCanMove = new boolean[7];
            this.mPositionHasChanged = true;
            this.mTempCoords = new int[2];
        }

        private void updatePosition() {
            Editor.this.mTextView.getLocationInWindow(this.mTempCoords);
            this.mPositionHasChanged = (this.mTempCoords[0] == this.mPositionX && this.mTempCoords[1] == this.mPositionY) ? false : true;
            this.mPositionX = this.mTempCoords[0];
            this.mPositionY = this.mTempCoords[1];
        }

        public void addSubscriber(TextViewPositionListener textViewPositionListener, boolean z) {
            if (this.mNumberOfListeners == 0) {
                updatePosition();
                Editor.this.mTextView.getViewTreeObserver().addOnPreDrawListener(this);
            }
            int i = -1;
            int i2 = 0;
            while (i2 < 7) {
                TextViewPositionListener textViewPositionListener2 = this.mPositionListeners[i2];
                if (textViewPositionListener2 == textViewPositionListener) {
                    return;
                }
                int i3 = i;
                if (i < 0) {
                    i3 = i;
                    if (textViewPositionListener2 == null) {
                        i3 = i2;
                    }
                }
                i2++;
                i = i3;
            }
            this.mPositionListeners[i] = textViewPositionListener;
            this.mCanMove[i] = z;
            this.mNumberOfListeners++;
        }

        public int getPositionX() {
            return this.mPositionX;
        }

        public int getPositionY() {
            return this.mPositionY;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            TextViewPositionListener textViewPositionListener;
            updatePosition();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 7) {
                    this.mScrollHasChanged = false;
                    return true;
                }
                if ((this.mPositionHasChanged || this.mScrollHasChanged || this.mCanMove[i2]) && (textViewPositionListener = this.mPositionListeners[i2]) != null) {
                    textViewPositionListener.updatePosition(this.mPositionX, this.mPositionY, this.mPositionHasChanged, this.mScrollHasChanged);
                }
                i = i2 + 1;
            }
        }

        public void onScrollChanged() {
            this.mScrollHasChanged = true;
        }

        public void removeSubscriber(TextViewPositionListener textViewPositionListener) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 7) {
                    break;
                } else if (this.mPositionListeners[i2] == textViewPositionListener) {
                    this.mPositionListeners[i2] = null;
                    this.mNumberOfListeners--;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (this.mNumberOfListeners == 0) {
                Editor.this.mTextView.getViewTreeObserver().removeOnPreDrawListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SelectionActionModeCallback.class */
    public class SelectionActionModeCallback implements ActionMode.Callback {
        private SelectionActionModeCallback() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (Editor.this.mCustomSelectionActionModeCallback == null || !Editor.this.mCustomSelectionActionModeCallback.onActionItemClicked(actionMode, menuItem)) {
                return Editor.this.mTextView.onTextContextMenuItem(menuItem.getItemId());
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            TypedArray obtainStyledAttributes = (((Editor.this.mTextView.getContext().getApplicationInfo().targetSdkVersion < 21) || !(menu instanceof MenuBuilder)) ? Editor.this.mTextView.getContext() : ((MenuBuilder) menu).getContext()).obtainStyledAttributes(R.styleable.SelectionModeDrawables);
            actionMode.setTitle(Editor.this.mTextView.getContext().getString(R.string.textSelectionCABTitle));
            actionMode.setSubtitle((CharSequence) null);
            actionMode.setTitleOptionalHint(true);
            menu.add(0, 16908319, 0, 17039373).setIcon(obtainStyledAttributes.getResourceId(3, 0)).setAlphabeticShortcut('a').setShowAsAction(6);
            if (Editor.this.mTextView.canCut()) {
                menu.add(0, 16908320, 0, 17039363).setIcon(obtainStyledAttributes.getResourceId(0, 0)).setAlphabeticShortcut('x').setShowAsAction(6);
            }
            if (Editor.this.mTextView.canCopy()) {
                menu.add(0, 16908321, 0, 17039361).setIcon(obtainStyledAttributes.getResourceId(1, 0)).setAlphabeticShortcut('c').setShowAsAction(6);
            }
            if (Editor.this.mTextView.canPaste()) {
                menu.add(0, 16908322, 0, 17039371).setIcon(obtainStyledAttributes.getResourceId(2, 0)).setAlphabeticShortcut('v').setShowAsAction(6);
            }
            obtainStyledAttributes.recycle();
            if (Editor.this.mCustomSelectionActionModeCallback == null || Editor.this.mCustomSelectionActionModeCallback.onCreateActionMode(actionMode, menu)) {
                if (menu.hasVisibleItems() || actionMode.getCustomView() != null) {
                    Editor.this.getSelectionController().show();
                    Editor.this.mTextView.setHasTransientState(true);
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            if (Editor.this.mCustomSelectionActionModeCallback != null) {
                Editor.this.mCustomSelectionActionModeCallback.onDestroyActionMode(actionMode);
            }
            if (!Editor.this.mPreserveDetachedSelection) {
                Selection.setSelection((Spannable) Editor.this.mTextView.getText(), Editor.this.mTextView.getSelectionEnd());
                Editor.this.mTextView.setHasTransientState(false);
            }
            if (Editor.this.mSelectionModifierCursorController != null) {
                Editor.this.mSelectionModifierCursorController.hide();
            }
            Editor.this.mSelectionActionMode = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (Editor.this.mCustomSelectionActionModeCallback != null) {
                return Editor.this.mCustomSelectionActionModeCallback.onPrepareActionMode(actionMode, menu);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SelectionEndHandleView.class */
    public class SelectionEndHandleView extends HandleView {
        public SelectionEndHandleView(Drawable drawable, Drawable drawable2) {
            super(drawable, drawable2);
        }

        @Override // android.widget.Editor.HandleView
        public int getCurrentCursorOffset() {
            return Editor.this.mTextView.getSelectionEnd();
        }

        @Override // android.widget.Editor.HandleView
        protected int getHorizontalGravity(boolean z) {
            return z ? 3 : 5;
        }

        @Override // android.widget.Editor.HandleView
        protected int getHotspotX(Drawable drawable, boolean z) {
            return z ? (drawable.getIntrinsicWidth() * 3) / 4 : drawable.getIntrinsicWidth() / 4;
        }

        public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            this.mActionPopupWindow = actionPopupWindow;
        }

        @Override // android.widget.Editor.HandleView
        public void updatePosition(float f, float f2) {
            int offsetForPosition = Editor.this.mTextView.getOffsetForPosition(f, f2);
            int selectionStart = Editor.this.mTextView.getSelectionStart();
            int i = offsetForPosition;
            if (offsetForPosition <= selectionStart) {
                i = Math.min(selectionStart + 1, Editor.this.mTextView.getText().length());
            }
            positionAtCursorOffset(i, false);
        }

        @Override // android.widget.Editor.HandleView
        public void updateSelection(int i) {
            Selection.setSelection((Spannable) Editor.this.mTextView.getText(), Editor.this.mTextView.getSelectionStart(), i);
            updateDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SelectionModifierCursorController.class */
    public class SelectionModifierCursorController implements CursorController {
        private static final int DELAY_BEFORE_REPLACE_ACTION = 200;
        private float mDownPositionX;
        private float mDownPositionY;
        private SelectionEndHandleView mEndHandle;
        private boolean mGestureStayedInTapRegion;
        private int mMaxTouchOffset;
        private int mMinTouchOffset;
        private long mPreviousTapUpTime = 0;
        private SelectionStartHandleView mStartHandle;

        SelectionModifierCursorController() {
            resetTouchOffsets();
        }

        private void initDrawables() {
            if (Editor.this.mSelectHandleLeft == null) {
                Editor.this.mSelectHandleLeft = Editor.this.mTextView.getContext().getDrawable(Editor.this.mTextView.mTextSelectHandleLeftRes);
            }
            if (Editor.this.mSelectHandleRight == null) {
                Editor.this.mSelectHandleRight = Editor.this.mTextView.getContext().getDrawable(Editor.this.mTextView.mTextSelectHandleRightRes);
            }
        }

        private void initHandles() {
            if (this.mStartHandle == null) {
                this.mStartHandle = new SelectionStartHandleView(Editor.this.mSelectHandleLeft, Editor.this.mSelectHandleRight);
            }
            if (this.mEndHandle == null) {
                this.mEndHandle = new SelectionEndHandleView(Editor.this.mSelectHandleRight, Editor.this.mSelectHandleLeft);
            }
            this.mStartHandle.show();
            this.mEndHandle.show();
            this.mStartHandle.showActionPopupWindow(200);
            this.mEndHandle.setActionPopupWindow(this.mStartHandle.getActionPopupWindow());
            Editor.this.hideInsertionPointCursorController();
        }

        private void updateMinAndMaxOffsets(MotionEvent motionEvent) {
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pointerCount) {
                    return;
                }
                int offsetForPosition = Editor.this.mTextView.getOffsetForPosition(motionEvent.getX(i2), motionEvent.getY(i2));
                if (offsetForPosition < this.mMinTouchOffset) {
                    this.mMinTouchOffset = offsetForPosition;
                }
                if (offsetForPosition > this.mMaxTouchOffset) {
                    this.mMaxTouchOffset = offsetForPosition;
                }
                i = i2 + 1;
            }
        }

        public int getMaxTouchOffset() {
            return this.mMaxTouchOffset;
        }

        public int getMinTouchOffset() {
            return this.mMinTouchOffset;
        }

        @Override // android.widget.Editor.CursorController
        public void hide() {
            if (this.mStartHandle != null) {
                this.mStartHandle.hide();
            }
            if (this.mEndHandle != null) {
                this.mEndHandle.hide();
            }
        }

        public boolean isSelectionStartDragged() {
            return this.mStartHandle != null && this.mStartHandle.isDragging();
        }

        @Override // android.widget.Editor.CursorController
        public void onDetached() {
            Editor.this.mTextView.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if (this.mStartHandle != null) {
                this.mStartHandle.onDetached();
            }
            if (this.mEndHandle != null) {
                this.mEndHandle.onDetached();
            }
        }

        public void onTouchEvent(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    int offsetForPosition = Editor.this.mTextView.getOffsetForPosition(x, y);
                    this.mMaxTouchOffset = offsetForPosition;
                    this.mMinTouchOffset = offsetForPosition;
                    if (this.mGestureStayedInTapRegion && SystemClock.uptimeMillis() - this.mPreviousTapUpTime <= ViewConfiguration.getDoubleTapTimeout()) {
                        float f = x - this.mDownPositionX;
                        float f2 = y - this.mDownPositionY;
                        int scaledDoubleTapSlop = ViewConfiguration.get(Editor.this.mTextView.getContext()).getScaledDoubleTapSlop();
                        if (((f * f) + (f2 * f2) < ((float) (scaledDoubleTapSlop * scaledDoubleTapSlop))) && Editor.this.isPositionOnText(x, y)) {
                            Editor.this.startSelectionActionMode();
                            Editor.this.mDiscardNextActionUp = true;
                        }
                    }
                    this.mDownPositionX = x;
                    this.mDownPositionY = y;
                    this.mGestureStayedInTapRegion = true;
                    return;
                case 1:
                    this.mPreviousTapUpTime = SystemClock.uptimeMillis();
                    return;
                case 2:
                    if (this.mGestureStayedInTapRegion) {
                        float x2 = motionEvent.getX() - this.mDownPositionX;
                        float y2 = motionEvent.getY() - this.mDownPositionY;
                        int scaledDoubleTapTouchSlop = ViewConfiguration.get(Editor.this.mTextView.getContext()).getScaledDoubleTapTouchSlop();
                        if ((x2 * x2) + (y2 * y2) > scaledDoubleTapTouchSlop * scaledDoubleTapTouchSlop) {
                            this.mGestureStayedInTapRegion = false;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                case 4:
                default:
                    return;
                case 5:
                case 6:
                    if (Editor.this.mTextView.getContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)) {
                        updateMinAndMaxOffsets(motionEvent);
                        return;
                    }
                    return;
            }
        }

        @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
        public void onTouchModeChanged(boolean z) {
            if (z) {
                return;
            }
            hide();
        }

        public void resetTouchOffsets() {
            this.mMaxTouchOffset = -1;
            this.mMinTouchOffset = -1;
        }

        @Override // android.widget.Editor.CursorController
        public void show() {
            if (Editor.this.mTextView.isInBatchEditMode()) {
                return;
            }
            initDrawables();
            initHandles();
            Editor.this.hideInsertionPointCursorController();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SelectionStartHandleView.class */
    public class SelectionStartHandleView extends HandleView {
        public SelectionStartHandleView(Drawable drawable, Drawable drawable2) {
            super(drawable, drawable2);
        }

        public ActionPopupWindow getActionPopupWindow() {
            return this.mActionPopupWindow;
        }

        @Override // android.widget.Editor.HandleView
        public int getCurrentCursorOffset() {
            return Editor.this.mTextView.getSelectionStart();
        }

        @Override // android.widget.Editor.HandleView
        protected int getHorizontalGravity(boolean z) {
            return z ? 5 : 3;
        }

        @Override // android.widget.Editor.HandleView
        protected int getHotspotX(Drawable drawable, boolean z) {
            return z ? drawable.getIntrinsicWidth() / 4 : (drawable.getIntrinsicWidth() * 3) / 4;
        }

        @Override // android.widget.Editor.HandleView
        public void updatePosition(float f, float f2) {
            int offsetForPosition = Editor.this.mTextView.getOffsetForPosition(f, f2);
            int selectionEnd = Editor.this.mTextView.getSelectionEnd();
            int i = offsetForPosition;
            if (offsetForPosition >= selectionEnd) {
                i = Math.max(0, selectionEnd - 1);
            }
            positionAtCursorOffset(i, false);
        }

        @Override // android.widget.Editor.HandleView
        public void updateSelection(int i) {
            Selection.setSelection((Spannable) Editor.this.mTextView.getText(), i, Editor.this.mTextView.getSelectionEnd());
            updateDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SpanController.class */
    public class SpanController implements SpanWatcher {
        private static final int DISPLAY_TIMEOUT_MS = 3000;
        private Runnable mHidePopup;
        private EasyEditPopupWindow mPopupWindow;

        SpanController() {
        }

        private boolean isNonIntermediateSelectionSpan(Spannable spannable, Object obj) {
            return (Selection.SELECTION_START == obj || Selection.SELECTION_END == obj) && (spannable.getSpanFlags(obj) & 512) == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendEasySpanNotification(int i, EasyEditSpan easyEditSpan) {
            try {
                PendingIntent pendingIntent = easyEditSpan.getPendingIntent();
                if (pendingIntent != null) {
                    Intent intent = new Intent();
                    intent.putExtra(EasyEditSpan.EXTRA_TEXT_CHANGED_TYPE, i);
                    pendingIntent.send(Editor.this.mTextView.getContext(), 0, intent);
                }
            } catch (PendingIntent.CanceledException e) {
                Log.w(Editor.TAG, "PendingIntent for notification cannot be sent", e);
            }
        }

        public void hide() {
            if (this.mPopupWindow != null) {
                this.mPopupWindow.hide();
                Editor.this.mTextView.removeCallbacks(this.mHidePopup);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (isNonIntermediateSelectionSpan(spannable, obj)) {
                Editor.this.sendUpdateSelection();
            } else if (obj instanceof EasyEditSpan) {
                if (this.mPopupWindow == null) {
                    this.mPopupWindow = new EasyEditPopupWindow();
                    this.mHidePopup = new Runnable() { // from class: android.widget.Editor.SpanController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SpanController.this.hide();
                        }
                    };
                }
                if (this.mPopupWindow.mEasyEditSpan != null) {
                    this.mPopupWindow.mEasyEditSpan.setDeleteEnabled(false);
                }
                this.mPopupWindow.setEasyEditSpan((EasyEditSpan) obj);
                this.mPopupWindow.setOnDeleteListener(new EasyEditDeleteListener() { // from class: android.widget.Editor.SpanController.2
                    @Override // android.widget.Editor.EasyEditDeleteListener
                    public void onDeleteClick(EasyEditSpan easyEditSpan) {
                        Editable editable = (Editable) Editor.this.mTextView.getText();
                        int spanStart = editable.getSpanStart(easyEditSpan);
                        int spanEnd = editable.getSpanEnd(easyEditSpan);
                        if (spanStart >= 0 && spanEnd >= 0) {
                            SpanController.this.sendEasySpanNotification(1, easyEditSpan);
                            Editor.this.mTextView.deleteText_internal(spanStart, spanEnd);
                        }
                        editable.removeSpan(easyEditSpan);
                    }
                });
                if (Editor.this.mTextView.getWindowVisibility() != 0 || Editor.this.mTextView.getLayout() == null || Editor.this.extractedTextModeWillBeStarted()) {
                    return;
                }
                this.mPopupWindow.show();
                Editor.this.mTextView.removeCallbacks(this.mHidePopup);
                Editor.this.mTextView.postDelayed(this.mHidePopup, m.ag);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (isNonIntermediateSelectionSpan(spannable, obj)) {
                Editor.this.sendUpdateSelection();
            } else if (this.mPopupWindow == null || !(obj instanceof EasyEditSpan)) {
            } else {
                EasyEditSpan easyEditSpan = (EasyEditSpan) obj;
                sendEasySpanNotification(2, easyEditSpan);
                spannable.removeSpan(easyEditSpan);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (isNonIntermediateSelectionSpan(spannable, obj)) {
                Editor.this.sendUpdateSelection();
            } else if (this.mPopupWindow == null || obj != this.mPopupWindow.mEasyEditSpan) {
            } else {
                hide();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SuggestionsPopupWindow.class */
    public class SuggestionsPopupWindow extends PinnedPopupWindow implements AdapterView.OnItemClickListener {
        private static final int ADD_TO_DICTIONARY = -1;
        private static final int DELETE_TEXT = -2;
        private static final int MAX_NUMBER_SUGGESTIONS = 5;
        private boolean mCursorWasVisibleBeforeSuggestions;
        private boolean mIsShowingUp;
        private int mNumberOfSuggestions;
        private final HashMap<SuggestionSpan, Integer> mSpansLengths;
        private SuggestionInfo[] mSuggestionInfos;
        private final Comparator<SuggestionSpan> mSuggestionSpanComparator;
        private SuggestionAdapter mSuggestionsAdapter;

        /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SuggestionsPopupWindow$CustomPopupWindow.class */
        private class CustomPopupWindow extends PopupWindow {
            public CustomPopupWindow(Context context, int i) {
                super(context, (AttributeSet) null, i);
            }

            @Override // android.widget.PopupWindow
            public void dismiss() {
                super.dismiss();
                Editor.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable) Editor.this.mTextView.getText()).removeSpan(Editor.this.mSuggestionRangeSpan);
                Editor.this.mTextView.setCursorVisible(SuggestionsPopupWindow.this.mCursorWasVisibleBeforeSuggestions);
                if (Editor.this.hasInsertionController()) {
                    Editor.this.getInsertionController().show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SuggestionsPopupWindow$SuggestionAdapter.class */
        public class SuggestionAdapter extends BaseAdapter {
            private LayoutInflater mInflater;

            private SuggestionAdapter() {
                this.mInflater = (LayoutInflater) Editor.this.mTextView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }

            @Override // android.widget.Adapter
            public int getCount() {
                return SuggestionsPopupWindow.this.mNumberOfSuggestions;
            }

            @Override // android.widget.Adapter
            public Object getItem(int i) {
                return SuggestionsPopupWindow.this.mSuggestionInfos[i];
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return i;
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) view;
                TextView textView2 = textView;
                if (textView == null) {
                    textView2 = (TextView) this.mInflater.inflate(Editor.this.mTextView.mTextEditSuggestionItemLayout, viewGroup, false);
                }
                SuggestionInfo suggestionInfo = SuggestionsPopupWindow.this.mSuggestionInfos[i];
                textView2.setText(suggestionInfo.text);
                if (suggestionInfo.suggestionIndex == -1 || suggestionInfo.suggestionIndex == -2) {
                    textView2.setBackgroundColor(0);
                    return textView2;
                }
                textView2.setBackgroundColor(-1);
                return textView2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SuggestionsPopupWindow$SuggestionInfo.class */
        public class SuggestionInfo {
            TextAppearanceSpan highlightSpan;
            int suggestionEnd;
            int suggestionIndex;
            SuggestionSpan suggestionSpan;
            int suggestionStart;
            SpannableStringBuilder text;

            private SuggestionInfo() {
                this.text = new SpannableStringBuilder();
                this.highlightSpan = new TextAppearanceSpan(Editor.this.mTextView.getContext(), 16974104);
            }
        }

        /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$SuggestionsPopupWindow$SuggestionSpanComparator.class */
        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            private SuggestionSpanComparator() {
            }

            @Override // java.util.Comparator
            public int compare(SuggestionSpan suggestionSpan, SuggestionSpan suggestionSpan2) {
                boolean z = false;
                int flags = suggestionSpan.getFlags();
                int flags2 = suggestionSpan2.getFlags();
                if (flags != flags2) {
                    boolean z2 = (flags & 1) != 0;
                    boolean z3 = (flags2 & 1) != 0;
                    boolean z4 = (flags & 2) != 0;
                    if ((flags2 & 2) != 0) {
                        z = true;
                    }
                    if (z2 && !z4) {
                        return -1;
                    }
                    if (z3 && !z) {
                        return 1;
                    }
                    if (z4) {
                        return -1;
                    }
                    if (z) {
                        return 1;
                    }
                }
                return ((Integer) SuggestionsPopupWindow.this.mSpansLengths.get(suggestionSpan)).intValue() - ((Integer) SuggestionsPopupWindow.this.mSpansLengths.get(suggestionSpan2)).intValue();
            }
        }

        public SuggestionsPopupWindow() {
            super();
            this.mIsShowingUp = false;
            this.mCursorWasVisibleBeforeSuggestions = Editor.this.mCursorVisible;
            this.mSuggestionSpanComparator = new SuggestionSpanComparator();
            this.mSpansLengths = new HashMap<>();
        }

        private SuggestionSpan[] getSuggestionSpans() {
            int selectionStart = Editor.this.mTextView.getSelectionStart();
            Spannable spannable = (Spannable) Editor.this.mTextView.getText();
            SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(selectionStart, selectionStart, SuggestionSpan.class);
            this.mSpansLengths.clear();
            int length = suggestionSpanArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    Arrays.sort(suggestionSpanArr, this.mSuggestionSpanComparator);
                    return suggestionSpanArr;
                }
                SuggestionSpan suggestionSpan = suggestionSpanArr[i2];
                int spanStart = spannable.getSpanStart(suggestionSpan);
                this.mSpansLengths.put(suggestionSpan, Integer.valueOf(spannable.getSpanEnd(suggestionSpan) - spanStart));
                i = i2 + 1;
            }
        }

        private void highlightTextDifferences(SuggestionInfo suggestionInfo, int i, int i2) {
            Spannable spannable = (Spannable) Editor.this.mTextView.getText();
            int spanStart = spannable.getSpanStart(suggestionInfo.suggestionSpan);
            int spanEnd = spannable.getSpanEnd(suggestionInfo.suggestionSpan);
            suggestionInfo.suggestionStart = spanStart - i;
            suggestionInfo.suggestionEnd = suggestionInfo.suggestionStart + suggestionInfo.text.length();
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, suggestionInfo.text.length(), 33);
            String obj = spannable.toString();
            suggestionInfo.text.insert(0, (CharSequence) obj.substring(i, spanStart));
            suggestionInfo.text.append((CharSequence) obj.substring(spanEnd, i2));
        }

        private boolean updateSuggestions() {
            int i;
            boolean z;
            Spannable spannable = (Spannable) Editor.this.mTextView.getText();
            SuggestionSpan[] suggestionSpans = getSuggestionSpans();
            int length = suggestionSpans.length;
            if (length == 0) {
                return false;
            }
            this.mNumberOfSuggestions = 0;
            int length2 = Editor.this.mTextView.getText().length();
            int i2 = 0;
            SuggestionSpan suggestionSpan = null;
            int i3 = 0;
            int i4 = 0;
            while (i4 < length) {
                SuggestionSpan suggestionSpan2 = suggestionSpans[i4];
                int spanStart = spannable.getSpanStart(suggestionSpan2);
                int spanEnd = spannable.getSpanEnd(suggestionSpan2);
                int min = Math.min(spanStart, length2);
                int max = Math.max(spanEnd, i2);
                if ((suggestionSpan2.getFlags() & 2) != 0) {
                    suggestionSpan = suggestionSpan2;
                }
                if (i4 == 0) {
                    i3 = suggestionSpan2.getUnderlineColor();
                }
                String[] suggestions = suggestionSpan2.getSuggestions();
                int length3 = suggestions.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    i = i4;
                    if (i6 < length3) {
                        String str = suggestions[i6];
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            z = false;
                            if (i8 >= this.mNumberOfSuggestions) {
                                break;
                            }
                            if (this.mSuggestionInfos[i8].text.toString().equals(str)) {
                                SuggestionSpan suggestionSpan3 = this.mSuggestionInfos[i8].suggestionSpan;
                                int spanStart2 = spannable.getSpanStart(suggestionSpan3);
                                int spanEnd2 = spannable.getSpanEnd(suggestionSpan3);
                                if (spanStart == spanStart2 && spanEnd == spanEnd2) {
                                    z = true;
                                    break;
                                }
                            }
                            i7 = i8 + 1;
                        }
                        if (!z) {
                            SuggestionInfo suggestionInfo = this.mSuggestionInfos[this.mNumberOfSuggestions];
                            suggestionInfo.suggestionSpan = suggestionSpan2;
                            suggestionInfo.suggestionIndex = i6;
                            suggestionInfo.text.replace(0, suggestionInfo.text.length(), (CharSequence) str);
                            this.mNumberOfSuggestions++;
                            if (this.mNumberOfSuggestions == 5) {
                                i = length;
                                break;
                            }
                        }
                        i5 = i6 + 1;
                    }
                }
                i4 = i + 1;
                i2 = max;
                length2 = min;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.mNumberOfSuggestions) {
                    break;
                }
                highlightTextDifferences(this.mSuggestionInfos[i10], length2, i2);
                i9 = i10 + 1;
            }
            if (suggestionSpan != null) {
                int spanStart3 = spannable.getSpanStart(suggestionSpan);
                int spanEnd3 = spannable.getSpanEnd(suggestionSpan);
                if (spanStart3 >= 0 && spanEnd3 > spanStart3) {
                    SuggestionInfo suggestionInfo2 = this.mSuggestionInfos[this.mNumberOfSuggestions];
                    suggestionInfo2.suggestionSpan = suggestionSpan;
                    suggestionInfo2.suggestionIndex = -1;
                    suggestionInfo2.text.replace(0, suggestionInfo2.text.length(), (CharSequence) Editor.this.mTextView.getContext().getString(R.string.addToDictionary));
                    suggestionInfo2.text.setSpan(suggestionInfo2.highlightSpan, 0, 0, 33);
                    this.mNumberOfSuggestions++;
                }
            }
            SuggestionInfo suggestionInfo3 = this.mSuggestionInfos[this.mNumberOfSuggestions];
            suggestionInfo3.suggestionSpan = null;
            suggestionInfo3.suggestionIndex = -2;
            suggestionInfo3.text.replace(0, suggestionInfo3.text.length(), (CharSequence) Editor.this.mTextView.getContext().getString(R.string.deleteText));
            suggestionInfo3.text.setSpan(suggestionInfo3.highlightSpan, 0, 0, 33);
            this.mNumberOfSuggestions++;
            if (Editor.this.mSuggestionRangeSpan == null) {
                Editor.this.mSuggestionRangeSpan = new SuggestionRangeSpan();
            }
            if (i3 == 0) {
                Editor.this.mSuggestionRangeSpan.setBackgroundColor(Editor.this.mTextView.mHighlightColor);
            } else {
                Editor.this.mSuggestionRangeSpan.setBackgroundColor((16777215 & i3) + (((int) (Color.alpha(i3) * 0.4f)) << 24));
            }
            spannable.setSpan(Editor.this.mSuggestionRangeSpan, length2, i2, 33);
            this.mSuggestionsAdapter.notifyDataSetChanged();
            return true;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int clipVertically(int i) {
            return Math.min(i, Editor.this.mTextView.getResources().getDisplayMetrics().heightPixels - this.mContentView.getMeasuredHeight());
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void createPopupWindow() {
            this.mPopupWindow = new CustomPopupWindow(Editor.this.mTextView.getContext(), 16843635);
            this.mPopupWindow.setInputMethodMode(2);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setClippingEnabled(false);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getTextOffset() {
            return Editor.this.mTextView.getSelectionStart();
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected int getVerticalLocalPosition(int i) {
            return Editor.this.mTextView.getLayout().getLineBottom(i);
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        public void hide() {
            super.hide();
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void initContentView() {
            ListView listView = new ListView(Editor.this.mTextView.getContext());
            this.mSuggestionsAdapter = new SuggestionAdapter();
            listView.setAdapter((ListAdapter) this.mSuggestionsAdapter);
            listView.setOnItemClickListener(this);
            this.mContentView = listView;
            this.mSuggestionInfos = new SuggestionInfo[7];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mSuggestionInfos.length) {
                    return;
                }
                this.mSuggestionInfos[i2] = new SuggestionInfo();
                i = i2 + 1;
            }
        }

        public boolean isShowingUp() {
            return this.mIsShowingUp;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        protected void measureContent() {
            DisplayMetrics displayMetrics = Editor.this.mTextView.getResources().getDisplayMetrics();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
            int i = 0;
            View view = null;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mNumberOfSuggestions) {
                    break;
                }
                view = this.mSuggestionsAdapter.getView(i3, view, this.mContentView);
                view.getLayoutParams().width = -2;
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i = Math.max(i, view.getMeasuredWidth());
                i2 = i3 + 1;
            }
            this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), makeMeasureSpec2);
            Drawable background = this.mPopupWindow.getBackground();
            int i4 = i;
            if (background != null) {
                if (Editor.this.mTempRect == null) {
                    Editor.this.mTempRect = new Rect();
                }
                background.getPadding(Editor.this.mTempRect);
                i4 = i + Editor.this.mTempRect.left + Editor.this.mTempRect.right;
            }
            this.mPopupWindow.setWidth(i4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0082, code lost:
            if (java.lang.Character.isSpaceChar(r0.charAt(r0 - 1)) != false) goto L15;
         */
        @Override // android.widget.AdapterView.OnItemClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onItemClick(android.widget.AdapterView<?> r8, android.view.View r9, int r10, long r11) {
            /*
                Method dump skipped, instructions count: 745
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.Editor.SuggestionsPopupWindow.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
        }

        public void onParentLostFocus() {
            this.mIsShowingUp = false;
        }

        @Override // android.widget.Editor.PinnedPopupWindow
        public void show() {
            if ((Editor.this.mTextView.getText() instanceof Editable) && updateSuggestions()) {
                this.mCursorWasVisibleBeforeSuggestions = Editor.this.mCursorVisible;
                Editor.this.mTextView.setCursorVisible(false);
                this.mIsShowingUp = true;
                super.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$TextDisplayList.class */
    public static class TextDisplayList {
        RenderNode displayList;
        boolean isDirty = true;

        public TextDisplayList(String str) {
            this.displayList = RenderNode.create(str, null);
        }

        boolean needsRecord() {
            return this.isDirty || !this.displayList.isValid();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$TextModifyOperation.class */
    public static class TextModifyOperation extends UndoOperation<TextView> {
        public static final Parcelable.ClassLoaderCreator<TextModifyOperation> CREATOR = new Parcelable.ClassLoaderCreator<TextModifyOperation>() { // from class: android.widget.Editor.TextModifyOperation.1
            @Override // android.os.Parcelable.Creator
            public TextModifyOperation createFromParcel(Parcel parcel) {
                return new TextModifyOperation(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public TextModifyOperation createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new TextModifyOperation(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public TextModifyOperation[] newArray(int i) {
                return new TextModifyOperation[i];
            }
        };
        CharSequence mOldText;
        int mRangeEnd;
        int mRangeStart;

        public TextModifyOperation(UndoOwner undoOwner) {
            super(undoOwner);
        }

        public TextModifyOperation(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mRangeStart = parcel.readInt();
            this.mRangeEnd = parcel.readInt();
            this.mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        private void swapText() {
            Editable editable = (Editable) getOwnerData().getText();
            CharSequence subSequence = this.mRangeStart >= this.mRangeEnd ? null : editable.subSequence(this.mRangeStart, this.mRangeEnd);
            if (this.mOldText == null) {
                editable.delete(this.mRangeStart, this.mRangeEnd);
                this.mRangeEnd = this.mRangeStart;
            } else {
                editable.replace(this.mRangeStart, this.mRangeEnd, this.mOldText);
                this.mRangeEnd = this.mRangeStart + this.mOldText.length();
            }
            this.mOldText = subSequence;
        }

        @Override // android.content.UndoOperation
        public void commit() {
        }

        @Override // android.content.UndoOperation
        public void redo() {
            swapText();
        }

        @Override // android.content.UndoOperation
        public void undo() {
            swapText();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mRangeStart);
            parcel.writeInt(this.mRangeEnd);
            TextUtils.writeToParcel(this.mOldText, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$TextViewPositionListener.class */
    public interface TextViewPositionListener {
        void updatePosition(int i, int i2, boolean z, boolean z2);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/Editor$UndoInputFilter.class */
    public static class UndoInputFilter implements InputFilter {
        final Editor mEditor;

        public UndoInputFilter(Editor editor) {
            this.mEditor = editor;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            UndoManager undoManager = this.mEditor.mUndoManager;
            if (undoManager.isInUndo()) {
                return null;
            }
            undoManager.beginUpdate("Edit text");
            TextModifyOperation textModifyOperation = (TextModifyOperation) undoManager.getLastOperation(TextModifyOperation.class, this.mEditor.mUndoOwner, 1);
            if (textModifyOperation != null) {
                if (textModifyOperation.mOldText == null) {
                    if (i < i2 && ((i3 >= textModifyOperation.mRangeStart && i4 <= textModifyOperation.mRangeEnd) || (i3 == textModifyOperation.mRangeEnd && i4 == textModifyOperation.mRangeEnd))) {
                        textModifyOperation.mRangeEnd = (i2 - i) + i3;
                        undoManager.endUpdate();
                        return null;
                    }
                } else if (i == i2 && i4 == textModifyOperation.mRangeStart - 1) {
                    SpannableStringBuilder spannableStringBuilder = textModifyOperation.mOldText instanceof SpannableString ? (SpannableStringBuilder) textModifyOperation.mOldText : new SpannableStringBuilder(textModifyOperation.mOldText);
                    spannableStringBuilder.insert(0, (CharSequence) spanned, i3, i4);
                    textModifyOperation.mRangeStart = i3;
                    textModifyOperation.mOldText = spannableStringBuilder;
                    undoManager.endUpdate();
                    return null;
                }
                undoManager.commitState(null);
                undoManager.setUndoLabel("Edit text");
            }
            TextModifyOperation textModifyOperation2 = new TextModifyOperation(this.mEditor.mUndoOwner);
            textModifyOperation2.mRangeStart = i3;
            if (i < i2) {
                textModifyOperation2.mRangeEnd = (i2 - i) + i3;
            } else {
                textModifyOperation2.mRangeEnd = i3;
            }
            if (i3 < i4) {
                textModifyOperation2.mOldText = spanned.subSequence(i3, i4);
            }
            undoManager.addOperation(textModifyOperation2, 0);
            undoManager.endUpdate();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Editor(TextView textView) {
        this.mTextView = textView;
    }

    private boolean canSelectText() {
        return hasSelectionController() && this.mTextView.getText().length() != 0;
    }

    private void chooseSize(PopupWindow popupWindow, CharSequence charSequence, TextView textView) {
        int paddingLeft = textView.getPaddingLeft();
        int paddingRight = textView.getPaddingRight();
        int paddingTop = textView.getPaddingTop();
        int paddingBottom = textView.getPaddingBottom();
        StaticLayout staticLayout = new StaticLayout(charSequence, textView.getPaint(), this.mTextView.getResources().getDimensionPixelSize(R.dimen.textview_error_popup_default_width), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= staticLayout.getLineCount()) {
                popupWindow.setWidth(((int) Math.ceil(f)) + paddingLeft + paddingRight);
                popupWindow.setHeight(staticLayout.getHeight() + paddingTop + paddingBottom);
                return;
            }
            f = Math.max(f, staticLayout.getLineWidth(i2));
            i = i2 + 1;
        }
    }

    private void destroyDisplayListsData() {
        if (this.mTextDisplayLists == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTextDisplayLists.length) {
                return;
            }
            RenderNode renderNode = this.mTextDisplayLists[i2] != null ? this.mTextDisplayLists[i2].displayList : null;
            if (renderNode != null && renderNode.isValid()) {
                renderNode.destroyDisplayListData();
            }
            i = i2 + 1;
        }
    }

    private void downgradeEasyCorrectionSpans() {
        CharSequence text = this.mTextView.getText();
        if (!(text instanceof Spannable)) {
            return;
        }
        Spannable spannable = (Spannable) text;
        SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) spannable.getSpans(0, spannable.length(), SuggestionSpan.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= suggestionSpanArr.length) {
                return;
            }
            int flags = suggestionSpanArr[i2].getFlags();
            if ((flags & 1) != 0 && (flags & 2) == 0) {
                suggestionSpanArr[i2].setFlags(flags & (-2));
            }
            i = i2 + 1;
        }
    }

    private void drawCursor(Canvas canvas, int i) {
        boolean z = i != 0;
        if (z) {
            canvas.translate(0.0f, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mCursorCount) {
                break;
            }
            this.mCursorDrawable[i3].draw(canvas);
            i2 = i3 + 1;
        }
        if (z) {
            canvas.translate(0.0f, -i);
        }
    }

    private void drawHardwareAccelerated(Canvas canvas, Layout layout, Path path, Paint paint, int i) {
        long lineRangeForDraw = layout.getLineRangeForDraw(canvas);
        int unpackRangeStartFromLong = TextUtils.unpackRangeStartFromLong(lineRangeForDraw);
        int unpackRangeEndFromLong = TextUtils.unpackRangeEndFromLong(lineRangeForDraw);
        if (unpackRangeEndFromLong < 0) {
            return;
        }
        layout.drawBackground(canvas, path, paint, i, unpackRangeStartFromLong, unpackRangeEndFromLong);
        if (!(layout instanceof DynamicLayout)) {
            layout.drawText(canvas, unpackRangeStartFromLong, unpackRangeEndFromLong);
            return;
        }
        if (this.mTextDisplayLists == null) {
            this.mTextDisplayLists = (TextDisplayList[]) ArrayUtils.emptyArray(TextDisplayList.class);
        }
        DynamicLayout dynamicLayout = (DynamicLayout) layout;
        int[] blockEndLines = dynamicLayout.getBlockEndLines();
        int[] blockIndices = dynamicLayout.getBlockIndices();
        int numberOfBlocks = dynamicLayout.getNumberOfBlocks();
        int indexFirstChangedBlock = dynamicLayout.getIndexFirstChangedBlock();
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i4 < numberOfBlocks) {
            int i5 = blockEndLines[i4];
            int i6 = blockIndices[i4];
            int i7 = i3;
            if (i6 == -1) {
                i6 = getAvailableDisplayListIndex(blockIndices, numberOfBlocks, i3);
                blockIndices[i4] = i6;
                i7 = i6 + 1;
            }
            if (this.mTextDisplayLists[i6] == null) {
                this.mTextDisplayLists[i6] = new TextDisplayList("Text " + i6);
            }
            boolean needsRecord = this.mTextDisplayLists[i6].needsRecord();
            RenderNode renderNode = this.mTextDisplayLists[i6].displayList;
            if (i4 >= indexFirstChangedBlock || needsRecord) {
                int i8 = i2 + 1;
                int lineTop = layout.getLineTop(i8);
                int lineBottom = layout.getLineBottom(i5);
                int i9 = 0;
                int width = this.mTextView.getWidth();
                if (this.mTextView.getHorizontallyScrolling()) {
                    float f = Float.MAX_VALUE;
                    float f2 = Float.MIN_VALUE;
                    int i10 = i8;
                    while (true) {
                        int i11 = i10;
                        if (i11 > i5) {
                            break;
                        }
                        f = Math.min(f, layout.getLineLeft(i11));
                        f2 = Math.max(f2, layout.getLineRight(i11));
                        i10 = i11 + 1;
                    }
                    i9 = (int) f;
                    width = (int) (0.5f + f2);
                }
                if (needsRecord) {
                    HardwareCanvas start = renderNode.start(width - i9, lineBottom - lineTop);
                    try {
                        start.translate(-i9, -lineTop);
                        layout.drawText(start, i8, i5);
                    } finally {
                        renderNode.end(start);
                        renderNode.setClipToBounds(false);
                    }
                }
                renderNode.setLeftTopRightBottom(i9, lineTop, width, lineBottom);
            }
            ((HardwareCanvas) canvas).drawRenderNode(renderNode, null, 0);
            i2 = i5;
            i4++;
            i3 = i7;
        }
        dynamicLayout.setIndexFirstChangedBlock(numberOfBlocks);
    }

    private boolean extractTextInternal(ExtractedTextRequest extractedTextRequest, int i, int i2, int i3, ExtractedText extractedText) {
        int i4;
        int i5;
        int i6;
        boolean z = false;
        CharSequence text = this.mTextView.getText();
        if (text != null) {
            if (i != -2) {
                int length = text.length();
                if (i < 0) {
                    extractedText.partialEndOffset = -1;
                    extractedText.partialStartOffset = -1;
                    i5 = 0;
                    i6 = length;
                } else {
                    int i7 = i2 + i3;
                    int i8 = i;
                    int i9 = i7;
                    if (text instanceof Spanned) {
                        Spanned spanned = (Spanned) text;
                        Object[] spans = spanned.getSpans(i, i7, ParcelableSpan.class);
                        int length2 = spans.length;
                        while (true) {
                            i8 = i;
                            i9 = i7;
                            if (length2 <= 0) {
                                break;
                            }
                            int i10 = length2 - 1;
                            int spanStart = spanned.getSpanStart(spans[i10]);
                            int i11 = i;
                            if (spanStart < i) {
                                i11 = spanStart;
                            }
                            int spanEnd = spanned.getSpanEnd(spans[i10]);
                            length2 = i10;
                            i = i11;
                            if (spanEnd > i7) {
                                i7 = spanEnd;
                                length2 = i10;
                                i = i11;
                            }
                        }
                    }
                    extractedText.partialStartOffset = i8;
                    extractedText.partialEndOffset = i9 - i3;
                    if (i8 > length) {
                        i4 = length;
                    } else {
                        i4 = i8;
                        if (i8 < 0) {
                            i4 = 0;
                        }
                    }
                    if (i9 > length) {
                        i6 = length;
                        i5 = i4;
                    } else {
                        i5 = i4;
                        i6 = i9;
                        if (i9 < 0) {
                            i6 = 0;
                            i5 = i4;
                        }
                    }
                }
                if ((extractedTextRequest.flags & 1) != 0) {
                    extractedText.text = text.subSequence(i5, i6);
                } else {
                    extractedText.text = TextUtils.substring(text, i5, i6);
                }
            } else {
                extractedText.partialStartOffset = 0;
                extractedText.partialEndOffset = 0;
                extractedText.text = "";
            }
            extractedText.flags = 0;
            if (MetaKeyKeyListener.getMetaState(text, 2048) != 0) {
                extractedText.flags |= 2;
            }
            if (this.mTextView.isSingleLine()) {
                extractedText.flags |= 1;
            }
            extractedText.startOffset = 0;
            extractedText.selectionStart = this.mTextView.getSelectionStart();
            extractedText.selectionEnd = this.mTextView.getSelectionEnd();
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean extractedTextModeWillBeStarted() {
        boolean z = false;
        if (!(this.mTextView instanceof ExtractEditText)) {
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            z = false;
            if (peekInstance != null) {
                z = false;
                if (peekInstance.isFullscreenMode()) {
                    z = true;
                }
            }
        }
        return z;
    }

    private int getAvailableDisplayListIndex(int[] iArr, int i, int i2) {
        int i3;
        boolean z;
        int length = this.mTextDisplayLists.length;
        while (true) {
            if (i2 >= length) {
                this.mTextDisplayLists = (TextDisplayList[]) GrowingArrayUtils.append(this.mTextDisplayLists, length, (Object) null);
                i3 = length;
                break;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                z = false;
                if (i5 >= i) {
                    break;
                } else if (iArr[i5] == i2) {
                    z = true;
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            i3 = i2;
            if (!z) {
                break;
            }
            i2++;
        }
        return i3;
    }

    private long getCharRange(int i) {
        int length = this.mTextView.getText().length();
        if (i + 1 >= length || !Character.isSurrogatePair(this.mTextView.getText().charAt(i), this.mTextView.getText().charAt(i + 1))) {
            if (i < length) {
                return TextUtils.packRangeInLong(i, i + 1);
            }
            if (i - 2 >= 0) {
                if (Character.isSurrogatePair(this.mTextView.getText().charAt(i - 2), this.mTextView.getText().charAt(i - 1))) {
                    return TextUtils.packRangeInLong(i - 2, i);
                }
            }
            return i - 1 >= 0 ? TextUtils.packRangeInLong(i - 1, i) : TextUtils.packRangeInLong(i, i);
        }
        return TextUtils.packRangeInLong(i, i + 2);
    }

    private int getErrorX() {
        int i = 0;
        float f = this.mTextView.getResources().getDisplayMetrics().density;
        TextView.Drawables drawables = this.mTextView.mDrawables;
        switch (this.mTextView.getLayoutDirection()) {
            case 1:
                int i2 = 0;
                if (drawables != null) {
                    i2 = drawables.mDrawableSizeLeft;
                }
                return this.mTextView.getPaddingLeft() + ((i2 / 2) - ((int) ((25.0f * f) + 0.5f)));
            default:
                if (drawables != null) {
                    i = drawables.mDrawableSizeRight;
                }
                return ((this.mTextView.getWidth() - this.mErrorPopup.getWidth()) - this.mTextView.getPaddingRight()) + ((-i) / 2) + ((int) ((25.0f * f) + 0.5f));
        }
    }

    private int getErrorY() {
        int i = 0;
        int compoundPaddingTop = this.mTextView.getCompoundPaddingTop();
        int bottom = this.mTextView.getBottom();
        int top = this.mTextView.getTop();
        int compoundPaddingBottom = this.mTextView.getCompoundPaddingBottom();
        TextView.Drawables drawables = this.mTextView.mDrawables;
        switch (this.mTextView.getLayoutDirection()) {
            case 1:
                i = 0;
                if (drawables != null) {
                    i = drawables.mDrawableHeightLeft;
                    break;
                }
                break;
            default:
                if (drawables != null) {
                    i = drawables.mDrawableHeightRight;
                    break;
                }
                break;
        }
        return (((compoundPaddingTop + (((((bottom - top) - compoundPaddingBottom) - compoundPaddingTop) - i) / 2)) + i) - this.mTextView.getHeight()) - ((int) ((2.0f * this.mTextView.getResources().getDisplayMetrics().density) + 0.5f));
    }

    private int getLastTapPosition() {
        int minTouchOffset;
        if (this.mSelectionModifierCursorController == null || (minTouchOffset = this.mSelectionModifierCursorController.getMinTouchOffset()) < 0) {
            return -1;
        }
        int i = minTouchOffset;
        if (minTouchOffset > this.mTextView.getText().length()) {
            i = this.mTextView.getText().length();
        }
        return i;
    }

    private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController = getSelectionController();
        return TextUtils.packRangeInLong(selectionController.getMinTouchOffset(), selectionController.getMaxTouchOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PositionListener getPositionListener() {
        if (this.mPositionListener == null) {
            this.mPositionListener = new PositionListener();
        }
        return this.mPositionListener;
    }

    private float getPrimaryHorizontal(Layout layout, Layout layout2, int i, boolean z) {
        return (!TextUtils.isEmpty(layout.getText()) || layout2 == null || TextUtils.isEmpty(layout2.getText())) ? layout.getPrimaryHorizontal(i, z) : layout2.getPrimaryHorizontal(i, z);
    }

    private View.DragShadowBuilder getTextThumbnailBuilder(CharSequence charSequence) {
        TextView textView = (TextView) View.inflate(this.mTextView.getContext(), R.layout.text_drag_thumbnail, null);
        if (textView == null) {
            throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        }
        CharSequence charSequence2 = charSequence;
        if (charSequence.length() > DRAG_SHADOW_MAX_TEXT_LENGTH) {
            charSequence2 = charSequence.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
        }
        textView.setText(charSequence2);
        textView.setTextColor(this.mTextView.getTextColors());
        textView.setTextAppearance(this.mTextView.getContext(), 16);
        textView.setGravity(17);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        textView.measure(makeMeasureSpec, makeMeasureSpec);
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        textView.invalidate();
        return new View.DragShadowBuilder(textView);
    }

    private boolean hasPasswordTransformationMethod() {
        return this.mTextView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private void hideCursorControllers() {
        if (this.mSuggestionsPopupWindow != null && !this.mSuggestionsPopupWindow.isShowingUp()) {
            this.mSuggestionsPopupWindow.hide();
        }
        hideInsertionPointCursorController();
        stopSelectionActionMode();
    }

    private void hideError() {
        if (this.mErrorPopup != null && this.mErrorPopup.isShowing()) {
            this.mErrorPopup.dismiss();
        }
        this.mShowErrorAfterAttach = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInsertionPointCursorController() {
        if (this.mInsertionPointCursorController != null) {
            this.mInsertionPointCursorController.hide();
        }
    }

    private void hideSpanControllers() {
        if (this.mSpanController != null) {
            this.mSpanController.hide();
        }
    }

    private boolean isCursorInsideEasyCorrectionSpan() {
        SuggestionSpan[] suggestionSpanArr = (SuggestionSpan[]) ((Spannable) this.mTextView.getText()).getSpans(this.mTextView.getSelectionStart(), this.mTextView.getSelectionEnd(), SuggestionSpan.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= suggestionSpanArr.length) {
                return false;
            }
            if ((suggestionSpanArr[i2].getFlags() & 1) != 0) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCursorInsideSuggestionSpan() {
        CharSequence text = this.mTextView.getText();
        return (text instanceof Spannable) && ((SuggestionSpan[]) ((Spannable) text).getSpans(this.mTextView.getSelectionStart(), this.mTextView.getSelectionEnd(), SuggestionSpan.class)).length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOffsetVisible(int i) {
        Layout layout = this.mTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineBottom = layout.getLineBottom(layout.getLineForOffset(i));
        return isPositionVisible(this.mTextView.viewportToContentHorizontalOffset() + ((int) layout.getPrimaryHorizontal(i)), this.mTextView.viewportToContentVerticalOffset() + lineBottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPositionOnText(float f, float f2) {
        Layout layout = this.mTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineAtCoordinate = this.mTextView.getLineAtCoordinate(f2);
        float convertToLocalHorizontalCoordinate = this.mTextView.convertToLocalHorizontalCoordinate(f);
        return convertToLocalHorizontalCoordinate >= layout.getLineLeft(lineAtCoordinate) && convertToLocalHorizontalCoordinate <= layout.getLineRight(lineAtCoordinate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [android.view.View] */
    public boolean isPositionVisible(float f, float f2) {
        synchronized (TEMP_POSITION) {
            float[] fArr = TEMP_POSITION;
            fArr[0] = f;
            fArr[1] = f2;
            TextView textView = this.mTextView;
            while (textView != null) {
                if (textView != this.mTextView) {
                    fArr[0] = fArr[0] - textView.getScrollX();
                    fArr[1] = fArr[1] - textView.getScrollY();
                }
                if (fArr[0] < 0.0f || fArr[1] < 0.0f || fArr[0] > textView.getWidth() || fArr[1] > textView.getHeight()) {
                    return false;
                }
                if (!textView.getMatrix().isIdentity()) {
                    textView.getMatrix().mapPoints(fArr);
                }
                fArr[0] = fArr[0] + textView.getLeft();
                fArr[1] = fArr[1] + textView.getTop();
                ViewParent parent = textView.getParent();
                textView = parent instanceof View ? (View) parent : null;
            }
            return true;
        }
    }

    private void resumeBlink() {
        if (this.mBlink != null) {
            this.mBlink.uncancel();
            makeBlink();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0136, code lost:
        if (r0 == r0) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean selectCurrentWord() {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.Editor.selectCurrentWord():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateSelection() {
        InputMethodManager peekInstance;
        if (this.mInputMethodState == null || this.mInputMethodState.mBatchEditNesting > 0 || (peekInstance = InputMethodManager.peekInstance()) == null) {
            return;
        }
        int selectionStart = this.mTextView.getSelectionStart();
        int selectionEnd = this.mTextView.getSelectionEnd();
        int i = -1;
        int i2 = -1;
        if (this.mTextView.getText() instanceof Spannable) {
            Spannable spannable = (Spannable) this.mTextView.getText();
            i = EditableInputConnection.getComposingSpanStart(spannable);
            i2 = EditableInputConnection.getComposingSpanEnd(spannable);
        }
        peekInstance.updateSelection(this.mTextView, selectionStart, selectionEnd, i, i2);
    }

    private void setErrorIcon(Drawable drawable) {
        TextView.Drawables drawables = this.mTextView.mDrawables;
        TextView.Drawables drawables2 = drawables;
        if (drawables == null) {
            TextView textView = this.mTextView;
            drawables2 = new TextView.Drawables(this.mTextView.getContext());
            textView.mDrawables = drawables2;
        }
        drawables2.setErrorDrawable(drawable, this.mTextView);
        this.mTextView.resetResolvedDrawables();
        this.mTextView.invalidate();
        this.mTextView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldBlink() {
        int selectionStart;
        int selectionEnd;
        return isCursorVisible() && this.mTextView.isFocused() && (selectionStart = this.mTextView.getSelectionStart()) >= 0 && (selectionEnd = this.mTextView.getSelectionEnd()) >= 0 && selectionStart == selectionEnd;
    }

    private void showError() {
        if (this.mTextView.getWindowToken() == null) {
            this.mShowErrorAfterAttach = true;
            return;
        }
        if (this.mErrorPopup == null) {
            TextView textView = (TextView) LayoutInflater.from(this.mTextView.getContext()).inflate(R.layout.textview_hint, (ViewGroup) null);
            float f = this.mTextView.getResources().getDisplayMetrics().density;
            this.mErrorPopup = new ErrorPopup(textView, (int) ((200.0f * f) + 0.5f), (int) ((50.0f * f) + 0.5f));
            this.mErrorPopup.setFocusable(false);
            this.mErrorPopup.setInputMethodMode(1);
        }
        TextView textView2 = (TextView) this.mErrorPopup.getContentView();
        chooseSize(this.mErrorPopup, this.mError, textView2);
        textView2.setText(this.mError);
        this.mErrorPopup.showAsDropDown(this.mTextView, getErrorX(), getErrorY());
        this.mErrorPopup.fixDirection(this.mErrorPopup.isAboveAnchor());
    }

    private void suspendBlink() {
        if (this.mBlink != null) {
            this.mBlink.cancel();
        }
    }

    private boolean touchPositionIsInSelection() {
        int selectionStart = this.mTextView.getSelectionStart();
        int selectionEnd = this.mTextView.getSelectionEnd();
        if (selectionStart == selectionEnd) {
            return false;
        }
        int i = selectionEnd;
        int i2 = selectionStart;
        if (selectionStart > selectionEnd) {
            i2 = selectionEnd;
            i = selectionStart;
            Selection.setSelection((Spannable) this.mTextView.getText(), i2, i);
        }
        SelectionModifierCursorController selectionController = getSelectionController();
        return selectionController.getMinTouchOffset() >= i2 && selectionController.getMaxTouchOffset() < i;
    }

    private void updateCursorPosition(int i, int i2, int i3, float f) {
        if (this.mCursorDrawable[i] == null) {
            this.mCursorDrawable[i] = this.mTextView.getContext().getDrawable(this.mTextView.mCursorDrawableRes);
        }
        if (this.mTempRect == null) {
            this.mTempRect = new Rect();
        }
        this.mCursorDrawable[i].getPadding(this.mTempRect);
        int intrinsicWidth = this.mCursorDrawable[i].getIntrinsicWidth();
        int max = ((int) Math.max(0.5f, f - 0.5f)) - this.mTempRect.left;
        this.mCursorDrawable[i].setBounds(max, i2 - this.mTempRect.top, max + intrinsicWidth, this.mTempRect.bottom + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpellCheckSpans(int i, int i2, boolean z) {
        this.mTextView.removeAdjacentSuggestionSpans(i);
        this.mTextView.removeAdjacentSuggestionSpans(i2);
        if (this.mTextView.isTextEditable() && this.mTextView.isSuggestionsEnabled() && !(this.mTextView instanceof ExtractEditText)) {
            if (this.mSpellChecker == null && z) {
                this.mSpellChecker = new SpellChecker(this.mTextView);
            }
            if (this.mSpellChecker != null) {
                this.mSpellChecker.spellCheck(i, i2);
            }
        }
    }

    public void addSpanWatchers(Spannable spannable) {
        int length = spannable.length();
        if (this.mKeyListener != null) {
            spannable.setSpan(this.mKeyListener, 0, length, 18);
        }
        if (this.mSpanController == null) {
            this.mSpanController = new SpanController();
        }
        spannable.setSpan(this.mSpanController, 0, length, 18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustInputType(boolean z, boolean z2, boolean z3, boolean z4) {
        if ((this.mInputType & 15) != 1) {
            if ((this.mInputType & 15) == 2 && z4) {
                this.mInputType = (this.mInputType & (-4081)) | 16;
                return;
            }
            return;
        }
        if (z || z2) {
            this.mInputType = (this.mInputType & (-4081)) | 128;
        }
        if (z3) {
            this.mInputType = (this.mInputType & (-4081)) | 224;
        }
    }

    boolean areSuggestionsShown() {
        return this.mSuggestionsPopupWindow != null && this.mSuggestionsPopupWindow.isShowing();
    }

    public void beginBatchEdit() {
        this.mInBatchEditControllers = true;
        InputMethodState inputMethodState = this.mInputMethodState;
        if (inputMethodState != null) {
            int i = inputMethodState.mBatchEditNesting + 1;
            inputMethodState.mBatchEditNesting = i;
            if (i == 1) {
                inputMethodState.mCursorChanged = false;
                inputMethodState.mChangedDelta = 0;
                if (inputMethodState.mContentChanged) {
                    inputMethodState.mChangedStart = 0;
                    inputMethodState.mChangedEnd = this.mTextView.getText().length();
                } else {
                    inputMethodState.mChangedStart = -1;
                    inputMethodState.mChangedEnd = -1;
                    inputMethodState.mContentChanged = false;
                }
                this.mTextView.onBeginBatchEdit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createInputContentTypeIfNeeded() {
        if (this.mInputContentType == null) {
            this.mInputContentType = new InputContentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createInputMethodStateIfNeeded() {
        if (this.mInputMethodState == null) {
            this.mInputMethodState = new InputMethodState();
        }
    }

    public void endBatchEdit() {
        this.mInBatchEditControllers = false;
        InputMethodState inputMethodState = this.mInputMethodState;
        if (inputMethodState != null) {
            int i = inputMethodState.mBatchEditNesting - 1;
            inputMethodState.mBatchEditNesting = i;
            if (i == 0) {
                finishBatchEdit(inputMethodState);
            }
        }
    }

    void ensureEndedBatchEdit() {
        InputMethodState inputMethodState = this.mInputMethodState;
        if (inputMethodState == null || inputMethodState.mBatchEditNesting == 0) {
            return;
        }
        inputMethodState.mBatchEditNesting = 0;
        finishBatchEdit(inputMethodState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean extractText(ExtractedTextRequest extractedTextRequest, ExtractedText extractedText) {
        return extractTextInternal(extractedTextRequest, -1, -1, -1, extractedText);
    }

    void finishBatchEdit(InputMethodState inputMethodState) {
        this.mTextView.onEndBatchEdit();
        if (inputMethodState.mContentChanged || inputMethodState.mSelectionModeChanged) {
            this.mTextView.updateAfterEdit();
            reportExtractedText();
        } else if (inputMethodState.mCursorChanged) {
            this.mTextView.invalidateCursor();
        }
        sendUpdateSelection();
    }

    InsertionPointCursorController getInsertionController() {
        if (this.mInsertionControllerEnabled) {
            if (this.mInsertionPointCursorController == null) {
                this.mInsertionPointCursorController = new InsertionPointCursorController();
                this.mTextView.getViewTreeObserver().addOnTouchModeChangeListener(this.mInsertionPointCursorController);
            }
            return this.mInsertionPointCursorController;
        }
        return null;
    }

    SelectionModifierCursorController getSelectionController() {
        if (this.mSelectionControllerEnabled) {
            if (this.mSelectionModifierCursorController == null) {
                this.mSelectionModifierCursorController = new SelectionModifierCursorController();
                this.mTextView.getViewTreeObserver().addOnTouchModeChangeListener(this.mSelectionModifierCursorController);
            }
            return this.mSelectionModifierCursorController;
        }
        return null;
    }

    public WordIterator getWordIterator() {
        if (this.mWordIterator == null) {
            this.mWordIterator = new WordIterator(this.mTextView.getTextServicesLocale());
        }
        return this.mWordIterator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasInsertionController() {
        return this.mInsertionControllerEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSelectionController() {
        return this.mSelectionControllerEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateTextDisplayList() {
        if (this.mTextDisplayLists == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTextDisplayLists.length) {
                return;
            }
            if (this.mTextDisplayLists[i2] != null) {
                this.mTextDisplayLists[i2].isDirty = true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateTextDisplayList(Layout layout, int i, int i2) {
        int i3;
        if (this.mTextDisplayLists == null || !(layout instanceof DynamicLayout)) {
            return;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int lineForOffset2 = layout.getLineForOffset(i2);
        DynamicLayout dynamicLayout = (DynamicLayout) layout;
        int[] blockEndLines = dynamicLayout.getBlockEndLines();
        int[] blockIndices = dynamicLayout.getBlockIndices();
        int numberOfBlocks = dynamicLayout.getNumberOfBlocks();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i3 = i5;
            if (i5 >= numberOfBlocks) {
                break;
            } else if (blockEndLines[i5] >= lineForOffset) {
                i3 = i5;
                break;
            } else {
                i4 = i5 + 1;
            }
        }
        while (i3 < numberOfBlocks) {
            int i6 = blockIndices[i3];
            if (i6 != -1) {
                this.mTextDisplayLists[i6].isDirty = true;
            }
            if (blockEndLines[i3] >= lineForOffset2) {
                return;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCursorVisible() {
        return this.mCursorVisible && this.mTextView.isTextEditable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makeBlink() {
        if (!shouldBlink()) {
            if (this.mBlink != null) {
                this.mBlink.removeCallbacks(this.mBlink);
                return;
            }
            return;
        }
        this.mShowCursor = SystemClock.uptimeMillis();
        if (this.mBlink == null) {
            this.mBlink = new Blink();
        }
        this.mBlink.removeCallbacks(this.mBlink);
        this.mBlink.postAtTime(this.mBlink, this.mShowCursor + 500);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        if (this.mShowErrorAfterAttach) {
            showError();
            this.mShowErrorAfterAttach = false;
        }
        this.mTemporaryDetach = false;
        ViewTreeObserver viewTreeObserver = this.mTextView.getViewTreeObserver();
        if (this.mInsertionPointCursorController != null) {
            viewTreeObserver.addOnTouchModeChangeListener(this.mInsertionPointCursorController);
        }
        if (this.mSelectionModifierCursorController != null) {
            this.mSelectionModifierCursorController.resetTouchOffsets();
            viewTreeObserver.addOnTouchModeChangeListener(this.mSelectionModifierCursorController);
        }
        updateSpellCheckSpans(0, this.mTextView.getText().length(), true);
        if (this.mTextView.hasTransientState() && this.mTextView.getSelectionStart() != this.mTextView.getSelectionEnd()) {
            this.mTextView.setHasTransientState(false);
            startSelectionActionMode();
        }
        getPositionListener().addSubscriber(this.mCursorAnchorInfoNotifier, true);
        resumeBlink();
    }

    public void onCommitCorrection(CorrectionInfo correctionInfo) {
        if (this.mCorrectionHighlighter == null) {
            this.mCorrectionHighlighter = new CorrectionHighlighter();
        } else {
            this.mCorrectionHighlighter.invalidate(false);
        }
        this.mCorrectionHighlighter.highlight(correctionInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        getPositionListener().removeSubscriber(this.mCursorAnchorInfoNotifier);
        if (this.mError != null) {
            hideError();
        }
        suspendBlink();
        if (this.mInsertionPointCursorController != null) {
            this.mInsertionPointCursorController.onDetached();
        }
        if (this.mSelectionModifierCursorController != null) {
            this.mSelectionModifierCursorController.onDetached();
        }
        if (this.mShowSuggestionRunnable != null) {
            this.mTextView.removeCallbacks(this.mShowSuggestionRunnable);
        }
        destroyDisplayListsData();
        if (this.mSpellChecker != null) {
            this.mSpellChecker.closeSession();
            this.mSpellChecker = null;
        }
        this.mPreserveDetachedSelection = true;
        hideControllers();
        this.mPreserveDetachedSelection = false;
        this.mTemporaryDetach = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDraw(Canvas canvas, Layout layout, Path path, Paint paint, int i) {
        InputMethodManager peekInstance;
        int selectionStart = this.mTextView.getSelectionStart();
        int selectionEnd = this.mTextView.getSelectionEnd();
        InputMethodState inputMethodState = this.mInputMethodState;
        if (inputMethodState != null && inputMethodState.mBatchEditNesting == 0 && (peekInstance = InputMethodManager.peekInstance()) != null && peekInstance.isActive(this.mTextView) && (inputMethodState.mContentChanged || inputMethodState.mSelectionModeChanged)) {
            reportExtractedText();
        }
        if (this.mCorrectionHighlighter != null) {
            this.mCorrectionHighlighter.draw(canvas, i);
        }
        Path path2 = path;
        if (path != null) {
            path2 = path;
            if (selectionStart == selectionEnd) {
                path2 = path;
                if (this.mCursorCount > 0) {
                    drawCursor(canvas, i);
                    path2 = null;
                }
            }
        }
        if (this.mTextView.canHaveDisplayList() && canvas.isHardwareAccelerated()) {
            drawHardwareAccelerated(canvas, layout, path2, paint, i);
        } else {
            layout.draw(canvas, path2, paint, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDrop(DragEvent dragEvent) {
        StringBuilder sb = new StringBuilder("");
        ClipData clipData = dragEvent.getClipData();
        int itemCount = clipData.getItemCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= itemCount) {
                break;
            }
            sb.append(clipData.getItemAt(i2).coerceToStyledText(this.mTextView.getContext()));
            i = i2 + 1;
        }
        int offsetForPosition = this.mTextView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        Object localState = dragEvent.getLocalState();
        DragLocalState dragLocalState = null;
        if (localState instanceof DragLocalState) {
            dragLocalState = (DragLocalState) localState;
        }
        boolean z = dragLocalState != null && dragLocalState.sourceTextView == this.mTextView;
        if (!z || offsetForPosition < dragLocalState.start || offsetForPosition >= dragLocalState.end) {
            int length = this.mTextView.getText().length();
            Selection.setSelection((Spannable) this.mTextView.getText(), offsetForPosition);
            this.mTextView.replaceText_internal(offsetForPosition, offsetForPosition, sb);
            if (z) {
                int i3 = dragLocalState.start;
                int i4 = dragLocalState.end;
                int i5 = i4;
                int i6 = i3;
                if (offsetForPosition <= i3) {
                    int length2 = this.mTextView.getText().length() - length;
                    i6 = i3 + length2;
                    i5 = i4 + length2;
                }
                this.mTextView.deleteText_internal(i6, i5);
                int max = Math.max(0, i6 - 1);
                int min = Math.min(this.mTextView.getText().length(), i6 + 1);
                if (min > max + 1) {
                    CharSequence transformedText = this.mTextView.getTransformedText(max, min);
                    if (Character.isSpaceChar(transformedText.charAt(0)) && Character.isSpaceChar(transformedText.charAt(1))) {
                        this.mTextView.deleteText_internal(max, max + 1);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFocusChanged(boolean z, int i) {
        this.mShowCursor = SystemClock.uptimeMillis();
        ensureEndedBatchEdit();
        if (!z) {
            if (this.mError != null) {
                hideError();
            }
            this.mTextView.onEndBatchEdit();
            if (this.mTextView instanceof ExtractEditText) {
                int selectionStart = this.mTextView.getSelectionStart();
                int selectionEnd = this.mTextView.getSelectionEnd();
                hideControllers();
                Selection.setSelection((Spannable) this.mTextView.getText(), selectionStart, selectionEnd);
            } else {
                if (this.mTemporaryDetach) {
                    this.mPreserveDetachedSelection = true;
                }
                hideControllers();
                if (this.mTemporaryDetach) {
                    this.mPreserveDetachedSelection = false;
                }
                downgradeEasyCorrectionSpans();
            }
            if (this.mSelectionModifierCursorController != null) {
                this.mSelectionModifierCursorController.resetTouchOffsets();
                return;
            }
            return;
        }
        int selectionStart2 = this.mTextView.getSelectionStart();
        int selectionEnd2 = this.mTextView.getSelectionEnd();
        this.mCreatedWithASelection = this.mFrozenWithFocus && this.mTextView.hasSelection() && !(this.mSelectAllOnFocus && selectionStart2 == 0 && selectionEnd2 == this.mTextView.getText().length());
        if (!this.mFrozenWithFocus || selectionStart2 < 0 || selectionEnd2 < 0) {
            int lastTapPosition = getLastTapPosition();
            if (lastTapPosition >= 0) {
                Selection.setSelection((Spannable) this.mTextView.getText(), lastTapPosition);
            }
            MovementMethod movementMethod = this.mTextView.getMovementMethod();
            if (movementMethod != null) {
                movementMethod.onTakeFocus(this.mTextView, (Spannable) this.mTextView.getText(), i);
            }
            if (((this.mTextView instanceof ExtractEditText) || this.mSelectionMoved) && selectionStart2 >= 0 && selectionEnd2 >= 0) {
                Selection.setSelection((Spannable) this.mTextView.getText(), selectionStart2, selectionEnd2);
            }
            if (this.mSelectAllOnFocus) {
                this.mTextView.selectAllText();
            }
            this.mTouchFocusSelected = true;
        }
        this.mFrozenWithFocus = false;
        this.mSelectionMoved = false;
        if (this.mError != null) {
            showError();
        }
        makeBlink();
    }

    void onLocaleChanged() {
        this.mWordIterator = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScreenStateChanged(int i) {
        switch (i) {
            case 0:
                suspendBlink();
                return;
            case 1:
                resumeBlink();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScrollChanged() {
        if (this.mPositionListener != null) {
            this.mPositionListener.onScrollChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTouchEvent(MotionEvent motionEvent) {
        if (hasSelectionController()) {
            getSelectionController().onTouchEvent(motionEvent);
        }
        if (this.mShowSuggestionRunnable != null) {
            this.mTextView.removeCallbacks(this.mShowSuggestionRunnable);
            this.mShowSuggestionRunnable = null;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.mLastDownPositionX = motionEvent.getX();
            this.mLastDownPositionY = motionEvent.getY();
            this.mTouchFocusSelected = false;
            this.mIgnoreActionUpEvent = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTouchUpEvent(MotionEvent motionEvent) {
        boolean z = this.mSelectAllOnFocus && this.mTextView.didTouchFocusSelect();
        hideControllers();
        CharSequence text = this.mTextView.getText();
        if (z || text.length() <= 0) {
            return;
        }
        Selection.setSelection((Spannable) text, this.mTextView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY()));
        if (this.mSpellChecker != null) {
            this.mSpellChecker.onSelectionChanged();
        }
        if (extractedTextModeWillBeStarted()) {
            return;
        }
        if (isCursorInsideEasyCorrectionSpan()) {
            this.mShowSuggestionRunnable = new Runnable() { // from class: android.widget.Editor.1
                @Override // java.lang.Runnable
                public void run() {
                    Editor.this.showSuggestions();
                }
            };
            this.mTextView.postDelayed(this.mShowSuggestionRunnable, ViewConfiguration.getDoubleTapTimeout());
        } else if (hasInsertionController()) {
            getInsertionController().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            if (this.mBlink != null) {
                this.mBlink.uncancel();
                makeBlink();
                return;
            }
            return;
        }
        if (this.mBlink != null) {
            this.mBlink.cancel();
        }
        if (this.mInputContentType != null) {
            this.mInputContentType.enterDown = false;
        }
        hideControllers();
        if (this.mSuggestionsPopupWindow != null) {
            this.mSuggestionsPopupWindow.onParentLostFocus();
        }
        ensureEndedBatchEdit();
    }

    public boolean performLongClick(boolean z) {
        boolean z2 = z;
        if (!z) {
            z2 = z;
            if (!isPositionOnText(this.mLastDownPositionX, this.mLastDownPositionY)) {
                z2 = z;
                if (this.mInsertionControllerEnabled) {
                    int offsetForPosition = this.mTextView.getOffsetForPosition(this.mLastDownPositionX, this.mLastDownPositionY);
                    stopSelectionActionMode();
                    Selection.setSelection((Spannable) this.mTextView.getText(), offsetForPosition);
                    getInsertionController().showWithActionPopup();
                    z2 = true;
                }
            }
        }
        boolean z3 = z2;
        if (!z2) {
            z3 = z2;
            if (this.mSelectionActionMode != null) {
                if (touchPositionIsInSelection()) {
                    int selectionStart = this.mTextView.getSelectionStart();
                    int selectionEnd = this.mTextView.getSelectionEnd();
                    CharSequence transformedText = this.mTextView.getTransformedText(selectionStart, selectionEnd);
                    this.mTextView.startDrag(ClipData.newPlainText(null, transformedText), getTextThumbnailBuilder(transformedText), new DragLocalState(this.mTextView, selectionStart, selectionEnd), 0);
                    stopSelectionActionMode();
                } else {
                    getSelectionController().hide();
                    selectCurrentWord();
                    getSelectionController().show();
                }
                z3 = true;
            }
        }
        boolean z4 = z3;
        if (!z3) {
            z4 = startSelectionActionMode();
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepareCursorControllers() {
        boolean z = false;
        ViewGroup.LayoutParams layoutParams = this.mTextView.getRootView().getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
            z = layoutParams2.type < 1000 || layoutParams2.type > 1999;
        }
        boolean z2 = z && this.mTextView.getLayout() != null;
        this.mInsertionControllerEnabled = z2 && isCursorVisible();
        this.mSelectionControllerEnabled = z2 && this.mTextView.textCanBeSelected();
        if (!this.mInsertionControllerEnabled) {
            hideInsertionPointCursorController();
            if (this.mInsertionPointCursorController != null) {
                this.mInsertionPointCursorController.onDetached();
                this.mInsertionPointCursorController = null;
            }
        }
        if (this.mSelectionControllerEnabled) {
            return;
        }
        stopSelectionActionMode();
        if (this.mSelectionModifierCursorController != null) {
            this.mSelectionModifierCursorController.onDetached();
            this.mSelectionModifierCursorController = null;
        }
    }

    boolean reportExtractedText() {
        InputMethodManager peekInstance;
        InputMethodState inputMethodState = this.mInputMethodState;
        if (inputMethodState != null) {
            boolean z = inputMethodState.mContentChanged;
            if (z || inputMethodState.mSelectionModeChanged) {
                inputMethodState.mContentChanged = false;
                inputMethodState.mSelectionModeChanged = false;
                ExtractedTextRequest extractedTextRequest = inputMethodState.mExtractedTextRequest;
                if (extractedTextRequest == null || (peekInstance = InputMethodManager.peekInstance()) == null) {
                    return false;
                }
                if (inputMethodState.mChangedStart < 0 && !z) {
                    inputMethodState.mChangedStart = -2;
                }
                if (extractTextInternal(extractedTextRequest, inputMethodState.mChangedStart, inputMethodState.mChangedEnd, inputMethodState.mChangedDelta, inputMethodState.mExtractedText)) {
                    peekInstance.updateExtractedText(this.mTextView, extractedTextRequest.token, inputMethodState.mExtractedText);
                    inputMethodState.mChangedStart = -1;
                    inputMethodState.mChangedEnd = -1;
                    inputMethodState.mChangedDelta = 0;
                    inputMethodState.mContentChanged = false;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendOnTextChanged(int i, int i2) {
        updateSpellCheckSpans(i, i + i2, false);
        hideCursorControllers();
    }

    public void setError(CharSequence charSequence, Drawable drawable) {
        this.mError = TextUtils.stringOrSpannedString(charSequence);
        this.mErrorWasChanged = true;
        if (this.mError != null) {
            setErrorIcon(drawable);
            if (this.mTextView.isFocused()) {
                showError();
                return;
            }
            return;
        }
        setErrorIcon(null);
        if (this.mErrorPopup != null) {
            if (this.mErrorPopup.isShowing()) {
                this.mErrorPopup.dismiss();
            }
            this.mErrorPopup = null;
        }
        this.mShowErrorAfterAttach = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFrame() {
        if (this.mErrorPopup != null) {
            chooseSize(this.mErrorPopup, this.mError, (TextView) this.mErrorPopup.getContentView());
            this.mErrorPopup.update(this.mTextView, getErrorX(), getErrorY(), this.mErrorPopup.getWidth(), this.mErrorPopup.getHeight());
        }
    }

    void showSuggestions() {
        if (this.mSuggestionsPopupWindow == null) {
            this.mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        }
        hideControllers();
        this.mSuggestionsPopupWindow.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startSelectionActionMode() {
        boolean z;
        if (this.mSelectionActionMode != null) {
            z = false;
        } else if (!canSelectText() || !this.mTextView.requestFocus()) {
            Log.w("TextView", "TextView does not support text selection. Action mode cancelled.");
            return false;
        } else if (!this.mTextView.hasSelection() && !selectCurrentWord()) {
            return false;
        } else {
            boolean extractedTextModeWillBeStarted = extractedTextModeWillBeStarted();
            if (!extractedTextModeWillBeStarted) {
                this.mSelectionActionMode = this.mTextView.startActionMode(new SelectionActionModeCallback());
            }
            boolean z2 = this.mSelectionActionMode != null || extractedTextModeWillBeStarted;
            z = z2;
            if (z2) {
                z = z2;
                if (!this.mTextView.isTextSelectable()) {
                    z = z2;
                    if (this.mShowSoftInputOnFocus) {
                        InputMethodManager peekInstance = InputMethodManager.peekInstance();
                        z = z2;
                        if (peekInstance != null) {
                            peekInstance.showSoftInput(this.mTextView, 0, null);
                            return z2;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopSelectionActionMode() {
        if (this.mSelectionActionMode != null) {
            this.mSelectionActionMode.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateCursorsPositions() {
        if (this.mTextView.mCursorDrawableRes == 0) {
            this.mCursorCount = 0;
            return;
        }
        Layout layout = this.mTextView.getLayout();
        Layout hintLayout = this.mTextView.getHintLayout();
        int selectionStart = this.mTextView.getSelectionStart();
        int lineForOffset = layout.getLineForOffset(selectionStart);
        int lineTop = layout.getLineTop(lineForOffset);
        int lineTop2 = layout.getLineTop(lineForOffset + 1);
        this.mCursorCount = layout.isLevelBoundary(selectionStart) ? 2 : 1;
        int i = lineTop2;
        if (this.mCursorCount == 2) {
            i = (lineTop + lineTop2) >> 1;
        }
        boolean shouldClampCursor = layout.shouldClampCursor(lineForOffset);
        updateCursorPosition(0, lineTop, i, getPrimaryHorizontal(layout, hintLayout, selectionStart, shouldClampCursor));
        if (this.mCursorCount == 2) {
            updateCursorPosition(1, i, lineTop2, layout.getSecondaryHorizontal(selectionStart, shouldClampCursor));
        }
    }
}

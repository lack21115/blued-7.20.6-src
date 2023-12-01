package android.inputmethodservice;

import android.R;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Region;
import android.inputmethodservice.AbstractInputMethodService;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/InputMethodService.class */
public class InputMethodService extends AbstractInputMethodService {
    public static final int BACK_DISPOSITION_DEFAULT = 0;
    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
    static final boolean DEBUG = false;
    public static final int IME_ACTIVE = 1;
    public static final int IME_VISIBLE = 2;
    static final int MOVEMENT_DOWN = -1;
    static final int MOVEMENT_UP = -2;
    static final String TAG = "InputMethodService";
    private static final int VOLUME_CURSOR_OFF = 0;
    private static final int VOLUME_CURSOR_ON = 1;
    private static final int VOLUME_CURSOR_ON_REVERSE = 2;
    int mBackDisposition;
    FrameLayout mCandidatesFrame;
    boolean mCandidatesViewStarted;
    int mCandidatesVisibility;
    CompletionInfo[] mCurCompletions;
    ViewGroup mExtractAccessories;
    Button mExtractAction;
    ExtractEditText mExtractEditText;
    FrameLayout mExtractFrame;
    View mExtractView;
    boolean mExtractViewHidden;
    ExtractedText mExtractedText;
    int mExtractedToken;
    boolean mFullscreenApplied;
    ViewGroup mFullscreenArea;
    InputMethodManager mImm;
    boolean mInShowWindow;
    LayoutInflater mInflater;
    boolean mInitialized;
    InputBinding mInputBinding;
    InputConnection mInputConnection;
    EditorInfo mInputEditorInfo;
    FrameLayout mInputFrame;
    boolean mInputStarted;
    View mInputView;
    boolean mInputViewStarted;
    boolean mIsFullscreen;
    boolean mIsInputViewShown;
    boolean mLastShowInputRequested;
    View mRootView;
    int mShowInputFlags;
    boolean mShowInputForced;
    boolean mShowInputRequested;
    InputConnection mStartedInputConnection;
    int mStatusIcon;
    TypedArray mThemeAttrs;
    IBinder mToken;
    int mVolumeKeyCursorControl;
    SoftInputWindow mWindow;
    boolean mWindowAdded;
    boolean mWindowCreated;
    boolean mWindowVisible;
    boolean mWindowWasVisible;
    int mTheme = 0;
    boolean mHardwareAccelerated = false;
    final Insets mTmpInsets = new Insets();
    final int[] mTmpLocation = new int[2];
    final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() { // from class: android.inputmethodservice.InputMethodService.1
        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
            if (!InputMethodService.this.isExtractViewShown()) {
                InputMethodService.this.onComputeInsets(InputMethodService.this.mTmpInsets);
                internalInsetsInfo.contentInsets.top = InputMethodService.this.mTmpInsets.contentTopInsets;
                internalInsetsInfo.visibleInsets.top = InputMethodService.this.mTmpInsets.visibleTopInsets;
                internalInsetsInfo.touchableRegion.set(InputMethodService.this.mTmpInsets.touchableRegion);
                internalInsetsInfo.setTouchableInsets(InputMethodService.this.mTmpInsets.touchableInsets);
                return;
            }
            View decorView = InputMethodService.this.getWindow().getWindow().getDecorView();
            Rect rect = internalInsetsInfo.contentInsets;
            Rect rect2 = internalInsetsInfo.visibleInsets;
            int height = decorView.getHeight();
            rect2.top = height;
            rect.top = height;
            internalInsetsInfo.touchableRegion.setEmpty();
            internalInsetsInfo.setTouchableInsets(0);
        }
    };
    final View.OnClickListener mActionClickListener = new View.OnClickListener() { // from class: android.inputmethodservice.InputMethodService.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditorInfo currentInputEditorInfo = InputMethodService.this.getCurrentInputEditorInfo();
            InputConnection currentInputConnection = InputMethodService.this.getCurrentInputConnection();
            if (currentInputEditorInfo == null || currentInputConnection == null) {
                return;
            }
            if (currentInputEditorInfo.actionId != 0) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.actionId);
            } else if ((currentInputEditorInfo.imeOptions & 255) != 1) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.imeOptions & 255);
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/InputMethodService$InputMethodImpl.class */
    public class InputMethodImpl extends AbstractInputMethodService.AbstractInputMethodImpl {
        public InputMethodImpl() {
            super();
        }

        @Override // android.view.inputmethod.InputMethod
        public void attachToken(IBinder iBinder) {
            if (InputMethodService.this.mToken == null) {
                InputMethodService.this.mToken = iBinder;
                InputMethodService.this.mWindow.setToken(iBinder);
            }
        }

        @Override // android.view.inputmethod.InputMethod
        public void bindInput(InputBinding inputBinding) {
            InputMethodService.this.mInputBinding = inputBinding;
            InputMethodService.this.mInputConnection = inputBinding.getConnection();
            InputConnection currentInputConnection = InputMethodService.this.getCurrentInputConnection();
            if (currentInputConnection != null) {
                currentInputConnection.reportFullscreenMode(InputMethodService.this.mIsFullscreen);
            }
            InputMethodService.this.initialize();
            InputMethodService.this.onBindInput();
        }

        @Override // android.view.inputmethod.InputMethod
        public void changeInputMethodSubtype(InputMethodSubtype inputMethodSubtype) {
            InputMethodService.this.onCurrentInputMethodSubtypeChanged(inputMethodSubtype);
        }

        @Override // android.view.inputmethod.InputMethod
        public void hideSoftInput(int i, ResultReceiver resultReceiver) {
            int i2 = 0;
            boolean isInputViewShown = InputMethodService.this.isInputViewShown();
            InputMethodService.this.mShowInputFlags = 0;
            InputMethodService.this.mShowInputRequested = false;
            InputMethodService.this.mShowInputForced = false;
            InputMethodService.this.doHideWindow();
            if (resultReceiver != null) {
                if (isInputViewShown != InputMethodService.this.isInputViewShown()) {
                    i2 = 3;
                } else if (!isInputViewShown) {
                    i2 = 1;
                }
                resultReceiver.send(i2, null);
            }
        }

        @Override // android.view.inputmethod.InputMethod
        public void restartInput(InputConnection inputConnection, EditorInfo editorInfo) {
            InputMethodService.this.doStartInput(inputConnection, editorInfo, true);
        }

        @Override // android.view.inputmethod.InputMethod
        public void showSoftInput(int i, ResultReceiver resultReceiver) {
            boolean isInputViewShown = InputMethodService.this.isInputViewShown();
            InputMethodService.this.mShowInputFlags = 0;
            if (InputMethodService.this.onShowInputRequested(i, false)) {
                try {
                    InputMethodService.this.showWindow(true);
                } catch (WindowManager.BadTokenException e) {
                    InputMethodService.this.mWindowVisible = false;
                    InputMethodService.this.mWindowAdded = false;
                }
            }
            InputMethodService.this.mImm.setImeWindowStatus(InputMethodService.this.mToken, (InputMethodService.this.isInputViewShown() ? 2 : 0) | 1, InputMethodService.this.mBackDisposition);
            if (resultReceiver != null) {
                resultReceiver.send(isInputViewShown != InputMethodService.this.isInputViewShown() ? 2 : isInputViewShown ? 0 : 1, null);
            }
        }

        @Override // android.view.inputmethod.InputMethod
        public void startInput(InputConnection inputConnection, EditorInfo editorInfo) {
            InputMethodService.this.doStartInput(inputConnection, editorInfo, false);
        }

        @Override // android.view.inputmethod.InputMethod
        public void unbindInput() {
            InputMethodService.this.onUnbindInput();
            InputMethodService.this.mInputBinding = null;
            InputMethodService.this.mInputConnection = null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/InputMethodService$InputMethodSessionImpl.class */
    public class InputMethodSessionImpl extends AbstractInputMethodService.AbstractInputMethodSessionImpl {
        public InputMethodSessionImpl() {
            super();
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void appPrivateCommand(String str, Bundle bundle) {
            if (isEnabled()) {
                InputMethodService.this.onAppPrivateCommand(str, bundle);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void displayCompletions(CompletionInfo[] completionInfoArr) {
            if (isEnabled()) {
                InputMethodService.this.mCurCompletions = completionInfoArr;
                InputMethodService.this.onDisplayCompletions(completionInfoArr);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void finishInput() {
            if (isEnabled()) {
                InputMethodService.this.doFinishInput();
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void toggleSoftInput(int i, int i2) {
            InputMethodService.this.onToggleSoftInput(i, i2);
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void updateCursor(Rect rect) {
            if (isEnabled()) {
                InputMethodService.this.onUpdateCursor(rect);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
            if (isEnabled()) {
                InputMethodService.this.onUpdateCursorAnchorInfo(cursorAnchorInfo);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void updateExtractedText(int i, ExtractedText extractedText) {
            if (isEnabled()) {
                InputMethodService.this.onUpdateExtractedText(i, extractedText);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void updateSelection(int i, int i2, int i3, int i4, int i5, int i6) {
            if (isEnabled()) {
                InputMethodService.this.onUpdateSelection(i, i2, i3, i4, i5, i6);
            }
        }

        @Override // android.view.inputmethod.InputMethodSession
        public void viewClicked(boolean z) {
            if (isEnabled()) {
                InputMethodService.this.onViewClicked(z);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/InputMethodService$Insets.class */
    public static final class Insets {
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public int contentTopInsets;
        public int touchableInsets;
        public final Region touchableRegion = new Region();
        public int visibleTopInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHideWindow() {
        this.mImm.setImeWindowStatus(this.mToken, 0, this.mBackDisposition);
        hideWindow();
    }

    private void finishViews() {
        if (this.mInputViewStarted) {
            onFinishInputView(false);
        } else if (this.mCandidatesViewStarted) {
            onFinishCandidatesView(false);
        }
        this.mInputViewStarted = false;
        this.mCandidatesViewStarted = false;
    }

    private boolean handleBack(boolean z) {
        if (!this.mShowInputRequested) {
            if (this.mWindowVisible) {
                if (this.mCandidatesVisibility == 0) {
                    if (z) {
                        setCandidatesViewShown(false);
                        return true;
                    }
                    return true;
                } else if (z) {
                    doHideWindow();
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        if (isExtractViewShown() && (this.mExtractView instanceof ExtractEditLayout)) {
            ExtractEditLayout extractEditLayout = (ExtractEditLayout) this.mExtractView;
            if (extractEditLayout.isActionModeStarted()) {
                if (z) {
                    extractEditLayout.finishActionMode();
                    return true;
                }
                return true;
            }
        }
        if (z) {
            requestHideSelf(0);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onToggleSoftInput(int i, int i2) {
        if (isInputViewShown()) {
            requestHideSelf(i2);
        } else {
            requestShowSelf(i);
        }
    }

    private void requestShowSelf(int i) {
        this.mImm.showSoftInputFromInputMethod(this.mToken, i);
    }

    void doFinishInput() {
        if (this.mInputViewStarted) {
            onFinishInputView(true);
        } else if (this.mCandidatesViewStarted) {
            onFinishCandidatesView(true);
        }
        this.mInputViewStarted = false;
        this.mCandidatesViewStarted = false;
        if (this.mInputStarted) {
            onFinishInput();
        }
        this.mInputStarted = false;
        this.mStartedInputConnection = null;
        this.mCurCompletions = null;
    }

    boolean doMovementKey(int i, KeyEvent keyEvent, int i2) {
        ExtractEditText extractEditText = this.mExtractEditText;
        if (isExtractViewShown() && isInputViewShown() && extractEditText != null) {
            MovementMethod movementMethod = extractEditText.getMovementMethod();
            Layout layout = extractEditText.getLayout();
            if (movementMethod != null && layout != null) {
                if (i2 == -1) {
                    if (movementMethod.onKeyDown(extractEditText, extractEditText.getText(), i, keyEvent)) {
                        reportExtractedMovement(i, 1);
                        return true;
                    }
                } else if (i2 == -2) {
                    if (movementMethod.onKeyUp(extractEditText, extractEditText.getText(), i, keyEvent)) {
                        return true;
                    }
                } else if (movementMethod.onKeyOther(extractEditText, extractEditText.getText(), keyEvent)) {
                    reportExtractedMovement(i, i2);
                } else {
                    KeyEvent changeAction = KeyEvent.changeAction(keyEvent, 0);
                    if (movementMethod.onKeyDown(extractEditText, extractEditText.getText(), i, changeAction)) {
                        KeyEvent changeAction2 = KeyEvent.changeAction(keyEvent, 1);
                        movementMethod.onKeyUp(extractEditText, extractEditText.getText(), i, changeAction2);
                        while (true) {
                            i2--;
                            if (i2 <= 0) {
                                break;
                            }
                            movementMethod.onKeyDown(extractEditText, extractEditText.getText(), i, changeAction);
                            movementMethod.onKeyUp(extractEditText, extractEditText.getText(), i, changeAction2);
                        }
                        reportExtractedMovement(i, i2);
                    }
                }
            }
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    void doStartInput(InputConnection inputConnection, EditorInfo editorInfo, boolean z) {
        if (!z) {
            doFinishInput();
        }
        this.mInputStarted = true;
        this.mStartedInputConnection = inputConnection;
        this.mInputEditorInfo = editorInfo;
        initialize();
        onStartInput(editorInfo, z);
        if (this.mWindowVisible) {
            if (this.mShowInputRequested) {
                this.mInputViewStarted = true;
                onStartInputView(this.mInputEditorInfo, z);
                startExtractingText(true);
            } else if (this.mCandidatesVisibility == 0) {
                this.mCandidatesViewStarted = true;
                onStartCandidatesView(this.mInputEditorInfo, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.inputmethodservice.AbstractInputMethodService, android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        PrintWriterPrinter printWriterPrinter = new PrintWriterPrinter(printWriter);
        printWriterPrinter.println("Input method service state for " + this + ":");
        printWriterPrinter.println("  mWindowCreated=" + this.mWindowCreated + " mWindowAdded=" + this.mWindowAdded);
        printWriterPrinter.println("  mWindowVisible=" + this.mWindowVisible + " mWindowWasVisible=" + this.mWindowWasVisible + " mInShowWindow=" + this.mInShowWindow);
        printWriterPrinter.println("  Configuration=" + getResources().getConfiguration());
        printWriterPrinter.println("  mToken=" + this.mToken);
        printWriterPrinter.println("  mInputBinding=" + this.mInputBinding);
        printWriterPrinter.println("  mInputConnection=" + this.mInputConnection);
        printWriterPrinter.println("  mStartedInputConnection=" + this.mStartedInputConnection);
        printWriterPrinter.println("  mInputStarted=" + this.mInputStarted + " mInputViewStarted=" + this.mInputViewStarted + " mCandidatesViewStarted=" + this.mCandidatesViewStarted);
        if (this.mInputEditorInfo != null) {
            printWriterPrinter.println("  mInputEditorInfo:");
            this.mInputEditorInfo.dump(printWriterPrinter, "    ");
        } else {
            printWriterPrinter.println("  mInputEditorInfo: null");
        }
        printWriterPrinter.println("  mShowInputRequested=" + this.mShowInputRequested + " mLastShowInputRequested=" + this.mLastShowInputRequested + " mShowInputForced=" + this.mShowInputForced + " mShowInputFlags=0x" + Integer.toHexString(this.mShowInputFlags));
        printWriterPrinter.println("  mCandidatesVisibility=" + this.mCandidatesVisibility + " mFullscreenApplied=" + this.mFullscreenApplied + " mIsFullscreen=" + this.mIsFullscreen + " mExtractViewHidden=" + this.mExtractViewHidden);
        if (this.mExtractedText != null) {
            printWriterPrinter.println("  mExtractedText:");
            printWriterPrinter.println("    text=" + this.mExtractedText.text.length() + " chars startOffset=" + this.mExtractedText.startOffset);
            printWriterPrinter.println("    selectionStart=" + this.mExtractedText.selectionStart + " selectionEnd=" + this.mExtractedText.selectionEnd + " flags=0x" + Integer.toHexString(this.mExtractedText.flags));
        } else {
            printWriterPrinter.println("  mExtractedText: null");
        }
        printWriterPrinter.println("  mExtractedToken=" + this.mExtractedToken);
        printWriterPrinter.println("  mIsInputViewShown=" + this.mIsInputViewShown + " mStatusIcon=" + this.mStatusIcon);
        printWriterPrinter.println("Last computed insets:");
        printWriterPrinter.println("  contentTopInsets=" + this.mTmpInsets.contentTopInsets + " visibleTopInsets=" + this.mTmpInsets.visibleTopInsets + " touchableInsets=" + this.mTmpInsets.touchableInsets + " touchableRegion=" + this.mTmpInsets.touchableRegion);
    }

    public boolean enableHardwareAcceleration() {
        if (this.mWindow != null) {
            throw new IllegalStateException("Must be called before onCreate()");
        }
        if (ActivityManager.isHighEndGfx()) {
            this.mHardwareAccelerated = true;
            return true;
        }
        return false;
    }

    public int getBackDisposition() {
        return this.mBackDisposition;
    }

    public int getCandidatesHiddenVisibility() {
        return isExtractViewShown() ? 8 : 4;
    }

    public InputBinding getCurrentInputBinding() {
        return this.mInputBinding;
    }

    public InputConnection getCurrentInputConnection() {
        InputConnection inputConnection = this.mStartedInputConnection;
        return inputConnection != null ? inputConnection : this.mInputConnection;
    }

    public EditorInfo getCurrentInputEditorInfo() {
        return this.mInputEditorInfo;
    }

    public boolean getCurrentInputStarted() {
        return this.mInputStarted;
    }

    public int getInputMethodWindowRecommendedHeight() {
        return this.mImm.getInputMethodWindowVisibleHeight();
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getMaxWidth() {
        return ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    public CharSequence getTextForImeAction(int i) {
        switch (i & 255) {
            case 1:
                return null;
            case 2:
                return getText(17040908);
            case 3:
                return getText(17040909);
            case 4:
                return getText(17040910);
            case 5:
                return getText(17040911);
            case 6:
                return getText(17040912);
            case 7:
                return getText(17040913);
            default:
                return getText(17040914);
        }
    }

    public Dialog getWindow() {
        return this.mWindow;
    }

    public void hideStatusIcon() {
        this.mStatusIcon = 0;
        this.mImm.hideStatusIcon(this.mToken);
    }

    public void hideWindow() {
        finishViews();
        if (this.mWindowVisible) {
            this.mWindow.hide();
            this.mWindowVisible = false;
            onWindowHidden();
            this.mWindowWasVisible = false;
        }
    }

    void initViews() {
        this.mInitialized = false;
        this.mWindowCreated = false;
        this.mShowInputRequested = false;
        this.mShowInputForced = false;
        this.mThemeAttrs = obtainStyledAttributes(R.styleable.InputMethodService);
        this.mRootView = this.mInflater.inflate(17367131, (ViewGroup) null);
        this.mRootView.setSystemUiVisibility(768);
        this.mWindow.setContentView(this.mRootView);
        this.mRootView.getViewTreeObserver().addOnComputeInternalInsetsListener(this.mInsetsComputer);
        if (Settings.Global.getInt(getContentResolver(), Settings.Global.FANCY_IME_ANIMATIONS, 0) != 0) {
            this.mWindow.getWindow().setWindowAnimations(16974562);
        }
        this.mFullscreenArea = (ViewGroup) this.mRootView.findViewById(16909072);
        this.mExtractViewHidden = false;
        this.mExtractFrame = (FrameLayout) this.mRootView.findViewById(R.id.extractArea);
        this.mExtractView = null;
        this.mExtractEditText = null;
        this.mExtractAccessories = null;
        this.mExtractAction = null;
        this.mFullscreenApplied = false;
        this.mCandidatesFrame = (FrameLayout) this.mRootView.findViewById(R.id.candidatesArea);
        this.mInputFrame = (FrameLayout) this.mRootView.findViewById(R.id.inputArea);
        this.mInputView = null;
        this.mIsInputViewShown = false;
        this.mExtractFrame.setVisibility(8);
        this.mCandidatesVisibility = getCandidatesHiddenVisibility();
        this.mCandidatesFrame.setVisibility(this.mCandidatesVisibility);
        this.mInputFrame.setVisibility(8);
    }

    void initialize() {
        if (this.mInitialized) {
            return;
        }
        this.mInitialized = true;
        onInitializeInterface();
    }

    public boolean isExtractViewShown() {
        return this.mIsFullscreen && !this.mExtractViewHidden;
    }

    public boolean isFullscreenMode() {
        return this.mIsFullscreen;
    }

    public boolean isInputViewShown() {
        return this.mIsInputViewShown && this.mWindowVisible;
    }

    public boolean isShowInputRequested() {
        return this.mShowInputRequested;
    }

    public void onAppPrivateCommand(String str, Bundle bundle) {
    }

    public void onBindInput() {
    }

    public void onComputeInsets(Insets insets) {
        int[] iArr = this.mTmpLocation;
        if (this.mInputFrame.getVisibility() == 0) {
            this.mInputFrame.getLocationInWindow(iArr);
        } else {
            iArr[1] = getWindow().getWindow().getDecorView().getHeight();
        }
        if (isFullscreenMode()) {
            insets.contentTopInsets = getWindow().getWindow().getDecorView().getHeight();
        } else {
            insets.contentTopInsets = iArr[1];
        }
        if (this.mCandidatesFrame.getVisibility() == 0) {
            this.mCandidatesFrame.getLocationInWindow(iArr);
        }
        insets.visibleTopInsets = iArr[1];
        insets.touchableInsets = 2;
        insets.touchableRegion.setEmpty();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i = 0;
        super.onConfigurationChanged(configuration);
        boolean z = this.mWindowVisible;
        int i2 = this.mShowInputFlags;
        boolean z2 = this.mShowInputRequested;
        CompletionInfo[] completionInfoArr = this.mCurCompletions;
        initViews();
        this.mInputViewStarted = false;
        this.mCandidatesViewStarted = false;
        if (this.mInputStarted) {
            doStartInput(getCurrentInputConnection(), getCurrentInputEditorInfo(), true);
        }
        if (z) {
            if (z2) {
                if (onShowInputRequested(i2, true)) {
                    showWindow(true);
                    if (completionInfoArr != null) {
                        this.mCurCompletions = completionInfoArr;
                        onDisplayCompletions(completionInfoArr);
                    }
                } else {
                    doHideWindow();
                }
            } else if (this.mCandidatesVisibility == 0) {
                showWindow(false);
            } else {
                doHideWindow();
            }
            boolean onEvaluateInputViewShown = onEvaluateInputViewShown();
            InputMethodManager inputMethodManager = this.mImm;
            IBinder iBinder = this.mToken;
            if (onEvaluateInputViewShown) {
                i = 2;
            }
            inputMethodManager.setImeWindowStatus(iBinder, i | 1, this.mBackDisposition);
        }
    }

    public void onConfigureWindow(Window window, boolean z, boolean z2) {
        int i = this.mWindow.getWindow().getAttributes().height;
        int i2 = z ? -1 : -2;
        if (this.mIsInputViewShown && i != i2) {
            Log.w(TAG, "Window size has been changed. This may cause jankiness of resizing window: " + i + " -> " + i2);
        }
        this.mWindow.getWindow().setLayout(-1, i2);
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mTheme = Resources.selectSystemTheme(this.mTheme, getApplicationInfo().targetSdkVersion, R.style.Theme_InputMethod, R.style.Theme_Holo_InputMethod, R.style.Theme_DeviceDefault_InputMethod, R.style.Theme_DeviceDefault_InputMethod);
        super.setTheme(this.mTheme);
        super.onCreate();
        this.mImm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        this.mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mWindow = new SoftInputWindow(this, "InputMethod", this.mTheme, null, null, this.mDispatcherState, 2011, 80, false);
        if (this.mHardwareAccelerated) {
            this.mWindow.getWindow().addFlags(16777216);
        }
        initViews();
        this.mWindow.getWindow().setLayout(-1, -2);
    }

    public View onCreateCandidatesView() {
        return null;
    }

    public View onCreateExtractTextView() {
        return this.mInflater.inflate(17367132, (ViewGroup) null);
    }

    @Override // android.inputmethodservice.AbstractInputMethodService
    public AbstractInputMethodService.AbstractInputMethodImpl onCreateInputMethodInterface() {
        return new InputMethodImpl();
    }

    @Override // android.inputmethodservice.AbstractInputMethodService
    public AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        return new InputMethodSessionImpl();
    }

    public View onCreateInputView() {
        return null;
    }

    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype inputMethodSubtype) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(this.mInsetsComputer);
        doFinishInput();
        if (this.mWindowAdded) {
            this.mWindow.getWindow().setWindowAnimations(0);
            this.mWindow.dismiss();
        }
    }

    public void onDisplayCompletions(CompletionInfo[] completionInfoArr) {
    }

    public boolean onEvaluateFullscreenMode() {
        if (getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return this.mInputEditorInfo == null || (this.mInputEditorInfo.imeOptions & 33554432) == 0;
    }

    public boolean onEvaluateInputViewShown() {
        Configuration configuration = getResources().getConfiguration();
        return configuration.keyboard == 1 || configuration.hardKeyboardHidden == 2;
    }

    public boolean onExtractTextContextMenuItem(int i) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.performContextMenuAction(i);
            return true;
        }
        return true;
    }

    public void onExtractedCursorMovement(int i, int i2) {
        if (this.mExtractEditText == null || i2 == 0 || !this.mExtractEditText.hasVerticalScrollBar()) {
            return;
        }
        setCandidatesViewShown(false);
    }

    public void onExtractedDeleteText(int i, int i2) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.setSelection(i, i);
            currentInputConnection.deleteSurroundingText(0, i2 - i);
        }
    }

    public void onExtractedReplaceText(int i, int i2, CharSequence charSequence) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.setComposingRegion(i, i2);
            currentInputConnection.commitText(charSequence, 1);
        }
    }

    public void onExtractedSelectionChanged(int i, int i2) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.setSelection(i, i2);
        }
    }

    public void onExtractedSetSpan(Object obj, int i, int i2, int i3) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection == null || !currentInputConnection.setSelection(i, i2)) {
            return;
        }
        CharSequence selectedText = currentInputConnection.getSelectedText(1);
        if (selectedText instanceof Spannable) {
            ((Spannable) selectedText).setSpan(obj, 0, selectedText.length(), i3);
            currentInputConnection.setComposingRegion(i, i2);
            currentInputConnection.commitText(selectedText, 1);
        }
    }

    public void onExtractedTextClicked() {
        if (this.mExtractEditText != null && this.mExtractEditText.hasVerticalScrollBar()) {
            setCandidatesViewShown(false);
        }
    }

    public void onExtractingInputChanged(EditorInfo editorInfo) {
        if (editorInfo.inputType == 0) {
            requestHideSelf(2);
        }
    }

    public void onFinishCandidatesView(boolean z) {
        InputConnection currentInputConnection;
        if (z || (currentInputConnection = getCurrentInputConnection()) == null) {
            return;
        }
        currentInputConnection.finishComposingText();
    }

    public void onFinishInput() {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.finishComposingText();
        }
    }

    public void onFinishInputView(boolean z) {
        InputConnection currentInputConnection;
        if (z || (currentInputConnection = getCurrentInputConnection()) == null) {
            return;
        }
        currentInputConnection.finishComposingText();
    }

    @Override // android.inputmethodservice.AbstractInputMethodService
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onInitializeInterface() {
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            if (handleBack(false)) {
                keyEvent.startTracking();
                return true;
            }
            return false;
        } else if (keyEvent.getKeyCode() == 24) {
            this.mVolumeKeyCursorControl = Settings.System.getInt(getContentResolver(), Settings.System.VOLUME_KEY_CURSOR_CONTROL, 0);
            if (!isInputViewShown() || this.mVolumeKeyCursorControl == 0) {
                return false;
            }
            sendDownUpKeyEvents(this.mVolumeKeyCursorControl == 2 ? 22 : 21);
            return true;
        } else if (keyEvent.getKeyCode() == 25) {
            this.mVolumeKeyCursorControl = Settings.System.getInt(getContentResolver(), Settings.System.VOLUME_KEY_CURSOR_CONTROL, 0);
            if (!isInputViewShown() || this.mVolumeKeyCursorControl == 0) {
                return false;
            }
            sendDownUpKeyEvents(this.mVolumeKeyCursorControl == 2 ? 21 : 22);
            return true;
        } else {
            return doMovementKey(i, keyEvent, -1);
        }
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return doMovementKey(i, keyEvent, i2);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 4 && keyEvent.isTracking() && !keyEvent.isCanceled()) {
            z = handleBack(true);
        } else if (keyEvent.getKeyCode() != 24 && i != 25) {
            return doMovementKey(i, keyEvent, -2);
        } else {
            this.mVolumeKeyCursorControl = Settings.System.getInt(getContentResolver(), Settings.System.VOLUME_KEY_CURSOR_CONTROL, 0);
            if (!isInputViewShown() || this.mVolumeKeyCursorControl == 0) {
                return false;
            }
        }
        return z;
    }

    public boolean onShowInputRequested(int i, boolean z) {
        if (onEvaluateInputViewShown()) {
            if ((i & 1) != 0 || ((z || !onEvaluateFullscreenMode()) && getResources().getConfiguration().keyboard == 1)) {
                if ((i & 2) != 0) {
                    this.mShowInputForced = true;
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void onStartCandidatesView(EditorInfo editorInfo, boolean z) {
    }

    public void onStartInput(EditorInfo editorInfo, boolean z) {
    }

    public void onStartInputView(EditorInfo editorInfo, boolean z) {
    }

    @Override // android.inputmethodservice.AbstractInputMethodService
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onUnbindInput() {
    }

    @Deprecated
    public void onUpdateCursor(Rect rect) {
    }

    public void onUpdateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
    }

    public void onUpdateExtractedText(int i, ExtractedText extractedText) {
        if (this.mExtractedToken != i || extractedText == null || this.mExtractEditText == null) {
            return;
        }
        this.mExtractedText = extractedText;
        this.mExtractEditText.setExtractedText(extractedText);
    }

    public void onUpdateExtractingViews(EditorInfo editorInfo) {
        if (isExtractViewShown() && this.mExtractAccessories != null) {
            boolean z = true;
            if (editorInfo.actionLabel == null) {
                z = ((editorInfo.imeOptions & 255) == 1 || (editorInfo.imeOptions & 536870912) != 0 || editorInfo.inputType == 0) ? false : true;
            }
            if (!z) {
                this.mExtractAccessories.setVisibility(8);
                if (this.mExtractAction != null) {
                    this.mExtractAction.setOnClickListener(null);
                    return;
                }
                return;
            }
            this.mExtractAccessories.setVisibility(0);
            if (this.mExtractAction != null) {
                if (editorInfo.actionLabel != null) {
                    this.mExtractAction.setText(editorInfo.actionLabel);
                } else {
                    this.mExtractAction.setText(getTextForImeAction(editorInfo.imeOptions));
                }
                this.mExtractAction.setOnClickListener(this.mActionClickListener);
            }
        }
    }

    public void onUpdateExtractingVisibility(EditorInfo editorInfo) {
        if (editorInfo.inputType == 0 || (editorInfo.imeOptions & 268435456) != 0) {
            setExtractViewShown(false);
        } else {
            setExtractViewShown(true);
        }
    }

    public void onUpdateSelection(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        ExtractEditText extractEditText = this.mExtractEditText;
        if (extractEditText == null || !isFullscreenMode() || this.mExtractedText == null) {
            return;
        }
        int i9 = this.mExtractedText.startOffset;
        extractEditText.startInternalChanges();
        int i10 = i3 - i9;
        int i11 = i4 - i9;
        int length = extractEditText.getText().length();
        if (i10 < 0) {
            i7 = 0;
        } else {
            i7 = i10;
            if (i10 > length) {
                i7 = length;
            }
        }
        if (i11 < 0) {
            i8 = 0;
        } else {
            i8 = i11;
            if (i11 > length) {
                i8 = length;
            }
        }
        extractEditText.setSelection(i7, i8);
        extractEditText.finishInternalChanges();
    }

    public void onViewClicked(boolean z) {
    }

    public void onWindowHidden() {
    }

    public void onWindowShown() {
    }

    void reportExtractedMovement(int i, int i2) {
        int i3;
        switch (i) {
            case 19:
                i2 = -i2;
                i3 = 0;
                break;
            case 20:
                i3 = 0;
                break;
            case 21:
                i3 = -i2;
                i2 = 0;
                break;
            case 22:
                i3 = i2;
                i2 = 0;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        onExtractedCursorMovement(i3, i2);
    }

    public void requestHideSelf(int i) {
        this.mImm.hideSoftInputFromInputMethod(this.mToken, i);
    }

    public boolean sendDefaultEditorAction(boolean z) {
        EditorInfo currentInputEditorInfo = getCurrentInputEditorInfo();
        if (currentInputEditorInfo != null) {
            if ((!z || (currentInputEditorInfo.imeOptions & 1073741824) == 0) && (currentInputEditorInfo.imeOptions & 255) != 1) {
                InputConnection currentInputConnection = getCurrentInputConnection();
                if (currentInputConnection != null) {
                    currentInputConnection.performEditorAction(currentInputEditorInfo.imeOptions & 255);
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void sendDownUpKeyEvents(int i) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        currentInputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0, 0, -1, 0, 6));
        currentInputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, SystemClock.uptimeMillis(), 1, i, 0, 0, -1, 0, 6));
    }

    public void sendKeyChar(char c2) {
        switch (c2) {
            case '\n':
                if (sendDefaultEditorAction(true)) {
                    return;
                }
                sendDownUpKeyEvents(66);
                return;
            default:
                if (c2 >= '0' && c2 <= '9') {
                    sendDownUpKeyEvents((c2 - '0') + 7);
                    return;
                }
                InputConnection currentInputConnection = getCurrentInputConnection();
                if (currentInputConnection != null) {
                    currentInputConnection.commitText(String.valueOf(c2), 1);
                    return;
                }
                return;
        }
    }

    public void setBackDisposition(int i) {
        this.mBackDisposition = i;
    }

    public void setCandidatesView(View view) {
        this.mCandidatesFrame.removeAllViews();
        this.mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setCandidatesViewShown(boolean z) {
        updateCandidatesVisibility(z);
        if (this.mShowInputRequested || this.mWindowVisible == z) {
            return;
        }
        if (z) {
            showWindow(false);
        } else {
            doHideWindow();
        }
    }

    public void setExtractView(View view) {
        this.mExtractFrame.removeAllViews();
        this.mExtractFrame.addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.mExtractView = view;
        if (view == null) {
            this.mExtractEditText = null;
            this.mExtractAccessories = null;
            this.mExtractAction = null;
            return;
        }
        this.mExtractEditText = (ExtractEditText) view.findViewById(R.id.inputExtractEditText);
        this.mExtractEditText.setIME(this);
        this.mExtractAction = (Button) view.findViewById(16909074);
        if (this.mExtractAction != null) {
            this.mExtractAccessories = (ViewGroup) view.findViewById(16909073);
        }
        startExtractingText(false);
    }

    public void setExtractViewShown(boolean z) {
        if (this.mExtractViewHidden == z) {
            this.mExtractViewHidden = !z;
            updateExtractFrameVisibility();
        }
    }

    public void setInputView(View view) {
        this.mInputFrame.removeAllViews();
        this.mInputFrame.addView(view, new FrameLayout.LayoutParams(-1, -2));
        this.mInputView = view;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mWindow != null) {
            throw new IllegalStateException("Must be called before onCreate()");
        }
        this.mTheme = i;
    }

    public void showStatusIcon(int i) {
        this.mStatusIcon = i;
        this.mImm.showStatusIcon(this.mToken, getPackageName(), i);
    }

    public void showWindow(boolean z) {
        if (this.mInShowWindow) {
            Log.w(TAG, "Re-entrance in to showWindow");
            return;
        }
        try {
            this.mWindowWasVisible = this.mWindowVisible;
            this.mInShowWindow = true;
            showWindowInner(z);
        } finally {
            this.mWindowWasVisible = true;
            this.mInShowWindow = false;
        }
    }

    void showWindowInner(boolean z) {
        boolean z2;
        boolean z3 = this.mWindowVisible;
        this.mWindowVisible = true;
        if (this.mShowInputRequested) {
            z2 = false;
        } else {
            z2 = false;
            if (this.mInputStarted) {
                z2 = false;
                if (z) {
                    z2 = true;
                    this.mShowInputRequested = true;
                }
            }
        }
        initialize();
        updateFullscreenMode();
        updateInputViewShown();
        if (!this.mWindowAdded || !this.mWindowCreated) {
            this.mWindowAdded = true;
            this.mWindowCreated = true;
            initialize();
            View onCreateCandidatesView = onCreateCandidatesView();
            if (onCreateCandidatesView != null) {
                setCandidatesView(onCreateCandidatesView);
            }
        }
        if (this.mShowInputRequested) {
            if (!this.mInputViewStarted) {
                this.mInputViewStarted = true;
                onStartInputView(this.mInputEditorInfo, false);
            }
        } else if (!this.mCandidatesViewStarted) {
            this.mCandidatesViewStarted = true;
            onStartCandidatesView(this.mInputEditorInfo, false);
        }
        if (z2) {
            startExtractingText(false);
        }
        if (z3) {
            return;
        }
        this.mImm.setImeWindowStatus(this.mToken, 1, this.mBackDisposition);
        onWindowShown();
        this.mWindow.show();
    }

    void startExtractingText(boolean z) {
        ExtractEditText extractEditText = this.mExtractEditText;
        if (extractEditText != null && getCurrentInputStarted() && isFullscreenMode()) {
            this.mExtractedToken++;
            ExtractedTextRequest extractedTextRequest = new ExtractedTextRequest();
            extractedTextRequest.token = this.mExtractedToken;
            extractedTextRequest.flags = 1;
            extractedTextRequest.hintMaxLines = 10;
            extractedTextRequest.hintMaxChars = 10000;
            InputConnection currentInputConnection = getCurrentInputConnection();
            this.mExtractedText = currentInputConnection == null ? null : currentInputConnection.getExtractedText(extractedTextRequest, 1);
            if (this.mExtractedText == null || currentInputConnection == null) {
                Log.e(TAG, "Unexpected null in startExtractingText : mExtractedText = " + this.mExtractedText + ", input connection = " + currentInputConnection);
            }
            EditorInfo currentInputEditorInfo = getCurrentInputEditorInfo();
            try {
                extractEditText.startInternalChanges();
                onUpdateExtractingVisibility(currentInputEditorInfo);
                onUpdateExtractingViews(currentInputEditorInfo);
                int i = currentInputEditorInfo.inputType;
                int i2 = i;
                if ((i & 15) == 1) {
                    i2 = i;
                    if ((262144 & i) != 0) {
                        i2 = i | 131072;
                    }
                }
                extractEditText.setInputType(i2);
                extractEditText.setHint(currentInputEditorInfo.hintText);
                if (this.mExtractedText != null) {
                    extractEditText.setEnabled(true);
                    extractEditText.setExtractedText(this.mExtractedText);
                } else {
                    extractEditText.setEnabled(false);
                    extractEditText.setText("");
                }
                if (z) {
                    onExtractingInputChanged(currentInputEditorInfo);
                }
            } finally {
                extractEditText.finishInternalChanges();
            }
        }
    }

    public void switchInputMethod(String str) {
        this.mImm.setInputMethod(this.mToken, str);
    }

    void updateCandidatesVisibility(boolean z) {
        int candidatesHiddenVisibility = z ? 0 : getCandidatesHiddenVisibility();
        if (this.mCandidatesVisibility != candidatesHiddenVisibility) {
            this.mCandidatesFrame.setVisibility(candidatesHiddenVisibility);
            this.mCandidatesVisibility = candidatesHiddenVisibility;
        }
    }

    void updateExtractFrameVisibility() {
        int i;
        int i2 = 1;
        if (isFullscreenMode()) {
            i = this.mExtractViewHidden ? 4 : 0;
            this.mExtractFrame.setVisibility(i);
        } else {
            i = 0;
            this.mExtractFrame.setVisibility(8);
        }
        updateCandidatesVisibility(this.mCandidatesVisibility == 0);
        if (this.mWindowWasVisible && this.mFullscreenArea.getVisibility() != i) {
            TypedArray typedArray = this.mThemeAttrs;
            if (i != 0) {
                i2 = 2;
            }
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                this.mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(this, resourceId));
            }
        }
        this.mFullscreenArea.setVisibility(i);
    }

    public void updateFullscreenMode() {
        View onCreateExtractTextView;
        boolean z = true;
        boolean z2 = this.mShowInputRequested && onEvaluateFullscreenMode();
        boolean z3 = this.mLastShowInputRequested != this.mShowInputRequested;
        if (this.mIsFullscreen != z2 || !this.mFullscreenApplied) {
            z3 = true;
            this.mIsFullscreen = z2;
            InputConnection currentInputConnection = getCurrentInputConnection();
            if (currentInputConnection != null) {
                currentInputConnection.reportFullscreenMode(z2);
            }
            this.mFullscreenApplied = true;
            initialize();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mFullscreenArea.getLayoutParams();
            if (z2) {
                this.mFullscreenArea.setBackgroundDrawable(this.mThemeAttrs.getDrawable(0));
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
            } else {
                this.mFullscreenArea.setBackgroundDrawable(null);
                layoutParams.height = -2;
                layoutParams.weight = 0.0f;
            }
            ((ViewGroup) this.mFullscreenArea.getParent()).updateViewLayout(this.mFullscreenArea, layoutParams);
            if (z2) {
                if (this.mExtractView == null && (onCreateExtractTextView = onCreateExtractTextView()) != null) {
                    setExtractView(onCreateExtractTextView);
                }
                startExtractingText(false);
            }
            updateExtractFrameVisibility();
        }
        if (z3) {
            Window window = this.mWindow.getWindow();
            if (this.mShowInputRequested) {
                z = false;
            }
            onConfigureWindow(window, z2, z);
            this.mLastShowInputRequested = this.mShowInputRequested;
        }
    }

    public void updateInputViewShown() {
        int i = 0;
        boolean z = this.mShowInputRequested && onEvaluateInputViewShown();
        if (this.mIsInputViewShown == z || !this.mWindowVisible) {
            return;
        }
        this.mIsInputViewShown = z;
        FrameLayout frameLayout = this.mInputFrame;
        if (!z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        if (this.mInputView == null) {
            initialize();
            View onCreateInputView = onCreateInputView();
            if (onCreateInputView != null) {
                setInputView(onCreateInputView);
            }
        }
    }
}

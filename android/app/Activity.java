package android.app;

import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.UserHandle;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.util.SparseArray;
import android.util.SuperNotCalledException;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import com.android.internal.R;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.app.ToolbarActionBar;
import com.android.internal.app.WindowDecorActionBar;
import com.android.internal.policy.PolicyManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/app/Activity.class */
public class Activity extends ContextThemeWrapper implements LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, View.OnCreateContextMenuListener, ComponentCallbacks2, Window.OnWindowDismissedCallback {
    private static final boolean DEBUG_LIFECYCLE = false;
    public static final int DEFAULT_KEYS_DIALER = 1;
    public static final int DEFAULT_KEYS_DISABLE = 0;
    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    public static final int DEFAULT_KEYS_SHORTCUT = 2;
    protected static final int[] FOCUSED_STATE_SET = {16842908};
    static final String FRAGMENTS_TAG = "android:fragments";
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_FIRST_USER = 1;
    public static final int RESULT_OK = -1;
    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    private static final String TAG = "Activity";
    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    ActivityInfo mActivityInfo;
    ArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;
    private Application mApplication;
    boolean mCalled;
    private boolean mChangeCanvasToTranslucent;
    boolean mCheckedForLoaderManager;
    private ComponentName mComponent;
    int mConfigChangeFlags;
    Configuration mCurrentConfig;
    private boolean mDestroyed;
    String mEmbeddedID;
    private boolean mEnableDefaultActionBarUp;
    boolean mFinished;
    private int mIdent;
    private Instrumentation mInstrumentation;
    Intent mIntent;
    NonConfigurationInstances mLastNonConfigurationInstances;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    ActivityThread mMainThread;
    private SparseArray<ManagedDialog> mManagedDialogs;
    private MenuInflater mMenuInflater;
    Activity mParent;
    String mReferrer;
    boolean mResumed;
    private SearchManager mSearchManager;
    boolean mStartedActivity;
    private boolean mStopped;
    private CharSequence mTitle;
    private IBinder mToken;
    private TranslucentConversionListener mTranslucentCallback;
    private Thread mUiThread;
    boolean mVisibleBehind;
    private VoiceInteractor mVoiceInteractor;
    private Window mWindow;
    private WindowManager mWindowManager;
    private boolean mDoReportFullyDrawn = true;
    boolean mTemporaryPause = false;
    boolean mChangingConfigurations = false;
    View mDecor = null;
    boolean mWindowAdded = false;
    boolean mVisibleFromServer = false;
    boolean mVisibleFromClient = true;
    ActionBar mActionBar = null;
    private int mTitleColor = 0;
    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    final FragmentContainer mContainer = new FragmentContainer() { // from class: android.app.Activity.1
        @Override // android.app.FragmentContainer
        public View findViewById(int i) {
            return Activity.this.findViewById(i);
        }

        @Override // android.app.FragmentContainer
        public boolean hasView() {
            Window window = Activity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    };
    private final ArrayList<ManagedCursor> mManagedCursors = new ArrayList<>();
    int mResultCode = 0;
    Intent mResultData = null;
    private boolean mTitleReady = false;
    private int mDefaultKeyMode = 0;
    private SpannableStringBuilder mDefaultKeySsb = null;
    private final Object mInstanceTracker = StrictMode.trackActivity(this);
    final Handler mHandler = new Handler();
    ActivityTransitionState mActivityTransitionState = new ActivityTransitionState();
    SharedElementCallback mEnterTransitionListener = SharedElementCallback.NULL_CALLBACK;
    SharedElementCallback mExitTransitionListener = SharedElementCallback.NULL_CALLBACK;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/Activity$ManagedCursor.class */
    public static final class ManagedCursor {
        private final Cursor mCursor;
        private boolean mReleased = false;
        private boolean mUpdated = false;

        ManagedCursor(Cursor cursor) {
            this.mCursor = cursor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/Activity$ManagedDialog.class */
    public static class ManagedDialog {
        Bundle mArgs;
        Dialog mDialog;

        private ManagedDialog() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/Activity$NonConfigurationInstances.class */
    public static final class NonConfigurationInstances {
        Object activity;
        HashMap<String, Object> children;
        ArrayList<Fragment> fragments;
        ArrayMap<String, LoaderManagerImpl> loaders;
        VoiceInteractor voiceInteractor;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Activity$TranslucentConversionListener.class */
    public interface TranslucentConversionListener {
        void onTranslucentConversionComplete(boolean z);
    }

    private Dialog createDialog(Integer num, Bundle bundle, Bundle bundle2) {
        Dialog onCreateDialog = onCreateDialog(num.intValue(), bundle2);
        if (onCreateDialog == null) {
            return null;
        }
        onCreateDialog.dispatchOnCreate(bundle);
        return onCreateDialog;
    }

    private void ensureSearchManager() {
        if (this.mSearchManager != null) {
            return;
        }
        this.mSearchManager = new SearchManager(this, null);
    }

    private void finish(boolean z) {
        int i;
        Intent intent;
        if (this.mParent != null) {
            this.mParent.finishFromChild(this);
            return;
        }
        synchronized (this) {
            i = this.mResultCode;
            intent = this.mResultData;
        }
        if (intent != null) {
            try {
                intent.prepareToLeaveProcess();
            } catch (RemoteException e) {
                return;
            }
        }
        if (ActivityManagerNative.getDefault().finishActivity(this.mToken, i, intent, z)) {
            this.mFinished = true;
        }
    }

    private void initWindowDecorActionBar() {
        Window window = getWindow();
        window.getDecorView();
        if (!isChild() && window.hasFeature(8) && this.mActionBar == null) {
            this.mActionBar = new WindowDecorActionBar(this);
            this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            this.mWindow.setDefaultIcon(this.mActivityInfo.getIconResource());
            this.mWindow.setDefaultLogo(this.mActivityInfo.getLogoResource());
        }
    }

    private boolean isTopOfTask() {
        try {
            return ActivityManagerNative.getDefault().isTopOfTask(this.mToken);
        } catch (RemoteException e) {
            return false;
        }
    }

    private IllegalArgumentException missingDialog(int i) {
        return new IllegalArgumentException("no dialog with id " + i + " was ever shown via Activity#showDialog");
    }

    private void restoreManagedDialogs(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(SAVED_DIALOGS_TAG);
        if (bundle2 == null) {
            return;
        }
        int[] intArray = bundle2.getIntArray(SAVED_DIALOG_IDS_KEY);
        int length = intArray.length;
        this.mManagedDialogs = new SparseArray<>(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Integer valueOf = Integer.valueOf(intArray[i2]);
            Bundle bundle3 = bundle2.getBundle(savedDialogKeyFor(valueOf.intValue()));
            if (bundle3 != null) {
                ManagedDialog managedDialog = new ManagedDialog();
                managedDialog.mArgs = bundle2.getBundle(savedDialogArgsKeyFor(valueOf.intValue()));
                managedDialog.mDialog = createDialog(valueOf, bundle3, managedDialog.mArgs);
                if (managedDialog.mDialog != null) {
                    this.mManagedDialogs.put(valueOf.intValue(), managedDialog);
                    onPrepareDialog(valueOf.intValue(), managedDialog.mDialog, managedDialog.mArgs);
                    managedDialog.mDialog.onRestoreInstanceState(bundle3);
                }
            }
            i = i2 + 1;
        }
    }

    private void saveManagedDialogs(Bundle bundle) {
        int size;
        if (this.mManagedDialogs == null || (size = this.mManagedDialogs.size()) == 0) {
            return;
        }
        Bundle bundle2 = new Bundle();
        int[] iArr = new int[this.mManagedDialogs.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                bundle2.putIntArray(SAVED_DIALOG_IDS_KEY, iArr);
                bundle.putBundle(SAVED_DIALOGS_TAG, bundle2);
                return;
            }
            int keyAt = this.mManagedDialogs.keyAt(i2);
            iArr[i2] = keyAt;
            ManagedDialog valueAt = this.mManagedDialogs.valueAt(i2);
            bundle2.putBundle(savedDialogKeyFor(keyAt), valueAt.mDialog.onSaveInstanceState());
            if (valueAt.mArgs != null) {
                bundle2.putBundle(savedDialogArgsKeyFor(keyAt), valueAt.mArgs);
            }
            i = i2 + 1;
        }
    }

    private static String savedDialogArgsKeyFor(int i) {
        return SAVED_DIALOG_ARGS_KEY_PREFIX + i;
    }

    private static String savedDialogKeyFor(int i) {
        return SAVED_DIALOG_KEY_PREFIX + i;
    }

    private void startIntentSenderForResultInner(IntentSender intentSender, int i, Intent intent, int i2, int i3, Activity activity, Bundle bundle) throws IntentSender.SendIntentException {
        String str = null;
        if (intent != null) {
            try {
                intent.migrateExtraStreamToClipData();
                intent.prepareToLeaveProcess();
                str = intent.resolveTypeIfNeeded(getContentResolver());
            } catch (RemoteException e) {
            }
        }
        int startActivityIntentSender = ActivityManagerNative.getDefault().startActivityIntentSender(this.mMainThread.getApplicationThread(), intentSender, intent, str, this.mToken, activity.mEmbeddedID, i, i2, i3, bundle);
        if (startActivityIntentSender == -6) {
            throw new IntentSender.SendIntentException();
        }
        Instrumentation.checkStartActivityResult(startActivityIntentSender, null);
        if (i >= 0) {
            this.mStartedActivity = true;
        }
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getWindow().addContentView(view, layoutParams);
        initWindowDecorActionBar();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void attach(Context context, ActivityThread activityThread, Instrumentation instrumentation, IBinder iBinder, int i, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, NonConfigurationInstances nonConfigurationInstances, Configuration configuration, String str2, IVoiceInteractor iVoiceInteractor) {
        attachBaseContext(context);
        this.mFragments.attachActivity(this, this.mContainer, null);
        this.mWindow = PolicyManager.makeNewWindow(this);
        this.mWindow.setCallback(this);
        this.mWindow.setOnWindowDismissedCallback(this);
        this.mWindow.getLayoutInflater().setPrivateFactory(this);
        if (activityInfo.softInputMode != 0) {
            this.mWindow.setSoftInputMode(activityInfo.softInputMode);
        }
        if (activityInfo.uiOptions != 0) {
            this.mWindow.setUiOptions(activityInfo.uiOptions);
        }
        this.mUiThread = Thread.currentThread();
        this.mMainThread = activityThread;
        this.mInstrumentation = instrumentation;
        this.mToken = iBinder;
        this.mIdent = i;
        this.mApplication = application;
        this.mIntent = intent;
        this.mReferrer = str2;
        this.mComponent = intent.getComponent();
        this.mActivityInfo = activityInfo;
        this.mTitle = charSequence;
        this.mParent = activity;
        this.mEmbeddedID = str;
        this.mLastNonConfigurationInstances = nonConfigurationInstances;
        if (iVoiceInteractor != null) {
            if (nonConfigurationInstances != null) {
                this.mVoiceInteractor = nonConfigurationInstances.voiceInteractor;
            } else {
                this.mVoiceInteractor = new VoiceInteractor(iVoiceInteractor, this, this, Looper.myLooper());
            }
        }
        this.mWindow.setWindowManager((WindowManager) context.getSystemService(Context.WINDOW_SERVICE), this.mToken, this.mComponent.flattenToString(), (activityInfo.flags & 512) != 0);
        if (this.mParent != null) {
            this.mWindow.setContainer(this.mParent.getWindow());
        }
        this.mWindowManager = this.mWindow.getWindowManager();
        this.mCurrentConfig = configuration;
    }

    public void closeContextMenu() {
        if (this.mWindow.hasFeature(6)) {
            this.mWindow.closePanel(6);
        }
    }

    public void closeOptionsMenu() {
        if (this.mWindow.hasFeature(0)) {
            this.mWindow.closePanel(0);
        }
    }

    public void convertFromTranslucent() {
        try {
            this.mTranslucentCallback = null;
            if (ActivityManagerNative.getDefault().convertFromTranslucent(this.mToken)) {
                WindowManagerGlobal.getInstance().changeCanvasOpacity(this.mToken, true);
            }
        } catch (RemoteException e) {
        }
    }

    public boolean convertToTranslucent(TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        boolean z;
        try {
            this.mTranslucentCallback = translucentConversionListener;
            this.mChangeCanvasToTranslucent = ActivityManagerNative.getDefault().convertToTranslucent(this.mToken, activityOptions);
            WindowManagerGlobal.getInstance().changeCanvasOpacity(this.mToken, false);
            z = true;
        } catch (RemoteException e) {
            this.mChangeCanvasToTranslucent = false;
            z = false;
        }
        if (!this.mChangeCanvasToTranslucent && this.mTranslucentCallback != null) {
            this.mTranslucentCallback.onTranslucentConversionComplete(z);
        }
        return this.mChangeCanvasToTranslucent;
    }

    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        String packageName = getPackageName();
        try {
            intent.prepareToLeaveProcess();
            IIntentSender intentSender = ActivityManagerNative.getDefault().getIntentSender(3, packageName, this.mParent == null ? this.mToken : this.mParent.mToken, this.mEmbeddedID, i, new Intent[]{intent}, null, i2, null, UserHandle.myUserId());
            if (intentSender != null) {
                return new PendingIntent(intentSender);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Deprecated
    public final void dismissDialog(int i) {
        if (this.mManagedDialogs == null) {
            throw missingDialog(i);
        }
        ManagedDialog managedDialog = this.mManagedDialogs.get(i);
        if (managedDialog == null) {
            throw missingDialog(i);
        }
        managedDialog.mDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityResult(String str, int i, int i2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        if (str == null) {
            onActivityResult(i, i2, intent);
            return;
        }
        Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
        if (findFragmentByWho != null) {
            findFragmentByWho.onActivityResult(i, i2, intent);
        }
    }

    public void dispatchEnterAnimationComplete() {
        onEnterAnimationComplete();
        if (getWindow() == null || getWindow().getDecorView() == null) {
            return;
        }
        getWindow().getDecorView().getViewTreeObserver().dispatchOnEnterAnimationComplete();
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        onUserInteraction();
        if (getWindow().superDispatchGenericMotionEvent(motionEvent)) {
            return true;
        }
        return onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        onUserInteraction();
        if (keyEvent.getKeyCode() == 82 && this.mActionBar != null && this.mActionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        Window window = getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View view = this.mDecor;
        View view2 = view;
        if (view == null) {
            view2 = window.getDecorView();
        }
        return keyEvent.dispatch(this, view2 != null ? view2.getKeyDispatcherState() : null, this);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        onUserInteraction();
        if (getWindow().superDispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        return onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getPackageName());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        accessibilityEvent.setFullScreen(attributes.width == -1 && attributes.height == -1);
        CharSequence title = getTitle();
        if (TextUtils.isEmpty(title)) {
            return true;
        }
        accessibilityEvent.getText().add(title);
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            onUserInteraction();
        }
        if (getWindow().superDispatchTouchEvent(motionEvent)) {
            return true;
        }
        return onTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        onUserInteraction();
        if (getWindow().superDispatchTrackballEvent(motionEvent)) {
            return true;
        }
        return onTrackballEvent(motionEvent);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dumpInner(str, fileDescriptor, printWriter, strArr);
    }

    void dumpInner(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("Local Activity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mFinished=");
        printWriter.println(this.mFinished);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        printWriter.print(str2);
        printWriter.print("mChangingConfigurations=");
        printWriter.println(this.mChangingConfigurations);
        printWriter.print(str2);
        printWriter.print("mCurrentConfig=");
        printWriter.println(this.mCurrentConfig);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.mFragments.dump(str, fileDescriptor, printWriter, strArr);
        if (getWindow() != null && getWindow().peekDecorView() != null && getWindow().peekDecorView().getViewRootImpl() != null) {
            getWindow().peekDecorView().getViewRootImpl().dump(str, fileDescriptor, printWriter, strArr);
        }
        this.mHandler.getLooper().dump(new PrintWriterPrinter(printWriter), str);
    }

    public View findViewById(int i) {
        return getWindow().findViewById(i);
    }

    public void finish() {
        finish(false);
    }

    public void finishActivity(int i) {
        if (this.mParent != null) {
            this.mParent.finishActivityFromChild(this, i);
            return;
        }
        try {
            ActivityManagerNative.getDefault().finishSubActivity(this.mToken, this.mEmbeddedID, i);
        } catch (RemoteException e) {
        }
    }

    public void finishActivityFromChild(Activity activity, int i) {
        try {
            ActivityManagerNative.getDefault().finishSubActivity(this.mToken, activity.mEmbeddedID, i);
        } catch (RemoteException e) {
        }
    }

    public void finishAffinity() {
        if (this.mParent != null) {
            throw new IllegalStateException("Can not be called from an embedded activity");
        }
        if (this.mResultCode != 0 || this.mResultData != null) {
            throw new IllegalStateException("Can not be called to deliver a result");
        }
        try {
            if (ActivityManagerNative.getDefault().finishActivityAffinity(this.mToken)) {
                this.mFinished = true;
            }
        } catch (RemoteException e) {
        }
    }

    public void finishAfterTransition() {
        if (this.mActivityTransitionState.startExitBackTransition(this)) {
            return;
        }
        finish();
    }

    public void finishAndRemoveTask() {
        finish(true);
    }

    public void finishFromChild(Activity activity) {
        finish();
    }

    public ActionBar getActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    ActivityOptions getActivityOptions() {
        try {
            return ActivityManagerNative.getDefault().getActivityOptions(this.mToken);
        } catch (RemoteException e) {
            return null;
        }
    }

    public final IBinder getActivityToken() {
        return this.mParent != null ? this.mParent.getActivityToken() : this.mToken;
    }

    public final Application getApplication() {
        return this.mApplication;
    }

    public ComponentName getCallingActivity() {
        try {
            return ActivityManagerNative.getDefault().getCallingActivity(this.mToken);
        } catch (RemoteException e) {
            return null;
        }
    }

    public String getCallingPackage() {
        try {
            return ActivityManagerNative.getDefault().getCallingPackage(this.mToken);
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getChangingConfigurations() {
        return this.mConfigChangeFlags;
    }

    public ComponentName getComponentName() {
        return this.mComponent;
    }

    public Scene getContentScene() {
        return getWindow().getContentScene();
    }

    public TransitionManager getContentTransitionManager() {
        return getWindow().getTransitionManager();
    }

    public View getCurrentFocus() {
        if (this.mWindow != null) {
            return this.mWindow.getCurrentFocus();
        }
        return null;
    }

    public FragmentManager getFragmentManager() {
        return this.mFragments;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, Object> getLastNonConfigurationChildInstances() {
        if (this.mLastNonConfigurationInstances != null) {
            return this.mLastNonConfigurationInstances.children;
        }
        return null;
    }

    @Deprecated
    public Object getLastNonConfigurationInstance() {
        if (this.mLastNonConfigurationInstances != null) {
            return this.mLastNonConfigurationInstances.activity;
        }
        return null;
    }

    public LayoutInflater getLayoutInflater() {
        return getWindow().getLayoutInflater();
    }

    public LoaderManager getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoaderManagerImpl getLoaderManager(String str, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new ArrayMap<>();
        }
        LoaderManagerImpl loaderManagerImpl = this.mAllLoaderManagers.get(str);
        if (loaderManagerImpl != null) {
            loaderManagerImpl.updateActivity(this);
            return loaderManagerImpl;
        }
        if (z2) {
            loaderManagerImpl = new LoaderManagerImpl(str, this, z);
            this.mAllLoaderManagers.put(str, loaderManagerImpl);
        }
        return loaderManagerImpl;
    }

    public String getLocalClassName() {
        String packageName = getPackageName();
        String className = this.mComponent.getClassName();
        int length = packageName.length();
        return (className.startsWith(packageName) && className.length() > length && className.charAt(length) == '.') ? className.substring(length + 1) : className;
    }

    public final MediaController getMediaController() {
        return getWindow().getMediaController();
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            initWindowDecorActionBar();
            if (this.mActionBar != null) {
                this.mMenuInflater = new MenuInflater(this.mActionBar.getThemedContext(), this);
            } else {
                this.mMenuInflater = new MenuInflater(this);
            }
        }
        return this.mMenuInflater;
    }

    public final Activity getParent() {
        return this.mParent;
    }

    public Intent getParentActivityIntent() {
        String str = this.mActivityInfo.parentActivityName;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ComponentName componentName = new ComponentName(this, str);
        try {
            return getPackageManager().getActivityInfo(componentName, 0).parentActivityName == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + str + "' in manifest");
            return null;
        }
    }

    public SharedPreferences getPreferences(int i) {
        return getSharedPreferences(getLocalClassName(), i);
    }

    public Uri getReferrer() {
        Intent intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra(Intent.EXTRA_REFERRER);
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra(Intent.EXTRA_REFERRER_NAME);
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        if (this.mReferrer != null) {
            return new Uri.Builder().scheme("android-app").authority(this.mReferrer).build();
        }
        return null;
    }

    public int getRequestedOrientation() {
        if (this.mParent == null) {
            try {
                return ActivityManagerNative.getDefault().getRequestedOrientation(this.mToken);
            } catch (RemoteException e) {
                return -1;
            }
        }
        return this.mParent.getRequestedOrientation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (getBaseContext() == null) {
            throw new IllegalStateException("System services not available to Activities before onCreate()");
        }
        if (Context.WINDOW_SERVICE.equals(str)) {
            return this.mWindowManager;
        }
        if ("search".equals(str)) {
            ensureSearchManager();
            return this.mSearchManager;
        }
        return super.getSystemService(str);
    }

    public int getTaskId() {
        try {
            return ActivityManagerNative.getDefault().getTaskForActivity(this.mToken, false);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public final CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getTitleColor() {
        return this.mTitleColor;
    }

    public VoiceInteractor getVoiceInteractor() {
        return this.mVoiceInteractor;
    }

    public final int getVolumeControlStream() {
        return getWindow().getVolumeControlStream();
    }

    public Window getWindow() {
        return this.mWindow;
    }

    public WindowManager getWindowManager() {
        return this.mWindowManager;
    }

    public boolean hasWindowFocus() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        return decorView.hasWindowFocus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateFragment(String str) {
        LoaderManagerImpl loaderManagerImpl;
        if (this.mAllLoaderManagers == null || (loaderManagerImpl = this.mAllLoaderManagers.get(str)) == null || loaderManagerImpl.mRetaining) {
            return;
        }
        loaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(str);
    }

    public void invalidateOptionsMenu() {
        if (this.mWindow.hasFeature(0)) {
            if (this.mActionBar == null || !this.mActionBar.invalidateOptionsMenu()) {
                this.mWindow.invalidatePanelMenu(0);
            }
        }
    }

    public boolean isBackgroundVisibleBehind() {
        try {
            return ActivityManagerNative.getDefault().isBackgroundVisibleBehind(this.mToken);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public final boolean isChild() {
        return this.mParent != null;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isFinishing() {
        return this.mFinished;
    }

    public boolean isImmersive() {
        try {
            return ActivityManagerNative.getDefault().isImmersive(this.mToken);
        } catch (RemoteException e) {
            return false;
        }
    }

    public final boolean isResumed() {
        return this.mResumed;
    }

    public boolean isTaskRoot() {
        try {
            return ActivityManagerNative.getDefault().getTaskForActivity(this.mToken, true) >= 0;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isVoiceInteraction() {
        return this.mVoiceInteractor != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makeVisible() {
        if (!this.mWindowAdded) {
            getWindowManager().addView(this.mDecor, getWindow().getAttributes());
            this.mWindowAdded = true;
        }
        this.mDecor.setVisibility(0);
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String str2) {
        Cursor query = getContentResolver().query(uri, strArr, str, null, str2);
        if (query != null) {
            startManagingCursor(query);
        }
        return query;
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query = getContentResolver().query(uri, strArr, str, strArr2, str2);
        if (query != null) {
            startManagingCursor(query);
        }
        return query;
    }

    public boolean moveTaskToBack(boolean z) {
        try {
            return ActivityManagerNative.getDefault().moveActivityTaskToBack(this.mToken, z);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean navigateUpTo(Intent intent) {
        int i;
        Intent intent2;
        if (this.mParent == null) {
            Intent intent3 = intent;
            if (intent.getComponent() == null) {
                ComponentName resolveActivity = intent.resolveActivity(getPackageManager());
                if (resolveActivity == null) {
                    return false;
                }
                intent3 = new Intent(intent);
                intent3.setComponent(resolveActivity);
            }
            synchronized (this) {
                i = this.mResultCode;
                intent2 = this.mResultData;
            }
            if (intent2 != null) {
                intent2.prepareToLeaveProcess();
            }
            try {
                intent3.prepareToLeaveProcess();
                return ActivityManagerNative.getDefault().navigateUpTo(this.mToken, intent3, i, intent2);
            } catch (RemoteException e) {
                return false;
            }
        }
        return this.mParent.navigateUpToFromChild(this, intent);
    }

    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return navigateUpTo(intent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
    }

    public void onActivityReenter(int i, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        if (this.mParent == null) {
            super.onApplyThemeResource(theme, i, z);
        } else {
            try {
                theme.setTo(this.mParent.getTheme());
            } catch (Exception e) {
            }
            theme.applyStyle(i, false);
        }
        if (theme != null) {
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(R.styleable.Theme);
            int color = obtainStyledAttributes.getColor(227, 0);
            obtainStyledAttributes.recycle();
            if (color != 0) {
                setTaskDescription(new ActivityManager.TaskDescription((String) null, (Bitmap) null, color));
            }
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
    }

    public void onBackPressed() {
        if ((this.mActionBar == null || !this.mActionBar.collapseActionView()) && !this.mFragments.popBackStackImmediate()) {
            finishAfterTransition();
        }
    }

    public void onBackgroundVisibleBehindChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
        this.mFragments.dispatchConfigurationChanged(configuration);
        if (this.mWindow != null) {
            this.mWindow.onConfigurationChanged(configuration);
        }
        if (this.mActionBar != null) {
            this.mActionBar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.mParent != null) {
            return this.mParent.onContextItemSelected(menuItem);
        }
        return false;
    }

    public void onContextMenuClosed(Menu menu) {
        if (this.mParent != null) {
            this.mParent.onContextMenuClosed(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (this.mLastNonConfigurationInstances != null) {
            this.mAllLoaderManagers = this.mLastNonConfigurationInstances.loaders;
        }
        if (this.mActivityInfo.parentActivityName != null) {
            if (this.mActionBar == null) {
                this.mEnableDefaultActionBarUp = true;
            } else {
                this.mActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
        if (bundle != null) {
            this.mFragments.restoreAllState(bundle.getParcelable(FRAGMENTS_TAG), this.mLastNonConfigurationInstances != null ? this.mLastNonConfigurationInstances.fragments : null);
        }
        this.mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, bundle);
        if (this.mVoiceInteractor != null) {
            this.mVoiceInteractor.attachActivity(this);
        }
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        onCreate(bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }

    public CharSequence onCreateDescription() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public Dialog onCreateDialog(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public Dialog onCreateDialog(int i, Bundle bundle) {
        return onCreateDialog(i);
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mParent != null) {
            return this.mParent.onCreateOptionsMenu(menu);
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return onCreateOptionsMenu(menu) | this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return null;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return false;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return !"fragment".equals(str) ? onCreateView(str, context, attributeSet) : this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.mCalled = true;
        if (this.mManagedDialogs != null) {
            int size = this.mManagedDialogs.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ManagedDialog valueAt = this.mManagedDialogs.valueAt(i2);
                if (valueAt.mDialog.isShowing()) {
                    valueAt.mDialog.dismiss();
                }
                i = i2 + 1;
            }
            this.mManagedDialogs = null;
        }
        synchronized (this.mManagedCursors) {
            int size2 = this.mManagedCursors.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                ManagedCursor managedCursor = this.mManagedCursors.get(i4);
                if (managedCursor != null) {
                    managedCursor.mCursor.close();
                }
                i3 = i4 + 1;
            }
            this.mManagedCursors.clear();
        }
        if (this.mSearchManager != null) {
            this.mSearchManager.stopSearch();
        }
        getApplication().dispatchActivityDestroyed(this);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
    }

    public void onEnterAnimationComplete() {
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        if (i == 4) {
            if (getApplicationInfo().targetSdkVersion >= 5) {
                keyEvent.startTracking();
            } else {
                onBackPressed();
            }
            z3 = true;
        } else if (this.mDefaultKeyMode == 0) {
            return false;
        } else {
            if (this.mDefaultKeyMode == 2) {
                Window window = getWindow();
                return window.hasFeature(0) && window.performPanelShortcut(0, i, keyEvent, 2);
            }
            if (keyEvent.getRepeatCount() == 0 && !keyEvent.isSystem()) {
                boolean onKeyDown = TextKeyListener.getInstance().onKeyDown(null, this.mDefaultKeySsb, i, keyEvent);
                z = false;
                z2 = onKeyDown;
                if (onKeyDown) {
                    z = false;
                    z2 = onKeyDown;
                    if (this.mDefaultKeySsb.length() > 0) {
                        String spannableStringBuilder = this.mDefaultKeySsb.toString();
                        z = true;
                        switch (this.mDefaultKeyMode) {
                            case 1:
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + spannableStringBuilder));
                                intent.addFlags(268435456);
                                startActivity(intent);
                                z2 = onKeyDown;
                                break;
                            case 2:
                            default:
                                z2 = onKeyDown;
                                break;
                            case 3:
                                startSearch(spannableStringBuilder, false, null, false);
                                z2 = onKeyDown;
                                break;
                            case 4:
                                startSearch(spannableStringBuilder, false, null, true);
                                z2 = onKeyDown;
                                break;
                        }
                    }
                }
            } else {
                z = true;
                z2 = false;
            }
            z3 = z2;
            if (z) {
                this.mDefaultKeySsb.clear();
                this.mDefaultKeySsb.clearSpans();
                Selection.setSelection(this.mDefaultKeySsb, 0);
                return z2;
            }
        }
        return z3;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (getApplicationInfo().targetSdkVersion < 5 || i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        onBackPressed();
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        boolean z;
        CharSequence titleCondensed = menuItem.getTitleCondensed();
        switch (i) {
            case 0:
                if (titleCondensed != null) {
                    EventLog.writeEvent(50000, 0, titleCondensed.toString());
                }
                z = true;
                if (!onOptionsItemSelected(menuItem)) {
                    z = true;
                    if (!this.mFragments.dispatchOptionsItemSelected(menuItem)) {
                        if (menuItem.getItemId() != 16908332 || this.mActionBar == null || (this.mActionBar.getDisplayOptions() & 4) == 0) {
                            return false;
                        }
                        return this.mParent == null ? onNavigateUp() : this.mParent.onNavigateUpFromChild(this);
                    }
                }
                break;
            case 6:
                if (titleCondensed != null) {
                    EventLog.writeEvent(50000, 1, titleCondensed.toString());
                }
                z = true;
                if (!onContextItemSelected(menuItem)) {
                    return this.mFragments.dispatchContextItemSelected(menuItem);
                }
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (i == 8) {
            initWindowDecorActionBar();
            if (this.mActionBar != null) {
                this.mActionBar.dispatchMenuVisibilityChanged(true);
                return true;
            }
            Log.e(TAG, "Tried to open action bar menu with no action bar");
            return true;
        }
        return true;
    }

    public boolean onNavigateUp() {
        Intent parentActivityIntent = getParentActivityIntent();
        if (parentActivityIntent != null) {
            if (this.mActivityInfo.taskAffinity == null) {
                finish();
                return true;
            } else if (!shouldUpRecreateTask(parentActivityIntent)) {
                navigateUpTo(parentActivityIntent);
                return true;
            } else {
                TaskStackBuilder create = TaskStackBuilder.create(this);
                onCreateNavigateUpTaskStack(create);
                onPrepareNavigateUpTaskStack(create);
                create.startActivities();
                if (this.mResultCode == 0 && this.mResultData == null) {
                    finishAffinity();
                    return true;
                }
                Log.i(TAG, "onNavigateUp only finishing topmost activity to return a result");
                finish();
                return true;
            }
        }
        return false;
    }

    public boolean onNavigateUpFromChild(Activity activity) {
        return onNavigateUp();
    }

    public void onNewActivityOptions(ActivityOptions activityOptions) {
        this.mActivityTransitionState.setEnterActivityOptions(this, activityOptions);
        if (this.mStopped) {
            return;
        }
        this.mActivityTransitionState.enterReady(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.mParent != null) {
            return this.mParent.onOptionsItemSelected(menuItem);
        }
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
        if (this.mParent != null) {
            this.mParent.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.dispatchOptionsMenuClosed(menu);
                onOptionsMenuClosed(menu);
                return;
            case 6:
                onContextMenuClosed(menu);
                return;
            case 8:
                initWindowDecorActionBar();
                this.mActionBar.dispatchMenuVisibilityChanged(false);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        getApplication().dispatchActivityPaused(this);
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        if (!isChild()) {
            this.mTitleReady = true;
            onTitleChanged(getTitle(), getTitleColor());
        }
        this.mCalled = true;
    }

    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        onPostCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostResume() {
        Window window = getWindow();
        if (window != null) {
            window.makeActive();
        }
        if (this.mActionBar != null) {
            this.mActionBar.setShowHideAnimationEnabled(true);
        }
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void onPrepareDialog(int i, Dialog dialog) {
        dialog.setOwnerActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        onPrepareDialog(i, dialog);
    }

    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.mParent != null) {
            return this.mParent.onPrepareOptionsMenu(menu);
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return true;
        }
        return onPrepareOptionsMenu(menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
    }

    public void onProvideAssistData(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestart() {
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2;
        if (this.mWindow == null || (bundle2 = bundle.getBundle(WINDOW_HIERARCHY_TAG)) == null) {
            return;
        }
        this.mWindow.restoreHierarchyState(bundle2);
    }

    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        getApplication().dispatchActivityResumed(this);
        this.mActivityTransitionState.onResume();
        this.mCalled = true;
    }

    HashMap<String, Object> onRetainNonConfigurationChildInstances() {
        return null;
    }

    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBundle(WINDOW_HIERARCHY_TAG, this.mWindow.saveHierarchyState());
        Parcelable saveAllState = this.mFragments.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
        }
        getApplication().dispatchActivitySaveInstanceState(this, bundle);
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        onSaveInstanceState(bundle);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        boolean z = false;
        if ((getResources().getConfiguration().uiMode & 15) != 4) {
            startSearch(null, false, null, false);
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doStart();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
            }
            this.mCheckedForLoaderManager = true;
        }
        getApplication().dispatchActivityStarted(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        if (this.mActionBar != null) {
            this.mActionBar.setShowHideAnimationEnabled(false);
        }
        this.mActivityTransitionState.onStop();
        getApplication().dispatchActivityStopped(this);
        this.mTranslucentCallback = null;
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        if (this.mTitleReady) {
            Window window = getWindow();
            if (window != null) {
                window.setTitle(charSequence);
                if (i != 0) {
                    window.setTitleColor(i);
                }
            }
            if (this.mActionBar != null) {
                this.mActionBar.setWindowTitle(charSequence);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWindow.shouldCloseOnTouch(this, motionEvent)) {
            finish();
            return true;
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTranslucentConversionComplete(boolean z) {
        if (this.mTranslucentCallback != null) {
            this.mTranslucentCallback.onTranslucentConversionComplete(z);
            this.mTranslucentCallback = null;
        }
        if (this.mChangeCanvasToTranslucent) {
            WindowManagerGlobal.getInstance().changeCanvasOpacity(this.mToken, false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mCalled = true;
        this.mFragments.dispatchTrimMemory(i);
    }

    public void onUserInteraction() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserLeaveHint() {
    }

    public void onVisibleBehindCanceled() {
        this.mCalled = true;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        View view;
        if (this.mParent != null || (view = this.mDecor) == null || view.getParent() == null) {
            return;
        }
        getWindowManager().updateViewLayout(view, layoutParams);
    }

    @Override // android.view.Window.OnWindowDismissedCallback
    public void onWindowDismissed() {
        finish();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        initWindowDecorActionBar();
        if (this.mActionBar != null) {
            return this.mActionBar.startActionMode(callback);
        }
        return null;
    }

    public void openContextMenu(View view) {
        view.showContextMenu();
    }

    public void openOptionsMenu() {
        if (this.mWindow.hasFeature(0)) {
            if (this.mActionBar == null || !this.mActionBar.openOptionsMenu()) {
                this.mWindow.openPanel(0, null);
            }
        }
    }

    public void overridePendingTransition(int i, int i2) {
        try {
            ActivityManagerNative.getDefault().overridePendingTransition(this.mToken, getPackageName(), i, i2);
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performCreate(Bundle bundle) {
        onCreate(bundle);
        this.mActivityTransitionState.readState(bundle);
        performCreateCommon();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performCreate(Bundle bundle, PersistableBundle persistableBundle) {
        onCreate(bundle, persistableBundle);
        this.mActivityTransitionState.readState(bundle);
        performCreateCommon();
    }

    final void performCreateCommon() {
        boolean z = false;
        if (!this.mWindow.getWindowStyle().getBoolean(10, false)) {
            z = true;
        }
        this.mVisibleFromClient = z;
        this.mFragments.dispatchActivityCreated();
        this.mActivityTransitionState.setEnterActivityOptions(this, getActivityOptions());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performDestroy() {
        this.mDestroyed = true;
        this.mWindow.destroy();
        this.mFragments.dispatchDestroy();
        onDestroy();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
        if (this.mVoiceInteractor != null) {
            this.mVoiceInteractor.detachActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performPause() {
        this.mDoReportFullyDrawn = false;
        this.mFragments.dispatchPause();
        this.mCalled = false;
        onPause();
        this.mResumed = false;
        if (!this.mCalled && getApplicationInfo().targetSdkVersion >= 9) {
            throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onPause()");
        }
        this.mResumed = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performRestart() {
        this.mFragments.noteStateNotSaved();
        if (this.mStopped) {
            this.mStopped = false;
            if (this.mToken != null && this.mParent == null) {
                WindowManagerGlobal.getInstance().setStoppedState(this.mToken, false);
            }
            synchronized (this.mManagedCursors) {
                int size = this.mManagedCursors.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        ManagedCursor managedCursor = this.mManagedCursors.get(i2);
                        if (managedCursor.mReleased || managedCursor.mUpdated) {
                            if (!managedCursor.mCursor.requery() && getApplicationInfo().targetSdkVersion >= 14) {
                                throw new IllegalStateException("trying to requery an already closed cursor  " + managedCursor.mCursor);
                            }
                            managedCursor.mReleased = false;
                            managedCursor.mUpdated = false;
                        }
                        i = i2 + 1;
                    }
                }
            }
            this.mCalled = false;
            this.mInstrumentation.callActivityOnRestart(this);
            if (!this.mCalled) {
                throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onRestart()");
            }
            performStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performRestoreInstanceState(Bundle bundle) {
        onRestoreInstanceState(bundle);
        restoreManagedDialogs(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        onRestoreInstanceState(bundle, persistableBundle);
        if (bundle != null) {
            restoreManagedDialogs(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performResume() {
        performRestart();
        this.mFragments.execPendingActions();
        this.mLastNonConfigurationInstances = null;
        this.mCalled = false;
        this.mInstrumentation.callActivityOnResume(this);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onResume()");
        }
        this.mCalled = false;
        this.mFragments.dispatchResume();
        this.mFragments.execPendingActions();
        onPostResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onPostResume()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        saveManagedDialogs(bundle);
        this.mActivityTransitionState.saveState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        onSaveInstanceState(bundle, persistableBundle);
        saveManagedDialogs(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performStart() {
        this.mActivityTransitionState.setEnterActivityOptions(this, getActivityOptions());
        this.mFragments.noteStateNotSaved();
        this.mCalled = false;
        this.mFragments.execPendingActions();
        this.mInstrumentation.callActivityOnStart(this);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onStart()");
        }
        this.mFragments.dispatchStart();
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            int i = size;
            while (true) {
                int i2 = i - 1;
                if (i2 < 0) {
                    break;
                }
                loaderManagerImplArr[i2] = this.mAllLoaderManagers.valueAt(i2);
                i = i2;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i4];
                loaderManagerImpl.finishRetain();
                loaderManagerImpl.doReportStart();
                i3 = i4 + 1;
            }
        }
        this.mActivityTransitionState.enterReady(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performStop() {
        this.mDoReportFullyDrawn = false;
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (this.mLoaderManager != null) {
                if (this.mChangingConfigurations) {
                    this.mLoaderManager.doRetain();
                } else {
                    this.mLoaderManager.doStop();
                }
            }
        }
        if (!this.mStopped) {
            if (this.mWindow != null) {
                this.mWindow.closeAllPanels();
            }
            if (this.mToken != null && this.mParent == null) {
                WindowManagerGlobal.getInstance().setStoppedState(this.mToken, true);
            }
            this.mFragments.dispatchStop();
            this.mCalled = false;
            this.mInstrumentation.callActivityOnStop(this);
            if (!this.mCalled) {
                throw new SuperNotCalledException("Activity " + this.mComponent.toShortString() + " did not call through to super.onStop()");
            }
            synchronized (this.mManagedCursors) {
                int size = this.mManagedCursors.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    ManagedCursor managedCursor = this.mManagedCursors.get(i2);
                    if (!managedCursor.mReleased) {
                        managedCursor.mCursor.deactivate();
                        managedCursor.mReleased = true;
                    }
                    i = i2 + 1;
                }
            }
            this.mStopped = true;
        }
        this.mResumed = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
    }

    public void postponeEnterTransition() {
        this.mActivityTransitionState.postponeEnterTransition();
    }

    public void recreate() {
        if (this.mParent != null) {
            throw new IllegalStateException("Can only be called on top-level activity");
        }
        if (Looper.myLooper() != this.mMainThread.getLooper()) {
            throw new IllegalStateException("Must be called from main thread");
        }
        this.mMainThread.requestRelaunchActivity(this.mToken, null, null, 0, false, null, false);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public boolean releaseInstance() {
        try {
            return ActivityManagerNative.getDefault().releaseActivityInstance(this.mToken);
        } catch (RemoteException e) {
            return false;
        }
    }

    @Deprecated
    public final void removeDialog(int i) {
        ManagedDialog managedDialog;
        if (this.mManagedDialogs == null || (managedDialog = this.mManagedDialogs.get(i)) == null) {
            return;
        }
        managedDialog.mDialog.dismiss();
        this.mManagedDialogs.remove(i);
    }

    public void reportFullyDrawn() {
        if (this.mDoReportFullyDrawn) {
            this.mDoReportFullyDrawn = false;
            try {
                ActivityManagerNative.getDefault().reportActivityFullyDrawn(this.mToken);
            } catch (RemoteException e) {
            }
        }
    }

    public boolean requestVisibleBehind(boolean z) {
        if (!this.mResumed) {
            z = false;
        }
        try {
            this.mVisibleBehind = ActivityManagerNative.getDefault().requestVisibleBehind(this.mToken, z) && z;
        } catch (RemoteException e) {
            this.mVisibleBehind = false;
        }
        return this.mVisibleBehind;
    }

    public final boolean requestWindowFeature(int i) {
        return getWindow().requestFeature(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NonConfigurationInstances retainNonConfigurationInstances() {
        Object onRetainNonConfigurationInstance = onRetainNonConfigurationInstance();
        HashMap<String, Object> onRetainNonConfigurationChildInstances = onRetainNonConfigurationChildInstances();
        ArrayList<Fragment> retainNonConfig = this.mFragments.retainNonConfig();
        boolean z = false;
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            int i = size;
            while (true) {
                int i2 = i - 1;
                if (i2 < 0) {
                    break;
                }
                loaderManagerImplArr[i2] = this.mAllLoaderManagers.valueAt(i2);
                i = i2;
            }
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z = z2;
                if (i4 >= size) {
                    break;
                }
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i4];
                if (loaderManagerImpl.mRetaining) {
                    z2 = true;
                } else {
                    loaderManagerImpl.doDestroy();
                    this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
                }
                i3 = i4 + 1;
            }
        }
        if (onRetainNonConfigurationInstance == null && onRetainNonConfigurationChildInstances == null && retainNonConfig == null && !z && this.mVoiceInteractor == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.activity = onRetainNonConfigurationInstance;
        nonConfigurationInstances.children = onRetainNonConfigurationChildInstances;
        nonConfigurationInstances.fragments = retainNonConfig;
        nonConfigurationInstances.loaders = this.mAllLoaderManagers;
        nonConfigurationInstances.voiceInteractor = this.mVoiceInteractor;
        return nonConfigurationInstances;
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != this.mUiThread) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void setActionBar(Toolbar toolbar) {
        if (getActionBar() instanceof WindowDecorActionBar) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set android:windowActionBar to false in your theme to use a Toolbar instead.");
        }
        ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, getTitle(), this);
        this.mActionBar = toolbarActionBar;
        this.mWindow.setCallback(toolbarActionBar.getWrappedWindowCallback());
        this.mActionBar.invalidateOptionsMenu();
    }

    public void setContentTransitionManager(TransitionManager transitionManager) {
        getWindow().setTransitionManager(transitionManager);
    }

    public void setContentView(int i) {
        getWindow().setContentView(i);
        initWindowDecorActionBar();
    }

    public void setContentView(View view) {
        getWindow().setContentView(view);
        initWindowDecorActionBar();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getWindow().setContentView(view, layoutParams);
        initWindowDecorActionBar();
    }

    public final void setDefaultKeyMode(int i) {
        this.mDefaultKeyMode = i;
        switch (i) {
            case 0:
            case 2:
                this.mDefaultKeySsb = null;
                return;
            case 1:
            case 3:
            case 4:
                this.mDefaultKeySsb = new SpannableStringBuilder();
                Selection.setSelection(this.mDefaultKeySsb, 0);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        if (sharedElementCallback == null) {
            sharedElementCallback2 = SharedElementCallback.NULL_CALLBACK;
        }
        this.mEnterTransitionListener = sharedElementCallback2;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        if (sharedElementCallback == null) {
            sharedElementCallback2 = SharedElementCallback.NULL_CALLBACK;
        }
        this.mExitTransitionListener = sharedElementCallback2;
    }

    public final void setFeatureDrawable(int i, Drawable drawable) {
        getWindow().setFeatureDrawable(i, drawable);
    }

    public final void setFeatureDrawableAlpha(int i, int i2) {
        getWindow().setFeatureDrawableAlpha(i, i2);
    }

    public final void setFeatureDrawableResource(int i, int i2) {
        getWindow().setFeatureDrawableResource(i, i2);
    }

    public final void setFeatureDrawableUri(int i, Uri uri) {
        getWindow().setFeatureDrawableUri(i, uri);
    }

    public void setFinishOnTouchOutside(boolean z) {
        this.mWindow.setCloseOnTouchOutside(z);
    }

    public void setImmersive(boolean z) {
        try {
            ActivityManagerNative.getDefault().setImmersive(this.mToken, z);
        } catch (RemoteException e) {
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public final void setMediaController(MediaController mediaController) {
        getWindow().setMediaController(mediaController);
    }

    final void setParent(Activity activity) {
        this.mParent = activity;
    }

    @Deprecated
    public void setPersistent(boolean z) {
    }

    public final void setProgress(int i) {
        getWindow().setFeatureInt(2, i + 0);
    }

    public final void setProgressBarIndeterminate(boolean z) {
        getWindow().setFeatureInt(2, z ? -3 : -4);
    }

    public final void setProgressBarIndeterminateVisibility(boolean z) {
        getWindow().setFeatureInt(5, z ? -1 : -2);
    }

    public final void setProgressBarVisibility(boolean z) {
        getWindow().setFeatureInt(2, z ? -1 : -2);
    }

    public void setRequestedOrientation(int i) {
        if (this.mParent != null) {
            this.mParent.setRequestedOrientation(i);
            return;
        }
        try {
            ActivityManagerNative.getDefault().setRequestedOrientation(this.mToken, i);
        } catch (RemoteException e) {
        }
    }

    public final void setResult(int i) {
        synchronized (this) {
            this.mResultCode = i;
            this.mResultData = null;
        }
    }

    public final void setResult(int i, Intent intent) {
        synchronized (this) {
            this.mResultCode = i;
            this.mResultData = intent;
        }
    }

    public final void setSecondaryProgress(int i) {
        getWindow().setFeatureInt(2, i + 20000);
    }

    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        if (taskDescription.getIconFilename() == null && taskDescription.getIcon() != null) {
            int launcherLargeIconSizeInner = ActivityManager.getLauncherLargeIconSizeInner(this);
            taskDescription = new ActivityManager.TaskDescription(taskDescription.getLabel(), Bitmap.createScaledBitmap(taskDescription.getIcon(), launcherLargeIconSizeInner, launcherLargeIconSizeInner, true), taskDescription.getPrimaryColor());
        }
        try {
            ActivityManagerNative.getDefault().setTaskDescription(this.mToken, taskDescription);
        } catch (RemoteException e) {
        }
    }

    public void setTitle(int i) {
        setTitle(getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        onTitleChanged(charSequence, this.mTitleColor);
        if (this.mParent != null) {
            this.mParent.onChildTitleChanged(this, charSequence);
        }
    }

    @Deprecated
    public void setTitleColor(int i) {
        this.mTitleColor = i;
        onTitleChanged(this.mTitle, i);
    }

    public void setVisible(boolean z) {
        if (this.mVisibleFromClient != z) {
            this.mVisibleFromClient = z;
            if (this.mVisibleFromServer) {
                if (z) {
                    makeVisible();
                } else {
                    this.mDecor.setVisibility(4);
                }
            }
        }
    }

    public final void setVolumeControlStream(int i) {
        getWindow().setVolumeControlStream(i);
    }

    public boolean shouldUpRecreateTask(Intent intent) {
        try {
            PackageManager packageManager = getPackageManager();
            ComponentName component = intent.getComponent();
            ComponentName componentName = component;
            if (component == null) {
                componentName = intent.resolveActivity(packageManager);
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 0);
            if (activityInfo.taskAffinity == null) {
                return false;
            }
            return ActivityManagerNative.getDefault().shouldUpRecreateTask(this.mToken, activityInfo.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        } catch (RemoteException e2) {
            return false;
        }
    }

    @Deprecated
    public final void showDialog(int i) {
        showDialog(i, null);
    }

    @Deprecated
    public final boolean showDialog(int i, Bundle bundle) {
        if (this.mManagedDialogs == null) {
            this.mManagedDialogs = new SparseArray<>();
        }
        ManagedDialog managedDialog = this.mManagedDialogs.get(i);
        ManagedDialog managedDialog2 = managedDialog;
        if (managedDialog == null) {
            managedDialog2 = new ManagedDialog();
            managedDialog2.mDialog = createDialog(Integer.valueOf(i), null, bundle);
            if (managedDialog2.mDialog == null) {
                return false;
            }
            this.mManagedDialogs.put(i, managedDialog2);
        }
        managedDialog2.mArgs = bundle;
        onPrepareDialog(i, managedDialog2.mDialog, bundle);
        managedDialog2.mDialog.show();
        return true;
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mWindow.getDecorView().startActionMode(callback);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        startActivities(intentArr, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mInstrumentation.execStartActivities(this, this.mMainThread.getApplicationThread(), this.mToken, this, intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        if (bundle != null) {
            startActivityForResult(intent, -1, bundle);
        } else {
            startActivityForResult(intent, -1);
        }
    }

    public void startActivityAsCaller(Intent intent, Bundle bundle, int i) {
        if (this.mParent != null) {
            throw new RuntimeException("Can't be called from a child");
        }
        Instrumentation.ActivityResult execStartActivityAsCaller = this.mInstrumentation.execStartActivityAsCaller(this, this.mMainThread.getApplicationThread(), this.mToken, this, intent, -1, bundle, i);
        if (execStartActivityAsCaller != null) {
            this.mMainThread.sendActivityResult(this.mToken, this.mEmbeddedID, -1, execStartActivityAsCaller.getResultCode(), execStartActivityAsCaller.getResultData());
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivityAsUser(Intent intent, Bundle bundle, UserHandle userHandle) {
        if (this.mParent != null) {
            throw new RuntimeException("Can't be called from a child");
        }
        Instrumentation.ActivityResult execStartActivity = this.mInstrumentation.execStartActivity(this, this.mMainThread.getApplicationThread(), this.mToken, this, intent, -1, bundle, userHandle);
        if (execStartActivity != null) {
            this.mMainThread.sendActivityResult(this.mToken, this.mEmbeddedID, -1, execStartActivity.getResultCode(), execStartActivity.getResultData());
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivityAsUser(Intent intent, UserHandle userHandle) {
        startActivityAsUser(intent, null, userHandle);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mParent == null) {
            Instrumentation.ActivityResult execStartActivity = this.mInstrumentation.execStartActivity(this, this.mMainThread.getApplicationThread(), this.mToken, this, intent, i, bundle);
            if (execStartActivity != null) {
                this.mMainThread.sendActivityResult(this.mToken, this.mEmbeddedID, i, execStartActivity.getResultCode(), execStartActivity.getResultData());
            }
            if (i >= 0) {
                this.mStartedActivity = true;
            }
            View peekDecorView = this.mWindow != null ? this.mWindow.peekDecorView() : null;
            if (peekDecorView != null) {
                peekDecorView.cancelPendingInputEvents();
            }
        } else if (bundle != null) {
            this.mParent.startActivityFromChild(this, intent, i, bundle);
        } else {
            this.mParent.startActivityFromChild(this, intent, i);
        }
        if (bundle == null || isTopOfTask()) {
            return;
        }
        this.mActivityTransitionState.startExitOutTransition(this, bundle);
    }

    public void startActivityForResultAsUser(Intent intent, int i, Bundle bundle, UserHandle userHandle) {
        if (bundle != null) {
            this.mActivityTransitionState.startExitOutTransition(this, bundle);
        }
        if (this.mParent != null) {
            throw new RuntimeException("Can't be called from a child");
        }
        Instrumentation.ActivityResult execStartActivity = this.mInstrumentation.execStartActivity(this, this.mMainThread.getApplicationThread(), this.mToken, this, intent, i, bundle, userHandle);
        if (execStartActivity != null) {
            this.mMainThread.sendActivityResult(this.mToken, this.mEmbeddedID, i, execStartActivity.getResultCode(), execStartActivity.getResultData());
        }
        if (i >= 0) {
            this.mStartedActivity = true;
        }
        View peekDecorView = this.mWindow != null ? this.mWindow.peekDecorView() : null;
        if (peekDecorView != null) {
            peekDecorView.cancelPendingInputEvents();
        }
    }

    public void startActivityForResultAsUser(Intent intent, int i, UserHandle userHandle) {
        startActivityForResultAsUser(intent, i, null, userHandle);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        startActivityFromChild(activity, intent, i, null);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        Instrumentation.ActivityResult execStartActivity = this.mInstrumentation.execStartActivity(this, this.mMainThread.getApplicationThread(), this.mToken, activity, intent, i, bundle);
        if (execStartActivity != null) {
            this.mMainThread.sendActivityResult(this.mToken, activity.mEmbeddedID, i, execStartActivity.getResultCode(), execStartActivity.getResultData());
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (bundle != null) {
            this.mActivityTransitionState.startExitOutTransition(this, bundle);
        }
        Instrumentation.ActivityResult execStartActivity = this.mInstrumentation.execStartActivity(this, this.mMainThread.getApplicationThread(), this.mToken, fragment, intent, i, bundle);
        if (execStartActivity != null) {
            this.mMainThread.sendActivityResult(this.mToken, fragment.mWho, i, execStartActivity.getResultCode(), execStartActivity.getResultData());
        }
    }

    public boolean startActivityIfNeeded(Intent intent, int i) {
        return startActivityIfNeeded(intent, i, null);
    }

    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        if (this.mParent == null) {
            int i2 = 1;
            try {
                intent.migrateExtraStreamToClipData();
                intent.prepareToLeaveProcess();
                i2 = ActivityManagerNative.getDefault().startActivity(this.mMainThread.getApplicationThread(), getBasePackageName(), intent, intent.resolveTypeIfNeeded(getContentResolver()), this.mToken, this.mEmbeddedID, i, 1, null, bundle);
            } catch (RemoteException e) {
            }
            Instrumentation.checkStartActivityResult(i2, intent);
            if (i >= 0) {
                this.mStartedActivity = true;
            }
            return i2 != 1;
        }
        throw new UnsupportedOperationException("startActivityIfNeeded can only be called from a top-level activity");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        startIntentSender(intentSender, intent, i, i2, i3, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {
        if (bundle != null) {
            startIntentSenderForResult(intentSender, -1, intent, i, i2, i3, bundle);
        } else {
            startIntentSenderForResult(intentSender, -1, intent, i, i2, i3);
        }
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, null);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mParent == null) {
            startIntentSenderForResultInner(intentSender, i, intent, i2, i3, this, bundle);
        } else if (bundle != null) {
            this.mParent.startIntentSenderFromChild(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            this.mParent.startIntentSenderFromChild(this, intentSender, i, intent, i2, i3, i4);
        }
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, null);
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        startIntentSenderForResultInner(intentSender, i, intent, i2, i3, activity, bundle);
    }

    public void startLockTask() {
        try {
            ActivityManagerNative.getDefault().startLockTaskMode(this.mToken);
        } catch (RemoteException e) {
        }
    }

    @Deprecated
    public void startManagingCursor(Cursor cursor) {
        synchronized (this.mManagedCursors) {
            this.mManagedCursors.add(new ManagedCursor(cursor));
        }
    }

    public boolean startNextMatchingActivity(Intent intent) {
        return startNextMatchingActivity(intent, null);
    }

    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        if (this.mParent == null) {
            try {
                intent.migrateExtraStreamToClipData();
                intent.prepareToLeaveProcess();
                return ActivityManagerNative.getDefault().startNextMatchingActivity(this.mToken, intent, bundle);
            } catch (RemoteException e) {
                return false;
            }
        }
        throw new UnsupportedOperationException("startNextMatchingActivity can only be called from a top-level activity");
    }

    public void startPostponedEnterTransition() {
        this.mActivityTransitionState.startPostponedEnterTransition();
    }

    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        ensureSearchManager();
        this.mSearchManager.startSearch(str, z, getComponentName(), bundle, z2);
    }

    public void stopLockTask() {
        try {
            ActivityManagerNative.getDefault().stopLockTaskMode();
        } catch (RemoteException e) {
        }
    }

    @Deprecated
    public void stopManagingCursor(Cursor cursor) {
        synchronized (this.mManagedCursors) {
            int size = this.mManagedCursors.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (this.mManagedCursors.get(i2).mCursor == cursor) {
                    this.mManagedCursors.remove(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
    }

    public void takeKeyEvents(boolean z) {
        getWindow().takeKeyEvents(z);
    }

    public void triggerSearch(String str, Bundle bundle) {
        ensureSearchManager();
        this.mSearchManager.triggerSearch(str, getComponentName(), bundle);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}

package android.view;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Interpolator;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatProperty;
import android.util.Log;
import android.util.LongSparseLongArray;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.util.SuperNotCalledException;
import android.util.TypedValue;
import android.view.AccessibilityIterators;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.ScrollBarDrawable;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.util.Protocol;
import com.android.internal.util.cm.NavigationRingConstants;
import com.android.internal.util.cm.QSConstants;
import com.android.internal.view.menu.MenuBuilder;
import com.android.org.conscrypt.NativeCrypto;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-4181928-dex2jar.jar:android/view/View.class */
public class View implements Drawable.Callback, KeyEvent.Callback, AccessibilityEventSource {
    public static final int ACCESSIBILITY_CURSOR_POSITION_UNDEFINED = -1;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    static final int ACCESSIBILITY_LIVE_REGION_DEFAULT = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    static final int ALL_RTL_PROPERTIES_RESOLVED = 1610678816;
    public static final Property<View, Float> ALPHA;
    static final int CLICKABLE = 16384;
    private static final boolean DBG = false;
    public static final String DEBUG_LAYOUT_PROPERTY = "debug.layout";
    static final int DISABLED = 32;
    public static final int DRAG_FLAG_GLOBAL = 1;
    static final int DRAG_MASK = 3;
    static final int DRAWING_CACHE_ENABLED = 32768;
    public static final int DRAWING_CACHE_QUALITY_AUTO = 0;
    public static final int DRAWING_CACHE_QUALITY_HIGH = 1048576;
    public static final int DRAWING_CACHE_QUALITY_LOW = 524288;
    static final int DRAWING_CACHE_QUALITY_MASK = 1572864;
    static final int DRAW_MASK = 128;
    static final int DUPLICATE_PARENT_STATE = 4194304;
    protected static final int[] EMPTY_STATE_SET;
    static final int ENABLED = 0;
    protected static final int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    static final int ENABLED_MASK = 32;
    protected static final int[] ENABLED_SELECTED_STATE_SET;
    protected static final int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] ENABLED_STATE_SET;
    protected static final int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
    static final int FADING_EDGE_HORIZONTAL = 4096;
    static final int FADING_EDGE_MASK = 12288;
    static final int FADING_EDGE_NONE = 0;
    static final int FADING_EDGE_VERTICAL = 8192;
    static final int FILTER_TOUCHES_WHEN_OBSCURED = 1024;
    public static final int FIND_VIEWS_WITH_ACCESSIBILITY_NODE_PROVIDERS = 4;
    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    public static final int FIND_VIEWS_WITH_TEXT = 1;
    private static final int FITS_SYSTEM_WINDOWS = 2;
    private static final int FOCUSABLE = 1;
    public static final int FOCUSABLES_ALL = 0;
    public static final int FOCUSABLES_TOUCH_MODE = 1;
    static final int FOCUSABLE_IN_TOUCH_MODE = 262144;
    private static final int FOCUSABLE_MASK = 1;
    protected static final int[] FOCUSED_SELECTED_STATE_SET;
    protected static final int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] FOCUSED_STATE_SET;
    protected static final int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
    public static final int FOCUS_BACKWARD = 1;
    public static final int FOCUS_DOWN = 130;
    public static final int FOCUS_FORWARD = 2;
    public static final int FOCUS_LEFT = 17;
    public static final int FOCUS_RIGHT = 66;
    public static final int FOCUS_UP = 33;
    public static final int GONE = 8;
    public static final int HAPTIC_FEEDBACK_ENABLED = 268435456;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    static final int IMPORTANT_FOR_ACCESSIBILITY_DEFAULT = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int INVISIBLE = 4;
    public static final int KEEP_SCREEN_ON = 67108864;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    private static final int LAYOUT_DIRECTION_DEFAULT = 2;
    private static final int[] LAYOUT_DIRECTION_FLAGS;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    static final int LAYOUT_DIRECTION_RESOLVED_DEFAULT = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    static final int LONG_CLICKABLE = 2097152;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int NAVIGATION_BAR_TRANSIENT = 134217728;
    public static final int NAVIGATION_BAR_TRANSLUCENT = Integer.MIN_VALUE;
    public static final int NAVIGATION_BAR_UNHIDE = 536870912;
    private static final int NOT_FOCUSABLE = 0;
    public static final int NO_ID = -1;
    static final int OPTIONAL_FITS_SYSTEM_WINDOWS = 2048;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    static final int PARENT_SAVE_DISABLED = 536870912;
    static final int PARENT_SAVE_DISABLED_MASK = 536870912;
    static final int PFLAG2_ACCESSIBILITY_FOCUSED = 67108864;
    static final int PFLAG2_ACCESSIBILITY_LIVE_REGION_MASK = 25165824;
    static final int PFLAG2_ACCESSIBILITY_LIVE_REGION_SHIFT = 23;
    static final int PFLAG2_DRAG_CAN_ACCEPT = 1;
    static final int PFLAG2_DRAG_HOVERED = 2;
    static final int PFLAG2_DRAWABLE_RESOLVED = 1073741824;
    static final int PFLAG2_HAS_TRANSIENT_STATE = Integer.MIN_VALUE;
    static final int PFLAG2_IMPORTANT_FOR_ACCESSIBILITY_MASK = 7340032;
    static final int PFLAG2_IMPORTANT_FOR_ACCESSIBILITY_SHIFT = 20;
    static final int PFLAG2_LAYOUT_DIRECTION_MASK = 12;
    static final int PFLAG2_LAYOUT_DIRECTION_MASK_SHIFT = 2;
    static final int PFLAG2_LAYOUT_DIRECTION_RESOLVED = 32;
    static final int PFLAG2_LAYOUT_DIRECTION_RESOLVED_MASK = 48;
    static final int PFLAG2_LAYOUT_DIRECTION_RESOLVED_RTL = 16;
    static final int PFLAG2_PADDING_RESOLVED = 536870912;
    static final int PFLAG2_SUBTREE_ACCESSIBILITY_STATE_CHANGED = 134217728;
    private static final int[] PFLAG2_TEXT_ALIGNMENT_FLAGS;
    static final int PFLAG2_TEXT_ALIGNMENT_MASK = 57344;
    static final int PFLAG2_TEXT_ALIGNMENT_MASK_SHIFT = 13;
    static final int PFLAG2_TEXT_ALIGNMENT_RESOLVED = 65536;
    private static final int PFLAG2_TEXT_ALIGNMENT_RESOLVED_DEFAULT = 131072;
    static final int PFLAG2_TEXT_ALIGNMENT_RESOLVED_MASK = 917504;
    static final int PFLAG2_TEXT_ALIGNMENT_RESOLVED_MASK_SHIFT = 17;
    private static final int[] PFLAG2_TEXT_DIRECTION_FLAGS;
    static final int PFLAG2_TEXT_DIRECTION_MASK = 448;
    static final int PFLAG2_TEXT_DIRECTION_MASK_SHIFT = 6;
    static final int PFLAG2_TEXT_DIRECTION_RESOLVED = 512;
    static final int PFLAG2_TEXT_DIRECTION_RESOLVED_DEFAULT = 1024;
    static final int PFLAG2_TEXT_DIRECTION_RESOLVED_MASK = 7168;
    static final int PFLAG2_TEXT_DIRECTION_RESOLVED_MASK_SHIFT = 10;
    static final int PFLAG2_VIEW_QUICK_REJECTED = 268435456;
    static final int PFLAG3_APPLYING_INSETS = 32;
    static final int PFLAG3_CALLED_SUPER = 16;
    static final int PFLAG3_FITTING_SYSTEM_WINDOWS = 64;
    static final int PFLAG3_IS_LAID_OUT = 4;
    static final int PFLAG3_MEASURE_NEEDED_BEFORE_LAYOUT = 8;
    static final int PFLAG3_NESTED_SCROLLING_ENABLED = 128;
    static final int PFLAG3_VIEW_IS_ANIMATING_ALPHA = 2;
    static final int PFLAG3_VIEW_IS_ANIMATING_TRANSFORM = 1;
    static final int PFLAG_ACTIVATED = 1073741824;
    static final int PFLAG_ALPHA_SET = 262144;
    static final int PFLAG_ANIMATION_STARTED = 65536;
    private static final int PFLAG_AWAKEN_SCROLL_BARS_ON_ATTACH = 134217728;
    static final int PFLAG_CANCEL_NEXT_UP_EVENT = 67108864;
    static final int PFLAG_DIRTY = 2097152;
    static final int PFLAG_DIRTY_MASK = 6291456;
    static final int PFLAG_DIRTY_OPAQUE = 4194304;
    private static final int PFLAG_DOES_NOTHING_REUSE_PLEASE = 536870912;
    static final int PFLAG_DRAWABLE_STATE_DIRTY = 1024;
    static final int PFLAG_DRAWING_CACHE_VALID = 32768;
    static final int PFLAG_DRAWN = 32;
    static final int PFLAG_DRAW_ANIMATION = 64;
    static final int PFLAG_FOCUSED = 2;
    static final int PFLAG_FORCE_LAYOUT = 4096;
    static final int PFLAG_HAS_BOUNDS = 16;
    private static final int PFLAG_HOVERED = 268435456;
    static final int PFLAG_INVALIDATED = Integer.MIN_VALUE;
    static final int PFLAG_IS_ROOT_NAMESPACE = 8;
    static final int PFLAG_LAYOUT_REQUIRED = 8192;
    static final int PFLAG_MEASURED_DIMENSION_SET = 2048;
    static final int PFLAG_ONLY_DRAWS_BACKGROUND = 256;
    static final int PFLAG_OPAQUE_BACKGROUND = 8388608;
    static final int PFLAG_OPAQUE_MASK = 25165824;
    static final int PFLAG_OPAQUE_SCROLLBARS = 16777216;
    private static final int PFLAG_PREPRESSED = 33554432;
    private static final int PFLAG_PRESSED = 16384;
    static final int PFLAG_REQUEST_TRANSPARENT_REGIONS = 512;
    private static final int PFLAG_SAVE_STATE_CALLED = 131072;
    static final int PFLAG_SCROLL_CONTAINER = 524288;
    static final int PFLAG_SCROLL_CONTAINER_ADDED = 1048576;
    static final int PFLAG_SELECTED = 4;
    static final int PFLAG_SKIP_DRAW = 128;
    static final int PFLAG_WANTS_FOCUS = 1;
    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES = 172479;
    protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_STATE_SET;
    protected static final int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_SELECTED_STATE_SET;
    protected static final int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    protected static final int[] PRESSED_STATE_SET;
    protected static final int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
    private static final int PROVIDER_BACKGROUND = 0;
    private static final int PROVIDER_BOUNDS = 2;
    private static final int PROVIDER_NONE = 1;
    private static final int PROVIDER_PADDED_BOUNDS = 3;
    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 16383;
    public static final int RECENT_APPS_VISIBLE = 16384;
    public static final Property<View, Float> ROTATION;
    public static final Property<View, Float> ROTATION_X;
    public static final Property<View, Float> ROTATION_Y;
    static final int SAVE_DISABLED = 65536;
    static final int SAVE_DISABLED_MASK = 65536;
    public static final Property<View, Float> SCALE_X;
    public static final Property<View, Float> SCALE_Y;
    public static final int SCREEN_STATE_OFF = 0;
    public static final int SCREEN_STATE_ON = 1;
    static final int SCROLLBARS_HORIZONTAL = 256;
    static final int SCROLLBARS_INSET_MASK = 16777216;
    public static final int SCROLLBARS_INSIDE_INSET = 16777216;
    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    static final int SCROLLBARS_MASK = 768;
    static final int SCROLLBARS_NONE = 0;
    public static final int SCROLLBARS_OUTSIDE_INSET = 50331648;
    static final int SCROLLBARS_OUTSIDE_MASK = 33554432;
    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
    static final int SCROLLBARS_STYLE_MASK = 50331648;
    static final int SCROLLBARS_VERTICAL = 512;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    protected static final int[] SELECTED_STATE_SET;
    protected static final int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
    public static final int SOUND_EFFECTS_ENABLED = 134217728;
    public static final int STATUS_BAR_DISABLE_BACK = 4194304;
    public static final int STATUS_BAR_DISABLE_CLOCK = 8388608;
    public static final int STATUS_BAR_DISABLE_EXPAND = 65536;
    public static final int STATUS_BAR_DISABLE_HOME = 2097152;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 262144;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 131072;
    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 524288;
    public static final int STATUS_BAR_DISABLE_RECENT = 16777216;
    public static final int STATUS_BAR_DISABLE_SEARCH = 33554432;
    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 1048576;
    public static final int STATUS_BAR_HIDDEN = 1;
    public static final int STATUS_BAR_TRANSIENT = 67108864;
    public static final int STATUS_BAR_TRANSLUCENT = 1073741824;
    public static final int STATUS_BAR_UNHIDE = 268435456;
    public static final int STATUS_BAR_VISIBLE = 0;
    public static final int SYSTEM_UI_ALLOW_TRANSPARENT_VERTICAL_NAV = 16;
    public static final int SYSTEM_UI_CLEARABLE_FLAGS = 7;
    public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    public static final int SYSTEM_UI_FLAG_IMMERSIVE = 2048;
    public static final int SYSTEM_UI_FLAG_IMMERSIVE_STICKY = 4096;
    public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;
    public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536;
    public static final int SYSTEM_UI_TRANSPARENT = 32768;
    public static final int TEXT_ALIGNMENT_CENTER = 4;
    private static final int TEXT_ALIGNMENT_DEFAULT = 1;
    public static final int TEXT_ALIGNMENT_GRAVITY = 1;
    public static final int TEXT_ALIGNMENT_INHERIT = 0;
    static final int TEXT_ALIGNMENT_RESOLVED_DEFAULT = 1;
    public static final int TEXT_ALIGNMENT_TEXT_END = 3;
    public static final int TEXT_ALIGNMENT_TEXT_START = 2;
    public static final int TEXT_ALIGNMENT_VIEW_END = 6;
    public static final int TEXT_ALIGNMENT_VIEW_START = 5;
    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    private static final int TEXT_DIRECTION_DEFAULT = 0;
    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    public static final int TEXT_DIRECTION_INHERIT = 0;
    public static final int TEXT_DIRECTION_LOCALE = 5;
    public static final int TEXT_DIRECTION_LTR = 3;
    static final int TEXT_DIRECTION_RESOLVED_DEFAULT = 1;
    public static final int TEXT_DIRECTION_RTL = 4;
    public static final Property<View, Float> TRANSLATION_X;
    public static final Property<View, Float> TRANSLATION_Y;
    public static final Property<View, Float> TRANSLATION_Z;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    protected static final String VIEW_LOG_TAG = "View";
    static final int VIEW_STATE_ACCELERATED = 64;
    static final int VIEW_STATE_ACTIVATED = 32;
    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 256;
    static final int VIEW_STATE_DRAG_HOVERED = 512;
    static final int VIEW_STATE_ENABLED = 8;
    static final int VIEW_STATE_FOCUSED = 4;
    static final int VIEW_STATE_HOVERED = 128;
    static final int VIEW_STATE_PRESSED = 16;
    static final int VIEW_STATE_SELECTED = 2;
    private static final int[][] VIEW_STATE_SETS;
    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    static final int VISIBILITY_MASK = 12;
    public static final int VISIBLE = 0;
    static final int WILL_NOT_CACHE_DRAWING = 131072;
    static final int WILL_NOT_DRAW = 128;
    protected static final int[] WINDOW_FOCUSED_STATE_SET;
    public static final Property<View, Float> X;
    public static final Property<View, Float> Y;
    public static final Property<View, Float> Z;
    private static SparseArray<String> mAttributeMap;
    private static int sNextAccessibilityViewId;
    private static final AtomicInteger sNextGeneratedId;
    static final ThreadLocal<Rect> sThreadLocal;
    private int mAccessibilityCursorPosition;
    AccessibilityDelegate mAccessibilityDelegate;
    private int mAccessibilityTraversalAfterId;
    private int mAccessibilityTraversalBeforeId;
    int mAccessibilityViewId;
    private ViewPropertyAnimator mAnimator;
    AttachInfo mAttachInfo;
    @ViewDebug.ExportedProperty(category = "attributes", hasAdjacentMapping = true)
    public String[] mAttributes;
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "bg_")
    private Drawable mBackground;
    private RenderNode mBackgroundRenderNode;
    private int mBackgroundResource;
    private boolean mBackgroundSizeChanged;
    private TintInfo mBackgroundTint;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mBottom;
    public boolean mCachingFailed;
    Rect mClipBounds;
    private CharSequence mContentDescription;
    @ViewDebug.ExportedProperty(deepExport = true)
    protected Context mContext;
    protected Animation mCurrentAnimation;
    private int[] mDrawableState;
    private Bitmap mDrawingCache;
    private int mDrawingCacheBackgroundColor;
    private ViewTreeObserver mFloatingTreeObserver;
    GhostView mGhostView;
    private boolean mHasPerformedLongPress;
    @ViewDebug.ExportedProperty(resolveId = true)
    int mID;
    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier;
    private SparseArray<Object> mKeyedTags;
    private int mLabelForId;
    private boolean mLastIsOpaque;
    Paint mLayerPaint;
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 1, to = "SOFTWARE"), @ViewDebug.IntToString(from = 2, to = "HARDWARE")})
    int mLayerType;
    private Insets mLayoutInsets;
    protected ViewGroup.LayoutParams mLayoutParams;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mLeft;
    private boolean mLeftPaddingDefined;
    ListenerInfo mListenerInfo;
    private MatchIdPredicate mMatchIdPredicate;
    private MatchLabelForPredicate mMatchLabelForPredicate;
    private LongSparseLongArray mMeasureCache;
    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredHeight;
    @ViewDebug.ExportedProperty(category = "measurement")
    int mMeasuredWidth;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinHeight;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mMinWidth;
    private ViewParent mNestedScrollingParent;
    private int mNextFocusDownId;
    int mNextFocusForwardId;
    private int mNextFocusLeftId;
    private int mNextFocusRightId;
    private int mNextFocusUpId;
    int mOldHeightMeasureSpec;
    int mOldWidthMeasureSpec;
    ViewOutlineProvider mOutlineProvider;
    private int mOverScrollMode;
    ViewOverlay mOverlay;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingBottom;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mPaddingTop;
    protected ViewParent mParent;
    private CheckForLongPress mPendingCheckForLongPress;
    private CheckForTap mPendingCheckForTap;
    private PerformClick mPerformClick;
    @ViewDebug.ExportedProperty(flagMapping = {@ViewDebug.FlagToString(equals = 4096, mask = 4096, name = "FORCE_LAYOUT"), @ViewDebug.FlagToString(equals = 8192, mask = 8192, name = "LAYOUT_REQUIRED"), @ViewDebug.FlagToString(equals = 32768, mask = 32768, name = "DRAWING_CACHE_INVALID", outputIf = false), @ViewDebug.FlagToString(equals = 32, mask = 32, name = "DRAWN", outputIf = true), @ViewDebug.FlagToString(equals = 32, mask = 32, name = "NOT_DRAWN", outputIf = false), @ViewDebug.FlagToString(equals = 4194304, mask = PFLAG_DIRTY_MASK, name = "DIRTY_OPAQUE"), @ViewDebug.FlagToString(equals = 2097152, mask = PFLAG_DIRTY_MASK, name = "DIRTY")}, formatToHexString = true)
    int mPrivateFlags;
    int mPrivateFlags2;
    int mPrivateFlags3;
    boolean mRecreateDisplayList;
    final RenderNode mRenderNode;
    private final Resources mResources;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mRight;
    private boolean mRightPaddingDefined;
    private ScrollabilityCache mScrollCache;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollX;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mScrollY;
    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
    SendViewStateChangedAccessibilityEvent mSendViewStateChangedAccessibilityEvent;
    private boolean mSendingHoverAccessibilityEvents;
    private StateListAnimator mStateListAnimator;
    @ViewDebug.ExportedProperty(flagMapping = {@ViewDebug.FlagToString(equals = 1, mask = 1, name = "SYSTEM_UI_FLAG_LOW_PROFILE", outputIf = true), @ViewDebug.FlagToString(equals = 2, mask = 2, name = "SYSTEM_UI_FLAG_HIDE_NAVIGATION", outputIf = true), @ViewDebug.FlagToString(equals = 0, mask = PUBLIC_STATUS_BAR_VISIBILITY_MASK, name = "SYSTEM_UI_FLAG_VISIBLE", outputIf = true)}, formatToHexString = true)
    int mSystemUiVisibility;
    protected Object mTag;
    private int[] mTempNestedScrollConsumed;
    @ViewDebug.ExportedProperty(category = "layout")
    protected int mTop;
    private TouchDelegate mTouchDelegate;
    private int mTouchSlop;
    TransformationInfo mTransformationInfo;
    int mTransientStateCount;
    private String mTransitionName;
    private Bitmap mUnscaledDrawingCache;
    private UnsetPressedState mUnsetPressedState;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingBottom;
    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingEnd;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingLeft;
    int mUserPaddingLeftInitial;
    @ViewDebug.ExportedProperty(category = "padding")
    protected int mUserPaddingRight;
    int mUserPaddingRightInitial;
    @ViewDebug.ExportedProperty(category = "padding")
    int mUserPaddingStart;
    private float mVerticalScrollFactor;
    private int mVerticalScrollbarPosition;
    @ViewDebug.ExportedProperty(formatToHexString = true)
    int mViewFlags;
    int mWindowAttachCount;
    public static boolean mDebugViewAttributes = false;
    private static boolean sCompatibilityDone = false;
    private static boolean sUseBrokenMakeMeasureSpec = false;
    private static boolean sIgnoreMeasureCache = false;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int[] DRAWING_CACHE_QUALITY_FLAGS = {0, 524288, 1048576};
    static final int[] VIEW_STATE_IDS = {R.attr.state_window_focused, 1, R.attr.state_selected, 2, R.attr.state_focused, 4, R.attr.state_enabled, 8, R.attr.state_pressed, 16, R.attr.state_activated, 32, R.attr.state_accelerated, 64, R.attr.state_hovered, 128, R.attr.state_drag_can_accept, 256, R.attr.state_drag_hovered, 512};

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$AccessibilityDelegate.class */
    public static class AccessibilityDelegate {
        public AccessibilityNodeInfo createAccessibilityNodeInfo(View view) {
            return view.createAccessibilityNodeInfoInternal();
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return view.dispatchPopulateAccessibilityEventInternal(accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            view.onInitializeAccessibilityEventInternal(accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            view.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            view.onPopulateAccessibilityEventInternal(accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return viewGroup.onRequestSendAccessibilityEventInternal(view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityActionInternal(i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            view.sendAccessibilityEventInternal(i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            view.sendAccessibilityEventUncheckedInternal(accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$AttachInfo.class */
    public static final class AttachInfo {
        int mAccessibilityFetchFlags;
        Drawable mAccessibilityFocusDrawable;
        float mApplicationScale;
        Canvas mCanvas;
        int mDisabledSystemUiVisibility;
        final Display mDisplay;
        long mDrawingTime;
        boolean mForceReportNewAttributes;
        int mGlobalSystemUiVisibility;
        final Handler mHandler;
        boolean mHardwareAccelerated;
        boolean mHardwareAccelerationRequested;
        HardwareRenderer mHardwareRenderer;
        boolean mHasNonEmptyGivenInternalInsets;
        boolean mHasSystemUiListeners;
        boolean mHasWindowFocus;
        boolean mHighContrastText;
        IWindowId mIWindowId;
        boolean mIgnoreDirtyState;
        boolean mInTouchMode;
        boolean mKeepScreenOn;
        boolean mOverscanRequested;
        IBinder mPanelParentWindowToken;
        List<RenderNode> mPendingAnimatingRenderNodes;
        boolean mRecomputeGlobalAttributes;
        final Callbacks mRootCallbacks;
        View mRootView;
        boolean mScalingRequired;
        final IWindowSession mSession;
        int mSystemUiVisibility;
        boolean mTurnOffWindowResizeAnim;
        boolean mUnbufferedDispatchRequested;
        boolean mUse32BitDrawingCache;
        View mViewRequestingLayout;
        final ViewRootImpl mViewRootImpl;
        boolean mViewScrollChanged;
        boolean mViewVisibilityChanged;
        final IWindow mWindow;
        WindowId mWindowId;
        int mWindowLeft;
        final IBinder mWindowToken;
        int mWindowTop;
        int mWindowVisibility;
        int mDisplayState = 0;
        final Rect mOverscanInsets = new Rect();
        final Rect mContentInsets = new Rect();
        final Rect mVisibleInsets = new Rect();
        final Rect mStableInsets = new Rect();
        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets = new ViewTreeObserver.InternalInsetsInfo();
        final ArrayList<View> mScrollContainers = new ArrayList<>();
        final KeyEvent.DispatcherState mKeyDispatchState = new KeyEvent.DispatcherState();
        boolean mSetIgnoreDirtyState = false;
        final int[] mTransparentLocation = new int[2];
        final int[] mInvalidateChildLocation = new int[2];
        final int[] mTmpLocation = new int[2];
        final float[] mTmpTransformLocation = new float[2];
        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        final Rect mTmpInvalRect = new Rect();
        final RectF mTmpTransformRect = new RectF();
        final RectF mTmpTransformRect1 = new RectF();
        final List<RectF> mTmpRectList = new ArrayList();
        final Matrix mTmpMatrix = new Matrix();
        final Transformation mTmpTransformation = new Transformation();
        final Outline mTmpOutline = new Outline();
        final ArrayList<View> mTempArrayList = new ArrayList<>(24);
        int mAccessibilityWindowId = Integer.MAX_VALUE;
        boolean mDebugLayout = SystemProperties.getBoolean(View.DEBUG_LAYOUT_PROPERTY, false);
        final Point mPoint = new Point();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-4181928-dex2jar.jar:android/view/View$AttachInfo$Callbacks.class */
        public interface Callbacks {
            boolean performHapticFeedback(int i, boolean z);

            void playSoundEffect(int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-4181928-dex2jar.jar:android/view/View$AttachInfo$InvalidateInfo.class */
        public static class InvalidateInfo {
            private static final int POOL_LIMIT = 10;
            private static final Pools.SynchronizedPool<InvalidateInfo> sPool = new Pools.SynchronizedPool<>(10);
            int bottom;
            int left;
            int right;
            View target;
            int top;

            InvalidateInfo() {
            }

            public static InvalidateInfo obtain() {
                InvalidateInfo invalidateInfo = (InvalidateInfo) sPool.acquire();
                return invalidateInfo != null ? invalidateInfo : new InvalidateInfo();
            }

            public void recycle() {
                this.target = null;
                sPool.release(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public AttachInfo(IWindowSession iWindowSession, IWindow iWindow, Display display, ViewRootImpl viewRootImpl, Handler handler, Callbacks callbacks) {
            this.mSession = iWindowSession;
            this.mWindow = iWindow;
            this.mWindowToken = iWindow.asBinder();
            this.mDisplay = display;
            this.mViewRootImpl = viewRootImpl;
            this.mHandler = handler;
            this.mRootCallbacks = callbacks;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$BaseSavedState.class */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() { // from class: android.view.View.BaseSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$CheckForLongPress.class */
    public final class CheckForLongPress implements Runnable {
        private int mOriginalWindowAttachCount;

        private CheckForLongPress() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalWindowAttachCount = View.this.mWindowAttachCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (View.this.isPressed() && View.this.mParent != null && this.mOriginalWindowAttachCount == View.this.mWindowAttachCount && View.this.performLongClick()) {
                View.this.mHasPerformedLongPress = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$CheckForTap.class */
    public final class CheckForTap implements Runnable {
        public float x;
        public float y;

        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View.this.mPrivateFlags &= -33554433;
            View.this.setPressed(true, this.x, this.y);
            View.this.checkForLongClick(ViewConfiguration.getTapTimeout());
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$DragShadowBuilder.class */
    public static class DragShadowBuilder {
        private final WeakReference<View> mView;

        public DragShadowBuilder() {
            this.mView = new WeakReference<>(null);
        }

        public DragShadowBuilder(View view) {
            this.mView = new WeakReference<>(view);
        }

        public final View getView() {
            return this.mView.get();
        }

        public void onDrawShadow(Canvas canvas) {
            View view = this.mView.get();
            if (view != null) {
                view.draw(canvas);
            } else {
                Log.e(View.VIEW_LOG_TAG, "Asked to draw drag shadow but no view");
            }
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
            View view = this.mView.get();
            if (view == null) {
                Log.e(View.VIEW_LOG_TAG, "Asked for drag thumb metrics but no view");
                return;
            }
            point.set(view.getWidth(), view.getHeight());
            point2.set(point.x / 2, point.y / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$ListenerInfo.class */
    public static class ListenerInfo {
        OnApplyWindowInsetsListener mOnApplyWindowInsetsListener;
        private CopyOnWriteArrayList<OnAttachStateChangeListener> mOnAttachStateChangeListeners;
        public OnClickListener mOnClickListener;
        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
        private OnDragListener mOnDragListener;
        protected OnFocusChangeListener mOnFocusChangeListener;
        private OnGenericMotionListener mOnGenericMotionListener;
        private OnHoverListener mOnHoverListener;
        private OnKeyListener mOnKeyListener;
        private ArrayList<OnLayoutChangeListener> mOnLayoutChangeListeners;
        protected OnLongClickListener mOnLongClickListener;
        protected OnScrollChangeListener mOnScrollChangeListener;
        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        private OnTouchListener mOnTouchListener;

        ListenerInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$MatchIdPredicate.class */
    public class MatchIdPredicate implements Predicate<View> {
        public int mId;

        private MatchIdPredicate() {
        }

        @Override // com.android.internal.util.Predicate
        public boolean apply(View view) {
            return view.mID == this.mId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$MatchLabelForPredicate.class */
    public class MatchLabelForPredicate implements Predicate<View> {
        private int mLabeledId;

        private MatchLabelForPredicate() {
        }

        @Override // com.android.internal.util.Predicate
        public boolean apply(View view) {
            return view.mLabelForId == this.mLabeledId;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$MeasureSpec.class */
    public static class MeasureSpec {
        public static final int AT_MOST = Integer.MIN_VALUE;
        public static final int EXACTLY = 1073741824;
        private static final int MODE_MASK = -1073741824;
        private static final int MODE_SHIFT = 30;
        public static final int UNSPECIFIED = 0;

        static int adjust(int i, int i2) {
            int mode = getMode(i);
            if (mode == 0) {
                return makeMeasureSpec(0, 0);
            }
            int size = getSize(i) + i2;
            int i3 = size;
            if (size < 0) {
                Log.e(View.VIEW_LOG_TAG, "MeasureSpec.adjust: new size would be negative! (" + size + ") spec: " + toString(i) + " delta: " + i2);
                i3 = 0;
            }
            return makeMeasureSpec(i3, mode);
        }

        public static int getMode(int i) {
            return MODE_MASK & i;
        }

        public static int getSize(int i) {
            return 1073741823 & i;
        }

        public static int makeMeasureSpec(int i, int i2) {
            return View.sUseBrokenMakeMeasureSpec ? i + i2 : (1073741823 & i) | (MODE_MASK & i2);
        }

        public static String toString(int i) {
            int mode = getMode(i);
            int size = getSize(i);
            StringBuilder sb = new StringBuilder("MeasureSpec: ");
            if (mode == 0) {
                sb.append("UNSPECIFIED ");
            } else if (mode == 1073741824) {
                sb.append("EXACTLY ");
            } else if (mode == Integer.MIN_VALUE) {
                sb.append("AT_MOST ");
            } else {
                sb.append(mode).append(" ");
            }
            sb.append(size);
            return sb.toString();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnApplyWindowInsetsListener.class */
    public interface OnApplyWindowInsetsListener {
        WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnAttachStateChangeListener.class */
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnClickListener.class */
    public interface OnClickListener {
        void onClick(View view);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnCreateContextMenuListener.class */
    public interface OnCreateContextMenuListener {
        void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnDragListener.class */
    public interface OnDragListener {
        boolean onDrag(View view, DragEvent dragEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnFocusChangeListener.class */
    public interface OnFocusChangeListener {
        void onFocusChange(View view, boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnGenericMotionListener.class */
    public interface OnGenericMotionListener {
        boolean onGenericMotion(View view, MotionEvent motionEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnHoverListener.class */
    public interface OnHoverListener {
        boolean onHover(View view, MotionEvent motionEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnKeyListener.class */
    public interface OnKeyListener {
        boolean onKey(View view, int i, KeyEvent keyEvent);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnLayoutChangeListener.class */
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnLongClickListener.class */
    public interface OnLongClickListener {
        boolean onLongClick(View view);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnScrollChangeListener.class */
    public interface OnScrollChangeListener {
        void onScrollChange(View view, int i, int i2, int i3, int i4);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnSystemUiVisibilityChangeListener.class */
    public interface OnSystemUiVisibilityChangeListener {
        void onSystemUiVisibilityChange(int i);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/View$OnTouchListener.class */
    public interface OnTouchListener {
        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$PerformClick.class */
    public final class PerformClick implements Runnable {
        private PerformClick() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View.this.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$ScrollabilityCache.class */
    public static class ScrollabilityCache implements Runnable {
        public static final int FADING = 2;
        public static final int OFF = 0;
        public static final int ON = 1;
        private static final float[] OPAQUE = {255.0f};
        private static final float[] TRANSPARENT = {0.0f};
        public boolean fadeScrollBars;
        public long fadeStartTime;
        public int fadingEdgeLength;
        public View host;
        public float[] interpolatorValues;
        private int mLastColor;
        public ScrollBarDrawable scrollBar;
        public int scrollBarSize;
        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        public int state = 0;
        public int scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
        public int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
        public final Paint paint = new Paint();
        public final Matrix matrix = new Matrix();
        public Shader shader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, (int) View.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);

        public ScrollabilityCache(ViewConfiguration viewConfiguration, View view) {
            this.fadingEdgeLength = viewConfiguration.getScaledFadingEdgeLength();
            this.scrollBarSize = viewConfiguration.getScaledScrollBarSize();
            this.paint.setShader(this.shader);
            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.host = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis >= this.fadeStartTime) {
                int i = (int) currentAnimationTimeMillis;
                Interpolator interpolator = this.scrollBarInterpolator;
                interpolator.setKeyFrame(0, i, OPAQUE);
                interpolator.setKeyFrame(0 + 1, i + this.scrollBarFadeDuration, TRANSPARENT);
                this.state = 2;
                this.host.invalidate(true);
            }
        }

        public void setFadeColor(int i) {
            if (i != this.mLastColor) {
                this.mLastColor = i;
                if (i != 0) {
                    this.shader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, (-16777216) | i, i & 16777215, Shader.TileMode.CLAMP);
                    this.paint.setShader(this.shader);
                    this.paint.setXfermode(null);
                    return;
                }
                this.shader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, (int) View.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);
                this.paint.setShader(this.shader);
                this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$SendViewScrolledAccessibilityEvent.class */
    public class SendViewScrolledAccessibilityEvent implements Runnable {
        public volatile boolean mIsPending;

        private SendViewScrolledAccessibilityEvent() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View.this.sendAccessibilityEvent(4096);
            this.mIsPending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$SendViewStateChangedAccessibilityEvent.class */
    public class SendViewStateChangedAccessibilityEvent implements Runnable {
        private int mChangeTypes;
        private long mLastEventTimeMillis;
        private boolean mPosted;
        private boolean mPostedWithDelay;

        private SendViewStateChangedAccessibilityEvent() {
            this.mChangeTypes = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mPosted = false;
            this.mPostedWithDelay = false;
            this.mLastEventTimeMillis = SystemClock.uptimeMillis();
            if (AccessibilityManager.getInstance(View.this.mContext).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                obtain.setContentChangeTypes(this.mChangeTypes);
                View.this.sendAccessibilityEventUnchecked(obtain);
            }
            this.mChangeTypes = 0;
        }

        public void runOrPost(int i) {
            this.mChangeTypes |= i;
            if (View.this.inLiveRegion()) {
                if (this.mPostedWithDelay) {
                    View.this.removeCallbacks(this);
                    this.mPostedWithDelay = false;
                }
                if (this.mPosted) {
                    return;
                }
                View.this.post(this);
                this.mPosted = true;
            } else if (this.mPosted) {
            } else {
                long uptimeMillis = SystemClock.uptimeMillis() - this.mLastEventTimeMillis;
                long sendRecurringAccessibilityEventsInterval = ViewConfiguration.getSendRecurringAccessibilityEventsInterval();
                if (uptimeMillis >= sendRecurringAccessibilityEventsInterval) {
                    View.this.removeCallbacks(this);
                    run();
                    return;
                }
                View.this.postDelayed(this, sendRecurringAccessibilityEventsInterval - uptimeMillis);
                this.mPostedWithDelay = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$TintInfo.class */
    public static class TintInfo {
        boolean mHasTintList;
        boolean mHasTintMode;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;

        private TintInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$TransformationInfo.class */
    public static class TransformationInfo {
        private Matrix mInverseMatrix;
        private final Matrix mMatrix = new Matrix();
        @ViewDebug.ExportedProperty
        float mAlpha = 1.0f;
        float mTransitionAlpha = 1.0f;

        TransformationInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/View$UnsetPressedState.class */
    public final class UnsetPressedState implements Runnable {
        private UnsetPressedState() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View.this.setPressed(false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [int[], int[][]] */
    static {
        if (VIEW_STATE_IDS.length / 2 != R.styleable.ViewDrawableStates.length) {
            throw new IllegalStateException("VIEW_STATE_IDs array length does not match ViewDrawableStates style array");
        }
        int[] iArr = new int[VIEW_STATE_IDS.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= R.styleable.ViewDrawableStates.length) {
                break;
            }
            int i3 = R.styleable.ViewDrawableStates[i2];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < VIEW_STATE_IDS.length) {
                    if (VIEW_STATE_IDS[i5] == i3) {
                        iArr[i2 * 2] = i3;
                        iArr[(i2 * 2) + 1] = VIEW_STATE_IDS[i5 + 1];
                    }
                    i4 = i5 + 2;
                }
            }
            i = i2 + 1;
        }
        VIEW_STATE_SETS = new int[1 << (VIEW_STATE_IDS.length / 2)];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= VIEW_STATE_SETS.length) {
                EMPTY_STATE_SET = VIEW_STATE_SETS[0];
                WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[1];
                SELECTED_STATE_SET = VIEW_STATE_SETS[2];
                SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[3];
                FOCUSED_STATE_SET = VIEW_STATE_SETS[4];
                FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[5];
                FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[6];
                FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[7];
                ENABLED_STATE_SET = VIEW_STATE_SETS[8];
                ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[9];
                ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[10];
                ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[11];
                ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[12];
                ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[13];
                ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[14];
                ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[15];
                PRESSED_STATE_SET = VIEW_STATE_SETS[16];
                PRESSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[17];
                PRESSED_SELECTED_STATE_SET = VIEW_STATE_SETS[18];
                PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[19];
                PRESSED_FOCUSED_STATE_SET = VIEW_STATE_SETS[20];
                PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[21];
                PRESSED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[22];
                PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[23];
                PRESSED_ENABLED_STATE_SET = VIEW_STATE_SETS[24];
                PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[25];
                PRESSED_ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[26];
                PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[27];
                PRESSED_ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[28];
                PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[29];
                PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[30];
                PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[31];
                sThreadLocal = new ThreadLocal<>();
                LAYOUT_DIRECTION_FLAGS = new int[]{0, 1, 2, 3};
                PFLAG2_TEXT_DIRECTION_FLAGS = new int[]{0, 64, 128, 192, 256, NativeCrypto.SSL3_RT_MAX_ENCRYPTED_OVERHEAD};
                PFLAG2_TEXT_ALIGNMENT_FLAGS = new int[]{0, 8192, 16384, 24576, 32768, 40960, 49152};
                sNextGeneratedId = new AtomicInteger(1);
                ALPHA = new FloatProperty<View>("alpha") { // from class: android.view.View.3
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getAlpha());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setAlpha(f);
                    }
                };
                TRANSLATION_X = new FloatProperty<View>("translationX") { // from class: android.view.View.4
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getTranslationX());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setTranslationX(f);
                    }
                };
                TRANSLATION_Y = new FloatProperty<View>("translationY") { // from class: android.view.View.5
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getTranslationY());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setTranslationY(f);
                    }
                };
                TRANSLATION_Z = new FloatProperty<View>("translationZ") { // from class: android.view.View.6
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getTranslationZ());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setTranslationZ(f);
                    }
                };
                X = new FloatProperty<View>("x") { // from class: android.view.View.7
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getX());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setX(f);
                    }
                };
                Y = new FloatProperty<View>("y") { // from class: android.view.View.8
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getY());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setY(f);
                    }
                };
                Z = new FloatProperty<View>("z") { // from class: android.view.View.9
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getZ());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setZ(f);
                    }
                };
                ROTATION = new FloatProperty<View>(QSConstants.TILE_ROTATION) { // from class: android.view.View.10
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getRotation());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setRotation(f);
                    }
                };
                ROTATION_X = new FloatProperty<View>("rotationX") { // from class: android.view.View.11
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getRotationX());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setRotationX(f);
                    }
                };
                ROTATION_Y = new FloatProperty<View>("rotationY") { // from class: android.view.View.12
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getRotationY());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setRotationY(f);
                    }
                };
                SCALE_X = new FloatProperty<View>("scaleX") { // from class: android.view.View.13
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getScaleX());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setScaleX(f);
                    }
                };
                SCALE_Y = new FloatProperty<View>("scaleY") { // from class: android.view.View.14
                    @Override // android.util.Property
                    public Float get(View view) {
                        return Float.valueOf(view.getScaleY());
                    }

                    @Override // android.util.FloatProperty
                    public void setValue(View view, float f) {
                        view.setScaleY(f);
                    }
                };
                return;
            }
            int[] iArr2 = new int[Integer.bitCount(i7)];
            int i8 = 0;
            int i9 = 0;
            while (i9 < iArr.length) {
                int i10 = i8;
                if ((iArr[i9 + 1] & i7) != 0) {
                    iArr2[i8] = iArr[i9];
                    i10 = i8 + 1;
                }
                i9 += 2;
                i8 = i10;
            }
            VIEW_STATE_SETS[i7] = iArr2;
            i6 = i7 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View() {
        this.mCurrentAnimation = null;
        this.mRecreateDisplayList = false;
        this.mID = -1;
        this.mAccessibilityViewId = -1;
        this.mAccessibilityCursorPosition = -1;
        this.mTag = null;
        this.mTransientStateCount = 0;
        this.mClipBounds = null;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mLabelForId = -1;
        this.mAccessibilityTraversalBeforeId = -1;
        this.mAccessibilityTraversalAfterId = -1;
        this.mLeftPaddingDefined = false;
        this.mRightPaddingDefined = false;
        this.mOldWidthMeasureSpec = Integer.MIN_VALUE;
        this.mOldHeightMeasureSpec = Integer.MIN_VALUE;
        this.mDrawableState = null;
        this.mOutlineProvider = ViewOutlineProvider.BACKGROUND;
        this.mNextFocusLeftId = -1;
        this.mNextFocusRightId = -1;
        this.mNextFocusUpId = -1;
        this.mNextFocusDownId = -1;
        this.mNextFocusForwardId = -1;
        this.mPendingCheckForTap = null;
        this.mTouchDelegate = null;
        this.mDrawingCacheBackgroundColor = 0;
        this.mAnimator = null;
        this.mLayerType = 0;
        this.mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 0) : null;
        this.mResources = null;
        this.mRenderNode = RenderNode.create(getClass().getName(), this);
    }

    public View(Context context) {
        this.mCurrentAnimation = null;
        this.mRecreateDisplayList = false;
        this.mID = -1;
        this.mAccessibilityViewId = -1;
        this.mAccessibilityCursorPosition = -1;
        this.mTag = null;
        this.mTransientStateCount = 0;
        this.mClipBounds = null;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mLabelForId = -1;
        this.mAccessibilityTraversalBeforeId = -1;
        this.mAccessibilityTraversalAfterId = -1;
        this.mLeftPaddingDefined = false;
        this.mRightPaddingDefined = false;
        this.mOldWidthMeasureSpec = Integer.MIN_VALUE;
        this.mOldHeightMeasureSpec = Integer.MIN_VALUE;
        this.mDrawableState = null;
        this.mOutlineProvider = ViewOutlineProvider.BACKGROUND;
        this.mNextFocusLeftId = -1;
        this.mNextFocusRightId = -1;
        this.mNextFocusUpId = -1;
        this.mNextFocusDownId = -1;
        this.mNextFocusForwardId = -1;
        this.mPendingCheckForTap = null;
        this.mTouchDelegate = null;
        this.mDrawingCacheBackgroundColor = 0;
        this.mAnimator = null;
        this.mLayerType = 0;
        this.mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ? new InputEventConsistencyVerifier(this, 0) : null;
        this.mContext = context;
        this.mResources = context != null ? context.getResources() : null;
        this.mViewFlags = 402653184;
        this.mPrivateFlags2 = 140296;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOverScrollMode(1);
        this.mUserPaddingStart = Integer.MIN_VALUE;
        this.mUserPaddingEnd = Integer.MIN_VALUE;
        this.mRenderNode = RenderNode.create(getClass().getName(), this);
        if (sCompatibilityDone || context == null) {
            return;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        sUseBrokenMakeMeasureSpec = i <= 17;
        sIgnoreMeasureCache = i < 19;
        sCompatibilityDone = true;
    }

    public View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public View(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, i, i2);
        if (mDebugViewAttributes) {
            saveAttributeData(attributeSet, obtainStyledAttributes);
        }
        Drawable drawable = null;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MIN_VALUE;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        boolean z = false;
        int i12 = 0;
        int i13 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 1.0f;
        float f9 = 1.0f;
        boolean z2 = false;
        int i14 = 0;
        int i15 = this.mOverScrollMode;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i16 = context.getApplicationInfo().targetSdkVersion;
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i17 = 0;
        while (i17 < indexCount) {
            int index = obtainStyledAttributes.getIndex(i17);
            Drawable drawable2 = drawable;
            int i18 = i6;
            float f10 = f4;
            int i19 = i8;
            boolean z8 = z5;
            boolean z9 = z3;
            int i20 = i3;
            boolean z10 = z6;
            int i21 = i15;
            int i22 = i9;
            int i23 = i5;
            boolean z11 = z7;
            float f11 = f5;
            float f12 = f6;
            float f13 = f7;
            int i24 = i14;
            boolean z12 = z;
            int i25 = i7;
            boolean z13 = z4;
            float f14 = f8;
            float f15 = f9;
            int i26 = i4;
            boolean z14 = z2;
            float f16 = f;
            float f17 = f2;
            float f18 = f3;
            int i27 = i11;
            int i28 = i10;
            int i29 = i12;
            int i30 = i13;
            switch (index) {
                case 8:
                    int i31 = obtainStyledAttributes.getInt(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i31;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i31 != 0) {
                        i28 = i10 | (50331648 & i31);
                        i27 = i11 | 50331648;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i31;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 9:
                    this.mID = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 10:
                    this.mTag = obtainStyledAttributes.getText(index);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 11:
                    i29 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 12:
                    i30 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 13:
                    drawable2 = obtainStyledAttributes.getDrawable(index);
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 14:
                    i22 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.mUserPaddingLeftInitial = i22;
                    this.mUserPaddingRightInitial = i22;
                    z10 = true;
                    z11 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    i21 = i15;
                    i23 = i5;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 15:
                    i20 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.mUserPaddingLeftInitial = i20;
                    z10 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 16:
                    i26 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 17:
                    i23 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.mUserPaddingRightInitial = i23;
                    z11 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 18:
                    i18 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    drawable2 = drawable;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 19:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 1;
                        i27 = i11 | 1;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 20:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 262145;
                        i27 = i11 | 262145;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 21:
                    int i32 = obtainStyledAttributes.getInt(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i32 != 0) {
                        i28 = i10 | VISIBILITY_FLAGS[i32];
                        i27 = i11 | 12;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 22:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 2;
                        i27 = i11 | 2;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 23:
                    int i33 = obtainStyledAttributes.getInt(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i33 != 0) {
                        i28 = i10 | i33;
                        i27 = i11 | 768;
                        z9 = true;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 24:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i16 >= 14) {
                        continue;
                        i17++;
                        drawable = drawable2;
                        i6 = i18;
                        f4 = f10;
                        i8 = i19;
                        z5 = z8;
                        z3 = z9;
                        i3 = i20;
                        z6 = z10;
                        i15 = i21;
                        i9 = i22;
                        i5 = i23;
                        z7 = z11;
                        f5 = f11;
                        f6 = f12;
                        f7 = f13;
                        i14 = i24;
                        z = z12;
                        i7 = i25;
                        z4 = z13;
                        f8 = f14;
                        f9 = f15;
                        i4 = i26;
                        z2 = z14;
                        f = f16;
                        f2 = f17;
                        f3 = f18;
                        i11 = i27;
                        i10 = i28;
                        i12 = i29;
                        i13 = i30;
                    }
                    break;
                case 25:
                case 43:
                case 44:
                case 45:
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 26:
                    this.mNextFocusLeftId = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 27:
                    this.mNextFocusRightId = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 28:
                    this.mNextFocusUpId = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 29:
                    this.mNextFocusDownId = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 30:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 16384;
                        i27 = i11 | 16384;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 31:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 2097152;
                        i27 = i11 | 2097152;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 32:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, true)) {
                        continue;
                    } else {
                        i28 = i10 | 65536;
                        i27 = i11 | 65536;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 33:
                    int i34 = obtainStyledAttributes.getInt(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i34 != 0) {
                        i28 = i10 | DRAWING_CACHE_QUALITY_FLAGS[i34];
                        i27 = i11 | DRAWING_CACHE_QUALITY_MASK;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 34:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 4194304;
                        i27 = i11 | 4194304;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 35:
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 36:
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 37:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, true)) {
                        continue;
                    } else {
                        i28 = i10 & (-134217729);
                        i27 = i11 | 134217728;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 38:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 67108864;
                        i27 = i11 | 67108864;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 39:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = true;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        setScrollContainer(true);
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = true;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i27 = i11;
                        i28 = i10;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 40:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, true)) {
                        continue;
                    } else {
                        i28 = i10 & (-268435457);
                        i27 = i11 | 268435456;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 41:
                    if (context.isRestricted()) {
                        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                    }
                    final String string = obtainStyledAttributes.getString(index);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (string != null) {
                        setOnClickListener(new OnClickListener() { // from class: android.view.View.1
                            private Method mHandler;

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (this.mHandler == null) {
                                    try {
                                        this.mHandler = View.this.getContext().getClass().getMethod(string, View.class);
                                    } catch (NoSuchMethodException e) {
                                        int id = View.this.getId();
                                        throw new IllegalStateException("Could not find a method " + string + "(View) in the activity " + View.this.getContext().getClass() + " for onClick handler on view " + View.this.getClass() + (id == -1 ? "" : " with id '" + View.this.getContext().getResources().getResourceEntryName(id) + "'"), e);
                                    }
                                }
                                try {
                                    this.mHandler.invoke(View.this.getContext(), View.this);
                                } catch (IllegalAccessException e2) {
                                    throw new IllegalStateException("Could not execute non public method of the activity", e2);
                                } catch (InvocationTargetException e3) {
                                    throw new IllegalStateException("Could not execute method of the activity", e3);
                                }
                            }
                        });
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i27 = i11;
                        i28 = i10;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 42:
                    setContentDescription(obtainStyledAttributes.getString(index));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 46:
                    i21 = obtainStyledAttributes.getInt(index, 1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 47:
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        i28 = i10 | 1024;
                        i27 = i11 | 1024;
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 48:
                    setAlpha(obtainStyledAttributes.getFloat(index, 1.0f));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 49:
                    setPivotX(obtainStyledAttributes.getDimensionPixelOffset(index, 0));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 50:
                    setPivotY(obtainStyledAttributes.getDimensionPixelOffset(index, 0));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 51:
                    f16 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 52:
                    f17 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 53:
                    f14 = obtainStyledAttributes.getFloat(index, 1.0f);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 54:
                    f15 = obtainStyledAttributes.getFloat(index, 1.0f);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 55:
                    f11 = obtainStyledAttributes.getFloat(index, 0.0f);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 56:
                    f12 = obtainStyledAttributes.getFloat(index, 0.0f);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 57:
                    f13 = obtainStyledAttributes.getFloat(index, 0.0f);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 58:
                    this.mVerticalScrollbarPosition = obtainStyledAttributes.getInt(index, 0);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 59:
                    this.mNextFocusForwardId = obtainStyledAttributes.getResourceId(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 60:
                    setLayerType(obtainStyledAttributes.getInt(index, 0), null);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 61:
                    break;
                case 62:
                    setImportantForAccessibility(obtainStyledAttributes.getInt(index, 0));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 63:
                    this.mPrivateFlags2 &= -449;
                    int i35 = obtainStyledAttributes.getInt(index, -1);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    if (i35 != -1) {
                        this.mPrivateFlags2 |= PFLAG2_TEXT_DIRECTION_FLAGS[i35];
                        drawable2 = drawable;
                        i18 = i6;
                        f10 = f4;
                        i19 = i8;
                        z8 = z5;
                        z9 = z3;
                        i20 = i3;
                        z10 = z6;
                        i21 = i15;
                        i22 = i9;
                        i23 = i5;
                        z11 = z7;
                        f11 = f5;
                        f12 = f6;
                        f13 = f7;
                        i24 = i14;
                        z12 = z;
                        i25 = i7;
                        z13 = z4;
                        f14 = f8;
                        f15 = f9;
                        i26 = i4;
                        z14 = z2;
                        f16 = f;
                        f17 = f2;
                        f18 = f3;
                        i27 = i11;
                        i28 = i10;
                        i29 = i12;
                        i30 = i13;
                    } else {
                        continue;
                    }
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 64:
                    this.mPrivateFlags2 &= -57345;
                    this.mPrivateFlags2 |= PFLAG2_TEXT_ALIGNMENT_FLAGS[obtainStyledAttributes.getInt(index, 1)];
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 65:
                    this.mPrivateFlags2 &= -61;
                    int i36 = obtainStyledAttributes.getInt(index, -1);
                    this.mPrivateFlags2 |= (i36 != -1 ? LAYOUT_DIRECTION_FLAGS[i36] : 2) << 2;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 66:
                    i25 = obtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    z13 = i25 != Integer.MIN_VALUE;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 67:
                    i19 = obtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    z8 = i19 != Integer.MIN_VALUE;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 68:
                    setLabelFor(obtainStyledAttributes.getResourceId(index, -1));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 69:
                    setAccessibilityLiveRegion(obtainStyledAttributes.getInt(index, 0));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 70:
                    f18 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 71:
                    setTransitionName(obtainStyledAttributes.getString(index));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 72:
                    setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(index, false));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 73:
                    f10 = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    z14 = true;
                    drawable2 = drawable;
                    i18 = i6;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 74:
                    setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(index, 0)));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 75:
                    if (this.mBackgroundTint == null) {
                        this.mBackgroundTint = new TintInfo();
                    }
                    this.mBackgroundTint.mTintList = obtainStyledAttributes.getColorStateList(75);
                    this.mBackgroundTint.mHasTintList = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 76:
                    if (this.mBackgroundTint == null) {
                        this.mBackgroundTint = new TintInfo();
                    }
                    this.mBackgroundTint.mTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(76, -1), null);
                    this.mBackgroundTint.mHasTintMode = true;
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 77:
                    setOutlineProviderFromAttribute(obtainStyledAttributes.getInt(77, 0));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 78:
                    setAccessibilityTraversalBefore(obtainStyledAttributes.getResourceId(index, -1));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                case 79:
                    setAccessibilityTraversalAfter(obtainStyledAttributes.getResourceId(index, -1));
                    drawable2 = drawable;
                    i18 = i6;
                    f10 = f4;
                    i19 = i8;
                    z8 = z5;
                    z9 = z3;
                    i20 = i3;
                    z10 = z6;
                    i21 = i15;
                    i22 = i9;
                    i23 = i5;
                    z11 = z7;
                    f11 = f5;
                    f12 = f6;
                    f13 = f7;
                    i24 = i14;
                    z12 = z;
                    i25 = i7;
                    z13 = z4;
                    f14 = f8;
                    f15 = f9;
                    i26 = i4;
                    z14 = z2;
                    f16 = f;
                    f17 = f2;
                    f18 = f3;
                    i27 = i11;
                    i28 = i10;
                    i29 = i12;
                    i30 = i13;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
                default:
                    i30 = i13;
                    i29 = i12;
                    i28 = i10;
                    i27 = i11;
                    f18 = f3;
                    f17 = f2;
                    f16 = f;
                    z14 = z2;
                    i26 = i4;
                    f15 = f9;
                    f14 = f8;
                    z13 = z4;
                    i25 = i7;
                    z12 = z;
                    i24 = i14;
                    f13 = f7;
                    f12 = f6;
                    f11 = f5;
                    z11 = z7;
                    i23 = i5;
                    i22 = i9;
                    i21 = i15;
                    z10 = z6;
                    i20 = i3;
                    z9 = z3;
                    z8 = z5;
                    i19 = i8;
                    f10 = f4;
                    i18 = i6;
                    drawable2 = drawable;
                    continue;
                    i17++;
                    drawable = drawable2;
                    i6 = i18;
                    f4 = f10;
                    i8 = i19;
                    z5 = z8;
                    z3 = z9;
                    i3 = i20;
                    z6 = z10;
                    i15 = i21;
                    i9 = i22;
                    i5 = i23;
                    z7 = z11;
                    f5 = f11;
                    f6 = f12;
                    f7 = f13;
                    i14 = i24;
                    z = z12;
                    i7 = i25;
                    z4 = z13;
                    f8 = f14;
                    f9 = f15;
                    i4 = i26;
                    z2 = z14;
                    f = f16;
                    f2 = f17;
                    f3 = f18;
                    i11 = i27;
                    i10 = i28;
                    i12 = i29;
                    i13 = i30;
            }
            int i37 = obtainStyledAttributes.getInt(index, 0);
            drawable2 = drawable;
            i18 = i6;
            f10 = f4;
            i19 = i8;
            z8 = z5;
            z9 = z3;
            i20 = i3;
            z10 = z6;
            i21 = i15;
            i22 = i9;
            i23 = i5;
            z11 = z7;
            f11 = f5;
            f12 = f6;
            f13 = f7;
            i24 = i14;
            z12 = z;
            i25 = i7;
            z13 = z4;
            f14 = f8;
            f15 = f9;
            i26 = i4;
            z14 = z2;
            f16 = f;
            f17 = f2;
            f18 = f3;
            i27 = i11;
            i28 = i10;
            i29 = i12;
            i30 = i13;
            if (i37 != 0) {
                i28 = i10 | i37;
                i27 = i11 | 12288;
                initializeFadingEdgeInternal(obtainStyledAttributes);
                drawable2 = drawable;
                i18 = i6;
                f10 = f4;
                i19 = i8;
                z8 = z5;
                z9 = z3;
                i20 = i3;
                z10 = z6;
                i21 = i15;
                i22 = i9;
                i23 = i5;
                z11 = z7;
                f11 = f5;
                f12 = f6;
                f13 = f7;
                i24 = i14;
                z12 = z;
                i25 = i7;
                z13 = z4;
                f14 = f8;
                f15 = f9;
                i26 = i4;
                z14 = z2;
                f16 = f;
                f17 = f2;
                f18 = f3;
                i29 = i12;
                i30 = i13;
            }
            i17++;
            drawable = drawable2;
            i6 = i18;
            f4 = f10;
            i8 = i19;
            z5 = z8;
            z3 = z9;
            i3 = i20;
            z6 = z10;
            i15 = i21;
            i9 = i22;
            i5 = i23;
            z7 = z11;
            f5 = f11;
            f6 = f12;
            f7 = f13;
            i14 = i24;
            z = z12;
            i7 = i25;
            z4 = z13;
            f8 = f14;
            f9 = f15;
            i4 = i26;
            z2 = z14;
            f = f16;
            f2 = f17;
            f3 = f18;
            i11 = i27;
            i10 = i28;
            i12 = i29;
            i13 = i30;
        }
        setOverScrollMode(i15);
        this.mUserPaddingStart = i7;
        this.mUserPaddingEnd = i8;
        if (drawable != null) {
            setBackground(drawable);
        }
        this.mLeftPaddingDefined = z6;
        this.mRightPaddingDefined = z7;
        if (i9 >= 0) {
            i3 = i9;
            i4 = i9;
            i5 = i9;
            i6 = i9;
            this.mUserPaddingLeftInitial = i9;
            this.mUserPaddingRightInitial = i9;
        }
        if (isRtlCompatibilityMode()) {
            int i38 = i3;
            if (!this.mLeftPaddingDefined) {
                i38 = i3;
                if (z4) {
                    i38 = i7;
                }
            }
            this.mUserPaddingLeftInitial = i38 < 0 ? this.mUserPaddingLeftInitial : i38;
            int i39 = i5;
            if (!this.mRightPaddingDefined) {
                i39 = i5;
                if (z5) {
                    i39 = i8;
                }
            }
            this.mUserPaddingRightInitial = i39 < 0 ? this.mUserPaddingRightInitial : i39;
        } else {
            boolean z15 = z4 || z5;
            if (this.mLeftPaddingDefined && !z15) {
                this.mUserPaddingLeftInitial = i3;
            }
            if (this.mRightPaddingDefined && !z15) {
                this.mUserPaddingRightInitial = i5;
            }
        }
        internalSetPadding(this.mUserPaddingLeftInitial, i4 < 0 ? this.mPaddingTop : i4, this.mUserPaddingRightInitial, i6 < 0 ? this.mPaddingBottom : i6);
        if (i11 != 0) {
            setFlags(i10, i11);
        }
        if (z3) {
            initializeScrollbarsInternal(obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        if (i14 != 0) {
            recomputePadding();
        }
        if (i12 != 0 || i13 != 0) {
            scrollTo(i12, i13);
        }
        if (z2) {
            setTranslationX(f);
            setTranslationY(f2);
            setTranslationZ(f3);
            setElevation(f4);
            setRotation(f5);
            setRotationX(f6);
            setRotationY(f7);
            setScaleX(f8);
            setScaleY(f9);
        }
        if (!z && (i10 & 512) != 0) {
            setScrollContainer(true);
        }
        computeOpaqueFlags();
    }

    private void applyBackgroundTint() {
        if (this.mBackground == null || this.mBackgroundTint == null) {
            return;
        }
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            this.mBackground = this.mBackground.mutate();
            if (tintInfo.mHasTintList) {
                this.mBackground.setTintList(tintInfo.mTintList);
            }
            if (tintInfo.mHasTintMode) {
                this.mBackground.setTintMode(tintInfo.mTintMode);
            }
            if (this.mBackground.isStateful()) {
                this.mBackground.setState(getDrawableState());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x013e, code lost:
        if (r19.getHeight() != r11) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void buildDrawingCacheImpl(boolean r6) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.buildDrawingCacheImpl(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForLongClick(int i) {
        if ((this.mViewFlags & 2097152) == 2097152) {
            this.mHasPerformedLongPress = false;
            if (this.mPendingCheckForLongPress == null) {
                this.mPendingCheckForLongPress = new CheckForLongPress();
            }
            this.mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout() - i);
        }
    }

    private void cleanupDraw() {
        resetDisplayList();
        if (this.mAttachInfo != null) {
            this.mAttachInfo.mViewRootImpl.cancelInvalidate(this);
        }
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    private void damageShadowReceiver() {
        ViewParent parent;
        if (this.mAttachInfo == null || (parent = getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).damageInParent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String debugIndent(int i) {
        StringBuilder sb = new StringBuilder(((i * 2) + 3) * 2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 2) + 3) {
                return sb.toString();
            }
            sb.append(' ').append(' ');
            i2 = i3 + 1;
        }
    }

    private boolean dispatchGenericMotionEventInternal(MotionEvent motionEvent) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if ((listenerInfo == null || listenerInfo.mOnGenericMotionListener == null || (this.mViewFlags & 32) != 0 || !listenerInfo.mOnGenericMotionListener.onGenericMotion(this, motionEvent)) && !onGenericMotionEvent(motionEvent)) {
            if (this.mInputEventConsistencyVerifier != null) {
                this.mInputEventConsistencyVerifier.onUnhandledEvent(motionEvent, 0);
                return false;
            }
            return false;
        }
        return true;
    }

    private boolean drawAnimation(ViewGroup viewGroup, long j, Animation animation, boolean z) {
        int i = viewGroup.mGroupFlags;
        if (!animation.isInitialized()) {
            animation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, viewGroup.getWidth(), viewGroup.getHeight());
            animation.initializeInvalidateRegion(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
            if (this.mAttachInfo != null) {
                animation.setListenerHandler(this.mAttachInfo.mHandler);
            }
            onAnimationStart();
        }
        Transformation childTransformation = viewGroup.getChildTransformation();
        boolean transformation = animation.getTransformation(j, childTransformation, 1.0f);
        if (z && this.mAttachInfo.mApplicationScale != 1.0f) {
            if (viewGroup.mInvalidationTransformation == null) {
                viewGroup.mInvalidationTransformation = new Transformation();
            }
            childTransformation = viewGroup.mInvalidationTransformation;
            animation.getTransformation(j, childTransformation, 1.0f);
        }
        if (transformation) {
            if (animation.willChangeBounds()) {
                if (viewGroup.mInvalidateRegion == null) {
                    viewGroup.mInvalidateRegion = new RectF();
                }
                RectF rectF = viewGroup.mInvalidateRegion;
                animation.getInvalidateRegion(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop, rectF, childTransformation);
                viewGroup.mPrivateFlags |= 64;
                int i2 = this.mLeft + ((int) rectF.left);
                int i3 = this.mTop + ((int) rectF.top);
                viewGroup.invalidate(i2, i3, ((int) (rectF.width() + 0.5f)) + i2, ((int) (rectF.height() + 0.5f)) + i3);
                return transformation;
            } else if ((i & 144) == 128) {
                viewGroup.mGroupFlags |= 4;
            } else if ((i & 4) == 0) {
                viewGroup.mPrivateFlags |= 64;
                viewGroup.invalidate(this.mLeft, this.mTop, this.mRight, this.mBottom);
                return transformation;
            }
        }
        return transformation;
    }

    private void drawBackground(Canvas canvas) {
        Drawable drawable = this.mBackground;
        if (drawable == null) {
            return;
        }
        if (this.mBackgroundSizeChanged) {
            drawable.setBounds(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
            this.mBackgroundSizeChanged = false;
            rebuildOutline();
        }
        if (canvas.isHardwareAccelerated() && this.mAttachInfo != null && this.mAttachInfo.mHardwareRenderer != null) {
            this.mBackgroundRenderNode = getDrawableRenderNode(drawable, this.mBackgroundRenderNode);
            RenderNode renderNode = this.mBackgroundRenderNode;
            if (renderNode != null && renderNode.isValid()) {
                setBackgroundRenderNodeProperties(renderNode);
                ((HardwareCanvas) canvas).drawRenderNode(renderNode);
                return;
            }
        }
        int i = this.mScrollX;
        int i2 = this.mScrollY;
        if ((i | i2) == 0) {
            drawable.draw(canvas);
            return;
        }
        canvas.translate(i, i2);
        drawable.draw(canvas);
        canvas.translate(-i, -i2);
    }

    private static void dumpFlag(HashMap<String, String> hashMap, String str, int i) {
        String replace = String.format("%32s", Integer.toBinaryString(i)).replace('0', ' ');
        int indexOf = str.indexOf(95);
        hashMap.put((indexOf > 0 ? str.substring(0, indexOf) : str) + replace + str, replace + " " + str);
    }

    private static void dumpFlags() {
        HashMap newHashMap = Maps.newHashMap();
        try {
            Field[] declaredFields = View.class.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Field field = declaredFields[i2];
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    if (field.getType().equals(Integer.TYPE)) {
                        dumpFlag(newHashMap, field.getName(), field.getInt(null));
                    } else if (field.getType().equals(int[].class)) {
                        int[] iArr = (int[]) field.get(null);
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < iArr.length) {
                                dumpFlag(newHashMap, field.getName() + "[" + i4 + "]", iArr[i4]);
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
                i = i2 + 1;
            }
            ArrayList newArrayList = Lists.newArrayList();
            newArrayList.addAll(newHashMap.keySet());
            Collections.sort(newArrayList);
            Iterator it = newArrayList.iterator();
            while (it.hasNext()) {
                Log.d(VIEW_LOG_TAG, (String) newHashMap.get((String) it.next()));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private View findLabelForView(View view, int i) {
        if (this.mMatchLabelForPredicate == null) {
            this.mMatchLabelForPredicate = new MatchLabelForPredicate();
        }
        this.mMatchLabelForPredicate.mLabeledId = i;
        return findViewByPredicateInsideOut(view, this.mMatchLabelForPredicate);
    }

    private View findViewInsideOutShouldExist(View view, int i) {
        if (this.mMatchIdPredicate == null) {
            this.mMatchIdPredicate = new MatchIdPredicate();
        }
        this.mMatchIdPredicate.mId = i;
        View findViewByPredicateInsideOut = view.findViewByPredicateInsideOut(this, this.mMatchIdPredicate);
        if (findViewByPredicateInsideOut == null) {
            Log.w(VIEW_LOG_TAG, "couldn't find view with id " + i);
        }
        return findViewByPredicateInsideOut;
    }

    private boolean fitSystemWindowsInt(Rect rect) {
        if ((this.mViewFlags & 2) == 2) {
            this.mUserPaddingStart = Integer.MIN_VALUE;
            this.mUserPaddingEnd = Integer.MIN_VALUE;
            Rect rect2 = sThreadLocal.get();
            Rect rect3 = rect2;
            if (rect2 == null) {
                rect3 = new Rect();
                sThreadLocal.set(rect3);
            }
            boolean computeFitSystemWindows = computeFitSystemWindows(rect, rect3);
            this.mUserPaddingLeftInitial = rect3.left;
            this.mUserPaddingRightInitial = rect3.right;
            internalSetPadding(rect3.left, rect3.top, rect3.right, rect3.bottom);
            return computeFitSystemWindows;
        }
        return false;
    }

    public static int generateViewId() {
        int i;
        int i2;
        do {
            i = sNextGeneratedId.get();
            int i3 = i + 1;
            i2 = i3;
            if (i3 > 16777215) {
                i2 = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(i, i2));
        return i;
    }

    private static SparseArray<String> getAttributeMap() {
        if (mAttributeMap == null) {
            mAttributeMap = new SparseArray<>();
        }
        return mAttributeMap;
    }

    public static int getDefaultSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return size;
            case 0:
                return i;
            default:
                return i;
        }
    }

    private RenderNode getDrawableRenderNode(Drawable drawable, RenderNode renderNode) {
        RenderNode renderNode2 = renderNode;
        if (renderNode == null) {
            renderNode2 = RenderNode.create(drawable.getClass().getName(), this);
        }
        Rect bounds = drawable.getBounds();
        HardwareCanvas start = renderNode2.start(bounds.width(), bounds.height());
        start.translate(-bounds.left, -bounds.top);
        try {
            drawable.draw(start);
            renderNode2.end(start);
            renderNode2.setProjectBackwards(drawable.isProjected());
            renderNode2.setProjectionReceiver(true);
            renderNode2.setClipToBounds(false);
            return renderNode2;
        } catch (Throwable th) {
            renderNode2.end(start);
            throw th;
        }
    }

    private float getFinalAlpha() {
        if (this.mTransformationInfo != null) {
            return this.mTransformationInfo.mAlpha * this.mTransformationInfo.mTransitionAlpha;
        }
        return 1.0f;
    }

    private View getProjectionReceiver() {
        ViewParent parent = getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null || !(viewParent instanceof View)) {
                return null;
            }
            View view = (View) viewParent;
            if (view.isProjectionReceiver()) {
                return view;
            }
            parent = viewParent.getParent();
        }
    }

    private ScrollabilityCache getScrollCache() {
        initScrollCache();
        return this.mScrollCache;
    }

    private boolean hasAncestorThatBlocksDescendantFocus() {
        boolean isFocusableInTouchMode = isFocusableInTouchMode();
        ViewParent viewParent = this.mParent;
        while (true) {
            ViewParent viewParent2 = viewParent;
            if (!(viewParent2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent2;
            if (viewGroup.getDescendantFocusability() == 393216) {
                return true;
            }
            if (!isFocusableInTouchMode && viewGroup.shouldBlockFocusForTouchscreen()) {
                return true;
            }
            viewParent = viewGroup.getParent();
        }
    }

    private boolean hasListenersForAccessibility() {
        ListenerInfo listenerInfo = getListenerInfo();
        return (this.mTouchDelegate == null && listenerInfo.mOnKeyListener == null && listenerInfo.mOnTouchListener == null && listenerInfo.mOnGenericMotionListener == null && listenerInfo.mOnHoverListener == null && listenerInfo.mOnDragListener == null) ? false : true;
    }

    private boolean hasRtlSupport() {
        return this.mContext.getApplicationInfo().hasRtlSupport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean inLiveRegion() {
        if (getAccessibilityLiveRegion() != 0) {
            return true;
        }
        ViewParent parent = getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (!(viewParent instanceof View)) {
                return false;
            }
            if (((View) viewParent).getAccessibilityLiveRegion() != 0) {
                return true;
            }
            parent = viewParent.getParent();
        }
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(i, viewGroup);
    }

    private void initScrollCache() {
        if (this.mScrollCache == null) {
            this.mScrollCache = new ScrollabilityCache(ViewConfiguration.get(this.mContext), this);
        }
    }

    private boolean initialAwakenScrollBars() {
        return this.mScrollCache != null && awakenScrollBars(this.mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }

    private boolean isHoverable() {
        int i = this.mViewFlags;
        if ((i & 32) == 32) {
            return false;
        }
        return (i & 16384) == 16384 || (i & 2097152) == 2097152;
    }

    public static boolean isLayoutModeOptical(Object obj) {
        return (obj instanceof ViewGroup) && ((ViewGroup) obj).isLayoutModeOptical();
    }

    private boolean isProjectionReceiver() {
        return this.mBackground != null;
    }

    private boolean isRtlCompatibilityMode() {
        return (getContext().getApplicationInfo().targetSdkVersion < 17 && !isSystemApp()) || !hasRtlSupport();
    }

    private boolean isSystemApp() {
        return (getContext().getApplicationInfo().flags & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int[] mergeDrawableStates(int[] iArr, int[] iArr2) {
        int i;
        int length = iArr.length;
        while (true) {
            i = length - 1;
            if (i < 0 || iArr[i] != 0) {
                break;
            }
            length = i;
        }
        System.arraycopy(iArr2, 0, iArr, i + 1, iArr2.length);
        return iArr;
    }

    private boolean needRtlPropertiesResolution() {
        return (this.mPrivateFlags2 & ALL_RTL_PROPERTIES_RESOLVED) != ALL_RTL_PROPERTIES_RESOLVED;
    }

    private void postSendViewScrolledAccessibilityEventCallback() {
        if (this.mSendViewScrolledAccessibilityEvent == null) {
            this.mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        }
        if (this.mSendViewScrolledAccessibilityEvent.mIsPending) {
            return;
        }
        this.mSendViewScrolledAccessibilityEvent.mIsPending = true;
        postDelayed(this.mSendViewScrolledAccessibilityEvent, ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
    }

    private static String printFlags(int i) {
        String str = "";
        int i2 = 0;
        if ((i & 1) == 1) {
            str = "TAKES_FOCUS";
            i2 = 0 + 1;
        }
        switch (i & 12) {
            case 4:
                String str2 = str;
                if (i2 > 0) {
                    str2 = str + " ";
                }
                return str2 + "INVISIBLE";
            case 8:
                String str3 = str;
                if (i2 > 0) {
                    str3 = str + " ";
                }
                return str3 + "GONE";
            default:
                return str;
        }
    }

    private static String printPrivateFlags(int i) {
        String str = "";
        int i2 = 0;
        if ((i & 1) == 1) {
            str = "WANTS_FOCUS";
            i2 = 0 + 1;
        }
        int i3 = i2;
        String str2 = str;
        if ((i & 2) == 2) {
            String str3 = str;
            if (i2 > 0) {
                str3 = str + " ";
            }
            str2 = str3 + "FOCUSED";
            i3 = i2 + 1;
        }
        int i4 = i3;
        String str4 = str2;
        if ((i & 4) == 4) {
            String str5 = str2;
            if (i3 > 0) {
                str5 = str2 + " ";
            }
            str4 = str5 + "SELECTED";
            i4 = i3 + 1;
        }
        int i5 = i4;
        String str6 = str4;
        if ((i & 8) == 8) {
            String str7 = str4;
            if (i4 > 0) {
                str7 = str4 + " ";
            }
            str6 = str7 + "IS_ROOT_NAMESPACE";
            i5 = i4 + 1;
        }
        int i6 = i5;
        String str8 = str6;
        if ((i & 16) == 16) {
            String str9 = str6;
            if (i5 > 0) {
                str9 = str6 + " ";
            }
            str8 = str9 + "HAS_BOUNDS";
            i6 = i5 + 1;
        }
        String str10 = str8;
        if ((i & 32) == 32) {
            String str11 = str8;
            if (i6 > 0) {
                str11 = str8 + " ";
            }
            str10 = str11 + "DRAWN";
        }
        return str10;
    }

    private void rebuildOutline() {
        if (this.mAttachInfo == null) {
            return;
        }
        if (this.mOutlineProvider == null) {
            this.mRenderNode.setOutline((Outline) null);
            return;
        }
        Outline outline = this.mAttachInfo.mTmpOutline;
        outline.setEmpty();
        outline.setAlpha(1.0f);
        this.mOutlineProvider.getOutline(this, outline);
        this.mRenderNode.setOutline(outline);
    }

    private void removeLongPressCallback() {
        if (this.mPendingCheckForLongPress != null) {
            removeCallbacks(this.mPendingCheckForLongPress);
        }
    }

    private void removePerformClickCallback() {
        if (this.mPerformClick != null) {
            removeCallbacks(this.mPerformClick);
        }
    }

    private void removeSendViewScrolledAccessibilityEventCallback() {
        if (this.mSendViewScrolledAccessibilityEvent != null) {
            removeCallbacks(this.mSendViewScrolledAccessibilityEvent);
            this.mSendViewScrolledAccessibilityEvent.mIsPending = false;
        }
    }

    private void removeTapCallback() {
        if (this.mPendingCheckForTap != null) {
            this.mPrivateFlags &= -33554433;
            removeCallbacks(this.mPendingCheckForTap);
        }
    }

    private void removeUnsetPressCallback() {
        if ((this.mPrivateFlags & 16384) == 0 || this.mUnsetPressedState == null) {
            return;
        }
        setPressed(false);
        removeCallbacks(this.mUnsetPressedState);
    }

    private boolean requestFocusNoSearch(int i, Rect rect) {
        if ((this.mViewFlags & 1) == 1 && (this.mViewFlags & 12) == 0) {
            if ((!isInTouchMode() || 262144 == (this.mViewFlags & 262144)) && !hasAncestorThatBlocksDescendantFocus()) {
                handleFocusGainInternal(i, rect);
                return true;
            }
            return false;
        }
        return false;
    }

    private void resetDisplayList() {
        if (this.mRenderNode.isValid()) {
            this.mRenderNode.destroyDisplayListData();
        }
        if (this.mBackgroundRenderNode == null || !this.mBackgroundRenderNode.isValid()) {
            return;
        }
        this.mBackgroundRenderNode.destroyDisplayListData();
    }

    private void resetPressedState() {
        if ((this.mViewFlags & 32) != 32 && isPressed()) {
            setPressed(false);
            if (this.mHasPerformedLongPress) {
                return;
            }
            removeLongPressCallback();
        }
    }

    public static int resolveSize(int i, int i2) {
        return resolveSizeAndState(i, i2, 0) & 16777215;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < i) {
                    i = size | 16777216;
                    break;
                }
                break;
            case 0:
                break;
            case 1073741824:
                i = size;
                break;
            default:
                i = i;
                break;
        }
        return ((-16777216) & i3) | i;
    }

    private void saveAttributeData(AttributeSet attributeSet, TypedArray typedArray) {
        int i = 0;
        if (attributeSet != null) {
            i = attributeSet.getAttributeCount();
        }
        this.mAttributes = new String[(i + typedArray.getIndexCount()) * 2];
        int i2 = 0;
        if (attributeSet != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i2 = i4;
                if (i4 >= attributeSet.getAttributeCount()) {
                    break;
                }
                this.mAttributes[i4] = attributeSet.getAttributeName(i4);
                this.mAttributes[i4 + 1] = attributeSet.getAttributeValue(i4);
                i3 = i4 + 2;
            }
        }
        SparseArray<String> attributeMap = getAttributeMap();
        int i5 = 0;
        while (i5 < typedArray.length()) {
            int i6 = i2;
            if (typedArray.hasValue(i5)) {
                try {
                    int resourceId = typedArray.getResourceId(i5, 0);
                    if (resourceId == 0) {
                        i6 = i2;
                    } else {
                        String str = attributeMap.get(resourceId);
                        String str2 = str;
                        if (str == null) {
                            str2 = typedArray.getResources().getResourceName(resourceId);
                            attributeMap.put(resourceId, str2);
                        }
                        this.mAttributes[i2] = str2;
                        this.mAttributes[i2 + 1] = typedArray.getText(i5).toString();
                        i6 = i2 + 2;
                    }
                } catch (Resources.NotFoundException e) {
                    i6 = i2;
                }
            }
            i5++;
            i2 = i6;
        }
    }

    private void sendAccessibilityHoverEvent(int i) {
        View view = this;
        while (true) {
            View view2 = view;
            if (view2.includeForAccessibility()) {
                view2.sendAccessibilityEvent(i);
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            view = (View) parent;
        }
    }

    private void sendViewTextTraversedAtGranularityEvent(int i, int i2, int i3, int i4) {
        if (this.mParent == null) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(131072);
        onInitializeAccessibilityEvent(obtain);
        onPopulateAccessibilityEvent(obtain);
        obtain.setFromIndex(i3);
        obtain.setToIndex(i4);
        obtain.setAction(i);
        obtain.setMovementGranularity(i2);
        this.mParent.requestSendAccessibilityEvent(this, obtain);
    }

    private void setBackgroundRenderNodeProperties(RenderNode renderNode) {
        renderNode.setTranslationX(this.mScrollX);
        renderNode.setTranslationY(this.mScrollY);
    }

    private void setKeyedTag(int i, Object obj) {
        if (this.mKeyedTags == null) {
            this.mKeyedTags = new SparseArray<>(2);
        }
        this.mKeyedTags.put(i, obj);
    }

    private void setMeasuredDimensionRaw(int i, int i2) {
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
        this.mPrivateFlags |= 2048;
    }

    private boolean setOpticalFrame(int i, int i2, int i3, int i4) {
        Insets opticalInsets = this.mParent instanceof View ? ((View) this.mParent).getOpticalInsets() : Insets.NONE;
        Insets opticalInsets2 = getOpticalInsets();
        return setFrame((opticalInsets.left + i) - opticalInsets2.left, (opticalInsets.top + i2) - opticalInsets2.top, opticalInsets.left + i3 + opticalInsets2.right, opticalInsets.top + i4 + opticalInsets2.bottom);
    }

    private void setOutlineProviderFromAttribute(int i) {
        switch (i) {
            case 0:
                setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                return;
            case 1:
                setOutlineProvider(null);
                return;
            case 2:
                setOutlineProvider(ViewOutlineProvider.BOUNDS);
                return;
            case 3:
                setOutlineProvider(ViewOutlineProvider.PADDED_BOUNDS);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPressed(boolean z, float f, float f2) {
        if (z) {
            drawableHotspotChanged(f, f2);
        }
        setPressed(z);
    }

    private void sizeChange(int i, int i2, int i3, int i4) {
        onSizeChanged(i, i2, i3, i4);
        if (this.mOverlay != null) {
            this.mOverlay.getOverlayView().setRight(i);
            this.mOverlay.getOverlayView().setBottom(i2);
        }
        rebuildOutline();
    }

    private boolean skipInvalidate() {
        if ((this.mViewFlags & 12) == 0 || this.mCurrentAnimation != null) {
            return false;
        }
        return ((this.mParent instanceof ViewGroup) && ((ViewGroup) this.mParent).isViewTransitioning(this)) ? false : true;
    }

    private boolean traverseAtGranularity(int i, boolean z, boolean z2) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd();
        int i4 = accessibilitySelectionEnd;
        if (accessibilitySelectionEnd == -1) {
            i4 = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(i4) : iteratorForGranularity.preceding(i4);
        if (following == null) {
            return false;
        }
        int i5 = following[0];
        int i6 = following[1];
        if (z2 && isAccessibilitySelectionExtendable()) {
            int accessibilitySelectionStart = getAccessibilitySelectionStart();
            i3 = accessibilitySelectionStart;
            if (accessibilitySelectionStart == -1) {
                i3 = z ? i5 : i6;
            }
            i2 = z ? i6 : i5;
        } else {
            int i7 = z ? i6 : i5;
            i2 = i7;
            i3 = i7;
        }
        setAccessibilitySelection(i3, i2);
        sendViewTextTraversedAtGranularityEvent(z ? 256 : 512, i, i5, i6);
        return true;
    }

    private void updateDisplayListIfDirty() {
        RenderNode renderNode = this.mRenderNode;
        if (canHaveDisplayList()) {
            if ((this.mPrivateFlags & 32768) != 0 && renderNode.isValid() && !this.mRecreateDisplayList) {
                this.mPrivateFlags |= 32800;
                this.mPrivateFlags &= -6291457;
            } else if (renderNode.isValid() && !this.mRecreateDisplayList) {
                this.mPrivateFlags |= 32800;
                this.mPrivateFlags &= -6291457;
                dispatchGetDisplayList();
            } else {
                this.mRecreateDisplayList = true;
                int i = this.mRight;
                int i2 = this.mLeft;
                int i3 = this.mBottom;
                int i4 = this.mTop;
                int layerType = getLayerType();
                Canvas start = renderNode.start(i - i2, i3 - i4);
                start.setHighContrastText(this.mAttachInfo.mHighContrastText);
                try {
                    HardwareLayer hardwareLayer = getHardwareLayer();
                    if (hardwareLayer != null && hardwareLayer.isValid()) {
                        start.drawHardwareLayer(hardwareLayer, 0.0f, 0.0f, this.mLayerPaint);
                    } else if (layerType == 1) {
                        buildDrawingCache(true);
                        Bitmap drawingCache = getDrawingCache(true);
                        if (drawingCache != null) {
                            start.drawBitmap(drawingCache, 0.0f, 0.0f, this.mLayerPaint);
                        }
                    } else {
                        computeScroll();
                        start.translate(-this.mScrollX, -this.mScrollY);
                        this.mPrivateFlags |= 32800;
                        this.mPrivateFlags &= -6291457;
                        if ((this.mPrivateFlags & 128) == 128) {
                            dispatchDraw(start);
                            if (this.mOverlay != null && !this.mOverlay.isEmpty()) {
                                this.mOverlay.getOverlayView().draw(start);
                            }
                        } else {
                            draw(start);
                        }
                    }
                } finally {
                    renderNode.end(start);
                    setDisplayListProperties(renderNode);
                }
            }
        }
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public void addFocusables(ArrayList<View> arrayList, int i) {
        addFocusables(arrayList, i, 1);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (arrayList != null && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnAttachStateChangeListeners == null) {
            listenerInfo.mOnAttachStateChangeListeners = new CopyOnWriteArrayList();
        }
        listenerInfo.mOnAttachStateChangeListeners.add(onAttachStateChangeListener);
    }

    public void addOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnLayoutChangeListeners == null) {
            listenerInfo.mOnLayoutChangeListeners = new ArrayList();
        }
        if (listenerInfo.mOnLayoutChangeListeners.contains(onLayoutChangeListener)) {
            return;
        }
        listenerInfo.mOnLayoutChangeListeners.add(onLayoutChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int i = this.mViewFlags;
        if (((i & 16384) == 16384 || (i & 2097152) == 2097152) && (i & 32) == 0) {
            arrayList.add(this);
        }
    }

    public ViewPropertyAnimator animate() {
        if (this.mAnimator == null) {
            this.mAnimator = new ViewPropertyAnimator(this);
        }
        return this.mAnimator;
    }

    public void announceForAccessibility(CharSequence charSequence) {
        if (!AccessibilityManager.getInstance(this.mContext).isEnabled() || this.mParent == null) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        onInitializeAccessibilityEvent(obtain);
        obtain.getText().add(charSequence);
        obtain.setContentDescription(null);
        this.mParent.requestSendAccessibilityEvent(this, obtain);
    }

    public void applyDrawableToTransparentRegion(Drawable drawable, Region region) {
        Region transparentRegion = drawable.getTransparentRegion();
        Rect bounds = drawable.getBounds();
        AttachInfo attachInfo = this.mAttachInfo;
        if (transparentRegion == null || attachInfo == null) {
            region.op(bounds, Region.Op.DIFFERENCE);
            return;
        }
        int right = getRight() - getLeft();
        int bottom = getBottom() - getTop();
        if (bounds.left > 0) {
            transparentRegion.op(0, 0, bounds.left, bottom, Region.Op.UNION);
        }
        if (bounds.right < right) {
            transparentRegion.op(bounds.right, 0, right, bottom, Region.Op.UNION);
        }
        if (bounds.top > 0) {
            transparentRegion.op(0, 0, right, bounds.top, Region.Op.UNION);
        }
        if (bounds.bottom < bottom) {
            transparentRegion.op(0, bounds.bottom, right, bottom, Region.Op.UNION);
        }
        int[] iArr = attachInfo.mTransparentLocation;
        getLocationInWindow(iArr);
        transparentRegion.translate(iArr[0], iArr[1]);
        region.op(transparentRegion, Region.Op.INTERSECT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean areDrawablesResolved() {
        return (this.mPrivateFlags2 & 1073741824) == 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(ViewParent viewParent) {
        if (this.mParent == null) {
            this.mParent = viewParent;
        } else if (viewParent != null) {
            throw new RuntimeException("view " + this + " being added, but it already has a parent");
        } else {
            this.mParent = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awakenScrollBars() {
        return this.mScrollCache != null && awakenScrollBars(this.mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awakenScrollBars(int i) {
        return awakenScrollBars(i, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awakenScrollBars(int i, boolean z) {
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        if (scrollabilityCache == null || !scrollabilityCache.fadeScrollBars) {
            return false;
        }
        if (scrollabilityCache.scrollBar == null) {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        }
        if (isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled()) {
            if (z) {
                postInvalidateOnAnimation();
            }
            int i2 = i;
            if (scrollabilityCache.state == 0) {
                i2 = Math.max(750, i);
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + i2;
            scrollabilityCache.fadeStartTime = currentAnimationTimeMillis;
            scrollabilityCache.state = 1;
            if (this.mAttachInfo != null) {
                this.mAttachInfo.mHandler.removeCallbacks(scrollabilityCache);
                this.mAttachInfo.mHandler.postAtTime(scrollabilityCache, currentAnimationTimeMillis);
                return true;
            }
            return true;
        }
        return false;
    }

    public void bringToFront() {
        if (this.mParent != null) {
            this.mParent.bringChildToFront(this);
        }
    }

    public void buildDrawingCache() {
        buildDrawingCache(false);
    }

    public void buildDrawingCache(boolean z) {
        if ((this.mPrivateFlags & 32768) != 0) {
            if (z) {
                if (this.mDrawingCache != null) {
                    return;
                }
            } else if (this.mUnscaledDrawingCache != null) {
                return;
            }
        }
        if (Trace.isTagEnabled(8L)) {
            Trace.traceBegin(8L, "buildDrawingCache/SW Layer for " + getClass().getSimpleName());
        }
        try {
            buildDrawingCacheImpl(z);
            Trace.traceEnd(8L);
        } catch (Throwable th) {
            Trace.traceEnd(8L);
            throw th;
        }
    }

    public void buildLayer() {
        if (this.mLayerType == 0) {
            return;
        }
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo == null) {
            throw new IllegalStateException("This view must be attached to a window first");
        }
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        switch (this.mLayerType) {
            case 1:
                buildDrawingCache(true);
                return;
            case 2:
                updateDisplayListIfDirty();
                if (attachInfo.mHardwareRenderer == null || !this.mRenderNode.isValid()) {
                    return;
                }
                attachInfo.mHardwareRenderer.buildLayer(this.mRenderNode);
                return;
            default:
                return;
        }
    }

    public boolean callOnClick() {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnClickListener == null) {
            return false;
        }
        listenerInfo.mOnClickListener.onClick(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canAcceptDrag() {
        return (this.mPrivateFlags2 & 1) != 0;
    }

    public boolean canHaveDisplayList() {
        return (this.mAttachInfo == null || this.mAttachInfo.mHardwareRenderer == null) ? false : true;
    }

    public boolean canResolveLayoutDirection() {
        switch (getRawLayoutDirection()) {
            case 2:
                if (this.mParent != null) {
                    try {
                        return this.mParent.canResolveLayoutDirection();
                    } catch (AbstractMethodError e) {
                        Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                        return false;
                    }
                }
                return false;
            default:
                return true;
        }
    }

    public boolean canResolveTextAlignment() {
        switch (getRawTextAlignment()) {
            case 0:
                if (this.mParent != null) {
                    try {
                        return this.mParent.canResolveTextAlignment();
                    } catch (AbstractMethodError e) {
                        Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                        return false;
                    }
                }
                return false;
            default:
                return true;
        }
    }

    public boolean canResolveTextDirection() {
        switch (getRawTextDirection()) {
            case 0:
                if (this.mParent != null) {
                    try {
                        return this.mParent.canResolveTextDirection();
                    } catch (AbstractMethodError e) {
                        Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                        return false;
                    }
                }
                return false;
            default:
                return true;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            z = false;
        } else if (i < 0) {
            if (computeHorizontalScrollOffset <= 0) {
                return false;
            }
        } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
            return false;
        }
        return z;
    }

    public boolean canScrollVertically(int i) {
        boolean z = true;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            z = false;
        } else if (i < 0) {
            if (computeVerticalScrollOffset <= 0) {
                return false;
            }
        } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
            return false;
        }
        return z;
    }

    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
    }

    public final void cancelPendingInputEvents() {
        dispatchCancelPendingInputEvents();
    }

    public void captureTransitioningViews(List<View> list) {
        if (getVisibility() == 0) {
            list.add(this);
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    public void clearAccessibilityFocus() {
        View accessibilityFocusedHost;
        clearAccessibilityFocusNoCallbacks();
        ViewRootImpl viewRootImpl = getViewRootImpl();
        if (viewRootImpl == null || (accessibilityFocusedHost = viewRootImpl.getAccessibilityFocusedHost()) == null || !ViewRootImpl.isViewDescendantOf(accessibilityFocusedHost, this)) {
            return;
        }
        viewRootImpl.setAccessibilityFocus(null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearAccessibilityFocusNoCallbacks() {
        if ((this.mPrivateFlags2 & 67108864) != 0) {
            this.mPrivateFlags2 &= -67108865;
            invalidate();
            sendAccessibilityEvent(65536);
        }
    }

    public void clearAnimation() {
        if (this.mCurrentAnimation != null) {
            this.mCurrentAnimation.detach();
        }
        this.mCurrentAnimation = null;
        invalidateParentIfNeeded();
    }

    public void clearFocus() {
        clearFocusInternal(null, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFocusInternal(View view, boolean z, boolean z2) {
        if ((this.mPrivateFlags & 2) != 0) {
            this.mPrivateFlags &= -3;
            if (z && this.mParent != null) {
                this.mParent.clearChildFocus(this);
            }
            onFocusChanged(false, 0, null);
            refreshDrawableState();
            if (z) {
                if (z2 && rootViewRequestFocus()) {
                    return;
                }
                notifyGlobalFocusCleared(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean computeFitSystemWindows(Rect rect, Rect rect2) {
        if ((this.mViewFlags & 2048) == 0 || this.mAttachInfo == null || ((this.mAttachInfo.mSystemUiVisibility & SYSTEM_UI_LAYOUT_FLAGS) == 0 && !this.mAttachInfo.mOverscanRequested)) {
            rect2.set(rect);
            rect.set(0, 0, 0, 0);
            return true;
        }
        Rect rect3 = this.mAttachInfo.mOverscanInsets;
        rect2.set(rect3);
        rect.left -= rect3.left;
        rect.top -= rect3.top;
        rect.right -= rect3.right;
        rect.bottom -= rect3.bottom;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        return getWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return this.mScrollX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return getWidth();
    }

    protected void computeOpaqueFlags() {
        if (this.mBackground == null || this.mBackground.getOpacity() != -1) {
            this.mPrivateFlags &= -8388609;
        } else {
            this.mPrivateFlags |= 8388608;
        }
        int i = this.mViewFlags;
        if (((i & 512) == 0 && (i & 256) == 0) || (i & 50331648) == 0 || (i & 50331648) == 33554432) {
            this.mPrivateFlags |= 16777216;
        } else {
            this.mPrivateFlags &= -16777217;
        }
    }

    Insets computeOpticalInsets() {
        return this.mBackground == null ? Insets.NONE : this.mBackground.getOpticalInsets();
    }

    public void computeScroll() {
    }

    public WindowInsets computeSystemWindowInsets(WindowInsets windowInsets, Rect rect) {
        if ((this.mViewFlags & 2048) == 0 || this.mAttachInfo == null || (this.mAttachInfo.mSystemUiVisibility & SYSTEM_UI_LAYOUT_FLAGS) == 0) {
            rect.set(windowInsets.getSystemWindowInsets());
            return windowInsets.consumeSystemWindowInsets();
        }
        rect.set(0, 0, 0, 0);
        return windowInsets;
    }

    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        return this.mScrollY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return getHeight();
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return this.mAccessibilityDelegate != null ? this.mAccessibilityDelegate.createAccessibilityNodeInfo(this) : createAccessibilityNodeInfoInternal();
    }

    AccessibilityNodeInfo createAccessibilityNodeInfoInternal() {
        AccessibilityNodeProvider accessibilityNodeProvider = getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return accessibilityNodeProvider.createAccessibilityNodeInfo(-1);
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(obtain);
        return obtain;
    }

    public void createContextMenu(ContextMenu contextMenu) {
        ContextMenu.ContextMenuInfo contextMenuInfo = getContextMenuInfo();
        ((MenuBuilder) contextMenu).setCurrentMenuInfo(contextMenuInfo);
        onCreateContextMenu(contextMenu);
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo != null && listenerInfo.mOnCreateContextMenuListener != null) {
            listenerInfo.mOnCreateContextMenuListener.onCreateContextMenu(contextMenu, this, contextMenuInfo);
        }
        ((MenuBuilder) contextMenu).setCurrentMenuInfo(null);
        if (this.mParent != null) {
            this.mParent.createContextMenu(contextMenu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap createSnapshot(Bitmap.Config config, int i, boolean z) {
        Canvas canvas;
        int i2 = this.mRight;
        int i3 = this.mLeft;
        int i4 = this.mBottom;
        int i5 = this.mTop;
        AttachInfo attachInfo = this.mAttachInfo;
        float f = attachInfo != null ? attachInfo.mApplicationScale : 1.0f;
        int i6 = (int) (((i2 - i3) * f) + 0.5f);
        int i7 = (int) (((i4 - i5) * f) + 0.5f);
        DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
        if (i6 <= 0) {
            i6 = 1;
        }
        if (i7 <= 0) {
            i7 = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(displayMetrics, i6, i7, config);
        if (createBitmap == null) {
            throw new OutOfMemoryError();
        }
        Resources resources = getResources();
        if (resources != null) {
            createBitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        }
        if (attachInfo != null) {
            Canvas canvas2 = attachInfo.mCanvas;
            canvas = canvas2;
            if (canvas2 == null) {
                canvas = new Canvas();
            }
            canvas.setBitmap(createBitmap);
            attachInfo.mCanvas = null;
        } else {
            canvas = new Canvas(createBitmap);
        }
        if (((-16777216) & i) != 0) {
            createBitmap.eraseColor(i);
        }
        computeScroll();
        int save = canvas.save();
        canvas.scale(f, f);
        canvas.translate(-this.mScrollX, -this.mScrollY);
        int i8 = this.mPrivateFlags;
        this.mPrivateFlags &= -6291457;
        if ((this.mPrivateFlags & 128) == 128) {
            dispatchDraw(canvas);
            if (this.mOverlay != null && !this.mOverlay.isEmpty()) {
                this.mOverlay.getOverlayView().draw(canvas);
            }
        } else {
            draw(canvas);
        }
        this.mPrivateFlags = i8;
        canvas.restoreToCount(save);
        canvas.setBitmap(null);
        if (attachInfo != null) {
            attachInfo.mCanvas = canvas;
        }
        return createBitmap;
    }

    protected void damageInParent() {
        AttachInfo attachInfo = this.mAttachInfo;
        if (this.mParent == null || attachInfo == null) {
            return;
        }
        Rect rect = attachInfo.mTmpInvalRect;
        rect.set(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop);
        if (this.mParent instanceof ViewGroup) {
            ((ViewGroup) this.mParent).damageChild(this, rect);
        } else {
            this.mParent.invalidateChild(this, rect);
        }
    }

    public void debug() {
        debug(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void debug(int i) {
        String str = debugIndent(i - 1) + "+ " + this;
        int id = getId();
        String str2 = str;
        if (id != -1) {
            str2 = str + " (id=" + id + ")";
        }
        Object tag = getTag();
        String str3 = str2;
        if (tag != null) {
            str3 = str2 + " (tag=" + tag + ")";
        }
        Log.d(VIEW_LOG_TAG, str3);
        if ((this.mPrivateFlags & 2) != 0) {
            Log.d(VIEW_LOG_TAG, debugIndent(i) + " FOCUSED");
        }
        Log.d(VIEW_LOG_TAG, debugIndent(i) + "frame={" + this.mLeft + ", " + this.mTop + ", " + this.mRight + ", " + this.mBottom + "} scroll={" + this.mScrollX + ", " + this.mScrollY + "} ");
        if (this.mPaddingLeft != 0 || this.mPaddingTop != 0 || this.mPaddingRight != 0 || this.mPaddingBottom != 0) {
            Log.d(VIEW_LOG_TAG, debugIndent(i) + "padding={" + this.mPaddingLeft + ", " + this.mPaddingTop + ", " + this.mPaddingRight + ", " + this.mPaddingBottom + i.d);
        }
        Log.d(VIEW_LOG_TAG, debugIndent(i) + "mMeasureWidth=" + this.mMeasuredWidth + " mMeasureHeight=" + this.mMeasuredHeight);
        String debugIndent = debugIndent(i);
        Log.d(VIEW_LOG_TAG, this.mLayoutParams == null ? debugIndent + "BAD! no layout params" : this.mLayoutParams.debug(debugIndent));
        Log.d(VIEW_LOG_TAG, ((debugIndent(i) + "flags={") + printFlags(this.mViewFlags)) + i.d);
        Log.d(VIEW_LOG_TAG, ((debugIndent(i) + "privateFlags={") + printPrivateFlags(this.mPrivateFlags)) + i.d);
    }

    public void destroyDrawingCache() {
        if (this.mDrawingCache != null) {
            this.mDrawingCache.recycle();
            this.mDrawingCache = null;
        }
        if (this.mUnscaledDrawingCache != null) {
            this.mUnscaledDrawingCache.recycle();
            this.mUnscaledDrawingCache = null;
        }
    }

    protected void destroyHardwareResources() {
        resetDisplayList();
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        try {
            this.mPrivateFlags3 |= 32;
            return (this.mListenerInfo == null || this.mListenerInfo.mOnApplyWindowInsetsListener == null) ? onApplyWindowInsets(windowInsets) : this.mListenerInfo.mOnApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
        } finally {
            this.mPrivateFlags3 &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchAttachedToWindow(AttachInfo attachInfo, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList = null;
        this.mAttachInfo = attachInfo;
        if (this.mOverlay != null) {
            this.mOverlay.getOverlayView().dispatchAttachedToWindow(attachInfo, i);
        }
        this.mWindowAttachCount++;
        this.mPrivateFlags |= 1024;
        if (this.mFloatingTreeObserver != null) {
            attachInfo.mTreeObserver.merge(this.mFloatingTreeObserver);
            this.mFloatingTreeObserver = null;
        }
        if ((this.mPrivateFlags & 524288) != 0) {
            this.mAttachInfo.mScrollContainers.add(this);
            this.mPrivateFlags |= 1048576;
        }
        performCollectViewAttributes(this.mAttachInfo, i);
        onAttachedToWindow();
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo != null) {
            copyOnWriteArrayList = listenerInfo.mOnAttachStateChangeListeners;
        }
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((OnAttachStateChangeListener) it.next()).onViewAttachedToWindow(this);
            }
        }
        int i2 = attachInfo.mWindowVisibility;
        if (i2 != 8) {
            onWindowVisibilityChanged(i2);
        }
        if ((this.mPrivateFlags & 1024) != 0) {
            refreshDrawableState();
        }
        needGlobalAttributesUpdate(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchCancelPendingInputEvents() {
        this.mPrivateFlags3 &= -17;
        onCancelPendingInputEvents();
        if ((this.mPrivateFlags3 & 16) != 16) {
            throw new SuperNotCalledException("View " + getClass().getSimpleName() + " did not call through to super.onCancelPendingInputEvents()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchCollectViewAttributes(AttachInfo attachInfo, int i) {
        performCollectViewAttributes(attachInfo, i);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchDetachedFromWindow() {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null && attachInfo.mWindowVisibility != 8) {
            onWindowVisibilityChanged(8);
        }
        onDetachedFromWindow();
        onDetachedFromWindowInternal();
        ListenerInfo listenerInfo = this.mListenerInfo;
        CopyOnWriteArrayList copyOnWriteArrayList = listenerInfo != null ? listenerInfo.mOnAttachStateChangeListeners : null;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((OnAttachStateChangeListener) it.next()).onViewDetachedFromWindow(this);
            }
        }
        if ((this.mPrivateFlags & 1048576) != 0) {
            this.mAttachInfo.mScrollContainers.remove(this);
            this.mPrivateFlags &= -1048577;
        }
        this.mAttachInfo = null;
        if (this.mOverlay != null) {
            this.mOverlay.getOverlayView().dispatchDetachedFromWindow();
        }
    }

    public void dispatchDisplayHint(int i) {
        onDisplayHint(i);
    }

    public boolean dispatchDragEvent(DragEvent dragEvent) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnDragListener == null || (this.mViewFlags & 32) != 0 || !listenerInfo.mOnDragListener.onDrag(this, dragEvent)) {
            return onDragEvent(dragEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void dispatchDrawableHotspotChanged(float f, float f2) {
    }

    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onGenericMotionEvent(motionEvent, 0);
        }
        if ((motionEvent.getSource() & 2) != 0) {
            int action = motionEvent.getAction();
            if (action == 9 || action == 7 || action == 10) {
                if (dispatchHoverEvent(motionEvent)) {
                    return true;
                }
            } else if (dispatchGenericPointerEvent(motionEvent)) {
                return true;
            }
        } else if (dispatchGenericFocusedEvent(motionEvent)) {
            return true;
        }
        if (dispatchGenericMotionEventInternal(motionEvent)) {
            return true;
        }
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onUnhandledEvent(motionEvent, 0);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dispatchGenericPointerEvent(MotionEvent motionEvent) {
        return false;
    }

    protected void dispatchGetDisplayList() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnHoverListener == null || (this.mViewFlags & 32) != 0 || !listenerInfo.mOnHoverListener.onHover(this, motionEvent)) {
            return onHoverEvent(motionEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onKeyEvent(keyEvent, 0);
        }
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnKeyListener == null || (this.mViewFlags & 32) != 0 || !listenerInfo.mOnKeyListener.onKey(this, keyEvent.getKeyCode(), keyEvent)) {
            if (keyEvent.dispatch(this, this.mAttachInfo != null ? this.mAttachInfo.mKeyDispatchState : null, this)) {
                return true;
            }
            if (this.mInputEventConsistencyVerifier != null) {
                this.mInputEventConsistencyVerifier.onUnhandledEvent(keyEvent, 0);
                return false;
            }
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return onKeyPreIme(keyEvent.getKeyCode(), keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        return this.mNestedScrollingParent.onNestedFling(this, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        return this.mNestedScrollingParent.onNestedPreFling(this, f, f2);
    }

    public boolean dispatchNestedPrePerformAccessibilityAction(int i, Bundle bundle) {
        ViewParent parent = getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null) {
                return false;
            }
            if (viewParent.onNestedPrePerformAccessibilityAction(this, i, bundle)) {
                return true;
            }
            parent = viewParent.getParent();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
        if (r15[1] != 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.dispatchNestedPreScroll(int, int, int[], int[]):boolean");
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
            return false;
        }
        int i5 = 0;
        int i6 = 0;
        if (iArr != null) {
            getLocationInWindow(iArr);
            i5 = iArr[0];
            i6 = iArr[1];
        }
        this.mNestedScrollingParent.onNestedScroll(this, i, i2, i3, i4);
        if (iArr != null) {
            getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i5;
            iArr[1] = iArr[1] - i6;
            return true;
        }
        return true;
    }

    public final boolean dispatchPointerEvent(MotionEvent motionEvent) {
        return motionEvent.isTouchEvent() ? dispatchTouchEvent(motionEvent) : dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mAccessibilityDelegate != null ? this.mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, accessibilityEvent) : dispatchPopulateAccessibilityEventInternal(accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable;
        if (this.mID == -1 || (parcelable = sparseArray.get(this.mID)) == null) {
            return;
        }
        this.mPrivateFlags &= -131073;
        onRestoreInstanceState(parcelable);
        if ((this.mPrivateFlags & 131072) == 0) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.mID == -1 || (this.mViewFlags & 65536) != 0) {
            return;
        }
        this.mPrivateFlags &= -131073;
        Parcelable onSaveInstanceState = onSaveInstanceState();
        if ((this.mPrivateFlags & 131072) == 0) {
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
        if (onSaveInstanceState != null) {
            sparseArray.put(this.mID, onSaveInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchScreenStateChanged(int i) {
        onScreenStateChanged(i);
    }

    protected void dispatchSetActivated(boolean z) {
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected void dispatchSetSelected(boolean z) {
    }

    public void dispatchStartTemporaryDetach() {
        onStartTemporaryDetach();
    }

    public void dispatchSystemUiVisibilityChanged(int i) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnSystemUiVisibilityChangeListener == null) {
            return;
        }
        listenerInfo.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(i & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c0, code lost:
        if (r7 == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.mInputEventConsistencyVerifier != null) {
            this.mInputEventConsistencyVerifier.onTrackballEvent(motionEvent, 0);
        }
        return onTrackballEvent(motionEvent);
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchVisibilityChanged(View view, int i) {
        onVisibilityChanged(view, i);
    }

    public void dispatchWindowFocusChanged(boolean z) {
        onWindowFocusChanged(z);
    }

    public void dispatchWindowSystemUiVisiblityChanged(int i) {
        onWindowSystemUiVisibilityChanged(i);
    }

    public void dispatchWindowVisibilityChanged(int i) {
        onWindowVisibilityChanged(i);
    }

    public void draw(Canvas canvas) {
        int i = this.mPrivateFlags;
        boolean z = (PFLAG_DIRTY_MASK & i) == 4194304 && (this.mAttachInfo == null || !this.mAttachInfo.mIgnoreDirtyState);
        this.mPrivateFlags = ((-6291457) & i) | 32;
        if (!z) {
            drawBackground(canvas);
        }
        int i2 = this.mViewFlags;
        boolean z2 = (i2 & 4096) != 0;
        boolean z3 = (i2 & 8192) != 0;
        if (!z3 && !z2) {
            if (!z) {
                onDraw(canvas);
            }
            dispatchDraw(canvas);
            onDrawScrollBars(canvas);
            if (this.mOverlay == null || this.mOverlay.isEmpty()) {
                return;
            }
            this.mOverlay.getOverlayView().dispatchDraw(canvas);
            return;
        }
        boolean z4 = false;
        boolean z5 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = this.mPaddingLeft;
        boolean isPaddingOffsetRequired = isPaddingOffsetRequired();
        int i4 = i3;
        if (isPaddingOffsetRequired) {
            i4 = i3 + getLeftPaddingOffset();
        }
        int i5 = this.mScrollX + i4;
        int i6 = (((this.mRight + i5) - this.mLeft) - this.mPaddingRight) - i4;
        int fadeTop = this.mScrollY + getFadeTop(isPaddingOffsetRequired);
        int fadeHeight = fadeTop + getFadeHeight(isPaddingOffsetRequired);
        int i7 = fadeHeight;
        int i8 = i6;
        if (isPaddingOffsetRequired) {
            i8 = i6 + getRightPaddingOffset();
            i7 = fadeHeight + getBottomPaddingOffset();
        }
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        float f5 = scrollabilityCache.fadingEdgeLength;
        int i9 = (int) f5;
        int i10 = i9;
        if (z3) {
            i10 = i9;
            if (fadeTop + i9 > i7 - i9) {
                i10 = (i7 - fadeTop) / 2;
            }
        }
        int i11 = i10;
        if (z2) {
            i11 = i10;
            if (i5 + i10 > i8 - i10) {
                i11 = (i8 - i5) / 2;
            }
        }
        boolean z6 = false;
        if (z3) {
            f = Math.max(0.0f, Math.min(1.0f, getTopFadingEdgeStrength()));
            boolean z7 = f * f5 > 1.0f;
            f2 = Math.max(0.0f, Math.min(1.0f, getBottomFadingEdgeStrength()));
            if (f2 * f5 > 1.0f) {
                z6 = true;
                z4 = z7;
            } else {
                z6 = false;
                z4 = z7;
            }
        }
        boolean z8 = false;
        if (z2) {
            f3 = Math.max(0.0f, Math.min(1.0f, getLeftFadingEdgeStrength()));
            boolean z9 = f3 * f5 > 1.0f;
            f4 = Math.max(0.0f, Math.min(1.0f, getRightFadingEdgeStrength()));
            if (f4 * f5 > 1.0f) {
                z8 = true;
                z5 = z9;
            } else {
                z8 = false;
                z5 = z9;
            }
        }
        int saveCount = canvas.getSaveCount();
        int solidColor = getSolidColor();
        if (solidColor == 0) {
            if (z4) {
                canvas.saveLayer(i5, fadeTop, i8, fadeTop + i11, null, 4);
            }
            if (z6) {
                canvas.saveLayer(i5, i7 - i11, i8, i7, null, 4);
            }
            if (z5) {
                canvas.saveLayer(i5, fadeTop, i5 + i11, i7, null, 4);
            }
            if (z8) {
                canvas.saveLayer(i8 - i11, fadeTop, i8, i7, null, 4);
            }
        } else {
            scrollabilityCache.setFadeColor(solidColor);
        }
        if (!z) {
            onDraw(canvas);
        }
        dispatchDraw(canvas);
        Paint paint = scrollabilityCache.paint;
        Matrix matrix = scrollabilityCache.matrix;
        Shader shader = scrollabilityCache.shader;
        if (z4) {
            matrix.setScale(1.0f, f5 * f);
            matrix.postTranslate(i5, fadeTop);
            shader.setLocalMatrix(matrix);
            paint.setShader(shader);
            canvas.drawRect(i5, fadeTop, i8, fadeTop + i11, paint);
        }
        if (z6) {
            matrix.setScale(1.0f, f5 * f2);
            matrix.postRotate(180.0f);
            matrix.postTranslate(i5, i7);
            shader.setLocalMatrix(matrix);
            paint.setShader(shader);
            canvas.drawRect(i5, i7 - i11, i8, i7, paint);
        }
        if (z5) {
            matrix.setScale(1.0f, f5 * f3);
            matrix.postRotate(-90.0f);
            matrix.postTranslate(i5, fadeTop);
            shader.setLocalMatrix(matrix);
            paint.setShader(shader);
            canvas.drawRect(i5, fadeTop, i5 + i11, i7, paint);
        }
        if (z8) {
            matrix.setScale(1.0f, f5 * f4);
            matrix.postRotate(90.0f);
            matrix.postTranslate(i8, fadeTop);
            shader.setLocalMatrix(matrix);
            paint.setShader(shader);
            canvas.drawRect(i8 - i11, fadeTop, i8, i7, paint);
        }
        canvas.restoreToCount(saveCount);
        onDrawScrollBars(canvas);
        if (this.mOverlay == null || this.mOverlay.isEmpty()) {
            return;
        }
        this.mOverlay.getOverlayView().dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0308, code lost:
        if (r0 == false) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x03b5, code lost:
        if ((r8.mPrivateFlags3 & 2) == 2) goto L198;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean draw(android.graphics.Canvas r9, android.view.ViewGroup r10, long r11) {
        /*
            Method dump skipped, instructions count: 2127
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.draw(android.graphics.Canvas, android.view.ViewGroup, long):boolean");
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (this.mBackground != null) {
            this.mBackground.setHotspot(f, f2);
        }
        dispatchDrawableHotspotChanged(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawableStateChanged() {
        Drawable drawable = this.mBackground;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        if (this.mStateListAnimator != null) {
            this.mStateListAnimator.setState(getDrawableState());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureTransformationInfo() {
        if (this.mTransformationInfo == null) {
            this.mTransformationInfo = new TransformationInfo();
        }
    }

    public View findFocus() {
        if ((this.mPrivateFlags & 2) != 0) {
            return this;
        }
        return null;
    }

    public void findNamedViews(Map<String, View> map) {
        String transitionName;
        if ((getVisibility() == 0 || this.mGhostView != null) && (transitionName = getTransitionName()) != null) {
            map.put(transitionName, this);
        }
    }

    View findUserSetNextFocus(View view, int i) {
        switch (i) {
            case 1:
                if (this.mID != -1) {
                    final int i2 = this.mID;
                    return view.findViewByPredicateInsideOut(this, new Predicate<View>() { // from class: android.view.View.2
                        @Override // com.android.internal.util.Predicate
                        public boolean apply(View view2) {
                            return view2.mNextFocusForwardId == i2;
                        }
                    });
                }
                return null;
            case 2:
                if (this.mNextFocusForwardId != -1) {
                    return findViewInsideOutShouldExist(view, this.mNextFocusForwardId);
                }
                return null;
            case 17:
                if (this.mNextFocusLeftId != -1) {
                    return findViewInsideOutShouldExist(view, this.mNextFocusLeftId);
                }
                return null;
            case 33:
                if (this.mNextFocusUpId != -1) {
                    return findViewInsideOutShouldExist(view, this.mNextFocusUpId);
                }
                return null;
            case 66:
                if (this.mNextFocusRightId != -1) {
                    return findViewInsideOutShouldExist(view, this.mNextFocusRightId);
                }
                return null;
            case 130:
                if (this.mNextFocusDownId != -1) {
                    return findViewInsideOutShouldExist(view, this.mNextFocusDownId);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View findViewByAccessibilityId(int i) {
        if (i < 0) {
            return null;
        }
        return findViewByAccessibilityIdTraversal(i);
    }

    public View findViewByAccessibilityIdTraversal(int i) {
        if (getAccessibilityViewId() == i) {
            return this;
        }
        return null;
    }

    public final View findViewById(int i) {
        if (i < 0) {
            return null;
        }
        return findViewTraversal(i);
    }

    public final View findViewByPredicate(Predicate<View> predicate) {
        return findViewByPredicateTraversal(predicate, null);
    }

    public final View findViewByPredicateInsideOut(View view, Predicate<View> predicate) {
        View findViewByPredicateTraversal;
        View view2 = null;
        while (true) {
            findViewByPredicateTraversal = view.findViewByPredicateTraversal(predicate, view2);
            if (findViewByPredicateTraversal != null || view == this) {
                break;
            }
            ViewParent parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view2 = view;
            view = (View) parent;
        }
        return findViewByPredicateTraversal;
    }

    protected View findViewByPredicateTraversal(Predicate<View> predicate, View view) {
        if (predicate.apply(this)) {
            return this;
        }
        return null;
    }

    protected View findViewTraversal(int i) {
        if (i == this.mID) {
            return this;
        }
        return null;
    }

    public final View findViewWithTag(Object obj) {
        if (obj == null) {
            return null;
        }
        return findViewWithTagTraversal(obj);
    }

    protected View findViewWithTagTraversal(Object obj) {
        if (obj == null || !obj.equals(this.mTag)) {
            return null;
        }
        return this;
    }

    public void findViewsWithText(ArrayList<View> arrayList, CharSequence charSequence, int i) {
        if (getAccessibilityNodeProvider() != null) {
            if ((i & 4) != 0) {
                arrayList.add(this);
            }
        } else if ((i & 2) == 0 || charSequence == null || charSequence.length() <= 0 || this.mContentDescription == null || this.mContentDescription.length() <= 0) {
        } else {
            if (this.mContentDescription.toString().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                arrayList.add(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if ((this.mPrivateFlags3 & 32) == 0) {
            if (rect == null) {
                return false;
            }
            try {
                this.mPrivateFlags3 |= 64;
                return dispatchApplyWindowInsets(new WindowInsets(rect)).isConsumed();
            } finally {
                this.mPrivateFlags3 &= -65;
            }
        }
        return fitSystemWindowsInt(rect);
    }

    public boolean fitsSystemWindows() {
        return getFitsSystemWindows();
    }

    public View focusSearch(int i) {
        if (this.mParent != null) {
            return this.mParent.focusSearch(this, i);
        }
        return null;
    }

    public void forceLayout() {
        if (this.mMeasureCache != null) {
            this.mMeasureCache.clear();
        }
        this.mPrivateFlags |= 4096;
        this.mPrivateFlags |= Integer.MIN_VALUE;
    }

    public boolean gatherTransparentRegion(Region region) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (region == null || attachInfo == null) {
            return true;
        }
        int i = this.mPrivateFlags;
        if ((i & 128) == 0) {
            int[] iArr = attachInfo.mTransparentLocation;
            getLocationInWindow(iArr);
            region.op(iArr[0], iArr[1], (iArr[0] + this.mRight) - this.mLeft, (iArr[1] + this.mBottom) - this.mTop, Region.Op.DIFFERENCE);
            return true;
        } else if ((i & 256) == 0 || this.mBackground == null || this.mBackground.getOpacity() == -2) {
            return true;
        } else {
            applyDrawableToTransparentRegion(this.mBackground, region);
            return true;
        }
    }

    public AccessibilityDelegate getAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public int getAccessibilityLiveRegion() {
        return (this.mPrivateFlags2 & 25165824) >> 23;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mAccessibilityDelegate != null) {
            return this.mAccessibilityDelegate.getAccessibilityNodeProvider(this);
        }
        return null;
    }

    public int getAccessibilitySelectionEnd() {
        return getAccessibilitySelectionStart();
    }

    public int getAccessibilitySelectionStart() {
        return this.mAccessibilityCursorPosition;
    }

    public int getAccessibilityTraversalAfter() {
        return this.mAccessibilityTraversalAfterId;
    }

    public int getAccessibilityTraversalBefore() {
        return this.mAccessibilityTraversalBeforeId;
    }

    public int getAccessibilityViewId() {
        if (this.mAccessibilityViewId == -1) {
            int i = sNextAccessibilityViewId;
            sNextAccessibilityViewId = i + 1;
            this.mAccessibilityViewId = i;
        }
        return this.mAccessibilityViewId;
    }

    public int getAccessibilityWindowId() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mAccessibilityWindowId;
        }
        return Integer.MAX_VALUE;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getAlpha() {
        if (this.mTransformationInfo != null) {
            return this.mTransformationInfo.mAlpha;
        }
        return 1.0f;
    }

    public Animation getAnimation() {
        return this.mCurrentAnimation;
    }

    public IBinder getApplicationWindowToken() {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            IBinder iBinder = attachInfo.mPanelParentWindowToken;
            IBinder iBinder2 = iBinder;
            if (iBinder == null) {
                iBinder2 = attachInfo.mWindowToken;
            }
            return iBinder2;
        }
        return null;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public ColorStateList getBackgroundTintList() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        if (this.mBackgroundTint != null) {
            return this.mBackgroundTint.mTintMode;
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        return -1;
    }

    @ViewDebug.CapturedViewProperty
    public final int getBottom() {
        return this.mBottom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return computeVerticalScrollOffset() + computeVerticalScrollExtent() < computeVerticalScrollRange() ? 1.0f : 0.0f;
    }

    protected int getBottomPaddingOffset() {
        return 0;
    }

    public void getBoundsOnScreen(Rect rect) {
        getBoundsOnScreen(rect, false);
    }

    public void getBoundsOnScreen(Rect rect, boolean z) {
        ViewParent viewParent;
        if (this.mAttachInfo == null) {
            return;
        }
        RectF rectF = this.mAttachInfo.mTmpTransformRect;
        rectF.set(0.0f, 0.0f, this.mRight - this.mLeft, this.mBottom - this.mTop);
        if (!hasIdentityMatrix()) {
            getMatrix().mapRect(rectF);
        }
        rectF.offset(this.mLeft, this.mTop);
        ViewParent viewParent2 = this.mParent;
        while (true) {
            viewParent = viewParent2;
            if (!(viewParent instanceof View)) {
                break;
            }
            View view = (View) viewParent;
            rectF.offset(-view.mScrollX, -view.mScrollY);
            if (z) {
                rectF.left = Math.max(rectF.left, 0.0f);
                rectF.top = Math.max(rectF.top, 0.0f);
                rectF.right = Math.min(rectF.right, view.getWidth());
                rectF.bottom = Math.min(rectF.bottom, view.getHeight());
            }
            if (!view.hasIdentityMatrix()) {
                view.getMatrix().mapRect(rectF);
            }
            rectF.offset(view.mLeft, view.mTop);
            viewParent2 = view.mParent;
        }
        if (viewParent instanceof ViewRootImpl) {
            rectF.offset(0.0f, -((ViewRootImpl) viewParent).mCurScrollY);
        }
        rectF.offset(this.mAttachInfo.mWindowLeft, this.mAttachInfo.mWindowTop);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public float getCameraDistance() {
        return -(this.mRenderNode.getCameraDistance() * this.mResources.getDisplayMetrics().densityDpi);
    }

    public Rect getClipBounds() {
        if (this.mClipBounds != null) {
            return new Rect(this.mClipBounds);
        }
        return null;
    }

    public final boolean getClipToOutline() {
        return this.mRenderNode.getClipToOutline();
    }

    @ViewDebug.ExportedProperty(category = "accessibility")
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @ViewDebug.CapturedViewProperty
    public final Context getContext() {
        return this.mContext;
    }

    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return null;
    }

    public Display getDisplay() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mDisplay;
        }
        return null;
    }

    public RenderNode getDisplayList() {
        updateDisplayListIfDirty();
        return this.mRenderNode;
    }

    public final int[] getDrawableState() {
        if (this.mDrawableState == null || (this.mPrivateFlags & 1024) != 0) {
            this.mDrawableState = onCreateDrawableState(0);
            this.mPrivateFlags &= -1025;
            return this.mDrawableState;
        }
        return this.mDrawableState;
    }

    public Bitmap getDrawingCache() {
        return getDrawingCache(false);
    }

    public Bitmap getDrawingCache(boolean z) {
        if ((this.mViewFlags & 131072) == 131072) {
            return null;
        }
        if ((this.mViewFlags & 32768) == 32768) {
            buildDrawingCache(z);
        }
        return z ? this.mDrawingCache : this.mUnscaledDrawingCache;
    }

    public int getDrawingCacheBackgroundColor() {
        return this.mDrawingCacheBackgroundColor;
    }

    public int getDrawingCacheQuality() {
        return this.mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }

    public void getDrawingRect(Rect rect) {
        rect.left = this.mScrollX;
        rect.top = this.mScrollY;
        rect.right = this.mScrollX + (this.mRight - this.mLeft);
        rect.bottom = this.mScrollY + (this.mBottom - this.mTop);
    }

    public long getDrawingTime() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mDrawingTime;
        }
        return 0L;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getElevation() {
        return this.mRenderNode.getElevation();
    }

    protected int getFadeHeight(boolean z) {
        int i = this.mPaddingTop;
        int i2 = i;
        if (z) {
            i2 = i + getTopPaddingOffset();
        }
        return ((this.mBottom - this.mTop) - this.mPaddingBottom) - i2;
    }

    protected int getFadeTop(boolean z) {
        int i = this.mPaddingTop;
        int i2 = i;
        if (z) {
            i2 = i + getTopPaddingOffset();
        }
        return i2;
    }

    @ViewDebug.ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        return (this.mViewFlags & 1024) != 0;
    }

    @ViewDebug.ExportedProperty
    public boolean getFitsSystemWindows() {
        return (this.mViewFlags & 2) == 2;
    }

    public ArrayList<View> getFocusables(int i) {
        ArrayList<View> arrayList = new ArrayList<>(24);
        addFocusables(arrayList, i);
        return arrayList;
    }

    public void getFocusedRect(Rect rect) {
        getDrawingRect(rect);
    }

    public final boolean getGlobalVisibleRect(Rect rect) {
        return getGlobalVisibleRect(rect, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r6.mParent.getChildVisibleRect(r6, r7, r8) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getGlobalVisibleRect(android.graphics.Rect r7, android.graphics.Point r8) {
        /*
            r6 = this;
            r0 = 0
            r12 = r0
            r0 = r6
            int r0 = r0.mRight
            r1 = r6
            int r1 = r1.mLeft
            int r0 = r0 - r1
            r9 = r0
            r0 = r6
            int r0 = r0.mBottom
            r1 = r6
            int r1 = r1.mTop
            int r0 = r0 - r1
            r10 = r0
            r0 = r12
            r11 = r0
            r0 = r9
            if (r0 <= 0) goto L61
            r0 = r12
            r11 = r0
            r0 = r10
            if (r0 <= 0) goto L61
            r0 = r7
            r1 = 0
            r2 = 0
            r3 = r9
            r4 = r10
            r0.set(r1, r2, r3, r4)
            r0 = r8
            if (r0 == 0) goto L44
            r0 = r8
            r1 = r6
            int r1 = r1.mScrollX
            int r1 = -r1
            r2 = r6
            int r2 = r2.mScrollY
            int r2 = -r2
            r0.set(r1, r2)
        L44:
            r0 = r6
            android.view.ViewParent r0 = r0.mParent
            if (r0 == 0) goto L5e
            r0 = r12
            r11 = r0
            r0 = r6
            android.view.ViewParent r0 = r0.mParent
            r1 = r6
            r2 = r7
            r3 = r8
            boolean r0 = r0.getChildVisibleRect(r1, r2, r3)
            if (r0 == 0) goto L61
        L5e:
            r0 = 1
            r11 = r0
        L61:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.getGlobalVisibleRect(android.graphics.Rect, android.graphics.Point):boolean");
    }

    public Handler getHandler() {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            return attachInfo.mHandler;
        }
        return null;
    }

    HardwareLayer getHardwareLayer() {
        return null;
    }

    public HardwareRenderer getHardwareRenderer() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mHardwareRenderer;
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "layout")
    public final int getHeight() {
        return this.mBottom - this.mTop;
    }

    public void getHitRect(Rect rect) {
        if (hasIdentityMatrix() || this.mAttachInfo == null) {
            rect.set(this.mLeft, this.mTop, this.mRight, this.mBottom);
            return;
        }
        RectF rectF = this.mAttachInfo.mTmpTransformRect;
        rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        getMatrix().mapRect(rectF);
        rect.set(((int) rectF.left) + this.mLeft, ((int) rectF.top) + this.mTop, ((int) rectF.right) + this.mLeft, ((int) rectF.bottom) + this.mTop);
    }

    public int getHorizontalFadingEdgeLength() {
        ScrollabilityCache scrollabilityCache;
        if (!isHorizontalFadingEdgeEnabled() || (scrollabilityCache = this.mScrollCache) == null) {
            return 0;
        }
        return scrollabilityCache.fadingEdgeLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getHorizontalScrollFactor() {
        return getVerticalScrollFactor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getHorizontalScrollbarHeight() {
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        int i = 0;
        if (scrollabilityCache != null) {
            ScrollBarDrawable scrollBarDrawable = scrollabilityCache.scrollBar;
            i = 0;
            if (scrollBarDrawable != null) {
                int size = scrollBarDrawable.getSize(false);
                i = size;
                if (size <= 0) {
                    i = scrollabilityCache.scrollBarSize;
                }
            }
        }
        return i;
    }

    public void getHotspotBounds(Rect rect) {
        Drawable background = getBackground();
        if (background != null) {
            background.getHotspotBounds(rect);
        } else {
            getBoundsOnScreen(rect);
        }
    }

    @ViewDebug.CapturedViewProperty
    public int getId() {
        return this.mID;
    }

    @ViewDebug.ExportedProperty(category = "accessibility", mapping = {@ViewDebug.IntToString(from = 0, to = "auto"), @ViewDebug.IntToString(from = 1, to = "yes"), @ViewDebug.IntToString(from = 2, to = "no"), @ViewDebug.IntToString(from = 4, to = "noHideDescendants")})
    public int getImportantForAccessibility() {
        return (this.mPrivateFlags2 & PFLAG2_IMPORTANT_FOR_ACCESSIBILITY_MASK) >> 20;
    }

    public final Matrix getInverseMatrix() {
        ensureTransformationInfo();
        if (this.mTransformationInfo.mInverseMatrix == null) {
            this.mTransformationInfo.mInverseMatrix = new Matrix();
        }
        Matrix matrix = this.mTransformationInfo.mInverseMatrix;
        this.mRenderNode.getInverseMatrix(matrix);
        return matrix;
    }

    public CharSequence getIterableTextForAccessibility() {
        return getContentDescription();
    }

    public AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(int i) {
        switch (i) {
            case 1:
                CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
                if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() <= 0) {
                    return null;
                }
                AccessibilityIterators.CharacterTextSegmentIterator characterTextSegmentIterator = AccessibilityIterators.CharacterTextSegmentIterator.getInstance(this.mContext.getResources().getConfiguration().locale);
                characterTextSegmentIterator.initialize(iterableTextForAccessibility.toString());
                return characterTextSegmentIterator;
            case 2:
                CharSequence iterableTextForAccessibility2 = getIterableTextForAccessibility();
                if (iterableTextForAccessibility2 == null || iterableTextForAccessibility2.length() <= 0) {
                    return null;
                }
                AccessibilityIterators.WordTextSegmentIterator wordTextSegmentIterator = AccessibilityIterators.WordTextSegmentIterator.getInstance(this.mContext.getResources().getConfiguration().locale);
                wordTextSegmentIterator.initialize(iterableTextForAccessibility2.toString());
                return wordTextSegmentIterator;
            case 8:
                CharSequence iterableTextForAccessibility3 = getIterableTextForAccessibility();
                if (iterableTextForAccessibility3 == null || iterableTextForAccessibility3.length() <= 0) {
                    return null;
                }
                AccessibilityIterators.ParagraphTextSegmentIterator paragraphTextSegmentIterator = AccessibilityIterators.ParagraphTextSegmentIterator.getInstance();
                paragraphTextSegmentIterator.initialize(iterableTextForAccessibility3.toString());
                return paragraphTextSegmentIterator;
            default:
                return null;
        }
    }

    public boolean getKeepScreenOn() {
        return (this.mViewFlags & 67108864) != 0;
    }

    public KeyEvent.DispatcherState getKeyDispatcherState() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mKeyDispatchState;
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "accessibility")
    public int getLabelFor() {
        return this.mLabelForId;
    }

    public int getLayerType() {
        return this.mLayerType;
    }

    @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "RESOLVED_DIRECTION_LTR"), @ViewDebug.IntToString(from = 1, to = "RESOLVED_DIRECTION_RTL")})
    public int getLayoutDirection() {
        if (getContext().getApplicationInfo().targetSdkVersion >= 17 || isSystemApp()) {
            return (this.mPrivateFlags2 & 16) == 16 ? 1 : 0;
        }
        this.mPrivateFlags2 |= 32;
        return 0;
    }

    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    @ViewDebug.CapturedViewProperty
    public final int getLeft() {
        return this.mLeft;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    protected int getLeftPaddingOffset() {
        return 0;
    }

    ListenerInfo getListenerInfo() {
        if (this.mListenerInfo != null) {
            return this.mListenerInfo;
        }
        this.mListenerInfo = new ListenerInfo();
        return this.mListenerInfo;
    }

    public final boolean getLocalVisibleRect(Rect rect) {
        Point point = this.mAttachInfo != null ? this.mAttachInfo.mPoint : new Point();
        if (getGlobalVisibleRect(rect, point)) {
            rect.offset(-point.x, -point.y);
            return true;
        }
        return false;
    }

    public void getLocationInWindow(int[] iArr) {
        ViewParent viewParent;
        if (iArr == null || iArr.length < 2) {
            throw new IllegalArgumentException("location must be an array of two integers");
        }
        if (this.mAttachInfo == null) {
            iArr[1] = 0;
            iArr[0] = 0;
            return;
        }
        float[] fArr = this.mAttachInfo.mTmpTransformLocation;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (!hasIdentityMatrix()) {
            getMatrix().mapPoints(fArr);
        }
        fArr[0] = fArr[0] + this.mLeft;
        fArr[1] = fArr[1] + this.mTop;
        ViewParent viewParent2 = this.mParent;
        while (true) {
            viewParent = viewParent2;
            if (!(viewParent instanceof View)) {
                break;
            }
            View view = (View) viewParent;
            fArr[0] = fArr[0] - view.mScrollX;
            fArr[1] = fArr[1] - view.mScrollY;
            if (!view.hasIdentityMatrix()) {
                view.getMatrix().mapPoints(fArr);
            }
            fArr[0] = fArr[0] + view.mLeft;
            fArr[1] = fArr[1] + view.mTop;
            viewParent2 = view.mParent;
        }
        if (viewParent instanceof ViewRootImpl) {
            fArr[1] = fArr[1] - ((ViewRootImpl) viewParent).mCurScrollY;
        }
        iArr[0] = (int) (fArr[0] + 0.5f);
        iArr[1] = (int) (fArr[1] + 0.5f);
    }

    public void getLocationOnScreen(int[] iArr) {
        getLocationInWindow(iArr);
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            iArr[0] = iArr[0] + attachInfo.mWindowLeft;
            iArr[1] = iArr[1] + attachInfo.mWindowTop;
        }
    }

    @ViewDebug.ExportedProperty(category = "layout", indexMapping = {@ViewDebug.IntToString(from = 0, to = "x"), @ViewDebug.IntToString(from = 1, to = "y")})
    public int[] getLocationOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr;
    }

    public Matrix getMatrix() {
        ensureTransformationInfo();
        Matrix matrix = this.mTransformationInfo.mMatrix;
        this.mRenderNode.getMatrix(matrix);
        return matrix;
    }

    public final int getMeasuredHeight() {
        return this.mMeasuredHeight & 16777215;
    }

    public final int getMeasuredHeightAndState() {
        return this.mMeasuredHeight;
    }

    public final int getMeasuredState() {
        return (this.mMeasuredWidth & MEASURED_STATE_MASK) | ((this.mMeasuredHeight >> 16) & (-256));
    }

    public final int getMeasuredWidth() {
        return this.mMeasuredWidth & 16777215;
    }

    public final int getMeasuredWidthAndState() {
        return this.mMeasuredWidth;
    }

    public int getMinimumHeight() {
        return this.mMinHeight;
    }

    public int getMinimumWidth() {
        return this.mMinWidth;
    }

    public int getNextFocusDownId() {
        return this.mNextFocusDownId;
    }

    public int getNextFocusForwardId() {
        return this.mNextFocusForwardId;
    }

    public int getNextFocusLeftId() {
        return this.mNextFocusLeftId;
    }

    public int getNextFocusRightId() {
        return this.mNextFocusRightId;
    }

    public int getNextFocusUpId() {
        return this.mNextFocusUpId;
    }

    public OnFocusChangeListener getOnFocusChangeListener() {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo != null) {
            return listenerInfo.mOnFocusChangeListener;
        }
        return null;
    }

    public Insets getOpticalInsets() {
        if (this.mLayoutInsets == null) {
            this.mLayoutInsets = computeOpticalInsets();
        }
        return this.mLayoutInsets;
    }

    public ViewOutlineProvider getOutlineProvider() {
        return this.mOutlineProvider;
    }

    public int getOverScrollMode() {
        return this.mOverScrollMode;
    }

    public ViewOverlay getOverlay() {
        if (this.mOverlay == null) {
            this.mOverlay = new ViewOverlay(this.mContext, this);
        }
        return this.mOverlay;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingEnd() {
        if (!isPaddingResolved()) {
            resolvePadding();
        }
        return getLayoutDirection() == 1 ? this.mPaddingLeft : this.mPaddingRight;
    }

    public int getPaddingLeft() {
        if (!isPaddingResolved()) {
            resolvePadding();
        }
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        if (!isPaddingResolved()) {
            resolvePadding();
        }
        return this.mPaddingRight;
    }

    public int getPaddingStart() {
        if (!isPaddingResolved()) {
            resolvePadding();
        }
        return getLayoutDirection() == 1 ? this.mPaddingRight : this.mPaddingLeft;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public final ViewParent getParent() {
        return this.mParent;
    }

    public ViewParent getParentForAccessibility() {
        if (this.mParent instanceof View) {
            return ((View) this.mParent).includeForAccessibility() ? this.mParent : this.mParent.getParentForAccessibility();
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getPivotX() {
        return this.mRenderNode.getPivotX();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getPivotY() {
        return this.mRenderNode.getPivotY();
    }

    @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = 0, to = "LTR"), @ViewDebug.IntToString(from = 1, to = "RTL"), @ViewDebug.IntToString(from = 2, to = "INHERIT"), @ViewDebug.IntToString(from = 3, to = "LOCALE")})
    public int getRawLayoutDirection() {
        return (this.mPrivateFlags2 & 12) >> 2;
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "INHERIT"), @ViewDebug.IntToString(from = 1, to = "GRAVITY"), @ViewDebug.IntToString(from = 2, to = "TEXT_START"), @ViewDebug.IntToString(from = 3, to = "TEXT_END"), @ViewDebug.IntToString(from = 4, to = "CENTER"), @ViewDebug.IntToString(from = 5, to = "VIEW_START"), @ViewDebug.IntToString(from = 6, to = "VIEW_END")})
    public int getRawTextAlignment() {
        return (this.mPrivateFlags2 & PFLAG2_TEXT_ALIGNMENT_MASK) >> 13;
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "INHERIT"), @ViewDebug.IntToString(from = 1, to = "FIRST_STRONG"), @ViewDebug.IntToString(from = 2, to = "ANY_RTL"), @ViewDebug.IntToString(from = 3, to = "LTR"), @ViewDebug.IntToString(from = 4, to = "RTL"), @ViewDebug.IntToString(from = 5, to = "LOCALE")})
    public int getRawTextDirection() {
        return (this.mPrivateFlags2 & PFLAG2_TEXT_DIRECTION_MASK) >> 6;
    }

    public Resources getResources() {
        return this.mResources;
    }

    @ViewDebug.CapturedViewProperty
    public final int getRight() {
        return this.mRight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() < computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }

    protected int getRightPaddingOffset() {
        return 0;
    }

    public View getRootView() {
        View view;
        View view2;
        if (this.mAttachInfo == null || (view2 = this.mAttachInfo.mRootView) == null) {
            View view3 = this;
            while (true) {
                view = view3;
                if (view.mParent == null || !(view.mParent instanceof View)) {
                    break;
                }
                view3 = (View) view.mParent;
            }
            return view;
        }
        return view2;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getRotation() {
        return this.mRenderNode.getRotation();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getRotationX() {
        return this.mRenderNode.getRotationX();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getRotationY() {
        return this.mRenderNode.getRotationY();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getScaleX() {
        return this.mRenderNode.getScaleX();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getScaleY() {
        return this.mRenderNode.getScaleY();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return this.mScrollCache == null ? ViewConfiguration.getScrollDefaultDelay() : this.mScrollCache.scrollBarDefaultDelayBeforeFade;
    }

    public int getScrollBarFadeDuration() {
        return this.mScrollCache == null ? ViewConfiguration.getScrollBarFadeDuration() : this.mScrollCache.scrollBarFadeDuration;
    }

    public int getScrollBarSize() {
        return this.mScrollCache == null ? ViewConfiguration.get(this.mContext).getScaledScrollBarSize() : this.mScrollCache.scrollBarSize;
    }

    @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "INSIDE_OVERLAY"), @ViewDebug.IntToString(from = 16777216, to = "INSIDE_INSET"), @ViewDebug.IntToString(from = 33554432, to = "OUTSIDE_OVERLAY"), @ViewDebug.IntToString(from = 50331648, to = "OUTSIDE_INSET")})
    public int getScrollBarStyle() {
        return this.mViewFlags & 50331648;
    }

    public final int getScrollX() {
        return this.mScrollX;
    }

    public final int getScrollY() {
        return this.mScrollY;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        return 0;
    }

    public StateListAnimator getStateListAnimator() {
        return this.mStateListAnimator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return this.mBackground == null ? this.mMinHeight : Math.max(this.mMinHeight, this.mBackground.getMinimumHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return this.mBackground == null ? this.mMinWidth : Math.max(this.mMinWidth, this.mBackground.getMinimumWidth());
    }

    public int getSystemUiVisibility() {
        return this.mSystemUiVisibility;
    }

    @ViewDebug.ExportedProperty
    public Object getTag() {
        return this.mTag;
    }

    public Object getTag(int i) {
        if (this.mKeyedTags != null) {
            return this.mKeyedTags.get(i);
        }
        return null;
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "INHERIT"), @ViewDebug.IntToString(from = 1, to = "GRAVITY"), @ViewDebug.IntToString(from = 2, to = "TEXT_START"), @ViewDebug.IntToString(from = 3, to = "TEXT_END"), @ViewDebug.IntToString(from = 4, to = "CENTER"), @ViewDebug.IntToString(from = 5, to = "VIEW_START"), @ViewDebug.IntToString(from = 6, to = "VIEW_END")})
    public int getTextAlignment() {
        return (this.mPrivateFlags2 & PFLAG2_TEXT_ALIGNMENT_RESOLVED_MASK) >> 17;
    }

    @ViewDebug.ExportedProperty(category = "text", mapping = {@ViewDebug.IntToString(from = 0, to = "INHERIT"), @ViewDebug.IntToString(from = 1, to = "FIRST_STRONG"), @ViewDebug.IntToString(from = 2, to = "ANY_RTL"), @ViewDebug.IntToString(from = 3, to = "LTR"), @ViewDebug.IntToString(from = 4, to = "RTL"), @ViewDebug.IntToString(from = 5, to = "LOCALE")})
    public int getTextDirection() {
        return (this.mPrivateFlags2 & PFLAG2_TEXT_DIRECTION_RESOLVED_MASK) >> 10;
    }

    @ViewDebug.CapturedViewProperty
    public final int getTop() {
        return this.mTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    protected int getTopPaddingOffset() {
        return 0;
    }

    public TouchDelegate getTouchDelegate() {
        return this.mTouchDelegate;
    }

    public ArrayList<View> getTouchables() {
        ArrayList<View> arrayList = new ArrayList<>();
        addTouchables(arrayList);
        return arrayList;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getTransitionAlpha() {
        if (this.mTransformationInfo != null) {
            return this.mTransformationInfo.mTransitionAlpha;
        }
        return 1.0f;
    }

    @ViewDebug.ExportedProperty
    public String getTransitionName() {
        return this.mTransitionName;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getTranslationX() {
        return this.mRenderNode.getTranslationX();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getTranslationY() {
        return this.mRenderNode.getTranslationY();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getTranslationZ() {
        return this.mRenderNode.getTranslationZ();
    }

    public int getVerticalFadingEdgeLength() {
        ScrollabilityCache scrollabilityCache;
        if (!isVerticalFadingEdgeEnabled() || (scrollabilityCache = this.mScrollCache) == null) {
            return 0;
        }
        return scrollabilityCache.fadingEdgeLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getVerticalScrollFactor() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (!this.mContext.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(this.mContext.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    public int getVerticalScrollbarPosition() {
        return this.mVerticalScrollbarPosition;
    }

    public int getVerticalScrollbarWidth() {
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        int i = 0;
        if (scrollabilityCache != null) {
            ScrollBarDrawable scrollBarDrawable = scrollabilityCache.scrollBar;
            i = 0;
            if (scrollBarDrawable != null) {
                int size = scrollBarDrawable.getSize(true);
                i = size;
                if (size <= 0) {
                    i = scrollabilityCache.scrollBarSize;
                }
            }
        }
        return i;
    }

    public ViewRootImpl getViewRootImpl() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mViewRootImpl;
        }
        return null;
    }

    public ViewTreeObserver getViewTreeObserver() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mTreeObserver;
        }
        if (this.mFloatingTreeObserver == null) {
            this.mFloatingTreeObserver = new ViewTreeObserver();
        }
        return this.mFloatingTreeObserver;
    }

    @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "VISIBLE"), @ViewDebug.IntToString(from = 4, to = "INVISIBLE"), @ViewDebug.IntToString(from = 8, to = "GONE")})
    public int getVisibility() {
        return this.mViewFlags & 12;
    }

    @ViewDebug.ExportedProperty(category = "layout")
    public final int getWidth() {
        return this.mRight - this.mLeft;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getWindowAttachCount() {
        return this.mWindowAttachCount;
    }

    public WindowId getWindowId() {
        if (this.mAttachInfo == null) {
            return null;
        }
        if (this.mAttachInfo.mWindowId == null) {
            try {
                this.mAttachInfo.mIWindowId = this.mAttachInfo.mSession.getWindowId(this.mAttachInfo.mWindowToken);
                this.mAttachInfo.mWindowId = new WindowId(this.mAttachInfo.mIWindowId);
            } catch (RemoteException e) {
            }
        }
        return this.mAttachInfo.mWindowId;
    }

    IWindowSession getWindowSession() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mSession;
        }
        return null;
    }

    public int getWindowSystemUiVisibility() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mSystemUiVisibility;
        }
        return 0;
    }

    public IBinder getWindowToken() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mWindowToken;
        }
        return null;
    }

    public int getWindowVisibility() {
        if (this.mAttachInfo != null) {
            return this.mAttachInfo.mWindowVisibility;
        }
        return 8;
    }

    public void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.mAttachInfo == null) {
            DisplayManagerGlobal.getInstance().getRealDisplay(0).getRectSize(rect);
            return;
        }
        try {
            this.mAttachInfo.mSession.getDisplayFrame(this.mAttachInfo.mWindow, rect);
            Rect rect2 = this.mAttachInfo.mVisibleInsets;
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
        } catch (RemoteException e) {
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getX() {
        return this.mLeft + getTranslationX();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getY() {
        return this.mTop + getTranslationY();
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void hackTurnOffWindowResizeAnim(boolean z) {
        this.mAttachInfo.mTurnOffWindowResizeAnim = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleFocusGainInternal(int i, Rect rect) {
        if ((this.mPrivateFlags & 2) == 0) {
            this.mPrivateFlags |= 2;
            View findFocus = this.mAttachInfo != null ? getRootView().findFocus() : null;
            if (this.mParent != null) {
                this.mParent.requestChildFocus(this, this);
            }
            if (this.mAttachInfo != null) {
                this.mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(findFocus, this);
            }
            onFocusChanged(true, i, rect);
            refreshDrawableState();
        }
    }

    @ViewDebug.ExportedProperty(category = "focus")
    public boolean hasFocus() {
        return (this.mPrivateFlags & 2) != 0;
    }

    public boolean hasFocusable() {
        if (!isFocusableInTouchMode()) {
            ViewParent viewParent = this.mParent;
            while (true) {
                ViewParent viewParent2 = viewParent;
                if (!(viewParent2 instanceof ViewGroup)) {
                    break;
                } else if (((ViewGroup) viewParent2).shouldBlockFocusForTouchscreen()) {
                    return false;
                } else {
                    viewParent = viewParent2.getParent();
                }
            }
        }
        return (this.mViewFlags & 12) == 0 && isFocusable();
    }

    protected boolean hasHoveredChild() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasIdentityMatrix() {
        return this.mRenderNode.hasIdentityMatrix();
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingParent != null;
    }

    public boolean hasOnClickListeners() {
        ListenerInfo listenerInfo = this.mListenerInfo;
        return (listenerInfo == null || listenerInfo.mOnClickListener == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasOpaqueScrollbars() {
        return (this.mPrivateFlags & 16777216) == 16777216;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean hasOverlappingRendering() {
        return true;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean hasShadow() {
        return this.mRenderNode.hasShadow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasStaticLayer() {
        return true;
    }

    @ViewDebug.ExportedProperty(category = "layout")
    public boolean hasTransientState() {
        return (this.mPrivateFlags2 & Integer.MIN_VALUE) == Integer.MIN_VALUE;
    }

    public boolean hasWindowFocus() {
        return this.mAttachInfo != null && this.mAttachInfo.mHasWindowFocus;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (isImportantForAccessibility() != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean includeForAccessibility() {
        /*
            r3 = this;
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r3
            android.view.View$AttachInfo r0 = r0.mAttachInfo
            if (r0 == 0) goto L23
            r0 = r3
            android.view.View$AttachInfo r0 = r0.mAttachInfo
            int r0 = r0.mAccessibilityFetchFlags
            r1 = 8
            r0 = r0 & r1
            if (r0 != 0) goto L21
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.isImportantForAccessibility()
            if (r0 == 0) goto L23
        L21:
            r0 = 1
            r4 = r0
        L23:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.includeForAccessibility():boolean");
    }

    protected void initializeFadingEdge(TypedArray typedArray) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.View);
        initializeFadingEdgeInternal(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    protected void initializeFadingEdgeInternal(TypedArray typedArray) {
        initScrollCache();
        this.mScrollCache.fadingEdgeLength = typedArray.getDimensionPixelSize(25, ViewConfiguration.get(this.mContext).getScaledFadingEdgeLength());
    }

    protected void initializeScrollbars(TypedArray typedArray) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R.styleable.View);
        initializeScrollbarsInternal(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeScrollbarsInternal(TypedArray typedArray) {
        initScrollCache();
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        if (scrollabilityCache.scrollBar == null) {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        }
        boolean z = typedArray.getBoolean(45, true);
        if (!z) {
            scrollabilityCache.state = 1;
        }
        scrollabilityCache.fadeScrollBars = z;
        scrollabilityCache.scrollBarFadeDuration = typedArray.getInt(43, ViewConfiguration.getScrollBarFadeDuration());
        scrollabilityCache.scrollBarDefaultDelayBeforeFade = typedArray.getInt(44, ViewConfiguration.getScrollDefaultDelay());
        scrollabilityCache.scrollBarSize = typedArray.getDimensionPixelSize(1, ViewConfiguration.get(this.mContext).getScaledScrollBarSize());
        scrollabilityCache.scrollBar.setHorizontalTrackDrawable(typedArray.getDrawable(4));
        Drawable drawable = typedArray.getDrawable(2);
        if (drawable != null) {
            scrollabilityCache.scrollBar.setHorizontalThumbDrawable(drawable);
        }
        if (typedArray.getBoolean(6, false)) {
            scrollabilityCache.scrollBar.setAlwaysDrawHorizontalTrack(true);
        }
        Drawable drawable2 = typedArray.getDrawable(5);
        scrollabilityCache.scrollBar.setVerticalTrackDrawable(drawable2);
        Drawable drawable3 = typedArray.getDrawable(3);
        if (drawable3 != null) {
            scrollabilityCache.scrollBar.setVerticalThumbDrawable(drawable3);
        }
        if (typedArray.getBoolean(7, false)) {
            scrollabilityCache.scrollBar.setAlwaysDrawVerticalTrack(true);
        }
        int layoutDirection = getLayoutDirection();
        if (drawable2 != null) {
            drawable2.setLayoutDirection(layoutDirection);
        }
        if (drawable3 != null) {
            drawable3.setLayoutDirection(layoutDirection);
        }
        resolvePadding();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void internalSetPadding(int i, int i2, int i3, int i4) {
        this.mUserPaddingLeft = i;
        this.mUserPaddingRight = i3;
        this.mUserPaddingBottom = i4;
        int i5 = this.mViewFlags;
        int i6 = i;
        int i7 = i3;
        int i8 = i4;
        if ((i5 & 768) != 0) {
            int i9 = i;
            int i10 = i3;
            if ((i5 & 512) != 0) {
                int verticalScrollbarWidth = (i5 & 16777216) == 0 ? 0 : getVerticalScrollbarWidth();
                switch (this.mVerticalScrollbarPosition) {
                    case 0:
                        if (!isLayoutRtl()) {
                            i10 = i3 + verticalScrollbarWidth;
                            i9 = i;
                            break;
                        } else {
                            i9 = i + verticalScrollbarWidth;
                            i10 = i3;
                            break;
                        }
                    case 1:
                        i9 = i + verticalScrollbarWidth;
                        i10 = i3;
                        break;
                    case 2:
                        i10 = i3 + verticalScrollbarWidth;
                        i9 = i;
                        break;
                    default:
                        i10 = i3;
                        i9 = i;
                        break;
                }
            }
            i6 = i9;
            i7 = i10;
            i8 = i4;
            if ((i5 & 256) != 0) {
                i8 = i4 + ((i5 & 16777216) == 0 ? 0 : getHorizontalScrollbarHeight());
                i7 = i10;
                i6 = i9;
            }
        }
        boolean z = false;
        if (this.mPaddingLeft != i6) {
            z = true;
            this.mPaddingLeft = i6;
        }
        if (this.mPaddingTop != i2) {
            z = true;
            this.mPaddingTop = i2;
        }
        if (this.mPaddingRight != i7) {
            z = true;
            this.mPaddingRight = i7;
        }
        if (this.mPaddingBottom != i8) {
            z = true;
            this.mPaddingBottom = i8;
        }
        if (z) {
            requestLayout();
            invalidateOutline();
        }
    }

    public void invalidate() {
        invalidate(true);
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        int i5 = this.mScrollX;
        int i6 = this.mScrollY;
        invalidateInternal(i - i5, i2 - i6, i3 - i5, i4 - i6, true, false);
    }

    public void invalidate(Rect rect) {
        int i = this.mScrollX;
        int i2 = this.mScrollY;
        invalidateInternal(rect.left - i, rect.top - i2, rect.right - i, rect.bottom - i2, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate(boolean z) {
        invalidateInternal(0, 0, this.mRight - this.mLeft, this.mBottom - this.mTop, z, true);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect dirtyBounds = drawable.getDirtyBounds();
            int i = this.mScrollX;
            int i2 = this.mScrollY;
            invalidate(dirtyBounds.left + i, dirtyBounds.top + i2, dirtyBounds.right + i, dirtyBounds.bottom + i2);
            rebuildOutline();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateInheritedLayoutMode(int i) {
    }

    void invalidateInternal(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        View projectionReceiver;
        if (this.mGhostView != null) {
            this.mGhostView.invalidate(true);
        } else if (skipInvalidate()) {
        } else {
            if ((this.mPrivateFlags & 48) == 48 || ((z && (this.mPrivateFlags & 32768) == 32768) || (this.mPrivateFlags & Integer.MIN_VALUE) != Integer.MIN_VALUE || (z2 && isOpaque() != this.mLastIsOpaque))) {
                if (z2) {
                    this.mLastIsOpaque = isOpaque();
                    this.mPrivateFlags &= -33;
                }
                this.mPrivateFlags |= 2097152;
                if (z) {
                    this.mPrivateFlags |= Integer.MIN_VALUE;
                    this.mPrivateFlags &= -32769;
                }
                AttachInfo attachInfo = this.mAttachInfo;
                ViewParent viewParent = this.mParent;
                if (viewParent != null && attachInfo != null && i < i3 && i2 < i4) {
                    Rect rect = attachInfo.mTmpInvalRect;
                    rect.set(i, i2, i3, i4);
                    viewParent.invalidateChild(this, rect);
                }
                if (this.mBackground != null && this.mBackground.isProjected() && (projectionReceiver = getProjectionReceiver()) != null) {
                    projectionReceiver.damageInParent();
                }
                if (!isHardwareAccelerated() || getZ() == 0.0f) {
                    return;
                }
                damageShadowReceiver();
            }
        }
    }

    public void invalidateOutline() {
        rebuildOutline();
        notifySubtreeAccessibilityStateChangedIfNeeded();
        invalidateViewProperty(false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidateParentCaches() {
        if (this.mParent instanceof View) {
            ((View) this.mParent).mPrivateFlags |= Integer.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (this.mParent instanceof View)) {
            ((View) this.mParent).invalidate(true);
        }
    }

    protected void invalidateParentIfNeededAndWasQuickRejected() {
        if ((this.mPrivateFlags2 & 268435456) != 0) {
            invalidateParentIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateViewProperty(boolean z, boolean z2) {
        if (isHardwareAccelerated() && this.mRenderNode.isValid() && (this.mPrivateFlags & 64) == 0) {
            damageInParent();
        } else {
            if (z) {
                invalidateParentCaches();
            }
            if (z2) {
                this.mPrivateFlags |= 32;
            }
            invalidate(false);
        }
        if (isHardwareAccelerated() && z && getZ() != 0.0f) {
            damageShadowReceiver();
        }
    }

    public boolean isAccessibilityFocused() {
        return (this.mPrivateFlags2 & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAccessibilityFocusedViewOrHost() {
        if (isAccessibilityFocused()) {
            return true;
        }
        return getViewRootImpl() != null && getViewRootImpl().getAccessibilityFocusedHost() == this;
    }

    public boolean isAccessibilitySelectionExtendable() {
        return false;
    }

    public boolean isActionableForAccessibility() {
        return isClickable() || isLongClickable() || isFocusable();
    }

    @ViewDebug.ExportedProperty
    public boolean isActivated() {
        return (this.mPrivateFlags & 1073741824) != 0;
    }

    public boolean isAttachedToWindow() {
        return this.mAttachInfo != null;
    }

    @ViewDebug.ExportedProperty
    public boolean isClickable() {
        return (this.mViewFlags & 16384) == 16384;
    }

    public boolean isDirty() {
        return (this.mPrivateFlags & PFLAG_DIRTY_MASK) != 0;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        return (this.mViewFlags & 32768) == 32768;
    }

    public boolean isDuplicateParentStateEnabled() {
        return (this.mViewFlags & 4194304) == 4194304;
    }

    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        return (this.mViewFlags & 32) == 0;
    }

    @ViewDebug.ExportedProperty(category = "focus")
    public final boolean isFocusable() {
        return 1 == (this.mViewFlags & 1);
    }

    @ViewDebug.ExportedProperty
    public final boolean isFocusableInTouchMode() {
        return 262144 == (this.mViewFlags & 262144);
    }

    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        return (this.mPrivateFlags & 2) != 0;
    }

    @ViewDebug.ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        return 268435456 == (this.mViewFlags & 268435456);
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isHardwareAccelerated() {
        return this.mAttachInfo != null && this.mAttachInfo.mHardwareAccelerated;
    }

    public boolean isHorizontalFadingEdgeEnabled() {
        return (this.mViewFlags & 4096) == 4096;
    }

    public boolean isHorizontalScrollBarEnabled() {
        return (this.mViewFlags & 256) == 256;
    }

    @ViewDebug.ExportedProperty
    public boolean isHovered() {
        return (this.mPrivateFlags & 268435456) != 0;
    }

    public boolean isImportantForAccessibility() {
        int i = (this.mPrivateFlags2 & PFLAG2_IMPORTANT_FOR_ACCESSIBILITY_MASK) >> 20;
        if (i == 2 || i == 4) {
            return false;
        }
        ViewParent viewParent = this.mParent;
        while (true) {
            ViewParent viewParent2 = viewParent;
            if (!(viewParent2 instanceof View)) {
                return i == 1 || isActionableForAccessibility() || hasListenersForAccessibility() || getAccessibilityNodeProvider() != null || getAccessibilityLiveRegion() != 0;
            } else if (((View) viewParent2).getImportantForAccessibility() == 4) {
                return false;
            } else {
                viewParent = viewParent2.getParent();
            }
        }
    }

    public boolean isInEditMode() {
        return false;
    }

    public boolean isInLayout() {
        ViewRootImpl viewRootImpl = getViewRootImpl();
        return viewRootImpl != null && viewRootImpl.isInLayout();
    }

    public boolean isInScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            ViewParent viewParent = parent;
            if (viewParent == null || !(viewParent instanceof ViewGroup)) {
                return false;
            }
            if (((ViewGroup) viewParent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewParent.getParent();
        }
    }

    @ViewDebug.ExportedProperty
    public boolean isInTouchMode() {
        return this.mAttachInfo != null ? this.mAttachInfo.mInTouchMode : ViewRootImpl.isInTouchMode();
    }

    public boolean isLaidOut() {
        return (this.mPrivateFlags3 & 4) == 4;
    }

    public boolean isLayoutDirectionInherited() {
        return getRawLayoutDirection() == 2;
    }

    public boolean isLayoutDirectionResolved() {
        return (this.mPrivateFlags2 & 32) == 32;
    }

    public boolean isLayoutRequested() {
        return (this.mPrivateFlags & 4096) == 4096;
    }

    @ViewDebug.ExportedProperty(category = "layout")
    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    public boolean isLongClickable() {
        return (this.mViewFlags & 2097152) == 2097152;
    }

    public boolean isNestedScrollingEnabled() {
        return (this.mPrivateFlags3 & 128) == 128;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        return (this.mPrivateFlags & 25165824) == 25165824 && getFinalAlpha() >= 1.0f;
    }

    protected boolean isPaddingOffsetRequired() {
        return false;
    }

    public boolean isPaddingRelative() {
        return (this.mUserPaddingStart == Integer.MIN_VALUE && this.mUserPaddingEnd == Integer.MIN_VALUE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPaddingResolved() {
        return (this.mPrivateFlags2 & 536870912) == 536870912;
    }

    @ViewDebug.ExportedProperty
    public boolean isPressed() {
        return (this.mPrivateFlags & 16384) == 16384;
    }

    public boolean isRootNamespace() {
        return (this.mPrivateFlags & 8) != 0;
    }

    public boolean isSaveEnabled() {
        return (this.mViewFlags & 65536) != 65536;
    }

    public boolean isSaveFromParentEnabled() {
        return (this.mViewFlags & 536870912) != 536870912;
    }

    public boolean isScrollContainer() {
        return (this.mPrivateFlags & 1048576) != 0;
    }

    public boolean isScrollbarFadingEnabled() {
        return this.mScrollCache != null && this.mScrollCache.fadeScrollBars;
    }

    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        return (this.mPrivateFlags & 4) != 0;
    }

    public boolean isShown() {
        ViewParent viewParent;
        View view = this;
        while ((view.mViewFlags & 12) == 0 && (viewParent = view.mParent) != null) {
            if (!(viewParent instanceof View)) {
                return true;
            }
            View view2 = (View) viewParent;
            view = view2;
            if (view2 == null) {
                return false;
            }
        }
        return false;
    }

    @ViewDebug.ExportedProperty
    public boolean isSoundEffectsEnabled() {
        return 134217728 == (this.mViewFlags & 134217728);
    }

    public boolean isTextAlignmentInherited() {
        return getRawTextAlignment() == 0;
    }

    public boolean isTextAlignmentResolved() {
        return (this.mPrivateFlags2 & 65536) == 65536;
    }

    public boolean isTextDirectionInherited() {
        return getRawTextDirection() == 0;
    }

    public boolean isTextDirectionResolved() {
        return (this.mPrivateFlags2 & 512) == 512;
    }

    public boolean isVerticalFadingEdgeEnabled() {
        return (this.mViewFlags & 8192) == 8192;
    }

    public boolean isVerticalScrollBarEnabled() {
        return (this.mViewFlags & 512) == 512;
    }

    protected boolean isVerticalScrollBarHidden() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVisibleToUser() {
        return isVisibleToUser(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVisibleToUser(Rect rect) {
        if (this.mAttachInfo == null || this.mAttachInfo.mWindowVisibility != 0) {
            return false;
        }
        Object obj = this;
        while (true) {
            Object obj2 = obj;
            if (!(obj2 instanceof View)) {
                Rect rect2 = this.mAttachInfo.mTmpInvalRect;
                Point point = this.mAttachInfo.mPoint;
                if (getGlobalVisibleRect(rect2, point)) {
                    if (rect != null) {
                        rect2.offset(-point.x, -point.y);
                        return rect.intersect(rect2);
                    }
                    return true;
                }
                return false;
            }
            View view = (View) obj2;
            if (view.getAlpha() <= 0.0f || view.getTransitionAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            obj = view.mParent;
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (this.mBackground != null) {
            this.mBackground.jumpToCurrentState();
        }
        if (this.mStateListAnimator != null) {
            this.mStateListAnimator.jumpToCurrentState();
        }
    }

    public void layout(int i, int i2, int i3, int i4) {
        if ((this.mPrivateFlags3 & 8) != 0) {
            onMeasure(this.mOldWidthMeasureSpec, this.mOldHeightMeasureSpec);
            this.mPrivateFlags3 &= -9;
        }
        int i5 = this.mLeft;
        int i6 = this.mTop;
        int i7 = this.mBottom;
        int i8 = this.mRight;
        boolean opticalFrame = isLayoutModeOptical(this.mParent) ? setOpticalFrame(i, i2, i3, i4) : setFrame(i, i2, i3, i4);
        if (opticalFrame || (this.mPrivateFlags & 8192) == 8192) {
            onLayout(opticalFrame, i, i2, i3, i4);
            this.mPrivateFlags &= -8193;
            ListenerInfo listenerInfo = this.mListenerInfo;
            if (listenerInfo != null && listenerInfo.mOnLayoutChangeListeners != null) {
                ArrayList arrayList = (ArrayList) listenerInfo.mOnLayoutChangeListeners.clone();
                int size = arrayList.size();
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= size) {
                        break;
                    }
                    ((OnLayoutChangeListener) arrayList.get(i10)).onLayoutChange(this, i, i2, i3, i4, i5, i6, i8, i7);
                    i9 = i10 + 1;
                }
            }
        }
        this.mPrivateFlags &= -4097;
        this.mPrivateFlags3 |= 4;
    }

    public void makeOptionalFitsSystemWindows() {
        setFlags(2048, 2048);
    }

    public final void measure(int i, int i2) {
        boolean isLayoutModeOptical = isLayoutModeOptical(this);
        int i3 = i;
        int i4 = i2;
        if (isLayoutModeOptical != isLayoutModeOptical(this.mParent)) {
            Insets opticalInsets = getOpticalInsets();
            int i5 = opticalInsets.left + opticalInsets.right;
            int i6 = opticalInsets.top + opticalInsets.bottom;
            int i7 = i5;
            if (isLayoutModeOptical) {
                i7 = -i5;
            }
            int adjust = MeasureSpec.adjust(i, i7);
            int i8 = i6;
            if (isLayoutModeOptical) {
                i8 = -i6;
            }
            i4 = MeasureSpec.adjust(i2, i8);
            i3 = adjust;
        }
        long j = (i3 << 32) | (i4 & ExpandableListView.PACKED_POSITION_VALUE_NULL);
        if (this.mMeasureCache == null) {
            this.mMeasureCache = new LongSparseLongArray(2);
        }
        boolean z = (this.mPrivateFlags & 4096) == 4096;
        boolean z2 = (MeasureSpec.getMode(i3) == 1073741824 && MeasureSpec.getMode(i4) == 1073741824) && getMeasuredWidth() == MeasureSpec.getSize(i3) && getMeasuredHeight() == MeasureSpec.getSize(i4);
        if (z || (!z2 && (i3 != this.mOldWidthMeasureSpec || i4 != this.mOldHeightMeasureSpec))) {
            this.mPrivateFlags &= -2049;
            resolveRtlPropertiesIfNeeded();
            int indexOfKey = z ? -1 : this.mMeasureCache.indexOfKey(j);
            if (indexOfKey < 0 || sIgnoreMeasureCache) {
                onMeasure(i3, i4);
                this.mPrivateFlags3 &= -9;
            } else {
                long valueAt = this.mMeasureCache.valueAt(indexOfKey);
                setMeasuredDimensionRaw((int) (valueAt >> 32), (int) valueAt);
                this.mPrivateFlags3 |= 8;
            }
            if ((this.mPrivateFlags & 2048) != 2048) {
                throw new IllegalStateException("onMeasure() did not set the measured dimension by calling setMeasuredDimension()");
            }
            this.mPrivateFlags |= 8192;
        }
        this.mOldWidthMeasureSpec = i3;
        this.mOldHeightMeasureSpec = i4;
        this.mMeasureCache.put(j, (this.mMeasuredWidth << 32) | (this.mMeasuredHeight & ExpandableListView.PACKED_POSITION_VALUE_NULL));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void needGlobalAttributesUpdate(boolean z) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo == null || attachInfo.mRecomputeGlobalAttributes) {
            return;
        }
        if (z || attachInfo.mKeepScreenOn || attachInfo.mSystemUiVisibility != 0 || attachInfo.mHasSystemUiListeners) {
            attachInfo.mRecomputeGlobalAttributes = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyGlobalFocusCleared(View view) {
        if (view == null || this.mAttachInfo == null) {
            return;
        }
        this.mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(view, null);
    }

    public void notifySubtreeAccessibilityStateChangedIfNeeded() {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled() && (this.mPrivateFlags2 & 134217728) == 0) {
            this.mPrivateFlags2 |= 134217728;
            if (this.mParent != null) {
                try {
                    this.mParent.notifySubtreeAccessibilityStateChanged(this, this, 1);
                } catch (AbstractMethodError e) {
                    Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public void notifyViewAccessibilityStateChangedIfNeeded(int i) {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            if (this.mSendViewStateChangedAccessibilityEvent == null) {
                this.mSendViewStateChangedAccessibilityEvent = new SendViewStateChangedAccessibilityEvent();
            }
            this.mSendViewStateChangedAccessibilityEvent.runOrPost(i);
        }
    }

    public void offsetLeftAndRight(int i) {
        int i2;
        int i3;
        if (i != 0) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidateViewProperty(false, false);
            } else if (isHardwareAccelerated()) {
                invalidateViewProperty(false, false);
            } else {
                ViewParent viewParent = this.mParent;
                if (viewParent != null && this.mAttachInfo != null) {
                    Rect rect = this.mAttachInfo.mTmpInvalRect;
                    if (i < 0) {
                        i2 = this.mLeft + i;
                        i3 = this.mRight;
                    } else {
                        i2 = this.mLeft;
                        i3 = this.mRight + i;
                    }
                    rect.set(0, 0, i3 - i2, this.mBottom - this.mTop);
                    viewParent.invalidateChild(this, rect);
                }
            }
            this.mLeft += i;
            this.mRight += i;
            this.mRenderNode.offsetLeftAndRight(i);
            if (isHardwareAccelerated()) {
                invalidateViewProperty(false, false);
            } else {
                if (!hasIdentityMatrix) {
                    invalidateViewProperty(false, true);
                }
                invalidateParentIfNeeded();
            }
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void offsetTopAndBottom(int i) {
        int i2;
        int i3;
        int i4;
        if (i != 0) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidateViewProperty(false, false);
            } else if (isHardwareAccelerated()) {
                invalidateViewProperty(false, false);
            } else {
                ViewParent viewParent = this.mParent;
                if (viewParent != null && this.mAttachInfo != null) {
                    Rect rect = this.mAttachInfo.mTmpInvalRect;
                    if (i < 0) {
                        i2 = this.mTop + i;
                        i3 = this.mBottom;
                        i4 = i;
                    } else {
                        i2 = this.mTop;
                        i3 = this.mBottom + i;
                        i4 = 0;
                    }
                    rect.set(0, i4, this.mRight - this.mLeft, i3 - i2);
                    viewParent.invalidateChild(this, rect);
                }
            }
            this.mTop += i;
            this.mBottom += i;
            this.mRenderNode.offsetTopAndBottom(i);
            if (isHardwareAccelerated()) {
                invalidateViewProperty(false, false);
            } else {
                if (!hasIdentityMatrix) {
                    invalidateViewProperty(false, true);
                }
                invalidateParentIfNeeded();
            }
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAnimationEnd() {
        this.mPrivateFlags &= -65537;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAnimationStart() {
        this.mPrivateFlags |= 65536;
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsets2;
        if ((this.mPrivateFlags3 & 64) == 0) {
            windowInsets2 = windowInsets;
            if (fitSystemWindows(windowInsets.getSystemWindowInsets())) {
                windowInsets2 = windowInsets.consumeSystemWindowInsets();
            }
        } else {
            windowInsets2 = windowInsets;
            if (fitSystemWindowsInt(windowInsets.getSystemWindowInsets())) {
                return windowInsets.consumeSystemWindowInsets();
            }
        }
        return windowInsets2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if ((this.mPrivateFlags & 512) != 0) {
            this.mParent.requestTransparentRegion(this);
        }
        if ((this.mPrivateFlags & 134217728) != 0) {
            initialAwakenScrollBars();
            this.mPrivateFlags &= -134217729;
        }
        this.mPrivateFlags3 &= -5;
        jumpDrawablesToCurrentState();
        resetSubtreeAccessibilityStateChanged();
        rebuildOutline();
        if (isFocused()) {
            InputMethodManager.peekInstance().focusIn(this);
        }
    }

    public void onCancelPendingInputEvents() {
        removePerformClickCallback();
        cancelLongPress();
        this.mPrivateFlags3 |= 16;
    }

    public boolean onCheckIsTextEditor() {
        return false;
    }

    public void onCloseSystemDialogs(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
    }

    protected void onCreateContextMenu(ContextMenu contextMenu) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71 */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public int[] onCreateDrawableState(int i) {
        int[] iArr;
        int[] iArr2;
        if ((this.mViewFlags & 4194304) == 4194304 && (this.mParent instanceof View)) {
            iArr = ((View) this.mParent).onCreateDrawableState(i);
        } else {
            int i2 = this.mPrivateFlags;
            ?? r9 = false;
            if ((i2 & 16384) != 0) {
                r9 = false | true;
            }
            ?? r8 = r9;
            if ((this.mViewFlags & 32) == 0) {
                r8 = r9 | true;
            }
            ?? r92 = r8;
            if (isFocused()) {
                r92 = r8 | true;
            }
            ?? r82 = r92;
            if ((i2 & 4) != 0) {
                r82 = r92 | true;
            }
            ?? r93 = r82;
            if (hasWindowFocus()) {
                r93 = r82 | true;
            }
            ?? r83 = r93;
            if ((1073741824 & i2) != 0) {
                r83 = r93 | true;
            }
            ?? r94 = r83;
            if (this.mAttachInfo != null) {
                r94 = r83;
                if (this.mAttachInfo.mHardwareAccelerationRequested) {
                    r94 = r83;
                    if (HardwareRenderer.isAvailable()) {
                        r94 = r83 | true;
                    }
                }
            }
            ?? r84 = r94;
            if ((268435456 & i2) != 0) {
                r84 = r94 | true;
            }
            int i3 = this.mPrivateFlags2;
            ?? r95 = r84;
            if ((i3 & 1) != 0) {
                r95 = r84 | true;
            }
            ?? r85 = r95;
            if ((i3 & 2) != 0) {
                r85 = r95 | true;
            }
            int[] iArr3 = VIEW_STATE_SETS[r85 == true ? 1 : 0];
            iArr = iArr3;
            if (i != 0) {
                if (iArr3 != null) {
                    iArr2 = new int[iArr3.length + i];
                    System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
                } else {
                    iArr2 = new int[i];
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindowInternal() {
        this.mPrivateFlags &= -67108865;
        this.mPrivateFlags3 &= -5;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        stopNestedScroll();
        jumpDrawablesToCurrentState();
        destroyDrawingCache();
        cleanupDraw();
        this.mCurrentAnimation = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDisplayHint(int i) {
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setBounds(i, i2, i3, i4);
        drawable.draw(canvas);
    }

    protected final void onDrawScrollBars(Canvas canvas) {
        int i;
        int i2;
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        if (scrollabilityCache == null || (i = scrollabilityCache.state) == 0) {
            return;
        }
        boolean z = false;
        if (i == 2) {
            if (scrollabilityCache.interpolatorValues == null) {
                scrollabilityCache.interpolatorValues = new float[1];
            }
            float[] fArr = scrollabilityCache.interpolatorValues;
            if (scrollabilityCache.scrollBarInterpolator.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                scrollabilityCache.state = 0;
            } else {
                scrollabilityCache.scrollBar.mutate().setAlpha(Math.round(fArr[0]));
            }
            z = true;
        } else {
            scrollabilityCache.scrollBar.mutate().setAlpha(255);
        }
        int i3 = this.mViewFlags;
        boolean z2 = (i3 & 256) == 256;
        boolean z3 = (i3 & 512) == 512 && !isVerticalScrollBarHidden();
        if (z3 || z2) {
            int i4 = this.mRight - this.mLeft;
            int i5 = this.mBottom - this.mTop;
            ScrollBarDrawable scrollBarDrawable = scrollabilityCache.scrollBar;
            int i6 = this.mScrollX;
            int i7 = this.mScrollY;
            int i8 = (33554432 & i3) == 0 ? -1 : 0;
            if (z2) {
                int size = scrollBarDrawable.getSize(false);
                int i9 = size;
                if (size <= 0) {
                    i9 = scrollabilityCache.scrollBarSize;
                }
                scrollBarDrawable.setParameters(computeHorizontalScrollRange(), computeHorizontalScrollOffset(), computeHorizontalScrollExtent(), false);
                int verticalScrollbarWidth = z3 ? getVerticalScrollbarWidth() : 0;
                int i10 = ((i7 + i5) - i9) - (this.mUserPaddingBottom & i8);
                int i11 = i6 + (this.mPaddingLeft & i8);
                int i12 = ((i6 + i4) - (this.mUserPaddingRight & i8)) - verticalScrollbarWidth;
                int i13 = i10 + i9;
                onDrawHorizontalScrollBar(canvas, scrollBarDrawable, i11, i10, i12, i13);
                if (z) {
                    invalidate(i11, i10, i12, i13);
                }
            }
            if (z3) {
                int size2 = scrollBarDrawable.getSize(true);
                int i14 = size2;
                if (size2 <= 0) {
                    i14 = scrollabilityCache.scrollBarSize;
                }
                scrollBarDrawable.setParameters(computeVerticalScrollRange(), computeVerticalScrollOffset(), computeVerticalScrollExtent(), true);
                int i15 = this.mVerticalScrollbarPosition;
                int i16 = i15;
                if (i15 == 0) {
                    i16 = isLayoutRtl() ? 1 : 2;
                }
                switch (i16) {
                    case 1:
                        i2 = i6 + (this.mUserPaddingLeft & i8);
                        break;
                    default:
                        i2 = ((i6 + i4) - i14) - (this.mUserPaddingRight & i8);
                        break;
                }
                int i17 = i7 + (this.mPaddingTop & i8);
                int i18 = i2 + i14;
                int i19 = (i7 + i5) - (this.mUserPaddingBottom & i8);
                onDrawVerticalScrollBar(canvas, scrollBarDrawable, i2, i17, i18, i19);
                if (z) {
                    invalidate(i2, i17, i18, i19);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setBounds(i, i2, i3, i4);
        drawable.draw(canvas);
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        return (this.mViewFlags & 1024) == 0 || (motionEvent.getFlags() & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFinishInflate() {
    }

    public void onFinishTemporaryDetach() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            sendAccessibilityEvent(8);
        } else {
            notifyViewAccessibilityStateChangedIfNeeded(0);
        }
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (!z) {
            if (isPressed()) {
                setPressed(false);
            }
            if (peekInstance != null && this.mAttachInfo != null && this.mAttachInfo.mHasWindowFocus) {
                peekInstance.focusOut(this);
            }
            onFocusLost();
        } else if (peekInstance != null && this.mAttachInfo != null && this.mAttachInfo.mHasWindowFocus) {
            peekInstance.focusIn(this);
        }
        invalidate(true);
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo != null && listenerInfo.mOnFocusChangeListener != null) {
            listenerInfo.mOnFocusChangeListener.onFocusChange(this, z);
        }
        if (this.mAttachInfo != null) {
            this.mAttachInfo.mKeyDispatchState.reset(this);
        }
    }

    protected void onFocusLost() {
        resetPressedState();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mSendingHoverAccessibilityEvents) {
            if (actionMasked == 10 || (actionMasked == 2 && !pointInView(motionEvent.getX(), motionEvent.getY()))) {
                this.mSendingHoverAccessibilityEvents = false;
                sendAccessibilityHoverEvent(256);
            }
        } else if ((actionMasked == 9 || actionMasked == 7) && !hasHoveredChild() && pointInView(motionEvent.getX(), motionEvent.getY())) {
            sendAccessibilityHoverEvent(128);
            this.mSendingHoverAccessibilityEvents = true;
        }
        if (isHoverable()) {
            switch (actionMasked) {
                case 9:
                    setHovered(true);
                    break;
                case 10:
                    setHovered(false);
                    break;
            }
            dispatchGenericMotionEventInternal(motionEvent);
            return true;
        }
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.mAccessibilityDelegate != null) {
            this.mAccessibilityDelegate.onInitializeAccessibilityEvent(this, accessibilityEvent);
        } else {
            onInitializeAccessibilityEventInternal(accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInitializeAccessibilityEventInternal(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(View.class.getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setEnabled(isEnabled());
        accessibilityEvent.setContentDescription(this.mContentDescription);
        switch (accessibilityEvent.getEventType()) {
            case 8:
                ArrayList<View> arrayList = this.mAttachInfo != null ? this.mAttachInfo.mTempArrayList : new ArrayList<>();
                getRootView().addFocusables(arrayList, 2, 0);
                accessibilityEvent.setItemCount(arrayList.size());
                accessibilityEvent.setCurrentItemIndex(arrayList.indexOf(this));
                if (this.mAttachInfo != null) {
                    arrayList.clear();
                    return;
                }
                return;
            case 8192:
                CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
                if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() <= 0) {
                    return;
                }
                accessibilityEvent.setFromIndex(getAccessibilitySelectionStart());
                accessibilityEvent.setToIndex(getAccessibilitySelectionEnd());
                accessibilityEvent.setItemCount(iterableTextForAccessibility.length());
                return;
            default:
                return;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (this.mAccessibilityDelegate != null) {
            this.mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, accessibilityNodeInfo);
        } else {
            onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = this.mAttachInfo.mTmpInvalRect;
        getDrawingRect(rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
        getBoundsOnScreen(rect, true);
        accessibilityNodeInfo.setBoundsInScreen(rect);
        ViewParent parentForAccessibility = getParentForAccessibility();
        if (parentForAccessibility instanceof View) {
            accessibilityNodeInfo.setParent((View) parentForAccessibility);
        }
        if (this.mID != -1) {
            View rootView = getRootView();
            View view = rootView;
            if (rootView == null) {
                view = this;
            }
            View findLabelForView = view.findLabelForView(this, this.mID);
            if (findLabelForView != null) {
                accessibilityNodeInfo.setLabeledBy(findLabelForView);
            }
            if ((this.mAttachInfo.mAccessibilityFetchFlags & 16) != 0 && Resources.resourceHasPackage(this.mID)) {
                try {
                    accessibilityNodeInfo.setViewIdResourceName(getResources().getResourceName(this.mID));
                } catch (Resources.NotFoundException e) {
                }
            }
        }
        if (this.mLabelForId != -1) {
            View rootView2 = getRootView();
            View view2 = rootView2;
            if (rootView2 == null) {
                view2 = this;
            }
            View findViewInsideOutShouldExist = view2.findViewInsideOutShouldExist(this, this.mLabelForId);
            if (findViewInsideOutShouldExist != null) {
                accessibilityNodeInfo.setLabelFor(findViewInsideOutShouldExist);
            }
        }
        if (this.mAccessibilityTraversalBeforeId != -1) {
            View rootView3 = getRootView();
            View view3 = rootView3;
            if (rootView3 == null) {
                view3 = this;
            }
            View findViewInsideOutShouldExist2 = view3.findViewInsideOutShouldExist(this, this.mAccessibilityTraversalBeforeId);
            if (findViewInsideOutShouldExist2 != null) {
                accessibilityNodeInfo.setTraversalBefore(findViewInsideOutShouldExist2);
            }
        }
        if (this.mAccessibilityTraversalAfterId != -1) {
            View rootView4 = getRootView();
            View view4 = rootView4;
            if (rootView4 == null) {
                view4 = this;
            }
            View findViewInsideOutShouldExist3 = view4.findViewInsideOutShouldExist(this, this.mAccessibilityTraversalAfterId);
            if (findViewInsideOutShouldExist3 != null) {
                accessibilityNodeInfo.setTraversalAfter(findViewInsideOutShouldExist3);
            }
        }
        accessibilityNodeInfo.setVisibleToUser(isVisibleToUser());
        accessibilityNodeInfo.setPackageName(this.mContext.getPackageName());
        accessibilityNodeInfo.setClassName(View.class.getName());
        accessibilityNodeInfo.setContentDescription(getContentDescription());
        accessibilityNodeInfo.setEnabled(isEnabled());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setFocusable(isFocusable());
        accessibilityNodeInfo.setFocused(isFocused());
        accessibilityNodeInfo.setAccessibilityFocused(isAccessibilityFocused());
        accessibilityNodeInfo.setSelected(isSelected());
        accessibilityNodeInfo.setLongClickable(isLongClickable());
        accessibilityNodeInfo.setLiveRegion(getAccessibilityLiveRegion());
        accessibilityNodeInfo.addAction(4);
        accessibilityNodeInfo.addAction(8);
        if (isFocusable()) {
            if (isFocused()) {
                accessibilityNodeInfo.addAction(2);
            } else {
                accessibilityNodeInfo.addAction(1);
            }
        }
        if (isAccessibilityFocused()) {
            accessibilityNodeInfo.addAction(128);
        } else {
            accessibilityNodeInfo.addAction(64);
        }
        if (isClickable() && isEnabled()) {
            accessibilityNodeInfo.addAction(16);
        }
        if (isLongClickable() && isEnabled()) {
            accessibilityNodeInfo.addAction(32);
        }
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility();
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() <= 0) {
            return;
        }
        accessibilityNodeInfo.setTextSelection(getAccessibilitySelectionStart(), getAccessibilitySelectionEnd());
        accessibilityNodeInfo.addAction(131072);
        accessibilityNodeInfo.addAction(256);
        accessibilityNodeInfo.addAction(512);
        accessibilityNodeInfo.setMovementGranularities(11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        if ((r3.mViewFlags & 2097152) == 2097152) goto L10;
     */
    @Override // android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r4
            boolean r0 = android.view.KeyEvent.isConfirmKey(r0)
            if (r0 == 0) goto L1b
            r0 = r3
            int r0 = r0.mViewFlags
            r1 = 32
            r0 = r0 & r1
            r1 = 32
            if (r0 != r1) goto L1d
            r0 = 1
            r6 = r0
        L1b:
            r0 = r6
            return r0
        L1d:
            r0 = r3
            int r0 = r0.mViewFlags
            r1 = 16384(0x4000, float:2.2959E-41)
            r0 = r0 & r1
            r1 = 16384(0x4000, float:2.2959E-41)
            if (r0 == r1) goto L3a
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.mViewFlags
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r1
            r1 = 2097152(0x200000, float:2.938736E-39)
            if (r0 != r1) goto L1b
        L3a:
            r0 = r7
            r6 = r0
            r0 = r5
            int r0 = r0.getRepeatCount()
            if (r0 != 0) goto L1b
            r0 = r3
            r1 = 1
            r0.setPressed(r1)
            r0 = r3
            r1 = 0
            r0.checkForLongClick(r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.View.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (KeyEvent.isConfirmKey(i)) {
            if ((this.mViewFlags & 32) == 32) {
                z = true;
            } else {
                z = false;
                if ((this.mViewFlags & 16384) == 16384) {
                    z = false;
                    if (isPressed()) {
                        setPressed(false);
                        z = false;
                        if (!this.mHasPerformedLongPress) {
                            removeLongPressCallback();
                            return performClick();
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.mAccessibilityDelegate != null) {
            this.mAccessibilityDelegate.onPopulateAccessibilityEvent(this, accessibilityEvent);
        } else {
            onPopulateAccessibilityEventInternal(accessibilityEvent);
        }
    }

    void onPopulateAccessibilityEventInternal(AccessibilityEvent accessibilityEvent) {
    }

    public void onResolveDrawables(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mPrivateFlags |= 131072;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class, expecting View State but received " + parcelable.getClass().toString() + " instead. This usually happens when two views of different type have the same id in the same hierarchy. This view's id is " + ViewDebug.resolveId(this.mContext, getId()) + ". Make sure other views do not use the same id.");
        }
    }

    public void onRtlPropertiesChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        this.mPrivateFlags |= 131072;
        return BaseSavedState.EMPTY_STATE;
    }

    public void onScreenStateChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            postSendViewScrolledAccessibilityEventCallback();
        }
        this.mBackgroundSizeChanged = true;
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.mViewScrollChanged = true;
        }
        if (this.mListenerInfo == null || this.mListenerInfo.mOnScrollChangeListener == null) {
            return;
        }
        this.mListenerInfo.mOnScrollChangeListener.onScrollChange(this, i, i2, i3, i4);
    }

    protected boolean onSetAlpha(int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void onStartTemporaryDetach() {
        removeUnsetPressCallback();
        this.mPrivateFlags |= 67108864;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.mViewFlags;
        if ((i & 32) == 32) {
            if (motionEvent.getAction() == 1 && (this.mPrivateFlags & 16384) != 0) {
                setPressed(false);
            }
            if ((i & 16384) == 16384 || (i & 2097152) == 2097152) {
                z = true;
            }
        } else if (this.mTouchDelegate != null && this.mTouchDelegate.onTouchEvent(motionEvent)) {
            return true;
        } else {
            if ((i & 16384) == 16384 || (i & 2097152) == 2097152) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.mHasPerformedLongPress = false;
                        if (performButtonActionOnTouchDown(motionEvent)) {
                            return true;
                        }
                        if (!isInScrollingContainer()) {
                            setPressed(true, x, y);
                            checkForLongClick(0);
                            return true;
                        }
                        this.mPrivateFlags |= 33554432;
                        if (this.mPendingCheckForTap == null) {
                            this.mPendingCheckForTap = new CheckForTap();
                        }
                        this.mPendingCheckForTap.x = motionEvent.getX();
                        this.mPendingCheckForTap.y = motionEvent.getY();
                        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        return true;
                    case 1:
                        boolean z2 = (this.mPrivateFlags & 33554432) != 0;
                        if ((this.mPrivateFlags & 16384) != 0 || z2) {
                            boolean z3 = false;
                            if (isFocusable()) {
                                z3 = false;
                                if (isFocusableInTouchMode()) {
                                    z3 = false;
                                    if (!isFocused()) {
                                        z3 = requestFocus();
                                    }
                                }
                            }
                            if (z2) {
                                setPressed(true, x, y);
                            }
                            if (!this.mHasPerformedLongPress) {
                                removeLongPressCallback();
                                if (!z3) {
                                    if (this.mPerformClick == null) {
                                        this.mPerformClick = new PerformClick();
                                    }
                                    if (!post(this.mPerformClick)) {
                                        performClick();
                                    }
                                }
                            }
                            if (this.mUnsetPressedState == null) {
                                this.mUnsetPressedState = new UnsetPressedState();
                            }
                            if (z2) {
                                postDelayed(this.mUnsetPressedState, ViewConfiguration.getPressedStateDuration());
                            } else if (!post(this.mUnsetPressedState)) {
                                this.mUnsetPressedState.run();
                            }
                            removeTapCallback();
                            return true;
                        }
                        return true;
                    case 2:
                        drawableHotspotChanged(x, y);
                        if (pointInView(x, y, this.mTouchSlop)) {
                            return true;
                        }
                        removeTapCallback();
                        if ((this.mPrivateFlags & 16384) != 0) {
                            removeLongPressCallback();
                            setPressed(false);
                            return true;
                        }
                        return true;
                    case 3:
                        setPressed(false);
                        removeTapCallback();
                        removeLongPressCallback();
                        return true;
                    default:
                        return true;
                }
            }
        }
        return z;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        if (i == 0) {
            if (this.mAttachInfo != null) {
                initialAwakenScrollBars();
            } else {
                this.mPrivateFlags |= 134217728;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        InputMethodManager peekInstance = InputMethodManager.peekInstance();
        if (!z) {
            if (isPressed()) {
                setPressed(false);
            }
            if (peekInstance != null && (this.mPrivateFlags & 2) != 0) {
                peekInstance.focusOut(this);
            }
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } else if (peekInstance != null && (this.mPrivateFlags & 2) != 0) {
            peekInstance.focusIn(this);
        }
        refreshDrawableState();
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (i == 0) {
            initialAwakenScrollBars();
        }
    }

    public void outputDirtyFlags(String str, boolean z, int i) {
        Log.d(VIEW_LOG_TAG, str + this + "             DIRTY(" + (this.mPrivateFlags & PFLAG_DIRTY_MASK) + ") DRAWN(" + (this.mPrivateFlags & 32) + ") CACHE_VALID(" + (this.mPrivateFlags & 32768) + ") INVALIDATED(" + (this.mPrivateFlags & Integer.MIN_VALUE) + ")");
        if (z) {
            this.mPrivateFlags &= i;
        }
        if (!(this instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this;
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            viewGroup.getChildAt(i3).outputDirtyFlags(str + "  ", z, i);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9;
        int i10 = this.mOverScrollMode;
        boolean z2 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z3 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z4 = i10 == 0 || (i10 == 1 && z2);
        boolean z5 = i10 == 0 || (i10 == 1 && z3);
        int i11 = i3 + i;
        if (!z4) {
            i7 = 0;
        }
        int i12 = i4 + i2;
        if (!z5) {
            i8 = 0;
        }
        int i13 = -i7;
        int i14 = i7 + i5;
        int i15 = -i8;
        int i16 = i8 + i6;
        boolean z6 = false;
        if (i11 > i14) {
            z6 = true;
        } else {
            i14 = i11;
            if (i11 < i13) {
                i14 = i13;
                z6 = true;
            }
        }
        boolean z7 = false;
        if (i12 > i16) {
            i9 = i16;
            z7 = true;
        } else {
            i9 = i12;
            if (i12 < i15) {
                i9 = i15;
                z7 = true;
            }
        }
        onOverScrolled(i14, i9, z6, z7);
        return z6 || z7;
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return this.mAccessibilityDelegate != null ? this.mAccessibilityDelegate.performAccessibilityAction(this, i, bundle) : performAccessibilityActionInternal(i, bundle);
    }

    public boolean performAccessibilityActionInternal(int i, Bundle bundle) {
        int i2 = -1;
        if (isNestedScrollingEnabled() && ((i == 8192 || i == 4096) && dispatchNestedPrePerformAccessibilityAction(i, bundle))) {
            return true;
        }
        switch (i) {
            case 1:
                if (hasFocus()) {
                    return false;
                }
                getViewRootImpl().ensureTouchMode(false);
                return requestFocus();
            case 2:
                if (hasFocus()) {
                    clearFocus();
                    return !isFocused();
                }
                return false;
            case 4:
                if (isSelected()) {
                    return false;
                }
                setSelected(true);
                return isSelected();
            case 8:
                if (isSelected()) {
                    setSelected(false);
                    return !isSelected();
                }
                return false;
            case 16:
                if (isClickable()) {
                    performClick();
                    return true;
                }
                return false;
            case 32:
                if (isLongClickable()) {
                    performLongClick();
                    return true;
                }
                return false;
            case 64:
                if (isAccessibilityFocused()) {
                    return false;
                }
                return requestAccessibilityFocus();
            case 128:
                if (isAccessibilityFocused()) {
                    clearAccessibilityFocus();
                    return true;
                }
                return false;
            case 256:
                if (bundle != null) {
                    return traverseAtGranularity(bundle.getInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT), true, bundle.getBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN));
                }
                return false;
            case 512:
                if (bundle != null) {
                    return traverseAtGranularity(bundle.getInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT), false, bundle.getBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN));
                }
                return false;
            case 131072:
                if (getIterableTextForAccessibility() == null) {
                    return false;
                }
                int i3 = bundle != null ? bundle.getInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1;
                if (bundle != null) {
                    i2 = bundle.getInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, -1);
                }
                if (!(getAccessibilitySelectionStart() == i3 && getAccessibilitySelectionEnd() == i2) && i3 == i2) {
                    setAccessibilitySelection(i3, i2);
                    notifyViewAccessibilityStateChangedIfNeeded(0);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        return (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    public boolean performClick() {
        boolean z;
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnClickListener == null) {
            z = false;
        } else {
            playSoundEffect(0);
            listenerInfo.mOnClickListener.onClick(this);
            z = true;
        }
        sendAccessibilityEvent(1);
        return z;
    }

    void performCollectViewAttributes(AttachInfo attachInfo, int i) {
        if ((i & 12) == 0) {
            if ((this.mViewFlags & 67108864) == 67108864) {
                attachInfo.mKeepScreenOn = true;
            }
            attachInfo.mSystemUiVisibility |= this.mSystemUiVisibility;
            ListenerInfo listenerInfo = this.mListenerInfo;
            if (listenerInfo == null || listenerInfo.mOnSystemUiVisibilityChangeListener == null) {
                return;
            }
            attachInfo.mHasSystemUiListeners = true;
        }
    }

    public boolean performHapticFeedback(int i) {
        return performHapticFeedback(i, 0);
    }

    public boolean performHapticFeedback(int i, int i2) {
        boolean z = false;
        if (this.mAttachInfo == null) {
            return false;
        }
        if ((i2 & 1) != 0 || isHapticFeedbackEnabled()) {
            AttachInfo.Callbacks callbacks = this.mAttachInfo.mRootCallbacks;
            if ((i2 & 2) != 0) {
                z = true;
            }
            return callbacks.performHapticFeedback(i, z);
        }
        return false;
    }

    public boolean performLongClick() {
        sendAccessibilityEvent(2);
        ListenerInfo listenerInfo = this.mListenerInfo;
        boolean z = false;
        if (listenerInfo != null) {
            z = false;
            if (listenerInfo.mOnLongClickListener != null) {
                z = listenerInfo.mOnLongClickListener.onLongClick(this);
            }
        }
        boolean z2 = z;
        if (!z) {
            z2 = showContextMenu();
        }
        if (z2) {
            performHapticFeedback(0);
        }
        return z2;
    }

    public void playSoundEffect(int i) {
        if (this.mAttachInfo == null || this.mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            return;
        }
        this.mAttachInfo.mRootCallbacks.playSoundEffect(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean pointInView(float f, float f2) {
        return f >= 0.0f && f < ((float) (this.mRight - this.mLeft)) && f2 >= 0.0f && f2 < ((float) (this.mBottom - this.mTop));
    }

    public boolean pointInView(float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (this.mRight - this.mLeft)) + f3 && f2 < ((float) (this.mBottom - this.mTop)) + f3;
    }

    public boolean post(Runnable runnable) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            return attachInfo.mHandler.post(runnable);
        }
        ViewRootImpl.getRunQueue().post(runnable);
        return true;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            return attachInfo.mHandler.postDelayed(runnable, j);
        }
        ViewRootImpl.getRunQueue().postDelayed(runnable, j);
        return true;
    }

    public void postInvalidate() {
        postInvalidateDelayed(0L);
    }

    public void postInvalidate(int i, int i2, int i3, int i4) {
        postInvalidateDelayed(0L, i, i2, i3, i4);
    }

    public void postInvalidateDelayed(long j) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.mViewRootImpl.dispatchInvalidateDelayed(this, j);
        }
    }

    public void postInvalidateDelayed(long j, int i, int i2, int i3, int i4) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            AttachInfo.InvalidateInfo obtain = AttachInfo.InvalidateInfo.obtain();
            obtain.target = this;
            obtain.left = i;
            obtain.top = i2;
            obtain.right = i3;
            obtain.bottom = i4;
            attachInfo.mViewRootImpl.dispatchInvalidateRectDelayed(obtain, j);
        }
    }

    public void postInvalidateOnAnimation() {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.mViewRootImpl.dispatchInvalidateOnAnimation(this);
        }
    }

    public void postInvalidateOnAnimation(int i, int i2, int i3, int i4) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            AttachInfo.InvalidateInfo obtain = AttachInfo.InvalidateInfo.obtain();
            obtain.target = this;
            obtain.left = i;
            obtain.top = i2;
            obtain.right = i3;
            obtain.bottom = i4;
            attachInfo.mViewRootImpl.dispatchInvalidateRectOnAnimation(obtain);
        }
    }

    public void postOnAnimation(Runnable runnable) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.mViewRootImpl.mChoreographer.postCallback(1, runnable, null);
        } else {
            ViewRootImpl.getRunQueue().post(runnable);
        }
    }

    public void postOnAnimationDelayed(Runnable runnable, long j) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo != null) {
            attachInfo.mViewRootImpl.mChoreographer.postCallbackDelayed(1, runnable, null, j);
        } else {
            ViewRootImpl.getRunQueue().postDelayed(runnable, j);
        }
    }

    protected void recomputePadding() {
        internalSetPadding(this.mUserPaddingLeft, this.mPaddingTop, this.mUserPaddingRight, this.mUserPaddingBottom);
    }

    public void refreshDrawableState() {
        this.mPrivateFlags |= 1024;
        drawableStateChanged();
        ViewParent viewParent = this.mParent;
        if (viewParent != null) {
            viewParent.childDrawableStateChanged(this);
        }
    }

    public boolean removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            AttachInfo attachInfo = this.mAttachInfo;
            if (attachInfo != null) {
                attachInfo.mHandler.removeCallbacks(runnable);
                attachInfo.mViewRootImpl.mChoreographer.removeCallbacks(1, runnable, null);
            }
            ViewRootImpl.getRunQueue().removeCallbacks(runnable);
            return true;
        }
        return true;
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnAttachStateChangeListeners == null) {
            return;
        }
        listenerInfo.mOnAttachStateChangeListeners.remove(onAttachStateChangeListener);
    }

    public void removeOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
        ListenerInfo listenerInfo = this.mListenerInfo;
        if (listenerInfo == null || listenerInfo.mOnLayoutChangeListeners == null) {
            return;
        }
        listenerInfo.mOnLayoutChangeListeners.remove(onLayoutChangeListener);
    }

    public boolean requestAccessibilityFocus() {
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(this.mContext);
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (this.mViewFlags & 12) == 0 && (this.mPrivateFlags2 & 67108864) == 0) {
            this.mPrivateFlags2 |= 67108864;
            ViewRootImpl viewRootImpl = getViewRootImpl();
            if (viewRootImpl != null) {
                viewRootImpl.setAccessibilityFocus(this, null);
            }
            invalidate();
            sendAccessibilityEvent(32768);
            return true;
        }
        return false;
    }

    public void requestApplyInsets() {
        requestFitSystemWindows();
    }

    public void requestFitSystemWindows() {
        if (this.mParent != null) {
            this.mParent.requestFitSystemWindows();
        }
    }

    public final boolean requestFocus() {
        return requestFocus(130);
    }

    public final boolean requestFocus(int i) {
        return requestFocus(i, null);
    }

    public boolean requestFocus(int i, Rect rect) {
        return requestFocusNoSearch(i, rect);
    }

    public final boolean requestFocusFromTouch() {
        ViewRootImpl viewRootImpl;
        if (isInTouchMode() && (viewRootImpl = getViewRootImpl()) != null) {
            viewRootImpl.ensureTouchMode(false);
        }
        return requestFocus(130);
    }

    public void requestLayout() {
        if (this.mMeasureCache != null) {
            this.mMeasureCache.clear();
        }
        if (this.mAttachInfo != null && this.mAttachInfo.mViewRequestingLayout == null) {
            ViewRootImpl viewRootImpl = getViewRootImpl();
            if (viewRootImpl != null && viewRootImpl.isInLayout() && !viewRootImpl.requestLayoutDuringLayout(this)) {
                return;
            }
            this.mAttachInfo.mViewRequestingLayout = this;
        }
        this.mPrivateFlags |= 4096;
        this.mPrivateFlags |= Integer.MIN_VALUE;
        if (this.mParent != null && !this.mParent.isLayoutRequested()) {
            this.mParent.requestLayout();
        }
        if (this.mAttachInfo == null || this.mAttachInfo.mViewRequestingLayout != this) {
            return;
        }
        this.mAttachInfo.mViewRequestingLayout = null;
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        return requestRectangleOnScreen(rect, false);
    }

    public boolean requestRectangleOnScreen(Rect rect, boolean z) {
        boolean z2;
        if (this.mParent != null) {
            View view = this;
            RectF rectF = this.mAttachInfo != null ? this.mAttachInfo.mTmpTransformRect : new RectF();
            rectF.set(rect);
            ViewParent viewParent = this.mParent;
            boolean z3 = false;
            while (true) {
                z2 = z3;
                if (viewParent == null) {
                    break;
                }
                rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                z3 |= viewParent.requestChildRectangleOnScreen(view, rect, z);
                if (!view.hasIdentityMatrix()) {
                    view.getMatrix().mapRect(rectF);
                }
                rectF.offset(view.mLeft, view.mTop);
                z2 = z3;
                if (!(viewParent instanceof View)) {
                    break;
                }
                view = (View) viewParent;
                rectF.offset(-view.getScrollX(), -view.getScrollY());
                viewParent = view.getParent();
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    public final void requestUnbufferedDispatch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mAttachInfo != null) {
            if ((action == 0 || action == 2) && motionEvent.isTouchEvent()) {
                this.mAttachInfo.mUnbufferedDispatchRequested = true;
            }
        }
    }

    public void resetPaddingToInitialValues() {
        if (isRtlCompatibilityMode()) {
            this.mPaddingLeft = this.mUserPaddingLeftInitial;
            this.mPaddingRight = this.mUserPaddingRightInitial;
        } else if (isLayoutRtl()) {
            this.mPaddingLeft = this.mUserPaddingEnd >= 0 ? this.mUserPaddingEnd : this.mUserPaddingLeftInitial;
            this.mPaddingRight = this.mUserPaddingStart >= 0 ? this.mUserPaddingStart : this.mUserPaddingRightInitial;
        } else {
            this.mPaddingLeft = this.mUserPaddingStart >= 0 ? this.mUserPaddingStart : this.mUserPaddingLeftInitial;
            this.mPaddingRight = this.mUserPaddingEnd >= 0 ? this.mUserPaddingEnd : this.mUserPaddingRightInitial;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetResolvedDrawables() {
        resetResolvedDrawablesInternal();
    }

    void resetResolvedDrawablesInternal() {
        this.mPrivateFlags2 &= -1073741825;
    }

    public void resetResolvedLayoutDirection() {
        this.mPrivateFlags2 &= -49;
    }

    public void resetResolvedPadding() {
        resetResolvedPaddingInternal();
    }

    void resetResolvedPaddingInternal() {
        this.mPrivateFlags2 &= -536870913;
    }

    public void resetResolvedTextAlignment() {
        this.mPrivateFlags2 &= -983041;
        this.mPrivateFlags2 |= 131072;
    }

    public void resetResolvedTextDirection() {
        this.mPrivateFlags2 &= -7681;
        this.mPrivateFlags2 |= 1024;
    }

    public void resetRtlProperties() {
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
        resetResolvedTextAlignment();
        resetResolvedPadding();
        resetResolvedDrawables();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetSubtreeAccessibilityStateChanged() {
        this.mPrivateFlags2 &= -134217729;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveDrawables() {
        if (isLayoutDirectionResolved() || getRawLayoutDirection() != 2) {
            int layoutDirection = isLayoutDirectionResolved() ? getLayoutDirection() : getRawLayoutDirection();
            if (this.mBackground != null) {
                this.mBackground.setLayoutDirection(layoutDirection);
            }
            this.mPrivateFlags2 |= 1073741824;
            onResolveDrawables(layoutDirection);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean resolveLayoutDirection() {
        boolean z;
        this.mPrivateFlags2 &= -49;
        if (hasRtlSupport()) {
            switch ((this.mPrivateFlags2 & 12) >> 2) {
                case 1:
                    this.mPrivateFlags2 |= 16;
                    break;
                case 2:
                    z = false;
                    if (canResolveLayoutDirection()) {
                        z = false;
                        try {
                            if (this.mParent.isLayoutDirectionResolved()) {
                                if (this.mParent.getLayoutDirection() == 1) {
                                    this.mPrivateFlags2 |= 16;
                                    break;
                                }
                            }
                        } catch (AbstractMethodError e) {
                            Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                            break;
                        }
                    }
                    break;
                case 3:
                    if (1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault())) {
                        this.mPrivateFlags2 |= 16;
                        break;
                    }
                    break;
            }
            return z;
        }
        this.mPrivateFlags2 |= 32;
        z = true;
        return z;
    }

    public void resolveLayoutParams() {
        if (this.mLayoutParams != null) {
            this.mLayoutParams.resolveLayoutDirection(getLayoutDirection());
        }
    }

    public void resolvePadding() {
        int layoutDirection = getLayoutDirection();
        if (!isRtlCompatibilityMode()) {
            if (this.mBackground != null && (!this.mLeftPaddingDefined || !this.mRightPaddingDefined)) {
                Rect rect = sThreadLocal.get();
                Rect rect2 = rect;
                if (rect == null) {
                    rect2 = new Rect();
                    sThreadLocal.set(rect2);
                }
                this.mBackground.getPadding(rect2);
                if (!this.mLeftPaddingDefined) {
                    this.mUserPaddingLeftInitial = rect2.left;
                }
                if (!this.mRightPaddingDefined) {
                    this.mUserPaddingRightInitial = rect2.right;
                }
            }
            switch (layoutDirection) {
                case 1:
                    if (this.mUserPaddingStart != Integer.MIN_VALUE) {
                        this.mUserPaddingRight = this.mUserPaddingStart;
                    } else {
                        this.mUserPaddingRight = this.mUserPaddingRightInitial;
                    }
                    if (this.mUserPaddingEnd == Integer.MIN_VALUE) {
                        this.mUserPaddingLeft = this.mUserPaddingLeftInitial;
                        break;
                    } else {
                        this.mUserPaddingLeft = this.mUserPaddingEnd;
                        break;
                    }
                default:
                    if (this.mUserPaddingStart != Integer.MIN_VALUE) {
                        this.mUserPaddingLeft = this.mUserPaddingStart;
                    } else {
                        this.mUserPaddingLeft = this.mUserPaddingLeftInitial;
                    }
                    if (this.mUserPaddingEnd == Integer.MIN_VALUE) {
                        this.mUserPaddingRight = this.mUserPaddingRightInitial;
                        break;
                    } else {
                        this.mUserPaddingRight = this.mUserPaddingEnd;
                        break;
                    }
            }
            this.mUserPaddingBottom = this.mUserPaddingBottom >= 0 ? this.mUserPaddingBottom : this.mPaddingBottom;
        }
        internalSetPadding(this.mUserPaddingLeft, this.mPaddingTop, this.mUserPaddingRight, this.mUserPaddingBottom);
        onRtlPropertiesChanged(layoutDirection);
        this.mPrivateFlags2 |= 536870912;
    }

    public boolean resolveRtlPropertiesIfNeeded() {
        if (needRtlPropertiesResolution()) {
            if (!isLayoutDirectionResolved()) {
                resolveLayoutDirection();
                resolveLayoutParams();
            }
            if (!isTextDirectionResolved()) {
                resolveTextDirection();
            }
            if (!isTextAlignmentResolved()) {
                resolveTextAlignment();
            }
            if (!areDrawablesResolved()) {
                resolveDrawables();
            }
            if (!isPaddingResolved()) {
                resolvePadding();
            }
            onRtlPropertiesChanged(getLayoutDirection());
            return true;
        }
        return false;
    }

    public boolean resolveTextAlignment() {
        int i;
        this.mPrivateFlags2 &= -983041;
        if (hasRtlSupport()) {
            int rawTextAlignment = getRawTextAlignment();
            switch (rawTextAlignment) {
                case 0:
                    if (!canResolveTextAlignment()) {
                        this.mPrivateFlags2 |= 131072;
                        return false;
                    }
                    try {
                        if (!this.mParent.isTextAlignmentResolved()) {
                            this.mPrivateFlags2 |= 131072;
                            return false;
                        }
                        try {
                            i = this.mParent.getTextAlignment();
                        } catch (AbstractMethodError e) {
                            Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                            i = 1;
                        }
                        switch (i) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.mPrivateFlags2 |= i << 17;
                                break;
                            default:
                                this.mPrivateFlags2 |= 131072;
                                break;
                        }
                    } catch (AbstractMethodError e2) {
                        Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                        this.mPrivateFlags2 |= Protocol.BASE_DHCP;
                        return true;
                    }
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    this.mPrivateFlags2 |= rawTextAlignment << 17;
                    break;
                default:
                    this.mPrivateFlags2 |= 131072;
                    break;
            }
        } else {
            this.mPrivateFlags2 |= 131072;
        }
        this.mPrivateFlags2 |= 65536;
        return true;
    }

    public boolean resolveTextDirection() {
        int i;
        this.mPrivateFlags2 &= -7681;
        if (hasRtlSupport()) {
            int rawTextDirection = getRawTextDirection();
            switch (rawTextDirection) {
                case 0:
                    if (!canResolveTextDirection()) {
                        this.mPrivateFlags2 |= 1024;
                        return false;
                    }
                    try {
                        if (!this.mParent.isTextDirectionResolved()) {
                            this.mPrivateFlags2 |= 1024;
                            return false;
                        }
                        try {
                            i = this.mParent.getTextDirection();
                        } catch (AbstractMethodError e) {
                            Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                            i = 3;
                        }
                        switch (i) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                this.mPrivateFlags2 |= i << 10;
                                break;
                            default:
                                this.mPrivateFlags2 |= 1024;
                                break;
                        }
                    } catch (AbstractMethodError e2) {
                        Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                        this.mPrivateFlags2 |= SYSTEM_UI_LAYOUT_FLAGS;
                        return true;
                    }
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    this.mPrivateFlags2 |= rawTextDirection << 10;
                    break;
                default:
                    this.mPrivateFlags2 |= 1024;
                    break;
            }
        } else {
            this.mPrivateFlags2 |= 1024;
        }
        this.mPrivateFlags2 |= 512;
        return true;
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        dispatchRestoreInstanceState(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean rootViewRequestFocus() {
        View rootView = getRootView();
        return rootView != null && rootView.requestFocus();
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        dispatchSaveInstanceState(sparseArray);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (!verifyDrawable(drawable) || runnable == null) {
            return;
        }
        long uptimeMillis = j - SystemClock.uptimeMillis();
        if (this.mAttachInfo != null) {
            this.mAttachInfo.mViewRootImpl.mChoreographer.postCallbackDelayed(1, runnable, drawable, Choreographer.subtractFrameDelay(uptimeMillis));
        } else {
            ViewRootImpl.getRunQueue().postDelayed(runnable, uptimeMillis);
        }
    }

    public void scrollBy(int i, int i2) {
        scrollTo(this.mScrollX + i, this.mScrollY + i2);
    }

    public void scrollTo(int i, int i2) {
        if (this.mScrollX == i && this.mScrollY == i2) {
            return;
        }
        int i3 = this.mScrollX;
        int i4 = this.mScrollY;
        this.mScrollX = i;
        this.mScrollY = i2;
        invalidateParentCaches();
        onScrollChanged(this.mScrollX, this.mScrollY, i3, i4);
        if (awakenScrollBars()) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (this.mAccessibilityDelegate != null) {
            this.mAccessibilityDelegate.sendAccessibilityEvent(this, i);
        } else {
            sendAccessibilityEventInternal(i);
        }
    }

    void sendAccessibilityEventInternal(int i) {
        if (AccessibilityManager.getInstance(this.mContext).isEnabled()) {
            sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(i));
        }
    }

    @Override // android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (this.mAccessibilityDelegate != null) {
            this.mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, accessibilityEvent);
        } else {
            sendAccessibilityEventUncheckedInternal(accessibilityEvent);
        }
    }

    void sendAccessibilityEventUncheckedInternal(AccessibilityEvent accessibilityEvent) {
        if (isShown()) {
            onInitializeAccessibilityEvent(accessibilityEvent);
            if ((accessibilityEvent.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0) {
                dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            getParent().requestSendAccessibilityEvent(this, accessibilityEvent);
        }
    }

    public void setAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        this.mAccessibilityDelegate = accessibilityDelegate;
    }

    public void setAccessibilityLiveRegion(int i) {
        if (i != getAccessibilityLiveRegion()) {
            this.mPrivateFlags2 &= -25165825;
            this.mPrivateFlags2 |= (i << 23) & 25165824;
            notifyViewAccessibilityStateChangedIfNeeded(0);
        }
    }

    public void setAccessibilitySelection(int i, int i2) {
        if (i == i2 && i2 == this.mAccessibilityCursorPosition) {
            return;
        }
        if (i < 0 || i != i2 || i2 > getIterableTextForAccessibility().length()) {
            this.mAccessibilityCursorPosition = -1;
        } else {
            this.mAccessibilityCursorPosition = i;
        }
        sendAccessibilityEvent(8192);
    }

    @RemotableViewMethod
    public void setAccessibilityTraversalAfter(int i) {
        if (this.mAccessibilityTraversalAfterId == i) {
            return;
        }
        this.mAccessibilityTraversalAfterId = i;
        notifyViewAccessibilityStateChangedIfNeeded(0);
    }

    @RemotableViewMethod
    public void setAccessibilityTraversalBefore(int i) {
        if (this.mAccessibilityTraversalBeforeId == i) {
            return;
        }
        this.mAccessibilityTraversalBeforeId = i;
        notifyViewAccessibilityStateChangedIfNeeded(0);
    }

    public void setActivated(boolean z) {
        int i = 1073741824;
        if (((this.mPrivateFlags & 1073741824) != 0) != z) {
            int i2 = this.mPrivateFlags;
            if (!z) {
                i = 0;
            }
            this.mPrivateFlags = i | (i2 & (-1073741825));
            invalidate(true);
            refreshDrawableState();
            dispatchSetActivated(z);
        }
    }

    public void setAlpha(float f) {
        ensureTransformationInfo();
        if (this.mTransformationInfo.mAlpha != f) {
            this.mTransformationInfo.mAlpha = f;
            if (onSetAlpha((int) (255.0f * f))) {
                this.mPrivateFlags |= 262144;
                invalidateParentCaches();
                invalidate(true);
                return;
            }
            this.mPrivateFlags &= -262145;
            invalidateViewProperty(true, false);
            this.mRenderNode.setAlpha(getFinalAlpha());
            notifyViewAccessibilityStateChangedIfNeeded(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setAlphaNoInvalidation(float f) {
        ensureTransformationInfo();
        if (this.mTransformationInfo.mAlpha != f) {
            this.mTransformationInfo.mAlpha = f;
            if (onSetAlpha((int) (255.0f * f))) {
                this.mPrivateFlags |= 262144;
                return true;
            }
            this.mPrivateFlags &= -262145;
            this.mRenderNode.setAlpha(getFinalAlpha());
            return false;
        }
        return false;
    }

    public void setAnimation(Animation animation) {
        this.mCurrentAnimation = animation;
        if (animation != null) {
            if (this.mAttachInfo != null && this.mAttachInfo.mDisplayState == 1 && animation.getStartTime() == -1) {
                animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            }
            animation.reset();
        }
    }

    public void setAnimationMatrix(Matrix matrix) {
        invalidateViewProperty(true, false);
        this.mRenderNode.setAnimationMatrix(matrix);
        invalidateViewProperty(false, true);
        invalidateParentIfNeededAndWasQuickRejected();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @RemotableViewMethod
    public void setBackgroundColor(int i) {
        if (!(this.mBackground instanceof ColorDrawable)) {
            setBackground(new ColorDrawable(i));
            return;
        }
        ((ColorDrawable) this.mBackground.mutate()).setColor(i);
        computeOpaqueFlags();
        this.mBackgroundResource = 0;
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        computeOpaqueFlags();
        if (drawable == this.mBackground) {
            return;
        }
        boolean z = false;
        this.mBackgroundResource = 0;
        if (this.mBackground != null) {
            this.mBackground.setCallback(null);
            unscheduleDrawable(this.mBackground);
        }
        if (drawable != null) {
            Rect rect = sThreadLocal.get();
            Rect rect2 = rect;
            if (rect == null) {
                rect2 = new Rect();
                sThreadLocal.set(rect2);
            }
            resetResolvedDrawablesInternal();
            drawable.setLayoutDirection(getLayoutDirection());
            if (drawable.getPadding(rect2)) {
                resetResolvedPaddingInternal();
                switch (drawable.getLayoutDirection()) {
                    case 1:
                        this.mUserPaddingLeftInitial = rect2.right;
                        this.mUserPaddingRightInitial = rect2.left;
                        internalSetPadding(rect2.right, rect2.top, rect2.left, rect2.bottom);
                        break;
                    default:
                        this.mUserPaddingLeftInitial = rect2.left;
                        this.mUserPaddingRightInitial = rect2.right;
                        internalSetPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
                        break;
                }
                this.mLeftPaddingDefined = false;
                this.mRightPaddingDefined = false;
            }
            if (this.mBackground == null || this.mBackground.getMinimumHeight() != drawable.getMinimumHeight() || this.mBackground.getMinimumWidth() != drawable.getMinimumWidth()) {
                z = true;
            }
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setVisible(getVisibility() == 0, false);
            this.mBackground = drawable;
            applyBackgroundTint();
            if ((this.mPrivateFlags & 128) != 0) {
                this.mPrivateFlags &= -129;
                this.mPrivateFlags |= 256;
                z = true;
            }
        } else {
            this.mBackground = null;
            if ((this.mPrivateFlags & 256) != 0) {
                this.mPrivateFlags &= -257;
                this.mPrivateFlags |= 128;
            }
            z = true;
        }
        computeOpaqueFlags();
        if (z) {
            requestLayout();
        }
        this.mBackgroundSizeChanged = true;
        invalidate(true);
    }

    @RemotableViewMethod
    public void setBackgroundResource(int i) {
        if (i == 0 || i != this.mBackgroundResource) {
            Drawable drawable = null;
            if (i != 0) {
                drawable = this.mContext.getDrawable(i);
            }
            setBackground(drawable);
            this.mBackgroundResource = i;
        }
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintList = colorStateList;
        this.mBackgroundTint.mHasTintList = true;
        applyBackgroundTint();
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        this.mBackgroundTint.mTintMode = mode;
        this.mBackgroundTint.mHasTintMode = true;
        applyBackgroundTint();
    }

    public final void setBottom(int i) {
        if (i != this.mBottom) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidate(true);
            } else if (this.mAttachInfo != null) {
                invalidate(0, 0, this.mRight - this.mLeft, (i < this.mBottom ? this.mBottom : i) - this.mTop);
            }
            int i2 = this.mRight - this.mLeft;
            int i3 = this.mBottom;
            int i4 = this.mTop;
            this.mBottom = i;
            this.mRenderNode.setBottom(this.mBottom);
            sizeChange(i2, this.mBottom - this.mTop, i2, i3 - i4);
            if (!hasIdentityMatrix) {
                this.mPrivateFlags |= 32;
                invalidate(true);
            }
            this.mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if ((this.mPrivateFlags2 & 268435456) == 268435456) {
                invalidateParentIfNeeded();
            }
        }
    }

    public void setCameraDistance(float f) {
        float f2 = this.mResources.getDisplayMetrics().densityDpi;
        invalidateViewProperty(true, false);
        this.mRenderNode.setCameraDistance((-Math.abs(f)) / f2);
        invalidateViewProperty(false, false);
        invalidateParentIfNeededAndWasQuickRejected();
    }

    public void setClickable(boolean z) {
        setFlags(z ? 16384 : 0, 16384);
    }

    public void setClipBounds(Rect rect) {
        if (rect != this.mClipBounds) {
            if (rect == null || !rect.equals(this.mClipBounds)) {
                if (rect == null) {
                    this.mClipBounds = null;
                } else if (this.mClipBounds == null) {
                    this.mClipBounds = new Rect(rect);
                } else {
                    this.mClipBounds.set(rect);
                }
                this.mRenderNode.setClipBounds(this.mClipBounds);
                invalidateViewProperty(false, false);
            }
        }
    }

    public void setClipToOutline(boolean z) {
        damageInParent();
        if (getClipToOutline() != z) {
            this.mRenderNode.setClipToOutline(z);
        }
    }

    @RemotableViewMethod
    public void setContentDescription(CharSequence charSequence) {
        if (this.mContentDescription == null) {
            if (charSequence == null) {
                return;
            }
        } else if (this.mContentDescription.equals(charSequence)) {
            return;
        }
        this.mContentDescription = charSequence;
        if (!(charSequence != null && charSequence.length() > 0) || getImportantForAccessibility() != 0) {
            notifyViewAccessibilityStateChangedIfNeeded(4);
            return;
        }
        setImportantForAccessibility(1);
        notifySubtreeAccessibilityStateChangedIfNeeded();
    }

    public void setDisabledSystemUiVisibility(int i) {
        if (this.mAttachInfo == null || this.mAttachInfo.mDisabledSystemUiVisibility == i) {
            return;
        }
        this.mAttachInfo.mDisabledSystemUiVisibility = i;
        if (this.mParent != null) {
            this.mParent.recomputeViewAttributes(this);
        }
    }

    void setDisplayListProperties(RenderNode renderNode) {
        if (renderNode != null) {
            renderNode.setHasOverlappingRendering(hasOverlappingRendering());
            if (this.mParent instanceof ViewGroup) {
                renderNode.setClipToBounds((((ViewGroup) this.mParent).mGroupFlags & 1) != 0);
            }
            float f = 1.0f;
            float f2 = 1.0f;
            if (this.mParent instanceof ViewGroup) {
                f2 = 1.0f;
                if ((((ViewGroup) this.mParent).mGroupFlags & 2048) != 0) {
                    ViewGroup viewGroup = (ViewGroup) this.mParent;
                    Transformation childTransformation = viewGroup.getChildTransformation();
                    f2 = 1.0f;
                    if (viewGroup.getChildStaticTransformation(this, childTransformation)) {
                        int transformationType = childTransformation.getTransformationType();
                        f2 = 1.0f;
                        if (transformationType != 0) {
                            if ((transformationType & 1) != 0) {
                                f = childTransformation.getAlpha();
                            }
                            f2 = f;
                            if ((transformationType & 2) != 0) {
                                renderNode.setStaticMatrix(childTransformation.getMatrix());
                                f2 = f;
                            }
                        }
                    }
                }
            }
            if (this.mTransformationInfo == null) {
                if (f2 < 1.0f) {
                    renderNode.setAlpha(f2);
                    return;
                }
                return;
            }
            float finalAlpha = f2 * getFinalAlpha();
            float f3 = finalAlpha;
            if (finalAlpha < 1.0f) {
                f3 = finalAlpha;
                if (onSetAlpha((int) (255.0f * finalAlpha))) {
                    f3 = 1.0f;
                }
            }
            renderNode.setAlpha(f3);
        }
    }

    public void setDrawingCacheBackgroundColor(int i) {
        if (i != this.mDrawingCacheBackgroundColor) {
            this.mDrawingCacheBackgroundColor = i;
            this.mPrivateFlags &= -32769;
        }
    }

    public void setDrawingCacheEnabled(boolean z) {
        int i = 0;
        this.mCachingFailed = false;
        if (z) {
            i = 32768;
        }
        setFlags(i, 32768);
    }

    public void setDrawingCacheQuality(int i) {
        setFlags(i, DRAWING_CACHE_QUALITY_MASK);
    }

    public void setDuplicateParentStateEnabled(boolean z) {
        setFlags(z ? 4194304 : 0, 4194304);
    }

    public void setElevation(float f) {
        if (f != getElevation()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setElevation(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
        }
    }

    @RemotableViewMethod
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        setFlags(z ? 0 : 32, 32);
        refreshDrawableState();
        invalidate(true);
        if (z) {
            return;
        }
        cancelPendingInputEvents();
    }

    public void setFadingEdgeLength(int i) {
        initScrollCache();
        this.mScrollCache.fadingEdgeLength = i;
    }

    public void setFilterTouchesWhenObscured(boolean z) {
        setFlags(z ? 1024 : 0, 1024);
    }

    public void setFitsSystemWindows(boolean z) {
        setFlags(z ? 2 : 0, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFlags(int i, int i2) {
        boolean isEnabled = AccessibilityManager.getInstance(this.mContext).isEnabled();
        boolean z = isEnabled && includeForAccessibility();
        int i3 = this.mViewFlags;
        this.mViewFlags = (this.mViewFlags & (i2 ^ (-1))) | (i & i2);
        int i4 = this.mViewFlags ^ i3;
        if (i4 == 0) {
            return;
        }
        int i5 = this.mPrivateFlags;
        if ((i4 & 1) != 0 && (i5 & 16) != 0) {
            if ((i3 & 1) == 1 && (i5 & 2) != 0) {
                clearFocus();
            } else if ((i3 & 1) == 0 && (i5 & 2) == 0 && this.mParent != null) {
                this.mParent.focusableViewAvailable(this);
            }
        }
        int i6 = i & 12;
        if (i6 == 0 && (i4 & 12) != 0) {
            this.mPrivateFlags |= 32;
            invalidate(true);
            needGlobalAttributesUpdate(true);
            if (this.mParent != null && this.mBottom > this.mTop && this.mRight > this.mLeft) {
                this.mParent.focusableViewAvailable(this);
            }
        }
        if ((i4 & 8) != 0) {
            needGlobalAttributesUpdate(false);
            requestLayout();
            if ((this.mViewFlags & 12) == 8) {
                if (hasFocus()) {
                    clearFocus();
                }
                clearAccessibilityFocus();
                destroyDrawingCache();
                if (this.mParent instanceof View) {
                    ((View) this.mParent).invalidate(true);
                }
                this.mPrivateFlags |= 32;
            }
            if (this.mAttachInfo != null) {
                this.mAttachInfo.mViewVisibilityChanged = true;
            }
        }
        if ((i4 & 4) != 0) {
            needGlobalAttributesUpdate(false);
            this.mPrivateFlags |= 32;
            if ((this.mViewFlags & 12) == 4 && getRootView() != this) {
                if (hasFocus()) {
                    clearFocus();
                }
                clearAccessibilityFocus();
            }
            if (this.mAttachInfo != null) {
                this.mAttachInfo.mViewVisibilityChanged = true;
            }
        }
        if ((i4 & 12) != 0) {
            if (i6 != 0 && this.mAttachInfo != null) {
                cleanupDraw();
            }
            if (this.mParent instanceof ViewGroup) {
                ((ViewGroup) this.mParent).onChildVisibilityChanged(this, i4 & 12, i6);
                ((View) this.mParent).invalidate(true);
            } else if (this.mParent != null) {
                this.mParent.invalidateChild(this, null);
            }
            dispatchVisibilityChanged(this, i6);
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
        if ((131072 & i4) != 0) {
            destroyDrawingCache();
        }
        if ((32768 & i4) != 0) {
            destroyDrawingCache();
            this.mPrivateFlags &= -32769;
            invalidateParentCaches();
        }
        if ((DRAWING_CACHE_QUALITY_MASK & i4) != 0) {
            destroyDrawingCache();
            this.mPrivateFlags &= -32769;
        }
        if ((i4 & 128) != 0) {
            if ((this.mViewFlags & 128) == 0) {
                this.mPrivateFlags &= -129;
            } else if (this.mBackground != null) {
                this.mPrivateFlags &= -129;
                this.mPrivateFlags |= 256;
            } else {
                this.mPrivateFlags |= 128;
            }
            requestLayout();
            invalidate(true);
        }
        if ((67108864 & i4) != 0 && this.mParent != null && this.mAttachInfo != null && !this.mAttachInfo.mRecomputeGlobalAttributes) {
            this.mParent.recomputeViewAttributes(this);
        }
        if (isEnabled) {
            if ((i4 & 1) == 0 && (i4 & 12) == 0 && (i4 & 16384) == 0 && (2097152 & i4) == 0) {
                if ((i4 & 32) != 0) {
                    notifyViewAccessibilityStateChangedIfNeeded(0);
                }
            } else if (z != includeForAccessibility()) {
                notifySubtreeAccessibilityStateChangedIfNeeded();
            } else {
                notifyViewAccessibilityStateChangedIfNeeded(0);
            }
        }
    }

    public void setFocusable(boolean z) {
        int i = 0;
        if (!z) {
            setFlags(0, 262144);
        }
        if (z) {
            i = 1;
        }
        setFlags(i, 1);
    }

    public void setFocusableInTouchMode(boolean z) {
        setFlags(z ? 262144 : 0, 262144);
        if (z) {
            setFlags(1, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.mLeft != i || this.mRight != i3 || this.mTop != i2 || this.mBottom != i4) {
            int i5 = this.mPrivateFlags;
            int i6 = this.mRight - this.mLeft;
            int i7 = this.mBottom - this.mTop;
            int i8 = i3 - i;
            int i9 = i4 - i2;
            boolean z2 = (i8 == i6 && i9 == i7) ? false : true;
            invalidate(z2);
            this.mLeft = i;
            this.mTop = i2;
            this.mRight = i3;
            this.mBottom = i4;
            this.mRenderNode.setLeftTopRightBottom(this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mPrivateFlags |= 16;
            if (z2) {
                sizeChange(i8, i9, i6, i7);
            }
            if ((this.mViewFlags & 12) == 0 || this.mGhostView != null) {
                this.mPrivateFlags |= 32;
                invalidate(z2);
                invalidateParentCaches();
            }
            this.mPrivateFlags |= i5 & 32;
            this.mBackgroundSizeChanged = true;
            notifySubtreeAccessibilityStateChangedIfNeeded();
            z = true;
        }
        return z;
    }

    public void setHapticFeedbackEnabled(boolean z) {
        setFlags(z ? 268435456 : 0, 268435456);
    }

    public void setHasTransientState(boolean z) {
        this.mTransientStateCount = z ? this.mTransientStateCount + 1 : this.mTransientStateCount - 1;
        if (this.mTransientStateCount < 0) {
            this.mTransientStateCount = 0;
            Log.e(VIEW_LOG_TAG, "hasTransientState decremented below 0: unmatched pair of setHasTransientState calls");
        } else if (!(z && this.mTransientStateCount == 1) && (z || this.mTransientStateCount != 0)) {
        } else {
            this.mPrivateFlags2 = (z ? Integer.MIN_VALUE : 0) | (Integer.MAX_VALUE & this.mPrivateFlags2);
            if (this.mParent != null) {
                try {
                    this.mParent.childHasTransientStateChanged(this, z);
                } catch (AbstractMethodError e) {
                    Log.e(VIEW_LOG_TAG, this.mParent.getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    public void setHorizontalFadingEdgeEnabled(boolean z) {
        if (isHorizontalFadingEdgeEnabled() != z) {
            if (z) {
                initScrollCache();
            }
            this.mViewFlags ^= 4096;
        }
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        if (isHorizontalScrollBarEnabled() != z) {
            this.mViewFlags ^= 256;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setHovered(boolean z) {
        if (z) {
            if ((this.mPrivateFlags & 268435456) == 0) {
                this.mPrivateFlags |= 268435456;
                refreshDrawableState();
                onHoverChanged(true);
            }
        } else if ((this.mPrivateFlags & 268435456) != 0) {
            this.mPrivateFlags &= -268435457;
            refreshDrawableState();
            onHoverChanged(false);
        }
    }

    public void setId(int i) {
        this.mID = i;
        if (this.mID != -1 || this.mLabelForId == -1) {
            return;
        }
        this.mID = generateViewId();
    }

    public void setImportantForAccessibility(int i) {
        boolean z = true;
        int importantForAccessibility = getImportantForAccessibility();
        if (i != importantForAccessibility) {
            boolean z2 = importantForAccessibility == 0 || i == 0;
            if (!z2 || !includeForAccessibility()) {
                z = false;
            }
            this.mPrivateFlags2 &= -7340033;
            this.mPrivateFlags2 |= (i << 20) & PFLAG2_IMPORTANT_FOR_ACCESSIBILITY_MASK;
            if (z2 && z == includeForAccessibility()) {
                notifyViewAccessibilityStateChangedIfNeeded(0);
            } else {
                notifySubtreeAccessibilityStateChangedIfNeeded();
            }
        }
    }

    public void setIsRootNamespace(boolean z) {
        if (z) {
            this.mPrivateFlags |= 8;
        } else {
            this.mPrivateFlags &= -9;
        }
    }

    public void setKeepScreenOn(boolean z) {
        setFlags(z ? 67108864 : 0, 67108864);
    }

    @RemotableViewMethod
    public void setLabelFor(int i) {
        if (this.mLabelForId == i) {
            return;
        }
        this.mLabelForId = i;
        if (this.mLabelForId != -1 && this.mID == -1) {
            this.mID = generateViewId();
        }
        notifyViewAccessibilityStateChangedIfNeeded(0);
    }

    public void setLayerPaint(Paint paint) {
        int layerType = getLayerType();
        if (layerType != 0) {
            Paint paint2 = paint;
            if (paint == null) {
                paint2 = new Paint();
            }
            this.mLayerPaint = paint2;
            if (layerType != 2) {
                invalidate();
            } else if (this.mRenderNode.setLayerPaint(this.mLayerPaint)) {
                invalidateViewProperty(false, false);
            }
        }
    }

    public void setLayerType(int i, Paint paint) {
        Paint paint2;
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        }
        if (!this.mRenderNode.setLayerType(i)) {
            setLayerPaint(paint);
            return;
        }
        if (this.mLayerType == 1) {
            destroyDrawingCache();
        }
        this.mLayerType = i;
        if (this.mLayerType == 0) {
            paint2 = null;
        } else {
            paint2 = paint;
            if (paint == null) {
                paint2 = new Paint();
            }
        }
        this.mLayerPaint = paint2;
        this.mRenderNode.setLayerPaint(this.mLayerPaint);
        invalidateParentCaches();
        invalidate(true);
    }

    @RemotableViewMethod
    public void setLayoutDirection(int i) {
        if (getRawLayoutDirection() != i) {
            this.mPrivateFlags2 &= -13;
            resetRtlProperties();
            this.mPrivateFlags2 |= (i << 2) & 12;
            resolveRtlPropertiesIfNeeded();
            requestLayout();
            invalidate(true);
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            throw new NullPointerException("Layout parameters cannot be null");
        }
        this.mLayoutParams = layoutParams;
        resolveLayoutParams();
        if (this.mParent instanceof ViewGroup) {
            ((ViewGroup) this.mParent).onSetLayoutParams(this, layoutParams);
        }
        requestLayout();
    }

    public final void setLeft(int i) {
        int i2;
        int i3;
        if (i != this.mLeft) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidate(true);
            } else if (this.mAttachInfo != null) {
                if (i < this.mLeft) {
                    i2 = i;
                    i3 = i - this.mLeft;
                } else {
                    i2 = this.mLeft;
                    i3 = 0;
                }
                invalidate(i3, 0, this.mRight - i2, this.mBottom - this.mTop);
            }
            int i4 = this.mRight;
            int i5 = this.mLeft;
            int i6 = this.mBottom - this.mTop;
            this.mLeft = i;
            this.mRenderNode.setLeft(i);
            sizeChange(this.mRight - this.mLeft, i6, i4 - i5, i6);
            if (!hasIdentityMatrix) {
                this.mPrivateFlags |= 32;
                invalidate(true);
            }
            this.mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if ((this.mPrivateFlags2 & 268435456) == 268435456) {
                invalidateParentIfNeeded();
            }
        }
    }

    public void setLeftTopRightBottom(int i, int i2, int i3, int i4) {
        setFrame(i, i2, i3, i4);
    }

    public void setLongClickable(boolean z) {
        setFlags(z ? 2097152 : 0, 2097152);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMeasuredDimension(int i, int i2) {
        boolean isLayoutModeOptical = isLayoutModeOptical(this);
        int i3 = i;
        int i4 = i2;
        if (isLayoutModeOptical != isLayoutModeOptical(this.mParent)) {
            Insets opticalInsets = getOpticalInsets();
            int i5 = opticalInsets.left + opticalInsets.right;
            int i6 = opticalInsets.top + opticalInsets.bottom;
            if (!isLayoutModeOptical) {
                i5 = -i5;
            }
            int i7 = i + i5;
            i4 = i2 + (isLayoutModeOptical ? i6 : -i6);
            i3 = i7;
        }
        setMeasuredDimensionRaw(i3, i4);
    }

    public void setMinimumHeight(int i) {
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinimumWidth(int i) {
        this.mMinWidth = i;
        requestLayout();
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (z) {
            this.mPrivateFlags3 |= 128;
            return;
        }
        stopNestedScroll();
        this.mPrivateFlags3 &= -129;
    }

    public void setNextFocusDownId(int i) {
        this.mNextFocusDownId = i;
    }

    public void setNextFocusForwardId(int i) {
        this.mNextFocusForwardId = i;
    }

    public void setNextFocusLeftId(int i) {
        this.mNextFocusLeftId = i;
    }

    public void setNextFocusRightId(int i) {
        this.mNextFocusRightId = i;
    }

    public void setNextFocusUpId(int i) {
        this.mNextFocusUpId = i;
    }

    public void setOnApplyWindowInsetsListener(OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        getListenerInfo().mOnApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (!isClickable()) {
            setClickable(true);
        }
        getListenerInfo().mOnClickListener = onClickListener;
    }

    public void setOnCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        getListenerInfo().mOnCreateContextMenuListener = onCreateContextMenuListener;
    }

    public void setOnDragListener(OnDragListener onDragListener) {
        getListenerInfo().mOnDragListener = onDragListener;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        getListenerInfo().mOnFocusChangeListener = onFocusChangeListener;
    }

    public void setOnGenericMotionListener(OnGenericMotionListener onGenericMotionListener) {
        getListenerInfo().mOnGenericMotionListener = onGenericMotionListener;
    }

    public void setOnHoverListener(OnHoverListener onHoverListener) {
        getListenerInfo().mOnHoverListener = onHoverListener;
    }

    public void setOnKeyListener(OnKeyListener onKeyListener) {
        getListenerInfo().mOnKeyListener = onKeyListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        getListenerInfo().mOnLongClickListener = onLongClickListener;
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        getListenerInfo().mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener onSystemUiVisibilityChangeListener) {
        getListenerInfo().mOnSystemUiVisibilityChangeListener = onSystemUiVisibilityChangeListener;
        if (this.mParent == null || this.mAttachInfo == null || this.mAttachInfo.mRecomputeGlobalAttributes) {
            return;
        }
        this.mParent.recomputeViewAttributes(this);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getListenerInfo().mOnTouchListener = onTouchListener;
    }

    public void setOpticalInsets(Insets insets) {
        this.mLayoutInsets = insets;
    }

    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
        this.mOutlineProvider = viewOutlineProvider;
        invalidateOutline();
    }

    public void setOverScrollMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid overscroll mode " + i);
        }
        this.mOverScrollMode = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        resetResolvedPaddingInternal();
        this.mUserPaddingStart = Integer.MIN_VALUE;
        this.mUserPaddingEnd = Integer.MIN_VALUE;
        this.mUserPaddingLeftInitial = i;
        this.mUserPaddingRightInitial = i3;
        this.mLeftPaddingDefined = true;
        this.mRightPaddingDefined = true;
        internalSetPadding(i, i2, i3, i4);
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        resetResolvedPaddingInternal();
        this.mUserPaddingStart = i;
        this.mUserPaddingEnd = i3;
        this.mLeftPaddingDefined = true;
        this.mRightPaddingDefined = true;
        switch (getLayoutDirection()) {
            case 1:
                this.mUserPaddingLeftInitial = i3;
                this.mUserPaddingRightInitial = i;
                internalSetPadding(i3, i2, i, i4);
                return;
            default:
                this.mUserPaddingLeftInitial = i;
                this.mUserPaddingRightInitial = i3;
                internalSetPadding(i, i2, i3, i4);
                return;
        }
    }

    public void setPivotX(float f) {
        if (this.mRenderNode.isPivotExplicitlySet() && f == getPivotX()) {
            return;
        }
        invalidateViewProperty(true, false);
        this.mRenderNode.setPivotX(f);
        invalidateViewProperty(false, true);
        invalidateParentIfNeededAndWasQuickRejected();
    }

    public void setPivotY(float f) {
        if (this.mRenderNode.isPivotExplicitlySet() && f == getPivotY()) {
            return;
        }
        invalidateViewProperty(true, false);
        this.mRenderNode.setPivotY(f);
        invalidateViewProperty(false, true);
        invalidateParentIfNeededAndWasQuickRejected();
    }

    public void setPressed(boolean z) {
        boolean z2 = true;
        if (z == ((this.mPrivateFlags & 16384) == 16384)) {
            z2 = false;
        }
        if (z) {
            this.mPrivateFlags |= 16384;
        } else {
            this.mPrivateFlags &= -16385;
        }
        if (z2) {
            refreshDrawableState();
        }
        dispatchSetPressed(z);
    }

    public void setRevealClip(boolean z, float f, float f2, float f3) {
        this.mRenderNode.setRevealClip(z, f, f2, f3);
        invalidateViewProperty(false, false);
    }

    public final void setRight(int i) {
        if (i != this.mRight) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidate(true);
            } else if (this.mAttachInfo != null) {
                invalidate(0, 0, (i < this.mRight ? this.mRight : i) - this.mLeft, this.mBottom - this.mTop);
            }
            int i2 = this.mRight;
            int i3 = this.mLeft;
            int i4 = this.mBottom - this.mTop;
            this.mRight = i;
            this.mRenderNode.setRight(this.mRight);
            sizeChange(this.mRight - this.mLeft, i4, i2 - i3, i4);
            if (!hasIdentityMatrix) {
                this.mPrivateFlags |= 32;
                invalidate(true);
            }
            this.mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if ((this.mPrivateFlags2 & 268435456) == 268435456) {
                invalidateParentIfNeeded();
            }
        }
    }

    public void setRotation(float f) {
        if (f != getRotation()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setRotation(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setRotationX(float f) {
        if (f != getRotationX()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setRotationX(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setRotationY(float f) {
        if (f != getRotationY()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setRotationY(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setSaveEnabled(boolean z) {
        setFlags(z ? 0 : 65536, 65536);
    }

    public void setSaveFromParentEnabled(boolean z) {
        setFlags(z ? 0 : 536870912, 536870912);
    }

    public void setScaleX(float f) {
        if (f != getScaleX()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setScaleX(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setScaleY(float f) {
        if (f != getScaleY()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setScaleY(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setScrollBarDefaultDelayBeforeFade(int i) {
        getScrollCache().scrollBarDefaultDelayBeforeFade = i;
    }

    public void setScrollBarFadeDuration(int i) {
        getScrollCache().scrollBarFadeDuration = i;
    }

    public void setScrollBarSize(int i) {
        getScrollCache().scrollBarSize = i;
    }

    public void setScrollBarStyle(int i) {
        if (i != (this.mViewFlags & 50331648)) {
            this.mViewFlags = (this.mViewFlags & (-50331649)) | (i & 50331648);
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setScrollContainer(boolean z) {
        if (!z) {
            if ((this.mPrivateFlags & 1048576) != 0) {
                this.mAttachInfo.mScrollContainers.remove(this);
            }
            this.mPrivateFlags &= -1572865;
            return;
        }
        if (this.mAttachInfo != null && (this.mPrivateFlags & 1048576) == 0) {
            this.mAttachInfo.mScrollContainers.add(this);
            this.mPrivateFlags |= 1048576;
        }
        this.mPrivateFlags |= 524288;
    }

    public void setScrollX(int i) {
        scrollTo(i, this.mScrollY);
    }

    public void setScrollY(int i) {
        scrollTo(this.mScrollX, i);
    }

    public void setScrollbarFadingEnabled(boolean z) {
        initScrollCache();
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        scrollabilityCache.fadeScrollBars = z;
        if (z) {
            scrollabilityCache.state = 0;
        } else {
            scrollabilityCache.state = 1;
        }
    }

    public void setSelected(boolean z) {
        if (((this.mPrivateFlags & 4) != 0) != z) {
            this.mPrivateFlags = (z ? 4 : 0) | (this.mPrivateFlags & (-5));
            if (!z) {
                resetPressedState();
            }
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(z);
            if (z) {
                sendAccessibilityEvent(4);
            } else {
                notifyViewAccessibilityStateChangedIfNeeded(0);
            }
        }
    }

    public void setSoundEffectsEnabled(boolean z) {
        setFlags(z ? 134217728 : 0, 134217728);
    }

    public void setStateListAnimator(StateListAnimator stateListAnimator) {
        if (this.mStateListAnimator == stateListAnimator) {
            return;
        }
        if (this.mStateListAnimator != null) {
            this.mStateListAnimator.setTarget(null);
        }
        this.mStateListAnimator = stateListAnimator;
        if (stateListAnimator != null) {
            stateListAnimator.setTarget(this);
            if (isAttachedToWindow()) {
                stateListAnimator.setState(getDrawableState());
            }
        }
    }

    public void setSystemUiVisibility(int i) {
        if (i != this.mSystemUiVisibility) {
            this.mSystemUiVisibility = i;
            if (this.mParent == null || this.mAttachInfo == null || this.mAttachInfo.mRecomputeGlobalAttributes) {
                return;
            }
            this.mParent.recomputeViewAttributes(this);
        }
    }

    public void setTag(int i, Object obj) {
        if ((i >>> 24) < 2) {
            throw new IllegalArgumentException("The key must be an application-specific resource id.");
        }
        setKeyedTag(i, obj);
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public void setTagInternal(int i, Object obj) {
        if ((i >>> 24) != 1) {
            throw new IllegalArgumentException("The key must be a framework-specific resource id.");
        }
        setKeyedTag(i, obj);
    }

    public void setTextAlignment(int i) {
        if (i != getRawTextAlignment()) {
            this.mPrivateFlags2 &= -57345;
            resetResolvedTextAlignment();
            this.mPrivateFlags2 |= (i << 13) & PFLAG2_TEXT_ALIGNMENT_MASK;
            resolveTextAlignment();
            onRtlPropertiesChanged(getLayoutDirection());
            requestLayout();
            invalidate(true);
        }
    }

    public void setTextDirection(int i) {
        if (getRawTextDirection() != i) {
            this.mPrivateFlags2 &= -449;
            resetResolvedTextDirection();
            this.mPrivateFlags2 |= (i << 6) & PFLAG2_TEXT_DIRECTION_MASK;
            resolveTextDirection();
            onRtlPropertiesChanged(getLayoutDirection());
            requestLayout();
            invalidate(true);
        }
    }

    public final void setTop(int i) {
        int i2;
        int i3;
        if (i != this.mTop) {
            boolean hasIdentityMatrix = hasIdentityMatrix();
            if (!hasIdentityMatrix) {
                invalidate(true);
            } else if (this.mAttachInfo != null) {
                if (i < this.mTop) {
                    i2 = i;
                    i3 = i - this.mTop;
                } else {
                    i2 = this.mTop;
                    i3 = 0;
                }
                invalidate(0, i3, this.mRight - this.mLeft, this.mBottom - i2);
            }
            int i4 = this.mRight - this.mLeft;
            int i5 = this.mBottom;
            int i6 = this.mTop;
            this.mTop = i;
            this.mRenderNode.setTop(this.mTop);
            sizeChange(i4, this.mBottom - this.mTop, i4, i5 - i6);
            if (!hasIdentityMatrix) {
                this.mPrivateFlags |= 32;
                invalidate(true);
            }
            this.mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
            if ((this.mPrivateFlags2 & 268435456) == 268435456) {
                invalidateParentIfNeeded();
            }
        }
    }

    public void setTouchDelegate(TouchDelegate touchDelegate) {
        this.mTouchDelegate = touchDelegate;
    }

    public void setTransitionAlpha(float f) {
        ensureTransformationInfo();
        if (this.mTransformationInfo.mTransitionAlpha != f) {
            this.mTransformationInfo.mTransitionAlpha = f;
            this.mPrivateFlags &= -262145;
            invalidateViewProperty(true, false);
            this.mRenderNode.setAlpha(getFinalAlpha());
        }
    }

    public final void setTransitionName(String str) {
        this.mTransitionName = str;
    }

    public void setTranslationX(float f) {
        if (f != getTranslationX()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setTranslationX(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
            notifySubtreeAccessibilityStateChangedIfNeeded();
        }
    }

    public void setTranslationY(float f) {
        if (f != getTranslationY()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setTranslationY(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
        }
    }

    public void setTranslationZ(float f) {
        if (f != getTranslationZ()) {
            invalidateViewProperty(true, false);
            this.mRenderNode.setTranslationZ(f);
            invalidateViewProperty(false, true);
            invalidateParentIfNeededAndWasQuickRejected();
        }
    }

    public void setVerticalFadingEdgeEnabled(boolean z) {
        if (isVerticalFadingEdgeEnabled() != z) {
            if (z) {
                initScrollCache();
            }
            this.mViewFlags ^= 8192;
        }
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        if (isVerticalScrollBarEnabled() != z) {
            this.mViewFlags ^= 512;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    public void setVerticalScrollbarPosition(int i) {
        if (this.mVerticalScrollbarPosition != i) {
            this.mVerticalScrollbarPosition = i;
            computeOpaqueFlags();
            resolvePadding();
        }
    }

    @RemotableViewMethod
    public void setVisibility(int i) {
        setFlags(i, 12);
        if (this.mBackground != null) {
            this.mBackground.setVisible(i == 0, false);
        }
    }

    public void setWillNotCacheDrawing(boolean z) {
        setFlags(z ? 131072 : 0, 131072);
    }

    public void setWillNotDraw(boolean z) {
        setFlags(z ? 128 : 0, 128);
    }

    public void setX(float f) {
        setTranslationX(f - this.mLeft);
    }

    public void setY(float f) {
        setTranslationY(f - this.mTop);
    }

    public void setZ(float f) {
        setTranslationZ(f - getElevation());
    }

    public boolean showContextMenu() {
        return getParent().showContextMenuForChild(this);
    }

    public boolean showContextMenu(float f, float f2, int i) {
        return showContextMenu();
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        return parent.startActionModeForChild(this, callback);
    }

    public void startAnimation(Animation animation) {
        animation.setStartTime(-1L);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
    }

    public final boolean startDrag(ClipData clipData, DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        Point point = new Point();
        Point point2 = new Point();
        dragShadowBuilder.onProvideShadowMetrics(point, point2);
        if (point.x < 0 || point.y < 0 || point2.x < 0 || point2.y < 0) {
            throw new IllegalStateException("Drag shadow dimensions must not be negative");
        }
        Surface surface = new Surface();
        boolean z = false;
        try {
            IBinder prepareDrag = this.mAttachInfo.mSession.prepareDrag(this.mAttachInfo.mWindow, i, point.x, point.y, surface);
            z = false;
            if (prepareDrag != null) {
                Canvas lockCanvas = surface.lockCanvas(null);
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                dragShadowBuilder.onDrawShadow(lockCanvas);
                surface.unlockCanvasAndPost(lockCanvas);
                ViewRootImpl viewRootImpl = getViewRootImpl();
                viewRootImpl.setLocalDragState(obj);
                viewRootImpl.getLastTouchPoint(point);
                boolean performDrag = this.mAttachInfo.mSession.performDrag(this.mAttachInfo.mWindow, prepareDrag, point.x, point.y, point2.x, point2.y, clipData);
                z = performDrag;
                surface.release();
                return performDrag;
            }
        } catch (Exception e) {
            Log.e(VIEW_LOG_TAG, "Unable to initiate drag", e);
            surface.destroy();
        }
        return z;
    }

    public boolean startNestedScroll(int i) {
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this;
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                try {
                    if (parent.onStartNestedScroll(view, this, i)) {
                        this.mNestedScrollingParent = parent;
                        parent.onNestedScrollAccepted(view, this, i);
                        return true;
                    }
                } catch (AbstractMethodError e) {
                    Log.e(VIEW_LOG_TAG, "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                }
                if (parent instanceof View) {
                    view = parent;
                }
            }
            return false;
        }
        return false;
    }

    public void stopNestedScroll() {
        if (this.mNestedScrollingParent != null) {
            this.mNestedScrollingParent.onStopNestedScroll(this);
            this.mNestedScrollingParent = null;
        }
    }

    public boolean toGlobalMotionEvent(MotionEvent motionEvent) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo == null) {
            return false;
        }
        Matrix matrix = attachInfo.mTmpMatrix;
        matrix.set(Matrix.IDENTITY_MATRIX);
        transformMatrixToGlobal(matrix);
        motionEvent.transform(matrix);
        return true;
    }

    public boolean toLocalMotionEvent(MotionEvent motionEvent) {
        AttachInfo attachInfo = this.mAttachInfo;
        if (attachInfo == null) {
            return false;
        }
        Matrix matrix = attachInfo.mTmpMatrix;
        matrix.set(Matrix.IDENTITY_MATRIX);
        transformMatrixToLocal(matrix);
        motionEvent.transform(matrix);
        return true;
    }

    public String toString() {
        String resourcePackageName;
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        switch (this.mViewFlags & 12) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append((this.mViewFlags & 1) == 1 ? 'F' : '.');
        sb.append((this.mViewFlags & 32) == 0 ? 'E' : '.');
        sb.append((this.mViewFlags & 128) == 128 ? '.' : 'D');
        sb.append((this.mViewFlags & 256) != 0 ? 'H' : '.');
        sb.append((this.mViewFlags & 512) != 0 ? 'V' : '.');
        sb.append((this.mViewFlags & 16384) != 0 ? 'C' : '.');
        sb.append((this.mViewFlags & 2097152) != 0 ? 'L' : '.');
        sb.append(' ');
        sb.append((this.mPrivateFlags & 8) != 0 ? 'R' : '.');
        sb.append((this.mPrivateFlags & 2) != 0 ? 'F' : '.');
        sb.append((this.mPrivateFlags & 4) != 0 ? 'S' : '.');
        if ((this.mPrivateFlags & 33554432) != 0) {
            sb.append('p');
        } else {
            sb.append((this.mPrivateFlags & 16384) != 0 ? 'P' : '.');
        }
        sb.append((this.mPrivateFlags & 268435456) != 0 ? 'H' : '.');
        sb.append((this.mPrivateFlags & 1073741824) != 0 ? 'A' : '.');
        sb.append((this.mPrivateFlags & Integer.MIN_VALUE) != 0 ? 'I' : '.');
        sb.append((this.mPrivateFlags & PFLAG_DIRTY_MASK) != 0 ? 'D' : '.');
        sb.append(' ');
        sb.append(this.mLeft);
        sb.append(',');
        sb.append(this.mTop);
        sb.append('-');
        sb.append(this.mRight);
        sb.append(',');
        sb.append(this.mBottom);
        int id = getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = this.mResources;
            if (Resources.resourceHasPackage(id) && resources != null) {
                switch ((-16777216) & id) {
                    case 16777216:
                        resourcePackageName = MsgBackupManager.PLATFORM_ANDROID;
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append(BridgeUtil.SPLIT_MARK);
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        resourcePackageName = NavigationRingConstants.ACTION_APP;
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append(BridgeUtil.SPLIT_MARK);
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            resourcePackageName = resources.getResourcePackageName(id);
                            String resourceTypeName22 = resources.getResourceTypeName(id);
                            String resourceEntryName22 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(resourcePackageName);
                            sb.append(":");
                            sb.append(resourceTypeName22);
                            sb.append(BridgeUtil.SPLIT_MARK);
                            sb.append(resourceEntryName22);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
            }
        }
        sb.append(i.d);
        return sb.toString();
    }

    public void transformMatrixToGlobal(Matrix matrix) {
        ViewParent viewParent = this.mParent;
        if (viewParent instanceof View) {
            View view = (View) viewParent;
            view.transformMatrixToGlobal(matrix);
            matrix.preTranslate(-view.mScrollX, -view.mScrollY);
        } else if (viewParent instanceof ViewRootImpl) {
            ViewRootImpl viewRootImpl = (ViewRootImpl) viewParent;
            viewRootImpl.transformMatrixToGlobal(matrix);
            matrix.preTranslate(0.0f, -viewRootImpl.mCurScrollY);
        }
        matrix.preTranslate(this.mLeft, this.mTop);
        if (hasIdentityMatrix()) {
            return;
        }
        matrix.preConcat(getMatrix());
    }

    public void transformMatrixToLocal(Matrix matrix) {
        ViewParent viewParent = this.mParent;
        if (viewParent instanceof View) {
            View view = (View) viewParent;
            view.transformMatrixToLocal(matrix);
            matrix.postTranslate(view.mScrollX, view.mScrollY);
        } else if (viewParent instanceof ViewRootImpl) {
            ViewRootImpl viewRootImpl = (ViewRootImpl) viewParent;
            viewRootImpl.transformMatrixToLocal(matrix);
            matrix.postTranslate(0.0f, viewRootImpl.mCurScrollY);
        }
        matrix.postTranslate(-this.mLeft, -this.mTop);
        if (hasIdentityMatrix()) {
            return;
        }
        matrix.postConcat(getInverseMatrix());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transformRect(Rect rect) {
        if (getMatrix().isIdentity()) {
            return;
        }
        RectF rectF = this.mAttachInfo.mTmpTransformRect;
        rectF.set(rect);
        getMatrix().mapRect(rectF);
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unFocus(View view) {
        clearFocusInternal(view, false, false);
    }

    public void unscheduleDrawable(Drawable drawable) {
        if (this.mAttachInfo == null || drawable == null) {
            return;
        }
        this.mAttachInfo.mViewRootImpl.mChoreographer.removeCallbacks(1, null, drawable);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (!verifyDrawable(drawable) || runnable == null) {
            return;
        }
        if (this.mAttachInfo != null) {
            this.mAttachInfo.mViewRootImpl.mChoreographer.removeCallbacks(1, runnable, drawable);
        }
        ViewRootImpl.getRunQueue().removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean updateLocalSystemUiVisibility(int i, int i2) {
        int i3 = (this.mSystemUiVisibility & (i2 ^ (-1))) | (i & i2);
        if (i3 != this.mSystemUiVisibility) {
            setSystemUiVisibility(i3);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mBackground;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        return (this.mViewFlags & 131072) == 131072;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        return (this.mViewFlags & 128) == 128;
    }
}

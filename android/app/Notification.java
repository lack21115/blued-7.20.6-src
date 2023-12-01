package android.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.MathUtils;
import android.widget.RemoteViews;
import com.android.internal.R;
import com.android.internal.util.NotificationColorUtil;
import com.igexin.push.core.b;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/Notification.class */
public class Notification implements Parcelable {
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ALLOW_DURING_SETUP = "android.allowDuringSetup";
    public static final String EXTRA_AS_HEADS_UP = "headsup";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_FORCE_SHOW_LIGHTS = "android.forceShowLights";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_ORIGINATING_USERID = "android.originatingUserId";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int HEADS_UP_ALLOWED = 1;
    public static final int HEADS_UP_NEVER = 0;
    public static final int HEADS_UP_REQUESTED = 2;
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int SHOW_ALL_NOTI_ON_KEYGUARD = 1;
    public static final int SHOW_NO_ONGOING_NOTI_ON_KEYGUARD = 2;
    @Deprecated
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "Notification";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;
    public Action[] actions;
    public AudioAttributes audioAttributes;
    @Deprecated
    public int audioStreamType;
    public RemoteViews bigContentView;
    public String category;
    public int color;
    public PendingIntent contentIntent;
    public RemoteViews contentView;
    public int defaults;
    public PendingIntent deleteIntent;
    public Bundle extras;
    public int flags;
    public PendingIntent fullScreenIntent;
    public RemoteViews headsUpContentView;
    public int icon;
    public int iconLevel;
    public Bitmap largeIcon;
    public int ledARGB;
    public int ledOffMS;
    public int ledOnMS;
    private String mGroupKey;
    private String mSortKey;
    public int number;
    public int priority;
    public Notification publicVersion;
    public Uri sound;
    public CharSequence tickerText;
    @Deprecated
    public RemoteViews tickerView;
    public long[] vibrate;
    public int visibility;
    public long when;
    public static final AudioAttributes AUDIO_ATTRIBUTES_DEFAULT = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    public static final Parcelable.Creator<Notification> CREATOR = new Parcelable.Creator<Notification>() { // from class: android.app.Notification.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Notification createFromParcel(Parcel parcel) {
            return new Notification(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Notification[] newArray(int i) {
            return new Notification[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Action.class */
    public static class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() { // from class: android.app.Notification.Action.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Action createFromParcel(Parcel parcel) {
                return new Action(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Action[] newArray(int i) {
                return new Action[i];
            }
        };
        public PendingIntent actionIntent;
        public int icon;
        private final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Action$Builder.class */
        public static final class Builder {
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null);
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
                this.mIcon = i;
                this.mTitle = charSequence;
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                if (remoteInputArr != null) {
                    this.mRemoteInputs = new ArrayList<>(remoteInputArr.length);
                    Collections.addAll(this.mRemoteInputs, remoteInputArr);
                }
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs());
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public Action build() {
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, this.mRemoteInputs != null ? (RemoteInput[]) this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]) : null);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Action$Extender.class */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Action$WearableExtender.class */
        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                this.mFlags = 1;
            }

            public WearableExtender(Action action) {
                this.mFlags = 1;
                Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt("flags", 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    this.mFlags |= i;
                } else {
                    this.mFlags &= i ^ (-1);
                }
            }

            /* renamed from: clone */
            public WearableExtender m119clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            @Override // android.app.Notification.Action.Extender
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.mFlags != 1) {
                    bundle.putInt("flags", this.mFlags);
                }
                if (this.mInProgressLabel != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, this.mInProgressLabel);
                }
                if (this.mConfirmLabel != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, this.mConfirmLabel);
                }
                if (this.mCancelLabel != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, this.mCancelLabel);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null);
        }

        private Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
            this.icon = i;
            this.title = charSequence;
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
        }

        private Action(Parcel parcel) {
            this.icon = parcel.readInt();
            this.title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 1) {
                this.actionIntent = PendingIntent.CREATOR.createFromParcel(parcel);
            }
            this.mExtras = parcel.readBundle();
            this.mRemoteInputs = (RemoteInput[]) parcel.createTypedArray(RemoteInput.CREATOR);
        }

        /* renamed from: clone */
        public Action m118clone() {
            return new Action(this.icon, this.title, this.actionIntent, new Bundle(this.mExtras), getRemoteInputs());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.icon);
            TextUtils.writeToParcel(this.title, parcel, i);
            if (this.actionIntent != null) {
                parcel.writeInt(1);
                this.actionIntent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeBundle(this.mExtras);
            parcel.writeTypedArray(this.mRemoteInputs, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$BigPictureStyle.class */
    public static class BigPictureStyle extends Style {
        private Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet = false;
        private Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews makeBigContentView() {
            Bitmap bitmap = null;
            if (this.mBigLargeIconSet) {
                bitmap = this.mBuilder.mLargeIcon;
                this.mBuilder.mLargeIcon = this.mBigLargeIcon;
            }
            RemoteViews standardView = getStandardView(this.mBuilder.getBigPictureLayoutResource());
            if (this.mBigLargeIconSet) {
                this.mBuilder.mLargeIcon = bitmap;
            }
            standardView.setImageViewBitmap(R.id.big_picture, this.mPicture);
            applyTopPadding(standardView);
            this.mBuilder.addProfileBadge(standardView, this.mBuilder.mSubText != null && this.mBuilder.mContentText != null ? 16909128 : 16909131);
            return standardView;
        }

        @Override // android.app.Notification.Style
        public void addExtras(Bundle bundle) {
            super.addExtras(bundle);
            if (this.mBigLargeIconSet) {
                bundle.putParcelable("android.largeIcon.big", this.mBigLargeIcon);
            }
            bundle.putParcelable("android.picture", this.mPicture);
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIconSet = true;
            this.mBigLargeIcon = bitmap;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        @Override // android.app.Notification.Style
        public void populateBigContentView(Notification notification) {
            this.mBuilder.setBuilderBigContentView(notification, makeBigContentView());
        }

        @Override // android.app.Notification.Style
        protected void restoreFromExtras(Bundle bundle) {
            super.restoreFromExtras(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.mBigLargeIconSet = true;
                this.mBigLargeIcon = (Bitmap) bundle.getParcelable("android.largeIcon.big");
            }
            this.mPicture = (Bitmap) bundle.getParcelable("android.picture");
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            internalSetBigContentTitle(Notification.safeCharSequence(charSequence));
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            internalSetSummaryText(Notification.safeCharSequence(charSequence));
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$BigTextStyle.class */
    public static class BigTextStyle extends Style {
        private static final int LINES_CONSUMED_BY_ACTIONS = 3;
        private static final int LINES_CONSUMED_BY_SUMMARY = 2;
        private static final int MAX_LINES = 13;
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        private int calculateMaxLines() {
            int i = 13;
            boolean z = this.mBuilder.mActions.size() > 0;
            boolean z2 = (this.mSummaryTextSet ? this.mSummaryText : this.mBuilder.mSubText) != null;
            if (z) {
                i = 13 - 3;
            }
            int i2 = i;
            if (z2) {
                i2 = i - 2;
            }
            int i3 = i2;
            if (!this.mBuilder.mHasThreeLines) {
                i3 = i2 - 1;
            }
            return i3;
        }

        private RemoteViews makeBigContentView() {
            CharSequence charSequence = this.mBuilder.mContentText;
            this.mBuilder.mContentText = null;
            RemoteViews standardView = getStandardView(this.mBuilder.getBigTextLayoutResource());
            this.mBuilder.mContentText = charSequence;
            standardView.setTextViewText(R.id.big_text, this.mBuilder.processLegacyText(this.mBigText));
            standardView.setViewVisibility(R.id.big_text, 0);
            standardView.setInt(R.id.big_text, "setMaxLines", calculateMaxLines());
            standardView.setViewVisibility(16908309, 8);
            applyTopPadding(standardView);
            this.mBuilder.shrinkLine3Text(standardView);
            this.mBuilder.addProfileBadge(standardView, R.id.profile_badge_large_template);
            return standardView;
        }

        @Override // android.app.Notification.Style
        public void addExtras(Bundle bundle) {
            super.addExtras(bundle);
            bundle.putCharSequence("android.bigText", this.mBigText);
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Notification.safeCharSequence(charSequence);
            return this;
        }

        @Override // android.app.Notification.Style
        public void populateBigContentView(Notification notification) {
            this.mBuilder.setBuilderBigContentView(notification, makeBigContentView());
        }

        @Override // android.app.Notification.Style
        protected void restoreFromExtras(Bundle bundle) {
            super.restoreFromExtras(bundle);
            this.mBigText = bundle.getCharSequence("android.bigText");
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            internalSetBigContentTitle(Notification.safeCharSequence(charSequence));
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            internalSetSummaryText(Notification.safeCharSequence(charSequence));
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Builder.class */
    public static class Builder {
        public static final String EXTRA_NEEDS_REBUILD = "android.rebuild";
        public static final String EXTRA_REBUILD_BIG_CONTENT_VIEW = "android.rebuild.bigView";
        public static final String EXTRA_REBUILD_BIG_CONTENT_VIEW_ACTION_COUNT = "android.rebuild.bigViewActionCount";
        public static final String EXTRA_REBUILD_CONTENT_VIEW = "android.rebuild.contentView";
        public static final String EXTRA_REBUILD_CONTENT_VIEW_ACTION_COUNT = "android.rebuild.contentViewActionCount";
        private static final String EXTRA_REBUILD_CONTEXT_APPLICATION_INFO = "android.rebuild.applicationInfo";
        public static final String EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW = "android.rebuild.hudView";
        public static final String EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW_ACTION_COUNT = "android.rebuild.hudViewActionCount";
        public static final String EXTRA_REBUILD_LARGE_ICON = "android.rebuild.largeIcon";
        private static final float LARGE_TEXT_SCALE = 1.3f;
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final boolean STRIP_AND_REBUILD = true;
        private ArrayList<Action> mActions;
        private AudioAttributes mAudioAttributes;
        private int mAudioStreamType;
        private String mCategory;
        private int mColor;
        private final NotificationColorUtil mColorUtil;
        private CharSequence mContentInfo;
        private PendingIntent mContentIntent;
        private CharSequence mContentText;
        private CharSequence mContentTitle;
        private RemoteViews mContentView;
        private Context mContext;
        private int mDefaults;
        private PendingIntent mDeleteIntent;
        private Bundle mExtras;
        private int mFlags;
        private PendingIntent mFullScreenIntent;
        private String mGroupKey;
        private boolean mHasThreeLines;
        private Bitmap mLargeIcon;
        private int mLedArgb;
        private int mLedOffMs;
        private int mLedOnMs;
        private int mNumber;
        private int mOriginatingUserId;
        private ArrayList<String> mPeople;
        private int mPriority;
        private int mProgress;
        private boolean mProgressIndeterminate;
        private int mProgressMax;
        private Notification mPublicVersion;
        private Bundle mRebuildBundle;
        private Notification mRebuildNotification;
        private boolean mShowWhen;
        private int mSmallIcon;
        private int mSmallIconLevel;
        private String mSortKey;
        private Uri mSound;
        private Style mStyle;
        private CharSequence mSubText;
        private CharSequence mTickerText;
        private RemoteViews mTickerView;
        private boolean mUseChronometer;
        private long[] mVibrate;
        private int mVisibility;
        private long mWhen;

        public Builder(Context context) {
            NotificationColorUtil notificationColorUtil = null;
            this.mActions = new ArrayList<>(3);
            this.mShowWhen = true;
            this.mVisibility = 0;
            this.mPublicVersion = null;
            this.mColor = 0;
            this.mRebuildBundle = new Bundle();
            this.mRebuildNotification = null;
            this.mContext = context;
            this.mWhen = System.currentTimeMillis();
            this.mAudioStreamType = -1;
            this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
            this.mColorUtil = context.getApplicationInfo().targetSdkVersion < 21 ? NotificationColorUtil.getInstance(this.mContext) : notificationColorUtil;
        }

        private Builder(Context context, Notification notification) {
            this(context);
            this.mRebuildNotification = notification;
            restoreFromNotification(notification);
            Style style = null;
            Bundle bundle = notification.extras;
            String string = bundle.getString("android.template");
            if (!TextUtils.isEmpty(string)) {
                Class<? extends Style> notificationStyleClass = getNotificationStyleClass(string);
                if (notificationStyleClass == null) {
                    Log.d(Notification.TAG, "Unknown style class: " + notificationStyleClass);
                    return;
                }
                try {
                    style = notificationStyleClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                    style.restoreFromExtras(bundle);
                } catch (Throwable th) {
                    Log.e(Notification.TAG, "Could not create Style", th);
                    return;
                }
            }
            if (style != null) {
                setStyle(style);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean addProfileBadge(RemoteViews remoteViews, int i) {
            boolean z = false;
            Bitmap profileBadge = getProfileBadge();
            remoteViews.setViewVisibility(R.id.profile_badge_large_template, 8);
            remoteViews.setViewVisibility(R.id.profile_badge_line2, 8);
            remoteViews.setViewVisibility(R.id.profile_badge_line3, 8);
            if (profileBadge != null) {
                remoteViews.setImageViewBitmap(i, profileBadge);
                remoteViews.setViewVisibility(i, 0);
                if (i == 16909131) {
                    remoteViews.setViewVisibility(R.id.line3, 0);
                }
                z = true;
            }
            return z;
        }

        private void applyLargeIconBackground(RemoteViews remoteViews) {
            remoteViews.setInt(16908294, "setBackgroundResource", R.drawable.notification_icon_legacy_bg);
            remoteViews.setDrawableParameters(16908294, true, -1, resolveColor(), PorterDuff.Mode.SRC_ATOP, -1);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_circle_padding);
            remoteViews.setViewPadding(16908294, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }

        private RemoteViews applyStandardTemplate(int i) {
            return applyStandardTemplate(i, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RemoteViews applyStandardTemplate(int i, boolean z) {
            BuilderRemoteViews builderRemoteViews = new BuilderRemoteViews(this.mContext.getApplicationInfo(), i);
            resetStandardTemplate(builderRemoteViews);
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            if (this.mLargeIcon != null) {
                builderRemoteViews.setImageViewBitmap(16908294, this.mLargeIcon);
                processLargeLegacyIcon(this.mLargeIcon, builderRemoteViews);
                builderRemoteViews.setImageViewResource(R.id.right_icon, this.mSmallIcon);
                builderRemoteViews.setViewVisibility(R.id.right_icon, 0);
                processSmallRightIcon(this.mSmallIcon, builderRemoteViews);
            } else {
                builderRemoteViews.setImageViewResource(16908294, this.mSmallIcon);
                builderRemoteViews.setViewVisibility(16908294, 0);
                processSmallIconAsLarge(this.mSmallIcon, builderRemoteViews);
            }
            if (this.mContentTitle != null) {
                builderRemoteViews.setTextViewText(16908310, processLegacyText(this.mContentTitle));
            }
            if (this.mContentText != null) {
                builderRemoteViews.setTextViewText(R.id.text, processLegacyText(this.mContentText));
                z2 = true;
            }
            if (this.mContentInfo != null) {
                builderRemoteViews.setTextViewText(R.id.info, processLegacyText(this.mContentInfo));
                builderRemoteViews.setViewVisibility(R.id.info, 0);
                z2 = true;
            } else if (this.mNumber > 0) {
                if (this.mNumber > this.mContext.getResources().getInteger(17694723)) {
                    builderRemoteViews.setTextViewText(R.id.info, processLegacyText(this.mContext.getResources().getString(17039383)));
                } else {
                    builderRemoteViews.setTextViewText(R.id.info, processLegacyText(NumberFormat.getIntegerInstance().format(this.mNumber)));
                }
                builderRemoteViews.setViewVisibility(R.id.info, 0);
                z2 = true;
            } else {
                builderRemoteViews.setViewVisibility(R.id.info, 8);
            }
            if (this.mSubText != null) {
                builderRemoteViews.setTextViewText(R.id.text, processLegacyText(this.mSubText));
                if (this.mContentText != null) {
                    builderRemoteViews.setTextViewText(16908309, processLegacyText(this.mContentText));
                    builderRemoteViews.setViewVisibility(16908309, 0);
                    z3 = true;
                    z4 = true;
                } else {
                    builderRemoteViews.setViewVisibility(16908309, 8);
                }
            } else {
                builderRemoteViews.setViewVisibility(16908309, 8);
                if (!z || (this.mProgressMax == 0 && !this.mProgressIndeterminate)) {
                    builderRemoteViews.setViewVisibility(16908301, 8);
                } else {
                    builderRemoteViews.setViewVisibility(16908301, 0);
                    builderRemoteViews.setProgressBar(16908301, this.mProgressMax, this.mProgress, this.mProgressIndeterminate);
                    builderRemoteViews.setProgressBackgroundTintList(16908301, ColorStateList.valueOf(this.mContext.getResources().getColor(R.color.notification_progress_background_color)));
                    if (this.mColor != 0) {
                        ColorStateList valueOf = ColorStateList.valueOf(this.mColor);
                        builderRemoteViews.setProgressTintList(16908301, valueOf);
                        builderRemoteViews.setProgressIndeterminateTintList(16908301, valueOf);
                    }
                    z3 = true;
                }
            }
            if (z3) {
                shrinkLine3Text(builderRemoteViews);
            }
            if (showsTimeOrChronometer()) {
                if (this.mUseChronometer) {
                    builderRemoteViews.setViewVisibility(R.id.chronometer, 0);
                    builderRemoteViews.setLong(R.id.chronometer, "setBase", this.mWhen + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                    builderRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                } else {
                    builderRemoteViews.setViewVisibility(R.id.time, 0);
                    builderRemoteViews.setLong(R.id.time, "setTime", this.mWhen);
                }
            }
            builderRemoteViews.setViewPadding(R.id.line1, 0, calculateTopPadding(this.mContext, this.mHasThreeLines, this.mContext.getResources().getConfiguration().fontScale), 0, 0);
            boolean z5 = z2;
            if (addProfileBadge(builderRemoteViews, z4 ? 16909128 : 16909131)) {
                z5 = z2;
                if (!z4) {
                    z5 = true;
                }
            }
            builderRemoteViews.setViewVisibility(R.id.line3, z5 ? 0 : 8);
            builderRemoteViews.setViewVisibility(R.id.overflow_divider, z5 ? 0 : 8);
            return builderRemoteViews;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RemoteViews applyStandardTemplateWithActions(int i) {
            RemoteViews applyStandardTemplate = applyStandardTemplate(i);
            resetStandardTemplateWithActions(applyStandardTemplate);
            int size = this.mActions.size();
            if (size > 0) {
                applyStandardTemplate.setViewVisibility(R.id.actions, 0);
                applyStandardTemplate.setViewVisibility(R.id.action_divider, 0);
                int i2 = size;
                if (size > 3) {
                    i2 = 3;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= i2) {
                        break;
                    }
                    applyStandardTemplate.addView(R.id.actions, generateActionButton(this.mActions.get(i4)));
                    i3 = i4 + 1;
                }
            }
            return applyStandardTemplate;
        }

        public static int calculateTopPadding(Context context, boolean z, float f) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(z ? 17104984 : 17104983);
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(z ? 17104986 : 17104985);
            float constrain = (MathUtils.constrain(f, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - constrain) * dimensionPixelSize) + (dimensionPixelSize2 * constrain));
        }

        private RemoteViews generateActionButton(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), z ? getActionTombstoneLayoutResource() : getActionLayoutResource());
            remoteViews.setTextViewCompoundDrawablesRelative(R.id.action0, action.icon, 0, 0, 0);
            remoteViews.setTextViewText(R.id.action0, processLegacyText(action.title));
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, action.actionIntent);
            }
            remoteViews.setContentDescription(R.id.action0, action.title);
            processLegacyAction(action, remoteViews);
            return remoteViews;
        }

        private int getActionLayoutResource() {
            return R.layout.notification_material_action;
        }

        private int getActionTombstoneLayoutResource() {
            return R.layout.notification_material_action_tombstone;
        }

        private int getBaseLayoutResource() {
            return R.layout.notification_template_material_base;
        }

        private int getBigBaseLayoutResource() {
            return R.layout.notification_template_material_big_base;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getBigPictureLayoutResource() {
            return R.layout.notification_template_material_big_picture;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getBigTextLayoutResource() {
            return R.layout.notification_template_material_big_text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getInboxLayoutResource() {
            return R.layout.notification_template_material_inbox;
        }

        private static Class<? extends Style> getNotificationStyleClass(String str) {
            Class<? extends Style>[] clsArr = {BigTextStyle.class, BigPictureStyle.class, InboxStyle.class, MediaStyle.class};
            int length = clsArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                Class<? extends Style> cls = clsArr[i2];
                if (str.equals(cls.getName())) {
                    return cls;
                }
                i = i2 + 1;
            }
        }

        private Bitmap getProfileBadge() {
            Drawable profileBadgeDrawable = getProfileBadgeDrawable();
            if (profileBadgeDrawable == null) {
                return null;
            }
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.notification_badge_size);
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            profileBadgeDrawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            profileBadgeDrawable.draw(canvas);
            return createBitmap;
        }

        private Drawable getProfileBadgeDrawable() {
            return this.mContext.getPackageManager().getUserBadgeForDensity(new UserHandle(this.mOriginatingUserId), 0);
        }

        private boolean hasThreeLines() {
            boolean z = (this.mSubText == null || this.mContentText == null) ? false : true;
            return ((this.mSubText != null && this.mContentText != null) || ((this.mStyle == null || this.mStyle.hasProgress()) && this.mSubText == null && (this.mProgressMax != 0 || this.mProgressIndeterminate))) && (this.mContentText != null || this.mContentInfo != null || this.mNumber > 0 || (getProfileBadgeDrawable() != null && !z));
        }

        private boolean isLegacy() {
            return this.mColorUtil != null;
        }

        private RemoteViews makeBigContentView() {
            if (this.mActions.size() == 0) {
                return null;
            }
            return applyStandardTemplateWithActions(getBigBaseLayoutResource());
        }

        private RemoteViews makeContentView() {
            return this.mContentView != null ? this.mContentView : applyStandardTemplate(getBaseLayoutResource());
        }

        private RemoteViews makeHeadsUpContentView() {
            if (this.mActions.size() == 0) {
                return null;
            }
            return applyStandardTemplateWithActions(getBigBaseLayoutResource());
        }

        private RemoteViews makeTickerView() {
            if (this.mTickerView != null) {
                return this.mTickerView;
            }
            return null;
        }

        private void processLargeLegacyIcon(Bitmap bitmap, RemoteViews remoteViews) {
            if (isLegacy() && this.mColorUtil.isGrayscaleIcon(bitmap)) {
                applyLargeIconBackground(remoteViews);
            } else {
                removeLargeIconBackground(remoteViews);
            }
        }

        private void processLegacyAction(Action action, RemoteViews remoteViews) {
            if (!isLegacy() || this.mColorUtil.isGrayscaleIcon(this.mContext, action.icon)) {
                remoteViews.setTextViewCompoundDrawablesRelativeColorFilter(R.id.action0, 0, this.mContext.getResources().getColor(R.color.notification_action_color_filter), PorterDuff.Mode.MULTIPLY);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence processLegacyText(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            if (isLegacy()) {
                charSequence2 = this.mColorUtil.invertCharSequenceColors(charSequence);
            }
            return charSequence2;
        }

        private void processSmallIconAsLarge(int i, RemoteViews remoteViews) {
            if (!isLegacy()) {
                remoteViews.setDrawableParameters(16908294, false, -1, -1, PorterDuff.Mode.SRC_ATOP, -1);
            }
            if (!isLegacy() || this.mColorUtil.isGrayscaleIcon(this.mContext, i)) {
                applyLargeIconBackground(remoteViews);
            }
        }

        private void processSmallRightIcon(int i, RemoteViews remoteViews) {
            if (!isLegacy()) {
                remoteViews.setDrawableParameters(R.id.right_icon, false, -1, -1, PorterDuff.Mode.SRC_ATOP, -1);
            }
            if (!isLegacy() || this.mColorUtil.isGrayscaleIcon(this.mContext, i)) {
                remoteViews.setInt(R.id.right_icon, "setBackgroundResource", R.drawable.notification_icon_legacy_bg);
                remoteViews.setDrawableParameters(R.id.right_icon, true, -1, resolveColor(), PorterDuff.Mode.SRC_ATOP, -1);
            }
        }

        private Notification rebuild() {
            if (this.mRebuildNotification == null) {
                throw new IllegalStateException("rebuild() only valid when in 'rebuild' mode.");
            }
            this.mHasThreeLines = hasThreeLines();
            Bundle bundle = this.mRebuildNotification.extras;
            if (bundle.getBoolean(EXTRA_REBUILD_LARGE_ICON)) {
                this.mRebuildNotification.largeIcon = (Bitmap) bundle.getParcelable("android.largeIcon");
            }
            bundle.remove(EXTRA_REBUILD_LARGE_ICON);
            if (bundle.getBoolean(EXTRA_REBUILD_CONTENT_VIEW)) {
                setBuilderContentView(this.mRebuildNotification, makeContentView());
                if (this.mStyle != null) {
                    this.mStyle.populateContentView(this.mRebuildNotification);
                }
            }
            bundle.remove(EXTRA_REBUILD_CONTENT_VIEW);
            if (bundle.getBoolean(EXTRA_REBUILD_BIG_CONTENT_VIEW)) {
                setBuilderBigContentView(this.mRebuildNotification, makeBigContentView());
                if (this.mStyle != null) {
                    this.mStyle.populateBigContentView(this.mRebuildNotification);
                }
            }
            bundle.remove(EXTRA_REBUILD_BIG_CONTENT_VIEW);
            if (bundle.getBoolean(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW)) {
                setBuilderHeadsUpContentView(this.mRebuildNotification, makeHeadsUpContentView());
                if (this.mStyle != null) {
                    this.mStyle.populateHeadsUpContentView(this.mRebuildNotification);
                }
            }
            bundle.remove(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW);
            this.mHasThreeLines = false;
            return this.mRebuildNotification;
        }

        public static Notification rebuild(Context context, Notification notification) {
            Bundle bundle = notification.extras;
            if (bundle.getBoolean(EXTRA_NEEDS_REBUILD)) {
                bundle.remove(EXTRA_NEEDS_REBUILD);
                ApplicationInfo applicationInfo = (ApplicationInfo) bundle.getParcelable(EXTRA_REBUILD_CONTEXT_APPLICATION_INFO);
                try {
                    context = context.createApplicationContext(applicationInfo, 4);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(Notification.TAG, "ApplicationInfo " + applicationInfo + " not found");
                }
                return new Builder(context, notification).rebuild();
            }
            return notification;
        }

        private void removeLargeIconBackground(RemoteViews remoteViews) {
            remoteViews.setInt(16908294, "setBackgroundResource", 0);
        }

        private void resetStandardTemplate(RemoteViews remoteViews) {
            removeLargeIconBackground(remoteViews);
            remoteViews.setViewPadding(16908294, 0, 0, 0, 0);
            remoteViews.setImageViewResource(16908294, 0);
            remoteViews.setInt(16908294, "setBackgroundResource", 0);
            remoteViews.setViewVisibility(R.id.right_icon, 8);
            remoteViews.setInt(R.id.right_icon, "setBackgroundResource", 0);
            remoteViews.setImageViewResource(R.id.right_icon, 0);
            remoteViews.setImageViewResource(16908294, 0);
            remoteViews.setTextViewText(16908310, null);
            remoteViews.setTextViewText(R.id.text, null);
            unshrinkLine3Text(remoteViews);
            remoteViews.setTextViewText(16908309, null);
            remoteViews.setViewVisibility(16908309, 8);
            remoteViews.setViewVisibility(R.id.info, 8);
            remoteViews.setViewVisibility(R.id.time, 8);
            remoteViews.setViewVisibility(R.id.line3, 8);
            remoteViews.setViewVisibility(R.id.overflow_divider, 8);
            remoteViews.setViewVisibility(16908301, 8);
            remoteViews.setViewVisibility(R.id.chronometer, 8);
            remoteViews.setViewVisibility(R.id.time, 8);
        }

        private void resetStandardTemplateWithActions(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.actions, 8);
            remoteViews.setViewVisibility(R.id.action_divider, 8);
            remoteViews.removeAllViews(R.id.actions);
        }

        private int resolveColor() {
            return this.mColor == 0 ? this.mContext.getResources().getColor(R.color.notification_icon_bg_color) : this.mColor;
        }

        private void restoreFromNotification(Notification notification) {
            this.mWhen = notification.when;
            this.mSmallIcon = notification.icon;
            this.mSmallIconLevel = notification.iconLevel;
            this.mNumber = notification.number;
            this.mColor = notification.color;
            this.mContentView = notification.contentView;
            this.mDeleteIntent = notification.deleteIntent;
            this.mFullScreenIntent = notification.fullScreenIntent;
            this.mTickerText = notification.tickerText;
            this.mTickerView = notification.tickerView;
            this.mLargeIcon = notification.largeIcon;
            this.mSound = notification.sound;
            this.mAudioStreamType = notification.audioStreamType;
            this.mAudioAttributes = notification.audioAttributes;
            this.mVibrate = notification.vibrate;
            this.mLedArgb = notification.ledARGB;
            this.mLedOnMs = notification.ledOnMS;
            this.mLedOffMs = notification.ledOffMS;
            this.mDefaults = notification.defaults;
            this.mFlags = notification.flags;
            this.mCategory = notification.category;
            this.mGroupKey = notification.mGroupKey;
            this.mSortKey = notification.mSortKey;
            this.mPriority = notification.priority;
            this.mActions.clear();
            if (notification.actions != null) {
                Collections.addAll(this.mActions, notification.actions);
            }
            this.mVisibility = notification.visibility;
            this.mPublicVersion = notification.publicVersion;
            Bundle bundle = notification.extras;
            this.mOriginatingUserId = bundle.getInt(Notification.EXTRA_ORIGINATING_USERID);
            this.mContentTitle = bundle.getCharSequence("android.title");
            this.mContentText = bundle.getCharSequence("android.text");
            this.mSubText = bundle.getCharSequence("android.subText");
            this.mContentInfo = bundle.getCharSequence("android.infoText");
            this.mSmallIcon = bundle.getInt("android.icon");
            this.mProgress = bundle.getInt("android.progress");
            this.mProgressMax = bundle.getInt("android.progressMax");
            this.mProgressIndeterminate = bundle.getBoolean("android.progressIndeterminate");
            this.mUseChronometer = bundle.getBoolean("android.showChronometer");
            this.mShowWhen = bundle.getBoolean("android.showWhen");
            if (bundle.containsKey("android.largeIcon")) {
                this.mLargeIcon = (Bitmap) bundle.getParcelable("android.largeIcon");
            }
            if (bundle.containsKey("android.people")) {
                this.mPeople.clear();
                Collections.addAll(this.mPeople, bundle.getStringArray("android.people"));
            }
        }

        private int sanitizeColor() {
            if (this.mColor != 0) {
                this.mColor |= -16777216;
            }
            return this.mColor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBuilderBigContentView(Notification notification, RemoteViews remoteViews) {
            notification.bigContentView = remoteViews;
            if (remoteViews instanceof BuilderRemoteViews) {
                this.mRebuildBundle.putInt(EXTRA_REBUILD_BIG_CONTENT_VIEW_ACTION_COUNT, remoteViews.getSequenceNumber());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBuilderContentView(Notification notification, RemoteViews remoteViews) {
            notification.contentView = remoteViews;
            if (remoteViews instanceof BuilderRemoteViews) {
                this.mRebuildBundle.putInt(EXTRA_REBUILD_CONTENT_VIEW_ACTION_COUNT, remoteViews.getSequenceNumber());
            }
        }

        private void setBuilderHeadsUpContentView(Notification notification, RemoteViews remoteViews) {
            notification.headsUpContentView = remoteViews;
            if (remoteViews instanceof BuilderRemoteViews) {
                this.mRebuildBundle.putInt(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW_ACTION_COUNT, remoteViews.getSequenceNumber());
            }
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags |= i;
            } else {
                this.mFlags &= i ^ (-1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean showsTimeOrChronometer() {
            return this.mWhen != 0 && this.mShowWhen;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void shrinkLine3Text(RemoteViews remoteViews) {
            remoteViews.setTextViewTextSize(R.id.text, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.notification_subtext_size));
        }

        public static void stripForDelivery(Notification notification) {
            String string = notification.extras.getString("android.template");
            boolean z = TextUtils.isEmpty(string) || getNotificationStyleClass(string) != null;
            boolean z2 = false;
            if (notification.largeIcon != null) {
                z2 = false;
                if (notification.extras.containsKey("android.largeIcon")) {
                    notification.largeIcon = null;
                    notification.extras.putBoolean(EXTRA_REBUILD_LARGE_ICON, true);
                    z2 = true;
                }
            }
            boolean z3 = z2;
            if (z) {
                z3 = z2;
                if (notification.contentView instanceof BuilderRemoteViews) {
                    z3 = z2;
                    if (notification.extras.getInt(EXTRA_REBUILD_CONTENT_VIEW_ACTION_COUNT, -1) == notification.contentView.getSequenceNumber()) {
                        notification.contentView = null;
                        notification.extras.putBoolean(EXTRA_REBUILD_CONTENT_VIEW, true);
                        notification.extras.remove(EXTRA_REBUILD_CONTENT_VIEW_ACTION_COUNT);
                        z3 = true;
                    }
                }
            }
            boolean z4 = z3;
            if (z) {
                z4 = z3;
                if (notification.bigContentView instanceof BuilderRemoteViews) {
                    z4 = z3;
                    if (notification.extras.getInt(EXTRA_REBUILD_BIG_CONTENT_VIEW_ACTION_COUNT, -1) == notification.bigContentView.getSequenceNumber()) {
                        notification.bigContentView = null;
                        notification.extras.putBoolean(EXTRA_REBUILD_BIG_CONTENT_VIEW, true);
                        notification.extras.remove(EXTRA_REBUILD_BIG_CONTENT_VIEW_ACTION_COUNT);
                        z4 = true;
                    }
                }
            }
            boolean z5 = z4;
            if (z) {
                z5 = z4;
                if (notification.headsUpContentView instanceof BuilderRemoteViews) {
                    z5 = z4;
                    if (notification.extras.getInt(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW_ACTION_COUNT, -1) == notification.headsUpContentView.getSequenceNumber()) {
                        notification.headsUpContentView = null;
                        notification.extras.putBoolean(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW, true);
                        notification.extras.remove(EXTRA_REBUILD_HEADS_UP_CONTENT_VIEW_ACTION_COUNT);
                        z5 = true;
                    }
                }
            }
            if (z5) {
                notification.extras.putBoolean(EXTRA_NEEDS_REBUILD, true);
            }
        }

        private void unshrinkLine3Text(RemoteViews remoteViews) {
            remoteViews.setTextViewTextSize(R.id.text, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.notification_text_size));
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, Notification.safeCharSequence(charSequence), pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                if (this.mExtras != null) {
                    this.mExtras.putAll(bundle);
                    return this;
                }
                this.mExtras = new Bundle(bundle);
            }
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            this.mOriginatingUserId = this.mContext.getUserId();
            this.mHasThreeLines = hasThreeLines();
            Notification buildUnstyled = buildUnstyled();
            Notification notification = buildUnstyled;
            if (this.mStyle != null) {
                notification = this.mStyle.buildStyled(buildUnstyled);
            }
            if (this.mExtras != null) {
                notification.extras.putAll(this.mExtras);
            }
            if (this.mRebuildBundle.size() > 0) {
                notification.extras.putAll(this.mRebuildBundle);
                this.mRebuildBundle.clear();
            }
            populateExtras(notification.extras);
            if (this.mStyle != null) {
                this.mStyle.addExtras(notification.extras);
            }
            this.mHasThreeLines = false;
            return notification;
        }

        public Notification buildInto(Notification notification) {
            build().cloneInto(notification, true);
            return notification;
        }

        public Notification buildUnstyled() {
            Notification notification = new Notification();
            notification.when = this.mWhen;
            notification.icon = this.mSmallIcon;
            notification.iconLevel = this.mSmallIconLevel;
            notification.number = this.mNumber;
            notification.color = sanitizeColor();
            setBuilderContentView(notification, makeContentView());
            notification.contentIntent = this.mContentIntent;
            notification.deleteIntent = this.mDeleteIntent;
            notification.fullScreenIntent = this.mFullScreenIntent;
            notification.tickerText = this.mTickerText;
            notification.tickerView = makeTickerView();
            notification.largeIcon = this.mLargeIcon;
            notification.sound = this.mSound;
            notification.audioStreamType = this.mAudioStreamType;
            notification.audioAttributes = this.mAudioAttributes;
            notification.vibrate = this.mVibrate;
            notification.ledARGB = this.mLedArgb;
            notification.ledOnMS = this.mLedOnMs;
            notification.ledOffMS = this.mLedOffMs;
            notification.defaults = this.mDefaults;
            notification.flags = this.mFlags;
            setBuilderBigContentView(notification, makeBigContentView());
            setBuilderHeadsUpContentView(notification, makeHeadsUpContentView());
            if (this.mLedOnMs != 0 || this.mLedOffMs != 0) {
                notification.flags |= 1;
            }
            if ((this.mDefaults & 4) != 0) {
                notification.flags |= 1;
            }
            notification.category = this.mCategory;
            notification.mGroupKey = this.mGroupKey;
            notification.mSortKey = this.mSortKey;
            notification.priority = this.mPriority;
            if (this.mActions.size() > 0) {
                notification.actions = new Action[this.mActions.size()];
                this.mActions.toArray(notification.actions);
            }
            notification.visibility = this.mVisibility;
            if (this.mPublicVersion != null) {
                notification.publicVersion = new Notification();
                this.mPublicVersion.cloneInto(notification.publicVersion, true);
            }
            return notification;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public void populateExtras(Bundle bundle) {
            bundle.putInt(Notification.EXTRA_ORIGINATING_USERID, this.mOriginatingUserId);
            bundle.putParcelable(EXTRA_REBUILD_CONTEXT_APPLICATION_INFO, this.mContext.getApplicationInfo());
            bundle.putCharSequence("android.title", this.mContentTitle);
            bundle.putCharSequence("android.text", this.mContentText);
            bundle.putCharSequence("android.subText", this.mSubText);
            bundle.putCharSequence("android.infoText", this.mContentInfo);
            bundle.putInt("android.icon", this.mSmallIcon);
            bundle.putInt("android.progress", this.mProgress);
            bundle.putInt("android.progressMax", this.mProgressMax);
            bundle.putBoolean("android.progressIndeterminate", this.mProgressIndeterminate);
            bundle.putBoolean("android.showChronometer", this.mUseChronometer);
            bundle.putBoolean("android.showWhen", this.mShowWhen);
            if (this.mLargeIcon != null) {
                bundle.putParcelable("android.largeIcon", this.mLargeIcon);
            }
            if (this.mPeople.isEmpty()) {
                return;
            }
            bundle.putStringArray("android.people", (String[]) this.mPeople.toArray(new String[this.mPeople.size()]));
        }

        public Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setColor(int i) {
            this.mColor = i;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = Notification.safeCharSequence(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = Notification.safeCharSequence(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = Notification.safeCharSequence(charSequence);
            return this;
        }

        public Builder setDefaults(int i) {
            this.mDefaults = i;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mDeleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.mGroupKey = str;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            setFlag(512, z);
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(int i, int i2, int i3) {
            this.mLedArgb = i;
            this.mLedOnMs = i2;
            this.mLedOffMs = i3;
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            setFlag(256, z);
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mSmallIcon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            this.mSmallIcon = i;
            this.mSmallIconLevel = i2;
            return this;
        }

        public Builder setSortKey(String str) {
            this.mSortKey = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.mSound = uri;
            this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
            return this;
        }

        @Deprecated
        public Builder setSound(Uri uri, int i) {
            this.mSound = uri;
            this.mAudioStreamType = i;
            return this;
        }

        public Builder setSound(Uri uri, AudioAttributes audioAttributes) {
            this.mSound = uri;
            this.mAudioAttributes = audioAttributes;
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = Notification.safeCharSequence(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mTickerText = Notification.safeCharSequence(charSequence);
            return this;
        }

        @Deprecated
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mTickerText = Notification.safeCharSequence(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mVibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.mWhen = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$BuilderRemoteViews.class */
    public static class BuilderRemoteViews extends RemoteViews {
        public BuilderRemoteViews(ApplicationInfo applicationInfo, int i) {
            super(applicationInfo, i);
        }

        public BuilderRemoteViews(Parcel parcel) {
            super(parcel);
        }

        @Override // android.widget.RemoteViews
        /* renamed from: clone */
        public BuilderRemoteViews mo120clone() {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            BuilderRemoteViews builderRemoteViews = new BuilderRemoteViews(obtain);
            obtain.recycle();
            return builderRemoteViews;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Extender.class */
    public interface Extender {
        Builder extend(Builder builder);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$InboxStyle.class */
    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> mTexts = new ArrayList<>(5);

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews makeBigContentView() {
            CharSequence charSequence = this.mBuilder.mContentText;
            this.mBuilder.mContentText = null;
            RemoteViews standardView = getStandardView(this.mBuilder.getInboxLayoutResource());
            this.mBuilder.mContentText = charSequence;
            standardView.setViewVisibility(16908309, 8);
            int[] iArr = {R.id.inbox_text0, R.id.inbox_text1, R.id.inbox_text2, R.id.inbox_text3, R.id.inbox_text4, R.id.inbox_text5, R.id.inbox_text6};
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                standardView.setViewVisibility(iArr[i2], 8);
                i = i2 + 1;
            }
            boolean z = this.mBuilder.mContext.getResources().getConfiguration().fontScale > 1.0f;
            float dimensionPixelSize = this.mBuilder.mContext.getResources().getDimensionPixelSize(R.dimen.notification_subtext_size);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mTexts.size() || i4 >= iArr.length) {
                    break;
                }
                CharSequence charSequence2 = this.mTexts.get(i4);
                if (charSequence2 != null && !charSequence2.equals("")) {
                    standardView.setViewVisibility(iArr[i4], 0);
                    standardView.setTextViewText(iArr[i4], this.mBuilder.processLegacyText(charSequence2));
                    if (z) {
                        standardView.setTextViewTextSize(iArr[i4], 0, dimensionPixelSize);
                    }
                }
                i3 = i4 + 1;
            }
            standardView.setViewVisibility(R.id.inbox_end_pad, this.mTexts.size() > 0 ? 0 : 8);
            standardView.setViewVisibility(R.id.inbox_more, this.mTexts.size() > iArr.length ? 0 : 8);
            applyTopPadding(standardView);
            this.mBuilder.shrinkLine3Text(standardView);
            this.mBuilder.addProfileBadge(standardView, R.id.profile_badge_large_template);
            return standardView;
        }

        @Override // android.app.Notification.Style
        public void addExtras(Bundle bundle) {
            super.addExtras(bundle);
            bundle.putCharSequenceArray("android.textLines", (CharSequence[]) this.mTexts.toArray(new CharSequence[this.mTexts.size()]));
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.mTexts.add(Notification.safeCharSequence(charSequence));
            return this;
        }

        @Override // android.app.Notification.Style
        public void populateBigContentView(Notification notification) {
            this.mBuilder.setBuilderBigContentView(notification, makeBigContentView());
        }

        @Override // android.app.Notification.Style
        protected void restoreFromExtras(Bundle bundle) {
            super.restoreFromExtras(bundle);
            this.mTexts.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.mTexts, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            internalSetBigContentTitle(Notification.safeCharSequence(charSequence));
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            internalSetSummaryText(Notification.safeCharSequence(charSequence));
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$MediaStyle.class */
    public static class MediaStyle extends Style {
        static final int MAX_MEDIA_BUTTONS = 5;
        static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        private int[] mActionsToShowInCompact = null;
        private MediaSession.Token mToken;

        public MediaStyle() {
        }

        public MediaStyle(Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews generateMediaActionButton(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), (int) R.layout.notification_material_media_action);
            remoteViews.setImageViewResource(R.id.action0, action.icon);
            remoteViews.setDrawableParameters(R.id.action0, false, -1, -1, PorterDuff.Mode.SRC_ATOP, -1);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, action.actionIntent);
            }
            remoteViews.setContentDescription(R.id.action0, action.title);
            return remoteViews;
        }

        private int getBigLayoutResource(int i) {
            return i <= 3 ? R.layout.notification_template_material_big_media_narrow : R.layout.notification_template_material_big_media;
        }

        private void hideRightIcon(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.right_icon, 8);
        }

        private RemoteViews makeMediaBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = this.mBuilder.applyStandardTemplate(getBigLayoutResource(min), false);
            if (min > 0) {
                applyStandardTemplate.removeAllViews(R.id.media_actions);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= min) {
                        break;
                    }
                    applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton((Action) this.mBuilder.mActions.get(i2)));
                    i = i2 + 1;
                }
            }
            styleText(applyStandardTemplate);
            hideRightIcon(applyStandardTemplate);
            applyTopPadding(applyStandardTemplate);
            applyStandardTemplate.setViewVisibility(16908301, 8);
            return applyStandardTemplate;
        }

        private RemoteViews makeMediaContentView() {
            RemoteViews applyStandardTemplate = this.mBuilder.applyStandardTemplate(R.layout.notification_template_material_media, false);
            int size = this.mBuilder.mActions.size();
            int min = this.mActionsToShowInCompact == null ? 0 : Math.min(this.mActionsToShowInCompact.length, 3);
            if (min > 0) {
                applyStandardTemplate.removeAllViews(R.id.media_actions);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= min) {
                        break;
                    } else if (i2 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    } else {
                        applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton((Action) this.mBuilder.mActions.get(this.mActionsToShowInCompact[i2])));
                        i = i2 + 1;
                    }
                }
            }
            styleText(applyStandardTemplate);
            hideRightIcon(applyStandardTemplate);
            return applyStandardTemplate;
        }

        private void styleText(RemoteViews remoteViews) {
            int color = this.mBuilder.mContext.getResources().getColor(R.color.notification_media_primary_color);
            int color2 = this.mBuilder.mContext.getResources().getColor(R.color.notification_media_secondary_color);
            remoteViews.setTextColor(16908310, color);
            if (this.mBuilder.showsTimeOrChronometer()) {
                if (this.mBuilder.mUseChronometer) {
                    remoteViews.setTextColor(R.id.chronometer, color2);
                } else {
                    remoteViews.setTextColor(R.id.time, color2);
                }
            }
            remoteViews.setTextColor(16908309, color2);
            remoteViews.setTextColor(R.id.text, color2);
            remoteViews.setTextColor(R.id.info, color2);
        }

        @Override // android.app.Notification.Style
        public void addExtras(Bundle bundle) {
            super.addExtras(bundle);
            if (this.mToken != null) {
                bundle.putParcelable("android.mediaSession", this.mToken);
            }
            if (this.mActionsToShowInCompact != null) {
                bundle.putIntArray("android.compactActions", this.mActionsToShowInCompact);
            }
        }

        @Override // android.app.Notification.Style
        public Notification buildStyled(Notification notification) {
            super.buildStyled(notification);
            if (notification.category == null) {
                notification.category = "transport";
            }
            return notification;
        }

        @Override // android.app.Notification.Style
        protected boolean hasProgress() {
            return false;
        }

        @Override // android.app.Notification.Style
        public void populateBigContentView(Notification notification) {
            this.mBuilder.setBuilderBigContentView(notification, makeMediaBigContentView());
        }

        @Override // android.app.Notification.Style
        public void populateContentView(Notification notification) {
            this.mBuilder.setBuilderContentView(notification, makeMediaContentView());
        }

        @Override // android.app.Notification.Style
        protected void restoreFromExtras(Bundle bundle) {
            super.restoreFromExtras(bundle);
            if (bundle.containsKey("android.mediaSession")) {
                this.mToken = (MediaSession.Token) bundle.getParcelable("android.mediaSession");
            }
            if (bundle.containsKey("android.compactActions")) {
                this.mActionsToShowInCompact = bundle.getIntArray("android.compactActions");
            }
        }

        public MediaStyle setMediaSession(MediaSession.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$Style.class */
    public static abstract class Style {
        private CharSequence mBigContentTitle;
        protected Builder mBuilder;
        protected CharSequence mSummaryText = null;
        protected boolean mSummaryTextSet = false;

        public void addExtras(Bundle bundle) {
            if (this.mSummaryTextSet) {
                bundle.putCharSequence("android.summaryText", this.mSummaryText);
            }
            if (this.mBigContentTitle != null) {
                bundle.putCharSequence("android.title.big", this.mBigContentTitle);
            }
            bundle.putString("android.template", getClass().getName());
        }

        protected void applyTopPadding(RemoteViews remoteViews) {
            remoteViews.setViewPadding(R.id.line1, 0, Builder.calculateTopPadding(this.mBuilder.mContext, this.mBuilder.mHasThreeLines, this.mBuilder.mContext.getResources().getConfiguration().fontScale), 0, 0);
        }

        public Notification build() {
            checkBuilder();
            return this.mBuilder.build();
        }

        public Notification buildStyled(Notification notification) {
            populateTickerView(notification);
            populateContentView(notification);
            populateBigContentView(notification);
            populateHeadsUpContentView(notification);
            return notification;
        }

        protected void checkBuilder() {
            if (this.mBuilder == null) {
                throw new IllegalArgumentException("Style requires a valid Builder object");
            }
        }

        protected RemoteViews getStandardView(int i) {
            checkBuilder();
            CharSequence charSequence = this.mBuilder.mContentTitle;
            if (this.mBigContentTitle != null) {
                this.mBuilder.setContentTitle(this.mBigContentTitle);
            }
            RemoteViews applyStandardTemplateWithActions = this.mBuilder.applyStandardTemplateWithActions(i);
            this.mBuilder.mContentTitle = charSequence;
            if (this.mBigContentTitle == null || !this.mBigContentTitle.equals("")) {
                applyStandardTemplateWithActions.setViewVisibility(R.id.line1, 0);
            } else {
                applyStandardTemplateWithActions.setViewVisibility(R.id.line1, 8);
            }
            CharSequence charSequence2 = this.mSummaryTextSet ? this.mSummaryText : this.mBuilder.mSubText;
            if (charSequence2 != null) {
                applyStandardTemplateWithActions.setTextViewText(R.id.text, this.mBuilder.processLegacyText(charSequence2));
                applyStandardTemplateWithActions.setViewVisibility(R.id.overflow_divider, 0);
                applyStandardTemplateWithActions.setViewVisibility(R.id.line3, 0);
                return applyStandardTemplateWithActions;
            }
            applyStandardTemplateWithActions.setTextViewText(R.id.text, "");
            applyStandardTemplateWithActions.setViewVisibility(R.id.overflow_divider, 8);
            applyStandardTemplateWithActions.setViewVisibility(R.id.line3, 8);
            return applyStandardTemplateWithActions;
        }

        protected boolean hasProgress() {
            return true;
        }

        protected void internalSetBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = charSequence;
        }

        protected void internalSetSummaryText(CharSequence charSequence) {
            this.mSummaryText = charSequence;
            this.mSummaryTextSet = true;
        }

        protected void populateBigContentView(Notification notification) {
        }

        protected void populateContentView(Notification notification) {
        }

        protected void populateHeadsUpContentView(Notification notification) {
        }

        protected void populateTickerView(Notification notification) {
        }

        protected void restoreFromExtras(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.mSummaryText = bundle.getCharSequence("android.summaryText");
                this.mSummaryTextSet = true;
            }
            if (bundle.containsKey("android.title.big")) {
                this.mBigContentTitle = bundle.getCharSequence("android.title.big");
            }
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/Notification$WearableExtender.class */
    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(Notification notification) {
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle bundle = notification.extras.getBundle(EXTRA_WEARABLE_EXTENSIONS);
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (parcelableArrayList != null) {
                    this.mActions.addAll(parcelableArrayList);
                }
                this.mFlags = bundle.getInt("flags", 1);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = Notification.getNotificationArrayFromBundle(bundle, "pages");
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
            }
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                this.mFlags |= i;
            } else {
                this.mFlags &= i ^ (-1);
            }
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        /* renamed from: clone */
        public WearableExtender m121clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList<>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList<>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            return wearableExtender;
        }

        @Override // android.app.Notification.Extender
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                bundle.putParcelableArrayList("actions", this.mActions);
            }
            if (this.mFlags != 1) {
                bundle.putInt("flags", this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                bundle.putParcelable(KEY_BACKGROUND, this.mBackground);
            }
            if (this.mContentIcon != 0) {
                bundle.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                bundle.putInt(KEY_GRAVITY, this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, this.mHintScreenTimeout);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        public WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        public WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }
    }

    public Notification() {
        this.audioStreamType = -1;
        this.audioAttributes = AUDIO_ATTRIBUTES_DEFAULT;
        this.color = 0;
        this.extras = new Bundle();
        this.when = System.currentTimeMillis();
        this.priority = 0;
    }

    @Deprecated
    public Notification(int i, CharSequence charSequence, long j) {
        this.audioStreamType = -1;
        this.audioAttributes = AUDIO_ATTRIBUTES_DEFAULT;
        this.color = 0;
        this.extras = new Bundle();
        this.icon = i;
        this.tickerText = charSequence;
        this.when = j;
    }

    public Notification(Context context, int i, CharSequence charSequence, long j, CharSequence charSequence2, CharSequence charSequence3, Intent intent) {
        this.audioStreamType = -1;
        this.audioAttributes = AUDIO_ATTRIBUTES_DEFAULT;
        this.color = 0;
        this.extras = new Bundle();
        this.when = j;
        this.icon = i;
        this.tickerText = charSequence;
        setLatestEventInfo(context, charSequence2, charSequence3, PendingIntent.getActivity(context, 0, intent, 0));
    }

    public Notification(Parcel parcel) {
        this.audioStreamType = -1;
        this.audioAttributes = AUDIO_ATTRIBUTES_DEFAULT;
        this.color = 0;
        this.extras = new Bundle();
        parcel.readInt();
        this.when = parcel.readLong();
        this.icon = parcel.readInt();
        this.number = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.contentIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.deleteIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.tickerText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.tickerView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.contentView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.largeIcon = Bitmap.CREATOR.createFromParcel(parcel);
        }
        this.defaults = parcel.readInt();
        this.flags = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.sound = Uri.CREATOR.createFromParcel(parcel);
        }
        this.audioStreamType = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.audioAttributes = AudioAttributes.CREATOR.createFromParcel(parcel);
        }
        this.vibrate = parcel.createLongArray();
        this.ledARGB = parcel.readInt();
        this.ledOnMS = parcel.readInt();
        this.ledOffMS = parcel.readInt();
        this.iconLevel = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.fullScreenIntent = PendingIntent.CREATOR.createFromParcel(parcel);
        }
        this.priority = parcel.readInt();
        this.category = parcel.readString();
        this.mGroupKey = parcel.readString();
        this.mSortKey = parcel.readString();
        this.extras = parcel.readBundle();
        this.actions = (Action[]) parcel.createTypedArray(Action.CREATOR);
        if (parcel.readInt() != 0) {
            this.bigContentView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() != 0) {
            this.headsUpContentView = RemoteViews.CREATOR.createFromParcel(parcel);
        }
        this.visibility = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.publicVersion = CREATOR.createFromParcel(parcel);
        }
        this.color = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = (Notification[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification[].class);
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static CharSequence safeCharSequence(CharSequence charSequence) {
        if (charSequence != null) {
            CharSequence charSequence2 = charSequence;
            if (charSequence.length() > 5120) {
                charSequence2 = charSequence.subSequence(0, 5120);
            }
            charSequence = charSequence2;
            if (charSequence2 instanceof Parcelable) {
                Log.e(TAG, "warning: " + charSequence2.getClass().getCanonicalName() + " instance is a custom Parcelable and not allowed in Notification");
                return charSequence2.toString();
            }
        }
        return charSequence;
    }

    public static String visibilityToString(int i) {
        switch (i) {
            case -1:
                return "SECRET";
            case 0:
                return "PRIVATE";
            case 1:
                return "PUBLIC";
            default:
                return "UNKNOWN(" + String.valueOf(i) + ")";
        }
    }

    /* renamed from: clone */
    public Notification m116clone() {
        Notification notification = new Notification();
        cloneInto(notification, true);
        return notification;
    }

    public void cloneInto(Notification notification, boolean z) {
        notification.when = this.when;
        notification.icon = this.icon;
        notification.number = this.number;
        notification.contentIntent = this.contentIntent;
        notification.deleteIntent = this.deleteIntent;
        notification.fullScreenIntent = this.fullScreenIntent;
        if (this.tickerText != null) {
            notification.tickerText = this.tickerText.toString();
        }
        if (z && this.tickerView != null) {
            notification.tickerView = this.tickerView.mo120clone();
        }
        if (z && this.contentView != null) {
            notification.contentView = this.contentView.mo120clone();
        }
        if (z && this.largeIcon != null) {
            notification.largeIcon = Bitmap.createBitmap(this.largeIcon);
        }
        notification.iconLevel = this.iconLevel;
        notification.sound = this.sound;
        notification.audioStreamType = this.audioStreamType;
        if (this.audioAttributes != null) {
            notification.audioAttributes = new AudioAttributes.Builder(this.audioAttributes).build();
        }
        long[] jArr = this.vibrate;
        if (jArr != null) {
            int length = jArr.length;
            long[] jArr2 = new long[length];
            notification.vibrate = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, length);
        }
        notification.ledARGB = this.ledARGB;
        notification.ledOnMS = this.ledOnMS;
        notification.ledOffMS = this.ledOffMS;
        notification.defaults = this.defaults;
        notification.flags = this.flags;
        notification.priority = this.priority;
        notification.category = this.category;
        notification.mGroupKey = this.mGroupKey;
        notification.mSortKey = this.mSortKey;
        if (this.extras != null) {
            try {
                notification.extras = new Bundle(this.extras);
                notification.extras.size();
            } catch (BadParcelableException e) {
                Log.e(TAG, "could not unparcel extras from notification: " + this, e);
                notification.extras = null;
            }
        }
        if (this.actions != null) {
            notification.actions = new Action[this.actions.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.actions.length) {
                    break;
                }
                notification.actions[i2] = this.actions[i2].m118clone();
                i = i2 + 1;
            }
        }
        if (z && this.bigContentView != null) {
            notification.bigContentView = this.bigContentView.mo120clone();
        }
        if (z && this.headsUpContentView != null) {
            notification.headsUpContentView = this.headsUpContentView.mo120clone();
        }
        notification.visibility = this.visibility;
        if (this.publicVersion != null) {
            notification.publicVersion = new Notification();
            this.publicVersion.cloneInto(notification.publicVersion, z);
        }
        notification.color = this.color;
        if (z) {
            return;
        }
        notification.lightenPayload();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getGroup() {
        return this.mGroupKey;
    }

    public String getSortKey() {
        return this.mSortKey;
    }

    public boolean isGroupChild() {
        return this.mGroupKey != null && (this.flags & 512) == 0;
    }

    public boolean isGroupSummary() {
        return (this.mGroupKey == null || (this.flags & 512) == 0) ? false : true;
    }

    public boolean isValid() {
        return this.contentView != null || this.extras.getBoolean(Builder.EXTRA_REBUILD_CONTENT_VIEW);
    }

    public final void lightenPayload() {
        this.tickerView = null;
        this.contentView = null;
        this.bigContentView = null;
        this.headsUpContentView = null;
        this.largeIcon = null;
        if (this.extras != null) {
            this.extras.remove("android.largeIcon");
            this.extras.remove("android.largeIcon.big");
            this.extras.remove("android.picture");
            this.extras.remove("android.bigText");
            this.extras.remove(Builder.EXTRA_NEEDS_REBUILD);
        }
    }

    @Deprecated
    public void setLatestEventInfo(Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        Builder builder = new Builder(context);
        builder.setWhen(this.when);
        builder.setSmallIcon(this.icon);
        builder.setPriority(this.priority);
        builder.setTicker(this.tickerText);
        builder.setNumber(this.number);
        builder.setColor(this.color);
        builder.mFlags = this.flags;
        builder.setSound(this.sound, this.audioStreamType);
        builder.setDefaults(this.defaults);
        builder.setVibrate(this.vibrate);
        if (charSequence != null) {
            builder.setContentTitle(charSequence);
        }
        if (charSequence2 != null) {
            builder.setContentText(charSequence2);
        }
        builder.setContentIntent(pendingIntent);
        builder.buildInto(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Notification(pri=");
        sb.append(this.priority);
        sb.append(" contentView=");
        if (this.contentView != null) {
            sb.append(this.contentView.getPackage());
            sb.append("/0x");
            sb.append(Integer.toHexString(this.contentView.getLayoutId()));
        } else {
            sb.append(b.l);
        }
        sb.append(" vibrate=");
        if ((this.defaults & 2) != 0) {
            sb.append("default");
        } else if (this.vibrate != null) {
            int length = this.vibrate.length - 1;
            sb.append("[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(this.vibrate[i2]);
                sb.append(',');
                i = i2 + 1;
            }
            if (length != -1) {
                sb.append(this.vibrate[length]);
            }
            sb.append("]");
        } else {
            sb.append(b.l);
        }
        sb.append(" sound=");
        if ((this.defaults & 1) != 0) {
            sb.append("default");
        } else if (this.sound != null) {
            sb.append(this.sound.toString());
        } else {
            sb.append(b.l);
        }
        sb.append(" defaults=0x");
        sb.append(Integer.toHexString(this.defaults));
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.flags));
        sb.append(String.format(" color=0x%08x", Integer.valueOf(this.color)));
        if (this.category != null) {
            sb.append(" category=");
            sb.append(this.category);
        }
        if (this.mGroupKey != null) {
            sb.append(" groupKey=");
            sb.append(this.mGroupKey);
        }
        if (this.mSortKey != null) {
            sb.append(" sortKey=");
            sb.append(this.mSortKey);
        }
        if (this.actions != null) {
            sb.append(" actions=");
            sb.append(this.actions.length);
        }
        sb.append(" vis=");
        sb.append(visibilityToString(this.visibility));
        if (this.publicVersion != null) {
            sb.append(" publicVersion=");
            sb.append(this.publicVersion.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeLong(this.when);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.number);
        if (this.contentIntent != null) {
            parcel.writeInt(1);
            this.contentIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.deleteIntent != null) {
            parcel.writeInt(1);
            this.deleteIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.tickerText != null) {
            parcel.writeInt(1);
            TextUtils.writeToParcel(this.tickerText, parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.tickerView != null) {
            parcel.writeInt(1);
            this.tickerView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.contentView != null) {
            parcel.writeInt(1);
            this.contentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.largeIcon != null) {
            parcel.writeInt(1);
            this.largeIcon.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.defaults);
        parcel.writeInt(this.flags);
        if (this.sound != null) {
            parcel.writeInt(1);
            this.sound.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.audioStreamType);
        if (this.audioAttributes != null) {
            parcel.writeInt(1);
            this.audioAttributes.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLongArray(this.vibrate);
        parcel.writeInt(this.ledARGB);
        parcel.writeInt(this.ledOnMS);
        parcel.writeInt(this.ledOffMS);
        parcel.writeInt(this.iconLevel);
        if (this.fullScreenIntent != null) {
            parcel.writeInt(1);
            this.fullScreenIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.priority);
        parcel.writeString(this.category);
        parcel.writeString(this.mGroupKey);
        parcel.writeString(this.mSortKey);
        parcel.writeBundle(this.extras);
        parcel.writeTypedArray(this.actions, 0);
        if (this.bigContentView != null) {
            parcel.writeInt(1);
            this.bigContentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if (this.headsUpContentView != null) {
            parcel.writeInt(1);
            this.headsUpContentView.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.visibility);
        if (this.publicVersion != null) {
            parcel.writeInt(1);
            this.publicVersion.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.color);
    }
}

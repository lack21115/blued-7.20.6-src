package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ThemesContract;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import com.huawei.openalliance.ad.constant.ao;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.analytics.pro.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat.class */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
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
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Action.class */
    public static class Action {
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2299a;
        public PendingIntent actionIntent;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        private IconCompat f2300c;
        private final RemoteInput[] d;
        private final RemoteInput[] e;
        private boolean f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int icon;
        public CharSequence title;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Action$Builder.class */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final IconCompat f2301a;
            private final CharSequence b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f2302c;
            private boolean d;
            private final Bundle e;
            private ArrayList<RemoteInput> f;
            private int g;
            private boolean h;
            private boolean i;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.f2299a), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.b, action.isContextual());
            }

            public Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            private Builder(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3) {
                this.d = true;
                this.h = true;
                this.f2301a = iconCompat;
                this.b = Builder.a(charSequence);
                this.f2302c = pendingIntent;
                this.e = bundle;
                this.f = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.d = z;
                this.g = i;
                this.h = z2;
                this.i = z3;
            }

            private void a() {
                if (this.i && this.f2302c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public static Builder fromAndroidAction(Notification.Action action) {
                android.app.RemoteInput[] remoteInputs;
                Builder builder = (Build.VERSION.SDK_INT < 23 || action.getIcon() == null) ? new Builder(action.icon, action.title, action.actionIntent) : new Builder(IconCompat.createFromIcon(action.getIcon()), action.title, action.actionIntent);
                if (Build.VERSION.SDK_INT >= 20 && (remoteInputs = action.getRemoteInputs()) != null && remoteInputs.length != 0) {
                    int length = remoteInputs.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        builder.addRemoteInput(RemoteInput.a(remoteInputs[i2]));
                        i = i2 + 1;
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.d = action.getAllowGeneratedReplies();
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    builder.setSemanticAction(action.getSemanticAction());
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    builder.setContextual(action.isContextual());
                }
                return builder;
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.e.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                if (remoteInput != null) {
                    this.f.add(remoteInput);
                }
                return this;
            }

            public Action build() {
                a();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.f;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.isDataOnly()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = null;
                RemoteInput[] remoteInputArr2 = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                if (!arrayList2.isEmpty()) {
                    remoteInputArr = (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]);
                }
                return new Action(this.f2301a, this.b, this.f2302c, this.e, remoteInputArr, remoteInputArr2, this.d, this.g, this.h, this.i);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.e;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.d = z;
                return this;
            }

            public Builder setContextual(boolean z) {
                this.i = z;
                return this;
            }

            public Builder setSemanticAction(int i) {
                this.g = i;
                return this;
            }

            public Builder setShowsUserInterface(boolean z) {
                this.h = z;
                return this;
            }
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Action$Extender.class */
        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Action$SemanticAction.class */
        public @interface SemanticAction {
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Action$WearableExtender.class */
        public static final class WearableExtender implements Extender {

            /* renamed from: a  reason: collision with root package name */
            private int f2303a;
            private CharSequence b;

            /* renamed from: c  reason: collision with root package name */
            private CharSequence f2304c;
            private CharSequence d;

            public WearableExtender() {
                this.f2303a = 1;
            }

            public WearableExtender(Action action) {
                this.f2303a = 1;
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f2303a = bundle.getInt("flags", 1);
                    this.b = bundle.getCharSequence("inProgressLabel");
                    this.f2304c = bundle.getCharSequence("confirmLabel");
                    this.d = bundle.getCharSequence("cancelLabel");
                }
            }

            private void a(int i, boolean z) {
                if (z) {
                    this.f2303a = i | this.f2303a;
                } else {
                    this.f2303a = i & this.f2303a;
                }
            }

            /* renamed from: clone */
            public WearableExtender m1269clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f2303a = this.f2303a;
                wearableExtender.b = this.b;
                wearableExtender.f2304c = this.f2304c;
                wearableExtender.d = this.d;
                return wearableExtender;
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.f2303a;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.b;
                if (charSequence != null) {
                    bundle.putCharSequence("inProgressLabel", charSequence);
                }
                CharSequence charSequence2 = this.f2304c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("confirmLabel", charSequence2);
                }
                CharSequence charSequence3 = this.d;
                if (charSequence3 != null) {
                    bundle.putCharSequence("cancelLabel", charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.d;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.f2304c;
            }

            public boolean getHintDisplayActionInline() {
                return (this.f2303a & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.f2303a & 2) != 0;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.b;
            }

            public boolean isAvailableOffline() {
                return (this.f2303a & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                a(1, z);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.d = charSequence;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.f2304c = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                a(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                a(2, z);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.b = charSequence;
                return this;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            this(i != 0 ? IconCompat.createWithResource(null, "", i) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i2, z2, z3);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3) {
            this.b = true;
            this.f2300c = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.a(charSequence);
            this.actionIntent = pendingIntent;
            this.f2299a = bundle == null ? new Bundle() : bundle;
            this.d = remoteInputArr;
            this.e = remoteInputArr2;
            this.f = z;
            this.g = i;
            this.b = z2;
            this.h = z3;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.e;
        }

        public Bundle getExtras() {
            return this.f2299a;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            int i;
            if (this.f2300c == null && (i = this.icon) != 0) {
                this.f2300c = IconCompat.createWithResource(null, "", i);
            }
            return this.f2300c;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.d;
        }

        public int getSemanticAction() {
            return this.g;
        }

        public boolean getShowsUserInterface() {
            return this.b;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.h;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BadgeIconType.class */
    public @interface BadgeIconType {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BigPictureStyle.class */
    public static class BigPictureStyle extends Style {
        private Bitmap e;
        private IconCompat f;
        private boolean g;
        private boolean h;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BigPictureStyle$Api16Impl.class */
        static class Api16Impl {
            private Api16Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BigPictureStyle$Api23Impl.class */
        static class Api23Impl {
            private Api23Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BigPictureStyle$Api31Impl.class */
        static class Api31Impl {
            private Api31Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, boolean z) {
                bigPictureStyle.showBigPictureWhenCollapsed(z);
            }
        }

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        private static IconCompat a(Parcelable parcelable) {
            if (parcelable != null) {
                if (Build.VERSION.SDK_INT < 23 || !(parcelable instanceof Icon)) {
                    if (parcelable instanceof Bitmap) {
                        return IconCompat.createWithBitmap((Bitmap) parcelable);
                    }
                    return null;
                }
                return IconCompat.createFromIcon((Icon) parcelable);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String a() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void a(Bundle bundle) {
            super.a(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f = a(bundle.getParcelable("android.largeIcon.big"));
                this.g = true;
            }
            this.e = (Bitmap) bundle.getParcelable("android.picture");
            this.h = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b).bigPicture(this.e);
                if (this.g) {
                    Context context = null;
                    if (this.f == null) {
                        Api16Impl.a(bigPicture, (Bitmap) null);
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                            context = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).getContext();
                        }
                        Api23Impl.a(bigPicture, this.f.toIcon(context));
                    } else if (this.f.getType() == 1) {
                        Api16Impl.a(bigPicture, this.f.getBitmap());
                    } else {
                        Api16Impl.a(bigPicture, (Bitmap) null);
                    }
                }
                if (this.d) {
                    Api16Impl.a(bigPicture, this.f2320c);
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.a(bigPicture, this.h);
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void b(Bundle bundle) {
            super.b(bundle);
            bundle.remove("android.largeIcon.big");
            bundle.remove("android.picture");
            bundle.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.f = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
            this.g = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.b = Builder.a(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.f2320c = Builder.a(charSequence);
            this.d = true;
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean z) {
            this.h = z;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BigTextStyle.class */
    public static class BigTextStyle extends Style {
        private CharSequence e;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String a() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void a(Bundle bundle) {
            super.a(bundle);
            this.e = bundle.getCharSequence("android.bigText");
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.e);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.f2320c);
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void b(Bundle bundle) {
            super.b(bundle);
            bundle.remove("android.bigText");
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.e = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.b = Builder.a(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.f2320c = Builder.a(charSequence);
            this.d = true;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BubbleMetadata.class */
    public static final class BubbleMetadata {

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f2305a;
        private PendingIntent b;

        /* renamed from: c  reason: collision with root package name */
        private IconCompat f2306c;
        private int d;
        private int e;
        private int f;
        private String g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BubbleMetadata$Api29Impl.class */
        public static class Api29Impl {
            private Api29Impl() {
            }

            static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }

            static BubbleMetadata a(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Builder suppressNotification = new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon())).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BubbleMetadata$Api30Impl.class */
        public static class Api30Impl {
            private Api30Impl() {
            }

            static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = bubbleMetadata.getShortcutId() != null ? new Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId()) : new Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
                builder.setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }

            static BubbleMetadata a(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Builder builder = bubbleMetadata.getShortcutId() != null ? new Builder(bubbleMetadata.getShortcutId()) : new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon()));
                builder.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }
        }

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$BubbleMetadata$Builder.class */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private PendingIntent f2307a;
            private IconCompat b;

            /* renamed from: c  reason: collision with root package name */
            private int f2308c;
            private int d;
            private int e;
            private PendingIntent f;
            private String g;

            @Deprecated
            public Builder() {
            }

            public Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.f2307a = pendingIntent;
                this.b = iconCompat;
            }

            public Builder(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.g = str;
            }

            private Builder a(int i, boolean z) {
                if (z) {
                    this.e = i | this.e;
                    return this;
                }
                this.e = i & this.e;
                return this;
            }

            public BubbleMetadata build() {
                if (this.g == null && this.f2307a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (this.g == null && this.b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                BubbleMetadata bubbleMetadata = new BubbleMetadata(this.f2307a, this.f, this.b, this.f2308c, this.d, this.e, this.g);
                bubbleMetadata.setFlags(this.e);
                return bubbleMetadata;
            }

            public Builder setAutoExpandBubble(boolean z) {
                a(1, z);
                return this;
            }

            public Builder setDeleteIntent(PendingIntent pendingIntent) {
                this.f = pendingIntent;
                return this;
            }

            public Builder setDesiredHeight(int i) {
                this.f2308c = Math.max(i, 0);
                this.d = 0;
                return this;
            }

            public Builder setDesiredHeightResId(int i) {
                this.d = i;
                this.f2308c = 0;
                return this;
            }

            public Builder setIcon(IconCompat iconCompat) {
                if (this.g == null) {
                    if (iconCompat != null) {
                        this.b = iconCompat;
                        return this;
                    }
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setIntent(PendingIntent pendingIntent) {
                if (this.g == null) {
                    if (pendingIntent != null) {
                        this.f2307a = pendingIntent;
                        return this;
                    }
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public Builder setSuppressNotification(boolean z) {
                a(2, z);
                return this;
            }
        }

        private BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i, int i2, int i3, String str) {
            this.f2305a = pendingIntent;
            this.f2306c = iconCompat;
            this.d = i;
            this.e = i2;
            this.b = pendingIntent2;
            this.f = i3;
            this.g = str;
        }

        public static BubbleMetadata fromPlatform(Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.a(bubbleMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return Api29Impl.a(bubbleMetadata);
            }
            return null;
        }

        public static Notification.BubbleMetadata toPlatform(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.a(bubbleMetadata);
            }
            if (Build.VERSION.SDK_INT == 29) {
                return Api29Impl.a(bubbleMetadata);
            }
            return null;
        }

        public boolean getAutoExpandBubble() {
            return (this.f & 1) != 0;
        }

        public PendingIntent getDeleteIntent() {
            return this.b;
        }

        public int getDesiredHeight() {
            return this.d;
        }

        public int getDesiredHeightResId() {
            return this.e;
        }

        public IconCompat getIcon() {
            return this.f2306c;
        }

        public PendingIntent getIntent() {
            return this.f2305a;
        }

        public String getShortcutId() {
            return this.g;
        }

        public boolean isNotificationSuppressed() {
            return (this.f & 2) != 0;
        }

        public void setFlags(int i) {
            this.f = i;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Builder.class */
    public static class Builder {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        LocusIdCompat L;
        long M;
        int N;
        int O;
        boolean P;
        BubbleMetadata Q;
        Notification R;
        boolean S;
        Icon T;

        /* renamed from: a  reason: collision with root package name */
        ArrayList<Action> f2309a;
        CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2310c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        Bitmap g;
        CharSequence h;
        int i;
        int j;
        boolean k;
        boolean l;
        boolean m;
        public ArrayList<Action> mActions;
        public Context mContext;
        @Deprecated
        public ArrayList<String> mPeople;
        public ArrayList<Person> mPersonList;
        Style n;
        CharSequence o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        @Deprecated
        public Builder(Context context) {
            this(context, (String) null);
        }

        public Builder(Context context, Notification notification) {
            this(context, NotificationCompat.getChannelId(notification));
            ArrayList parcelableArrayList;
            Bundle bundle = notification.extras;
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(extractStyleFromNotification).setContentIntent(notification.contentIntent).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.a(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(bundle.getInt("android.progressMax"), bundle.getInt("android.progress"), bundle.getBoolean("android.progressIndeterminate")).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(a(notification, extractStyleFromNotification));
            if (Build.VERSION.SDK_INT >= 23) {
                this.T = notification.getSmallIcon();
            }
            if (notification.actions != null && notification.actions.length != 0) {
                Notification.Action[] actionArr = notification.actions;
                int length = actionArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    addAction(Action.Builder.fromAndroidAction(actionArr[i2]).build());
                    i = i2 + 1;
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                List<Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
                if (!invisibleActions.isEmpty()) {
                    for (Action action : invisibleActions) {
                        addInvisibleAction(action);
                    }
                }
            }
            String[] stringArray = notification.extras.getStringArray("android.people");
            if (stringArray != null && stringArray.length != 0) {
                int length2 = stringArray.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    addPerson(stringArray[i4]);
                    i3 = i4 + 1;
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    addPerson(Person.fromAndroidPerson((android.app.Person) it.next()));
                }
            }
            if (Build.VERSION.SDK_INT >= 24 && bundle.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(bundle.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (Build.VERSION.SDK_INT < 26 || !bundle.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                return;
            }
            setColorized(bundle.getBoolean(NotificationCompat.EXTRA_COLORIZED));
        }

        public Builder(Context context, String str) {
            this.mActions = new ArrayList<>();
            this.mPersonList = new ArrayList<>();
            this.f2309a = new ArrayList<>();
            this.k = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.N = 0;
            this.O = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.mContext = context;
            this.I = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.j = 0;
            this.mPeople = new ArrayList<>();
            this.P = true;
        }

        private Bitmap a(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            if (bitmap != null) {
                if (Build.VERSION.SDK_INT >= 27) {
                    return bitmap;
                }
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                    return bitmap;
                }
                double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
            }
            return bitmap2;
        }

        private static Bundle a(Notification notification, Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove("android.title");
            bundle.remove("android.text");
            bundle.remove("android.infoText");
            bundle.remove("android.subText");
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            bundle.remove("android.showWhen");
            bundle.remove("android.progress");
            bundle.remove("android.progressMax");
            bundle.remove("android.progressIndeterminate");
            bundle.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            bundle.remove(NotificationCompat.EXTRA_COLORIZED);
            bundle.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            bundle.remove("android.people");
            bundle.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            bundle.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            bundle.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.b(bundle);
            }
            return bundle;
        }

        protected static CharSequence a(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            CharSequence charSequence2 = charSequence;
            if (charSequence.length() > 5120) {
                charSequence2 = charSequence.subSequence(0, 5120);
            }
            return charSequence2;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.R;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.R;
            notification2.flags = i & notification2.flags;
        }

        private boolean a() {
            Style style = this.n;
            return style == null || !style.displayCustomViewInline();
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.B;
                if (bundle2 == null) {
                    this.B = new Bundle(bundle);
                    return this;
                }
                bundle2.putAll(bundle);
            }
            return this;
        }

        public Builder addInvisibleAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2309a.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addInvisibleAction(Action action) {
            if (action != null) {
                this.f2309a.add(action);
            }
            return this;
        }

        public Builder addPerson(Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @Deprecated
        public Builder addPerson(String str) {
            if (str != null && !str.isEmpty()) {
                this.mPeople.add(str);
            }
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public Builder clearInvisibleActions() {
            this.f2309a.clear();
            Bundle bundle = this.B.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.B.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            RemoteViews makeBigContentView;
            if (Build.VERSION.SDK_INT < 16) {
                return null;
            }
            if (this.G == null || !a()) {
                NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
                Style style = this.n;
                if (style == null || (makeBigContentView = style.makeBigContentView(notificationCompatBuilder)) == null) {
                    Notification build = notificationCompatBuilder.build();
                    return Build.VERSION.SDK_INT >= 24 ? Notification.Builder.recoverBuilder(this.mContext, build).createBigContentView() : build.bigContentView;
                }
                return makeBigContentView;
            }
            return this.G;
        }

        public RemoteViews createContentView() {
            RemoteViews makeContentView;
            if (this.F == null || !a()) {
                NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
                Style style = this.n;
                if (style == null || (makeContentView = style.makeContentView(notificationCompatBuilder)) == null) {
                    Notification build = notificationCompatBuilder.build();
                    return Build.VERSION.SDK_INT >= 24 ? Notification.Builder.recoverBuilder(this.mContext, build).createContentView() : build.contentView;
                }
                return makeContentView;
            }
            return this.F;
        }

        public RemoteViews createHeadsUpContentView() {
            RemoteViews makeHeadsUpContentView;
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            if (this.H == null || !a()) {
                NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
                Style style = this.n;
                if (style == null || (makeHeadsUpContentView = style.makeHeadsUpContentView(notificationCompatBuilder)) == null) {
                    Notification build = notificationCompatBuilder.build();
                    return Build.VERSION.SDK_INT >= 24 ? Notification.Builder.recoverBuilder(this.mContext, build).createHeadsUpContentView() : build.headsUpContentView;
                }
                return makeHeadsUpContentView;
            }
            return this.H;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.G;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.Q;
        }

        public int getColor() {
            return this.C;
        }

        public RemoteViews getContentView() {
            return this.F;
        }

        public Bundle getExtras() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public int getForegroundServiceBehavior() {
            return this.O;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.H;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public int getPriority() {
            return this.j;
        }

        public long getWhenIfShowing() {
            if (this.k) {
                return this.R.when;
            }
            return 0L;
        }

        public Builder setAllowSystemGeneratedContextualActions(boolean z) {
            this.P = z;
            return this;
        }

        public Builder setAutoCancel(boolean z) {
            a(16, z);
            return this;
        }

        public Builder setBadgeIconType(int i) {
            this.J = i;
            return this;
        }

        public Builder setBubbleMetadata(BubbleMetadata bubbleMetadata) {
            this.Q = bubbleMetadata;
            return this;
        }

        public Builder setCategory(String str) {
            this.A = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.I = str;
            return this;
        }

        public Builder setChronometerCountDown(boolean z) {
            this.m = z;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
            return this;
        }

        public Builder setColor(int i) {
            this.C = i;
            return this;
        }

        public Builder setColorized(boolean z) {
            this.y = z;
            this.z = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.R.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.h = a(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.f2310c = a(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.b = a(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.G = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.F = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.H = remoteViews;
            return this;
        }

        public Builder setDefaults(int i) {
            this.R.defaults = i;
            if ((i & 4) != 0) {
                this.R.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.B = bundle;
            return this;
        }

        public Builder setForegroundServiceBehavior(int i) {
            this.O = i;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.e = pendingIntent;
            a(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.u = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i) {
            this.N = i;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.v = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.g = a(bitmap);
            return this;
        }

        public Builder setLights(int i, int i2, int i3) {
            this.R.ledARGB = i;
            this.R.ledOnMS = i2;
            this.R.ledOffMS = i3;
            int i4 = (this.R.ledOnMS == 0 || this.R.ledOffMS == 0) ? 0 : 1;
            Notification notification = this.R;
            notification.flags = i4 | (notification.flags & (-2));
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.x = z;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.L = locusIdCompat;
            return this;
        }

        @Deprecated
        public Builder setNotificationSilent() {
            this.S = true;
            return this;
        }

        public Builder setNumber(int i) {
            this.i = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            a(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            a(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.j = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.r = i;
            this.s = i2;
            this.t = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.E = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.q = charSequenceArr;
            return this;
        }

        public Builder setSettingsText(CharSequence charSequence) {
            this.p = a(charSequence);
            return this;
        }

        public Builder setShortcutId(String str) {
            this.K = str;
            return this;
        }

        public Builder setShortcutInfo(ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.K = shortcutInfoCompat.getId();
            if (this.L == null) {
                if (shortcutInfoCompat.getLocusId() != null) {
                    this.L = shortcutInfoCompat.getLocusId();
                } else if (shortcutInfoCompat.getId() != null) {
                    this.L = new LocusIdCompat(shortcutInfoCompat.getId());
                }
            }
            if (this.b == null) {
                setContentTitle(shortcutInfoCompat.getShortLabel());
            }
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setSilent(boolean z) {
            this.S = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.R.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            this.R.icon = i;
            this.R.iconLevel = i2;
            return this;
        }

        public Builder setSmallIcon(IconCompat iconCompat) {
            this.T = iconCompat.toIcon(this.mContext);
            return this;
        }

        public Builder setSortKey(String str) {
            this.w = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.R.sound = uri;
            this.R.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.R.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            this.R.sound = uri;
            this.R.audioStreamType = i;
            if (Build.VERSION.SDK_INT >= 21) {
                this.R.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            }
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.n != style) {
                this.n = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.o = a(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.R.tickerText = a(charSequence);
            return this;
        }

        @Deprecated
        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.R.tickerText = a(charSequence);
            this.f = remoteViews;
            return this;
        }

        public Builder setTimeoutAfter(long j) {
            this.M = j;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.D = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.R.when = j;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$CarExtender.class */
    public static final class CarExtender implements Extender {

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f2311a;
        private UnreadConversation b;

        /* renamed from: c  reason: collision with root package name */
        private int f2312c;

        @Deprecated
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$CarExtender$UnreadConversation.class */
        public static class UnreadConversation {

            /* renamed from: a  reason: collision with root package name */
            private final String[] f2313a;
            private final RemoteInput b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f2314c;
            private final PendingIntent d;
            private final String[] e;
            private final long f;

            /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$CarExtender$UnreadConversation$Builder.class */
            public static class Builder {

                /* renamed from: a  reason: collision with root package name */
                private final List<String> f2315a = new ArrayList();
                private final String b;

                /* renamed from: c  reason: collision with root package name */
                private RemoteInput f2316c;
                private PendingIntent d;
                private PendingIntent e;
                private long f;

                public Builder(String str) {
                    this.b = str;
                }

                public Builder addMessage(String str) {
                    if (str != null) {
                        this.f2315a.add(str);
                    }
                    return this;
                }

                public UnreadConversation build() {
                    List<String> list = this.f2315a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.f2316c, this.e, this.d, new String[]{this.b}, this.f);
                }

                public Builder setLatestTimestamp(long j) {
                    this.f = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.d = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.f2316c = remoteInput;
                    this.e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f2313a = strArr;
                this.b = remoteInput;
                this.d = pendingIntent2;
                this.f2314c = pendingIntent;
                this.e = strArr2;
                this.f = j;
            }

            public long getLatestTimestamp() {
                return this.f;
            }

            public String[] getMessages() {
                return this.f2313a;
            }

            public String getParticipant() {
                String[] strArr = this.e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.e;
            }

            public PendingIntent getReadPendingIntent() {
                return this.d;
            }

            public RemoteInput getRemoteInput() {
                return this.b;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.f2314c;
            }
        }

        public CarExtender() {
            this.f2312c = 0;
        }

        public CarExtender(Notification notification) {
            this.f2312c = 0;
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                this.f2311a = (Bitmap) bundle.getParcelable("large_icon");
                this.f2312c = bundle.getInt("app_color", 0);
                this.b = a(bundle.getBundle("car_conversation"));
            }
        }

        private static Bundle a(UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            int length = unreadConversation.getMessages().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i = 0; i < length; i++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i]);
                bundle2.putString(ThemesContract.ThemesColumns.AUTHOR, str);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
            bundle.putParcelable("on_read", unreadConversation.getReadPendingIntent());
            bundle.putStringArray("participants", unreadConversation.getParticipants());
            bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
            return bundle;
        }

        private static UnreadConversation a(Bundle bundle) {
            String[] strArr;
            boolean z;
            UnreadConversation unreadConversation = null;
            if (bundle == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                strArr = new String[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (!(parcelableArray[i2] instanceof Bundle)) {
                        break;
                    } else {
                        strArr[i2] = ((Bundle) parcelableArray[i2]).getString("text");
                        if (strArr[i2] == null) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
                z = false;
                if (!z) {
                    return null;
                }
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("on_read");
            PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("on_reply");
            android.app.RemoteInput remoteInput = (android.app.RemoteInput) bundle.getParcelable("remote_input");
            String[] stringArray = bundle.getStringArray("participants");
            if (stringArray != null) {
                if (stringArray.length != 1) {
                    return null;
                }
                RemoteInput remoteInput2 = null;
                if (remoteInput != null) {
                    remoteInput2 = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
                }
                unreadConversation = new UnreadConversation(strArr, remoteInput2, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
            }
            return unreadConversation;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f2311a;
            if (bitmap != null) {
                bundle.putParcelable("large_icon", bitmap);
            }
            int i = this.f2312c;
            if (i != 0) {
                bundle.putInt("app_color", i);
            }
            UnreadConversation unreadConversation = this.b;
            if (unreadConversation != null) {
                bundle.putBundle("car_conversation", a(unreadConversation));
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        public int getColor() {
            return this.f2312c;
        }

        public Bitmap getLargeIcon() {
            return this.f2311a;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            return this.b;
        }

        public CarExtender setColor(int i) {
            this.f2312c = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.f2311a = bitmap;
            return this;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.b = unreadConversation;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$DecoratedCustomViewStyle.class */
    public static class DecoratedCustomViewStyle extends Style {
        private RemoteViews a(RemoteViews remoteViews, boolean z) {
            boolean z2;
            int min;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(R.id.actions);
            List<Action> a2 = a(this.f2319a.mActions);
            if (z && a2 != null && (min = Math.min(a2.size(), 3)) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z2 = true;
                    if (i2 >= min) {
                        break;
                    }
                    applyStandardTemplate.addView(R.id.actions, a(a2.get(i2)));
                    i = i2 + 1;
                }
            } else {
                z2 = false;
            }
            int i3 = z2 ? 0 : 8;
            applyStandardTemplate.setViewVisibility(R.id.actions, i3);
            applyStandardTemplate.setViewVisibility(R.id.action_divider, i3);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private RemoteViews a(Action action) {
            boolean z = action.actionIntent == null;
            RemoteViews remoteViews = new RemoteViews(this.f2319a.mContext.getPackageName(), z ? R.layout.notification_action_tombstone : R.layout.notification_action);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewBitmap(R.id.action_image, a(iconCompat, this.f2319a.mContext.getResources().getColor(R.color.notification_action_color_filter)));
            }
            remoteViews.setTextViewText(R.id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.action_container, action.title);
            }
            return remoteViews;
        }

        private static List<Action> a(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action action : list) {
                if (!action.isContextual()) {
                    arrayList.add(action);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String a() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public boolean displayCustomViewInline() {
            return true;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.f2319a.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.f2319a.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return a(bigContentView, true);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.f2319a.getContentView() != null) {
                return a(this.f2319a.getContentView(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.f2319a.getHeadsUpContentView();
            RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.f2319a.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            return a(contentView, true);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Extender.class */
    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$GroupAlertBehavior.class */
    public @interface GroupAlertBehavior {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$InboxStyle.class */
    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> e = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String a() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void a(Bundle bundle) {
            super.a(bundle);
            this.e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public InboxStyle addLine(CharSequence charSequence) {
            if (charSequence != null) {
                this.e.add(Builder.a(charSequence));
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.b);
                if (this.d) {
                    bigContentTitle.setSummaryText(this.f2320c);
                }
                Iterator<CharSequence> it = this.e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void b(Bundle bundle) {
            super.b(bundle);
            bundle.remove("android.textLines");
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.b = Builder.a(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.f2320c = Builder.a(charSequence);
            this.d = true;
            return this;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$MessagingStyle.class */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private final List<Message> e = new ArrayList();
        private final List<Message> f = new ArrayList();
        private Person g;
        private CharSequence h;
        private Boolean i;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$MessagingStyle$Message.class */
        public static final class Message {

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f2317a;
            private final long b;

            /* renamed from: c  reason: collision with root package name */
            private final Person f2318c;
            private Bundle d;
            private String e;
            private Uri f;

            public Message(CharSequence charSequence, long j, Person person) {
                this.d = new Bundle();
                this.f2317a = charSequence;
                this.b = j;
                this.f2318c = person;
            }

            @Deprecated
            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this(charSequence, j, new Person.Builder().setName(charSequence2).build());
            }

            static Message a(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), bundle.containsKey("person") ? Person.fromBundle(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new Person.Builder().setName(bundle.getCharSequence("sender")).build() : null : Person.fromAndroidPerson((android.app.Person) bundle.getParcelable("sender_person")));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            message.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey(ao.K)) {
                            message.getExtras().putAll(bundle.getBundle(ao.K));
                        }
                        return message;
                    }
                    return null;
                } catch (ClassCastException e) {
                    return null;
                }
            }

            static List<Message> a(Parcelable[] parcelableArr) {
                Message a2;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= parcelableArr.length) {
                        return arrayList;
                    }
                    if ((parcelableArr[i2] instanceof Bundle) && (a2 = a((Bundle) parcelableArr[i2])) != null) {
                        arrayList.add(a2);
                    }
                    i = i2 + 1;
                }
            }

            static Bundle[] a(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        return bundleArr;
                    }
                    bundleArr[i2] = list.get(i2).b();
                    i = i2 + 1;
                }
            }

            private Bundle b() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f2317a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.b);
                Person person = this.f2318c;
                if (person != null) {
                    bundle.putCharSequence("sender", person.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", this.f2318c.toAndroidPerson());
                    } else {
                        bundle.putBundle("person", this.f2318c.toBundle());
                    }
                }
                String str = this.e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.d;
                if (bundle2 != null) {
                    bundle.putBundle(ao.K, bundle2);
                }
                return bundle;
            }

            Notification.MessagingStyle.Message a() {
                Notification.MessagingStyle.Message message;
                Person person = getPerson();
                android.app.Person person2 = null;
                if (Build.VERSION.SDK_INT >= 28) {
                    CharSequence text = getText();
                    long timestamp = getTimestamp();
                    if (person != null) {
                        person2 = person.toAndroidPerson();
                    }
                    message = new Notification.MessagingStyle.Message(text, timestamp, person2);
                } else {
                    message = new Notification.MessagingStyle.Message(getText(), getTimestamp(), person == null ? null : person.getName());
                }
                if (getDataMimeType() != null) {
                    message.setData(getDataMimeType(), getDataUri());
                }
                return message;
            }

            public String getDataMimeType() {
                return this.e;
            }

            public Uri getDataUri() {
                return this.f;
            }

            public Bundle getExtras() {
                return this.d;
            }

            public Person getPerson() {
                return this.f2318c;
            }

            @Deprecated
            public CharSequence getSender() {
                Person person = this.f2318c;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            public CharSequence getText() {
                return this.f2317a;
            }

            public long getTimestamp() {
                return this.b;
            }

            public Message setData(String str, Uri uri) {
                this.e = str;
                this.f = uri;
                return this;
            }
        }

        MessagingStyle() {
        }

        public MessagingStyle(Person person) {
            if (TextUtils.isEmpty(person.getName())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.g = person;
        }

        @Deprecated
        public MessagingStyle(CharSequence charSequence) {
            this.g = new Person.Builder().setName(charSequence).build();
        }

        private TextAppearanceSpan a(int i) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
        }

        private CharSequence a(Message message) {
            BidiFormatter bidiFormatter = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = Build.VERSION.SDK_INT >= 21;
            int i = z ? -16777216 : -1;
            String name = message.getPerson() == null ? "" : message.getPerson().getName();
            int i2 = i;
            CharSequence charSequence = name;
            if (TextUtils.isEmpty(name)) {
                CharSequence name2 = this.g.getName();
                i2 = i;
                charSequence = name2;
                if (z) {
                    i2 = i;
                    charSequence = name2;
                    if (this.f2319a.getColor() != 0) {
                        i2 = this.f2319a.getColor();
                        charSequence = name2;
                    }
                }
            }
            CharSequence unicodeWrap = bidiFormatter.unicodeWrap(charSequence);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(a(i2), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() == null ? "" : message.getText()));
            return spannableStringBuilder;
        }

        private Message b() {
            int size = this.e.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    if (this.e.isEmpty()) {
                        return null;
                    }
                    List<Message> list = this.e;
                    return list.get(list.size() - 1);
                }
                Message message = this.e.get(i);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
                size = i;
            }
        }

        private boolean c() {
            int size = this.e.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return false;
                }
                Message message = this.e.get(i);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
                size = i;
            }
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            if (extractStyleFromNotification instanceof MessagingStyle) {
                return (MessagingStyle) extractStyleFromNotification;
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected String a() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void a(Bundle bundle) {
            super.a(bundle);
            this.e.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.g = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.g = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.h = charSequence;
            if (charSequence == null) {
                this.h = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.e.addAll(Message.a(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (parcelableArray2 != null) {
                this.f.addAll(Message.a(parcelableArray2));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.i = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.g.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.g.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.h);
            if (this.h != null && this.i.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.h);
            }
            if (!this.e.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.a(this.e));
            }
            if (!this.f.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.a(this.f));
            }
            Boolean bool = this.i;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        public MessagingStyle addHistoricMessage(Message message) {
            if (message != null) {
                this.f.add(message);
                if (this.f.size() > 25) {
                    this.f.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            if (message != null) {
                this.e.add(message);
                if (this.e.size() > 25) {
                    this.e.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, Person person) {
            addMessage(new Message(charSequence, j, person));
            return this;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.e.add(new Message(charSequence, j, new Person.Builder().setName(charSequence2).build()));
            if (this.e.size() > 25) {
                this.e.remove(0);
            }
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            setGroupConversation(isGroupConversation());
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.MessagingStyle messagingStyle = Build.VERSION.SDK_INT >= 28 ? new Notification.MessagingStyle(this.g.toAndroidPerson()) : new Notification.MessagingStyle(this.g.getName());
                for (Message message : this.e) {
                    messagingStyle.addMessage(message.a());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    for (Message message2 : this.f) {
                        messagingStyle.addHistoricMessage(message2.a());
                    }
                }
                if (this.i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setConversationTitle(this.h);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    messagingStyle.setGroupConversation(this.i.booleanValue());
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message b = b();
            if (this.h != null && this.i.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.h);
            } else if (b != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (b.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(b.getPerson().getName());
                }
            }
            if (b != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.h != null ? a(b) : b.getText());
            }
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = this.h != null || c();
            int size = this.e.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
                    return;
                }
                Message message3 = this.e.get(i);
                CharSequence a2 = z ? a(message3) : message3.getText();
                if (i != this.e.size() - 1) {
                    spannableStringBuilder.insert(0, (CharSequence) "\n");
                }
                spannableStringBuilder.insert(0, a2);
                size = i;
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        protected void b(Bundle bundle) {
            super.b(bundle);
            bundle.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        public CharSequence getConversationTitle() {
            return this.h;
        }

        public List<Message> getHistoricMessages() {
            return this.f;
        }

        public List<Message> getMessages() {
            return this.e;
        }

        public Person getUser() {
            return this.g;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.g.getName();
        }

        public boolean isGroupConversation() {
            boolean z = false;
            if (this.f2319a != null && this.f2319a.mContext.getApplicationInfo().targetSdkVersion < 28 && this.i == null) {
                if (this.h != null) {
                    z = true;
                }
                return z;
            }
            Boolean bool = this.i;
            boolean z2 = false;
            if (bool != null) {
                z2 = bool.booleanValue();
            }
            return z2;
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.h = charSequence;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$NotificationVisibility.class */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$ServiceNotificationBehavior.class */
    public @interface ServiceNotificationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$StreamType.class */
    public @interface StreamType {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$Style.class */
    public static abstract class Style {

        /* renamed from: a  reason: collision with root package name */
        protected Builder f2319a;
        CharSequence b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2320c;
        boolean d = false;

        private static float a(float f, float f2, float f3) {
            if (f < f2) {
                return f2;
            }
            float f4 = f;
            if (f > f3) {
                f4 = f3;
            }
            return f4;
        }

        private Bitmap a(int i, int i2, int i3) {
            return a(IconCompat.createWithResource(this.f2319a.mContext, i), i2, i3);
        }

        private Bitmap a(int i, int i2, int i3, int i4) {
            int i5 = R.drawable.notification_icon_background;
            int i6 = i4;
            if (i4 == 0) {
                i6 = 0;
            }
            Bitmap a2 = a(i5, i6, i2);
            Canvas canvas = new Canvas(a2);
            Drawable mutate = this.f2319a.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i7 = (i2 - i3) / 2;
            int i8 = i3 + i7;
            mutate.setBounds(i7, i7, i8, i8);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return a2;
        }

        private Bitmap a(IconCompat iconCompat, int i, int i2) {
            Drawable loadDrawable = iconCompat.loadDrawable(this.f2319a.mContext);
            int intrinsicWidth = i2 == 0 ? loadDrawable.getIntrinsicWidth() : i2;
            int i3 = i2;
            if (i2 == 0) {
                i3 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        static Style a(String str) {
            if (str != null) {
                boolean z = true;
                switch (str.hashCode()) {
                    case -716705180:
                        if (str.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                            z = true;
                            break;
                        }
                        break;
                    case -171946061:
                        if (str.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                            z = true;
                            break;
                        }
                        break;
                    case 912942987:
                        if (str.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                            z = true;
                            break;
                        }
                        break;
                    case 919595044:
                        if (str.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                            z = false;
                            break;
                        }
                        break;
                    case 2090799565:
                        if (str.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                            z = true;
                            break;
                        }
                        break;
                }
                if (z) {
                    if (!z) {
                        if (!z) {
                            if (!z) {
                                if (!z) {
                                    return null;
                                }
                                return new MessagingStyle();
                            }
                            return new DecoratedCustomViewStyle();
                        }
                        return new InboxStyle();
                    }
                    return new BigPictureStyle();
                }
                return new BigTextStyle();
            }
            return null;
        }

        private void a(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        private int b() {
            Resources resources = this.f2319a.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float a2 = (a(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - a2) * dimensionPixelSize) + (a2 * dimensionPixelSize2));
        }

        private static Style b(String str) {
            if (str != null && Build.VERSION.SDK_INT >= 16) {
                if (str.equals(Notification.BigPictureStyle.class.getName())) {
                    return new BigPictureStyle();
                }
                if (str.equals(Notification.BigTextStyle.class.getName())) {
                    return new BigTextStyle();
                }
                if (str.equals(Notification.InboxStyle.class.getName())) {
                    return new InboxStyle();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    if (str.equals(Notification.MessagingStyle.class.getName())) {
                        return new MessagingStyle();
                    }
                    if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                        return new DecoratedCustomViewStyle();
                    }
                    return null;
                }
                return null;
            }
            return null;
        }

        static Style c(Bundle bundle) {
            Style a2 = a(bundle.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            return a2 != null ? a2 : (bundle.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) ? new MessagingStyle() : bundle.containsKey("android.picture") ? new BigPictureStyle() : bundle.containsKey("android.bigText") ? new BigTextStyle() : bundle.containsKey("android.textLines") ? new InboxStyle() : b(bundle.getString("android.template"));
        }

        static Style d(Bundle bundle) {
            Style c2 = c(bundle);
            if (c2 == null) {
                return null;
            }
            try {
                c2.a(bundle);
                return c2;
            } catch (ClassCastException e) {
                return null;
            }
        }

        public static Style extractStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return d(extras);
        }

        Bitmap a(IconCompat iconCompat, int i) {
            return a(iconCompat, i, 0);
        }

        protected String a() {
            return null;
        }

        protected void a(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f2320c = bundle.getCharSequence("android.summaryText");
                this.d = true;
            }
            this.b = bundle.getCharSequence("android.title.big");
        }

        public void addCompatExtras(Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.f2320c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String a2 = a();
            if (a2 != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, a2);
            }
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x02c4  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x02e2  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02f4  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0300  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x032e  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x03c6  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x03cb  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x03e0  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x03e6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.widget.RemoteViews applyStandardTemplate(boolean r11, int r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 1012
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        protected void b(Bundle bundle) {
            bundle.remove("android.summaryText");
            bundle.remove("android.title.big");
            bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        public Notification build() {
            Builder builder = this.f2319a;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            a(remoteViews);
            remoteViews.removeAllViews(R.id.notification_main_column);
            remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R.id.notification_main_column, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(R.id.notification_main_column_container, 0, b(), 0, 0);
            }
        }

        public Bitmap createColoredBitmap(int i, int i2) {
            return a(i, i2, 0);
        }

        public boolean displayCustomViewInline() {
            return false;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void setBuilder(Builder builder) {
            if (this.f2319a != builder) {
                this.f2319a = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompat$WearableExtender.class */
    public static final class WearableExtender implements Extender {
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Action> f2321a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private PendingIntent f2322c;
        private ArrayList<Notification> d;
        private Bitmap e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private String m;
        private String n;

        public WearableExtender() {
            this.f2321a = new ArrayList<>();
            this.b = 1;
            this.d = new ArrayList<>();
            this.g = 8388613;
            this.h = -1;
            this.i = 0;
            this.k = 80;
        }

        public WearableExtender(Notification notification) {
            this.f2321a = new ArrayList<>();
            this.b = 1;
            this.d = new ArrayList<>();
            this.g = 8388613;
            this.h = -1;
            this.i = 0;
            this.k = 80;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(AssistPushConsts.MSG_TYPE_ACTIONS);
                if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        if (Build.VERSION.SDK_INT >= 20) {
                            actionArr[i2] = NotificationCompat.a((Notification.Action) parcelableArrayList.get(i2));
                        } else if (Build.VERSION.SDK_INT >= 16) {
                            actionArr[i2] = NotificationCompatJellybean.a((Bundle) parcelableArrayList.get(i2));
                        }
                        i = i2 + 1;
                    }
                    Collections.addAll(this.f2321a, actionArr);
                }
                this.b = bundle.getInt("flags", 1);
                this.f2322c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] a2 = NotificationCompat.a(bundle, d.t);
                if (a2 != null) {
                    Collections.addAll(this.d, a2);
                }
                this.e = (Bitmap) bundle.getParcelable("background");
                this.f = bundle.getInt("contentIcon");
                this.g = bundle.getInt("contentIconGravity", 8388613);
                this.h = bundle.getInt("contentActionIndex", -1);
                this.i = bundle.getInt("customSizePreset", 0);
                this.j = bundle.getInt("customContentHeight");
                this.k = bundle.getInt("gravity", 80);
                this.l = bundle.getInt("hintScreenTimeout");
                this.m = bundle.getString("dismissalId");
                this.n = bundle.getString("bridgeTag");
            }
        }

        private static Notification.Action a(Action action) {
            Notification.Action.Builder builder;
            if (Build.VERSION.SDK_INT >= 23) {
                IconCompat iconCompat = action.getIconCompat();
                builder = new Notification.Action.Builder(iconCompat == null ? null : iconCompat.toIcon(), action.getTitle(), action.getActionIntent());
            } else {
                IconCompat iconCompat2 = action.getIconCompat();
                builder = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), action.getTitle(), action.getActionIntent());
            }
            Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                android.app.RemoteInput[] a2 = RemoteInput.a(remoteInputs);
                int length = a2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    builder.addRemoteInput(a2[i2]);
                    i = i2 + 1;
                }
            }
            return builder.build();
        }

        private void a(int i, boolean z) {
            if (z) {
                this.b = i | this.b;
            } else {
                this.b = i & this.b;
            }
        }

        public WearableExtender addAction(Action action) {
            this.f2321a.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.f2321a.addAll(list);
            return this;
        }

        @Deprecated
        public WearableExtender addPage(Notification notification) {
            this.d.add(notification);
            return this;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> list) {
            this.d.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.f2321a.clear();
            return this;
        }

        @Deprecated
        public WearableExtender clearPages() {
            this.d.clear();
            return this;
        }

        /* renamed from: clone */
        public WearableExtender m1270clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f2321a = new ArrayList<>(this.f2321a);
            wearableExtender.b = this.b;
            wearableExtender.f2322c = this.f2322c;
            wearableExtender.d = new ArrayList<>(this.d);
            wearableExtender.e = this.e;
            wearableExtender.f = this.f;
            wearableExtender.g = this.g;
            wearableExtender.h = this.h;
            wearableExtender.i = this.i;
            wearableExtender.j = this.j;
            wearableExtender.k = this.k;
            wearableExtender.l = this.l;
            wearableExtender.m = this.m;
            wearableExtender.n = this.n;
            return wearableExtender;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f2321a.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 16) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.f2321a.size());
                    Iterator<Action> it = this.f2321a.iterator();
                    while (it.hasNext()) {
                        Action next = it.next();
                        if (Build.VERSION.SDK_INT >= 20) {
                            arrayList.add(a(next));
                        } else if (Build.VERSION.SDK_INT >= 16) {
                            arrayList.add(NotificationCompatJellybean.a(next));
                        }
                    }
                    bundle.putParcelableArrayList(AssistPushConsts.MSG_TYPE_ACTIONS, arrayList);
                } else {
                    bundle.putParcelableArrayList(AssistPushConsts.MSG_TYPE_ACTIONS, null);
                }
            }
            int i = this.b;
            if (i != 1) {
                bundle.putInt("flags", i);
            }
            PendingIntent pendingIntent = this.f2322c;
            if (pendingIntent != null) {
                bundle.putParcelable("displayIntent", pendingIntent);
            }
            if (!this.d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.d;
                bundle.putParcelableArray(d.t, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.e;
            if (bitmap != null) {
                bundle.putParcelable("background", bitmap);
            }
            int i2 = this.f;
            if (i2 != 0) {
                bundle.putInt("contentIcon", i2);
            }
            int i3 = this.g;
            if (i3 != 8388613) {
                bundle.putInt("contentIconGravity", i3);
            }
            int i4 = this.h;
            if (i4 != -1) {
                bundle.putInt("contentActionIndex", i4);
            }
            int i5 = this.i;
            if (i5 != 0) {
                bundle.putInt("customSizePreset", i5);
            }
            int i6 = this.j;
            if (i6 != 0) {
                bundle.putInt("customContentHeight", i6);
            }
            int i7 = this.k;
            if (i7 != 80) {
                bundle.putInt("gravity", i7);
            }
            int i8 = this.l;
            if (i8 != 0) {
                bundle.putInt("hintScreenTimeout", i8);
            }
            String str = this.m;
            if (str != null) {
                bundle.putString("dismissalId", str);
            }
            String str2 = this.n;
            if (str2 != null) {
                bundle.putString("bridgeTag", str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.f2321a;
        }

        @Deprecated
        public Bitmap getBackground() {
            return this.e;
        }

        public String getBridgeTag() {
            return this.n;
        }

        public int getContentAction() {
            return this.h;
        }

        @Deprecated
        public int getContentIcon() {
            return this.f;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.g;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.b & 1) != 0;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.j;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.i;
        }

        public String getDismissalId() {
            return this.m;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            return this.f2322c;
        }

        @Deprecated
        public int getGravity() {
            return this.k;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.b & 32) != 0;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.b & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.b & 64) != 0;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.b & 2) != 0;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.l;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.b & 4) != 0;
        }

        @Deprecated
        public List<Notification> getPages() {
            return this.d;
        }

        public boolean getStartScrollBottom() {
            return (this.b & 8) != 0;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.n = str;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.h = i;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int i) {
            this.f = i;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int i) {
            this.g = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            a(1, z);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int i) {
            this.j = i;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int i) {
            this.i = i;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.m = str;
            return this;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.f2322c = pendingIntent;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int i) {
            this.k = i;
            return this;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            a(32, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            a(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            a(64, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            a(2, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int i) {
            this.l = i;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            a(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            a(8, z);
            return this;
        }
    }

    static Action a(Notification.Action action) {
        RemoteInput[] remoteInputArr;
        android.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
        IconCompat iconCompat = null;
        if (remoteInputs != null) {
            remoteInputArr = new RemoteInput[remoteInputs.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= remoteInputs.length) {
                    break;
                }
                android.app.RemoteInput remoteInput = remoteInputs[i2];
                remoteInputArr[i2] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
                i = i2 + 1;
            }
        } else {
            remoteInputArr = null;
        }
        boolean z = Build.VERSION.SDK_INT >= 24 ? action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies() : action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        boolean z2 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int semanticAction = Build.VERSION.SDK_INT >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0);
        boolean isContextual = Build.VERSION.SDK_INT >= 29 ? action.isContextual() : false;
        if (Build.VERSION.SDK_INT >= 23) {
            if (action.getIcon() != null || action.icon == 0) {
                if (action.getIcon() != null) {
                    iconCompat = IconCompat.createFromIconOrNullIfZeroResId(action.getIcon());
                }
                return new Action(iconCompat, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
            }
            return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
        }
        return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z, semanticAction, z2, isContextual);
    }

    static boolean a(Notification notification) {
        return (notification.flags & 128) != 0;
    }

    static Notification[] a(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= parcelableArray.length) {
                bundle.putParcelableArray(str, notificationArr);
                return notificationArr;
            }
            notificationArr[i2] = (Notification) parcelableArray[i2];
            i = i2 + 1;
        }
    }

    public static Action getAction(Notification notification, int i) {
        if (Build.VERSION.SDK_INT >= 20) {
            return a(notification.actions[i]);
        }
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT >= 16) {
                return NotificationCompatJellybean.getAction(notification, i);
            }
            return null;
        }
        Notification.Action action = notification.actions[i];
        SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        Bundle bundle = null;
        if (sparseParcelableArray != null) {
            bundle = (Bundle) sparseParcelableArray.get(i);
        }
        return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, bundle);
    }

    public static int getActionCount(Notification notification) {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 19) {
            if (notification.actions != null) {
                i = notification.actions.length;
            }
            return i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getActionCount(notification);
        } else {
            return 0;
        }
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static boolean getAutoCancel(Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static BubbleMetadata getBubbleMetadata(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static int getColor(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.color;
        }
        return 0;
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence("android.infoText");
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence("android.text");
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence("android.title");
    }

    public static Bundle getExtras(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static String getGroup(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return notification.getGroup();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    public static List<Action> getInvisibleActions(Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            Bundle bundle = notification.extras.getBundle("android.car.EXTENSIONS");
            if (bundle == null) {
                return arrayList;
            }
            Bundle bundle2 = bundle.getBundle("invisible_actions");
            if (bundle2 != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bundle2.size()) {
                        break;
                    }
                    arrayList.add(NotificationCompatJellybean.a(bundle2.getBundle(Integer.toString(i2))));
                    i = i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 20) {
            if ((notification.flags & 256) != 0) {
                z = true;
            }
            return z;
        } else if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            }
            return false;
        }
    }

    public static LocusIdCompat getLocusId(Notification notification) {
        LocusIdCompat locusIdCompat = null;
        if (Build.VERSION.SDK_INT >= 29) {
            LocusId locusId = notification.getLocusId();
            if (locusId == null) {
                return null;
            }
            locusIdCompat = LocusIdCompat.toLocusIdCompat(locusId);
        }
        return locusIdCompat;
    }

    public static boolean getOngoing(Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        return (notification.flags & 8) != 0;
    }

    public static List<Person> getPeople(Notification notification) {
        String[] stringArray;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Person.fromAndroidPerson((android.app.Person) it.next()));
                }
            }
        } else if (Build.VERSION.SDK_INT >= 19 && (stringArray = notification.extras.getStringArray("android.people")) != null && stringArray.length != 0) {
            int length = stringArray.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                arrayList.add(new Person.Builder().setUri(stringArray[i2]).build());
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.publicVersion;
        }
        return null;
    }

    public static CharSequence getSettingsText(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getSettingsText();
        }
        return null;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean("android.showWhen");
    }

    public static String getSortKey(Notification notification) {
        if (Build.VERSION.SDK_INT >= 20) {
            return notification.getSortKey();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence("android.subText");
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean("android.showChronometer");
    }

    public static int getVisibility(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.visibility;
        }
        return 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 20) {
            if ((notification.flags & 512) != 0) {
                z = true;
            }
            return z;
        } else if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            }
            return false;
        }
    }
}

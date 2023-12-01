package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationChannelCompat.class */
public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";

    /* renamed from: a  reason: collision with root package name */
    final String f2293a;
    CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    int f2294c;
    String d;
    String e;
    boolean f;
    Uri g;
    AudioAttributes h;
    boolean i;
    int j;
    boolean k;
    long[] l;
    String m;
    String n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationChannelCompat$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final NotificationChannelCompat f2295a;

        public Builder(String str, int i) {
            this.f2295a = new NotificationChannelCompat(str, i);
        }

        public NotificationChannelCompat build() {
            return this.f2295a;
        }

        public Builder setConversationId(String str, String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2295a.m = str;
                this.f2295a.n = str2;
            }
            return this;
        }

        public Builder setDescription(String str) {
            this.f2295a.d = str;
            return this;
        }

        public Builder setGroup(String str) {
            this.f2295a.e = str;
            return this;
        }

        public Builder setImportance(int i) {
            this.f2295a.f2294c = i;
            return this;
        }

        public Builder setLightColor(int i) {
            this.f2295a.j = i;
            return this;
        }

        public Builder setLightsEnabled(boolean z) {
            this.f2295a.i = z;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.f2295a.b = charSequence;
            return this;
        }

        public Builder setShowBadge(boolean z) {
            this.f2295a.f = z;
            return this;
        }

        public Builder setSound(Uri uri, AudioAttributes audioAttributes) {
            this.f2295a.g = uri;
            this.f2295a.h = audioAttributes;
            return this;
        }

        public Builder setVibrationEnabled(boolean z) {
            this.f2295a.k = z;
            return this;
        }

        public Builder setVibrationPattern(long[] jArr) {
            this.f2295a.k = jArr != null && jArr.length > 0;
            this.f2295a.l = jArr;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannelCompat(NotificationChannel notificationChannel) {
        this(notificationChannel.getId(), notificationChannel.getImportance());
        this.b = notificationChannel.getName();
        this.d = notificationChannel.getDescription();
        this.e = notificationChannel.getGroup();
        this.f = notificationChannel.canShowBadge();
        this.g = notificationChannel.getSound();
        this.h = notificationChannel.getAudioAttributes();
        this.i = notificationChannel.shouldShowLights();
        this.j = notificationChannel.getLightColor();
        this.k = notificationChannel.shouldVibrate();
        this.l = notificationChannel.getVibrationPattern();
        if (Build.VERSION.SDK_INT >= 30) {
            this.m = notificationChannel.getParentChannelId();
            this.n = notificationChannel.getConversationId();
        }
        this.o = notificationChannel.canBypassDnd();
        this.p = notificationChannel.getLockscreenVisibility();
        if (Build.VERSION.SDK_INT >= 29) {
            this.q = notificationChannel.canBubble();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.r = notificationChannel.isImportantConversation();
        }
    }

    NotificationChannelCompat(String str, int i) {
        this.f = true;
        this.g = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.j = 0;
        this.f2293a = (String) Preconditions.checkNotNull(str);
        this.f2294c = i;
        if (Build.VERSION.SDK_INT >= 21) {
            this.h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannel a() {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.f2293a, this.b, this.f2294c);
        notificationChannel.setDescription(this.d);
        notificationChannel.setGroup(this.e);
        notificationChannel.setShowBadge(this.f);
        notificationChannel.setSound(this.g, this.h);
        notificationChannel.enableLights(this.i);
        notificationChannel.setLightColor(this.j);
        notificationChannel.setVibrationPattern(this.l);
        notificationChannel.enableVibration(this.k);
        if (Build.VERSION.SDK_INT >= 30 && (str = this.m) != null && (str2 = this.n) != null) {
            notificationChannel.setConversationId(str, str2);
        }
        return notificationChannel;
    }

    public boolean canBubble() {
        return this.q;
    }

    public boolean canBypassDnd() {
        return this.o;
    }

    public boolean canShowBadge() {
        return this.f;
    }

    public AudioAttributes getAudioAttributes() {
        return this.h;
    }

    public String getConversationId() {
        return this.n;
    }

    public String getDescription() {
        return this.d;
    }

    public String getGroup() {
        return this.e;
    }

    public String getId() {
        return this.f2293a;
    }

    public int getImportance() {
        return this.f2294c;
    }

    public int getLightColor() {
        return this.j;
    }

    public int getLockscreenVisibility() {
        return this.p;
    }

    public CharSequence getName() {
        return this.b;
    }

    public String getParentChannelId() {
        return this.m;
    }

    public Uri getSound() {
        return this.g;
    }

    public long[] getVibrationPattern() {
        return this.l;
    }

    public boolean isImportantConversation() {
        return this.r;
    }

    public boolean shouldShowLights() {
        return this.i;
    }

    public boolean shouldVibrate() {
        return this.k;
    }

    public Builder toBuilder() {
        return new Builder(this.f2293a, this.f2294c).setName(this.b).setDescription(this.d).setGroup(this.e).setShowBadge(this.f).setSound(this.g, this.h).setLightsEnabled(this.i).setLightColor(this.j).setVibrationEnabled(this.k).setVibrationPattern(this.l).setConversationId(this.m, this.n);
    }
}

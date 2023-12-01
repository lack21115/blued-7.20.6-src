package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationChannelGroupCompat.class */
public class NotificationChannelGroupCompat {

    /* renamed from: a  reason: collision with root package name */
    final String f2296a;
    CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    String f2297c;
    private boolean d;
    private List<NotificationChannelCompat> e;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationChannelGroupCompat$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final NotificationChannelGroupCompat f2298a;

        public Builder(String str) {
            this.f2298a = new NotificationChannelGroupCompat(str);
        }

        public NotificationChannelGroupCompat build() {
            return this.f2298a;
        }

        public Builder setDescription(String str) {
            this.f2298a.f2297c = str;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.f2298a.b = charSequence;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup, List<NotificationChannel> list) {
        this(notificationChannelGroup.getId());
        this.b = notificationChannelGroup.getName();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2297c = notificationChannelGroup.getDescription();
        }
        if (Build.VERSION.SDK_INT < 28) {
            this.e = a(list);
            return;
        }
        this.d = notificationChannelGroup.isBlocked();
        this.e = a(notificationChannelGroup.getChannels());
    }

    NotificationChannelGroupCompat(String str) {
        this.e = Collections.emptyList();
        this.f2296a = (String) Preconditions.checkNotNull(str);
    }

    private List<NotificationChannelCompat> a(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : list) {
            if (this.f2296a.equals(notificationChannel.getGroup())) {
                arrayList.add(new NotificationChannelCompat(notificationChannel));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannelGroup a() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(this.f2296a, this.b);
        if (Build.VERSION.SDK_INT >= 28) {
            notificationChannelGroup.setDescription(this.f2297c);
        }
        return notificationChannelGroup;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.e;
    }

    public String getDescription() {
        return this.f2297c;
    }

    public String getId() {
        return this.f2296a;
    }

    public CharSequence getName() {
        return this.b;
    }

    public boolean isBlocked() {
        return this.d;
    }

    public Builder toBuilder() {
        return new Builder(this.f2296a).setName(this.b).setDescription(this.f2297c);
    }
}

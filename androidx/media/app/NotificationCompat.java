package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/app/NotificationCompat.class */
public class NotificationCompat {

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/app/NotificationCompat$DecoratedMediaCustomViewStyle.class */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void a(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", this.f2319a.getColor() != 0 ? this.f2319a.getColor() : this.f2319a.mContext.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int a(int i) {
            return i <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int b() {
            return this.f2319a.getContentView() != null ? R.layout.notification_template_media_custom : super.b();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.f2319a.getBigContentView() != null ? this.f2319a.getBigContentView() : this.f2319a.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews d = d();
            buildIntoRemoteViews(d, bigContentView);
            if (Build.VERSION.SDK_INT >= 21) {
                a(d);
            }
            return d;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = this.f2319a.getContentView() != null;
            if (Build.VERSION.SDK_INT < 21) {
                RemoteViews c2 = c();
                if (z) {
                    buildIntoRemoteViews(c2, this.f2319a.getContentView());
                    return c2;
                }
                return null;
            }
            boolean z2 = true;
            if (!z) {
                z2 = this.f2319a.getBigContentView() != null;
            }
            if (z2) {
                RemoteViews c3 = c();
                if (z) {
                    buildIntoRemoteViews(c3, this.f2319a.getContentView());
                }
                a(c3);
                return c3;
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.f2319a.getHeadsUpContentView() != null ? this.f2319a.getHeadsUpContentView() : this.f2319a.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews d = d();
            buildIntoRemoteViews(d, headsUpContentView);
            if (Build.VERSION.SDK_INT >= 21) {
                a(d);
            }
            return d;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/app/NotificationCompat$MediaStyle.class */
    public static class MediaStyle extends NotificationCompat.Style {
        int[] e = null;
        MediaSessionCompat.Token f;
        boolean g;
        PendingIntent h;

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews a(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.f2319a.mContext.getPackageName(), R.layout.notification_media_action);
            remoteViews.setImageViewResource(R.id.action0, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.action0, action.getTitle());
            }
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    Parcelable parcelable = extras.getParcelable("android.mediaSession");
                    if (parcelable != null) {
                        return MediaSessionCompat.Token.fromToken(parcelable);
                    }
                    return null;
                }
                IBinder binder = BundleCompat.getBinder(extras, "android.mediaSession");
                if (binder != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.writeStrongBinder(binder);
                    obtain.setDataPosition(0);
                    MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    return createFromParcel;
                }
                return null;
            }
            return null;
        }

        int a(int i) {
            return i <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        Notification.MediaStyle a(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.e;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(a(new Notification.MediaStyle()));
            } else if (this.g) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        int b() {
            return R.layout.notification_template_media;
        }

        RemoteViews c() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, b(), true);
            int size = this.f2319a.mActions.size();
            int[] iArr = this.e;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= min) {
                        break;
                    } else if (i2 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    } else {
                        applyStandardTemplate.addView(R.id.media_actions, a(this.f2319a.mActions.get(this.e[i2])));
                        i = i2 + 1;
                    }
                }
            }
            if (!this.g) {
                applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
                return applyStandardTemplate;
            }
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, this.h);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", this.f2319a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            return applyStandardTemplate;
        }

        RemoteViews d() {
            int min = Math.min(this.f2319a.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, a(min), false);
            applyStandardTemplate.removeAllViews(R.id.media_actions);
            if (min > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= min) {
                        break;
                    }
                    applyStandardTemplate.addView(R.id.media_actions, a(this.f2319a.mActions.get(i2)));
                    i = i2 + 1;
                }
            }
            if (!this.g) {
                applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
                return applyStandardTemplate;
            }
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", this.f2319a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, this.h);
            return applyStandardTemplate;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return d();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return c();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.h = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.e = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.g = z;
            }
            return this;
        }
    }

    private NotificationCompat() {
    }
}

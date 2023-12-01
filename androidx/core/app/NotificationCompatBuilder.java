package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.os.BuildCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompatBuilder.class */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2323a;
    private final Notification.Builder b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationCompat.Builder f2324c;
    private RemoteViews d;
    private RemoteViews e;
    private final List<Bundle> f = new ArrayList();
    private final Bundle g = new Bundle();
    private int h;
    private RemoteViews i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        List<String> a2;
        this.f2324c = builder;
        this.f2323a = builder.mContext;
        if (Build.VERSION.SDK_INT >= 26) {
            this.b = new Notification.Builder(builder.mContext, builder.I);
        } else {
            this.b = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.R;
        this.b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.b).setContentText(builder.f2310c).setContentInfo(builder.h).setContentIntent(builder.d).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.e, (notification.flags & 128) != 0).setLargeIcon(builder.g).setNumber(builder.i).setProgress(builder.r, builder.s, builder.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.b.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setSubText(builder.o).setUsesChronometer(builder.l).setPriority(builder.j);
            Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (builder.B != null) {
                this.g.putAll(builder.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.x) {
                    this.g.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                if (builder.u != null) {
                    this.g.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, builder.u);
                    if (builder.v) {
                        this.g.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.g.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                if (builder.w != null) {
                    this.g.putString(NotificationCompatExtras.EXTRA_SORT_KEY, builder.w);
                }
            }
            this.d = builder.F;
            this.e = builder.G;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.b.setShowWhen(builder.k);
        }
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21 && (a2 = a(a(builder.mPersonList), builder.mPeople)) != null && !a2.isEmpty()) {
            this.g.putStringArray("android.people", (String[]) a2.toArray(new String[a2.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.b.setLocalOnly(builder.x).setGroup(builder.u).setGroupSummary(builder.v).setSortKey(builder.w);
            this.h = builder.N;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setCategory(builder.A).setColor(builder.C).setVisibility(builder.D).setPublicVersion(builder.E).setSound(notification.sound, notification.audioAttributes);
            List<String> a3 = Build.VERSION.SDK_INT < 28 ? a(a(builder.mPersonList), builder.mPeople) : builder.mPeople;
            if (a3 != null && !a3.isEmpty()) {
                for (String str : a3) {
                    this.b.addPerson(str);
                }
            }
            this.i = builder.H;
            if (builder.f2309a.size() > 0) {
                Bundle bundle = builder.getExtras().getBundle("android.car.EXTENSIONS");
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= builder.f2309a.size()) {
                        break;
                    }
                    bundle4.putBundle(Integer.toString(i2), NotificationCompatJellybean.a(builder.f2309a.get(i2)));
                    i = i2 + 1;
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
                this.g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && builder.T != null) {
            this.b.setSmallIcon(builder.T);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.b.setExtras(builder.B).setRemoteInputHistory(builder.q);
            if (builder.F != null) {
                this.b.setCustomContentView(builder.F);
            }
            if (builder.G != null) {
                this.b.setCustomBigContentView(builder.G);
            }
            if (builder.H != null) {
                this.b.setCustomHeadsUpContentView(builder.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.setBadgeIconType(builder.J).setSettingsText(builder.p).setShortcutId(builder.K).setTimeoutAfter(builder.M).setGroupAlertBehavior(builder.N);
            if (builder.z) {
                this.b.setColorized(builder.y);
            }
            if (!TextUtils.isEmpty(builder.I)) {
                this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<Person> it2 = builder.mPersonList.iterator();
            while (it2.hasNext()) {
                this.b.addPerson(it2.next().toAndroidPerson());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(builder.P);
            this.b.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(builder.Q));
            if (builder.L != null) {
                this.b.setLocusId(builder.L.toLocusId());
            }
        }
        if (BuildCompat.isAtLeastS() && builder.O != 0) {
            this.b.setForegroundServiceBehavior(builder.O);
        }
        if (builder.S) {
            if (this.f2324c.v) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate(null);
            this.b.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.b.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f2324c.u)) {
                    this.b.setGroup("silent");
                }
                this.b.setGroupAlertBehavior(this.h);
            }
        }
    }

    private static List<String> a(List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person person : list) {
            arrayList.add(person.resolveToLegacyUri());
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    private void a(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        if (Build.VERSION.SDK_INT < 20) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, action));
                return;
            }
            return;
        }
        IconCompat iconCompat = action.getIconCompat();
        if (Build.VERSION.SDK_INT >= 23) {
            builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent());
        } else {
            builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        }
        if (action.getRemoteInputs() != null) {
            android.app.RemoteInput[] a2 = RemoteInput.a(action.getRemoteInputs());
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
        Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(action.getSemanticAction());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setContextual(action.isContextual());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        builder.addExtras(bundle);
        this.b.addAction(builder.build());
    }

    protected Notification a() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.b.build();
            if (this.h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.h == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.h == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.b.setExtras(this.g);
            Notification build2 = this.b.build();
            RemoteViews remoteViews = this.d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.h != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.h == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.h == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.b.setExtras(this.g);
            Notification build3 = this.b.build();
            RemoteViews remoteViews4 = this.d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.h != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.h == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.h == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.f);
            if (buildActionExtrasMap != null) {
                this.g.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            this.b.setExtras(this.g);
            Notification build4 = this.b.build();
            RemoteViews remoteViews6 = this.d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.b.build();
            Bundle extras = NotificationCompat.getExtras(build5);
            Bundle bundle = new Bundle(this.g);
            for (String str : this.g.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray<Bundle> buildActionExtrasMap2 = NotificationCompatJellybean.buildActionExtrasMap(this.f);
            if (buildActionExtrasMap2 != null) {
                NotificationCompat.getExtras(build5).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap2);
            }
            RemoteViews remoteViews8 = this.d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.b.getNotification();
        }
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.f2324c.n;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification a2 = a();
        if (makeContentView != null) {
            a2.contentView = makeContentView;
        } else if (this.f2324c.F != null) {
            a2.contentView = this.f2324c.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            a2.bigContentView = makeBigContentView;
        }
        if (Build.VERSION.SDK_INT >= 21 && style != null && (makeHeadsUpContentView = this.f2324c.n.makeHeadsUpContentView(this)) != null) {
            a2.headsUpContentView = makeHeadsUpContentView;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (extras = NotificationCompat.getExtras(a2)) != null) {
            style.addCompatExtras(extras);
        }
        return a2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.f2323a;
    }
}

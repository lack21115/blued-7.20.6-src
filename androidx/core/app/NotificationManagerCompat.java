package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat.class */
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    private static String b;
    private static SideChannelManager g;
    private final Context d;
    private final NotificationManager e;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2376a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f2377c = new HashSet();
    private static final Object f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$CancelTask.class */
    public static class CancelTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        final String f2378a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final String f2379c;
        final boolean d;

        CancelTask(String str) {
            this.f2378a = str;
            this.b = 0;
            this.f2379c = null;
            this.d = true;
        }

        CancelTask(String str, int i, String str2) {
            this.f2378a = str;
            this.b = i;
            this.f2379c = str2;
            this.d = false;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.d) {
                iNotificationSideChannel.cancelAll(this.f2378a);
            } else {
                iNotificationSideChannel.cancel(this.f2378a, this.b, this.f2379c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f2378a + ", id:" + this.b + ", tag:" + this.f2379c + ", all:" + this.d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$NotifyTask.class */
    public static class NotifyTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        final String f2380a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final String f2381c;
        final Notification d;

        NotifyTask(String str, int i, String str2, Notification notification) {
            this.f2380a = str;
            this.b = i;
            this.f2381c = str2;
            this.d = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f2380a, this.b, this.f2381c, this.d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f2380a + ", id:" + this.b + ", tag:" + this.f2381c + "]";
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$ServiceConnectedEvent.class */
    static class ServiceConnectedEvent {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2382a;
        final IBinder b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f2382a = componentName;
            this.b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$SideChannelManager.class */
    public static class SideChannelManager implements ServiceConnection, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2383a;
        private final HandlerThread b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f2384c;
        private final Map<ComponentName, ListenerRecord> d = new HashMap();
        private Set<String> e = new HashSet();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$SideChannelManager$ListenerRecord.class */
        public static class ListenerRecord {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f2385a;

            /* renamed from: c  reason: collision with root package name */
            INotificationSideChannel f2386c;
            boolean b = false;
            ArrayDeque<Task> d = new ArrayDeque<>();
            int e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f2385a = componentName;
            }
        }

        SideChannelManager(Context context) {
            this.f2383a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.b = handlerThread;
            handlerThread.start();
            this.f2384c = new Handler(this.b.getLooper(), this);
        }

        private void a() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f2383a);
            if (enabledListenerPackages.equals(this.e)) {
                return;
            }
            this.e = enabledListenerPackages;
            List<ResolveInfo> queryIntentServices = this.f2383a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.d.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        private void a(ComponentName componentName) {
            ListenerRecord listenerRecord = this.d.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f2386c = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.e = 0;
                d(listenerRecord);
            }
        }

        private void a(Task task) {
            a();
            for (ListenerRecord listenerRecord : this.d.values()) {
                listenerRecord.d.add(task);
                d(listenerRecord);
            }
        }

        private boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                return true;
            }
            listenerRecord.b = this.f2383a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.f2385a), this, 33);
            if (listenerRecord.b) {
                listenerRecord.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f2385a);
                this.f2383a.unbindService(this);
            }
            return listenerRecord.b;
        }

        private void b(ComponentName componentName) {
            ListenerRecord listenerRecord = this.d.get(componentName);
            if (listenerRecord != null) {
                d(listenerRecord);
            }
        }

        private void b(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                this.f2383a.unbindService(this);
                listenerRecord.b = false;
            }
            listenerRecord.f2386c = null;
        }

        private void c(ListenerRecord listenerRecord) {
            if (this.f2384c.hasMessages(3, listenerRecord.f2385a)) {
                return;
            }
            listenerRecord.e++;
            if (listenerRecord.e <= 6) {
                int i = (1 << (listenerRecord.e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f2384c.sendMessageDelayed(this.f2384c.obtainMessage(3, listenerRecord.f2385a), i);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.d.size() + " tasks to " + listenerRecord.f2385a + " after " + listenerRecord.e + " retries");
            listenerRecord.d.clear();
        }

        private void d(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f2385a + ", " + listenerRecord.d.size() + " queued tasks");
            }
            if (listenerRecord.d.isEmpty()) {
                return;
            }
            if (!a(listenerRecord) || listenerRecord.f2386c == null) {
                c(listenerRecord);
                return;
            }
            while (true) {
                Task peek = listenerRecord.d.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + peek);
                    }
                    peek.send(listenerRecord.f2386c);
                    listenerRecord.d.remove();
                } catch (DeadObjectException e) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f2385a);
                    }
                } catch (RemoteException e2) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f2385a, e2);
                }
            }
            if (listenerRecord.d.isEmpty()) {
                return;
            }
            c(listenerRecord);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                a((Task) message.obj);
                return true;
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                a(serviceConnectedEvent.f2382a, serviceConnectedEvent.b);
                return true;
            } else if (i == 2) {
                a((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                b((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2384c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2384c.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.f2384c.obtainMessage(0, task).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationManagerCompat$Task.class */
    public interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private NotificationManagerCompat(Context context) {
        this.d = context;
        this.e = (NotificationManager) context.getSystemService("notification");
    }

    private void a(Task task) {
        synchronized (f) {
            if (g == null) {
                g = new SideChannelManager(this.d.getApplicationContext());
            }
            g.queueTask(task);
        }
    }

    private static boolean a(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ENABLED_NOTIFICATION_LISTENERS);
        synchronized (f2376a) {
            if (string != null) {
                if (!string.equals(b)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i2]);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                        i = i2 + 1;
                    }
                    f2377c = hashSet;
                    b = string;
                }
            }
            set = f2377c;
        }
        return set;
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.e.areNotificationsEnabled();
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.d.getSystemService(Context.APP_OPS_SERVICE);
            ApplicationInfo applicationInfo = this.d.getApplicationInfo();
            String packageName = this.d.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                    return true;
                }
                z = false;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
                return true;
            }
        }
        return z;
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(String str, int i) {
        this.e.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.d.getPackageName(), i, str));
        }
    }

    public void cancelAll() {
        this.e.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a(new CancelTask(this.d.getPackageName()));
        }
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannel(NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.a());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat notificationChannelGroupCompat) {
        createNotificationChannelGroup(notificationChannelGroupCompat.a());
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (NotificationChannelGroupCompat notificationChannelGroupCompat : list) {
            arrayList.add(notificationChannelGroupCompat.a());
        }
        this.e.createNotificationChannelGroups(arrayList);
    }

    public void createNotificationChannels(List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.createNotificationChannels(list);
        }
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (NotificationChannelCompat notificationChannelCompat : list) {
            arrayList.add(notificationChannelCompat.a());
        }
        this.e.createNotificationChannels(arrayList);
    }

    public void deleteNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.e.deleteNotificationChannelGroup(str);
        }
    }

    public void deleteUnlistedNotificationChannels(Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel notificationChannel : this.e.getNotificationChannels()) {
                if (!collection.contains(notificationChannel.getId()) && (Build.VERSION.SDK_INT < 30 || !collection.contains(notificationChannel.getParentChannelId()))) {
                    this.e.deleteNotificationChannel(notificationChannel.getId());
                }
            }
        }
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.e.getImportance();
        }
        return -1000;
    }

    public NotificationChannel getNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.e.getNotificationChannel(str);
        }
        return null;
    }

    public NotificationChannel getNotificationChannel(String str, String str2) {
        return Build.VERSION.SDK_INT >= 30 ? this.e.getNotificationChannel(str, str2) : getNotificationChannel(str);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String str) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String str, String str2) {
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannel = getNotificationChannel(str, str2)) == null) {
            return null;
        }
        return new NotificationChannelCompat(notificationChannel);
    }

    public NotificationChannelGroup getNotificationChannelGroup(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.e.getNotificationChannelGroup(str);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
                if (notificationChannelGroup.getId().equals(str)) {
                    return notificationChannelGroup;
                }
            }
            return null;
        }
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String str) {
        NotificationChannelGroup notificationChannelGroup;
        if (Build.VERSION.SDK_INT >= 28) {
            NotificationChannelGroup notificationChannelGroup2 = getNotificationChannelGroup(str);
            if (notificationChannelGroup2 != null) {
                return new NotificationChannelGroupCompat(notificationChannelGroup2);
            }
            return null;
        } else if (Build.VERSION.SDK_INT < 26 || (notificationChannelGroup = getNotificationChannelGroup(str)) == null) {
            return null;
        } else {
            return new NotificationChannelGroupCompat(notificationChannelGroup, getNotificationChannels());
        }
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return Build.VERSION.SDK_INT >= 26 ? this.e.getNotificationChannelGroups() : Collections.emptyList();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannelGroup> notificationChannelGroups = getNotificationChannelGroups();
            if (!notificationChannelGroups.isEmpty()) {
                List<NotificationChannel> emptyList = Build.VERSION.SDK_INT >= 28 ? Collections.emptyList() : getNotificationChannels();
                ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
                for (NotificationChannelGroup notificationChannelGroup : notificationChannelGroups) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup));
                    } else {
                        arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup, emptyList));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public List<NotificationChannel> getNotificationChannels() {
        return Build.VERSION.SDK_INT >= 26 ? this.e.getNotificationChannels() : Collections.emptyList();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = getNotificationChannels();
            if (!notificationChannels.isEmpty()) {
                ArrayList arrayList = new ArrayList(notificationChannels.size());
                for (NotificationChannel notificationChannel : notificationChannels) {
                    arrayList.add(new NotificationChannelCompat(notificationChannel));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        if (!a(notification)) {
            this.e.notify(str, i, notification);
            return;
        }
        a(new NotifyTask(this.d.getPackageName(), i, str, notification));
        this.e.cancel(str, i);
    }
}

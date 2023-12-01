package android.content.pm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.os.Handler;
import android.os.UserHandle;
import android.util.AtomicFile;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.annotations.GuardedBy;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastXmlSerializer;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.tencent.mapsdk.internal.k2;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/RegisteredServicesCache.class */
public abstract class RegisteredServicesCache<V> {
    private static final boolean DEBUG = false;
    private static final String TAG = "PackageManager";
    private final String mAttributesName;
    public final Context mContext;
    private Handler mHandler;
    private final String mInterfaceName;
    private RegisteredServicesCacheListener<V> mListener;
    private final String mMetaDataName;
    private final AtomicFile mPersistentServicesFile;
    @GuardedBy("mServicesLock")
    private boolean mPersistentServicesFileDidNotExist;
    private final XmlSerializerAndParser<V> mSerializerAndParser;
    private final Object mServicesLock = new Object();
    @GuardedBy("mServicesLock")
    private final SparseArray<UserServices<V>> mUserServices = new SparseArray<>(2);
    private final BroadcastReceiver mPackageReceiver = new BroadcastReceiver() { // from class: android.content.pm.RegisteredServicesCache.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(Intent.EXTRA_UID, -1);
            if (intExtra != -1) {
                RegisteredServicesCache.this.handlePackageEvent(intent, UserHandle.getUserId(intExtra));
            }
        }
    };
    private final BroadcastReceiver mExternalReceiver = new BroadcastReceiver() { // from class: android.content.pm.RegisteredServicesCache.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RegisteredServicesCache.this.handlePackageEvent(intent, 0);
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/RegisteredServicesCache$ServiceInfo.class */
    public static class ServiceInfo<V> {
        public final ComponentName componentName;
        public final V type;
        public final int uid;

        public ServiceInfo(V v, ComponentName componentName, int i) {
            this.type = v;
            this.componentName = componentName;
            this.uid = i;
        }

        public String toString() {
            return "ServiceInfo: " + this.type + ", " + this.componentName + ", uid " + this.uid;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/RegisteredServicesCache$UserServices.class */
    public static class UserServices<V> {
        @GuardedBy("mServicesLock")
        public final Map<V, Integer> persistentServices;
        @GuardedBy("mServicesLock")
        public Map<V, ServiceInfo<V>> services;

        private UserServices() {
            this.persistentServices = Maps.newHashMap();
            this.services = null;
        }
    }

    public RegisteredServicesCache(Context context, String str, String str2, String str3, XmlSerializerAndParser<V> xmlSerializerAndParser) {
        this.mContext = context;
        this.mInterfaceName = str;
        this.mMetaDataName = str2;
        this.mAttributesName = str3;
        this.mSerializerAndParser = xmlSerializerAndParser;
        this.mPersistentServicesFile = new AtomicFile(new File(new File(new File(Environment.getDataDirectory(), "system"), "registered_services"), str + ".xml"));
        readPersistentServicesLocked();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        this.mContext.registerReceiverAsUser(this.mPackageReceiver, UserHandle.ALL, intentFilter, null, null);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        intentFilter2.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        this.mContext.registerReceiver(this.mExternalReceiver, intentFilter2);
    }

    private boolean containsType(ArrayList<ServiceInfo<V>> arrayList, V v) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).type.equals(v)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsTypeAndUid(ArrayList<ServiceInfo<V>> arrayList, V v, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ServiceInfo<V> serviceInfo = arrayList.get(i2);
            if (serviceInfo.type.equals(v) && serviceInfo.uid == i) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUid(int[] iArr, int i) {
        return iArr == null || ArrayUtils.contains(iArr, i);
    }

    private UserServices<V> findOrCreateUserLocked(int i) {
        UserServices<V> userServices = this.mUserServices.get(i);
        UserServices<V> userServices2 = userServices;
        if (userServices == null) {
            userServices2 = new UserServices<>();
            this.mUserServices.put(i, userServices2);
        }
        return userServices2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void generateServicesMap(int[] iArr, int i) {
        PackageManager packageManager = this.mContext.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServicesAsUser(new Intent(this.mInterfaceName), 128, i)) {
            try {
                ServiceInfo parseServiceInfo = parseServiceInfo(resolveInfo);
                if (parseServiceInfo == null) {
                    Log.w(TAG, "Unable to load service info " + resolveInfo.toString());
                } else {
                    arrayList.add(parseServiceInfo);
                }
            } catch (IOException e) {
                Log.w(TAG, "Unable to load service info " + resolveInfo.toString(), e);
            } catch (XmlPullParserException e2) {
                Log.w(TAG, "Unable to load service info " + resolveInfo.toString(), e2);
            }
        }
        synchronized (this.mServicesLock) {
            UserServices findOrCreateUserLocked = findOrCreateUserLocked(i);
            boolean z = findOrCreateUserLocked.services == null;
            if (z) {
                findOrCreateUserLocked.services = Maps.newHashMap();
            }
            new StringBuilder();
            boolean z2 = false;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ServiceInfo<V> serviceInfo = (ServiceInfo) it.next();
                Integer num = findOrCreateUserLocked.persistentServices.get(serviceInfo.type);
                if (num == null) {
                    findOrCreateUserLocked.services.put(serviceInfo.type, serviceInfo);
                    findOrCreateUserLocked.persistentServices.put(serviceInfo.type, Integer.valueOf(serviceInfo.uid));
                    if (this.mPersistentServicesFileDidNotExist) {
                        z2 = true;
                        if (!z) {
                        }
                    }
                    notifyListener(serviceInfo.type, i, false);
                    z2 = true;
                } else if (num.intValue() == serviceInfo.uid) {
                    findOrCreateUserLocked.services.put(serviceInfo.type, serviceInfo);
                } else if (inSystemImage(serviceInfo.uid) || !containsTypeAndUid(arrayList, serviceInfo.type, num.intValue())) {
                    z2 = true;
                    findOrCreateUserLocked.services.put(serviceInfo.type, serviceInfo);
                    findOrCreateUserLocked.persistentServices.put(serviceInfo.type, Integer.valueOf(serviceInfo.uid));
                    notifyListener(serviceInfo.type, i, false);
                }
            }
            ArrayList newArrayList = Lists.newArrayList();
            for (V v : findOrCreateUserLocked.persistentServices.keySet()) {
                if (!containsType(arrayList, v) && containsUid(iArr, findOrCreateUserLocked.persistentServices.get(v).intValue())) {
                    newArrayList.add(v);
                }
            }
            Iterator it2 = newArrayList.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                z2 = true;
                findOrCreateUserLocked.persistentServices.remove(next);
                findOrCreateUserLocked.services.remove(next);
                notifyListener(next, i, true);
            }
            if (z2) {
                writePersistentServicesLocked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePackageEvent(Intent intent, int i) {
        int[] intArrayExtra;
        String action = intent.getAction();
        boolean z = Intent.ACTION_PACKAGE_REMOVED.equals(action) || Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action);
        boolean booleanExtra = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
        if (z && booleanExtra) {
            return;
        }
        if (Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action) || Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action)) {
            intArrayExtra = intent.getIntArrayExtra(Intent.EXTRA_CHANGED_UID_LIST);
        } else {
            int intExtra = intent.getIntExtra(Intent.EXTRA_UID, -1);
            intArrayExtra = null;
            if (intExtra > 0) {
                intArrayExtra = new int[]{intExtra};
            }
        }
        generateServicesMap(intArrayExtra, i);
    }

    private boolean inSystemImage(int i) {
        boolean z;
        String[] packagesForUid = this.mContext.getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            z = false;
            if (i3 >= length) {
                break;
            }
            try {
                if ((this.mContext.getPackageManager().getPackageInfo(packagesForUid[i3], 0).applicationInfo.flags & 1) != 0) {
                    z = true;
                    break;
                }
                i2 = i3 + 1;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
        return z;
    }

    private void notifyListener(final V v, final int i, final boolean z) {
        final RegisteredServicesCacheListener<V> registeredServicesCacheListener;
        Handler handler;
        synchronized (this) {
            registeredServicesCacheListener = this.mListener;
            handler = this.mHandler;
        }
        if (registeredServicesCacheListener == null) {
            return;
        }
        handler.post(new Runnable() { // from class: android.content.pm.RegisteredServicesCache.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                registeredServicesCacheListener.onServiceChanged(v, i, z);
            }
        });
    }

    private ServiceInfo<V> parseServiceInfo(ResolveInfo resolveInfo) throws XmlPullParserException, IOException {
        int next;
        ServiceInfo<V> serviceInfo;
        android.content.pm.ServiceInfo serviceInfo2 = resolveInfo.serviceInfo;
        ComponentName componentName = new ComponentName(serviceInfo2.packageName, serviceInfo2.name);
        PackageManager packageManager = this.mContext.getPackageManager();
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser loadXmlMetaData = serviceInfo2.loadXmlMetaData(packageManager, this.mMetaDataName);
                if (loadXmlMetaData == null) {
                    throw new XmlPullParserException("No " + this.mMetaDataName + " meta-data");
                }
                AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                do {
                    next = loadXmlMetaData.next();
                    if (next == 1) {
                        break;
                    }
                } while (next != 2);
                if (this.mAttributesName.equals(loadXmlMetaData.getName())) {
                    V parseServiceAttributes = parseServiceAttributes(packageManager.getResourcesForApplication(serviceInfo2.applicationInfo), serviceInfo2.packageName, asAttributeSet);
                    if (parseServiceAttributes == null) {
                        serviceInfo = null;
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                            serviceInfo = null;
                        }
                    } else {
                        ServiceInfo<V> serviceInfo3 = new ServiceInfo<>(parseServiceAttributes, componentName, resolveInfo.serviceInfo.applicationInfo.uid);
                        serviceInfo = serviceInfo3;
                        if (loadXmlMetaData != null) {
                            loadXmlMetaData.close();
                            return serviceInfo3;
                        }
                    }
                    return serviceInfo;
                }
                throw new XmlPullParserException("Meta-data does not start with " + this.mAttributesName + " tag");
            } catch (PackageManager.NameNotFoundException e) {
                throw new XmlPullParserException("Unable to load resources for pacakge " + serviceInfo2.packageName);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void readPersistentServicesLocked() {
        int next;
        this.mUserServices.clear();
        if (this.mSerializerAndParser == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                this.mPersistentServicesFileDidNotExist = !this.mPersistentServicesFile.getBaseFile().exists();
                if (this.mPersistentServicesFileDidNotExist) {
                    if (0 != 0) {
                        try {
                            throw new NullPointerException();
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                FileInputStream openRead = this.mPersistentServicesFile.openRead();
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openRead, null);
                for (int eventType = newPullParser.getEventType(); eventType != 2 && eventType != 1; eventType = newPullParser.next()) {
                }
                if (k2.d.equals(newPullParser.getName())) {
                    int next2 = newPullParser.next();
                    do {
                        if (next2 == 2) {
                            fileInputStream = openRead;
                            fileInputStream2 = openRead;
                            if (newPullParser.getDepth() == 2 && "service".equals(newPullParser.getName())) {
                                V createFromXml = this.mSerializerAndParser.createFromXml(newPullParser);
                                if (createFromXml == null) {
                                    break;
                                }
                                int parseInt = Integer.parseInt(newPullParser.getAttributeValue(null, "uid"));
                                findOrCreateUserLocked(UserHandle.getUserId(parseInt)).persistentServices.put(createFromXml, Integer.valueOf(parseInt));
                            }
                        }
                        next = newPullParser.next();
                        next2 = next;
                    } while (next != 1);
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                fileInputStream2 = fileInputStream;
                Log.w(TAG, "Error reading persistent services, starting from scratch", e3);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } catch (Throwable th) {
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
    }

    private void writePersistentServicesLocked() {
        if (this.mSerializerAndParser == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream startWrite = this.mPersistentServicesFile.startWrite();
            FastXmlSerializer fastXmlSerializer = new FastXmlSerializer();
            fastXmlSerializer.setOutput(startWrite, "utf-8");
            fastXmlSerializer.startDocument(null, true);
            fastXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            fastXmlSerializer.startTag(null, k2.d);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mUserServices.size()) {
                    fastXmlSerializer.endTag(null, k2.d);
                    fastXmlSerializer.endDocument();
                    fileOutputStream = startWrite;
                    this.mPersistentServicesFile.finishWrite(startWrite);
                    return;
                }
                for (Map.Entry<V, Integer> entry : this.mUserServices.valueAt(i2).persistentServices.entrySet()) {
                    fastXmlSerializer.startTag(null, "service");
                    fastXmlSerializer.attribute(null, "uid", Integer.toString(entry.getValue().intValue()));
                    this.mSerializerAndParser.writeAsXml(entry.getKey(), fastXmlSerializer);
                    fastXmlSerializer.endTag(null, "service");
                }
                i = i2 + 1;
            }
        } catch (IOException e) {
            Log.w(TAG, "Error writing accounts", e);
            if (fileOutputStream != null) {
                this.mPersistentServicesFile.failWrite(fileOutputStream);
            }
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr, int i) {
        synchronized (this.mServicesLock) {
            UserServices<V> findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services != null) {
                printWriter.println("RegisteredServicesCache: " + findOrCreateUserLocked.services.size() + " services");
                Iterator<ServiceInfo<V>> it = findOrCreateUserLocked.services.values().iterator();
                while (it.hasNext()) {
                    printWriter.println("  " + it.next());
                }
            } else {
                printWriter.println("RegisteredServicesCache: services not loaded");
            }
        }
    }

    public Collection<ServiceInfo<V>> getAllServices(int i) {
        Collection<ServiceInfo<V>> unmodifiableCollection;
        synchronized (this.mServicesLock) {
            UserServices<V> findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services == null) {
                generateServicesMap(null, i);
            }
            unmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(findOrCreateUserLocked.services.values()));
        }
        return unmodifiableCollection;
    }

    public RegisteredServicesCacheListener<V> getListener() {
        RegisteredServicesCacheListener<V> registeredServicesCacheListener;
        synchronized (this) {
            registeredServicesCacheListener = this.mListener;
        }
        return registeredServicesCacheListener;
    }

    public ServiceInfo<V> getServiceInfo(V v, int i) {
        ServiceInfo<V> serviceInfo;
        synchronized (this.mServicesLock) {
            UserServices<V> findOrCreateUserLocked = findOrCreateUserLocked(i);
            if (findOrCreateUserLocked.services == null) {
                generateServicesMap(null, i);
            }
            serviceInfo = findOrCreateUserLocked.services.get(v);
        }
        return serviceInfo;
    }

    public void invalidateCache(int i) {
        synchronized (this.mServicesLock) {
            findOrCreateUserLocked(i).services = null;
        }
    }

    public abstract V parseServiceAttributes(Resources resources, String str, AttributeSet attributeSet);

    public void setListener(RegisteredServicesCacheListener<V> registeredServicesCacheListener, Handler handler) {
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler(this.mContext.getMainLooper());
        }
        synchronized (this) {
            this.mHandler = handler2;
            this.mListener = registeredServicesCacheListener;
        }
    }
}

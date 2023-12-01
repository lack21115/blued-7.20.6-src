package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel.class */
public class ActivityChooserModel extends DataSetObservable {
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;

    /* renamed from: a  reason: collision with root package name */
    static final String f1721a = ActivityChooserModel.class.getSimpleName();
    private static final Object e = new Object();
    private static final Map<String, ActivityChooserModel> f = new HashMap();
    final Context b;

    /* renamed from: c  reason: collision with root package name */
    final String f1722c;
    private Intent j;
    private OnChooseActivityListener p;
    private final Object g = new Object();
    private final List<ActivityResolveInfo> h = new ArrayList();
    private final List<HistoricalRecord> i = new ArrayList();
    private ActivitySorter k = new DefaultSorter();
    private int l = 50;
    boolean d = true;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$ActivityChooserModelClient.class */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$ActivityResolveInfo.class */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$ActivitySorter.class */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$DefaultSorter.class */
    static final class DefaultSorter implements ActivitySorter {

        /* renamed from: a  reason: collision with root package name */
        private final Map<ComponentName, ActivityResolveInfo> f1723a = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.f1723a;
            map.clear();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ActivityResolveInfo activityResolveInfo = list.get(i2);
                activityResolveInfo.weight = 0.0f;
                map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
                i = i2 + 1;
            }
            int size2 = list2.size() - 1;
            float f = 1.0f;
            while (true) {
                float f2 = f;
                if (size2 < 0) {
                    Collections.sort(list);
                    return;
                }
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                float f3 = f2;
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f2;
                    f3 = f2 * 0.95f;
                }
                size2--;
                f = f3;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord.class */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                HistoricalRecord historicalRecord = (HistoricalRecord) obj;
                ComponentName componentName = this.activity;
                if (componentName == null) {
                    if (historicalRecord.activity != null) {
                        return false;
                    }
                } else if (!componentName.equals(historicalRecord.activity)) {
                    return false;
                }
                return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
            }
            return false;
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$OnChooseActivityListener.class */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask.class */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Finally extract failed */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        newSerializer.setOutput(openFileOutput, null);
                        newSerializer.startDocument("UTF-8", true);
                        newSerializer.startTag(null, "historical-records");
                        int size = list.size();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                            newSerializer.startTag(null, "historical-record");
                            newSerializer.attribute(null, "activity", historicalRecord.activity.flattenToString());
                            newSerializer.attribute(null, "time", String.valueOf(historicalRecord.time));
                            newSerializer.attribute(null, "weight", String.valueOf(historicalRecord.weight));
                            newSerializer.endTag(null, "historical-record");
                            i = i2 + 1;
                        }
                        newSerializer.endTag(null, "historical-records");
                        newSerializer.endDocument();
                        ActivityChooserModel.this.d = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    } catch (IOException e) {
                        String str2 = ActivityChooserModel.f1721a;
                        Log.e(str2, "Error writing historical record file: " + ActivityChooserModel.this.f1722c, e);
                        ActivityChooserModel.this.d = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    } catch (IllegalArgumentException e2) {
                        String str3 = ActivityChooserModel.f1721a;
                        Log.e(str3, "Error writing historical record file: " + ActivityChooserModel.this.f1722c, e2);
                        ActivityChooserModel.this.d = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    } catch (IllegalStateException e3) {
                        String str4 = ActivityChooserModel.f1721a;
                        Log.e(str4, "Error writing historical record file: " + ActivityChooserModel.this.f1722c, e3);
                        ActivityChooserModel.this.d = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    }
                    try {
                        openFileOutput.close();
                        return null;
                    } catch (IOException e4) {
                        return null;
                    }
                } catch (Throwable th) {
                    ActivityChooserModel.this.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                String str5 = ActivityChooserModel.f1721a;
                Log.e(str5, "Error writing historical record file: " + str, e6);
                return null;
            }
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.b = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f1722c = str;
            return;
        }
        this.f1722c = str + ".xml";
    }

    private void a() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.f1722c)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.f1722c);
        }
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.i.add(historicalRecord);
        if (add) {
            this.n = true;
            f();
            a();
            c();
            notifyChanged();
        }
        return add;
    }

    private void b() {
        boolean d = d();
        boolean e2 = e();
        f();
        if (d || e2) {
            c();
            notifyChanged();
        }
    }

    private boolean c() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.sort(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean d() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean e() {
        if (this.d && this.n && !TextUtils.isEmpty(this.f1722c)) {
            this.d = false;
            this.m = true;
            g();
            return true;
        }
        return false;
    }

    private void f() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.i.remove(0);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0144, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.g():void");
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (e) {
            ActivityChooserModel activityChooserModel2 = f.get(str);
            activityChooserModel = activityChooserModel2;
            if (activityChooserModel2 == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                f.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    public Intent chooseActivity(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            b();
            ActivityResolveInfo activityResolveInfo = this.h.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            b();
            resolveInfo = this.h.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.g) {
            b();
            size = this.h.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            b();
            List<ActivityResolveInfo> list = this.h;
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return -1;
                }
                if (list.get(i2).resolveInfo == resolveInfo) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.g) {
            b();
            if (this.h.isEmpty()) {
                return null;
            }
            return this.h.get(0).resolveInfo;
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.g) {
            i = this.l;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.g) {
            b();
            size = this.i.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.g) {
            intent = this.j;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.g) {
            if (this.k == activitySorter) {
                return;
            }
            this.k = activitySorter;
            if (c()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i) {
        synchronized (this.g) {
            b();
            ActivityResolveInfo activityResolveInfo = this.h.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.h.get(0);
            a(new HistoricalRecord(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f));
        }
    }

    public void setHistoryMaxSize(int i) {
        synchronized (this.g) {
            if (this.l == i) {
                return;
            }
            this.l = i;
            f();
            if (c()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.g) {
            if (this.j == intent) {
                return;
            }
            this.j = intent;
            this.o = true;
            b();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.g) {
            this.p = onChooseActivityListener;
        }
    }
}

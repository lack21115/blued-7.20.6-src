package com.blued.android.core.imagecache;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.blued.android.core.utils.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/AutoClearImageDiskCache.class */
public class AutoClearImageDiskCache {

    /* renamed from: a  reason: collision with root package name */
    private static AutoClearImageDiskCache f9570a;
    private ClearTask b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask.class */
    public static class ClearTask extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private String f9571a;

        public ClearTask(String str) {
            this.f9571a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            try {
                try {
                    if (!TextUtils.isEmpty(this.f9571a)) {
                        File file = new File(this.f9571a);
                        if (file.exists() && file.isDirectory()) {
                            File[] listFiles = file.listFiles();
                            if (listFiles != null && listFiles.length > 100) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                try {
                                    Arrays.sort(listFiles, new LastModifiedFileComparator());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= listFiles.length / 3) {
                                        return true;
                                    }
                                    File file2 = listFiles[i2];
                                    Log.a("AutoClearImageDiskCache", "delete " + file2.getName() + "\t" + simpleDateFormat.format(new Date(file2.lastModified())));
                                    file2.delete();
                                    i = i2 + 1;
                                }
                            }
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool != null) {
                bool.booleanValue();
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/AutoClearImageDiskCache$CountCheckTask.class */
    static class CountCheckTask extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private String f9572a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            String[] list;
            try {
                if (!TextUtils.isEmpty(this.f9572a)) {
                    File file = new File(this.f9572a);
                    if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                        Log.a("AutoClearImageDiskCache", "image count:" + list.length);
                        if (list.length >= 5000) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            AutoClearImageDiskCache.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/AutoClearImageDiskCache$LastModifiedFileComparator.class */
    public static class LastModifiedFileComparator implements Comparator {
        private LastModifiedFileComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            int i = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0L ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0L ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i > 0 ? 1 : 0;
        }
    }

    public static AutoClearImageDiskCache a() {
        AutoClearImageDiskCache autoClearImageDiskCache;
        synchronized (AutoClearImageDiskCache.class) {
            try {
                if (f9570a == null) {
                    f9570a = new AutoClearImageDiskCache();
                }
                autoClearImageDiskCache = f9570a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return autoClearImageDiskCache;
    }

    public void b() {
        synchronized (this) {
            Log.a("AutoClearImageDiskCache", "startClearTask()");
            boolean z = true;
            if (this.b != null) {
                AsyncTask.Status status = this.b.getStatus();
                if (status != AsyncTask.Status.PENDING) {
                    z = true;
                    if (status == AsyncTask.Status.RUNNING) {
                    }
                }
                z = false;
            }
            if (z) {
                String a2 = RecyclingUtils.a();
                if (!TextUtils.isEmpty(a2)) {
                    ClearTask clearTask = new ClearTask(a2);
                    this.b = clearTask;
                    clearTask.execute(new Void[0]);
                }
            }
        }
    }
}

package android.content.res;

import android.content.res.Resources;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/ConfigurationBoundResourceCache.class */
public class ConfigurationBoundResourceCache<T> {
    private final ArrayMap<String, LongSparseArray<WeakReference<ConstantState<T>>>> mCache = new ArrayMap<>();
    final Resources mResources;

    public ConfigurationBoundResourceCache(Resources resources) {
        this.mResources = resources;
    }

    private void onConfigurationChangeInt(LongSparseArray<WeakReference<ConstantState<T>>> longSparseArray, int i) {
        int size = longSparseArray.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                return;
            }
            ConstantState<T> constantState = longSparseArray.valueAt(i2).get();
            if (constantState == null || Configuration.needNewResources(i, constantState.getChangingConfigurations())) {
                longSparseArray.removeAt(i2);
            }
            size = i2;
        }
    }

    public T get(long j, Resources.Theme theme) {
        String key = theme != null ? theme.getKey() : "";
        synchronized (this) {
            LongSparseArray<WeakReference<ConstantState<T>>> longSparseArray = this.mCache.get(key);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<ConstantState<T>> weakReference = longSparseArray.get(j);
            if (weakReference != null) {
                ConstantState<T> constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newInstance(this.mResources, theme);
                }
                synchronized (this) {
                    longSparseArray.delete(j);
                }
                return null;
            }
            return null;
        }
    }

    public void onConfigurationChange(int i) {
        synchronized (this) {
            int size = this.mCache.size();
            while (true) {
                int i2 = size - 1;
                if (i2 >= 0) {
                    LongSparseArray<WeakReference<ConstantState<T>>> valueAt = this.mCache.valueAt(i2);
                    onConfigurationChangeInt(valueAt, i);
                    if (valueAt.size() == 0) {
                        this.mCache.removeAt(i2);
                    }
                    size = i2;
                }
            }
        }
    }

    public void put(long j, Resources.Theme theme, ConstantState<T> constantState) {
        if (constantState == null) {
            return;
        }
        String key = theme == null ? "" : theme.getKey();
        synchronized (this) {
            LongSparseArray<WeakReference<ConstantState<T>>> longSparseArray = this.mCache.get(key);
            LongSparseArray<WeakReference<ConstantState<T>>> longSparseArray2 = longSparseArray;
            if (longSparseArray == null) {
                longSparseArray2 = new LongSparseArray<>(1);
                this.mCache.put(key, longSparseArray2);
            }
            longSparseArray2.put(j, new WeakReference<>(constantState));
        }
    }
}

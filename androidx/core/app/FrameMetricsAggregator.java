package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/FrameMetricsAggregator.class */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;

    /* renamed from: a  reason: collision with root package name */
    private FrameMetricsBaseImpl f2326a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/FrameMetricsAggregator$FrameMetricsApi24Impl.class */
    static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static HandlerThread e;
        private static Handler f;

        /* renamed from: a  reason: collision with root package name */
        int f2327a;
        SparseIntArray[] b = new SparseIntArray[9];
        private ArrayList<WeakReference<Activity>> d = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f2328c = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                if ((FrameMetricsApi24Impl.this.f2327a & 1) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[0], frameMetrics.getMetric(8));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 2) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.b[1], frameMetrics.getMetric(1));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 4) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.b[2], frameMetrics.getMetric(3));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 8) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.b[3], frameMetrics.getMetric(4));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 16) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.b[4], frameMetrics.getMetric(5));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 64) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.b[6], frameMetrics.getMetric(7));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 32) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.b[5], frameMetrics.getMetric(6));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 128) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.b[7], frameMetrics.getMetric(0));
                }
                if ((FrameMetricsApi24Impl.this.f2327a & 256) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.b[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i) {
            this.f2327a = i;
        }

        void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            if (e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                e = handlerThread;
                handlerThread.start();
                f = new Handler(e.getLooper());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 8) {
                    activity.getWindow().addOnFrameMetricsAvailableListener(this.f2328c, f);
                    this.d.add(new WeakReference<>(activity));
                    return;
                }
                SparseIntArray[] sparseIntArrayArr = this.b;
                if (sparseIntArrayArr[i2] == null && (this.f2327a & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.b;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.d.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f2328c);
            return this.b;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] sparseIntArrayArr = this.b;
            this.b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            int size = this.d.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return this.b;
                }
                WeakReference<Activity> weakReference = this.d.get(i);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f2328c);
                    this.d.remove(i);
                }
                size = i;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/FrameMetricsAggregator$FrameMetricsBaseImpl.class */
    static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public void add(Activity activity) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity activity) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/FrameMetricsAggregator$MetricType.class */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2326a = new FrameMetricsApi24Impl(i);
        } else {
            this.f2326a = new FrameMetricsBaseImpl();
        }
    }

    public void add(Activity activity) {
        this.f2326a.add(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.f2326a.getMetrics();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.f2326a.remove(activity);
    }

    public SparseIntArray[] reset() {
        return this.f2326a.reset();
    }

    public SparseIntArray[] stop() {
        return this.f2326a.stop();
    }
}

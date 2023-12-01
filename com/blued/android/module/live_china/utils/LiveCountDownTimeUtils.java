package com.blued.android.module.live_china.utils;

import android.os.CountDownTimer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils.class */
public final class LiveCountDownTimeUtils {
    public static final Companion a = new Companion(null);
    private static final Lazy<LiveCountDownTimeUtils> d = LazyKt.a(new Function0<LiveCountDownTimeUtils>() { // from class: com.blued.android.module.live_china.utils.LiveCountDownTimeUtils$Companion$INSTANCE$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveCountDownTimeUtils invoke() {
            return new LiveCountDownTimeUtils();
        }
    });
    private LiveCountDownTime b;
    private long c = 1000;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveCountDownTimeUtils a() {
            return (LiveCountDownTimeUtils) LiveCountDownTimeUtils.d.getValue();
        }

        public final LiveCountDownTimeUtils b() {
            return a();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$CountDownFinishListener.class */
    public interface CountDownFinishListener {
        void a();

        void a(long j);
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$LiveCountDownTime.class */
    public final class LiveCountDownTime extends CountDownTimer {
        private final CountDownFinishListener a;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CountDownFinishListener countDownFinishListener = this.a;
            if (countDownFinishListener == null) {
                return;
            }
            countDownFinishListener.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CountDownFinishListener countDownFinishListener = this.a;
            if (countDownFinishListener == null) {
                return;
            }
            countDownFinishListener.a(j);
        }
    }

    public final void a() {
        LiveCountDownTime liveCountDownTime = this.b;
        if (liveCountDownTime == null) {
            return;
        }
        liveCountDownTime.cancel();
    }
}

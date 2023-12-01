package kotlin.concurrent;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/concurrent/TimersKt$timerTask$1.class */
public final class TimersKt$timerTask$1 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<TimerTask, Unit> f42445a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f42445a.invoke(this);
    }
}

package kotlinx.coroutines.debug;

import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/AgentPremain.class */
public final class AgentPremain {

    /* renamed from: a  reason: collision with root package name */
    public static final AgentPremain f43014a = new AgentPremain();
    private static final boolean b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer.class */
    public static final class DebugProbesTransformer implements ClassFileTransformer {

        /* renamed from: a  reason: collision with root package name */
        public static final DebugProbesTransformer f43015a = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }
    }

    static {
        Object f;
        try {
            Result.Companion companion = Result.f42293a;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            f = Result.f(property == null ? null : Boolean.valueOf(Boolean.parseBoolean(property)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            f = Result.f(ResultKt.a(th));
        }
        if (Result.b(f)) {
            f = null;
        }
        Boolean bool = (Boolean) f;
        b = bool == null ? DebugProbesImpl.f43034a.a() : bool.booleanValue();
    }

    private AgentPremain() {
    }
}

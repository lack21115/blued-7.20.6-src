package kotlinx.coroutines.debug;

import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/AgentPremain.class */
public final class AgentPremain {
    public static final AgentPremain a = new AgentPremain();
    private static final boolean b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer.class */
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        public static final DebugProbesTransformer a = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }
    }

    static {
        Object f;
        try {
            Result.Companion companion = Result.a;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            f = Result.f(property == null ? null : Boolean.valueOf(Boolean.parseBoolean(property)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        if (Result.b(f)) {
            f = null;
        }
        Boolean bool = (Boolean) f;
        b = bool == null ? DebugProbesImpl.a.a() : bool.booleanValue();
    }

    private AgentPremain() {
    }
}

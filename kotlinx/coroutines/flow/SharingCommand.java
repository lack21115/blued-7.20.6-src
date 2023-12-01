package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharingCommand.class */
public enum SharingCommand {
    START,
    STOP,
    STOP_AND_RESET_REPLAY_CACHE;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static SharingCommand[] valuesCustom() {
        SharingCommand[] valuesCustom = values();
        return (SharingCommand[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}

package kotlinx.coroutines.channels;

import java.util.Arrays;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/BufferOverflow.class */
public enum BufferOverflow {
    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BufferOverflow[] valuesCustom() {
        BufferOverflow[] valuesCustom = values();
        return (BufferOverflow[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}

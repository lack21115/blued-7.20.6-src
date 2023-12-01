package kotlinx.coroutines.channels;

import java.util.Arrays;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/TickerMode.class */
public enum TickerMode {
    FIXED_PERIOD,
    FIXED_DELAY;

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static TickerMode[] valuesCustom() {
        TickerMode[] valuesCustom = values();
        return (TickerMode[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}

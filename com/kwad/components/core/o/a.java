package com.kwad.components.core.o;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/o/a.class */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.pm();
        return b.wrapInputStream(inputStream);
    }
}

package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/INativeAdvanceLoadListener.class */
public interface INativeAdvanceLoadListener {
    void onAdFailed(int i, String str);

    void onAdSuccess(List<INativeAdvanceData> list);
}

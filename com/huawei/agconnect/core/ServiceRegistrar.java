package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/ServiceRegistrar.class */
public interface ServiceRegistrar {
    List<Service> getServices(Context context);

    void initialize(Context context);
}

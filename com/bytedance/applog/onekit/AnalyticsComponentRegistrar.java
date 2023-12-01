package com.bytedance.applog.onekit;

import android.content.Context;
import com.bytedance.bdtracker.e1;
import com.volcengine.onekit.component.Component;
import com.volcengine.onekit.component.ComponentContainer;
import com.volcengine.onekit.component.ComponentFactory;
import com.volcengine.onekit.component.ComponentRegistrar;
import com.volcengine.onekit.component.Dependency;
import com.volcengine.onekit.model.InitOptions;
import com.volcengine.onekit.service.Analytics;
import com.volcengine.onekit.service.AppInfo;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/onekit/AnalyticsComponentRegistrar.class */
public class AnalyticsComponentRegistrar implements ComponentRegistrar {
    public static /* synthetic */ Analytics a(ComponentContainer componentContainer) {
        return new e1();
    }

    public List<Component> getComponents() {
        return Arrays.asList(Component.builder(Analytics.class, new Class[0]).addDependency(Dependency.required(Context.class)).addDependency(Dependency.required(AppInfo.class)).addDependency(Dependency.required(InitOptions.class)).enablePrivacy().factory(new ComponentFactory() { // from class: com.bytedance.applog.onekit.-$$Lambda$HMFAkl03CBcSQqxS8ZrHLWoClUs
            public final Object create(ComponentContainer componentContainer) {
                return AnalyticsComponentRegistrar.a(componentContainer);
            }
        }).build());
    }
}

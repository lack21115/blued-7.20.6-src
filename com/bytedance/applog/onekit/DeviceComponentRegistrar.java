package com.bytedance.applog.onekit;

import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.bdtracker.f1;
import com.bytedance.bdtracker.g1;
import com.volcengine.onekit.component.Component;
import com.volcengine.onekit.component.ComponentContainer;
import com.volcengine.onekit.component.ComponentFactory;
import com.volcengine.onekit.component.ComponentRegistrar;
import com.volcengine.onekit.component.Dependency;
import com.volcengine.onekit.service.Analytics;
import com.volcengine.onekit.service.Device;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/onekit/DeviceComponentRegistrar.class */
public class DeviceComponentRegistrar implements ComponentRegistrar {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/onekit/DeviceComponentRegistrar$a.class */
    public class a implements ComponentFactory<Device> {
        public a(DeviceComponentRegistrar deviceComponentRegistrar) {
        }

        public Object create(ComponentContainer componentContainer) {
            if (TextUtils.isEmpty(AppLog.getDid())) {
                AppLog.addDataObserver(new f1(this, componentContainer));
                return null;
            }
            return new g1();
        }
    }

    public List<Component> getComponents() {
        return Arrays.asList(Component.builder(Device.class, new Class[0]).addDependency(Dependency.required(Analytics.class)).enablePrivacy().factory(new a(this)).build());
    }
}

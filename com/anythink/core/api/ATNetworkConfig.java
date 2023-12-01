package com.anythink.core.api;

import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATNetworkConfig.class */
public class ATNetworkConfig {
    List<ATInitConfig> mATInitConfigList;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATNetworkConfig$Builder.class */
    public static class Builder {
        List<ATInitConfig> mATInitConfigs;

        public ATNetworkConfig build() {
            ATNetworkConfig aTNetworkConfig = new ATNetworkConfig();
            aTNetworkConfig.mATInitConfigList = this.mATInitConfigs;
            return aTNetworkConfig;
        }

        public Builder withInitConfigList(List<ATInitConfig> list) {
            this.mATInitConfigs = list;
            return this;
        }
    }

    public List<ATInitConfig> getATInitConfigList() {
        return this.mATInitConfigList;
    }
}

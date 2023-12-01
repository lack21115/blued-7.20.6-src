package com.bytedance.android.live.base.api;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.android.live.saas.middleware.alog.ALogConfig;
import com.bytedance.android.live.saas.middleware.applog.AppLogConfig;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/ILiveHostContextParam.class */
public interface ILiveHostContextParam {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/ILiveHostContextParam$Builder.class */
    public static class Builder {
        private ALogConfig aLogConfig;
        private IHostActivityProvider activityProvider;
        private int aid;
        private int appIcon;
        private AppLogConfig appLogConfig;
        private String appName;
        private String channel;
        private Application context;
        private String generalAppId;
        private ILiveHostActionParam hostActionParam;
        private boolean isBoe;
        private boolean isDebug;
        private MethodChannelService methodChannelService;
        private String partner;
        private String partnerSecret;
        private String ttSDKAppId;
        private String ttSDKCertAssetsPath;
        private String version;
        private int versionCode;
        private String cjAppId = "";
        private String cjMerchantId = "";
        private String nativeLibraryDir = "";
        private PartnerExtra partnerExtra = null;
        private Map<String, String> feParamsExtra = null;
        private String ecHostAppId = null;
        private String clientKey = "";
        private boolean needInitNetwork = true;
        private ILiveHostWebViewParam hostWebViewParam = new DefaultHostWebViewParam();
        private IHostTokenInjectionAuth injectionAuth = null;
        private IUserIdGetter userIdGetter = new IUserIdGetter() { // from class: com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.1
            @Override // com.bytedance.android.live.base.api.ILiveHostContextParam.IUserIdGetter
            public String getUserId() {
                return "";
            }
        };
        private IHostPermission hostPermission = new DefaultHostPermission();

        /* JADX INFO: Access modifiers changed from: private */
        public Builder copy(Builder builder) {
            Builder builder2 = new Builder();
            Field[] declaredFields = Builder.class.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return builder2;
                }
                Field field = declaredFields[i2];
                boolean isAccessible = field.isAccessible();
                if (!isAccessible) {
                    field.setAccessible(true);
                }
                field.set(builder2, field.get(builder));
                field.setAccessible(isAccessible);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public PackageInfo getPackageInfo(Application application) {
            try {
                return application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public ILiveHostContextParam build() {
            if (this.partner == null || this.partnerSecret == null) {
                throw new IllegalArgumentException("partner & partnerSecret is required");
            }
            return new ILiveHostContextParam() { // from class: com.bytedance.android.live.base.api.ILiveHostContextParam.Builder.2
                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public ALogConfig getALogConfig() {
                    return Builder.this.aLogConfig;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getAid() {
                    return Builder.this.aid;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getAppIcon() {
                    if (Builder.this.appIcon == 0) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        if (packageInfo != null && packageInfo.applicationInfo != null) {
                            return packageInfo.applicationInfo.icon;
                        }
                    }
                    return Builder.this.appIcon;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public AppLogConfig getAppLogConfig() {
                    return Builder.this.appLogConfig;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getAppName() {
                    if (Builder.this.appName == null) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        if (packageInfo != null && packageInfo.applicationInfo != null) {
                            return packageInfo.applicationInfo.name;
                        }
                    }
                    return Builder.this.appName;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getCJAppId() {
                    return Builder.this.cjAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getCJMerchantId() {
                    return Builder.this.cjMerchantId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getChannel() {
                    return Builder.this.channel;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getClientKey() {
                    return Builder.this.clientKey;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Application getContext() {
                    return Builder.this.context;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean getDebug() {
                    return Builder.this.isDebug;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getECHostAppId() {
                    return Builder.this.ecHostAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Map<String, String> getFEParamsExtra() {
                    return Builder.this.feParamsExtra;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getGeneralAppId() {
                    return Builder.this.generalAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public ILiveHostActionParam getHostAction() {
                    return Builder.this.hostActionParam;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Class<?> getHostActivity(int i) {
                    return Builder.this.activityProvider.getHostActivity(i);
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IHostPermission getHostPermission() {
                    return Builder.this.hostPermission;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public ILiveHostWebViewParam getHostWebViewParam() {
                    return Builder.this.hostWebViewParam;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getNativeLibraryDir() {
                    return Builder.this.nativeLibraryDir;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getPartner() {
                    return Builder.this.partner;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public PartnerExtra getPartnerExtra() {
                    return Builder.this.partnerExtra;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getPartnerSecret() {
                    return Builder.this.partnerSecret;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getTtSDKAppId() {
                    return Builder.this.ttSDKAppId;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getTtSDKCertAssetsPath() {
                    return Builder.this.ttSDKCertAssetsPath;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public String getVersion() {
                    if (Builder.this.version == null) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        return (packageInfo == null || packageInfo.versionName == null) ? "1.0.0-default" : packageInfo.versionName;
                    }
                    return Builder.this.version;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public int getVersionCode() {
                    if (Builder.this.versionCode == 0) {
                        Builder builder = Builder.this;
                        PackageInfo packageInfo = builder.getPackageInfo(builder.context);
                        if (packageInfo != null) {
                            return packageInfo.versionCode;
                        }
                        return 1;
                    }
                    return Builder.this.versionCode;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IHostTokenInjectionAuth injectAccount() {
                    return Builder.this.injectionAuth;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean isBoe() {
                    return Builder.this.isBoe;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public boolean isNeedInitNetwork() {
                    return Builder.this.needInitNetwork;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public MethodChannelService provideMethodChannel() {
                    return Builder.this.methodChannelService;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public IUserIdGetter provideUserIdGetter() {
                    return Builder.this.userIdGetter;
                }

                @Override // com.bytedance.android.live.base.api.ILiveHostContextParam
                public Builder toBuilder() {
                    try {
                        return Builder.this.copy(this);
                    } catch (Exception e) {
                        return this;
                    }
                }
            };
        }

        public Builder provideMethodChannel(MethodChannelService methodChannelService) {
            this.methodChannelService = methodChannelService;
            return this;
        }

        public Builder setALogConfig(ALogConfig aLogConfig) {
            this.aLogConfig = aLogConfig;
            return this;
        }

        public Builder setActivityProvider(IHostActivityProvider iHostActivityProvider) {
            this.activityProvider = iHostActivityProvider;
            return this;
        }

        public Builder setAid(int i) {
            this.aid = i;
            return this;
        }

        public Builder setAppIcon(int i) {
            this.appIcon = i;
            return this;
        }

        public Builder setAppLogConfig(AppLogConfig appLogConfig) {
            this.appLogConfig = appLogConfig;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setCjAppId(String str) {
            this.cjAppId = str;
            return this;
        }

        public Builder setCjMerchantId(String str) {
            this.cjMerchantId = str;
            return this;
        }

        public Builder setClientKey(String str) {
            this.clientKey = str;
            return this;
        }

        public Builder setContext(Application application) {
            this.context = application;
            return this;
        }

        public Builder setECHostAppId(String str) {
            this.ecHostAppId = str;
            return this;
        }

        public Builder setFeParamsExtra(Map<String, String> map) {
            this.feParamsExtra = map;
            return this;
        }

        public Builder setGeneralAppId(String str) {
            this.generalAppId = str;
            return this;
        }

        public Builder setHostActionParam(ILiveHostActionParam iLiveHostActionParam) {
            this.hostActionParam = iLiveHostActionParam;
            return this;
        }

        public Builder setHostPermission(IHostPermission iHostPermission) {
            if (iHostPermission != null) {
                this.hostPermission = iHostPermission;
            }
            return this;
        }

        public Builder setHostWebViewParam(ILiveHostWebViewParam iLiveHostWebViewParam) {
            this.hostWebViewParam = iLiveHostWebViewParam;
            return this;
        }

        public Builder setInjectionAuth(IHostTokenInjectionAuth iHostTokenInjectionAuth) {
            this.injectionAuth = iHostTokenInjectionAuth;
            return this;
        }

        public Builder setIsBoe(boolean z) {
            this.isBoe = z;
            return this;
        }

        public Builder setIsDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setIsNeedInitNetwork(boolean z) {
            this.needInitNetwork = z;
            return this;
        }

        public Builder setNativeLibraryDir(String str) {
            this.nativeLibraryDir = str;
            return this;
        }

        public Builder setPartner(String str) {
            this.partner = str;
            return this;
        }

        public Builder setPartnerExtra(PartnerExtra partnerExtra) {
            this.partnerExtra = partnerExtra;
            return this;
        }

        public Builder setPartnerSecret(String str) {
            this.partnerSecret = str;
            return this;
        }

        public Builder setTtSDKAppId(String str) {
            this.ttSDKAppId = str;
            return this;
        }

        public Builder setTtSDKCertAssetsPath(String str) {
            this.ttSDKCertAssetsPath = str;
            return this;
        }

        public Builder setUserIdGetter(IUserIdGetter iUserIdGetter) {
            this.userIdGetter = iUserIdGetter;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public Builder setVersionCode(int i) {
            this.versionCode = i;
            return this;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/ILiveHostContextParam$IHostActivityProvider.class */
    public interface IHostActivityProvider {
        Class<?> getHostActivity(int i);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/ILiveHostContextParam$IUserIdGetter.class */
    public interface IUserIdGetter {
        String getUserId();
    }

    ALogConfig getALogConfig();

    int getAid();

    int getAppIcon();

    AppLogConfig getAppLogConfig();

    String getAppName();

    String getCJAppId();

    String getCJMerchantId();

    String getChannel();

    String getClientKey();

    Application getContext();

    boolean getDebug();

    String getECHostAppId();

    Map<String, String> getFEParamsExtra();

    String getGeneralAppId();

    ILiveHostActionParam getHostAction();

    Class<?> getHostActivity(int i);

    IHostPermission getHostPermission();

    ILiveHostWebViewParam getHostWebViewParam();

    String getNativeLibraryDir();

    String getPartner();

    PartnerExtra getPartnerExtra();

    String getPartnerSecret();

    String getTtSDKAppId();

    String getTtSDKCertAssetsPath();

    String getVersion();

    int getVersionCode();

    IHostTokenInjectionAuth injectAccount();

    boolean isBoe();

    boolean isNeedInitNetwork();

    MethodChannelService provideMethodChannel();

    IUserIdGetter provideUserIdGetter();

    Builder toBuilder();
}

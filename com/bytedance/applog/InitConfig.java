package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.bdtracker.j1;
import com.bytedance.bdtracker.y3;
import com.bytedance.mpaas.IEncryptor;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/InitConfig.class */
public class InitConfig {
    public String A;
    public Map<String, Object> B;
    public Account C;
    public boolean D;
    public INetworkClient E;
    public boolean G;
    public String L;
    public String M;
    public ISensitiveInfoProvider N;
    public List<String> T;
    public String W;
    public boolean X;

    /* renamed from: a  reason: collision with root package name */
    public String f7564a;

    /* renamed from: c  reason: collision with root package name */
    public String f7565c;
    public String d;
    public IEncryptor e;
    public String f;
    public String g;
    public ILogger h;
    public String i;
    public String j;
    public IPicker k;
    public boolean l;
    public boolean n;
    public String p;
    public boolean q;
    public String r;
    public UriConfig s;
    public String t;
    public String u;
    public int v;
    public int w;
    public int x;
    public String y;
    public String z;
    public boolean b = true;
    public boolean m = false;
    public int o = 0;
    public boolean F = true;
    public boolean H = false;
    public boolean I = true;
    public boolean J = true;
    public boolean K = true;
    public boolean O = true;
    public boolean P = true;
    public boolean Q = false;
    public boolean R = true;
    public boolean S = false;
    public boolean U = false;
    public boolean V = true;
    public IpcDataChecker Y = null;
    public String Z = null;
    public boolean a0 = true;
    public boolean b0 = false;
    public boolean c0 = false;
    public int d0 = -1;
    public boolean e0 = true;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/InitConfig$IpcDataChecker.class */
    public interface IpcDataChecker {
        boolean checkIpcData(String[] strArr);
    }

    public InitConfig(String str, String str2) {
        j1.a(TextUtils.isEmpty(str), "App id must not be empty!");
        j1.a(TextUtils.isEmpty(str2), "Channel must not be empty!");
        this.f7564a = str;
        this.f7565c = str2;
    }

    public boolean autoStart() {
        return this.b;
    }

    public InitConfig clearABCacheOnUserChange(boolean z) {
        this.V = z;
        return this;
    }

    public void clearDidAndIid(String str) {
        this.D = true;
        this.d = str;
    }

    public InitConfig disableDeferredALink() {
        this.U = false;
        return this;
    }

    public InitConfig enableDeferredALink() {
        this.U = true;
        return this;
    }

    public Account getAccount() {
        return this.C;
    }

    public String getAid() {
        return this.f7564a;
    }

    public String getAliyunUdid() {
        return this.j;
    }

    public boolean getAnonymous() {
        return this.l;
    }

    public String getAppImei() {
        return this.W;
    }

    public String getAppName() {
        return this.r;
    }

    public String getChannel() {
        return this.f7565c;
    }

    public String getClearKey() {
        return this.d;
    }

    public Map<String, Object> getCommonHeader() {
        return this.B;
    }

    public String getDbName() {
        if (TextUtils.isEmpty(this.L)) {
            return j1.a((Object) this.f7564a) + "@bd_tea_agent.db";
        }
        return this.L;
    }

    public int getDeferDeepLinkRetryCount() {
        return this.d0;
    }

    public IEncryptor getEncryptor() {
        return this.e;
    }

    public String getGoogleAid() {
        return this.f;
    }

    public List<String> getH5BridgeAllowlist() {
        return this.T;
    }

    public IpcDataChecker getIpcDataChecker() {
        return this.Y;
    }

    public String getLanguage() {
        return this.g;
    }

    public boolean getLocalTest() {
        return this.m;
    }

    public ILogger getLogger() {
        return this.h;
    }

    public String getManifestVersion() {
        return this.y;
    }

    public int getManifestVersionCode() {
        return this.x;
    }

    public INetworkClient getNetworkClient() {
        return this.E;
    }

    public boolean getNotReuqestSender() {
        return this.q;
    }

    public IPicker getPicker() {
        return this.k;
    }

    public y3 getPreInstallCallback() {
        return null;
    }

    public int getProcess() {
        return this.o;
    }

    public String getRegion() {
        return this.i;
    }

    public String getReleaseBuild() {
        return this.p;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.N;
    }

    public String getSpName() {
        return this.M;
    }

    public String getTweakedChannel() {
        return this.u;
    }

    public int getUpdateVersionCode() {
        return this.w;
    }

    public UriConfig getUriConfig() {
        return this.s;
    }

    public String getUserUniqueId() {
        return this.Z;
    }

    public String getVersion() {
        return this.t;
    }

    public int getVersionCode() {
        return this.v;
    }

    public String getVersionMinor() {
        return this.z;
    }

    public String getZiJieCloudPkg() {
        return this.A;
    }

    public boolean isAbEnable() {
        return this.H;
    }

    public boolean isAutoActive() {
        return this.F;
    }

    public boolean isAutoTrackEnabled() {
        return this.I;
    }

    public boolean isAutoTrackFragmentEnabled() {
        return this.c0;
    }

    public boolean isClearABCacheOnUserChange() {
        return this.V;
    }

    public boolean isClearDidAndIid() {
        return this.D;
    }

    public boolean isCongestionControlEnable() {
        return this.K;
    }

    public boolean isDeferredALinkEnabled() {
        return this.U;
    }

    public boolean isEventFilterEnable() {
        return this.X;
    }

    public boolean isH5BridgeEnable() {
        return this.Q;
    }

    public boolean isH5CollectEnable() {
        return this.R;
    }

    public boolean isHandleLifeCycle() {
        return this.J;
    }

    public boolean isHarmonyEnabled() {
        return this.b0;
    }

    public boolean isImeiEnable() {
        return this.P;
    }

    public boolean isLogEnable() {
        return this.S;
    }

    public boolean isMacEnable() {
        return this.O;
    }

    public boolean isMetaSecEnabled() {
        return this.e0;
    }

    public boolean isPlayEnable() {
        return this.n;
    }

    public boolean isSilenceInBackground() {
        return this.G;
    }

    public boolean isTrackEventEnabled() {
        return this.a0;
    }

    public InitConfig putCommonHeader(Map<String, Object> map) {
        this.B = map;
        return this;
    }

    public void setAbEnable(boolean z) {
        this.H = z;
    }

    public InitConfig setAccount(Account account) {
        this.C = account;
        return this;
    }

    public InitConfig setAliyunUdid(String str) {
        this.j = str;
        return this;
    }

    public InitConfig setAnonymous(boolean z) {
        this.l = z;
        return this;
    }

    public void setAppImei(String str) {
        this.W = str;
    }

    public InitConfig setAppName(String str) {
        this.r = str;
        return this;
    }

    public void setAutoActive(boolean z) {
        this.F = z;
    }

    public InitConfig setAutoStart(boolean z) {
        this.b = z;
        return this;
    }

    public void setAutoTrackEnabled(boolean z) {
        this.I = z;
    }

    public void setAutoTrackFragmentEnabled(boolean z) {
        this.c0 = z;
    }

    public void setChannel(String str) {
        this.f7565c = str;
    }

    public void setCongestionControlEnable(boolean z) {
        this.K = z;
    }

    public InitConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.L = str;
        }
        return this;
    }

    public void setDeferDeepLinkRetryCount(int i) {
        if (i < 0) {
            i = -1;
        }
        this.d0 = i;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.n = z;
        return this;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor) {
        this.e = iEncryptor;
        return this;
    }

    public void setEventFilterEnable(boolean z) {
        this.X = z;
    }

    public InitConfig setGoogleAid(String str) {
        this.f = str;
        return this;
    }

    public InitConfig setH5BridgeAllowlist(List<String> list) {
        this.T = list;
        return this;
    }

    public InitConfig setH5BridgeEnable(boolean z) {
        this.Q = z;
        return this;
    }

    public InitConfig setH5CollectEnable(boolean z) {
        this.R = z;
        return this;
    }

    public void setHandleLifeCycle(boolean z) {
        this.J = z;
    }

    public void setHarmonyEnable(boolean z) {
        this.b0 = z;
    }

    public InitConfig setImeiEnable(boolean z) {
        this.P = z;
        return this;
    }

    public InitConfig setIpcDataChecker(IpcDataChecker ipcDataChecker) {
        this.Y = ipcDataChecker;
        return this;
    }

    public InitConfig setLanguage(String str) {
        this.g = str;
        return this;
    }

    public InitConfig setLocalTest(boolean z) {
        this.m = z;
        return this;
    }

    public InitConfig setLogEnable(boolean z) {
        this.S = z;
        return this;
    }

    public InitConfig setLogger(ILogger iLogger) {
        this.h = iLogger;
        return this;
    }

    public void setMacEnable(boolean z) {
        this.O = z;
    }

    public InitConfig setMainProcess() {
        this.o = 1;
        return this;
    }

    public InitConfig setManifestVersion(String str) {
        this.y = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.x = i;
        return this;
    }

    public void setMetaSecEnable(boolean z) {
        this.e0 = z;
    }

    public InitConfig setNetworkClient(INetworkClient iNetworkClient) {
        this.E = iNetworkClient;
        return this;
    }

    public InitConfig setNotRequestSender(boolean z) {
        this.q = z;
        return this;
    }

    public InitConfig setPicker(IPicker iPicker) {
        this.k = iPicker;
        return this;
    }

    public InitConfig setPreInstallChannelCallback(y3 y3Var) {
        return this;
    }

    public InitConfig setProcess(int i) {
        this.o = i;
        return this;
    }

    public InitConfig setRegion(String str) {
        this.i = str;
        return this;
    }

    public InitConfig setReleaseBuild(String str) {
        this.p = str;
        return this;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.N = iSensitiveInfoProvider;
    }

    public void setSilenceInBackground(boolean z) {
        this.G = z;
    }

    public InitConfig setSpName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.M = str;
        }
        return this;
    }

    public void setTrackEventEnabled(boolean z) {
        this.a0 = z;
    }

    public InitConfig setTweakedChannel(String str) {
        this.u = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.w = i;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        this.s = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.s = uriConfig;
        return this;
    }

    public InitConfig setUserUniqueId(String str) {
        this.Z = str;
        return this;
    }

    public InitConfig setVersion(String str) {
        this.t = str;
        return this;
    }

    public InitConfig setVersionCode(int i) {
        this.v = i;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.z = str;
        return this;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.A = str;
        return this;
    }
}

package com.blued.android.module.live.im.biz;

import android.os.Build;
import cn.irisgw.live.LiveConnect;
import cn.irisgw.live.LiveConnectorGrpc;
import com.blued.android.module.im.grpc.BaseConnector;
import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.live.im.LiveIMConfig;
import com.blued.android.statistics.util.DeviceUtils;
import com.blued.android.statistics.util.Utils;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import io.grpc.MethodDescriptor;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/im/biz/LiveConnector.class */
public final class LiveConnector extends BaseConnector {
    public LiveConnector(ChannelManager channelManager) {
        super(channelManager);
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public ApmProtos.GrpcConnectTypeProto.BUSINESS a() {
        return ApmProtos.GrpcConnectTypeProto.BUSINESS.LIVE_CHAT;
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public Any a(Any any) throws Exception {
        if (any.is(LiveConnect.LiveBasePackage.class)) {
            LiveConnect.LiveBasePackage unpack = any.unpack(LiveConnect.LiveBasePackage.class);
            if (unpack.getNeedAck()) {
                LiveConnect.LiveBasePackageAck m4715build = LiveConnect.LiveBasePackageAck.newBuilder().setPackageId(unpack.getPackageId()).m4715build();
                if (LiveIMConfig.b()) {
                    LiveIMConfig.a().b(">> sendAck : ", m4715build);
                }
                b(Any.pack(m4715build));
            }
            return unpack.getBody();
        }
        return null;
    }

    public void a(String str, String str2, String str3, String str4) {
        try {
            LiveConnect.LiveSetting m4762build = LiveConnect.LiveSetting.newBuilder().setAppVersion(Utils.b(str)).setPlatform(Utils.b(str2)).setLanguage(Utils.b(str3)).setOsVersion(Utils.b(Build.VERSION.RELEASE)).setDevice(Utils.b(DeviceUtils.a())).setChannel(Utils.b(str4)).m4762build();
            if (LiveIMConfig.b()) {
                LiveIMConfig.a().b(">> sendSetting : ", m4762build);
            }
            b(Any.pack(m4762build));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public boolean b() {
        return LiveIMConfig.b();
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public MethodDescriptor c() {
        return LiveConnectorGrpc.getConnectMethod();
    }

    @Override // com.blued.android.module.im.grpc.BaseConnector
    public void d() {
    }
}

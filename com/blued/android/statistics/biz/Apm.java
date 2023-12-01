package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.ApmManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import io.grpc.internal.GrpcUtil;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Apm.class */
public final class Apm {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Apm$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Apm a = new Apm();

        private InstanceHolder() {
        }
    }

    private Apm() {
    }

    public static Apm a() {
        return InstanceHolder.a;
    }

    private void a(ApmProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        ApmManager.a().a((ApmManager) builder.build());
    }

    public void a(long j) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.OPEN_TIME).setTakes((int) j).setExtra(Any.pack(ApmProtos.OpenTimeTypeProto.newBuilder().build())));
        } catch (Exception e) {
        }
    }

    public void a(ApmProtos.GrpcConnectTypeProto.BUSINESS business, int i, long j, Throwable th, String str, String str2) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_CONNECT).setTakes((int) j).setCode(i).setDescription(Utils.a(th)).setExtra(Any.pack(ApmProtos.GrpcConnectTypeProto.newBuilder().setBusiness(business).setHost(Utils.b(str)).setPort((int) GrpcUtil.DEFAULT_PORT_SSL).setServerIp(Utils.b(str2)).build())));
        } catch (Exception e) {
        }
    }

    public void a(ApmProtos.GrpcRequestTypeProto.BUSINESS business, String str, int i, long j, String str2, Throwable th, String str3, String str4) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_REQUEST).setCode(i).setTakes((int) j).setServerRequestId(Utils.b(str2)).setDescription(Utils.a(th)).setExtra(Any.pack(ApmProtos.GrpcRequestTypeProto.newBuilder().setBusiness(business).setName(Utils.b(str)).setHost(Utils.b(str3)).setPort((int) GrpcUtil.DEFAULT_PORT_SSL).setServerIp(Utils.b(str4)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, int i, String str2) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.ALERT).setCode(i).setDescription(Utils.b(str2)).setExtra(Any.pack(ApmProtos.AlertTypeProto.newBuilder().setName(Utils.b(str)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, int i, String str2, long j) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setCode(200).setTakes((int) j).setExtra(Any.pack(ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.b(str)).setPort(i).setServerIp(Utils.b(str2)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, int i, String str2, long j, long j2, String str3) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(i).setTakes((int) j2).setExtra(Any.pack(ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.b(str)).setResponseType(Utils.b(str2)).setResponseLength((int) j).setServerIp(Utils.b(str3)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, int i, String str2, Throwable th, long j) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setTakes((int) j).setCode(100).setDescription(Utils.a(th)).setExtra(Any.pack(ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.b(str)).setPort(i).setServerIp(Utils.b(str2)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, int i, String str2, Throwable th, long j, String str3) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(i).setTakes((int) j).setDescription(Utils.a(th)).setExtra(Any.pack(ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.b(str)).setResponseType(Utils.b(str2)).setServerIp(Utils.b(str3)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, long j) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int) j).setCode(200).setExtra(Any.pack(ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.b(str)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, long j, int i, String str2) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int) j).setCode(i).setDescription(Utils.b(str2)).setExtra(Any.pack(ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.b(str)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, long j, String str2, int i, String str3) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(200).setTakes((int) j).setExtra(Any.pack(ApmProtos.ImTypeProto.newBuilder().setName(Utils.b(str)).setHost(Utils.b(str2)).setPort(i).setServerIp(Utils.b(str3)).build())));
        } catch (Exception e) {
        }
    }

    public void a(String str, long j, String str2, String str3, int i, String str4) {
        try {
            a(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(100).setTakes((int) j).setDescription(Utils.b(str2)).setExtra(Any.pack(ApmProtos.ImTypeProto.newBuilder().setName(Utils.b(str)).setHost(Utils.b(str3)).setPort(i).setServerIp(Utils.b(str4)).build())));
        } catch (Exception e) {
        }
    }
}

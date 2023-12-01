package com.tencent.cloud.huiyansdkface.wehttp2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeDns.class */
public interface WeDns {
    List<InetAddress> lookup(String str) throws UnknownHostException;
}

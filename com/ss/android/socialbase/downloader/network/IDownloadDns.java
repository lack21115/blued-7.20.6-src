package com.ss.android.socialbase.downloader.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/IDownloadDns.class */
public interface IDownloadDns {
    List<InetAddress> lookup(String str) throws UnknownHostException;
}

package com.android.server.net;

import android.net.LinkProperties;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/net/DnsServerRepository.class */
class DnsServerRepository {
    public static final int NUM_CURRENT_SERVERS = 3;
    public static final int NUM_SERVERS = 12;
    public static final String TAG = "DnsServerRepository";
    private Set<InetAddress> mCurrentServers = new HashSet();
    private ArrayList<DnsServerEntry> mAllServers = new ArrayList<>(12);
    private HashMap<InetAddress, DnsServerEntry> mIndex = new HashMap<>(12);

    private boolean updateCurrentServers() {
        boolean z;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            z = false;
            int size = this.mAllServers.size();
            while (true) {
                int i = size - 1;
                if (i < 0 || (i < 12 && this.mAllServers.get(i).expiry >= currentTimeMillis)) {
                    break;
                }
                DnsServerEntry remove = this.mAllServers.remove(i);
                this.mIndex.remove(remove.address);
                z |= this.mCurrentServers.remove(remove.address);
                size = i;
            }
            Iterator<DnsServerEntry> it = this.mAllServers.iterator();
            while (it.hasNext()) {
                DnsServerEntry next = it.next();
                if (this.mCurrentServers.size() >= 3) {
                    break;
                }
                z |= this.mCurrentServers.add(next.address);
            }
        }
        return z;
    }

    private boolean updateExistingEntry(InetAddress inetAddress, long j) {
        boolean z;
        synchronized (this) {
            DnsServerEntry dnsServerEntry = this.mIndex.get(inetAddress);
            if (dnsServerEntry != null) {
                dnsServerEntry.expiry = j;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean addServers(long j, String[] strArr) {
        boolean updateCurrentServers;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis + (1000 * j);
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    try {
                        InetAddress parseNumericAddress = InetAddress.parseNumericAddress(strArr[i2]);
                        if (!updateExistingEntry(parseNumericAddress, j2) && j2 > currentTimeMillis) {
                            DnsServerEntry dnsServerEntry = new DnsServerEntry(parseNumericAddress, j2);
                            this.mAllServers.add(dnsServerEntry);
                            this.mIndex.put(parseNumericAddress, dnsServerEntry);
                        }
                    } catch (IllegalArgumentException e) {
                    }
                    i = i2 + 1;
                } else {
                    Collections.sort(this.mAllServers);
                    updateCurrentServers = updateCurrentServers();
                }
            }
        }
        return updateCurrentServers;
    }

    public void setDnsServersOn(LinkProperties linkProperties) {
        synchronized (this) {
            linkProperties.setDnsServers(this.mCurrentServers);
        }
    }
}

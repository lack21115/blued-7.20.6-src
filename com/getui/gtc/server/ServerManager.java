package com.getui.gtc.server;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.e.c;
import com.getui.gtc.e.d;
import com.getui.gtc.f.b;
import com.getui.gtc.h.e;
import com.getui.gtc.i.c.a;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/server/ServerManager.class */
public class ServerManager {
    private static final long SERVERS_REFRESH_PERIOD = 86400000;
    private static Map<String, List<String>> availableServerMap;
    private static Map<String, List<String>> configServerMap;
    private static Map<String, String> runningServerMap;
    private static final Map<String, List<String>> buildInServerMap = new ConcurrentHashMap();
    private static final Map<String, List<String>> unavailableServerMap = new ConcurrentHashMap();

    static /* synthetic */ Map access$000() {
        return getAvailableServerMap();
    }

    static /* synthetic */ Map access$100() {
        return getConfigServerMap();
    }

    public static void addBuildInServerMap(Map<String, List<String>> map) {
        synchronized (ServerManager.class) {
            try {
                buildInServerMap.putAll(map);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void confirmServer(String str, String str2) {
        c cVar;
        c cVar2;
        synchronized (ServerManager.class) {
            try {
                List<String> list = unavailableServerMap.get(str);
                if (list != null) {
                    list.remove(str2);
                }
                cVar = c.a.f21997a;
                String str3 = cVar.f21995a.h;
                Properties properties = new Properties();
                if (!TextUtils.isEmpty(str3)) {
                    properties.load(new StringReader(str3));
                }
                properties.put(str, str2);
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append("\n");
                }
                cVar2 = c.a.f21997a;
                d dVar = cVar2.f21995a;
                String sb2 = sb.toString();
                if (dVar.a(13, Base64.encodeToString(SecureCryptTools.getInstance().encrypt(sb2.getBytes()), 0))) {
                    dVar.h = sb2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map<String, List<String>> getAvailableServerMap() {
        c cVar;
        Map<String, List<String>> map = availableServerMap;
        if (map != null) {
            return map;
        }
        availableServerMap = new HashMap();
        cVar = c.a.f21997a;
        parseServerProperties(cVar.f21995a.g, availableServerMap);
        return availableServerMap;
    }

    public static List<String> getBuildInServers(String str) {
        List<String> list;
        synchronized (ServerManager.class) {
            try {
                list = buildInServerMap.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public static List<String> getConfigServerMap(String str) {
        List<String> list;
        synchronized (ServerManager.class) {
            try {
                list = getConfigServerMap().get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private static Map<String, List<String>> getConfigServerMap() {
        c cVar;
        Map<String, List<String>> map = configServerMap;
        if (map != null) {
            return map;
        }
        configServerMap = new HashMap();
        cVar = c.a.f21997a;
        parseServerProperties(cVar.f21995a.f, configServerMap);
        return configServerMap;
    }

    private static Map<String, String> getRunningServerMap() {
        c cVar;
        Map<String, String> map = runningServerMap;
        if (map != null) {
            return map;
        }
        runningServerMap = new HashMap();
        try {
            cVar = c.a.f21997a;
            String str = cVar.f21995a.h;
            if (!TextUtils.isEmpty(str)) {
                Properties properties = new Properties();
                properties.load(new StringReader(str));
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    runningServerMap.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            a.a(th);
        }
        return runningServerMap;
    }

    public static String getServer(String str) {
        synchronized (ServerManager.class) {
            try {
                String str2 = getRunningServerMap().get(str);
                String str3 = str2;
                if (TextUtils.isEmpty(str2)) {
                    List<String> list = buildInServerMap.get(str);
                    str3 = str2;
                    if (list != null) {
                        str3 = str2;
                        if (list.size() > 0) {
                            str3 = list.get(0);
                        }
                    }
                }
                List<String> list2 = getAvailableServerMap().get(str);
                if (list2 != null && list2.size() > 0 && !list2.contains(str3)) {
                    String str4 = list2.get(0);
                    getRunningServerMap().put(str, str4);
                    return str4;
                }
                if (str3 != null) {
                    getRunningServerMap().put(str, str3);
                }
                return str3;
            } finally {
            }
        }
    }

    @Deprecated
    public static void initServerMap(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseServerProperties(String str, Map<String, List<String>> map) {
        if (map == null) {
            return;
        }
        map.clear();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Properties properties = new Properties();
            properties.load(new StringReader(str));
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                ArrayList arrayList = new ArrayList();
                map.put(str2, arrayList);
                JSONObject jSONObject = new JSONObject(str3);
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                ArrayList<String> arrayList2 = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    arrayList2.add(next);
                    ArrayList arrayList3 = new ArrayList();
                    hashMap.put(next, arrayList3);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < jSONArray.length()) {
                            String str4 = (String) jSONArray.opt(i2);
                            if (!TextUtils.isEmpty(str4) && !arrayList3.contains(str4)) {
                                arrayList3.add(str4);
                            }
                            i = i2 + 1;
                        }
                    }
                }
                Collections.sort(arrayList2);
                for (String str5 : arrayList2) {
                    arrayList.addAll((Collection) hashMap.get(str5));
                }
            }
        } catch (Throwable th) {
            a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveAvailableConfigServers() {
        c cVar;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : availableServerMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("1", jSONArray);
                for (String str : entry.getValue()) {
                    jSONArray.put(str);
                }
                sb.append(jSONObject.toString());
            } catch (JSONException e) {
                a.a(e);
            }
            sb.append("\n");
        }
        cVar = c.a.f21997a;
        cVar.f21995a.c(sb.toString());
    }

    public static boolean switchServer(String str, String str2) {
        synchronized (ServerManager.class) {
            try {
                List<String> list = unavailableServerMap.get(str);
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    unavailableServerMap.put(str, arrayList);
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
                List<String> list2 = getAvailableServerMap().get(str);
                if (list2 != null) {
                    list2.remove(str2);
                    saveAvailableConfigServers();
                }
                if (TextUtils.equals(str2, getRunningServerMap().get(str))) {
                    if (list2 != null && list2.size() > 0) {
                        getRunningServerMap().put(str, list2.get(0));
                        return true;
                    }
                    List<String> list3 = buildInServerMap.get(str);
                    if (list3 != null && list3.size() > 0) {
                        for (String str3 : list3) {
                            if (!arrayList.contains(str3) && !TextUtils.equals(str3, str2)) {
                                getRunningServerMap().put(str, str3);
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return true;
            } finally {
            }
        }
    }

    public static void updateConfigServerMap() {
        synchronized (ServerManager.class) {
            try {
                ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.server.ServerManager.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar;
                        c cVar2;
                        c cVar3;
                        synchronized (ServerManager.class) {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                cVar = c.a.f21997a;
                                if (currentTimeMillis - cVar.f21995a.i > 86400000) {
                                    cVar3 = c.a.f21997a;
                                    d dVar = cVar3.f21995a;
                                    if (dVar.a(14, currentTimeMillis)) {
                                        dVar.i = currentTimeMillis;
                                    }
                                    ServerManager.access$000().clear();
                                    ServerManager.access$000().putAll(ServerManager.access$100());
                                    ServerManager.saveAvailableConfigServers();
                                }
                                Map<String, String> a2 = b.a(new com.getui.gtc.f.d() { // from class: com.getui.gtc.server.ServerManager.1.1
                                    @Override // com.getui.gtc.f.d
                                    public final void a(String str) {
                                    }

                                    @Override // com.getui.gtc.f.d
                                    public final void a(Map<String, String> map, Map<String, String> map2) {
                                        c cVar4;
                                        if (map2 == null || map2.size() <= 0) {
                                            return;
                                        }
                                        final String str = map2.get("sdk.gtc.hosts.url");
                                        if (map != null && map.size() > 0) {
                                            String str2 = map.get("sdk.gtc.hosts.url");
                                            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(str2)) {
                                                return;
                                            }
                                        }
                                        cVar4 = c.a.f21997a;
                                        String str3 = cVar4.f21995a.e;
                                        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(str3)) {
                                            return;
                                        }
                                        e.a(str, map2.get("sdk.gtc.hosts.key"), new e.a() { // from class: com.getui.gtc.server.ServerManager.1.1.1
                                            @Override // com.getui.gtc.h.e.a
                                            public final void a(String str4) {
                                                c cVar5;
                                                c cVar6;
                                                c cVar7;
                                                cVar5 = c.a.f21997a;
                                                cVar5.f21995a.a(str);
                                                cVar6 = c.a.f21997a;
                                                cVar6.f21995a.b(str4);
                                                cVar7 = c.a.f21997a;
                                                cVar7.f21995a.c(str4);
                                                ServerManager.parseServerProperties(str4, ServerManager.access$100());
                                                ServerManager.parseServerProperties(str4, ServerManager.access$000());
                                            }
                                        });
                                    }
                                });
                                if (a2 != null && a2.size() > 0) {
                                    final String str = a2.get("sdk.gtc.hosts.url");
                                    cVar2 = c.a.f21997a;
                                    String str2 = cVar2.f21995a.e;
                                    if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(str2)) {
                                        e.a(str, a2.get("sdk.gtc.hosts.key"), new e.a() { // from class: com.getui.gtc.server.ServerManager.1.2
                                            @Override // com.getui.gtc.h.e.a
                                            public final void a(String str3) {
                                                c cVar4;
                                                c cVar5;
                                                c cVar6;
                                                cVar4 = c.a.f21997a;
                                                cVar4.f21995a.a(str);
                                                cVar5 = c.a.f21997a;
                                                cVar5.f21995a.b(str3);
                                                cVar6 = c.a.f21997a;
                                                cVar6.f21995a.c(str3);
                                                ServerManager.parseServerProperties(str3, ServerManager.access$100());
                                                ServerManager.parseServerProperties(str3, ServerManager.access$000());
                                            }
                                        });
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

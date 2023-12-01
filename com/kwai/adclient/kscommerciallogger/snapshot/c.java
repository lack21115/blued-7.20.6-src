package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/snapshot/c.class */
public class c {
    private final String aEH;
    private final LinkedList<d> aEI;
    private int aEJ;
    private final int aEK;
    private long aEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this(str, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, int i) {
        this.aEH = str == null ? "" : str;
        this.aEI = new LinkedList<>();
        this.aEK = Math.min(i, 30);
        this.aEL = System.currentTimeMillis();
    }

    public final long Gg() {
        long j;
        synchronized (this) {
            j = this.aEL;
        }
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aEH.equals(((c) obj).aEH);
    }

    public d fh(String str) {
        d dVar;
        synchronized (this) {
            if (this.aEI.size() >= this.aEK) {
                this.aEI.removeFirst();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            int i = this.aEJ;
            this.aEJ = i + 1;
            sb.append(i);
            dVar = new d(sb.toString());
            this.aEI.addLast(dVar);
            this.aEL = System.currentTimeMillis();
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject fi(String str) {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<d> it = this.aEI.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().Gf());
                }
                jSONObject.put("session_id", str);
                jSONObject.put("segment_name", this.aEH);
                jSONObject.put("spans", jSONArray);
                this.aEL = System.currentTimeMillis();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getName() {
        return this.aEH;
    }

    public int hashCode() {
        return Objects.hash(this.aEH);
    }
}

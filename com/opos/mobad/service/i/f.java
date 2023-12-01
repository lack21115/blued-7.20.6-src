package com.opos.mobad.service.i;

import com.opos.acs.st.STManager;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/f.class */
public class f {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f27388a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(JSONObject jSONObject) {
            this.f27388a = jSONObject == null ? new JSONObject() : jSONObject;
        }

        public void a(int i, int i2) {
            try {
                JSONObject jSONObject = new JSONObject();
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                jSONObject.put("tTemplateId", i);
                jSONObject.put("errorState", i2);
                this.f27388a.put("data_event", 13);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imgCache", i);
                jSONObject.put("imgAmount", i2);
                jSONObject.put("videoCache", i3);
                jSONObject.put("videoAmount", i4);
                this.f27388a.put("data_event", 1);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void a(int i, String str, JSONObject jSONObject) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crAmount", i);
                jSONObject2.put("crInfo", str);
                if (jSONObject != null) {
                    jSONObject2.put("crEnvInfo", jSONObject);
                }
                this.f27388a.put("data_event", 9);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject2.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void a(String str) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f27388a.put("data_event", 6);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void a(String str, int i) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("errorState", i);
                this.f27388a.put("data_event", 4);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void a(String str, String str2, long j, long j2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("traceId", str);
                jSONObject.put("vDuration", j);
                jSONObject.put("aDuration", j2);
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f27388a.put("data_event", 12);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void b(String str) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f27388a.put("data_event", 7);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void b(String str, int i) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                jSONObject.put("failNum", i);
                this.f27388a.put("data_event", 5);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void c(String str) {
            try {
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("posId", str);
                this.f27388a.put("data_event", 14);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void c(String str, int i) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("unSupportType", i);
                jSONObject.put("traceId", str);
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f27388a.put("data_event", 11);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }

        public void d(String str) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("traceId", str);
                this.f27388a.put(STManager.KEY_DATA_TYPE, "lm-c-alarm");
                this.f27388a.put("data_event", 10);
                this.f27388a.put("event_info", URLEncoder.encode(jSONObject.toString()));
                d.a().a(this.f27388a);
            } catch (JSONException e) {
            }
        }
    }
}

package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.p;
import com.alibaba.mtl.log.model.LogField;
import com.anythink.core.api.ErrorCode;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHitBuilders.class */
public class UTHitBuilders {

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHitBuilders$UTControlHitBuilder.class */
    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (TextUtils.isEmpty(currentPageName)) {
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, currentPageName + BridgeUtil.UNDERLINE_STR + str);
        }

        public UTControlHitBuilder(String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Page name can not be empty.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, str + BridgeUtil.UNDERLINE_STR + str2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHitBuilders$UTCustomHitBuilder.class */
    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        @Override // com.ut.mini.UTHitBuilders.UTHitBuilder
        public Map<String, String> build() {
            Map<String, String> build = super.build();
            Map<String, String> map = build;
            if (build != null) {
                String str = build.get(LogField.PAGE.toString());
                String str2 = build.get(LogField.ARG1.toString());
                map = build;
                if (str2 != null) {
                    build.remove(LogField.ARG1.toString());
                    build.remove(LogField.PAGE.toString());
                    map = p.b(build);
                    map.put(LogField.ARG1.toString(), str2);
                    map.put(LogField.PAGE.toString(), str);
                }
            }
            return map;
        }

        public UTCustomHitBuilder setDurationOnEvent(long j) {
            long j2 = j;
            if (j < 0) {
                j2 = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j2);
            return this;
        }

        public UTCustomHitBuilder setEventPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHitBuilders$UTHitBuilder.class */
    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> v;

        public UTHitBuilder() {
            HashMap hashMap = new HashMap();
            this.v = hashMap;
            if (hashMap.containsKey(FIELD_PAGE)) {
                return;
            }
            this.v.put(FIELD_PAGE, "UT");
        }

        private static boolean a(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(null)) {
                    map.remove(null);
                }
                if (map.containsKey("")) {
                    map.remove("");
                }
                if (map.containsKey(LogField.PAGE.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.EVENTID.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG1.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG2.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG3.toString())) {
                    i.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else {
                    return true;
                }
            }
            return true;
        }

        private static void d(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(FIELD_PAGE)) {
                    map.remove(FIELD_PAGE);
                    map.put(LogField.PAGE.toString(), map.get(FIELD_PAGE));
                }
                if (map.containsKey(FIELD_ARG1)) {
                    map.remove(FIELD_ARG1);
                    map.put(LogField.ARG1.toString(), map.get(FIELD_ARG1));
                }
                if (map.containsKey(FIELD_ARG2)) {
                    map.remove(FIELD_ARG2);
                    map.put(LogField.ARG2.toString(), map.get(FIELD_ARG2));
                }
                if (map.containsKey(FIELD_ARG3)) {
                    map.remove(FIELD_ARG3);
                    map.put(LogField.ARG3.toString(), map.get(FIELD_ARG3));
                }
                if (map.containsKey(FIELD_ARGS)) {
                    map.remove(FIELD_ARGS);
                    map.put(LogField.ARGS.toString(), map.get(FIELD_ARGS));
                }
                if (map.containsKey(FIELD_EVENT_ID)) {
                    map.remove(FIELD_EVENT_ID);
                    map.put(LogField.EVENTID.toString(), map.get(FIELD_EVENT_ID));
                }
            }
        }

        private static void e(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(LogField.PAGE.toString())) {
                    map.remove(LogField.PAGE.toString());
                }
                if (map.containsKey(LogField.EVENTID.toString())) {
                    map.remove(LogField.EVENTID.toString());
                }
                if (map.containsKey(LogField.ARG1.toString())) {
                    map.remove(LogField.ARG1.toString());
                }
                if (map.containsKey(LogField.ARG2.toString())) {
                    map.remove(LogField.ARG2.toString());
                }
                if (map.containsKey(LogField.ARG3.toString())) {
                    map.remove(LogField.ARG3.toString());
                }
                if (map.containsKey(LogField.ARGS.toString())) {
                    map.remove(LogField.ARGS.toString());
                }
            }
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.v);
            if (a(hashMap)) {
                e(hashMap);
                d(hashMap);
                if (hashMap.containsKey(LogField.EVENTID.toString())) {
                    return hashMap;
                }
                return null;
            }
            return null;
        }

        public String getProperty(String str) {
            if (str == null || !this.v.containsKey(str)) {
                return null;
            }
            return this.v.get(str);
        }

        public UTHitBuilder setProperties(Map<String, String> map) {
            if (map != null) {
                this.v.putAll(map);
            }
            return this;
        }

        public UTHitBuilder setProperty(String str, String str2) {
            if (TextUtils.isEmpty(str) || str2 == null) {
                i.a("setProperty", "key is null or key is empty or value is null,please check it!");
                return this;
            }
            if (this.v.containsKey(str)) {
                this.v.remove(str);
            }
            this.v.put(str, str2);
            return this;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/UTHitBuilders$UTPageHitBuilder.class */
    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, str);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, ErrorCode.timeOutError);
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setDurationOnPage(long j) {
            long j2 = j;
            if (j < 0) {
                j2 = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + j2);
            return this;
        }

        public UTPageHitBuilder setReferPage(String str) {
            if (!TextUtils.isEmpty(str)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, str);
            }
            return this;
        }
    }
}

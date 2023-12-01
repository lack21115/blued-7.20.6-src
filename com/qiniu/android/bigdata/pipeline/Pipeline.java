package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.bigdata.Configuration;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/bigdata/pipeline/Pipeline.class */
public final class Pipeline {
    private static final String HTTPHeaderAuthorization = "Authorization";
    private static final String TEXT_PLAIN = "text/plain";
    private final Client client;
    private final Configuration config;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/bigdata/pipeline/Pipeline$PumpCompleteHandler.class */
    public interface PumpCompleteHandler {
        void complete(ResponseInfo responseInfo);
    }

    public Pipeline(Configuration configuration) {
        Configuration copy = Configuration.copy(configuration);
        this.config = copy;
        this.client = new Client(copy.proxy, this.config.connectTimeout, this.config.responseTimeout, null, null);
    }

    private void send(String str, StringBuilder sb, String str2, final PumpCompleteHandler pumpCompleteHandler) {
        if (pumpCompleteHandler == null) {
            throw new IllegalArgumentException("no CompletionHandler");
        }
        if (StringUtils.isBlank(str2)) {
            throw new IllegalArgumentException("no token");
        }
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException("no repo");
        }
        byte[] bytes = sb.toString().getBytes();
        StringMap stringMap = new StringMap();
        stringMap.put("Authorization", str2);
        stringMap.put("Content-Type", "text/plain");
        this.client.asyncPost(null, url(str), bytes, stringMap, null, bytes.length, null, new CompletionHandler() { // from class: com.qiniu.android.bigdata.pipeline.Pipeline.1
            @Override // com.qiniu.android.http.CompletionHandler
            public void complete(ResponseInfo responseInfo, JSONObject jSONObject) {
                pumpCompleteHandler.complete(responseInfo);
            }
        }, null);
    }

    private String url(String str) {
        return this.config.pipelineHost + "/v2/repos/" + str + "/data";
    }

    public void pump(String str, Object obj, String str2, PumpCompleteHandler pumpCompleteHandler) {
        StringBuilder sb = new StringBuilder();
        Points.formatPoint(obj, sb);
        send(str, sb, str2, pumpCompleteHandler);
    }

    public <V> void pump(String str, Map<String, V> map, String str2, PumpCompleteHandler pumpCompleteHandler) {
        StringBuilder sb = new StringBuilder();
        Points.formatPoint((Map) map, sb);
        send(str, sb, str2, pumpCompleteHandler);
    }

    public <V> void pumpMulti(String str, List<Map<String, V>> list, String str2, PumpCompleteHandler pumpCompleteHandler) {
        send(str, Points.formatPoints(list), str2, pumpCompleteHandler);
    }

    public <V> void pumpMulti(String str, Map<String, V>[] mapArr, String str2, PumpCompleteHandler pumpCompleteHandler) {
        send(str, Points.formatPoints((Map[]) mapArr), str2, pumpCompleteHandler);
    }

    public <V> void pumpMultiObjects(String str, List<V> list, String str2, PumpCompleteHandler pumpCompleteHandler) {
        send(str, Points.formatPointsObjects(list), str2, pumpCompleteHandler);
    }

    public void pumpMultiObjects(String str, Object[] objArr, String str2, PumpCompleteHandler pumpCompleteHandler) {
        send(str, Points.formatPoints(objArr), str2, pumpCompleteHandler);
    }
}

package com.kwad.components.offline.api.core.model;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/model/IOfflineCompoJsonParse.class */
public interface IOfflineCompoJsonParse {
    void parseJson(JSONObject jSONObject);

    JSONObject toJson();
}

package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/ParamObject.class */
public interface ParamObject {
    RequestParams buildParameters();

    boolean checkParams();
}

package com.huawei.hms.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api.class */
public class Api<O extends ApiOptions> {
    private final String mApiName;
    public List<ConnectionPostProcessor> mConnetctPostList;
    private final Options<O> mOption;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$ApiOptions.class */
    public interface ApiOptions {

        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$ApiOptions$HasOptions.class */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$ApiOptions$NoOptions.class */
        public static final class NoOptions implements NotRequiredOptions {
        }

        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$ApiOptions$NotRequiredOptions.class */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$ApiOptions$Optional.class */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/Api$Options.class */
    public static abstract class Options<O> {
        public List<PermissionInfo> getPermissionInfoList(O o) {
            return Collections.emptyList();
        }

        public List<Scope> getScopeList(O o) {
            return Collections.emptyList();
        }
    }

    public Api(String str) {
        this.mApiName = str;
        this.mOption = null;
    }

    public Api(String str, Options<O> options) {
        this.mApiName = str;
        this.mOption = options;
    }

    public String getApiName() {
        return this.mApiName;
    }

    public Options<O> getOptions() {
        return this.mOption;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> list) {
        this.mConnetctPostList = list;
    }
}

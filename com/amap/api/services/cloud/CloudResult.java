package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/cloud/CloudResult.class */
public final class CloudResult {

    /* renamed from: a  reason: collision with root package name */
    private int f5599a;
    private ArrayList<CloudItem> b;

    /* renamed from: c  reason: collision with root package name */
    private int f5600c;
    private int d;
    private CloudSearch.Query e;
    private CloudSearch.SearchBound f;

    private CloudResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        this.e = query;
        this.f5600c = i;
        this.d = i2;
        this.f5599a = a(i);
        this.b = arrayList;
        this.f = searchBound;
    }

    private int a(int i) {
        int i2 = this.d;
        return ((i + i2) - 1) / i2;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i, searchBound, i2, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.b;
    }

    public final int getPageCount() {
        return this.f5599a;
    }

    public final CloudSearch.Query getQuery() {
        return this.e;
    }

    public final int getTotalCount() {
        return this.f5600c;
    }
}

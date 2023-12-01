package com.google.api;

import com.google.api.Distribution;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/DistributionOrBuilder.class */
public interface DistributionOrBuilder extends MessageOrBuilder {
    long getBucketCounts(int i);

    int getBucketCountsCount();

    List<Long> getBucketCountsList();

    Distribution.BucketOptions getBucketOptions();

    Distribution.BucketOptionsOrBuilder getBucketOptionsOrBuilder();

    long getCount();

    Distribution.Exemplar getExemplars(int i);

    int getExemplarsCount();

    List<Distribution.Exemplar> getExemplarsList();

    Distribution.ExemplarOrBuilder getExemplarsOrBuilder(int i);

    List<? extends Distribution.ExemplarOrBuilder> getExemplarsOrBuilderList();

    double getMean();

    Distribution.Range getRange();

    Distribution.RangeOrBuilder getRangeOrBuilder();

    double getSumOfSquaredDeviation();

    boolean hasBucketOptions();

    boolean hasRange();
}

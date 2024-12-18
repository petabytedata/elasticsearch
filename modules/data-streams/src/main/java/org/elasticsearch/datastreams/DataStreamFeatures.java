/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.datastreams;

import org.elasticsearch.action.admin.indices.rollover.LazyRolloverAction;
import org.elasticsearch.action.datastreams.autosharding.DataStreamAutoShardingService;
import org.elasticsearch.cluster.metadata.DataStreamGlobalRetention;
import org.elasticsearch.datastreams.lifecycle.health.DataStreamLifecycleHealthInfoPublisher;
import org.elasticsearch.features.FeatureSpecification;
import org.elasticsearch.features.NodeFeature;

import java.util.Set;

/**
 * Provides the features for data streams that this version of the code supports
 */
public class DataStreamFeatures implements FeatureSpecification {

    public static final NodeFeature DATA_STREAM_FAILURE_STORE_TSDB_FIX = new NodeFeature("data_stream.failure_store.tsdb_fix");

    @Override
    public Set<NodeFeature> getFeatures() {
        return Set.of(
            DataStreamLifecycleHealthInfoPublisher.DSL_HEALTH_INFO_FEATURE,  // Added in 8.12
            LazyRolloverAction.DATA_STREAM_LAZY_ROLLOVER,                    // Added in 8.13
            DataStreamAutoShardingService.DATA_STREAM_AUTO_SHARDING_FEATURE,
            DataStreamGlobalRetention.GLOBAL_RETENTION                       // Added in 8.14
        );
    }

    @Override
    public Set<NodeFeature> getTestFeatures() {
        return Set.of(DATA_STREAM_FAILURE_STORE_TSDB_FIX);
    }
}

/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.spi;

import com.hazelcast.core.EntryView;

/**
 * Represents a read-only view of data structure entries for the merging process after a split-brain.
 * <p>
 * On key-less data structures like {@link com.hazelcast.core.ISet} or {@link com.hazelcast.ringbuffer.Ringbuffer},
 * the method {@link #getKey()} will return {@code null}.
 * <p>
 * Some methods return {@code -1} if statistics are not enabled or not implemented.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 * @since 3.10
 */
public interface SplitBrainMergeEntryView<K, V> extends EntryView<K, V> {
}

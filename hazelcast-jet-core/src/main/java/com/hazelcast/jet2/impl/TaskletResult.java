/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.jet2.impl;

public enum TaskletResult implements ProgressState {
    NO_PROGRESS(false, false),
    MADE_PROGRESS(true, false),
    DONE(true, true),
    WAS_ALREADY_DONE(true, false);

    private final boolean madeProgress;
    private final boolean isDone;

    TaskletResult(boolean madeProgress, boolean isDone) {
        this.madeProgress = madeProgress;
        this.isDone = isDone;
    }

    @Override
    public boolean isMadeProgress() {
        return madeProgress;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    public static TaskletResult valueOf(ProgressState state) {
        return state.isDone()
                ? state.isMadeProgress() ? DONE : WAS_ALREADY_DONE
                : state.isMadeProgress() ? MADE_PROGRESS : NO_PROGRESS;
    }
}

/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.remoting3.jaxrs.feignimpl;

import com.google.common.base.Preconditions;
import feign.Param.Expander;
import java.util.Objects;
import java.util.Optional;

/**
 * Expands Optional by using null for {@link Optional#empty()} and the {@link Object#toString()} of the
 * value otherwise.
 */
public final class Java8NullOptionalExpander implements Expander {

    @Override
    public String expand(Object value) {
        Preconditions.checkArgument(value instanceof Optional, "Value must be an Optional. Was: %s", value.getClass());
        Optional<?> optional = (Optional<?>) value;
        return optional.isPresent() ? Objects.toString(optional.get()) : null;
    }
}

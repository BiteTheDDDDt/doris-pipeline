// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.types;

import org.apache.doris.catalog.Type;
import org.apache.doris.nereids.types.coercion.PrimitiveType;

import com.google.common.base.Preconditions;

/**
 * Datetime type in Nereids.
 */
public class DateTimeV2Type extends PrimitiveType {
    public static final int MAX_SCALE = 6;
    public static final DateTimeV2Type INSTANCE = new DateTimeV2Type(0);

    private static final int WIDTH = 8;

    private int scale;

    private DateTimeV2Type(int scale) {
        Preconditions.checkArgument(0 <= scale && scale <= MAX_SCALE);
        this.scale = scale;
    }

    @Override
    public Type toCatalogDataType() {
        return Type.DATETIME;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DateTimeV2Type;
    }

    @Override
    public int width() {
        return WIDTH;
    }

    public int getScale() {
        return scale;
    }
}

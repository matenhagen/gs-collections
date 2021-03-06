/*
 * Copyright 2011 Goldman Sachs.
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

package com.gs.collections.impl.list.immutable;

import com.gs.collections.api.list.ImmutableList;
import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableQuadrupletonListTest extends AbstractImmutableListTestCase
{
    @Override
    protected ImmutableList<Integer> classUnderTest()
    {
        return new ImmutableQuadrupletonList<Integer>(1, 2, 3, 4);
    }

    @Override
    @Test
    public void testDistinct()
    {
        super.testDistinct();
        ImmutableList<Integer> list = new ImmutableQuadrupletonList<Integer>(2, 1, 1, 2);
        ImmutableList<Integer> distinctList = list.distinct();
        Assert.assertFalse(distinctList.isEmpty());
        Verify.assertInstanceOf(ImmutableDoubletonList.class, distinctList);
        Assert.assertEquals(FastList.newListWith(2, 1), distinctList);
    }
}

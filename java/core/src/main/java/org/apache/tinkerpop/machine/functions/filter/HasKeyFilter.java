/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.machine.functions.filter;

import org.apache.tinkerpop.machine.bytecode.Argument;
import org.apache.tinkerpop.machine.coefficients.Coefficient;
import org.apache.tinkerpop.machine.functions.AbstractFunction;
import org.apache.tinkerpop.machine.functions.FilterFunction;
import org.apache.tinkerpop.machine.traversers.Traverser;
import org.apache.tinkerpop.util.StringFactory;

import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public final class HasKeyFilter<C, K, V> extends AbstractFunction<C, Map<K, V>, Map<K, V>> implements FilterFunction<C, Map<K, V>> {

    private final Argument<K> key;

    public HasKeyFilter(final Coefficient<C> coefficient, final Set<String> labels, final Argument<K> key) {
        super(coefficient, labels);
        this.key = key;
    }

    @Override
    public boolean test(final Traverser<C, Map<K, V>> traverser) {
        final Map<K, V> object = traverser.object();
        return object.containsKey(this.key.getArg(object));
    }

    @Override
    public String toString() {
        return StringFactory.makeFunctionString(this, this.key);
    }
}
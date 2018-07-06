/**
 * Copyright (C) 2008 Google Inc.
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

package com.jd.jtf.common.inject.internal;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.jd.jtf.common.inject.Binder;
import com.jd.jtf.common.inject.Injector;
import com.jd.jtf.common.inject.Key;
import com.jd.jtf.common.inject.spi.BindingTargetVisitor;
import com.jd.jtf.common.inject.spi.Dependency;
import com.jd.jtf.common.inject.spi.ExposedBinding;
import com.jd.jtf.common.inject.spi.PrivateElements;

import java.util.Set;

public final class ExposedBindingImpl<T> extends BindingImpl<T> implements ExposedBinding<T> {

  private final PrivateElements privateElements;

  public ExposedBindingImpl(InjectorImpl injector, Object source, Key<T> key,
      InternalFactory<T> factory, PrivateElements privateElements) {
    super(injector, key, source, factory, Scoping.UNSCOPED);
    this.privateElements = privateElements;
  }

  public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> visitor) {
    return visitor.visit(this);
  }

  public Set<Dependency<?>> getDependencies() {
    return ImmutableSet.<Dependency<?>>of(Dependency.get(Key.get(Injector.class)));
  }

  public PrivateElements getPrivateElements() {
    return privateElements;
  }

  @Override public String toString() {
    return MoreObjects.toStringHelper(ExposedBinding.class)
        .add("key", getKey())
        .add("source", getSource())
        .add("privateElements", privateElements)
        .toString();
  }

  public void applyTo(Binder binder) {
    throw new UnsupportedOperationException("This element represents a synthetic binding.");
  }
  
  // Purposely does not override equals/hashcode, because exposed bindings are only equal to
  // themselves right now -- that is, there cannot be "duplicate" exposed bindings.
}

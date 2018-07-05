/**
 * Copyright (C) 2006 Google Inc.
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.jd.jtf.common.inject.Provider;
import com.jd.jtf.common.inject.spi.Dependency;

/**
 * @author crazybob@google.com (Bob Lee)
*/
final class InternalFactoryToProviderAdapter<T> implements InternalFactory<T> {

  private final Provider<? extends T> provider;
  private final Object source;

  public InternalFactoryToProviderAdapter(Provider<? extends T> provider, Object source) {
    this.provider = checkNotNull(provider, "provider");
    this.source = checkNotNull(source, "source");
  }

  public T get(Errors errors, InternalContext context, Dependency<?> dependency, boolean linked)
      throws ErrorsException {
    // TODO(sameb): Does this need to push state into the context?
    try {
      return errors.checkForNull(provider.get(), source, dependency);
    } catch (RuntimeException userException) {
      throw errors.withSource(source).errorInProvider(userException).toException();
    }
  }

  @Override public String toString() {
    return provider.toString();
  }
}
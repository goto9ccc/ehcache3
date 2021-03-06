/*
 * Copyright Terracotta, Inc.
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

package org.ehcache.impl.serialization;

import org.ehcache.core.spi.service.FileBasedPersistenceContext;
import org.ehcache.spi.serialization.Serializer;

import java.nio.ByteBuffer;

/**
 * Default {@link Serializer} for {@code Double} type. Simply writes the double value
 * to a byte buffer.
 */
public class DoubleSerializer implements Serializer<Double> {

  /**
   * No arg constructor
   */
  public DoubleSerializer() {
  }

  /**
   * Constructor to enable this serializer as a transient one.
   * <P>
   *   Parameter is ignored as {@link Double} is a base java type.
   * </P>
   *
   * @param classLoader the classloader to use
   *
   * @see Serializer
   */
  public DoubleSerializer(ClassLoader classLoader) {
  }

  /**
   * Constructor to enable this serializer as a persistent one.
   * <P>
   *   Parameters are ignored as {@link Double} is a base java type and this implementation requires no state.
   * </P>
   *
   * @param classLoader the classloader to use
   * @param persistenceContext the persistence context
   *
   * @see Serializer
   */
  public DoubleSerializer(ClassLoader classLoader, FileBasedPersistenceContext persistenceContext) {

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ByteBuffer serialize(Double object) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(8);
    byteBuffer.putDouble(object).flip();
    return byteBuffer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Double read(ByteBuffer binary) throws ClassNotFoundException {
    double d = binary.getDouble();
    return d;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Double object, ByteBuffer binary) throws ClassNotFoundException {
    return object.equals(read(binary));
  }
}

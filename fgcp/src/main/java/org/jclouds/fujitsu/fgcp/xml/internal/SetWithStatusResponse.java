/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.fujitsu.fgcp.xml.internal;

import javax.xml.bind.annotation.XmlElement;

import com.google.common.collect.ForwardingSet;

/**
 * Special base class extending (forwardable) Set with fields for the elements
 * that FGCP XML responses specify.
 * <p>
 * This is useful for methods that return a Set and the XML response has no
 * other elements but the set of elements (and message and status of course).
 * 
 * @author Dies Koper
 */
public abstract class SetWithStatusResponse<T> extends ForwardingSet<T>
      implements StatusQuerable {
   @XmlElement(required = true)
   private String responseMessage;
   @XmlElement(required = true)
   private String responseStatus;

   public String getResponseMessage() {
      return responseMessage;
   }

   public String getResponseStatus() {
      return responseStatus;
   }

   public boolean isError() {
      return !"SUCCESS".equals(responseStatus);
   }

   @Override
   public String toString() {
      return delegate().toString();
   }

}

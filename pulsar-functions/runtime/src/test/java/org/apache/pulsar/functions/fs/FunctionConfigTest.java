/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pulsar.functions.fs;

import java.io.File;
import java.net.URL;

import org.apache.pulsar.functions.proto.Function.FunctionConfig;
import org.apache.pulsar.functions.utils.FunctionConfigUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test of {@link FunctionConfig}.
 */
public class FunctionConfigTest {

    @Test
    public void testLoadFunctionConfig() throws Exception {
        URL yamlUrl = getClass().getClassLoader().getResource("test_function_config.yml");
        FunctionConfig fc = FunctionConfigUtils.loadConfig(new File(yamlUrl.toURI().getPath())).build();

        assertEquals("test-function", fc.getName());
        assertEquals("test-sink-topic", fc.getSinkTopic());
        assertEquals(1, fc.getInputsCount());
        assertTrue(fc.containsInputs("test-source-topic"));
    }

}

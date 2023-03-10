/*
 * Copyright (c) 2021, 2023 Oracle and/or its affiliates.
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

package org.eclipse.metro.helidon;

import com.sun.xml.ws.api.pipe.ClientTubeAssemblerContext;
import com.sun.xml.ws.api.pipe.TransportTubeFactory;
import com.sun.xml.ws.api.pipe.Tube;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelidonTransportFactory extends TransportTubeFactory {

    private static final Logger LOGGER = Logger.getLogger(HelidonTransportFactory.class.getName());

    @Override
    public Tube doCreate(ClientTubeAssemblerContext ctac) {
        LOGGER.log(Level.INFO, "creating {0}...", HelidonTransportFactory.class.getName());
        //ctac.
        return null;
    }
}

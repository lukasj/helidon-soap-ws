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

module org.glassfish.metro.helidon {

    exports org.eclipse.metro.helidon;

    requires java.logging;
    requires transitive jakarta.activation;
    requires transitive com.sun.xml.ws.rt;
    requires transitive org.glassfish.metro.wsit.impl;
    requires io.helidon.webserver;
    requires io.helidon.common.serviceloader;

    provides com.sun.xml.ws.api.pipe.TransportTubeFactory
            with org.eclipse.metro.helidon.HelidonTransportFactory;
    
}

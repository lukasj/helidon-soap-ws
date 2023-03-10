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

import com.sun.xml.ws.api.ResourceLoader;
import com.sun.xml.ws.api.pipe.TransportTubeFactory;
import com.sun.xml.ws.api.server.BoundEndpoint;
import com.sun.xml.ws.api.server.Container;
import com.sun.xml.ws.api.server.WebModule;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

class HelidonContainer extends Container {

    private final TransportTubeFactory transport = new HelidonTransportFactory();
    private final ResourceLoader loader = new ResourceLoader() {
        @Override
        public URL getResource(String string) throws MalformedURLException {
            URL res = Thread.currentThread().getContextClassLoader().getResource(string);
            return res != null ? res : Thread.currentThread().getContextClassLoader().getResource("/META-INF/" + string);
        }
    };
    private final WebModule module;

    public HelidonContainer(String rootContext) {
        super();
        module = new HelidonModule(rootContext);
    }

    List<BoundEndpoint> getBoundEndpoints() {
        return module.getBoundEndpoints();
    }

    @Override
    public <T> T getSPI(Class<T> spiType) {
        T t = super.getSPI(spiType);
        if (t != null) {
            return t;
        }
        if (spiType == TransportTubeFactory.class) {
            return spiType.cast(transport);
        }
        if (spiType == ResourceLoader.class) {
            return spiType.cast(loader);
        }
        if (spiType.isAssignableFrom(WebModule.class)) {
            return spiType.cast(module);
        }
        return null;
    }

}

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

package org.eclipse.metro.helidon.mp;

import io.helidon.config.Config;
import io.helidon.config.mp.MpConfig;
import io.helidon.microprofile.server.RoutingBuilders;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;
import jakarta.interceptor.Interceptor;
import org.eclipse.metro.helidon.MetroSupport;
import org.eclipse.microprofile.config.ConfigProvider;

public class MetroCdiExtension implements Extension {

    public void start(@Observes @Priority(Interceptor.Priority.PLATFORM_AFTER) @Initialized(ApplicationScoped.class) Object event, BeanManager bm) {
        org.eclipse.microprofile.config.Config config = ConfigProvider.getConfig();
        Config helidonConfig = MpConfig.toHelidonConfig(config).get("metro");
        MetroSupport metro = MetroSupport.create(helidonConfig);
        RoutingBuilders.create(helidonConfig)
                .routingBuilder()
                .register(metro);
    }

}

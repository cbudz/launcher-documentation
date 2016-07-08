/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
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
package org.wildfly.swarm.jaxrs;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.config.JAXRS;
import org.wildfly.swarm.jaxrs.internal.JAXRSArchiveImpl;
import org.wildfly.swarm.spi.api.Fraction;
import org.wildfly.swarm.spi.api.annotations.Configuration;

/**
 * @author Bob McWhirter
 */
@Configuration(
        extension = "org.jboss.as.jaxrs",
        marshal = true,
        deploymentModules = {"com.fasterxml.jackson.jaxrs.jackson-jaxrs-json-provider"}
)
public class JAXRSFraction extends JAXRS<JAXRSFraction> implements Fraction {

    public JAXRSFraction() {
    }

    static {
        ShrinkWrap.getDefaultDomain().getConfiguration().getExtensionLoader().addOverride(JAXRSArchive.class, JAXRSArchiveImpl.class);
    }


}
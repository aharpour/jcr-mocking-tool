/*
 * Copyright 2017 Open Web IT B.V. (https://www.openweb.nl/)
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
package nl.openweb.jcr;

import nl.openweb.jcr.importer.JcrImporter;
import nl.openweb.jcr.importer.JsonImporter;

import java.io.InputStream;

/**
 * @author Ebrahim Aharpour
 * @since 9/3/2017
 */
public class JsonImporterWitPathTest extends AbstractImporterWithPathTest {

    @Override
    public void init() throws Exception {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("nodes.json")) {
            JcrImporter importer = createImporter(JsonImporter.FORMAT);
            importer.createNodes("{}", "/some");
            rootNode = importer.createNodes(inputStream, getImportPath());
        }
    }
}

/*
* Copyright (C) Sean J. Barbeau (sjbarbeau@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.barbeaudev.geotools.referencing.operation.transform.test;

import com.barbeaudev.geotools.referencing.operation.transform.EarthGravitationalModel;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Tests for EarthGravitationalModel to calculate mean sea level altitude from WGS84 altitude
 */
public class EarthGravitationalModelTest extends TestCase {

    @Test
    public void testEGM() throws Exception {
        final EarthGravitationalModel gh = new EarthGravitationalModel();
        gh.load("/egm180.nor");
        assertEquals(1.505, gh.heightOffset(45, 45, 0), 0.001);
        assertEquals(1.515, gh.heightOffset(45, 45, 1000), 0.001);
        assertEquals(46.908, gh.heightOffset(0, 45, 0), 0.001);
    }
}

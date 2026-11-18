/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.service.segment;

import com.impactupgrade.nucleus.environment.Environment;

public interface SegmentService {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // REGISTRATION (for use by environment.json and Environment.java)
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    String name();
    boolean isConfigured(Environment env);
    void init(Environment env);
}

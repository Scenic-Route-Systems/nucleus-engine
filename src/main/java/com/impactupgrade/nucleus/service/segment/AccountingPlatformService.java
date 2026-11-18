/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.service.segment;

import com.impactupgrade.nucleus.model.CrmContact;
import com.impactupgrade.nucleus.model.CrmDonation;

import java.util.List;

public interface AccountingPlatformService extends SegmentService {
    List<String> updateOrCreateContacts(List<CrmContact> crmContacts) throws Exception;
    List<String> updateOrCreateTransactions(List<CrmDonation> crmDonations) throws Exception;
}

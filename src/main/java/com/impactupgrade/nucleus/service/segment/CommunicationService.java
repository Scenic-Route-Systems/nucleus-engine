/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.service.segment;

import java.util.Calendar;

public interface CommunicationService extends SegmentService {

  void syncContacts(Calendar lastSync) throws Exception;
  void syncUnsubscribes(Calendar lastSync) throws Exception;
  void upsertContact(String contactId) throws Exception;
  // TODO: deleteContact
  void massArchive() throws Exception;
}

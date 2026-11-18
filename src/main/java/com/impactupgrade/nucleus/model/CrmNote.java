/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.model;

import java.util.Calendar;

public class CrmNote {

  public String targetId;
  public String title;
  public String note;
  public Calendar date;

  public CrmNote() {
  }

  public CrmNote(String targetId, String title, String note, Calendar date) {
    this.targetId = targetId;
    this.title = title;
    this.note = note;
    this.date = date;
  }

}

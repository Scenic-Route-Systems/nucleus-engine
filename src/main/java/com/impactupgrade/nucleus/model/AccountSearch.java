/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.model;

import java.util.Set;

public class AccountSearch extends AbstractSearch {

  // helpers

  public static AccountSearch byKeywords(String keywords) {
    AccountSearch accountSearch = new AccountSearch();
    String[] keywordSplit = keywords.trim().split("\\s+");
    accountSearch.keywords = Set.of(keywordSplit);
    return accountSearch;
  }
}

/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.service.segment;

import com.impactupgrade.nucleus.environment.Environment;
import com.impactupgrade.nucleus.model.ContactSearch;
import com.impactupgrade.nucleus.model.CrmContact;
import com.impactupgrade.nucleus.model.CrmDonation;
import com.impactupgrade.nucleus.model.PagedResults;
import com.impactupgrade.nucleus.util.GoogleSheetsUtil;
import com.impactupgrade.nucleus.util.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GoogleSheetCrmService implements BasicCrmService {

    protected Environment env;

    @Override
    public String name() {
        return "googlesheet";
    }

    @Override
    public boolean isConfigured(Environment env) {
        // TODO: For now, this service is purely on-demand, for tools like SMS Blast. In the future, it might need
        //  to be env.json driven if it becomes more full featured, like a single sheet positioned as a writable CRM.
        return true;
    }

    @Override
    public void init(Environment env) {
        this.env = env;
    }

    @Override
    public Optional<CrmContact> getContactById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<CrmContact> getFilteredContactById(String id, String filter) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<CrmContact> getContactsFromList(String listId) throws Exception {
        // listId is assumed to be the full URL of a GSheet
        return GoogleSheetsUtil.getSheetData(listId).stream()
            .map(this::toCrmContact).collect(Collectors.toList());
    }

    @Override
    public PagedResults<CrmContact> searchContacts(ContactSearch contactSearch, boolean includeSecondary) throws Exception {
        return null;
    }

    @Override
    public String insertContact(CrmContact crmContact) throws Exception {
        return null;
    }

    @Override
    public boolean updateContact(CrmContact crmContact) throws Exception {
      return true;
    }

    @Override
    public List<CrmDonation> getDonationsByTransactionIds(List<String> transactionIds) throws Exception {
        return Collections.emptyList();
    }

    @Override
    public String insertDonation(CrmDonation crmDonation) throws Exception {
        return null;
    }

    @Override
    public boolean updateDonation(CrmDonation crmDonation) throws Exception {
      return true;
    }

    protected CrmContact toCrmContact(Map<String, String> map) {
        CrmContact crmContact = new CrmContact();

        crmContact.mobilePhone = Utils.getPhoneFromMap(map);

        crmContact.crmRawObject = map;
        crmContact.fieldFetcher = map::get;
        return crmContact;
    }
}

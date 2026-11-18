/*
 * Copyright (c) 2026 Scenic Route Systems LLC. All rights reserved.
 */

package com.impactupgrade.nucleus.service.segment;

import com.impactupgrade.nucleus.environment.EnvironmentConfig;
import com.impactupgrade.nucleus.model.AccountSearch;
import com.impactupgrade.nucleus.model.CrmAccount;
import com.impactupgrade.nucleus.model.CrmActivity;
import com.impactupgrade.nucleus.model.CrmCampaign;
import com.impactupgrade.nucleus.model.CrmContact;
import com.impactupgrade.nucleus.model.CrmContactListType;
import com.impactupgrade.nucleus.model.CrmCustomField;
import com.impactupgrade.nucleus.model.CrmDonation;
import com.impactupgrade.nucleus.model.CrmImportEvent;
import com.impactupgrade.nucleus.model.CrmNote;
import com.impactupgrade.nucleus.model.CrmOpportunity;
import com.impactupgrade.nucleus.model.CrmRecurringDonation;
import com.impactupgrade.nucleus.model.ManageDonationEvent;
import com.impactupgrade.nucleus.model.PagedResults;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * There is typically a huge difference in the feature set of general-purpose CRMs (like SFDC and HS) vs.
 * nonprofit CRMs and donor management/retention platforms (like Bloomerang). The latter rarely
 * include campaigns, lists/reports, non-donation opportunities, tasks, etc. Often, they don't even include an
 * account/household/organization level, instead lumping everything into a single "Donor" object (which we opt
 * to map to Contact). Ditto for recurring donations.
 *
 * So we provide a "basic" interface providing no-op default implementations of the methods not generally supported
 * by the other platforms.
 *
 * Note that we *could* reverse this and split the method definitions between something like a BasicCrmService
 * and "FullCrmService extends BasicCrmService", then have impls choose which one to implement. However, having a single
 * CrmService makes processing way easier and ensures we don't need to do a bunch of instanceof checks.
 */
public interface BasicCrmService extends CrmService {

  default Optional<CrmAccount> getAccountById(String id) throws Exception {
    return Optional.empty();
  }

  default List<CrmAccount> getAccountsByIds(List<String> ids) throws Exception {
    return Collections.emptyList();
  }

  default List<CrmAccount> getAccountsByEmails(Set<String> emails) throws Exception {
    return Collections.emptyList();
  }

  default List<CrmAccount> searchAccounts(AccountSearch accountSearch) throws Exception {
    return Collections.emptyList();
  }

  default String insertAccount(CrmAccount crmAccount) throws Exception {
    return null;
  }

  default boolean updateAccount(CrmAccount crmAccount) throws Exception {
    return true;
  }

  default void addAccountToCampaign(CrmAccount crmAccount, String campaignId, String status) throws Exception {
  }

  default void deleteAccount(String accountId) throws Exception {
  }

  default void addContactToCampaign(CrmContact crmContact, String campaignId, String status) throws Exception {
  }

  default List<CrmContact> getContactsFromList(String listId) throws Exception {
    return null;
  }

  default void addContactToList(CrmContact crmContact, String listId) throws Exception {
  }

  default void removeContactFromList(CrmContact crmContact, String listId) throws Exception {
  }

  default String insertOpportunity(CrmOpportunity crmOpportunity) throws Exception {
    return null;
  }

  default List<CrmDonation> getDonationsByCustomerId(String customerId) throws Exception {
    return Collections.emptyList();
  }

  default boolean refundDonation(CrmDonation crmDonation) throws Exception {
    return true;
  }

  default void insertDonationDeposit(List<CrmDonation> crmDonations) throws Exception {
  }

  default PagedResults<CrmDonation> getDonations(Calendar updatedAfter) throws Exception {
    return new PagedResults<>();
  }

  default Optional<CrmRecurringDonation> getRecurringDonationById(String id) throws Exception {
    return Optional.empty();
  }

  default Optional<CrmRecurringDonation> getRecurringDonationBySubscriptionId(String subscriptionId) throws Exception {
    return Optional.empty();
  }

  default List<CrmRecurringDonation> searchAllRecurringDonations(Optional<String> name, Optional<String> email, Optional<String> phone) throws Exception {
    return null;
  }

  default String insertRecurringDonation(CrmRecurringDonation crmRecurringDonation) throws Exception {
    return null;
  }

  default boolean closeRecurringDonation(CrmRecurringDonation crmRecurringDonation) throws Exception {
    return true;
  }

  default String insertCampaign(CrmCampaign crmCampaign) throws Exception {
    return null;
  }

  default boolean updateCampaign(CrmCampaign crmCampaign) throws Exception {
    return true;
  }

  default List<CrmCampaign> getCampaignsByExternalReference(String externalReference) throws Exception {
    return Collections.emptyList();
  }

  default void deleteCampaign(String campaignId) throws Exception {
  }

  default boolean updateRecurringDonation(ManageDonationEvent manageDonationEvent) throws Exception {
    return true;
  }

  default PagedResults<CrmContact> getEmailContacts(Calendar updatedSince, EnvironmentConfig.CommunicationList communicationList) throws Exception {
    return new PagedResults<>();
  }

  default PagedResults<CrmAccount> getEmailAccounts(Calendar updatedSince, EnvironmentConfig.CommunicationList communicationList) throws Exception {
    return new PagedResults<>();
  }

  default PagedResults<CrmContact> getSmsContacts(Calendar updatedSince, EnvironmentConfig.CommunicationList communicationList) throws Exception {
    return new PagedResults<>();
  }

  default PagedResults<CrmContact> getDonorIndividualContacts(Calendar updatedSince) throws Exception {
    return new PagedResults<>();
  }

  default PagedResults<CrmAccount> getDonorOrganizationAccounts(Calendar updatedSince) throws Exception {
    return new PagedResults<>();
  }

  default Map<String, List<String>> getContactsCampaigns(List<CrmContact> crmContacts,
      EnvironmentConfig.CommunicationList communicationList) throws Exception {
    return null;
  }

  default PagedResults.ResultSet<CrmContact> queryMoreContacts(String queryLocator) throws Exception {
    return null;
  }

  default PagedResults.ResultSet<CrmAccount> queryMoreAccounts(String queryLocator) throws Exception {
    return null;
  }

  default PagedResults.ResultSet<CrmDonation> queryMoreDonations(String queryLocator) throws Exception {
    return null;
  }

  default double getDonationsTotal(String filter) throws Exception {
    return 0;
  }

  default void processBulkImport(List<CrmImportEvent> importEvents) throws Exception {
  }

  default Map<String, String> getContactLists(CrmContactListType listType) throws Exception {
    return Collections.emptyMap();
  }

  default void batchInsertActivity(CrmActivity crmActivity) throws Exception {
  }

  default void batchUpdateActivity(CrmActivity crmActivity) throws Exception {
  }

  default List<CrmActivity> getActivitiesByExternalRefs(List<String> externalRefs) throws Exception {
    return Collections.emptyList();
  }

  default String insertNote(CrmNote crmNote) throws Exception {
    return null;
  }

  default List<CrmCustomField> insertCustomFields(List<CrmCustomField> crmCustomFields) {
    return null;
  }

  default EnvironmentConfig.CRMFieldDefinitions getFieldDefinitions() {
    return null;
  }
}

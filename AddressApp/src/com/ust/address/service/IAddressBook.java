package com.ust.address.service;

import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.exceptions.NoEntryException;
import com.ust.address.model.Address;

import java.util.Set;

/**
 *
 */
public interface IAddressBook {

    /**
     * @param address
     * @return boolean true/false
     */
    abstract boolean addAddress(final Address address) throws DuplicateAddressException;

    /**
     * @param flatId
     * @return boolean true/false
     */
    abstract boolean removeAddress(final String flatId) throws NoEntriesException, NoEntryException;

    public default Set<Address> getAllAddressEntries() throws NoEntriesException {
        return null;
    }



}

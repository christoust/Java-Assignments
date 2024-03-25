package com.ust.address.service;

import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.exceptions.NoEntryException;
import com.ust.address.model.Address;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AddressBookImpl implements IAddressBook {

    private Set<Address> addressBook = null;

    public AddressBookImpl() {
        addressBook = new HashSet<Address>();
    }

    @Override
    public boolean addAddress(Address address) throws DuplicateAddressException {
        if (address == null) {
            throw new NullPointerException("Address reference is null");

        }
        boolean addAddressFlag = addressBook.add(address);
        if (!addAddressFlag) {
            throw new DuplicateAddressException("Address Might be duplicated");
        }
        else{
            System.out.println("Address added");
        }
        return addAddressFlag;
    }

    @Override
    public boolean removeAddress(String firstName) throws NoEntriesException, NoEntryException {
        boolean addressRemoveFlag = false;
        if (firstName == null || firstName.isEmpty() || firstName.isBlank()) {
            throw new NullPointerException("First name invalid");

        }
        if (addressBook.isEmpty()) {
            throw new NoEntriesException("No entries so far");
        } else {
            Iterator<Address> addressIterator = addressBook.iterator();
            while (addressIterator.hasNext()) {
                Address address = addressIterator.next();
                if (firstName.equals(address.getFirstName())) {
                    addressIterator.remove();
                    addressRemoveFlag = true;
                    break;
                }
                }
            if(!addressRemoveFlag)
            {
                throw new NoEntryException("No such address");
            }
            return addressRemoveFlag;
        }
    }

    @Override
    public Set<Address> getAllAddressEntries() throws NoEntriesException {
        return this.addressBook;
    }
}

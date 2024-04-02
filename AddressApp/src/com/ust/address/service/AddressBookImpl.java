package com.ust.address.service;

import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.exceptions.NoEntryException;
import com.ust.address.model.Address;

import java.util.HashSet;
import java.util.Set;

import static com.ust.address.constants.ErrorMessage.*;

/**
 * Implementation of IAddressBook
 */
public class AddressBookImpl implements IAddressBook {

    private Set<Address> addressBook = null;

    public AddressBookImpl() {
        addressBook = new HashSet<Address>();
        addressBook.add(new Address("4", "Street1", "City1", "12345"));
        addressBook.add(new Address("2", "Street2", "City2", "23456"));
        addressBook.add(new Address("3", "Street3", "City3", "34567"));
    }

    /**
     * @param address
     * @return boolean true/false
     * @throws DuplicateAddressException
     */
    @Override
    public boolean addAddress(Address address) throws DuplicateAddressException {
        if (address == null) {
            throw new NullPointerException(ADDRESS_NULL);

        }
        boolean addAddressFlag;
//        synchronized (addressBook) {
        addAddressFlag = addressBook.add(address);
//        }
        if (!addAddressFlag) {
            throw new DuplicateAddressException(DUPLICATE_ADDRESS_MESSAGE);
        } else {
            System.out.println(ADDRESS_ADDED);
        }
        return addAddressFlag;
    }

    /**
     * @param flatId
     * @return boolean
     * @throws NoEntriesException
     * @throws NoEntryException
     */
    @Override
    public boolean removeAddress(String flatId) throws NoEntriesException, NoEntryException {
        boolean addressRemoveFlag = false;
        if (flatId == null || flatId.isEmpty() || flatId.isBlank()) {
            throw new NullPointerException(INVALID_FLAT_ID);

        }
        if (addressBook.isEmpty()) {
            throw new NoEntriesException(NO_ENTRY_MESSAGE);
        } else {
            addressRemoveFlag = addressBook.removeIf(address -> flatId.equals(address.getFlatId()));

//            synchronized (addressBook) {
//                Iterator<Address> addressIterator = addressBook.iterator();
//                while (addressIterator.hasNext()) {
//                    Address address = addressIterator.next();
//                    if (flatId.equals(address.getFlatId())) {
//                        addressBook.remove(address);
//                        System.out.println("Address with flatId: " + flatId + " deleted");
//                        addressRemoveFlag = true;
//                        break;
//                    }
//                }
//            }
            if (!addressRemoveFlag) {
                throw new NoEntryException(NO_ADDRESS);
            } else {
                System.out.println("Address with flatId: " + flatId + " deleted");

            }
            return addressRemoveFlag;
        }
    }

    /**
     * @return Set containing the addresses
     * @throws NoEntriesException
     */
    @Override
    public Set<Address> getAllAddressEntries() throws NoEntriesException {
        return this.addressBook;
    }
}

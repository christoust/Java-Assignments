package com.ust.address.app;

import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.model.Address;
import com.ust.address.service.AddressBookImpl;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AddressApp {

    public void testAddressApp() throws DuplicateAddressException, NoEntriesException {
        AddressBookImpl addressBook = new AddressBookImpl();
        System.out.println("Welcome to Address app");
        int option =0;
        try {
            do {
                System.out.println("1.Add new address\n2.Show addresses\n3.Delete an address\n0.Exit app");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter any option from above menu");
                option = sc.nextInt();

                switch (option) {
                    case 1: {
                        System.out.println("Enter flat Id");
                        String flatId = sc.next();
                        System.out.println("Enter First Name");
                        String firstName = sc.next();
                        System.out.println("Enter pinCode");
                        String pinCode = sc.next();
                        System.out.println("Enter State Name");
                        String stateName = sc.next();
                        addressBook.addAddress(new Address(flatId, firstName, pinCode, stateName));
                        break;
                    }
                    case 2: {
                        Set<Address> addresses = addressBook.getAllAddressEntries();
                        Iterator<Address> addressIterator = addresses.iterator();
                        int i = 0;
                        while(addressIterator.hasNext())
                        {

                            Address address = addressIterator.next();
                            i=i+1;
                            System.out.println("Address\t"+i+"\n\tFlat ID:\t"+address.getFlatId()+"\n\tFirstName\t"+address.getFirstName()+"\n\tPincode\t"+address.getPinCode()+"\n\tStateName\t"+address.getStateName());
                        }
                        break;
                    }
                    case 0: {
                        System.out.println("Exiting program...");
                    }
                    default: {
                        System.out.println("Enter correct option");
                        break;
                    }
                }
            } while (option != 0);
        }catch (DuplicateAddressException e)
        {
            System.out.println(e.getMessage());
        }
    }


}

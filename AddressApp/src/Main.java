import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.exceptions.NoEntryException;
import com.ust.address.model.Address;
import com.ust.address.service.AddressBookImpl;

public class Main {
   
        public static void main(String[] args) throws DuplicateAddressException, NoEntriesException, NoEntryException {
            AddressBookImpl ob = new AddressBookImpl();
//            Thread addThread = new Thread(() -> {
//                try {
//                    boolean result = ob.addAddress(new Address("1", "c", "6", "kl"));
//                    System.out.println(result);
//                } catch (DuplicateAddressException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//            Thread removeThread = new Thread(() -> {
//                try {
//                    // Introduce a delay before calling removeAddress
//                    Thread.sleep(1000);
//                    ob.removeAddress("1");
//                } catch (InterruptedException | NoEntriesException | NoEntryException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//
//            addThread.start();
//            removeThread.start();
            ob.addAddress(new Address("1", "c", "6", "kl"));
            ob.removeAddress("4");
            System.out.println(ob.getAllAddressEntries());
        }

    }

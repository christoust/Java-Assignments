import com.ust.address.app.AddressApp;
import com.ust.address.exceptions.DuplicateAddressException;
import com.ust.address.exceptions.NoEntriesException;
import com.ust.address.exceptions.NoEntryException;

public class Main {
    public static void main(String[] args) throws DuplicateAddressException, NoEntriesException, NoEntryException {
        AddressApp addressApp = new AddressApp();
        addressApp.testAddressApp();

    }
}
package finance.view.event;

import finance.model.Account;
import javafx.event.Event;
import javafx.event.EventType;

public class SaveAccountEvent extends Event {

    private Account account;

    public SaveAccountEvent(Account account) {
        super(EventType.ROOT);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}

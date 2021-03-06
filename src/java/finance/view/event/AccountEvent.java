package finance.view.event;

import finance.model.Account;
import javafx.event.Event;
import javafx.event.EventType;

public class AccountEvent extends Event {

    private Account account;

    public AccountEvent(Account account) {
        super(EventType.ROOT);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}

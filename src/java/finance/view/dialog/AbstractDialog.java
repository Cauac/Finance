package finance.view.dialog;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AbstractDialog extends Stage {

    public void setModal(Window owner) {
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
    }
}

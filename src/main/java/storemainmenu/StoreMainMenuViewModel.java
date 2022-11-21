package storemainmenu;

import java.util.Observable;

public class StoreMainMenuViewModel extends Observable {

    private boolean visible;

    public StoreMainMenuViewModel() {
        setVisible(false);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        setChanged();
        notifyObservers();
    }
}

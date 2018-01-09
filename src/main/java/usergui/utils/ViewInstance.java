package usergui.utils;

import usergui.utils.Layouts.LayoutName;

/**
 * Created By Bartłomiej Woś
 */
public enum  ViewInstance {
    LOGIN(new LayoutName("/dbLogin.fxml")),
    LOGOUT(new LayoutName("/dbLogin.fxml")),
    MAIN_VIEW(new LayoutName("/dbMain.fxml"));

    private final LayoutName layoutName;

    private ViewInstance(LayoutName layoutName)
    {
        this.layoutName = layoutName;
    }

    /**
     * @return Section corresponding to this enum.
     */
    public LayoutName layoutName()
    {
        return this.layoutName;
    }

}

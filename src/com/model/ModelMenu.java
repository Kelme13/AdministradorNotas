/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import javax.swing.Icon;

/**
 *
 * @author kelvi
 */
public class ModelMenu {

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return the subMenu
     */
    public String[] getSubMenu() {
        return subMenu;
    }

    /**
     * @param subMenu the subMenu to set
     */
    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }
    
    public ModelMenu(Icon icon, String menuName, String... subMenu)
    {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }
    private Icon icon;
    private String menuName;
    private String subMenu[];
}

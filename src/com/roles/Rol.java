package com.roles;

import com.model.ModelMenu;
import javax.swing.ImageIcon;

public class Rol {

    public enum Tipo {
        COORDINADOR,
        ESTUDIANTE,
        DOCENTE
    }

    @Override
    public String toString() {
        if (null == tp) {
            return "Docente";
        } else return switch (tp) {
            case COORDINADOR -> "Coordinador";
            case ESTUDIANTE -> "Estudiante";
            default -> "Docente";
        };
    }

    /**
     * @return the tp
     */
    public Tipo getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(Tipo tp) {
        this.tp = tp;
    }

    /**
     * @return the itemsMenu
     */
    public ModelMenu[] getItemsMenu() {
        return itemsMenu;
    }

    /**
     * @param itemsMenu the itemsMenu to set
     */
    public void setItemsMenu(ModelMenu[] itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    private Tipo tp;
    private ModelMenu[] itemsMenu;

    public Rol(Tipo tp) {

        this.tp = tp;

        initMenu();
    }

    private void initMenu() {

        if (null != getTp()) {
            switch (getTp()) {
                case COORDINADOR:
                    setItemsMenu(new ModelMenu[4]);

                    getItemsMenu()[0] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/7.png")),
                            "Clases");
                    getItemsMenu()[1] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/6.png")),
                            "Estudiantes");

                    getItemsMenu()[2] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/5.png")),
                            "Docentes");

                    getItemsMenu()[3] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/12.png")),
                            "Usuarios");

                    break;
                case ESTUDIANTE:

                    // La idea es mandar como parametros las clases para crear un
                    // submenu y asi
                    setItemsMenu(new ModelMenu[3]);

                    getItemsMenu()[0] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/1.png")),
                            "Inicio");

                    getItemsMenu()[1] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/7.png")),
                            "Clases", "Todas", "Fisica I", "Teoria de Base Datos", "Ingles III");

                    getItemsMenu()[2] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/5.png")),
                            "Docentes");

                    break;
                case DOCENTE:
                    // Lo mismo como en el estudiantes
                    setItemsMenu(new ModelMenu[3]);

                    getItemsMenu()[0] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/1.png")),
                            "Inicio");

                    getItemsMenu()[1] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/7.png")),
                            "Clases", "Todas", "Fisica I", "Teoria de Base Datos", "Ingles III");

                    getItemsMenu()[2] = new ModelMenu(new ImageIcon(getClass().getResource("/com/icon/5.png")),
                            "Estudiantes");
                    break;
                default:
                    break;
            }
        }
    }

}

package com.main;

import javax.swing.Icon;
import com.component.Header;
import com.component.Menu;
import com.dialogs.Message;
import com.event.EventClasesVisualizar;
import com.event.EventMenuSelected;
import com.event.EventSeccionVisualizar;
import com.event.EventShowPopupMenu;
import com.form.Form1;
import com.form.Form_Clase;
import com.form.Form_Home;
import com.form.Form_Matricula;
import com.form.Form_TodasClases;
import com.form.Form_VistaClase;
import com.form.Form_VistaSeccion;
import com.form.Form_VistaTablaSecciones;
import com.form.MainForm;
import com.model.ModelClass;
import com.model.ModelMenu;
import com.model.ModelSeccion;
import com.model.ModelStudent;
import com.roles.Rol;
import static com.roles.Rol.Tipo.COORDINADOR;
import static com.roles.Rol.Tipo.DOCENTE;
import static com.roles.Rol.Tipo.ESTUDIANTE;
import com.roles.Usuario;
import com.swing.MenuItem;
import com.swing.PopupMenu;
import com.swing.icon.GoogleMaterialDesignIcons;
import com.swing.icon.IconFontSwing;
import com.swing.table.EventAction;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.sql.*;

/**
 *
 * @author kelvi
 */
public class Main extends javax.swing.JDialog {

    /**
     * @param eventSecciones the eventShowSecciones to set
     */
    public void setEventSecciones(EventClasesVisualizar eventSecciones) {
        this.eventShowSecciones = eventSecciones;
    }

    /**
     * @return the eventShowSecciones
     */
    public EventClasesVisualizar getEventSecciones() {
        return eventShowSecciones;
    }

    /**
     * @param eventSecciones the eventShowSecciones to set
     */
    public void addEventSecciones(EventClasesVisualizar eventSecciones) {
        this.setEventSecciones(eventSecciones);
    }

    private void cerrar() {
        this.dispose();
    }

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    private Usuario usuario;

    private EventClasesVisualizar eventShowSecciones;
    private EventSeccionVisualizar eventVisualizarSeccion;
    private EventAction eventStudent;

    public Main(Usuario usuario, java.awt.Frame parent) {
        super(parent, false);

        initComponents();
        this.setLocationRelativeTo(null);

        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/com/icon/profile2.jpg"));

        this.usuario = usuario;
        usuario.setIcon(icon);

        this.setVisible(true);

        init();
    }

    private void initHeaderElements() {
        header.setUser(usuario);
    }

    private void initEventVisualizarSecciones() {

        boolean editable = (usuario.getRol().getTp() == Rol.Tipo.COORDINADOR);

        this.setEventSecciones(new EventClasesVisualizar() {
            @Override
            public void visualizar(ModelClass clase) {
                // main.showForm(new Form_VistaClase(clase));
                main.showForm(new Form_VistaClase(clase, eventVisualizarSeccion, editable, usuario));
            }
        });

    }

    private void initEventVisualizarSeccion() {

        boolean editable = (usuario.getRol().getTp() == Rol.Tipo.DOCENTE);

        this.eventVisualizarSeccion = new EventSeccionVisualizar() {
            @Override
            public void visualizar(ModelSeccion seccion) {
                main.showForm(new Form_VistaSeccion(seccion, usuario.getRol().getTp()));
                //main.showForm(new Form_VistaClase(clase, eventVisualizarSeccion, editable));
            }
        };
    }

    private void initEventStudent() {
        this.eventStudent = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                System.out.println("Borrarrr " + student.getName());
            }

            @Override
            public void update(ModelStudent student) {
                Message input = new Message(Login.getFrames()[0], true);

                input.showMessage("Ingrese la nota para [ " + student.getName()
                        + " - " + student.getNoCuenta() + " ]");

                if (input.isOk()) {
                    System.out.println("Se va a actualizar la nota de");
                }
            }

            public void visualizar(ModelStudent student) {

                System.out.println("nomas ver xD " + student.getName());
            }
        };
    }

    private void initMenu() {

        menu = new Menu();
        menu.setItemsMenu(usuario.getRol().getItemsMenu());

        main = new MainForm();

        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {

                System.out.println("MenukIndex " + menuIndex + " SubMenuIndex " + subMenuIndex);

                // Dependiendo del rol, el index cumple diferentes funciones
                switch (usuario.getRol().getTp()) {
                    case COORDINADOR -> {
                        if (menuIndex == 0) {
                            main.showForm(new Form_TodasClases(eventShowSecciones, usuario));
                        }
                         else if(menuIndex == 4)
                        {
                            cerrar();
                        }
                    }
                    case ESTUDIANTE -> {
                        // Aqui seria crear un estudiante en base al usuario

                        if (menuIndex == 1) {
                            if (subMenuIndex == 0) {
                                main.showForm(new Form_Clase(usuario.getId(), 0));
                            } else if (subMenuIndex == 1) {
                                main.showForm(new Form_Clase(usuario.getId(), 1));
                            }
                        } else if (menuIndex == 3) {
                            cerrar();
                        } else if(menuIndex == 2)
                        {
                            if(subMenuIndex == 0)
                            {
                                main.showForm(new Form_Matricula(usuario));
                            }
                        }
                    }
                    case DOCENTE -> {
                        if (menuIndex == 1) {
                            main.showForm(new Form_TodasClases(eventShowSecciones, usuario));
                        } else if (menuIndex == 3) {
                            cerrar();
                        }
                    }
                    default -> {
                    }
                }

            }
        });

        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Login.getFrames()[0], item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);

            }

        });
        menu.initMenuItem();

    }

    private void initAnimationHeader() {

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.4f);

        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                //menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideAllMenu();
                }
            }
        });
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);

        header = new Header();
        initHeaderElements();

        initMenu();

        bg.add(menu, "w 230!, spany 2");
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");

        initAnimationHeader();

        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont()); // Para usar iconos de google en cualquier momento

        // Eventos para ver las clases y secciones
        initEventVisualizarSecciones();
        initEventVisualizarSeccion();
        initEventStudent();

        main.showForm(new Form_Home(usuario.getUsuario()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

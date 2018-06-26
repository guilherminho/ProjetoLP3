package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;

/**
 *
 * @author Sandro
 */
public class GUIMenu extends JFrame {

    ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/icones/guiannini.png"));
    JLabel logo = new JLabel(iconeLogo);

    public GUIMenu() {
        setTitle("Menu Example");
        Container cp = getContentPane();
        cp = getContentPane();
        cp.add(logo);
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("GUIs");
        menuBar.add(fileMenu);

        // Cria e adiciona um item simples para o menu
        JMenuItem marca = new JMenuItem("GUIMarca");
        JMenuItem tipo = new JMenuItem("GUITipo");
        JMenuItem produto = new JMenuItem("GUIProduto");
        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem venda = new JMenuItem("GUIVenda");

        // Cria e aiciona um CheckButton como um item de menu
        // Cria e aiciona um RadioButton como um item de menu
        // Cria um ButtonGroup e adiciona os dois radio Button
        fileMenu.add(produto);
        fileMenu.add(marca);
        fileMenu.add(tipo);
        fileMenu.addSeparator();
        fileMenu.add(cliente);
        fileMenu.addSeparator();
        fileMenu.add(venda);

        setVisible(true);

        produto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIProduto guiProduto = new GUIProduto();
            }
        });

        marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIMarca guiMarca = new GUIMarca();
            }
        });

        tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITipo guiTipo = new GUITipo();
            }
        });

        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });

        venda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIVenda guiVenda = new GUIVenda();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            }
        });

        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}

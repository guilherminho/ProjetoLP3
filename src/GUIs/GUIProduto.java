package GUIs;

import DAOs.DAOProduto;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Image;
import javax.swing.JTextField;
import tools.*;
import DAOs.*;

public class GUIProduto extends JFrame {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    private JPanel pnNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnCentro = new JPanel(new GridLayout(6, 2));
    private JPanel pnSul = new JPanel(new GridLayout(1, 1));
    private JPanel pnE1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel pnE3 = new JPanel(new GridLayout(1, 1));
    private JLabel lbIdProduto = new JLabel("IdProduto");
    private JTextField tfIdProduto = new JTextField(10);
    private JLabel lbNome = new JLabel("Nome");
    private JTextField tfNome = new JTextField(10);
    private JLabel lbPreco = new JLabel("Preco");
    private JTextField tfPreco = new JTextField(10);
    private JLabel lbDescricao = new JLabel("Descricao");
    private JTextField tfDescricao = new JTextField(10);
    private JPanel pnIdMarca = new JPanel(new GridLayout(1, 2));
    private JLabel lbIdMarca = new JLabel("IdMarca");
    private JTextField tfIdMarca = new JTextField();
    private JButton btIdMarca = new JButton("Procurar");
    private JPanel pnIdTipo = new JPanel(new GridLayout(1, 2));
    private JLabel lbIdTipo = new JLabel("IdTipo");
    private JTextField tfIdTipo = new JTextField();
    private JButton btIdTipo = new JButton("Procurar");
    JTextField tfCaminho = new JTextField();
    ScrollPane scroll = new ScrollPane();
    JTextArea jTextArea = new JTextArea();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String qualAcao = "";//variavel para facilitar insert e update
    DAOProduto daoProduto = new DAOProduto();
    Produto produto;
    private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
    private JPanel pnEsquerda = new JPanel(new BorderLayout());
    private JPanel pnDireita = new JPanel(new BorderLayout());
    private JLabel rotulo = new JLabel();
    private JButton btAbrirImagem = new JButton("Selecionar imagem");
    private String caminho;
    private Image imagemAux;
    private ImageIcon icone;

    public GUIProduto() {
        setSize(900, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("CRUD - Produto");
        Container cp = getContentPane();
        cp = getContentPane();
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        cp.setLayout(new GridLayout(1, 2));
        cp.add(pnEsquerda);
        cp.add(pnDireita);
        try {
            String caminho = "";
            tfCaminho.setText(caminho);
            icone = new ImageIcon(getClass().getResource(caminho));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            rotulo.setIcon(icone);
        } catch (Exception err) {
            System.out.println("erro " + err.getLocalizedMessage());
        }
        pnDireita.add(pnE1, BorderLayout.NORTH);
        pnE1.add(rotulo);
        pnDireita.add(pnE2, BorderLayout.CENTER);
        pnE2.add(btAbrirImagem);
        pnDireita.add(pnE3, BorderLayout.SOUTH);
        pnE3.add(tfCaminho);
        pnEsquerda.add(pnNorte, BorderLayout.NORTH);
        pnEsquerda.add(pnCentro, BorderLayout.CENTER);
        pnEsquerda.add(pnSul, BorderLayout.SOUTH);
        pnNorte.add(lbIdProduto);
        pnNorte.add(tfIdProduto);
        pnNorte.add(btnRetrieve);
        pnNorte.add(btnCreate);
        pnNorte.add(btnUpdate);
        pnNorte.add(btnDelete);
        pnNorte.add(btnSave);
        pnNorte.add(btnList);
        btnCancel.setVisible(false);
        btnDelete.setVisible(false);
        btnCreate.setVisible(false);
        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btAbrirImagem.setEnabled(false);
        tfCaminho.setEditable(false);
        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbPreco);
        pnCentro.add(tfPreco);
        pnCentro.add(lbDescricao);
        pnCentro.add(tfDescricao);
        pnCentro.add(lbIdMarca);
        pnCentro.add(pnIdMarca);
        pnIdMarca.add(tfIdMarca);
        pnIdMarca.add(btIdMarca);
        pnCentro.add(lbIdTipo);
        pnCentro.add(pnIdTipo);
        pnIdTipo.add(tfIdTipo);
        pnIdTipo.add(btIdTipo);
        pnSul.setBackground(Color.red);
        scroll.add(jTextArea);
        pnSul.add(scroll);
        tfCaminho.setEditable(false);
        tfNome.setEditable(false);
        tfPreco.setEditable(false);
        tfDescricao.setEditable(false);
        tfIdMarca.setEditable(false);
        btIdMarca.setEnabled(false);
        tfIdTipo.setEditable(false);
        btIdTipo.setEnabled(false);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tfIdProduto.setBackground(Color.white);
                    jTextArea.setText("");
                    produto = new Produto();
                    int identificador = Integer.valueOf(tfIdProduto.getText());
                    produto.setIdProduto(identificador);
                    produto = daoProduto.obter(produto.getIdProduto());
                    if (produto == null) {
                        pnNorte.setBackground(Color.red);
                        tfCaminho.setText("");
                        tfNome.setText("");
                        tfPreco.setText("");
                        tfDescricao.setText("");
                        tfCaminho.setText("");
                        tfIdMarca.setText("");
                        tfIdTipo.setText("");
                        btnCreate.setVisible(true);
                    } else {
                        pnNorte.setBackground(Color.green);
                        caminho = produto.getCaminho();
                        tfCaminho.setText(caminho);
                        icone = new ImageIcon(caminho);
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                        tfNome.setText(produto.getNome());
                        tfPreco.setText(String.valueOf(produto.getPreco()));
                        tfDescricao.setText(produto.getDescricao());
                        tfCaminho.setText(produto.getCaminho());
                        String dao1 = String.valueOf(produto.getIdMarca());
                        String[] aux1 = dao1.split("-");
                        tfIdMarca.setText(aux1[0]);
                        String dao2 = String.valueOf(produto.getIdTipo());
                        String[] aux2 = dao2.split("-");
                        tfIdTipo.setText(aux2[0]);
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);
                        btnCreate.setVisible(false);
                    }
                    btAbrirImagem.setEnabled(false);
                    tfIdProduto.setEditable(false);
                    tfNome.setEditable(false);
                    tfPreco.setEditable(false);
                    tfDescricao.setEditable(false);
                    btIdMarca.setEnabled(false);
                    btIdTipo.setEnabled(false);
                    tfIdProduto.selectAll();
                } catch (Exception erro) {
                    pnNorte.setBackground(Color.yellow);
                    tfIdProduto.requestFocus();
                    tfIdProduto.setBackground(Color.red);
                    jTextArea.setText("Erro... \n");
                    jTextArea.append(erro.getMessage());
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfIdProduto.setEditable(false);
                tfNome.requestFocus();
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                qualAcao = "incluir";
                produto = new Produto();
                tfNome.setEditable(true);
                tfPreco.setEditable(true);
                tfDescricao.setEditable(true);
                btIdMarca.setEnabled(true);
                btIdTipo.setEnabled(true);
                tfIdProduto.setEditable(false);
                btAbrirImagem.setEnabled(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextArea.setText("");
                    produto = new Produto();
                    produto.setIdProduto(Integer.valueOf(tfIdProduto.getText()));
                    produto.setNome(tfNome.getText());
                    produto.setPreco(Double.valueOf(tfPreco.getText()));
                    produto.setDescricao(tfDescricao.getText());
                    produto.setCaminho(tfCaminho.getText());
                    String[] aux0 = tfIdMarca.getText().split("-");
                    DAOMarca daoMarca = new DAOMarca();
                    Marca d0 = daoMarca.obter(Integer.valueOf(aux0[0]));
                    produto.setIdMarca(d0);
                    String[] aux1 = tfIdTipo.getText().split("-");
                    DAOTipo daoTipo = new DAOTipo();
                    Tipo d1 = daoTipo.obter(Integer.valueOf(aux1[0]));
                    produto.setIdTipo(d1);
                    caminho = tfCaminho.getText();
                    produto.setCaminho(caminho);
                    caminho = "";
                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);
                    if (qualAcao.equals("incluir")) {
                        daoProduto.inserir(produto);
                    } else {
                        daoProduto.atualizar(produto);
                    }
                    tfIdProduto.setEditable(true);
                    tfIdProduto.requestFocus();
                    tfNome.setText("");
                    tfPreco.setText("");
                    tfDescricao.setText("");
                    tfCaminho.setText("");
                    tfIdMarca.setText("");
                    tfIdTipo.setText("");
                    tfCaminho.setText("");
                    btnSave.setVisible(false);
                    pnNorte.setBackground(Color.green);
                    tfNome.setEditable(false);
                    tfPreco.setEditable(false);
                    tfDescricao.setEditable(false);
                    tfCaminho.setEditable(false);
                    btIdMarca.setEnabled(false);
                    btIdTipo.setEnabled(false);
                    btAbrirImagem.setEnabled(false);
                } catch (Exception erro) {
                    jTextArea.append("Erro............");
                    tfIdProduto.setEditable(true);
                    pnNorte.setBackground(Color.red);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btAbrirImagem.setEnabled(true);
                tfNome.requestFocus();
                btnSave.setVisible(true);
                qualAcao = "editar";
                tfNome.setEditable(true);
                tfPreco.setEditable(true);
                tfDescricao.setEditable(true);
                btIdMarca.setEnabled(true);
                btIdTipo.setEnabled(true);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + produto.getIdProduto() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    daoProduto.remover(produto);
                    tfIdProduto.requestFocus();
                    tfNome.setText("");
                    tfPreco.setText("");
                    tfDescricao.setText("");
                    tfCaminho.setText("");
                    tfIdMarca.setText("");
                    tfIdTipo.setText("");
                    String caminho = "";

                    icone = new ImageIcon(caminho);
                    rotulo.setIcon(icone);

                    tfCaminho.setText("");
                    tfIdProduto.setEditable(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIListagemProduto guiListagem = new GUIListagemProduto(daoProduto.list());
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btAbrirImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(pnDireita) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    String caminho = fc.getSelectedFile().getAbsolutePath();
                    try {
                        tfCaminho.setText(caminho);
                        icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                        imagemAux = icone.getImage();
                        icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                        rotulo.setIcon(icone);
                    } catch (Exception ex) {
                        System.out.println("Erro: " + ex.getMessage());
                    }
                }
            }
        });
        DAOMarca daoMarca = new DAOMarca();
        btIdMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoMarca.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdMarca.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        DAOTipo daoTipo = new DAOTipo();
        btIdTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoTipo.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdTipo.setText(aux[0]);
                    } else {
                        jTextArea.setText("Nenhum dado adicionado!");
                    }
                }
            }
        });
        tfIdProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoProduto.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdProduto.setText(aux[0]);
                        btnRetrieve.doClick();

                    } else {
                        tfIdProduto.requestFocus();
                        tfIdProduto.selectAll();
                    }
                }
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        GUIProduto guiProduto = new GUIProduto();
    }
}

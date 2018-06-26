package GUIs;
import DAOs.DAOCliente;
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
public class GUICliente extends JFrame {
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
private JPanel pnCentro = new JPanel(new GridLayout(5, 2));
private JPanel pnSul = new JPanel(new GridLayout(1, 1));
private JLabel lbCpf = new JLabel("Cpf");
private JTextField tfCpf = new JTextField(10);
private JLabel lbLogin = new JLabel("Login");
private JTextField tfLogin = new JTextField(10);
private JLabel lbSenha = new JLabel("Senha");
private JTextField tfSenha = new JTextField(10);
private JLabel lbNome = new JLabel("Nome");
private JTextField tfNome = new JTextField(10);
private JLabel lbEndereco = new JLabel("Endereco");
private JTextField tfEndereco = new JTextField(10);
private JLabel lbTelefone = new JLabel("Telefone");
private JTextField tfTelefone = new JTextField(10);
ScrollPane scroll = new ScrollPane();
JTextArea jTextArea = new JTextArea();
JPanel aviso = new JPanel();
JLabel labelAviso = new JLabel("");
String qualAcao = "";//variavel para facilitar insert e update
DAOCliente daoCliente = new DAOCliente();
Cliente cliente;
private CaixaDeFerramentas ferramentas = new CaixaDeFerramentas();
public GUICliente() {
setSize(900, 400);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setTitle("CRUD - Cliente");
Container cp = getContentPane();cp = getContentPane();
btnCreate.setToolTipText("Inserir novo registro");
btnRetrieve.setToolTipText("Pesquisar por chave");
btnUpdate.setToolTipText("Alterar");
btnDelete.setToolTipText("Excluir");
btnList.setToolTipText("Listar todos");
btnSave.setToolTipText("Salvar");
btnCancel.setToolTipText("Cancelar");cp.setLayout(new BorderLayout());
cp.add(pnNorte, BorderLayout.NORTH);
cp.add(pnCentro, BorderLayout.CENTER);
cp.add(pnSul, BorderLayout.SOUTH);pnNorte.add(lbCpf);
pnNorte.add(tfCpf);
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
pnCentro.add(lbLogin);
pnCentro.add(tfLogin);
pnCentro.add(lbSenha);
pnCentro.add(tfSenha);
pnCentro.add(lbNome);
pnCentro.add(tfNome);
pnCentro.add(lbEndereco);
pnCentro.add(tfEndereco);
pnCentro.add(lbTelefone);
pnCentro.add(tfTelefone);
pnSul.setBackground(Color.red);
scroll.add(jTextArea);
pnSul.add(scroll);
tfLogin.setEditable(false);
tfSenha.setEditable(false);
tfNome.setEditable(false);
tfEndereco.setEditable(false);
tfTelefone.setEditable(false);
btnRetrieve.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
tfCpf.setBackground(Color.white);
jTextArea.setText("");
cliente = new Cliente();
String identificador = tfCpf.getText();
cliente.setCpf(identificador);
cliente = daoCliente.obter(cliente.getCpf());
if (cliente == null) {
pnNorte.setBackground(Color.red);
tfLogin.setText("");
tfSenha.setText("");
tfNome.setText("");
tfEndereco.setText("");
tfTelefone.setText("");
btnCreate.setVisible(true);
} else {
pnNorte.setBackground(Color.green);
tfLogin.setText(cliente.getLogin());
tfSenha.setText(cliente.getSenha());
tfNome.setText(cliente.getNome());
tfEndereco.setText(cliente.getEndereco());
tfTelefone.setText(cliente.getTelefone());
btnUpdate.setVisible(true);
btnDelete.setVisible(true);
btnCreate.setVisible(false);
}
tfCpf.setEditable(false);
tfLogin.setEditable(false);
tfSenha.setEditable(false);
tfNome.setEditable(false);
tfEndereco.setEditable(false);
tfTelefone.setEditable(false);
tfCpf.selectAll();
} catch (Exception erro) {
pnNorte.setBackground(Color.yellow);
tfCpf.requestFocus();
tfCpf.setBackground(Color.red);
jTextArea.setText("Erro... \n");
jTextArea.append(erro.getMessage());
}
}
});
btnCreate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
tfCpf.setEditable(false);
tfLogin.requestFocus();
btnCreate.setVisible(false);
btnSave.setVisible(true);
qualAcao = "incluir";
cliente = new Cliente();
tfLogin.setEditable(true);
tfSenha.setEditable(true);
tfNome.setEditable(true);
tfEndereco.setEditable(true);
tfTelefone.setEditable(true);
tfCpf.setEditable(false);
}
});
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
jTextArea.setText("");
cliente = new Cliente();
cliente.setCpf(tfCpf.getText());
cliente.setLogin(tfLogin.getText());
cliente.setSenha(tfSenha.getText());
cliente.setNome(tfNome.getText());
cliente.setEndereco(tfEndereco.getText());
cliente.setTelefone(tfTelefone.getText());
if (qualAcao.equals("incluir")) {
daoCliente.inserir(cliente);
} else {
daoCliente.atualizar(cliente);
}
tfCpf.setEditable(true);
tfCpf.requestFocus();
tfLogin.setText("");
tfSenha.setText("");
tfNome.setText("");
tfEndereco.setText("");
tfTelefone.setText("");
btnSave.setVisible(false)
;pnNorte.setBackground(Color.green);
tfLogin.setEditable(false);
tfSenha.setEditable(false);
tfNome.setEditable(false);
tfEndereco.setEditable(false);
tfTelefone.setEditable(false);
} catch (Exception erro){
jTextArea.append("Erro............");
tfCpf.setEditable(true);
pnNorte.setBackground(Color.red); 
}
}
});
btnUpdate.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
tfLogin.requestFocus();
btnSave.setVisible(true);
qualAcao = "editar";
tfLogin.setEditable(true);
tfSenha.setEditable(true);
tfNome.setEditable(true);
tfEndereco.setEditable(true);
tfTelefone.setEditable(true);
}
});
btnDelete.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
"Confirma a exclusão do registro <ID = " + cliente.getCpf() + ">?", "Confirm",
JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
daoCliente.remover(cliente);
tfCpf.requestFocus();
tfLogin.setText("");
tfSenha.setText("");
tfNome.setText("");
tfEndereco.setText("");
tfTelefone.setText("");
tfCpf.setEditable(true);
btnUpdate.setVisible(false);
btnDelete.setVisible(false);
}
}
});
btnList.addActionListener(new ActionListener() {
@Override
 public void actionPerformed(ActionEvent e) {
GUIListagemCliente guiListagem = new GUIListagemCliente(daoCliente.list());
}
});
setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
tfCpf.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
if (listaAuxiliar.size() > 0) {
String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
if (!selectedItem.equals("")) {
String[] aux = selectedItem.split("-");
tfCpf.setText(aux[0]);
btnRetrieve.doClick();

} else {
tfCpf.requestFocus();tfCpf.selectAll();}
}
}
});
CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
setVisible(true);
}
public static void main(String[] args) {
GUICliente guiCliente = new GUICliente();
}
}

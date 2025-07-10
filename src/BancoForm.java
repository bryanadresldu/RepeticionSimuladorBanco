import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoForm extends JFrame{

    private JPanel PanelBanco;
    private JLabel nombreLabel;
    private JLabel saldoLabel;
    private JButton depositarButton;
    private JButton retirarButton;
    private JButton transferirButton;
    private JButton salirButton;
    private JTextArea historialTextArea;
    private Cliente cliente= new Cliente("Bryan Angulo",1000);;

    public BancoForm() {

        setTitle("Sistema Bancario");
        setContentPane(PanelBanco);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500,500);
        setVisible(true);

        actualizarPantalla();

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoDepositar = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                try {
                    double monto = Double.parseDouble(montoDepositar);
                    if (monto > 0) {
                        cliente.depositar(monto);
                        actualizarSaldo();
                        historialTextArea.append("Depósito: " + monto + "\n");
                        JOptionPane.showMessageDialog(null, "Deposito realizado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un monto positivo.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Monto invalido");
                }

            }
        });
        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoRetiro= JOptionPane.showInputDialog("Ingrese monto a retirar:");
                try {
                    double monto = Double.parseDouble(montoRetiro);
                    if (monto <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un monto positivo.");
                    } else if (cliente.retirar(monto)) {
                        actualizarSaldo();
                        historialTextArea.append("Retiro: " + monto+ "\n");
                        JOptionPane.showMessageDialog(null, "Retiro realizado con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Monto invalido");
                }


            }
        });
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField destinatario = new JTextField(15);
                JTextField montoField = new JTextField(15);

                JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));

                panel.add(new JLabel("Nombre del destinatario:"));
                panel.add(destinatario);
                panel.add(new JLabel("Monto a transferir:"));
                panel.add(montoField);
                JOptionPane.showMessageDialog(null, panel, "Transferencia", JOptionPane.PLAIN_MESSAGE);

                try {
                    String nombreDestinatario = destinatario.getText().trim();
                    double monto = Double.parseDouble(montoField.getText());
                    if (nombreDestinatario.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un nombre de destinatario.");
                    } else if (monto <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un monto positivo.");
                    } else if (cliente.retirar(monto)) {
                        actualizarSaldo();
                        historialTextArea.append("Transferencia a " + nombreDestinatario + ": -$" + monto + "\n");
                        JOptionPane.showMessageDialog(null, "Transferencia exitosa a " + nombreDestinatario + " por $" + monto);
                    } else {

                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datos inválidos");
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                System.exit(0);
                dispose();

            }
        });
    }

    private void actualizarPantalla() {
        nombreLabel.setText("Cliente: " + cliente.getNombre());
        saldoLabel.setText("Saldo actual: $" + cliente.getSaldo());
    }

    private void actualizarSaldo() {
        saldoLabel.setText("Saldo actual: $" + cliente.getSaldo());
    }
}

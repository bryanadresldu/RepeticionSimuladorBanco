import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferirForm extends JFrame{
    private JTextField destinatario;
    private JTextField montoField;
    private JPanel transferirPanel;
    private JButton transferirButton;

    private Cliente cliente;
    private BancoForm bancoForm;

    public TransferirForm(Cliente cliente,  BancoForm bancoForm){
        this.cliente = cliente;
        this.bancoForm = bancoForm;

        setTitle("Transferencia");
        setContentPane(transferirPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);


        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreDestinatario = destinatario.getText().trim();
                    double monto = Double.parseDouble(montoField.getText());
                    if (nombreDestinatario.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un nombre de destinatario.");
                    } else if (monto <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese un monto positivo.");
                    } else if (cliente.retirar(monto)) {
                        bancoForm.agregarTransferenciaAHistorial(nombreDestinatario, monto);
                        JOptionPane.showMessageDialog(null, "Transferencia exitosa a " + nombreDestinatario + " por $" + monto);
                        dispose();
                    } else {

                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datos inválidos");
                }

            }
        });


    }


}

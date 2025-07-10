import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame{
    private JPanel PanelLogin;
    private JTextField usuario_textField;
    private JPasswordField passwordField;
    private JButton ingresarButton;

    public LoginForm() {
        setTitle(" Sistema de Ingreso");
        setContentPane(PanelLogin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario=usuario_textField.getText();
                String contrasenia=String.valueOf(passwordField.getPassword());

                if(usuario.equals("cliente123")&&contrasenia.equals("clave456")){
                    JOptionPane.showMessageDialog(null,"Ingreso exitoso");
                    new BancoForm();
                    dispose();}
                else
                    JOptionPane.showMessageDialog(null, "Usuario o contrasenia incorrecto","error",JOptionPane.ERROR_MESSAGE);

            }
        });
    }


}

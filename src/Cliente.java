
public class Cliente {
    private String nombre;
    private double saldo;

    public Cliente(String nombre, double saldoInicial) {
        this.nombre = nombre;
        this.saldo = saldoInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public boolean transferir(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}

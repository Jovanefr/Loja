package models;

public class Cartao {
    
    private String titular;
    private double saldo;
    
    public Cartao(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void saque(double valor){
        saldo -= valor;
    }
}

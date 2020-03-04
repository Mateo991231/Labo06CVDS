package edu.eci.cvds.servlet;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Random;

@SessionScoped
@ManagedBean(name = "guess")

public class BackingBean {
    public int numeroCorrecto;
    public int numeroIntentos;
    public int total;
    public boolean status;


    public BackingBean() {
        restart();

    }

    public void guess(int num) {
        numeroIntentos++;
        if (numeroCorrecto != num) {
            total -= 10000;
        } else if (numeroCorrecto == num) {
            status = true;
            if(numeroIntentos==1){
                total+=100000;
            }        }
    }
    public void restart(){
        Random random= new Random(21);
        numeroCorrecto=random.nextInt();
        numeroIntentos=0;
        status=false;
        total=0;
    }
    public int getNumeroCorrecto() {
        return numeroCorrecto;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public int getTotal() {
        return total;
    }
    public void setStatus(boolean status){
        this.status=status;

    }
    public void setNumeroCorrecto(int correcto){
        this.numeroCorrecto=correcto;
    }

    public void setNumeroIntentos(){
        this.numeroIntentos++;
    }

    public void setTotal(int total){
        this.total=total;
    }

    public boolean getEstado() {
        return status;
    }
}
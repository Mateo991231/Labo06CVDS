package edu.eci.cvds.servlet;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.util.Random;

@SessionScoped
@ManagedBean(name = "guessBean")
public class BackingBean {
    private int guessNumber;
    private int Attempts;
    private int prize;
    private boolean state;
    private int input;

    public BackingBean(){ restart(); }
    public int getInput() { return input; }
    public void setEstado(boolean bol){ this.state=bol; }
    public void setNumeroAdivinar(int number){ this.guessNumber=number; }
    public void setIntentos(){ this.Attempts++; }
    public void setPremio(int premio){ this.prize=premio; }
    public int getNumeroAdivinar() { return guessNumber; }
    public int getIntentos() { return Attempts; }
    public int getPremio() { return prize; }
    public String getState() { return state?"\n"+"Won":"Game in progress"; }
    public void guess(){
        Attempts++;
        if(guessNumber!=input){
            prize-=10000;
        }
        else{
            state=true;
        }
    }
    public void adivinar(){
        Attempts++;
        if(guessNumber!=input){
            prize-=10000;
        }
        else{
            state=true;
        }
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void restart(){
        Random random= new Random(21);
        guessNumber=random.nextInt();
        Attempts=0;
        state=false;
        prize=100000;
    }


}
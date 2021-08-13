package com.felipe.lapajogo;

public class Item {
    private String Nome;
    private int Efeito;
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getEfeito() {
        return Efeito;
    }

    public void setEfeito(int Efeito) {
        this.Efeito = Efeito;
    }
 
    public Item() {
        this.Nome = Nome;
        this.Efeito = Efeito;
    }
  
    public void aplicarefeito(Personagem p){ 
        
    }
}

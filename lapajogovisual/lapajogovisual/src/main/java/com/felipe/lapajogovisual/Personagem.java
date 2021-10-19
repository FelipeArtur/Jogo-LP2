package com.felipe.lapajogovisual;
public abstract class Personagem {
    
   //ATRIBUTOS
   public String nome;
   private int vida;
   private int defesa;
   private int ph; //Ponto de habilidade usado para as ults
   private int dano;
   private char icone;
   public int linha;
   public int coluna;
   
   
    //MÉTODOS PERSONALIZADOS
    public void atacar(char[][] mapa,Personagem pAtacado){ //Atacar apenas para frente
  
    }
   
    public void ult(){ //Particular de cada um 

    }
    
    //SOBREPOSICAO
    public void ult(char[][] mapa, Personagem pAtacado, Personagem pAtacado2, Personagem pAtacado3){ //Particular de cada um 

    }
    
   //Construtor 
    public Personagem() {
        this.nome = nome;
        this.vida = vida;
        this.defesa = defesa;
        this.ph = ph;
        this.dano = dano;
        this.icone = icone;
        this.linha = linha;
        this.coluna = coluna;
    }
    
    //Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome; 
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida; 
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa; 
    }

    public int getPh() {
        return ph;
    }

    public void setPh(int ph) {
        this.ph = ph; 
    }
    
    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano; 
    }
    
    public char getIcone() {
        return icone;
    }

    public void setIcone(char icone) {
        this.icone = icone;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    
}

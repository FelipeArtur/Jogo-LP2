package com.felipe.lapajogo;
public class CotaDeMalha extends Item{
    
    public CotaDeMalha(){
        this.setNome("Cota de Malha");
        this.setEfeito(50);
    }
    
    @Override
      public void aplicarefeito(Personagem p){      
        p.setVida(p.getVida() + this.getEfeito());
        System.out.println("O item "+this.getNome()+" foi usado em "+p.getNome());
    }
}
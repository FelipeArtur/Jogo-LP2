package com.felipe.lapajogo;
public class Anel extends Item{
    
    public Anel(){
        this.setNome("Anel");
        this.setEfeito(50);
    }
    
    @Override
    public void aplicarefeito(Personagem p){      
        p.setPh(p.getPh() + this.getEfeito());
        System.out.println("O item "+this.getNome()+" foi usado em "+p.getNome());
    }
}

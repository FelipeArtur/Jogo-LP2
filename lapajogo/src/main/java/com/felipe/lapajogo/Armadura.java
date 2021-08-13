package com.felipe.lapajogo;
public class Armadura extends Item{
    
    public Armadura(){
        this.setNome("Armadura");
        this.setEfeito(50);
    }
    
    @Override
    public void aplicarefeito(Personagem p){      
        p.setDefesa(p.getDefesa() + this.getEfeito());
        System.out.println("O item "+this.getNome()+" foi usado em "+p.getNome());
    }
}

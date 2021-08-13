package com.felipe.lapajogo;
public class Luva extends Item{
    
    public Luva(){
        this.setNome("Luva");
        this.setEfeito(50);
    }

    @Override
     public void aplicarefeito(Personagem p){      
        p.setDano(p.getDano() + this.getEfeito());
        System.out.println("O item "+this.getNome()+" foi usado em "+p.getNome());
    }
}

package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;

public class Luva extends Item{
    
    public Luva(){
        this.setNome("Luva");
        this.setEfeito(50);
    }

    @Override
     public void aplicarefeito(Personagem p){      
        p.setDano(p.getDano() + this.getEfeito());
        Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O item "+this.getNome()+" foi usado em "+p.getNome()); a1.setHeaderText(null); a1.showAndWait();
    }
}

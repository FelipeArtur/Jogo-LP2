package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;

public class Anel extends Item{
    
    public Anel(){
        this.setNome("Anel");
        this.setEfeito(50);
    }
    
    @Override
    public void aplicarefeito(Personagem p){      
        p.setPh(p.getPh() + this.getEfeito());
        Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O item "+this.getNome()+" foi usado em "+p.getNome()); a1.setHeaderText(null); a1.showAndWait();
    }
}

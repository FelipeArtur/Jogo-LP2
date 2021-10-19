package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Zagreu extends Personagem{
//FELIPE ARTUR MACEDO LIMA 
    public Zagreu(){
        this.setNome("Zagreu");
        this.setVida(200);
        this.setDano(25);
        this.setDefesa(100);
        this.setPh(50);
        this.setIcone('#');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 2 casas;
        //Zagreu nega a armadura de seus oponentes, ou seja, ele ataca diretamente a vida deles
        //Alem disso, ao atacar inimigos ele ganhar 5 de vida
        //Sua ult deixa ele reviver apenas uma vez por combate, ele volta com 200 de vida
        boolean achouPatacado = false;
        for(int i = 1; i <= 4; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = this.linha + 1; j < this.linha + i; j++ ){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                    }
                }    
                break;
            }
          }
          
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = this.linha - 1; j < this.linha - i; j--){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                    }
                }              
                break;
            }
         }
        }
            if(achouPatacado){
                //System.out.println(pAtacado.getNome()+" foi golpeado por "+this.getNome());
                //pAtacado.setVida(pAtacado.getVida() - this.getDano());
                //this.setVida(this.getVida() + (this.getDano()/2));
             if(pAtacado.getDefesa() != 0){
                pAtacado.setDefesa(pAtacado.getDefesa() - this.getDano()); 
                 if(pAtacado.getDefesa() - this.getDano() < 0){
                    int danoExtra = (pAtacado.getDefesa() - this.getDano()) * -1;
                    pAtacado.setDefesa(0);
                    pAtacado.setVida(pAtacado.getVida() - danoExtra);
                 }
             }else if (pAtacado.getDefesa() == 0){
                 pAtacado.setVida(pAtacado.getVida() - this.getDano());
             }           
            //===MOSTRAR DANO
               Image img = new Image(getClass().getResourceAsStream("dano.gif"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(pAtacado.getNome()+" foi golpeado por "+this.getNome()); a1.setHeaderText(null); a1.showAndWait();
                        
                if(pAtacado.getVida() <= 0){
                    Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText("Manda um abraço para o meu pai "+pAtacado.getNome()+ " ,fala que "+this.getNome()+ "te mandou"); a2.setHeaderText(null); a2.showAndWait();
                    Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                    pAtacado.setVida(0);
                }
            //===TIRAR O DANO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============                  

            }else{
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque"); a1.setHeaderText(null); a1.showAndWait();
            }
    }
    
    @Override
    public void ult(){
    //A Ult(Reviver) é uma magia criada pelo Zagreu que ou recupera
    //a vido toda em caso de vida<=50;
    //Revive uma vez
       if(this.getVida() <= 50 && this.getPh() == 50){
            //===MOSTRAR EFEITO
               Image img = new Image(getClass().getResourceAsStream("energia3.gif"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============            
           this.setVida(200);
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Mais uma chance"); a1.setHeaderText(null); a1.showAndWait();
            //===TIRAR O EFEITO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img1);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============           
           this.setPh(this.getPh() - 50);
       }else if (this.getVida() != 0){
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Ainda estou vivo"); a1.setHeaderText(null); a1.showAndWait(); 
       }else{
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Sem PH o sufuciente"); a1.setHeaderText(null); a1.showAndWait(); 
       }
    }
}
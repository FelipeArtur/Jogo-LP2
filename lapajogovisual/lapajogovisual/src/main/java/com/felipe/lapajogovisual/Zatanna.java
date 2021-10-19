package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Zatanna extends Personagem {
    //DANILO SCHELTES CARDOSO
    public Zatanna(){
        this.setNome("Zatanna");
        this.setVida(175);
        this.setDano(25);
        this.setDefesa(100);
        this.setPh(100);
        this.setIcone('Z');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 3 casas;
        //O ataque so vai pra frente e para tras
        //O ataque basico da Zatanna se trata da envocação de uma Bola de Fogo atirada em um inimigo
        //Vale ressaltar que ele nao atravessa obstaculos(~), atravessa somente persnoagens;
        boolean achouPatacado = false;
        for(int i = 1; i <= 2; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }
                break;
            }
          }
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;
            }
          }
 
        }
        if(achouPatacado){
            //System.out.println(this.getNome()+"Ogof!!(Fogo) Uma Bola de fogo foi airada no inimigo: " +pAtacado.getNome());
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+"Ogof!!(Fogo) Uma Bola de fogo foi airada no inimigo: " +pAtacado.getNome()); a1.setHeaderText(null); a1.showAndWait(); 
            
            if(pAtacado.getVida() <= 0){
                Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();
                Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                pAtacado.setVida(0);
            }  
            //===TIRAR O DANO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //=============== 
        }else{
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("A Bola de Fogo não atingiu ninguém ou bateu em um obstaculo."); a1.setHeaderText(null); a1.showAndWait(); 
        }
        
    }
    
    @Override
    public void ult(){
        //A Ult (Opmac ed saçrof) se trata de um campo de força criada por Zatanna;
        //Que consede a personagem um Bonos de 50 de Defesa;
    if(this.getPh() >= 50){
            //===MOSTRAR EFEITO
               Image img = new Image(getClass().getResourceAsStream("energia3.gif"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //=============== 
             Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Opmac ed saçrof!!"); a1.setHeaderText(null); a1.showAndWait();
            //===TIRAR O EFEITO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img1);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============            
           this.setDefesa(this.getDefesa() + 50);
           this.setPh(this.getPh() - 50);
       }else{
          Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Não tenho Pontos de Habiliadade (Ph) suficientes para essa magia"); a1.setHeaderText(null); a1.showAndWait();
       }
   }
  

}


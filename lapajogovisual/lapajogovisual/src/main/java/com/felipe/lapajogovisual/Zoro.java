/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Zoro extends Personagem{
// FELIPE SERRA PORTO DE AZEVEDO ☺
    public Zoro(){
        this.setNome("Zoro");
        this.setVida(100);
        this.setDano(40);
        this.setDefesa(100);
        this.setPh(50);
        this.setIcone('$');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 2 casas;
        //O ataque basico do Zoro pula personagens inimigos e aliados; //Exemplo se eh tiver um personagem na frente do zoro e um atras desse
        // e for pedido para atacar o de tras ele ira ignorar o da frente dele e dara o dano do de tras
        // Vale ressaltar que ele nao atravessa obstaculos(~);
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
          if(this.coluna + i < Mapa.length - 1){//verifica se esta a direita
            if(Mapa[this.linha][this.coluna + i] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;                
            }
          }
          if(this.coluna - i > 0){//verifica se esta a esquerda
            if(Mapa[this.linha][this.coluna - i] == pAtacado.getIcone()){
                achouPatacado = true;
                if(Mapa[(this.linha + i) - 1][this.coluna] == '~'){
                     achouPatacado = false;
                }                
                break;  
            }
          } 
        }
        if(achouPatacado){
            //System.out.println(this.getNome()+" atacando com estilo duplo o inimigo: " +pAtacado.getNome());
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" atacando com estilo duplo o inimigo: " +pAtacado.getNome()); a1.setHeaderText(null); a1.showAndWait();
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem que voce escolheu atacar não esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque"); a1.showAndWait();
        }
        
    }
    
    @Override
    public void ult(char[][] Mapa, Personagem pAtacado, Personagem pAtacado2, Personagem pAtacado3){//PRONTO
        //A ult(Sentoryu) eh ataque com range ate o final das casas;
        //Ele pode ser utilizado para frente ou para tras;
        //Porem se um personagem aliado estiver na frente da linha do ataque, o aliado nao sofrera da dano e o ataque nao passara;
        //O ult atrevessa personagens inimigos, logo se tiver 3 inimigos um atras do outro, os levam o dano
        //Dano da ult eh 180
       int dano = 180;
       if (this.getPh() >= 50){
           boolean achouPatacado1 = false;
           boolean achouPatacado2 = false;
           boolean achouPatacado3 = false;
           for(int i = this.linha + 1; i < Mapa.length; i++){
               if(Mapa[i][this.coluna] == pAtacado.getIcone()){
                   achouPatacado1 = true;
               }else if(Mapa[i][this.coluna] == pAtacado2.getIcone()){
                   achouPatacado2 = true;
               }else if(Mapa[i][this.coluna] == pAtacado3.getIcone()){
                   achouPatacado3 = true;
               }else if(Mapa[i][this.coluna] != '*'){
                   break;                   
               }
           }
           for(int i = this.linha - 1; i > 0; i--){
               if(Mapa[i][this.coluna] == pAtacado.getIcone()){
                    achouPatacado1 = true;  
               }else if(Mapa[i][this.coluna] == pAtacado2.getIcone()){
                   achouPatacado2 = true;
               }else if(Mapa[i][this.coluna] == pAtacado3.getIcone()){
                   achouPatacado3 = true;
               }else if(Mapa[i][this.coluna] != '*'){
                   break;                   
               }
           }
           
        this.setPh(this.getPh() - 50);  
        if(achouPatacado1){
            //System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado.getNome());
            if(pAtacado.getDefesa() != 0){
                if(pAtacado.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado.getDefesa() - dano) * -1;
                    pAtacado.setDefesa(0);
                    pAtacado.setVida(pAtacado.getVida() - danoExtra);
                }else{
                    pAtacado.setDefesa(pAtacado.getDefesa() - dano);                     
                }
            }else if (pAtacado.getDefesa() == 0){
                 pAtacado.setVida(pAtacado.getVida() - dano);
            }  
            //===MOSTRAR DANO
               Image img = new Image(getClass().getResourceAsStream("dano.gif"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado.getNome()); a1.setHeaderText(null); a1.showAndWait();
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
            
        }
        if(achouPatacado2){
            //System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado2.getNome());
            if(pAtacado2.getDefesa() != 0){
                if(pAtacado2.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado2.getDefesa() - dano) * -1;
                    pAtacado2.setDefesa(0);
                    pAtacado2.setVida(pAtacado2.getVida() - danoExtra);
                }else{
                    pAtacado2.setDefesa(pAtacado2.getDefesa() - dano);                     
                }
            }else if (pAtacado2.getDefesa() == 0){
                 pAtacado2.setVida(pAtacado2.getVida() - dano);
            }  
            //===MOSTRAR DANO
               Image img = new Image(getClass().getResourceAsStream("dano.gif"));
                App.mapaAnimacao[pAtacado2.linha][pAtacado2.coluna].setImage(img);
                App.mapaAnimacao[pAtacado2.linha][pAtacado2.coluna].setPreserveRatio(false);            
            //===============
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado2.getNome()); a1.setHeaderText(null); a1.showAndWait();
            if(pAtacado2.getVida() <= 0){
                Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado2.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();    
                Mapa[pAtacado2.linha][pAtacado2.coluna] = '*';
                pAtacado2.setVida(0);
            }
            //===TIRAR O DANO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============               
        }
        if(achouPatacado3){
            //System.out.println(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado3.getNome());
            if(pAtacado3.getDefesa() != 0){
                if(pAtacado3.getDefesa() - dano < 0){
                    int danoExtra = (pAtacado3.getDefesa() - dano) * -1;
                    pAtacado3.setDefesa(0);
                    pAtacado3.setVida(pAtacado3.getVida() - danoExtra);
                }else{
                    pAtacado3.setDefesa(pAtacado3.getDefesa() - dano);                     
                }
            }else if (pAtacado3.getDefesa() == 0){
                 pAtacado3.setVida(pAtacado3.getVida() - dano);
            }  
            //===MOSTRAR DANO
               Image img = new Image(getClass().getResourceAsStream("dano.gif"));
                 App.mapaAnimacao[pAtacado3.linha][pAtacado3.coluna].setImage(img);
                 App.mapaAnimacao[pAtacado3.linha][pAtacado3.coluna].setPreserveRatio(false);            
            //===============      
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" ultando: atacando com o estilo triplo: " +pAtacado3.getNome()); a1.setHeaderText(null); a1.showAndWait();
            if(pAtacado3.getVida() <= 0){
                Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado3.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();
                Mapa[pAtacado3.linha][pAtacado3.coluna] = '*';
                pAtacado3.setVida(0);
            }
            //===TIRAR O DANO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============               
        }
        if(achouPatacado1 == false && achouPatacado2 == false && achouPatacado3 == false){
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Sua ult nao acertou nenhum adversario"); a1.setHeaderText(null); a1.showAndWait();
        }
      }else{
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Voce nao possui pontos de habilidade (Ph) suficentes"); a1.setHeaderText(null); a1.showAndWait();
       }//Não ulta 
    }    
}

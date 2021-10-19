package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

public class Artemis extends Personagem{
//FELIPE ARTUR MACEDO LIMA 
    public Artemis(){
        this.setNome("Artemis");
        this.setVida(150);
        this.setDano(10);
        this.setDefesa(100);
        this.setPh(100);
        this.setIcone('@');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){     
        boolean achouPatacado = false;
        //Ataca ao longo de toda a coluna
        //obs: Se tiver coisa no caminha do ataque que não seja o alvo a flecha é perdida
        for(int i = 1; i <= 20; i++){
          if(this.linha + i < Mapa.length - 1){//verifica se esta acima 
            if(Mapa[this.linha + i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = (this.linha + i)-1; j > this.linha; j-- ){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                         break;
                    }
                }    
                break;
            }
          }
          
          if(this.linha - i > 0){//verifica se esta embaixo 
            if(Mapa[this.linha - i][this.coluna] == pAtacado.getIcone()){
                achouPatacado = true;
                for (int j = (this.linha - i) + 1; j < this.linha; j++){
                    if(Mapa[j][this.coluna] != '*'){
                         achouPatacado = false;
                         break;
                    }
                }              
                break;
            }
         }
        }
        
        if(achouPatacado){
            //System.out.println(this.getNome()+" mostrando a o poder da caçadora para " +pAtacado.getNome());
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" mostrando a o poder da caçadora para " +pAtacado.getNome()); a1.setHeaderText(null); a1.showAndWait();
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque"); a1.setHeaderText(null); a1.showAndWait();
        }
       
    }
    
    @Override
    public void ult(){
    //A Ult(Flechas Lunares) é uma habilidade da Artemis pode ativar suas 
    //flechas especias e dar o dobro de dano de suas flechas padrão;
    //Range:ao longo de toda a coluna
    //Dano: 30;
       if(this.getPh() >= 50){
            //===MOSTRAR EFEITO
               Image img = new Image(getClass().getResourceAsStream("energia3.gif"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============              
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Não terei piedade"); a1.setHeaderText(null); a1.showAndWait();
            //===TIRAR O EFEITO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img1);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============            
           this.setDano(this.getDano()*2);
           this.setPh(this.getPh()-50);
       }else{
           Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Sem PH o sufuciente"); a1.setHeaderText(null); a1.showAndWait();
       }
    }
}


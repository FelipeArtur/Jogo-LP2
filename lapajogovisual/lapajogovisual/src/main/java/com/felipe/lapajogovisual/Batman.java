package com.felipe.lapajogovisual;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

    public class Batman extends Personagem {
    //  BRENO BOGÉA ALVOS PASSOS
    public Batman(){
        this.setNome("Batman");
        this.setVida(180);
        this.setDano(20);
        this.setDefesa(120);
        this.setPh(50);
        this.setIcone('G');
    }
    
    @Override
    public void atacar(char[][] Mapa, Personagem pAtacado){
        //Range do ataque basico: 1 casas;
        //Ao Atacabar Batman entra em combate corpo a corpo com o inimigo 
        //Utilizando suas tecnicas de combate;
        boolean achouPatacado = false;
            if(this.linha + 1 < Mapa.length - 1){//verifica se esta acima 
                if(Mapa[this.linha + 1][this.coluna] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }
                }
            }
            if(this.linha - 1 > 0){//verifica se esta embaixo 
                if(Mapa[this.linha - 1][this.coluna] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }               
                }
            }
            if(this.coluna + 1 < Mapa.length - 1){//verifica se esta a direita
                if(Mapa[this.linha][this.coluna + 1] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }                            
                }
            }
            if(this.coluna - 1 > 0){//verifica se esta a esquerda
                if(Mapa[this.linha][this.coluna - 1] == pAtacado.getIcone()){
                    achouPatacado = true;
                    if(Mapa[this.linha][this.coluna] == '~'){
                         achouPatacado = false;
                    }                
                }
            }
        
        if(achouPatacado == true){
            //System.out.println(pAtacado.getNome() + "é atacado com as técnicas de combate do " + this.getNome());
            if(pAtacado.getDefesa() != 0){
                pAtacado.setDefesa((pAtacado.getDefesa() - this.getDano()* + 10));
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(pAtacado.getNome() + "é atacado com as técnicas de combate do " + this.getNome()); a1.setHeaderText(null); a1.showAndWait();
            if(pAtacado.getVida() <= 0){
                Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();
                Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                pAtacado.setVida(0);
            }  
        }else{
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem que voce escolheu atacar não está dentro do alcance do seu golpe, ou existe um obstáculo impedindo o ataque"); a1.setHeaderText(null); a1.showAndWait();
        }
    }
        
        @Override
        public void ult(){
            //A Ult(Preparo) se trata do preparo que o Batman é tão conhecido;
            //Ao ativar a Ult o Batman ganha um Bonos de Defesa e De Dano;
            if(this.getPh() <= 25){
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Você não tem Pontos de Habilidade (PH) necessários para usar essa habilidade."); a1.setHeaderText(null); a1.showAndWait();
            }else{
            //===MOSTRAR EFEITO
               Image img = new Image(getClass().getResourceAsStream("energia3.gif"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //=============== 
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O " + this.getNome() + " utiliza o seu preparo para ganhar bônus no ataque e na defesa."); a1.setHeaderText(null); a1.showAndWait();
            //===TIRAR O EFEITO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[this.linha][this.coluna].setImage(img1);
                App.mapaAnimacao[this.linha][this.coluna].setPreserveRatio(false);            
            //===============              
            this.setDano(this.getDano() + 10);
            this.setDefesa(this.getDefesa() + 40);
            this.setPh(this.getPh() - 25);                
            }

            
        }
        
}

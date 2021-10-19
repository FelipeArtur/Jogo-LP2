package com.felipe.lapajogovisual;

//import javax.swing.JOptionPane;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;

public class Oryx extends Personagem{
    //MATHEUS FREITAS PEREIRA
    public Oryx(){
        this.setNome("Oryx");
        this.setVida(110);
        this.setDano(30);
        this.setDefesa(100);
        this.setPh(70);
        this.setIcone('O');
    }
    
    @Override
    public void atacar(char[][] Mapa,Personagem pAtacado){
        //Range do ataque básico = 3 casas
        //Ataque básico atira esferas de fogo e podem passar por cima de personagens
        //Caso queira acertar um personagem que esteja atrás de outro
        boolean achouPatacado = false;
        for(int i = 1; i <= 3; i++){
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
            //System.out.println(this.getNome()+" atacando com chamas o inimigo: " +pAtacado.getNome());
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
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText(this.getNome()+" atacando com chamas o inimigo: " +pAtacado.getNome()); a1.setHeaderText(null); a1.showAndWait();
            if(pAtacado.getVida() <= 0){
            Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();
            Mapa[pAtacado.linha][pAtacado.coluna] = '*';
            }
            //===TIRAR O DANO
               Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
            //===============             
        }else{
            Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque"); a1.showAndWait();
        }
        
    }
    
    @Override
    public void ult(char[][] Mapa, Personagem pAtacado, Personagem pAtacado2, Personagem pAtacado3){
        //Ult é uma bola de fogo parecida com o ataque básico, mas com range 4 e dano de 180
        int dano = 140;
        if(this.getPh() >= 50){
            this.setPh(this.getPh() - 50);
            //int linha = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a linha que deseja jogar sua ult:")));
            //int coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a coluna que deseja jogar sua ult:")));
            TextInputDialog dialog = new TextInputDialog("OLA");
            dialog.setTitle("Escolha da Linha");
            dialog.setHeaderText("Selecionar a linha que deseja jogar sua ult");
            dialog.setContentText("Insira o numero da linha");
            
            Optional<String> result = dialog.showAndWait();            
            int linha = Integer.parseInt(result.get());
            
            TextInputDialog dialog2 = new TextInputDialog("OLA");
            dialog.setTitle("Escolha da Coluna");
            dialog.setHeaderText("Selecionar a coluna que deseja jogar sua ult");
            dialog.setContentText("Insira o numero da linha");
            
            Optional<String> result2 = dialog2.showAndWait();
            int coluna = Integer.parseInt(result2.get());
            
            if(linha > this.linha + 4 || linha < this.linha - 4 || coluna > this.coluna + 4 || coluna < this.coluna - 4){
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Essas coordenadas estão além do meu alcance!"); a1.setHeaderText(null); a1.showAndWait();
            }else{
                if(Mapa[linha][coluna] == pAtacado.getIcone()){
                    //System.out.println("Atacando " +pAtacado.getNome()+ "!");
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
                Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Atacando " +pAtacado.getNome()+ "!"); a1.setHeaderText(null); a1.showAndWait();
                    if(pAtacado.getVida() <= 0){
                        Alert a2 = new Alert(Alert.AlertType.INFORMATION); a2.setTitle(null); a2.setContentText(pAtacado.getNome()+" está morto(a)"); a2.setHeaderText(null); a2.showAndWait();
                        Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                    }
                //===TIRAR O DANO
                Image img1 = new Image(getClass().getResourceAsStream("Empty.png"));
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setImage(img1);
                App.mapaAnimacao[pAtacado.linha][pAtacado.coluna].setPreserveRatio(false);            
                //===============                     
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Droga! Não tinha ninguém nessa posição..."); a1.setHeaderText(null); a1.showAndWait();
                }
            }
        }
        
    }
}

package com.felipe.lapajogo;

import javax.swing.JOptionPane;

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
            System.out.println(this.getNome()+" atacando com chamas o inimigo: " +pAtacado.getNome());
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
            if(pAtacado.getVida() <= 0){
            System.out.println(pAtacado.getNome()+" está morto(a)");
            Mapa[pAtacado.linha][pAtacado.coluna] = '*';
            }  
        }else{
            System.out.println("O personagem que voce escolheu atacar nao esta dentro do range do seu ataque ou existe um obstaculo impedindo o ataque");
        }
        
    }
    
    @Override
    public void ult(char[][] Mapa, Personagem pAtacado, Personagem pAtacado2, Personagem pAtacado3){
        //Ult é uma bola de fogo parecida com o ataque básico, mas com range 4 e dano de 180
        int dano = 140;
        if(this.getPh() >= 50){
            this.setPh(this.getPh() - 50);
            int linha = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a linha que deseja jogar sua ult:")));
            int coluna = (Integer.parseInt(JOptionPane.showInputDialog(null, "Selecionar a coluna que deseja jogar sua ult:")));
            if(linha > this.linha + 4 || linha < this.linha - 4 || coluna > this.coluna + 4 || coluna < this.coluna - 4){
                System.out.println("Essas coordenadas estão além do meu alcance!");
            }else{
                if(Mapa[linha][coluna] == pAtacado.getIcone()){
                    System.out.println("Atacando " +pAtacado.getNome()+ "!");
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
                    if(pAtacado.getVida() <= 0){
                        System.out.println(pAtacado.getNome()+" está morto(a)");
                        Mapa[pAtacado.linha][pAtacado.coluna] = '*';
                    }
                }else{
                    System.out.println("Droga! Não tinha ninguém nessa posição...");
                }
            }
        }
        
    }
}

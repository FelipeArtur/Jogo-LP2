package com.felipe.lapajogovisual;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
//import javax.swing.JOptionPane;

public class Jogador {
    public int lado;
    private int item;
    private String nome;
    public  Personagem[] P;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Personagem[] getP() {
        return P;
    }

    public void setP(Personagem[] P) {
        this.P = P;
    }

    public Jogador(String nome) {
        this.lado = lado;
        this.item = item;
        this.nome = nome;
        this.P = P;
    }
   //SORTEIO QUEM COMECA
    public int sorteio(){
        Random gerador = new Random();
        int num = gerador.nextInt(10);
        //System.out.println(+num);
        System.out.println("SORTEIO OCORREU COM SUCESSO");
        if(num <= 5){
            num = 1;
        }else{
            num = 2;
        }
        return num;
    }
    
    //Escanear o arquivo
    //COLOCA O NOME E O ITEM SORTEADO DO JOGADOR VENCEDOR NO ARQUIVO
    public void dadosjogador(Jogador v) throws IOException{
        int NumSort = (int) ( 1+ (Math.random() * 4));
        Item i1  = new Item();
        System.out.println("O numero sorteado foi: " + NumSort);
        switch(NumSort){
            case 1: 
              i1 = new Anel();
            break;  
            
            case 2:
                i1 = new Armadura();  
            break;  
            
            case 3:
               i1 = new CotaDeMalha();       
            break;  
            
            case 4:
               i1 = new Luva();
            break;  
        }
        //----------------------------------------------------------------------
        //Percorrendo o arquivo 
        BufferedReader br;
        FileReader fr;
        
        try{
            fr = new FileReader("dados.txt"); //Le arrquivo do HD
            br = new BufferedReader(fr); //Guarda uma parcela na RAM
        }catch(Exception ex){
            System.out.println("Arquivo n encnontrado");
            return;
        }
        
        //Declarando e instanciando uma lista de usuarios
        ArrayList<String> usuarios = new ArrayList<String>();
        //Declarando e instanciando uma lista de premios(itens do vencedor)
        ArrayList<String> premios = new ArrayList<String>();
        //Uma String que guarda as linhas, util no futuro
        String line = "";
        boolean jogadorExiste = false; //MUDAR -> Entender para q
        
        try {
        line = br.readLine();
        while(line != null){ // readLine() metodo de BufferedReader, retorna uma linha por vez
            usuarios.add(line);//Adiciona uma linha no vetor
               
            if (line.equals(v.getNome())) {//Checa se a linha = ao nome recebido
                line = br.readLine() + "|" + i1.getNome();
                jogadorExiste = true; //MUDAR -> Entender para q
            }else line = br.readLine(); 
                premios.add(line);//Add um novo item
                line = br.readLine();
        }
        
        }catch (Exception ex){
          System.out.println("ERRO");
          br.close(); //Fechar o arquivo em caso de erro
        }
        
        fr.close(); //Fechar o arquivo 
        br.close(); //Fechar o arquiv
        
        //----------------------------------------------------------------------
        //Gravando no arquivo
        FileWriter fw; 
        PrintWriter pw; 
            
        try {
          fw = new FileWriter("dados.txt");
          pw = new PrintWriter(fw);
        } catch (Exception ex) {
          System.out.println("Erro na abertura do arquivo 3");
          return;
        }
        
        int aux = 0;
        for (String nome : usuarios) {
          pw.println(nome);
          pw.println(premios.get(aux));
          aux++;
        }
        
        if (!jogadorExiste) {
          pw.println(v.getNome());
          pw.println(i1.getNome());
        }
        pw.close();
        fw.close();
       //-----------------------------------------------------------------------
    }
    //BUSCA O ITEM NO ARQUIVO E EQUIPA NO PERSONAGEM
    public void usaritem(Jogador j, Personagem P) throws IOException{

        
        //if (existe){

            System.out.println("===========================================================");
            System.out.println("= "+this.getNome()+" deseja usar o item em um personagem? =");
            System.out.println("= 1: Anel                                                 =");
            System.out.println("= 2: Armadura                                             =");
            System.out.println("= 3: Cota de malha                                        =");
            System.out.println("= 4: Luva                                                 =");
            System.out.println("= 5 :Sair                                             =");
            System.out.println("===========================================================");

            Item[] i;  
            i = new Item[5];
            
            i[0] = new Anel();
            i[1] = new Armadura(); 
            i[2] = new CotaDeMalha();
            i[3] = new Luva();
            for(;;){
                //int op = (Integer.parseInt(JOptionPane.showInputDialog(null, " - Selecione o opcao desejado")));
                TextInputDialog dialog = new TextInputDialog("OLA");
                dialog.setTitle("Opção");
                dialog.setHeaderText("Escolha da opção");
                dialog.setContentText("= "+this.getNome()+" deseja usar o item em um personagem?\n"+
            "1: Anel   \n"+
            "2: Armadura   \n"+
            "3: Cota de malha\n"+
            "4: Luva   \n"+
            "5 :Sair "        
            ); 
            
                Optional<String> result = dialog.showAndWait();
                int op = Integer.parseInt(result.get()); 
                
                if(op == 1 && verificaARQ(j, i[0]) == 0){
                    i[0].aplicarefeito(P);
                    break;
                }else if(op == 2 && verificaARQ(j, i[1]) == 0){
                    i[1].aplicarefeito(P);
                    break;
                }else if(op == 3 && verificaARQ(j, i[2]) == 0){
                    i[2].aplicarefeito(P);
                    break;
                }else if(op == 4 && verificaARQ(j, i[3]) == 0){
                    i[3].aplicarefeito(P);
                    break;
                }else if(op == 5){
                    break;
                }else{
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION); a1.setTitle(null); a1.setContentText("Valor digitado invalido"); a1.setHeaderText(null); a1.showAndWait();
                }
            }
            
        //}
        
    }
    //VERIFICA SE O ITEM DESEJADO NO ARQUIVO
    public int verificaARQ(Jogador j, Item i) throws IOException{
        BufferedReader br;
        FileReader fr;
        
        try{
            fr = new FileReader("dados.txt"); //Le arrquivo do HD
            br = new BufferedReader(fr); //Guarda uma parcela na RAM
        }catch(Exception ex){
            System.out.println("Arquivo n encnontrado");
            return 1;
        }
        String line = "";
        
        //Verifica o nome -> OK
        try {
        line = br.readLine();
        while(line != null){
            System.out.println("chegou");// readLine() metodo de BufferedReader, retorna uma linha por vez
            if (line.equals(j.getNome())) {//Checa se a linha = ao nome recebido
                //line = j.getNome();
                System.out.println("Existe1");
                line = br.readLine();
                if (line.indexOf(i.getNome()) != -1) {//Checa se a linha = ao nome recebido
                //line = i.getNome();
                System.out.println("Existe3");
                return 0;
                }
            }
                line = br.readLine();
        }
        
        }catch (Exception ex){
          System.out.println("ERRO");
          br.close(); //Fechar o arquivo em caso de erro
        }

        fr.close(); //Fechar o arquivo 
        br.close(); //Fechar o arquivo
        return 1;
    }
    //VERIFICA SE TEM O NOME DO JOGADOR NO ARQUIVO
    public int verificaJog(Jogador j) throws IOException{
        BufferedReader br;
        FileReader fr;
        
        try{
            fr = new FileReader("dados.txt"); //Le arrquivo do HD
            br = new BufferedReader(fr); //Guarda uma parcela na RAM
        }catch(Exception ex){
            System.out.println("Arquivo n encnontrado");
            return 1;
        }
        String line = "";
        
        //Verifica o nome -> OK
        try {
        line = br.readLine();
        while(line != null){
            //System.out.println("chegou");// readLine() metodo de BufferedReader, retorna uma linha por vez
            if (line.equals(j.getNome())) {//Checa se a linha = ao nome recebido
                //line = j.getNome();
                //System.out.println("Existe1");
                return 0;
            }
                line = br.readLine();
        }
        
        }catch (Exception ex){
          System.out.println("ERRO");
          br.close(); //Fechar o arquivo em caso de erro
        }

        fr.close(); //Fechar o arquivo 
        br.close(); //Fechar o arquivo       
        return 1;
    }
    
}
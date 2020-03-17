package DAO;

import Models.PedidoModel;
import Models.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Memento {

    public static int load() {
        Configuração novo = null;
        try {
            FileInputStream recuperarFile = new FileInputStream("Configuração");
            ObjectInputStream stream = new ObjectInputStream(recuperarFile); //
            novo = (Configuração) stream.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(novo != null){
            return novo.getConfig();
        }
        return -1;
    }

    public static void save(int cfg) {
        try {
            Configuração novo = new Configuração();
            novo.setConfig(cfg);
            FileOutputStream salvarFile = new FileOutputStream("Configuração"); //Cria arquivo para ser escrito
            ObjectOutputStream objeto = new ObjectOutputStream(salvarFile); //Objeto que vai escrever no arquivo
            objeto.flush();
            objeto.writeObject(novo); //Grava a Arraylist no arquivo
            objeto.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(PedidoDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void alterarConfig(){
        int  cfg;
        cfg = load();

        if(cfg == 1){
            cfg = 2;
        }else{
            cfg = 1;
        }
        save(cfg);
    }

}




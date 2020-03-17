package DAO;

import java.io.Serializable;

public class Configuração implements Serializable {
    
    int config;

    public int getConfig() {
        return config;
    }

    public void setConfig(int config) {
        this.config = config;
    }
}

package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoModel implements Serializable{
    int id;
    List ItemModel = new ArrayList<>();
    float precoTotal;
    
    public int getId() {
        return id;
    }

    public void setId() {
        this.id ++;
    }

    public List getItemModel() {
        return ItemModel;
    }

    public void setItemModel(Produto item) {
        this.ItemModel.add(item);
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float valor) {
        this.precoTotal += valor;
    }
    

    
    
    
    
}

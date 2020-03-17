
package Models;
import java.util.Comparator;

public class ComparatorProduto implements Comparator<Produto> {




   @Override
   public int compare(Produto o1, Produto o2) {
      return o1.getCod() - o2.getCod();
   }
}

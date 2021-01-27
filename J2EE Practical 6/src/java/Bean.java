
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bvcbi
 */
public class Bean {
List<Map<String,String>> listFinal= new ArrayList();

    public List<Map<String, String>> getListFinal() {
        return listFinal;
    }

    public void setListFinal(List<Map<String, String>> listFinal) {
        this.listFinal = listFinal;
    }

    Iterable<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}


import static com.decagon.service.ArticleService.getUsernameWithHighestCommentCount;
import static com.decagon.service.ArticleService.getUsernames;
import static com.decagon.service.ArticleService.getUsernamesSortedByRecordDate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project gProperties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austine.okoroafor
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      List<String>response=  getUsernames(1);
    
    System.out.println("Data ========="+response);
    }
    
}
